package y9;

import ca.u;
import java.util.Collection;
import java.util.List;
import m8.q;
import n9.g0;
import n9.k0;
import y8.l;
import y9.k;

/* loaded from: classes.dex */
public final class f implements k0 {

    /* renamed from: a, reason: collision with root package name */
    private final g f15986a;

    /* renamed from: b, reason: collision with root package name */
    private final ab.a<la.b, z9.h> f15987b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends l implements x8.a<z9.h> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ u f15989g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(u uVar) {
            super(0);
            this.f15989g = uVar;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final z9.h b() {
            return new z9.h(f.this.f15986a, this.f15989g);
        }
    }

    public f(b bVar) {
        l8.h c10;
        y8.k.e(bVar, "components");
        k.a aVar = k.a.f16002a;
        c10 = l8.k.c(null);
        g gVar = new g(bVar, aVar, c10);
        this.f15986a = gVar;
        this.f15987b = gVar.e().f();
    }

    private final z9.h d(la.b bVar) {
        u a10 = this.f15986a.a().d().a(bVar);
        if (a10 == null) {
            return null;
        }
        return this.f15987b.a(bVar, new a(a10));
    }

    @Override // n9.h0
    public List<z9.h> a(la.b bVar) {
        List<z9.h> h10;
        y8.k.e(bVar, "fqName");
        h10 = q.h(d(bVar));
        return h10;
    }

    @Override // n9.k0
    public void b(la.b bVar, Collection<g0> collection) {
        y8.k.e(bVar, "fqName");
        y8.k.e(collection, "packageFragments");
        jb.a.a(collection, d(bVar));
    }

    @Override // n9.h0
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public List<la.b> z(la.b bVar, x8.l<? super la.e, Boolean> lVar) {
        List<la.b> d10;
        y8.k.e(bVar, "fqName");
        y8.k.e(lVar, "nameFilter");
        z9.h d11 = d(bVar);
        List<la.b> Z0 = d11 == null ? null : d11.Z0();
        if (Z0 != null) {
            return Z0;
        }
        d10 = q.d();
        return d10;
    }
}
