package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MatrixEvaluator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.CircularBorderDrawable;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.google.android.material.shadow.ShadowViewDelegate;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FloatingActionButtonImpl {
    private static final float HIDE_ICON_SCALE = 0.0f;
    private static final float HIDE_OPACITY = 0.0f;
    private static final float HIDE_SCALE = 0.0f;
    private static final float SHOW_ICON_SCALE = 1.0f;
    private static final float SHOW_OPACITY = 1.0f;
    private static final float SHOW_SCALE = 1.0f;
    static final TimeInterpolator q = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
    static final int[] r = {R.attr.state_pressed, R.attr.state_enabled};
    static final int[] s = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    static final int[] t = {R.attr.state_focused, R.attr.state_enabled};
    static final int[] u = {R.attr.state_hovered, R.attr.state_enabled};
    static final int[] v = {R.attr.state_enabled};
    static final int[] w = new int[0];

    @Nullable
    Animator b;

    @Nullable
    MotionSpec c;

    @Nullable
    MotionSpec d;

    @Nullable
    private MotionSpec defaultHideMotionSpec;

    @Nullable
    private MotionSpec defaultShowMotionSpec;
    ShadowDrawableWrapper e;
    Drawable f;
    Drawable g;
    CircularBorderDrawable h;
    private ArrayList<Animator.AnimatorListener> hideListeners;
    Drawable i;
    float j;
    float k;
    float l;
    int m;
    final VisibilityAwareImageButton o;
    final ShadowViewDelegate p;
    private ViewTreeObserver.OnPreDrawListener preDrawListener;
    private float rotation;
    private ArrayList<Animator.AnimatorListener> showListeners;
    int a = 0;
    float n = 1.0f;
    private final Rect tmpRect = new Rect();
    private final RectF tmpRectF1 = new RectF();
    private final RectF tmpRectF2 = new RectF();
    private final Matrix tmpMatrix = new Matrix();
    private final StateListAnimator stateListAnimator = new StateListAnimator();

    /* loaded from: classes.dex */
    private class DisabledElevationAnimation extends ShadowAnimatorImpl {
        DisabledElevationAnimation(FloatingActionButtonImpl floatingActionButtonImpl) {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        protected float a() {
            return 0.0f;
        }
    }

    /* loaded from: classes.dex */
    private class ElevateToHoveredFocusedTranslationZAnimation extends ShadowAnimatorImpl {
        ElevateToHoveredFocusedTranslationZAnimation() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        protected float a() {
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            return floatingActionButtonImpl.j + floatingActionButtonImpl.k;
        }
    }

    /* loaded from: classes.dex */
    private class ElevateToPressedTranslationZAnimation extends ShadowAnimatorImpl {
        ElevateToPressedTranslationZAnimation() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        protected float a() {
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            return floatingActionButtonImpl.j + floatingActionButtonImpl.l;
        }
    }

    /* loaded from: classes.dex */
    interface InternalVisibilityChangedListener {
        void onHidden();

        void onShown();
    }

    /* loaded from: classes.dex */
    private class ResetElevationAnimation extends ShadowAnimatorImpl {
        ResetElevationAnimation() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        protected float a() {
            return FloatingActionButtonImpl.this.j;
        }
    }

    /* loaded from: classes.dex */
    private abstract class ShadowAnimatorImpl extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        private float shadowSizeEnd;
        private float shadowSizeStart;
        private boolean validValues;

        private ShadowAnimatorImpl() {
        }

        protected abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FloatingActionButtonImpl.this.e.setShadowSize(this.shadowSizeEnd);
            this.validValues = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.validValues) {
                this.shadowSizeStart = FloatingActionButtonImpl.this.e.getShadowSize();
                this.shadowSizeEnd = a();
                this.validValues = true;
            }
            ShadowDrawableWrapper shadowDrawableWrapper = FloatingActionButtonImpl.this.e;
            float f = this.shadowSizeStart;
            shadowDrawableWrapper.setShadowSize(f + ((this.shadowSizeEnd - f) * valueAnimator.getAnimatedFraction()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FloatingActionButtonImpl(VisibilityAwareImageButton visibilityAwareImageButton, ShadowViewDelegate shadowViewDelegate) {
        this.o = visibilityAwareImageButton;
        this.p = shadowViewDelegate;
        this.stateListAnimator.addState(r, createElevationAnimator(new ElevateToPressedTranslationZAnimation()));
        this.stateListAnimator.addState(s, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation()));
        this.stateListAnimator.addState(t, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation()));
        this.stateListAnimator.addState(u, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation()));
        this.stateListAnimator.addState(v, createElevationAnimator(new ResetElevationAnimation()));
        this.stateListAnimator.addState(w, createElevationAnimator(new DisabledElevationAnimation(this)));
        this.rotation = this.o.getRotation();
    }

    private void calculateImageMatrixFromScale(float f, Matrix matrix) {
        matrix.reset();
        if (this.o.getDrawable() == null || this.m == 0) {
            return;
        }
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int i = this.m;
        rectF2.set(0.0f, 0.0f, i, i);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i2 = this.m;
        matrix.postScale(f, f, i2 / 2.0f, i2 / 2.0f);
    }

    @NonNull
    private AnimatorSet createAnimator(@NonNull MotionSpec motionSpec, float f, float f2, float f3) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.o, (Property<VisibilityAwareImageButton, Float>) View.ALPHA, f);
        motionSpec.getTiming("opacity").apply(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.o, (Property<VisibilityAwareImageButton, Float>) View.SCALE_X, f2);
        motionSpec.getTiming("scale").apply(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.o, (Property<VisibilityAwareImageButton, Float>) View.SCALE_Y, f2);
        motionSpec.getTiming("scale").apply(ofFloat3);
        arrayList.add(ofFloat3);
        calculateImageMatrixFromScale(f3, this.tmpMatrix);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.o, new ImageMatrixProperty(), new MatrixEvaluator(), new Matrix(this.tmpMatrix));
        motionSpec.getTiming("iconScale").apply(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    private ValueAnimator createElevationAnimator(@NonNull ShadowAnimatorImpl shadowAnimatorImpl) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(q);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(shadowAnimatorImpl);
        valueAnimator.addUpdateListener(shadowAnimatorImpl);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    private void ensurePreDrawListener() {
        if (this.preDrawListener == null) {
            this.preDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.3
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    FloatingActionButtonImpl.this.o();
                    return true;
                }
            };
        }
    }

    private MotionSpec getDefaultHideMotionSpec() {
        if (this.defaultHideMotionSpec == null) {
            this.defaultHideMotionSpec = MotionSpec.createFromResource(this.o.getContext(), com.google.android.material.R.animator.design_fab_hide_motion_spec);
        }
        return this.defaultHideMotionSpec;
    }

    private MotionSpec getDefaultShowMotionSpec() {
        if (this.defaultShowMotionSpec == null) {
            this.defaultShowMotionSpec = MotionSpec.createFromResource(this.o.getContext(), com.google.android.material.R.animator.design_fab_show_motion_spec);
        }
        return this.defaultShowMotionSpec;
    }

    private boolean shouldAnimateVisibilityChange() {
        return ViewCompat.isLaidOut(this.o) && !this.o.isInEditMode();
    }

    private void updateFromViewRotation() {
        VisibilityAwareImageButton visibilityAwareImageButton;
        int i;
        if (Build.VERSION.SDK_INT == 19) {
            if (this.rotation % 90.0f != 0.0f) {
                i = 1;
                if (this.o.getLayerType() != 1) {
                    visibilityAwareImageButton = this.o;
                    visibilityAwareImageButton.setLayerType(i, null);
                }
            } else if (this.o.getLayerType() != 0) {
                visibilityAwareImageButton = this.o;
                i = 0;
                visibilityAwareImageButton.setLayerType(i, null);
            }
        }
        ShadowDrawableWrapper shadowDrawableWrapper = this.e;
        if (shadowDrawableWrapper != null) {
            shadowDrawableWrapper.setRotation(-this.rotation);
        }
        CircularBorderDrawable circularBorderDrawable = this.h;
        if (circularBorderDrawable != null) {
            circularBorderDrawable.setRotation(-this.rotation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GradientDrawable a() {
        GradientDrawable k = k();
        k.setShape(1);
        k.setColor(-1);
        return k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CircularBorderDrawable a(int i, ColorStateList colorStateList) {
        Context context = this.o.getContext();
        CircularBorderDrawable j = j();
        j.setGradientColors(ContextCompat.getColor(context, com.google.android.material.R.color.design_fab_stroke_top_outer_color), ContextCompat.getColor(context, com.google.android.material.R.color.design_fab_stroke_top_inner_color), ContextCompat.getColor(context, com.google.android.material.R.color.design_fab_stroke_end_inner_color), ContextCompat.getColor(context, com.google.android.material.R.color.design_fab_stroke_end_outer_color));
        j.setBorderWidth(i);
        j.setBorderTint(colorStateList);
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(float f) {
        if (this.j != f) {
            this.j = f;
            a(this.j, this.k, this.l);
        }
    }

    void a(float f, float f2, float f3) {
        ShadowDrawableWrapper shadowDrawableWrapper = this.e;
        if (shadowDrawableWrapper != null) {
            shadowDrawableWrapper.setShadowSize(f, this.l + f);
            r();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i) {
        if (this.m != i) {
            this.m = i;
            q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.showListeners == null) {
            this.showListeners = new ArrayList<>();
        }
        this.showListeners.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        Drawable drawable = this.f;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
        }
        CircularBorderDrawable circularBorderDrawable = this.h;
        if (circularBorderDrawable != null) {
            circularBorderDrawable.setBorderTint(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Drawable[] drawableArr;
        this.f = DrawableCompat.wrap(a());
        DrawableCompat.setTintList(this.f, colorStateList);
        if (mode != null) {
            DrawableCompat.setTintMode(this.f, mode);
        }
        this.g = DrawableCompat.wrap(a());
        DrawableCompat.setTintList(this.g, RippleUtils.convertToRippleDrawableColor(colorStateList2));
        if (i > 0) {
            this.h = a(i, colorStateList);
            drawableArr = new Drawable[]{this.h, this.f, this.g};
        } else {
            this.h = null;
            drawableArr = new Drawable[]{this.f, this.g};
        }
        this.i = new LayerDrawable(drawableArr);
        Context context = this.o.getContext();
        Drawable drawable = this.i;
        float radius = this.p.getRadius();
        float f = this.j;
        this.e = new ShadowDrawableWrapper(context, drawable, radius, f, f + this.l);
        this.e.setAddPaddingForCorners(false);
        this.p.setBackgroundDrawable(this.e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        Drawable drawable = this.f;
        if (drawable != null) {
            DrawableCompat.setTintMode(drawable, mode);
        }
    }

    void a(Rect rect) {
        this.e.getPadding(rect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(@Nullable MotionSpec motionSpec) {
        this.d = motionSpec;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@Nullable final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean z) {
        if (g()) {
            return;
        }
        Animator animator = this.b;
        if (animator != null) {
            animator.cancel();
        }
        if (!shouldAnimateVisibilityChange()) {
            this.o.internalSetVisibility(z ? 8 : 4, z);
            if (internalVisibilityChangedListener != null) {
                internalVisibilityChangedListener.onHidden();
                return;
            }
            return;
        }
        MotionSpec motionSpec = this.d;
        if (motionSpec == null) {
            motionSpec = getDefaultHideMotionSpec();
        }
        AnimatorSet createAnimator = createAnimator(motionSpec, 0.0f, 0.0f, 0.0f);
        createAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.1
            private boolean cancelled;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                this.cancelled = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                floatingActionButtonImpl.a = 0;
                floatingActionButtonImpl.b = null;
                if (this.cancelled) {
                    return;
                }
                floatingActionButtonImpl.o.internalSetVisibility(z ? 8 : 4, z);
                InternalVisibilityChangedListener internalVisibilityChangedListener2 = internalVisibilityChangedListener;
                if (internalVisibilityChangedListener2 != null) {
                    internalVisibilityChangedListener2.onHidden();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                FloatingActionButtonImpl.this.o.internalSetVisibility(0, z);
                FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                floatingActionButtonImpl.a = 1;
                floatingActionButtonImpl.b = animator2;
                this.cancelled = false;
            }
        });
        ArrayList<Animator.AnimatorListener> arrayList = this.hideListeners;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                createAnimator.addListener(it.next());
            }
        }
        createAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int[] iArr) {
        this.stateListAnimator.setState(iArr);
    }

    public void addOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.hideListeners == null) {
            this.hideListeners = new ArrayList<>();
        }
        this.hideListeners.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Drawable b() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(float f) {
        if (this.k != f) {
            this.k = f;
            a(this.j, this.k, this.l);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@NonNull Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.showListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        Drawable drawable = this.g;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, RippleUtils.convertToRippleDrawableColor(colorStateList));
        }
    }

    void b(Rect rect) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(@Nullable MotionSpec motionSpec) {
        this.c = motionSpec;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean z) {
        if (h()) {
            return;
        }
        Animator animator = this.b;
        if (animator != null) {
            animator.cancel();
        }
        if (!shouldAnimateVisibilityChange()) {
            this.o.internalSetVisibility(0, z);
            this.o.setAlpha(1.0f);
            this.o.setScaleY(1.0f);
            this.o.setScaleX(1.0f);
            c(1.0f);
            if (internalVisibilityChangedListener != null) {
                internalVisibilityChangedListener.onShown();
                return;
            }
            return;
        }
        if (this.o.getVisibility() != 0) {
            this.o.setAlpha(0.0f);
            this.o.setScaleY(0.0f);
            this.o.setScaleX(0.0f);
            c(0.0f);
        }
        MotionSpec motionSpec = this.c;
        if (motionSpec == null) {
            motionSpec = getDefaultShowMotionSpec();
        }
        AnimatorSet createAnimator = createAnimator(motionSpec, 1.0f, 1.0f, 1.0f);
        createAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                floatingActionButtonImpl.a = 0;
                floatingActionButtonImpl.b = null;
                InternalVisibilityChangedListener internalVisibilityChangedListener2 = internalVisibilityChangedListener;
                if (internalVisibilityChangedListener2 != null) {
                    internalVisibilityChangedListener2.onShown();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                FloatingActionButtonImpl.this.o.internalSetVisibility(0, z);
                FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                floatingActionButtonImpl.a = 2;
                floatingActionButtonImpl.b = animator2;
            }
        });
        ArrayList<Animator.AnimatorListener> arrayList = this.showListeners;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                createAnimator.addListener(it.next());
            }
        }
        createAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final MotionSpec c() {
        return this.d;
    }

    final void c(float f) {
        this.n = f;
        Matrix matrix = this.tmpMatrix;
        calculateImageMatrixFromScale(f, matrix);
        this.o.setImageMatrix(matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(float f) {
        if (this.l != f) {
            this.l = f;
            a(this.j, this.k, this.l);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final MotionSpec f() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return this.o.getVisibility() == 0 ? this.a == 1 : this.a != 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getElevation() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        return this.o.getVisibility() != 0 ? this.a == 2 : this.a != 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        this.stateListAnimator.jumpToCurrentState();
    }

    CircularBorderDrawable j() {
        return new CircularBorderDrawable();
    }

    GradientDrawable k() {
        return new GradientDrawable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        if (p()) {
            ensurePreDrawListener();
            this.o.getViewTreeObserver().addOnPreDrawListener(this.preDrawListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        if (this.preDrawListener != null) {
            this.o.getViewTreeObserver().removeOnPreDrawListener(this.preDrawListener);
            this.preDrawListener = null;
        }
    }

    void o() {
        float rotation = this.o.getRotation();
        if (this.rotation != rotation) {
            this.rotation = rotation;
            updateFromViewRotation();
        }
    }

    boolean p() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void q() {
        c(this.n);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void r() {
        Rect rect = this.tmpRect;
        a(rect);
        b(rect);
        this.p.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void removeOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.hideListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }
}
