package io.grpc.inprocess;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.Compressor;
import io.grpc.Deadline;
import io.grpc.Decompressor;
import io.grpc.DecompressorRegistry;
import io.grpc.Grpc;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import io.grpc.InternalMetadata;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.SecurityLevel;
import io.grpc.ServerStreamTracer;
import io.grpc.Status;
import io.grpc.internal.ClientStream;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.ClientTransport;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.GrpcAttributes;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.InUseStateAggregator;
import io.grpc.internal.ManagedClientTransport;
import io.grpc.internal.NoopClientStream;
import io.grpc.internal.ObjectPool;
import io.grpc.internal.ServerStream;
import io.grpc.internal.ServerStreamListener;
import io.grpc.internal.ServerTransport;
import io.grpc.internal.ServerTransportListener;
import io.grpc.internal.StatsTraceContext;
import io.grpc.internal.StreamListener;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: Access modifiers changed from: package-private */
@ThreadSafe
/* loaded from: classes.dex */
public final class InProcessTransport implements ServerTransport, ConnectionClientTransport {
    private static final Logger log = Logger.getLogger(InProcessTransport.class.getName());
    private final Attributes attributes;
    private final String authority;
    private final int clientMaxInboundMetadataSize;
    private ManagedClientTransport.Listener clientTransportListener;
    private final InternalLogId logId;
    private final String name;
    private int serverMaxInboundMetadataSize;
    private ScheduledExecutorService serverScheduler;
    private ObjectPool<ScheduledExecutorService> serverSchedulerPool;
    private Attributes serverStreamAttributes;

    @GuardedBy("this")
    private List<ServerStreamTracer.Factory> serverStreamTracerFactories;
    private ServerTransportListener serverTransportListener;

    @GuardedBy("this")
    private boolean shutdown;

    @GuardedBy("this")
    private Status shutdownStatus;

    @GuardedBy("this")
    private boolean terminated;
    private final String userAgent;

    @GuardedBy("this")
    private Set<InProcessStream> streams = new HashSet();

    @GuardedBy("this")
    private final InUseStateAggregator<InProcessStream> inUseState = new InUseStateAggregator<InProcessStream>() { // from class: io.grpc.inprocess.InProcessTransport.1
        @Override // io.grpc.internal.InUseStateAggregator
        protected void a() {
            InProcessTransport.this.clientTransportListener.transportInUse(true);
        }

        @Override // io.grpc.internal.InUseStateAggregator
        protected void b() {
            InProcessTransport.this.clientTransportListener.transportInUse(false);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class InProcessStream {
        private volatile String authority;
        private final CallOptions callOptions;
        private final InProcessClientStream clientStream;
        private final Metadata headers;
        private final MethodDescriptor<?, ?> method;
        private final InProcessServerStream serverStream;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public class InProcessClientStream implements ClientStream {
            final StatsTraceContext a;
            final CallOptions b;

            @GuardedBy("this")
            private boolean closed;

            @GuardedBy("this")
            private int outboundSeqNo;

            @GuardedBy("this")
            private boolean serverNotifyHalfClose;

            @GuardedBy("this")
            private ArrayDeque<StreamListener.MessageProducer> serverReceiveQueue = new ArrayDeque<>();

            @GuardedBy("this")
            private int serverRequested;

            @GuardedBy("this")
            private ServerStreamListener serverStreamListener;

            InProcessClientStream(CallOptions callOptions, Metadata metadata) {
                this.b = callOptions;
                this.a = StatsTraceContext.newClientContext(callOptions, InProcessTransport.this.attributes, metadata);
            }

            private synchronized boolean internalCancel(Status status, Status status2) {
                if (this.closed) {
                    return false;
                }
                this.closed = true;
                while (true) {
                    StreamListener.MessageProducer poll = this.serverReceiveQueue.poll();
                    if (poll == null) {
                        InProcessStream.this.serverStream.a.streamClosed(status2);
                        this.serverStreamListener.closed(status);
                        return true;
                    }
                    while (true) {
                        InputStream next = poll.next();
                        if (next != null) {
                            try {
                                next.close();
                            } catch (Throwable th) {
                                InProcessTransport.log.log(Level.WARNING, "Exception closing stream", th);
                            }
                        }
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void serverClosed(Status status, Status status2) {
                internalCancel(status, status2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public synchronized boolean serverRequested(int i) {
                boolean z = false;
                if (this.closed) {
                    return false;
                }
                boolean z2 = this.serverRequested > 0;
                this.serverRequested += i;
                while (this.serverRequested > 0 && !this.serverReceiveQueue.isEmpty()) {
                    this.serverRequested--;
                    this.serverStreamListener.messagesAvailable(this.serverReceiveQueue.poll());
                }
                if (this.serverReceiveQueue.isEmpty() && this.serverNotifyHalfClose) {
                    this.serverNotifyHalfClose = false;
                    this.serverStreamListener.halfClosed();
                }
                boolean z3 = this.serverRequested > 0;
                if (!z2 && z3) {
                    z = true;
                }
                return z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public synchronized void setListener(ServerStreamListener serverStreamListener) {
                this.serverStreamListener = serverStreamListener;
            }

            @Override // io.grpc.internal.ClientStream
            public void cancel(Status status) {
                Status stripCause = InProcessTransport.stripCause(status);
                if (internalCancel(stripCause, stripCause)) {
                    InProcessStream.this.serverStream.clientCancelled(status);
                    InProcessStream.this.streamClosed();
                }
            }

            @Override // io.grpc.internal.Stream
            public void flush() {
            }

            @Override // io.grpc.internal.ClientStream
            public Attributes getAttributes() {
                return Attributes.EMPTY;
            }

            @Override // io.grpc.internal.ClientStream
            public synchronized void halfClose() {
                if (this.closed) {
                    return;
                }
                if (this.serverReceiveQueue.isEmpty()) {
                    this.serverStreamListener.halfClosed();
                } else {
                    this.serverNotifyHalfClose = true;
                }
            }

            @Override // io.grpc.internal.Stream
            public synchronized boolean isReady() {
                if (this.closed) {
                    return false;
                }
                return this.serverRequested > 0;
            }

            @Override // io.grpc.internal.Stream
            public void request(int i) {
                if (InProcessStream.this.serverStream.clientRequested(i)) {
                    synchronized (this) {
                        if (!this.closed) {
                            this.serverStreamListener.onReady();
                        }
                    }
                }
            }

            @Override // io.grpc.internal.ClientStream
            public void setAuthority(String str) {
                InProcessStream.this.authority = str;
            }

            @Override // io.grpc.internal.Stream
            public void setCompressor(Compressor compressor) {
            }

            @Override // io.grpc.internal.ClientStream
            public void setDeadline(Deadline deadline) {
                InProcessStream.this.headers.discardAll(GrpcUtil.TIMEOUT_KEY);
                InProcessStream.this.headers.put(GrpcUtil.TIMEOUT_KEY, Long.valueOf(Math.max(0L, deadline.timeRemaining(TimeUnit.NANOSECONDS))));
            }

            @Override // io.grpc.internal.ClientStream
            public void setDecompressorRegistry(DecompressorRegistry decompressorRegistry) {
            }

            @Override // io.grpc.internal.ClientStream
            public void setFullStreamDecompression(boolean z) {
            }

            @Override // io.grpc.internal.ClientStream
            public void setMaxInboundMessageSize(int i) {
            }

            @Override // io.grpc.internal.ClientStream
            public void setMaxOutboundMessageSize(int i) {
            }

            @Override // io.grpc.internal.Stream
            public void setMessageCompression(boolean z) {
            }

            @Override // io.grpc.internal.ClientStream
            public void start(ClientStreamListener clientStreamListener) {
                InProcessStream.this.serverStream.setListener(clientStreamListener);
                synchronized (InProcessTransport.this) {
                    this.a.clientOutboundHeaders();
                    InProcessTransport.this.streams.add(InProcessStream.this);
                    if (GrpcUtil.shouldBeCountedForInUse(this.b)) {
                        InProcessTransport.this.inUseState.updateObjectInUse(InProcessStream.this, true);
                    }
                    InProcessTransport.this.serverTransportListener.streamCreated(InProcessStream.this.serverStream, InProcessStream.this.method.getFullMethodName(), InProcessStream.this.headers);
                }
            }

            @Override // io.grpc.internal.Stream
            public synchronized void writeMessage(InputStream inputStream) {
                if (this.closed) {
                    return;
                }
                this.a.outboundMessage(this.outboundSeqNo);
                this.a.outboundMessageSent(this.outboundSeqNo, -1L, -1L);
                InProcessStream.this.serverStream.a.inboundMessage(this.outboundSeqNo);
                InProcessStream.this.serverStream.a.inboundMessageRead(this.outboundSeqNo, -1L, -1L);
                this.outboundSeqNo++;
                SingleMessageProducer singleMessageProducer = new SingleMessageProducer(inputStream);
                if (this.serverRequested > 0) {
                    this.serverRequested--;
                    this.serverStreamListener.messagesAvailable(singleMessageProducer);
                } else {
                    this.serverReceiveQueue.add(singleMessageProducer);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public class InProcessServerStream implements ServerStream {
            final StatsTraceContext a;

            @GuardedBy("this")
            private Status clientNotifyStatus;

            @GuardedBy("this")
            private Metadata clientNotifyTrailers;

            @GuardedBy("this")
            private ArrayDeque<StreamListener.MessageProducer> clientReceiveQueue = new ArrayDeque<>();

            @GuardedBy("this")
            private int clientRequested;

            @GuardedBy("this")
            private ClientStreamListener clientStreamListener;

            @GuardedBy("this")
            private boolean closed;

            @GuardedBy("this")
            private int outboundSeqNo;

            InProcessServerStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata) {
                this.a = StatsTraceContext.newServerContext(InProcessTransport.this.serverStreamTracerFactories, methodDescriptor.getFullMethodName(), metadata);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clientCancelled(Status status) {
                internalCancel(status);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public synchronized boolean clientRequested(int i) {
                boolean z = false;
                if (this.closed) {
                    return false;
                }
                boolean z2 = this.clientRequested > 0;
                this.clientRequested += i;
                while (this.clientRequested > 0 && !this.clientReceiveQueue.isEmpty()) {
                    this.clientRequested--;
                    this.clientStreamListener.messagesAvailable(this.clientReceiveQueue.poll());
                }
                if (this.closed) {
                    return false;
                }
                if (this.clientReceiveQueue.isEmpty() && this.clientNotifyStatus != null) {
                    this.closed = true;
                    InProcessStream.this.clientStream.a.clientInboundTrailers(this.clientNotifyTrailers);
                    InProcessStream.this.clientStream.a.streamClosed(this.clientNotifyStatus);
                    this.clientStreamListener.closed(this.clientNotifyStatus, this.clientNotifyTrailers);
                }
                boolean z3 = this.clientRequested > 0;
                if (!z2 && z3) {
                    z = true;
                }
                return z;
            }

            private synchronized boolean internalCancel(Status status) {
                if (this.closed) {
                    return false;
                }
                this.closed = true;
                while (true) {
                    StreamListener.MessageProducer poll = this.clientReceiveQueue.poll();
                    if (poll == null) {
                        InProcessStream.this.clientStream.a.streamClosed(status);
                        this.clientStreamListener.closed(status, new Metadata());
                        return true;
                    }
                    while (true) {
                        InputStream next = poll.next();
                        if (next != null) {
                            try {
                                next.close();
                            } catch (Throwable th) {
                                InProcessTransport.log.log(Level.WARNING, "Exception closing stream", th);
                            }
                        }
                    }
                }
            }

            private void notifyClientClose(Status status, Metadata metadata) {
                Status stripCause = InProcessTransport.stripCause(status);
                synchronized (this) {
                    if (this.closed) {
                        return;
                    }
                    if (this.clientReceiveQueue.isEmpty()) {
                        this.closed = true;
                        InProcessStream.this.clientStream.a.clientInboundTrailers(metadata);
                        InProcessStream.this.clientStream.a.streamClosed(stripCause);
                        this.clientStreamListener.closed(stripCause, metadata);
                    } else {
                        this.clientNotifyStatus = stripCause;
                        this.clientNotifyTrailers = metadata;
                    }
                    InProcessStream.this.streamClosed();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public synchronized void setListener(ClientStreamListener clientStreamListener) {
                this.clientStreamListener = clientStreamListener;
            }

            @Override // io.grpc.internal.ServerStream
            public void cancel(Status status) {
                if (internalCancel(Status.CANCELLED.withDescription("server cancelled stream"))) {
                    InProcessStream.this.clientStream.serverClosed(status, status);
                    InProcessStream.this.streamClosed();
                }
            }

            @Override // io.grpc.internal.ServerStream
            public void close(Status status, Metadata metadata) {
                InProcessStream.this.clientStream.serverClosed(Status.OK, status);
                if (InProcessTransport.this.clientMaxInboundMetadataSize != Integer.MAX_VALUE) {
                    int metadataSize = InProcessTransport.metadataSize(metadata) + (status.getDescription() == null ? 0 : status.getDescription().length());
                    if (metadataSize > InProcessTransport.this.clientMaxInboundMetadataSize) {
                        status = Status.RESOURCE_EXHAUSTED.withDescription(String.format("Response header metadata larger than %d: %d", Integer.valueOf(InProcessTransport.this.clientMaxInboundMetadataSize), Integer.valueOf(metadataSize)));
                        metadata = new Metadata();
                    }
                }
                notifyClientClose(status, metadata);
            }

            @Override // io.grpc.internal.Stream
            public void flush() {
            }

            @Override // io.grpc.internal.ServerStream
            public Attributes getAttributes() {
                return InProcessTransport.this.serverStreamAttributes;
            }

            @Override // io.grpc.internal.ServerStream
            public String getAuthority() {
                return InProcessStream.this.authority;
            }

            @Override // io.grpc.internal.Stream
            public synchronized boolean isReady() {
                if (this.closed) {
                    return false;
                }
                return this.clientRequested > 0;
            }

            @Override // io.grpc.internal.Stream
            public void request(int i) {
                if (InProcessStream.this.clientStream.serverRequested(i)) {
                    synchronized (this) {
                        if (!this.closed) {
                            this.clientStreamListener.onReady();
                        }
                    }
                }
            }

            @Override // io.grpc.internal.Stream
            public void setCompressor(Compressor compressor) {
            }

            @Override // io.grpc.internal.ServerStream
            public void setDecompressor(Decompressor decompressor) {
            }

            @Override // io.grpc.internal.ServerStream
            public void setListener(ServerStreamListener serverStreamListener) {
                InProcessStream.this.clientStream.setListener(serverStreamListener);
            }

            @Override // io.grpc.internal.Stream
            public void setMessageCompression(boolean z) {
            }

            @Override // io.grpc.internal.ServerStream
            public StatsTraceContext statsTraceContext() {
                return this.a;
            }

            @Override // io.grpc.internal.ServerStream
            public void writeHeaders(Metadata metadata) {
                int metadataSize;
                if (InProcessTransport.this.clientMaxInboundMetadataSize != Integer.MAX_VALUE && (metadataSize = InProcessTransport.metadataSize(metadata)) > InProcessTransport.this.clientMaxInboundMetadataSize) {
                    Status withDescription = Status.CANCELLED.withDescription("Client cancelled the RPC");
                    InProcessStream.this.clientStream.serverClosed(withDescription, withDescription);
                    notifyClientClose(Status.RESOURCE_EXHAUSTED.withDescription(String.format("Response header metadata larger than %d: %d", Integer.valueOf(InProcessTransport.this.clientMaxInboundMetadataSize), Integer.valueOf(metadataSize))), new Metadata());
                } else {
                    synchronized (this) {
                        if (this.closed) {
                            return;
                        }
                        InProcessStream.this.clientStream.a.clientInboundHeaders();
                        this.clientStreamListener.headersRead(metadata);
                    }
                }
            }

            @Override // io.grpc.internal.Stream
            public synchronized void writeMessage(InputStream inputStream) {
                if (this.closed) {
                    return;
                }
                this.a.outboundMessage(this.outboundSeqNo);
                this.a.outboundMessageSent(this.outboundSeqNo, -1L, -1L);
                InProcessStream.this.clientStream.a.inboundMessage(this.outboundSeqNo);
                InProcessStream.this.clientStream.a.inboundMessageRead(this.outboundSeqNo, -1L, -1L);
                this.outboundSeqNo++;
                SingleMessageProducer singleMessageProducer = new SingleMessageProducer(inputStream);
                if (this.clientRequested > 0) {
                    this.clientRequested--;
                    this.clientStreamListener.messagesAvailable(singleMessageProducer);
                } else {
                    this.clientReceiveQueue.add(singleMessageProducer);
                }
            }
        }

        private InProcessStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions, String str) {
            this.method = (MethodDescriptor) Preconditions.checkNotNull(methodDescriptor, FirebaseAnalytics.Param.METHOD);
            this.headers = (Metadata) Preconditions.checkNotNull(metadata, "headers");
            this.callOptions = (CallOptions) Preconditions.checkNotNull(callOptions, "callOptions");
            this.authority = str;
            this.clientStream = new InProcessClientStream(callOptions, metadata);
            this.serverStream = new InProcessServerStream(methodDescriptor, metadata);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void streamClosed() {
            synchronized (InProcessTransport.this) {
                boolean remove = InProcessTransport.this.streams.remove(this);
                if (GrpcUtil.shouldBeCountedForInUse(this.callOptions)) {
                    InProcessTransport.this.inUseState.updateObjectInUse(this, false);
                }
                if (InProcessTransport.this.streams.isEmpty() && remove && InProcessTransport.this.shutdown) {
                    InProcessTransport.this.notifyTerminated();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class SingleMessageProducer implements StreamListener.MessageProducer {
        private InputStream message;

        private SingleMessageProducer(InputStream inputStream) {
            this.message = inputStream;
        }

        @Override // io.grpc.internal.StreamListener.MessageProducer
        @Nullable
        public InputStream next() {
            InputStream inputStream = this.message;
            this.message = null;
            return inputStream;
        }
    }

    public InProcessTransport(String str, int i, String str2, String str3, Attributes attributes) {
        this.name = str;
        this.clientMaxInboundMetadataSize = i;
        this.authority = str2;
        this.userAgent = GrpcUtil.getGrpcUserAgent("inprocess", str3);
        Preconditions.checkNotNull(attributes, "eagAttrs");
        this.attributes = Attributes.newBuilder().set(GrpcAttributes.ATTR_SECURITY_LEVEL, SecurityLevel.PRIVACY_AND_INTEGRITY).set(GrpcAttributes.ATTR_CLIENT_EAG_ATTRS, attributes).build();
        this.logId = InternalLogId.allocate((Class<?>) InProcessTransport.class, str);
    }

    private ClientStream failedClientStream(final StatsTraceContext statsTraceContext, final Status status) {
        return new NoopClientStream(this) { // from class: io.grpc.inprocess.InProcessTransport.4
            @Override // io.grpc.internal.NoopClientStream, io.grpc.internal.ClientStream
            public void start(ClientStreamListener clientStreamListener) {
                statsTraceContext.clientOutboundHeaders();
                statsTraceContext.streamClosed(status);
                clientStreamListener.closed(status, new Metadata());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int metadataSize(Metadata metadata) {
        byte[][] serialize = InternalMetadata.serialize(metadata);
        if (serialize == null) {
            return 0;
        }
        long j = 0;
        for (int i = 0; i < serialize.length; i += 2) {
            j += serialize[i].length + 32 + serialize[i + 1].length;
        }
        return (int) Math.min(j, 2147483647L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyShutdown(Status status) {
        if (this.shutdown) {
            return;
        }
        this.shutdown = true;
        this.clientTransportListener.transportShutdown(status);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyTerminated() {
        if (this.terminated) {
            return;
        }
        this.terminated = true;
        if (this.serverScheduler != null) {
            this.serverScheduler = this.serverSchedulerPool.returnObject(this.serverScheduler);
        }
        this.clientTransportListener.transportTerminated();
        if (this.serverTransportListener != null) {
            this.serverTransportListener.transportTerminated();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status stripCause(Status status) {
        if (status == null) {
            return null;
        }
        return Status.fromCodeValue(status.getCode().value()).withDescription(status.getDescription());
    }

    @Override // io.grpc.internal.ConnectionClientTransport
    public Attributes getAttributes() {
        return this.attributes;
    }

    @Override // io.grpc.InternalWithLogId
    public InternalLogId getLogId() {
        return this.logId;
    }

    @Override // io.grpc.internal.ServerTransport
    public ScheduledExecutorService getScheduledExecutorService() {
        return this.serverScheduler;
    }

    @Override // io.grpc.InternalInstrumented
    public ListenableFuture<InternalChannelz.SocketStats> getStats() {
        SettableFuture create = SettableFuture.create();
        create.set(null);
        return create;
    }

    @Override // io.grpc.internal.ClientTransport
    public synchronized ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions) {
        int metadataSize;
        if (this.shutdownStatus != null) {
            return failedClientStream(StatsTraceContext.newClientContext(callOptions, this.attributes, metadata), this.shutdownStatus);
        }
        metadata.put(GrpcUtil.USER_AGENT_KEY, this.userAgent);
        return (this.serverMaxInboundMetadataSize == Integer.MAX_VALUE || (metadataSize = metadataSize(metadata)) <= this.serverMaxInboundMetadataSize) ? new InProcessStream(methodDescriptor, metadata, callOptions, this.authority).clientStream : failedClientStream(StatsTraceContext.newClientContext(callOptions, this.attributes, metadata), Status.RESOURCE_EXHAUSTED.withDescription(String.format("Request metadata larger than %d: %d", Integer.valueOf(this.serverMaxInboundMetadataSize), Integer.valueOf(metadataSize))));
    }

    @Override // io.grpc.internal.ClientTransport
    public synchronized void ping(final ClientTransport.PingCallback pingCallback, Executor executor) {
        if (this.terminated) {
            final Status status = this.shutdownStatus;
            executor.execute(new Runnable(this) { // from class: io.grpc.inprocess.InProcessTransport.5
                @Override // java.lang.Runnable
                public void run() {
                    pingCallback.onFailure(status.asRuntimeException());
                }
            });
        } else {
            executor.execute(new Runnable(this) { // from class: io.grpc.inprocess.InProcessTransport.6
                @Override // java.lang.Runnable
                public void run() {
                    pingCallback.onSuccess(0L);
                }
            });
        }
    }

    @Override // io.grpc.internal.ServerTransport
    public synchronized void shutdown() {
        shutdown(Status.UNAVAILABLE.withDescription("InProcessTransport shutdown by the server-side"));
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public synchronized void shutdown(Status status) {
        if (this.shutdown) {
            return;
        }
        this.shutdownStatus = status;
        notifyShutdown(status);
        if (this.streams.isEmpty()) {
            notifyTerminated();
        }
    }

    @Override // io.grpc.internal.ServerTransport, io.grpc.internal.ManagedClientTransport
    public void shutdownNow(Status status) {
        Preconditions.checkNotNull(status, "reason");
        synchronized (this) {
            shutdown(status);
            if (this.terminated) {
                return;
            }
            Iterator it = new ArrayList(this.streams).iterator();
            while (it.hasNext()) {
                ((InProcessStream) it.next()).clientStream.cancel(status);
            }
        }
    }

    @Override // io.grpc.internal.ManagedClientTransport
    @CheckReturnValue
    public synchronized Runnable start(ManagedClientTransport.Listener listener) {
        this.clientTransportListener = listener;
        InProcessServer a = InProcessServer.a(this.name);
        if (a != null) {
            this.serverMaxInboundMetadataSize = a.a();
            this.serverSchedulerPool = a.b();
            this.serverScheduler = this.serverSchedulerPool.getObject();
            this.serverStreamTracerFactories = a.c();
            this.serverTransportListener = a.a(this);
        }
        if (this.serverTransportListener != null) {
            return new Runnable() { // from class: io.grpc.inprocess.InProcessTransport.3
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (InProcessTransport.this) {
                        Attributes build = Attributes.newBuilder().set(Grpc.TRANSPORT_ATTR_REMOTE_ADDR, new InProcessSocketAddress(InProcessTransport.this.name)).set(Grpc.TRANSPORT_ATTR_LOCAL_ADDR, new InProcessSocketAddress(InProcessTransport.this.name)).build();
                        InProcessTransport.this.serverStreamAttributes = InProcessTransport.this.serverTransportListener.transportReady(build);
                        InProcessTransport.this.clientTransportListener.transportReady();
                    }
                }
            };
        }
        this.shutdownStatus = Status.UNAVAILABLE.withDescription("Could not find server: " + this.name);
        final Status status = this.shutdownStatus;
        return new Runnable() { // from class: io.grpc.inprocess.InProcessTransport.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (InProcessTransport.this) {
                    InProcessTransport.this.notifyShutdown(status);
                    InProcessTransport.this.notifyTerminated();
                }
            }
        };
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("logId", this.logId.getId()).add(AppMeasurementSdk.ConditionalUserProperty.NAME, this.name).toString();
    }
}
