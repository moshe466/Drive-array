package m;

import a.AbstractC0228a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.uh.sf.R;

/* renamed from: m.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0562p extends CheckBox {

    /* renamed from: a, reason: collision with root package name */
    public final r f5744a;

    /* renamed from: b, reason: collision with root package name */
    public final C0558n f5745b;

    /* renamed from: c, reason: collision with root package name */
    public final Z f5746c;

    /* renamed from: d, reason: collision with root package name */
    public C0573v f5747d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0562p(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.checkboxStyle);
        j1.a(context);
        i1.a(this, getContext());
        r rVar = new r(this);
        this.f5744a = rVar;
        rVar.c(attributeSet, R.attr.checkboxStyle);
        C0558n c0558n = new C0558n(this);
        this.f5745b = c0558n;
        c0558n.d(attributeSet, R.attr.checkboxStyle);
        Z z3 = new Z(this);
        this.f5746c = z3;
        z3.f(attributeSet, R.attr.checkboxStyle);
        getEmojiTextViewHelper().b(attributeSet, R.attr.checkboxStyle);
    }

    private C0573v getEmojiTextViewHelper() {
        if (this.f5747d == null) {
            this.f5747d = new C0573v(this);
        }
        return this.f5747d;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0558n c0558n = this.f5745b;
        if (c0558n != null) {
            c0558n.a();
        }
        Z z3 = this.f5746c;
        if (z3 != null) {
            z3.b();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        r rVar = this.f5744a;
        if (rVar != null) {
            rVar.getClass();
        }
        return compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0558n c0558n = this.f5745b;
        if (c0558n != null) {
            return c0558n.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0558n c0558n = this.f5745b;
        if (c0558n != null) {
            return c0558n.c();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        r rVar = this.f5744a;
        if (rVar != null) {
            return rVar.f5757a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        r rVar = this.f5744a;
        if (rVar != null) {
            return rVar.f5758b;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f5746c.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f5746c.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z3) {
        super.setAllCaps(z3);
        getEmojiTextViewHelper().c(z3);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0558n c0558n = this.f5745b;
        if (c0558n != null) {
            c0558n.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0558n c0558n = this.f5745b;
        if (c0558n != null) {
            c0558n.f(i);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        r rVar = this.f5744a;
        if (rVar != null) {
            if (rVar.f5761e) {
                rVar.f5761e = false;
            } else {
                rVar.f5761e = true;
                rVar.a();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        Z z3 = this.f5746c;
        if (z3 != null) {
            z3.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        Z z3 = this.f5746c;
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
        C0558n c0558n = this.f5745b;
        if (c0558n != null) {
            c0558n.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0558n c0558n = this.f5745b;
        if (c0558n != null) {
            c0558n.i(mode);
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        r rVar = this.f5744a;
        if (rVar != null) {
            rVar.f5757a = colorStateList;
            rVar.f5759c = true;
            rVar.a();
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        r rVar = this.f5744a;
        if (rVar != null) {
            rVar.f5758b = mode;
            rVar.f5760d = true;
            rVar.a();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        Z z3 = this.f5746c;
        z3.l(colorStateList);
        z3.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        Z z3 = this.f5746c;
        z3.m(mode);
        z3.b();
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(AbstractC0228a.q(getContext(), i));
    }
}
