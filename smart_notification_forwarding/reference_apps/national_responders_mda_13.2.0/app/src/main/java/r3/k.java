package r3;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final b0 f13744f;

    /* renamed from: g, reason: collision with root package name */
    private final r4.b f13745g;

    private k(b0 b0Var, r4.b bVar) {
        this.f13744f = b0Var;
        this.f13745g = bVar;
    }

    public static Runnable a(b0 b0Var, r4.b bVar) {
        return new k(b0Var, bVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f13744f.d(this.f13745g);
    }
}
