package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: classes.dex */
class m {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f1441a;

    /* renamed from: b, reason: collision with root package name */
    private final c0.f f1442b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(TextView textView) {
        this.f1441a = textView;
        this.f1442b = new c0.f(textView, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f1442b.a(inputFilterArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = this.f1441a.getContext().obtainStyledAttributes(attributeSet, e.j.f9008d0, i10, 0);
        try {
            int i11 = e.j.f9078r0;
            boolean z10 = obtainStyledAttributes.hasValue(i11) ? obtainStyledAttributes.getBoolean(i11, true) : true;
            obtainStyledAttributes.recycle();
            d(z10);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(boolean z10) {
        this.f1442b.b(z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(boolean z10) {
        this.f1442b.c(z10);
    }
}
