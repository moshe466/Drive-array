package com.wdullaer.materialdatetimepicker.date;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;

/* loaded from: classes2.dex */
public class SimpleMonthView extends MonthView {
    public SimpleMonthView(Context context, AttributeSet attributeSet, DatePickerController datePickerController) {
        super(context, attributeSet, datePickerController);
    }

    @Override // com.wdullaer.materialdatetimepicker.date.MonthView
    public void drawMonthDay(Canvas canvas, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        Paint paint;
        Typeface create;
        Paint paint2;
        int i10;
        if (this.l == i3) {
            canvas.drawCircle(i4, i5 - (MonthView.B / 3), MonthView.G, this.e);
        }
        if (!a(i, i2, i3) || this.l == i3) {
            paint = this.c;
            create = Typeface.create(Typeface.DEFAULT, 0);
        } else {
            canvas.drawCircle(i4, (MonthView.B + i5) - MonthView.I, MonthView.H, this.e);
            paint = this.c;
            create = Typeface.create(Typeface.DEFAULT, 1);
        }
        paint.setTypeface(create);
        if (this.a.isOutOfRange(i, i2, i3)) {
            paint2 = this.c;
            i10 = this.y;
        } else if (this.l == i3) {
            this.c.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
            paint2 = this.c;
            i10 = this.u;
        } else if (!this.k || this.m != i3) {
            this.c.setColor(a(i, i2, i3) ? this.x : this.t);
            canvas.drawText(String.format(this.a.getLocale(), "%d", Integer.valueOf(i3)), i4, i5, this.c);
        } else {
            paint2 = this.c;
            i10 = this.w;
        }
        paint2.setColor(i10);
        canvas.drawText(String.format(this.a.getLocale(), "%d", Integer.valueOf(i3)), i4, i5, this.c);
    }
}
