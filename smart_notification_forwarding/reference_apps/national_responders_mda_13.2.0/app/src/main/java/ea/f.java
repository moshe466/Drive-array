package ea;

/* loaded from: classes.dex */
public final class f implements xa.g {

    /* renamed from: a, reason: collision with root package name */
    private final m f9303a;

    /* renamed from: b, reason: collision with root package name */
    private final e f9304b;

    public f(m mVar, e eVar) {
        y8.k.e(mVar, "kotlinClassFinder");
        y8.k.e(eVar, "deserializedDescriptorResolver");
        this.f9303a = mVar;
        this.f9304b = eVar;
    }

    @Override // xa.g
    public xa.f a(la.a aVar) {
        y8.k.e(aVar, "classId");
        o b10 = n.b(this.f9303a, aVar);
        if (b10 == null) {
            return null;
        }
        y8.k.a(b10.d(), aVar);
        return this.f9304b.k(b10);
    }
}
