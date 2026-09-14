package nb;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public class h<T> extends k0<T> implements g<T>, r8.d {

    /* renamed from: l, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f12384l = AtomicIntegerFieldUpdater.newUpdater(h.class, "_decision");

    /* renamed from: m, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f12385m = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "_state");
    private volatile /* synthetic */ int _decision;
    private volatile /* synthetic */ Object _state;

    /* renamed from: i, reason: collision with root package name */
    private final p8.d<T> f12386i;

    /* renamed from: j, reason: collision with root package name */
    private final p8.f f12387j;

    /* renamed from: k, reason: collision with root package name */
    private n0 f12388k;

    private final Void k(Object obj) {
        throw new IllegalStateException(y8.k.j("Already resumed, but proposed with update ", obj).toString());
    }

    private final void o() {
        if (s()) {
            return;
        }
        n();
    }

    private final void p(int i10) {
        if (x()) {
            return;
        }
        l0.a(this, i10);
    }

    private final String r() {
        Object q10 = q();
        return q10 instanceof l1 ? "Active" : q10 instanceof i ? "Cancelled" : "Completed";
    }

    private final boolean s() {
        return l0.c(this.f12399h) && ((kotlinx.coroutines.internal.f) this.f12386i).m();
    }

    private final void u(Object obj, int i10, x8.l<? super Throwable, l8.w> lVar) {
        Object obj2;
        do {
            obj2 = this._state;
            if (!(obj2 instanceof l1)) {
                if (obj2 instanceof i) {
                    i iVar = (i) obj2;
                    if (iVar.c()) {
                        if (lVar == null) {
                            return;
                        }
                        m(lVar, iVar.f12408a);
                        return;
                    }
                }
                k(obj);
                throw new l8.e();
            }
        } while (!f12385m.compareAndSet(this, obj2, w((l1) obj2, obj, i10, lVar, null)));
        o();
        p(i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void v(h hVar, Object obj, int i10, x8.l lVar, int i11, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i11 & 4) != 0) {
            lVar = null;
        }
        hVar.u(obj, i10, lVar);
    }

    private final Object w(l1 l1Var, Object obj, int i10, x8.l<? super Throwable, l8.w> lVar, Object obj2) {
        if (obj instanceof n) {
            if (d0.a()) {
                if (!(obj2 == null)) {
                    throw new AssertionError();
                }
            }
            if (!d0.a()) {
                return obj;
            }
            if (lVar == null) {
                return obj;
            }
            throw new AssertionError();
        }
        if (!l0.b(i10) && obj2 == null) {
            return obj;
        }
        if (lVar == null && !(l1Var instanceof e) && obj2 == null) {
            return obj;
        }
        return new m(obj, l1Var instanceof e ? (e) l1Var : null, lVar, obj2, null, 16, null);
    }

    private final boolean x() {
        do {
            int i10 = this._decision;
            if (i10 != 0) {
                if (i10 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f12384l.compareAndSet(this, 0, 2));
        return true;
    }

    @Override // r8.d
    public r8.d a() {
        p8.d<T> dVar = this.f12386i;
        if (dVar instanceof r8.d) {
            return (r8.d) dVar;
        }
        return null;
    }

    @Override // p8.d
    public void b(Object obj) {
        v(this, r.b(obj, this), this.f12399h, null, 4, null);
    }

    @Override // p8.d
    public p8.f c() {
        return this.f12387j;
    }

    @Override // nb.k0
    public void d(Object obj, Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof l1) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof n) {
                return;
            }
            if (obj2 instanceof m) {
                m mVar = (m) obj2;
                if (!(!mVar.c())) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (f12385m.compareAndSet(this, obj2, m.b(mVar, null, null, null, null, th, 15, null))) {
                    mVar.d(this, th);
                    return;
                }
            } else if (f12385m.compareAndSet(this, obj2, new m(obj2, null, null, null, th, 14, null))) {
                return;
            }
        }
    }

    @Override // r8.d
    public StackTraceElement e() {
        return null;
    }

    @Override // nb.k0
    public final p8.d<T> f() {
        return this.f12386i;
    }

    @Override // nb.k0
    public Throwable g(Object obj) {
        Throwable j10;
        Throwable g10 = super.g(obj);
        if (g10 == null) {
            return null;
        }
        p8.d<T> f10 = f();
        if (!d0.c() || !(f10 instanceof r8.d)) {
            return g10;
        }
        j10 = kotlinx.coroutines.internal.a0.j(g10, (r8.d) f10);
        return j10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // nb.k0
    public <T> T h(Object obj) {
        return obj instanceof m ? (T) ((m) obj).f12401a : obj;
    }

    @Override // nb.k0
    public Object j() {
        return q();
    }

    public final void l(e eVar, Throwable th) {
        try {
            eVar.a(th);
        } catch (Throwable th2) {
            y.a(c(), new q(y8.k.j("Exception in invokeOnCancellation handler for ", this), th2));
        }
    }

    public final void m(x8.l<? super Throwable, l8.w> lVar, Throwable th) {
        try {
            lVar.h(th);
        } catch (Throwable th2) {
            y.a(c(), new q(y8.k.j("Exception in resume onCancellation handler for ", this), th2));
        }
    }

    public final void n() {
        n0 n0Var = this.f12388k;
        if (n0Var == null) {
            return;
        }
        n0Var.dispose();
        this.f12388k = k1.f12400f;
    }

    public final Object q() {
        return this._state;
    }

    protected String t() {
        return "CancellableContinuation";
    }

    public String toString() {
        return t() + '(' + e0.c(this.f12386i) + "){" + r() + "}@" + e0.b(this);
    }
}
