package bb;

/* loaded from: classes.dex */
public final class n0 extends w0 {

    /* renamed from: a, reason: collision with root package name */
    private final n9.a1 f4236a;

    /* renamed from: b, reason: collision with root package name */
    private final l8.h f4237b;

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.a<b0> {
        a() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b0 b() {
            return o0.a(n0.this.f4236a);
        }
    }

    public n0(n9.a1 a1Var) {
        l8.h a10;
        y8.k.e(a1Var, "typeParameter");
        this.f4236a = a1Var;
        a10 = l8.j.a(kotlin.b.PUBLICATION, new a());
        this.f4237b = a10;
    }

    private final b0 e() {
        return (b0) this.f4237b.getValue();
    }

    @Override // bb.v0
    public b0 b() {
        return e();
    }

    @Override // bb.v0
    public h1 c() {
        return h1.OUT_VARIANCE;
    }

    @Override // bb.v0
    public boolean d() {
        return true;
    }

    @Override // bb.v0
    public v0 y(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        y8.k.e(gVar, "kotlinTypeRefiner");
        return this;
    }
}
