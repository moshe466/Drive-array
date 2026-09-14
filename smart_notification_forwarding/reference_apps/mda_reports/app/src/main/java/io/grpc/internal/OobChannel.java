package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.Context;
import io.grpc.EquivalentAddressGroup;
import io.grpc.InternalChannelz;
import io.grpc.InternalInstrumented;
import io.grpc.InternalLogId;
import io.grpc.LoadBalancer;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.ClientCallImpl;
import io.grpc.internal.ManagedClientTransport;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: Access modifiers changed from: package-private */
@ThreadSafe
/* loaded from: classes2.dex */
public final class OobChannel extends ManagedChannel implements InternalInstrumented<InternalChannelz.ChannelStats> {
    private static final Logger log = Logger.getLogger(OobChannel.class.getName());
    private final String authority;
    private final CallTracer channelCallsTracer;
    private final ChannelTracer channelTracer;
    private final InternalChannelz channelz;
    private final ScheduledExecutorService deadlineCancellationExecutor;
    private final DelayedClientTransport delayedTransport;
    private final Executor executor;
    private final ObjectPool<? extends Executor> executorPool;
    private final InternalLogId logId;
    private volatile boolean shutdown;
    private InternalSubchannel subchannel;
    private AbstractSubchannel subchannelImpl;
    private LoadBalancer.SubchannelPicker subchannelPicker;
    private final TimeProvider timeProvider;
    private final CountDownLatch terminatedLatch = new CountDownLatch(1);
    private final ClientCallImpl.ClientTransportProvider transportProvider = new ClientCallImpl.ClientTransportProvider() { // from class: io.grpc.internal.OobChannel.1
        @Override // io.grpc.internal.ClientCallImpl.ClientTransportProvider
        public ClientTransport get(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            return OobChannel.this.delayedTransport;
        }

        @Override // io.grpc.internal.ClientCallImpl.ClientTransportProvider
        public <ReqT> ClientStream newRetriableStream(MethodDescriptor<ReqT, ?> methodDescriptor, CallOptions callOptions, Metadata metadata, Context context) {
            throw new UnsupportedOperationException("OobChannel should not create retriable streams");
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.grpc.internal.OobChannel$6, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] a = new int[ConnectivityState.values().length];

        static {
            try {
                a[ConnectivityState.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ConnectivityState.IDLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ConnectivityState.TRANSIENT_FAILURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OobChannel(String str, ObjectPool<? extends Executor> objectPool, ScheduledExecutorService scheduledExecutorService, SynchronizationContext synchronizationContext, CallTracer callTracer, ChannelTracer channelTracer, InternalChannelz internalChannelz, TimeProvider timeProvider) {
        this.authority = (String) Preconditions.checkNotNull(str, "authority");
        this.logId = InternalLogId.allocate((Class<?>) OobChannel.class, str);
        this.executorPool = (ObjectPool) Preconditions.checkNotNull(objectPool, "executorPool");
        this.executor = (Executor) Preconditions.checkNotNull(objectPool.getObject(), "executor");
        this.deadlineCancellationExecutor = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService, "deadlineCancellationExecutor");
        this.delayedTransport = new DelayedClientTransport(this.executor, synchronizationContext);
        this.channelz = (InternalChannelz) Preconditions.checkNotNull(internalChannelz);
        this.delayedTransport.start(new ManagedClientTransport.Listener() { // from class: io.grpc.internal.OobChannel.2
            @Override // io.grpc.internal.ManagedClientTransport.Listener
            public void transportInUse(boolean z) {
            }

            @Override // io.grpc.internal.ManagedClientTransport.Listener
            public void transportReady() {
            }

            @Override // io.grpc.internal.ManagedClientTransport.Listener
            public void transportShutdown(Status status) {
            }

            @Override // io.grpc.internal.ManagedClientTransport.Listener
            public void transportTerminated() {
                OobChannel.this.subchannelImpl.shutdown();
            }
        });
        this.channelCallsTracer = callTracer;
        this.channelTracer = (ChannelTracer) Preconditions.checkNotNull(channelTracer, "channelTracer");
        this.timeProvider = (TimeProvider) Preconditions.checkNotNull(timeProvider, "timeProvider");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InternalSubchannel a() {
        return this.subchannel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final ConnectivityStateInfo connectivityStateInfo) {
        this.channelTracer.a(new InternalChannelz.ChannelTrace.Event.Builder().setDescription("Entering " + connectivityStateInfo.getState() + " state").setSeverity(InternalChannelz.ChannelTrace.Event.Severity.CT_INFO).setTimestampNanos(this.timeProvider.currentTimeNanos()).build());
        int i = AnonymousClass6.a[connectivityStateInfo.getState().ordinal()];
        if (i == 1 || i == 2) {
            this.delayedTransport.a(this.subchannelPicker);
        } else {
            if (i != 3) {
                return;
            }
            this.delayedTransport.a(new LoadBalancer.SubchannelPicker(this) { // from class: io.grpc.internal.OobChannel.5
                final LoadBalancer.PickResult a;

                {
                    this.a = LoadBalancer.PickResult.withError(connectivityStateInfo.getStatus());
                }

                @Override // io.grpc.LoadBalancer.SubchannelPicker
                public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
                    return this.a;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(EquivalentAddressGroup equivalentAddressGroup) {
        this.subchannel.updateAddresses(Collections.singletonList(equivalentAddressGroup));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final InternalSubchannel internalSubchannel) {
        log.log(Level.FINE, "[{0}] Created with [{1}]", new Object[]{this, internalSubchannel});
        this.subchannel = internalSubchannel;
        this.subchannelImpl = new AbstractSubchannel(this) { // from class: io.grpc.internal.OobChannel.3
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // io.grpc.internal.AbstractSubchannel
            public ClientTransport a() {
                return internalSubchannel.f();
            }

            @Override // io.grpc.LoadBalancer.Subchannel
            public List<EquivalentAddressGroup> getAllAddresses() {
                return internalSubchannel.a();
            }

            @Override // io.grpc.LoadBalancer.Subchannel
            public Attributes getAttributes() {
                return Attributes.EMPTY;
            }

            @Override // io.grpc.LoadBalancer.Subchannel
            public void requestConnection() {
                internalSubchannel.f();
            }

            @Override // io.grpc.LoadBalancer.Subchannel
            public void shutdown() {
                internalSubchannel.shutdown(Status.UNAVAILABLE.withDescription("OobChannel is shutdown"));
            }
        };
        this.subchannelPicker = new LoadBalancer.SubchannelPicker() { // from class: io.grpc.internal.OobChannel.4
            final LoadBalancer.PickResult a;

            {
                this.a = LoadBalancer.PickResult.withSubchannel(OobChannel.this.subchannelImpl);
            }

            @Override // io.grpc.LoadBalancer.SubchannelPicker
            public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
                return this.a;
            }
        };
        this.delayedTransport.a(this.subchannelPicker);
    }

    @Override // io.grpc.Channel
    public String authority() {
        return this.authority;
    }

    @Override // io.grpc.ManagedChannel
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.terminatedLatch.await(j, timeUnit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.channelz.removeSubchannel(this);
        this.executorPool.returnObject(this.executor);
        this.terminatedLatch.countDown();
    }

    @Override // io.grpc.InternalWithLogId
    public InternalLogId getLogId() {
        return this.logId;
    }

    @Override // io.grpc.ManagedChannel
    public ConnectivityState getState(boolean z) {
        InternalSubchannel internalSubchannel = this.subchannel;
        return internalSubchannel == null ? ConnectivityState.IDLE : internalSubchannel.d();
    }

    @Override // io.grpc.InternalInstrumented
    public ListenableFuture<InternalChannelz.ChannelStats> getStats() {
        SettableFuture create = SettableFuture.create();
        InternalChannelz.ChannelStats.Builder builder = new InternalChannelz.ChannelStats.Builder();
        this.channelCallsTracer.a(builder);
        this.channelTracer.a(builder);
        builder.setTarget(this.authority).setState(this.subchannel.d()).setSubchannels(Collections.singletonList(this.subchannel));
        create.set(builder.build());
        return create;
    }

    @Override // io.grpc.ManagedChannel
    public boolean isShutdown() {
        return this.shutdown;
    }

    @Override // io.grpc.ManagedChannel
    public boolean isTerminated() {
        return this.terminatedLatch.getCount() == 0;
    }

    @Override // io.grpc.Channel
    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
        return new ClientCallImpl(methodDescriptor, callOptions.getExecutor() == null ? this.executor : callOptions.getExecutor(), callOptions, this.transportProvider, this.deadlineCancellationExecutor, this.channelCallsTracer, false);
    }

    @Override // io.grpc.ManagedChannel
    public void resetConnectBackoff() {
        this.subchannel.g();
    }

    @Override // io.grpc.ManagedChannel
    public ManagedChannel shutdown() {
        this.shutdown = true;
        this.delayedTransport.shutdown(Status.UNAVAILABLE.withDescription("OobChannel.shutdown() called"));
        return this;
    }

    @Override // io.grpc.ManagedChannel
    public ManagedChannel shutdownNow() {
        this.shutdown = true;
        this.delayedTransport.shutdownNow(Status.UNAVAILABLE.withDescription("OobChannel.shutdownNow() called"));
        return this;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("logId", this.logId.getId()).add("authority", this.authority).toString();
    }
}
