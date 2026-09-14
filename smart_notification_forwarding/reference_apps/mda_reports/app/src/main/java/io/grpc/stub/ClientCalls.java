package io.grpc.stub;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class ClientCalls {
    private static final Logger logger = Logger.getLogger(ClientCalls.class.getName());

    /* loaded from: classes2.dex */
    private static final class BlockingResponseStream<T> implements Iterator<T> {
        private final BlockingQueue<Object> buffer;
        private final ClientCall<?, T> call;
        private Object last;
        private final ClientCall.Listener<T> listener;
        private final ThreadlessExecutor threadless;

        /* loaded from: classes2.dex */
        private final class QueuingListener extends ClientCall.Listener<T> {
            private boolean done = false;

            QueuingListener() {
            }

            @Override // io.grpc.ClientCall.Listener
            public void onClose(Status status, Metadata metadata) {
                Preconditions.checkState(!this.done, "ClientCall already closed");
                if (status.isOk()) {
                    BlockingResponseStream.this.buffer.add(BlockingResponseStream.this);
                } else {
                    BlockingResponseStream.this.buffer.add(status.asRuntimeException(metadata));
                }
                this.done = true;
            }

            @Override // io.grpc.ClientCall.Listener
            public void onHeaders(Metadata metadata) {
            }

            @Override // io.grpc.ClientCall.Listener
            public void onMessage(T t) {
                Preconditions.checkState(!this.done, "ClientCall already closed");
                BlockingResponseStream.this.buffer.add(t);
            }
        }

        BlockingResponseStream(ClientCall<?, T> clientCall) {
            this(clientCall, null);
        }

        BlockingResponseStream(ClientCall<?, T> clientCall, ThreadlessExecutor threadlessExecutor) {
            this.buffer = new ArrayBlockingQueue(2);
            this.listener = new QueuingListener();
            this.call = clientCall;
            this.threadless = threadlessExecutor;
        }

        private Object waitForNext() {
            if (this.threadless == null) {
                return this.buffer.take();
            }
            while (true) {
                Object poll = this.buffer.poll();
                if (poll != null) {
                    return poll;
                }
                this.threadless.waitAndDrain();
            }
        }

        ClientCall.Listener<T> a() {
            return this.listener;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.last == null) {
                try {
                    this.last = waitForNext();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw Status.CANCELLED.withDescription("interrupted").withCause(e).asRuntimeException();
                }
            }
            Object obj = this.last;
            if (!(obj instanceof StatusRuntimeException)) {
                return obj != this;
            }
            StatusRuntimeException statusRuntimeException = (StatusRuntimeException) obj;
            throw statusRuntimeException.getStatus().asRuntimeException(statusRuntimeException.getTrailers());
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            try {
                this.call.request(1);
                return (T) this.last;
            } finally {
                this.last = null;
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class CallToStreamObserverAdapter<T> extends ClientCallStreamObserver<T> {
        private final ClientCall<T, ?> call;
        private boolean frozen;
        private Runnable onReadyHandler;
        private boolean autoFlowControlEnabled = true;
        private boolean aborted = false;
        private boolean completed = false;

        CallToStreamObserverAdapter(ClientCall<T, ?> clientCall) {
            this.call = clientCall;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void freeze() {
            this.frozen = true;
        }

        @Override // io.grpc.stub.ClientCallStreamObserver
        public void cancel(@Nullable String str, @Nullable Throwable th) {
            this.call.cancel(str, th);
        }

        @Override // io.grpc.stub.CallStreamObserver
        public void disableAutoInboundFlowControl() {
            if (this.frozen) {
                throw new IllegalStateException("Cannot disable auto flow control call started");
            }
            this.autoFlowControlEnabled = false;
        }

        @Override // io.grpc.stub.CallStreamObserver
        public boolean isReady() {
            return this.call.isReady();
        }

        @Override // io.grpc.stub.StreamObserver
        public void onCompleted() {
            this.call.halfClose();
            this.completed = true;
        }

        @Override // io.grpc.stub.StreamObserver
        public void onError(Throwable th) {
            this.call.cancel("Cancelled by client with StreamObserver.onError()", th);
            this.aborted = true;
        }

        @Override // io.grpc.stub.StreamObserver
        public void onNext(T t) {
            Preconditions.checkState(!this.aborted, "Stream was terminated by error, no further calls are allowed");
            Preconditions.checkState(!this.completed, "Stream is already completed, no further calls are allowed");
            this.call.sendMessage(t);
        }

        @Override // io.grpc.stub.CallStreamObserver
        public void request(int i) {
            this.call.request(i);
        }

        @Override // io.grpc.stub.CallStreamObserver
        public void setMessageCompression(boolean z) {
            this.call.setMessageCompression(z);
        }

        @Override // io.grpc.stub.CallStreamObserver
        public void setOnReadyHandler(Runnable runnable) {
            if (this.frozen) {
                throw new IllegalStateException("Cannot alter onReadyHandler after call started");
            }
            this.onReadyHandler = runnable;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class GrpcFuture<RespT> extends AbstractFuture<RespT> {
        private final ClientCall<?, RespT> call;

        GrpcFuture(ClientCall<?, RespT> clientCall) {
            this.call = clientCall;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        protected void b() {
            this.call.cancel("GrpcFuture was cancelled", null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.AbstractFuture
        public String c() {
            return MoreObjects.toStringHelper(this).add("clientCall", this.call).toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.AbstractFuture
        public boolean set(@Nullable RespT respt) {
            return super.set(respt);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.AbstractFuture
        public boolean setException(Throwable th) {
            return super.setException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class StreamObserverToCallListenerAdapter<ReqT, RespT> extends ClientCall.Listener<RespT> {
        private final CallToStreamObserverAdapter<ReqT> adapter;
        private boolean firstResponseReceived;
        private final StreamObserver<RespT> observer;
        private final boolean streamingResponse;

        StreamObserverToCallListenerAdapter(StreamObserver<RespT> streamObserver, CallToStreamObserverAdapter<ReqT> callToStreamObserverAdapter, boolean z) {
            this.observer = streamObserver;
            this.streamingResponse = z;
            this.adapter = callToStreamObserverAdapter;
            if (streamObserver instanceof ClientResponseObserver) {
                ((ClientResponseObserver) streamObserver).beforeStart(callToStreamObserverAdapter);
            }
            callToStreamObserverAdapter.freeze();
        }

        @Override // io.grpc.ClientCall.Listener
        public void onClose(Status status, Metadata metadata) {
            if (status.isOk()) {
                this.observer.onCompleted();
            } else {
                this.observer.onError(status.asRuntimeException(metadata));
            }
        }

        @Override // io.grpc.ClientCall.Listener
        public void onHeaders(Metadata metadata) {
        }

        @Override // io.grpc.ClientCall.Listener
        public void onMessage(RespT respt) {
            if (this.firstResponseReceived && !this.streamingResponse) {
                throw Status.INTERNAL.withDescription("More than one responses received for unary or client-streaming call").asRuntimeException();
            }
            this.firstResponseReceived = true;
            this.observer.onNext(respt);
            if (this.streamingResponse && ((CallToStreamObserverAdapter) this.adapter).autoFlowControlEnabled) {
                this.adapter.request(1);
            }
        }

        @Override // io.grpc.ClientCall.Listener
        public void onReady() {
            if (((CallToStreamObserverAdapter) this.adapter).onReadyHandler != null) {
                ((CallToStreamObserverAdapter) this.adapter).onReadyHandler.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class ThreadlessExecutor extends ConcurrentLinkedQueue<Runnable> implements Executor {
        private static final Logger log = Logger.getLogger(ThreadlessExecutor.class.getName());
        private volatile Thread waiter;

        ThreadlessExecutor() {
        }

        private static void throwIfInterrupted(Thread thread) {
            if (thread.isInterrupted()) {
                throw new InterruptedException();
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            add(runnable);
            LockSupport.unpark(this.waiter);
        }

        public void waitAndDrain() {
            Runnable poll;
            Thread currentThread = Thread.currentThread();
            throwIfInterrupted(currentThread);
            Runnable poll2 = poll();
            if (poll2 == null) {
                this.waiter = currentThread;
                while (true) {
                    try {
                        poll = poll();
                        if (poll != null) {
                            break;
                        }
                        LockSupport.park(this);
                        throwIfInterrupted(currentThread);
                    } catch (Throwable th) {
                        this.waiter = null;
                        throw th;
                    }
                }
                this.waiter = null;
                poll2 = poll;
            }
            do {
                try {
                    poll2.run();
                } catch (Throwable th2) {
                    log.log(Level.WARNING, "Runnable threw exception", th2);
                }
                poll2 = poll();
            } while (poll2 != null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class UnaryStreamToFuture<RespT> extends ClientCall.Listener<RespT> {
        private final GrpcFuture<RespT> responseFuture;
        private RespT value;

        UnaryStreamToFuture(GrpcFuture<RespT> grpcFuture) {
            this.responseFuture = grpcFuture;
        }

        @Override // io.grpc.ClientCall.Listener
        public void onClose(Status status, Metadata metadata) {
            if (!status.isOk()) {
                this.responseFuture.setException(status.asRuntimeException(metadata));
                return;
            }
            if (this.value == null) {
                this.responseFuture.setException(Status.INTERNAL.withDescription("No value received for unary call").asRuntimeException(metadata));
            }
            this.responseFuture.set(this.value);
        }

        @Override // io.grpc.ClientCall.Listener
        public void onHeaders(Metadata metadata) {
        }

        @Override // io.grpc.ClientCall.Listener
        public void onMessage(RespT respt) {
            if (this.value != null) {
                throw Status.INTERNAL.withDescription("More than one value received for unary call").asRuntimeException();
            }
            this.value = respt;
        }
    }

    private ClientCalls() {
    }

    public static <ReqT, RespT> StreamObserver<ReqT> asyncBidiStreamingCall(ClientCall<ReqT, RespT> clientCall, StreamObserver<RespT> streamObserver) {
        return asyncStreamingRequestCall(clientCall, streamObserver, true);
    }

    public static <ReqT, RespT> StreamObserver<ReqT> asyncClientStreamingCall(ClientCall<ReqT, RespT> clientCall, StreamObserver<RespT> streamObserver) {
        return asyncStreamingRequestCall(clientCall, streamObserver, false);
    }

    public static <ReqT, RespT> void asyncServerStreamingCall(ClientCall<ReqT, RespT> clientCall, ReqT reqt, StreamObserver<RespT> streamObserver) {
        asyncUnaryRequestCall((ClientCall) clientCall, (Object) reqt, (StreamObserver) streamObserver, true);
    }

    private static <ReqT, RespT> StreamObserver<ReqT> asyncStreamingRequestCall(ClientCall<ReqT, RespT> clientCall, StreamObserver<RespT> streamObserver, boolean z) {
        CallToStreamObserverAdapter callToStreamObserverAdapter = new CallToStreamObserverAdapter(clientCall);
        startCall(clientCall, new StreamObserverToCallListenerAdapter(streamObserver, callToStreamObserverAdapter, z), z);
        return callToStreamObserverAdapter;
    }

    public static <ReqT, RespT> void asyncUnaryCall(ClientCall<ReqT, RespT> clientCall, ReqT reqt, StreamObserver<RespT> streamObserver) {
        asyncUnaryRequestCall((ClientCall) clientCall, (Object) reqt, (StreamObserver) streamObserver, false);
    }

    private static <ReqT, RespT> void asyncUnaryRequestCall(ClientCall<ReqT, RespT> clientCall, ReqT reqt, ClientCall.Listener<RespT> listener, boolean z) {
        startCall(clientCall, listener, z);
        try {
            clientCall.sendMessage(reqt);
            clientCall.halfClose();
        } catch (Error e) {
            throw cancelThrow(clientCall, e);
        } catch (RuntimeException e2) {
            throw cancelThrow(clientCall, e2);
        }
    }

    private static <ReqT, RespT> void asyncUnaryRequestCall(ClientCall<ReqT, RespT> clientCall, ReqT reqt, StreamObserver<RespT> streamObserver, boolean z) {
        asyncUnaryRequestCall(clientCall, reqt, new StreamObserverToCallListenerAdapter(streamObserver, new CallToStreamObserverAdapter(clientCall), z), z);
    }

    public static <ReqT, RespT> Iterator<RespT> blockingServerStreamingCall(Channel channel, MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, ReqT reqt) {
        ThreadlessExecutor threadlessExecutor = new ThreadlessExecutor();
        ClientCall newCall = channel.newCall(methodDescriptor, callOptions.withExecutor(threadlessExecutor));
        BlockingResponseStream blockingResponseStream = new BlockingResponseStream(newCall, threadlessExecutor);
        asyncUnaryRequestCall(newCall, (Object) reqt, blockingResponseStream.a(), true);
        return blockingResponseStream;
    }

    public static <ReqT, RespT> Iterator<RespT> blockingServerStreamingCall(ClientCall<ReqT, RespT> clientCall, ReqT reqt) {
        BlockingResponseStream blockingResponseStream = new BlockingResponseStream(clientCall);
        asyncUnaryRequestCall((ClientCall) clientCall, (Object) reqt, blockingResponseStream.a(), true);
        return blockingResponseStream;
    }

    public static <ReqT, RespT> RespT blockingUnaryCall(Channel channel, MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, ReqT reqt) {
        ThreadlessExecutor threadlessExecutor = new ThreadlessExecutor();
        ClientCall newCall = channel.newCall(methodDescriptor, callOptions.withExecutor(threadlessExecutor));
        try {
            ListenableFuture futureUnaryCall = futureUnaryCall(newCall, reqt);
            while (!futureUnaryCall.isDone()) {
                try {
                    threadlessExecutor.waitAndDrain();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw Status.CANCELLED.withDescription("Call was interrupted").withCause(e).asRuntimeException();
                }
            }
            return (RespT) getUnchecked(futureUnaryCall);
        } catch (Error e2) {
            throw cancelThrow(newCall, e2);
        } catch (RuntimeException e3) {
            throw cancelThrow(newCall, e3);
        }
    }

    public static <ReqT, RespT> RespT blockingUnaryCall(ClientCall<ReqT, RespT> clientCall, ReqT reqt) {
        try {
            return (RespT) getUnchecked(futureUnaryCall(clientCall, reqt));
        } catch (Error e) {
            throw cancelThrow(clientCall, e);
        } catch (RuntimeException e2) {
            throw cancelThrow(clientCall, e2);
        }
    }

    private static RuntimeException cancelThrow(ClientCall<?, ?> clientCall, Throwable th) {
        try {
            clientCall.cancel(null, th);
        } catch (Throwable th2) {
            logger.log(Level.SEVERE, "RuntimeException encountered while closing call", th2);
        }
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
        throw new AssertionError(th);
    }

    public static <ReqT, RespT> ListenableFuture<RespT> futureUnaryCall(ClientCall<ReqT, RespT> clientCall, ReqT reqt) {
        GrpcFuture grpcFuture = new GrpcFuture(clientCall);
        asyncUnaryRequestCall((ClientCall) clientCall, (Object) reqt, (ClientCall.Listener) new UnaryStreamToFuture(grpcFuture), false);
        return grpcFuture;
    }

    private static <V> V getUnchecked(Future<V> future) {
        try {
            return future.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw Status.CANCELLED.withDescription("Call was interrupted").withCause(e).asRuntimeException();
        } catch (ExecutionException e2) {
            throw toStatusRuntimeException(e2.getCause());
        }
    }

    private static <ReqT, RespT> void startCall(ClientCall<ReqT, RespT> clientCall, ClientCall.Listener<RespT> listener, boolean z) {
        clientCall.start(listener, new Metadata());
        clientCall.request(z ? 1 : 2);
    }

    private static StatusRuntimeException toStatusRuntimeException(Throwable th) {
        for (Throwable th2 = (Throwable) Preconditions.checkNotNull(th, "t"); th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof StatusException) {
                StatusException statusException = (StatusException) th2;
                return new StatusRuntimeException(statusException.getStatus(), statusException.getTrailers());
            }
            if (th2 instanceof StatusRuntimeException) {
                StatusRuntimeException statusRuntimeException = (StatusRuntimeException) th2;
                return new StatusRuntimeException(statusRuntimeException.getStatus(), statusRuntimeException.getTrailers());
            }
        }
        return Status.UNKNOWN.withDescription("unexpected exception").withCause(th).asRuntimeException();
    }
}
