package P2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.CompletionHandlerException;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.TimeoutCancellationException;
import s2.C0684i;
import w2.InterfaceC0763d;
import w2.InterfaceC0766g;
import w2.InterfaceC0767h;
import w2.InterfaceC0768i;
import x2.EnumC0779a;

/* loaded from: classes.dex */
public class w0 implements InterfaceC0157i0, r, B0 {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f1709a = AtomicReferenceFieldUpdater.newUpdater(w0.class, Object.class, "_state$volatile");

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f1710b = AtomicReferenceFieldUpdater.newUpdater(w0.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    public w0(boolean z3) {
        T t3;
        if (z3) {
            t3 = G.f1612j;
        } else {
            t3 = G.i;
        }
        this._state$volatile = t3;
    }

    public static C0167q G(U2.j jVar) {
        while (jVar.h()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = U2.j.f2361b;
            U2.j d2 = jVar.d();
            if (d2 == null) {
                Object obj = atomicReferenceFieldUpdater.get(jVar);
                while (true) {
                    jVar = (U2.j) obj;
                    if (!jVar.h()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(jVar);
                }
            } else {
                jVar = d2;
            }
        }
        while (true) {
            jVar = jVar.g();
            if (!jVar.h()) {
                if (jVar instanceof C0167q) {
                    return (C0167q) jVar;
                }
                if (jVar instanceof y0) {
                    return null;
                }
            }
        }
    }

    public static String M(Object obj) {
        if (obj instanceof p0) {
            p0 p0Var = (p0) obj;
            if (p0Var.d()) {
                return "Cancelling";
            }
            if (p0Var.e()) {
                return "Completing";
            }
            return "Active";
        }
        if (obj instanceof InterfaceC0147d0) {
            if (((InterfaceC0147d0) obj).isActive()) {
                return "Active";
            }
            return "New";
        }
        if (obj instanceof C0171v) {
            return "Cancelled";
        }
        return "Completed";
    }

    public static CancellationException N(w0 w0Var, Throwable th) {
        CancellationException cancellationException;
        if (th instanceof CancellationException) {
            cancellationException = (CancellationException) th;
        } else {
            cancellationException = null;
        }
        if (cancellationException == null) {
            return new JobCancellationException(w0Var.n(), th, w0Var);
        }
        return cancellationException;
    }

    public final void A(InterfaceC0157i0 interfaceC0157i0) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1710b;
        z0 z0Var = z0.f1718a;
        if (interfaceC0157i0 == null) {
            atomicReferenceFieldUpdater.set(this, z0Var);
            return;
        }
        interfaceC0157i0.start();
        InterfaceC0166p attachChild = interfaceC0157i0.attachChild(this);
        atomicReferenceFieldUpdater.set(this, attachChild);
        if (!(x() instanceof InterfaceC0147d0)) {
            attachChild.dispose();
            atomicReferenceFieldUpdater.set(this, z0Var);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c8, code lost:
    
        return r1;
     */
    /* JADX WARN: Type inference failed for: r2v2, types: [P2.y0, U2.j] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final P2.Q B(boolean r8, boolean r9, P2.InterfaceC0153g0 r10) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: P2.w0.B(boolean, boolean, P2.g0):P2.Q");
    }

    public boolean C() {
        return this instanceof C0154h;
    }

    public final boolean D(Object obj) {
        Object O3;
        do {
            O3 = O(x(), obj);
            if (O3 == G.f1607d) {
                return false;
            }
            if (O3 == G.f1608e) {
                return true;
            }
        } while (O3 == G.f1609f);
        h(O3);
        return true;
    }

    public final Object E(Object obj) {
        Object O3;
        C0171v c0171v;
        do {
            O3 = O(x(), obj);
            if (O3 == G.f1607d) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                Throwable th = null;
                if (obj instanceof C0171v) {
                    c0171v = (C0171v) obj;
                } else {
                    c0171v = null;
                }
                if (c0171v != null) {
                    th = c0171v.f1707a;
                }
                throw new IllegalStateException(str, th);
            }
        } while (O3 == G.f1609f);
        return O3;
    }

    public String F() {
        return getClass().getSimpleName();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Throwable, kotlinx.coroutines.CompletionHandlerException] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.RuntimeException] */
    /* JADX WARN: Type inference failed for: r1v5 */
    public final void H(y0 y0Var, Throwable th) {
        Object f4 = y0Var.f();
        kotlin.jvm.internal.j.c(f4, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        U2.j jVar = (U2.j) f4;
        CompletionHandlerException completionHandlerException = 0;
        while (!jVar.equals(y0Var)) {
            if (jVar instanceof AbstractC0159j0) {
                m0 m0Var = (m0) jVar;
                try {
                    m0Var.a(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != 0) {
                        E1.b.b(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new RuntimeException("Exception in completion handler " + m0Var + " for " + this, th2);
                    }
                }
            }
            jVar = jVar.g();
            completionHandlerException = completionHandlerException;
        }
        if (completionHandlerException != 0) {
            z(completionHandlerException);
        }
        m(th);
    }

    public final void K(m0 m0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        U2.j jVar = new U2.j();
        m0Var.getClass();
        U2.j.f2361b.set(jVar, m0Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = U2.j.f2360a;
        atomicReferenceFieldUpdater2.set(jVar, m0Var);
        loop0: while (true) {
            if (m0Var.f() != m0Var) {
                break;
            }
            while (!atomicReferenceFieldUpdater2.compareAndSet(m0Var, m0Var, jVar)) {
                if (atomicReferenceFieldUpdater2.get(m0Var) != m0Var) {
                    break;
                }
            }
            jVar.e(m0Var);
        }
        U2.j g3 = m0Var.g();
        do {
            atomicReferenceFieldUpdater = f1709a;
            if (atomicReferenceFieldUpdater.compareAndSet(this, m0Var, g3)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == m0Var);
    }

    public final int L(Object obj) {
        boolean z3 = obj instanceof T;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1709a;
        if (z3) {
            if (!((T) obj).f1627a) {
                T t3 = G.f1612j;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, t3)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        return -1;
                    }
                }
                J();
                return 1;
            }
            return 0;
        }
        if (obj instanceof C0145c0) {
            y0 y0Var = ((C0145c0) obj).f1648a;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, y0Var)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    return -1;
                }
            }
            J();
            return 1;
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00bf, code lost:
    
        if (r2 != null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00cf, code lost:
    
        if (P2.G.o(r2.f1687e, false, new P2.o0(r6, r1, r2, r8), 1) == P2.z0.f1718a) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d4, code lost:
    
        r2 = G(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00d8, code lost:
    
        if (r2 != null) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d3, code lost:
    
        return P2.G.f1608e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00de, code lost:
    
        return r(r1, r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object O(java.lang.Object r7, java.lang.Object r8) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: P2.w0.O(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // P2.InterfaceC0157i0
    public final InterfaceC0166p attachChild(r rVar) {
        Q o2 = G.o(this, true, new C0167q(rVar), 2);
        kotlin.jvm.internal.j.c(o2, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (InterfaceC0166p) o2;
    }

    @Override // P2.InterfaceC0157i0
    public void cancel(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(n(), null, this);
        }
        l(cancellationException);
    }

    @Override // w2.InterfaceC0768i
    public final Object fold(Object obj, F2.p pVar) {
        return pVar.invoke(obj, this);
    }

    public final boolean g(InterfaceC0147d0 interfaceC0147d0, y0 y0Var, m0 m0Var) {
        char c4;
        r0 r0Var = new r0(m0Var, this, interfaceC0147d0);
        do {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = U2.j.f2361b;
            U2.j d2 = y0Var.d();
            if (d2 == null) {
                Object obj = atomicReferenceFieldUpdater.get(y0Var);
                while (true) {
                    d2 = (U2.j) obj;
                    if (!d2.h()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(d2);
                }
            }
            U2.j.f2361b.set(m0Var, d2);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = U2.j.f2360a;
            atomicReferenceFieldUpdater2.set(m0Var, y0Var);
            r0Var.f1691c = y0Var;
            while (true) {
                if (atomicReferenceFieldUpdater2.compareAndSet(d2, y0Var, r0Var)) {
                    if (r0Var.a(d2) == null) {
                        c4 = 1;
                    } else {
                        c4 = 2;
                    }
                } else if (atomicReferenceFieldUpdater2.get(d2) != y0Var) {
                    c4 = 0;
                    break;
                }
            }
            if (c4 == 1) {
                return true;
            }
        } while (c4 != 2);
        return false;
    }

    @Override // w2.InterfaceC0768i
    public final InterfaceC0766g get(InterfaceC0767h interfaceC0767h) {
        return T.b.v(this, interfaceC0767h);
    }

    @Override // P2.InterfaceC0157i0
    public final CancellationException getCancellationException() {
        Object x3 = x();
        CancellationException cancellationException = null;
        if (x3 instanceof p0) {
            Throwable b4 = ((p0) x3).b();
            if (b4 != null) {
                String concat = getClass().getSimpleName().concat(" is cancelling");
                if (b4 instanceof CancellationException) {
                    cancellationException = (CancellationException) b4;
                }
                if (cancellationException == null) {
                    if (concat == null) {
                        concat = n();
                    }
                    return new JobCancellationException(concat, b4, this);
                }
                return cancellationException;
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (!(x3 instanceof InterfaceC0147d0)) {
            if (x3 instanceof C0171v) {
                return N(this, ((C0171v) x3).f1707a);
            }
            return new JobCancellationException(getClass().getSimpleName().concat(" has completed normally"), null, this);
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    @Override // P2.InterfaceC0157i0
    public final M2.d getChildren() {
        return new D2.c(new s0(this, null), 1);
    }

    public Object getCompleted() {
        return s();
    }

    public final Throwable getCompletionExceptionOrNull() {
        C0171v c0171v;
        Object x3 = x();
        if (!(x3 instanceof InterfaceC0147d0)) {
            if (x3 instanceof C0171v) {
                c0171v = (C0171v) x3;
            } else {
                c0171v = null;
            }
            if (c0171v == null) {
                return null;
            }
            return c0171v.f1707a;
        }
        throw new IllegalStateException("This job has not completed yet");
    }

    @Override // w2.InterfaceC0766g
    public final InterfaceC0767h getKey() {
        return B.f1595b;
    }

    @Override // P2.InterfaceC0157i0
    public final InterfaceC0157i0 getParent() {
        InterfaceC0166p interfaceC0166p = (InterfaceC0166p) f1710b.get(this);
        if (interfaceC0166p != null) {
            return interfaceC0166p.getParent();
        }
        return null;
    }

    public void i(Object obj) {
        h(obj);
    }

    @Override // P2.InterfaceC0157i0
    public final Q invokeOnCompletion(F2.l lVar) {
        return B(false, true, new C0151f0(lVar));
    }

    @Override // P2.InterfaceC0157i0
    public boolean isActive() {
        Object x3 = x();
        if ((x3 instanceof InterfaceC0147d0) && ((InterfaceC0147d0) x3).isActive()) {
            return true;
        }
        return false;
    }

    @Override // P2.InterfaceC0157i0
    public final boolean isCancelled() {
        Object x3 = x();
        if (!(x3 instanceof C0171v)) {
            if (!(x3 instanceof p0) || !((p0) x3).d()) {
                return false;
            }
            return true;
        }
        return true;
    }

    public final Object j(InterfaceC0763d interfaceC0763d) {
        Object x3;
        do {
            x3 = x();
            if (!(x3 instanceof InterfaceC0147d0)) {
                if (!(x3 instanceof C0171v)) {
                    return G.x(x3);
                }
                throw ((C0171v) x3).f1707a;
            }
        } while (L(x3) < 0);
        n0 n0Var = new n0(this, m3.b.z(interfaceC0763d));
        n0Var.r();
        int i = 2;
        n0Var.t(new C0158j(G.o(this, false, new S(n0Var, i), 3), i));
        Object q3 = n0Var.q();
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        return q3;
    }

    @Override // P2.InterfaceC0157i0
    public final Object join(InterfaceC0763d interfaceC0763d) {
        Object x3;
        C0684i c0684i;
        do {
            x3 = x();
            boolean z3 = x3 instanceof InterfaceC0147d0;
            c0684i = C0684i.f6340a;
            if (!z3) {
                G.i(interfaceC0763d.getContext());
                return c0684i;
            }
        } while (L(x3) < 0);
        C0163m c0163m = new C0163m(1, m3.b.z(interfaceC0763d));
        c0163m.r();
        c0163m.t(new C0158j(G.o(this, false, new S(c0163m, 3), 3), 2));
        Object q3 = c0163m.q();
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        if (q3 != enumC0779a) {
            q3 = c0684i;
        }
        if (q3 == enumC0779a) {
            return q3;
        }
        return c0684i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0032, code lost:
    
        r0 = P2.G.f1607d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0036, code lost:
    
        if (r0 != P2.G.f1608e) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x00ff, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:
    
        r0 = O(r0, new P2.C0171v(q(r10), false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        if (r0 == P2.G.f1609f) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        if (r0 != P2.G.f1607d) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003e, code lost:
    
        r0 = null;
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0040, code lost:
    
        r4 = x();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        if ((r4 instanceof P2.p0) == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0094, code lost:
    
        if ((r4 instanceof P2.InterfaceC0147d0) == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0096, code lost:
    
        if (r1 != null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0098, code lost:
    
        r1 = q(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009c, code lost:
    
        r5 = (P2.InterfaceC0147d0) r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0008, code lost:
    
        if (v() != false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a3, code lost:
    
        if (r5.isActive() == false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c7, code lost:
    
        r5 = O(r4, new P2.C0171v(r1, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d2, code lost:
    
        if (r5 == P2.G.f1607d) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d6, code lost:
    
        if (r5 == P2.G.f1609f) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d8, code lost:
    
        r0 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
    
        r0 = x();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f1, code lost:
    
        throw new java.lang.IllegalStateException(("Cannot happen in " + r4).toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a5, code lost:
    
        r6 = w(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a9, code lost:
    
        if (r6 != null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ac, code lost:
    
        r7 = new P2.p0(r6, r1);
        r8 = P2.w0.f1709a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b7, code lost:
    
        if (r8.compareAndSet(r9, r5, r7) == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:
    
        if ((r0 instanceof P2.InterfaceC0147d0) == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c3, code lost:
    
        if (r8.get(r9) == r5) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b9, code lost:
    
        H(r6, r1);
        r10 = P2.G.f1607d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0061, code lost:
    
        r0 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00f2, code lost:
    
        r10 = P2.G.f1610g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0048, code lost:
    
        monitor-enter(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0049, code lost:
    
        r5 = (P2.p0) r4;
        r5.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0057, code lost:
    
        if (P2.p0.f1685d.get(r5) != P2.G.f1611h) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0059, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x005c, code lost:
    
        if (r5 == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x005e, code lost:
    
        r10 = P2.G.f1610g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0060, code lost:
    
        monitor-exit(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0066, code lost:
    
        r5 = ((P2.p0) r4).d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0014, code lost:
    
        if ((r0 instanceof P2.p0) == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x006d, code lost:
    
        if (r1 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x006f, code lost:
    
        r1 = q(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0073, code lost:
    
        ((P2.p0) r4).a(r1);
        r10 = ((P2.p0) r4).b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0080, code lost:
    
        if (r5 != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0082, code lost:
    
        r0 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0083, code lost:
    
        monitor-exit(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0084, code lost:
    
        if (r0 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0086, code lost:
    
        H(((P2.p0) r4).f1686a, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x008d, code lost:
    
        r10 = P2.G.f1607d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x005b, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00f8, code lost:
    
        if (r0 != P2.G.f1607d) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00fd, code lost:
    
        if (r0 != P2.G.f1608e) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0102, code lost:
    
        if (r0 != P2.G.f1610g) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0104, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0105, code lost:
    
        h(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
    
        if (((P2.p0) r0).e() == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0108, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean k(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: P2.w0.k(java.lang.Object):boolean");
    }

    public void l(CancellationException cancellationException) {
        k(cancellationException);
    }

    public final boolean m(Throwable th) {
        if (!C()) {
            boolean z3 = th instanceof CancellationException;
            InterfaceC0166p interfaceC0166p = (InterfaceC0166p) f1710b.get(this);
            if (interfaceC0166p != null && interfaceC0166p != z0.f1718a) {
                if (!interfaceC0166p.b(th) && !z3) {
                    return false;
                }
                return true;
            }
            return z3;
        }
        return true;
    }

    @Override // w2.InterfaceC0768i
    public final InterfaceC0768i minusKey(InterfaceC0767h interfaceC0767h) {
        return T.b.D(this, interfaceC0767h);
    }

    public String n() {
        return "Job was cancelled";
    }

    public boolean o(Throwable th) {
        if (!(th instanceof CancellationException)) {
            if (k(th) && u()) {
                return true;
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.RuntimeException, kotlinx.coroutines.CompletionHandlerException] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Throwable, kotlinx.coroutines.CompletionHandlerException] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.RuntimeException] */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final void p(InterfaceC0147d0 interfaceC0147d0, Object obj) {
        C0171v c0171v;
        Throwable th;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1710b;
        InterfaceC0166p interfaceC0166p = (InterfaceC0166p) atomicReferenceFieldUpdater.get(this);
        if (interfaceC0166p != null) {
            interfaceC0166p.dispose();
            atomicReferenceFieldUpdater.set(this, z0.f1718a);
        }
        CompletionHandlerException completionHandlerException = 0;
        if (obj instanceof C0171v) {
            c0171v = (C0171v) obj;
        } else {
            c0171v = null;
        }
        if (c0171v != null) {
            th = c0171v.f1707a;
        } else {
            th = null;
        }
        if (interfaceC0147d0 instanceof m0) {
            try {
                ((m0) interfaceC0147d0).a(th);
                return;
            } catch (Throwable th2) {
                z(new RuntimeException("Exception in completion handler " + interfaceC0147d0 + " for " + this, th2));
                return;
            }
        }
        y0 c4 = interfaceC0147d0.c();
        if (c4 != null) {
            Object f4 = c4.f();
            kotlin.jvm.internal.j.c(f4, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            U2.j jVar = (U2.j) f4;
            while (!jVar.equals(c4)) {
                if (jVar instanceof m0) {
                    m0 m0Var = (m0) jVar;
                    try {
                        m0Var.a(th);
                    } catch (Throwable th3) {
                        if (completionHandlerException != 0) {
                            E1.b.b(completionHandlerException, th3);
                        } else {
                            completionHandlerException = new RuntimeException("Exception in completion handler " + m0Var + " for " + this, th3);
                        }
                    }
                }
                jVar = jVar.g();
                completionHandlerException = completionHandlerException;
            }
            if (completionHandlerException != 0) {
                z(completionHandlerException);
            }
        }
    }

    @Override // w2.InterfaceC0768i
    public final InterfaceC0768i plus(InterfaceC0768i interfaceC0768i) {
        return T.b.F(this, interfaceC0768i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    public final Throwable q(Object obj) {
        CancellationException cancellationException;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        w0 w0Var = (w0) ((B0) obj);
        Object x3 = w0Var.x();
        CancellationException cancellationException2 = null;
        if (x3 instanceof p0) {
            cancellationException = ((p0) x3).b();
        } else if (x3 instanceof C0171v) {
            cancellationException = ((C0171v) x3).f1707a;
        } else if (!(x3 instanceof InterfaceC0147d0)) {
            cancellationException = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + x3).toString());
        }
        if (cancellationException instanceof CancellationException) {
            cancellationException2 = cancellationException;
        }
        if (cancellationException2 == null) {
            return new JobCancellationException("Parent job is ".concat(M(x3)), cancellationException, w0Var);
        }
        return cancellationException2;
    }

    public final Object r(p0 p0Var, Object obj) {
        C0171v c0171v;
        Throwable t3;
        Object obj2;
        Throwable th = null;
        if (obj instanceof C0171v) {
            c0171v = (C0171v) obj;
        } else {
            c0171v = null;
        }
        if (c0171v != null) {
            th = c0171v.f1707a;
        }
        synchronized (p0Var) {
            p0Var.d();
            ArrayList f4 = p0Var.f(th);
            t3 = t(p0Var, f4);
            if (t3 != null && f4.size() > 1) {
                Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(f4.size()));
                int size = f4.size();
                int i = 0;
                while (i < size) {
                    Object obj3 = f4.get(i);
                    i++;
                    Throwable th2 = (Throwable) obj3;
                    if (th2 != t3 && th2 != t3 && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                        E1.b.b(t3, th2);
                    }
                }
            }
        }
        if (t3 != null && t3 != th) {
            obj = new C0171v(t3, false);
        }
        if (t3 != null && (m(t3) || y(t3))) {
            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            C0171v.f1706b.compareAndSet((C0171v) obj, 0, 1);
        }
        I(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1709a;
        if (obj instanceof InterfaceC0147d0) {
            obj2 = new C0149e0((InterfaceC0147d0) obj);
        } else {
            obj2 = obj;
        }
        while (!atomicReferenceFieldUpdater.compareAndSet(this, p0Var, obj2) && atomicReferenceFieldUpdater.get(this) == p0Var) {
        }
        p(p0Var, obj);
        return obj;
    }

    public final Object s() {
        Object x3 = x();
        if (!(x3 instanceof InterfaceC0147d0)) {
            if (!(x3 instanceof C0171v)) {
                return G.x(x3);
            }
            throw ((C0171v) x3).f1707a;
        }
        throw new IllegalStateException("This job has not completed yet");
    }

    @Override // P2.InterfaceC0157i0
    public final boolean start() {
        int L3;
        do {
            L3 = L(x());
            if (L3 == 0) {
                return false;
            }
        } while (L3 != 1);
        return true;
    }

    public final Throwable t(p0 p0Var, ArrayList arrayList) {
        Object obj;
        Object obj2 = null;
        if (arrayList.isEmpty()) {
            if (!p0Var.d()) {
                return null;
            }
            return new JobCancellationException(n(), null, this);
        }
        int size = arrayList.size();
        int i = 0;
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                obj = arrayList.get(i3);
                i3++;
                if (!(((Throwable) obj) instanceof CancellationException)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Throwable th = (Throwable) obj;
        if (th != null) {
            return th;
        }
        Throwable th2 = (Throwable) arrayList.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            int size2 = arrayList.size();
            while (true) {
                if (i >= size2) {
                    break;
                }
                Object obj3 = arrayList.get(i);
                i++;
                Throwable th3 = (Throwable) obj3;
                if (th3 != th2 && (th3 instanceof TimeoutCancellationException)) {
                    obj2 = obj3;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj2;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(F() + '{' + M(x()) + '}');
        sb.append('@');
        sb.append(G.l(this));
        return sb.toString();
    }

    public boolean u() {
        return true;
    }

    public boolean v() {
        return this instanceof C0169t;
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [P2.y0, U2.j] */
    public final y0 w(InterfaceC0147d0 interfaceC0147d0) {
        y0 c4 = interfaceC0147d0.c();
        if (c4 == null) {
            if (interfaceC0147d0 instanceof T) {
                return new U2.j();
            }
            if (interfaceC0147d0 instanceof m0) {
                K((m0) interfaceC0147d0);
                return null;
            }
            throw new IllegalStateException(("State should have list: " + interfaceC0147d0).toString());
        }
        return c4;
    }

    public final Object x() {
        while (true) {
            Object obj = f1709a.get(this);
            if (!(obj instanceof U2.o)) {
                return obj;
            }
            ((U2.o) obj).a(this);
        }
    }

    public boolean y(Throwable th) {
        return false;
    }

    @Override // P2.InterfaceC0157i0
    public final Q invokeOnCompletion(boolean z3, boolean z4, F2.l lVar) {
        return B(z3, z4, new C0151f0(lVar));
    }

    public void J() {
    }

    public void I(Object obj) {
    }

    public void h(Object obj) {
    }

    public void z(CompletionHandlerException completionHandlerException) {
        throw completionHandlerException;
    }
}
