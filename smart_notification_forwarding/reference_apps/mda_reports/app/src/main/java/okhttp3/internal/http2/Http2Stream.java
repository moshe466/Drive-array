package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Header;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* loaded from: classes3.dex */
public final class Http2Stream {
    long b;
    final int c;
    final Http2Connection d;
    final FramingSink e;
    private boolean hasResponseHeaders;
    private Header.Listener headersListener;
    private final FramingSource source;
    long a = 0;
    private final Deque<Headers> headersQueue = new ArrayDeque();
    final StreamTimeout f = new StreamTimeout();
    final StreamTimeout g = new StreamTimeout();
    ErrorCode h = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public final class FramingSink implements Sink {
        private static final long EMIT_BUFFER_SIZE = 16384;
        boolean a;
        boolean b;
        private final Buffer sendBuffer = new Buffer();

        FramingSink() {
        }

        private void emitFrame(boolean z) {
            long min;
            synchronized (Http2Stream.this) {
                Http2Stream.this.g.enter();
                while (Http2Stream.this.b <= 0 && !this.b && !this.a && Http2Stream.this.h == null) {
                    try {
                        Http2Stream.this.d();
                    } finally {
                    }
                }
                Http2Stream.this.g.exitAndThrowIfTimedOut();
                Http2Stream.this.b();
                min = Math.min(Http2Stream.this.b, this.sendBuffer.size());
                Http2Stream.this.b -= min;
            }
            Http2Stream.this.g.enter();
            try {
                Http2Stream.this.d.writeData(Http2Stream.this.c, z && min == this.sendBuffer.size(), this.sendBuffer, min);
            } finally {
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            synchronized (Http2Stream.this) {
                if (this.a) {
                    return;
                }
                if (!Http2Stream.this.e.b) {
                    if (this.sendBuffer.size() > 0) {
                        while (this.sendBuffer.size() > 0) {
                            emitFrame(true);
                        }
                    } else {
                        Http2Stream http2Stream = Http2Stream.this;
                        http2Stream.d.writeData(http2Stream.c, true, null, 0L);
                    }
                }
                synchronized (Http2Stream.this) {
                    this.a = true;
                }
                Http2Stream.this.d.flush();
                Http2Stream.this.a();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            synchronized (Http2Stream.this) {
                Http2Stream.this.b();
            }
            while (this.sendBuffer.size() > 0) {
                emitFrame(false);
                Http2Stream.this.d.flush();
            }
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return Http2Stream.this.g;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) {
            this.sendBuffer.write(buffer, j);
            while (this.sendBuffer.size() >= 16384) {
                emitFrame(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class FramingSource implements Source {
        boolean a;
        boolean b;
        private final long maxByteCount;
        private final Buffer receiveBuffer = new Buffer();
        private final Buffer readBuffer = new Buffer();

        FramingSource(long j) {
            this.maxByteCount = j;
        }

        private void updateConnectionFlowControl(long j) {
            Http2Stream.this.d.a(j);
        }

        void a(BufferedSource bufferedSource, long j) {
            boolean z;
            boolean z2;
            boolean z3;
            while (j > 0) {
                synchronized (Http2Stream.this) {
                    z = this.b;
                    z2 = true;
                    z3 = this.readBuffer.size() + j > this.maxByteCount;
                }
                if (z3) {
                    bufferedSource.skip(j);
                    Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
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
                synchronized (Http2Stream.this) {
                    if (this.readBuffer.size() != 0) {
                        z2 = false;
                    }
                    this.readBuffer.writeAll(this.receiveBuffer);
                    if (z2) {
                        Http2Stream.this.notifyAll();
                    }
                }
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            long size;
            ArrayList arrayList;
            Header.Listener listener;
            synchronized (Http2Stream.this) {
                this.a = true;
                size = this.readBuffer.size();
                this.readBuffer.clear();
                arrayList = null;
                if (Http2Stream.this.headersQueue.isEmpty() || Http2Stream.this.headersListener == null) {
                    listener = null;
                } else {
                    arrayList = new ArrayList(Http2Stream.this.headersQueue);
                    Http2Stream.this.headersQueue.clear();
                    listener = Http2Stream.this.headersListener;
                }
                Http2Stream.this.notifyAll();
            }
            if (size > 0) {
                updateConnectionFlowControl(size);
            }
            Http2Stream.this.a();
            if (listener != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    listener.onHeaders((Headers) it.next());
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x00cb, code lost:
        
            if (r11 == (-1)) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00cd, code lost:
        
            updateConnectionFlowControl(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00d0, code lost:
        
            return r11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00d1, code lost:
        
            if (r0 != null) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00d3, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00d9, code lost:
        
            throw new okhttp3.internal.http2.StreamResetException(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00e1, code lost:
        
            throw new java.io.IOException("stream closed");
         */
        @Override // okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public long read(okio.Buffer r18, long r19) {
            /*
                Method dump skipped, instructions count: 263
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.FramingSource.read(okio.Buffer, long):long");
        }

        @Override // okio.Source
        public Timeout timeout() {
            return Http2Stream.this.f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class StreamTimeout extends AsyncTimeout {
        StreamTimeout() {
        }

        @Override // okio.AsyncTimeout
        protected void a() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
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
    public Http2Stream(int i, Http2Connection http2Connection, boolean z, boolean z2, @Nullable Headers headers) {
        if (http2Connection == null) {
            throw new NullPointerException("connection == null");
        }
        this.c = i;
        this.d = http2Connection;
        this.b = http2Connection.l.c();
        this.source = new FramingSource(http2Connection.k.c());
        this.e = new FramingSink();
        this.source.b = z2;
        this.e.b = z;
        if (headers != null) {
            this.headersQueue.add(headers);
        }
        if (isLocallyInitiated() && headers != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!isLocallyInitiated() && headers == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    private boolean closeInternal(ErrorCode errorCode) {
        synchronized (this) {
            if (this.h != null) {
                return false;
            }
            if (this.source.b && this.e.b) {
                return false;
            }
            this.h = errorCode;
            notifyAll();
            this.d.c(this.c);
            return true;
        }
    }

    void a() {
        boolean z;
        boolean isOpen;
        synchronized (this) {
            z = !this.source.b && this.source.a && (this.e.b || this.e.a);
            isOpen = isOpen();
        }
        if (z) {
            close(ErrorCode.CANCEL);
        } else {
            if (isOpen) {
                return;
            }
            this.d.c(this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        this.b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<Header> list) {
        boolean isOpen;
        synchronized (this) {
            this.hasResponseHeaders = true;
            this.headersQueue.add(Util.toHeaders(list));
            isOpen = isOpen();
            notifyAll();
        }
        if (isOpen) {
            return;
        }
        this.d.c(this.c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(ErrorCode errorCode) {
        if (this.h == null) {
            this.h = errorCode;
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(BufferedSource bufferedSource, int i) {
        this.source.a(bufferedSource, i);
    }

    void b() {
        FramingSink framingSink = this.e;
        if (framingSink.a) {
            throw new IOException("stream closed");
        }
        if (framingSink.b) {
            throw new IOException("stream finished");
        }
        ErrorCode errorCode = this.h;
        if (errorCode != null) {
            throw new StreamResetException(errorCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        boolean isOpen;
        synchronized (this) {
            this.source.b = true;
            isOpen = isOpen();
            notifyAll();
        }
        if (isOpen) {
            return;
        }
        this.d.c(this.c);
    }

    public void close(ErrorCode errorCode) {
        if (closeInternal(errorCode)) {
            this.d.b(this.c, errorCode);
        }
    }

    public void closeLater(ErrorCode errorCode) {
        if (closeInternal(errorCode)) {
            this.d.c(this.c, errorCode);
        }
    }

    void d() {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public Http2Connection getConnection() {
        return this.d;
    }

    public synchronized ErrorCode getErrorCode() {
        return this.h;
    }

    public int getId() {
        return this.c;
    }

    public Sink getSink() {
        synchronized (this) {
            if (!this.hasResponseHeaders && !isLocallyInitiated()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.e;
    }

    public Source getSource() {
        return this.source;
    }

    public boolean isLocallyInitiated() {
        return this.d.a == ((this.c & 1) == 1);
    }

    public synchronized boolean isOpen() {
        if (this.h != null) {
            return false;
        }
        if ((this.source.b || this.source.a) && (this.e.b || this.e.a)) {
            if (this.hasResponseHeaders) {
                return false;
            }
        }
        return true;
    }

    public Timeout readTimeout() {
        return this.f;
    }

    public synchronized void setHeadersListener(Header.Listener listener) {
        this.headersListener = listener;
        if (!this.headersQueue.isEmpty() && listener != null) {
            notifyAll();
        }
    }

    public synchronized Headers takeHeaders() {
        this.f.enter();
        while (this.headersQueue.isEmpty() && this.h == null) {
            try {
                d();
            } catch (Throwable th) {
                this.f.exitAndThrowIfTimedOut();
                throw th;
            }
        }
        this.f.exitAndThrowIfTimedOut();
        if (this.headersQueue.isEmpty()) {
            throw new StreamResetException(this.h);
        }
        return this.headersQueue.removeFirst();
    }

    public void writeHeaders(List<Header> list, boolean z) {
        boolean z2;
        boolean z3;
        if (list == null) {
            throw new NullPointerException("headers == null");
        }
        synchronized (this) {
            this.hasResponseHeaders = true;
            if (z) {
                z2 = false;
                z3 = false;
            } else {
                this.e.b = true;
                z2 = true;
                z3 = true;
            }
        }
        if (!z2) {
            synchronized (this.d) {
                z2 = this.d.j == 0;
            }
        }
        this.d.a(this.c, z3, list);
        if (z2) {
            this.d.flush();
        }
    }

    public Timeout writeTimeout() {
        return this.g;
    }
}
