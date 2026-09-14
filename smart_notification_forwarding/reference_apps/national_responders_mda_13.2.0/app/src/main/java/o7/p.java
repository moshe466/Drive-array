package o7;

import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public class p {

    /* renamed from: i, reason: collision with root package name */
    private static Object f12617i = new Object();

    /* renamed from: j, reason: collision with root package name */
    private static p f12618j;

    /* renamed from: a, reason: collision with root package name */
    private final Random f12619a = new Random();

    /* renamed from: b, reason: collision with root package name */
    private final ReentrantReadWriteLock f12620b;

    /* renamed from: c, reason: collision with root package name */
    private final Lock f12621c;

    /* renamed from: d, reason: collision with root package name */
    private final Lock f12622d;

    /* renamed from: e, reason: collision with root package name */
    String f12623e;

    /* renamed from: f, reason: collision with root package name */
    private Timer f12624f;

    /* renamed from: g, reason: collision with root package name */
    private Hashtable<SocketChannel, fc.b<SocketAddress, Vector<q>, g>> f12625g;

    /* renamed from: h, reason: collision with root package name */
    private Collection<fc.b<SocketAddress, Vector<q>, g>> f12626h;

    /* loaded from: classes.dex */
    public class a extends TimerTask {

        /* renamed from: f, reason: collision with root package name */
        private fc.b<SocketAddress, Vector<q>, g> f12627f;

        public a(fc.b<SocketAddress, Vector<q>, g> bVar) {
            this.f12627f = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            v7.b.c(p.this.f12623e, "ReconnectTask - run");
            if (p.d().g(this.f12627f)) {
                cancel();
                synchronized (p.this.f12626h) {
                    p.this.f12626h.remove(this.f12627f);
                }
            }
        }
    }

    private p() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f12620b = reentrantReadWriteLock;
        this.f12621c = reentrantReadWriteLock.readLock();
        this.f12622d = reentrantReadWriteLock.writeLock();
        ic.c.i(p.class.getSimpleName());
        this.f12623e = "SocketChannelManager";
        this.f12624f = new Timer();
        this.f12625g = new Hashtable<>();
        this.f12626h = new ArrayList();
    }

    public static p d() {
        if (f12618j == null) {
            synchronized (f12617i) {
                if (f12618j == null) {
                    f12618j = new p();
                }
            }
        }
        return f12618j;
    }

    public void b() {
        v7.b.c(this.f12623e, "dismissAllChannels() started");
        this.f12622d.lock();
        try {
            Timer timer = this.f12624f;
            if (timer != null) {
                timer.cancel();
                this.f12624f = null;
            }
            Collection<fc.b<SocketAddress, Vector<q>, g>> values = this.f12625g.values();
            synchronized (this.f12626h) {
                this.f12626h.removeAll(values);
                this.f12626h.addAll(values);
            }
            Enumeration<SocketChannel> keys = this.f12625g.keys();
            while (keys.hasMoreElements()) {
                c(keys.nextElement(), false);
            }
            this.f12622d.unlock();
            v7.b.c(this.f12623e, "dismissAllChannels() finished");
        } catch (Throwable th) {
            this.f12622d.unlock();
            throw th;
        }
    }

    public void c(SocketChannel socketChannel, boolean z10) {
        v7.b.c(this.f12623e, "dismissChannel() started");
        this.f12621c.lock();
        try {
            synchronized (socketChannel.socket()) {
                if (this.f12625g.containsKey(socketChannel)) {
                    fc.b<SocketAddress, Vector<q>, g> remove = this.f12625g.remove(socketChannel);
                    Iterator<q> it = remove.l().iterator();
                    while (it.hasNext()) {
                        it.next().a();
                    }
                    v7.b.c(this.f12623e, "dismissChannel() all handlers notified");
                    if (z10 && !g(remove)) {
                        synchronized (this.f12626h) {
                            this.f12626h.add(remove);
                        }
                        this.f12624f.schedule(new a(remove), (this.f12619a.nextInt(60) * 1000) + 5000, 14000L);
                    }
                }
            }
            this.f12621c.unlock();
            v7.b.c(this.f12623e, "dismissChannel() finished");
        } catch (Throwable th) {
            this.f12621c.unlock();
            throw th;
        }
    }

    public void e(SocketChannel socketChannel, g gVar, q qVar, String str) {
        v7.b.d(this.f12623e, "registerChannel({}) started", str);
        if (this.f12625g.containsKey(socketChannel)) {
            Vector<q> l10 = this.f12625g.get(socketChannel).l();
            if (!l10.contains(qVar)) {
                l10.add(qVar);
            }
        } else {
            Vector vector = new Vector();
            vector.add(qVar);
            this.f12625g.put(socketChannel, fc.b.o(socketChannel.socket().getRemoteSocketAddress(), vector, gVar));
        }
        v7.b.d(this.f12623e, "registerChannel({}) finished", str);
    }

    public void f() {
        v7.b.c(this.f12623e, "renewAllChannels() started");
        this.f12622d.lock();
        try {
            if (this.f12624f == null) {
                this.f12624f = new Timer();
            }
            synchronized (this.f12626h) {
                Iterator<fc.b<SocketAddress, Vector<q>, g>> it = this.f12626h.iterator();
                while (it.hasNext()) {
                    fc.b<SocketAddress, Vector<q>, g> next = it.next();
                    if (g(next)) {
                        it.remove();
                    } else {
                        this.f12624f.schedule(new a(next), 5000 + (this.f12619a.nextInt(60) * 1000), 14000L);
                    }
                }
            }
            this.f12622d.unlock();
            v7.b.c(this.f12623e, "renewAllChannels() finished");
        } catch (Throwable th) {
            this.f12622d.unlock();
            throw th;
        }
    }

    public boolean g(fc.b<SocketAddress, Vector<q>, g> bVar) {
        boolean contains;
        v7.b.d(this.f12623e, "Renew channel - socket: {}", bVar.k().toString());
        v7.b.c(this.f12623e, "renewChannel() started");
        Vector<q> l10 = bVar.l();
        this.f12621c.lock();
        try {
            com.google.gson.n nVar = new com.google.gson.n();
            nVar.z("status", "begin");
            synchronized (bVar.k()) {
                g n10 = bVar.n();
                n10.c(nVar);
                contains = this.f12625g.contains(bVar);
                int i10 = 0;
                while (i10 < 6 && !contains) {
                    try {
                        SocketChannel open = SocketChannel.open(bVar.k());
                        this.f12625g.put(open, bVar);
                        Iterator<q> it = l10.iterator();
                        while (it.hasNext()) {
                            it.next().b(open);
                        }
                        nVar.z("status", "success");
                        n10.c(nVar);
                        try {
                            v7.b.c(this.f12623e, "renewChannel() reconnect succeded");
                            contains = true;
                        } catch (Throwable th) {
                            th = th;
                            contains = true;
                            v7.b.d(this.f12623e, "renewChannel() threw exception on re-connect {}: {}", String.valueOf(i10), th.getMessage());
                            int i11 = i10 + 1;
                            try {
                                Thread.sleep(1500 / (6 - i10));
                            } catch (InterruptedException unused) {
                            }
                            i10 = i11;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                if (!contains) {
                    n10.d();
                }
            }
            this.f12621c.unlock();
            v7.b.c(this.f12623e, "renewChannel() finished");
            return contains;
        } catch (Throwable th3) {
            this.f12621c.unlock();
            throw th3;
        }
    }
}
