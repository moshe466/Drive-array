package h9;

import bb.c1;
import bb.v0;
import h9.d0;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import n9.a1;
import n9.z0;

/* loaded from: classes.dex */
public final class x implements e9.k {

    /* renamed from: d, reason: collision with root package name */
    static final /* synthetic */ e9.j[] f10679d = {y8.w.g(new y8.t(y8.w.b(x.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), y8.w.g(new y8.t(y8.w.b(x.class), "arguments", "getArguments()Ljava/util/List;"))};

    /* renamed from: a, reason: collision with root package name */
    private final d0.a<Type> f10680a;

    /* renamed from: b, reason: collision with root package name */
    private final d0.a f10681b;

    /* renamed from: c, reason: collision with root package name */
    private final bb.b0 f10682c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends y8.l implements x8.a<List<? extends e9.m>> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ x8.a f10684g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: h9.x$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0195a extends y8.l implements x8.a<Type> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f10685f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ a f10686g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ l8.h f10687h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ e9.j f10688i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0195a(int i10, a aVar, l8.h hVar, e9.j jVar) {
                super(0);
                this.f10685f = i10;
                this.f10686g = aVar;
                this.f10687h = hVar;
                this.f10688i = jVar;
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Type b() {
                Class cls;
                String str;
                Type d10 = x.this.d();
                if (d10 instanceof Class) {
                    Class cls2 = (Class) d10;
                    cls = cls2.isArray() ? cls2.getComponentType() : Object.class;
                    str = "if (javaType.isArray) ja…Type else Any::class.java";
                } else if (d10 instanceof GenericArrayType) {
                    if (this.f10685f != 0) {
                        throw new b0("Array type has been queried for a non-0th argument: " + x.this);
                    }
                    cls = ((GenericArrayType) d10).getGenericComponentType();
                    str = "javaType.genericComponentType";
                } else {
                    if (!(d10 instanceof ParameterizedType)) {
                        throw new b0("Non-generic type has been queried for arguments: " + x.this);
                    }
                    cls = (Type) ((List) this.f10687h.getValue()).get(this.f10685f);
                    if (cls instanceof WildcardType) {
                        WildcardType wildcardType = (WildcardType) cls;
                        Type[] lowerBounds = wildcardType.getLowerBounds();
                        y8.k.d(lowerBounds, "argument.lowerBounds");
                        Type type = (Type) m8.g.q(lowerBounds);
                        if (type != null) {
                            cls = type;
                        } else {
                            Type[] upperBounds = wildcardType.getUpperBounds();
                            y8.k.d(upperBounds, "argument.upperBounds");
                            cls = (Type) m8.g.p(upperBounds);
                        }
                    }
                    str = "if (argument !is Wildcar…ument.upperBounds.first()";
                }
                y8.k.d(cls, str);
                return cls;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static final class b extends y8.l implements x8.a<List<? extends Type>> {
            b() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final List<Type> b() {
                Type d10 = x.this.d();
                y8.k.b(d10);
                return s9.b.d(d10);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(x8.a aVar) {
            super(0);
            this.f10684g = aVar;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<e9.m> b() {
            l8.h a10;
            int n10;
            e9.m d10;
            List<e9.m> d11;
            List<v0> V0 = x.this.e().V0();
            if (V0.isEmpty()) {
                d11 = m8.q.d();
                return d11;
            }
            a10 = l8.j.a(kotlin.b.PUBLICATION, new b());
            n10 = m8.r.n(V0, 10);
            ArrayList arrayList = new ArrayList(n10);
            int i10 = 0;
            for (Object obj : V0) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    m8.q.m();
                }
                v0 v0Var = (v0) obj;
                if (v0Var.d()) {
                    d10 = e9.m.f9257c.c();
                } else {
                    bb.b0 b10 = v0Var.b();
                    y8.k.d(b10, "typeProjection.type");
                    x xVar = new x(b10, this.f10684g != null ? new C0195a(i10, this, a10, null) : null);
                    int i12 = w.f10678a[v0Var.c().ordinal()];
                    if (i12 == 1) {
                        d10 = e9.m.f9257c.d(xVar);
                    } else if (i12 == 2) {
                        d10 = e9.m.f9257c.a(xVar);
                    } else {
                        if (i12 != 3) {
                            throw new l8.l();
                        }
                        d10 = e9.m.f9257c.b(xVar);
                    }
                }
                arrayList.add(d10);
                i10 = i11;
            }
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    static final class b extends y8.l implements x8.a<e9.c> {
        b() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e9.c b() {
            x xVar = x.this;
            return xVar.c(xVar.e());
        }
    }

    public x(bb.b0 b0Var, x8.a<? extends Type> aVar) {
        y8.k.e(b0Var, "type");
        this.f10682c = b0Var;
        d0.a<Type> aVar2 = null;
        d0.a<Type> aVar3 = (d0.a) (!(aVar instanceof d0.a) ? null : aVar);
        if (aVar3 != null) {
            aVar2 = aVar3;
        } else if (aVar != null) {
            aVar2 = d0.d(aVar);
        }
        this.f10680a = aVar2;
        this.f10681b = d0.d(new b());
        d0.d(new a(aVar));
    }

    public /* synthetic */ x(bb.b0 b0Var, x8.a aVar, int i10, y8.g gVar) {
        this(b0Var, (i10 & 2) != 0 ? null : aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e9.c c(bb.b0 b0Var) {
        bb.b0 b10;
        n9.h o10 = b0Var.W0().o();
        if (!(o10 instanceof n9.e)) {
            if (o10 instanceof a1) {
                return new z(null, (a1) o10);
            }
            if (!(o10 instanceof z0)) {
                return null;
            }
            throw new l8.m("An operation is not implemented: Type alias classifiers are not yet supported");
        }
        Class<?> l10 = k0.l((n9.e) o10);
        if (l10 == null) {
            return null;
        }
        if (!l10.isArray()) {
            if (c1.l(b0Var)) {
                return new h(l10);
            }
            Class<?> e10 = s9.b.e(l10);
            if (e10 != null) {
                l10 = e10;
            }
            return new h(l10);
        }
        v0 v0Var = (v0) m8.o.f0(b0Var.V0());
        if (v0Var == null || (b10 = v0Var.b()) == null) {
            return new h(l10);
        }
        y8.k.d(b10, "type.arguments.singleOrN…return KClassImpl(jClass)");
        e9.c c10 = c(b10);
        if (c10 != null) {
            return new h(s9.b.a(w8.a.b(g9.a.a(c10))));
        }
        throw new b0("Cannot determine classifier for array element type: " + this);
    }

    @Override // e9.k
    public e9.c a() {
        return (e9.c) this.f10681b.c(this, f10679d[0]);
    }

    public Type d() {
        d0.a<Type> aVar = this.f10680a;
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    public final bb.b0 e() {
        return this.f10682c;
    }

    public boolean equals(Object obj) {
        return (obj instanceof x) && y8.k.a(this.f10682c, ((x) obj).f10682c);
    }

    public int hashCode() {
        return this.f10682c.hashCode();
    }

    public String toString() {
        return g0.f10543b.h(this.f10682c);
    }
}
