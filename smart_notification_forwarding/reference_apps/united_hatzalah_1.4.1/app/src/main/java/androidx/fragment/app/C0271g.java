package androidx.fragment.app;

import F0.AbstractC0008a;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.Objects;

/* renamed from: androidx.fragment.app.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0271g extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f3368a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f3369b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f3370c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ E0 f3371d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0273h f3372e;

    public C0271g(ViewGroup viewGroup, View view, boolean z3, E0 e02, C0273h c0273h) {
        this.f3368a = viewGroup;
        this.f3369b = view;
        this.f3370c = z3;
        this.f3371d = e02;
        this.f3372e = c0273h;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator anim) {
        kotlin.jvm.internal.j.e(anim, "anim");
        ViewGroup viewGroup = this.f3368a;
        View viewToAnimate = this.f3369b;
        viewGroup.endViewTransition(viewToAnimate);
        boolean z3 = this.f3370c;
        E0 e02 = this.f3371d;
        if (z3 || e02.f3289a == 3) {
            int i = e02.f3289a;
            kotlin.jvm.internal.j.d(viewToAnimate, "viewToAnimate");
            AbstractC0008a.a(i, viewToAnimate, viewGroup);
        }
        C0273h c0273h = this.f3372e;
        c0273h.f3412c.f3425a.c(c0273h);
        if (AbstractC0272g0.J(2)) {
            Objects.toString(e02);
        }
    }
}
