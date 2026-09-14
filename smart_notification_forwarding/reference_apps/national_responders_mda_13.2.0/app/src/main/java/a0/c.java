package a0;

import a0.b;

/* loaded from: classes.dex */
public final class c extends b<c> {

    /* renamed from: m, reason: collision with root package name */
    private final a f32m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: b, reason: collision with root package name */
        private float f34b;

        /* renamed from: a, reason: collision with root package name */
        private float f33a = -4.2f;

        /* renamed from: c, reason: collision with root package name */
        private final b.p f35c = new b.p();

        a() {
        }

        public boolean a(float f10, float f11) {
            return Math.abs(f11) < this.f34b;
        }

        void b(float f10) {
            this.f33a = f10 * (-4.2f);
        }

        void c(float f10) {
            this.f34b = f10 * 62.5f;
        }

        b.p d(float f10, float f11, long j10) {
            float f12 = (float) j10;
            this.f35c.f31b = (float) (f11 * Math.exp((f12 / 1000.0f) * this.f33a));
            b.p pVar = this.f35c;
            float f13 = this.f33a;
            pVar.f30a = (float) ((f10 - (f11 / f13)) + ((f11 / f13) * Math.exp((f13 * f12) / 1000.0f)));
            b.p pVar2 = this.f35c;
            if (a(pVar2.f30a, pVar2.f31b)) {
                this.f35c.f31b = 0.0f;
            }
            return this.f35c;
        }
    }

    public c(e eVar) {
        super(eVar);
        a aVar = new a();
        this.f32m = aVar;
        aVar.c(e());
    }

    @Override // a0.b
    void n(float f10) {
        this.f32m.c(f10);
    }

    @Override // a0.b
    boolean q(long j10) {
        b.p d10 = this.f32m.d(this.f18b, this.f17a, j10);
        float f10 = d10.f30a;
        this.f18b = f10;
        float f11 = d10.f31b;
        this.f17a = f11;
        float f12 = this.f24h;
        if (f10 < f12) {
            this.f18b = f12;
            return true;
        }
        float f13 = this.f23g;
        if (f10 <= f13) {
            return r(f10, f11);
        }
        this.f18b = f13;
        return true;
    }

    boolean r(float f10, float f11) {
        return f10 >= this.f23g || f10 <= this.f24h || this.f32m.a(f10, f11);
    }

    public c s(float f10) {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("Friction must be positive");
        }
        this.f32m.b(f10);
        return this;
    }

    public c t(float f10) {
        super.h(f10);
        return this;
    }

    public c u(float f10) {
        super.i(f10);
        return this;
    }

    public c v(float f10) {
        super.m(f10);
        return this;
    }
}
