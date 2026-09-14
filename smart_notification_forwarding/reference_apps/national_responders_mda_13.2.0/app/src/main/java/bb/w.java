package bb;

/* loaded from: classes.dex */
public final class w extends v implements j {

    /* renamed from: j, reason: collision with root package name */
    public static boolean f4275j;

    /* renamed from: i, reason: collision with root package name */
    private boolean f4276i;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(i0 i0Var, i0 i0Var2) {
        super(i0Var, i0Var2);
        y8.k.e(i0Var, "lowerBound");
        y8.k.e(i0Var2, "upperBound");
    }

    private final void i1() {
        if (!f4275j || this.f4276i) {
            return;
        }
        this.f4276i = true;
        y.b(e1());
        y.b(f1());
        y8.k.a(e1(), f1());
        kotlin.reflect.jvm.internal.impl.types.checker.f.f11565a.b(e1(), f1());
    }

    @Override // bb.g1
    public g1 a1(boolean z10) {
        c0 c0Var = c0.f4165a;
        return c0.d(e1().a1(z10), f1().a1(z10));
    }

    @Override // bb.j
    public boolean c() {
        return (e1().W0().o() instanceof n9.a1) && y8.k.a(e1().W0(), f1().W0());
    }

    @Override // bb.g1
    public g1 c1(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        y8.k.e(gVar, "newAnnotations");
        c0 c0Var = c0.f4165a;
        return c0.d(e1().c1(gVar), f1().c1(gVar));
    }

    @Override // bb.v
    public i0 d1() {
        i1();
        return e1();
    }

    @Override // bb.v
    public String g1(kotlin.reflect.jvm.internal.impl.renderer.c cVar, kotlin.reflect.jvm.internal.impl.renderer.f fVar) {
        y8.k.e(cVar, "renderer");
        y8.k.e(fVar, "options");
        if (!fVar.m()) {
            return cVar.u(cVar.x(e1()), cVar.x(f1()), eb.a.e(this));
        }
        return '(' + cVar.x(e1()) + ".." + cVar.x(f1()) + ')';
    }

    @Override // bb.g1
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public v g1(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        y8.k.e(gVar, "kotlinTypeRefiner");
        return new w((i0) gVar.g(e1()), (i0) gVar.g(f1()));
    }

    @Override // bb.j
    public b0 v0(b0 b0Var) {
        g1 d10;
        y8.k.e(b0Var, "replacement");
        g1 Z0 = b0Var.Z0();
        if (Z0 instanceof v) {
            d10 = Z0;
        } else {
            if (!(Z0 instanceof i0)) {
                throw new l8.l();
            }
            c0 c0Var = c0.f4165a;
            i0 i0Var = (i0) Z0;
            d10 = c0.d(i0Var, i0Var.a1(true));
        }
        return e1.b(d10, Z0);
    }
}
