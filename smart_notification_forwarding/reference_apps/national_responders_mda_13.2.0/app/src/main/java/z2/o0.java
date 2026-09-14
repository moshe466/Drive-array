package z2;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o0<TResult> extends l<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private final Object f16111a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final k0 f16112b = new k0();

    /* renamed from: c, reason: collision with root package name */
    private boolean f16113c;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f16114d;

    /* renamed from: e, reason: collision with root package name */
    private Object f16115e;

    /* renamed from: f, reason: collision with root package name */
    private Exception f16116f;

    private final void A() {
        synchronized (this.f16111a) {
            if (this.f16113c) {
                this.f16112b.b(this);
            }
        }
    }

    private final void x() {
        b2.p.o(this.f16113c, "Task is not yet complete");
    }

    private final void y() {
        if (this.f16114d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void z() {
        if (this.f16113c) {
            throw d.a(this);
        }
    }

    @Override // z2.l
    public final l<TResult> a(Executor executor, e eVar) {
        this.f16112b.a(new a0(executor, eVar));
        A();
        return this;
    }

    @Override // z2.l
    public final l<TResult> b(Executor executor, f<TResult> fVar) {
        this.f16112b.a(new c0(executor, fVar));
        A();
        return this;
    }

    @Override // z2.l
    public final l<TResult> c(f<TResult> fVar) {
        this.f16112b.a(new c0(n.f16108a, fVar));
        A();
        return this;
    }

    @Override // z2.l
    public final l<TResult> d(Executor executor, g gVar) {
        this.f16112b.a(new e0(executor, gVar));
        A();
        return this;
    }

    @Override // z2.l
    public final l<TResult> e(g gVar) {
        d(n.f16108a, gVar);
        return this;
    }

    @Override // z2.l
    public final l<TResult> f(Executor executor, h<? super TResult> hVar) {
        this.f16112b.a(new g0(executor, hVar));
        A();
        return this;
    }

    @Override // z2.l
    public final l<TResult> g(h<? super TResult> hVar) {
        f(n.f16108a, hVar);
        return this;
    }

    @Override // z2.l
    public final <TContinuationResult> l<TContinuationResult> h(Executor executor, c<TResult, TContinuationResult> cVar) {
        o0 o0Var = new o0();
        this.f16112b.a(new w(executor, cVar, o0Var));
        A();
        return o0Var;
    }

    @Override // z2.l
    public final <TContinuationResult> l<TContinuationResult> i(c<TResult, TContinuationResult> cVar) {
        return h(n.f16108a, cVar);
    }

    @Override // z2.l
    public final <TContinuationResult> l<TContinuationResult> j(Executor executor, c<TResult, l<TContinuationResult>> cVar) {
        o0 o0Var = new o0();
        this.f16112b.a(new y(executor, cVar, o0Var));
        A();
        return o0Var;
    }

    @Override // z2.l
    public final Exception k() {
        Exception exc;
        synchronized (this.f16111a) {
            exc = this.f16116f;
        }
        return exc;
    }

    @Override // z2.l
    public final TResult l() {
        TResult tresult;
        synchronized (this.f16111a) {
            x();
            y();
            Exception exc = this.f16116f;
            if (exc != null) {
                throw new j(exc);
            }
            tresult = (TResult) this.f16115e;
        }
        return tresult;
    }

    @Override // z2.l
    public final <X extends Throwable> TResult m(Class<X> cls) {
        TResult tresult;
        synchronized (this.f16111a) {
            x();
            y();
            if (cls.isInstance(this.f16116f)) {
                throw cls.cast(this.f16116f);
            }
            Exception exc = this.f16116f;
            if (exc != null) {
                throw new j(exc);
            }
            tresult = (TResult) this.f16115e;
        }
        return tresult;
    }

    @Override // z2.l
    public final boolean n() {
        return this.f16114d;
    }

    @Override // z2.l
    public final boolean o() {
        boolean z10;
        synchronized (this.f16111a) {
            z10 = this.f16113c;
        }
        return z10;
    }

    @Override // z2.l
    public final boolean p() {
        boolean z10;
        synchronized (this.f16111a) {
            z10 = false;
            if (this.f16113c && !this.f16114d && this.f16116f == null) {
                z10 = true;
            }
        }
        return z10;
    }

    @Override // z2.l
    public final <TContinuationResult> l<TContinuationResult> q(Executor executor, k<TResult, TContinuationResult> kVar) {
        o0 o0Var = new o0();
        this.f16112b.a(new i0(executor, kVar, o0Var));
        A();
        return o0Var;
    }

    @Override // z2.l
    public final <TContinuationResult> l<TContinuationResult> r(k<TResult, TContinuationResult> kVar) {
        Executor executor = n.f16108a;
        o0 o0Var = new o0();
        this.f16112b.a(new i0(executor, kVar, o0Var));
        A();
        return o0Var;
    }

    public final void s(Exception exc) {
        b2.p.l(exc, "Exception must not be null");
        synchronized (this.f16111a) {
            z();
            this.f16113c = true;
            this.f16116f = exc;
        }
        this.f16112b.b(this);
    }

    public final void t(Object obj) {
        synchronized (this.f16111a) {
            z();
            this.f16113c = true;
            this.f16115e = obj;
        }
        this.f16112b.b(this);
    }

    public final boolean u() {
        synchronized (this.f16111a) {
            if (this.f16113c) {
                return false;
            }
            this.f16113c = true;
            this.f16114d = true;
            this.f16112b.b(this);
            return true;
        }
    }

    public final boolean v(Exception exc) {
        b2.p.l(exc, "Exception must not be null");
        synchronized (this.f16111a) {
            if (this.f16113c) {
                return false;
            }
            this.f16113c = true;
            this.f16116f = exc;
            this.f16112b.b(this);
            return true;
        }
    }

    public final boolean w(Object obj) {
        synchronized (this.f16111a) {
            if (this.f16113c) {
                return false;
            }
            this.f16113c = true;
            this.f16115e = obj;
            this.f16112b.b(this);
            return true;
        }
    }
}
