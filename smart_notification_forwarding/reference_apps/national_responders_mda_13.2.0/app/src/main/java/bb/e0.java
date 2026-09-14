package bb;

/* loaded from: classes.dex */
public final class e0 extends i1 {

    /* renamed from: g, reason: collision with root package name */
    private final ab.n f4190g;

    /* renamed from: h, reason: collision with root package name */
    private final x8.a<b0> f4191h;

    /* renamed from: i, reason: collision with root package name */
    private final ab.i<b0> f4192i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends y8.l implements x8.a<b0> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.types.checker.g f4193f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ e0 f4194g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(kotlin.reflect.jvm.internal.impl.types.checker.g gVar, e0 e0Var) {
            super(0);
            this.f4193f = gVar;
            this.f4194g = e0Var;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b0 b() {
            return this.f4193f.g((b0) this.f4194g.f4191h.b());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e0(ab.n nVar, x8.a<? extends b0> aVar) {
        y8.k.e(nVar, "storageManager");
        y8.k.e(aVar, "computation");
        this.f4190g = nVar;
        this.f4191h = aVar;
        this.f4192i = nVar.a(aVar);
    }

    @Override // bb.i1
    protected b0 a1() {
        return this.f4192i.b();
    }

    @Override // bb.i1
    public boolean b1() {
        return this.f4192i.e();
    }

    @Override // bb.b0
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public e0 g1(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        y8.k.e(gVar, "kotlinTypeRefiner");
        return new e0(this.f4190g, new a(gVar, this));
    }
}
