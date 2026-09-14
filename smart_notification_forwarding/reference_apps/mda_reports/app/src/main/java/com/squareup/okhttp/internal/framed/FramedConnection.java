package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.framed.FrameReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

/* loaded from: classes2.dex */
public final class FramedConnection implements Closeable {
    private static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private static final ExecutorService executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp FramedConnection", true));
    final Protocol a;
    final boolean b;
    long c;
    private final Set<Integer> currentPushRequests;
    long d;
    Settings e;
    final Settings f;
    final Variant g;
    final Socket h;
    private final String hostName;
    final FrameWriter i;
    private long idleStartTimeNs;
    final Reader j;
    private int lastGoodStreamId;
    private final Listener listener;
    private int nextPingId;
    private int nextStreamId;
    private Map<Integer, Ping> pings;
    private final ExecutorService pushExecutor;
    private final PushObserver pushObserver;
    private boolean receivedInitialPeerSettings;
    private boolean shutdown;
    private final Map<Integer, FramedStream> streams;

    /* loaded from: classes2.dex */
    public static class Builder {
        private boolean client;
        private String hostName;
        private Listener listener = Listener.REFUSE_INCOMING_STREAMS;
        private Protocol protocol = Protocol.SPDY_3;
        private PushObserver pushObserver = PushObserver.CANCEL;
        private BufferedSink sink;
        private Socket socket;
        private BufferedSource source;

        public Builder(boolean z) {
            this.client = z;
        }

        public FramedConnection build() {
            return new FramedConnection(this);
        }

        public Builder listener(Listener listener) {
            this.listener = listener;
            return this;
        }

        public Builder protocol(Protocol protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder pushObserver(PushObserver pushObserver) {
            this.pushObserver = pushObserver;
            return this;
        }

        public Builder socket(Socket socket) {
            return socket(socket, ((InetSocketAddress) socket.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(socket)), Okio.buffer(Okio.sink(socket)));
        }

        public Builder socket(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.socket = socket;
            this.hostName = str;
            this.source = bufferedSource;
            this.sink = bufferedSink;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class Listener {
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener() { // from class: com.squareup.okhttp.internal.framed.FramedConnection.Listener.1
            @Override // com.squareup.okhttp.internal.framed.FramedConnection.Listener
            public void onStream(FramedStream framedStream) {
                framedStream.close(ErrorCode.REFUSED_STREAM);
            }
        };

        public void onSettings(FramedConnection framedConnection) {
        }

        public abstract void onStream(FramedStream framedStream);
    }

    /* loaded from: classes2.dex */
    class Reader extends NamedRunnable implements FrameReader.Handler {
        final FrameReader b;

        private Reader(FrameReader frameReader) {
            super("OkHttp %s", FramedConnection.this.hostName);
            this.b = frameReader;
        }

        private void ackSettingsLater(final Settings settings) {
            FramedConnection.executor.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{FramedConnection.this.hostName}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.Reader.3
                @Override // com.squareup.okhttp.internal.NamedRunnable
                public void execute() {
                    try {
                        FramedConnection.this.i.ackSettings(settings);
                    } catch (IOException unused) {
                    }
                }
            });
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void ackSettings() {
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j) {
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void data(boolean z, int i, BufferedSource bufferedSource, int i2) {
            if (FramedConnection.this.pushedStream(i)) {
                FramedConnection.this.pushDataLater(i, bufferedSource, i2, z);
                return;
            }
            FramedStream a = FramedConnection.this.a(i);
            if (a == null) {
                FramedConnection.this.b(i, ErrorCode.INVALID_STREAM);
                bufferedSource.skip(i2);
            } else {
                a.a(bufferedSource, i2);
                if (z) {
                    a.a();
                }
            }
        }

        @Override // com.squareup.okhttp.internal.NamedRunnable
        protected void execute() {
            ErrorCode errorCode;
            ErrorCode errorCode2;
            FramedConnection framedConnection;
            ErrorCode errorCode3 = ErrorCode.INTERNAL_ERROR;
            try {
                try {
                    try {
                        if (!FramedConnection.this.b) {
                            this.b.readConnectionPreface();
                        }
                        do {
                        } while (this.b.nextFrame(this));
                        errorCode2 = ErrorCode.NO_ERROR;
                        try {
                            errorCode3 = ErrorCode.CANCEL;
                            framedConnection = FramedConnection.this;
                        } catch (IOException unused) {
                            errorCode2 = ErrorCode.PROTOCOL_ERROR;
                            errorCode3 = ErrorCode.PROTOCOL_ERROR;
                            framedConnection = FramedConnection.this;
                            framedConnection.close(errorCode2, errorCode3);
                            Util.closeQuietly(this.b);
                        }
                    } catch (Throwable th) {
                        errorCode = errorCode2;
                        th = th;
                        try {
                            FramedConnection.this.close(errorCode, errorCode3);
                        } catch (IOException unused2) {
                        }
                        Util.closeQuietly(this.b);
                        throw th;
                    }
                } catch (IOException unused3) {
                } catch (Throwable th2) {
                    th = th2;
                    errorCode = errorCode3;
                    FramedConnection.this.close(errorCode, errorCode3);
                    Util.closeQuietly(this.b);
                    throw th;
                }
                framedConnection.close(errorCode2, errorCode3);
            } catch (IOException unused4) {
            }
            Util.closeQuietly(this.b);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void goAway(int i, ErrorCode errorCode, ByteString byteString) {
            FramedStream[] framedStreamArr;
            byteString.size();
            synchronized (FramedConnection.this) {
                framedStreamArr = (FramedStream[]) FramedConnection.this.streams.values().toArray(new FramedStream[FramedConnection.this.streams.size()]);
                FramedConnection.this.shutdown = true;
            }
            for (FramedStream framedStream : framedStreamArr) {
                if (framedStream.getId() > i && framedStream.isLocallyInitiated()) {
                    framedStream.a(ErrorCode.REFUSED_STREAM);
                    FramedConnection.this.b(framedStream.getId());
                }
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void headers(boolean z, boolean z2, int i, int i2, List<Header> list, HeadersMode headersMode) {
            if (FramedConnection.this.pushedStream(i)) {
                FramedConnection.this.pushHeadersLater(i, list, z2);
                return;
            }
            synchronized (FramedConnection.this) {
                if (FramedConnection.this.shutdown) {
                    return;
                }
                FramedStream a = FramedConnection.this.a(i);
                if (a != null) {
                    if (headersMode.failIfStreamPresent()) {
                        a.closeLater(ErrorCode.PROTOCOL_ERROR);
                        FramedConnection.this.b(i);
                        return;
                    } else {
                        a.a(list, headersMode);
                        if (z2) {
                            a.a();
                            return;
                        }
                        return;
                    }
                }
                if (headersMode.failIfStreamAbsent()) {
                    FramedConnection.this.b(i, ErrorCode.INVALID_STREAM);
                    return;
                }
                if (i <= FramedConnection.this.lastGoodStreamId) {
                    return;
                }
                if (i % 2 == FramedConnection.this.nextStreamId % 2) {
                    return;
                }
                final FramedStream framedStream = new FramedStream(i, FramedConnection.this, z, z2, list);
                FramedConnection.this.lastGoodStreamId = i;
                FramedConnection.this.streams.put(Integer.valueOf(i), framedStream);
                FramedConnection.executor.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{FramedConnection.this.hostName, Integer.valueOf(i)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.Reader.1
                    @Override // com.squareup.okhttp.internal.NamedRunnable
                    public void execute() {
                        try {
                            FramedConnection.this.listener.onStream(framedStream);
                        } catch (IOException e) {
                            Internal.logger.log(Level.INFO, "FramedConnection.Listener failure for " + FramedConnection.this.hostName, (Throwable) e);
                            try {
                                framedStream.close(ErrorCode.PROTOCOL_ERROR);
                            } catch (IOException unused) {
                            }
                        }
                    }
                });
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void ping(boolean z, int i, int i2) {
            if (!z) {
                FramedConnection.this.writePingLater(true, i, i2, null);
                return;
            }
            Ping removePing = FramedConnection.this.removePing(i);
            if (removePing != null) {
                removePing.b();
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void priority(int i, int i2, int i3, boolean z) {
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void pushPromise(int i, int i2, List<Header> list) {
            FramedConnection.this.pushRequestLater(i2, list);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void rstStream(int i, ErrorCode errorCode) {
            if (FramedConnection.this.pushedStream(i)) {
                FramedConnection.this.pushResetLater(i, errorCode);
                return;
            }
            FramedStream b = FramedConnection.this.b(i);
            if (b != null) {
                b.a(errorCode);
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void settings(boolean z, Settings settings) {
            FramedStream[] framedStreamArr;
            long j;
            int i;
            synchronized (FramedConnection.this) {
                int c = FramedConnection.this.f.c(65536);
                if (z) {
                    FramedConnection.this.f.a();
                }
                FramedConnection.this.f.a(settings);
                if (FramedConnection.this.getProtocol() == Protocol.HTTP_2) {
                    ackSettingsLater(settings);
                }
                int c2 = FramedConnection.this.f.c(65536);
                framedStreamArr = null;
                if (c2 == -1 || c2 == c) {
                    j = 0;
                } else {
                    j = c2 - c;
                    if (!FramedConnection.this.receivedInitialPeerSettings) {
                        FramedConnection.this.a(j);
                        FramedConnection.this.receivedInitialPeerSettings = true;
                    }
                    if (!FramedConnection.this.streams.isEmpty()) {
                        framedStreamArr = (FramedStream[]) FramedConnection.this.streams.values().toArray(new FramedStream[FramedConnection.this.streams.size()]);
                    }
                }
                FramedConnection.executor.execute(new NamedRunnable("OkHttp %s settings", FramedConnection.this.hostName) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.Reader.2
                    @Override // com.squareup.okhttp.internal.NamedRunnable
                    public void execute() {
                        FramedConnection.this.listener.onSettings(FramedConnection.this);
                    }
                });
            }
            if (framedStreamArr == null || j == 0) {
                return;
            }
            for (FramedStream framedStream : framedStreamArr) {
                synchronized (framedStream) {
                    framedStream.a(j);
                }
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void windowUpdate(int i, long j) {
            FramedConnection framedConnection = FramedConnection.this;
            if (i == 0) {
                synchronized (framedConnection) {
                    FramedConnection.this.d += j;
                    FramedConnection.this.notifyAll();
                }
                return;
            }
            FramedStream a = framedConnection.a(i);
            if (a != null) {
                synchronized (a) {
                    a.a(j);
                }
            }
        }
    }

    private FramedConnection(Builder builder) {
        this.streams = new HashMap();
        this.idleStartTimeNs = System.nanoTime();
        this.c = 0L;
        this.e = new Settings();
        this.f = new Settings();
        this.receivedInitialPeerSettings = false;
        this.currentPushRequests = new LinkedHashSet();
        this.a = builder.protocol;
        this.pushObserver = builder.pushObserver;
        this.b = builder.client;
        this.listener = builder.listener;
        this.nextStreamId = builder.client ? 1 : 2;
        if (builder.client && this.a == Protocol.HTTP_2) {
            this.nextStreamId += 2;
        }
        this.nextPingId = builder.client ? 1 : 2;
        if (builder.client) {
            this.e.a(7, 0, 16777216);
        }
        this.hostName = builder.hostName;
        Protocol protocol = this.a;
        if (protocol == Protocol.HTTP_2) {
            this.g = new Http2();
            this.pushExecutor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(String.format("OkHttp %s Push Observer", this.hostName), true));
            this.f.a(7, 0, 65535);
            this.f.a(5, 0, 16384);
        } else {
            if (protocol != Protocol.SPDY_3) {
                throw new AssertionError(protocol);
            }
            this.g = new Spdy3();
            this.pushExecutor = null;
        }
        this.d = this.f.c(65536);
        this.h = builder.socket;
        this.i = this.g.newWriter(builder.sink, this.b);
        this.j = new Reader(this.g.newReader(builder.source, this.b));
        new Thread(this.j).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close(ErrorCode errorCode, ErrorCode errorCode2) {
        int i;
        FramedStream[] framedStreamArr;
        Ping[] pingArr = null;
        try {
            shutdown(errorCode);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            if (this.streams.isEmpty()) {
                framedStreamArr = null;
            } else {
                framedStreamArr = (FramedStream[]) this.streams.values().toArray(new FramedStream[this.streams.size()]);
                this.streams.clear();
                setIdle(false);
            }
            if (this.pings != null) {
                Ping[] pingArr2 = (Ping[]) this.pings.values().toArray(new Ping[this.pings.size()]);
                this.pings = null;
                pingArr = pingArr2;
            }
        }
        if (framedStreamArr != null) {
            IOException iOException = e;
            for (FramedStream framedStream : framedStreamArr) {
                try {
                    framedStream.close(errorCode2);
                } catch (IOException e2) {
                    if (iOException != null) {
                        iOException = e2;
                    }
                }
            }
            e = iOException;
        }
        if (pingArr != null) {
            for (Ping ping : pingArr) {
                ping.a();
            }
        }
        try {
            this.i.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.h.close();
        } catch (IOException e4) {
            e = e4;
        }
        if (e != null) {
            throw e;
        }
    }

    private FramedStream newStream(int i, List<Header> list, boolean z, boolean z2) {
        int i2;
        FramedStream framedStream;
        boolean z3 = !z;
        boolean z4 = !z2;
        synchronized (this.i) {
            synchronized (this) {
                if (this.shutdown) {
                    throw new IOException("shutdown");
                }
                i2 = this.nextStreamId;
                this.nextStreamId += 2;
                framedStream = new FramedStream(i2, this, z3, z4, list);
                if (framedStream.isOpen()) {
                    this.streams.put(Integer.valueOf(i2), framedStream);
                    setIdle(false);
                }
            }
            if (i == 0) {
                this.i.synStream(z3, z4, i2, i, list);
            } else {
                if (this.b) {
                    throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                }
                this.i.pushPromise(i, i2, list);
            }
        }
        if (!z) {
            this.i.flush();
        }
        return framedStream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushDataLater(final int i, BufferedSource bufferedSource, final int i2, final boolean z) {
        final Buffer buffer = new Buffer();
        long j = i2;
        bufferedSource.require(j);
        bufferedSource.read(buffer, j);
        if (buffer.size() == j) {
            this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.hostName, Integer.valueOf(i)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.6
                @Override // com.squareup.okhttp.internal.NamedRunnable
                public void execute() {
                    try {
                        boolean onData = FramedConnection.this.pushObserver.onData(i, buffer, i2, z);
                        if (onData) {
                            FramedConnection.this.i.rstStream(i, ErrorCode.CANCEL);
                        }
                        if (onData || z) {
                            synchronized (FramedConnection.this) {
                                FramedConnection.this.currentPushRequests.remove(Integer.valueOf(i));
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

    /* JADX INFO: Access modifiers changed from: private */
    public void pushHeadersLater(final int i, final List<Header> list, final boolean z) {
        this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.hostName, Integer.valueOf(i)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.5
            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void execute() {
                boolean onHeaders = FramedConnection.this.pushObserver.onHeaders(i, list, z);
                if (onHeaders) {
                    try {
                        FramedConnection.this.i.rstStream(i, ErrorCode.CANCEL);
                    } catch (IOException unused) {
                        return;
                    }
                }
                if (onHeaders || z) {
                    synchronized (FramedConnection.this) {
                        FramedConnection.this.currentPushRequests.remove(Integer.valueOf(i));
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushRequestLater(final int i, final List<Header> list) {
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(i))) {
                b(i, ErrorCode.PROTOCOL_ERROR);
            } else {
                this.currentPushRequests.add(Integer.valueOf(i));
                this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[]{this.hostName, Integer.valueOf(i)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.4
                    @Override // com.squareup.okhttp.internal.NamedRunnable
                    public void execute() {
                        if (FramedConnection.this.pushObserver.onRequest(i, list)) {
                            try {
                                FramedConnection.this.i.rstStream(i, ErrorCode.CANCEL);
                                synchronized (FramedConnection.this) {
                                    FramedConnection.this.currentPushRequests.remove(Integer.valueOf(i));
                                }
                            } catch (IOException unused) {
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushResetLater(final int i, final ErrorCode errorCode) {
        this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.hostName, Integer.valueOf(i)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.7
            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void execute() {
                FramedConnection.this.pushObserver.onReset(i, errorCode);
                synchronized (FramedConnection.this) {
                    FramedConnection.this.currentPushRequests.remove(Integer.valueOf(i));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pushedStream(int i) {
        return this.a == Protocol.HTTP_2 && i != 0 && (i & 1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Ping removePing(int i) {
        return this.pings != null ? this.pings.remove(Integer.valueOf(i)) : null;
    }

    private synchronized void setIdle(boolean z) {
        long nanoTime;
        if (z) {
            try {
                nanoTime = System.nanoTime();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            nanoTime = Long.MAX_VALUE;
        }
        this.idleStartTimeNs = nanoTime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writePing(boolean z, int i, int i2, Ping ping) {
        synchronized (this.i) {
            if (ping != null) {
                ping.c();
            }
            this.i.ping(z, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writePingLater(final boolean z, final int i, final int i2, final Ping ping) {
        executor.execute(new NamedRunnable("OkHttp %s ping %08x%08x", new Object[]{this.hostName, Integer.valueOf(i), Integer.valueOf(i2)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.3
            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void execute() {
                try {
                    FramedConnection.this.writePing(z, i, i2, ping);
                } catch (IOException unused) {
                }
            }
        });
    }

    synchronized FramedStream a(int i) {
        return this.streams.get(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final int i, final long j) {
        executor.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.hostName, Integer.valueOf(i)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.2
            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void execute() {
                try {
                    FramedConnection.this.i.windowUpdate(i, j);
                } catch (IOException unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ErrorCode errorCode) {
        this.i.rstStream(i, errorCode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, boolean z, List<Header> list) {
        this.i.synReply(z, i, list);
    }

    void a(long j) {
        this.d += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized FramedStream b(int i) {
        FramedStream remove;
        remove = this.streams.remove(Integer.valueOf(i));
        if (remove != null && this.streams.isEmpty()) {
            setIdle(true);
        }
        notifyAll();
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(final int i, final ErrorCode errorCode) {
        executor.submit(new NamedRunnable("OkHttp %s stream %d", new Object[]{this.hostName, Integer.valueOf(i)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.1
            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void execute() {
                try {
                    FramedConnection.this.a(i, errorCode);
                } catch (IOException unused) {
                }
            }
        });
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    public void flush() {
        this.i.flush();
    }

    public synchronized long getIdleStartTimeNs() {
        return this.idleStartTimeNs;
    }

    public Protocol getProtocol() {
        return this.a;
    }

    public synchronized boolean isIdle() {
        return this.idleStartTimeNs != Long.MAX_VALUE;
    }

    public synchronized int maxConcurrentStreams() {
        return this.f.d(Integer.MAX_VALUE);
    }

    public FramedStream newStream(List<Header> list, boolean z, boolean z2) {
        return newStream(0, list, z, z2);
    }

    public synchronized int openStreamCount() {
        return this.streams.size();
    }

    public Ping ping() {
        int i;
        Ping ping = new Ping();
        synchronized (this) {
            if (this.shutdown) {
                throw new IOException("shutdown");
            }
            i = this.nextPingId;
            this.nextPingId += 2;
            if (this.pings == null) {
                this.pings = new HashMap();
            }
            this.pings.put(Integer.valueOf(i), ping);
        }
        writePing(false, i, 1330343787, ping);
        return ping;
    }

    public FramedStream pushStream(int i, List<Header> list, boolean z) {
        if (this.b) {
            throw new IllegalStateException("Client cannot push requests.");
        }
        if (this.a == Protocol.HTTP_2) {
            return newStream(i, list, z, false);
        }
        throw new IllegalStateException("protocol != HTTP_2");
    }

    public void sendConnectionPreface() {
        this.i.connectionPreface();
        this.i.settings(this.e);
        if (this.e.c(65536) != 65536) {
            this.i.windowUpdate(0, r0 - 65536);
        }
    }

    public void setSettings(Settings settings) {
        synchronized (this.i) {
            synchronized (this) {
                if (this.shutdown) {
                    throw new IOException("shutdown");
                }
                this.e.a(settings);
                this.i.settings(settings);
            }
        }
    }

    public void shutdown(ErrorCode errorCode) {
        synchronized (this.i) {
            synchronized (this) {
                if (this.shutdown) {
                    return;
                }
                this.shutdown = true;
                this.i.goAway(this.lastGoodStreamId, errorCode, Util.EMPTY_BYTE_ARRAY);
            }
        }
    }

    public void writeData(int i, boolean z, Buffer buffer, long j) {
        int min;
        long j2;
        if (j == 0) {
            this.i.data(z, i, buffer, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (this.d <= 0) {
                    try {
                        if (!this.streams.containsKey(Integer.valueOf(i))) {
                            throw new IOException("stream closed");
                        }
                        wait();
                    } catch (InterruptedException unused) {
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j, this.d), this.i.maxDataLength());
                j2 = min;
                this.d -= j2;
            }
            j -= j2;
            this.i.data(z && j == 0, i, buffer, min);
        }
    }
}
