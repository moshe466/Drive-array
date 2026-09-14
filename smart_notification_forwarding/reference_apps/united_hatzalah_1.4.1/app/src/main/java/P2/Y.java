package P2;

import F0.G1;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public abstract class Y extends Z implements L {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f1634j = AtomicReferenceFieldUpdater.newUpdater(Y.class, Object.class, "_queue$volatile");

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f1635k = AtomicReferenceFieldUpdater.newUpdater(Y.class, Object.class, "_delayed$volatile");

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f1636l = AtomicIntegerFieldUpdater.newUpdater(Y.class, "_isCompleted$volatile");
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile = 0;
    private volatile /* synthetic */ Object _queue$volatile;

    public Q a(long j2, G0 g02, InterfaceC0768i interfaceC0768i) {
        return I.f1617a.a(j2, g02, interfaceC0768i);
    }

    @Override // P2.L
    public final void b(long j2, C0163m c0163m) {
        long j3 = 0;
        if (j2 > 0) {
            if (j2 >= 9223372036854L) {
                j3 = Long.MAX_VALUE;
            } else {
                j3 = 1000000 * j2;
            }
        }
        if (j3 < 4611686018427387903L) {
            long nanoTime = System.nanoTime();
            U u3 = new U(this, j3 + nanoTime, c0163m);
            o(nanoTime, u3);
            c0163m.t(new C0158j(u3, 2));
        }
    }

    @Override // P2.A
    public final void d(InterfaceC0768i interfaceC0768i, Runnable runnable) {
        l(runnable);
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d1, code lost:
    
        if (r0 == false) goto L97;
     */
    @Override // P2.Z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long i() {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: P2.Y.i():long");
    }

    public void l(Runnable runnable) {
        if (m(runnable)) {
            Thread g3 = g();
            if (Thread.currentThread() != g3) {
                LockSupport.unpark(g3);
                return;
            }
            return;
        }
        H.f1614m.l(runnable);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m(java.lang.Runnable r7) {
        /*
            r6 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = P2.Y.f1634j
            java.lang.Object r1 = r0.get(r6)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = P2.Y.f1636l
            int r2 = r2.get(r6)
            r3 = 0
            if (r2 == 0) goto L10
            return r3
        L10:
            r2 = 1
            if (r1 != 0) goto L22
        L13:
            r1 = 0
            boolean r1 = r0.compareAndSet(r6, r1, r7)
            if (r1 == 0) goto L1b
            goto L62
        L1b:
            java.lang.Object r1 = r0.get(r6)
            if (r1 == 0) goto L13
            goto L0
        L22:
            boolean r4 = r1 instanceof U2.m
            if (r4 == 0) goto L47
            r4 = r1
            U2.m r4 = (U2.m) r4
            int r5 = r4.a(r7)
            if (r5 == 0) goto L62
            if (r5 == r2) goto L35
            r0 = 2
            if (r5 == r0) goto L4b
            goto L0
        L35:
            U2.m r3 = r4.c()
        L39:
            boolean r2 = r0.compareAndSet(r6, r1, r3)
            if (r2 == 0) goto L40
            goto L0
        L40:
            java.lang.Object r2 = r0.get(r6)
            if (r2 == r1) goto L39
            goto L0
        L47:
            F0.G1 r4 = P2.G.f1606c
            if (r1 != r4) goto L4c
        L4b:
            return r3
        L4c:
            U2.m r3 = new U2.m
            r4 = 8
            r3.<init>(r4, r2)
            r4 = r1
            java.lang.Runnable r4 = (java.lang.Runnable) r4
            r3.a(r4)
            r3.a(r7)
        L5c:
            boolean r4 = r0.compareAndSet(r6, r1, r3)
            if (r4 == 0) goto L63
        L62:
            return r2
        L63:
            java.lang.Object r4 = r0.get(r6)
            if (r4 == r1) goto L5c
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: P2.Y.m(java.lang.Runnable):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
    
        if (r0 == false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean n() {
        /*
            r7 = this;
            t2.f r0 = r7.f1640e
            r1 = 1
            if (r0 == 0) goto La
            boolean r0 = r0.isEmpty()
            goto Lb
        La:
            r0 = r1
        Lb:
            r2 = 0
            if (r0 != 0) goto Lf
            goto L54
        Lf:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = P2.Y.f1635k
            java.lang.Object r0 = r0.get(r7)
            P2.X r0 = (P2.X) r0
            if (r0 == 0) goto L27
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r3 = U2.w.f2383b
            int r0 = r3.get(r0)
            if (r0 != 0) goto L23
            r0 = r1
            goto L24
        L23:
            r0 = r2
        L24:
            if (r0 != 0) goto L27
            goto L54
        L27:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = P2.Y.f1634j
            java.lang.Object r0 = r0.get(r7)
            if (r0 != 0) goto L30
            goto L53
        L30:
            boolean r3 = r0 instanceof U2.m
            if (r3 == 0) goto L4f
            U2.m r0 = (U2.m) r0
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = U2.m.f2366f
            long r3 = r3.get(r0)
            r5 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r5 = r5 & r3
            int r0 = (int) r5
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r3 = r3 & r5
            r5 = 30
            long r3 = r3 >> r5
            int r3 = (int) r3
            if (r0 != r3) goto L4e
            return r1
        L4e:
            return r2
        L4f:
            F0.G1 r3 = P2.G.f1606c
            if (r0 != r3) goto L54
        L53:
            return r1
        L54:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: P2.Y.n():boolean");
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [P2.X, java.lang.Object] */
    public final void o(long j2, W w3) {
        int a2;
        Thread g3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1635k;
        W w4 = null;
        if (f1636l.get(this) != 0) {
            a2 = 1;
        } else {
            X x3 = (X) atomicReferenceFieldUpdater.get(this);
            if (x3 == null) {
                ?? obj = new Object();
                obj.f1633c = j2;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, null, obj) && atomicReferenceFieldUpdater.get(this) == null) {
                }
                Object obj2 = atomicReferenceFieldUpdater.get(this);
                kotlin.jvm.internal.j.b(obj2);
                x3 = (X) obj2;
            }
            a2 = w3.a(j2, x3, this);
        }
        if (a2 != 0) {
            if (a2 != 1) {
                if (a2 != 2) {
                    throw new IllegalStateException("unexpected result");
                }
                return;
            } else {
                k(j2, w3);
                return;
            }
        }
        X x4 = (X) atomicReferenceFieldUpdater.get(this);
        if (x4 != null) {
            synchronized (x4) {
                W[] wArr = x4.f2384a;
                if (wArr != null) {
                    w4 = wArr[0];
                }
            }
        }
        if (w4 == w3 && Thread.currentThread() != (g3 = g())) {
            LockSupport.unpark(g3);
        }
    }

    @Override // P2.Z
    public void shutdown() {
        W w3;
        F0.f1603a.set(null);
        f1636l.set(this, 1);
        G1 g12 = G.f1606c;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1634j;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, null, g12)) {
                    if (atomicReferenceFieldUpdater.get(this) != null) {
                        break;
                    }
                }
                break loop0;
            } else {
                if (obj instanceof U2.m) {
                    ((U2.m) obj).b();
                    break;
                }
                if (obj != g12) {
                    U2.m mVar = new U2.m(8, true);
                    mVar.a((Runnable) obj);
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, mVar)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    break loop0;
                }
                break;
            }
        }
        do {
        } while (i() <= 0);
        long nanoTime = System.nanoTime();
        while (true) {
            X x3 = (X) f1635k.get(this);
            if (x3 != null) {
                synchronized (x3) {
                    if (U2.w.f2383b.get(x3) > 0) {
                        w3 = x3.b(0);
                    } else {
                        w3 = null;
                    }
                }
                if (w3 != null) {
                    k(nanoTime, w3);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }
}
