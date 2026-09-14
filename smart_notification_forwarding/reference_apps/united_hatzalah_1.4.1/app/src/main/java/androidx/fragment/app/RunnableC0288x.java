package androidx.fragment.app;

/* renamed from: androidx.fragment.app.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0288x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3530a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ G f3531b;

    public /* synthetic */ RunnableC0288x(G g3, int i) {
        this.f3530a = i;
        this.f3531b = g3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3530a) {
            case 0:
                this.f3531b.startPostponedEnterTransition();
                return;
            default:
                this.f3531b.callStartTransitionListener(false);
                return;
        }
    }
}
