package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.errorprone.annotations.ForOverride;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.ChannelLogger;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.HttpConnectProxiedSocketAddress;
import io.grpc.InternalChannelz;
import io.grpc.InternalInstrumented;
import io.grpc.InternalLogId;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.BackoffPolicy;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.ClientTransportFactory;
import io.grpc.internal.ManagedClientTransport;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: Access modifiers changed from: package-private */
@ThreadSafe
/* loaded from: classes2.dex */
public final class InternalSubchannel implements InternalInstrumented<InternalChannelz.ChannelStats> {
    private static final Logger log = Logger.getLogger(InternalSubchannel.class.getName());

    @Nullable
    private volatile ManagedClientTransport activeTransport;

    @GuardedBy("lock")
    private Index addressIndex;
    private final String authority;
    private final BackoffPolicy.Provider backoffPolicyProvider;
    private final Callback callback;
    private final CallTracer callsTracer;
    private final ChannelLoggerImpl channelLogger;
    private final ChannelTracer channelTracer;
    private final InternalChannelz channelz;

    @GuardedBy("lock")
    private final Stopwatch connectingTimer;
    private final InternalLogId logId;

    @GuardedBy("lock")
    @Nullable
    private ConnectionClientTransport pendingTransport;

    @GuardedBy("lock")
    private boolean reconnectCanceled;

    @GuardedBy("lock")
    private BackoffPolicy reconnectPolicy;

    @GuardedBy("lock")
    @Nullable
    private ScheduledFuture<?> reconnectTask;
    private final ScheduledExecutorService scheduledExecutor;

    @GuardedBy("lock")
    private Status shutdownReason;
    private final SynchronizationContext syncContext;
    private final ClientTransportFactory transportFactory;
    private final String userAgent;
    private final Object lock = new Object();

    @GuardedBy("lock")
    private final Collection<ConnectionClientTransport> transports = new ArrayList();
    private final InUseStateAggregator<ConnectionClientTransport> inUseStateAggregator = new InUseStateAggregator<ConnectionClientTransport>() { // from class: io.grpc.internal.InternalSubchannel.1
        @Override // io.grpc.internal.InUseStateAggregator
        protected void a() {
            InternalSubchannel.this.callback.a(InternalSubchannel.this);
        }

        @Override // io.grpc.internal.InUseStateAggregator
        protected void b() {
            InternalSubchannel.this.callback.b(InternalSubchannel.this);
        }
    };

    @GuardedBy("lock")
    private ConnectivityStateInfo state = ConnectivityStateInfo.forNonError(ConnectivityState.IDLE);

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class CallTracingTransport extends ForwardingConnectionClientTransport {
        private final CallTracer callTracer;
        private final ConnectionClientTransport delegate;

        private CallTracingTransport(ConnectionClientTransport connectionClientTransport, CallTracer callTracer) {
            this.delegate = connectionClientTransport;
            this.callTracer = callTracer;
        }

        @Override // io.grpc.internal.ForwardingConnectionClientTransport
        protected ConnectionClientTransport a() {
            return this.delegate;
        }

        @Override // io.grpc.internal.ForwardingConnectionClientTransport, io.grpc.internal.ClientTransport
        public ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions) {
            final ClientStream newStream = super.newStream(methodDescriptor, metadata, callOptions);
            return new ForwardingClientStream() { // from class: io.grpc.internal.InternalSubchannel.CallTracingTransport.1
                @Override // io.grpc.internal.ForwardingClientStream
                protected ClientStream a() {
                    return newStream;
                }

                @Override // io.grpc.internal.ForwardingClientStream, io.grpc.internal.ClientStream
                public void start(final ClientStreamListener clientStreamListener) {
                    CallTracingTransport.this.callTracer.reportCallStarted();
                    super.start(new ForwardingClientStreamListener() { // from class: io.grpc.internal.InternalSubchannel.CallTracingTransport.1.1
                        @Override // io.grpc.internal.ForwardingClientStreamListener
                        protected ClientStreamListener a() {
                            return clientStreamListener;
                        }

                        @Override // io.grpc.internal.ForwardingClientStreamListener, io.grpc.internal.ClientStreamListener
                        public void closed(Status status, Metadata metadata2) {
                            CallTracingTransport.this.callTracer.reportCallEnded(status.isOk());
                            super.closed(status, metadata2);
                        }

                        @Override // io.grpc.internal.ForwardingClientStreamListener, io.grpc.internal.ClientStreamListener
                        public void closed(Status status, ClientStreamListener.RpcProgress rpcProgress, Metadata metadata2) {
                            CallTracingTransport.this.callTracer.reportCallEnded(status.isOk());
                            super.closed(status, rpcProgress, metadata2);
                        }
                    });
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class Callback {
        @ForOverride
        void a(InternalSubchannel internalSubchannel) {
        }

        @ForOverride
        void a(InternalSubchannel internalSubchannel, ConnectivityStateInfo connectivityStateInfo) {
        }

        @ForOverride
        void b(InternalSubchannel internalSubchannel) {
        }

        @ForOverride
        void c(InternalSubchannel internalSubchannel) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class Index {
        private List<EquivalentAddressGroup> addressGroups;
        private int addressIndex;
        private int groupIndex;

        public Index(List<EquivalentAddressGroup> list) {
            this.addressGroups = list;
        }

        public SocketAddress getCurrentAddress() {
            return this.addressGroups.get(this.groupIndex).getAddresses().get(this.addressIndex);
        }

        public Attributes getCurrentEagAttributes() {
            return this.addressGroups.get(this.groupIndex).getAttributes();
        }

        public List<EquivalentAddressGroup> getGroups() {
            return this.addressGroups;
        }

        public void increment() {
            EquivalentAddressGroup equivalentAddressGroup = this.addressGroups.get(this.groupIndex);
            this.addressIndex++;
            if (this.addressIndex >= equivalentAddressGroup.getAddresses().size()) {
                this.groupIndex++;
                this.addressIndex = 0;
            }
        }

        public boolean isAtBeginning() {
            return this.groupIndex == 0 && this.addressIndex == 0;
        }

        public boolean isValid() {
            return this.groupIndex < this.addressGroups.size();
        }

        public void reset() {
            this.groupIndex = 0;
            this.addressIndex = 0;
        }

        public boolean seekTo(SocketAddress socketAddress) {
            for (int i = 0; i < this.addressGroups.size(); i++) {
                int indexOf = this.addressGroups.get(i).getAddresses().indexOf(socketAddress);
                if (indexOf != -1) {
                    this.groupIndex = i;
                    this.addressIndex = indexOf;
                    return true;
                }
            }
            return false;
        }

        public void updateGroups(List<EquivalentAddressGroup> list) {
            this.addressGroups = list;
            reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class TransportListener implements ManagedClientTransport.Listener {
        final ConnectionClientTransport a;

        TransportListener(ConnectionClientTransport connectionClientTransport, SocketAddress socketAddress) {
            this.a = connectionClientTransport;
        }

        @Override // io.grpc.internal.ManagedClientTransport.Listener
        public void transportInUse(boolean z) {
            InternalSubchannel.this.handleTransportInUseState(this.a, z);
        }

        @Override // io.grpc.internal.ManagedClientTransport.Listener
        public void transportReady() {
            Status status;
            InternalSubchannel.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "READY");
            try {
                synchronized (InternalSubchannel.this.lock) {
                    status = InternalSubchannel.this.shutdownReason;
                    InternalSubchannel.this.reconnectPolicy = null;
                    if (status != null) {
                        Preconditions.checkState(InternalSubchannel.this.activeTransport == null, "Unexpected non-null activeTransport");
                    } else if (InternalSubchannel.this.pendingTransport == this.a) {
                        InternalSubchannel.this.gotoNonErrorState(ConnectivityState.READY);
                        InternalSubchannel.this.activeTransport = this.a;
                        InternalSubchannel.this.pendingTransport = null;
                    }
                }
                if (status != null) {
                    this.a.shutdown(status);
                }
            } finally {
                InternalSubchannel.this.syncContext.drain();
            }
        }

        @Override // io.grpc.internal.ManagedClientTransport.Listener
        public void transportShutdown(Status status) {
            InternalSubchannel.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "{0} SHUTDOWN with {1}", this.a.getLogId(), InternalSubchannel.this.printShortStatus(status));
            try {
                synchronized (InternalSubchannel.this.lock) {
                    if (InternalSubchannel.this.state.getState() == ConnectivityState.SHUTDOWN) {
                        return;
                    }
                    if (InternalSubchannel.this.activeTransport == this.a) {
                        InternalSubchannel.this.gotoNonErrorState(ConnectivityState.IDLE);
                        InternalSubchannel.this.activeTransport = null;
                        InternalSubchannel.this.addressIndex.reset();
                    } else if (InternalSubchannel.this.pendingTransport == this.a) {
                        Preconditions.checkState(InternalSubchannel.this.state.getState() == ConnectivityState.CONNECTING, "Expected state is CONNECTING, actual state is %s", InternalSubchannel.this.state.getState());
                        InternalSubchannel.this.addressIndex.increment();
                        if (InternalSubchannel.this.addressIndex.isValid()) {
                            InternalSubchannel.this.startNewTransport();
                        } else {
                            InternalSubchannel.this.pendingTransport = null;
                            InternalSubchannel.this.addressIndex.reset();
                            InternalSubchannel.this.scheduleBackoff(status);
                        }
                    }
                }
            } finally {
                InternalSubchannel.this.syncContext.drain();
            }
        }

        @Override // io.grpc.internal.ManagedClientTransport.Listener
        public void transportTerminated() {
            InternalSubchannel.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "{0} Terminated", this.a.getLogId());
            InternalSubchannel.this.channelz.removeClientSocket(this.a);
            InternalSubchannel.this.handleTransportInUseState(this.a, false);
            try {
                synchronized (InternalSubchannel.this.lock) {
                    InternalSubchannel.this.transports.remove(this.a);
                    if (InternalSubchannel.this.state.getState() == ConnectivityState.SHUTDOWN && InternalSubchannel.this.transports.isEmpty()) {
                        InternalSubchannel.this.handleTermination();
                    }
                }
                InternalSubchannel.this.syncContext.drain();
                Preconditions.checkState(InternalSubchannel.this.activeTransport != this.a, "activeTransport still points to this transport. Seems transportShutdown() was not called.");
            } catch (Throwable th) {
                InternalSubchannel.this.syncContext.drain();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class TransportLogger extends ChannelLogger {
        InternalLogId a;

        TransportLogger() {
        }

        @Override // io.grpc.ChannelLogger
        public void log(ChannelLogger.ChannelLogLevel channelLogLevel, String str) {
            ChannelLoggerImpl.a(this.a, channelLogLevel, str);
        }

        @Override // io.grpc.ChannelLogger
        public void log(ChannelLogger.ChannelLogLevel channelLogLevel, String str, Object... objArr) {
            ChannelLoggerImpl.a(this.a, channelLogLevel, str, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InternalSubchannel(List<EquivalentAddressGroup> list, String str, String str2, BackoffPolicy.Provider provider, ClientTransportFactory clientTransportFactory, ScheduledExecutorService scheduledExecutorService, Supplier<Stopwatch> supplier, SynchronizationContext synchronizationContext, Callback callback, InternalChannelz internalChannelz, CallTracer callTracer, ChannelTracer channelTracer, InternalLogId internalLogId, TimeProvider timeProvider) {
        Preconditions.checkNotNull(list, "addressGroups");
        Preconditions.checkArgument(!list.isEmpty(), "addressGroups is empty");
        checkListHasNoNulls(list, "addressGroups contains null entry");
        this.addressIndex = new Index(Collections.unmodifiableList(new ArrayList(list)));
        this.authority = str;
        this.userAgent = str2;
        this.backoffPolicyProvider = provider;
        this.transportFactory = clientTransportFactory;
        this.scheduledExecutor = scheduledExecutorService;
        this.connectingTimer = supplier.get();
        this.syncContext = synchronizationContext;
        this.callback = callback;
        this.channelz = internalChannelz;
        this.callsTracer = callTracer;
        this.channelTracer = (ChannelTracer) Preconditions.checkNotNull(channelTracer, "channelTracer");
        this.logId = InternalLogId.allocate("Subchannel", str);
        this.channelLogger = new ChannelLoggerImpl(channelTracer, timeProvider);
    }

    @GuardedBy("lock")
    private void cancelReconnectTask() {
        ScheduledFuture<?> scheduledFuture = this.reconnectTask;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.reconnectCanceled = true;
            this.reconnectTask = null;
            this.reconnectPolicy = null;
        }
    }

    private static void checkListHasNoNulls(List<?> list, String str) {
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            Preconditions.checkNotNull(it.next(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("lock")
    public void gotoNonErrorState(ConnectivityState connectivityState) {
        gotoState(ConnectivityStateInfo.forNonError(connectivityState));
    }

    @GuardedBy("lock")
    private void gotoState(final ConnectivityStateInfo connectivityStateInfo) {
        if (this.state.getState() != connectivityStateInfo.getState()) {
            Preconditions.checkState(this.state.getState() != ConnectivityState.SHUTDOWN, "Cannot transition out of SHUTDOWN to " + connectivityStateInfo);
            this.state = connectivityStateInfo;
            this.syncContext.executeLater(new Runnable() { // from class: io.grpc.internal.InternalSubchannel.2
                @Override // java.lang.Runnable
                public void run() {
                    InternalSubchannel.this.callback.a(InternalSubchannel.this, connectivityStateInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("lock")
    public void handleTermination() {
        this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Terminated");
        this.syncContext.executeLater(new Runnable() { // from class: io.grpc.internal.InternalSubchannel.3
            @Override // java.lang.Runnable
            public void run() {
                InternalSubchannel.this.callback.c(InternalSubchannel.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTransportInUseState(final ConnectionClientTransport connectionClientTransport, final boolean z) {
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.InternalSubchannel.4
            @Override // java.lang.Runnable
            public void run() {
                InternalSubchannel.this.inUseStateAggregator.updateObjectInUse(connectionClientTransport, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String printShortStatus(Status status) {
        StringBuilder sb = new StringBuilder();
        sb.append(status.getCode());
        if (status.getDescription() != null) {
            sb.append("(");
            sb.append(status.getDescription());
            sb.append(")");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("lock")
    public void scheduleBackoff(Status status) {
        gotoState(ConnectivityStateInfo.forTransientFailure(status));
        if (this.reconnectPolicy == null) {
            this.reconnectPolicy = this.backoffPolicyProvider.get();
        }
        long nextBackoffNanos = this.reconnectPolicy.nextBackoffNanos() - this.connectingTimer.elapsed(TimeUnit.NANOSECONDS);
        this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "TRANSIENT_FAILURE ({0}). Will reconnect after {1} ns", printShortStatus(status), Long.valueOf(nextBackoffNanos));
        Preconditions.checkState(this.reconnectTask == null, "previous reconnectTask is not done");
        this.reconnectCanceled = false;
        this.reconnectTask = this.scheduledExecutor.schedule(new LogExceptionRunnable(new Runnable() { // from class: io.grpc.internal.InternalSubchannel.1EndOfCurrentBackoff
            @Override // java.lang.Runnable
            public void run() {
                try {
                } finally {
                    try {
                    } finally {
                    }
                }
                synchronized (InternalSubchannel.this.lock) {
                    InternalSubchannel.this.reconnectTask = null;
                    if (InternalSubchannel.this.reconnectCanceled) {
                        return;
                    }
                    InternalSubchannel.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "CONNECTING after backoff");
                    InternalSubchannel.this.gotoNonErrorState(ConnectivityState.CONNECTING);
                    InternalSubchannel.this.startNewTransport();
                }
            }
        }), nextBackoffNanos, TimeUnit.NANOSECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("lock")
    public void startNewTransport() {
        SocketAddress socketAddress;
        HttpConnectProxiedSocketAddress httpConnectProxiedSocketAddress;
        Preconditions.checkState(this.reconnectTask == null, "Should have no reconnectTask scheduled");
        if (this.addressIndex.isAtBeginning()) {
            this.connectingTimer.reset().start();
        }
        SocketAddress currentAddress = this.addressIndex.getCurrentAddress();
        if (currentAddress instanceof HttpConnectProxiedSocketAddress) {
            httpConnectProxiedSocketAddress = (HttpConnectProxiedSocketAddress) currentAddress;
            socketAddress = httpConnectProxiedSocketAddress.getTargetAddress();
        } else {
            socketAddress = currentAddress;
            httpConnectProxiedSocketAddress = null;
        }
        ClientTransportFactory.ClientTransportOptions httpConnectProxiedSocketAddress2 = new ClientTransportFactory.ClientTransportOptions().setAuthority(this.authority).setEagAttributes(this.addressIndex.getCurrentEagAttributes()).setUserAgent(this.userAgent).setHttpConnectProxiedSocketAddress(httpConnectProxiedSocketAddress);
        TransportLogger transportLogger = new TransportLogger();
        transportLogger.a = getLogId();
        CallTracingTransport callTracingTransport = new CallTracingTransport(this.transportFactory.newClientTransport(socketAddress, httpConnectProxiedSocketAddress2, transportLogger), this.callsTracer);
        transportLogger.a = callTracingTransport.getLogId();
        this.channelz.addClientSocket(callTracingTransport);
        this.pendingTransport = callTracingTransport;
        this.transports.add(callTracingTransport);
        Runnable start = callTracingTransport.start(new TransportListener(callTracingTransport, socketAddress));
        if (start != null) {
            this.syncContext.executeLater(start);
        }
        this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Started transport {0}", transportLogger.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<EquivalentAddressGroup> a() {
        List<EquivalentAddressGroup> groups;
        try {
            synchronized (this.lock) {
                groups = this.addressIndex.getGroups();
            }
            return groups;
        } finally {
            this.syncContext.drain();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return this.authority;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelLogger c() {
        return this.channelLogger;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public ConnectivityState d() {
        ConnectivityState state;
        try {
            synchronized (this.lock) {
                state = this.state.getState();
            }
            return state;
        } finally {
            this.syncContext.drain();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public ClientTransport e() {
        return this.activeTransport;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public ClientTransport f() {
        ManagedClientTransport managedClientTransport = this.activeTransport;
        if (managedClientTransport != null) {
            return managedClientTransport;
        }
        try {
            synchronized (this.lock) {
                ManagedClientTransport managedClientTransport2 = this.activeTransport;
                if (managedClientTransport2 != null) {
                    return managedClientTransport2;
                }
                if (this.state.getState() == ConnectivityState.IDLE) {
                    this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "CONNECTING as requested");
                    gotoNonErrorState(ConnectivityState.CONNECTING);
                    startNewTransport();
                }
                this.syncContext.drain();
                return null;
            }
        } finally {
            this.syncContext.drain();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        try {
            synchronized (this.lock) {
                if (this.state.getState() != ConnectivityState.TRANSIENT_FAILURE) {
                    return;
                }
                cancelReconnectTask();
                this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "CONNECTING; backoff interrupted");
                gotoNonErrorState(ConnectivityState.CONNECTING);
                startNewTransport();
            }
        } finally {
            this.syncContext.drain();
        }
    }

    @Override // io.grpc.InternalWithLogId
    public InternalLogId getLogId() {
        return this.logId;
    }

    @Override // io.grpc.InternalInstrumented
    public ListenableFuture<InternalChannelz.ChannelStats> getStats() {
        List<EquivalentAddressGroup> groups;
        ArrayList arrayList;
        SettableFuture create = SettableFuture.create();
        InternalChannelz.ChannelStats.Builder builder = new InternalChannelz.ChannelStats.Builder();
        synchronized (this.lock) {
            groups = this.addressIndex.getGroups();
            arrayList = new ArrayList(this.transports);
        }
        builder.setTarget(groups.toString()).setState(d());
        builder.setSockets(arrayList);
        this.callsTracer.a(builder);
        this.channelTracer.a(builder);
        create.set(builder.build());
        return create;
    }

    public void shutdown(Status status) {
        try {
            synchronized (this.lock) {
                if (this.state.getState() == ConnectivityState.SHUTDOWN) {
                    return;
                }
                this.shutdownReason = status;
                gotoNonErrorState(ConnectivityState.SHUTDOWN);
                ManagedClientTransport managedClientTransport = this.activeTransport;
                ConnectionClientTransport connectionClientTransport = this.pendingTransport;
                this.activeTransport = null;
                this.pendingTransport = null;
                this.addressIndex.reset();
                if (this.transports.isEmpty()) {
                    handleTermination();
                }
                cancelReconnectTask();
                if (managedClientTransport != null) {
                    managedClientTransport.shutdown(status);
                }
                if (connectionClientTransport != null) {
                    connectionClientTransport.shutdown(status);
                }
            }
        } finally {
            this.syncContext.drain();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void shutdownNow(Status status) {
        ArrayList arrayList;
        shutdown(status);
        try {
            synchronized (this.lock) {
                arrayList = new ArrayList(this.transports);
            }
            this.syncContext.drain();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((ManagedClientTransport) it.next()).shutdownNow(status);
            }
        } catch (Throwable th) {
            this.syncContext.drain();
            throw th;
        }
    }

    public String toString() {
        List<EquivalentAddressGroup> groups;
        synchronized (this.lock) {
            groups = this.addressIndex.getGroups();
        }
        return MoreObjects.toStringHelper(this).add("logId", this.logId.getId()).add("addressGroups", groups).toString();
    }

    public void updateAddresses(List<EquivalentAddressGroup> list) {
        ManagedClientTransport managedClientTransport;
        Preconditions.checkNotNull(list, "newAddressGroups");
        checkListHasNoNulls(list, "newAddressGroups contains null entry");
        Preconditions.checkArgument(!list.isEmpty(), "newAddressGroups is empty");
        List<EquivalentAddressGroup> unmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        try {
            synchronized (this.lock) {
                SocketAddress currentAddress = this.addressIndex.getCurrentAddress();
                this.addressIndex.updateGroups(unmodifiableList);
                if ((this.state.getState() != ConnectivityState.READY && this.state.getState() != ConnectivityState.CONNECTING) || this.addressIndex.seekTo(currentAddress)) {
                    managedClientTransport = null;
                } else if (this.state.getState() == ConnectivityState.READY) {
                    managedClientTransport = this.activeTransport;
                    this.activeTransport = null;
                    this.addressIndex.reset();
                    gotoNonErrorState(ConnectivityState.IDLE);
                } else {
                    managedClientTransport = this.pendingTransport;
                    this.pendingTransport = null;
                    this.addressIndex.reset();
                    startNewTransport();
                }
            }
            if (managedClientTransport != null) {
                managedClientTransport.shutdown(Status.UNAVAILABLE.withDescription("InternalSubchannel closed transport due to address change"));
            }
        } finally {
            this.syncContext.drain();
        }
    }
}
