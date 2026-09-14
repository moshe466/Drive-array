package androidx.fragment.app;

import J.ViewTreeObserverOnPreDrawListenerC0134w;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

/* loaded from: classes.dex */
public final class N extends AnimationSet implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f3310a;

    /* renamed from: b, reason: collision with root package name */
    public final View f3311b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3312c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3313d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3314e;

    public N(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.f3314e = true;
        this.f3310a = viewGroup;
        this.f3311b = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public final boolean getTransformation(long j2, Transformation transformation) {
        this.f3314e = true;
        if (this.f3312c) {
            return !this.f3313d;
        }
        if (!super.getTransformation(j2, transformation)) {
            this.f3312c = true;
            ViewTreeObserverOnPreDrawListenerC0134w.a(this.f3310a, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z3 = this.f3312c;
        ViewGroup viewGroup = this.f3310a;
        if (!z3 && this.f3314e) {
            this.f3314e = false;
            viewGroup.post(this);
        } else {
            viewGroup.endViewTransition(this.f3311b);
            this.f3313d = true;
        }
    }

    @Override // android.view.animation.Animation
    public final boolean getTransformation(long j2, Transformation transformation, float f4) {
        this.f3314e = true;
        if (this.f3312c) {
            return !this.f3313d;
        }
        if (!super.getTransformation(j2, transformation, f4)) {
            this.f3312c = true;
            ViewTreeObserverOnPreDrawListenerC0134w.a(this.f3310a, this);
        }
        return true;
    }
}
