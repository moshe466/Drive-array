package z9;

import bb.b0;
import bb.h1;
import bb.i0;
import ca.o;
import ca.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.KProperty;
import l8.n;
import m8.l0;
import m8.r;
import n9.d0;
import n9.d1;
import pa.q;
import pa.s;
import v9.y;
import y8.t;
import y8.w;

/* loaded from: classes.dex */
public final class e implements kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, x9.i {

    /* renamed from: i, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f16262i = {w.g(new t(w.b(e.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), w.g(new t(w.b(e.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), w.g(new t(w.b(e.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};

    /* renamed from: a, reason: collision with root package name */
    private final y9.g f16263a;

    /* renamed from: b, reason: collision with root package name */
    private final ca.a f16264b;

    /* renamed from: c, reason: collision with root package name */
    private final ab.j f16265c;

    /* renamed from: d, reason: collision with root package name */
    private final ab.i f16266d;

    /* renamed from: e, reason: collision with root package name */
    private final ba.a f16267e;

    /* renamed from: f, reason: collision with root package name */
    private final ab.i f16268f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f16269g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f16270h;

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.a<Map<la.e, ? extends pa.g<?>>> {
        a() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map<la.e, pa.g<?>> b() {
            Map<la.e, pa.g<?>> p10;
            Collection<ca.b> G = e.this.f16264b.G();
            e eVar = e.this;
            ArrayList arrayList = new ArrayList();
            for (ca.b bVar : G) {
                la.e c10 = bVar.c();
                if (c10 == null) {
                    c10 = y.f14814b;
                }
                pa.g n10 = eVar.n(bVar);
                n a10 = n10 == null ? null : l8.t.a(c10, n10);
                if (a10 != null) {
                    arrayList.add(a10);
                }
            }
            p10 = l0.p(arrayList);
            return p10;
        }
    }

    /* loaded from: classes.dex */
    static final class b extends y8.l implements x8.a<la.b> {
        b() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la.b b() {
            la.a d10 = e.this.f16264b.d();
            if (d10 == null) {
                return null;
            }
            return d10.b();
        }
    }

    /* loaded from: classes.dex */
    static final class c extends y8.l implements x8.a<i0> {
        c() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i0 b() {
            la.b f10 = e.this.f();
            if (f10 == null) {
                return bb.t.j(y8.k.j("No fqName: ", e.this.f16264b));
            }
            n9.e h10 = m9.d.h(m9.d.f12071a, f10, e.this.f16263a.d().w(), null, 4, null);
            if (h10 == null) {
                ca.g k10 = e.this.f16264b.k();
                h10 = k10 == null ? null : e.this.f16263a.a().m().a(k10);
                if (h10 == null) {
                    h10 = e.this.h(f10);
                }
            }
            return h10.s();
        }
    }

    public e(y9.g gVar, ca.a aVar, boolean z10) {
        y8.k.e(gVar, "c");
        y8.k.e(aVar, "javaAnnotation");
        this.f16263a = gVar;
        this.f16264b = aVar;
        this.f16265c = gVar.e().h(new b());
        this.f16266d = gVar.e().a(new c());
        this.f16267e = gVar.a().s().a(aVar);
        this.f16268f = gVar.e().a(new a());
        this.f16269g = aVar.j();
        this.f16270h = aVar.U() || z10;
    }

    public /* synthetic */ e(y9.g gVar, ca.a aVar, boolean z10, int i10, y8.g gVar2) {
        this(gVar, aVar, (i10 & 4) != 0 ? false : z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n9.e h(la.b bVar) {
        d0 d10 = this.f16263a.d();
        la.a m10 = la.a.m(bVar);
        y8.k.d(m10, "topLevel(fqName)");
        return n9.w.c(d10, m10, this.f16263a.a().b().f().q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final pa.g<?> n(ca.b bVar) {
        if (bVar instanceof o) {
            return pa.h.f13329a.c(((o) bVar).getValue());
        }
        if (bVar instanceof ca.m) {
            ca.m mVar = (ca.m) bVar;
            return q(mVar.e(), mVar.a());
        }
        if (bVar instanceof ca.e) {
            la.e c10 = bVar.c();
            if (c10 == null) {
                c10 = y.f14814b;
            }
            y8.k.d(c10, "argument.name ?: DEFAULT_ANNOTATION_MEMBER_NAME");
            return p(c10, ((ca.e) bVar).d());
        }
        if (bVar instanceof ca.c) {
            return o(((ca.c) bVar).b());
        }
        if (bVar instanceof ca.h) {
            return r(((ca.h) bVar).f());
        }
        return null;
    }

    private final pa.g<?> o(ca.a aVar) {
        return new pa.a(new e(this.f16263a, aVar, false, 4, null));
    }

    private final pa.g<?> p(la.e eVar, List<? extends ca.b> list) {
        int n10;
        i0 b10 = b();
        y8.k.d(b10, "type");
        if (bb.d0.a(b10)) {
            return null;
        }
        n9.e f10 = ra.a.f(this);
        y8.k.b(f10);
        d1 b11 = w9.a.b(eVar, f10);
        b0 b12 = b11 != null ? b11.b() : null;
        if (b12 == null) {
            b12 = this.f16263a.a().l().w().l(h1.INVARIANT, bb.t.j("Unknown array element type"));
        }
        y8.k.d(b12, "DescriptorResolverUtils.getAnnotationParameterByName(argumentName, annotationClass!!)?.type\n            // Try to load annotation arguments even if the annotation class is not found\n                ?: c.components.module.builtIns.getArrayType(\n                    Variance.INVARIANT,\n                    ErrorUtils.createErrorType(\"Unknown array element type\")\n                )");
        n10 = r.n(list, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            pa.g<?> n11 = n((ca.b) it.next());
            if (n11 == null) {
                n11 = new s();
            }
            arrayList.add(n11);
        }
        return pa.h.f13329a.a(arrayList, b12);
    }

    private final pa.g<?> q(la.a aVar, la.e eVar) {
        if (aVar == null || eVar == null) {
            return null;
        }
        return new pa.j(aVar, eVar);
    }

    private final pa.g<?> r(x xVar) {
        return q.f13348b.a(this.f16263a.g().n(xVar, aa.d.f(w9.k.COMMON, false, null, 3, null)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public Map<la.e, pa.g<?>> a() {
        return (Map) ab.m.a(this.f16268f, this, f16262i[2]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public la.b f() {
        return (la.b) ab.m.b(this.f16265c, this, f16262i[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public ba.a k() {
        return this.f16267e;
    }

    @Override // x9.i
    public boolean j() {
        return this.f16269g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public i0 b() {
        return (i0) ab.m.a(this.f16266d, this, f16262i[1]);
    }

    public final boolean m() {
        return this.f16270h;
    }

    public String toString() {
        return kotlin.reflect.jvm.internal.impl.renderer.c.t(kotlin.reflect.jvm.internal.impl.renderer.c.f11499b, this, null, 2, null);
    }
}
