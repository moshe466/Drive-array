package za;

import ga.r;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.protobuf.q;
import kotlin.reflect.jvm.internal.impl.protobuf.s;
import m8.k0;
import m8.l0;
import m8.s0;
import m8.y;
import n9.p0;
import n9.u0;
import n9.z0;
import ua.d;
import xa.u;
import xa.v;
import y8.t;
import y8.w;

/* loaded from: classes.dex */
public abstract class h extends ua.i {

    /* renamed from: f, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f16424f = {w.g(new t(w.b(h.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;")), w.g(new t(w.b(h.class), "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;"))};

    /* renamed from: b, reason: collision with root package name */
    private final xa.l f16425b;

    /* renamed from: c, reason: collision with root package name */
    private final a f16426c;

    /* renamed from: d, reason: collision with root package name */
    private final ab.i f16427d;

    /* renamed from: e, reason: collision with root package name */
    private final ab.j f16428e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface a {
        Collection<p0> a(la.e eVar, u9.b bVar);

        Collection<u0> b(la.e eVar, u9.b bVar);

        Set<la.e> c();

        Set<la.e> d();

        void e(Collection<n9.m> collection, ua.d dVar, x8.l<? super la.e, Boolean> lVar, u9.b bVar);

        z0 f(la.e eVar);

        Set<la.e> g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b implements a {

        /* renamed from: o, reason: collision with root package name */
        static final /* synthetic */ KProperty<Object>[] f16429o = {w.g(new t(w.b(b.class), "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;")), w.g(new t(w.b(b.class), "declaredProperties", "getDeclaredProperties()Ljava/util/List;")), w.g(new t(w.b(b.class), "allTypeAliases", "getAllTypeAliases()Ljava/util/List;")), w.g(new t(w.b(b.class), "allFunctions", "getAllFunctions()Ljava/util/List;")), w.g(new t(w.b(b.class), "allProperties", "getAllProperties()Ljava/util/List;")), w.g(new t(w.b(b.class), "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;")), w.g(new t(w.b(b.class), "functionsByName", "getFunctionsByName()Ljava/util/Map;")), w.g(new t(w.b(b.class), "propertiesByName", "getPropertiesByName()Ljava/util/Map;")), w.g(new t(w.b(b.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), w.g(new t(w.b(b.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};

        /* renamed from: a, reason: collision with root package name */
        private final List<ga.i> f16430a;

        /* renamed from: b, reason: collision with root package name */
        private final List<ga.n> f16431b;

        /* renamed from: c, reason: collision with root package name */
        private final List<r> f16432c;

        /* renamed from: d, reason: collision with root package name */
        private final ab.i f16433d;

        /* renamed from: e, reason: collision with root package name */
        private final ab.i f16434e;

        /* renamed from: f, reason: collision with root package name */
        private final ab.i f16435f;

        /* renamed from: g, reason: collision with root package name */
        private final ab.i f16436g;

        /* renamed from: h, reason: collision with root package name */
        private final ab.i f16437h;

        /* renamed from: i, reason: collision with root package name */
        private final ab.i f16438i;

        /* renamed from: j, reason: collision with root package name */
        private final ab.i f16439j;

        /* renamed from: k, reason: collision with root package name */
        private final ab.i f16440k;

        /* renamed from: l, reason: collision with root package name */
        private final ab.i f16441l;

        /* renamed from: m, reason: collision with root package name */
        private final ab.i f16442m;

        /* renamed from: n, reason: collision with root package name */
        final /* synthetic */ h f16443n;

        /* loaded from: classes.dex */
        static final class a extends y8.l implements x8.a<List<? extends u0>> {
            a() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final List<u0> b() {
                List<u0> a02;
                a02 = y.a0(b.this.D(), b.this.t());
                return a02;
            }
        }

        /* renamed from: za.h$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class C0353b extends y8.l implements x8.a<List<? extends p0>> {
            C0353b() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final List<p0> b() {
                List<p0> a02;
                a02 = y.a0(b.this.E(), b.this.u());
                return a02;
            }
        }

        /* loaded from: classes.dex */
        static final class c extends y8.l implements x8.a<List<? extends z0>> {
            c() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final List<z0> b() {
                return b.this.z();
            }
        }

        /* loaded from: classes.dex */
        static final class d extends y8.l implements x8.a<List<? extends u0>> {
            d() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final List<u0> b() {
                return b.this.v();
            }
        }

        /* loaded from: classes.dex */
        static final class e extends y8.l implements x8.a<List<? extends p0>> {
            e() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final List<p0> b() {
                return b.this.y();
            }
        }

        /* loaded from: classes.dex */
        static final class f extends y8.l implements x8.a<Set<? extends la.e>> {

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ h f16450g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            f(h hVar) {
                super(0);
                this.f16450g = hVar;
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Set<la.e> b() {
                Set<la.e> g10;
                b bVar = b.this;
                List list = bVar.f16430a;
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                h hVar = bVar.f16443n;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    linkedHashSet.add(v.b(hVar.f16425b.g(), ((ga.i) ((q) it.next())).X()));
                }
                g10 = s0.g(linkedHashSet, this.f16450g.u());
                return g10;
            }
        }

        /* loaded from: classes.dex */
        static final class g extends y8.l implements x8.a<Map<la.e, ? extends List<? extends u0>>> {
            g() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Map<la.e, List<u0>> b() {
                List A = b.this.A();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : A) {
                    la.e c10 = ((u0) obj).c();
                    y8.k.d(c10, "it.name");
                    Object obj2 = linkedHashMap.get(c10);
                    if (obj2 == null) {
                        obj2 = new ArrayList();
                        linkedHashMap.put(c10, obj2);
                    }
                    ((List) obj2).add(obj);
                }
                return linkedHashMap;
            }
        }

        /* renamed from: za.h$b$h, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class C0354h extends y8.l implements x8.a<Map<la.e, ? extends List<? extends p0>>> {
            C0354h() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Map<la.e, List<p0>> b() {
                List B = b.this.B();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : B) {
                    la.e c10 = ((p0) obj).c();
                    y8.k.d(c10, "it.name");
                    Object obj2 = linkedHashMap.get(c10);
                    if (obj2 == null) {
                        obj2 = new ArrayList();
                        linkedHashMap.put(c10, obj2);
                    }
                    ((List) obj2).add(obj);
                }
                return linkedHashMap;
            }
        }

        /* loaded from: classes.dex */
        static final class i extends y8.l implements x8.a<Map<la.e, ? extends z0>> {
            i() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Map<la.e, z0> b() {
                int n10;
                int d10;
                int a10;
                List C = b.this.C();
                n10 = m8.r.n(C, 10);
                d10 = k0.d(n10);
                a10 = d9.f.a(d10, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(a10);
                for (Object obj : C) {
                    la.e c10 = ((z0) obj).c();
                    y8.k.d(c10, "it.name");
                    linkedHashMap.put(c10, obj);
                }
                return linkedHashMap;
            }
        }

        /* loaded from: classes.dex */
        static final class j extends y8.l implements x8.a<Set<? extends la.e>> {

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ h f16455g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            j(h hVar) {
                super(0);
                this.f16455g = hVar;
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Set<la.e> b() {
                Set<la.e> g10;
                b bVar = b.this;
                List list = bVar.f16431b;
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                h hVar = bVar.f16443n;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    linkedHashSet.add(v.b(hVar.f16425b.g(), ((ga.n) ((q) it.next())).W()));
                }
                g10 = s0.g(linkedHashSet, this.f16455g.v());
                return g10;
            }
        }

        public b(h hVar, List<ga.i> list, List<ga.n> list2, List<r> list3) {
            y8.k.e(hVar, "this$0");
            y8.k.e(list, "functionList");
            y8.k.e(list2, "propertyList");
            y8.k.e(list3, "typeAliasList");
            this.f16443n = hVar;
            this.f16430a = list;
            this.f16431b = list2;
            this.f16432c = hVar.q().c().g().d() ? list3 : m8.q.d();
            this.f16433d = hVar.q().h().a(new d());
            this.f16434e = hVar.q().h().a(new e());
            this.f16435f = hVar.q().h().a(new c());
            this.f16436g = hVar.q().h().a(new a());
            this.f16437h = hVar.q().h().a(new C0353b());
            this.f16438i = hVar.q().h().a(new i());
            this.f16439j = hVar.q().h().a(new g());
            this.f16440k = hVar.q().h().a(new C0354h());
            this.f16441l = hVar.q().h().a(new f(hVar));
            this.f16442m = hVar.q().h().a(new j(hVar));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<u0> A() {
            return (List) ab.m.a(this.f16436g, this, f16429o[3]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<p0> B() {
            return (List) ab.m.a(this.f16437h, this, f16429o[4]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<z0> C() {
            return (List) ab.m.a(this.f16435f, this, f16429o[2]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<u0> D() {
            return (List) ab.m.a(this.f16433d, this, f16429o[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<p0> E() {
            return (List) ab.m.a(this.f16434e, this, f16429o[1]);
        }

        private final Map<la.e, Collection<u0>> F() {
            return (Map) ab.m.a(this.f16439j, this, f16429o[6]);
        }

        private final Map<la.e, Collection<p0>> G() {
            return (Map) ab.m.a(this.f16440k, this, f16429o[7]);
        }

        private final Map<la.e, z0> H() {
            return (Map) ab.m.a(this.f16438i, this, f16429o[5]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<u0> t() {
            Set<la.e> u10 = this.f16443n.u();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = u10.iterator();
            while (it.hasNext()) {
                m8.v.r(arrayList, w((la.e) it.next()));
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<p0> u() {
            Set<la.e> v10 = this.f16443n.v();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = v10.iterator();
            while (it.hasNext()) {
                m8.v.r(arrayList, x((la.e) it.next()));
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<u0> v() {
            List<ga.i> list = this.f16430a;
            h hVar = this.f16443n;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                u0 n10 = hVar.f16425b.f().n((ga.i) ((q) it.next()));
                if (!hVar.y(n10)) {
                    n10 = null;
                }
                if (n10 != null) {
                    arrayList.add(n10);
                }
            }
            return arrayList;
        }

        private final List<u0> w(la.e eVar) {
            List<u0> D = D();
            h hVar = this.f16443n;
            ArrayList arrayList = new ArrayList();
            for (Object obj : D) {
                if (y8.k.a(((n9.m) obj).c(), eVar)) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            hVar.l(eVar, arrayList);
            return arrayList.subList(size, arrayList.size());
        }

        private final List<p0> x(la.e eVar) {
            List<p0> E = E();
            h hVar = this.f16443n;
            ArrayList arrayList = new ArrayList();
            for (Object obj : E) {
                if (y8.k.a(((n9.m) obj).c(), eVar)) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            hVar.m(eVar, arrayList);
            return arrayList.subList(size, arrayList.size());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<p0> y() {
            List<ga.n> list = this.f16431b;
            h hVar = this.f16443n;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                p0 p10 = hVar.f16425b.f().p((ga.n) ((q) it.next()));
                if (p10 != null) {
                    arrayList.add(p10);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<z0> z() {
            List<r> list = this.f16432c;
            h hVar = this.f16443n;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                z0 q10 = hVar.f16425b.f().q((r) ((q) it.next()));
                if (q10 != null) {
                    arrayList.add(q10);
                }
            }
            return arrayList;
        }

        @Override // za.h.a
        public Collection<p0> a(la.e eVar, u9.b bVar) {
            List d10;
            List d11;
            y8.k.e(eVar, "name");
            y8.k.e(bVar, "location");
            if (!d().contains(eVar)) {
                d11 = m8.q.d();
                return d11;
            }
            Collection<p0> collection = G().get(eVar);
            if (collection != null) {
                return collection;
            }
            d10 = m8.q.d();
            return d10;
        }

        @Override // za.h.a
        public Collection<u0> b(la.e eVar, u9.b bVar) {
            List d10;
            List d11;
            y8.k.e(eVar, "name");
            y8.k.e(bVar, "location");
            if (!c().contains(eVar)) {
                d11 = m8.q.d();
                return d11;
            }
            Collection<u0> collection = F().get(eVar);
            if (collection != null) {
                return collection;
            }
            d10 = m8.q.d();
            return d10;
        }

        @Override // za.h.a
        public Set<la.e> c() {
            return (Set) ab.m.a(this.f16441l, this, f16429o[8]);
        }

        @Override // za.h.a
        public Set<la.e> d() {
            return (Set) ab.m.a(this.f16442m, this, f16429o[9]);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // za.h.a
        public void e(Collection<n9.m> collection, ua.d dVar, x8.l<? super la.e, Boolean> lVar, u9.b bVar) {
            y8.k.e(collection, "result");
            y8.k.e(dVar, "kindFilter");
            y8.k.e(lVar, "nameFilter");
            y8.k.e(bVar, "location");
            if (dVar.a(ua.d.f14505c.k())) {
                for (Object obj : B()) {
                    la.e c10 = ((p0) obj).c();
                    y8.k.d(c10, "it.name");
                    if (lVar.h(c10).booleanValue()) {
                        collection.add(obj);
                    }
                }
            }
            if (dVar.a(ua.d.f14505c.e())) {
                for (Object obj2 : A()) {
                    la.e c11 = ((u0) obj2).c();
                    y8.k.d(c11, "it.name");
                    if (lVar.h(c11).booleanValue()) {
                        collection.add(obj2);
                    }
                }
            }
        }

        @Override // za.h.a
        public z0 f(la.e eVar) {
            y8.k.e(eVar, "name");
            return H().get(eVar);
        }

        @Override // za.h.a
        public Set<la.e> g() {
            List<r> list = this.f16432c;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            h hVar = this.f16443n;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(v.b(hVar.f16425b.g(), ((r) ((q) it.next())).Y()));
            }
            return linkedHashSet;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class c implements a {

        /* renamed from: j, reason: collision with root package name */
        static final /* synthetic */ KProperty<Object>[] f16456j = {w.g(new t(w.b(c.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), w.g(new t(w.b(c.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};

        /* renamed from: a, reason: collision with root package name */
        private final Map<la.e, byte[]> f16457a;

        /* renamed from: b, reason: collision with root package name */
        private final Map<la.e, byte[]> f16458b;

        /* renamed from: c, reason: collision with root package name */
        private final Map<la.e, byte[]> f16459c;

        /* renamed from: d, reason: collision with root package name */
        private final ab.g<la.e, Collection<u0>> f16460d;

        /* renamed from: e, reason: collision with root package name */
        private final ab.g<la.e, Collection<p0>> f16461e;

        /* renamed from: f, reason: collision with root package name */
        private final ab.h<la.e, z0> f16462f;

        /* renamed from: g, reason: collision with root package name */
        private final ab.i f16463g;

        /* renamed from: h, reason: collision with root package name */
        private final ab.i f16464h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ h f16465i;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX INFO: Add missing generic type declarations: [M] */
        /* loaded from: classes.dex */
        public static final class a<M> extends y8.l implements x8.a<M> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ s<M> f16466f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ ByteArrayInputStream f16467g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ h f16468h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(s<M> sVar, ByteArrayInputStream byteArrayInputStream, h hVar) {
                super(0);
                this.f16466f = sVar;
                this.f16467g = byteArrayInputStream;
                this.f16468h = hVar;
            }

            /* JADX WARN: Incorrect return type in method signature: ()TM; */
            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final q b() {
                return (q) this.f16466f.a(this.f16467g, this.f16468h.q().c().j());
            }
        }

        /* loaded from: classes.dex */
        static final class b extends y8.l implements x8.a<Set<? extends la.e>> {

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ h f16470g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(h hVar) {
                super(0);
                this.f16470g = hVar;
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Set<la.e> b() {
                Set<la.e> g10;
                g10 = s0.g(c.this.f16457a.keySet(), this.f16470g.u());
                return g10;
            }
        }

        /* renamed from: za.h$c$c, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class C0355c extends y8.l implements x8.l<la.e, Collection<? extends u0>> {
            C0355c() {
                super(1);
            }

            @Override // x8.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Collection<u0> h(la.e eVar) {
                y8.k.e(eVar, "it");
                return c.this.m(eVar);
            }
        }

        /* loaded from: classes.dex */
        static final class d extends y8.l implements x8.l<la.e, Collection<? extends p0>> {
            d() {
                super(1);
            }

            @Override // x8.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Collection<p0> h(la.e eVar) {
                y8.k.e(eVar, "it");
                return c.this.n(eVar);
            }
        }

        /* loaded from: classes.dex */
        static final class e extends y8.l implements x8.l<la.e, z0> {
            e() {
                super(1);
            }

            @Override // x8.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final z0 h(la.e eVar) {
                y8.k.e(eVar, "it");
                return c.this.o(eVar);
            }
        }

        /* loaded from: classes.dex */
        static final class f extends y8.l implements x8.a<Set<? extends la.e>> {

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ h f16475g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            f(h hVar) {
                super(0);
                this.f16475g = hVar;
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Set<la.e> b() {
                Set<la.e> g10;
                g10 = s0.g(c.this.f16458b.keySet(), this.f16475g.v());
                return g10;
            }
        }

        public c(h hVar, List<ga.i> list, List<ga.n> list2, List<r> list3) {
            Map<la.e, byte[]> h10;
            y8.k.e(hVar, "this$0");
            y8.k.e(list, "functionList");
            y8.k.e(list2, "propertyList");
            y8.k.e(list3, "typeAliasList");
            this.f16465i = hVar;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : list) {
                la.e b10 = v.b(hVar.f16425b.g(), ((ga.i) ((q) obj)).X());
                Object obj2 = linkedHashMap.get(b10);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap.put(b10, obj2);
                }
                ((List) obj2).add(obj);
            }
            this.f16457a = p(linkedHashMap);
            h hVar2 = this.f16465i;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj3 : list2) {
                la.e b11 = v.b(hVar2.f16425b.g(), ((ga.n) ((q) obj3)).W());
                Object obj4 = linkedHashMap2.get(b11);
                if (obj4 == null) {
                    obj4 = new ArrayList();
                    linkedHashMap2.put(b11, obj4);
                }
                ((List) obj4).add(obj3);
            }
            this.f16458b = p(linkedHashMap2);
            if (this.f16465i.q().c().g().d()) {
                h hVar3 = this.f16465i;
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                for (Object obj5 : list3) {
                    la.e b12 = v.b(hVar3.f16425b.g(), ((r) ((q) obj5)).Y());
                    Object obj6 = linkedHashMap3.get(b12);
                    if (obj6 == null) {
                        obj6 = new ArrayList();
                        linkedHashMap3.put(b12, obj6);
                    }
                    ((List) obj6).add(obj5);
                }
                h10 = p(linkedHashMap3);
            } else {
                h10 = l0.h();
            }
            this.f16459c = h10;
            this.f16460d = this.f16465i.q().h().i(new C0355c());
            this.f16461e = this.f16465i.q().h().i(new d());
            this.f16462f = this.f16465i.q().h().c(new e());
            this.f16463g = this.f16465i.q().h().a(new b(this.f16465i));
            this.f16464h = this.f16465i.q().h().a(new f(this.f16465i));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<u0> m(la.e eVar) {
            lb.h g10;
            List<ga.i> w10;
            Map<la.e, byte[]> map = this.f16457a;
            s<ga.i> sVar = ga.i.f10069x;
            y8.k.d(sVar, "PARSER");
            h hVar = this.f16465i;
            byte[] bArr = map.get(eVar);
            if (bArr == null) {
                w10 = null;
            } else {
                g10 = lb.l.g(new a(sVar, new ByteArrayInputStream(bArr), this.f16465i));
                w10 = lb.n.w(g10);
            }
            if (w10 == null) {
                w10 = m8.q.d();
            }
            ArrayList arrayList = new ArrayList(w10.size());
            for (ga.i iVar : w10) {
                u f10 = hVar.q().f();
                y8.k.d(iVar, "it");
                u0 n10 = f10.n(iVar);
                if (!hVar.y(n10)) {
                    n10 = null;
                }
                if (n10 != null) {
                    arrayList.add(n10);
                }
            }
            hVar.l(eVar, arrayList);
            return jb.a.c(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<p0> n(la.e eVar) {
            lb.h g10;
            List<ga.n> w10;
            Map<la.e, byte[]> map = this.f16458b;
            s<ga.n> sVar = ga.n.f10132x;
            y8.k.d(sVar, "PARSER");
            h hVar = this.f16465i;
            byte[] bArr = map.get(eVar);
            if (bArr == null) {
                w10 = null;
            } else {
                g10 = lb.l.g(new a(sVar, new ByteArrayInputStream(bArr), this.f16465i));
                w10 = lb.n.w(g10);
            }
            if (w10 == null) {
                w10 = m8.q.d();
            }
            ArrayList arrayList = new ArrayList(w10.size());
            for (ga.n nVar : w10) {
                u f10 = hVar.q().f();
                y8.k.d(nVar, "it");
                p0 p10 = f10.p(nVar);
                if (p10 != null) {
                    arrayList.add(p10);
                }
            }
            hVar.m(eVar, arrayList);
            return jb.a.c(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final z0 o(la.e eVar) {
            r p02;
            byte[] bArr = this.f16459c.get(eVar);
            if (bArr == null || (p02 = r.p0(new ByteArrayInputStream(bArr), this.f16465i.q().c().j())) == null) {
                return null;
            }
            return this.f16465i.q().f().q(p02);
        }

        private final Map<la.e, byte[]> p(Map<la.e, ? extends Collection<? extends kotlin.reflect.jvm.internal.impl.protobuf.a>> map) {
            int d10;
            int n10;
            d10 = k0.d(map.size());
            LinkedHashMap linkedHashMap = new LinkedHashMap(d10);
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Iterable iterable = (Iterable) entry.getValue();
                n10 = m8.r.n(iterable, 10);
                ArrayList arrayList = new ArrayList(n10);
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    ((kotlin.reflect.jvm.internal.impl.protobuf.a) it2.next()).g(byteArrayOutputStream);
                    arrayList.add(l8.w.f11824a);
                }
                linkedHashMap.put(key, byteArrayOutputStream.toByteArray());
            }
            return linkedHashMap;
        }

        @Override // za.h.a
        public Collection<p0> a(la.e eVar, u9.b bVar) {
            List d10;
            y8.k.e(eVar, "name");
            y8.k.e(bVar, "location");
            if (d().contains(eVar)) {
                return this.f16461e.h(eVar);
            }
            d10 = m8.q.d();
            return d10;
        }

        @Override // za.h.a
        public Collection<u0> b(la.e eVar, u9.b bVar) {
            List d10;
            y8.k.e(eVar, "name");
            y8.k.e(bVar, "location");
            if (c().contains(eVar)) {
                return this.f16460d.h(eVar);
            }
            d10 = m8.q.d();
            return d10;
        }

        @Override // za.h.a
        public Set<la.e> c() {
            return (Set) ab.m.a(this.f16463g, this, f16456j[0]);
        }

        @Override // za.h.a
        public Set<la.e> d() {
            return (Set) ab.m.a(this.f16464h, this, f16456j[1]);
        }

        @Override // za.h.a
        public void e(Collection<n9.m> collection, ua.d dVar, x8.l<? super la.e, Boolean> lVar, u9.b bVar) {
            y8.k.e(collection, "result");
            y8.k.e(dVar, "kindFilter");
            y8.k.e(lVar, "nameFilter");
            y8.k.e(bVar, "location");
            if (dVar.a(ua.d.f14505c.k())) {
                Set<la.e> d10 = d();
                ArrayList arrayList = new ArrayList();
                for (la.e eVar : d10) {
                    if (lVar.h(eVar).booleanValue()) {
                        arrayList.addAll(a(eVar, bVar));
                    }
                }
                na.g gVar = na.g.f12339a;
                y8.k.d(gVar, "INSTANCE");
                m8.u.q(arrayList, gVar);
                collection.addAll(arrayList);
            }
            if (dVar.a(ua.d.f14505c.e())) {
                Set<la.e> c10 = c();
                ArrayList arrayList2 = new ArrayList();
                for (la.e eVar2 : c10) {
                    if (lVar.h(eVar2).booleanValue()) {
                        arrayList2.addAll(b(eVar2, bVar));
                    }
                }
                na.g gVar2 = na.g.f12339a;
                y8.k.d(gVar2, "INSTANCE");
                m8.u.q(arrayList2, gVar2);
                collection.addAll(arrayList2);
            }
        }

        @Override // za.h.a
        public z0 f(la.e eVar) {
            y8.k.e(eVar, "name");
            return this.f16462f.h(eVar);
        }

        @Override // za.h.a
        public Set<la.e> g() {
            return this.f16459c.keySet();
        }
    }

    /* loaded from: classes.dex */
    static final class d extends y8.l implements x8.a<Set<? extends la.e>> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ x8.a<Collection<la.e>> f16476f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(x8.a<? extends Collection<la.e>> aVar) {
            super(0);
            this.f16476f = aVar;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Set<la.e> b() {
            Set<la.e> r02;
            r02 = y.r0(this.f16476f.b());
            return r02;
        }
    }

    /* loaded from: classes.dex */
    static final class e extends y8.l implements x8.a<Set<? extends la.e>> {
        e() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Set<la.e> b() {
            Set g10;
            Set<la.e> g11;
            Set<la.e> t10 = h.this.t();
            if (t10 == null) {
                return null;
            }
            g10 = s0.g(h.this.r(), h.this.f16426c.g());
            g11 = s0.g(g10, t10);
            return g11;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(xa.l lVar, List<ga.i> list, List<ga.n> list2, List<r> list3, x8.a<? extends Collection<la.e>> aVar) {
        y8.k.e(lVar, "c");
        y8.k.e(list, "functionList");
        y8.k.e(list2, "propertyList");
        y8.k.e(list3, "typeAliasList");
        y8.k.e(aVar, "classNames");
        this.f16425b = lVar;
        this.f16426c = o(list, list2, list3);
        this.f16427d = lVar.h().a(new d(aVar));
        this.f16428e = lVar.h().h(new e());
    }

    private final a o(List<ga.i> list, List<ga.n> list2, List<r> list3) {
        return this.f16425b.c().g().a() ? new b(this, list, list2, list3) : new c(this, list, list2, list3);
    }

    private final n9.e p(la.e eVar) {
        return this.f16425b.c().b(n(eVar));
    }

    private final Set<la.e> s() {
        return (Set) ab.m.b(this.f16428e, this, f16424f[1]);
    }

    private final z0 w(la.e eVar) {
        return this.f16426c.f(eVar);
    }

    @Override // ua.i, ua.h
    public Collection<p0> a(la.e eVar, u9.b bVar) {
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        return this.f16426c.a(eVar, bVar);
    }

    @Override // ua.i, ua.h
    public Collection<u0> b(la.e eVar, u9.b bVar) {
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        return this.f16426c.b(eVar, bVar);
    }

    @Override // ua.i, ua.h
    public Set<la.e> c() {
        return this.f16426c.c();
    }

    @Override // ua.i, ua.h
    public Set<la.e> d() {
        return this.f16426c.d();
    }

    @Override // ua.i, ua.h
    public Set<la.e> f() {
        return s();
    }

    @Override // ua.i, ua.k
    public n9.h g(la.e eVar, u9.b bVar) {
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        if (x(eVar)) {
            return p(eVar);
        }
        if (this.f16426c.g().contains(eVar)) {
            return w(eVar);
        }
        return null;
    }

    protected abstract void j(Collection<n9.m> collection, x8.l<? super la.e, Boolean> lVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public final Collection<n9.m> k(ua.d dVar, x8.l<? super la.e, Boolean> lVar, u9.b bVar) {
        y8.k.e(dVar, "kindFilter");
        y8.k.e(lVar, "nameFilter");
        y8.k.e(bVar, "location");
        ArrayList arrayList = new ArrayList(0);
        d.a aVar = ua.d.f14505c;
        if (dVar.a(aVar.h())) {
            j(arrayList, lVar);
        }
        this.f16426c.e(arrayList, dVar, lVar, bVar);
        if (dVar.a(aVar.d())) {
            for (la.e eVar : r()) {
                if (lVar.h(eVar).booleanValue()) {
                    jb.a.a(arrayList, p(eVar));
                }
            }
        }
        if (dVar.a(ua.d.f14505c.i())) {
            for (la.e eVar2 : this.f16426c.g()) {
                if (lVar.h(eVar2).booleanValue()) {
                    jb.a.a(arrayList, this.f16426c.f(eVar2));
                }
            }
        }
        return jb.a.c(arrayList);
    }

    protected void l(la.e eVar, List<u0> list) {
        y8.k.e(eVar, "name");
        y8.k.e(list, "functions");
    }

    protected void m(la.e eVar, List<p0> list) {
        y8.k.e(eVar, "name");
        y8.k.e(list, "descriptors");
    }

    protected abstract la.a n(la.e eVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public final xa.l q() {
        return this.f16425b;
    }

    public final Set<la.e> r() {
        return (Set) ab.m.a(this.f16427d, this, f16424f[0]);
    }

    protected abstract Set<la.e> t();

    protected abstract Set<la.e> u();

    protected abstract Set<la.e> v();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean x(la.e eVar) {
        y8.k.e(eVar, "name");
        return r().contains(eVar);
    }

    protected boolean y(u0 u0Var) {
        y8.k.e(u0Var, "function");
        return true;
    }
}
