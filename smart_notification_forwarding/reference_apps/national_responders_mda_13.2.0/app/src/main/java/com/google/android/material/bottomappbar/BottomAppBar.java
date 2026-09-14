package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.a0;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {
    private final int W;

    /* renamed from: a0, reason: collision with root package name */
    private final j3.a f6747a0;

    /* renamed from: b0, reason: collision with root package name */
    private Animator f6748b0;

    /* renamed from: c0, reason: collision with root package name */
    private Animator f6749c0;

    /* renamed from: d0, reason: collision with root package name */
    private Animator f6750d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f6751e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f6752f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f6753g0;

    /* renamed from: h0, reason: collision with root package name */
    AnimatorListenerAdapter f6754h0;

    /* loaded from: classes.dex */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: d, reason: collision with root package name */
        private final Rect f6755d;

        public Behavior() {
            this.f6755d = new Rect();
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f6755d = new Rect();
        }

        private boolean L(FloatingActionButton floatingActionButton, BottomAppBar bottomAppBar) {
            ((CoordinatorLayout.f) floatingActionButton.getLayoutParams()).f2149d = 17;
            bottomAppBar.b0(floatingActionButton);
            return true;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public boolean l(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i10) {
            FloatingActionButton g02 = bottomAppBar.g0();
            if (g02 != null) {
                L(g02, bottomAppBar);
                g02.i(this.f6755d);
                bottomAppBar.setFabDiameter(this.f6755d.height());
            }
            if (!bottomAppBar.j0()) {
                bottomAppBar.o0();
            }
            coordinatorLayout.I(bottomAppBar, i10);
            return super.l(coordinatorLayout, bottomAppBar, i10);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        public boolean z(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i10, int i11) {
            return bottomAppBar.getHideOnScroll() && super.z(coordinatorLayout, bottomAppBar, view, view2, i10, i11);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior
        /* renamed from: J, reason: merged with bridge method [inline-methods] */
        public void F(BottomAppBar bottomAppBar) {
            super.F(bottomAppBar);
            FloatingActionButton g02 = bottomAppBar.g0();
            if (g02 != null) {
                g02.h(this.f6755d);
                float measuredHeight = g02.getMeasuredHeight() - this.f6755d.height();
                g02.clearAnimation();
                g02.animate().translationY((-g02.getPaddingBottom()) + measuredHeight).setInterpolator(b3.a.f4091c).setDuration(175L);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior
        /* renamed from: K, reason: merged with bridge method [inline-methods] */
        public void G(BottomAppBar bottomAppBar) {
            super.G(bottomAppBar);
            FloatingActionButton g02 = bottomAppBar.g0();
            if (g02 != null) {
                g02.clearAnimation();
                g02.animate().translationY(bottomAppBar.getFabTranslationY()).setInterpolator(b3.a.f4092d).setDuration(225L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.f6749c0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.f6750d0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f6758a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ActionMenuView f6759b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f6760c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f6761d;

        c(ActionMenuView actionMenuView, int i10, boolean z10) {
            this.f6759b = actionMenuView;
            this.f6760c = i10;
            this.f6761d = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f6758a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f6758a) {
                return;
            }
            BottomAppBar.this.p0(this.f6759b, this.f6760c, this.f6761d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d extends y.a {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: h, reason: collision with root package name */
        int f6763h;

        /* renamed from: i, reason: collision with root package name */
        boolean f6764i;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<d> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i10) {
                return new d[i10];
            }
        }

        public d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f6763h = parcel.readInt();
            this.f6764i = parcel.readInt() != 0;
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // y.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f6763h);
            parcel.writeInt(this.f6764i ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(FloatingActionButton floatingActionButton) {
        n0(floatingActionButton);
        floatingActionButton.e(this.f6754h0);
        floatingActionButton.f(this.f6754h0);
    }

    private void c0() {
        Animator animator = this.f6748b0;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.f6750d0;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animator animator3 = this.f6749c0;
        if (animator3 != null) {
            animator3.cancel();
        }
    }

    private void d0(int i10, List<Animator> list) {
        if (this.f6753g0) {
            throw null;
        }
    }

    private void e0(int i10, List<Animator> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(g0(), "translationX", h0(i10));
        ofFloat.setDuration(300L);
        list.add(ofFloat);
    }

    private void f0(int i10, boolean z10, List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        Animator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        if ((!this.f6753g0 && (!z10 || !k0())) || (this.f6751e0 != 1 && i10 != 1)) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(ofFloat);
            }
        } else {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
            ofFloat2.addListener(new c(actionMenuView, i10, z10));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(150L);
            animatorSet.playSequentially(ofFloat2, ofFloat);
            list.add(animatorSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FloatingActionButton g0() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).s(this)) {
            if (view instanceof FloatingActionButton) {
                return (FloatingActionButton) view;
            }
        }
        return null;
    }

    private ActionMenuView getActionMenuView() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    private float getFabTranslationX() {
        return h0(this.f6751e0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationY() {
        return i0(this.f6753g0);
    }

    private int h0(int i10) {
        boolean z10 = a0.z(this) == 1;
        if (i10 == 1) {
            return ((getMeasuredWidth() / 2) - this.W) * (z10 ? -1 : 1);
        }
        return 0;
    }

    private float i0(boolean z10) {
        FloatingActionButton g02 = g0();
        if (g02 == null) {
            return 0.0f;
        }
        Rect rect = new Rect();
        g02.h(rect);
        float height = rect.height();
        if (height == 0.0f) {
            height = g02.getMeasuredHeight();
        }
        float height2 = g02.getHeight() - rect.bottom;
        float height3 = g02.getHeight() - rect.height();
        float f10 = (-getCradleVerticalOffset()) + (height / 2.0f) + height2;
        float paddingBottom = height3 - g02.getPaddingBottom();
        float f11 = -getMeasuredHeight();
        if (!z10) {
            f10 = paddingBottom;
        }
        return f11 + f10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j0() {
        Animator animator;
        Animator animator2;
        Animator animator3 = this.f6748b0;
        return (animator3 != null && animator3.isRunning()) || ((animator = this.f6750d0) != null && animator.isRunning()) || ((animator2 = this.f6749c0) != null && animator2.isRunning());
    }

    private boolean k0() {
        FloatingActionButton g02 = g0();
        return g02 != null && g02.l();
    }

    private void l0(int i10, boolean z10) {
        if (a0.S(this)) {
            Animator animator = this.f6750d0;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!k0()) {
                i10 = 0;
                z10 = false;
            }
            f0(i10, z10, arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.f6750d0 = animatorSet;
            animatorSet.addListener(new b());
            this.f6750d0.start();
        }
    }

    private void m0(int i10) {
        if (this.f6751e0 == i10 || !a0.S(this)) {
            return;
        }
        Animator animator = this.f6749c0;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        d0(i10, arrayList);
        e0(i10, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.f6749c0 = animatorSet;
        animatorSet.addListener(new a());
        this.f6749c0.start();
    }

    private void n0(FloatingActionButton floatingActionButton) {
        floatingActionButton.o(this.f6754h0);
        floatingActionButton.p(this.f6754h0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        getFabTranslationX();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(ActionMenuView actionMenuView, int i10, boolean z10) {
        boolean z11 = a0.z(this) == 1;
        int i11 = 0;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            if ((childAt.getLayoutParams() instanceof Toolbar.e) && (((Toolbar.e) childAt.getLayoutParams()).f603a & 8388615) == 8388611) {
                i11 = Math.max(i11, z11 ? childAt.getLeft() : childAt.getRight());
            }
        }
        actionMenuView.setTranslationX((i10 == 1 && z10) ? i11 - (z11 ? actionMenuView.getRight() : actionMenuView.getLeft()) : 0.0f);
    }

    public ColorStateList getBackgroundTint() {
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<BottomAppBar> getBehavior() {
        return new Behavior();
    }

    public float getCradleVerticalOffset() {
        throw null;
    }

    public int getFabAlignmentMode() {
        return this.f6751e0;
    }

    public float getFabCradleMargin() {
        throw null;
    }

    public float getFabCradleRoundedCornerRadius() {
        throw null;
    }

    public boolean getHideOnScroll() {
        return this.f6752f0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        c0();
        o0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.a());
        this.f6751e0 = dVar.f6763h;
        this.f6753g0 = dVar.f6764i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.f6763h = this.f6751e0;
        dVar.f6764i = this.f6753g0;
        return dVar;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        androidx.core.graphics.drawable.a.o(this.f6747a0, colorStateList);
    }

    public void setCradleVerticalOffset(float f10) {
        if (f10 != getCradleVerticalOffset()) {
            throw null;
        }
    }

    public void setFabAlignmentMode(int i10) {
        m0(i10);
        l0(i10, this.f6753g0);
        this.f6751e0 = i10;
    }

    public void setFabCradleMargin(float f10) {
        if (f10 != getFabCradleMargin()) {
            throw null;
        }
    }

    public void setFabCradleRoundedCornerRadius(float f10) {
        if (f10 != getFabCradleRoundedCornerRadius()) {
            throw null;
        }
    }

    void setFabDiameter(int i10) {
        throw null;
    }

    public void setHideOnScroll(boolean z10) {
        this.f6752f0 = z10;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }
}
