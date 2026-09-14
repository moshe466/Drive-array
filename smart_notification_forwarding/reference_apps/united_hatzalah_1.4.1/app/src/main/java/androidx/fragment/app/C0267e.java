package androidx.fragment.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

/* renamed from: androidx.fragment.app.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0267e extends D0 {

    /* renamed from: c, reason: collision with root package name */
    public final C0269f f3361c;

    public C0267e(C0269f c0269f) {
        this.f3361c = c0269f;
    }

    @Override // androidx.fragment.app.D0
    public final void b(ViewGroup container) {
        kotlin.jvm.internal.j.e(container, "container");
        C0269f c0269f = this.f3361c;
        E0 e02 = c0269f.f3425a;
        View view = e02.f3291c.mView;
        view.clearAnimation();
        container.endViewTransition(view);
        c0269f.f3425a.c(this);
        if (AbstractC0272g0.J(2)) {
            e02.toString();
        }
    }

    @Override // androidx.fragment.app.D0
    public final void c(ViewGroup container) {
        kotlin.jvm.internal.j.e(container, "container");
        C0269f c0269f = this.f3361c;
        E0 e02 = c0269f.f3425a;
        if (c0269f.a()) {
            e02.c(this);
            return;
        }
        Context context = container.getContext();
        View view = e02.f3291c.mView;
        kotlin.jvm.internal.j.d(context, "context");
        M b4 = c0269f.b(context);
        if (b4 != null) {
            Animation animation = (Animation) b4.f3308a;
            if (animation != null) {
                if (e02.f3289a != 1) {
                    view.startAnimation(animation);
                    e02.c(this);
                    return;
                }
                container.startViewTransition(view);
                N n4 = new N(animation, container, view);
                n4.setAnimationListener(new AnimationAnimationListenerC0265d(e02, container, view, this));
                view.startAnimation(n4);
                if (AbstractC0272g0.J(2)) {
                    e02.toString();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Required value was null.");
        }
        throw new IllegalStateException("Required value was null.");
    }
}
