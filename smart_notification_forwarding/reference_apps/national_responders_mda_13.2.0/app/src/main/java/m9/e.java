package m9;

import ab.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import k9.k;
import kotlin.reflect.KProperty;
import m8.o;
import m8.p;
import m8.q0;
import m8.r0;
import n9.a0;
import n9.d0;
import n9.g0;
import n9.m;
import n9.v0;
import x8.l;
import y8.t;
import y8.w;

/* loaded from: classes.dex */
public final class e implements o9.b {

    /* renamed from: d, reason: collision with root package name */
    public static final b f12072d = new b(null);

    /* renamed from: e, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f12073e = {w.g(new t(w.b(e.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};

    /* renamed from: f, reason: collision with root package name */
    private static final la.b f12074f = k.f11246l;

    /* renamed from: g, reason: collision with root package name */
    private static final la.e f12075g;

    /* renamed from: h, reason: collision with root package name */
    private static final la.a f12076h;

    /* renamed from: a, reason: collision with root package name */
    private final d0 f12077a;

    /* renamed from: b, reason: collision with root package name */
    private final l<d0, m> f12078b;

    /* renamed from: c, reason: collision with root package name */
    private final ab.i f12079c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends y8.l implements l<d0, k9.b> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f12080f = new a();

        a() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final k9.b h(d0 d0Var) {
            y8.k.e(d0Var, "module");
            List<g0> f02 = d0Var.C(e.f12074f).f0();
            ArrayList arrayList = new ArrayList();
            for (Object obj : f02) {
                if (obj instanceof k9.b) {
                    arrayList.add(obj);
                }
            }
            return (k9.b) o.H(arrayList);
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(y8.g gVar) {
            this();
        }

        public final la.a a() {
            return e.f12076h;
        }
    }

    /* loaded from: classes.dex */
    static final class c extends y8.l implements x8.a<p9.h> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ n f12082g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(n nVar) {
            super(0);
            this.f12082g = nVar;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final p9.h b() {
            List b10;
            Set<n9.d> b11;
            m mVar = (m) e.this.f12078b.h(e.this.f12077a);
            la.e eVar = e.f12075g;
            a0 a0Var = a0.ABSTRACT;
            n9.f fVar = n9.f.INTERFACE;
            b10 = p.b(e.this.f12077a.w().i());
            p9.h hVar = new p9.h(mVar, eVar, a0Var, fVar, b10, v0.f12324a, false, this.f12082g);
            m9.a aVar = new m9.a(this.f12082g, hVar);
            b11 = r0.b();
            hVar.V0(aVar, b11, null);
            return hVar;
        }
    }

    static {
        la.c cVar = k.a.f11257d;
        la.e i10 = cVar.i();
        y8.k.d(i10, "cloneable.shortName()");
        f12075g = i10;
        la.a m10 = la.a.m(cVar.l());
        y8.k.d(m10, "topLevel(StandardNames.FqNames.cloneable.toSafe())");
        f12076h = m10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(n nVar, d0 d0Var, l<? super d0, ? extends m> lVar) {
        y8.k.e(nVar, "storageManager");
        y8.k.e(d0Var, "moduleDescriptor");
        y8.k.e(lVar, "computeContainingDeclaration");
        this.f12077a = d0Var;
        this.f12078b = lVar;
        this.f12079c = nVar.a(new c(nVar));
    }

    public /* synthetic */ e(n nVar, d0 d0Var, l lVar, int i10, y8.g gVar) {
        this(nVar, d0Var, (i10 & 4) != 0 ? a.f12080f : lVar);
    }

    private final p9.h i() {
        return (p9.h) ab.m.a(this.f12079c, this, f12073e[0]);
    }

    @Override // o9.b
    public boolean a(la.b bVar, la.e eVar) {
        y8.k.e(bVar, "packageFqName");
        y8.k.e(eVar, "name");
        return y8.k.a(eVar, f12075g) && y8.k.a(bVar, f12074f);
    }

    @Override // o9.b
    public n9.e b(la.a aVar) {
        y8.k.e(aVar, "classId");
        if (y8.k.a(aVar, f12072d.a())) {
            return i();
        }
        return null;
    }

    @Override // o9.b
    public Collection<n9.e> c(la.b bVar) {
        Set b10;
        Set a10;
        y8.k.e(bVar, "packageFqName");
        if (y8.k.a(bVar, f12074f)) {
            a10 = q0.a(i());
            return a10;
        }
        b10 = r0.b();
        return b10;
    }
}
