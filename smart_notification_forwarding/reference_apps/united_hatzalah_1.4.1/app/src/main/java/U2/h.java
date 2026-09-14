package U2;

import F0.RunnableC0091v;
import P2.A;
import P2.C0163m;
import P2.G0;
import P2.I;
import P2.L;
import P2.Q;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public final class h extends A implements L {

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f2354k = AtomicIntegerFieldUpdater.newUpdater(h.class, "runningWorkers$volatile");

    /* renamed from: c, reason: collision with root package name */
    public final A f2355c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2356d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ L f2357e;

    /* renamed from: f, reason: collision with root package name */
    public final k f2358f;

    /* renamed from: j, reason: collision with root package name */
    public final Object f2359j;
    private volatile /* synthetic */ int runningWorkers$volatile;

    /* JADX WARN: Multi-variable type inference failed */
    public h(A a2, int i) {
        L l3;
        this.f2355c = a2;
        this.f2356d = i;
        if (a2 instanceof L) {
            l3 = (L) a2;
        } else {
            l3 = null;
        }
        this.f2357e = l3 == null ? I.f1617a : l3;
        this.f2358f = new k();
        this.f2359j = new Object();
    }

    @Override // P2.L
    public final Q a(long j2, G0 g02, InterfaceC0768i interfaceC0768i) {
        return this.f2357e.a(j2, g02, interfaceC0768i);
    }

    @Override // P2.L
    public final void b(long j2, C0163m c0163m) {
        this.f2357e.b(j2, c0163m);
    }

    @Override // P2.A
    public final void d(InterfaceC0768i interfaceC0768i, Runnable runnable) {
        this.f2358f.a(runnable);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f2354k;
        if (atomicIntegerFieldUpdater.get(this) < this.f2356d) {
            synchronized (this.f2359j) {
                if (atomicIntegerFieldUpdater.get(this) >= this.f2356d) {
                    return;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
                Runnable f4 = f();
                if (f4 != null) {
                    this.f2355c.d(this, new RunnableC0091v(this, f4, 5, false));
                }
            }
        }
    }

    public final Runnable f() {
        while (true) {
            Runnable runnable = (Runnable) this.f2358f.d();
            if (runnable == null) {
                synchronized (this.f2359j) {
                    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f2354k;
                    atomicIntegerFieldUpdater.decrementAndGet(this);
                    if (this.f2358f.c() == 0) {
                        return null;
                    }
                    atomicIntegerFieldUpdater.incrementAndGet(this);
                }
            } else {
                return runnable;
            }
        }
    }
}
