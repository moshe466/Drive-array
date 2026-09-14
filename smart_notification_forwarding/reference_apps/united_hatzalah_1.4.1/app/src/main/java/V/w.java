package V;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.style.ReplacementSpan;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class w extends ReplacementSpan {

    /* renamed from: b, reason: collision with root package name */
    public final p f2438b;

    /* renamed from: a, reason: collision with root package name */
    public final Paint.FontMetricsInt f2437a = new Paint.FontMetricsInt();

    /* renamed from: c, reason: collision with root package name */
    public float f2439c = 1.0f;

    public w(p pVar) {
        I.d.c(pVar, "metadata cannot be null");
        this.f2438b = pVar;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i3, float f4, int i4, int i5, int i6, Paint paint) {
        k.a().getClass();
        p pVar = this.f2438b;
        K1.m mVar = pVar.f2411b;
        Typeface typeface = (Typeface) mVar.f1105d;
        Typeface typeface2 = paint.getTypeface();
        paint.setTypeface(typeface);
        canvas.drawText((char[]) mVar.f1103b, pVar.f2410a * 2, 2, f4, i5, paint);
        paint.setTypeface(typeface2);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i, int i3, Paint.FontMetricsInt fontMetricsInt) {
        short s3;
        Paint.FontMetricsInt fontMetricsInt2 = this.f2437a;
        paint.getFontMetricsInt(fontMetricsInt2);
        float abs = Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f;
        p pVar = this.f2438b;
        W.a b4 = pVar.b();
        int a2 = b4.a(14);
        short s4 = 0;
        if (a2 != 0) {
            s3 = ((ByteBuffer) b4.f946d).getShort(a2 + b4.f943a);
        } else {
            s3 = 0;
        }
        this.f2439c = abs / s3;
        W.a b5 = pVar.b();
        int a4 = b5.a(14);
        if (a4 != 0) {
            ((ByteBuffer) b5.f946d).getShort(a4 + b5.f943a);
        }
        W.a b6 = pVar.b();
        int a5 = b6.a(12);
        if (a5 != 0) {
            s4 = ((ByteBuffer) b6.f946d).getShort(a5 + b6.f943a);
        }
        short s5 = (short) (s4 * this.f2439c);
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return s5;
    }
}
