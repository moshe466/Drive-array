package q1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final l f13456f;

    private j(l lVar) {
        this.f13456f = lVar;
    }

    public static Runnable a(l lVar) {
        return new j(lVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        r0.f13461d.c(k.a(this.f13456f));
    }
}
