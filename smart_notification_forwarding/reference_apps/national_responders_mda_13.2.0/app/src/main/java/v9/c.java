package v9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final jb.e f14759a;

    /* renamed from: b, reason: collision with root package name */
    private final ab.h<n9.e, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> f14760b;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c f14761a;

        /* renamed from: b, reason: collision with root package name */
        private final int f14762b;

        public a(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar, int i10) {
            y8.k.e(cVar, "typeQualifier");
            this.f14761a = cVar;
            this.f14762b = i10;
        }

        private final boolean c(v9.a aVar) {
            return ((1 << aVar.ordinal()) & this.f14762b) != 0;
        }

        private final boolean d(v9.a aVar) {
            if (c(aVar)) {
                return true;
            }
            return c(v9.a.TYPE_USE) && aVar != v9.a.TYPE_PARAMETER_BOUNDS;
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c a() {
            return this.f14761a;
        }

        public final List<v9.a> b() {
            v9.a[] valuesCustom = v9.a.valuesCustom();
            ArrayList arrayList = new ArrayList();
            for (v9.a aVar : valuesCustom) {
                if (d(aVar)) {
                    arrayList.add(aVar);
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends y8.l implements x8.p<pa.j, v9.a, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        public static final b f14763f = new b();

        b() {
            super(2);
        }

        public final boolean a(pa.j jVar, v9.a aVar) {
            y8.k.e(jVar, "<this>");
            y8.k.e(aVar, "it");
            return y8.k.a(jVar.c().n(), aVar.getJavaTarget());
        }

        @Override // x8.p
        public /* bridge */ /* synthetic */ Boolean g(pa.j jVar, v9.a aVar) {
            return Boolean.valueOf(a(jVar, aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: v9.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0305c extends y8.l implements x8.p<pa.j, v9.a, Boolean> {
        C0305c() {
            super(2);
        }

        public final boolean a(pa.j jVar, v9.a aVar) {
            y8.k.e(jVar, "<this>");
            y8.k.e(aVar, "it");
            return c.this.p(aVar.getJavaTarget()).contains(jVar.c().n());
        }

        @Override // x8.p
        public /* bridge */ /* synthetic */ Boolean g(pa.j jVar, v9.a aVar) {
            return Boolean.valueOf(a(jVar, aVar));
        }
    }

    /* loaded from: classes.dex */
    /* synthetic */ class d extends y8.i implements x8.l<n9.e, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> {
        d(c cVar) {
            super(1, cVar);
        }

        @Override // y8.c, e9.a
        public final String c() {
            return "computeTypeQualifierNickname";
        }

        @Override // y8.c
        public final e9.d k() {
            return y8.w.b(c.class);
        }

        @Override // y8.c
        public final String m() {
            return "computeTypeQualifierNickname(Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;)Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;";
        }

        @Override // x8.l
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c h(n9.e eVar) {
            y8.k.e(eVar, "p0");
            return ((c) this.f15934g).c(eVar);
        }
    }

    public c(ab.n nVar, jb.e eVar) {
        y8.k.e(nVar, "storageManager");
        y8.k.e(eVar, "javaTypeEnhancementState");
        this.f14759a = eVar;
        this.f14760b = nVar.c(new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c c(n9.e eVar) {
        if (!eVar.u().r(v9.b.g())) {
            return null;
        }
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> it = eVar.u().iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.c m10 = m(it.next());
            if (m10 != null) {
                return m10;
            }
        }
        return null;
    }

    private final List<v9.a> d(pa.g<?> gVar, x8.p<? super pa.j, ? super v9.a, Boolean> pVar) {
        List<v9.a> d10;
        v9.a aVar;
        List<v9.a> h10;
        if (gVar instanceof pa.b) {
            List<? extends pa.g<?>> b10 = ((pa.b) gVar).b();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = b10.iterator();
            while (it.hasNext()) {
                m8.v.r(arrayList, d((pa.g) it.next(), pVar));
            }
            return arrayList;
        }
        if (!(gVar instanceof pa.j)) {
            d10 = m8.q.d();
            return d10;
        }
        v9.a[] valuesCustom = v9.a.valuesCustom();
        int length = valuesCustom.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                aVar = null;
                break;
            }
            aVar = valuesCustom[i10];
            if (pVar.g(gVar, aVar).booleanValue()) {
                break;
            }
            i10++;
        }
        h10 = m8.q.h(aVar);
        return h10;
    }

    private final List<v9.a> e(pa.g<?> gVar) {
        return d(gVar, b.f14763f);
    }

    private final List<v9.a> f(pa.g<?> gVar) {
        return d(gVar, new C0305c());
    }

    private final jb.h g(n9.e eVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c e10 = eVar.u().e(v9.b.d());
        pa.g<?> b10 = e10 == null ? null : ra.a.b(e10);
        pa.j jVar = b10 instanceof pa.j ? (pa.j) b10 : null;
        if (jVar == null) {
            return null;
        }
        jb.h f10 = this.f14759a.f();
        if (f10 != null) {
            return f10;
        }
        String k10 = jVar.c().k();
        int hashCode = k10.hashCode();
        if (hashCode == -2137067054) {
            if (k10.equals("IGNORE")) {
                return jb.h.IGNORE;
            }
            return null;
        }
        if (hashCode == -1838656823) {
            if (k10.equals("STRICT")) {
                return jb.h.STRICT;
            }
            return null;
        }
        if (hashCode == 2656902 && k10.equals("WARN")) {
            return jb.h.WARN;
        }
        return null;
    }

    private final jb.h i(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        return v9.b.c().containsKey(cVar.f()) ? this.f14759a.e() : j(cVar);
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c o(n9.e eVar) {
        if (eVar.r() != n9.f.ANNOTATION_CLASS) {
            return null;
        }
        return this.f14760b.h(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> p(String str) {
        int n10;
        Set<kotlin.reflect.jvm.internal.impl.descriptors.annotations.n> b10 = w9.d.f15316a.b(str);
        n10 = m8.r.n(b10, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator<T> it = b10.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.annotations.n) it.next()).name());
        }
        return arrayList;
    }

    public final a h(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        y8.k.e(cVar, "annotationDescriptor");
        n9.e f10 = ra.a.f(cVar);
        if (f10 == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u10 = f10.u();
        la.b bVar = y.f14815c;
        y8.k.d(bVar, "TARGET_ANNOTATION");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c e10 = u10.e(bVar);
        if (e10 == null) {
            return null;
        }
        Map<la.e, pa.g<?>> a10 = e10.a();
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<la.e, pa.g<?>>> it = a10.entrySet().iterator();
        while (it.hasNext()) {
            m8.v.r(arrayList, f(it.next().getValue()));
        }
        int i10 = 0;
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            i10 |= 1 << ((v9.a) it2.next()).ordinal();
        }
        return new a(cVar, i10);
    }

    public final jb.h j(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        y8.k.e(cVar, "annotationDescriptor");
        jb.h k10 = k(cVar);
        return k10 == null ? this.f14759a.d() : k10;
    }

    public final jb.h k(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        y8.k.e(cVar, "annotationDescriptor");
        Map<String, jb.h> g10 = this.f14759a.g();
        la.b f10 = cVar.f();
        jb.h hVar = g10.get(f10 == null ? null : f10.b());
        if (hVar != null) {
            return hVar;
        }
        n9.e f11 = ra.a.f(cVar);
        if (f11 == null) {
            return null;
        }
        return g(f11);
    }

    public final s l(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        s sVar;
        y8.k.e(cVar, "annotationDescriptor");
        if (this.f14759a.a() || (sVar = v9.b.a().get(cVar.f())) == null) {
            return null;
        }
        jb.h i10 = i(cVar);
        if (!(i10 != jb.h.IGNORE)) {
            i10 = null;
        }
        if (i10 == null) {
            return null;
        }
        return s.b(sVar, da.i.b(sVar.e(), null, i10.isWarning(), 1, null), null, false, 6, null);
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c m(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        n9.e f10;
        boolean b10;
        y8.k.e(cVar, "annotationDescriptor");
        if (this.f14759a.b() || (f10 = ra.a.f(cVar)) == null) {
            return null;
        }
        b10 = v9.d.b(f10);
        return b10 ? cVar : o(f10);
    }

    public final a n(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar2;
        y8.k.e(cVar, "annotationDescriptor");
        if (this.f14759a.b()) {
            return null;
        }
        n9.e f10 = ra.a.f(cVar);
        if (f10 == null || !f10.u().r(v9.b.e())) {
            f10 = null;
        }
        if (f10 == null) {
            return null;
        }
        n9.e f11 = ra.a.f(cVar);
        y8.k.b(f11);
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c e10 = f11.u().e(v9.b.e());
        y8.k.b(e10);
        Map<la.e, pa.g<?>> a10 = e10.a();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<la.e, pa.g<?>> entry : a10.entrySet()) {
            m8.v.r(arrayList, y8.k.a(entry.getKey(), y.f14814b) ? e(entry.getValue()) : m8.q.d());
        }
        Iterator it = arrayList.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 |= 1 << ((v9.a) it.next()).ordinal();
        }
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> it2 = f10.u().iterator();
        while (true) {
            if (!it2.hasNext()) {
                cVar2 = null;
                break;
            }
            cVar2 = it2.next();
            if (m(cVar2) != null) {
                break;
            }
        }
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar3 = cVar2;
        if (cVar3 == null) {
            return null;
        }
        return new a(cVar3, i10);
    }
}
