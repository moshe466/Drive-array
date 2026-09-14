package J;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;

/* loaded from: classes.dex */
public final class W extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f962a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f963b;

    public /* synthetic */ W(Object obj, int i) {
        this.f962a = i;
        this.f963b = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f962a) {
            case 0:
                ((Y) this.f963b).a();
                return;
            case 1:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f963b;
                actionBarOverlayLayout.f2852z = null;
                actionBarOverlayLayout.f2842n = false;
                return;
            default:
                super.onAnimationCancel(animator);
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f962a) {
            case 0:
                ((Y) this.f963b).c();
                return;
            case 1:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f963b;
                actionBarOverlayLayout.f2852z = null;
                actionBarOverlayLayout.f2842n = false;
                return;
            default:
                ((q0.q) this.f963b).n();
                animator.removeListener(this);
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f962a) {
            case 0:
                ((Y) this.f963b).b();
                return;
            default:
                super.onAnimationStart(animator);
                return;
        }
    }

    public W(Y y, View view) {
        this.f962a = 0;
        this.f963b = y;
    }
}
