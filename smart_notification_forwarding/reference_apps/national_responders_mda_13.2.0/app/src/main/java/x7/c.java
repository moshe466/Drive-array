package x7;

/* loaded from: classes.dex */
class c implements g {

    /* renamed from: a, reason: collision with root package name */
    private g f15512a;

    /* renamed from: b, reason: collision with root package name */
    private d f15513b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(g gVar, d dVar) {
        this.f15512a = gVar;
        this.f15513b = dVar;
    }

    @Override // x7.g
    public void a() {
        this.f15513b.c();
        this.f15512a.a();
    }

    @Override // x7.g
    public void b() {
        this.f15513b.a();
        this.f15512a.b();
    }
}
