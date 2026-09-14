package io.grpc.internal;

import androidx.core.app.NotificationCompat;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Attributes;
import io.grpc.Codec;
import io.grpc.Compressor;
import io.grpc.CompressorRegistry;
import io.grpc.Context;
import io.grpc.DecompressorRegistry;
import io.grpc.InternalDecompressorRegistry;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.ServerCall;
import io.grpc.Status;
import io.grpc.internal.StreamListener;
import io.grpc.perfmark.PerfMark;
import io.grpc.perfmark.PerfTag;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
final class ServerCallImpl<ReqT, RespT> extends ServerCall<ReqT, RespT> {
    private static final Logger log = Logger.getLogger(ServerCallImpl.class.getName());
    private volatile boolean cancelled;
    private boolean closeCalled;
    private Compressor compressor;
    private final CompressorRegistry compressorRegistry;
    private final Context.CancellableContext context;
    private final DecompressorRegistry decompressorRegistry;
    private final byte[] messageAcceptEncoding;
    private boolean messageSent;
    private final MethodDescriptor<ReqT, RespT> method;
    private boolean sendHeadersCalled;
    private CallTracer serverCallTracer;
    private final ServerStream stream;
    private final PerfTag tag;

    @VisibleForTesting
    /* loaded from: classes2.dex */
    static final class ServerStreamListenerImpl<ReqT> implements ServerStreamListener {
        private final ServerCallImpl<ReqT, ?> call;
        private final Context.CancellableContext context;
        private final ServerCall.Listener<ReqT> listener;

        public ServerStreamListenerImpl(ServerCallImpl<ReqT, ?> serverCallImpl, ServerCall.Listener<ReqT> listener, Context.CancellableContext cancellableContext) {
            this.call = (ServerCallImpl) Preconditions.checkNotNull(serverCallImpl, NotificationCompat.CATEGORY_CALL);
            this.listener = (ServerCall.Listener) Preconditions.checkNotNull(listener, "listener must not be null");
            this.context = (Context.CancellableContext) Preconditions.checkNotNull(cancellableContext, "context");
            this.context.addListener(new Context.CancellationListener() { // from class: io.grpc.internal.ServerCallImpl.ServerStreamListenerImpl.1
                @Override // io.grpc.Context.CancellationListener
                public void cancelled(Context context) {
                    ServerStreamListenerImpl.this.call.cancelled = true;
                }
            }, MoreExecutors.directExecutor());
        }

        @Override // io.grpc.internal.ServerStreamListener
        public void closed(Status status) {
            PerfMark.taskStart(((ServerCallImpl) this.call).tag, "ServerCall.closed");
            try {
                try {
                    if (status.isOk()) {
                        this.listener.onComplete();
                    } else {
                        ((ServerCallImpl) this.call).cancelled = true;
                        this.listener.onCancel();
                    }
                } finally {
                    this.context.cancel(null);
                }
            } finally {
                PerfMark.taskEnd(((ServerCallImpl) this.call).tag, "ServerCall.closed");
            }
        }

        @Override // io.grpc.internal.ServerStreamListener
        public void halfClosed() {
            if (((ServerCallImpl) this.call).cancelled) {
                return;
            }
            PerfMark.taskStart(((ServerCallImpl) this.call).tag, "ServerCall.halfClosed");
            try {
                this.listener.onHalfClose();
            } finally {
                PerfMark.taskEnd(((ServerCallImpl) this.call).tag, "ServerCall.halfClosed");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.grpc.internal.StreamListener
        public void messagesAvailable(StreamListener.MessageProducer messageProducer) {
            if (((ServerCallImpl) this.call).cancelled) {
                GrpcUtil.a(messageProducer);
                return;
            }
            PerfMark.taskStart(((ServerCallImpl) this.call).tag, "ServerCall.messagesAvailable");
            while (true) {
                try {
                    InputStream next = messageProducer.next();
                    if (next == null) {
                        return;
                    }
                    try {
                        this.listener.onMessage(((ServerCallImpl) this.call).method.parseRequest(next));
                        next.close();
                    } finally {
                    }
                } finally {
                }
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void onReady() {
            if (((ServerCallImpl) this.call).cancelled) {
                return;
            }
            PerfMark.taskStart(((ServerCallImpl) this.call).tag, "ServerCall.closed");
            try {
                this.listener.onReady();
            } finally {
                PerfMark.taskEnd(((ServerCallImpl) this.call).tag, "ServerCall.closed");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServerCallImpl(ServerStream serverStream, MethodDescriptor<ReqT, RespT> methodDescriptor, Metadata metadata, Context.CancellableContext cancellableContext, DecompressorRegistry decompressorRegistry, CompressorRegistry compressorRegistry, CallTracer callTracer) {
        this.stream = serverStream;
        this.method = methodDescriptor;
        this.tag = PerfMark.createTag(methodDescriptor.getFullMethodName());
        this.context = cancellableContext;
        this.messageAcceptEncoding = (byte[]) metadata.get(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY);
        this.decompressorRegistry = decompressorRegistry;
        this.compressorRegistry = compressorRegistry;
        this.serverCallTracer = callTracer;
        this.serverCallTracer.reportCallStarted();
    }

    private void closeInternal(Status status, Metadata metadata) {
        Preconditions.checkState(!this.closeCalled, "call already closed");
        try {
            this.closeCalled = true;
            if (status.isOk() && this.method.getType().serverSendsOneMessage() && !this.messageSent) {
                internalClose(Status.INTERNAL.withDescription("Completed without a response"));
            } else {
                this.stream.close(status, metadata);
            }
        } finally {
            this.serverCallTracer.reportCallEnded(status.isOk());
        }
    }

    private void internalClose(Status status) {
        log.log(Level.WARNING, "Cancelling the stream with status {0}", new Object[]{status});
        this.stream.cancel(status);
        this.serverCallTracer.reportCallEnded(status.isOk());
    }

    private void sendHeadersInternal(Metadata metadata) {
        byte[] bArr;
        Preconditions.checkState(!this.sendHeadersCalled, "sendHeaders has already been called");
        Preconditions.checkState(!this.closeCalled, "call is closed");
        metadata.discardAll(GrpcUtil.MESSAGE_ENCODING_KEY);
        if (this.compressor == null || (bArr = this.messageAcceptEncoding) == null || !GrpcUtil.a(GrpcUtil.ACCEPT_ENCODING_SPLITTER.split(new String(bArr, GrpcUtil.US_ASCII)), this.compressor.getMessageEncoding())) {
            this.compressor = Codec.Identity.NONE;
        }
        metadata.put(GrpcUtil.MESSAGE_ENCODING_KEY, this.compressor.getMessageEncoding());
        this.stream.setCompressor(this.compressor);
        metadata.discardAll(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY);
        byte[] rawAdvertisedMessageEncodings = InternalDecompressorRegistry.getRawAdvertisedMessageEncodings(this.decompressorRegistry);
        if (rawAdvertisedMessageEncodings.length != 0) {
            metadata.put(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY, rawAdvertisedMessageEncodings);
        }
        this.sendHeadersCalled = true;
        this.stream.writeHeaders(metadata);
    }

    private void sendMessageInternal(RespT respt) {
        Preconditions.checkState(this.sendHeadersCalled, "sendHeaders has not been called");
        Preconditions.checkState(!this.closeCalled, "call is closed");
        if (this.method.getType().serverSendsOneMessage() && this.messageSent) {
            internalClose(Status.INTERNAL.withDescription("Too many responses"));
            return;
        }
        this.messageSent = true;
        try {
            this.stream.writeMessage(this.method.streamResponse(respt));
            this.stream.flush();
        } catch (Error e) {
            close(Status.CANCELLED.withDescription("Server sendMessage() failed with Error"), new Metadata());
            throw e;
        } catch (RuntimeException e2) {
            close(Status.fromThrowable(e2), new Metadata());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServerStreamListener a(ServerCall.Listener<ReqT> listener) {
        return new ServerStreamListenerImpl(this, listener, this.context);
    }

    @Override // io.grpc.ServerCall
    public void close(Status status, Metadata metadata) {
        PerfMark.taskStart(this.tag, "ServerCall.close");
        try {
            closeInternal(status, metadata);
        } finally {
            PerfMark.taskEnd(this.tag, "ServerCall.close");
        }
    }

    @Override // io.grpc.ServerCall
    public Attributes getAttributes() {
        return this.stream.getAttributes();
    }

    @Override // io.grpc.ServerCall
    public String getAuthority() {
        return this.stream.getAuthority();
    }

    @Override // io.grpc.ServerCall
    public MethodDescriptor<ReqT, RespT> getMethodDescriptor() {
        return this.method;
    }

    @Override // io.grpc.ServerCall
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override // io.grpc.ServerCall
    public boolean isReady() {
        return this.stream.isReady();
    }

    @Override // io.grpc.ServerCall
    public void request(int i) {
        this.stream.request(i);
    }

    @Override // io.grpc.ServerCall
    public void sendHeaders(Metadata metadata) {
        PerfMark.taskStart(this.tag, "ServerCall.sendHeaders");
        try {
            sendHeadersInternal(metadata);
        } finally {
            PerfMark.taskEnd(this.tag, "ServerCall.sendHeaders");
        }
    }

    @Override // io.grpc.ServerCall
    public void sendMessage(RespT respt) {
        PerfMark.taskStart(this.tag, "ServerCall.sendMessage");
        try {
            sendMessageInternal(respt);
        } finally {
            PerfMark.taskEnd(this.tag, "ServerCall.sendMessage");
        }
    }

    @Override // io.grpc.ServerCall
    public void setCompression(String str) {
        Preconditions.checkState(!this.sendHeadersCalled, "sendHeaders has been called");
        this.compressor = this.compressorRegistry.lookupCompressor(str);
        Preconditions.checkArgument(this.compressor != null, "Unable to find compressor by name %s", str);
    }

    @Override // io.grpc.ServerCall
    public void setMessageCompression(boolean z) {
        this.stream.setMessageCompression(z);
    }
}
