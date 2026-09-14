package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<View> f2574a;

    /* renamed from: b, reason: collision with root package name */
    Runnable f2575b = null;

    /* renamed from: c, reason: collision with root package name */
    Runnable f2576c = null;

    /* renamed from: d, reason: collision with root package name */
    int f2577d = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h0 f2578a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f2579b;

        a(g0 g0Var, h0 h0Var, View view) {
            this.f2578a = h0Var;
            this.f2579b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2578a.a(this.f2579b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2578a.b(this.f2579b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f2578a.c(this.f2579b);
        }
    }

    /* loaded from: classes.dex */
    static class b {
        static ViewPropertyAnimator a(ViewPropertyAnimator viewPropertyAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            return viewPropertyAnimator.setUpdateListener(animatorUpdateListener);
        }
    }

    /* loaded from: classes.dex */
    static class c implements h0 {

        /* renamed from: a, reason: collision with root package name */
        g0 f2580a;

        /* renamed from: b, reason: collision with root package name */
        boolean f2581b;

        c(g0 g0Var) {
            this.f2580a = g0Var;
        }

        @Override // androidx.core.view.h0
        public void a(View view) {
            Object tag = view.getTag(2113929216);
            h0 h0Var = tag instanceof h0 ? (h0) tag : null;
            if (h0Var != null) {
                h0Var.a(view);
            }
        }

        @Override // androidx.core.view.h0
        @SuppressLint({"WrongConstant"})
        public void b(View view) {
            int i10 = this.f2580a.f2577d;
            if (i10 > -1) {
                view.setLayerType(i10, null);
                this.f2580a.f2577d = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.f2581b) {
                g0 g0Var = this.f2580a;
                Runnable runnable = g0Var.f2576c;
                if (runnable != null) {
                    g0Var.f2576c = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                h0 h0Var = tag instanceof h0 ? (h0) tag : null;
                if (h0Var != null) {
                    h0Var.b(view);
                }
                this.f2581b = true;
            }
        }

        @Override // androidx.core.view.h0
        public void c(View view) {
            this.f2581b = false;
            if (this.f2580a.f2577d > -1) {
                view.setLayerType(2, null);
            }
            g0 g0Var = this.f2580a;
            Runnable runnable = g0Var.f2575b;
            if (runnable != null) {
                g0Var.f2575b = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            h0 h0Var = tag instanceof h0 ? (h0) tag : null;
            if (h0Var != null) {
                h0Var.c(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g0(View view) {
        this.f2574a = new WeakReference<>(view);
    }

    private void i(View view, h0 h0Var) {
        if (h0Var != null) {
            view.animate().setListener(new a(this, h0Var, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public g0 b(float f10) {
        View view = this.f2574a.get();
        if (view != null) {
            view.animate().alpha(f10);
        }
        return this;
    }

    public void c() {
        View view = this.f2574a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long d() {
        View view = this.f2574a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public g0 f(long j10) {
        View view = this.f2574a.get();
        if (view != null) {
            view.animate().setDuration(j10);
        }
        return this;
    }

    public g0 g(Interpolator interpolator) {
        View view = this.f2574a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public g0 h(h0 h0Var) {
        View view = this.f2574a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT < 16) {
                view.setTag(2113929216, h0Var);
                h0Var = new c(this);
            }
            i(view, h0Var);
        }
        return this;
    }

    public g0 j(long j10) {
        View view = this.f2574a.get();
        if (view != null) {
            view.animate().setStartDelay(j10);
        }
        return this;
    }

    public g0 k(final j0 j0Var) {
        final View view = this.f2574a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            b.a(view.animate(), j0Var != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.f0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    j0.this.a(view);
                }
            } : null);
        }
        return this;
    }

    public void l() {
        View view = this.f2574a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public g0 m(float f10) {
        View view = this.f2574a.get();
        if (view != null) {
            view.animate().translationY(f10);
        }
        return this;
    }
}
