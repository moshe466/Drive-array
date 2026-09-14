package okhttp3;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import ub.g;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: g, reason: collision with root package name */
    private static final Executor f12739g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), sb.c.G("OkHttp ConnectionPool", true));

    /* renamed from: a, reason: collision with root package name */
    private final int f12740a;

    /* renamed from: b, reason: collision with root package name */
    private final long f12741b;

    /* renamed from: c, reason: collision with root package name */
    private final Runnable f12742c;

    /* renamed from: d, reason: collision with root package name */
    private final Deque<ub.c> f12743d;

    /* renamed from: e, reason: collision with root package name */
    final ub.d f12744e;

    /* renamed from: f, reason: collision with root package name */
    boolean f12745f;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                long a10 = i.this.a(System.nanoTime());
                if (a10 == -1) {
                    return;
                }
                if (a10 > 0) {
                    long j10 = a10 / 1000000;
                    long j11 = a10 - (1000000 * j10);
                    synchronized (i.this) {
                        try {
                            i.this.wait(j10, (int) j11);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }
    }

    public i() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public i(int i10, long j10, TimeUnit timeUnit) {
        this.f12742c = new a();
        this.f12743d = new ArrayDeque();
        this.f12744e = new ub.d();
        this.f12740a = i10;
        this.f12741b = timeUnit.toNanos(j10);
        if (j10 > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j10);
    }

    private int e(ub.c cVar, long j10) {
        List<Reference<ub.g>> list = cVar.f14573n;
        int i10 = 0;
        while (i10 < list.size()) {
            Reference<ub.g> reference = list.get(i10);
            if (reference.get() != null) {
                i10++;
            } else {
                yb.f.j().q("A connection to " + cVar.p().a().l() + " was leaked. Did you forget to close a response body?", ((g.a) reference).f14602a);
                list.remove(i10);
                cVar.f14570k = true;
                if (list.isEmpty()) {
                    cVar.f14574o = j10 - this.f12741b;
                    return 0;
                }
            }
        }
        return list.size();
    }

    long a(long j10) {
        synchronized (this) {
            ub.c cVar = null;
            long j11 = Long.MIN_VALUE;
            int i10 = 0;
            int i11 = 0;
            for (ub.c cVar2 : this.f12743d) {
                if (e(cVar2, j10) > 0) {
                    i11++;
                } else {
                    i10++;
                    long j12 = j10 - cVar2.f14574o;
                    if (j12 > j11) {
                        cVar = cVar2;
                        j11 = j12;
                    }
                }
            }
            long j13 = this.f12741b;
            if (j11 < j13 && i10 <= this.f12740a) {
                if (i10 > 0) {
                    return j13 - j11;
                }
                if (i11 > 0) {
                    return j13;
                }
                this.f12745f = false;
                return -1L;
            }
            this.f12743d.remove(cVar);
            sb.c.h(cVar.q());
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(ub.c cVar) {
        if (cVar.f14570k || this.f12740a == 0) {
            this.f12743d.remove(cVar);
            return true;
        }
        notifyAll();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Socket c(okhttp3.a aVar, ub.g gVar) {
        for (ub.c cVar : this.f12743d) {
            if (cVar.l(aVar, null) && cVar.n() && cVar != gVar.d()) {
                return gVar.m(cVar);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ub.c d(okhttp3.a aVar, ub.g gVar, c0 c0Var) {
        for (ub.c cVar : this.f12743d) {
            if (cVar.l(aVar, c0Var)) {
                gVar.a(cVar, true);
                return cVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ub.c cVar) {
        if (!this.f12745f) {
            this.f12745f = true;
            f12739g.execute(this.f12742c);
        }
        this.f12743d.add(cVar);
    }
}
