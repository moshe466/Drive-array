package n9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public final class i0 implements k0 {

    /* renamed from: a, reason: collision with root package name */
    private final Collection<g0> f12292a;

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.l<g0, la.b> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f12293f = new a();

        a() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la.b h(g0 g0Var) {
            y8.k.e(g0Var, "it");
            return g0Var.f();
        }
    }

    /* loaded from: classes.dex */
    static final class b extends y8.l implements x8.l<la.b, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ la.b f12294f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(la.b bVar) {
            super(1);
            this.f12294f = bVar;
        }

        public final boolean a(la.b bVar) {
            y8.k.e(bVar, "it");
            return !bVar.d() && y8.k.a(bVar.e(), this.f12294f);
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ Boolean h(la.b bVar) {
            return Boolean.valueOf(a(bVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i0(Collection<? extends g0> collection) {
        y8.k.e(collection, "packageFragments");
        this.f12292a = collection;
    }

    @Override // n9.h0
    public List<g0> a(la.b bVar) {
        y8.k.e(bVar, "fqName");
        Collection<g0> collection = this.f12292a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (y8.k.a(((g0) obj).f(), bVar)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // n9.k0
    public void b(la.b bVar, Collection<g0> collection) {
        y8.k.e(bVar, "fqName");
        y8.k.e(collection, "packageFragments");
        for (Object obj : this.f12292a) {
            if (y8.k.a(((g0) obj).f(), bVar)) {
                collection.add(obj);
            }
        }
    }

    @Override // n9.h0
    public Collection<la.b> z(la.b bVar, x8.l<? super la.e, Boolean> lVar) {
        lb.h A;
        lb.h q10;
        lb.h l10;
        List w10;
        y8.k.e(bVar, "fqName");
        y8.k.e(lVar, "nameFilter");
        A = m8.y.A(this.f12292a);
        q10 = lb.n.q(A, a.f12293f);
        l10 = lb.n.l(q10, new b(bVar));
        w10 = lb.n.w(l10);
        return w10;
    }
}
