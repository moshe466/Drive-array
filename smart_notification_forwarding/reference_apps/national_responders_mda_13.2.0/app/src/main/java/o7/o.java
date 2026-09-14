package o7;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.Thread;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public class o implements q {

    /* renamed from: l, reason: collision with root package name */
    static String f12594l = "ServerWrite";

    /* renamed from: m, reason: collision with root package name */
    private static final g f12595m = new a();

    /* renamed from: n, reason: collision with root package name */
    protected static Map<Integer, Integer> f12596n = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private final String f12597a;

    /* renamed from: b, reason: collision with root package name */
    private volatile SocketChannel f12598b;

    /* renamed from: c, reason: collision with root package name */
    private Map<Integer, m> f12599c;

    /* renamed from: d, reason: collision with root package name */
    private Queue<ByteBuffer> f12600d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f12601e;

    /* renamed from: f, reason: collision with root package name */
    private Timer f12602f;

    /* renamed from: g, reason: collision with root package name */
    private n f12603g;

    /* renamed from: h, reason: collision with root package name */
    private ReentrantReadWriteLock f12604h;

    /* renamed from: i, reason: collision with root package name */
    private Lock f12605i;

    /* renamed from: j, reason: collision with root package name */
    private Lock f12606j;

    /* renamed from: k, reason: collision with root package name */
    private h f12607k;

    /* loaded from: classes.dex */
    static class a implements g {
        a() {
        }

        @Override // o7.g
        public void b(int i10, String str) {
        }

        @Override // o7.g
        public void c(com.google.gson.n nVar) {
        }

        @Override // o7.g
        public void d() {
        }
    }

    /* loaded from: classes.dex */
    class b extends TimerTask {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f12608f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.google.gson.n f12609g;

        b(int i10, com.google.gson.n nVar) {
            this.f12608f = i10;
            this.f12609g = nVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            m j10 = o.this.j(this.f12608f);
            if (j10 != null) {
                try {
                    v7.b.a("callApi", "Timeout");
                    j10.b();
                    return;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return;
                }
            }
            if (this.f12609g.B("reqType").s().equals("keepAlive")) {
                return;
            }
            v7.b.c(o.f12594l, "{" + o.this.f12597a + "} response for " + this.f12609g.toString() + " was received in time");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.google.gson.n f12611f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ g f12612g;

        c(com.google.gson.n nVar, g gVar) {
            this.f12611f = nVar;
            this.f12612g = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ByteBuffer byteBuffer;
            try {
                ByteBuffer wrap = ByteBuffer.wrap((new com.google.gson.e().q(this.f12611f) + '\n').getBytes("UTF-8"));
                wrap.rewind();
                synchronized (o.this.f12600d) {
                    if (o.this.f12601e) {
                        o.this.f12600d.add(wrap);
                        return;
                    }
                    o.this.f12601e = true;
                    while (true) {
                        try {
                            try {
                                o.this.f12598b.write(wrap);
                                com.google.gson.k B = this.f12611f.B("reqType");
                                if (B == null || !B.s().equals("keepAlive")) {
                                    v7.b.c(o.f12594l, "{" + o.this.f12597a + "}.write.run thread wrote " + new String(wrap.array(), "UTF-8"));
                                }
                                wrap.rewind();
                                synchronized (o.this.f12600d) {
                                    byteBuffer = (ByteBuffer) o.this.f12600d.poll();
                                }
                                if (byteBuffer == null) {
                                    synchronized (o.this.f12600d) {
                                        o.this.f12601e = false;
                                    }
                                    return;
                                }
                                wrap = byteBuffer;
                            } catch (Exception e10) {
                                v7.b.c(o.f12594l, "{" + o.this.f12597a + "}.write.run thread SocketChannel.write threw exception " + e10.getMessage());
                                try {
                                    o.this.f12598b.close();
                                } catch (Exception unused) {
                                }
                                o.this.j(this.f12611f.B("reqId").c());
                                this.f12612g.b(71, "Network write operation failes");
                                synchronized (o.this.f12600d) {
                                    o.this.f12601e = false;
                                    return;
                                }
                            }
                        } catch (Throwable th) {
                            synchronized (o.this.f12600d) {
                                o.this.f12601e = false;
                                throw th;
                            }
                        }
                    }
                }
            } catch (UnsupportedEncodingException e11) {
                v7.b.c(o.f12594l, "{" + o.this.f12597a + "}.write.run thread ByteBuffer.put threw " + e11.getMessage());
                o.this.j(this.f12611f.B("reqId").c());
                this.f12612g.b(70, "System error");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements Thread.UncaughtExceptionHandler {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.gson.n f12614a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f12615b;

        d(com.google.gson.n nVar, g gVar) {
            this.f12614a = nVar;
            this.f12615b = gVar;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            v7.b.c(o.f12594l, "{" + o.this.f12597a + "}.write.run thread uncaught exception: " + th);
            th.printStackTrace();
            o.this.j(this.f12614a.B("reqId").c());
            this.f12615b.b(72, "Networking general error");
        }
    }

    public o(SocketChannel socketChannel, String str) {
        ic.c.i(o.class.getSimpleName());
        this.f12599c = new HashMap();
        this.f12600d = new LinkedList();
        this.f12601e = false;
        this.f12602f = new Timer();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f12604h = reentrantReadWriteLock;
        this.f12605i = reentrantReadWriteLock.readLock();
        this.f12606j = this.f12604h.writeLock();
        this.f12598b = socketChannel;
        this.f12597a = str;
    }

    private void p(com.google.gson.n nVar, g gVar) {
        Thread thread = new Thread(new c(nVar, gVar));
        thread.setUncaughtExceptionHandler(new d(nVar, gVar));
        synchronized (this) {
            if (this.f12598b.isConnected()) {
                thread.start();
            } else {
                v7.b.c(f12594l, "{" + this.f12597a + "}.write socket is not connected");
                j(nVar.B("reqId").c());
                gVar.b(73, "Network is not available");
            }
        }
    }

    @Override // o7.q
    public void a() {
        synchronized (this) {
            try {
                this.f12598b.close();
            } catch (Exception unused) {
            }
        }
        try {
            this.f12605i.lock();
            h hVar = this.f12607k;
            if (hVar != null) {
                hVar.a(false);
            }
        } finally {
            this.f12605i.unlock();
        }
    }

    @Override // o7.q
    public void b(SocketChannel socketChannel) {
        synchronized (this) {
            this.f12598b = socketChannel;
        }
        try {
            this.f12605i.lock();
            h hVar = this.f12607k;
            if (hVar != null) {
                hVar.a(true);
            }
        } finally {
            this.f12605i.unlock();
        }
    }

    public void h(com.google.gson.n nVar, g gVar, long j10) {
        int nextInt;
        if (gVar == null) {
            gVar = f12595m;
        }
        v7.b.c("callApi", "function: " + nVar.B("reqType"));
        do {
            nextInt = new Random().nextInt(1000000000);
        } while (this.f12599c.containsKey(Integer.valueOf(nextInt)));
        nVar.y("reqId", Integer.valueOf(nextInt));
        m mVar = new m(nVar, gVar);
        synchronized (this.f12599c) {
            this.f12599c.put(Integer.valueOf(nextInt), mVar);
        }
        p(nVar, gVar);
        this.f12602f.schedule(new b(nextInt, nVar), j10);
    }

    public synchronized void i() {
        try {
            this.f12598b.close();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public m j(int i10) {
        m remove;
        synchronized (this.f12599c) {
            remove = this.f12599c.remove(Integer.valueOf(i10));
        }
        return remove;
    }

    public n k() {
        return this.f12603g;
    }

    public synchronized SocketChannel l() {
        return this.f12598b;
    }

    public void m(h hVar) {
        try {
            this.f12606j.lock();
            this.f12607k = hVar;
        } finally {
            this.f12606j.unlock();
        }
    }

    public void n(n nVar) {
        this.f12603g = nVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(com.google.gson.n nVar) {
        p(nVar, f12595m);
    }
}
