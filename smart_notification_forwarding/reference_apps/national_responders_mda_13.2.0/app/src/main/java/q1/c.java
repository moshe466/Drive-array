package q1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final h f13427f;

    /* renamed from: g, reason: collision with root package name */
    private final k1.m f13428g;

    /* renamed from: h, reason: collision with root package name */
    private final int f13429h;

    /* renamed from: i, reason: collision with root package name */
    private final Runnable f13430i;

    private c(h hVar, k1.m mVar, int i10, Runnable runnable) {
        this.f13427f = hVar;
        this.f13428g = mVar;
        this.f13429h = i10;
        this.f13430i = runnable;
    }

    public static Runnable a(h hVar, k1.m mVar, int i10, Runnable runnable) {
        return new c(hVar, mVar, i10, runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        h.e(this.f13427f, this.f13428g, this.f13429h, this.f13430i);
    }
}
