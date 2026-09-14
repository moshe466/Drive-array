package s0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class d extends i0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends n {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f13892a;

        a(d dVar, View view) {
            this.f13892a = view;
        }

        @Override // s0.m.f
        public void b(m mVar) {
            d0.h(this.f13892a, 1.0f);
            d0.a(this.f13892a);
            mVar.X(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final View f13893a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f13894b = false;

        b(View view) {
            this.f13893a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d0.h(this.f13893a, 1.0f);
            if (this.f13894b) {
                this.f13893a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (androidx.core.view.a0.O(this.f13893a) && this.f13893a.getLayerType() == 0) {
                this.f13894b = true;
                this.f13893a.setLayerType(2, null);
            }
        }
    }

    public d(int i10) {
        q0(i10);
    }

    private Animator r0(View view, float f10, float f11) {
        if (f10 == f11) {
            return null;
        }
        d0.h(view, f10);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, d0.f13898d, f11);
        ofFloat.addListener(new b(view));
        a(new a(this, view));
        return ofFloat;
    }

    private static float s0(s sVar, float f10) {
        Float f11;
        return (sVar == null || (f11 = (Float) sVar.f13987a.get("android:fade:transitionAlpha")) == null) ? f10 : f11.floatValue();
    }

    @Override // s0.i0, s0.m
    public void m(s sVar) {
        super.m(sVar);
        sVar.f13987a.put("android:fade:transitionAlpha", Float.valueOf(d0.d(sVar.f13988b)));
    }

    @Override // s0.i0
    public Animator m0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        float s02 = s0(sVar, 0.0f);
        return r0(view, s02 != 1.0f ? s02 : 0.0f, 1.0f);
    }

    @Override // s0.i0
    public Animator o0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        d0.f(view);
        return r0(view, s0(sVar, 1.0f), 0.0f);
    }
}
