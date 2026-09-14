package m;

import androidx.appcompat.widget.ActionBarOverlayLayout;

/* renamed from: m.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0534b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5624a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ActionBarOverlayLayout f5625b;

    public /* synthetic */ RunnableC0534b(ActionBarOverlayLayout actionBarOverlayLayout, int i) {
        this.f5624a = i;
        this.f5625b = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5624a) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = this.f5625b;
                actionBarOverlayLayout.b();
                actionBarOverlayLayout.f2852z = actionBarOverlayLayout.f2835d.animate().translationY(0.0f).setListener(actionBarOverlayLayout.f2828A);
                return;
            default:
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.f5625b;
                actionBarOverlayLayout2.b();
                actionBarOverlayLayout2.f2852z = actionBarOverlayLayout2.f2835d.animate().translationY(-actionBarOverlayLayout2.f2835d.getHeight()).setListener(actionBarOverlayLayout2.f2828A);
                return;
        }
    }
}
