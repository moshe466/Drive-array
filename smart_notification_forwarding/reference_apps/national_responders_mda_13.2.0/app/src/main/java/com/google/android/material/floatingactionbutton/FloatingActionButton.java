package com.google.android.material.floatingactionbutton;

import a3.d;
import a3.k;
import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.p;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.a0;
import androidx.core.view.y;
import androidx.core.widget.o;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.a;
import com.google.android.material.internal.h;
import java.util.List;

@CoordinatorLayout.d(Behavior.class)
/* loaded from: classes.dex */
public class FloatingActionButton extends h implements y, o, e3.a {

    /* renamed from: g, reason: collision with root package name */
    private ColorStateList f6826g;

    /* renamed from: h, reason: collision with root package name */
    private PorterDuff.Mode f6827h;

    /* renamed from: i, reason: collision with root package name */
    private ColorStateList f6828i;

    /* renamed from: j, reason: collision with root package name */
    private PorterDuff.Mode f6829j;

    /* renamed from: k, reason: collision with root package name */
    private ColorStateList f6830k;

    /* renamed from: l, reason: collision with root package name */
    private int f6831l;

    /* renamed from: m, reason: collision with root package name */
    private int f6832m;

    /* renamed from: n, reason: collision with root package name */
    private int f6833n;

    /* renamed from: o, reason: collision with root package name */
    private int f6834o;

    /* renamed from: p, reason: collision with root package name */
    boolean f6835p;

    /* renamed from: q, reason: collision with root package name */
    final Rect f6836q;

    /* renamed from: r, reason: collision with root package name */
    private final Rect f6837r;

    /* renamed from: s, reason: collision with root package name */
    private final p f6838s;

    /* renamed from: t, reason: collision with root package name */
    private com.google.android.material.floatingactionbutton.a f6839t;

    /* loaded from: classes.dex */
    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.c<T> {

        /* renamed from: a, reason: collision with root package name */
        private Rect f6840a;

        /* renamed from: b, reason: collision with root package name */
        private a f6841b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f6842c;

        public BaseBehavior() {
            this.f6842c = true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.f152i);
            this.f6842c = obtainStyledAttributes.getBoolean(k.f154j, true);
            obtainStyledAttributes.recycle();
        }

        private static boolean E(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private void F(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            Rect rect = floatingActionButton.f6836q;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) floatingActionButton.getLayoutParams();
            int i10 = 0;
            int i11 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) fVar).rightMargin ? rect.right : floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) fVar).leftMargin ? -rect.left : 0;
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) {
                i10 = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) fVar).topMargin) {
                i10 = -rect.top;
            }
            if (i10 != 0) {
                a0.Z(floatingActionButton, i10);
            }
            if (i11 != 0) {
                a0.Y(floatingActionButton, i11);
            }
        }

        private boolean I(View view, FloatingActionButton floatingActionButton) {
            return this.f6842c && ((CoordinatorLayout.f) floatingActionButton.getLayoutParams()).e() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean J(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!I(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f6840a == null) {
                this.f6840a = new Rect();
            }
            Rect rect = this.f6840a;
            com.google.android.material.internal.b.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.k(this.f6841b, false);
                return true;
            }
            floatingActionButton.r(this.f6841b, false);
            return true;
        }

        private boolean K(View view, FloatingActionButton floatingActionButton) {
            if (!I(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.k(this.f6841b, false);
                return true;
            }
            floatingActionButton.r(this.f6841b, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        public boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.f6836q;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public boolean h(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                J(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (!E(view)) {
                return false;
            }
            K(view, floatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public boolean l(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i10) {
            List<View> r10 = coordinatorLayout.r(floatingActionButton);
            int size = r10.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view = r10.get(i11);
                if (!(view instanceof AppBarLayout)) {
                    if (E(view) && K(view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (J(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.I(floatingActionButton, i10);
            F(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void g(CoordinatorLayout.f fVar) {
            if (fVar.f2153h == 0) {
                fVar.f2153h = 80;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class a {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements i3.b {
        b() {
        }

        @Override // i3.b
        public void a(int i10, int i11, int i12, int i13) {
            FloatingActionButton.this.f6836q.set(i10, i11, i12, i13);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i10 + floatingActionButton.f6833n, i11 + FloatingActionButton.this.f6833n, i12 + FloatingActionButton.this.f6833n, i13 + FloatingActionButton.this.f6833n);
        }

        @Override // i3.b
        public void b(Drawable drawable) {
            FloatingActionButton.super.setBackgroundDrawable(drawable);
        }

        @Override // i3.b
        public boolean c() {
            return FloatingActionButton.this.f6835p;
        }

        @Override // i3.b
        public float d() {
            return FloatingActionButton.this.getSizeDimension() / 2.0f;
        }
    }

    private com.google.android.material.floatingactionbutton.a g() {
        return Build.VERSION.SDK_INT >= 21 ? new com.google.android.material.floatingactionbutton.b(this, new b()) : new com.google.android.material.floatingactionbutton.a(this, new b());
    }

    private com.google.android.material.floatingactionbutton.a getImpl() {
        if (this.f6839t == null) {
            this.f6839t = g();
        }
        return this.f6839t;
    }

    private int j(int i10) {
        int i11 = this.f6832m;
        if (i11 != 0) {
            return i11;
        }
        Resources resources = getResources();
        if (i10 != -1) {
            return resources.getDimensionPixelSize(i10 != 1 ? d.f109c : d.f108b);
        }
        return Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? j(1) : j(0);
    }

    private void m(Rect rect) {
        int i10 = rect.left;
        Rect rect2 = this.f6836q;
        rect.left = i10 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    private void n() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f6828i;
        if (colorStateList == null) {
            androidx.core.graphics.drawable.a.c(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f6829j;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(androidx.appcompat.widget.k.e(colorForState, mode));
    }

    private static int q(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i10, size);
        }
        if (mode == 0) {
            return i10;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalArgumentException();
    }

    private a.g s(a aVar) {
        return null;
    }

    @Override // e3.a
    public boolean a() {
        throw null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().w(getDrawableState());
    }

    public void e(Animator.AnimatorListener animatorListener) {
        getImpl().a(animatorListener);
    }

    public void f(Animator.AnimatorListener animatorListener) {
        getImpl().b(animatorListener);
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f6826g;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f6827h;
    }

    public float getCompatElevation() {
        return getImpl().j();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().l();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().n();
    }

    public Drawable getContentBackground() {
        return getImpl().g();
    }

    public int getCustomSize() {
        return this.f6832m;
    }

    public int getExpandedComponentIdHint() {
        throw null;
    }

    public b3.h getHideMotionSpec() {
        return getImpl().k();
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f6830k;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f6830k;
    }

    public b3.h getShowMotionSpec() {
        return getImpl().o();
    }

    public int getSize() {
        return this.f6831l;
    }

    int getSizeDimension() {
        return j(this.f6831l);
    }

    @Override // androidx.core.view.y
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // androidx.core.view.y
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // androidx.core.widget.o
    public ColorStateList getSupportImageTintList() {
        return this.f6828i;
    }

    @Override // androidx.core.widget.o
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f6829j;
    }

    public boolean getUseCompatPadding() {
        return this.f6835p;
    }

    @Deprecated
    public boolean h(Rect rect) {
        if (!a0.S(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        m(rect);
        return true;
    }

    public void i(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        m(rect);
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().s();
    }

    void k(a aVar, boolean z10) {
        getImpl().p(s(aVar), z10);
    }

    public boolean l() {
        return getImpl().r();
    }

    public void o(Animator.AnimatorListener animatorListener) {
        getImpl().A(animatorListener);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().t();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().v();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i10, int i11) {
        int sizeDimension = getSizeDimension();
        this.f6833n = (sizeDimension - this.f6834o) / 2;
        getImpl().Q();
        int min = Math.min(q(sizeDimension, i10), q(sizeDimension, i11));
        Rect rect = this.f6836q;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof k3.a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        k3.a aVar = (k3.a) parcelable;
        super.onRestoreInstanceState(aVar.a());
        aVar.f11195h.get("expandableWidgetHelper");
        throw null;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        new k3.a(super.onSaveInstanceState());
        throw null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && h(this.f6837r) && !this.f6837r.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void p(Animator.AnimatorListener animatorListener) {
        getImpl().B(animatorListener);
    }

    void r(a aVar, boolean z10) {
        getImpl().N(s(aVar), z10);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f6826g != colorStateList) {
            this.f6826g = colorStateList;
            getImpl().D(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f6827h != mode) {
            this.f6827h = mode;
            getImpl().E(mode);
        }
    }

    public void setCompatElevation(float f10) {
        getImpl().F(f10);
    }

    public void setCompatElevationResource(int i10) {
        setCompatElevation(getResources().getDimension(i10));
    }

    public void setCompatHoveredFocusedTranslationZ(float f10) {
        getImpl().H(f10);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i10) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i10));
    }

    public void setCompatPressedTranslationZ(float f10) {
        getImpl().J(f10);
    }

    public void setCompatPressedTranslationZResource(int i10) {
        setCompatPressedTranslationZ(getResources().getDimension(i10));
    }

    public void setCustomSize(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        this.f6832m = i10;
    }

    public void setExpandedComponentIdHint(int i10) {
        throw null;
    }

    public void setHideMotionSpec(b3.h hVar) {
        getImpl().G(hVar);
    }

    public void setHideMotionSpecResource(int i10) {
        setHideMotionSpec(b3.h.b(getContext(), i10));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        getImpl().P();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i10) {
        this.f6838s.i(i10);
    }

    public void setRippleColor(int i10) {
        setRippleColor(ColorStateList.valueOf(i10));
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f6830k != colorStateList) {
            this.f6830k = colorStateList;
            getImpl().K(this.f6830k);
        }
    }

    public void setShowMotionSpec(b3.h hVar) {
        getImpl().L(hVar);
    }

    public void setShowMotionSpecResource(int i10) {
        setShowMotionSpec(b3.h.b(getContext(), i10));
    }

    public void setSize(int i10) {
        this.f6832m = 0;
        if (i10 != this.f6831l) {
            this.f6831l = i10;
            requestLayout();
        }
    }

    @Override // androidx.core.view.y
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // androidx.core.view.y
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // androidx.core.widget.o
    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f6828i != colorStateList) {
            this.f6828i = colorStateList;
            n();
        }
    }

    @Override // androidx.core.widget.o
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f6829j != mode) {
            this.f6829j = mode;
            n();
        }
    }

    public void setUseCompatPadding(boolean z10) {
        if (this.f6835p != z10) {
            this.f6835p = z10;
            getImpl().u();
        }
    }
}
