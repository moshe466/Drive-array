package m;

import F0.G1;
import a.AbstractC0228a;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* renamed from: m.c0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0537c0 extends TextView {

    /* renamed from: a, reason: collision with root package name */
    public final C0558n f5627a;

    /* renamed from: b, reason: collision with root package name */
    public final Z f5628b;

    /* renamed from: c, reason: collision with root package name */
    public final C0522A f5629c;

    /* renamed from: d, reason: collision with root package name */
    public C0573v f5630d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5631e;

    /* renamed from: f, reason: collision with root package name */
    public G1 f5632f;

    /* renamed from: j, reason: collision with root package name */
    public Future f5633j;

    public C0537c0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    private C0573v getEmojiTextViewHelper() {
        if (this.f5630d == null) {
            this.f5630d = new C0573v(this);
        }
        return this.f5630d;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0558n c0558n = this.f5627a;
        if (c0558n != null) {
            c0558n.a();
        }
        Z z3 = this.f5628b;
        if (z3 != null) {
            z3.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (z1.f5854b) {
            return super.getAutoSizeMaxTextSize();
        }
        Z z3 = this.f5628b;
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
        Z z3 = this.f5628b;
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
        Z z3 = this.f5628b;
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
        Z z3 = this.f5628b;
        if (z3 != null) {
            return z3.i.f5703f;
        }
        return new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (z1.f5854b) {
            if (super.getAutoSizeTextType() == 1) {
                return 1;
            }
            return 0;
        }
        Z z3 = this.f5628b;
        if (z3 != null) {
            return z3.i.f5698a;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return m3.b.S(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public InterfaceC0533a0 getSuperCaller() {
        if (this.f5632f == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                this.f5632f = new C0535b0(this);
            } else if (i >= 26) {
                this.f5632f = new G1(this, 22);
            }
        }
        return this.f5632f;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0558n c0558n = this.f5627a;
        if (c0558n != null) {
            return c0558n.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0558n c0558n = this.f5627a;
        if (c0558n != null) {
            return c0558n.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f5628b.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f5628b.e();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        Future future = this.f5633j;
        if (future != null) {
            try {
                this.f5633j = null;
                if (future.get() == null) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        throw null;
                    }
                    m3.b.v(this);
                    throw null;
                }
                throw new ClassCastException();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        C0522A c0522a;
        if (Build.VERSION.SDK_INT < 28 && (c0522a = this.f5629c) != null) {
            TextClassifier textClassifier = (TextClassifier) c0522a.f5496c;
            if (textClassifier == null) {
                return T.a((TextView) c0522a.f5495b);
            }
            return textClassifier;
        }
        return super.getTextClassifier();
    }

    public H.a getTextMetricsParamsCompat() {
        return m3.b.v(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f5628b.getClass();
        Z.h(editorInfo, onCreateInputConnection, this);
        m3.b.E(editorInfo, onCreateInputConnection, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z3, int i, int i3, int i4, int i5) {
        super.onLayout(z3, i, i3, i4, i5);
        Z z4 = this.f5628b;
        if (z4 != null && !z1.f5854b) {
            z4.i.a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i3) {
        Future future = this.f5633j;
        if (future != null) {
            try {
                this.f5633j = null;
                if (future.get() == null) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        throw null;
                    }
                    m3.b.v(this);
                    throw null;
                }
                throw new ClassCastException();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        super.onMeasure(i, i3);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i, int i3, int i4) {
        super.onTextChanged(charSequence, i, i3, i4);
        Z z3 = this.f5628b;
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
        Z z3 = this.f5628b;
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
        Z z3 = this.f5628b;
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
        Z z3 = this.f5628b;
        if (z3 != null) {
            z3.k(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0558n c0558n = this.f5627a;
        if (c0558n != null) {
            c0558n.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0558n c0558n = this.f5627a;
        if (c0558n != null) {
            c0558n.f(i);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        Z z3 = this.f5628b;
        if (z3 != null) {
            z3.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        Z z3 = this.f5628b;
        if (z3 != null) {
            z3.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        Z z3 = this.f5628b;
        if (z3 != null) {
            z3.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        Z z3 = this.f5628b;
        if (z3 != null) {
            z3.b();
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

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().f(i);
        } else {
            m3.b.K(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().a(i);
        } else {
            m3.b.L(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        if (i >= 0) {
            if (i != getPaint().getFontMetricsInt(null)) {
                setLineSpacing(i - r0, 1.0f);
                return;
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public void setPrecomputedText(H.b bVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        m3.b.v(this);
        throw null;
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0558n c0558n = this.f5627a;
        if (c0558n != null) {
            c0558n.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0558n c0558n = this.f5627a;
        if (c0558n != null) {
            c0558n.i(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        Z z3 = this.f5628b;
        z3.l(colorStateList);
        z3.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        Z z3 = this.f5628b;
        z3.m(mode);
        z3.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        Z z3 = this.f5628b;
        if (z3 != null) {
            z3.g(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        C0522A c0522a;
        if (Build.VERSION.SDK_INT < 28 && (c0522a = this.f5629c) != null) {
            c0522a.f5496c = textClassifier;
        } else {
            super.setTextClassifier(textClassifier);
        }
    }

    public void setTextFuture(Future<H.b> future) {
        this.f5633j = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(H.a aVar) {
        TextDirectionHeuristic textDirectionHeuristic;
        TextDirectionHeuristic textDirectionHeuristic2 = aVar.f841b;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        int i = 1;
        if (textDirectionHeuristic2 != textDirectionHeuristic3 && textDirectionHeuristic2 != (textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            if (textDirectionHeuristic2 == TextDirectionHeuristics.ANYRTL_LTR) {
                i = 2;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LTR) {
                i = 3;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.RTL) {
                i = 4;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LOCALE) {
                i = 5;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic) {
                i = 6;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic3) {
                i = 7;
            }
        }
        setTextDirection(i);
        getPaint().set(aVar.f840a);
        setBreakStrategy(aVar.f842c);
        setHyphenationFrequency(aVar.f843d);
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i, float f4) {
        boolean z3 = z1.f5854b;
        if (z3) {
            super.setTextSize(i, f4);
            return;
        }
        Z z4 = this.f5628b;
        if (z4 != null) {
            C0551j0 c0551j0 = z4.i;
            if (!z3 && !c0551j0.e()) {
                c0551j0.f(i, f4);
            }
        }
    }

    @Override // android.widget.TextView
    public final void setTypeface(Typeface typeface, int i) {
        Typeface typeface2;
        if (this.f5631e) {
            return;
        }
        if (typeface != null && i > 0) {
            Context context = getContext();
            E1.b bVar = A.g.f7a;
            if (context != null) {
                typeface2 = Typeface.create(typeface, i);
            } else {
                throw new IllegalArgumentException("Context cannot be null");
            }
        } else {
            typeface2 = null;
        }
        this.f5631e = true;
        if (typeface2 != null) {
            typeface = typeface2;
        }
        try {
            super.setTypeface(typeface, i);
        } finally {
            this.f5631e = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0537c0(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j1.a(context);
        this.f5631e = false;
        this.f5632f = null;
        i1.a(this, getContext());
        C0558n c0558n = new C0558n(this);
        this.f5627a = c0558n;
        c0558n.d(attributeSet, i);
        Z z3 = new Z(this);
        this.f5628b = z3;
        z3.f(attributeSet, i);
        z3.b();
        C0522A c0522a = new C0522A();
        c0522a.f5495b = this;
        this.f5629c = c0522a;
        getEmojiTextViewHelper().b(attributeSet, i);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i3, int i4, int i5) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i != 0 ? AbstractC0228a.q(context, i) : null, i3 != 0 ? AbstractC0228a.q(context, i3) : null, i4 != 0 ? AbstractC0228a.q(context, i4) : null, i5 != 0 ? AbstractC0228a.q(context, i5) : null);
        Z z3 = this.f5628b;
        if (z3 != null) {
            z3.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i, int i3, int i4, int i5) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i != 0 ? AbstractC0228a.q(context, i) : null, i3 != 0 ? AbstractC0228a.q(context, i3) : null, i4 != 0 ? AbstractC0228a.q(context, i4) : null, i5 != 0 ? AbstractC0228a.q(context, i5) : null);
        Z z3 = this.f5628b;
        if (z3 != null) {
            z3.b();
        }
    }
}
