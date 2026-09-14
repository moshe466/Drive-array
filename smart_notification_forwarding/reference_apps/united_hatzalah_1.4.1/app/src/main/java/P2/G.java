package P2;

import F0.G1;
import a.AbstractC0228a;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.TimeoutCancellationException;
import s2.C0681f;
import s2.C0684i;
import t2.C0716r;
import w2.C0764e;
import w2.C0769j;
import w2.InterfaceC0763d;
import w2.InterfaceC0766g;
import w2.InterfaceC0768i;
import x2.EnumC0779a;
import y2.AbstractC0787c;
import y2.AbstractC0793i;
import y2.InterfaceC0788d;

/* loaded from: classes.dex */
public abstract class G {

    /* renamed from: a, reason: collision with root package name */
    public static final G1 f1604a;

    /* renamed from: b, reason: collision with root package name */
    public static final G1 f1605b;

    /* renamed from: c, reason: collision with root package name */
    public static final G1 f1606c;

    /* renamed from: d, reason: collision with root package name */
    public static final G1 f1607d;

    /* renamed from: e, reason: collision with root package name */
    public static final G1 f1608e;

    /* renamed from: f, reason: collision with root package name */
    public static final G1 f1609f;

    /* renamed from: g, reason: collision with root package name */
    public static final G1 f1610g;

    /* renamed from: h, reason: collision with root package name */
    public static final G1 f1611h;
    public static final T i = new T(false);

    /* renamed from: j, reason: collision with root package name */
    public static final T f1612j = new T(true);

    static {
        int i3 = 8;
        f1604a = new G1("RESUME_TOKEN", i3);
        f1605b = new G1("REMOVED_TASK", i3);
        f1606c = new G1("CLOSED_EMPTY", i3);
        f1607d = new G1("COMPLETING_ALREADY", i3);
        f1608e = new G1("COMPLETING_WAITING_CHILDREN", i3);
        f1609f = new G1("COMPLETING_RETRY", i3);
        f1610g = new G1("TOO_LATE_TO_CANCEL", i3);
        f1611h = new G1("SEALED", i3);
    }

    public static final Object A(long j2, F2.p pVar, AbstractC0787c abstractC0787c) {
        Object c0171v;
        Object E3;
        if (j2 > 0) {
            G0 g02 = new G0(j2, abstractC0787c);
            o(g02, false, new S(k(g02.f2374d.getContext()).a(g02.f1613e, g02, g02.f1641c), 0), 3);
            try {
                kotlin.jvm.internal.u.a(2, pVar);
                c0171v = pVar.invoke(g02, g02);
            } catch (Throwable th) {
                c0171v = new C0171v(th, false);
            }
            Object obj = EnumC0779a.f6740a;
            if (c0171v != obj && (E3 = g02.E(c0171v)) != f1608e) {
                if (E3 instanceof C0171v) {
                    Throwable th2 = ((C0171v) E3).f1707a;
                    if (th2 instanceof TimeoutCancellationException) {
                        if (((TimeoutCancellationException) th2).f5315a == g02) {
                            if (c0171v instanceof C0171v) {
                                throw ((C0171v) c0171v).f1707a;
                            }
                        } else {
                            throw th2;
                        }
                    } else {
                        throw th2;
                    }
                } else {
                    c0171v = x(E3);
                }
                return c0171v;
            }
            return obj;
        }
        throw new TimeoutCancellationException("Timed out immediately", null);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [P2.w0, P2.t] */
    public static C0169t a() {
        ?? w0Var = new w0(true);
        w0Var.A(null);
        return w0Var;
    }

    public static final U2.e b(InterfaceC0768i interfaceC0768i) {
        if (interfaceC0768i.get(B.f1595b) == null) {
            interfaceC0768i = interfaceC0768i.plus(new C0161k0());
        }
        return new U2.e(interfaceC0768i);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [P2.a, P2.K] */
    public static K c(E e4, F2.p pVar) {
        F f4 = F.f1598a;
        InterfaceC0768i s3 = s(e4, C0769j.f6733a);
        F f5 = F.f1598a;
        ?? abstractC0140a = new AbstractC0140a(s3, true);
        abstractC0140a.R(f4, abstractC0140a, pVar);
        return abstractC0140a;
    }

    public static final Object d(J[] jArr, AbstractC0793i abstractC0793i) {
        if (jArr.length == 0) {
            return C0716r.f6476a;
        }
        C0148e c0148e = new C0148e(jArr);
        C0163m c0163m = new C0163m(1, m3.b.z(abstractC0793i));
        c0163m.r();
        int length = jArr.length;
        C0144c[] c0144cArr = new C0144c[length];
        for (int i3 = 0; i3 < length; i3++) {
            J j2 = jArr[i3];
            j2.start();
            C0144c c0144c = new C0144c(c0148e, c0163m);
            c0144c.f1646f = o(j2, false, c0144c, 3);
            c0144cArr[i3] = c0144c;
        }
        C0146d c0146d = new C0146d(c0144cArr);
        for (int i4 = 0; i4 < length; i4++) {
            C0144c c0144c2 = c0144cArr[i4];
            c0144c2.getClass();
            C0144c.f1644k.set(c0144c2, c0146d);
        }
        if (!(C0163m.f1671j.get(c0163m) instanceof A0)) {
            c0146d.b();
        } else {
            c0163m.t(c0146d);
        }
        Object q3 = c0163m.q();
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        return q3;
    }

    public static final void e(E e4, String str, Exception exc) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(exc);
        InterfaceC0157i0 interfaceC0157i0 = (InterfaceC0157i0) e4.a().get(B.f1595b);
        if (interfaceC0157i0 != null) {
            interfaceC0157i0.cancel(cancellationException);
        } else {
            throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + e4).toString());
        }
    }

    public static void f(InterfaceC0768i interfaceC0768i) {
        M2.d children;
        InterfaceC0157i0 interfaceC0157i0 = (InterfaceC0157i0) interfaceC0768i.get(B.f1595b);
        if (interfaceC0157i0 != null && (children = interfaceC0157i0.getChildren()) != null) {
            Iterator it = children.iterator();
            while (it.hasNext()) {
                ((InterfaceC0157i0) it.next()).cancel(null);
            }
        }
    }

    public static final Object g(F2.p pVar, InterfaceC0763d interfaceC0763d) {
        U2.r rVar = new U2.r(interfaceC0763d, interfaceC0763d.getContext());
        Object A3 = AbstractC0228a.A(rVar, rVar, pVar);
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        return A3;
    }

    public static final Object h(long j2, AbstractC0787c abstractC0787c) {
        if (j2 > 0) {
            C0163m c0163m = new C0163m(1, m3.b.z(abstractC0787c));
            c0163m.r();
            if (j2 < Long.MAX_VALUE) {
                k(c0163m.f1674e).b(j2, c0163m);
            }
            Object q3 = c0163m.q();
            if (q3 == EnumC0779a.f6740a) {
                return q3;
            }
        }
        return C0684i.f6340a;
    }

    public static final void i(InterfaceC0768i interfaceC0768i) {
        InterfaceC0157i0 interfaceC0157i0 = (InterfaceC0157i0) interfaceC0768i.get(B.f1595b);
        if (interfaceC0157i0 != null && !interfaceC0157i0.isActive()) {
            throw interfaceC0157i0.getCancellationException();
        }
    }

    public static final InterfaceC0768i j(InterfaceC0768i interfaceC0768i, InterfaceC0768i interfaceC0768i2, boolean z3) {
        Boolean bool = Boolean.FALSE;
        C0173x c0173x = C0173x.f1712c;
        boolean booleanValue = ((Boolean) interfaceC0768i.fold(bool, c0173x)).booleanValue();
        boolean booleanValue2 = ((Boolean) interfaceC0768i2.fold(bool, c0173x)).booleanValue();
        if (!booleanValue && !booleanValue2) {
            return interfaceC0768i.plus(interfaceC0768i2);
        }
        C0173x c0173x2 = new C0173x(2, 2);
        C0769j c0769j = C0769j.f6733a;
        InterfaceC0768i interfaceC0768i3 = (InterfaceC0768i) interfaceC0768i.fold(c0769j, c0173x2);
        Object obj = interfaceC0768i2;
        if (booleanValue2) {
            obj = interfaceC0768i2.fold(c0769j, C0173x.f1711b);
        }
        return interfaceC0768i3.plus((InterfaceC0768i) obj);
    }

    public static final L k(InterfaceC0768i interfaceC0768i) {
        L l3;
        InterfaceC0766g interfaceC0766g = interfaceC0768i.get(C0764e.f6732a);
        if (interfaceC0766g instanceof L) {
            l3 = (L) interfaceC0766g;
        } else {
            l3 = null;
        }
        if (l3 == null) {
            return I.f1617a;
        }
        return l3;
    }

    public static final String l(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final C0163m m(InterfaceC0763d interfaceC0763d) {
        C0163m c0163m;
        C0163m c0163m2;
        if (!(interfaceC0763d instanceof U2.g)) {
            return new C0163m(1, interfaceC0763d);
        }
        U2.g gVar = (U2.g) interfaceC0763d;
        G1 g12 = U2.a.f2340d;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = U2.g.f2349k;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(gVar);
            c0163m = null;
            if (obj == null) {
                atomicReferenceFieldUpdater.set(gVar, g12);
                c0163m2 = null;
                break;
            }
            if (obj instanceof C0163m) {
                while (!atomicReferenceFieldUpdater.compareAndSet(gVar, obj, g12)) {
                    if (atomicReferenceFieldUpdater.get(gVar) != obj) {
                        break;
                    }
                }
                c0163m2 = (C0163m) obj;
                break loop0;
            }
            if (obj != g12 && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
        if (c0163m2 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = C0163m.f1671j;
            Object obj2 = atomicReferenceFieldUpdater2.get(c0163m2);
            if ((obj2 instanceof C0170u) && ((C0170u) obj2).f1703d != null) {
                c0163m2.n();
            } else {
                C0163m.f1670f.set(c0163m2, 536870911);
                atomicReferenceFieldUpdater2.set(c0163m2, C0142b.f1642a);
                c0163m = c0163m2;
            }
            if (c0163m != null) {
                return c0163m;
            }
        }
        return new C0163m(2, interfaceC0763d);
    }

    public static final void n(Throwable th, InterfaceC0768i interfaceC0768i) {
        try {
            C c4 = (C) interfaceC0768i.get(B.f1594a);
            if (c4 != null) {
                c4.c(th);
            } else {
                U2.a.c(th, interfaceC0768i);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                E1.b.b(runtimeException, th);
                th = runtimeException;
            }
            U2.a.c(th, interfaceC0768i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [F2.l, kotlin.jvm.internal.h] */
    public static Q o(InterfaceC0157i0 interfaceC0157i0, boolean z3, m0 m0Var, int i3) {
        boolean z4 = false;
        if ((i3 & 1) != 0) {
            z3 = false;
        }
        if ((i3 & 2) != 0) {
            z4 = true;
        }
        if (interfaceC0157i0 instanceof w0) {
            return ((w0) interfaceC0157i0).B(z3, z4, m0Var);
        }
        return interfaceC0157i0.invokeOnCompletion(z3, z4, new kotlin.jvm.internal.h(1, m0Var, InterfaceC0153g0.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object p(java.util.List r4, y2.AbstractC0787c r5) {
        /*
            boolean r0 = r5 instanceof P2.C0152g
            if (r0 == 0) goto L13
            r0 = r5
            P2.g r0 = (P2.C0152g) r0
            int r1 = r0.f1661c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1661c = r1
            goto L18
        L13:
            P2.g r0 = new P2.g
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f1660b
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.f1661c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            java.util.Iterator r4 = r0.f1659a
            a.AbstractC0228a.C(r5)
            goto L38
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            a.AbstractC0228a.C(r5)
            java.util.Iterator r4 = r4.iterator()
        L38:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L4f
            java.lang.Object r5 = r4.next()
            P2.i0 r5 = (P2.InterfaceC0157i0) r5
            r0.f1659a = r4
            r0.f1661c = r3
            java.lang.Object r5 = r5.join(r0)
            if (r5 != r1) goto L38
            return r1
        L4f:
            s2.i r4 = s2.C0684i.f6340a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: P2.G.p(java.util.List, y2.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0050 -> B:10:0x0053). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object q(P2.InterfaceC0157i0[] r6, y2.AbstractC0787c r7) {
        /*
            boolean r0 = r7 instanceof P2.C0150f
            if (r0 == 0) goto L13
            r0 = r7
            P2.f r0 = (P2.C0150f) r0
            int r1 = r0.f1657e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1657e = r1
            goto L18
        L13:
            P2.f r0 = new P2.f
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f1656d
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.f1657e
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            int r6 = r0.f1655c
            int r2 = r0.f1654b
            java.lang.Object[] r4 = r0.f1653a
            P2.i0[] r4 = (P2.InterfaceC0157i0[]) r4
            a.AbstractC0228a.C(r7)
            r7 = r4
            goto L53
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            a.AbstractC0228a.C(r7)
            int r7 = r6.length
            r2 = 0
            r5 = r7
            r7 = r6
            r6 = r5
        L40:
            if (r2 >= r6) goto L55
            r4 = r7[r2]
            r0.f1653a = r7
            r0.f1654b = r2
            r0.f1655c = r6
            r0.f1657e = r3
            java.lang.Object r4 = r4.join(r0)
            if (r4 != r1) goto L53
            return r1
        L53:
            int r2 = r2 + r3
            goto L40
        L55:
            s2.i r6 = s2.C0684i.f6340a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: P2.G.q(P2.i0[], y2.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [P2.a, P2.C0] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    public static C0 r(E e4, InterfaceC0768i interfaceC0768i, F2.p pVar, int i3) {
        ?? r3;
        F f4 = F.f1601d;
        if ((i3 & 1) != 0) {
            interfaceC0768i = C0769j.f6733a;
        }
        if ((i3 & 2) != 0) {
            f4 = F.f1598a;
        }
        InterfaceC0768i s3 = s(e4, interfaceC0768i);
        if (f4 == F.f1599b) {
            r3 = new x0(s3, pVar);
        } else {
            r3 = new AbstractC0140a(s3, true);
        }
        r3.R(f4, r3, pVar);
        return r3;
    }

    public static final InterfaceC0768i s(E e4, InterfaceC0768i interfaceC0768i) {
        InterfaceC0768i j2 = j(e4.a(), interfaceC0768i, true);
        W2.e eVar = O.f1622a;
        if (j2 != eVar && j2.get(C0764e.f6732a) == null) {
            return j2.plus(eVar);
        }
        return j2;
    }

    public static final Object t(Object obj) {
        if (obj instanceof C0171v) {
            return AbstractC0228a.g(((C0171v) obj).f1707a);
        }
        return obj;
    }

    public static final void u(C0163m c0163m, InterfaceC0763d interfaceC0763d, boolean z3) {
        Object g3;
        I0 i02;
        Object obj = C0163m.f1671j.get(c0163m);
        Throwable d2 = c0163m.d(obj);
        if (d2 != null) {
            g3 = AbstractC0228a.g(d2);
        } else {
            g3 = c0163m.g(obj);
        }
        if (z3) {
            kotlin.jvm.internal.j.c(interfaceC0763d, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
            U2.g gVar = (U2.g) interfaceC0763d;
            AbstractC0787c abstractC0787c = gVar.f2351e;
            Object obj2 = gVar.f2353j;
            InterfaceC0768i context = abstractC0787c.getContext();
            Object l3 = U2.a.l(context, obj2);
            if (l3 != U2.a.f2342f) {
                i02 = y(abstractC0787c, context, l3);
            } else {
                i02 = null;
            }
            try {
                abstractC0787c.resumeWith(g3);
                if (i02 != null && !i02.S()) {
                    return;
                }
                U2.a.f(context, l3);
                return;
            } catch (Throwable th) {
                if (i02 == null || i02.S()) {
                    U2.a.f(context, l3);
                }
                throw th;
            }
        }
        interfaceC0763d.resumeWith(g3);
    }

    public static Object v(F2.p pVar) {
        Object obj;
        InterfaceC0768i interfaceC0768i;
        long j2;
        C0171v c0171v;
        Thread currentThread = Thread.currentThread();
        Z a2 = F0.a();
        boolean booleanValue = ((Boolean) a2.fold(Boolean.FALSE, C0173x.f1712c)).booleanValue();
        if (!booleanValue) {
            interfaceC0768i = a2;
        } else {
            C0769j c0769j = C0769j.f6733a;
            if (booleanValue) {
                obj = a2.fold(c0769j, C0173x.f1711b);
            } else {
                obj = a2;
            }
            interfaceC0768i = (InterfaceC0768i) obj;
            c0769j.plus(interfaceC0768i);
        }
        W2.e eVar = O.f1622a;
        if (interfaceC0768i != eVar && interfaceC0768i.get(C0764e.f6732a) == null) {
            interfaceC0768i = interfaceC0768i.plus(eVar);
        }
        C0154h c0154h = new C0154h(interfaceC0768i, currentThread, a2);
        c0154h.R(F.f1598a, c0154h, pVar);
        Z z3 = c0154h.f1663e;
        if (z3 != null) {
            int i3 = Z.f1637f;
            z3.h(false);
        }
        while (!Thread.interrupted()) {
            try {
                if (z3 != null) {
                    j2 = z3.i();
                } else {
                    j2 = Long.MAX_VALUE;
                }
                if (c0154h.x() instanceof InterfaceC0147d0) {
                    LockSupport.parkNanos(c0154h, j2);
                } else {
                    if (z3 != null) {
                        int i4 = Z.f1637f;
                        z3.f(false);
                    }
                    Object x3 = x(c0154h.x());
                    if (x3 instanceof C0171v) {
                        c0171v = (C0171v) x3;
                    } else {
                        c0171v = null;
                    }
                    if (c0171v == null) {
                        return x3;
                    }
                    throw c0171v.f1707a;
                }
            } catch (Throwable th) {
                if (z3 != null) {
                    int i5 = Z.f1637f;
                    z3.f(false);
                }
                throw th;
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        c0154h.k(interruptedException);
        throw interruptedException;
    }

    public static final String w(InterfaceC0763d interfaceC0763d) {
        Object g3;
        if (interfaceC0763d instanceof U2.g) {
            return interfaceC0763d.toString();
        }
        try {
            g3 = interfaceC0763d + '@' + l(interfaceC0763d);
        } catch (Throwable th) {
            g3 = AbstractC0228a.g(th);
        }
        if (C0681f.a(g3) != null) {
            g3 = interfaceC0763d.getClass().getName() + '@' + l(interfaceC0763d);
        }
        return (String) g3;
    }

    public static final Object x(Object obj) {
        C0149e0 c0149e0;
        InterfaceC0147d0 interfaceC0147d0;
        if (obj instanceof C0149e0) {
            c0149e0 = (C0149e0) obj;
        } else {
            c0149e0 = null;
        }
        if (c0149e0 != null && (interfaceC0147d0 = c0149e0.f1652a) != null) {
            return interfaceC0147d0;
        }
        return obj;
    }

    public static final I0 y(InterfaceC0763d interfaceC0763d, InterfaceC0768i interfaceC0768i, Object obj) {
        I0 i02 = null;
        if ((interfaceC0763d instanceof InterfaceC0788d) && interfaceC0768i.get(J0.f1619a) != null) {
            InterfaceC0788d interfaceC0788d = (InterfaceC0788d) interfaceC0763d;
            while (true) {
                if ((interfaceC0788d instanceof M) || (interfaceC0788d = interfaceC0788d.getCallerFrame()) == null) {
                    break;
                }
                if (interfaceC0788d instanceof I0) {
                    i02 = (I0) interfaceC0788d;
                    break;
                }
            }
            if (i02 != null) {
                i02.T(interfaceC0768i, obj);
            }
        }
        return i02;
    }

    public static final Object z(InterfaceC0768i interfaceC0768i, F2.p pVar, InterfaceC0763d interfaceC0763d) {
        InterfaceC0768i j2;
        Object x3;
        InterfaceC0768i context = interfaceC0763d.getContext();
        if (!((Boolean) interfaceC0768i.fold(Boolean.FALSE, C0173x.f1712c)).booleanValue()) {
            j2 = context.plus(interfaceC0768i);
        } else {
            j2 = j(context, interfaceC0768i, false);
        }
        i(j2);
        if (j2 == context) {
            U2.r rVar = new U2.r(interfaceC0763d, j2);
            x3 = AbstractC0228a.A(rVar, rVar, pVar);
        } else {
            C0764e c0764e = C0764e.f6732a;
            if (kotlin.jvm.internal.j.a(j2.get(c0764e), context.get(c0764e))) {
                I0 i02 = new I0(interfaceC0763d, j2);
                InterfaceC0768i interfaceC0768i2 = i02.f1641c;
                Object l3 = U2.a.l(interfaceC0768i2, null);
                try {
                    Object A3 = AbstractC0228a.A(i02, i02, pVar);
                    U2.a.f(interfaceC0768i2, l3);
                    x3 = A3;
                } catch (Throwable th) {
                    U2.a.f(interfaceC0768i2, l3);
                    throw th;
                }
            } else {
                U2.r rVar2 = new U2.r(interfaceC0763d, j2);
                T.b.I(pVar, rVar2, rVar2);
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = M.f1620e;
                while (true) {
                    int i3 = atomicIntegerFieldUpdater.get(rVar2);
                    if (i3 != 0) {
                        if (i3 == 2) {
                            x3 = x(rVar2.x());
                            if (x3 instanceof C0171v) {
                                throw ((C0171v) x3).f1707a;
                            }
                        } else {
                            throw new IllegalStateException("Already suspended");
                        }
                    } else if (atomicIntegerFieldUpdater.compareAndSet(rVar2, 0, 1)) {
                        x3 = EnumC0779a.f6740a;
                        break;
                    }
                }
            }
        }
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        return x3;
    }
}
