package z2;

import java.util.concurrent.ExecutionException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t<T> implements s<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Object f16121a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final int f16122b;

    /* renamed from: c, reason: collision with root package name */
    private final o0 f16123c;

    /* renamed from: d, reason: collision with root package name */
    private int f16124d;

    /* renamed from: e, reason: collision with root package name */
    private int f16125e;

    /* renamed from: f, reason: collision with root package name */
    private int f16126f;

    /* renamed from: g, reason: collision with root package name */
    private Exception f16127g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f16128h;

    public t(int i10, o0 o0Var) {
        this.f16122b = i10;
        this.f16123c = o0Var;
    }

    private final void c() {
        if (this.f16124d + this.f16125e + this.f16126f == this.f16122b) {
            if (this.f16127g == null) {
                if (this.f16128h) {
                    this.f16123c.u();
                    return;
                } else {
                    this.f16123c.t(null);
                    return;
                }
            }
            this.f16123c.s(new ExecutionException(this.f16125e + " out of " + this.f16122b + " underlying tasks failed", this.f16127g));
        }
    }

    @Override // z2.e
    public final void a() {
        synchronized (this.f16121a) {
            this.f16126f++;
            this.f16128h = true;
            c();
        }
    }

    @Override // z2.h
    public final void b(T t10) {
        synchronized (this.f16121a) {
            this.f16124d++;
            c();
        }
    }

    @Override // z2.g
    public final void d(Exception exc) {
        synchronized (this.f16121a) {
            this.f16125e++;
            this.f16127g = exc;
            c();
        }
    }
}
