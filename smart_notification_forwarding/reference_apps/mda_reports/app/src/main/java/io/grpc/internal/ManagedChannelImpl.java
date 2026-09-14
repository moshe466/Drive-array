package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.Attributes;
import io.grpc.BinaryLog;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ChannelLogger;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ClientInterceptors;
import io.grpc.ClientStreamTracer;
import io.grpc.CompressorRegistry;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.Context;
import io.grpc.DecompressorRegistry;
import io.grpc.EquivalentAddressGroup;
import io.grpc.InternalChannelz;
import io.grpc.InternalInstrumented;
import io.grpc.InternalLogId;
import io.grpc.LoadBalancer;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.NameResolver;
import io.grpc.ProxyDetector;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.BackoffPolicy;
import io.grpc.internal.CallTracer;
import io.grpc.internal.ClientCallImpl;
import io.grpc.internal.HedgingPolicy;
import io.grpc.internal.InternalSubchannel;
import io.grpc.internal.ManagedClientTransport;
import io.grpc.internal.RetriableStream;
import io.grpc.internal.RetryPolicy;
import java.lang.Thread;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.annotation.CheckForNull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: Access modifiers changed from: package-private */
@ThreadSafe
/* loaded from: classes2.dex */
public final class ManagedChannelImpl extends ManagedChannel implements InternalInstrumented<InternalChannelz.ChannelStats> {
    static final Logger c = Logger.getLogger(ManagedChannelImpl.class.getName());

    @VisibleForTesting
    static final Pattern d = Pattern.compile("[a-zA-Z][a-zA-Z0-9+.-]*:/.*");

    @VisibleForTesting
    static final Status e = Status.UNAVAILABLE.withDescription("Channel shutdownNow invoked");

    @VisibleForTesting
    static final Status f = Status.UNAVAILABLE.withDescription("Channel shutdown invoked");

    @VisibleForTesting
    static final Status g = Status.UNAVAILABLE.withDescription("Subchannel shutdown invoked");

    @VisibleForTesting
    final InUseStateAggregator<Object> b;
    private final BackoffPolicy.Provider backoffPolicyProvider;
    private final ExecutorHolder balancerRpcExecutorHolder;
    private final ObjectPool<? extends Executor> balancerRpcExecutorPool;
    private final CallTracer.Factory callTracerFactory;
    private final long channelBufferLimit;
    private final CallTracer channelCallTracer;
    private final ChannelLogger channelLogger;
    private final ChannelTracer channelTracer;
    private final InternalChannelz channelz;
    private final CompressorRegistry compressorRegistry;
    private final DecompressorRegistry decompressorRegistry;

    @Nullable
    private final Map<String, ?> defaultServiceConfig;
    private final DelayedClientTransport delayedTransport;
    private final ManagedClientTransport.Listener delayedTransportListener;
    private final Executor executor;
    private final ObjectPool<? extends Executor> executorPool;
    private boolean fullStreamDecompression;

    @CheckForNull
    private Boolean haveBackends;
    private final long idleTimeoutMillis;
    private final Rescheduler idleTimer;
    private final Channel interceptorChannel;

    @Nullable
    private Map<String, ?> lastServiceConfig;

    @Nullable
    private LbHelperImpl lbHelper;
    private final AutoConfiguredLoadBalancerFactory loadBalancerFactory;
    private final InternalLogId logId;
    private final boolean lookUpServiceConfig;
    private final int maxTraceEvents;
    private NameResolver nameResolver;
    private final NameResolver.Args nameResolverArgs;

    @Nullable
    private BackoffPolicy nameResolverBackoffPolicy;
    private final NameResolver.Factory nameResolverFactory;
    private boolean nameResolverStarted;
    private boolean panicMode;
    private final long perRpcBufferLimit;
    private final boolean retryEnabled;
    private final ScheduledExecutorForBalancer scheduledExecutorForBalancer;

    @Nullable
    private SynchronizationContext.ScheduledHandle scheduledNameResolverRefresh;
    private final ServiceConfigInterceptor serviceConfigInterceptor;
    private boolean shutdownNowed;
    private final Supplier<Stopwatch> stopwatchSupplier;

    @Nullable
    private volatile LoadBalancer.SubchannelPicker subchannelPicker;
    private final String target;
    private volatile boolean terminated;
    private volatile boolean terminating;

    @Nullable
    private RetriableStream.Throttle throttle;
    private final TimeProvider timeProvider;
    private final ClientTransportFactory transportFactory;
    private final ClientCallImpl.ClientTransportProvider transportProvider;
    private final UncommittedRetriableStreamsRegistry uncommittedRetriableStreamsRegistry;

    @Nullable
    private final String userAgent;

    @VisibleForTesting
    final SynchronizationContext a = new SynchronizationContext(new Thread.UncaughtExceptionHandler() { // from class: io.grpc.internal.ManagedChannelImpl.1
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            ManagedChannelImpl.c.log(Level.SEVERE, "[" + ManagedChannelImpl.this.getLogId() + "] Uncaught exception in the SynchronizationContext. Panic!", th);
            ManagedChannelImpl.this.a(th);
        }
    });
    private final ConnectivityStateManager channelStateManager = new ConnectivityStateManager();
    private final Set<InternalSubchannel> subchannels = new HashSet(16, 0.75f);
    private final Set<OobChannel> oobChannels = new HashSet(1, 0.75f);
    private final AtomicBoolean shutdown = new AtomicBoolean(false);
    private final CountDownLatch terminatedLatch = new CountDownLatch(1);
    private boolean waitingForServiceConfig = true;
    private final RetriableStream.ChannelBufferMeter channelBufferUsed = new RetriableStream.ChannelBufferMeter();

    /* loaded from: classes2.dex */
    private final class ChannelTransportProvider implements ClientCallImpl.ClientTransportProvider {
        private ChannelTransportProvider() {
        }

        @Override // io.grpc.internal.ClientCallImpl.ClientTransportProvider
        public ClientTransport get(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            LoadBalancer.SubchannelPicker subchannelPicker = ManagedChannelImpl.this.subchannelPicker;
            if (!ManagedChannelImpl.this.shutdown.get()) {
                if (subchannelPicker == null) {
                    ManagedChannelImpl.this.a.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.ChannelTransportProvider.1ExitIdleModeForTransport
                        @Override // java.lang.Runnable
                        public void run() {
                            ManagedChannelImpl.this.a();
                        }
                    });
                } else {
                    ClientTransport a = GrpcUtil.a(subchannelPicker.pickSubchannel(pickSubchannelArgs), pickSubchannelArgs.getCallOptions().isWaitForReady());
                    if (a != null) {
                        return a;
                    }
                }
            }
            return ManagedChannelImpl.this.delayedTransport;
        }

        @Override // io.grpc.internal.ClientCallImpl.ClientTransportProvider
        public <ReqT> ClientStream newRetriableStream(MethodDescriptor<ReqT, ?> methodDescriptor, CallOptions callOptions, Metadata metadata, Context context) {
            Preconditions.checkState(ManagedChannelImpl.this.retryEnabled, "retry should be enabled");
            return new RetriableStream<ReqT>(methodDescriptor, metadata, callOptions, context) { // from class: io.grpc.internal.ManagedChannelImpl.ChannelTransportProvider.1RetryStream
                final /* synthetic */ MethodDescriptor c;
                final /* synthetic */ CallOptions d;
                final /* synthetic */ Context e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(methodDescriptor, metadata, ManagedChannelImpl.this.channelBufferUsed, ManagedChannelImpl.this.perRpcBufferLimit, ManagedChannelImpl.this.channelBufferLimit, ManagedChannelImpl.this.getCallExecutor(callOptions), ManagedChannelImpl.this.transportFactory.getScheduledExecutorService(), (RetryPolicy.Provider) callOptions.getOption(ServiceConfigInterceptor.b), (HedgingPolicy.Provider) callOptions.getOption(ServiceConfigInterceptor.c), ManagedChannelImpl.this.throttle);
                    this.c = methodDescriptor;
                    this.d = callOptions;
                    this.e = context;
                }

                @Override // io.grpc.internal.RetriableStream
                ClientStream a(ClientStreamTracer.Factory factory, Metadata metadata2) {
                    CallOptions withStreamTracerFactory = this.d.withStreamTracerFactory(factory);
                    ClientTransport clientTransport = ChannelTransportProvider.this.get(new PickSubchannelArgsImpl(this.c, metadata2, withStreamTracerFactory));
                    Context attach = this.e.attach();
                    try {
                        return clientTransport.newStream(this.c, metadata2, withStreamTracerFactory);
                    } finally {
                        this.e.detach(attach);
                    }
                }

                @Override // io.grpc.internal.RetriableStream
                void a() {
                    ManagedChannelImpl.this.uncommittedRetriableStreamsRegistry.b(this);
                }

                @Override // io.grpc.internal.RetriableStream
                Status b() {
                    return ManagedChannelImpl.this.uncommittedRetriableStreamsRegistry.a(this);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public class DelayedNameResolverRefresh implements Runnable {
        DelayedNameResolverRefresh() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ManagedChannelImpl.this.scheduledNameResolverRefresh = null;
            ManagedChannelImpl.this.refreshNameResolution();
        }
    }

    /* loaded from: classes2.dex */
    private final class DelayedTransportListener implements ManagedClientTransport.Listener {
        private DelayedTransportListener() {
        }

        @Override // io.grpc.internal.ManagedClientTransport.Listener
        public void transportInUse(boolean z) {
            ManagedChannelImpl managedChannelImpl = ManagedChannelImpl.this;
            managedChannelImpl.b.updateObjectInUse(managedChannelImpl.delayedTransport, z);
        }

        @Override // io.grpc.internal.ManagedClientTransport.Listener
        public void transportReady() {
        }

        @Override // io.grpc.internal.ManagedClientTransport.Listener
        public void transportShutdown(Status status) {
            Preconditions.checkState(ManagedChannelImpl.this.shutdown.get(), "Channel must have been shut down");
        }

        @Override // io.grpc.internal.ManagedClientTransport.Listener
        public void transportTerminated() {
            Preconditions.checkState(ManagedChannelImpl.this.shutdown.get(), "Channel must have been shut down");
            ManagedChannelImpl.this.terminating = true;
            ManagedChannelImpl.this.shutdownNameResolverAndLoadBalancer(false);
            ManagedChannelImpl.this.maybeShutdownNowSubchannels();
            ManagedChannelImpl.this.maybeTerminateChannel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class ExecutorHolder {
        private Executor executor;
        private final ObjectPool<? extends Executor> pool;

        ExecutorHolder(ObjectPool<? extends Executor> objectPool) {
            this.pool = (ObjectPool) Preconditions.checkNotNull(objectPool, "executorPool");
        }

        synchronized Executor a() {
            if (this.executor == null) {
                this.executor = (Executor) Preconditions.checkNotNull(this.pool.getObject(), "%s.getObject()", this.executor);
            }
            return this.executor;
        }

        synchronized void b() {
            if (this.executor != null) {
                this.executor = this.pool.returnObject(this.executor);
            }
        }
    }

    /* loaded from: classes2.dex */
    private final class IdleModeStateAggregator extends InUseStateAggregator<Object> {
        private IdleModeStateAggregator() {
        }

        @Override // io.grpc.internal.InUseStateAggregator
        protected void a() {
            ManagedChannelImpl.this.a();
        }

        @Override // io.grpc.internal.InUseStateAggregator
        protected void b() {
            if (ManagedChannelImpl.this.shutdown.get()) {
                return;
            }
            ManagedChannelImpl.this.rescheduleIdleTimer();
        }
    }

    /* loaded from: classes2.dex */
    private class IdleModeTimer implements Runnable {
        private IdleModeTimer() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ManagedChannelImpl.this.enterIdleMode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class LbHelperImpl extends LoadBalancer.Helper {
        LoadBalancer a;

        private LbHelperImpl() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleInternalSubchannelState(ConnectivityStateInfo connectivityStateInfo) {
            if (connectivityStateInfo.getState() == ConnectivityState.TRANSIENT_FAILURE || connectivityStateInfo.getState() == ConnectivityState.IDLE) {
                ManagedChannelImpl.this.refreshAndResetNameResolution();
            }
        }

        @Override // io.grpc.LoadBalancer.Helper
        public ManagedChannel createOobChannel(EquivalentAddressGroup equivalentAddressGroup, String str) {
            Preconditions.checkState(!ManagedChannelImpl.this.terminated, "Channel is terminated");
            long currentTimeNanos = ManagedChannelImpl.this.timeProvider.currentTimeNanos();
            InternalLogId allocate = InternalLogId.allocate("OobChannel", (String) null);
            InternalLogId allocate2 = InternalLogId.allocate("Subchannel-OOB", (String) null);
            ChannelTracer channelTracer = new ChannelTracer(allocate, ManagedChannelImpl.this.maxTraceEvents, currentTimeNanos, "OobChannel for " + equivalentAddressGroup);
            ObjectPool objectPool = ManagedChannelImpl.this.balancerRpcExecutorPool;
            ScheduledExecutorService scheduledExecutorService = ManagedChannelImpl.this.transportFactory.getScheduledExecutorService();
            ManagedChannelImpl managedChannelImpl = ManagedChannelImpl.this;
            final OobChannel oobChannel = new OobChannel(str, objectPool, scheduledExecutorService, managedChannelImpl.a, managedChannelImpl.callTracerFactory.create(), channelTracer, ManagedChannelImpl.this.channelz, ManagedChannelImpl.this.timeProvider);
            ManagedChannelImpl.this.channelTracer.a(new InternalChannelz.ChannelTrace.Event.Builder().setDescription("Child OobChannel created").setSeverity(InternalChannelz.ChannelTrace.Event.Severity.CT_INFO).setTimestampNanos(currentTimeNanos).setChannelRef(oobChannel).build());
            InternalSubchannel internalSubchannel = new InternalSubchannel(Collections.singletonList(equivalentAddressGroup), str, ManagedChannelImpl.this.userAgent, ManagedChannelImpl.this.backoffPolicyProvider, ManagedChannelImpl.this.transportFactory, ManagedChannelImpl.this.transportFactory.getScheduledExecutorService(), ManagedChannelImpl.this.stopwatchSupplier, ManagedChannelImpl.this.a, new InternalSubchannel.Callback() { // from class: io.grpc.internal.ManagedChannelImpl.LbHelperImpl.1ManagedOobChannelCallback
                @Override // io.grpc.internal.InternalSubchannel.Callback
                void a(InternalSubchannel internalSubchannel2, ConnectivityStateInfo connectivityStateInfo) {
                    LbHelperImpl.this.handleInternalSubchannelState(connectivityStateInfo);
                    oobChannel.a(connectivityStateInfo);
                }

                @Override // io.grpc.internal.InternalSubchannel.Callback
                void c(InternalSubchannel internalSubchannel2) {
                    ManagedChannelImpl.this.oobChannels.remove(oobChannel);
                    ManagedChannelImpl.this.channelz.removeSubchannel(internalSubchannel2);
                    oobChannel.b();
                    ManagedChannelImpl.this.maybeTerminateChannel();
                }
            }, ManagedChannelImpl.this.channelz, ManagedChannelImpl.this.callTracerFactory.create(), new ChannelTracer(allocate2, ManagedChannelImpl.this.maxTraceEvents, currentTimeNanos, "Subchannel for " + equivalentAddressGroup), allocate2, ManagedChannelImpl.this.timeProvider);
            channelTracer.a(new InternalChannelz.ChannelTrace.Event.Builder().setDescription("Child Subchannel created").setSeverity(InternalChannelz.ChannelTrace.Event.Severity.CT_INFO).setTimestampNanos(currentTimeNanos).setSubchannelRef(internalSubchannel).build());
            ManagedChannelImpl.this.channelz.addSubchannel(oobChannel);
            ManagedChannelImpl.this.channelz.addSubchannel(internalSubchannel);
            oobChannel.a(internalSubchannel);
            ManagedChannelImpl.this.a.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.LbHelperImpl.1AddOobChannel
                @Override // java.lang.Runnable
                public void run() {
                    if (ManagedChannelImpl.this.terminating) {
                        oobChannel.shutdown();
                    }
                    if (ManagedChannelImpl.this.terminated) {
                        return;
                    }
                    ManagedChannelImpl.this.oobChannels.add(oobChannel);
                }
            });
            return oobChannel;
        }

        @Override // io.grpc.LoadBalancer.Helper
        public /* bridge */ /* synthetic */ LoadBalancer.Subchannel createSubchannel(List list, Attributes attributes) {
            return createSubchannel((List<EquivalentAddressGroup>) list, attributes);
        }

        @Override // io.grpc.LoadBalancer.Helper
        public AbstractSubchannel createSubchannel(List<EquivalentAddressGroup> list, Attributes attributes) {
            ManagedChannelImpl.this.logWarningIfNotInSyncContext("createSubchannel()");
            Preconditions.checkNotNull(list, "addressGroups");
            Preconditions.checkNotNull(attributes, "attrs");
            Preconditions.checkState(!ManagedChannelImpl.this.terminated, "Channel is terminated");
            final SubchannelImpl subchannelImpl = new SubchannelImpl(attributes);
            long currentTimeNanos = ManagedChannelImpl.this.timeProvider.currentTimeNanos();
            InternalLogId allocate = InternalLogId.allocate("Subchannel", (String) null);
            final InternalSubchannel internalSubchannel = new InternalSubchannel(list, ManagedChannelImpl.this.authority(), ManagedChannelImpl.this.userAgent, ManagedChannelImpl.this.backoffPolicyProvider, ManagedChannelImpl.this.transportFactory, ManagedChannelImpl.this.transportFactory.getScheduledExecutorService(), ManagedChannelImpl.this.stopwatchSupplier, ManagedChannelImpl.this.a, new InternalSubchannel.Callback() { // from class: io.grpc.internal.ManagedChannelImpl.LbHelperImpl.1ManagedInternalSubchannelCallback
                @Override // io.grpc.internal.InternalSubchannel.Callback
                void a(InternalSubchannel internalSubchannel2) {
                    ManagedChannelImpl.this.b.updateObjectInUse(internalSubchannel2, true);
                }

                @Override // io.grpc.internal.InternalSubchannel.Callback
                void a(InternalSubchannel internalSubchannel2, ConnectivityStateInfo connectivityStateInfo) {
                    LbHelperImpl.this.handleInternalSubchannelState(connectivityStateInfo);
                    LbHelperImpl lbHelperImpl = LbHelperImpl.this;
                    if (lbHelperImpl == ManagedChannelImpl.this.lbHelper) {
                        LbHelperImpl.this.a.handleSubchannelState(subchannelImpl, connectivityStateInfo);
                    }
                }

                @Override // io.grpc.internal.InternalSubchannel.Callback
                void b(InternalSubchannel internalSubchannel2) {
                    ManagedChannelImpl.this.b.updateObjectInUse(internalSubchannel2, false);
                }

                @Override // io.grpc.internal.InternalSubchannel.Callback
                void c(InternalSubchannel internalSubchannel2) {
                    ManagedChannelImpl.this.subchannels.remove(internalSubchannel2);
                    ManagedChannelImpl.this.channelz.removeSubchannel(internalSubchannel2);
                    ManagedChannelImpl.this.maybeTerminateChannel();
                }
            }, ManagedChannelImpl.this.channelz, ManagedChannelImpl.this.callTracerFactory.create(), new ChannelTracer(allocate, ManagedChannelImpl.this.maxTraceEvents, currentTimeNanos, "Subchannel for " + list), allocate, ManagedChannelImpl.this.timeProvider);
            ManagedChannelImpl.this.channelTracer.a(new InternalChannelz.ChannelTrace.Event.Builder().setDescription("Child Subchannel created").setSeverity(InternalChannelz.ChannelTrace.Event.Severity.CT_INFO).setTimestampNanos(currentTimeNanos).setSubchannelRef(internalSubchannel).build());
            ManagedChannelImpl.this.channelz.addSubchannel(internalSubchannel);
            subchannelImpl.a = internalSubchannel;
            ManagedChannelImpl.this.a.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.LbHelperImpl.1AddSubchannel
                @Override // java.lang.Runnable
                public void run() {
                    if (ManagedChannelImpl.this.terminating) {
                        internalSubchannel.shutdown(ManagedChannelImpl.f);
                    }
                    if (ManagedChannelImpl.this.terminated) {
                        return;
                    }
                    ManagedChannelImpl.this.subchannels.add(internalSubchannel);
                }
            });
            return subchannelImpl;
        }

        @Override // io.grpc.LoadBalancer.Helper
        public String getAuthority() {
            return ManagedChannelImpl.this.authority();
        }

        @Override // io.grpc.LoadBalancer.Helper
        public ChannelLogger getChannelLogger() {
            return ManagedChannelImpl.this.channelLogger;
        }

        @Override // io.grpc.LoadBalancer.Helper
        @Deprecated
        public NameResolver.Factory getNameResolverFactory() {
            return ManagedChannelImpl.this.nameResolverFactory;
        }

        @Override // io.grpc.LoadBalancer.Helper
        public ScheduledExecutorService getScheduledExecutorService() {
            return ManagedChannelImpl.this.scheduledExecutorForBalancer;
        }

        @Override // io.grpc.LoadBalancer.Helper
        public SynchronizationContext getSynchronizationContext() {
            return ManagedChannelImpl.this.a;
        }

        @Override // io.grpc.LoadBalancer.Helper
        public void refreshNameResolution() {
            ManagedChannelImpl.this.logWarningIfNotInSyncContext("refreshNameResolution()");
            ManagedChannelImpl.this.a.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.LbHelperImpl.1LoadBalancerRefreshNameResolution
                @Override // java.lang.Runnable
                public void run() {
                    ManagedChannelImpl.this.refreshAndResetNameResolution();
                }
            });
        }

        @Override // io.grpc.LoadBalancer.Helper
        public void updateBalancingState(final ConnectivityState connectivityState, final LoadBalancer.SubchannelPicker subchannelPicker) {
            Preconditions.checkNotNull(connectivityState, "newState");
            Preconditions.checkNotNull(subchannelPicker, "newPicker");
            ManagedChannelImpl.this.logWarningIfNotInSyncContext("updateBalancingState()");
            ManagedChannelImpl.this.a.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.LbHelperImpl.1UpdateBalancingState
                @Override // java.lang.Runnable
                public void run() {
                    LbHelperImpl lbHelperImpl = LbHelperImpl.this;
                    if (lbHelperImpl != ManagedChannelImpl.this.lbHelper) {
                        return;
                    }
                    ManagedChannelImpl.this.updateSubchannelPicker(subchannelPicker);
                    if (connectivityState != ConnectivityState.SHUTDOWN) {
                        ManagedChannelImpl.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Entering {0} state", connectivityState);
                        ManagedChannelImpl.this.channelStateManager.a(connectivityState);
                    }
                }
            });
        }

        @Override // io.grpc.LoadBalancer.Helper
        public void updateOobChannelAddresses(ManagedChannel managedChannel, EquivalentAddressGroup equivalentAddressGroup) {
            Preconditions.checkArgument(managedChannel instanceof OobChannel, "channel must have been returned from createOobChannel");
            ((OobChannel) managedChannel).a(equivalentAddressGroup);
        }

        @Override // io.grpc.LoadBalancer.Helper
        public void updateSubchannelAddresses(LoadBalancer.Subchannel subchannel, List<EquivalentAddressGroup> list) {
            Preconditions.checkArgument(subchannel instanceof SubchannelImpl, "subchannel must have been returned from createSubchannel");
            ManagedChannelImpl.this.logWarningIfNotInSyncContext("updateSubchannelAddresses()");
            ((SubchannelImpl) subchannel).a.updateAddresses(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class NameResolverListener extends NameResolver.Listener2 {
        final LbHelperImpl a;
        final NameResolver b;

        NameResolverListener(LbHelperImpl lbHelperImpl, NameResolver nameResolver) {
            this.a = (LbHelperImpl) Preconditions.checkNotNull(lbHelperImpl, "helperImpl");
            this.b = (NameResolver) Preconditions.checkNotNull(nameResolver, "resolver");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleErrorInSyncContext(Status status) {
            ManagedChannelImpl.c.log(Level.WARNING, "[{0}] Failed to resolve name. status={1}", new Object[]{ManagedChannelImpl.this.getLogId(), status});
            if (ManagedChannelImpl.this.haveBackends == null || ManagedChannelImpl.this.haveBackends.booleanValue()) {
                ManagedChannelImpl.this.channelLogger.log(ChannelLogger.ChannelLogLevel.WARNING, "Failed to resolve name: {0}", status);
                ManagedChannelImpl.this.haveBackends = false;
            }
            if (this.a != ManagedChannelImpl.this.lbHelper) {
                return;
            }
            this.a.a.handleNameResolutionError(status);
            if (ManagedChannelImpl.this.scheduledNameResolverRefresh == null || !ManagedChannelImpl.this.scheduledNameResolverRefresh.isPending()) {
                if (ManagedChannelImpl.this.nameResolverBackoffPolicy == null) {
                    ManagedChannelImpl managedChannelImpl = ManagedChannelImpl.this;
                    managedChannelImpl.nameResolverBackoffPolicy = managedChannelImpl.backoffPolicyProvider.get();
                }
                long nextBackoffNanos = ManagedChannelImpl.this.nameResolverBackoffPolicy.nextBackoffNanos();
                ManagedChannelImpl.this.channelLogger.log(ChannelLogger.ChannelLogLevel.DEBUG, "Scheduling DNS resolution backoff for {0} ns", Long.valueOf(nextBackoffNanos));
                ManagedChannelImpl managedChannelImpl2 = ManagedChannelImpl.this;
                managedChannelImpl2.scheduledNameResolverRefresh = managedChannelImpl2.a.schedule(new DelayedNameResolverRefresh(), nextBackoffNanos, TimeUnit.NANOSECONDS, ManagedChannelImpl.this.transportFactory.getScheduledExecutorService());
            }
        }

        @Override // io.grpc.NameResolver.Listener2, io.grpc.NameResolver.Listener
        public void onError(final Status status) {
            Preconditions.checkArgument(!status.isOk(), "the error status must not be OK");
            ManagedChannelImpl.this.a.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.NameResolverListener.1NameResolverErrorHandler
                @Override // java.lang.Runnable
                public void run() {
                    NameResolverListener.this.handleErrorInSyncContext(status);
                }
            });
        }

        @Override // io.grpc.NameResolver.Listener2
        public void onResult(final NameResolver.ResolutionResult resolutionResult) {
            ManagedChannelImpl.this.a.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.NameResolverListener.1NamesResolved
                @Override // java.lang.Runnable
                public void run() {
                    Map map;
                    List<EquivalentAddressGroup> addresses = resolutionResult.getAddresses();
                    Attributes attributes = resolutionResult.getAttributes();
                    ManagedChannelImpl.this.channelLogger.log(ChannelLogger.ChannelLogLevel.DEBUG, "Resolved address: {0}, config={1}", addresses, attributes);
                    if (ManagedChannelImpl.this.haveBackends == null || !ManagedChannelImpl.this.haveBackends.booleanValue()) {
                        ManagedChannelImpl.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Address resolved: {0}", addresses);
                        ManagedChannelImpl.this.haveBackends = true;
                    }
                    ManagedChannelImpl.this.nameResolverBackoffPolicy = null;
                    Map map2 = (Map) attributes.get(GrpcAttributes.NAME_RESOLVER_SERVICE_CONFIG);
                    if (ManagedChannelImpl.this.lookUpServiceConfig) {
                        if (map2 != null) {
                            map = map2;
                        } else {
                            map = ManagedChannelImpl.this.defaultServiceConfig;
                            if (ManagedChannelImpl.this.defaultServiceConfig != null) {
                                ManagedChannelImpl.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Received no service config, using default service config");
                            }
                        }
                        if (map != ManagedChannelImpl.this.lastServiceConfig) {
                            ChannelLogger channelLogger = ManagedChannelImpl.this.channelLogger;
                            ChannelLogger.ChannelLogLevel channelLogLevel = ChannelLogger.ChannelLogLevel.INFO;
                            Object[] objArr = new Object[1];
                            objArr[0] = map == null ? " to null" : "";
                            channelLogger.log(channelLogLevel, "Service config changed{0}", objArr);
                            ManagedChannelImpl.this.lastServiceConfig = map;
                        }
                        try {
                            ManagedChannelImpl.this.handleServiceConfigUpdate();
                        } catch (RuntimeException e) {
                            ManagedChannelImpl.c.log(Level.WARNING, "[" + ManagedChannelImpl.this.getLogId() + "] Unexpected exception from parsing service config", (Throwable) e);
                        }
                    } else {
                        if (map2 != null) {
                            ManagedChannelImpl.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Service config from name resolver discarded by channel settings");
                        }
                        map = ManagedChannelImpl.this.defaultServiceConfig;
                    }
                    NameResolverListener nameResolverListener = NameResolverListener.this;
                    if (nameResolverListener.a == ManagedChannelImpl.this.lbHelper) {
                        if (!addresses.isEmpty() || NameResolverListener.this.a.a.canHandleEmptyAddressListFromNameResolution()) {
                            if (map != map2) {
                                attributes = attributes.toBuilder().set(GrpcAttributes.NAME_RESOLVER_SERVICE_CONFIG, map).build();
                            }
                            NameResolverListener.this.a.a.handleResolvedAddresses(LoadBalancer.ResolvedAddresses.newBuilder().setAddresses(addresses).setAttributes(attributes).build());
                            return;
                        }
                        NameResolverListener.this.handleErrorInSyncContext(Status.UNAVAILABLE.withDescription("Name resolver " + NameResolverListener.this.b + " returned an empty list"));
                    }
                }
            });
        }
    }

    /* loaded from: classes2.dex */
    private class RealChannel extends Channel {
        private final String authority;

        private RealChannel(String str) {
            this.authority = (String) Preconditions.checkNotNull(str, "authority");
        }

        @Override // io.grpc.Channel
        public String authority() {
            return this.authority;
        }

        @Override // io.grpc.Channel
        public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
            return new ClientCallImpl(methodDescriptor, ManagedChannelImpl.this.getCallExecutor(callOptions), callOptions, ManagedChannelImpl.this.transportProvider, ManagedChannelImpl.this.terminated ? null : ManagedChannelImpl.this.transportFactory.getScheduledExecutorService(), ManagedChannelImpl.this.channelCallTracer, ManagedChannelImpl.this.retryEnabled).a(ManagedChannelImpl.this.fullStreamDecompression).a(ManagedChannelImpl.this.decompressorRegistry).a(ManagedChannelImpl.this.compressorRegistry);
        }
    }

    @VisibleForTesting
    /* loaded from: classes2.dex */
    static final class ScParser extends NameResolver.ServiceConfigParser {
        private final AutoConfiguredLoadBalancerFactory autoLoadBalancerFactory;
        private final int maxHedgedAttemptsLimit;
        private final int maxRetryAttemptsLimit;
        private final boolean retryEnabled;

        ScParser(boolean z, int i, int i2, AutoConfiguredLoadBalancerFactory autoConfiguredLoadBalancerFactory) {
            this.retryEnabled = z;
            this.maxRetryAttemptsLimit = i;
            this.maxHedgedAttemptsLimit = i2;
            this.autoLoadBalancerFactory = (AutoConfiguredLoadBalancerFactory) Preconditions.checkNotNull(autoConfiguredLoadBalancerFactory, "autoLoadBalancerFactory");
        }

        @Override // io.grpc.NameResolver.ServiceConfigParser
        public NameResolver.ConfigOrError parseServiceConfig(Map<String, ?> map) {
            Object config;
            try {
                NameResolver.ConfigOrError a = this.autoLoadBalancerFactory.a(map);
                if (a == null) {
                    config = null;
                } else {
                    if (a.getError() != null) {
                        return NameResolver.ConfigOrError.fromError(a.getError());
                    }
                    config = a.getConfig();
                }
                return NameResolver.ConfigOrError.fromConfig(ManagedChannelServiceConfig.a(map, this.retryEnabled, this.maxRetryAttemptsLimit, this.maxHedgedAttemptsLimit, config));
            } catch (RuntimeException e) {
                return NameResolver.ConfigOrError.fromError(Status.UNKNOWN.withDescription("failed to parse service config").withCause(e));
            }
        }
    }

    /* loaded from: classes2.dex */
    private static final class ScheduledExecutorForBalancer implements ScheduledExecutorService {
        final ScheduledExecutorService a;

        private ScheduledExecutorForBalancer(ScheduledExecutorService scheduledExecutorService) {
            this.a = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService, "delegate");
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j, TimeUnit timeUnit) {
            return this.a.awaitTermination(j, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.a.execute(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
            return this.a.invokeAll(collection);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
            return this.a.invokeAll(collection, j, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
            return (T) this.a.invokeAny(collection);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
            return (T) this.a.invokeAny(collection, j, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.a.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.a.isTerminated();
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.a.schedule(runnable, j, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
            return this.a.schedule(callable, j, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            return this.a.scheduleAtFixedRate(runnable, j, j2, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            return this.a.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            throw new UnsupportedOperationException("Restricted: shutdown() is not allowed");
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            throw new UnsupportedOperationException("Restricted: shutdownNow() is not allowed");
        }

        @Override // java.util.concurrent.ExecutorService
        public Future<?> submit(Runnable runnable) {
            return this.a.submit(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Runnable runnable, T t) {
            return this.a.submit(runnable, t);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Callable<T> callable) {
            return this.a.submit(callable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class SubchannelImpl extends AbstractSubchannel {
        InternalSubchannel a;
        final Object b = new Object();
        final Attributes c;

        @GuardedBy("shutdownLock")
        boolean d;

        @GuardedBy("shutdownLock")
        ScheduledFuture<?> e;

        SubchannelImpl(Attributes attributes) {
            this.c = (Attributes) Preconditions.checkNotNull(attributes, "attrs");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // io.grpc.internal.AbstractSubchannel
        public ClientTransport a() {
            return this.a.f();
        }

        @Override // io.grpc.LoadBalancer.Subchannel
        public Channel asChannel() {
            return new SubchannelChannel(this.a, ManagedChannelImpl.this.balancerRpcExecutorHolder.a(), ManagedChannelImpl.this.transportFactory.getScheduledExecutorService(), ManagedChannelImpl.this.callTracerFactory.create());
        }

        @Override // io.grpc.LoadBalancer.Subchannel
        public List<EquivalentAddressGroup> getAllAddresses() {
            ManagedChannelImpl.this.logWarningIfNotInSyncContext("Subchannel.getAllAddresses()");
            return this.a.a();
        }

        @Override // io.grpc.LoadBalancer.Subchannel
        public Attributes getAttributes() {
            return this.c;
        }

        @Override // io.grpc.LoadBalancer.Subchannel
        public ChannelLogger getChannelLogger() {
            return this.a.c();
        }

        @Override // io.grpc.LoadBalancer.Subchannel
        public void requestConnection() {
            this.a.f();
        }

        @Override // io.grpc.LoadBalancer.Subchannel
        public void shutdown() {
            ManagedChannelImpl.this.logWarningIfNotInSyncContext("Subchannel.shutdown()");
            synchronized (this.b) {
                if (!this.d) {
                    this.d = true;
                } else {
                    if (!ManagedChannelImpl.this.terminating || this.e == null) {
                        return;
                    }
                    this.e.cancel(false);
                    this.e = null;
                }
                if (ManagedChannelImpl.this.terminating) {
                    this.a.shutdown(ManagedChannelImpl.f);
                } else {
                    this.e = ManagedChannelImpl.this.transportFactory.getScheduledExecutorService().schedule(new LogExceptionRunnable(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.SubchannelImpl.1ShutdownSubchannel
                        @Override // java.lang.Runnable
                        public void run() {
                            SubchannelImpl.this.a.shutdown(ManagedChannelImpl.g);
                        }
                    }), 5L, TimeUnit.SECONDS);
                }
            }
        }

        public String toString() {
            return this.a.getLogId().toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class UncommittedRetriableStreamsRegistry {
        final Object a;

        @GuardedBy("lock")
        Collection<ClientStream> b;

        @GuardedBy("lock")
        Status c;

        private UncommittedRetriableStreamsRegistry() {
            this.a = new Object();
            this.b = new HashSet();
        }

        @Nullable
        Status a(RetriableStream<?> retriableStream) {
            synchronized (this.a) {
                if (this.c != null) {
                    return this.c;
                }
                this.b.add(retriableStream);
                return null;
            }
        }

        void a(Status status) {
            synchronized (this.a) {
                if (this.c != null) {
                    return;
                }
                this.c = status;
                boolean isEmpty = this.b.isEmpty();
                if (isEmpty) {
                    ManagedChannelImpl.this.delayedTransport.shutdown(status);
                }
            }
        }

        void b(Status status) {
            ArrayList arrayList;
            a(status);
            synchronized (this.a) {
                arrayList = new ArrayList(this.b);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((ClientStream) it.next()).cancel(status);
            }
            ManagedChannelImpl.this.delayedTransport.shutdownNow(status);
        }

        void b(RetriableStream<?> retriableStream) {
            Status status;
            synchronized (this.a) {
                this.b.remove(retriableStream);
                if (this.b.isEmpty()) {
                    status = this.c;
                    this.b = new HashSet();
                } else {
                    status = null;
                }
            }
            if (status != null) {
                ManagedChannelImpl.this.delayedTransport.shutdown(status);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ManagedChannelImpl(AbstractManagedChannelImplBuilder<?> abstractManagedChannelImplBuilder, ClientTransportFactory clientTransportFactory, BackoffPolicy.Provider provider, ObjectPool<? extends Executor> objectPool, Supplier<Stopwatch> supplier, List<ClientInterceptor> list, final TimeProvider timeProvider) {
        this.uncommittedRetriableStreamsRegistry = new UncommittedRetriableStreamsRegistry();
        this.delayedTransportListener = new DelayedTransportListener();
        this.b = new IdleModeStateAggregator();
        this.transportProvider = new ChannelTransportProvider();
        this.target = (String) Preconditions.checkNotNull(abstractManagedChannelImplBuilder.b, "target");
        this.logId = InternalLogId.allocate("Channel", this.target);
        this.nameResolverFactory = abstractManagedChannelImplBuilder.d();
        ProxyDetector proxyDetector = abstractManagedChannelImplBuilder.v;
        proxyDetector = proxyDetector == null ? GrpcUtil.getDefaultProxyDetector() : proxyDetector;
        this.retryEnabled = abstractManagedChannelImplBuilder.n && !abstractManagedChannelImplBuilder.o;
        this.loadBalancerFactory = new AutoConfiguredLoadBalancerFactory(abstractManagedChannelImplBuilder.e);
        this.nameResolverArgs = NameResolver.Args.newBuilder().setDefaultPort(abstractManagedChannelImplBuilder.b()).setProxyDetector(proxyDetector).setSynchronizationContext(this.a).setServiceConfigParser(new ScParser(this.retryEnabled, abstractManagedChannelImplBuilder.j, abstractManagedChannelImplBuilder.k, this.loadBalancerFactory)).build();
        this.nameResolver = a(this.target, this.nameResolverFactory, this.nameResolverArgs);
        this.timeProvider = (TimeProvider) Preconditions.checkNotNull(timeProvider, "timeProvider");
        int i = abstractManagedChannelImplBuilder.q;
        this.maxTraceEvents = i;
        this.channelTracer = new ChannelTracer(this.logId, i, timeProvider.currentTimeNanos(), "Channel for '" + this.target + "'");
        this.channelLogger = new ChannelLoggerImpl(this.channelTracer, timeProvider);
        this.executorPool = (ObjectPool) Preconditions.checkNotNull(abstractManagedChannelImplBuilder.a, "executorPool");
        this.balancerRpcExecutorPool = (ObjectPool) Preconditions.checkNotNull(objectPool, "balancerRpcExecutorPool");
        this.balancerRpcExecutorHolder = new ExecutorHolder(objectPool);
        this.executor = (Executor) Preconditions.checkNotNull(this.executorPool.getObject(), "executor");
        this.delayedTransport = new DelayedClientTransport(this.executor, this.a);
        this.delayedTransport.start(this.delayedTransportListener);
        this.backoffPolicyProvider = provider;
        this.transportFactory = new CallCredentialsApplyingTransportFactory(clientTransportFactory, this.executor);
        this.scheduledExecutorForBalancer = new ScheduledExecutorForBalancer(this.transportFactory.getScheduledExecutorService());
        this.serviceConfigInterceptor = new ServiceConfigInterceptor(this.retryEnabled, abstractManagedChannelImplBuilder.j, abstractManagedChannelImplBuilder.k);
        this.defaultServiceConfig = abstractManagedChannelImplBuilder.r;
        this.lastServiceConfig = this.defaultServiceConfig;
        this.lookUpServiceConfig = abstractManagedChannelImplBuilder.s;
        Channel intercept = ClientInterceptors.intercept(new RealChannel(this.nameResolver.getServiceAuthority()), this.serviceConfigInterceptor);
        BinaryLog binaryLog = abstractManagedChannelImplBuilder.u;
        this.interceptorChannel = ClientInterceptors.intercept(binaryLog != null ? binaryLog.wrapChannel(intercept) : intercept, list);
        this.stopwatchSupplier = (Supplier) Preconditions.checkNotNull(supplier, "stopwatchSupplier");
        long j = abstractManagedChannelImplBuilder.i;
        if (j == -1) {
            this.idleTimeoutMillis = j;
        } else {
            Preconditions.checkArgument(j >= AbstractManagedChannelImplBuilder.x, "invalid idleTimeoutMillis %s", abstractManagedChannelImplBuilder.i);
            this.idleTimeoutMillis = abstractManagedChannelImplBuilder.i;
        }
        this.idleTimer = new Rescheduler(new IdleModeTimer(), this.a, this.transportFactory.getScheduledExecutorService(), supplier.get());
        this.fullStreamDecompression = abstractManagedChannelImplBuilder.f;
        this.decompressorRegistry = (DecompressorRegistry) Preconditions.checkNotNull(abstractManagedChannelImplBuilder.g, "decompressorRegistry");
        this.compressorRegistry = (CompressorRegistry) Preconditions.checkNotNull(abstractManagedChannelImplBuilder.h, "compressorRegistry");
        this.userAgent = abstractManagedChannelImplBuilder.c;
        this.channelBufferLimit = abstractManagedChannelImplBuilder.l;
        this.perRpcBufferLimit = abstractManagedChannelImplBuilder.m;
        this.callTracerFactory = new CallTracer.Factory(this) { // from class: io.grpc.internal.ManagedChannelImpl.1ChannelCallTracerFactory
            @Override // io.grpc.internal.CallTracer.Factory
            public CallTracer create() {
                return new CallTracer(timeProvider);
            }
        };
        this.channelCallTracer = this.callTracerFactory.create();
        this.channelz = (InternalChannelz) Preconditions.checkNotNull(abstractManagedChannelImplBuilder.p);
        this.channelz.addRootChannel(this);
        if (this.lookUpServiceConfig) {
            return;
        }
        if (this.defaultServiceConfig != null) {
            this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Service config look-up disabled, using default service config");
        }
        handleServiceConfigUpdate();
    }

    @VisibleForTesting
    static NameResolver a(String str, NameResolver.Factory factory, NameResolver.Args args) {
        URI uri;
        NameResolver newNameResolver;
        StringBuilder sb = new StringBuilder();
        try {
            uri = new URI(str);
        } catch (URISyntaxException e2) {
            sb.append(e2.getMessage());
            uri = null;
        }
        if (uri != null && (newNameResolver = factory.newNameResolver(uri, args)) != null) {
            return newNameResolver;
        }
        String str2 = "";
        if (!d.matcher(str).matches()) {
            try {
                NameResolver newNameResolver2 = factory.newNameResolver(new URI(factory.getDefaultScheme(), "", "/" + str, null), args);
                if (newNameResolver2 != null) {
                    return newNameResolver2;
                }
            } catch (URISyntaxException e3) {
                throw new IllegalArgumentException(e3);
            }
        }
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (sb.length() > 0) {
            str2 = " (" + ((Object) sb) + ")";
        }
        objArr[1] = str2;
        throw new IllegalArgumentException(String.format("cannot find a NameResolver for %s%s", objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelIdleTimer(boolean z) {
        this.idleTimer.a(z);
    }

    private void cancelNameResolverBackoff() {
        this.a.throwIfNotInThisSynchronizationContext();
        SynchronizationContext.ScheduledHandle scheduledHandle = this.scheduledNameResolverRefresh;
        if (scheduledHandle != null) {
            scheduledHandle.cancel();
            this.scheduledNameResolverRefresh = null;
            this.nameResolverBackoffPolicy = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterIdleMode() {
        shutdownNameResolverAndLoadBalancer(true);
        this.delayedTransport.a((LoadBalancer.SubchannelPicker) null);
        this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Entering IDLE state");
        this.channelStateManager.a(ConnectivityState.IDLE);
        if (this.b.isInUse()) {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Executor getCallExecutor(CallOptions callOptions) {
        Executor executor = callOptions.getExecutor();
        return executor == null ? this.executor : executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleServiceConfigUpdate() {
        this.waitingForServiceConfig = false;
        this.serviceConfigInterceptor.a(this.lastServiceConfig);
        if (this.retryEnabled) {
            this.throttle = ServiceConfigUtil.q(this.lastServiceConfig);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logWarningIfNotInSyncContext(String str) {
        try {
            this.a.throwIfNotInThisSynchronizationContext();
        } catch (IllegalStateException e2) {
            c.log(Level.WARNING, str + " should be called from SynchronizationContext. This warning will become an exception in a future release. See https://github.com/grpc/grpc-java/issues/5015 for more details", (Throwable) e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeShutdownNowSubchannels() {
        if (this.shutdownNowed) {
            Iterator<InternalSubchannel> it = this.subchannels.iterator();
            while (it.hasNext()) {
                it.next().shutdownNow(e);
            }
            Iterator<OobChannel> it2 = this.oobChannels.iterator();
            while (it2.hasNext()) {
                it2.next().a().shutdownNow(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeTerminateChannel() {
        if (!this.terminated && this.shutdown.get() && this.subchannels.isEmpty() && this.oobChannels.isEmpty()) {
            this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Terminated");
            this.channelz.removeRootChannel(this);
            this.terminated = true;
            this.terminatedLatch.countDown();
            this.executorPool.returnObject(this.executor);
            this.balancerRpcExecutorHolder.b();
            this.transportFactory.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshAndResetNameResolution() {
        this.a.throwIfNotInThisSynchronizationContext();
        cancelNameResolverBackoff();
        refreshNameResolution();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshNameResolution() {
        this.a.throwIfNotInThisSynchronizationContext();
        if (this.nameResolverStarted) {
            this.nameResolver.refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rescheduleIdleTimer() {
        long j = this.idleTimeoutMillis;
        if (j == -1) {
            return;
        }
        this.idleTimer.a(j, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shutdownNameResolverAndLoadBalancer(boolean z) {
        this.a.throwIfNotInThisSynchronizationContext();
        if (z) {
            Preconditions.checkState(this.nameResolverStarted, "nameResolver is not started");
            Preconditions.checkState(this.lbHelper != null, "lbHelper is null");
        }
        if (this.nameResolver != null) {
            cancelNameResolverBackoff();
            this.nameResolver.shutdown();
            this.nameResolverStarted = false;
            if (z) {
                this.nameResolver = a(this.target, this.nameResolverFactory, this.nameResolverArgs);
            } else {
                this.nameResolver = null;
            }
        }
        LbHelperImpl lbHelperImpl = this.lbHelper;
        if (lbHelperImpl != null) {
            lbHelperImpl.a.shutdown();
            this.lbHelper = null;
        }
        this.subchannelPicker = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSubchannelPicker(LoadBalancer.SubchannelPicker subchannelPicker) {
        this.subchannelPicker = subchannelPicker;
        this.delayedTransport.a(subchannelPicker);
    }

    @VisibleForTesting
    void a() {
        this.a.throwIfNotInThisSynchronizationContext();
        if (this.shutdown.get() || this.panicMode) {
            return;
        }
        if (this.b.isInUse()) {
            cancelIdleTimer(false);
        } else {
            rescheduleIdleTimer();
        }
        if (this.lbHelper != null) {
            return;
        }
        this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Exiting idle mode");
        LbHelperImpl lbHelperImpl = new LbHelperImpl();
        lbHelperImpl.a = this.loadBalancerFactory.newLoadBalancer(lbHelperImpl);
        this.lbHelper = lbHelperImpl;
        this.nameResolver.start((NameResolver.Listener2) new NameResolverListener(lbHelperImpl, this.nameResolver));
        this.nameResolverStarted = true;
    }

    @VisibleForTesting
    void a(final Throwable th) {
        if (this.panicMode) {
            return;
        }
        this.panicMode = true;
        cancelIdleTimer(true);
        shutdownNameResolverAndLoadBalancer(false);
        updateSubchannelPicker(new LoadBalancer.SubchannelPicker(this) { // from class: io.grpc.internal.ManagedChannelImpl.1PanicSubchannelPicker
            private final LoadBalancer.PickResult panicPickResult;

            {
                this.panicPickResult = LoadBalancer.PickResult.withDrop(Status.INTERNAL.withDescription("Panic! This is a bug!").withCause(th));
            }

            @Override // io.grpc.LoadBalancer.SubchannelPicker
            public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
                return this.panicPickResult;
            }
        });
        this.channelLogger.log(ChannelLogger.ChannelLogLevel.ERROR, "PANIC! Entering TRANSIENT_FAILURE");
        this.channelStateManager.a(ConnectivityState.TRANSIENT_FAILURE);
    }

    @Override // io.grpc.Channel
    public String authority() {
        return this.interceptorChannel.authority();
    }

    @Override // io.grpc.ManagedChannel
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.terminatedLatch.await(j, timeUnit);
    }

    @Override // io.grpc.ManagedChannel
    public void enterIdle() {
        this.a.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.1PrepareToLoseNetworkRunnable
            @Override // java.lang.Runnable
            public void run() {
                if (ManagedChannelImpl.this.shutdown.get() || ManagedChannelImpl.this.lbHelper == null) {
                    return;
                }
                ManagedChannelImpl.this.cancelIdleTimer(false);
                ManagedChannelImpl.this.enterIdleMode();
            }
        });
    }

    @Override // io.grpc.InternalWithLogId
    public InternalLogId getLogId() {
        return this.logId;
    }

    @Override // io.grpc.ManagedChannel
    public ConnectivityState getState(boolean z) {
        ConnectivityState a = this.channelStateManager.a();
        if (z && a == ConnectivityState.IDLE) {
            this.a.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.1RequestConnection
                @Override // java.lang.Runnable
                public void run() {
                    ManagedChannelImpl.this.a();
                    if (ManagedChannelImpl.this.subchannelPicker != null) {
                        ManagedChannelImpl.this.subchannelPicker.requestConnection();
                    }
                }
            });
        }
        return a;
    }

    @Override // io.grpc.InternalInstrumented
    public ListenableFuture<InternalChannelz.ChannelStats> getStats() {
        final SettableFuture create = SettableFuture.create();
        this.a.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.1StatsFetcher
            @Override // java.lang.Runnable
            public void run() {
                InternalChannelz.ChannelStats.Builder builder = new InternalChannelz.ChannelStats.Builder();
                ManagedChannelImpl.this.channelCallTracer.a(builder);
                ManagedChannelImpl.this.channelTracer.a(builder);
                builder.setTarget(ManagedChannelImpl.this.target).setState(ManagedChannelImpl.this.channelStateManager.a());
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(ManagedChannelImpl.this.subchannels);
                arrayList.addAll(ManagedChannelImpl.this.oobChannels);
                builder.setSubchannels(arrayList);
                create.set(builder.build());
            }
        });
        return create;
    }

    @Override // io.grpc.ManagedChannel
    public boolean isShutdown() {
        return this.shutdown.get();
    }

    @Override // io.grpc.ManagedChannel
    public boolean isTerminated() {
        return this.terminated;
    }

    @Override // io.grpc.Channel
    public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
        return this.interceptorChannel.newCall(methodDescriptor, callOptions);
    }

    @Override // io.grpc.ManagedChannel
    public void notifyWhenStateChanged(final ConnectivityState connectivityState, final Runnable runnable) {
        this.a.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.1NotifyStateChanged
            @Override // java.lang.Runnable
            public void run() {
                ManagedChannelImpl.this.channelStateManager.a(runnable, ManagedChannelImpl.this.executor, connectivityState);
            }
        });
    }

    @Override // io.grpc.ManagedChannel
    public void resetConnectBackoff() {
        this.a.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.1ResetConnectBackoff
            @Override // java.lang.Runnable
            public void run() {
                if (ManagedChannelImpl.this.shutdown.get()) {
                    return;
                }
                if (ManagedChannelImpl.this.scheduledNameResolverRefresh != null && ManagedChannelImpl.this.scheduledNameResolverRefresh.isPending()) {
                    Preconditions.checkState(ManagedChannelImpl.this.nameResolverStarted, "name resolver must be started");
                    ManagedChannelImpl.this.refreshAndResetNameResolution();
                }
                Iterator it = ManagedChannelImpl.this.subchannels.iterator();
                while (it.hasNext()) {
                    ((InternalSubchannel) it.next()).g();
                }
                Iterator it2 = ManagedChannelImpl.this.oobChannels.iterator();
                while (it2.hasNext()) {
                    ((OobChannel) it2.next()).resetConnectBackoff();
                }
            }
        });
    }

    @Override // io.grpc.ManagedChannel
    public ManagedChannelImpl shutdown() {
        this.channelLogger.log(ChannelLogger.ChannelLogLevel.DEBUG, "shutdown() called");
        if (!this.shutdown.compareAndSet(false, true)) {
            return this;
        }
        this.a.executeLater(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.1Shutdown
            @Override // java.lang.Runnable
            public void run() {
                ManagedChannelImpl.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Entering SHUTDOWN state");
                ManagedChannelImpl.this.channelStateManager.a(ConnectivityState.SHUTDOWN);
            }
        });
        this.uncommittedRetriableStreamsRegistry.a(f);
        this.a.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.1CancelIdleTimer
            @Override // java.lang.Runnable
            public void run() {
                ManagedChannelImpl.this.cancelIdleTimer(true);
            }
        });
        return this;
    }

    @Override // io.grpc.ManagedChannel
    public ManagedChannelImpl shutdownNow() {
        this.channelLogger.log(ChannelLogger.ChannelLogLevel.DEBUG, "shutdownNow() called");
        shutdown();
        this.uncommittedRetriableStreamsRegistry.b(e);
        this.a.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.1ShutdownNow
            @Override // java.lang.Runnable
            public void run() {
                if (ManagedChannelImpl.this.shutdownNowed) {
                    return;
                }
                ManagedChannelImpl.this.shutdownNowed = true;
                ManagedChannelImpl.this.maybeShutdownNowSubchannels();
            }
        });
        return this;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("logId", this.logId.getId()).add("target", this.target).toString();
    }
}
