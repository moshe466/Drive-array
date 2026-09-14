package o7;

import java.nio.channels.SocketChannel;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public class n implements q {

    /* renamed from: o, reason: collision with root package name */
    public static int f12577o = 1024;

    /* renamed from: a, reason: collision with root package name */
    private final String f12578a;

    /* renamed from: b, reason: collision with root package name */
    private String f12579b;

    /* renamed from: c, reason: collision with root package name */
    private SocketChannel f12580c;

    /* renamed from: d, reason: collision with root package name */
    private o f12581d;

    /* renamed from: e, reason: collision with root package name */
    private BlockingQueue<com.google.gson.n> f12582e;

    /* renamed from: f, reason: collision with root package name */
    private BlockingQueue<String> f12583f;

    /* renamed from: g, reason: collision with root package name */
    private Map<t7.a, j> f12584g;

    /* renamed from: h, reason: collision with root package name */
    private i f12585h;

    /* renamed from: i, reason: collision with root package name */
    private ReentrantReadWriteLock f12586i;

    /* renamed from: j, reason: collision with root package name */
    private Lock f12587j;

    /* renamed from: k, reason: collision with root package name */
    private Lock f12588k;

    /* renamed from: l, reason: collision with root package name */
    private h f12589l;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f12590m;

    /* renamed from: n, reason: collision with root package name */
    private AtomicLong f12591n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:77:0x01ea A[DONT_GENERATE, FINALLY_INSNS] */
        /* JADX WARN: Removed duplicated region for block: B:88:0x022e A[DONT_GENERATE, FINALLY_INSNS] */
        /* JADX WARN: Removed duplicated region for block: B:90:0x0249 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:92:0x0000 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:93:0x0236 A[DONT_GENERATE, FINALLY_INSNS] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 586
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: o7.n.a.run():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j jVar;
            while (n.this.f12590m) {
                try {
                    com.google.gson.n nVar = (com.google.gson.n) n.this.f12582e.take();
                    t7.a valueOf = t7.a.valueOf(nVar.B("reqType").s());
                    com.google.gson.n a10 = n7.a.a(valueOf).a(nVar);
                    a10.z("sId", n.this.f12579b);
                    n.this.f12581d.o(a10);
                    if (n.this.f12584g.containsKey(valueOf) && (jVar = (j) n.this.f12584g.get(valueOf)) != null) {
                        jVar.a(nVar);
                    }
                } catch (Exception e10) {
                    v7.b.c("ServerRead", "{" + n.this.f12578a + "}.startRead().run thread WRITE EXCEPTION " + e10.getMessage());
                }
            }
        }
    }

    public n(String str, o oVar, i iVar, String str2) {
        ic.c.i(n.class.getSimpleName());
        this.f12582e = new LinkedBlockingQueue();
        this.f12583f = new LinkedBlockingQueue();
        this.f12584g = new Hashtable();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f12586i = reentrantReadWriteLock;
        this.f12587j = reentrantReadWriteLock.readLock();
        this.f12588k = this.f12586i.writeLock();
        this.f12590m = true;
        this.f12591n = new AtomicLong(System.currentTimeMillis());
        this.f12579b = str;
        this.f12580c = oVar.l();
        this.f12581d = oVar;
        oVar.n(this);
        this.f12585h = iVar;
        this.f12578a = str2;
        s();
    }

    private void s() {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        for (int i10 = 0; i10 < 5; i10++) {
            newFixedThreadPool.execute(new b());
        }
    }

    @Override // o7.q
    public void a() {
        try {
            this.f12580c.close();
        } catch (Exception unused) {
        }
        try {
            this.f12587j.lock();
            h hVar = this.f12589l;
            if (hVar != null) {
                hVar.a(false);
            }
        } finally {
            this.f12587j.unlock();
        }
    }

    @Override // o7.q
    public void b(SocketChannel socketChannel) {
        this.f12580c = socketChannel;
        w();
        try {
            this.f12587j.lock();
            h hVar = this.f12589l;
            if (hVar != null) {
                hVar.a(true);
            }
        } finally {
            this.f12587j.unlock();
        }
    }

    public void o() {
        this.f12590m = false;
        try {
            this.f12580c.close();
        } catch (Exception unused) {
        } catch (Throwable th) {
            p.d().c(this.f12580c, false);
            throw th;
        }
        p.d().c(this.f12580c, false);
    }

    public j p() {
        return this.f12584g.get(t7.a.invitedToChannel);
    }

    public long q() {
        return this.f12591n.get();
    }

    public void r(j jVar) {
        this.f12584g.put(t7.a.newVoiceHistory, jVar);
    }

    public synchronized void t(h hVar) {
        try {
            this.f12588k.lock();
            this.f12589l = hVar;
        } finally {
            this.f12588k.unlock();
        }
    }

    public void u(j jVar) {
        this.f12584g.put(t7.a.invitedToChannel, jVar);
    }

    public void v(j jVar) {
        this.f12584g.put(t7.a.recvTxtMsg, jVar);
    }

    public void w() {
        new Thread(new a()).start();
    }
}
