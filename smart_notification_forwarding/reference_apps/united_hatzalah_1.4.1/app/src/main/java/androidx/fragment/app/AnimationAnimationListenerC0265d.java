package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.util.Objects;

/* renamed from: androidx.fragment.app.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class AnimationAnimationListenerC0265d implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ E0 f3357a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f3358b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f3359c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0267e f3360d;

    public AnimationAnimationListenerC0265d(E0 e02, ViewGroup viewGroup, View view, C0267e c0267e) {
        this.f3357a = e02;
        this.f3358b = viewGroup;
        this.f3359c = view;
        this.f3360d = c0267e;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        kotlin.jvm.internal.j.e(animation, "animation");
        ViewGroup viewGroup = this.f3358b;
        viewGroup.post(new K0.b(viewGroup, this.f3359c, this.f3360d, 2));
        if (AbstractC0272g0.J(2)) {
            Objects.toString(this.f3357a);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        kotlin.jvm.internal.j.e(animation, "animation");
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        kotlin.jvm.internal.j.e(animation, "animation");
        if (AbstractC0272g0.J(2)) {
            Objects.toString(this.f3357a);
        }
    }
}
