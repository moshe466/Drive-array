package io.grpc.stub;

import com.google.common.base.Preconditions;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.Status;

/* loaded from: classes2.dex */
public final class ServerCalls {

    /* loaded from: classes2.dex */
    public interface BidiStreamingMethod<ReqT, RespT> extends StreamingRequestMethod<ReqT, RespT> {
    }

    /* loaded from: classes2.dex */
    public interface ClientStreamingMethod<ReqT, RespT> extends StreamingRequestMethod<ReqT, RespT> {
    }

    /* loaded from: classes2.dex */
    static class NoopStreamObserver<V> implements StreamObserver<V> {
        NoopStreamObserver() {
        }

        @Override // io.grpc.stub.StreamObserver
        public void onCompleted() {
        }

        @Override // io.grpc.stub.StreamObserver
        public void onError(Throwable th) {
        }

        @Override // io.grpc.stub.StreamObserver
        public void onNext(V v) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class ServerCallStreamObserverImpl<ReqT, RespT> extends ServerCallStreamObserver<RespT> {
        final ServerCall<ReqT, RespT> a;
        volatile boolean b;
        private boolean frozen;
        private Runnable onCancelHandler;
        private Runnable onReadyHandler;
        private boolean sentHeaders;
        private boolean autoFlowControlEnabled = true;
        private boolean aborted = false;
        private boolean completed = false;

        ServerCallStreamObserverImpl(ServerCall<ReqT, RespT> serverCall) {
            this.a = serverCall;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void freeze() {
            this.frozen = true;
        }

        @Override // io.grpc.stub.CallStreamObserver
        public void disableAutoInboundFlowControl() {
            Preconditions.checkState(!this.frozen, "Cannot disable auto flow control after initialization");
            this.autoFlowControlEnabled = false;
        }

        @Override // io.grpc.stub.ServerCallStreamObserver
        public boolean isCancelled() {
            return this.a.isCancelled();
        }

        @Override // io.grpc.stub.CallStreamObserver
        public boolean isReady() {
            return this.a.isReady();
        }

        @Override // io.grpc.stub.StreamObserver
        public void onCompleted() {
            if (this.b) {
                if (this.onCancelHandler == null) {
                    throw Status.CANCELLED.withDescription("call already cancelled").asRuntimeException();
                }
            } else {
                this.a.close(Status.OK, new Metadata());
                this.completed = true;
            }
        }

        @Override // io.grpc.stub.StreamObserver
        public void onError(Throwable th) {
            Metadata trailersFromThrowable = Status.trailersFromThrowable(th);
            if (trailersFromThrowable == null) {
                trailersFromThrowable = new Metadata();
            }
            this.a.close(Status.fromThrowable(th), trailersFromThrowable);
            this.aborted = true;
        }

        @Override // io.grpc.stub.StreamObserver
        public void onNext(RespT respt) {
            if (this.b) {
                if (this.onCancelHandler == null) {
                    throw Status.CANCELLED.withDescription("call already cancelled").asRuntimeException();
                }
                return;
            }
            Preconditions.checkState(!this.aborted, "Stream was terminated by error, no further calls are allowed");
            Preconditions.checkState(!this.completed, "Stream is already completed, no further calls are allowed");
            if (!this.sentHeaders) {
                this.a.sendHeaders(new Metadata());
                this.sentHeaders = true;
            }
            this.a.sendMessage(respt);
        }

        @Override // io.grpc.stub.CallStreamObserver
        public void request(int i) {
            this.a.request(i);
        }

        @Override // io.grpc.stub.ServerCallStreamObserver
        public void setCompression(String str) {
            this.a.setCompression(str);
        }

        @Override // io.grpc.stub.CallStreamObserver
        public void setMessageCompression(boolean z) {
            this.a.setMessageCompression(z);
        }

        @Override // io.grpc.stub.ServerCallStreamObserver
        public void setOnCancelHandler(Runnable runnable) {
            Preconditions.checkState(!this.frozen, "Cannot alter onCancelHandler after initialization");
            this.onCancelHandler = runnable;
        }

        @Override // io.grpc.stub.CallStreamObserver
        public void setOnReadyHandler(Runnable runnable) {
            Preconditions.checkState(!this.frozen, "Cannot alter onReadyHandler after initialization");
            this.onReadyHandler = runnable;
        }
    }

    /* loaded from: classes2.dex */
    public interface ServerStreamingMethod<ReqT, RespT> extends UnaryRequestMethod<ReqT, RespT> {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface StreamingRequestMethod<ReqT, RespT> {
        StreamObserver<ReqT> invoke(StreamObserver<RespT> streamObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class StreamingServerCallHandler<ReqT, RespT> implements ServerCallHandler<ReqT, RespT> {
        private final StreamingRequestMethod<ReqT, RespT> method;

        /* loaded from: classes2.dex */
        private final class StreamingServerCallListener extends ServerCall.Listener<ReqT> {
            private final ServerCall<ReqT, RespT> call;
            private boolean halfClosed = false;
            private final StreamObserver<ReqT> requestObserver;
            private final ServerCallStreamObserverImpl<ReqT, RespT> responseObserver;

            StreamingServerCallListener(StreamingServerCallHandler streamingServerCallHandler, StreamObserver<ReqT> streamObserver, ServerCallStreamObserverImpl<ReqT, RespT> serverCallStreamObserverImpl, ServerCall<ReqT, RespT> serverCall) {
                this.requestObserver = streamObserver;
                this.responseObserver = serverCallStreamObserverImpl;
                this.call = serverCall;
            }

            @Override // io.grpc.ServerCall.Listener
            public void onCancel() {
                ServerCallStreamObserverImpl<ReqT, RespT> serverCallStreamObserverImpl = this.responseObserver;
                serverCallStreamObserverImpl.b = true;
                if (((ServerCallStreamObserverImpl) serverCallStreamObserverImpl).onCancelHandler != null) {
                    ((ServerCallStreamObserverImpl) this.responseObserver).onCancelHandler.run();
                }
                if (this.halfClosed) {
                    return;
                }
                this.requestObserver.onError(Status.CANCELLED.withDescription("cancelled before receiving half close").asRuntimeException());
            }

            @Override // io.grpc.ServerCall.Listener
            public void onHalfClose() {
                this.halfClosed = true;
                this.requestObserver.onCompleted();
            }

            @Override // io.grpc.ServerCall.Listener
            public void onMessage(ReqT reqt) {
                this.requestObserver.onNext(reqt);
                if (((ServerCallStreamObserverImpl) this.responseObserver).autoFlowControlEnabled) {
                    this.call.request(1);
                }
            }

            @Override // io.grpc.ServerCall.Listener
            public void onReady() {
                if (((ServerCallStreamObserverImpl) this.responseObserver).onReadyHandler != null) {
                    ((ServerCallStreamObserverImpl) this.responseObserver).onReadyHandler.run();
                }
            }
        }

        StreamingServerCallHandler(StreamingRequestMethod<ReqT, RespT> streamingRequestMethod) {
            this.method = streamingRequestMethod;
        }

        @Override // io.grpc.ServerCallHandler
        public ServerCall.Listener<ReqT> startCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata) {
            ServerCallStreamObserverImpl serverCallStreamObserverImpl = new ServerCallStreamObserverImpl(serverCall);
            StreamObserver<ReqT> invoke = this.method.invoke(serverCallStreamObserverImpl);
            serverCallStreamObserverImpl.freeze();
            if (serverCallStreamObserverImpl.autoFlowControlEnabled) {
                serverCall.request(1);
            }
            return new StreamingServerCallListener(this, invoke, serverCallStreamObserverImpl, serverCall);
        }
    }

    /* loaded from: classes2.dex */
    public interface UnaryMethod<ReqT, RespT> extends UnaryRequestMethod<ReqT, RespT> {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface UnaryRequestMethod<ReqT, RespT> {
        void invoke(ReqT reqt, StreamObserver<RespT> streamObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class UnaryServerCallHandler<ReqT, RespT> implements ServerCallHandler<ReqT, RespT> {
        private final UnaryRequestMethod<ReqT, RespT> method;

        /* loaded from: classes2.dex */
        private final class UnaryServerCallListener extends ServerCall.Listener<ReqT> {
            private final ServerCall<ReqT, RespT> call;
            private boolean canInvoke = true;
            private ReqT request;
            private final ServerCallStreamObserverImpl<ReqT, RespT> responseObserver;

            UnaryServerCallListener(ServerCallStreamObserverImpl<ReqT, RespT> serverCallStreamObserverImpl, ServerCall<ReqT, RespT> serverCall) {
                this.call = serverCall;
                this.responseObserver = serverCallStreamObserverImpl;
            }

            @Override // io.grpc.ServerCall.Listener
            public void onCancel() {
                ServerCallStreamObserverImpl<ReqT, RespT> serverCallStreamObserverImpl = this.responseObserver;
                serverCallStreamObserverImpl.b = true;
                if (((ServerCallStreamObserverImpl) serverCallStreamObserverImpl).onCancelHandler != null) {
                    ((ServerCallStreamObserverImpl) this.responseObserver).onCancelHandler.run();
                }
            }

            @Override // io.grpc.ServerCall.Listener
            public void onHalfClose() {
                if (this.canInvoke) {
                    if (this.request == null) {
                        this.call.close(Status.INTERNAL.withDescription("Half-closed without a request"), new Metadata());
                        return;
                    }
                    UnaryServerCallHandler.this.method.invoke(this.request, this.responseObserver);
                    this.request = null;
                    this.responseObserver.freeze();
                    if (this.call.isReady()) {
                        onReady();
                    }
                }
            }

            @Override // io.grpc.ServerCall.Listener
            public void onMessage(ReqT reqt) {
                if (this.request == null) {
                    this.request = reqt;
                } else {
                    this.call.close(Status.INTERNAL.withDescription("Too many requests"), new Metadata());
                    this.canInvoke = false;
                }
            }

            @Override // io.grpc.ServerCall.Listener
            public void onReady() {
                if (((ServerCallStreamObserverImpl) this.responseObserver).onReadyHandler != null) {
                    ((ServerCallStreamObserverImpl) this.responseObserver).onReadyHandler.run();
                }
            }
        }

        UnaryServerCallHandler(UnaryRequestMethod<ReqT, RespT> unaryRequestMethod) {
            this.method = unaryRequestMethod;
        }

        @Override // io.grpc.ServerCallHandler
        public ServerCall.Listener<ReqT> startCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata) {
            Preconditions.checkArgument(serverCall.getMethodDescriptor().getType().clientSendsOneMessage(), "asyncUnaryRequestCall is only for clientSendsOneMessage methods");
            ServerCallStreamObserverImpl serverCallStreamObserverImpl = new ServerCallStreamObserverImpl(serverCall);
            serverCall.request(2);
            return new UnaryServerCallListener(serverCallStreamObserverImpl, serverCall);
        }
    }

    private ServerCalls() {
    }

    public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncBidiStreamingCall(BidiStreamingMethod<ReqT, RespT> bidiStreamingMethod) {
        return asyncStreamingRequestCall(bidiStreamingMethod);
    }

    public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncClientStreamingCall(ClientStreamingMethod<ReqT, RespT> clientStreamingMethod) {
        return asyncStreamingRequestCall(clientStreamingMethod);
    }

    public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncServerStreamingCall(ServerStreamingMethod<ReqT, RespT> serverStreamingMethod) {
        return asyncUnaryRequestCall(serverStreamingMethod);
    }

    private static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncStreamingRequestCall(StreamingRequestMethod<ReqT, RespT> streamingRequestMethod) {
        return new StreamingServerCallHandler(streamingRequestMethod);
    }

    public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncUnaryCall(UnaryMethod<ReqT, RespT> unaryMethod) {
        return asyncUnaryRequestCall(unaryMethod);
    }

    private static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncUnaryRequestCall(UnaryRequestMethod<ReqT, RespT> unaryRequestMethod) {
        return new UnaryServerCallHandler(unaryRequestMethod);
    }

    public static <T> StreamObserver<T> asyncUnimplementedStreamingCall(MethodDescriptor<?, ?> methodDescriptor, StreamObserver<?> streamObserver) {
        asyncUnimplementedUnaryCall(methodDescriptor, streamObserver);
        return new NoopStreamObserver();
    }

    public static void asyncUnimplementedUnaryCall(MethodDescriptor<?, ?> methodDescriptor, StreamObserver<?> streamObserver) {
        Preconditions.checkNotNull(methodDescriptor, "methodDescriptor");
        Preconditions.checkNotNull(streamObserver, "responseObserver");
        streamObserver.onError(Status.UNIMPLEMENTED.withDescription(String.format("Method %s is unimplemented", methodDescriptor.getFullMethodName())).asRuntimeException());
    }
}
