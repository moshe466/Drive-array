package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* loaded from: classes.dex */
public abstract class i extends ReplacementSpan {

    /* renamed from: g, reason: collision with root package name */
    private final g f2797g;

    /* renamed from: f, reason: collision with root package name */
    private final Paint.FontMetricsInt f2796f = new Paint.FontMetricsInt();

    /* renamed from: h, reason: collision with root package name */
    private short f2798h = -1;

    /* renamed from: i, reason: collision with root package name */
    private float f2799i = 1.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        androidx.core.util.h.g(gVar, "metadata cannot be null");
        this.f2797g = gVar;
    }

    public final g a() {
        return this.f2797g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int b() {
        return this.f2798h;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f2796f);
        Paint.FontMetricsInt fontMetricsInt2 = this.f2796f;
        this.f2799i = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.f2797g.e();
        this.f2797g.e();
        short i12 = (short) (this.f2797g.i() * this.f2799i);
        this.f2798h = i12;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f2796f;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return i12;
    }
}
