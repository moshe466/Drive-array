package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import com.google.android.material.internal.h;
import java.util.ArrayList;

/* loaded from: classes.dex */
class b extends a {
    private InsetDrawable H;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(h hVar, i3.b bVar) {
        super(hVar, bVar);
    }

    private Animator R(float f10, float f11) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f6863t, "elevation", f10).setDuration(0L)).with(ObjectAnimator.ofFloat(this.f6863t, (Property<h, Float>) View.TRANSLATION_Z, f11).setDuration(100L));
        animatorSet.setInterpolator(a.A);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.a
    boolean C() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.a
    public void K(ColorStateList colorStateList) {
        Drawable drawable = this.f6854k;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(h3.a.a(colorStateList));
        } else {
            super.K(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public float j() {
        return this.f6863t.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void m(Rect rect) {
        if (!this.f6864u.c()) {
            rect.set(0, 0, 0, 0);
            return;
        }
        float d10 = this.f6864u.d();
        float j10 = j() + this.f6858o;
        int ceil = (int) Math.ceil(i3.a.c(j10, d10, false));
        int ceil2 = (int) Math.ceil(i3.a.d(j10, d10, false));
        rect.set(ceil, ceil2, ceil, ceil2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.a
    public void s() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.a
    public void u() {
        Q();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.a
    public void w(int[] iArr) {
        h hVar;
        if (Build.VERSION.SDK_INT == 21) {
            float f10 = 0.0f;
            if (this.f6863t.isEnabled()) {
                this.f6863t.setElevation(this.f6856m);
                if (this.f6863t.isPressed()) {
                    hVar = this.f6863t;
                    f10 = this.f6858o;
                } else if (this.f6863t.isFocused() || this.f6863t.isHovered()) {
                    hVar = this.f6863t;
                    f10 = this.f6857n;
                }
                hVar.setTranslationZ(f10);
            }
            this.f6863t.setElevation(0.0f);
            hVar = this.f6863t;
            hVar.setTranslationZ(f10);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void x(float f10, float f11, float f12) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 == 21) {
            this.f6863t.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(a.B, R(f10, f12));
            stateListAnimator.addState(a.C, R(f10, f11));
            stateListAnimator.addState(a.D, R(f10, f11));
            stateListAnimator.addState(a.E, R(f10, f11));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.f6863t, "elevation", f10).setDuration(0L));
            if (i10 >= 22 && i10 <= 24) {
                h hVar = this.f6863t;
                arrayList.add(ObjectAnimator.ofFloat(hVar, (Property<h, Float>) View.TRANSLATION_Z, hVar.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.f6863t, (Property<h, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(a.A);
            stateListAnimator.addState(a.F, animatorSet);
            stateListAnimator.addState(a.G, R(0.0f, 0.0f));
            this.f6863t.setStateListAnimator(stateListAnimator);
        }
        if (this.f6864u.c()) {
            Q();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void y(Rect rect) {
        i3.b bVar;
        Drawable drawable;
        if (this.f6864u.c()) {
            InsetDrawable insetDrawable = new InsetDrawable(this.f6854k, rect.left, rect.top, rect.right, rect.bottom);
            this.H = insetDrawable;
            drawable = insetDrawable;
            bVar = this.f6864u;
        } else {
            i3.b bVar2 = this.f6864u;
            drawable = this.f6854k;
            bVar = bVar2;
        }
        bVar.b(drawable);
    }
}
