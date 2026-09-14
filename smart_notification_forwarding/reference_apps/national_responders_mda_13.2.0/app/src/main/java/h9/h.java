package h9;

import bb.t0;
import fa.a;
import h9.d0;
import h9.j;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.i;
import n9.a1;
import n9.p0;
import ua.k;

/* loaded from: classes.dex */
public final class h<T> extends j implements e9.b<T>, a0 {

    /* renamed from: i, reason: collision with root package name */
    private final d0.b<h<T>.a> f10546i;

    /* renamed from: j, reason: collision with root package name */
    private final Class<T> f10547j;

    /* loaded from: classes.dex */
    public final class a extends j.b {

        /* renamed from: m, reason: collision with root package name */
        static final /* synthetic */ e9.j[] f10548m = {y8.w.g(new y8.t(y8.w.b(a.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), y8.w.g(new y8.t(y8.w.b(a.class), "annotations", "getAnnotations()Ljava/util/List;")), y8.w.g(new y8.t(y8.w.b(a.class), "simpleName", "getSimpleName()Ljava/lang/String;")), y8.w.g(new y8.t(y8.w.b(a.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), y8.w.g(new y8.t(y8.w.b(a.class), "constructors", "getConstructors()Ljava/util/Collection;")), y8.w.g(new y8.t(y8.w.b(a.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), y8.w.g(new y8.t(y8.w.b(a.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), y8.w.g(new y8.t(y8.w.b(a.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), y8.w.g(new y8.t(y8.w.b(a.class), "supertypes", "getSupertypes()Ljava/util/List;")), y8.w.g(new y8.t(y8.w.b(a.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), y8.w.g(new y8.t(y8.w.b(a.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), y8.w.g(new y8.t(y8.w.b(a.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), y8.w.g(new y8.t(y8.w.b(a.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), y8.w.g(new y8.t(y8.w.b(a.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), y8.w.g(new y8.t(y8.w.b(a.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), y8.w.g(new y8.t(y8.w.b(a.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), y8.w.g(new y8.t(y8.w.b(a.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), y8.w.g(new y8.t(y8.w.b(a.class), "allMembers", "getAllMembers()Ljava/util/Collection;"))};

        /* renamed from: d, reason: collision with root package name */
        private final d0.a f10549d;

        /* renamed from: e, reason: collision with root package name */
        private final d0.a f10550e;

        /* renamed from: f, reason: collision with root package name */
        private final d0.a f10551f;

        /* renamed from: g, reason: collision with root package name */
        private final d0.a f10552g;

        /* renamed from: h, reason: collision with root package name */
        private final d0.a f10553h;

        /* renamed from: i, reason: collision with root package name */
        private final d0.a f10554i;

        /* renamed from: j, reason: collision with root package name */
        private final d0.a f10555j;

        /* renamed from: k, reason: collision with root package name */
        private final d0.a f10556k;

        /* renamed from: h9.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class C0191a extends y8.l implements x8.a<List<? extends h9.f<?>>> {
            C0191a() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final List<h9.f<?>> b() {
                List<h9.f<?>> a02;
                a02 = m8.y.a0(a.this.g(), a.this.h());
                return a02;
            }
        }

        /* loaded from: classes.dex */
        static final class b extends y8.l implements x8.a<List<? extends h9.f<?>>> {
            b() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final List<h9.f<?>> b() {
                List<h9.f<?>> a02;
                a02 = m8.y.a0(a.this.i(), a.this.l());
                return a02;
            }
        }

        /* loaded from: classes.dex */
        static final class c extends y8.l implements x8.a<List<? extends h9.f<?>>> {
            c() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final List<h9.f<?>> b() {
                List<h9.f<?>> a02;
                a02 = m8.y.a0(a.this.j(), a.this.m());
                return a02;
            }
        }

        /* loaded from: classes.dex */
        static final class d extends y8.l implements x8.a<List<? extends Annotation>> {
            d() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final List<Annotation> b() {
                return k0.c(a.this.k());
            }
        }

        /* loaded from: classes.dex */
        static final class e extends y8.l implements x8.a<List<? extends e9.e<? extends T>>> {
            e() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final List<e9.e<T>> b() {
                int n10;
                Collection<n9.l> l10 = h.this.l();
                n10 = m8.r.n(l10, 10);
                ArrayList arrayList = new ArrayList(n10);
                Iterator<T> it = l10.iterator();
                while (it.hasNext()) {
                    arrayList.add(new h9.k(h.this, (n9.l) it.next()));
                }
                return arrayList;
            }
        }

        /* loaded from: classes.dex */
        static final class f extends y8.l implements x8.a<List<? extends h9.f<?>>> {
            f() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final List<h9.f<?>> b() {
                List<h9.f<?>> a02;
                a02 = m8.y.a0(a.this.i(), a.this.j());
                return a02;
            }
        }

        /* loaded from: classes.dex */
        static final class g extends y8.l implements x8.a<Collection<? extends h9.f<?>>> {
            g() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Collection<h9.f<?>> b() {
                h hVar = h.this;
                return hVar.o(hVar.D(), j.c.DECLARED);
            }
        }

        /* renamed from: h9.h$a$h, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class C0192h extends y8.l implements x8.a<Collection<? extends h9.f<?>>> {
            C0192h() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Collection<h9.f<?>> b() {
                h hVar = h.this;
                return hVar.o(hVar.E(), j.c.DECLARED);
            }
        }

        /* loaded from: classes.dex */
        static final class i extends y8.l implements x8.a<n9.e> {
            i() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final n9.e b() {
                la.a A = h.this.A();
                r9.k a10 = h.this.B().b().a();
                n9.e b10 = A.k() ? a10.a().b(A) : n9.w.a(a10.b(), A);
                if (b10 != null) {
                    return b10;
                }
                h.this.F();
                throw null;
            }
        }

        /* loaded from: classes.dex */
        static final class j extends y8.l implements x8.a<Collection<? extends h9.f<?>>> {
            j() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Collection<h9.f<?>> b() {
                h hVar = h.this;
                return hVar.o(hVar.D(), j.c.INHERITED);
            }
        }

        /* loaded from: classes.dex */
        static final class k extends y8.l implements x8.a<Collection<? extends h9.f<?>>> {
            k() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Collection<h9.f<?>> b() {
                h hVar = h.this;
                return hVar.o(hVar.E(), j.c.INHERITED);
            }
        }

        /* loaded from: classes.dex */
        static final class l extends y8.l implements x8.a<List<? extends h<? extends Object>>> {
            l() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final List<h<? extends Object>> b() {
                Collection a10 = k.a.a(a.this.k().u0(), null, null, 3, null);
                ArrayList<n9.m> arrayList = new ArrayList();
                for (T t10 : a10) {
                    if (!na.d.B((n9.m) t10)) {
                        arrayList.add(t10);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                for (n9.m mVar : arrayList) {
                    Objects.requireNonNull(mVar, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    Class<?> l10 = k0.l((n9.e) mVar);
                    h hVar = l10 != null ? new h(l10) : null;
                    if (hVar != null) {
                        arrayList2.add(hVar);
                    }
                }
                return arrayList2;
            }
        }

        /* loaded from: classes.dex */
        static final class m extends y8.l implements x8.a<T> {
            m() {
                super(0);
            }

            @Override // x8.a
            public final T b() {
                n9.e k10 = a.this.k();
                if (k10.r() != n9.f.OBJECT) {
                    return null;
                }
                T t10 = (T) ((!k10.N() || k9.d.a(k9.c.f11209a, k10)) ? h.this.b().getDeclaredField("INSTANCE") : h.this.b().getEnclosingClass().getDeclaredField(k10.c().k())).get(null);
                Objects.requireNonNull(t10, "null cannot be cast to non-null type T");
                return t10;
            }
        }

        /* loaded from: classes.dex */
        static final class n extends y8.l implements x8.a<String> {
            n() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String b() {
                if (h.this.b().isAnonymousClass()) {
                    return null;
                }
                la.a A = h.this.A();
                if (A.k()) {
                    return null;
                }
                return A.b().b();
            }
        }

        /* loaded from: classes.dex */
        static final class o extends y8.l implements x8.a<List<? extends h<? extends T>>> {
            o() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final List<h<? extends T>> b() {
                Collection<n9.e> g02 = a.this.k().g0();
                y8.k.d(g02, "descriptor.sealedSubclasses");
                ArrayList arrayList = new ArrayList();
                for (n9.e eVar : g02) {
                    Objects.requireNonNull(eVar, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    Class<?> l10 = k0.l(eVar);
                    h hVar = l10 != null ? new h(l10) : null;
                    if (hVar != null) {
                        arrayList.add(hVar);
                    }
                }
                return arrayList;
            }
        }

        /* loaded from: classes.dex */
        static final class p extends y8.l implements x8.a<String> {
            p() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String b() {
                if (h.this.b().isAnonymousClass()) {
                    return null;
                }
                la.a A = h.this.A();
                if (A.k()) {
                    a aVar = a.this;
                    return aVar.f(h.this.b());
                }
                String k10 = A.j().k();
                y8.k.d(k10, "classId.shortClassName.asString()");
                return k10;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static final class q extends y8.l implements x8.a<List<? extends x>> {

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: h9.h$a$q$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0193a extends y8.l implements x8.a<Type> {

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ bb.b0 f10575f;

                /* renamed from: g, reason: collision with root package name */
                final /* synthetic */ q f10576g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0193a(bb.b0 b0Var, q qVar) {
                    super(0);
                    this.f10575f = b0Var;
                    this.f10576g = qVar;
                }

                @Override // x8.a
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Type b() {
                    int v10;
                    Type type;
                    String str;
                    n9.h o10 = this.f10575f.W0().o();
                    if (!(o10 instanceof n9.e)) {
                        throw new b0("Supertype not a class: " + o10);
                    }
                    Class<?> l10 = k0.l((n9.e) o10);
                    if (l10 == null) {
                        throw new b0("Unsupported superclass of " + a.this + ": " + o10);
                    }
                    if (y8.k.a(h.this.b().getSuperclass(), l10)) {
                        type = h.this.b().getGenericSuperclass();
                        str = "jClass.genericSuperclass";
                    } else {
                        Class<?>[] interfaces = h.this.b().getInterfaces();
                        y8.k.d(interfaces, "jClass.interfaces");
                        v10 = m8.k.v(interfaces, l10);
                        if (v10 < 0) {
                            throw new b0("No superclass of " + a.this + " in Java reflection for " + o10);
                        }
                        type = h.this.b().getGenericInterfaces()[v10];
                        str = "jClass.genericInterfaces[index]";
                    }
                    y8.k.d(type, str);
                    return type;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* loaded from: classes.dex */
            public static final class b extends y8.l implements x8.a<Type> {

                /* renamed from: f, reason: collision with root package name */
                public static final b f10577f = new b();

                b() {
                    super(0);
                }

                @Override // x8.a
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Type b() {
                    return Object.class;
                }
            }

            q() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final List<x> b() {
                t0 o10 = a.this.k().o();
                y8.k.d(o10, "descriptor.typeConstructor");
                Collection<bb.b0> x10 = o10.x();
                y8.k.d(x10, "descriptor.typeConstructor.supertypes");
                ArrayList arrayList = new ArrayList(x10.size());
                for (bb.b0 b0Var : x10) {
                    y8.k.d(b0Var, "kotlinType");
                    arrayList.add(new x(b0Var, new C0193a(b0Var, this)));
                }
                if (!k9.h.B0(a.this.k())) {
                    boolean z10 = false;
                    if (!arrayList.isEmpty()) {
                        Iterator<T> it = arrayList.iterator();
                        while (it.hasNext()) {
                            n9.e e10 = na.d.e(((x) it.next()).e());
                            y8.k.d(e10, "DescriptorUtils.getClassDescriptorForType(it.type)");
                            n9.f r10 = e10.r();
                            y8.k.d(r10, "DescriptorUtils.getClass…ptorForType(it.type).kind");
                            if (!(r10 == n9.f.INTERFACE || r10 == n9.f.ANNOTATION_CLASS)) {
                                break;
                            }
                        }
                    }
                    z10 = true;
                    if (z10) {
                        bb.i0 i10 = ra.a.g(a.this.k()).i();
                        y8.k.d(i10, "descriptor.builtIns.anyType");
                        arrayList.add(new x(i10, b.f10577f));
                    }
                }
                return jb.a.c(arrayList);
            }
        }

        /* loaded from: classes.dex */
        static final class r extends y8.l implements x8.a<List<? extends z>> {
            r() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final List<z> b() {
                int n10;
                List<a1> B = a.this.k().B();
                y8.k.d(B, "descriptor.declaredTypeParameters");
                n10 = m8.r.n(B, 10);
                ArrayList arrayList = new ArrayList(n10);
                for (a1 a1Var : B) {
                    h hVar = h.this;
                    y8.k.d(a1Var, "descriptor");
                    arrayList.add(new z(hVar, a1Var));
                }
                return arrayList;
            }
        }

        public a() {
            super();
            this.f10549d = d0.d(new i());
            d0.d(new d());
            d0.d(new p());
            this.f10550e = d0.d(new n());
            d0.d(new e());
            d0.d(new l());
            d0.b(new m());
            d0.d(new r());
            d0.d(new q());
            d0.d(new o());
            this.f10551f = d0.d(new g());
            this.f10552g = d0.d(new C0192h());
            this.f10553h = d0.d(new j());
            this.f10554i = d0.d(new k());
            this.f10555j = d0.d(new b());
            this.f10556k = d0.d(new c());
            d0.d(new f());
            d0.d(new C0191a());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String f(Class<?> cls) {
            String Z;
            String a02;
            String a03;
            String simpleName = cls.getSimpleName();
            Method enclosingMethod = cls.getEnclosingMethod();
            if (enclosingMethod != null) {
                y8.k.d(simpleName, "name");
                a03 = mb.s.a0(simpleName, enclosingMethod.getName() + "$", null, 2, null);
                return a03;
            }
            Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
            y8.k.d(simpleName, "name");
            if (enclosingConstructor == null) {
                Z = mb.s.Z(simpleName, '$', null, 2, null);
                return Z;
            }
            a02 = mb.s.a0(simpleName, enclosingConstructor.getName() + "$", null, 2, null);
            return a02;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<h9.f<?>> j() {
            return (Collection) this.f10552g.c(this, f10548m[11]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<h9.f<?>> l() {
            return (Collection) this.f10553h.c(this, f10548m[12]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<h9.f<?>> m() {
            return (Collection) this.f10554i.c(this, f10548m[13]);
        }

        public final Collection<h9.f<?>> g() {
            return (Collection) this.f10555j.c(this, f10548m[14]);
        }

        public final Collection<h9.f<?>> h() {
            return (Collection) this.f10556k.c(this, f10548m[15]);
        }

        public final Collection<h9.f<?>> i() {
            return (Collection) this.f10551f.c(this, f10548m[10]);
        }

        public final n9.e k() {
            return (n9.e) this.f10549d.c(this, f10548m[0]);
        }

        public final String n() {
            return (String) this.f10550e.c(this, f10548m[3]);
        }
    }

    /* loaded from: classes.dex */
    static final class b extends y8.l implements x8.a<h<T>.a> {
        b() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final h<T>.a b() {
            return new a();
        }
    }

    /* loaded from: classes.dex */
    static final /* synthetic */ class c extends y8.i implements x8.p<xa.u, ga.n, p0> {

        /* renamed from: o, reason: collision with root package name */
        public static final c f10580o = new c();

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

    public h(Class<T> cls) {
        y8.k.e(cls, "jClass");
        this.f10547j = cls;
        d0.b<h<T>.a> b10 = d0.b(new b());
        y8.k.d(b10, "ReflectProperties.lazy { Data() }");
        this.f10546i = b10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final la.a A() {
        return h0.f10582b.c(b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Void F() {
        fa.a a10;
        r9.f a11 = r9.f.f13808c.a(b());
        a.EnumC0166a c10 = (a11 == null || (a10 = a11.a()) == null) ? null : a10.c();
        if (c10 != null) {
            switch (i.f10583a[c10.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    throw new UnsupportedOperationException("Packages and file facades are not yet supported in Kotlin reflection. Meanwhile please use Java reflection to inspect this class: " + b());
                case 4:
                    throw new UnsupportedOperationException("This class is an internal synthetic class generated by the Kotlin compiler, such as an anonymous class for a lambda, a SAM wrapper, a callable reference, etc. It's not a Kotlin class or interface, so the reflection library has no idea what declarations does it have. Please use Java reflection to inspect this class: " + b());
                case 5:
                    throw new b0("Unknown class: " + b() + " (kind = " + c10 + ')');
                case 6:
                    break;
                default:
                    throw new l8.l();
            }
        }
        throw new b0("Unresolved class: " + b());
    }

    public final d0.b<h<T>.a> B() {
        return this.f10546i;
    }

    public n9.e C() {
        return this.f10546i.b().k();
    }

    public final ua.h D() {
        return C().s().A();
    }

    public final ua.h E() {
        ua.h x02 = C().x0();
        y8.k.d(x02, "descriptor.staticScope");
        return x02;
    }

    @Override // e9.b
    public String a() {
        return this.f10546i.b().n();
    }

    @Override // y8.d
    public Class<T> b() {
        return this.f10547j;
    }

    public boolean equals(Object obj) {
        return (obj instanceof h) && y8.k.a(w8.a.c(this), w8.a.c((e9.b) obj));
    }

    public int hashCode() {
        return w8.a.c(this).hashCode();
    }

    @Override // h9.j
    public Collection<n9.l> l() {
        List d10;
        n9.e C = C();
        if (C.r() == n9.f.INTERFACE || C.r() == n9.f.OBJECT) {
            d10 = m8.q.d();
            return d10;
        }
        Collection<n9.d> q10 = C.q();
        y8.k.d(q10, "descriptor.constructors");
        return q10;
    }

    @Override // h9.j
    public Collection<n9.x> m(la.e eVar) {
        List a02;
        y8.k.e(eVar, "name");
        ua.h D = D();
        u9.d dVar = u9.d.FROM_REFLECTION;
        a02 = m8.y.a0(D.b(eVar, dVar), E().b(eVar, dVar));
        return a02;
    }

    @Override // h9.j
    public p0 n(int i10) {
        Class<?> declaringClass;
        if (y8.k.a(b().getSimpleName(), "DefaultImpls") && (declaringClass = b().getDeclaringClass()) != null && declaringClass.isInterface()) {
            e9.b e10 = w8.a.e(declaringClass);
            Objects.requireNonNull(e10, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
            return ((h) e10).n(i10);
        }
        n9.e C = C();
        if (!(C instanceof za.d)) {
            C = null;
        }
        za.d dVar = (za.d) C;
        if (dVar == null) {
            return null;
        }
        ga.c i12 = dVar.i1();
        i.f<ga.c, List<ga.n>> fVar = ja.a.f10982j;
        y8.k.d(fVar, "JvmProtoBuf.classLocalVariable");
        ga.n nVar = (ga.n) ia.e.b(i12, fVar, i10);
        if (nVar != null) {
            return (p0) k0.e(b(), nVar, dVar.h1().g(), dVar.h1().j(), dVar.k1(), c.f10580o);
        }
        return null;
    }

    @Override // h9.j
    public Collection<p0> q(la.e eVar) {
        List a02;
        y8.k.e(eVar, "name");
        ua.h D = D();
        u9.d dVar = u9.d.FROM_REFLECTION;
        a02 = m8.y.a0(D.a(eVar, dVar), E().a(eVar, dVar));
        return a02;
    }

    public String toString() {
        String str;
        String t10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("class ");
        la.a A = A();
        la.b h10 = A.h();
        y8.k.d(h10, "classId.packageFqName");
        if (h10.d()) {
            str = "";
        } else {
            str = h10.b() + ".";
        }
        String b10 = A.i().b();
        y8.k.d(b10, "classId.relativeClassName.asString()");
        t10 = mb.r.t(b10, '.', '$', false, 4, null);
        sb2.append(str + t10);
        return sb2.toString();
    }
}
