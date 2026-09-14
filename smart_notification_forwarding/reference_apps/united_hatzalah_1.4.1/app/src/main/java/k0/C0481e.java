package k0;

import android.animation.ValueAnimator;

/* renamed from: k0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0481e implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0482f f5216a;

    public C0481e(C0482f c0482f) {
        this.f5216a = c0482f;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
        C0482f c0482f = this.f5216a;
        c0482f.f5219b.setAlpha(floatValue);
        c0482f.f5220c.setAlpha(floatValue);
        c0482f.f5230n.invalidate();
    }
}
