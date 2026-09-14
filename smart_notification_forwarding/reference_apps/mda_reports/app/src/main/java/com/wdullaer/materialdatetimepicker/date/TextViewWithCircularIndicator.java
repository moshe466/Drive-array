package com.wdullaer.materialdatetimepicker.date;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.wdullaer.materialdatetimepicker.R;

/* loaded from: classes2.dex */
public class TextViewWithCircularIndicator extends AppCompatTextView {
    private static final int SELECTED_CIRCLE_ALPHA = 255;
    Paint a;
    private int mCircleColor;
    private boolean mDrawCircle;
    private final String mItemIsSelectedText;

    public TextViewWithCircularIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Paint();
        this.mCircleColor = ContextCompat.getColor(context, R.color.mdtp_accent_color);
        this.mItemIsSelectedText = context.getResources().getString(R.string.mdtp_item_is_selected);
        init();
    }

    private ColorStateList createTextColor(int i, boolean z) {
        int[][] iArr = {new int[]{android.R.attr.state_pressed}, new int[]{android.R.attr.state_selected}, new int[0]};
        int[] iArr2 = new int[3];
        iArr2[0] = i;
        iArr2[1] = -1;
        iArr2[2] = z ? -1 : ViewCompat.MEASURED_STATE_MASK;
        return new ColorStateList(iArr, iArr2);
    }

    private void init() {
        this.a.setFakeBoldText(true);
        this.a.setAntiAlias(true);
        this.a.setColor(this.mCircleColor);
        this.a.setTextAlign(Paint.Align.CENTER);
        this.a.setStyle(Paint.Style.FILL);
        this.a.setAlpha(255);
    }

    public void drawIndicator(boolean z) {
        this.mDrawCircle = z;
    }

    @Override // android.view.View
    @SuppressLint({"GetContentDescriptionOverride"})
    public CharSequence getContentDescription() {
        CharSequence text = getText();
        return this.mDrawCircle ? String.format(this.mItemIsSelectedText, text) : text;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        if (this.mDrawCircle) {
            int width = getWidth();
            int height = getHeight();
            canvas.drawCircle(width / 2, height / 2, Math.min(width, height) / 2, this.a);
        }
        setSelected(this.mDrawCircle);
        super.onDraw(canvas);
    }

    public void setAccentColor(int i, boolean z) {
        this.mCircleColor = i;
        this.a.setColor(this.mCircleColor);
        setTextColor(createTextColor(i, z));
    }
}
