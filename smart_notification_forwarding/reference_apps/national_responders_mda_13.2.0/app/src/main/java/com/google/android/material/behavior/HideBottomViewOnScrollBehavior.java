package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a, reason: collision with root package name */
    private int f6727a;

    /* renamed from: b, reason: collision with root package name */
    private int f6728b;

    /* renamed from: c, reason: collision with root package name */
    private ViewPropertyAnimator f6729c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f6729c = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
        this.f6727a = 0;
        this.f6728b = 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6727a = 0;
        this.f6728b = 2;
    }

    private void E(V v10, int i10, long j10, TimeInterpolator timeInterpolator) {
        this.f6729c = v10.animate().translationY(i10).setInterpolator(timeInterpolator).setDuration(j10).setListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(V v10) {
        ViewPropertyAnimator viewPropertyAnimator = this.f6729c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v10.clearAnimation();
        }
        this.f6728b = 1;
        E(v10, this.f6727a, 175L, b3.a.f4091c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G(V v10) {
        ViewPropertyAnimator viewPropertyAnimator = this.f6729c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v10.clearAnimation();
        }
        this.f6728b = 2;
        E(v10, 0, 225L, b3.a.f4092d);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        this.f6727a = v10.getMeasuredHeight();
        return super.l(coordinatorLayout, v10, i10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void r(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13) {
        int i14 = this.f6728b;
        if (i14 != 1 && i11 > 0) {
            F(v10);
        } else {
            if (i14 == 2 || i11 >= 0) {
                return;
            }
            G(v10);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean y(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10) {
        return i10 == 2;
    }
}
