package a0;

import a0.b;

/* loaded from: classes.dex */
public final class f extends b<f> {

    /* renamed from: m, reason: collision with root package name */
    private g f37m;

    /* renamed from: n, reason: collision with root package name */
    private float f38n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f39o;

    public f(e eVar) {
        super(eVar);
        this.f37m = null;
        this.f38n = Float.MAX_VALUE;
        this.f39o = false;
    }

    private void s() {
        g gVar = this.f37m;
        if (gVar == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double a10 = gVar.a();
        if (a10 > this.f23g) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (a10 < this.f24h) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
    }

    @Override // a0.b
    void n(float f10) {
    }

    @Override // a0.b
    public void o() {
        s();
        this.f37m.g(e());
        super.o();
    }

    @Override // a0.b
    boolean q(long j10) {
        g gVar;
        double d10;
        double d11;
        long j11;
        if (this.f39o) {
            float f10 = this.f38n;
            if (f10 != Float.MAX_VALUE) {
                this.f37m.e(f10);
                this.f38n = Float.MAX_VALUE;
            }
            this.f18b = this.f37m.a();
            this.f17a = 0.0f;
            this.f39o = false;
            return true;
        }
        if (this.f38n != Float.MAX_VALUE) {
            this.f37m.a();
            j11 = j10 / 2;
            b.p h10 = this.f37m.h(this.f18b, this.f17a, j11);
            this.f37m.e(this.f38n);
            this.f38n = Float.MAX_VALUE;
            gVar = this.f37m;
            d10 = h10.f30a;
            d11 = h10.f31b;
        } else {
            gVar = this.f37m;
            d10 = this.f18b;
            d11 = this.f17a;
            j11 = j10;
        }
        b.p h11 = gVar.h(d10, d11, j11);
        this.f18b = h11.f30a;
        this.f17a = h11.f31b;
        float max = Math.max(this.f18b, this.f24h);
        this.f18b = max;
        float min = Math.min(max, this.f23g);
        this.f18b = min;
        if (!r(min, this.f17a)) {
            return false;
        }
        this.f18b = this.f37m.a();
        this.f17a = 0.0f;
        return true;
    }

    boolean r(float f10, float f11) {
        return this.f37m.c(f10, f11);
    }

    public f t(g gVar) {
        this.f37m = gVar;
        return this;
    }
}
