package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Http2Reader;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

/* loaded from: classes3.dex */
public final class Http2Connection implements Closeable {
    private static final ExecutorService listenerExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Http2Connection", true));
    final boolean a;
    private boolean awaitingPong;
    final Listener b;
    final String d;
    int e;
    int f;
    boolean g;
    final PushObserver h;
    long j;
    final Socket n;
    final Http2Writer o;
    final ReaderRunnable p;
    private final ExecutorService pushExecutor;
    private final ScheduledExecutorService writerExecutor;
    final Map<Integer, Http2Stream> c = new LinkedHashMap();
    long i = 0;
    Settings k = new Settings();
    final Settings l = new Settings();
    boolean m = false;
    final Set<Integer> q = new LinkedHashSet();

    /* loaded from: classes3.dex */
    public static class Builder {
        Socket a;
        String b;
        BufferedSource c;
        BufferedSink d;
        Listener e = Listener.REFUSE_INCOMING_STREAMS;
        PushObserver f = PushObserver.CANCEL;
        boolean g;
        int h;

        public Builder(boolean z) {
            this.g = z;
        }

        public Http2Connection build() {
            return new Http2Connection(this);
        }

        public Builder listener(Listener listener) {
            this.e = listener;
            return this;
        }

        public Builder pingIntervalMillis(int i) {
            this.h = i;
            return this;
        }

        public Builder pushObserver(PushObserver pushObserver) {
            this.f = pushObserver;
            return this;
        }

        public Builder socket(Socket socket) {
            return socket(socket, ((InetSocketAddress) socket.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(socket)), Okio.buffer(Okio.sink(socket)));
        }

        public Builder socket(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.a = socket;
            this.b = str;
            this.c = bufferedSource;
            this.d = bufferedSink;
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Listener {
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener() { // from class: okhttp3.internal.http2.Http2Connection.Listener.1
            @Override // okhttp3.internal.http2.Http2Connection.Listener
            public void onStream(Http2Stream http2Stream) {
                http2Stream.close(ErrorCode.REFUSED_STREAM);
            }
        };

        public void onSettings(Http2Connection http2Connection) {
        }

        public abstract void onStream(Http2Stream http2Stream);
    }

    /* loaded from: classes3.dex */
    final class PingRunnable extends NamedRunnable {
        final boolean b;
        final int c;
        final int d;

        PingRunnable(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", Http2Connection.this.d, Integer.valueOf(i), Integer.valueOf(i2));
            this.b = z;
            this.c = i;
            this.d = i2;
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            Http2Connection.this.a(this.b, this.c, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class ReaderRunnable extends NamedRunnable implements Http2Reader.Handler {
        final Http2Reader b;

        ReaderRunnable(Http2Reader http2Reader) {
            super("OkHttp %s", Http2Connection.this.d);
            this.b = http2Reader;
        }

        private void applyAndAckSettings(final Settings settings) {
            try {
                Http2Connection.this.writerExecutor.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{Http2Connection.this.d}) { // from class: okhttp3.internal.http2.Http2Connection.ReaderRunnable.3
                    @Override // okhttp3.internal.NamedRunnable
                    public void execute() {
                        try {
                            Http2Connection.this.o.applyAndAckSettings(settings);
                        } catch (IOException unused) {
                            Http2Connection.this.failConnection();
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j) {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void data(boolean z, int i, BufferedSource bufferedSource, int i2) {
            if (Http2Connection.this.b(i)) {
                Http2Connection.this.a(i, bufferedSource, i2, z);
                return;
            }
            Http2Stream a = Http2Connection.this.a(i);
            if (a == null) {
                Http2Connection.this.c(i, ErrorCode.PROTOCOL_ERROR);
                long j = i2;
                Http2Connection.this.a(j);
                bufferedSource.skip(j);
                return;
            }
            a.a(bufferedSource, i2);
            if (z) {
                a.c();
            }
        }

        @Override // okhttp3.internal.NamedRunnable
        protected void execute() {
            ErrorCode errorCode;
            Http2Connection http2Connection;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    this.b.readConnectionPreface(this);
                    do {
                    } while (this.b.nextFrame(false, this));
                    errorCode = ErrorCode.NO_ERROR;
                } catch (IOException unused) {
                }
                try {
                    errorCode2 = ErrorCode.CANCEL;
                    http2Connection = Http2Connection.this;
                } catch (IOException unused2) {
                    errorCode = ErrorCode.PROTOCOL_ERROR;
                    errorCode2 = ErrorCode.PROTOCOL_ERROR;
                    http2Connection = Http2Connection.this;
                    http2Connection.a(errorCode, errorCode2);
                    Util.closeQuietly(this.b);
                }
            } catch (IOException unused3) {
            } catch (Throwable th2) {
                th = th2;
                errorCode = errorCode2;
                try {
                    Http2Connection.this.a(errorCode, errorCode2);
                } catch (IOException unused4) {
                }
                Util.closeQuietly(this.b);
                throw th;
            }
            http2Connection.a(errorCode, errorCode2);
            Util.closeQuietly(this.b);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void goAway(int i, ErrorCode errorCode, ByteString byteString) {
            Http2Stream[] http2StreamArr;
            byteString.size();
            synchronized (Http2Connection.this) {
                http2StreamArr = (Http2Stream[]) Http2Connection.this.c.values().toArray(new Http2Stream[Http2Connection.this.c.size()]);
                Http2Connection.this.g = true;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.getId() > i && http2Stream.isLocallyInitiated()) {
                    http2Stream.a(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.c(http2Stream.getId());
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void headers(boolean z, int i, int i2, List<Header> list) {
            if (Http2Connection.this.b(i)) {
                Http2Connection.this.a(i, list, z);
                return;
            }
            synchronized (Http2Connection.this) {
                Http2Stream a = Http2Connection.this.a(i);
                if (a != null) {
                    a.a(list);
                    if (z) {
                        a.c();
                        return;
                    }
                    return;
                }
                if (Http2Connection.this.g) {
                    return;
                }
                if (i <= Http2Connection.this.e) {
                    return;
                }
                if (i % 2 == Http2Connection.this.f % 2) {
                    return;
                }
                final Http2Stream http2Stream = new Http2Stream(i, Http2Connection.this, false, z, Util.toHeaders(list));
                Http2Connection.this.e = i;
                Http2Connection.this.c.put(Integer.valueOf(i), http2Stream);
                Http2Connection.listenerExecutor.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{Http2Connection.this.d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.Http2Connection.ReaderRunnable.1
                    @Override // okhttp3.internal.NamedRunnable
                    public void execute() {
                        try {
                            Http2Connection.this.b.onStream(http2Stream);
                        } catch (IOException e) {
                            Platform.get().log(4, "Http2Connection.Listener failure for " + Http2Connection.this.d, e);
                            try {
                                http2Stream.close(ErrorCode.PROTOCOL_ERROR);
                            } catch (IOException unused) {
                            }
                        }
                    }
                });
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ping(boolean z, int i, int i2) {
            if (!z) {
                try {
                    Http2Connection.this.writerExecutor.execute(new PingRunnable(true, i, i2));
                } catch (RejectedExecutionException unused) {
                }
            } else {
                synchronized (Http2Connection.this) {
                    Http2Connection.this.awaitingPong = false;
                    Http2Connection.this.notifyAll();
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void priority(int i, int i2, int i3, boolean z) {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void pushPromise(int i, int i2, List<Header> list) {
            Http2Connection.this.a(i2, list);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void rstStream(int i, ErrorCode errorCode) {
            if (Http2Connection.this.b(i)) {
                Http2Connection.this.a(i, errorCode);
                return;
            }
            Http2Stream c = Http2Connection.this.c(i);
            if (c != null) {
                c.a(errorCode);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void settings(boolean z, Settings settings) {
            Http2Stream[] http2StreamArr;
            long j;
            int i;
            synchronized (Http2Connection.this) {
                int c = Http2Connection.this.l.c();
                if (z) {
                    Http2Connection.this.l.a();
                }
                Http2Connection.this.l.a(settings);
                applyAndAckSettings(settings);
                int c2 = Http2Connection.this.l.c();
                http2StreamArr = null;
                if (c2 == -1 || c2 == c) {
                    j = 0;
                } else {
                    j = c2 - c;
                    if (!Http2Connection.this.m) {
                        Http2Connection.this.m = true;
                    }
                    if (!Http2Connection.this.c.isEmpty()) {
                        http2StreamArr = (Http2Stream[]) Http2Connection.this.c.values().toArray(new Http2Stream[Http2Connection.this.c.size()]);
                    }
                }
                Http2Connection.listenerExecutor.execute(new NamedRunnable("OkHttp %s settings", Http2Connection.this.d) { // from class: okhttp3.internal.http2.Http2Connection.ReaderRunnable.2
                    @Override // okhttp3.internal.NamedRunnable
                    public void execute() {
                        Http2Connection http2Connection = Http2Connection.this;
                        http2Connection.b.onSettings(http2Connection);
                    }
                });
            }
            if (http2StreamArr == null || j == 0) {
                return;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                synchronized (http2Stream) {
                    http2Stream.a(j);
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void windowUpdate(int i, long j) {
            Http2Connection http2Connection = Http2Connection.this;
            if (i == 0) {
                synchronized (http2Connection) {
                    Http2Connection.this.j += j;
                    Http2Connection.this.notifyAll();
                }
                return;
            }
            Http2Stream a = http2Connection.a(i);
            if (a != null) {
                synchronized (a) {
                    a.a(j);
                }
            }
        }
    }

    Http2Connection(Builder builder) {
        this.h = builder.f;
        boolean z = builder.g;
        this.a = z;
        this.b = builder.e;
        this.f = z ? 1 : 2;
        if (builder.g) {
            this.f += 2;
        }
        if (builder.g) {
            this.k.a(7, 16777216);
        }
        this.d = builder.b;
        this.writerExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(Util.format("OkHttp %s Writer", this.d), false));
        if (builder.h != 0) {
            ScheduledExecutorService scheduledExecutorService = this.writerExecutor;
            PingRunnable pingRunnable = new PingRunnable(false, 0, 0);
            int i = builder.h;
            scheduledExecutorService.scheduleAtFixedRate(pingRunnable, i, i, TimeUnit.MILLISECONDS);
        }
        this.pushExecutor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(Util.format("OkHttp %s Push Observer", this.d), true));
        this.l.a(7, 65535);
        this.l.a(5, 16384);
        this.j = this.l.c();
        this.n = builder.a;
        this.o = new Http2Writer(builder.d, this.a);
        this.p = new ReaderRunnable(new Http2Reader(builder.c, this.a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failConnection() {
        try {
            a(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR);
        } catch (IOException unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0043 A[Catch: all -> 0x0075, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000e, B:9:0x0013, B:11:0x0017, B:13:0x002b, B:15:0x0033, B:19:0x003d, B:21:0x0043, B:22:0x004c, B:36:0x006f, B:37:0x0074), top: B:5:0x0007, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private okhttp3.internal.http2.Http2Stream newStream(int r11, java.util.List<okhttp3.internal.http2.Header> r12, boolean r13) {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            okhttp3.internal.http2.Http2Writer r7 = r10.o
            monitor-enter(r7)
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L78
            int r0 = r10.f     // Catch: java.lang.Throwable -> L75
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L13
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch: java.lang.Throwable -> L75
            r10.shutdown(r0)     // Catch: java.lang.Throwable -> L75
        L13:
            boolean r0 = r10.g     // Catch: java.lang.Throwable -> L75
            if (r0 != 0) goto L6f
            int r8 = r10.f     // Catch: java.lang.Throwable -> L75
            int r0 = r10.f     // Catch: java.lang.Throwable -> L75
            int r0 = r0 + 2
            r10.f = r0     // Catch: java.lang.Throwable -> L75
            okhttp3.internal.http2.Http2Stream r9 = new okhttp3.internal.http2.Http2Stream     // Catch: java.lang.Throwable -> L75
            r5 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L75
            if (r13 == 0) goto L3c
            long r0 = r10.j     // Catch: java.lang.Throwable -> L75
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L3c
            long r0 = r9.b     // Catch: java.lang.Throwable -> L75
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L3a
            goto L3c
        L3a:
            r13 = 0
            goto L3d
        L3c:
            r13 = 1
        L3d:
            boolean r0 = r9.isOpen()     // Catch: java.lang.Throwable -> L75
            if (r0 == 0) goto L4c
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r0 = r10.c     // Catch: java.lang.Throwable -> L75
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L75
            r0.put(r1, r9)     // Catch: java.lang.Throwable -> L75
        L4c:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L75
            if (r11 != 0) goto L55
            okhttp3.internal.http2.Http2Writer r0 = r10.o     // Catch: java.lang.Throwable -> L78
            r0.synStream(r6, r8, r11, r12)     // Catch: java.lang.Throwable -> L78
            goto L5e
        L55:
            boolean r0 = r10.a     // Catch: java.lang.Throwable -> L78
            if (r0 != 0) goto L67
            okhttp3.internal.http2.Http2Writer r0 = r10.o     // Catch: java.lang.Throwable -> L78
            r0.pushPromise(r11, r8, r12)     // Catch: java.lang.Throwable -> L78
        L5e:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L78
            if (r13 == 0) goto L66
            okhttp3.internal.http2.Http2Writer r11 = r10.o
            r11.flush()
        L66:
            return r9
        L67:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L78
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch: java.lang.Throwable -> L78
            throw r11     // Catch: java.lang.Throwable -> L78
        L6f:
            okhttp3.internal.http2.ConnectionShutdownException r11 = new okhttp3.internal.http2.ConnectionShutdownException     // Catch: java.lang.Throwable -> L75
            r11.<init>()     // Catch: java.lang.Throwable -> L75
            throw r11     // Catch: java.lang.Throwable -> L75
        L75:
            r11 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L75
            throw r11     // Catch: java.lang.Throwable -> L78
        L78:
            r11 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L78
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.newStream(int, java.util.List, boolean):okhttp3.internal.http2.Http2Stream");
    }

    private synchronized void pushExecutorExecute(NamedRunnable namedRunnable) {
        if (!isShutdown()) {
            this.pushExecutor.execute(namedRunnable);
        }
    }

    synchronized Http2Stream a(int i) {
        return this.c.get(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final int i, final long j) {
        try {
            this.writerExecutor.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.Http2Connection.2
                @Override // okhttp3.internal.NamedRunnable
                public void execute() {
                    try {
                        Http2Connection.this.o.windowUpdate(i, j);
                    } catch (IOException unused) {
                        Http2Connection.this.failConnection();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    void a(final int i, final List<Header> list) {
        synchronized (this) {
            if (this.q.contains(Integer.valueOf(i))) {
                c(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.q.add(Integer.valueOf(i));
            try {
                pushExecutorExecute(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[]{this.d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.Http2Connection.3
                    @Override // okhttp3.internal.NamedRunnable
                    public void execute() {
                        if (Http2Connection.this.h.onRequest(i, list)) {
                            try {
                                Http2Connection.this.o.rstStream(i, ErrorCode.CANCEL);
                                synchronized (Http2Connection.this) {
                                    Http2Connection.this.q.remove(Integer.valueOf(i));
                                }
                            } catch (IOException unused) {
                            }
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    void a(final int i, final List<Header> list, final boolean z) {
        try {
            pushExecutorExecute(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.Http2Connection.4
                @Override // okhttp3.internal.NamedRunnable
                public void execute() {
                    boolean onHeaders = Http2Connection.this.h.onHeaders(i, list, z);
                    if (onHeaders) {
                        try {
                            Http2Connection.this.o.rstStream(i, ErrorCode.CANCEL);
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    if (onHeaders || z) {
                        synchronized (Http2Connection.this) {
                            Http2Connection.this.q.remove(Integer.valueOf(i));
                        }
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    void a(final int i, final ErrorCode errorCode) {
        pushExecutorExecute(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.Http2Connection.6
            @Override // okhttp3.internal.NamedRunnable
            public void execute() {
                Http2Connection.this.h.onReset(i, errorCode);
                synchronized (Http2Connection.this) {
                    Http2Connection.this.q.remove(Integer.valueOf(i));
                }
            }
        });
    }

    void a(final int i, BufferedSource bufferedSource, final int i2, final boolean z) {
        final Buffer buffer = new Buffer();
        long j = i2;
        bufferedSource.require(j);
        bufferedSource.read(buffer, j);
        if (buffer.size() == j) {
            pushExecutorExecute(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.Http2Connection.5
                @Override // okhttp3.internal.NamedRunnable
                public void execute() {
                    try {
                        boolean onData = Http2Connection.this.h.onData(i, buffer, i2, z);
                        if (onData) {
                            Http2Connection.this.o.rstStream(i, ErrorCode.CANCEL);
                        }
                        if (onData || z) {
                            synchronized (Http2Connection.this) {
                                Http2Connection.this.q.remove(Integer.valueOf(i));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(buffer.size() + " != " + i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, boolean z, List<Header> list) {
        this.o.synReply(z, i, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(long j) {
        this.i += j;
        if (this.i >= this.k.c() / 2) {
            a(0, this.i);
            this.i = 0L;
        }
    }

    void a(ErrorCode errorCode, ErrorCode errorCode2) {
        Http2Stream[] http2StreamArr = null;
        try {
            shutdown(errorCode);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            if (!this.c.isEmpty()) {
                http2StreamArr = (Http2Stream[]) this.c.values().toArray(new Http2Stream[this.c.size()]);
                this.c.clear();
            }
        }
        if (http2StreamArr != null) {
            for (Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.close(errorCode2);
                } catch (IOException e2) {
                    if (e != null) {
                        e = e2;
                    }
                }
            }
        }
        try {
            this.o.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.n.close();
        } catch (IOException e4) {
            e = e4;
        }
        this.writerExecutor.shutdown();
        this.pushExecutor.shutdown();
        if (e != null) {
            throw e;
        }
    }

    void a(boolean z) {
        if (z) {
            this.o.connectionPreface();
            this.o.settings(this.k);
            if (this.k.c() != 65535) {
                this.o.windowUpdate(0, r6 - 65535);
            }
        }
        new Thread(this.p).start();
    }

    void a(boolean z, int i, int i2) {
        boolean z2;
        if (!z) {
            synchronized (this) {
                z2 = this.awaitingPong;
                this.awaitingPong = true;
            }
            if (z2) {
                failConnection();
                return;
            }
        }
        try {
            this.o.ping(z, i, i2);
        } catch (IOException unused) {
            failConnection();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i, ErrorCode errorCode) {
        this.o.rstStream(i, errorCode);
    }

    boolean b(int i) {
        return i != 0 && (i & 1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Http2Stream c(int i) {
        Http2Stream remove;
        remove = this.c.remove(Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(final int i, final ErrorCode errorCode) {
        try {
            this.writerExecutor.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{this.d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.Http2Connection.1
                @Override // okhttp3.internal.NamedRunnable
                public void execute() {
                    try {
                        Http2Connection.this.b(i, errorCode);
                    } catch (IOException unused) {
                        Http2Connection.this.failConnection();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    public void flush() {
        this.o.flush();
    }

    public Protocol getProtocol() {
        return Protocol.HTTP_2;
    }

    public synchronized boolean isShutdown() {
        return this.g;
    }

    public synchronized int maxConcurrentStreams() {
        return this.l.b(Integer.MAX_VALUE);
    }

    public Http2Stream newStream(List<Header> list, boolean z) {
        return newStream(0, list, z);
    }

    public synchronized int openStreamCount() {
        return this.c.size();
    }

    public Http2Stream pushStream(int i, List<Header> list, boolean z) {
        if (this.a) {
            throw new IllegalStateException("Client cannot push requests.");
        }
        return newStream(i, list, z);
    }

    public void setSettings(Settings settings) {
        synchronized (this.o) {
            synchronized (this) {
                if (this.g) {
                    throw new ConnectionShutdownException();
                }
                this.k.a(settings);
            }
            this.o.settings(settings);
        }
    }

    public void shutdown(ErrorCode errorCode) {
        synchronized (this.o) {
            synchronized (this) {
                if (this.g) {
                    return;
                }
                this.g = true;
                this.o.goAway(this.e, errorCode, Util.EMPTY_BYTE_ARRAY);
            }
        }
    }

    public void start() {
        a(true);
    }

    public void writeData(int i, boolean z, Buffer buffer, long j) {
        int min;
        long j2;
        if (j == 0) {
            this.o.data(z, i, buffer, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (this.j <= 0) {
                    try {
                        if (!this.c.containsKey(Integer.valueOf(i))) {
                            throw new IOException("stream closed");
                        }
                        wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j, this.j), this.o.maxDataLength());
                j2 = min;
                this.j -= j2;
            }
            j -= j2;
            this.o.data(z && j == 0, i, buffer, min);
        }
    }
}
