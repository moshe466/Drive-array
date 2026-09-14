package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.Codec;
import io.grpc.Compressor;
import io.grpc.CompressorRegistry;
import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.InternalDecompressorRegistry;
import io.grpc.LoadBalancer;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.StreamListener;
import io.grpc.perfmark.PerfMark;
import io.grpc.perfmark.PerfTag;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ClientCallImpl<ReqT, RespT> extends ClientCall<ReqT, RespT> {
    private final Executor callExecutor;
    private final CallOptions callOptions;
    private boolean cancelCalled;
    private volatile boolean cancelListenersShouldBeRemoved;
    private final CallTracer channelCallsTracer;
    private final ClientTransportProvider clientTransportProvider;
    private final Context context;
    private final ScheduledExecutorService deadlineCancellationExecutor;
    private volatile ScheduledFuture<?> deadlineCancellationFuture;
    private boolean fullStreamDecompression;
    private boolean halfCloseCalled;
    private final MethodDescriptor<ReqT, RespT> method;
    private final boolean retryEnabled;
    private ClientStream stream;
    private final PerfTag tag;
    private final boolean unaryRequest;
    private static final Logger log = Logger.getLogger(ClientCallImpl.class.getName());
    private static final byte[] FULL_STREAM_DECOMPRESSION_ENCODINGS = HttpRequest.ENCODING_GZIP.getBytes(Charset.forName("US-ASCII"));
    private final Context.CancellationListener cancellationListener = new ContextCancellationListener();
    private DecompressorRegistry decompressorRegistry = DecompressorRegistry.getDefaultInstance();
    private CompressorRegistry compressorRegistry = CompressorRegistry.getDefaultInstance();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ClientStreamListenerImpl implements ClientStreamListener {
        private boolean closed;
        private final ClientCall.Listener<RespT> observer;

        public ClientStreamListenerImpl(ClientCall.Listener<RespT> listener) {
            this.observer = (ClientCall.Listener) Preconditions.checkNotNull(listener, "observer");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void close(Status status, Metadata metadata) {
            this.closed = true;
            ClientCallImpl.this.cancelListenersShouldBeRemoved = true;
            try {
                ClientCallImpl.this.closeObserver(this.observer, status, metadata);
            } finally {
                ClientCallImpl.this.removeContextListenerAndCancelDeadlineFuture();
                ClientCallImpl.this.channelCallsTracer.reportCallEnded(status.isOk());
            }
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void closed(Status status, Metadata metadata) {
            closed(status, ClientStreamListener.RpcProgress.PROCESSED, metadata);
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void closed(final Status status, ClientStreamListener.RpcProgress rpcProgress, final Metadata metadata) {
            Deadline effectiveDeadline = ClientCallImpl.this.effectiveDeadline();
            if (status.getCode() == Status.Code.CANCELLED && effectiveDeadline != null && effectiveDeadline.isExpired()) {
                status = Status.DEADLINE_EXCEEDED;
                metadata = new Metadata();
            }
            ClientCallImpl.this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ClientCallImpl.ClientStreamListenerImpl.1StreamClosed
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(ClientCallImpl.this.context);
                }

                @Override // io.grpc.internal.ContextRunnable
                public final void runInContext() {
                    if (ClientStreamListenerImpl.this.closed) {
                        return;
                    }
                    PerfMark.taskStart(ClientCallImpl.this.tag, "ClientCall.closed");
                    try {
                        ClientStreamListenerImpl.this.close(status, metadata);
                    } finally {
                        PerfMark.taskEnd(ClientCallImpl.this.tag, "ClientCall.closed");
                    }
                }
            });
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void headersRead(final Metadata metadata) {
            ClientCallImpl.this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ClientCallImpl.ClientStreamListenerImpl.1HeadersRead
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(ClientCallImpl.this.context);
                }

                @Override // io.grpc.internal.ContextRunnable
                public final void runInContext() {
                    if (ClientStreamListenerImpl.this.closed) {
                        return;
                    }
                    PerfMark.taskStart(ClientCallImpl.this.tag, "ClientCall.headersRead");
                    try {
                        ClientStreamListenerImpl.this.observer.onHeaders(metadata);
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            });
        }

        @Override // io.grpc.internal.StreamListener
        public void messagesAvailable(final StreamListener.MessageProducer messageProducer) {
            ClientCallImpl.this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ClientCallImpl.ClientStreamListenerImpl.1MessagesAvailable
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(ClientCallImpl.this.context);
                }

                @Override // io.grpc.internal.ContextRunnable
                public final void runInContext() {
                    if (ClientStreamListenerImpl.this.closed) {
                        GrpcUtil.a(messageProducer);
                        return;
                    }
                    PerfMark.taskStart(ClientCallImpl.this.tag, "ClientCall.messagesAvailable");
                    while (true) {
                        try {
                            InputStream next = messageProducer.next();
                            if (next == null) {
                                break;
                            }
                            try {
                                ClientStreamListenerImpl.this.observer.onMessage(ClientCallImpl.this.method.parseResponse(next));
                                next.close();
                            } finally {
                            }
                        } finally {
                            try {
                            } finally {
                            }
                        }
                    }
                }
            });
        }

        @Override // io.grpc.internal.StreamListener
        public void onReady() {
            ClientCallImpl.this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ClientCallImpl.ClientStreamListenerImpl.1StreamOnReady
                {
                    Context context = ClientCallImpl.this.context;
                }

                @Override // io.grpc.internal.ContextRunnable
                public final void runInContext() {
                    PerfMark.taskStart(ClientCallImpl.this.tag, "ClientCall.onReady");
                    try {
                        ClientStreamListenerImpl.this.observer.onReady();
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface ClientTransportProvider {
        ClientTransport get(LoadBalancer.PickSubchannelArgs pickSubchannelArgs);

        <ReqT> ClientStream newRetriableStream(MethodDescriptor<ReqT, ?> methodDescriptor, CallOptions callOptions, Metadata metadata, Context context);
    }

    /* loaded from: classes2.dex */
    private final class ContextCancellationListener implements Context.CancellationListener {
        private ContextCancellationListener() {
        }

        @Override // io.grpc.Context.CancellationListener
        public void cancelled(Context context) {
            ClientCallImpl.this.stream.cancel(Contexts.statusFromCancelled(context));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class DeadlineTimer implements Runnable {
        private final long remainingNanos;

        DeadlineTimer(long j) {
            this.remainingNanos = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            ClientCallImpl.this.stream.cancel(Status.DEADLINE_EXCEEDED.augmentDescription(String.format("deadline exceeded after %dns", Long.valueOf(this.remainingNanos))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClientCallImpl(MethodDescriptor<ReqT, RespT> methodDescriptor, Executor executor, CallOptions callOptions, ClientTransportProvider clientTransportProvider, ScheduledExecutorService scheduledExecutorService, CallTracer callTracer, boolean z) {
        this.method = methodDescriptor;
        this.tag = PerfMark.createTag(methodDescriptor.getFullMethodName());
        this.callExecutor = executor == MoreExecutors.directExecutor() ? new SerializeReentrantCallsDirectExecutor() : new SerializingExecutor(executor);
        this.channelCallsTracer = callTracer;
        this.context = Context.current();
        this.unaryRequest = methodDescriptor.getType() == MethodDescriptor.MethodType.UNARY || methodDescriptor.getType() == MethodDescriptor.MethodType.SERVER_STREAMING;
        this.callOptions = callOptions;
        this.clientTransportProvider = clientTransportProvider;
        this.deadlineCancellationExecutor = scheduledExecutorService;
        this.retryEnabled = z;
    }

    @VisibleForTesting
    static void a(Metadata metadata, DecompressorRegistry decompressorRegistry, Compressor compressor, boolean z) {
        metadata.discardAll(GrpcUtil.MESSAGE_ENCODING_KEY);
        if (compressor != Codec.Identity.NONE) {
            metadata.put(GrpcUtil.MESSAGE_ENCODING_KEY, compressor.getMessageEncoding());
        }
        metadata.discardAll(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY);
        byte[] rawAdvertisedMessageEncodings = InternalDecompressorRegistry.getRawAdvertisedMessageEncodings(decompressorRegistry);
        if (rawAdvertisedMessageEncodings.length != 0) {
            metadata.put(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY, rawAdvertisedMessageEncodings);
        }
        metadata.discardAll(GrpcUtil.CONTENT_ENCODING_KEY);
        metadata.discardAll(GrpcUtil.CONTENT_ACCEPT_ENCODING_KEY);
        if (z) {
            metadata.put(GrpcUtil.CONTENT_ACCEPT_ENCODING_KEY, FULL_STREAM_DECOMPRESSION_ENCODINGS);
        }
    }

    private void cancelInternal(@Nullable String str, @Nullable Throwable th) {
        if (str == null && th == null) {
            th = new CancellationException("Cancelled without a message or cause");
            log.log(Level.WARNING, "Cancelling without a message or cause is suboptimal", th);
        }
        if (this.cancelCalled) {
            return;
        }
        this.cancelCalled = true;
        try {
            if (this.stream != null) {
                Status status = Status.CANCELLED;
                if (str == null) {
                    str = "Call cancelled without message";
                }
                Status withDescription = status.withDescription(str);
                if (th != null) {
                    withDescription = withDescription.withCause(th);
                }
                this.stream.cancel(withDescription);
            }
        } finally {
            removeContextListenerAndCancelDeadlineFuture();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeObserver(ClientCall.Listener<RespT> listener, Status status, Metadata metadata) {
        listener.onClose(status, metadata);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public Deadline effectiveDeadline() {
        return min(this.callOptions.getDeadline(), this.context.getDeadline());
    }

    private void halfCloseInternal() {
        Preconditions.checkState(this.stream != null, "Not started");
        Preconditions.checkState(!this.cancelCalled, "call was cancelled");
        Preconditions.checkState(!this.halfCloseCalled, "call already half-closed");
        this.halfCloseCalled = true;
        this.stream.halfClose();
    }

    private static void logIfContextNarrowedTimeout(Deadline deadline, @Nullable Deadline deadline2, @Nullable Deadline deadline3) {
        if (log.isLoggable(Level.FINE) && deadline != null && deadline2 == deadline) {
            StringBuilder sb = new StringBuilder(String.format("Call timeout set to '%d' ns, due to context deadline.", Long.valueOf(Math.max(0L, deadline.timeRemaining(TimeUnit.NANOSECONDS)))));
            sb.append(deadline3 == null ? " Explicit call timeout was not set." : String.format(" Explicit call timeout was '%d' ns.", Long.valueOf(deadline3.timeRemaining(TimeUnit.NANOSECONDS))));
            log.fine(sb.toString());
        }
    }

    @Nullable
    private static Deadline min(@Nullable Deadline deadline, @Nullable Deadline deadline2) {
        return deadline == null ? deadline2 : deadline2 == null ? deadline : deadline.minimum(deadline2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeContextListenerAndCancelDeadlineFuture() {
        this.context.removeListener(this.cancellationListener);
        ScheduledFuture<?> scheduledFuture = this.deadlineCancellationFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    private void sendMessageInternal(ReqT reqt) {
        Preconditions.checkState(this.stream != null, "Not started");
        Preconditions.checkState(!this.cancelCalled, "call was cancelled");
        Preconditions.checkState(!this.halfCloseCalled, "call was half-closed");
        try {
            if (this.stream instanceof RetriableStream) {
                ((RetriableStream) this.stream).a((RetriableStream) reqt);
            } else {
                this.stream.writeMessage(this.method.streamRequest(reqt));
            }
            if (this.unaryRequest) {
                return;
            }
            this.stream.flush();
        } catch (Error e) {
            this.stream.cancel(Status.CANCELLED.withDescription("Client sendMessage() failed with Error"));
            throw e;
        } catch (RuntimeException e2) {
            this.stream.cancel(Status.CANCELLED.withCause(e2).withDescription("Failed to stream message"));
        }
    }

    private ScheduledFuture<?> startDeadlineTimer(Deadline deadline) {
        long timeRemaining = deadline.timeRemaining(TimeUnit.NANOSECONDS);
        return this.deadlineCancellationExecutor.schedule(new LogExceptionRunnable(new DeadlineTimer(timeRemaining)), timeRemaining, TimeUnit.NANOSECONDS);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void startInternal(final io.grpc.ClientCall.Listener<RespT> r7, io.grpc.Metadata r8) {
        /*
            Method dump skipped, instructions count: 363
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.ClientCallImpl.startInternal(io.grpc.ClientCall$Listener, io.grpc.Metadata):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClientCallImpl<ReqT, RespT> a(CompressorRegistry compressorRegistry) {
        this.compressorRegistry = compressorRegistry;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClientCallImpl<ReqT, RespT> a(DecompressorRegistry decompressorRegistry) {
        this.decompressorRegistry = decompressorRegistry;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClientCallImpl<ReqT, RespT> a(boolean z) {
        this.fullStreamDecompression = z;
        return this;
    }

    @Override // io.grpc.ClientCall
    public void cancel(@Nullable String str, @Nullable Throwable th) {
        PerfMark.taskStart(this.tag, "ClientCall.cancel");
        try {
            cancelInternal(str, th);
        } finally {
            PerfMark.taskEnd(this.tag, "ClientCall.cancel");
        }
    }

    @Override // io.grpc.ClientCall
    public Attributes getAttributes() {
        ClientStream clientStream = this.stream;
        return clientStream != null ? clientStream.getAttributes() : Attributes.EMPTY;
    }

    @Override // io.grpc.ClientCall
    public void halfClose() {
        PerfMark.taskStart(this.tag, "ClientCall.halfClose");
        try {
            halfCloseInternal();
        } finally {
            PerfMark.taskEnd(this.tag, "ClientCall.halfClose");
        }
    }

    @Override // io.grpc.ClientCall
    public boolean isReady() {
        return this.stream.isReady();
    }

    @Override // io.grpc.ClientCall
    public void request(int i) {
        Preconditions.checkState(this.stream != null, "Not started");
        Preconditions.checkArgument(i >= 0, "Number requested must be non-negative");
        this.stream.request(i);
    }

    @Override // io.grpc.ClientCall
    public void sendMessage(ReqT reqt) {
        PerfMark.taskStart(this.tag, "ClientCall.sendMessage");
        try {
            sendMessageInternal(reqt);
        } finally {
            PerfMark.taskEnd(this.tag, "ClientCall.sendMessage");
        }
    }

    @Override // io.grpc.ClientCall
    public void setMessageCompression(boolean z) {
        Preconditions.checkState(this.stream != null, "Not started");
        this.stream.setMessageCompression(z);
    }

    @Override // io.grpc.ClientCall
    public void start(ClientCall.Listener<RespT> listener, Metadata metadata) {
        PerfMark.taskStart(this.tag, "ClientCall.start");
        try {
            startInternal(listener, metadata);
        } finally {
            PerfMark.taskEnd(this.tag, "ClientCall.start");
        }
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add(FirebaseAnalytics.Param.METHOD, this.method).toString();
    }
}
