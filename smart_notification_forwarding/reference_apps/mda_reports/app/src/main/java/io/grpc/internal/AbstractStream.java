package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import io.grpc.Codec;
import io.grpc.Compressor;
import io.grpc.Decompressor;
import io.grpc.internal.ApplicationThreadDeframer;
import io.grpc.internal.MessageDeframer;
import io.grpc.internal.StreamListener;
import java.io.InputStream;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public abstract class AbstractStream implements Stream {

    /* loaded from: classes2.dex */
    public static abstract class TransportState implements ApplicationThreadDeframer.TransportExecutor, MessageDeframer.Listener {

        @VisibleForTesting
        public static final int DEFAULT_ONREADY_THRESHOLD = 32768;

        @GuardedBy("onReadyLock")
        private boolean allocated;

        @GuardedBy("onReadyLock")
        private boolean deallocated;
        private Deframer deframer;

        @GuardedBy("onReadyLock")
        private int numSentBytesQueued;
        private final Object onReadyLock = new Object();
        private final StatsTraceContext statsTraceCtx;
        private final TransportTracer transportTracer;

        /* JADX INFO: Access modifiers changed from: protected */
        public TransportState(int i, StatsTraceContext statsTraceContext, TransportTracer transportTracer) {
            this.statsTraceCtx = (StatsTraceContext) Preconditions.checkNotNull(statsTraceContext, "statsTraceCtx");
            this.transportTracer = (TransportTracer) Preconditions.checkNotNull(transportTracer, "transportTracer");
            this.deframer = new MessageDeframer(this, Codec.Identity.NONE, i, statsTraceContext, transportTracer);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isReady() {
            boolean z;
            synchronized (this.onReadyLock) {
                z = this.allocated && this.numSentBytesQueued < 32768 && !this.deallocated;
            }
            return z;
        }

        private void notifyIfReady() {
            boolean isReady;
            synchronized (this.onReadyLock) {
                isReady = isReady();
            }
            if (isReady) {
                b().onReady();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onSendingBytes(int i) {
            synchronized (this.onReadyLock) {
                this.numSentBytesQueued += i;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public TransportTracer a() {
            return this.transportTracer;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void a(int i) {
            this.deframer.setMaxInboundMessageSize(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void a(Decompressor decompressor) {
            this.deframer.setDecompressor(decompressor);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void a(GzipInflatingBuffer gzipInflatingBuffer) {
            this.deframer.setFullStreamDecompressor(gzipInflatingBuffer);
            this.deframer = new ApplicationThreadDeframer(this, this, (MessageDeframer) this.deframer);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void a(ReadableBuffer readableBuffer) {
            try {
                this.deframer.deframe(readableBuffer);
            } catch (Throwable th) {
                deframeFailed(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void a(boolean z) {
            if (z) {
                this.deframer.close();
            } else {
                this.deframer.closeWhenComplete();
            }
        }

        protected abstract StreamListener b();

        /* JADX INFO: Access modifiers changed from: protected */
        public final void c() {
            synchronized (this.onReadyLock) {
                this.deallocated = true;
            }
        }

        public final StatsTraceContext getStatsTraceContext() {
            return this.statsTraceCtx;
        }

        @Override // io.grpc.internal.MessageDeframer.Listener
        public void messagesAvailable(StreamListener.MessageProducer messageProducer) {
            b().messagesAvailable(messageProducer);
        }

        public final void onSentBytes(int i) {
            boolean z;
            synchronized (this.onReadyLock) {
                Preconditions.checkState(this.allocated, "onStreamAllocated was not called, but it seems the stream is active");
                z = true;
                boolean z2 = this.numSentBytesQueued < 32768;
                this.numSentBytesQueued -= i;
                boolean z3 = this.numSentBytesQueued < 32768;
                if (z2 || !z3) {
                    z = false;
                }
            }
            if (z) {
                notifyIfReady();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void onStreamAllocated() {
            Preconditions.checkState(b() != null);
            synchronized (this.onReadyLock) {
                Preconditions.checkState(this.allocated ? false : true, "Already allocated");
                this.allocated = true;
            }
            notifyIfReady();
        }

        public final void requestMessagesFromDeframer(int i) {
            try {
                this.deframer.request(i);
            } catch (Throwable th) {
                deframeFailed(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        b().close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i) {
        c().onSendingBytes(i);
    }

    protected abstract Framer b();

    protected abstract TransportState c();

    @Override // io.grpc.internal.Stream
    public final void flush() {
        if (b().isClosed()) {
            return;
        }
        b().flush();
    }

    @Override // io.grpc.internal.Stream
    public boolean isReady() {
        if (b().isClosed()) {
            return false;
        }
        return c().isReady();
    }

    @Override // io.grpc.internal.Stream
    public final void setCompressor(Compressor compressor) {
        b().setCompressor((Compressor) Preconditions.checkNotNull(compressor, "compressor"));
    }

    @Override // io.grpc.internal.Stream
    public final void setMessageCompression(boolean z) {
        b().setMessageCompression(z);
    }

    @Override // io.grpc.internal.Stream
    public final void writeMessage(InputStream inputStream) {
        Preconditions.checkNotNull(inputStream, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        try {
            if (!b().isClosed()) {
                b().writePayload(inputStream);
            }
        } finally {
            GrpcUtil.closeQuietly(inputStream);
        }
    }
}
