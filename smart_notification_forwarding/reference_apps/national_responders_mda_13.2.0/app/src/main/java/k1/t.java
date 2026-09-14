package k1;

/* loaded from: classes.dex */
public final class t implements m1.b<r> {

    /* renamed from: a, reason: collision with root package name */
    private final k8.a<t1.a> f11188a;

    /* renamed from: b, reason: collision with root package name */
    private final k8.a<t1.a> f11189b;

    /* renamed from: c, reason: collision with root package name */
    private final k8.a<p1.e> f11190c;

    /* renamed from: d, reason: collision with root package name */
    private final k8.a<q1.h> f11191d;

    /* renamed from: e, reason: collision with root package name */
    private final k8.a<q1.l> f11192e;

    public t(k8.a<t1.a> aVar, k8.a<t1.a> aVar2, k8.a<p1.e> aVar3, k8.a<q1.h> aVar4, k8.a<q1.l> aVar5) {
        this.f11188a = aVar;
        this.f11189b = aVar2;
        this.f11190c = aVar3;
        this.f11191d = aVar4;
        this.f11192e = aVar5;
    }

    public static t a(k8.a<t1.a> aVar, k8.a<t1.a> aVar2, k8.a<p1.e> aVar3, k8.a<q1.h> aVar4, k8.a<q1.l> aVar5) {
        return new t(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static r c(t1.a aVar, t1.a aVar2, p1.e eVar, q1.h hVar, q1.l lVar) {
        return new r(aVar, aVar2, eVar, hVar, lVar);
    }

    @Override // k8.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public r get() {
        return c(this.f11188a.get(), this.f11189b.get(), this.f11190c.get(), this.f11191d.get(), this.f11192e.get());
    }
}
