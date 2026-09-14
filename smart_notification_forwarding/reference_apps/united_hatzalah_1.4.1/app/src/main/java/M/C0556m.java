package m;

import F0.b3;
import a.AbstractC0228a;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;

/* renamed from: m.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0556m extends AutoCompleteTextView {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f5720d = {R.attr.popupBackground};

    /* renamed from: a, reason: collision with root package name */
    public final C0558n f5721a;

    /* renamed from: b, reason: collision with root package name */
    public final Z f5722b;

    /* renamed from: c, reason: collision with root package name */
    public final C0522A f5723c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0556m(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.uh.sf.R.attr.autoCompleteTextViewStyle);
        j1.a(context);
        i1.a(this, getContext());
        b3 t3 = b3.t(getContext(), attributeSet, f5720d, com.uh.sf.R.attr.autoCompleteTextViewStyle);
        if (((TypedArray) t3.f470c).hasValue(0)) {
            setDropDownBackgroundDrawable(t3.o(0));
        }
        t3.v();
        C0558n c0558n = new C0558n(this);
        this.f5721a = c0558n;
        c0558n.d(attributeSet, com.uh.sf.R.attr.autoCompleteTextViewStyle);
        Z z3 = new Z(this);
        this.f5722b = z3;
        z3.f(attributeSet, com.uh.sf.R.attr.autoCompleteTextViewStyle);
        z3.b();
        C0522A c0522a = new C0522A(this);
        this.f5723c = c0522a;
        c0522a.b(attributeSet, com.uh.sf.R.attr.autoCompleteTextViewStyle);
        KeyListener keyListener = getKeyListener();
        if (!(keyListener instanceof NumberKeyListener)) {
            boolean isFocusable = super.isFocusable();
            boolean isClickable = super.isClickable();
            boolean isLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener a2 = c0522a.a(keyListener);
            if (a2 != keyListener) {
                super.setKeyListener(a2);
                super.setRawInputType(inputType);
                super.setFocusable(isFocusable);
                super.setClickable(isClickable);
                super.setLongClickable(isLongClickable);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0558n c0558n = this.f5721a;
        if (c0558n != null) {
            c0558n.a();
        }
        Z z3 = this.f5722b;
        if (z3 != null) {
            z3.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return m3.b.S(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0558n c0558n = this.f5721a;
        if (c0558n != null) {
            return c0558n.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0558n c0558n = this.f5721a;
        if (c0558n != null) {
            return c0558n.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f5722b.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f5722b.e();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        m3.b.E(editorInfo, onCreateInputConnection, this);
        return this.f5723c.c(onCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0558n c0558n = this.f5721a;
        if (c0558n != null) {
            c0558n.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0558n c0558n = this.f5721a;
        if (c0558n != null) {
            c0558n.f(i);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        Z z3 = this.f5722b;
        if (z3 != null) {
            z3.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        Z z3 = this.f5722b;
        if (z3 != null) {
            z3.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(m3.b.U(callback, this));
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(AbstractC0228a.q(getContext(), i));
    }

    public void setEmojiCompatEnabled(boolean z3) {
        this.f5723c.d(z3);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f5723c.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0558n c0558n = this.f5721a;
        if (c0558n != null) {
            c0558n.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0558n c0558n = this.f5721a;
        if (c0558n != null) {
            c0558n.i(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        Z z3 = this.f5722b;
        z3.l(colorStateList);
        z3.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        Z z3 = this.f5722b;
        z3.m(mode);
        z3.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        Z z3 = this.f5722b;
        if (z3 != null) {
            z3.g(context, i);
        }
    }
}
