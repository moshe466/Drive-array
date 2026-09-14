package androidx.swiperefreshlayout.widget;

import android.animation.Animator;

/* loaded from: classes.dex */
public final class c implements Animator.AnimatorListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f3744a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f3745b;

    public c(e eVar, d dVar) {
        this.f3745b = eVar;
        this.f3744a = dVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
        e eVar = this.f3745b;
        d dVar = this.f3744a;
        eVar.a(1.0f, dVar, true);
        dVar.f3755k = dVar.f3750e;
        dVar.f3756l = dVar.f3751f;
        dVar.f3757m = dVar.f3752g;
        dVar.a((dVar.f3754j + 1) % dVar.i.length);
        if (eVar.f3773f) {
            eVar.f3773f = false;
            animator.cancel();
            animator.setDuration(1332L);
            animator.start();
            if (dVar.f3758n) {
                dVar.f3758n = false;
                return;
            }
            return;
        }
        eVar.f3772e += 1.0f;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f3745b.f3772e = 0.0f;
    }
}
