package bb;

/* loaded from: classes.dex */
public final class p extends y0 {

    /* renamed from: d, reason: collision with root package name */
    public static final a f4240d = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final y0 f4241b;

    /* renamed from: c, reason: collision with root package name */
    private final y0 f4242c;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        public final y0 a(y0 y0Var, y0 y0Var2) {
            y8.k.e(y0Var, "first");
            y8.k.e(y0Var2, "second");
            return y0Var.f() ? y0Var2 : y0Var2.f() ? y0Var : new p(y0Var, y0Var2, null);
        }
    }

    private p(y0 y0Var, y0 y0Var2) {
        this.f4241b = y0Var;
        this.f4242c = y0Var2;
    }

    public /* synthetic */ p(y0 y0Var, y0 y0Var2, y8.g gVar) {
        this(y0Var, y0Var2);
    }

    public static final y0 h(y0 y0Var, y0 y0Var2) {
        return f4240d.a(y0Var, y0Var2);
    }

    @Override // bb.y0
    public boolean a() {
        return this.f4241b.a() || this.f4242c.a();
    }

    @Override // bb.y0
    public boolean b() {
        return this.f4241b.b() || this.f4242c.b();
    }

    @Override // bb.y0
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g d(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        y8.k.e(gVar, "annotations");
        return this.f4242c.d(this.f4241b.d(gVar));
    }

    @Override // bb.y0
    public v0 e(b0 b0Var) {
        y8.k.e(b0Var, "key");
        v0 e10 = this.f4241b.e(b0Var);
        return e10 == null ? this.f4242c.e(b0Var) : e10;
    }

    @Override // bb.y0
    public boolean f() {
        return false;
    }

    @Override // bb.y0
    public b0 g(b0 b0Var, h1 h1Var) {
        y8.k.e(b0Var, "topLevelType");
        y8.k.e(h1Var, "position");
        return this.f4242c.g(this.f4241b.g(b0Var, h1Var), h1Var);
    }
}
