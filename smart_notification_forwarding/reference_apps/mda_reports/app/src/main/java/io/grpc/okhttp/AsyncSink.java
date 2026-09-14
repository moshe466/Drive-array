package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.grpc.internal.SerializingExecutor;
import io.grpc.okhttp.ExceptionHandlingFrameWriter;
import java.io.IOException;
import java.net.Socket;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class AsyncSink implements Sink {
    private final SerializingExecutor serializingExecutor;

    @Nullable
    private Sink sink;

    @Nullable
    private Socket socket;
    private final ExceptionHandlingFrameWriter.TransportExceptionHandler transportExceptionHandler;
    private final Object lock = new Object();
    private final Buffer buffer = new Buffer();

    @GuardedBy("lock")
    private boolean writeEnqueued = false;

    @GuardedBy("lock")
    private boolean flushEnqueued = false;
    private boolean closed = false;

    /* loaded from: classes2.dex */
    private abstract class WriteRunnable implements Runnable {
        private WriteRunnable() {
        }

        public abstract void doRun();

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (AsyncSink.this.sink == null) {
                    throw new IOException("Unable to perform write due to unavailable sink.");
                }
                doRun();
            } catch (Exception e) {
                AsyncSink.this.transportExceptionHandler.onException(e);
            }
        }
    }

    private AsyncSink(SerializingExecutor serializingExecutor, ExceptionHandlingFrameWriter.TransportExceptionHandler transportExceptionHandler) {
        this.serializingExecutor = (SerializingExecutor) Preconditions.checkNotNull(serializingExecutor, "executor");
        this.transportExceptionHandler = (ExceptionHandlingFrameWriter.TransportExceptionHandler) Preconditions.checkNotNull(transportExceptionHandler, "exceptionHandler");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AsyncSink a(SerializingExecutor serializingExecutor, ExceptionHandlingFrameWriter.TransportExceptionHandler transportExceptionHandler) {
        return new AsyncSink(serializingExecutor, transportExceptionHandler);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Sink sink, Socket socket) {
        Preconditions.checkState(this.sink == null, "AsyncSink's becomeConnected should only be called once.");
        this.sink = (Sink) Preconditions.checkNotNull(sink, "sink");
        this.socket = (Socket) Preconditions.checkNotNull(socket, "socket");
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.okhttp.AsyncSink.3
            @Override // java.lang.Runnable
            public void run() {
                AsyncSink.this.buffer.close();
                try {
                    if (AsyncSink.this.sink != null) {
                        AsyncSink.this.sink.close();
                    }
                } catch (IOException e) {
                    AsyncSink.this.transportExceptionHandler.onException(e);
                }
                try {
                    if (AsyncSink.this.socket != null) {
                        AsyncSink.this.socket.close();
                    }
                } catch (IOException e2) {
                    AsyncSink.this.transportExceptionHandler.onException(e2);
                }
            }
        });
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        if (this.closed) {
            throw new IOException("closed");
        }
        synchronized (this.lock) {
            if (this.flushEnqueued) {
                return;
            }
            this.flushEnqueued = true;
            this.serializingExecutor.execute(new WriteRunnable() { // from class: io.grpc.okhttp.AsyncSink.2
                @Override // io.grpc.okhttp.AsyncSink.WriteRunnable
                public void doRun() {
                    Buffer buffer = new Buffer();
                    synchronized (AsyncSink.this.lock) {
                        buffer.write(AsyncSink.this.buffer, AsyncSink.this.buffer.size());
                        AsyncSink.this.flushEnqueued = false;
                    }
                    AsyncSink.this.sink.write(buffer, buffer.size());
                    AsyncSink.this.sink.flush();
                }
            });
        }
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return Timeout.NONE;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) {
        Preconditions.checkNotNull(buffer, FirebaseAnalytics.Param.SOURCE);
        if (this.closed) {
            throw new IOException("closed");
        }
        synchronized (this.lock) {
            this.buffer.write(buffer, j);
            if (!this.writeEnqueued && !this.flushEnqueued && this.buffer.completeSegmentByteCount() > 0) {
                this.writeEnqueued = true;
                this.serializingExecutor.execute(new WriteRunnable() { // from class: io.grpc.okhttp.AsyncSink.1
                    @Override // io.grpc.okhttp.AsyncSink.WriteRunnable
                    public void doRun() {
                        Buffer buffer2 = new Buffer();
                        synchronized (AsyncSink.this.lock) {
                            buffer2.write(AsyncSink.this.buffer, AsyncSink.this.buffer.completeSegmentByteCount());
                            AsyncSink.this.writeEnqueued = false;
                        }
                        AsyncSink.this.sink.write(buffer2, buffer2.size());
                    }
                });
            }
        }
    }
}
