package nb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.o;
import nb.a1;
import p8.f;

/* loaded from: classes.dex */
public class g1 implements a1, l, m1 {

    /* renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f12376f = AtomicReferenceFieldUpdater.newUpdater(g1.class, Object.class, "_state");
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _state;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a extends f1 {

        /* renamed from: j, reason: collision with root package name */
        private final g1 f12377j;

        /* renamed from: k, reason: collision with root package name */
        private final b f12378k;

        /* renamed from: l, reason: collision with root package name */
        private final k f12379l;

        /* renamed from: m, reason: collision with root package name */
        private final Object f12380m;

        public a(g1 g1Var, b bVar, k kVar, Object obj) {
            this.f12377j = g1Var;
            this.f12378k = bVar;
            this.f12379l = kVar;
            this.f12380m = obj;
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ l8.w h(Throwable th) {
            w(th);
            return l8.w.f11824a;
        }

        @Override // nb.p
        public void w(Throwable th) {
            this.f12377j.u(this.f12378k, this.f12379l, this.f12380m);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements w0 {
        private volatile /* synthetic */ Object _exceptionsHolder = null;
        private volatile /* synthetic */ int _isCompleting;
        private volatile /* synthetic */ Object _rootCause;

        /* renamed from: f, reason: collision with root package name */
        private final j1 f12381f;

        public b(j1 j1Var, boolean z10, Throwable th) {
            this.f12381f = j1Var;
            this._isCompleting = z10 ? 1 : 0;
            this._rootCause = th;
        }

        private final ArrayList<Throwable> b() {
            return new ArrayList<>(4);
        }

        private final Object c() {
            return this._exceptionsHolder;
        }

        private final void l(Object obj) {
            this._exceptionsHolder = obj;
        }

        public final void a(Throwable th) {
            Throwable e10 = e();
            if (e10 == null) {
                m(th);
                return;
            }
            if (th == e10) {
                return;
            }
            Object c10 = c();
            if (c10 == null) {
                l(th);
                return;
            }
            if (!(c10 instanceof Throwable)) {
                if (!(c10 instanceof ArrayList)) {
                    throw new IllegalStateException(y8.k.j("State is ", c10).toString());
                }
                ((ArrayList) c10).add(th);
            } else {
                if (th == c10) {
                    return;
                }
                ArrayList<Throwable> b10 = b();
                b10.add(c10);
                b10.add(th);
                l(b10);
            }
        }

        @Override // nb.w0
        public boolean d() {
            return e() == null;
        }

        public final Throwable e() {
            return (Throwable) this._rootCause;
        }

        public final boolean f() {
            return e() != null;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
        public final boolean g() {
            return this._isCompleting;
        }

        public final boolean h() {
            kotlinx.coroutines.internal.b0 b0Var;
            Object c10 = c();
            b0Var = h1.f12393e;
            return c10 == b0Var;
        }

        @Override // nb.w0
        public j1 i() {
            return this.f12381f;
        }

        public final List<Throwable> j(Throwable th) {
            ArrayList<Throwable> arrayList;
            kotlinx.coroutines.internal.b0 b0Var;
            Object c10 = c();
            if (c10 == null) {
                arrayList = b();
            } else if (c10 instanceof Throwable) {
                ArrayList<Throwable> b10 = b();
                b10.add(c10);
                arrayList = b10;
            } else {
                if (!(c10 instanceof ArrayList)) {
                    throw new IllegalStateException(y8.k.j("State is ", c10).toString());
                }
                arrayList = (ArrayList) c10;
            }
            Throwable e10 = e();
            if (e10 != null) {
                arrayList.add(0, e10);
            }
            if (th != null && !y8.k.a(th, e10)) {
                arrayList.add(th);
            }
            b0Var = h1.f12393e;
            l(b0Var);
            return arrayList;
        }

        public final void k(boolean z10) {
            this._isCompleting = z10 ? 1 : 0;
        }

        public final void m(Throwable th) {
            this._rootCause = th;
        }

        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + g() + ", rootCause=" + e() + ", exceptions=" + c() + ", list=" + i() + ']';
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends o.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ g1 f12382d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f12383e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(kotlinx.coroutines.internal.o oVar, g1 g1Var, Object obj) {
            super(oVar);
            this.f12382d = g1Var;
            this.f12383e = obj;
        }

        @Override // kotlinx.coroutines.internal.c
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object g(kotlinx.coroutines.internal.o oVar) {
            if (this.f12382d.G() == this.f12383e) {
                return null;
            }
            return kotlinx.coroutines.internal.n.a();
        }
    }

    private final Throwable A(b bVar, List<? extends Throwable> list) {
        Object obj = null;
        if (list.isEmpty()) {
            if (bVar.f()) {
                return new b1(r(), null, this);
            }
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                obj = next;
                break;
            }
        }
        Throwable th = (Throwable) obj;
        return th != null ? th : list.get(0);
    }

    private final j1 E(w0 w0Var) {
        j1 i10 = w0Var.i();
        if (i10 != null) {
            return i10;
        }
        if (w0Var instanceof o0) {
            return new j1();
        }
        if (!(w0Var instanceof f1)) {
            throw new IllegalStateException(y8.k.j("State should have list: ", w0Var).toString());
        }
        Y((f1) w0Var);
        return null;
    }

    private final Object L(Object obj) {
        kotlinx.coroutines.internal.b0 b0Var;
        kotlinx.coroutines.internal.b0 b0Var2;
        kotlinx.coroutines.internal.b0 b0Var3;
        kotlinx.coroutines.internal.b0 b0Var4;
        kotlinx.coroutines.internal.b0 b0Var5;
        kotlinx.coroutines.internal.b0 b0Var6;
        Throwable th = null;
        while (true) {
            Object G = G();
            if (G instanceof b) {
                synchronized (G) {
                    if (((b) G).h()) {
                        b0Var2 = h1.f12392d;
                        return b0Var2;
                    }
                    boolean f10 = ((b) G).f();
                    if (obj != null || !f10) {
                        if (th == null) {
                            th = w(obj);
                        }
                        ((b) G).a(th);
                    }
                    Throwable e10 = f10 ^ true ? ((b) G).e() : null;
                    if (e10 != null) {
                        T(((b) G).i(), e10);
                    }
                    b0Var = h1.f12389a;
                    return b0Var;
                }
            }
            if (!(G instanceof w0)) {
                b0Var3 = h1.f12392d;
                return b0Var3;
            }
            if (th == null) {
                th = w(obj);
            }
            w0 w0Var = (w0) G;
            if (!w0Var.d()) {
                Object h02 = h0(G, new n(th, false, 2, null));
                b0Var5 = h1.f12389a;
                if (h02 == b0Var5) {
                    throw new IllegalStateException(y8.k.j("Cannot happen in ", G).toString());
                }
                b0Var6 = h1.f12391c;
                if (h02 != b0Var6) {
                    return h02;
                }
            } else if (g0(w0Var, th)) {
                b0Var4 = h1.f12389a;
                return b0Var4;
            }
        }
    }

    private final f1 Q(x8.l<? super Throwable, l8.w> lVar, boolean z10) {
        if (z10) {
            r0 = lVar instanceof c1 ? (c1) lVar : null;
            if (r0 == null) {
                r0 = new y0(lVar);
            }
        } else {
            f1 f1Var = lVar instanceof f1 ? (f1) lVar : null;
            if (f1Var != null) {
                if (d0.a() && !(!(f1Var instanceof c1))) {
                    throw new AssertionError();
                }
                r0 = f1Var;
            }
            if (r0 == null) {
                r0 = new z0(lVar);
            }
        }
        r0.y(this);
        return r0;
    }

    private final k S(kotlinx.coroutines.internal.o oVar) {
        while (oVar.q()) {
            oVar = oVar.p();
        }
        while (true) {
            oVar = oVar.o();
            if (!oVar.q()) {
                if (oVar instanceof k) {
                    return (k) oVar;
                }
                if (oVar instanceof j1) {
                    return null;
                }
            }
        }
    }

    private final void T(j1 j1Var, Throwable th) {
        q qVar;
        V(th);
        q qVar2 = null;
        for (kotlinx.coroutines.internal.o oVar = (kotlinx.coroutines.internal.o) j1Var.m(); !y8.k.a(oVar, j1Var); oVar = oVar.o()) {
            if (oVar instanceof c1) {
                f1 f1Var = (f1) oVar;
                try {
                    f1Var.w(th);
                } catch (Throwable th2) {
                    if (qVar2 == null) {
                        qVar = null;
                    } else {
                        l8.b.a(qVar2, th2);
                        qVar = qVar2;
                    }
                    if (qVar == null) {
                        qVar2 = new q("Exception in completion handler " + f1Var + " for " + this, th2);
                    }
                }
            }
        }
        if (qVar2 != null) {
            J(qVar2);
        }
        q(th);
    }

    private final void U(j1 j1Var, Throwable th) {
        q qVar;
        q qVar2 = null;
        for (kotlinx.coroutines.internal.o oVar = (kotlinx.coroutines.internal.o) j1Var.m(); !y8.k.a(oVar, j1Var); oVar = oVar.o()) {
            if (oVar instanceof f1) {
                f1 f1Var = (f1) oVar;
                try {
                    f1Var.w(th);
                } catch (Throwable th2) {
                    if (qVar2 == null) {
                        qVar = null;
                    } else {
                        l8.b.a(qVar2, th2);
                        qVar = qVar2;
                    }
                    if (qVar == null) {
                        qVar2 = new q("Exception in completion handler " + f1Var + " for " + this, th2);
                    }
                }
            }
        }
        if (qVar2 == null) {
            return;
        }
        J(qVar2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [nb.v0] */
    private final void X(o0 o0Var) {
        j1 j1Var = new j1();
        if (!o0Var.d()) {
            j1Var = new v0(j1Var);
        }
        f12376f.compareAndSet(this, o0Var, j1Var);
    }

    private final void Y(f1 f1Var) {
        f1Var.c(new j1());
        f12376f.compareAndSet(this, f1Var, f1Var.o());
    }

    private final String b0(Object obj) {
        if (!(obj instanceof b)) {
            return obj instanceof w0 ? ((w0) obj).d() ? "Active" : "New" : obj instanceof n ? "Cancelled" : "Completed";
        }
        b bVar = (b) obj;
        return bVar.f() ? "Cancelling" : bVar.g() ? "Completing" : "Active";
    }

    public static /* synthetic */ CancellationException d0(g1 g1Var, Throwable th, String str, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i10 & 1) != 0) {
            str = null;
        }
        return g1Var.c0(th, str);
    }

    private final boolean f0(w0 w0Var, Object obj) {
        if (d0.a()) {
            if (!((w0Var instanceof o0) || (w0Var instanceof f1))) {
                throw new AssertionError();
            }
        }
        if (d0.a() && !(!(obj instanceof n))) {
            throw new AssertionError();
        }
        if (!f12376f.compareAndSet(this, w0Var, h1.f(obj))) {
            return false;
        }
        V(null);
        W(obj);
        t(w0Var, obj);
        return true;
    }

    private final boolean g0(w0 w0Var, Throwable th) {
        if (d0.a() && !(!(w0Var instanceof b))) {
            throw new AssertionError();
        }
        if (d0.a() && !w0Var.d()) {
            throw new AssertionError();
        }
        j1 E = E(w0Var);
        if (E == null) {
            return false;
        }
        if (!f12376f.compareAndSet(this, w0Var, new b(E, false, th))) {
            return false;
        }
        T(E, th);
        return true;
    }

    private final Object h0(Object obj, Object obj2) {
        kotlinx.coroutines.internal.b0 b0Var;
        kotlinx.coroutines.internal.b0 b0Var2;
        if (!(obj instanceof w0)) {
            b0Var2 = h1.f12389a;
            return b0Var2;
        }
        if ((!(obj instanceof o0) && !(obj instanceof f1)) || (obj instanceof k) || (obj2 instanceof n)) {
            return i0((w0) obj, obj2);
        }
        if (f0((w0) obj, obj2)) {
            return obj2;
        }
        b0Var = h1.f12391c;
        return b0Var;
    }

    private final Object i0(w0 w0Var, Object obj) {
        kotlinx.coroutines.internal.b0 b0Var;
        kotlinx.coroutines.internal.b0 b0Var2;
        kotlinx.coroutines.internal.b0 b0Var3;
        j1 E = E(w0Var);
        if (E == null) {
            b0Var3 = h1.f12391c;
            return b0Var3;
        }
        b bVar = w0Var instanceof b ? (b) w0Var : null;
        if (bVar == null) {
            bVar = new b(E, false, null);
        }
        synchronized (bVar) {
            if (bVar.g()) {
                b0Var2 = h1.f12389a;
                return b0Var2;
            }
            bVar.k(true);
            if (bVar != w0Var && !f12376f.compareAndSet(this, w0Var, bVar)) {
                b0Var = h1.f12391c;
                return b0Var;
            }
            if (d0.a() && !(!bVar.h())) {
                throw new AssertionError();
            }
            boolean f10 = bVar.f();
            n nVar = obj instanceof n ? (n) obj : null;
            if (nVar != null) {
                bVar.a(nVar.f12408a);
            }
            Throwable e10 = true ^ f10 ? bVar.e() : null;
            l8.w wVar = l8.w.f11824a;
            if (e10 != null) {
                T(E, e10);
            }
            k y10 = y(w0Var);
            return (y10 == null || !j0(bVar, y10, obj)) ? x(bVar, obj) : h1.f12390b;
        }
    }

    private final boolean j0(b bVar, k kVar, Object obj) {
        while (a1.a.c(kVar.f12398j, false, false, new a(this, bVar, kVar, obj), 1, null) == k1.f12400f) {
            kVar = S(kVar);
            if (kVar == null) {
                return false;
            }
        }
        return true;
    }

    private final boolean k(Object obj, j1 j1Var, f1 f1Var) {
        int v10;
        c cVar = new c(f1Var, this, obj);
        do {
            v10 = j1Var.p().v(f1Var, j1Var, cVar);
            if (v10 == 1) {
                return true;
            }
        } while (v10 != 2);
        return false;
    }

    private final void l(Throwable th, List<? extends Throwable> list) {
        if (list.size() <= 1) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        Throwable l10 = !d0.c() ? th : kotlinx.coroutines.internal.a0.l(th);
        for (Throwable th2 : list) {
            if (d0.c()) {
                th2 = kotlinx.coroutines.internal.a0.l(th2);
            }
            if (th2 != th && th2 != l10 && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                l8.b.a(th, th2);
            }
        }
    }

    private final Object p(Object obj) {
        kotlinx.coroutines.internal.b0 b0Var;
        Object h02;
        kotlinx.coroutines.internal.b0 b0Var2;
        do {
            Object G = G();
            if (!(G instanceof w0) || ((G instanceof b) && ((b) G).g())) {
                b0Var = h1.f12389a;
                return b0Var;
            }
            h02 = h0(G, new n(w(obj), false, 2, null));
            b0Var2 = h1.f12391c;
        } while (h02 == b0Var2);
        return h02;
    }

    private final boolean q(Throwable th) {
        if (K()) {
            return true;
        }
        boolean z10 = th instanceof CancellationException;
        j F = F();
        return (F == null || F == k1.f12400f) ? z10 : F.n(th) || z10;
    }

    private final void t(w0 w0Var, Object obj) {
        j F = F();
        if (F != null) {
            F.dispose();
            a0(k1.f12400f);
        }
        n nVar = obj instanceof n ? (n) obj : null;
        Throwable th = nVar != null ? nVar.f12408a : null;
        if (!(w0Var instanceof f1)) {
            j1 i10 = w0Var.i();
            if (i10 == null) {
                return;
            }
            U(i10, th);
            return;
        }
        try {
            ((f1) w0Var).w(th);
        } catch (Throwable th2) {
            J(new q("Exception in completion handler " + w0Var + " for " + this, th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(b bVar, k kVar, Object obj) {
        if (d0.a()) {
            if (!(G() == bVar)) {
                throw new AssertionError();
            }
        }
        k S = S(kVar);
        if (S == null || !j0(bVar, S, obj)) {
            m(x(bVar, obj));
        }
    }

    private final Throwable w(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new b1(r(), null, this) : th;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((m1) obj).D();
    }

    private final Object x(b bVar, Object obj) {
        boolean f10;
        Throwable A;
        boolean z10 = true;
        if (d0.a()) {
            if (!(G() == bVar)) {
                throw new AssertionError();
            }
        }
        if (d0.a() && !(!bVar.h())) {
            throw new AssertionError();
        }
        if (d0.a() && !bVar.g()) {
            throw new AssertionError();
        }
        n nVar = obj instanceof n ? (n) obj : null;
        Throwable th = nVar == null ? null : nVar.f12408a;
        synchronized (bVar) {
            f10 = bVar.f();
            List<Throwable> j10 = bVar.j(th);
            A = A(bVar, j10);
            if (A != null) {
                l(A, j10);
            }
        }
        if (A != null && A != th) {
            obj = new n(A, false, 2, null);
        }
        if (A != null) {
            if (!q(A) && !I(A)) {
                z10 = false;
            }
            if (z10) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                ((n) obj).b();
            }
        }
        if (!f10) {
            V(A);
        }
        W(obj);
        boolean compareAndSet = f12376f.compareAndSet(this, bVar, h1.f(obj));
        if (d0.a() && !compareAndSet) {
            throw new AssertionError();
        }
        t(bVar, obj);
        return obj;
    }

    private final k y(w0 w0Var) {
        k kVar = w0Var instanceof k ? (k) w0Var : null;
        if (kVar != null) {
            return kVar;
        }
        j1 i10 = w0Var.i();
        if (i10 == null) {
            return null;
        }
        return S(i10);
    }

    private final Throwable z(Object obj) {
        n nVar = obj instanceof n ? (n) obj : null;
        if (nVar == null) {
            return null;
        }
        return nVar.f12408a;
    }

    public boolean B() {
        return true;
    }

    public boolean C() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    @Override // nb.m1
    public CancellationException D() {
        CancellationException cancellationException;
        Object G = G();
        if (G instanceof b) {
            cancellationException = ((b) G).e();
        } else if (G instanceof n) {
            cancellationException = ((n) G).f12408a;
        } else {
            if (G instanceof w0) {
                throw new IllegalStateException(y8.k.j("Cannot be cancelling child in this state: ", G).toString());
            }
            cancellationException = null;
        }
        CancellationException cancellationException2 = cancellationException instanceof CancellationException ? cancellationException : null;
        return cancellationException2 == null ? new b1(y8.k.j("Parent job is ", b0(G)), cancellationException, this) : cancellationException2;
    }

    public final j F() {
        return (j) this._parentHandle;
    }

    public final Object G() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof kotlinx.coroutines.internal.w)) {
                return obj;
            }
            ((kotlinx.coroutines.internal.w) obj).c(this);
        }
    }

    @Override // nb.a1
    public final CancellationException H() {
        Object G = G();
        if (!(G instanceof b)) {
            if (G instanceof w0) {
                throw new IllegalStateException(y8.k.j("Job is still new or active: ", this).toString());
            }
            return G instanceof n ? d0(this, ((n) G).f12408a, null, 1, null) : new b1(y8.k.j(e0.a(this), " has completed normally"), null, this);
        }
        Throwable e10 = ((b) G).e();
        CancellationException c02 = e10 != null ? c0(e10, y8.k.j(e0.a(this), " is cancelling")) : null;
        if (c02 != null) {
            return c02;
        }
        throw new IllegalStateException(y8.k.j("Job is still new or active: ", this).toString());
    }

    protected boolean I(Throwable th) {
        return false;
    }

    public void J(Throwable th) {
        throw th;
    }

    protected boolean K() {
        return false;
    }

    @Override // nb.a1
    public void N(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new b1(r(), null, this);
        }
        o(cancellationException);
    }

    public final Object P(Object obj) {
        Object h02;
        kotlinx.coroutines.internal.b0 b0Var;
        kotlinx.coroutines.internal.b0 b0Var2;
        do {
            h02 = h0(G(), obj);
            b0Var = h1.f12389a;
            if (h02 == b0Var) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, z(obj));
            }
            b0Var2 = h1.f12391c;
        } while (h02 == b0Var2);
        return h02;
    }

    public String R() {
        return e0.a(this);
    }

    protected void V(Throwable th) {
    }

    protected void W(Object obj) {
    }

    public final void Z(f1 f1Var) {
        Object G;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        o0 o0Var;
        do {
            G = G();
            if (!(G instanceof f1)) {
                if (!(G instanceof w0) || ((w0) G).i() == null) {
                    return;
                }
                f1Var.r();
                return;
            }
            if (G != f1Var) {
                return;
            }
            atomicReferenceFieldUpdater = f12376f;
            o0Var = h1.f12394f;
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, G, o0Var));
    }

    public final void a0(j jVar) {
        this._parentHandle = jVar;
    }

    protected final CancellationException c0(Throwable th, String str) {
        CancellationException cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (cancellationException == null) {
            if (str == null) {
                str = r();
            }
            cancellationException = new b1(str, th, this);
        }
        return cancellationException;
    }

    @Override // nb.a1
    public boolean d() {
        Object G = G();
        return (G instanceof w0) && ((w0) G).d();
    }

    public final String e0() {
        return R() + '{' + b0(G()) + '}';
    }

    @Override // p8.f
    public <R> R fold(R r10, x8.p<? super R, ? super f.b, ? extends R> pVar) {
        return (R) a1.a.a(this, r10, pVar);
    }

    @Override // nb.l
    public final void g(m1 m1Var) {
        n(m1Var);
    }

    @Override // p8.f.b, p8.f
    public <E extends f.b> E get(f.c<E> cVar) {
        return (E) a1.a.b(this, cVar);
    }

    @Override // p8.f.b
    public final f.c<?> getKey() {
        return a1.f12361d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(Object obj) {
    }

    @Override // p8.f
    public p8.f minusKey(f.c<?> cVar) {
        return a1.a.d(this, cVar);
    }

    public final boolean n(Object obj) {
        Object obj2;
        kotlinx.coroutines.internal.b0 b0Var;
        kotlinx.coroutines.internal.b0 b0Var2;
        kotlinx.coroutines.internal.b0 b0Var3;
        obj2 = h1.f12389a;
        if (C() && (obj2 = p(obj)) == h1.f12390b) {
            return true;
        }
        b0Var = h1.f12389a;
        if (obj2 == b0Var) {
            obj2 = L(obj);
        }
        b0Var2 = h1.f12389a;
        if (obj2 == b0Var2 || obj2 == h1.f12390b) {
            return true;
        }
        b0Var3 = h1.f12392d;
        if (obj2 == b0Var3) {
            return false;
        }
        m(obj2);
        return true;
    }

    public void o(Throwable th) {
        n(th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String r() {
        return "Job was cancelled";
    }

    public boolean s(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return n(th) && B();
    }

    public String toString() {
        return e0() + '@' + e0.b(this);
    }

    @Override // nb.a1
    public final n0 v(boolean z10, boolean z11, x8.l<? super Throwable, l8.w> lVar) {
        f1 Q = Q(lVar, z10);
        while (true) {
            Object G = G();
            if (G instanceof o0) {
                o0 o0Var = (o0) G;
                if (!o0Var.d()) {
                    X(o0Var);
                } else if (f12376f.compareAndSet(this, G, Q)) {
                    return Q;
                }
            } else {
                if (!(G instanceof w0)) {
                    if (z11) {
                        n nVar = G instanceof n ? (n) G : null;
                        lVar.h(nVar != null ? nVar.f12408a : null);
                    }
                    return k1.f12400f;
                }
                j1 i10 = ((w0) G).i();
                if (i10 == null) {
                    Objects.requireNonNull(G, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    Y((f1) G);
                } else {
                    n0 n0Var = k1.f12400f;
                    if (z10 && (G instanceof b)) {
                        synchronized (G) {
                            r3 = ((b) G).e();
                            if (r3 == null || ((lVar instanceof k) && !((b) G).g())) {
                                if (k(G, i10, Q)) {
                                    if (r3 == null) {
                                        return Q;
                                    }
                                    n0Var = Q;
                                }
                            }
                            l8.w wVar = l8.w.f11824a;
                        }
                    }
                    if (r3 != null) {
                        if (z11) {
                            lVar.h(r3);
                        }
                        return n0Var;
                    }
                    if (k(G, i10, Q)) {
                        return Q;
                    }
                }
            }
        }
    }
}
