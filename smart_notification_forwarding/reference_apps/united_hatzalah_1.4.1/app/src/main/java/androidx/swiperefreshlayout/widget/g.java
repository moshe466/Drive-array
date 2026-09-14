package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* loaded from: classes.dex */
public final class g extends Animation {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3776a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3777b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l f3778c;

    public g(l lVar, int i, int i3) {
        this.f3778c = lVar;
        this.f3776a = i;
        this.f3777b = i3;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f4, Transformation transformation) {
        this.f3778c.mProgress.setAlpha((int) (((this.f3777b - r0) * f4) + this.f3776a));
    }
}
