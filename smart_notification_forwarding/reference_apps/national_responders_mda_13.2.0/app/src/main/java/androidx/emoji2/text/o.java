package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;

/* loaded from: classes.dex */
public final class o extends i {

    /* renamed from: j, reason: collision with root package name */
    private static Paint f2824j;

    public o(g gVar) {
        super(gVar);
    }

    private static Paint c() {
        if (f2824j == null) {
            TextPaint textPaint = new TextPaint();
            f2824j = textPaint;
            textPaint.setColor(e.b().c());
            f2824j.setStyle(Paint.Style.FILL);
        }
        return f2824j;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i10, int i11, float f10, int i12, int i13, int i14, Paint paint) {
        if (e.b().i()) {
            canvas.drawRect(f10, i12, f10 + b(), i14, c());
        }
        a().a(canvas, f10, i13, paint);
    }
}
