package k0;

import J.S;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import java.util.WeakHashMap;

/* renamed from: k0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0480d extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5213a = 1;

    /* renamed from: b, reason: collision with root package name */
    public boolean f5214b = false;

    /* renamed from: c, reason: collision with root package name */
    public final Object f5215c;

    public C0480d(View view) {
        this.f5215c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f5213a) {
            case 0:
                this.f5214b = true;
                return;
            default:
                super.onAnimationCancel(animator);
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f5213a) {
            case 0:
                C0482f c0482f = (C0482f) this.f5215c;
                if (this.f5214b) {
                    this.f5214b = false;
                    return;
                } else if (((Float) c0482f.f5236u.getAnimatedValue()).floatValue() == 0.0f) {
                    c0482f.f5237v = 0;
                    c0482f.e(0);
                    return;
                } else {
                    c0482f.f5237v = 2;
                    c0482f.f5230n.invalidate();
                    return;
                }
            default:
                View view = (View) this.f5215c;
                q0.y.f6139a.O(view, 1.0f);
                if (this.f5214b) {
                    view.setLayerType(0, null);
                    return;
                }
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f5213a) {
            case 1:
                View view = (View) this.f5215c;
                WeakHashMap weakHashMap = S.f954a;
                if (view.hasOverlappingRendering() && view.getLayerType() == 0) {
                    this.f5214b = true;
                    view.setLayerType(2, null);
                    return;
                }
                return;
            default:
                super.onAnimationStart(animator);
                return;
        }
    }

    public C0480d(C0482f c0482f) {
        this.f5215c = c0482f;
    }
}
