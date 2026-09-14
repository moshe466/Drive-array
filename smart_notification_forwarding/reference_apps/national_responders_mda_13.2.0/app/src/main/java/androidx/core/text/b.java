package androidx.core.text;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;

/* loaded from: classes.dex */
public class b implements Spannable {

    /* renamed from: f, reason: collision with root package name */
    private final Spannable f2475f;

    /* renamed from: g, reason: collision with root package name */
    private final a f2476g;

    /* renamed from: h, reason: collision with root package name */
    private final PrecomputedText f2477h;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final TextPaint f2478a;

        /* renamed from: b, reason: collision with root package name */
        private final TextDirectionHeuristic f2479b;

        /* renamed from: c, reason: collision with root package name */
        private final int f2480c;

        /* renamed from: d, reason: collision with root package name */
        private final int f2481d;

        /* renamed from: androidx.core.text.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0036a {

            /* renamed from: a, reason: collision with root package name */
            private final TextPaint f2482a;

            /* renamed from: b, reason: collision with root package name */
            private TextDirectionHeuristic f2483b;

            /* renamed from: c, reason: collision with root package name */
            private int f2484c;

            /* renamed from: d, reason: collision with root package name */
            private int f2485d;

            public C0036a(TextPaint textPaint) {
                this.f2482a = textPaint;
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 23) {
                    this.f2484c = 1;
                    this.f2485d = 1;
                } else {
                    this.f2485d = 0;
                    this.f2484c = 0;
                }
                this.f2483b = i10 >= 18 ? TextDirectionHeuristics.FIRSTSTRONG_LTR : null;
            }

            public a a() {
                return new a(this.f2482a, this.f2483b, this.f2484c, this.f2485d);
            }

            public C0036a b(int i10) {
                this.f2484c = i10;
                return this;
            }

            public C0036a c(int i10) {
                this.f2485d = i10;
                return this;
            }

            public C0036a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.f2483b = textDirectionHeuristic;
                return this;
            }
        }

        public a(PrecomputedText.Params params) {
            this.f2478a = params.getTextPaint();
            this.f2479b = params.getTextDirection();
            this.f2480c = params.getBreakStrategy();
            this.f2481d = params.getHyphenationFrequency();
        }

        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i10, int i11) {
            if (Build.VERSION.SDK_INT >= 29) {
                new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i10).setHyphenationFrequency(i11).setTextDirection(textDirectionHeuristic).build();
            }
            this.f2478a = textPaint;
            this.f2479b = textDirectionHeuristic;
            this.f2480c = i10;
            this.f2481d = i11;
        }

        public boolean a(a aVar) {
            int i10 = Build.VERSION.SDK_INT;
            if ((i10 >= 23 && (this.f2480c != aVar.b() || this.f2481d != aVar.c())) || this.f2478a.getTextSize() != aVar.e().getTextSize() || this.f2478a.getTextScaleX() != aVar.e().getTextScaleX() || this.f2478a.getTextSkewX() != aVar.e().getTextSkewX()) {
                return false;
            }
            if ((i10 >= 21 && (this.f2478a.getLetterSpacing() != aVar.e().getLetterSpacing() || !TextUtils.equals(this.f2478a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()))) || this.f2478a.getFlags() != aVar.e().getFlags()) {
                return false;
            }
            if (i10 >= 24) {
                if (!this.f2478a.getTextLocales().equals(aVar.e().getTextLocales())) {
                    return false;
                }
            } else if (i10 >= 17 && !this.f2478a.getTextLocale().equals(aVar.e().getTextLocale())) {
                return false;
            }
            return this.f2478a.getTypeface() == null ? aVar.e().getTypeface() == null : this.f2478a.getTypeface().equals(aVar.e().getTypeface());
        }

        public int b() {
            return this.f2480c;
        }

        public int c() {
            return this.f2481d;
        }

        public TextDirectionHeuristic d() {
            return this.f2479b;
        }

        public TextPaint e() {
            return this.f2478a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (a(aVar)) {
                return Build.VERSION.SDK_INT < 18 || this.f2479b == aVar.d();
            }
            return false;
        }

        public int hashCode() {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 24) {
                return androidx.core.util.c.b(Float.valueOf(this.f2478a.getTextSize()), Float.valueOf(this.f2478a.getTextScaleX()), Float.valueOf(this.f2478a.getTextSkewX()), Float.valueOf(this.f2478a.getLetterSpacing()), Integer.valueOf(this.f2478a.getFlags()), this.f2478a.getTextLocales(), this.f2478a.getTypeface(), Boolean.valueOf(this.f2478a.isElegantTextHeight()), this.f2479b, Integer.valueOf(this.f2480c), Integer.valueOf(this.f2481d));
            }
            if (i10 >= 21) {
                return androidx.core.util.c.b(Float.valueOf(this.f2478a.getTextSize()), Float.valueOf(this.f2478a.getTextScaleX()), Float.valueOf(this.f2478a.getTextSkewX()), Float.valueOf(this.f2478a.getLetterSpacing()), Integer.valueOf(this.f2478a.getFlags()), this.f2478a.getTextLocale(), this.f2478a.getTypeface(), Boolean.valueOf(this.f2478a.isElegantTextHeight()), this.f2479b, Integer.valueOf(this.f2480c), Integer.valueOf(this.f2481d));
            }
            if (i10 < 18 && i10 < 17) {
                return androidx.core.util.c.b(Float.valueOf(this.f2478a.getTextSize()), Float.valueOf(this.f2478a.getTextScaleX()), Float.valueOf(this.f2478a.getTextSkewX()), Integer.valueOf(this.f2478a.getFlags()), this.f2478a.getTypeface(), this.f2479b, Integer.valueOf(this.f2480c), Integer.valueOf(this.f2481d));
            }
            return androidx.core.util.c.b(Float.valueOf(this.f2478a.getTextSize()), Float.valueOf(this.f2478a.getTextScaleX()), Float.valueOf(this.f2478a.getTextSkewX()), Integer.valueOf(this.f2478a.getFlags()), this.f2478a.getTextLocale(), this.f2478a.getTypeface(), this.f2479b, Integer.valueOf(this.f2480c), Integer.valueOf(this.f2481d));
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x00df  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String toString() {
            /*
                Method dump skipped, instructions count: 325
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.text.b.a.toString():java.lang.String");
        }
    }

    public a a() {
        return this.f2476g;
    }

    public PrecomputedText b() {
        Spannable spannable = this.f2475f;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i10) {
        return this.f2475f.charAt(i10);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f2475f.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f2475f.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f2475f.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i10, int i11, Class<T> cls) {
        return Build.VERSION.SDK_INT >= 29 ? (T[]) this.f2477h.getSpans(i10, i11, cls) : (T[]) this.f2475f.getSpans(i10, i11, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f2475f.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i10, int i11, Class cls) {
        return this.f2475f.nextSpanTransition(i10, i11, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f2477h.removeSpan(obj);
        } else {
            this.f2475f.removeSpan(obj);
        }
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i10, int i11, int i12) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f2477h.setSpan(obj, i10, i11, i12);
        } else {
            this.f2475f.setSpan(obj, i10, i11, i12);
        }
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i10, int i11) {
        return this.f2475f.subSequence(i10, i11);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f2475f.toString();
    }
}
