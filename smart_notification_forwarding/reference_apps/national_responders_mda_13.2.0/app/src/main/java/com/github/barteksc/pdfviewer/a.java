package com.github.barteksc.pdfviewer;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.animation.DecelerateInterpolator;
import android.widget.OverScroller;

/* loaded from: classes.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private PDFView f4598a;

    /* renamed from: b, reason: collision with root package name */
    private ValueAnimator f4599b;

    /* renamed from: c, reason: collision with root package name */
    private OverScroller f4600c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4601d = false;

    /* renamed from: com.github.barteksc.pdfviewer.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0082a implements ValueAnimator.AnimatorUpdateListener {
        C0082a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.f4598a.E(((Float) valueAnimator.getAnimatedValue()).floatValue(), a.this.f4598a.getCurrentYOffset());
        }
    }

    /* loaded from: classes.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.f4598a.E(a.this.f4598a.getCurrentXOffset(), ((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes.dex */
    class c implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        private final float f4604a;

        /* renamed from: b, reason: collision with root package name */
        private final float f4605b;

        public c(float f10, float f11) {
            this.f4604a = f10;
            this.f4605b = f11;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f4598a.C();
            a.this.d();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.f4598a.P(((Float) valueAnimator.getAnimatedValue()).floatValue(), new PointF(this.f4604a, this.f4605b));
        }
    }

    public a(PDFView pDFView) {
        this.f4598a = pDFView;
        this.f4600c = new OverScroller(pDFView.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.f4598a.getScrollHandle() != null) {
            this.f4598a.getScrollHandle().c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.f4600c.computeScrollOffset()) {
            this.f4598a.E(this.f4600c.getCurrX(), this.f4600c.getCurrY());
            this.f4598a.B();
        } else if (this.f4601d) {
            this.f4601d = false;
            this.f4598a.C();
            d();
        }
    }

    public void e(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        i();
        this.f4601d = true;
        this.f4600c.fling(i10, i11, i12, i13, i14, i15, i16, i17);
    }

    public void f(float f10, float f11) {
        i();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f10, f11);
        this.f4599b = ofFloat;
        ofFloat.setInterpolator(new DecelerateInterpolator());
        this.f4599b.addUpdateListener(new C0082a());
        this.f4599b.setDuration(400L);
        this.f4599b.start();
    }

    public void g(float f10, float f11) {
        i();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f10, f11);
        this.f4599b = ofFloat;
        ofFloat.setInterpolator(new DecelerateInterpolator());
        this.f4599b.addUpdateListener(new b());
        this.f4599b.setDuration(400L);
        this.f4599b.start();
    }

    public void h(float f10, float f11, float f12, float f13) {
        i();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f12, f13);
        this.f4599b = ofFloat;
        ofFloat.setInterpolator(new DecelerateInterpolator());
        c cVar = new c(f10, f11);
        this.f4599b.addUpdateListener(cVar);
        this.f4599b.addListener(cVar);
        this.f4599b.setDuration(400L);
        this.f4599b.start();
    }

    public void i() {
        ValueAnimator valueAnimator = this.f4599b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f4599b = null;
        }
        j();
    }

    public void j() {
        this.f4601d = false;
        this.f4600c.forceFinished(true);
    }
}
