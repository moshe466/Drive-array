package X;

import V.k;
import android.text.InputFilter;
import android.text.Spanned;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class d implements InputFilter {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f2561a;

    /* renamed from: b, reason: collision with root package name */
    public c f2562b;

    public d(TextView textView) {
        this.f2561a = textView;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i, int i3, Spanned spanned, int i4, int i5) {
        TextView textView = this.f2561a;
        if (!textView.isInEditMode()) {
            int b4 = k.a().b();
            if (b4 != 0) {
                if (b4 != 1) {
                    if (b4 != 3) {
                        return charSequence;
                    }
                } else {
                    if ((i5 != 0 || i4 != 0 || spanned.length() != 0 || charSequence != textView.getText()) && charSequence != null) {
                        if (i != 0 || i3 != charSequence.length()) {
                            charSequence = charSequence.subSequence(i, i3);
                        }
                        return k.a().e(charSequence, 0, charSequence.length());
                    }
                    return charSequence;
                }
            }
            k a2 = k.a();
            if (this.f2562b == null) {
                this.f2562b = new c(textView, this);
            }
            a2.f(this.f2562b);
            return charSequence;
        }
        return charSequence;
    }
}
