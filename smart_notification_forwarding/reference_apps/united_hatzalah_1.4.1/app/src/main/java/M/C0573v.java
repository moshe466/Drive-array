package m;

import F0.C0047j2;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;
import g.AbstractC0424a;

/* renamed from: m.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0573v {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f5797a;

    /* renamed from: b, reason: collision with root package name */
    public final C0047j2 f5798b;

    public C0573v(TextView textView) {
        this.f5797a = textView;
        this.f5798b = new C0047j2(textView);
    }

    public final InputFilter[] a(InputFilter[] inputFilterArr) {
        return ((m3.b) this.f5798b.f546b).p(inputFilterArr);
    }

    public final void b(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f5797a.getContext().obtainStyledAttributes(attributeSet, AbstractC0424a.i, i, 0);
        try {
            boolean z3 = true;
            if (obtainStyledAttributes.hasValue(14)) {
                z3 = obtainStyledAttributes.getBoolean(14, true);
            }
            obtainStyledAttributes.recycle();
            d(z3);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void c(boolean z3) {
        ((m3.b) this.f5798b.f546b).I(z3);
    }

    public final void d(boolean z3) {
        ((m3.b) this.f5798b.f546b).J(z3);
    }
}
