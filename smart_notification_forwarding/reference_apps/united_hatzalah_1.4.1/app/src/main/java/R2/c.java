package R2;

import F0.AbstractC0008a;
import F0.G1;
import P2.C0163m;
import P2.InterfaceC0162l;
import P2.K0;
import a.AbstractC0228a;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;

/* loaded from: classes.dex */
public class c implements g {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f2025b = AtomicLongFieldUpdater.newUpdater(c.class, "sendersAndCloseStatus$volatile");

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f2026c = AtomicLongFieldUpdater.newUpdater(c.class, "receivers$volatile");

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f2027d = AtomicLongFieldUpdater.newUpdater(c.class, "bufferEnd$volatile");

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f2028e = AtomicLongFieldUpdater.newUpdater(c.class, "completedExpandBuffersAndPauseFlag$volatile");

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f2029f = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "sendSegment$volatile");

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f2030j = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "receiveSegment$volatile");

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f2031k = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "bufferEndSegment$volatile");

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f2032l = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_closeCause$volatile");

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f2033m = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "closeHandler$volatile");
    private volatile /* synthetic */ Object _closeCause$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final int f2034a;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    public c(int i) {
        long j2;
        this.f2034a = i;
        if (i >= 0) {
            k kVar = e.f2036a;
            if (i != 0) {
                if (i != Integer.MAX_VALUE) {
                    j2 = i;
                } else {
                    j2 = Long.MAX_VALUE;
                }
            } else {
                j2 = 0;
            }
            this.bufferEnd$volatile = j2;
            this.completedExpandBuffersAndPauseFlag$volatile = f2027d.get(this);
            k kVar2 = new k(0L, null, this, 3);
            this.sendSegment$volatile = kVar2;
            this.receiveSegment$volatile = kVar2;
            if (t()) {
                kVar2 = e.f2036a;
                kotlin.jvm.internal.j.c(kVar2, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
            }
            this.bufferEndSegment$volatile = kVar2;
            this._closeCause$volatile = e.f2052s;
            return;
        }
        throw new IllegalArgumentException(AbstractC0008a.j(i, "Invalid channel capacity: ", ", should be >=0").toString());
    }

    public static final k a(c cVar, long j2, k kVar) {
        Object a2;
        c cVar2;
        k kVar2 = e.f2036a;
        d dVar = d.f2035a;
        loop0: while (true) {
            a2 = U2.a.a(kVar, j2, dVar);
            if (!U2.a.d(a2)) {
                U2.s b4 = U2.a.b(a2);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2029f;
                    U2.s sVar = (U2.s) atomicReferenceFieldUpdater.get(cVar);
                    if (sVar.f2376c >= b4.f2376c) {
                        break loop0;
                    }
                    if (!b4.j()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(cVar, sVar, b4)) {
                        if (atomicReferenceFieldUpdater.get(cVar) != sVar) {
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
        boolean d2 = U2.a.d(a2);
        AtomicLongFieldUpdater atomicLongFieldUpdater = f2026c;
        if (d2) {
            cVar.r();
            if (kVar.f2376c * e.f2037b < atomicLongFieldUpdater.get(cVar)) {
                kVar.b();
                return null;
            }
        } else {
            k kVar3 = (k) U2.a.b(a2);
            long j3 = kVar3.f2376c;
            if (j3 > j2) {
                long j4 = e.f2037b * j3;
                while (true) {
                    long j5 = f2025b.get(cVar);
                    long j6 = 1152921504606846975L & j5;
                    if (j6 >= j4) {
                        cVar2 = cVar;
                        break;
                    }
                    cVar2 = cVar;
                    if (f2025b.compareAndSet(cVar2, j5, (((int) (j5 >> 60)) << 60) + j6)) {
                        break;
                    }
                    cVar = cVar2;
                }
                if (j3 * e.f2037b < atomicLongFieldUpdater.get(cVar2)) {
                    kVar3.b();
                }
            } else {
                return kVar3;
            }
        }
        return null;
    }

    public static final void c(c cVar, Object obj, C0163m c0163m) {
        c0163m.resumeWith(AbstractC0228a.g(cVar.n()));
    }

    public static final int e(c cVar, k kVar, int i, Object obj, long j2, Object obj2, boolean z3) {
        kVar.n(i, obj);
        if (z3) {
            return cVar.A(kVar, i, obj, j2, obj2, z3);
        }
        Object l3 = kVar.l(i);
        if (l3 == null) {
            if (cVar.f(j2)) {
                if (kVar.k(i, null, e.f2039d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (kVar.k(i, null, obj2)) {
                    return 2;
                }
            }
        } else if (l3 instanceof K0) {
            kVar.n(i, null);
            if (cVar.x(l3, obj)) {
                kVar.o(i, e.i);
                return 0;
            }
            G1 g12 = e.f2045k;
            if (kVar.f2060f.getAndSet((i * 2) + 1, g12) != g12) {
                kVar.m(i, true);
                return 5;
            }
            return 5;
        }
        return cVar.A(kVar, i, obj, j2, obj2, z3);
    }

    public static void p(c cVar) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f2028e;
        if ((atomicLongFieldUpdater.addAndGet(cVar, 1L) & 4611686018427387904L) == 0) {
            return;
        }
        do {
        } while ((atomicLongFieldUpdater.get(cVar) & 4611686018427387904L) != 0);
    }

    public final int A(k kVar, int i, Object obj, long j2, Object obj2, boolean z3) {
        while (true) {
            Object l3 = kVar.l(i);
            if (l3 == null) {
                if (f(j2) && !z3) {
                    if (kVar.k(i, null, e.f2039d)) {
                        break;
                    }
                } else if (z3) {
                    if (kVar.k(i, null, e.f2044j)) {
                        kVar.i();
                        return 4;
                    }
                } else {
                    if (obj2 == null) {
                        return 3;
                    }
                    if (kVar.k(i, null, obj2)) {
                        return 2;
                    }
                }
            } else if (l3 == e.f2040e) {
                if (kVar.k(i, l3, e.f2039d)) {
                    break;
                }
            } else {
                G1 g12 = e.f2045k;
                if (l3 == g12) {
                    kVar.n(i, null);
                    return 5;
                }
                if (l3 == e.f2043h) {
                    kVar.n(i, null);
                    return 5;
                }
                if (l3 == e.f2046l) {
                    kVar.n(i, null);
                    r();
                    return 4;
                }
                kVar.n(i, null);
                if (l3 instanceof s) {
                    l3 = ((s) l3).f2070a;
                }
                if (x(l3, obj)) {
                    kVar.o(i, e.i);
                    return 0;
                }
                if (kVar.f2060f.getAndSet((i * 2) + 1, g12) != g12) {
                    kVar.m(i, true);
                }
                return 5;
            }
        }
        return 1;
    }

    public final void B(long j2) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        boolean z3;
        c cVar = this;
        if (!cVar.t()) {
            while (true) {
                atomicLongFieldUpdater = f2027d;
                if (atomicLongFieldUpdater.get(cVar) > j2) {
                    break;
                } else {
                    cVar = this;
                }
            }
            int i = e.f2038c;
            int i3 = 0;
            while (true) {
                AtomicLongFieldUpdater atomicLongFieldUpdater2 = f2028e;
                if (i3 < i) {
                    long j3 = atomicLongFieldUpdater.get(cVar);
                    if (j3 != (4611686018427387903L & atomicLongFieldUpdater2.get(cVar)) || j3 != atomicLongFieldUpdater.get(cVar)) {
                        i3++;
                    } else {
                        return;
                    }
                } else {
                    while (true) {
                        long j4 = atomicLongFieldUpdater2.get(cVar);
                        if (atomicLongFieldUpdater2.compareAndSet(cVar, j4, (j4 & 4611686018427387903L) + 4611686018427387904L)) {
                            break;
                        } else {
                            cVar = this;
                        }
                    }
                    while (true) {
                        long j5 = atomicLongFieldUpdater.get(cVar);
                        long j6 = atomicLongFieldUpdater2.get(cVar);
                        long j7 = j6 & 4611686018427387903L;
                        if ((j6 & 4611686018427387904L) != 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (j5 == j7 && j5 == atomicLongFieldUpdater.get(cVar)) {
                            break;
                        }
                        if (!z3) {
                            cVar = this;
                            atomicLongFieldUpdater2.compareAndSet(cVar, j6, 4611686018427387904L + j7);
                        } else {
                            cVar = this;
                        }
                    }
                    while (true) {
                        long j8 = atomicLongFieldUpdater2.get(cVar);
                        if (atomicLongFieldUpdater2.compareAndSet(cVar, j8, j8 & 4611686018427387903L)) {
                            return;
                        } else {
                            cVar = this;
                        }
                    }
                }
            }
        }
    }

    @Override // R2.r
    public Object b(Object obj) {
        boolean z3;
        K0 k02;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f2025b;
        long j2 = atomicLongFieldUpdater.get(this);
        boolean z4 = false;
        long j3 = 1152921504606846975L;
        if (q(j2, false)) {
            z3 = false;
        } else {
            z3 = !f(j2 & 1152921504606846975L);
        }
        i iVar = j.f2057b;
        if (z3) {
            return iVar;
        }
        F1.c cVar = e.f2044j;
        k kVar = (k) f2029f.get(this);
        while (true) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j4 = andIncrement & j3;
            boolean q3 = q(andIncrement, z4);
            int i = e.f2037b;
            long j5 = i;
            long j6 = j4 / j5;
            int i3 = (int) (j4 % j5);
            if (kVar.f2376c != j6) {
                k a2 = a(this, j6, kVar);
                if (a2 == null) {
                    if (q3) {
                        return new h(n());
                    }
                    z4 = false;
                    j3 = 1152921504606846975L;
                } else {
                    kVar = a2;
                }
            }
            int e4 = e(this, kVar, i3, obj, j4, cVar, q3);
            C0684i c0684i = C0684i.f6340a;
            if (e4 != 0) {
                if (e4 != 1) {
                    if (e4 != 2) {
                        if (e4 != 3) {
                            if (e4 != 4) {
                                if (e4 == 5) {
                                    kVar.b();
                                }
                                z4 = false;
                                j3 = 1152921504606846975L;
                            } else {
                                if (j4 < f2026c.get(this)) {
                                    kVar.b();
                                }
                                return new h(n());
                            }
                        } else {
                            throw new IllegalStateException("unexpected");
                        }
                    } else {
                        if (q3) {
                            kVar.i();
                            return new h(n());
                        }
                        if (cVar instanceof K0) {
                            k02 = (K0) cVar;
                        } else {
                            k02 = null;
                        }
                        if (k02 != null) {
                            k02.b(kVar, i3 + i);
                        }
                        kVar.i();
                        return iVar;
                    }
                } else {
                    return c0684i;
                }
            } else {
                kVar.b();
                return c0684i;
            }
        }
    }

    @Override // R2.q
    public final void cancel(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        g(cancellationException, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0189, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x00c6, code lost:
    
        c(r1, r4, r7);
     */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0173 A[RETURN] */
    @Override // R2.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(java.lang.Object r24, w2.InterfaceC0763d r25) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: R2.c.d(java.lang.Object, w2.d):java.lang.Object");
    }

    public final boolean f(long j2) {
        if (j2 >= f2027d.get(this) && j2 >= f2026c.get(this) + this.f2034a) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002d, code lost:
    
        if (r6.compareAndSet(r12, r5, r13) == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0035, code lost:
    
        if (r6.get(r12) == r5) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
    
        if (r14 == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003c, code lost:
    
        r5 = r3.get(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0049, code lost:
    
        if (r3.compareAndSet(r4, r5, (3 << 60) + (r5 & 1152921504606846975L)) == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0069, code lost:
    
        r();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006c, code lost:
    
        if (r10 == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006e, code lost:
    
        r13 = R2.c.f2033m;
        r14 = r13.get(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0074, code lost:
    
        if (r14 != null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0076, code lost:
    
        r0 = R2.e.f2050q;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007f, code lost:
    
        if (r13.compareAndSet(r12, r14, r0) == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0095, code lost:
    
        if (r13.get(r12) == r14) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x000a, code lost:
    
        if (r14 != false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0081, code lost:
    
        if (r14 != null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0084, code lost:
    
        kotlin.jvm.internal.u.a(1, r14);
        ((F2.l) r14).invoke(l());
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0090, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0079, code lost:
    
        r0 = R2.e.f2051r;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0098, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000c, code lost:
    
        r5 = r3.get(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x004c, code lost:
    
        r5 = r3.get(r12);
        r13 = (int) (r5 >> 60);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0053, code lost:
    
        if (r13 == 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0055, code lost:
    
        if (r13 == 1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0058, code lost:
    
        r13 = r5 & 1152921504606846975L;
        r7 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0067, code lost:
    
        if (r3.compareAndSet(r4, r5, (r7 << 60) + r13) == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0013, code lost:
    
        if (((int) (r5 >> 60)) != 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x005e, code lost:
    
        r13 = r5 & 1152921504606846975L;
        r7 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x002f, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0024, code lost:
    
        r4 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
    
        r4 = R2.e.f2036a;
        r4 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0021, code lost:
    
        if (r3.compareAndSet(r4, r5, (r5 & 1152921504606846975L) + (1 << 60)) == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0025, code lost:
    
        r5 = R2.e.f2052s;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
    
        r6 = R2.c.f2032l;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(java.lang.Throwable r13, boolean r14) {
        /*
            r12 = this;
            r0 = 60
            r1 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = R2.c.f2025b
            r9 = 1
            if (r14 == 0) goto L24
        Lc:
            long r5 = r3.get(r12)
            long r7 = r5 >> r0
            int r4 = (int) r7
            if (r4 != 0) goto L24
            long r7 = r5 & r1
            R2.k r4 = R2.e.f2036a
            long r10 = (long) r9
            long r10 = r10 << r0
            long r7 = r7 + r10
            r4 = r12
            boolean r5 = r3.compareAndSet(r4, r5, r7)
            if (r5 == 0) goto Lc
            goto L25
        L24:
            r4 = r12
        L25:
            F0.G1 r5 = R2.e.f2052s
        L27:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = R2.c.f2032l
            boolean r7 = r6.compareAndSet(r12, r5, r13)
            if (r7 == 0) goto L31
            r10 = r9
            goto L39
        L31:
            java.lang.Object r6 = r6.get(r12)
            if (r6 == r5) goto L27
            r13 = 0
            r10 = r13
        L39:
            r11 = 3
            if (r14 == 0) goto L4c
        L3c:
            long r5 = r3.get(r12)
            long r13 = r5 & r1
            long r7 = (long) r11
            long r7 = r7 << r0
            long r7 = r7 + r13
            boolean r13 = r3.compareAndSet(r4, r5, r7)
            if (r13 == 0) goto L3c
            goto L69
        L4c:
            long r5 = r3.get(r12)
            long r13 = r5 >> r0
            int r13 = (int) r13
            if (r13 == 0) goto L5e
            if (r13 == r9) goto L58
            goto L69
        L58:
            long r13 = r5 & r1
            long r7 = (long) r11
        L5b:
            long r7 = r7 << r0
            long r7 = r7 + r13
            goto L63
        L5e:
            long r13 = r5 & r1
            r7 = 2
            long r7 = (long) r7
            goto L5b
        L63:
            boolean r13 = r3.compareAndSet(r4, r5, r7)
            if (r13 == 0) goto L4c
        L69:
            r12.r()
            if (r10 == 0) goto L98
        L6e:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r13 = R2.c.f2033m
            java.lang.Object r14 = r13.get(r12)
            if (r14 != 0) goto L79
            F0.G1 r0 = R2.e.f2050q
            goto L7b
        L79:
            F0.G1 r0 = R2.e.f2051r
        L7b:
            boolean r1 = r13.compareAndSet(r12, r14, r0)
            if (r1 == 0) goto L91
            if (r14 != 0) goto L84
            goto L98
        L84:
            kotlin.jvm.internal.u.a(r9, r14)
            F2.l r14 = (F2.l) r14
            java.lang.Throwable r13 = r12.l()
            r14.invoke(r13)
            return r10
        L91:
            java.lang.Object r1 = r13.get(r12)
            if (r1 == r14) goto L7b
            goto L6e
        L98:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: R2.c.g(java.lang.Throwable, boolean):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x008d, code lost:
    
        r1 = (R2.k) ((U2.d) U2.d.f2346b.get(r1));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final R2.k h(long r13) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: R2.c.h(long):R2.k");
    }

    public final void i(long j2) {
        k kVar = (k) f2030j.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f2026c;
            long j3 = atomicLongFieldUpdater.get(this);
            if (j2 < Math.max(this.f2034a + j3, f2027d.get(this))) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j3, 1 + j3)) {
                long j4 = e.f2037b;
                long j5 = j3 / j4;
                int i = (int) (j3 % j4);
                if (kVar.f2376c != j5) {
                    k k4 = k(j5, kVar);
                    if (k4 != null) {
                        kVar = k4;
                    }
                }
                k kVar2 = kVar;
                if (z(kVar2, i, j3, null) == e.f2049o) {
                    if (j3 < o()) {
                        kVar2.b();
                    }
                } else {
                    kVar2.b();
                }
                kVar = kVar2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x00bd, code lost:
    
        if ((r0.addAndGet(r15, r4 - r8) & 4611686018427387904L) != 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x00c6, code lost:
    
        if ((r0.get(r15) & 4611686018427387904L) == 0) goto L144;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j() {
        /*
            Method dump skipped, instructions count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: R2.c.j():void");
    }

    public final k k(long j2, k kVar) {
        Object a2;
        long j3;
        k kVar2 = e.f2036a;
        d dVar = d.f2035a;
        loop0: while (true) {
            a2 = U2.a.a(kVar, j2, dVar);
            if (!U2.a.d(a2)) {
                U2.s b4 = U2.a.b(a2);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2030j;
                    U2.s sVar = (U2.s) atomicReferenceFieldUpdater.get(this);
                    if (sVar.f2376c >= b4.f2376c) {
                        break loop0;
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
        if (U2.a.d(a2)) {
            r();
            if (kVar.f2376c * e.f2037b < o()) {
                kVar.b();
                return null;
            }
        } else {
            k kVar3 = (k) U2.a.b(a2);
            long j4 = kVar3.f2376c;
            if (!t() && j2 <= f2027d.get(this) / e.f2037b) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f2031k;
                    U2.s sVar2 = (U2.s) atomicReferenceFieldUpdater2.get(this);
                    if (sVar2.f2376c >= j4) {
                        break;
                    }
                    if (!kVar3.j()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater2.compareAndSet(this, sVar2, kVar3)) {
                        if (atomicReferenceFieldUpdater2.get(this) != sVar2) {
                            if (kVar3.f()) {
                                kVar3.e();
                            }
                        }
                    }
                    if (sVar2.f()) {
                        sVar2.e();
                    }
                }
            }
            if (j4 > j2) {
                long j5 = j4 * e.f2037b;
                do {
                    j3 = f2026c.get(this);
                    if (j3 >= j5) {
                        break;
                    }
                } while (!f2026c.compareAndSet(this, j3, j5));
                if (j4 * e.f2037b < o()) {
                    kVar3.b();
                }
            } else {
                return kVar3;
            }
        }
        return null;
    }

    public final Throwable l() {
        return (Throwable) f2032l.get(this);
    }

    public final Throwable m() {
        Throwable l3 = l();
        if (l3 == null) {
            return new NoSuchElementException("Channel was closed");
        }
        return l3;
    }

    public final Throwable n() {
        Throwable l3 = l();
        if (l3 == null) {
            return new IllegalStateException("Channel was closed");
        }
        return l3;
    }

    public final long o() {
        return f2025b.get(this) & 1152921504606846975L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x00a2, code lost:
    
        r0 = (R2.k) ((U2.d) U2.d.f2346b.get(r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(long r14, boolean r16) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: R2.c.q(long, boolean):boolean");
    }

    public final boolean r() {
        return q(f2025b.get(this), false);
    }

    public boolean s() {
        return false;
    }

    public final boolean t() {
        long j2 = f2027d.get(this);
        if (j2 != 0 && j2 != Long.MAX_VALUE) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x01c4, code lost:
    
        r16 = r7;
        r3 = (R2.k) r3.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01cd, code lost:
    
        if (r3 != null) goto L98;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 523
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: R2.c.toString():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0011, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(long r5, R2.k r7) {
        /*
            r4 = this;
        L0:
            long r0 = r7.f2376c
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L11
            U2.d r0 = r7.c()
            R2.k r0 = (R2.k) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r7 = r0
            goto L0
        L11:
            boolean r5 = r7.d()
            if (r5 == 0) goto L22
            U2.d r5 = r7.c()
            R2.k r5 = (R2.k) r5
            if (r5 != 0) goto L20
            goto L22
        L20:
            r7 = r5
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = R2.c.f2031k
            java.lang.Object r6 = r5.get(r4)
            U2.s r6 = (U2.s) r6
            long r0 = r6.f2376c
            long r2 = r7.f2376c
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L33
            goto L49
        L33:
            boolean r0 = r7.j()
            if (r0 != 0) goto L3a
            goto L11
        L3a:
            boolean r0 = r5.compareAndSet(r4, r6, r7)
            if (r0 == 0) goto L4a
            boolean r5 = r6.f()
            if (r5 == 0) goto L49
            r6.e()
        L49:
            return
        L4a:
            java.lang.Object r0 = r5.get(r4)
            if (r0 == r6) goto L3a
            boolean r5 = r7.f()
            if (r5 == 0) goto L22
            r7.e()
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: R2.c.u(long, R2.k):void");
    }

    public final Object v(Object obj, InterfaceC0763d interfaceC0763d) {
        C0163m c0163m = new C0163m(1, m3.b.z(interfaceC0763d));
        c0163m.r();
        c0163m.resumeWith(AbstractC0228a.g(n()));
        Object q3 = c0163m.q();
        if (q3 == EnumC0779a.f6740a) {
            return q3;
        }
        return C0684i.f6340a;
    }

    public final void w(K0 k02, boolean z3) {
        Throwable n4;
        if (k02 instanceof InterfaceC0162l) {
            InterfaceC0763d interfaceC0763d = (InterfaceC0763d) k02;
            if (z3) {
                n4 = m();
            } else {
                n4 = n();
            }
            interfaceC0763d.resumeWith(AbstractC0228a.g(n4));
            return;
        }
        if (k02 instanceof b) {
            b bVar = (b) k02;
            C0163m c0163m = bVar.f2023b;
            kotlin.jvm.internal.j.b(c0163m);
            bVar.f2023b = null;
            bVar.f2022a = e.f2046l;
            Throwable l3 = bVar.f2024c.l();
            if (l3 == null) {
                c0163m.resumeWith(Boolean.FALSE);
                return;
            } else {
                c0163m.resumeWith(AbstractC0228a.g(l3));
                return;
            }
        }
        if (k02 instanceof X2.c) {
            ((X2.c) k02).c(this, e.f2046l);
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + k02).toString());
        }
    }

    public final boolean x(Object obj, Object obj2) {
        if (obj instanceof X2.c) {
            return ((X2.c) obj).c(this, obj2);
        }
        if (obj instanceof b) {
            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            b bVar = (b) obj;
            C0163m c0163m = bVar.f2023b;
            kotlin.jvm.internal.j.b(c0163m);
            bVar.f2023b = null;
            bVar.f2022a = obj2;
            Boolean bool = Boolean.TRUE;
            k kVar = e.f2036a;
            G1 e4 = c0163m.e(bool, null);
            if (e4 == null) {
                return false;
            }
            c0163m.f(e4);
            return true;
        }
        if (obj instanceof InterfaceC0162l) {
            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            InterfaceC0162l interfaceC0162l = (InterfaceC0162l) obj;
            k kVar2 = e.f2036a;
            G1 e5 = interfaceC0162l.e(obj2, null);
            if (e5 == null) {
                return false;
            }
            interfaceC0162l.f(e5);
            return true;
        }
        throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
    }

    public final boolean y(Object obj, k kVar, int i) {
        X2.d dVar;
        boolean z3 = obj instanceof InterfaceC0162l;
        C0684i c0684i = C0684i.f6340a;
        if (z3) {
            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            InterfaceC0162l interfaceC0162l = (InterfaceC0162l) obj;
            k kVar2 = e.f2036a;
            G1 e4 = interfaceC0162l.e(c0684i, null);
            if (e4 == null) {
                return false;
            }
            interfaceC0162l.f(e4);
            return true;
        }
        if (obj instanceof X2.c) {
            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            int d2 = ((X2.c) obj).d(this, c0684i);
            if (d2 != 0) {
                if (d2 != 1) {
                    if (d2 != 2) {
                        if (d2 == 3) {
                            dVar = X2.d.f2628d;
                        } else {
                            throw new IllegalStateException(("Unexpected internal result: " + d2).toString());
                        }
                    } else {
                        dVar = X2.d.f2627c;
                    }
                } else {
                    dVar = X2.d.f2626b;
                }
            } else {
                dVar = X2.d.f2625a;
            }
            if (dVar == X2.d.f2626b) {
                kVar.n(i, null);
            }
            if (dVar != X2.d.f2625a) {
                return false;
            }
            return true;
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    public final Object z(k kVar, int i, long j2, Object obj) {
        AtomicReferenceArray atomicReferenceArray = kVar.f2060f;
        Object l3 = kVar.l(i);
        AtomicLongFieldUpdater atomicLongFieldUpdater = f2025b;
        if (l3 == null) {
            if (j2 >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return e.f2048n;
                }
                if (kVar.k(i, l3, obj)) {
                    j();
                    return e.f2047m;
                }
            }
        } else if (l3 == e.f2039d && kVar.k(i, l3, e.i)) {
            j();
            Object obj2 = atomicReferenceArray.get(i * 2);
            kVar.n(i, null);
            return obj2;
        }
        while (true) {
            Object l4 = kVar.l(i);
            if (l4 != null && l4 != e.f2040e) {
                if (l4 == e.f2039d) {
                    if (kVar.k(i, l4, e.i)) {
                        j();
                        Object obj3 = atomicReferenceArray.get(i * 2);
                        kVar.n(i, null);
                        return obj3;
                    }
                } else {
                    G1 g12 = e.f2044j;
                    if (l4 == g12) {
                        return e.f2049o;
                    }
                    if (l4 == e.f2043h) {
                        return e.f2049o;
                    }
                    if (l4 == e.f2046l) {
                        j();
                        return e.f2049o;
                    }
                    if (l4 != e.f2042g && kVar.k(i, l4, e.f2041f)) {
                        boolean z3 = l4 instanceof s;
                        if (z3) {
                            l4 = ((s) l4).f2070a;
                        }
                        if (y(l4, kVar, i)) {
                            kVar.o(i, e.i);
                            j();
                            Object obj4 = atomicReferenceArray.get(i * 2);
                            kVar.n(i, null);
                            return obj4;
                        }
                        kVar.o(i, g12);
                        kVar.i();
                        if (z3) {
                            j();
                        }
                        return e.f2049o;
                    }
                }
            } else if (j2 < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (kVar.k(i, l4, e.f2043h)) {
                    j();
                    return e.f2049o;
                }
            } else {
                if (obj == null) {
                    return e.f2048n;
                }
                if (kVar.k(i, l4, obj)) {
                    j();
                    return e.f2047m;
                }
            }
        }
    }
}
