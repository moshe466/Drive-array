package y9;

import java.util.Iterator;
import k9.k;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import lb.n;
import m8.y;
import y8.l;

/* loaded from: classes.dex */
public final class d implements kotlin.reflect.jvm.internal.impl.descriptors.annotations.g {

    /* renamed from: f, reason: collision with root package name */
    private final g f15981f;

    /* renamed from: g, reason: collision with root package name */
    private final ca.d f15982g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f15983h;

    /* renamed from: i, reason: collision with root package name */
    private final ab.h<ca.a, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> f15984i;

    /* loaded from: classes.dex */
    static final class a extends l implements x8.l<ca.a, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> {
        a() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c h(ca.a aVar) {
            y8.k.e(aVar, "annotation");
            return w9.c.f15310a.e(aVar, d.this.f15981f, d.this.f15983h);
        }
    }

    public d(g gVar, ca.d dVar, boolean z10) {
        y8.k.e(gVar, "c");
        y8.k.e(dVar, "annotationOwner");
        this.f15981f = gVar;
        this.f15982g = dVar;
        this.f15983h = z10;
        this.f15984i = gVar.a().t().c(new a());
    }

    public /* synthetic */ d(g gVar, ca.d dVar, boolean z10, int i10, y8.g gVar2) {
        this(gVar, dVar, (i10 & 4) != 0 ? false : z10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.c e(la.b bVar) {
        y8.k.e(bVar, "fqName");
        ca.a e10 = this.f15982g.e(bVar);
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c h10 = e10 == null ? null : this.f15984i.h(e10);
        return h10 == null ? w9.c.f15310a.a(bVar, this.f15982g, this.f15981f) : h10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean isEmpty() {
        return this.f15982g.u().isEmpty() && !this.f15982g.v();
    }

    @Override // java.lang.Iterable
    public Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> iterator() {
        lb.h A;
        lb.h q10;
        lb.h t10;
        lb.h n10;
        A = y.A(this.f15982g.u());
        q10 = n.q(A, this.f15984i);
        t10 = n.t(q10, w9.c.f15310a.a(k.a.f11287u, this.f15982g, this.f15981f));
        n10 = n.n(t10);
        return n10.iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean r(la.b bVar) {
        return g.b.b(this, bVar);
    }
}
