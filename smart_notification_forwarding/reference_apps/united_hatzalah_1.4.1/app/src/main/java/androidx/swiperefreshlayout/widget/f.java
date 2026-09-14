package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;

/* loaded from: classes.dex */
public final class f implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3774a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f3775b;

    public /* synthetic */ f(l lVar, int i) {
        this.f3774a = i;
        this.f3775b = lVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        j jVar;
        switch (this.f3774a) {
            case 0:
                l lVar = this.f3775b;
                if (lVar.mRefreshing) {
                    lVar.mProgress.setAlpha(255);
                    lVar.mProgress.start();
                    if (lVar.mNotify && (jVar = lVar.mListener) != null) {
                        jVar.onRefresh();
                    }
                    lVar.mCurrentTargetOffsetTop = lVar.mCircleView.getTop();
                    return;
                }
                lVar.reset();
                return;
            default:
                l lVar2 = this.f3775b;
                if (!lVar2.mScale) {
                    lVar2.startScaleDownAnimation(null);
                    return;
                }
                return;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        int i = this.f3774a;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        int i = this.f3774a;
    }

    private final void a(Animation animation) {
    }

    private final void b(Animation animation) {
    }

    private final void c(Animation animation) {
    }

    private final void d(Animation animation) {
    }
}
