package m;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.uh.sf.R;

/* renamed from: m.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0560o extends Button {

    /* renamed from: a, reason: collision with root package name */
    public final C0558n f5733a;

    /* renamed from: b, reason: collision with root package name */
    public final Z f5734b;

    /* renamed from: c, reason: collision with root package name */
    public C0573v f5735c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0560o(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.buttonStyle);
        j1.a(context);
        i1.a(this, getContext());
        C0558n c0558n = new C0558n(this);
        this.f5733a = c0558n;
        c0558n.d(attributeSet, R.attr.buttonStyle);
        Z z3 = new Z(this);
        this.f5734b = z3;
        z3.f(attributeSet, R.attr.buttonStyle);
        z3.b();
        getEmojiTextViewHelper().b(attributeSet, R.attr.buttonStyle);
    }

    private C0573v getEmojiTextViewHelper() {
        if (this.f5735c == null) {
            this.f5735c = new C0573v(this);
        }
        return this.f5735c;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0558n c0558n = this.f5733a;
        if (c0558n != null) {
            c0558n.a();
        }
        Z z3 = this.f5734b;
        if (z3 != null) {
            z3.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (z1.f5854b) {
            return super.getAutoSizeMaxTextSize();
        }
        Z z3 = this.f5734b;
        if (z3 != null) {
            return Math.round(z3.i.f5702e);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (z1.f5854b) {
            return super.getAutoSizeMinTextSize();
        }
        Z z3 = this.f5734b;
        if (z3 != null) {
            return Math.round(z3.i.f5701d);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (z1.f5854b) {
            return super.getAutoSizeStepGranularity();
        }
        Z z3 = this.f5734b;
        if (z3 != null) {
            return Math.round(z3.i.f5700c);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (z1.f5854b) {
            return super.getAutoSizeTextAvailableSizes();
        }
        Z z3 = this.f5734b;
        if (z3 != null) {
            return z3.i.f5703f;
        }
        return new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (z1.f5854b) {
            if (super.getAutoSizeTextType() != 1) {
                return 0;
            }
            return 1;
        }
        Z z3 = this.f5734b;
        if (z3 == null) {
            return 0;
        }
        return z3.i.f5698a;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return m3.b.S(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0558n c0558n = this.f5733a;
        if (c0558n != null) {
            return c0558n.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0558n c0558n = this.f5733a;
        if (c0558n != null) {
            return c0558n.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f5734b.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f5734b.e();
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z3, int i, int i3, int i4, int i5) {
        super.onLayout(z3, i, i3, i4, i5);
        Z z4 = this.f5734b;
        if (z4 != null && !z1.f5854b) {
            z4.i.a();
        }
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i, int i3, int i4) {
        super.onTextChanged(charSequence, i, i3, i4);
        Z z3 = this.f5734b;
        if (z3 != null) {
            C0551j0 c0551j0 = z3.i;
            if (!z1.f5854b && c0551j0.e()) {
                c0551j0.a();
            }
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z3) {
        super.setAllCaps(z3);
        getEmojiTextViewHelper().c(z3);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i, int i3, int i4, int i5) {
        if (z1.f5854b) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i3, i4, i5);
            return;
        }
        Z z3 = this.f5734b;
        if (z3 != null) {
            z3.i(i, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (z1.f5854b) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        Z z3 = this.f5734b;
        if (z3 != null) {
            z3.j(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (z1.f5854b) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        Z z3 = this.f5734b;
        if (z3 != null) {
            z3.k(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0558n c0558n = this.f5733a;
        if (c0558n != null) {
            c0558n.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0558n c0558n = this.f5733a;
        if (c0558n != null) {
            c0558n.f(i);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(m3.b.U(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z3) {
        getEmojiTextViewHelper().d(z3);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z3) {
        Z z4 = this.f5734b;
        if (z4 != null) {
            z4.f5611a.setAllCaps(z3);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0558n c0558n = this.f5733a;
        if (c0558n != null) {
            c0558n.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0558n c0558n = this.f5733a;
        if (c0558n != null) {
            c0558n.i(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        Z z3 = this.f5734b;
        z3.l(colorStateList);
        z3.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        Z z3 = this.f5734b;
        z3.m(mode);
        z3.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        Z z3 = this.f5734b;
        if (z3 != null) {
            z3.g(context, i);
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i, float f4) {
        boolean z3 = z1.f5854b;
        if (z3) {
            super.setTextSize(i, f4);
            return;
        }
        Z z4 = this.f5734b;
        if (z4 != null) {
            C0551j0 c0551j0 = z4.i;
            if (!z3 && !c0551j0.e()) {
                c0551j0.f(i, f4);
            }
        }
    }
}
