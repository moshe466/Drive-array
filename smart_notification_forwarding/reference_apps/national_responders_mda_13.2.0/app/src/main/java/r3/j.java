package r3;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements r4.b {

    /* renamed from: a, reason: collision with root package name */
    private final n f13742a;

    /* renamed from: b, reason: collision with root package name */
    private final d f13743b;

    private j(n nVar, d dVar) {
        this.f13742a = nVar;
        this.f13743b = dVar;
    }

    public static r4.b a(n nVar, d dVar) {
        return new j(nVar, dVar);
    }

    @Override // r4.b
    public Object get() {
        Object a10;
        a10 = r1.d().a(new d0(this.f13743b, this.f13742a));
        return a10;
    }
}
