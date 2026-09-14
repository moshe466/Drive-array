package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
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
import io.opencensus.trace.BlankSpan;
import io.opencensus.trace.EndSpanOptions;
import io.opencensus.trace.MessageEvent;
import io.opencensus.trace.Span;
import io.opencensus.trace.SpanContext;
import io.opencensus.trace.Tracer;
import io.opencensus.trace.propagation.BinaryFormat;
import io.opencensus.trace.unsafe.ContextUtils;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class CensusTracingModule {

    @Nullable
    private static final AtomicIntegerFieldUpdater<ClientCallTracer> callEndedUpdater;
    private static final Logger logger = Logger.getLogger(CensusTracingModule.class.getName());

    @Nullable
    private static final AtomicIntegerFieldUpdater<ServerTracer> streamClosedUpdater;

    @VisibleForTesting
    final Metadata.Key<SpanContext> a;
    private final Tracer censusTracer;
    private final TracingClientInterceptor clientInterceptor = new TracingClientInterceptor();
    private final ServerTracerFactory serverTracerFactory = new ServerTracerFactory();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.grpc.internal.CensusTracingModule$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a = new int[Status.Code.values().length];

        static {
            try {
                a[Status.Code.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Status.Code.CANCELLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Status.Code.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Status.Code.INVALID_ARGUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Status.Code.DEADLINE_EXCEEDED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Status.Code.NOT_FOUND.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[Status.Code.ALREADY_EXISTS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[Status.Code.PERMISSION_DENIED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[Status.Code.RESOURCE_EXHAUSTED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[Status.Code.FAILED_PRECONDITION.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[Status.Code.ABORTED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[Status.Code.OUT_OF_RANGE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[Status.Code.UNIMPLEMENTED.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[Status.Code.INTERNAL.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[Status.Code.UNAVAILABLE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[Status.Code.DATA_LOSS.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[Status.Code.UNAUTHENTICATED.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public final class ClientCallTracer extends ClientStreamTracer.Factory {
        volatile int a;
        private final boolean isSampledToLocalTracing;
        private final Span span;

        ClientCallTracer(@Nullable Span span, MethodDescriptor<?, ?> methodDescriptor) {
            Preconditions.checkNotNull(methodDescriptor, FirebaseAnalytics.Param.METHOD);
            this.isSampledToLocalTracing = methodDescriptor.isSampledToLocalTracing();
            this.span = CensusTracingModule.this.censusTracer.spanBuilderWithExplicitParent(CensusTracingModule.a(false, methodDescriptor.getFullMethodName()), span).setRecordEvents(true).startSpan();
        }

        void a(Status status) {
            if (CensusTracingModule.callEndedUpdater != null) {
                if (CensusTracingModule.callEndedUpdater.getAndSet(this, 1) != 0) {
                    return;
                }
            } else if (this.a != 0) {
                return;
            } else {
                this.a = 1;
            }
            this.span.end(CensusTracingModule.createEndSpanOptions(status, this.isSampledToLocalTracing));
        }

        @Override // io.grpc.ClientStreamTracer.Factory
        public ClientStreamTracer newClientStreamTracer(ClientStreamTracer.StreamInfo streamInfo, Metadata metadata) {
            if (this.span != BlankSpan.INSTANCE) {
                metadata.discardAll(CensusTracingModule.this.a);
                metadata.put(CensusTracingModule.this.a, this.span.getContext());
            }
            return new ClientTracer(this.span);
        }
    }

    /* loaded from: classes2.dex */
    private static final class ClientTracer extends ClientStreamTracer {
        private final Span span;

        ClientTracer(Span span) {
            this.span = (Span) Preconditions.checkNotNull(span, "span");
        }

        @Override // io.grpc.StreamTracer
        public void inboundMessageRead(int i, long j, long j2) {
            CensusTracingModule.recordMessageEvent(this.span, MessageEvent.Type.RECEIVED, i, j, j2);
        }

        @Override // io.grpc.StreamTracer
        public void outboundMessageSent(int i, long j, long j2) {
            CensusTracingModule.recordMessageEvent(this.span, MessageEvent.Type.SENT, i, j, j2);
        }
    }

    /* loaded from: classes2.dex */
    private final class ServerTracer extends ServerStreamTracer {
        volatile boolean a;
        volatile int b;
        private final Span span;

        ServerTracer(CensusTracingModule censusTracingModule, @Nullable String str, SpanContext spanContext) {
            Preconditions.checkNotNull(str, "fullMethodName");
            this.span = censusTracingModule.censusTracer.spanBuilderWithRemoteParent(CensusTracingModule.a(true, str), spanContext).setRecordEvents(true).startSpan();
        }

        @Override // io.grpc.ServerStreamTracer
        public Context filterContext(Context context) {
            return ContextUtils.withValue(context, this.span);
        }

        @Override // io.grpc.StreamTracer
        public void inboundMessageRead(int i, long j, long j2) {
            CensusTracingModule.recordMessageEvent(this.span, MessageEvent.Type.RECEIVED, i, j, j2);
        }

        @Override // io.grpc.StreamTracer
        public void outboundMessageSent(int i, long j, long j2) {
            CensusTracingModule.recordMessageEvent(this.span, MessageEvent.Type.SENT, i, j, j2);
        }

        @Override // io.grpc.ServerStreamTracer
        public void serverCallStarted(ServerStreamTracer.ServerCallInfo<?, ?> serverCallInfo) {
            this.a = serverCallInfo.getMethodDescriptor().isSampledToLocalTracing();
        }

        @Override // io.grpc.StreamTracer
        public void streamClosed(Status status) {
            if (CensusTracingModule.streamClosedUpdater != null) {
                if (CensusTracingModule.streamClosedUpdater.getAndSet(this, 1) != 0) {
                    return;
                }
            } else if (this.b != 0) {
                return;
            } else {
                this.b = 1;
            }
            this.span.end(CensusTracingModule.createEndSpanOptions(status, this.a));
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
            SpanContext spanContext = (SpanContext) metadata.get(CensusTracingModule.this.a);
            if (spanContext == SpanContext.INVALID) {
                spanContext = null;
            }
            return new ServerTracer(CensusTracingModule.this, str, spanContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public final class TracingClientInterceptor implements ClientInterceptor {
        TracingClientInterceptor() {
        }

        @Override // io.grpc.ClientInterceptor
        public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
            final ClientCallTracer a = CensusTracingModule.this.a(ContextUtils.getValue(Context.current()), (MethodDescriptor<?, ?>) methodDescriptor);
            return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(this, channel.newCall(methodDescriptor, callOptions.withStreamTracerFactory(a))) { // from class: io.grpc.internal.CensusTracingModule.TracingClientInterceptor.1
                @Override // io.grpc.ForwardingClientCall, io.grpc.ClientCall
                public void start(ClientCall.Listener<RespT> listener, Metadata metadata) {
                    a().start(new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(listener) { // from class: io.grpc.internal.CensusTracingModule.TracingClientInterceptor.1.1
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

    static {
        AtomicIntegerFieldUpdater<ServerTracer> atomicIntegerFieldUpdater;
        AtomicIntegerFieldUpdater<ClientCallTracer> atomicIntegerFieldUpdater2 = null;
        try {
            AtomicIntegerFieldUpdater<ClientCallTracer> newUpdater = AtomicIntegerFieldUpdater.newUpdater(ClientCallTracer.class, "a");
            atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(ServerTracer.class, "b");
            atomicIntegerFieldUpdater2 = newUpdater;
        } catch (Throwable th) {
            logger.log(Level.SEVERE, "Creating atomic field updaters failed", th);
            atomicIntegerFieldUpdater = null;
        }
        callEndedUpdater = atomicIntegerFieldUpdater2;
        streamClosedUpdater = atomicIntegerFieldUpdater;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CensusTracingModule(Tracer tracer, final BinaryFormat binaryFormat) {
        this.censusTracer = (Tracer) Preconditions.checkNotNull(tracer, "censusTracer");
        Preconditions.checkNotNull(binaryFormat, "censusPropagationBinaryFormat");
        this.a = Metadata.Key.of("grpc-trace-bin", new Metadata.BinaryMarshaller<SpanContext>(this) { // from class: io.grpc.internal.CensusTracingModule.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.Metadata.BinaryMarshaller
            public SpanContext parseBytes(byte[] bArr) {
                try {
                    return binaryFormat.fromByteArray(bArr);
                } catch (Exception e) {
                    CensusTracingModule.logger.log(Level.FINE, "Failed to parse tracing header", (Throwable) e);
                    return SpanContext.INVALID;
                }
            }

            @Override // io.grpc.Metadata.BinaryMarshaller
            public byte[] toBytes(SpanContext spanContext) {
                return binaryFormat.toByteArray(spanContext);
            }
        });
    }

    @VisibleForTesting
    static io.opencensus.trace.Status a(Status status) {
        io.opencensus.trace.Status status2;
        switch (AnonymousClass2.a[status.getCode().ordinal()]) {
            case 1:
                status2 = io.opencensus.trace.Status.OK;
                break;
            case 2:
                status2 = io.opencensus.trace.Status.CANCELLED;
                break;
            case 3:
                status2 = io.opencensus.trace.Status.UNKNOWN;
                break;
            case 4:
                status2 = io.opencensus.trace.Status.INVALID_ARGUMENT;
                break;
            case 5:
                status2 = io.opencensus.trace.Status.DEADLINE_EXCEEDED;
                break;
            case 6:
                status2 = io.opencensus.trace.Status.NOT_FOUND;
                break;
            case 7:
                status2 = io.opencensus.trace.Status.ALREADY_EXISTS;
                break;
            case 8:
                status2 = io.opencensus.trace.Status.PERMISSION_DENIED;
                break;
            case 9:
                status2 = io.opencensus.trace.Status.RESOURCE_EXHAUSTED;
                break;
            case 10:
                status2 = io.opencensus.trace.Status.FAILED_PRECONDITION;
                break;
            case 11:
                status2 = io.opencensus.trace.Status.ABORTED;
                break;
            case 12:
                status2 = io.opencensus.trace.Status.OUT_OF_RANGE;
                break;
            case 13:
                status2 = io.opencensus.trace.Status.UNIMPLEMENTED;
                break;
            case 14:
                status2 = io.opencensus.trace.Status.INTERNAL;
                break;
            case 15:
                status2 = io.opencensus.trace.Status.UNAVAILABLE;
                break;
            case 16:
                status2 = io.opencensus.trace.Status.DATA_LOSS;
                break;
            case 17:
                status2 = io.opencensus.trace.Status.UNAUTHENTICATED;
                break;
            default:
                throw new AssertionError("Unhandled status code " + status.getCode());
        }
        return status.getDescription() != null ? status2.withDescription(status.getDescription()) : status2;
    }

    @VisibleForTesting
    static String a(boolean z, String str) {
        return (z ? "Recv" : "Sent") + "." + str.replace('/', '.');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static EndSpanOptions createEndSpanOptions(Status status, boolean z) {
        return EndSpanOptions.builder().setStatus(a(status)).setSampleToLocalSpanStore(z).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void recordMessageEvent(Span span, MessageEvent.Type type, int i, long j, long j2) {
        MessageEvent.Builder builder = MessageEvent.builder(type, i);
        if (j2 != -1) {
            builder.setUncompressedMessageSize(j2);
        }
        if (j != -1) {
            builder.setCompressedMessageSize(j);
        }
        span.addMessageEvent(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClientInterceptor a() {
        return this.clientInterceptor;
    }

    @VisibleForTesting
    ClientCallTracer a(@Nullable Span span, MethodDescriptor<?, ?> methodDescriptor) {
        return new ClientCallTracer(span, methodDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServerStreamTracer.Factory b() {
        return this.serverTracerFactory;
    }
}
