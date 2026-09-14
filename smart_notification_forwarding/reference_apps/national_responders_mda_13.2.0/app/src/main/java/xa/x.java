package xa;

import ga.c;
import n9.v0;

/* loaded from: classes.dex */
public abstract class x {

    /* renamed from: a, reason: collision with root package name */
    private final ia.c f15657a;

    /* renamed from: b, reason: collision with root package name */
    private final ia.g f15658b;

    /* renamed from: c, reason: collision with root package name */
    private final v0 f15659c;

    /* loaded from: classes.dex */
    public static final class a extends x {

        /* renamed from: d, reason: collision with root package name */
        private final ga.c f15660d;

        /* renamed from: e, reason: collision with root package name */
        private final a f15661e;

        /* renamed from: f, reason: collision with root package name */
        private final la.a f15662f;

        /* renamed from: g, reason: collision with root package name */
        private final c.EnumC0180c f15663g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f15664h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ga.c cVar, ia.c cVar2, ia.g gVar, v0 v0Var, a aVar) {
            super(cVar2, gVar, v0Var, null);
            y8.k.e(cVar, "classProto");
            y8.k.e(cVar2, "nameResolver");
            y8.k.e(gVar, "typeTable");
            this.f15660d = cVar;
            this.f15661e = aVar;
            this.f15662f = v.a(cVar2, cVar.p0());
            c.EnumC0180c d10 = ia.b.f10799e.d(cVar.o0());
            this.f15663g = d10 == null ? c.EnumC0180c.CLASS : d10;
            Boolean d11 = ia.b.f10800f.d(cVar.o0());
            y8.k.d(d11, "IS_INNER.get(classProto.flags)");
            this.f15664h = d11.booleanValue();
        }

        @Override // xa.x
        public la.b a() {
            la.b b10 = this.f15662f.b();
            y8.k.d(b10, "classId.asSingleFqName()");
            return b10;
        }

        public final la.a e() {
            return this.f15662f;
        }

        public final ga.c f() {
            return this.f15660d;
        }

        public final c.EnumC0180c g() {
            return this.f15663g;
        }

        public final a h() {
            return this.f15661e;
        }

        public final boolean i() {
            return this.f15664h;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends x {

        /* renamed from: d, reason: collision with root package name */
        private final la.b f15665d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(la.b bVar, ia.c cVar, ia.g gVar, v0 v0Var) {
            super(cVar, gVar, v0Var, null);
            y8.k.e(bVar, "fqName");
            y8.k.e(cVar, "nameResolver");
            y8.k.e(gVar, "typeTable");
            this.f15665d = bVar;
        }

        @Override // xa.x
        public la.b a() {
            return this.f15665d;
        }
    }

    private x(ia.c cVar, ia.g gVar, v0 v0Var) {
        this.f15657a = cVar;
        this.f15658b = gVar;
        this.f15659c = v0Var;
    }

    public /* synthetic */ x(ia.c cVar, ia.g gVar, v0 v0Var, y8.g gVar2) {
        this(cVar, gVar, v0Var);
    }

    public abstract la.b a();

    public final ia.c b() {
        return this.f15657a;
    }

    public final v0 c() {
        return this.f15659c;
    }

    public final ia.g d() {
        return this.f15658b;
    }

    public String toString() {
        return ((Object) getClass().getSimpleName()) + ": " + a();
    }
}
