package com.wdullaer.materialdatetimepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: classes2.dex */
public class VerticalTextView extends AppCompatTextView {
    final boolean a;

    public VerticalTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        int gravity = getGravity();
        if (Gravity.isVertical(gravity) && (gravity & 112) == 80) {
            setGravity((gravity & 7) | 48);
            z = false;
        } else {
            z = true;
        }
        this.a = z;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.drawableState = getDrawableState();
        canvas.save();
        if (this.a) {
            canvas.translate(getWidth(), 0.0f);
            f = 90.0f;
        } else {
            canvas.translate(0.0f, getHeight());
            f = -90.0f;
        }
        canvas.rotate(f);
        canvas.translate(getCompoundPaddingLeft(), getExtendedPaddingTop());
        getLayout().draw(canvas);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i2, i);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }
}
