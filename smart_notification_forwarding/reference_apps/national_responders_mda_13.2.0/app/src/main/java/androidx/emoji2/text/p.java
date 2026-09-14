package androidx.emoji2.text;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* loaded from: classes.dex */
class p implements Spannable {

    /* renamed from: f, reason: collision with root package name */
    private boolean f2825f = false;

    /* renamed from: g, reason: collision with root package name */
    private Spannable f2826g;

    /* loaded from: classes.dex */
    private static class a {
        static IntStream a(CharSequence charSequence) {
            return charSequence.chars();
        }

        static IntStream b(CharSequence charSequence) {
            return charSequence.codePoints();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        b() {
        }

        boolean a(CharSequence charSequence) {
            return charSequence instanceof androidx.core.text.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c extends b {
        c() {
        }

        @Override // androidx.emoji2.text.p.b
        boolean a(CharSequence charSequence) {
            return (charSequence instanceof PrecomputedText) || (charSequence instanceof androidx.core.text.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Spannable spannable) {
        this.f2826g = spannable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(CharSequence charSequence) {
        this.f2826g = new SpannableString(charSequence);
    }

    private void a() {
        Spannable spannable = this.f2826g;
        if (!this.f2825f && c().a(spannable)) {
            this.f2826g = new SpannableString(spannable);
        }
        this.f2825f = true;
    }

    static b c() {
        return Build.VERSION.SDK_INT < 28 ? new b() : new c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Spannable b() {
        return this.f2826g;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i10) {
        return this.f2826g.charAt(i10);
    }

    @Override // java.lang.CharSequence
    public IntStream chars() {
        return a.a(this.f2826g);
    }

    @Override // java.lang.CharSequence
    public IntStream codePoints() {
        return a.b(this.f2826g);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f2826g.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f2826g.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f2826g.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i10, int i11, Class<T> cls) {
        return (T[]) this.f2826g.getSpans(i10, i11, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f2826g.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i10, int i11, Class cls) {
        return this.f2826g.nextSpanTransition(i10, i11, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        a();
        this.f2826g.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i10, int i11, int i12) {
        a();
        this.f2826g.setSpan(obj, i10, i11, i12);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i10, int i11) {
        return this.f2826g.subSequence(i10, i11);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f2826g.toString();
    }
}
