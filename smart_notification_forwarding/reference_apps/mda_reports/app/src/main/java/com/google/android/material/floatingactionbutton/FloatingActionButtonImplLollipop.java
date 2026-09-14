package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.material.internal.CircularBorderDrawable;
import com.google.android.material.internal.CircularBorderDrawableLollipop;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.google.android.material.shadow.ShadowViewDelegate;
import java.util.ArrayList;

@RequiresApi(21)
/* loaded from: classes.dex */
class FloatingActionButtonImplLollipop extends FloatingActionButtonImpl {
    private InsetDrawable insetDrawable;

    /* loaded from: classes.dex */
    static class AlwaysStatefulGradientDrawable extends GradientDrawable {
        AlwaysStatefulGradientDrawable() {
        }

        @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FloatingActionButtonImplLollipop(VisibilityAwareImageButton visibilityAwareImageButton, ShadowViewDelegate shadowViewDelegate) {
        super(visibilityAwareImageButton, shadowViewDelegate);
    }

    @NonNull
    private Animator createElevationAnimator(float f, float f2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.o, "elevation", f).setDuration(0L)).with(ObjectAnimator.ofFloat(this.o, (Property<VisibilityAwareImageButton, Float>) View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet.setInterpolator(FloatingActionButtonImpl.q);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void a(float f, float f2, float f3) {
        if (Build.VERSION.SDK_INT == 21) {
            this.o.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(FloatingActionButtonImpl.r, createElevationAnimator(f, f3));
            stateListAnimator.addState(FloatingActionButtonImpl.s, createElevationAnimator(f, f2));
            stateListAnimator.addState(FloatingActionButtonImpl.t, createElevationAnimator(f, f2));
            stateListAnimator.addState(FloatingActionButtonImpl.u, createElevationAnimator(f, f2));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.o, "elevation", f).setDuration(0L));
            int i = Build.VERSION.SDK_INT;
            if (i >= 22 && i <= 24) {
                VisibilityAwareImageButton visibilityAwareImageButton = this.o;
                arrayList.add(ObjectAnimator.ofFloat(visibilityAwareImageButton, (Property<VisibilityAwareImageButton, Float>) View.TRANSLATION_Z, visibilityAwareImageButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.o, (Property<VisibilityAwareImageButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(FloatingActionButtonImpl.q);
            stateListAnimator.addState(FloatingActionButtonImpl.v, animatorSet);
            stateListAnimator.addState(FloatingActionButtonImpl.w, createElevationAnimator(0.0f, 0.0f));
            this.o.setStateListAnimator(stateListAnimator);
        }
        if (this.p.isCompatPaddingEnabled()) {
            r();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void a(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Drawable drawable;
        this.f = DrawableCompat.wrap(a());
        DrawableCompat.setTintList(this.f, colorStateList);
        if (mode != null) {
            DrawableCompat.setTintMode(this.f, mode);
        }
        if (i > 0) {
            this.h = a(i, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{this.h, this.f});
        } else {
            this.h = null;
            drawable = this.f;
        }
        this.g = new RippleDrawable(RippleUtils.convertToRippleDrawableColor(colorStateList2), drawable, null);
        Drawable drawable2 = this.g;
        this.i = drawable2;
        this.p.setBackgroundDrawable(drawable2);
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void a(Rect rect) {
        if (!this.p.isCompatPaddingEnabled()) {
            rect.set(0, 0, 0, 0);
            return;
        }
        float radius = this.p.getRadius();
        float elevation = getElevation() + this.l;
        int ceil = (int) Math.ceil(ShadowDrawableWrapper.calculateHorizontalPadding(elevation, radius, false));
        int ceil2 = (int) Math.ceil(ShadowDrawableWrapper.calculateVerticalPadding(elevation, radius, false));
        rect.set(ceil, ceil2, ceil, ceil2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void a(int[] iArr) {
        VisibilityAwareImageButton visibilityAwareImageButton;
        if (Build.VERSION.SDK_INT == 21) {
            float f = 0.0f;
            if (this.o.isEnabled()) {
                this.o.setElevation(this.j);
                if (this.o.isPressed()) {
                    visibilityAwareImageButton = this.o;
                    f = this.l;
                } else if (this.o.isFocused() || this.o.isHovered()) {
                    visibilityAwareImageButton = this.o;
                    f = this.k;
                }
                visibilityAwareImageButton.setTranslationZ(f);
            }
            this.o.setElevation(0.0f);
            visibilityAwareImageButton = this.o;
            visibilityAwareImageButton.setTranslationZ(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void b(ColorStateList colorStateList) {
        Drawable drawable = this.g;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(RippleUtils.convertToRippleDrawableColor(colorStateList));
        } else {
            super.b(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void b(Rect rect) {
        ShadowViewDelegate shadowViewDelegate;
        Drawable drawable;
        if (this.p.isCompatPaddingEnabled()) {
            this.insetDrawable = new InsetDrawable(this.g, rect.left, rect.top, rect.right, rect.bottom);
            shadowViewDelegate = this.p;
            drawable = this.insetDrawable;
        } else {
            shadowViewDelegate = this.p;
            drawable = this.g;
        }
        shadowViewDelegate.setBackgroundDrawable(drawable);
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public float getElevation() {
        return this.o.getElevation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void i() {
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    CircularBorderDrawable j() {
        return new CircularBorderDrawableLollipop();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    GradientDrawable k() {
        return new AlwaysStatefulGradientDrawable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void m() {
        r();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    boolean p() {
        return false;
    }
}
