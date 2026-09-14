package k1;

/* loaded from: classes.dex */
final class p<T> implements i1.f<T> {

    /* renamed from: a, reason: collision with root package name */
    private final m f11178a;

    /* renamed from: b, reason: collision with root package name */
    private final String f11179b;

    /* renamed from: c, reason: collision with root package name */
    private final i1.b f11180c;

    /* renamed from: d, reason: collision with root package name */
    private final i1.e<T, byte[]> f11181d;

    /* renamed from: e, reason: collision with root package name */
    private final q f11182e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(m mVar, String str, i1.b bVar, i1.e<T, byte[]> eVar, q qVar) {
        this.f11178a = mVar;
        this.f11179b = str;
        this.f11180c = bVar;
        this.f11181d = eVar;
        this.f11182e = qVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(Exception exc) {
    }

    @Override // i1.f
    public void a(i1.c<T> cVar) {
        b(cVar, o.b());
    }

    @Override // i1.f
    public void b(i1.c<T> cVar, i1.h hVar) {
        this.f11182e.a(l.a().e(this.f11178a).c(cVar).f(this.f11179b).d(this.f11181d).b(this.f11180c).a(), hVar);
    }
}
