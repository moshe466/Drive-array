package bc;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class i extends t {

    /* renamed from: e, reason: collision with root package name */
    private t f4306e;

    public i(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f4306e = tVar;
    }

    @Override // bc.t
    public t a() {
        return this.f4306e.a();
    }

    @Override // bc.t
    public t b() {
        return this.f4306e.b();
    }

    @Override // bc.t
    public long c() {
        return this.f4306e.c();
    }

    @Override // bc.t
    public t d(long j10) {
        return this.f4306e.d(j10);
    }

    @Override // bc.t
    public boolean e() {
        return this.f4306e.e();
    }

    @Override // bc.t
    public void f() {
        this.f4306e.f();
    }

    @Override // bc.t
    public t g(long j10, TimeUnit timeUnit) {
        return this.f4306e.g(j10, timeUnit);
    }

    public final t i() {
        return this.f4306e;
    }

    public final i j(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f4306e = tVar;
        return this;
    }
}
