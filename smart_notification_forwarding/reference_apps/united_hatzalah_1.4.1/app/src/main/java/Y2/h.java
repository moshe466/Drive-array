package Y2;

import F0.G1;
import P2.C0163m;
import P2.InterfaceC0162l;
import R.L;
import U2.s;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import s2.C0684i;

/* loaded from: classes.dex */
public class h {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f2715b = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "head$volatile");

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f2716c = AtomicLongFieldUpdater.newUpdater(h.class, "deqIdx$volatile");

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f2717d = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "tail$volatile");

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f2718e = AtomicLongFieldUpdater.newUpdater(h.class, "enqIdx$volatile");

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f2719f = AtomicIntegerFieldUpdater.newUpdater(h.class, "_availablePermits$volatile");
    private volatile /* synthetic */ int _availablePermits$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final L f2720a;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    public h(int i) {
        if (i >= 0 && i <= 1) {
            j jVar = new j(0L, null, 2);
            this.head$volatile = jVar;
            this.tail$volatile = jVar;
            this._availablePermits$volatile = 1 - i;
            this.f2720a = new L(this, 2);
            return;
        }
        throw new IllegalArgumentException("The number of acquired permits should be in 0..1".toString());
    }

    public final void a(c cVar) {
        Object a2;
        j jVar;
        C0163m c0163m = cVar.f2709a;
        d dVar = cVar.f2710b;
        while (true) {
            int andDecrement = f2719f.getAndDecrement(this);
            if (andDecrement <= 1) {
                C0684i c0684i = C0684i.f6340a;
                if (andDecrement > 0) {
                    d.f2711g.set(dVar, null);
                    c0163m.y(c0684i, new b(dVar, cVar, 0));
                    return;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2717d;
                j jVar2 = (j) atomicReferenceFieldUpdater.get(this);
                long andIncrement = f2718e.getAndIncrement(this);
                f fVar = f.f2713a;
                long j2 = andIncrement / i.f2726f;
                while (true) {
                    a2 = U2.a.a(jVar2, j2, fVar);
                    if (!U2.a.d(a2)) {
                        s b4 = U2.a.b(a2);
                        while (true) {
                            s sVar = (s) atomicReferenceFieldUpdater.get(this);
                            jVar = jVar2;
                            if (sVar.f2376c >= b4.f2376c) {
                                break;
                            }
                            if (!b4.j()) {
                                break;
                            }
                            while (!atomicReferenceFieldUpdater.compareAndSet(this, sVar, b4)) {
                                if (atomicReferenceFieldUpdater.get(this) != sVar) {
                                    if (b4.f()) {
                                        b4.e();
                                    }
                                    jVar2 = jVar;
                                }
                            }
                            if (sVar.f()) {
                                sVar.e();
                            }
                        }
                    } else {
                        break;
                    }
                    jVar2 = jVar;
                }
                j jVar3 = (j) U2.a.b(a2);
                AtomicReferenceArray atomicReferenceArray = jVar3.f2727e;
                int i = (int) (andIncrement % i.f2726f);
                while (!atomicReferenceArray.compareAndSet(i, null, cVar)) {
                    if (atomicReferenceArray.get(i) != null) {
                        G1 g12 = i.f2722b;
                        G1 g13 = i.f2723c;
                        while (!atomicReferenceArray.compareAndSet(i, g12, g13)) {
                            if (atomicReferenceArray.get(i) != g12) {
                                break;
                            }
                        }
                        d.f2711g.set(dVar, null);
                        c0163m.y(c0684i, new b(dVar, cVar, 0));
                        return;
                    }
                }
                cVar.b(jVar3, i);
                return;
            }
        }
    }

    public final void b() {
        boolean z3;
        int i;
        Object a2;
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f2719f;
            int andIncrement = atomicIntegerFieldUpdater.getAndIncrement(this);
            z3 = true;
            if (andIncrement < 1) {
                if (andIncrement < 0) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2715b;
                    j jVar = (j) atomicReferenceFieldUpdater.get(this);
                    long andIncrement2 = f2716c.getAndIncrement(this);
                    long j2 = andIncrement2 / i.f2726f;
                    g gVar = g.f2714a;
                    while (true) {
                        a2 = U2.a.a(jVar, j2, gVar);
                        if (!U2.a.d(a2)) {
                            s b4 = U2.a.b(a2);
                            while (true) {
                                s sVar = (s) atomicReferenceFieldUpdater.get(this);
                                if (sVar.f2376c >= b4.f2376c) {
                                    break;
                                }
                                if (!b4.j()) {
                                    break;
                                }
                                while (!atomicReferenceFieldUpdater.compareAndSet(this, sVar, b4)) {
                                    if (atomicReferenceFieldUpdater.get(this) != sVar) {
                                        if (b4.f()) {
                                            b4.e();
                                        }
                                    }
                                }
                                if (sVar.f()) {
                                    sVar.e();
                                }
                            }
                        } else {
                            break;
                        }
                    }
                    j jVar2 = (j) U2.a.b(a2);
                    AtomicReferenceArray atomicReferenceArray = jVar2.f2727e;
                    jVar2.b();
                    boolean z4 = false;
                    if (jVar2.f2376c <= j2) {
                        int i3 = (int) (andIncrement2 % i.f2726f);
                        Object andSet = atomicReferenceArray.getAndSet(i3, i.f2722b);
                        if (andSet == null) {
                            int i4 = i.f2721a;
                            int i5 = 0;
                            while (true) {
                                if (i5 < i4) {
                                    if (atomicReferenceArray.get(i3) == i.f2723c) {
                                        break;
                                    } else {
                                        i5++;
                                    }
                                } else {
                                    G1 g12 = i.f2722b;
                                    G1 g13 = i.f2724d;
                                    while (true) {
                                        if (atomicReferenceArray.compareAndSet(i3, g12, g13)) {
                                            z4 = true;
                                            break;
                                        } else if (atomicReferenceArray.get(i3) != g12) {
                                            break;
                                        }
                                    }
                                    z3 = true ^ z4;
                                }
                            }
                        } else if (andSet != i.f2725e) {
                            boolean z5 = andSet instanceof InterfaceC0162l;
                            C0684i c0684i = C0684i.f6340a;
                            if (z5) {
                                InterfaceC0162l interfaceC0162l = (InterfaceC0162l) andSet;
                                G1 e4 = interfaceC0162l.e(c0684i, this.f2720a);
                                if (e4 != null) {
                                    interfaceC0162l.f(e4);
                                }
                            } else if (andSet instanceof X2.c) {
                                z3 = ((X2.c) andSet).c(this, c0684i);
                            } else {
                                throw new IllegalStateException(("unexpected: " + andSet).toString());
                            }
                        }
                    }
                    z3 = false;
                } else {
                    return;
                }
            } else {
                do {
                    i = atomicIntegerFieldUpdater.get(this);
                    if (i <= 1) {
                        break;
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 1));
                throw new IllegalStateException("The number of released permits cannot be greater than 1".toString());
            }
        } while (!z3);
    }
}
