package androidx.fragment.app;

import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import c.C0325a;
import java.util.Objects;

/* renamed from: androidx.fragment.app.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0273h extends D0 {

    /* renamed from: c, reason: collision with root package name */
    public final C0269f f3412c;

    /* renamed from: d, reason: collision with root package name */
    public AnimatorSet f3413d;

    public C0273h(C0269f c0269f) {
        this.f3412c = c0269f;
    }

    @Override // androidx.fragment.app.D0
    public final void b(ViewGroup container) {
        kotlin.jvm.internal.j.e(container, "container");
        AnimatorSet animatorSet = this.f3413d;
        C0269f c0269f = this.f3412c;
        if (animatorSet == null) {
            c0269f.f3425a.c(this);
            return;
        }
        E0 e02 = c0269f.f3425a;
        if (e02.f3295g) {
            if (Build.VERSION.SDK_INT >= 26) {
                C0275j.f3423a.a(animatorSet);
            }
        } else {
            animatorSet.end();
        }
        if (AbstractC0272g0.J(2)) {
            e02.toString();
        }
    }

    @Override // androidx.fragment.app.D0
    public final void c(ViewGroup container) {
        kotlin.jvm.internal.j.e(container, "container");
        E0 e02 = this.f3412c.f3425a;
        AnimatorSet animatorSet = this.f3413d;
        if (animatorSet == null) {
            e02.c(this);
            return;
        }
        animatorSet.start();
        if (AbstractC0272g0.J(2)) {
            Objects.toString(e02);
        }
    }

    @Override // androidx.fragment.app.D0
    public final void d(C0325a c0325a, ViewGroup container) {
        kotlin.jvm.internal.j.e(container, "container");
        E0 e02 = this.f3412c.f3425a;
        AnimatorSet animatorSet = this.f3413d;
        if (animatorSet == null) {
            e02.c(this);
            return;
        }
        if (Build.VERSION.SDK_INT >= 34 && e02.f3291c.mTransitioning) {
            if (AbstractC0272g0.J(2)) {
                e02.toString();
            }
            long a2 = C0274i.f3414a.a(animatorSet);
            long j2 = c0325a.f3811c * ((float) a2);
            if (j2 == 0) {
                j2 = 1;
            }
            if (j2 == a2) {
                j2 = a2 - 1;
            }
            if (AbstractC0272g0.J(2)) {
                animatorSet.toString();
                e02.toString();
            }
            C0275j.f3423a.b(animatorSet, j2);
        }
    }

    @Override // androidx.fragment.app.D0
    public final void e(ViewGroup container) {
        AnimatorSet animatorSet;
        boolean z3;
        C0273h c0273h;
        kotlin.jvm.internal.j.e(container, "container");
        C0269f c0269f = this.f3412c;
        if (!c0269f.a()) {
            Context context = container.getContext();
            kotlin.jvm.internal.j.d(context, "context");
            M b4 = c0269f.b(context);
            if (b4 != null) {
                animatorSet = (AnimatorSet) b4.f3309b;
            } else {
                animatorSet = null;
            }
            this.f3413d = animatorSet;
            E0 e02 = c0269f.f3425a;
            G g3 = e02.f3291c;
            if (e02.f3289a == 3) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean z4 = z3;
            View view = g3.mView;
            container.startViewTransition(view);
            AnimatorSet animatorSet2 = this.f3413d;
            if (animatorSet2 != null) {
                c0273h = this;
                animatorSet2.addListener(new C0271g(container, view, z4, e02, c0273h));
            } else {
                c0273h = this;
            }
            AnimatorSet animatorSet3 = c0273h.f3413d;
            if (animatorSet3 != null) {
                animatorSet3.setTarget(view);
            }
        }
    }
}
