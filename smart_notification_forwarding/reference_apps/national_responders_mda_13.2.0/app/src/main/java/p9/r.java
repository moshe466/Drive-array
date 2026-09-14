package p9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.KProperty;
import n9.l0;
import ua.h;

/* loaded from: classes.dex */
public final class r extends j implements n9.l0 {

    /* renamed from: l, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f13289l = {y8.w.g(new y8.t(y8.w.b(r.class), "fragments", "getFragments()Ljava/util/List;"))};

    /* renamed from: h, reason: collision with root package name */
    private final x f13290h;

    /* renamed from: i, reason: collision with root package name */
    private final la.b f13291i;

    /* renamed from: j, reason: collision with root package name */
    private final ab.i f13292j;

    /* renamed from: k, reason: collision with root package name */
    private final ua.h f13293k;

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.a<List<? extends n9.g0>> {
        a() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<n9.g0> b() {
            return n9.j0.b(r.this.n0().a1(), r.this.f());
        }
    }

    /* loaded from: classes.dex */
    static final class b extends y8.l implements x8.a<ua.h> {
        b() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ua.h b() {
            int n10;
            List b02;
            if (r.this.f0().isEmpty()) {
                return h.b.f14541b;
            }
            List<n9.g0> f02 = r.this.f0();
            n10 = m8.r.n(f02, 10);
            ArrayList arrayList = new ArrayList(n10);
            Iterator<T> it = f02.iterator();
            while (it.hasNext()) {
                arrayList.add(((n9.g0) it.next()).A());
            }
            b02 = m8.y.b0(arrayList, new g0(r.this.n0(), r.this.f()));
            return ua.b.f14499d.a("package view scope for " + r.this.f() + " in " + r.this.n0().c(), b02);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(x xVar, la.b bVar, ab.n nVar) {
        super(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b(), bVar.h());
        y8.k.e(xVar, "module");
        y8.k.e(bVar, "fqName");
        y8.k.e(nVar, "storageManager");
        this.f13290h = xVar;
        this.f13291i = bVar;
        this.f13292j = nVar.a(new a());
        this.f13293k = new ua.g(nVar, new b());
    }

    @Override // n9.l0
    public ua.h A() {
        return this.f13293k;
    }

    @Override // n9.m
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public n9.l0 d() {
        if (f().d()) {
            return null;
        }
        x n02 = n0();
        la.b e10 = f().e();
        y8.k.d(e10, "fqName.parent()");
        return n02.C(e10);
    }

    @Override // n9.m
    public <R, D> R J0(n9.o<R, D> oVar, D d10) {
        y8.k.e(oVar, "visitor");
        return oVar.d(this, d10);
    }

    @Override // n9.l0
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public x n0() {
        return this.f13290h;
    }

    public boolean equals(Object obj) {
        n9.l0 l0Var = obj instanceof n9.l0 ? (n9.l0) obj : null;
        return l0Var != null && y8.k.a(f(), l0Var.f()) && y8.k.a(n0(), l0Var.n0());
    }

    @Override // n9.l0
    public la.b f() {
        return this.f13291i;
    }

    @Override // n9.l0
    public List<n9.g0> f0() {
        return (List) ab.m.a(this.f13292j, this, f13289l[0]);
    }

    public int hashCode() {
        return (n0().hashCode() * 31) + f().hashCode();
    }

    @Override // n9.l0
    public boolean isEmpty() {
        return l0.a.a(this);
    }
}
