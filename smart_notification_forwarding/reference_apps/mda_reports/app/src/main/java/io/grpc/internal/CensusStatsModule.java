package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ClientStreamTracer;
import io.grpc.Context;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.ServerStreamTracer;
import io.grpc.Status;
import io.opencensus.contrib.grpc.metrics.RpcMeasureConstants;
import io.opencensus.stats.Measure;
import io.opencensus.stats.MeasureMap;
import io.opencensus.stats.Stats;
import io.opencensus.stats.StatsRecorder;
import io.opencensus.tags.TagContext;
import io.opencensus.tags.TagValue;
import io.opencensus.tags.Tagger;
import io.opencensus.tags.Tags;
import io.opencensus.tags.propagation.TagContextBinarySerializer;
import io.opencensus.tags.propagation.TagContextSerializationException;
import io.opencensus.tags.unsafe.ContextUtils;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class CensusStatsModule {

    @VisibleForTesting
    final Metadata.Key<TagContext> a;
    private final boolean propagateTags;
    private final boolean recordFinishedRpcs;
    private final boolean recordRealTimeMetrics;
    private final boolean recordStartedRpcs;
    private final StatsRecorder statsRecorder;
    private final Supplier<Stopwatch> stopwatchSupplier;
    private final Tagger tagger;
    private static final Logger logger = Logger.getLogger(CensusStatsModule.class.getName());
    private static final double NANOS_PER_MILLI = TimeUnit.MILLISECONDS.toNanos(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class ClientCallTracer extends ClientStreamTracer.Factory {

        @Nullable
        private static final AtomicIntegerFieldUpdater<ClientCallTracer> callEndedUpdater;

        @Nullable
        private static final AtomicReferenceFieldUpdater<ClientCallTracer, ClientTracer> streamTracerUpdater;
        private volatile int callEnded;
        private final CensusStatsModule module;
        private final TagContext parentCtx;
        private final TagContext startCtx;
        private final Stopwatch stopwatch;
        private volatile ClientTracer streamTracer;

        static {
            AtomicIntegerFieldUpdater<ClientCallTracer> atomicIntegerFieldUpdater;
            AtomicReferenceFieldUpdater<ClientCallTracer, ClientTracer> atomicReferenceFieldUpdater = null;
            try {
                AtomicReferenceFieldUpdater<ClientCallTracer, ClientTracer> newUpdater = AtomicReferenceFieldUpdater.newUpdater(ClientCallTracer.class, ClientTracer.class, "streamTracer");
                atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(ClientCallTracer.class, "callEnded");
                atomicReferenceFieldUpdater = newUpdater;
            } catch (Throwable th) {
                CensusStatsModule.logger.log(Level.SEVERE, "Creating atomic field updaters failed", th);
                atomicIntegerFieldUpdater = null;
            }
            streamTracerUpdater = atomicReferenceFieldUpdater;
            callEndedUpdater = atomicIntegerFieldUpdater;
        }

        ClientCallTracer(CensusStatsModule censusStatsModule, TagContext tagContext, String str) {
            this.module = (CensusStatsModule) Preconditions.checkNotNull(censusStatsModule);
            this.parentCtx = (TagContext) Preconditions.checkNotNull(tagContext);
            this.startCtx = censusStatsModule.tagger.toBuilder(tagContext).putPropagating(DeprecatedCensusConstants.RPC_METHOD, TagValue.create(str)).build();
            this.stopwatch = ((Stopwatch) censusStatsModule.stopwatchSupplier.get()).start();
            if (censusStatsModule.recordStartedRpcs) {
                censusStatsModule.statsRecorder.newMeasureMap().put(DeprecatedCensusConstants.RPC_CLIENT_STARTED_COUNT, 1L).record(this.startCtx);
            }
        }

        void a(Status status) {
            AtomicIntegerFieldUpdater<ClientCallTracer> atomicIntegerFieldUpdater = callEndedUpdater;
            if (atomicIntegerFieldUpdater != null) {
                if (atomicIntegerFieldUpdater.getAndSet(this, 1) != 0) {
                    return;
                }
            } else if (this.callEnded != 0) {
                return;
            } else {
                this.callEnded = 1;
            }
            if (this.module.recordFinishedRpcs) {
                this.stopwatch.stop();
                long elapsed = this.stopwatch.elapsed(TimeUnit.NANOSECONDS);
                ClientTracer clientTracer = this.streamTracer;
                if (clientTracer == null) {
                    clientTracer = new ClientTracer(this.module, this.startCtx);
                }
                MeasureMap put = this.module.statsRecorder.newMeasureMap().put(DeprecatedCensusConstants.RPC_CLIENT_FINISHED_COUNT, 1L);
                Measure.MeasureDouble measureDouble = DeprecatedCensusConstants.RPC_CLIENT_ROUNDTRIP_LATENCY;
                double d = elapsed;
                double d2 = CensusStatsModule.NANOS_PER_MILLI;
                Double.isNaN(d);
                MeasureMap put2 = put.put(measureDouble, d / d2).put(DeprecatedCensusConstants.RPC_CLIENT_REQUEST_COUNT, clientTracer.a).put(DeprecatedCensusConstants.RPC_CLIENT_RESPONSE_COUNT, clientTracer.b).put(DeprecatedCensusConstants.RPC_CLIENT_REQUEST_BYTES, clientTracer.c).put(DeprecatedCensusConstants.RPC_CLIENT_RESPONSE_BYTES, clientTracer.d).put(DeprecatedCensusConstants.RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES, clientTracer.e).put(DeprecatedCensusConstants.RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES, clientTracer.f);
                if (!status.isOk()) {
                    put2.put(DeprecatedCensusConstants.RPC_CLIENT_ERROR_COUNT, 1L);
                }
                put2.record(this.module.tagger.toBuilder(this.startCtx).putPropagating(DeprecatedCensusConstants.RPC_STATUS, TagValue.create(status.getCode().toString())).build());
            }
        }

        @Override // io.grpc.ClientStreamTracer.Factory
        public ClientStreamTracer newClientStreamTracer(ClientStreamTracer.StreamInfo streamInfo, Metadata metadata) {
            ClientTracer clientTracer = new ClientTracer(this.module, this.startCtx);
            AtomicReferenceFieldUpdater<ClientCallTracer, ClientTracer> atomicReferenceFieldUpdater = streamTracerUpdater;
            if (atomicReferenceFieldUpdater != null) {
                Preconditions.checkState(atomicReferenceFieldUpdater.compareAndSet(this, null, clientTracer), "Are you creating multiple streams per call? This class doesn't yet support this case");
            } else {
                Preconditions.checkState(this.streamTracer == null, "Are you creating multiple streams per call? This class doesn't yet support this case");
                this.streamTracer = clientTracer;
            }
            if (this.module.propagateTags) {
                metadata.discardAll(this.module.a);
                if (!this.module.tagger.empty().equals(this.parentCtx)) {
                    metadata.put(this.module.a, this.parentCtx);
                }
            }
            return clientTracer;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class ClientTracer extends ClientStreamTracer {

        @Nullable
        private static final AtomicLongFieldUpdater<ClientTracer> inboundMessageCountUpdater;

        @Nullable
        private static final AtomicLongFieldUpdater<ClientTracer> inboundUncompressedSizeUpdater;

        @Nullable
        private static final AtomicLongFieldUpdater<ClientTracer> inboundWireSizeUpdater;

        @Nullable
        private static final AtomicLongFieldUpdater<ClientTracer> outboundMessageCountUpdater;

        @Nullable
        private static final AtomicLongFieldUpdater<ClientTracer> outboundUncompressedSizeUpdater;

        @Nullable
        private static final AtomicLongFieldUpdater<ClientTracer> outboundWireSizeUpdater;
        volatile long a;
        volatile long b;
        volatile long c;
        volatile long d;
        volatile long e;
        volatile long f;
        private final CensusStatsModule module;
        private final TagContext startCtx;

        static {
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater;
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater2;
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater3;
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater4;
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater5;
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater6 = null;
            try {
                AtomicLongFieldUpdater<ClientTracer> newUpdater = AtomicLongFieldUpdater.newUpdater(ClientTracer.class, "a");
                atomicLongFieldUpdater2 = AtomicLongFieldUpdater.newUpdater(ClientTracer.class, "b");
                atomicLongFieldUpdater3 = AtomicLongFieldUpdater.newUpdater(ClientTracer.class, "c");
                atomicLongFieldUpdater4 = AtomicLongFieldUpdater.newUpdater(ClientTracer.class, "d");
                atomicLongFieldUpdater5 = AtomicLongFieldUpdater.newUpdater(ClientTracer.class, "e");
                atomicLongFieldUpdater = AtomicLongFieldUpdater.newUpdater(ClientTracer.class, "f");
                atomicLongFieldUpdater6 = newUpdater;
            } catch (Throwable th) {
                CensusStatsModule.logger.log(Level.SEVERE, "Creating atomic field updaters failed", th);
                atomicLongFieldUpdater = null;
                atomicLongFieldUpdater2 = null;
                atomicLongFieldUpdater3 = null;
                atomicLongFieldUpdater4 = null;
                atomicLongFieldUpdater5 = null;
            }
            outboundMessageCountUpdater = atomicLongFieldUpdater6;
            inboundMessageCountUpdater = atomicLongFieldUpdater2;
            outboundWireSizeUpdater = atomicLongFieldUpdater3;
            inboundWireSizeUpdater = atomicLongFieldUpdater4;
            outboundUncompressedSizeUpdater = atomicLongFieldUpdater5;
            inboundUncompressedSizeUpdater = atomicLongFieldUpdater;
        }

        ClientTracer(CensusStatsModule censusStatsModule, TagContext tagContext) {
            this.module = (CensusStatsModule) Preconditions.checkNotNull(censusStatsModule, "module");
            this.startCtx = (TagContext) Preconditions.checkNotNull(tagContext, "startCtx");
        }

        @Override // io.grpc.StreamTracer
        public void inboundMessage(int i) {
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater = inboundMessageCountUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndIncrement(this);
            } else {
                this.b++;
            }
            this.module.recordRealTimeMetric(this.startCtx, RpcMeasureConstants.GRPC_CLIENT_RECEIVED_MESSAGES_PER_METHOD, 1L);
        }

        @Override // io.grpc.StreamTracer
        public void inboundUncompressedSize(long j) {
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater = inboundUncompressedSizeUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndAdd(this, j);
            } else {
                this.f += j;
            }
        }

        @Override // io.grpc.StreamTracer
        public void inboundWireSize(long j) {
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater = inboundWireSizeUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndAdd(this, j);
            } else {
                this.d += j;
            }
            this.module.recordRealTimeMetric(this.startCtx, RpcMeasureConstants.GRPC_CLIENT_RECEIVED_BYTES_PER_METHOD, j);
        }

        @Override // io.grpc.StreamTracer
        public void outboundMessage(int i) {
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater = outboundMessageCountUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndIncrement(this);
            } else {
                this.a++;
            }
            this.module.recordRealTimeMetric(this.startCtx, RpcMeasureConstants.GRPC_CLIENT_SENT_MESSAGES_PER_METHOD, 1L);
        }

        @Override // io.grpc.StreamTracer
        public void outboundUncompressedSize(long j) {
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater = outboundUncompressedSizeUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndAdd(this, j);
            } else {
                this.e += j;
            }
        }

        @Override // io.grpc.StreamTracer
        public void outboundWireSize(long j) {
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater = outboundWireSizeUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndAdd(this, j);
            } else {
                this.c += j;
            }
            this.module.recordRealTimeMetric(this.startCtx, RpcMeasureConstants.GRPC_CLIENT_SENT_BYTES_PER_METHOD, j);
        }
    }

    /* loaded from: classes2.dex */
    private static final class ServerTracer extends ServerStreamTracer {

        @Nullable
        private static final AtomicLongFieldUpdater<ServerTracer> inboundMessageCountUpdater;

        @Nullable
        private static final AtomicLongFieldUpdater<ServerTracer> inboundUncompressedSizeUpdater;

        @Nullable
        private static final AtomicLongFieldUpdater<ServerTracer> inboundWireSizeUpdater;

        @Nullable
        private static final AtomicLongFieldUpdater<ServerTracer> outboundMessageCountUpdater;

        @Nullable
        private static final AtomicLongFieldUpdater<ServerTracer> outboundUncompressedSizeUpdater;

        @Nullable
        private static final AtomicLongFieldUpdater<ServerTracer> outboundWireSizeUpdater;

        @Nullable
        private static final AtomicIntegerFieldUpdater<ServerTracer> streamClosedUpdater;
        private volatile long inboundMessageCount;
        private volatile long inboundUncompressedSize;
        private volatile long inboundWireSize;
        private final CensusStatsModule module;
        private volatile long outboundMessageCount;
        private volatile long outboundUncompressedSize;
        private volatile long outboundWireSize;
        private final TagContext parentCtx;
        private final Stopwatch stopwatch;
        private volatile int streamClosed;

        static {
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater;
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater2;
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater3;
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater4;
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater5;
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater6;
            AtomicIntegerFieldUpdater<ServerTracer> atomicIntegerFieldUpdater = null;
            try {
                AtomicIntegerFieldUpdater<ServerTracer> newUpdater = AtomicIntegerFieldUpdater.newUpdater(ServerTracer.class, "streamClosed");
                atomicLongFieldUpdater2 = AtomicLongFieldUpdater.newUpdater(ServerTracer.class, "outboundMessageCount");
                atomicLongFieldUpdater3 = AtomicLongFieldUpdater.newUpdater(ServerTracer.class, "inboundMessageCount");
                atomicLongFieldUpdater4 = AtomicLongFieldUpdater.newUpdater(ServerTracer.class, "outboundWireSize");
                atomicLongFieldUpdater5 = AtomicLongFieldUpdater.newUpdater(ServerTracer.class, "inboundWireSize");
                atomicLongFieldUpdater6 = AtomicLongFieldUpdater.newUpdater(ServerTracer.class, "outboundUncompressedSize");
                atomicLongFieldUpdater = AtomicLongFieldUpdater.newUpdater(ServerTracer.class, "inboundUncompressedSize");
                atomicIntegerFieldUpdater = newUpdater;
            } catch (Throwable th) {
                CensusStatsModule.logger.log(Level.SEVERE, "Creating atomic field updaters failed", th);
                atomicLongFieldUpdater = null;
                atomicLongFieldUpdater2 = null;
                atomicLongFieldUpdater3 = null;
                atomicLongFieldUpdater4 = null;
                atomicLongFieldUpdater5 = null;
                atomicLongFieldUpdater6 = null;
            }
            streamClosedUpdater = atomicIntegerFieldUpdater;
            outboundMessageCountUpdater = atomicLongFieldUpdater2;
            inboundMessageCountUpdater = atomicLongFieldUpdater3;
            outboundWireSizeUpdater = atomicLongFieldUpdater4;
            inboundWireSizeUpdater = atomicLongFieldUpdater5;
            outboundUncompressedSizeUpdater = atomicLongFieldUpdater6;
            inboundUncompressedSizeUpdater = atomicLongFieldUpdater;
        }

        ServerTracer(CensusStatsModule censusStatsModule, TagContext tagContext) {
            this.module = (CensusStatsModule) Preconditions.checkNotNull(censusStatsModule, "module");
            this.parentCtx = (TagContext) Preconditions.checkNotNull(tagContext, "parentCtx");
            this.stopwatch = ((Stopwatch) censusStatsModule.stopwatchSupplier.get()).start();
            if (censusStatsModule.recordStartedRpcs) {
                censusStatsModule.statsRecorder.newMeasureMap().put(DeprecatedCensusConstants.RPC_SERVER_STARTED_COUNT, 1L).record(tagContext);
            }
        }

        @Override // io.grpc.ServerStreamTracer
        public Context filterContext(Context context) {
            return !this.module.tagger.empty().equals(this.parentCtx) ? ContextUtils.withValue(context, this.parentCtx) : context;
        }

        @Override // io.grpc.StreamTracer
        public void inboundMessage(int i) {
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater = inboundMessageCountUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndIncrement(this);
            } else {
                this.inboundMessageCount++;
            }
            this.module.recordRealTimeMetric(this.parentCtx, RpcMeasureConstants.GRPC_SERVER_RECEIVED_MESSAGES_PER_METHOD, 1L);
        }

        @Override // io.grpc.StreamTracer
        public void inboundUncompressedSize(long j) {
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater = inboundUncompressedSizeUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndAdd(this, j);
            } else {
                this.inboundUncompressedSize += j;
            }
        }

        @Override // io.grpc.StreamTracer
        public void inboundWireSize(long j) {
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater = inboundWireSizeUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndAdd(this, j);
            } else {
                this.inboundWireSize += j;
            }
            this.module.recordRealTimeMetric(this.parentCtx, RpcMeasureConstants.GRPC_SERVER_RECEIVED_BYTES_PER_METHOD, j);
        }

        @Override // io.grpc.StreamTracer
        public void outboundMessage(int i) {
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater = outboundMessageCountUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndIncrement(this);
            } else {
                this.outboundMessageCount++;
            }
            this.module.recordRealTimeMetric(this.parentCtx, RpcMeasureConstants.GRPC_SERVER_SENT_MESSAGES_PER_METHOD, 1L);
        }

        @Override // io.grpc.StreamTracer
        public void outboundUncompressedSize(long j) {
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater = outboundUncompressedSizeUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndAdd(this, j);
            } else {
                this.outboundUncompressedSize += j;
            }
        }

        @Override // io.grpc.StreamTracer
        public void outboundWireSize(long j) {
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater = outboundWireSizeUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndAdd(this, j);
            } else {
                this.outboundWireSize += j;
            }
            this.module.recordRealTimeMetric(this.parentCtx, RpcMeasureConstants.GRPC_SERVER_SENT_BYTES_PER_METHOD, j);
        }

        @Override // io.grpc.StreamTracer
        public void streamClosed(Status status) {
            AtomicIntegerFieldUpdater<ServerTracer> atomicIntegerFieldUpdater = streamClosedUpdater;
            if (atomicIntegerFieldUpdater != null) {
                if (atomicIntegerFieldUpdater.getAndSet(this, 1) != 0) {
                    return;
                }
            } else if (this.streamClosed != 0) {
                return;
            } else {
                this.streamClosed = 1;
            }
            if (this.module.recordFinishedRpcs) {
                this.stopwatch.stop();
                long elapsed = this.stopwatch.elapsed(TimeUnit.NANOSECONDS);
                MeasureMap put = this.module.statsRecorder.newMeasureMap().put(DeprecatedCensusConstants.RPC_SERVER_FINISHED_COUNT, 1L);
                Measure.MeasureDouble measureDouble = DeprecatedCensusConstants.RPC_SERVER_SERVER_LATENCY;
                double d = elapsed;
                double d2 = CensusStatsModule.NANOS_PER_MILLI;
                Double.isNaN(d);
                MeasureMap put2 = put.put(measureDouble, d / d2).put(DeprecatedCensusConstants.RPC_SERVER_RESPONSE_COUNT, this.outboundMessageCount).put(DeprecatedCensusConstants.RPC_SERVER_REQUEST_COUNT, this.inboundMessageCount).put(DeprecatedCensusConstants.RPC_SERVER_RESPONSE_BYTES, this.outboundWireSize).put(DeprecatedCensusConstants.RPC_SERVER_REQUEST_BYTES, this.inboundWireSize).put(DeprecatedCensusConstants.RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES, this.outboundUncompressedSize).put(DeprecatedCensusConstants.RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES, this.inboundUncompressedSize);
                if (!status.isOk()) {
                    put2.put(DeprecatedCensusConstants.RPC_SERVER_ERROR_COUNT, 1L);
                }
                put2.record(this.module.tagger.toBuilder(this.parentCtx).putPropagating(DeprecatedCensusConstants.RPC_STATUS, TagValue.create(status.getCode().toString())).build());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public final class ServerTracerFactory extends ServerStreamTracer.Factory {
        ServerTracerFactory() {
        }

        @Override // io.grpc.ServerStreamTracer.Factory
        public ServerStreamTracer newServerStreamTracer(String str, Metadata metadata) {
            TagContext tagContext = (TagContext) metadata.get(CensusStatsModule.this.a);
            if (tagContext == null) {
                tagContext = CensusStatsModule.this.tagger.empty();
            }
            return new ServerTracer(CensusStatsModule.this, CensusStatsModule.this.tagger.toBuilder(tagContext).putPropagating(DeprecatedCensusConstants.RPC_METHOD, TagValue.create(str)).build());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public final class StatsClientInterceptor implements ClientInterceptor {
        StatsClientInterceptor() {
        }

        @Override // io.grpc.ClientInterceptor
        public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
            final ClientCallTracer a = CensusStatsModule.this.a(CensusStatsModule.this.tagger.getCurrentTagContext(), methodDescriptor.getFullMethodName());
            return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(this, channel.newCall(methodDescriptor, callOptions.withStreamTracerFactory(a))) { // from class: io.grpc.internal.CensusStatsModule.StatsClientInterceptor.1
                @Override // io.grpc.ForwardingClientCall, io.grpc.ClientCall
                public void start(ClientCall.Listener<RespT> listener, Metadata metadata) {
                    a().start(new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(listener) { // from class: io.grpc.internal.CensusStatsModule.StatsClientInterceptor.1.1
                        @Override // io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener, io.grpc.ForwardingClientCallListener, io.grpc.PartialForwardingClientCallListener, io.grpc.ClientCall.Listener
                        public void onClose(Status status, Metadata metadata2) {
                            a.a(status);
                            super.onClose(status, metadata2);
                        }
                    }, metadata);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CensusStatsModule(Supplier<Stopwatch> supplier, boolean z, boolean z2, boolean z3, boolean z4) {
        this(Tags.getTagger(), Tags.getTagPropagationComponent().getBinarySerializer(), Stats.getStatsRecorder(), supplier, z, z2, z3, z4);
    }

    public CensusStatsModule(final Tagger tagger, final TagContextBinarySerializer tagContextBinarySerializer, StatsRecorder statsRecorder, Supplier<Stopwatch> supplier, boolean z, boolean z2, boolean z3, boolean z4) {
        this.tagger = (Tagger) Preconditions.checkNotNull(tagger, "tagger");
        this.statsRecorder = (StatsRecorder) Preconditions.checkNotNull(statsRecorder, "statsRecorder");
        Preconditions.checkNotNull(tagContextBinarySerializer, "tagCtxSerializer");
        this.stopwatchSupplier = (Supplier) Preconditions.checkNotNull(supplier, "stopwatchSupplier");
        this.propagateTags = z;
        this.recordStartedRpcs = z2;
        this.recordFinishedRpcs = z3;
        this.recordRealTimeMetrics = z4;
        this.a = Metadata.Key.of("grpc-tags-bin", new Metadata.BinaryMarshaller<TagContext>(this) { // from class: io.grpc.internal.CensusStatsModule.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.Metadata.BinaryMarshaller
            public TagContext parseBytes(byte[] bArr) {
                try {
                    return tagContextBinarySerializer.fromByteArray(bArr);
                } catch (Exception e) {
                    CensusStatsModule.logger.log(Level.FINE, "Failed to parse stats header", (Throwable) e);
                    return tagger.empty();
                }
            }

            @Override // io.grpc.Metadata.BinaryMarshaller
            public byte[] toBytes(TagContext tagContext) {
                try {
                    return tagContextBinarySerializer.toByteArray(tagContext);
                } catch (TagContextSerializationException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordRealTimeMetric(TagContext tagContext, Measure.MeasureDouble measureDouble, double d) {
        if (this.recordRealTimeMetrics) {
            this.statsRecorder.newMeasureMap().put(measureDouble, d).record(tagContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordRealTimeMetric(TagContext tagContext, Measure.MeasureLong measureLong, long j) {
        if (this.recordRealTimeMetrics) {
            this.statsRecorder.newMeasureMap().put(measureLong, j).record(tagContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClientInterceptor a() {
        return new StatsClientInterceptor();
    }

    @VisibleForTesting
    ClientCallTracer a(TagContext tagContext, String str) {
        return new ClientCallTracer(this, tagContext, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServerStreamTracer.Factory b() {
        return new ServerTracerFactory();
    }
}
