package xa;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import m8.r0;
import n9.d0;
import n9.g0;
import n9.k0;

/* loaded from: classes.dex */
public abstract class a implements k0 {

    /* renamed from: a, reason: collision with root package name */
    private final ab.n f15543a;

    /* renamed from: b, reason: collision with root package name */
    private final s f15544b;

    /* renamed from: c, reason: collision with root package name */
    private final d0 f15545c;

    /* renamed from: d, reason: collision with root package name */
    protected j f15546d;

    /* renamed from: e, reason: collision with root package name */
    private final ab.h<la.b, g0> f15547e;

    /* renamed from: xa.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0332a extends y8.l implements x8.l<la.b, g0> {
        C0332a() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g0 h(la.b bVar) {
            y8.k.e(bVar, "fqName");
            n c10 = a.this.c(bVar);
            if (c10 == null) {
                return null;
            }
            c10.W0(a.this.d());
            return c10;
        }
    }

    public a(ab.n nVar, s sVar, d0 d0Var) {
        y8.k.e(nVar, "storageManager");
        y8.k.e(sVar, "finder");
        y8.k.e(d0Var, "moduleDescriptor");
        this.f15543a = nVar;
        this.f15544b = sVar;
        this.f15545c = d0Var;
        this.f15547e = nVar.c(new C0332a());
    }

    @Override // n9.h0
    public List<g0> a(la.b bVar) {
        List<g0> h10;
        y8.k.e(bVar, "fqName");
        h10 = m8.q.h(this.f15547e.h(bVar));
        return h10;
    }

    @Override // n9.k0
    public void b(la.b bVar, Collection<g0> collection) {
        y8.k.e(bVar, "fqName");
        y8.k.e(collection, "packageFragments");
        jb.a.a(collection, this.f15547e.h(bVar));
    }

    protected abstract n c(la.b bVar);

    protected final j d() {
        j jVar = this.f15546d;
        if (jVar != null) {
            return jVar;
        }
        y8.k.o("components");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final s e() {
        return this.f15544b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final d0 f() {
        return this.f15545c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ab.n g() {
        return this.f15543a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h(j jVar) {
        y8.k.e(jVar, "<set-?>");
        this.f15546d = jVar;
    }

    @Override // n9.h0
    public Collection<la.b> z(la.b bVar, x8.l<? super la.e, Boolean> lVar) {
        Set b10;
        y8.k.e(bVar, "fqName");
        y8.k.e(lVar, "nameFilter");
        b10 = r0.b();
        return b10;
    }
}
