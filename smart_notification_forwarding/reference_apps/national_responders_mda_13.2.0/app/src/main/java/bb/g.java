package bb;

import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public abstract class g implements t0 {

    /* renamed from: a, reason: collision with root package name */
    private final ab.i<b> f4203a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f4204b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class a implements t0 {

        /* renamed from: a, reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.types.checker.g f4205a;

        /* renamed from: b, reason: collision with root package name */
        private final l8.h f4206b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ g f4207c;

        /* renamed from: bb.g$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class C0072a extends y8.l implements x8.a<List<? extends b0>> {

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ g f4209g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0072a(g gVar) {
                super(0);
                this.f4209g = gVar;
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final List<b0> b() {
                return kotlin.reflect.jvm.internal.impl.types.checker.h.b(a.this.f4205a, this.f4209g.x());
            }
        }

        public a(g gVar, kotlin.reflect.jvm.internal.impl.types.checker.g gVar2) {
            l8.h a10;
            y8.k.e(gVar, "this$0");
            y8.k.e(gVar2, "kotlinTypeRefiner");
            this.f4207c = gVar;
            this.f4205a = gVar2;
            a10 = l8.j.a(kotlin.b.PUBLICATION, new C0072a(gVar));
            this.f4206b = a10;
        }

        private final List<b0> c() {
            return (List) this.f4206b.getValue();
        }

        @Override // bb.t0
        /* renamed from: A */
        public n9.h o() {
            return this.f4207c.o();
        }

        @Override // bb.t0
        public List<n9.a1> B() {
            List<n9.a1> B = this.f4207c.B();
            y8.k.d(B, "this@AbstractTypeConstructor.parameters");
            return B;
        }

        @Override // bb.t0
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public List<b0> x() {
            return c();
        }

        public boolean equals(Object obj) {
            return this.f4207c.equals(obj);
        }

        public int hashCode() {
            return this.f4207c.hashCode();
        }

        public String toString() {
            return this.f4207c.toString();
        }

        @Override // bb.t0
        public k9.h w() {
            k9.h w10 = this.f4207c.w();
            y8.k.d(w10, "this@AbstractTypeConstructor.builtIns");
            return w10;
        }

        @Override // bb.t0
        public t0 y(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            y8.k.e(gVar, "kotlinTypeRefiner");
            return this.f4207c.y(gVar);
        }

        @Override // bb.t0
        public boolean z() {
            return this.f4207c.z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final Collection<b0> f4210a;

        /* renamed from: b, reason: collision with root package name */
        private List<? extends b0> f4211b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Collection<? extends b0> collection) {
            List<? extends b0> b10;
            y8.k.e(collection, "allSupertypes");
            this.f4210a = collection;
            b10 = m8.p.b(t.f4260c);
            this.f4211b = b10;
        }

        public final Collection<b0> a() {
            return this.f4210a;
        }

        public final List<b0> b() {
            return this.f4211b;
        }

        public final void c(List<? extends b0> list) {
            y8.k.e(list, "<set-?>");
            this.f4211b = list;
        }
    }

    /* loaded from: classes.dex */
    static final class c extends y8.l implements x8.a<b> {
        c() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b b() {
            return new b(g.this.d());
        }
    }

    /* loaded from: classes.dex */
    static final class d extends y8.l implements x8.l<Boolean, b> {

        /* renamed from: f, reason: collision with root package name */
        public static final d f4213f = new d();

        d() {
            super(1);
        }

        public final b a(boolean z10) {
            List b10;
            b10 = m8.p.b(t.f4260c);
            return new b(b10);
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ b h(Boolean bool) {
            return a(bool.booleanValue());
        }
    }

    /* loaded from: classes.dex */
    static final class e extends y8.l implements x8.l<b, l8.w> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static final class a extends y8.l implements x8.l<t0, Iterable<? extends b0>> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ g f4215f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(g gVar) {
                super(1);
                this.f4215f = gVar;
            }

            @Override // x8.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Iterable<b0> h(t0 t0Var) {
                y8.k.e(t0Var, "it");
                return this.f4215f.c(t0Var, true);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static final class b extends y8.l implements x8.l<b0, l8.w> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ g f4216f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(g gVar) {
                super(1);
                this.f4216f = gVar;
            }

            public final void a(b0 b0Var) {
                y8.k.e(b0Var, "it");
                this.f4216f.k(b0Var);
            }

            @Override // x8.l
            public /* bridge */ /* synthetic */ l8.w h(b0 b0Var) {
                a(b0Var);
                return l8.w.f11824a;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static final class c extends y8.l implements x8.l<t0, Iterable<? extends b0>> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ g f4217f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(g gVar) {
                super(1);
                this.f4217f = gVar;
            }

            @Override // x8.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Iterable<b0> h(t0 t0Var) {
                y8.k.e(t0Var, "it");
                return this.f4217f.c(t0Var, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static final class d extends y8.l implements x8.l<b0, l8.w> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ g f4218f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(g gVar) {
                super(1);
                this.f4218f = gVar;
            }

            public final void a(b0 b0Var) {
                y8.k.e(b0Var, "it");
                this.f4218f.l(b0Var);
            }

            @Override // x8.l
            public /* bridge */ /* synthetic */ l8.w h(b0 b0Var) {
                a(b0Var);
                return l8.w.f11824a;
            }
        }

        e() {
            super(1);
        }

        public final void a(b bVar) {
            y8.k.e(bVar, "supertypes");
            Collection<b0> a10 = g.this.h().a(g.this, bVar.a(), new c(g.this), new d(g.this));
            if (a10.isEmpty()) {
                b0 e10 = g.this.e();
                a10 = e10 == null ? null : m8.p.b(e10);
                if (a10 == null) {
                    a10 = m8.q.d();
                }
            }
            if (g.this.g()) {
                n9.y0 h10 = g.this.h();
                g gVar = g.this;
                h10.a(gVar, a10, new a(gVar), new b(g.this));
            }
            g gVar2 = g.this;
            List<b0> list = a10 instanceof List ? (List) a10 : null;
            if (list == null) {
                list = m8.y.n0(a10);
            }
            bVar.c(gVar2.j(list));
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ l8.w h(b bVar) {
            a(bVar);
            return l8.w.f11824a;
        }
    }

    public g(ab.n nVar) {
        y8.k.e(nVar, "storageManager");
        this.f4203a = nVar.g(new c(), d.f4213f, new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<b0> c(t0 t0Var, boolean z10) {
        g gVar = t0Var instanceof g ? (g) t0Var : null;
        List a02 = gVar != null ? m8.y.a0(gVar.f4203a.b().a(), gVar.f(z10)) : null;
        if (a02 != null) {
            return a02;
        }
        Collection<b0> x10 = t0Var.x();
        y8.k.d(x10, "supertypes");
        return x10;
    }

    @Override // bb.t0
    /* renamed from: A */
    public abstract n9.h o();

    protected abstract Collection<b0> d();

    protected b0 e() {
        return null;
    }

    protected Collection<b0> f(boolean z10) {
        List d10;
        d10 = m8.q.d();
        return d10;
    }

    protected boolean g() {
        return this.f4204b;
    }

    protected abstract n9.y0 h();

    @Override // bb.t0
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public List<b0> x() {
        return this.f4203a.b().b();
    }

    protected List<b0> j(List<b0> list) {
        y8.k.e(list, "supertypes");
        return list;
    }

    protected void k(b0 b0Var) {
        y8.k.e(b0Var, "type");
    }

    protected void l(b0 b0Var) {
        y8.k.e(b0Var, "type");
    }

    @Override // bb.t0
    public t0 y(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        y8.k.e(gVar, "kotlinTypeRefiner");
        return new a(this, gVar);
    }
}
