package m;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* renamed from: m.k0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0553k0 extends ToggleButton {

    /* renamed from: a, reason: collision with root package name */
    public final C0558n f5715a;

    /* renamed from: b, reason: collision with root package name */
    public final Z f5716b;

    /* renamed from: c, reason: collision with root package name */
    public C0573v f5717c;

    public C0553k0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.buttonStyleToggle);
        i1.a(this, getContext());
        C0558n c0558n = new C0558n(this);
        this.f5715a = c0558n;
        c0558n.d(attributeSet, R.attr.buttonStyleToggle);
        Z z3 = new Z(this);
        this.f5716b = z3;
        z3.f(attributeSet, R.attr.buttonStyleToggle);
        getEmojiTextViewHelper().b(attributeSet, R.attr.buttonStyleToggle);
    }

    private C0573v getEmojiTextViewHelper() {
        if (this.f5717c == null) {
            this.f5717c = new C0573v(this);
        }
        return this.f5717c;
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0558n c0558n = this.f5715a;
        if (c0558n != null) {
            c0558n.a();
        }
        Z z3 = this.f5716b;
        if (z3 != null) {
            z3.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0558n c0558n = this.f5715a;
        if (c0558n != null) {
            return c0558n.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0558n c0558n = this.f5715a;
        if (c0558n != null) {
            return c0558n.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f5716b.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f5716b.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z3) {
        super.setAllCaps(z3);
        getEmojiTextViewHelper().c(z3);
    }

    @Override // android.widget.ToggleButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0558n c0558n = this.f5715a;
        if (c0558n != null) {
            c0558n.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0558n c0558n = this.f5715a;
        if (c0558n != null) {
            c0558n.f(i);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        Z z3 = this.f5716b;
        if (z3 != null) {
            z3.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        Z z3 = this.f5716b;
        if (z3 != null) {
            z3.b();
        }
    }

    public void setEmojiCompatEnabled(boolean z3) {
        getEmojiTextViewHelper().d(z3);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0558n c0558n = this.f5715a;
        if (c0558n != null) {
            c0558n.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0558n c0558n = this.f5715a;
        if (c0558n != null) {
            c0558n.i(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        Z z3 = this.f5716b;
        z3.l(colorStateList);
        z3.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        Z z3 = this.f5716b;
        z3.m(mode);
        z3.b();
    }
}
