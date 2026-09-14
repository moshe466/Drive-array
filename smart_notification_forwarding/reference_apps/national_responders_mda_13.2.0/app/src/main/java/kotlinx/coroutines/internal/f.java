package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import nb.k0;
import nb.o1;
import nb.p0;

/* loaded from: classes.dex */
public final class f<T> extends k0<T> implements r8.d, p8.d<T> {
    private volatile /* synthetic */ Object _reusableCancellableContinuation;

    /* renamed from: i, reason: collision with root package name */
    public final nb.u f11607i;

    /* renamed from: j, reason: collision with root package name */
    public final p8.d<T> f11608j;

    /* renamed from: k, reason: collision with root package name */
    public Object f11609k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f11610l;

    static {
        AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_reusableCancellableContinuation");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(nb.u uVar, p8.d<? super T> dVar) {
        super(-1);
        this.f11607i = uVar;
        this.f11608j = dVar;
        this.f11609k = g.a();
        this.f11610l = f0.b(c());
        this._reusableCancellableContinuation = null;
    }

    private final nb.h<?> l() {
        Object obj = this._reusableCancellableContinuation;
        if (obj instanceof nb.h) {
            return (nb.h) obj;
        }
        return null;
    }

    @Override // r8.d
    public r8.d a() {
        p8.d<T> dVar = this.f11608j;
        if (dVar instanceof r8.d) {
            return (r8.d) dVar;
        }
        return null;
    }

    @Override // p8.d
    public void b(Object obj) {
        p8.f c10 = this.f11608j.c();
        Object d10 = nb.r.d(obj, null, 1, null);
        if (this.f11607i.a0(c10)) {
            this.f11609k = d10;
            this.f12399h = 0;
            this.f11607i.c(c10, this);
            return;
        }
        nb.d0.a();
        p0 a10 = o1.f12412a.a();
        if (a10.i0()) {
            this.f11609k = d10;
            this.f12399h = 0;
            a10.e0(this);
            return;
        }
        a10.g0(true);
        try {
            p8.f c11 = c();
            Object c12 = f0.c(c11, this.f11610l);
            try {
                this.f11608j.b(obj);
                l8.w wVar = l8.w.f11824a;
                do {
                } while (a10.k0());
            } finally {
                f0.a(c11, c12);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // p8.d
    public p8.f c() {
        return this.f11608j.c();
    }

    @Override // nb.k0
    public void d(Object obj, Throwable th) {
        if (obj instanceof nb.o) {
            ((nb.o) obj).f12410b.h(th);
        }
    }

    @Override // r8.d
    public StackTraceElement e() {
        return null;
    }

    @Override // nb.k0
    public p8.d<T> f() {
        return this;
    }

    @Override // nb.k0
    public Object j() {
        Object obj = this.f11609k;
        if (nb.d0.a()) {
            if (!(obj != g.a())) {
                throw new AssertionError();
            }
        }
        this.f11609k = g.a();
        return obj;
    }

    public final void k() {
        do {
        } while (this._reusableCancellableContinuation == g.f11619b);
    }

    public final boolean m() {
        return this._reusableCancellableContinuation != null;
    }

    public final void n() {
        k();
        nb.h<?> l10 = l();
        if (l10 == null) {
            return;
        }
        l10.n();
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f11607i + ", " + nb.e0.c(this.f11608j) + ']';
    }
}
