package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.Attributes;
import io.grpc.BinaryLog;
import io.grpc.CompressorRegistry;
import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.Decompressor;
import io.grpc.DecompressorRegistry;
import io.grpc.HandlerRegistry;
import io.grpc.InternalChannelz;
import io.grpc.InternalInstrumented;
import io.grpc.InternalLogId;
import io.grpc.InternalServerInterceptors;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.ServerMethodDefinition;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServerTransportFilter;
import io.grpc.Status;
import io.grpc.internal.StreamListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class ServerImpl extends Server implements InternalInstrumented<InternalChannelz.ServerStats> {

    @GuardedBy("lock")
    private int activeTransportServers;
    private final BinaryLog binlog;
    private final InternalChannelz channelz;
    private final CompressorRegistry compressorRegistry;
    private final DecompressorRegistry decompressorRegistry;
    private Executor executor;
    private final ObjectPool<? extends Executor> executorPool;
    private final HandlerRegistry fallbackRegistry;
    private final long handshakeTimeoutMillis;
    private final ServerInterceptor[] interceptors;
    private final InternalLogId logId;
    private final HandlerRegistry registry;
    private final Context rootContext;
    private final CallTracer serverCallTracer;

    @GuardedBy("lock")
    private boolean serverShutdownCallbackInvoked;

    @GuardedBy("lock")
    private boolean shutdown;

    @GuardedBy("lock")
    private Status shutdownNowStatus;

    @GuardedBy("lock")
    private boolean started;

    @GuardedBy("lock")
    private boolean terminated;
    private final List<ServerTransportFilter> transportFilters;
    private final List<? extends InternalServer> transportServers;

    @GuardedBy("lock")
    private boolean transportServersTerminated;
    private static final Logger log = Logger.getLogger(ServerImpl.class.getName());
    private static final ServerStreamListener NOOP_LISTENER = new NoopListener();
    private final Object lock = new Object();

    @GuardedBy("lock")
    private final Set<ServerTransport> transports = new HashSet();

    @VisibleForTesting
    /* loaded from: classes2.dex */
    static final class ContextCloser implements Runnable {
        private final Throwable cause;
        private final Context.CancellableContext context;

        ContextCloser(Context.CancellableContext cancellableContext, Throwable th) {
            this.context = cancellableContext;
            this.cause = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.context.cancel(this.cause);
        }
    }

    @VisibleForTesting
    /* loaded from: classes2.dex */
    static final class JumpToApplicationThreadServerStreamListener implements ServerStreamListener {
        private final Executor callExecutor;
        private final Executor cancelExecutor;
        private final Context.CancellableContext context;
        private ServerStreamListener listener;
        private final ServerStream stream;

        public JumpToApplicationThreadServerStreamListener(Executor executor, Executor executor2, ServerStream serverStream, Context.CancellableContext cancellableContext) {
            this.callExecutor = executor;
            this.cancelExecutor = executor2;
            this.stream = serverStream;
            this.context = cancellableContext;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ServerStreamListener getListener() {
            ServerStreamListener serverStreamListener = this.listener;
            if (serverStreamListener != null) {
                return serverStreamListener;
            }
            throw new IllegalStateException("listener unset");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void internalClose() {
            this.stream.close(Status.UNKNOWN, new Metadata());
        }

        @VisibleForTesting
        void a(ServerStreamListener serverStreamListener) {
            Preconditions.checkNotNull(serverStreamListener, "listener must not be null");
            Preconditions.checkState(this.listener == null, "Listener already set");
            this.listener = serverStreamListener;
        }

        @Override // io.grpc.internal.ServerStreamListener
        public void closed(final Status status) {
            if (!status.isOk()) {
                this.cancelExecutor.execute(new ContextCloser(this.context, status.getCause()));
            }
            this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ServerImpl.JumpToApplicationThreadServerStreamListener.1Closed
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(JumpToApplicationThreadServerStreamListener.this.context);
                }

                @Override // io.grpc.internal.ContextRunnable
                public void runInContext() {
                    JumpToApplicationThreadServerStreamListener.this.getListener().closed(status);
                }
            });
        }

        @Override // io.grpc.internal.ServerStreamListener
        public void halfClosed() {
            this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ServerImpl.JumpToApplicationThreadServerStreamListener.1HalfClosed
                {
                    Context.CancellableContext cancellableContext = JumpToApplicationThreadServerStreamListener.this.context;
                }

                @Override // io.grpc.internal.ContextRunnable
                public void runInContext() {
                    try {
                        JumpToApplicationThreadServerStreamListener.this.getListener().halfClosed();
                    } catch (Error e) {
                        JumpToApplicationThreadServerStreamListener.this.internalClose();
                        throw e;
                    } catch (RuntimeException e2) {
                        JumpToApplicationThreadServerStreamListener.this.internalClose();
                        throw e2;
                    }
                }
            });
        }

        @Override // io.grpc.internal.StreamListener
        public void messagesAvailable(final StreamListener.MessageProducer messageProducer) {
            this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ServerImpl.JumpToApplicationThreadServerStreamListener.1MessagesAvailable
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(JumpToApplicationThreadServerStreamListener.this.context);
                }

                @Override // io.grpc.internal.ContextRunnable
                public void runInContext() {
                    try {
                        JumpToApplicationThreadServerStreamListener.this.getListener().messagesAvailable(messageProducer);
                    } catch (Error e) {
                        JumpToApplicationThreadServerStreamListener.this.internalClose();
                        throw e;
                    } catch (RuntimeException e2) {
                        JumpToApplicationThreadServerStreamListener.this.internalClose();
                        throw e2;
                    }
                }
            });
        }

        @Override // io.grpc.internal.StreamListener
        public void onReady() {
            this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ServerImpl.JumpToApplicationThreadServerStreamListener.1OnReady
                {
                    Context.CancellableContext cancellableContext = JumpToApplicationThreadServerStreamListener.this.context;
                }

                @Override // io.grpc.internal.ContextRunnable
                public void runInContext() {
                    try {
                        JumpToApplicationThreadServerStreamListener.this.getListener().onReady();
                    } catch (Error e) {
                        JumpToApplicationThreadServerStreamListener.this.internalClose();
                        throw e;
                    } catch (RuntimeException e2) {
                        JumpToApplicationThreadServerStreamListener.this.internalClose();
                        throw e2;
                    }
                }
            });
        }
    }

    /* loaded from: classes2.dex */
    private static final class NoopListener implements ServerStreamListener {
        private NoopListener() {
        }

        @Override // io.grpc.internal.ServerStreamListener
        public void closed(Status status) {
        }

        @Override // io.grpc.internal.ServerStreamListener
        public void halfClosed() {
        }

        @Override // io.grpc.internal.StreamListener
        public void messagesAvailable(StreamListener.MessageProducer messageProducer) {
            while (true) {
                InputStream next = messageProducer.next();
                if (next == null) {
                    return;
                }
                try {
                    next.close();
                } catch (IOException e) {
                    while (true) {
                        InputStream next2 = messageProducer.next();
                        if (next2 == null) {
                            break;
                        }
                        try {
                            next2.close();
                        } catch (IOException e2) {
                            ServerImpl.log.log(Level.WARNING, "Exception closing stream", (Throwable) e2);
                        }
                    }
                    throw new RuntimeException(e);
                }
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void onReady() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class ServerListenerImpl implements ServerListener {
        private ServerListenerImpl() {
        }

        @Override // io.grpc.internal.ServerListener
        public void serverShutdown() {
            synchronized (ServerImpl.this.lock) {
                ServerImpl.p(ServerImpl.this);
                if (ServerImpl.this.activeTransportServers != 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList(ServerImpl.this.transports);
                Status status = ServerImpl.this.shutdownNowStatus;
                ServerImpl.this.serverShutdownCallbackInvoked = true;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ServerTransport serverTransport = (ServerTransport) it.next();
                    if (status == null) {
                        serverTransport.shutdown();
                    } else {
                        serverTransport.shutdownNow(status);
                    }
                }
                synchronized (ServerImpl.this.lock) {
                    ServerImpl.this.transportServersTerminated = true;
                    ServerImpl.this.checkForTermination();
                }
            }
        }

        @Override // io.grpc.internal.ServerListener
        public ServerTransportListener transportCreated(ServerTransport serverTransport) {
            synchronized (ServerImpl.this.lock) {
                ServerImpl.this.transports.add(serverTransport);
            }
            ServerTransportListenerImpl serverTransportListenerImpl = new ServerTransportListenerImpl(serverTransport);
            serverTransportListenerImpl.init();
            return serverTransportListenerImpl;
        }
    }

    /* loaded from: classes2.dex */
    private final class ServerTransportListenerImpl implements ServerTransportListener {
        private Attributes attributes;
        private Future<?> handshakeTimeoutFuture;
        private final ServerTransport transport;

        ServerTransportListenerImpl(ServerTransport serverTransport) {
            this.transport = serverTransport;
        }

        private Context.CancellableContext createContext(final ServerStream serverStream, Metadata metadata, StatsTraceContext statsTraceContext) {
            Long l = (Long) metadata.get(GrpcUtil.TIMEOUT_KEY);
            Context serverFilterContext = statsTraceContext.serverFilterContext(ServerImpl.this.rootContext);
            if (l == null) {
                return serverFilterContext.withCancellation();
            }
            Context.CancellableContext withDeadlineAfter = serverFilterContext.withDeadlineAfter(l.longValue(), TimeUnit.NANOSECONDS, this.transport.getScheduledExecutorService());
            withDeadlineAfter.addListener(new Context.CancellationListener(this) { // from class: io.grpc.internal.ServerImpl.ServerTransportListenerImpl.1ServerStreamCancellationListener
                @Override // io.grpc.Context.CancellationListener
                public void cancelled(Context context) {
                    Status statusFromCancelled = Contexts.statusFromCancelled(context);
                    if (Status.DEADLINE_EXCEEDED.getCode().equals(statusFromCancelled.getCode())) {
                        serverStream.cancel(statusFromCancelled);
                    }
                }
            }, MoreExecutors.directExecutor());
            return withDeadlineAfter;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public <ReqT, RespT> ServerStreamListener startCall(ServerStream serverStream, String str, ServerMethodDefinition<ReqT, RespT> serverMethodDefinition, Metadata metadata, Context.CancellableContext cancellableContext, StatsTraceContext statsTraceContext) {
            statsTraceContext.serverCallStarted(new ServerCallInfoImpl(serverMethodDefinition.getMethodDescriptor(), serverStream.getAttributes(), serverStream.getAuthority()));
            ServerCallHandler<ReqT, RespT> serverCallHandler = serverMethodDefinition.getServerCallHandler();
            for (ServerInterceptor serverInterceptor : ServerImpl.this.interceptors) {
                serverCallHandler = InternalServerInterceptors.interceptCallHandler(serverInterceptor, serverCallHandler);
            }
            ServerMethodDefinition<ReqT, RespT> withServerCallHandler = serverMethodDefinition.withServerCallHandler(serverCallHandler);
            if (ServerImpl.this.binlog != null) {
                withServerCallHandler = (ServerMethodDefinition<ReqT, RespT>) ServerImpl.this.binlog.wrapMethodDefinition(withServerCallHandler);
            }
            return startWrappedCall(str, withServerCallHandler, serverStream, metadata, cancellableContext);
        }

        private <WReqT, WRespT> ServerStreamListener startWrappedCall(String str, ServerMethodDefinition<WReqT, WRespT> serverMethodDefinition, ServerStream serverStream, Metadata metadata, Context.CancellableContext cancellableContext) {
            ServerCallImpl serverCallImpl = new ServerCallImpl(serverStream, serverMethodDefinition.getMethodDescriptor(), metadata, cancellableContext, ServerImpl.this.decompressorRegistry, ServerImpl.this.compressorRegistry, ServerImpl.this.serverCallTracer);
            ServerCall.Listener<WReqT> startCall = serverMethodDefinition.getServerCallHandler().startCall(serverCallImpl, metadata);
            if (startCall != null) {
                return serverCallImpl.a(startCall);
            }
            throw new NullPointerException("startCall() returned a null listener for method " + str);
        }

        public void init() {
            this.handshakeTimeoutFuture = ServerImpl.this.handshakeTimeoutMillis != Long.MAX_VALUE ? this.transport.getScheduledExecutorService().schedule(new Runnable() { // from class: io.grpc.internal.ServerImpl.ServerTransportListenerImpl.1TransportShutdownNow
                @Override // java.lang.Runnable
                public void run() {
                    ServerTransportListenerImpl.this.transport.shutdownNow(Status.CANCELLED.withDescription("Handshake timeout exceeded"));
                }
            }, ServerImpl.this.handshakeTimeoutMillis, TimeUnit.MILLISECONDS) : new FutureTask<>(new Runnable(this) { // from class: io.grpc.internal.ServerImpl.ServerTransportListenerImpl.1
                @Override // java.lang.Runnable
                public void run() {
                }
            }, null);
            ServerImpl.this.channelz.addServerSocket(ServerImpl.this, this.transport);
        }

        @Override // io.grpc.internal.ServerTransportListener
        public void streamCreated(ServerStream serverStream, String str, Metadata metadata) {
            if (metadata.containsKey(GrpcUtil.MESSAGE_ENCODING_KEY)) {
                String str2 = (String) metadata.get(GrpcUtil.MESSAGE_ENCODING_KEY);
                Decompressor lookupDecompressor = ServerImpl.this.decompressorRegistry.lookupDecompressor(str2);
                if (lookupDecompressor == null) {
                    serverStream.close(Status.UNIMPLEMENTED.withDescription(String.format("Can't find decompressor for %s", str2)), new Metadata());
                    return;
                }
                serverStream.setDecompressor(lookupDecompressor);
            }
            StatsTraceContext statsTraceContext = (StatsTraceContext) Preconditions.checkNotNull(serverStream.statsTraceContext(), "statsTraceCtx not present from stream");
            Context.CancellableContext createContext = createContext(serverStream, metadata, statsTraceContext);
            Executor serializeReentrantCallsDirectExecutor = ServerImpl.this.executor == MoreExecutors.directExecutor() ? new SerializeReentrantCallsDirectExecutor() : new SerializingExecutor(ServerImpl.this.executor);
            JumpToApplicationThreadServerStreamListener jumpToApplicationThreadServerStreamListener = new JumpToApplicationThreadServerStreamListener(serializeReentrantCallsDirectExecutor, ServerImpl.this.executor, serverStream, createContext);
            serverStream.setListener(jumpToApplicationThreadServerStreamListener);
            serializeReentrantCallsDirectExecutor.execute(new ContextRunnable(createContext, str, serverStream, metadata, statsTraceContext, jumpToApplicationThreadServerStreamListener) { // from class: io.grpc.internal.ServerImpl.ServerTransportListenerImpl.1StreamCreated
                final /* synthetic */ Context.CancellableContext a;
                final /* synthetic */ String b;
                final /* synthetic */ ServerStream c;
                final /* synthetic */ Metadata d;
                final /* synthetic */ StatsTraceContext e;
                final /* synthetic */ JumpToApplicationThreadServerStreamListener f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(createContext);
                    this.a = createContext;
                    this.b = str;
                    this.c = serverStream;
                    this.d = metadata;
                    this.e = statsTraceContext;
                    this.f = jumpToApplicationThreadServerStreamListener;
                }

                @Override // io.grpc.internal.ContextRunnable
                public void runInContext() {
                    ServerStreamListener serverStreamListener = ServerImpl.NOOP_LISTENER;
                    try {
                        try {
                            try {
                                ServerMethodDefinition<?, ?> lookupMethod = ServerImpl.this.registry.lookupMethod(this.b);
                                if (lookupMethod == null) {
                                    lookupMethod = ServerImpl.this.fallbackRegistry.lookupMethod(this.b, this.c.getAuthority());
                                }
                                ServerMethodDefinition<?, ?> serverMethodDefinition = lookupMethod;
                                if (serverMethodDefinition != null) {
                                    this.f.a(ServerTransportListenerImpl.this.startCall(this.c, this.b, serverMethodDefinition, this.d, this.a, this.e));
                                    return;
                                }
                                this.c.close(Status.UNIMPLEMENTED.withDescription("Method not found: " + this.b), new Metadata());
                                this.a.cancel(null);
                            } catch (RuntimeException e) {
                                this.c.close(Status.fromThrowable(e), new Metadata());
                                this.a.cancel(null);
                                throw e;
                            }
                        } catch (Error e2) {
                            this.c.close(Status.fromThrowable(e2), new Metadata());
                            this.a.cancel(null);
                            throw e2;
                        }
                    } finally {
                        this.f.a(serverStreamListener);
                    }
                }
            });
        }

        @Override // io.grpc.internal.ServerTransportListener
        public Attributes transportReady(Attributes attributes) {
            this.handshakeTimeoutFuture.cancel(false);
            this.handshakeTimeoutFuture = null;
            for (ServerTransportFilter serverTransportFilter : ServerImpl.this.transportFilters) {
                attributes = (Attributes) Preconditions.checkNotNull(serverTransportFilter.transportReady(attributes), "Filter %s returned null", serverTransportFilter);
            }
            this.attributes = attributes;
            return attributes;
        }

        @Override // io.grpc.internal.ServerTransportListener
        public void transportTerminated() {
            Future<?> future = this.handshakeTimeoutFuture;
            if (future != null) {
                future.cancel(false);
                this.handshakeTimeoutFuture = null;
            }
            Iterator it = ServerImpl.this.transportFilters.iterator();
            while (it.hasNext()) {
                ((ServerTransportFilter) it.next()).transportTerminated(this.attributes);
            }
            ServerImpl.this.transportClosed(this.transport);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServerImpl(AbstractServerImplBuilder<?> abstractServerImplBuilder, List<? extends InternalServer> list, Context context) {
        this.executorPool = (ObjectPool) Preconditions.checkNotNull(abstractServerImplBuilder.e, "executorPool");
        this.registry = (HandlerRegistry) Preconditions.checkNotNull(abstractServerImplBuilder.a.a(), "registryBuilder");
        this.fallbackRegistry = (HandlerRegistry) Preconditions.checkNotNull(abstractServerImplBuilder.d, "fallbackRegistry");
        Preconditions.checkNotNull(list, "transportServers");
        Preconditions.checkArgument(!list.isEmpty(), "no servers provided");
        this.transportServers = new ArrayList(list);
        this.logId = InternalLogId.allocate("Server", String.valueOf(getListenSocketsIgnoringLifecycle()));
        this.rootContext = ((Context) Preconditions.checkNotNull(context, "rootContext")).fork();
        this.decompressorRegistry = abstractServerImplBuilder.f;
        this.compressorRegistry = abstractServerImplBuilder.g;
        this.transportFilters = Collections.unmodifiableList(new ArrayList(abstractServerImplBuilder.b));
        List<ServerInterceptor> list2 = abstractServerImplBuilder.c;
        this.interceptors = (ServerInterceptor[]) list2.toArray(new ServerInterceptor[list2.size()]);
        this.handshakeTimeoutMillis = abstractServerImplBuilder.h;
        this.binlog = abstractServerImplBuilder.i;
        this.channelz = abstractServerImplBuilder.j;
        this.serverCallTracer = abstractServerImplBuilder.k.create();
        this.channelz.addServer(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkForTermination() {
        synchronized (this.lock) {
            if (this.shutdown && this.transports.isEmpty() && this.transportServersTerminated) {
                if (this.terminated) {
                    throw new AssertionError("Server already terminated");
                }
                this.terminated = true;
                this.channelz.removeServer(this);
                if (this.executor != null) {
                    this.executor = this.executorPool.returnObject(this.executor);
                }
                this.lock.notifyAll();
            }
        }
    }

    private List<SocketAddress> getListenSocketsIgnoringLifecycle() {
        List<SocketAddress> unmodifiableList;
        synchronized (this.lock) {
            ArrayList arrayList = new ArrayList(this.transportServers.size());
            Iterator<? extends InternalServer> it = this.transportServers.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getListenSocketAddress());
            }
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return unmodifiableList;
    }

    static /* synthetic */ int p(ServerImpl serverImpl) {
        int i = serverImpl.activeTransportServers;
        serverImpl.activeTransportServers = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void transportClosed(ServerTransport serverTransport) {
        synchronized (this.lock) {
            if (!this.transports.remove(serverTransport)) {
                throw new AssertionError("Transport already removed");
            }
            this.channelz.removeServerSocket(this, serverTransport);
            checkForTermination();
        }
    }

    @Override // io.grpc.Server
    public void awaitTermination() {
        synchronized (this.lock) {
            while (!this.terminated) {
                this.lock.wait();
            }
        }
    }

    @Override // io.grpc.Server
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        boolean z;
        synchronized (this.lock) {
            long nanoTime = System.nanoTime() + timeUnit.toNanos(j);
            while (!this.terminated) {
                long nanoTime2 = nanoTime - System.nanoTime();
                if (nanoTime2 <= 0) {
                    break;
                }
                TimeUnit.NANOSECONDS.timedWait(this.lock, nanoTime2);
            }
            z = this.terminated;
        }
        return z;
    }

    @Override // io.grpc.Server
    public List<ServerServiceDefinition> getImmutableServices() {
        return this.registry.getServices();
    }

    @Override // io.grpc.Server
    public List<SocketAddress> getListenSockets() {
        List<SocketAddress> listenSocketsIgnoringLifecycle;
        synchronized (this.lock) {
            Preconditions.checkState(this.started, "Not started");
            Preconditions.checkState(!this.terminated, "Already terminated");
            listenSocketsIgnoringLifecycle = getListenSocketsIgnoringLifecycle();
        }
        return listenSocketsIgnoringLifecycle;
    }

    @Override // io.grpc.InternalWithLogId
    public InternalLogId getLogId() {
        return this.logId;
    }

    @Override // io.grpc.Server
    public List<ServerServiceDefinition> getMutableServices() {
        return Collections.unmodifiableList(this.fallbackRegistry.getServices());
    }

    @Override // io.grpc.Server
    public int getPort() {
        synchronized (this.lock) {
            Preconditions.checkState(this.started, "Not started");
            Preconditions.checkState(!this.terminated, "Already terminated");
            Iterator<? extends InternalServer> it = this.transportServers.iterator();
            while (it.hasNext()) {
                SocketAddress listenSocketAddress = it.next().getListenSocketAddress();
                if (listenSocketAddress instanceof InetSocketAddress) {
                    return ((InetSocketAddress) listenSocketAddress).getPort();
                }
            }
            return -1;
        }
    }

    @Override // io.grpc.Server
    public List<ServerServiceDefinition> getServices() {
        List<ServerServiceDefinition> services = this.fallbackRegistry.getServices();
        if (services.isEmpty()) {
            return this.registry.getServices();
        }
        List<ServerServiceDefinition> services2 = this.registry.getServices();
        ArrayList arrayList = new ArrayList(services2.size() + services.size());
        arrayList.addAll(services2);
        arrayList.addAll(services);
        return Collections.unmodifiableList(arrayList);
    }

    @Override // io.grpc.InternalInstrumented
    public ListenableFuture<InternalChannelz.ServerStats> getStats() {
        InternalChannelz.ServerStats.Builder builder = new InternalChannelz.ServerStats.Builder();
        Iterator<? extends InternalServer> it = this.transportServers.iterator();
        while (it.hasNext()) {
            InternalInstrumented<InternalChannelz.SocketStats> listenSocketStats = it.next().getListenSocketStats();
            if (listenSocketStats != null) {
                builder.addListenSockets(Collections.singletonList(listenSocketStats));
            }
        }
        this.serverCallTracer.a(builder);
        SettableFuture create = SettableFuture.create();
        create.set(builder.build());
        return create;
    }

    @Override // io.grpc.Server
    public boolean isShutdown() {
        boolean z;
        synchronized (this.lock) {
            z = this.shutdown;
        }
        return z;
    }

    @Override // io.grpc.Server
    public boolean isTerminated() {
        boolean z;
        synchronized (this.lock) {
            z = this.terminated;
        }
        return z;
    }

    @Override // io.grpc.Server
    public ServerImpl shutdown() {
        synchronized (this.lock) {
            if (this.shutdown) {
                return this;
            }
            this.shutdown = true;
            boolean z = this.started;
            if (!z) {
                this.transportServersTerminated = true;
                checkForTermination();
            }
            if (z) {
                Iterator<? extends InternalServer> it = this.transportServers.iterator();
                while (it.hasNext()) {
                    it.next().shutdown();
                }
            }
            return this;
        }
    }

    @Override // io.grpc.Server
    public ServerImpl shutdownNow() {
        shutdown();
        Status withDescription = Status.UNAVAILABLE.withDescription("Server shutdownNow invoked");
        synchronized (this.lock) {
            if (this.shutdownNowStatus != null) {
                return this;
            }
            this.shutdownNowStatus = withDescription;
            ArrayList arrayList = new ArrayList(this.transports);
            boolean z = this.serverShutdownCallbackInvoked;
            if (z) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((ServerTransport) it.next()).shutdownNow(withDescription);
                }
            }
            return this;
        }
    }

    @Override // io.grpc.Server
    public ServerImpl start() {
        synchronized (this.lock) {
            Preconditions.checkState(!this.started, "Already started");
            Preconditions.checkState(this.shutdown ? false : true, "Shutting down");
            ServerListenerImpl serverListenerImpl = new ServerListenerImpl();
            Iterator<? extends InternalServer> it = this.transportServers.iterator();
            while (it.hasNext()) {
                it.next().start(serverListenerImpl);
                this.activeTransportServers++;
            }
            this.executor = (Executor) Preconditions.checkNotNull(this.executorPool.getObject(), "executor");
            this.started = true;
        }
        return this;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("logId", this.logId.getId()).add("transportServers", this.transportServers).toString();
    }
}
