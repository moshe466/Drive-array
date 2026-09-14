package P2;

import F0.G1;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import s2.C0681f;
import t2.C0704f;
import w2.InterfaceC0763d;
import w2.InterfaceC0768i;
import x2.EnumC0779a;
import y2.InterfaceC0788d;

/* renamed from: P2.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0163m extends N implements InterfaceC0162l, InterfaceC0788d, K0 {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f1670f = AtomicIntegerFieldUpdater.newUpdater(C0163m.class, "_decisionAndIndex$volatile");

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f1671j = AtomicReferenceFieldUpdater.newUpdater(C0163m.class, Object.class, "_state$volatile");

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f1672k = AtomicReferenceFieldUpdater.newUpdater(C0163m.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC0763d f1673d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC0768i f1674e;

    public C0163m(int i, InterfaceC0763d interfaceC0763d) {
        super(i);
        this.f1673d = interfaceC0763d;
        this.f1674e = interfaceC0763d.getContext();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = C0142b.f1642a;
    }

    public static Object B(A0 a02, Object obj, int i, F2.l lVar) {
        InterfaceC0160k interfaceC0160k;
        if (obj instanceof C0171v) {
            return obj;
        }
        if (i != 1 && i != 2) {
            return obj;
        }
        if (lVar == null && !(a02 instanceof InterfaceC0160k)) {
            return obj;
        }
        if (a02 instanceof InterfaceC0160k) {
            interfaceC0160k = (InterfaceC0160k) a02;
        } else {
            interfaceC0160k = null;
        }
        return new C0170u(obj, interfaceC0160k, lVar, (Throwable) null, 16);
    }

    public static void v(A0 a02, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + a02 + ", already has " + obj).toString());
    }

    public final void A(A a2, Object obj) {
        U2.g gVar;
        A a4;
        int i;
        InterfaceC0763d interfaceC0763d = this.f1673d;
        if (interfaceC0763d instanceof U2.g) {
            gVar = (U2.g) interfaceC0763d;
        } else {
            gVar = null;
        }
        if (gVar != null) {
            a4 = gVar.f2350d;
        } else {
            a4 = null;
        }
        if (a4 == a2) {
            i = 4;
        } else {
            i = this.f1621c;
        }
        z(obj, i, null);
    }

    public final G1 C(Object obj, F2.l lVar) {
        G1 g12 = G.f1604a;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1671j;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof A0) {
                Object B3 = B((A0) obj2, obj, this.f1621c, lVar);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, B3)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                if (!u()) {
                    n();
                }
                return g12;
            }
            return null;
        }
    }

    @Override // P2.N
    public final void a(Object obj, CancellationException cancellationException) {
        CancellationException cancellationException2;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1671j;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof A0)) {
                if (!(obj2 instanceof C0171v)) {
                    if (obj2 instanceof C0170u) {
                        C0170u c0170u = (C0170u) obj2;
                        if (c0170u.f1704e == null) {
                            C0170u a2 = C0170u.a(c0170u, null, cancellationException, 15);
                            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, a2)) {
                                if (atomicReferenceFieldUpdater.get(this) != obj2) {
                                    cancellationException2 = cancellationException;
                                }
                            }
                            InterfaceC0160k interfaceC0160k = c0170u.f1701b;
                            if (interfaceC0160k != null) {
                                j(interfaceC0160k, cancellationException);
                            }
                            F2.l lVar = c0170u.f1702c;
                            if (lVar != null) {
                                k(lVar, cancellationException);
                                return;
                            }
                            return;
                        }
                        throw new IllegalStateException("Must be called at most once");
                    }
                    cancellationException2 = cancellationException;
                    C0170u c0170u2 = new C0170u(obj2, (InterfaceC0160k) null, (F2.l) null, cancellationException2, 14);
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, c0170u2)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj2) {
                            break;
                        }
                    }
                    return;
                    cancellationException = cancellationException2;
                } else {
                    return;
                }
            } else {
                throw new IllegalStateException("Not completed");
            }
        }
    }

    @Override // P2.K0
    public final void b(U2.s sVar, int i) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i3;
        do {
            atomicIntegerFieldUpdater = f1670f;
            i3 = atomicIntegerFieldUpdater.get(this);
            if ((i3 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i3, ((i3 >> 29) << 29) + i));
        t(sVar);
    }

    @Override // P2.N
    public final InterfaceC0763d c() {
        return this.f1673d;
    }

    @Override // P2.N
    public final Throwable d(Object obj) {
        Throwable d2 = super.d(obj);
        if (d2 != null) {
            return d2;
        }
        return null;
    }

    @Override // P2.InterfaceC0162l
    public final G1 e(Object obj, F2.l lVar) {
        return C(obj, lVar);
    }

    @Override // P2.InterfaceC0162l
    public final void f(Object obj) {
        o(this.f1621c);
    }

    @Override // P2.N
    public final Object g(Object obj) {
        if (obj instanceof C0170u) {
            return ((C0170u) obj).f1700a;
        }
        return obj;
    }

    @Override // y2.InterfaceC0788d
    public final InterfaceC0788d getCallerFrame() {
        InterfaceC0763d interfaceC0763d = this.f1673d;
        if (interfaceC0763d instanceof InterfaceC0788d) {
            return (InterfaceC0788d) interfaceC0763d;
        }
        return null;
    }

    @Override // w2.InterfaceC0763d
    public final InterfaceC0768i getContext() {
        return this.f1674e;
    }

    @Override // P2.N
    public final Object i() {
        return f1671j.get(this);
    }

    public final void j(InterfaceC0160k interfaceC0160k, Throwable th) {
        try {
            interfaceC0160k.a(th);
        } catch (Throwable th2) {
            G.n(new RuntimeException("Exception in invokeOnCancellation handler for " + this, th2), this.f1674e);
        }
    }

    public final void k(F2.l lVar, Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            G.n(new RuntimeException("Exception in resume onCancellation handler for " + this, th2), this.f1674e);
        }
    }

    public final void l(U2.s sVar, Throwable th) {
        InterfaceC0768i interfaceC0768i = this.f1674e;
        int i = f1670f.get(this) & 536870911;
        if (i != 536870911) {
            try {
                sVar.h(i, interfaceC0768i);
                return;
            } catch (Throwable th2) {
                G.n(new RuntimeException("Exception in invokeOnCancellation handler for " + this, th2), interfaceC0768i);
                return;
            }
        }
        throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
    }

    public final boolean m(Throwable th) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1671j;
            Object obj = atomicReferenceFieldUpdater.get(this);
            boolean z3 = false;
            if (!(obj instanceof A0)) {
                return false;
            }
            if ((obj instanceof InterfaceC0160k) || (obj instanceof U2.s)) {
                z3 = true;
            }
            C0164n c0164n = new C0164n(this, th, z3);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c0164n)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            A0 a02 = (A0) obj;
            if (a02 instanceof InterfaceC0160k) {
                j((InterfaceC0160k) obj, th);
            } else if (a02 instanceof U2.s) {
                l((U2.s) obj, th);
            }
            if (!u()) {
                n();
            }
            o(this.f1621c);
            return true;
        }
    }

    public final void n() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1672k;
        Q q3 = (Q) atomicReferenceFieldUpdater.get(this);
        if (q3 == null) {
            return;
        }
        q3.dispose();
        atomicReferenceFieldUpdater.set(this, z0.f1718a);
    }

    public final void o(int i) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i3;
        boolean z3;
        boolean z4;
        do {
            atomicIntegerFieldUpdater = f1670f;
            i3 = atomicIntegerFieldUpdater.get(this);
            int i4 = i3 >> 29;
            if (i4 != 0) {
                if (i4 == 1) {
                    boolean z5 = false;
                    if (i == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    InterfaceC0763d interfaceC0763d = this.f1673d;
                    if (!z3 && (interfaceC0763d instanceof U2.g)) {
                        if (i != 1 && i != 2) {
                            z4 = false;
                        } else {
                            z4 = true;
                        }
                        int i5 = this.f1621c;
                        if (i5 == 1 || i5 == 2) {
                            z5 = true;
                        }
                        if (z4 == z5) {
                            A a2 = ((U2.g) interfaceC0763d).f2350d;
                            InterfaceC0768i context = ((U2.g) interfaceC0763d).f2351e.getContext();
                            if (a2.e()) {
                                a2.d(context, this);
                                return;
                            }
                            Z a4 = F0.a();
                            if (a4.f1638c >= 4294967296L) {
                                C0704f c0704f = a4.f1640e;
                                if (c0704f == null) {
                                    c0704f = new C0704f();
                                    a4.f1640e = c0704f;
                                }
                                c0704f.addLast(this);
                                return;
                            }
                            a4.h(true);
                            try {
                                G.u(this, interfaceC0763d, true);
                                do {
                                } while (a4.j());
                            } finally {
                                try {
                                    return;
                                } finally {
                                }
                            }
                            return;
                        }
                    }
                    G.u(this, interfaceC0763d, z3);
                    return;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i3, 1073741824 + (536870911 & i3)));
    }

    public Throwable p(w0 w0Var) {
        return w0Var.getCancellationException();
    }

    public final Object q() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        InterfaceC0157i0 interfaceC0157i0;
        boolean u3 = u();
        do {
            atomicIntegerFieldUpdater = f1670f;
            i = atomicIntegerFieldUpdater.get(this);
            int i3 = i >> 29;
            if (i3 != 0) {
                if (i3 == 2) {
                    if (u3) {
                        x();
                    }
                    Object obj = f1671j.get(this);
                    if (!(obj instanceof C0171v)) {
                        int i4 = this.f1621c;
                        if ((i4 == 1 || i4 == 2) && (interfaceC0157i0 = (InterfaceC0157i0) this.f1674e.get(B.f1595b)) != null && !interfaceC0157i0.isActive()) {
                            CancellationException cancellationException = interfaceC0157i0.getCancellationException();
                            a(obj, cancellationException);
                            throw cancellationException;
                        }
                        return g(obj);
                    }
                    throw ((C0171v) obj).f1707a;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 536870912 + (536870911 & i)));
        if (((Q) f1672k.get(this)) == null) {
            s();
        }
        if (u3) {
            x();
        }
        return EnumC0779a.f6740a;
    }

    public final void r() {
        Q s3 = s();
        if (s3 != null && !(f1671j.get(this) instanceof A0)) {
            s3.dispose();
            f1672k.set(this, z0.f1718a);
        }
    }

    @Override // w2.InterfaceC0763d
    public final void resumeWith(Object obj) {
        Throwable a2 = C0681f.a(obj);
        if (a2 != null) {
            obj = new C0171v(a2, false);
        }
        z(obj, this.f1621c, null);
    }

    public final Q s() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        InterfaceC0157i0 interfaceC0157i0 = (InterfaceC0157i0) this.f1674e.get(B.f1595b);
        if (interfaceC0157i0 == null) {
            return null;
        }
        Q o2 = G.o(interfaceC0157i0, true, new C0165o(this), 2);
        do {
            atomicReferenceFieldUpdater = f1672k;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, o2)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return o2;
    }

    public final void t(A0 a02) {
        boolean z3;
        boolean z4;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1671j;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof C0142b) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, a02)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            boolean z5 = true;
            if (obj instanceof InterfaceC0160k) {
                z3 = true;
            } else {
                z3 = obj instanceof U2.s;
            }
            Throwable th = null;
            if (!z3) {
                if (obj instanceof C0171v) {
                    C0171v c0171v = (C0171v) obj;
                    c0171v.getClass();
                    if (C0171v.f1706b.compareAndSet(c0171v, 0, 1)) {
                        if (obj instanceof C0164n) {
                            if (obj == null) {
                                c0171v = null;
                            }
                            if (c0171v != null) {
                                th = c0171v.f1707a;
                            }
                            if (a02 instanceof InterfaceC0160k) {
                                j((InterfaceC0160k) a02, th);
                                return;
                            } else {
                                l((U2.s) a02, th);
                                return;
                            }
                        }
                        return;
                    }
                    v(a02, obj);
                    throw null;
                }
                if (obj instanceof C0170u) {
                    C0170u c0170u = (C0170u) obj;
                    if (c0170u.f1701b == null) {
                        if (!(a02 instanceof U2.s)) {
                            InterfaceC0160k interfaceC0160k = (InterfaceC0160k) a02;
                            Throwable th2 = c0170u.f1704e;
                            if (th2 != null) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (z4) {
                                j(interfaceC0160k, th2);
                                return;
                            }
                            C0170u a2 = C0170u.a(c0170u, interfaceC0160k, null, 29);
                            while (true) {
                                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, a2)) {
                                    break;
                                } else if (atomicReferenceFieldUpdater.get(this) != obj) {
                                    z5 = false;
                                    break;
                                }
                            }
                            if (z5) {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        v(a02, obj);
                        throw null;
                    }
                } else if (!(a02 instanceof U2.s)) {
                    C0170u c0170u2 = new C0170u(obj, (InterfaceC0160k) a02, (F2.l) null, (Throwable) null, 28);
                    while (true) {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, obj, c0170u2)) {
                            break;
                        } else if (atomicReferenceFieldUpdater.get(this) != obj) {
                            z5 = false;
                            break;
                        }
                    }
                    if (z5) {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                v(a02, obj);
                throw null;
            }
        }
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(w());
        sb.append('(');
        sb.append(G.w(this.f1673d));
        sb.append("){");
        Object obj = f1671j.get(this);
        if (obj instanceof A0) {
            str = "Active";
        } else if (obj instanceof C0164n) {
            str = "Cancelled";
        } else {
            str = "Completed";
        }
        sb.append(str);
        sb.append("}@");
        sb.append(G.l(this));
        return sb.toString();
    }

    public final boolean u() {
        if (this.f1621c == 2) {
            InterfaceC0763d interfaceC0763d = this.f1673d;
            kotlin.jvm.internal.j.c(interfaceC0763d, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (U2.g.f2349k.get((U2.g) interfaceC0763d) != null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public String w() {
        return "CancellableContinuation";
    }

    public final void x() {
        U2.g gVar;
        InterfaceC0763d interfaceC0763d = this.f1673d;
        Throwable th = null;
        if (interfaceC0763d instanceof U2.g) {
            gVar = (U2.g) interfaceC0763d;
        } else {
            gVar = null;
        }
        if (gVar != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = U2.g.f2349k;
            loop0: while (true) {
                Object obj = atomicReferenceFieldUpdater.get(gVar);
                G1 g12 = U2.a.f2340d;
                if (obj != g12) {
                    if (!(obj instanceof Throwable)) {
                        throw new IllegalStateException(("Inconsistent state " + obj).toString());
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(gVar, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(gVar) != obj) {
                            throw new IllegalArgumentException("Failed requirement.");
                        }
                    }
                    th = (Throwable) obj;
                }
                while (!atomicReferenceFieldUpdater.compareAndSet(gVar, g12, this)) {
                    if (atomicReferenceFieldUpdater.get(gVar) != g12) {
                        break;
                    }
                }
            }
            if (th != null) {
                n();
                m(th);
            }
        }
    }

    public final void y(Object obj, F2.l lVar) {
        z(obj, this.f1621c, lVar);
    }

    public final void z(Object obj, int i, F2.l lVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1671j;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof A0) {
                Object B3 = B((A0) obj2, obj, i, lVar);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, B3)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                if (!u()) {
                    n();
                }
                o(i);
                return;
            }
            if (obj2 instanceof C0164n) {
                C0164n c0164n = (C0164n) obj2;
                c0164n.getClass();
                if (C0164n.f1676c.compareAndSet(c0164n, 0, 1)) {
                    if (lVar != null) {
                        k(lVar, c0164n.f1707a);
                        return;
                    }
                    return;
                }
            }
            throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
        }
    }
}
