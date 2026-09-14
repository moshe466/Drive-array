package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* loaded from: classes.dex */
public final class h extends Animation {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3779a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f3780b;

    public /* synthetic */ h(l lVar, int i) {
        this.f3779a = i;
        this.f3780b = lVar;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f4, Transformation transformation) {
        int i;
        switch (this.f3779a) {
            case 0:
                l lVar = this.f3780b;
                if (!lVar.mUsingCustomStart) {
                    i = lVar.mSpinnerOffsetEnd - Math.abs(lVar.mOriginalOffsetTop);
                } else {
                    i = lVar.mSpinnerOffsetEnd;
                }
                lVar.setTargetOffsetTopAndBottom((lVar.mFrom + ((int) ((i - r1) * f4))) - lVar.mCircleView.getTop());
                e eVar = lVar.mProgress;
                float f5 = 1.0f - f4;
                d dVar = eVar.f3768a;
                if (f5 != dVar.p) {
                    dVar.p = f5;
                }
                eVar.invalidateSelf();
                return;
            case 1:
                l lVar2 = this.f3780b;
                float f6 = lVar2.mStartingScale;
                lVar2.setAnimationProgress(((-f6) * f4) + f6);
                lVar2.moveToStart(f4);
                return;
            case 2:
                this.f3780b.setAnimationProgress(f4);
                return;
            case 3:
                this.f3780b.setAnimationProgress(1.0f - f4);
                return;
            default:
                this.f3780b.moveToStart(f4);
                return;
        }
    }
}
