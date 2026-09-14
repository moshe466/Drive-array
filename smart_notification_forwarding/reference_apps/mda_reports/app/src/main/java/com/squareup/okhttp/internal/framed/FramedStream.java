package com.squareup.okhttp.internal.framed;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* loaded from: classes2.dex */
public final class FramedStream {
    long b;
    final FramedDataSink c;
    private final FramedConnection connection;
    private final int id;
    private final List<Header> requestHeaders;
    private List<Header> responseHeaders;
    private final FramedDataSource source;
    long a = 0;
    private final StreamTimeout readTimeout = new StreamTimeout();
    private final StreamTimeout writeTimeout = new StreamTimeout();
    private ErrorCode errorCode = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class FramedDataSink implements Sink {
        private static final long EMIT_BUFFER_SIZE = 16384;
        private boolean closed;
        private boolean finished;
        private final Buffer sendBuffer = new Buffer();

        FramedDataSink() {
        }

        private void emitDataFrame(boolean z) {
            long min;
            synchronized (FramedStream.this) {
                FramedStream.this.writeTimeout.enter();
                while (FramedStream.this.b <= 0 && !this.finished && !this.closed && FramedStream.this.errorCode == null) {
                    try {
                        FramedStream.this.waitForIo();
                    } finally {
                    }
                }
                FramedStream.this.writeTimeout.exitAndThrowIfTimedOut();
                FramedStream.this.checkOutNotClosed();
                min = Math.min(FramedStream.this.b, this.sendBuffer.size());
                FramedStream.this.b -= min;
            }
            FramedStream.this.writeTimeout.enter();
            try {
                FramedStream.this.connection.writeData(FramedStream.this.id, z && min == this.sendBuffer.size(), this.sendBuffer, min);
            } finally {
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            synchronized (FramedStream.this) {
                if (this.closed) {
                    return;
                }
                if (!FramedStream.this.c.finished) {
                    if (this.sendBuffer.size() > 0) {
                        while (this.sendBuffer.size() > 0) {
                            emitDataFrame(true);
                        }
                    } else {
                        FramedStream.this.connection.writeData(FramedStream.this.id, true, null, 0L);
                    }
                }
                synchronized (FramedStream.this) {
                    this.closed = true;
                }
                FramedStream.this.connection.flush();
                FramedStream.this.cancelStreamIfNecessary();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            synchronized (FramedStream.this) {
                FramedStream.this.checkOutNotClosed();
            }
            while (this.sendBuffer.size() > 0) {
                emitDataFrame(false);
                FramedStream.this.connection.flush();
            }
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return FramedStream.this.writeTimeout;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) {
            this.sendBuffer.write(buffer, j);
            while (this.sendBuffer.size() >= 16384) {
                emitDataFrame(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class FramedDataSource implements Source {
        private boolean closed;
        private boolean finished;
        private final long maxByteCount;
        private final Buffer readBuffer;
        private final Buffer receiveBuffer;

        private FramedDataSource(long j) {
            this.receiveBuffer = new Buffer();
            this.readBuffer = new Buffer();
            this.maxByteCount = j;
        }

        private void checkNotClosed() {
            if (this.closed) {
                throw new IOException("stream closed");
            }
            if (FramedStream.this.errorCode == null) {
                return;
            }
            throw new IOException("stream was reset: " + FramedStream.this.errorCode);
        }

        private void waitUntilReadable() {
            FramedStream.this.readTimeout.enter();
            while (this.readBuffer.size() == 0 && !this.finished && !this.closed && FramedStream.this.errorCode == null) {
                try {
                    FramedStream.this.waitForIo();
                } finally {
                    FramedStream.this.readTimeout.exitAndThrowIfTimedOut();
                }
            }
        }

        void a(BufferedSource bufferedSource, long j) {
            boolean z;
            boolean z2;
            boolean z3;
            while (j > 0) {
                synchronized (FramedStream.this) {
                    z = this.finished;
                    z2 = true;
                    z3 = this.readBuffer.size() + j > this.maxByteCount;
                }
                if (z3) {
                    bufferedSource.skip(j);
                    FramedStream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    bufferedSource.skip(j);
                    return;
                }
                long read = bufferedSource.read(this.receiveBuffer, j);
                if (read == -1) {
                    throw new EOFException();
                }
                j -= read;
                synchronized (FramedStream.this) {
                    if (this.readBuffer.size() != 0) {
                        z2 = false;
                    }
                    this.readBuffer.writeAll(this.receiveBuffer);
                    if (z2) {
                        FramedStream.this.notifyAll();
                    }
                }
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            synchronized (FramedStream.this) {
                this.closed = true;
                this.readBuffer.clear();
                FramedStream.this.notifyAll();
            }
            FramedStream.this.cancelStreamIfNecessary();
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            synchronized (FramedStream.this) {
                waitUntilReadable();
                checkNotClosed();
                if (this.readBuffer.size() == 0) {
                    return -1L;
                }
                long read = this.readBuffer.read(buffer, Math.min(j, this.readBuffer.size()));
                FramedStream.this.a += read;
                if (FramedStream.this.a >= FramedStream.this.connection.e.c(65536) / 2) {
                    FramedStream.this.connection.a(FramedStream.this.id, FramedStream.this.a);
                    FramedStream.this.a = 0L;
                }
                synchronized (FramedStream.this.connection) {
                    FramedStream.this.connection.c += read;
                    if (FramedStream.this.connection.c >= FramedStream.this.connection.e.c(65536) / 2) {
                        FramedStream.this.connection.a(0, FramedStream.this.connection.c);
                        FramedStream.this.connection.c = 0L;
                    }
                }
                return read;
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return FramedStream.this.readTimeout;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class StreamTimeout extends AsyncTimeout {
        StreamTimeout() {
        }

        @Override // okio.AsyncTimeout
        protected void a() {
            FramedStream.this.closeLater(ErrorCode.CANCEL);
        }

        @Override // okio.AsyncTimeout
        protected IOException b(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void exitAndThrowIfTimedOut() {
            if (exit()) {
                throw b(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FramedStream(int i, FramedConnection framedConnection, boolean z, boolean z2, List<Header> list) {
        if (framedConnection == null) {
            throw new NullPointerException("connection == null");
        }
        if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.id = i;
        this.connection = framedConnection;
        this.b = framedConnection.f.c(65536);
        this.source = new FramedDataSource(framedConnection.e.c(65536));
        this.c = new FramedDataSink();
        this.source.finished = z2;
        this.c.finished = z;
        this.requestHeaders = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelStreamIfNecessary() {
        boolean z;
        boolean isOpen;
        synchronized (this) {
            z = !this.source.finished && this.source.closed && (this.c.finished || this.c.closed);
            isOpen = isOpen();
        }
        if (z) {
            close(ErrorCode.CANCEL);
        } else {
            if (isOpen) {
                return;
            }
            this.connection.b(this.id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkOutNotClosed() {
        if (this.c.closed) {
            throw new IOException("stream closed");
        }
        if (this.c.finished) {
            throw new IOException("stream finished");
        }
        if (this.errorCode == null) {
            return;
        }
        throw new IOException("stream was reset: " + this.errorCode);
    }

    private boolean closeInternal(ErrorCode errorCode) {
        synchronized (this) {
            if (this.errorCode != null) {
                return false;
            }
            if (this.source.finished && this.c.finished) {
                return false;
            }
            this.errorCode = errorCode;
            notifyAll();
            this.connection.b(this.id);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void waitForIo() {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        boolean isOpen;
        synchronized (this) {
            this.source.finished = true;
            isOpen = isOpen();
            notifyAll();
        }
        if (isOpen) {
            return;
        }
        this.connection.b(this.id);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        this.b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(ErrorCode errorCode) {
        if (this.errorCode == null) {
            this.errorCode = errorCode;
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<Header> list, HeadersMode headersMode) {
        ErrorCode errorCode = null;
        boolean z = true;
        synchronized (this) {
            if (this.responseHeaders == null) {
                if (headersMode.failIfHeadersAbsent()) {
                    errorCode = ErrorCode.PROTOCOL_ERROR;
                } else {
                    this.responseHeaders = list;
                    z = isOpen();
                    notifyAll();
                }
            } else if (headersMode.failIfHeadersPresent()) {
                errorCode = ErrorCode.STREAM_IN_USE;
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.responseHeaders);
                arrayList.addAll(list);
                this.responseHeaders = arrayList;
            }
        }
        if (errorCode != null) {
            closeLater(errorCode);
        } else {
            if (z) {
                return;
            }
            this.connection.b(this.id);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(BufferedSource bufferedSource, int i) {
        this.source.a(bufferedSource, i);
    }

    public void close(ErrorCode errorCode) {
        if (closeInternal(errorCode)) {
            this.connection.a(this.id, errorCode);
        }
    }

    public void closeLater(ErrorCode errorCode) {
        if (closeInternal(errorCode)) {
            this.connection.b(this.id, errorCode);
        }
    }

    public FramedConnection getConnection() {
        return this.connection;
    }

    public synchronized ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public int getId() {
        return this.id;
    }

    public List<Header> getRequestHeaders() {
        return this.requestHeaders;
    }

    public synchronized List<Header> getResponseHeaders() {
        this.readTimeout.enter();
        while (this.responseHeaders == null && this.errorCode == null) {
            try {
                waitForIo();
            } catch (Throwable th) {
                this.readTimeout.exitAndThrowIfTimedOut();
                throw th;
            }
        }
        this.readTimeout.exitAndThrowIfTimedOut();
        if (this.responseHeaders == null) {
            throw new IOException("stream was reset: " + this.errorCode);
        }
        return this.responseHeaders;
    }

    public Sink getSink() {
        synchronized (this) {
            if (this.responseHeaders == null && !isLocallyInitiated()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.c;
    }

    public Source getSource() {
        return this.source;
    }

    public boolean isLocallyInitiated() {
        return this.connection.b == ((this.id & 1) == 1);
    }

    public synchronized boolean isOpen() {
        if (this.errorCode != null) {
            return false;
        }
        if ((this.source.finished || this.source.closed) && (this.c.finished || this.c.closed)) {
            if (this.responseHeaders != null) {
                return false;
            }
        }
        return true;
    }

    public Timeout readTimeout() {
        return this.readTimeout;
    }

    public void reply(List<Header> list, boolean z) {
        boolean z2 = false;
        synchronized (this) {
            try {
                if (list == null) {
                    throw new NullPointerException("responseHeaders == null");
                }
                if (this.responseHeaders != null) {
                    throw new IllegalStateException("reply already sent");
                }
                this.responseHeaders = list;
                if (!z) {
                    this.c.finished = true;
                    z2 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.connection.a(this.id, z2, list);
        if (z2) {
            this.connection.flush();
        }
    }

    public Timeout writeTimeout() {
        return this.writeTimeout;
    }
}
