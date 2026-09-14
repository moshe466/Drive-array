package V;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* loaded from: classes.dex */
public final class y implements Spannable {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2440a = false;

    /* renamed from: b, reason: collision with root package name */
    public Spannable f2441b;

    public y(Spannable spannable) {
        this.f2441b = spannable;
    }

    public final void a() {
        A.n nVar;
        Spannable spannable = this.f2441b;
        if (!this.f2440a) {
            if (Build.VERSION.SDK_INT < 28) {
                nVar = new A.n(13);
            } else {
                nVar = new A.n(13);
            }
            if (nVar.f(spannable)) {
                this.f2441b = new SpannableString(spannable);
            }
        }
        this.f2440a = true;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.f2441b.charAt(i);
    }

    @Override // java.lang.CharSequence
    public final IntStream chars() {
        return this.f2441b.chars();
    }

    @Override // java.lang.CharSequence
    public final IntStream codePoints() {
        return this.f2441b.codePoints();
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        return this.f2441b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        return this.f2441b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        return this.f2441b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public final Object[] getSpans(int i, int i3, Class cls) {
        return this.f2441b.getSpans(i, i3, cls);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f2441b.length();
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i, int i3, Class cls) {
        return this.f2441b.nextSpanTransition(i, i3, cls);
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        a();
        this.f2441b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int i, int i3, int i4) {
        a();
        this.f2441b.setSpan(obj, i, i3, i4);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i3) {
        return this.f2441b.subSequence(i, i3);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f2441b.toString();
    }

    public y(CharSequence charSequence) {
        this.f2441b = new SpannableString(charSequence);
    }
}
