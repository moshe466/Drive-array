package q0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import t.C0689e;

/* loaded from: classes.dex */
public final class n extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0689e f6095a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f6096b;

    public n(q qVar, C0689e c0689e) {
        this.f6096b = qVar;
        this.f6095a = c0689e;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f6095a.remove(animator);
        this.f6096b.f6115n.remove(animator);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f6096b.f6115n.add(animator);
    }
}
