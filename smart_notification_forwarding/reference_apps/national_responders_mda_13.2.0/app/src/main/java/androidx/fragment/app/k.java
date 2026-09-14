package androidx.fragment.app;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

/* loaded from: classes.dex */
class k {

    /* loaded from: classes.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Animation f3052a;

        /* renamed from: b, reason: collision with root package name */
        public final Animator f3053b;

        a(Animator animator) {
            this.f3052a = null;
            this.f3053b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        a(Animation animation) {
            this.f3052a = animation;
            this.f3053b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    /* loaded from: classes.dex */
    static class b extends AnimationSet implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        private final ViewGroup f3054f;

        /* renamed from: g, reason: collision with root package name */
        private final View f3055g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f3056h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f3057i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f3058j;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f3058j = true;
            this.f3054f = viewGroup;
            this.f3055g = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j10, Transformation transformation) {
            this.f3058j = true;
            if (this.f3056h) {
                return !this.f3057i;
            }
            if (!super.getTransformation(j10, transformation)) {
                this.f3056h = true;
                androidx.core.view.x.a(this.f3054f, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j10, Transformation transformation, float f10) {
            this.f3058j = true;
            if (this.f3056h) {
                return !this.f3057i;
            }
            if (!super.getTransformation(j10, transformation, f10)) {
                this.f3056h = true;
                androidx.core.view.x.a(this.f3054f, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3056h || !this.f3058j) {
                this.f3054f.endViewTransition(this.f3055g);
                this.f3057i = true;
            } else {
                this.f3058j = false;
                this.f3054f.post(this);
            }
        }
    }

    private static int a(Fragment fragment, boolean z10, boolean z11) {
        return z11 ? z10 ? fragment.U() : fragment.V() : z10 ? fragment.B() : fragment.G();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a b(Context context, Fragment fragment, boolean z10, boolean z11) {
        int Q = fragment.Q();
        int a10 = a(fragment, z10, z11);
        boolean z12 = false;
        fragment.H1(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.M;
        if (viewGroup != null) {
            int i10 = d0.b.f8630c;
            if (viewGroup.getTag(i10) != null) {
                fragment.M.setTag(i10, null);
            }
        }
        ViewGroup viewGroup2 = fragment.M;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation C0 = fragment.C0(Q, z10, a10);
        if (C0 != null) {
            return new a(C0);
        }
        Animator D0 = fragment.D0(Q, z10, a10);
        if (D0 != null) {
            return new a(D0);
        }
        if (a10 == 0 && Q != 0) {
            a10 = d(context, Q, z10);
        }
        if (a10 != 0) {
            boolean equals = "anim".equals(context.getResources().getResourceTypeName(a10));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(context, a10);
                    if (loadAnimation != null) {
                        return new a(loadAnimation);
                    }
                    z12 = true;
                } catch (Resources.NotFoundException e10) {
                    throw e10;
                } catch (RuntimeException unused) {
                }
            }
            if (!z12) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(context, a10);
                    if (loadAnimator != null) {
                        return new a(loadAnimator);
                    }
                } catch (RuntimeException e11) {
                    if (equals) {
                        throw e11;
                    }
                    Animation loadAnimation2 = AnimationUtils.loadAnimation(context, a10);
                    if (loadAnimation2 != null) {
                        return new a(loadAnimation2);
                    }
                }
            }
        }
        return null;
    }

    private static int c(Context context, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i10});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private static int d(Context context, int i10, boolean z10) {
        int i11;
        if (i10 == 4097) {
            return z10 ? d0.a.f8626e : d0.a.f8627f;
        }
        if (i10 == 8194) {
            return z10 ? d0.a.f8622a : d0.a.f8623b;
        }
        if (i10 == 8197) {
            i11 = z10 ? R.attr.activityCloseEnterAnimation : R.attr.activityCloseExitAnimation;
        } else {
            if (i10 == 4099) {
                return z10 ? d0.a.f8624c : d0.a.f8625d;
            }
            if (i10 != 4100) {
                return -1;
            }
            i11 = z10 ? R.attr.activityOpenEnterAnimation : R.attr.activityOpenExitAnimation;
        }
        return c(context, i11);
    }
}
