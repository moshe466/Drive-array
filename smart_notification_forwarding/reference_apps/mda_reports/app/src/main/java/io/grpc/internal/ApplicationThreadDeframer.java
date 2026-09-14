package io.grpc.internal;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.Preconditions;
import io.grpc.Decompressor;
import io.grpc.internal.MessageDeframer;
import io.grpc.internal.StreamListener;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public class ApplicationThreadDeframer implements Deframer, MessageDeframer.Listener {
    private final MessageDeframer deframer;
    private final Queue<InputStream> messageReadQueue = new ArrayDeque();
    private final MessageDeframer.Listener storedListener;
    private final TransportExecutor transportExecutor;

    /* loaded from: classes2.dex */
    private class InitializingMessageProducer implements StreamListener.MessageProducer {
        private boolean initialized;
        private final Runnable runnable;

        private InitializingMessageProducer(Runnable runnable) {
            this.initialized = false;
            this.runnable = runnable;
        }

        private void initialize() {
            if (this.initialized) {
                return;
            }
            this.runnable.run();
            this.initialized = true;
        }

        @Override // io.grpc.internal.StreamListener.MessageProducer
        @Nullable
        public InputStream next() {
            initialize();
            return (InputStream) ApplicationThreadDeframer.this.messageReadQueue.poll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface TransportExecutor {
        void runOnTransportThread(Runnable runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ApplicationThreadDeframer(MessageDeframer.Listener listener, TransportExecutor transportExecutor, MessageDeframer messageDeframer) {
        this.storedListener = (MessageDeframer.Listener) Preconditions.checkNotNull(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.transportExecutor = (TransportExecutor) Preconditions.checkNotNull(transportExecutor, "transportExecutor");
        messageDeframer.a(this);
        this.deframer = messageDeframer;
    }

    @Override // io.grpc.internal.MessageDeframer.Listener
    public void bytesRead(final int i) {
        this.transportExecutor.runOnTransportThread(new Runnable() { // from class: io.grpc.internal.ApplicationThreadDeframer.5
            @Override // java.lang.Runnable
            public void run() {
                ApplicationThreadDeframer.this.storedListener.bytesRead(i);
            }
        });
    }

    @Override // io.grpc.internal.Deframer
    public void close() {
        this.deframer.a();
        this.storedListener.messagesAvailable(new InitializingMessageProducer(new Runnable() { // from class: io.grpc.internal.ApplicationThreadDeframer.4
            @Override // java.lang.Runnable
            public void run() {
                ApplicationThreadDeframer.this.deframer.close();
            }
        }));
    }

    @Override // io.grpc.internal.Deframer
    public void closeWhenComplete() {
        this.storedListener.messagesAvailable(new InitializingMessageProducer(new Runnable() { // from class: io.grpc.internal.ApplicationThreadDeframer.3
            @Override // java.lang.Runnable
            public void run() {
                ApplicationThreadDeframer.this.deframer.closeWhenComplete();
            }
        }));
    }

    @Override // io.grpc.internal.Deframer
    public void deframe(final ReadableBuffer readableBuffer) {
        this.storedListener.messagesAvailable(new InitializingMessageProducer(new Runnable() { // from class: io.grpc.internal.ApplicationThreadDeframer.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ApplicationThreadDeframer.this.deframer.deframe(readableBuffer);
                } catch (Throwable th) {
                    ApplicationThreadDeframer.this.deframeFailed(th);
                    ApplicationThreadDeframer.this.deframer.close();
                }
            }
        }));
    }

    @Override // io.grpc.internal.MessageDeframer.Listener
    public void deframeFailed(final Throwable th) {
        this.transportExecutor.runOnTransportThread(new Runnable() { // from class: io.grpc.internal.ApplicationThreadDeframer.7
            @Override // java.lang.Runnable
            public void run() {
                ApplicationThreadDeframer.this.storedListener.deframeFailed(th);
            }
        });
    }

    @Override // io.grpc.internal.MessageDeframer.Listener
    public void deframerClosed(final boolean z) {
        this.transportExecutor.runOnTransportThread(new Runnable() { // from class: io.grpc.internal.ApplicationThreadDeframer.6
            @Override // java.lang.Runnable
            public void run() {
                ApplicationThreadDeframer.this.storedListener.deframerClosed(z);
            }
        });
    }

    @Override // io.grpc.internal.MessageDeframer.Listener
    public void messagesAvailable(StreamListener.MessageProducer messageProducer) {
        while (true) {
            InputStream next = messageProducer.next();
            if (next == null) {
                return;
            } else {
                this.messageReadQueue.add(next);
            }
        }
    }

    @Override // io.grpc.internal.Deframer
    public void request(final int i) {
        this.storedListener.messagesAvailable(new InitializingMessageProducer(new Runnable() { // from class: io.grpc.internal.ApplicationThreadDeframer.1
            @Override // java.lang.Runnable
            public void run() {
                if (ApplicationThreadDeframer.this.deframer.isClosed()) {
                    return;
                }
                try {
                    ApplicationThreadDeframer.this.deframer.request(i);
                } catch (Throwable th) {
                    ApplicationThreadDeframer.this.storedListener.deframeFailed(th);
                    ApplicationThreadDeframer.this.deframer.close();
                }
            }
        }));
    }

    @Override // io.grpc.internal.Deframer
    public void setDecompressor(Decompressor decompressor) {
        this.deframer.setDecompressor(decompressor);
    }

    @Override // io.grpc.internal.Deframer
    public void setFullStreamDecompressor(GzipInflatingBuffer gzipInflatingBuffer) {
        this.deframer.setFullStreamDecompressor(gzipInflatingBuffer);
    }

    @Override // io.grpc.internal.Deframer
    public void setMaxInboundMessageSize(int i) {
        this.deframer.setMaxInboundMessageSize(i);
    }
}
