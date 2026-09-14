package q0;

import a.AbstractC0228a;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class C extends AnimatorListenerAdapter implements p {

    /* renamed from: a, reason: collision with root package name */
    public final View f6056a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6057b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewGroup f6058c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f6060e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6061f = false;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f6059d = true;

    public C(View view, int i) {
        this.f6056a = view;
        this.f6057b = i;
        this.f6058c = (ViewGroup) view.getParent();
        f(true);
    }

    @Override // q0.p
    public final void b() {
        f(false);
    }

    @Override // q0.p
    public final void d() {
        f(true);
    }

    @Override // q0.p
    public final void e(q qVar) {
        if (!this.f6061f) {
            y.f6139a.P(this.f6056a, this.f6057b);
            ViewGroup viewGroup = this.f6058c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        f(false);
        qVar.w(this);
    }

    public final void f(boolean z3) {
        ViewGroup viewGroup;
        if (this.f6059d && this.f6060e != z3 && (viewGroup = this.f6058c) != null) {
            this.f6060e = z3;
            AbstractC0228a.B(viewGroup, z3);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f6061f = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (!this.f6061f) {
            y.f6139a.P(this.f6056a, this.f6057b);
            ViewGroup viewGroup = this.f6058c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        f(false);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationPause(Animator animator) {
        if (!this.f6061f) {
            y.f6139a.P(this.f6056a, this.f6057b);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationResume(Animator animator) {
        if (!this.f6061f) {
            y.f6139a.P(this.f6056a, 0);
        }
    }

    @Override // q0.p
    public final void c() {
    }

    @Override // q0.p
    public final void a(q qVar) {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
