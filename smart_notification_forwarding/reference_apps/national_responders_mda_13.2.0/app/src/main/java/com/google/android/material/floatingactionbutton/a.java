package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.view.a0;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a {
    static final TimeInterpolator A = b3.a.f4091c;
    static final int[] B = {R.attr.state_pressed, R.attr.state_enabled};
    static final int[] C = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    static final int[] D = {R.attr.state_focused, R.attr.state_enabled};
    static final int[] E = {R.attr.state_hovered, R.attr.state_enabled};
    static final int[] F = {R.attr.state_enabled};
    static final int[] G = new int[0];

    /* renamed from: b, reason: collision with root package name */
    Animator f6845b;

    /* renamed from: c, reason: collision with root package name */
    b3.h f6846c;

    /* renamed from: d, reason: collision with root package name */
    b3.h f6847d;

    /* renamed from: e, reason: collision with root package name */
    private b3.h f6848e;

    /* renamed from: f, reason: collision with root package name */
    private b3.h f6849f;

    /* renamed from: g, reason: collision with root package name */
    private final com.google.android.material.internal.e f6850g;

    /* renamed from: h, reason: collision with root package name */
    i3.a f6851h;

    /* renamed from: i, reason: collision with root package name */
    private float f6852i;

    /* renamed from: j, reason: collision with root package name */
    Drawable f6853j;

    /* renamed from: k, reason: collision with root package name */
    Drawable f6854k;

    /* renamed from: l, reason: collision with root package name */
    Drawable f6855l;

    /* renamed from: m, reason: collision with root package name */
    float f6856m;

    /* renamed from: n, reason: collision with root package name */
    float f6857n;

    /* renamed from: o, reason: collision with root package name */
    float f6858o;

    /* renamed from: p, reason: collision with root package name */
    int f6859p;

    /* renamed from: r, reason: collision with root package name */
    private ArrayList<Animator.AnimatorListener> f6861r;

    /* renamed from: s, reason: collision with root package name */
    private ArrayList<Animator.AnimatorListener> f6862s;

    /* renamed from: t, reason: collision with root package name */
    final com.google.android.material.internal.h f6863t;

    /* renamed from: u, reason: collision with root package name */
    final i3.b f6864u;

    /* renamed from: z, reason: collision with root package name */
    private ViewTreeObserver.OnPreDrawListener f6869z;

    /* renamed from: a, reason: collision with root package name */
    int f6844a = 0;

    /* renamed from: q, reason: collision with root package name */
    float f6860q = 1.0f;

    /* renamed from: v, reason: collision with root package name */
    private final Rect f6865v = new Rect();

    /* renamed from: w, reason: collision with root package name */
    private final RectF f6866w = new RectF();

    /* renamed from: x, reason: collision with root package name */
    private final RectF f6867x = new RectF();

    /* renamed from: y, reason: collision with root package name */
    private final Matrix f6868y = new Matrix();

    /* renamed from: com.google.android.material.floatingactionbutton.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0086a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private boolean f6870a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f6871b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ g f6872c;

        C0086a(boolean z10, g gVar) {
            this.f6871b = z10;
            this.f6872c = gVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f6870a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a aVar = a.this;
            aVar.f6844a = 0;
            aVar.f6845b = null;
            if (this.f6870a) {
                return;
            }
            com.google.android.material.internal.h hVar = aVar.f6863t;
            boolean z10 = this.f6871b;
            hVar.b(z10 ? 8 : 4, z10);
            g gVar = this.f6872c;
            if (gVar != null) {
                gVar.b();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.f6863t.b(0, this.f6871b);
            a aVar = a.this;
            aVar.f6844a = 1;
            aVar.f6845b = animator;
            this.f6870a = false;
        }
    }

    /* loaded from: classes.dex */
    class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f6874a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f6875b;

        b(boolean z10, g gVar) {
            this.f6874a = z10;
            this.f6875b = gVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a aVar = a.this;
            aVar.f6844a = 0;
            aVar.f6845b = null;
            g gVar = this.f6875b;
            if (gVar != null) {
                gVar.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.f6863t.b(0, this.f6874a);
            a aVar = a.this;
            aVar.f6844a = 2;
            aVar.f6845b = animator;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements ViewTreeObserver.OnPreDrawListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a.this.z();
            return true;
        }
    }

    /* loaded from: classes.dex */
    private class d extends i {
        d(a aVar) {
            super(aVar, null);
        }
    }

    /* loaded from: classes.dex */
    private class e extends i {
        e() {
            super(a.this, null);
        }
    }

    /* loaded from: classes.dex */
    private class f extends i {
        f() {
            super(a.this, null);
        }
    }

    /* loaded from: classes.dex */
    interface g {
        void a();

        void b();
    }

    /* loaded from: classes.dex */
    private class h extends i {
        h() {
            super(a.this, null);
        }
    }

    /* loaded from: classes.dex */
    private abstract class i extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        private boolean f6881a;

        private i() {
        }

        /* synthetic */ i(a aVar, C0086a c0086a) {
            this();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i3.a aVar = a.this.f6851h;
            throw null;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f6881a) {
                i3.a aVar = a.this.f6851h;
                throw null;
            }
            i3.a aVar2 = a.this.f6851h;
            valueAnimator.getAnimatedFraction();
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.google.android.material.internal.h hVar, i3.b bVar) {
        this.f6863t = hVar;
        this.f6864u = bVar;
        com.google.android.material.internal.e eVar = new com.google.android.material.internal.e();
        this.f6850g = eVar;
        eVar.a(B, e(new f()));
        eVar.a(C, e(new e()));
        eVar.a(D, e(new e()));
        eVar.a(E, e(new e()));
        eVar.a(F, e(new h()));
        eVar.a(G, e(new d(this)));
        this.f6852i = hVar.getRotation();
    }

    private boolean M() {
        return a0.S(this.f6863t) && !this.f6863t.isInEditMode();
    }

    private void O() {
        com.google.android.material.internal.h hVar;
        int i10;
        if (Build.VERSION.SDK_INT == 19) {
            if (this.f6852i % 90.0f != 0.0f) {
                i10 = 1;
                if (this.f6863t.getLayerType() == 1) {
                    return;
                } else {
                    hVar = this.f6863t;
                }
            } else {
                if (this.f6863t.getLayerType() == 0) {
                    return;
                }
                hVar = this.f6863t;
                i10 = 0;
            }
            hVar.setLayerType(i10, null);
        }
    }

    private void c(float f10, Matrix matrix) {
        matrix.reset();
        if (this.f6863t.getDrawable() == null || this.f6859p == 0) {
            return;
        }
        RectF rectF = this.f6866w;
        RectF rectF2 = this.f6867x;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int i10 = this.f6859p;
        rectF2.set(0.0f, 0.0f, i10, i10);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i11 = this.f6859p;
        matrix.postScale(f10, f10, i11 / 2.0f, i11 / 2.0f);
    }

    private AnimatorSet d(b3.h hVar, float f10, float f11, float f12) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f6863t, (Property<com.google.android.material.internal.h, Float>) View.ALPHA, f10);
        hVar.d("opacity").a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f6863t, (Property<com.google.android.material.internal.h, Float>) View.SCALE_X, f11);
        hVar.d("scale").a(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f6863t, (Property<com.google.android.material.internal.h, Float>) View.SCALE_Y, f11);
        hVar.d("scale").a(ofFloat3);
        arrayList.add(ofFloat3);
        c(f12, this.f6868y);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.f6863t, new b3.f(), new b3.g(), new Matrix(this.f6868y));
        hVar.d("iconScale").a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        b3.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    private ValueAnimator e(i iVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(A);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(iVar);
        valueAnimator.addUpdateListener(iVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    private void f() {
        if (this.f6869z == null) {
            this.f6869z = new c();
        }
    }

    private b3.h h() {
        if (this.f6849f == null) {
            this.f6849f = b3.h.b(this.f6863t.getContext(), a3.a.f90a);
        }
        return this.f6849f;
    }

    private b3.h i() {
        if (this.f6848e == null) {
            this.f6848e = b3.h.b(this.f6863t.getContext(), a3.a.f91b);
        }
        return this.f6848e;
    }

    public void A(Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.f6862s;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.f6861r;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    boolean C() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(ColorStateList colorStateList) {
        Drawable drawable = this.f6853j;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(PorterDuff.Mode mode) {
        Drawable drawable = this.f6853j;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.p(drawable, mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void F(float f10) {
        if (this.f6856m != f10) {
            this.f6856m = f10;
            x(f10, this.f6857n, this.f6858o);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void G(b3.h hVar) {
        this.f6847d = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void H(float f10) {
        if (this.f6857n != f10) {
            this.f6857n = f10;
            x(this.f6856m, f10, this.f6858o);
        }
    }

    final void I(float f10) {
        this.f6860q = f10;
        Matrix matrix = this.f6868y;
        c(f10, matrix);
        this.f6863t.setImageMatrix(matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void J(float f10) {
        if (this.f6858o != f10) {
            this.f6858o = f10;
            x(this.f6856m, this.f6857n, f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(ColorStateList colorStateList) {
        Drawable drawable = this.f6854k;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, h3.a.a(colorStateList));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void L(b3.h hVar) {
        this.f6846c = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N(g gVar, boolean z10) {
        if (r()) {
            return;
        }
        Animator animator = this.f6845b;
        if (animator != null) {
            animator.cancel();
        }
        if (!M()) {
            this.f6863t.b(0, z10);
            this.f6863t.setAlpha(1.0f);
            this.f6863t.setScaleY(1.0f);
            this.f6863t.setScaleX(1.0f);
            I(1.0f);
            if (gVar != null) {
                gVar.a();
                return;
            }
            return;
        }
        if (this.f6863t.getVisibility() != 0) {
            this.f6863t.setAlpha(0.0f);
            this.f6863t.setScaleY(0.0f);
            this.f6863t.setScaleX(0.0f);
            I(0.0f);
        }
        b3.h hVar = this.f6846c;
        if (hVar == null) {
            hVar = i();
        }
        AnimatorSet d10 = d(hVar, 1.0f, 1.0f, 1.0f);
        d10.addListener(new b(z10, gVar));
        ArrayList<Animator.AnimatorListener> arrayList = this.f6861r;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                d10.addListener(it.next());
            }
        }
        d10.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void P() {
        I(this.f6860q);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Q() {
        Rect rect = this.f6865v;
        m(rect);
        y(rect);
        this.f6864u.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        if (this.f6862s == null) {
            this.f6862s = new ArrayList<>();
        }
        this.f6862s.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Animator.AnimatorListener animatorListener) {
        if (this.f6861r == null) {
            this.f6861r = new ArrayList<>();
        }
        this.f6861r.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Drawable g() {
        return this.f6855l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        return this.f6856m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final b3.h k() {
        return this.f6847d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float l() {
        return this.f6857n;
    }

    void m(Rect rect) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float n() {
        return this.f6858o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final b3.h o() {
        return this.f6846c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(g gVar, boolean z10) {
        if (q()) {
            return;
        }
        Animator animator = this.f6845b;
        if (animator != null) {
            animator.cancel();
        }
        if (!M()) {
            this.f6863t.b(z10 ? 8 : 4, z10);
            if (gVar != null) {
                gVar.b();
                return;
            }
            return;
        }
        b3.h hVar = this.f6847d;
        if (hVar == null) {
            hVar = h();
        }
        AnimatorSet d10 = d(hVar, 0.0f, 0.0f, 0.0f);
        d10.addListener(new C0086a(z10, gVar));
        ArrayList<Animator.AnimatorListener> arrayList = this.f6862s;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                d10.addListener(it.next());
            }
        }
        d10.start();
    }

    boolean q() {
        return this.f6863t.getVisibility() == 0 ? this.f6844a == 1 : this.f6844a != 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r() {
        return this.f6863t.getVisibility() != 0 ? this.f6844a == 2 : this.f6844a != 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        this.f6850g.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t() {
        if (C()) {
            f();
            this.f6863t.getViewTreeObserver().addOnPreDrawListener(this.f6869z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v() {
        if (this.f6869z != null) {
            this.f6863t.getViewTreeObserver().removeOnPreDrawListener(this.f6869z);
            this.f6869z = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(int[] iArr) {
        this.f6850g.d(iArr);
    }

    void x(float f10, float f11, float f12) {
    }

    void y(Rect rect) {
    }

    void z() {
        float rotation = this.f6863t.getRotation();
        if (this.f6852i != rotation) {
            this.f6852i = rotation;
            O();
        }
    }
}
