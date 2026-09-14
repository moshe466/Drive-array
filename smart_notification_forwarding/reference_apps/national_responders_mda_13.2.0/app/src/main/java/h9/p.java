package h9;

import h9.d0;
import h9.j;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.i;
import n9.p0;
import ua.h;

/* loaded from: classes.dex */
public final class p extends j {

    /* renamed from: i, reason: collision with root package name */
    private final d0.b<a> f10617i;

    /* renamed from: j, reason: collision with root package name */
    private final Class<?> f10618j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class a extends j.b {

        /* renamed from: i, reason: collision with root package name */
        static final /* synthetic */ e9.j[] f10619i = {y8.w.g(new y8.t(y8.w.b(a.class), "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;")), y8.w.g(new y8.t(y8.w.b(a.class), "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), y8.w.g(new y8.t(y8.w.b(a.class), "multifileFacade", "getMultifileFacade()Ljava/lang/Class;")), y8.w.g(new y8.t(y8.w.b(a.class), "metadata", "getMetadata()Lkotlin/Triple;")), y8.w.g(new y8.t(y8.w.b(a.class), "members", "getMembers()Ljava/util/Collection;"))};

        /* renamed from: d, reason: collision with root package name */
        private final d0.a f10620d;

        /* renamed from: e, reason: collision with root package name */
        private final d0.a f10621e;

        /* renamed from: f, reason: collision with root package name */
        private final d0.b f10622f;

        /* renamed from: g, reason: collision with root package name */
        private final d0.b f10623g;

        /* renamed from: h9.p$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class C0194a extends y8.l implements x8.a<r9.f> {
            C0194a() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final r9.f b() {
                return r9.f.f13808c.a(p.this.b());
            }
        }

        /* loaded from: classes.dex */
        static final class b extends y8.l implements x8.a<Collection<? extends f<?>>> {
            b() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Collection<f<?>> b() {
                a aVar = a.this;
                return p.this.o(aVar.f(), j.c.DECLARED);
            }
        }

        /* loaded from: classes.dex */
        static final class c extends y8.l implements x8.a<l8.s<? extends ka.g, ? extends ga.l, ? extends ka.f>> {
            c() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final l8.s<ka.g, ga.l, ka.f> b() {
                fa.a a10;
                r9.f c10 = a.this.c();
                if (c10 == null || (a10 = c10.a()) == null) {
                    return null;
                }
                String[] a11 = a10.a();
                String[] g10 = a10.g();
                if (a11 == null || g10 == null) {
                    return null;
                }
                l8.n<ka.g, ga.l> m10 = ka.h.m(a11, g10);
                return new l8.s<>(m10.a(), m10.b(), a10.d());
            }
        }

        /* loaded from: classes.dex */
        static final class d extends y8.l implements x8.a<Class<?>> {
            d() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Class<?> b() {
                String t10;
                fa.a a10;
                r9.f c10 = a.this.c();
                String e10 = (c10 == null || (a10 = c10.a()) == null) ? null : a10.e();
                if (e10 == null) {
                    return null;
                }
                if (!(e10.length() > 0)) {
                    return null;
                }
                ClassLoader classLoader = p.this.b().getClassLoader();
                t10 = mb.r.t(e10, '/', '.', false, 4, null);
                return classLoader.loadClass(t10);
            }
        }

        /* loaded from: classes.dex */
        static final class e extends y8.l implements x8.a<ua.h> {
            e() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final ua.h b() {
                r9.f c10 = a.this.c();
                return c10 != null ? a.this.a().c().a(c10) : h.b.f14541b;
            }
        }

        public a() {
            super();
            this.f10620d = d0.d(new C0194a());
            this.f10621e = d0.d(new e());
            this.f10622f = d0.b(new d());
            this.f10623g = d0.b(new c());
            d0.d(new b());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public final r9.f c() {
            return (r9.f) this.f10620d.c(this, f10619i[0]);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final l8.s<ka.g, ga.l, ka.f> d() {
            return (l8.s) this.f10623g.c(this, f10619i[3]);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Class<?> e() {
            return (Class) this.f10622f.c(this, f10619i[2]);
        }

        public final ua.h f() {
            return (ua.h) this.f10621e.c(this, f10619i[1]);
        }
    }

    /* loaded from: classes.dex */
    static final class b extends y8.l implements x8.a<a> {
        b() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a b() {
            return new a();
        }
    }

    /* loaded from: classes.dex */
    static final /* synthetic */ class c extends y8.i implements x8.p<xa.u, ga.n, p0> {

        /* renamed from: o, reason: collision with root package name */
        public static final c f10631o = new c();

        c() {
            super(2);
        }

        @Override // y8.c, e9.a
        public final String c() {
            return "loadProperty";
        }

        @Override // y8.c
        public final e9.d k() {
            return y8.w.b(xa.u.class);
        }

        @Override // y8.c
        public final String m() {
            return "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;";
        }

        @Override // x8.p
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final p0 g(xa.u uVar, ga.n nVar) {
            y8.k.e(uVar, "p1");
            y8.k.e(nVar, "p2");
            return uVar.p(nVar);
        }
    }

    public p(Class<?> cls, String str) {
        y8.k.e(cls, "jClass");
        this.f10618j = cls;
        d0.b<a> b10 = d0.b(new b());
        y8.k.d(b10, "ReflectProperties.lazy { Data() }");
        this.f10617i = b10;
    }

    private final ua.h y() {
        return this.f10617i.b().f();
    }

    @Override // y8.d
    public Class<?> b() {
        return this.f10618j;
    }

    public boolean equals(Object obj) {
        return (obj instanceof p) && y8.k.a(b(), ((p) obj).b());
    }

    public int hashCode() {
        return b().hashCode();
    }

    @Override // h9.j
    public Collection<n9.l> l() {
        List d10;
        d10 = m8.q.d();
        return d10;
    }

    @Override // h9.j
    public Collection<n9.x> m(la.e eVar) {
        y8.k.e(eVar, "name");
        return y().b(eVar, u9.d.FROM_REFLECTION);
    }

    @Override // h9.j
    public p0 n(int i10) {
        l8.s<ka.g, ga.l, ka.f> d10 = this.f10617i.b().d();
        if (d10 == null) {
            return null;
        }
        ka.g a10 = d10.a();
        ga.l b10 = d10.b();
        ka.f c10 = d10.c();
        i.f<ga.l, List<ga.n>> fVar = ja.a.f10986n;
        y8.k.d(fVar, "JvmProtoBuf.packageLocalVariable");
        ga.n nVar = (ga.n) ia.e.b(b10, fVar, i10);
        if (nVar == null) {
            return null;
        }
        Class<?> b11 = b();
        ga.t X = b10.X();
        y8.k.d(X, "packageProto.typeTable");
        return (p0) k0.e(b11, nVar, a10, new ia.g(X), c10, c.f10631o);
    }

    @Override // h9.j
    protected Class<?> p() {
        Class<?> e10 = this.f10617i.b().e();
        return e10 != null ? e10 : b();
    }

    @Override // h9.j
    public Collection<p0> q(la.e eVar) {
        y8.k.e(eVar, "name");
        return y().a(eVar, u9.d.FROM_REFLECTION);
    }

    public String toString() {
        return "file class " + s9.b.b(b()).b();
    }
}
