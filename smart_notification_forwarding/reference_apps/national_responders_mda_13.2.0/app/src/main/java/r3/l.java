package r3;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class l implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final x f13746f;

    /* renamed from: g, reason: collision with root package name */
    private final r4.b f13747g;

    private l(x xVar, r4.b bVar) {
        this.f13746f = xVar;
        this.f13747g = bVar;
    }

    public static Runnable a(x xVar, r4.b bVar) {
        return new l(xVar, bVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f13746f.a(this.f13747g);
    }
}
