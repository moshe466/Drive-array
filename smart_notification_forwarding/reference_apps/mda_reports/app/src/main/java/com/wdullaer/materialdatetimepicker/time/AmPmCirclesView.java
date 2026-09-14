package com.wdullaer.materialdatetimepicker.time;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.wdullaer.materialdatetimepicker.R;
import com.wdullaer.materialdatetimepicker.Utils;
import java.text.DateFormatSymbols;
import java.util.Locale;

/* loaded from: classes2.dex */
public class AmPmCirclesView extends View {
    private static final int AM = 0;
    private static final int PM = 1;
    private static final int SELECTED_ALPHA = 255;
    private static final int SELECTED_ALPHA_THEME_DARK = 255;
    private static final String TAG = "AmPmCirclesView";
    private boolean mAmDisabled;
    private int mAmOrPm;
    private int mAmOrPmPressed;
    private int mAmPmCircleRadius;
    private float mAmPmCircleRadiusMultiplier;
    private int mAmPmDisabledTextColor;
    private int mAmPmSelectedTextColor;
    private int mAmPmTextColor;
    private int mAmPmYCenter;
    private String mAmText;
    private int mAmXCenter;
    private float mCircleRadiusMultiplier;
    private boolean mDrawValuesReady;
    private boolean mIsInitialized;
    private final Paint mPaint;
    private boolean mPmDisabled;
    private String mPmText;
    private int mPmXCenter;
    private int mSelectedAlpha;
    private int mSelectedColor;
    private int mTouchedColor;
    private int mUnselectedColor;

    public AmPmCirclesView(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.mIsInitialized = false;
    }

    public int getIsTouchingAmOrPm(float f, float f2) {
        if (!this.mDrawValuesReady) {
            return -1;
        }
        int i = this.mAmPmYCenter;
        int i2 = (int) ((f2 - i) * (f2 - i));
        int i3 = this.mAmXCenter;
        float f3 = i2;
        if (((int) Math.sqrt(((f - i3) * (f - i3)) + f3)) <= this.mAmPmCircleRadius && !this.mAmDisabled) {
            return 0;
        }
        int i4 = this.mPmXCenter;
        return (((int) Math.sqrt((double) (((f - ((float) i4)) * (f - ((float) i4))) + f3))) > this.mAmPmCircleRadius || this.mPmDisabled) ? -1 : 1;
    }

    public void initialize(Context context, Locale locale, TimePickerController timePickerController, int i) {
        int i2;
        if (this.mIsInitialized) {
            Log.e(TAG, "AmPmCirclesView may only be initialized once.");
            return;
        }
        Resources resources = context.getResources();
        if (timePickerController.isThemeDark()) {
            this.mUnselectedColor = ContextCompat.getColor(context, R.color.mdtp_circle_background_dark_theme);
            this.mAmPmTextColor = ContextCompat.getColor(context, R.color.mdtp_white);
            i2 = R.color.mdtp_date_picker_text_disabled_dark_theme;
        } else {
            this.mUnselectedColor = ContextCompat.getColor(context, R.color.mdtp_white);
            this.mAmPmTextColor = ContextCompat.getColor(context, R.color.mdtp_ampm_text_color);
            i2 = R.color.mdtp_date_picker_text_disabled;
        }
        this.mAmPmDisabledTextColor = ContextCompat.getColor(context, i2);
        this.mSelectedAlpha = 255;
        this.mSelectedColor = timePickerController.getAccentColor();
        this.mTouchedColor = Utils.darkenColor(this.mSelectedColor);
        this.mAmPmSelectedTextColor = ContextCompat.getColor(context, R.color.mdtp_white);
        this.mPaint.setTypeface(Typeface.create(resources.getString(R.string.mdtp_sans_serif), 0));
        this.mPaint.setAntiAlias(true);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mCircleRadiusMultiplier = Float.parseFloat(resources.getString(R.string.mdtp_circle_radius_multiplier));
        this.mAmPmCircleRadiusMultiplier = Float.parseFloat(resources.getString(R.string.mdtp_ampm_circle_radius_multiplier));
        String[] amPmStrings = new DateFormatSymbols(locale).getAmPmStrings();
        this.mAmText = amPmStrings[0];
        this.mPmText = amPmStrings[1];
        this.mAmDisabled = timePickerController.isAmDisabled();
        this.mPmDisabled = timePickerController.isPmDisabled();
        setAmOrPm(i);
        this.mAmOrPmPressed = -1;
        this.mIsInitialized = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        if (getWidth() == 0 || !this.mIsInitialized) {
            return;
        }
        if (!this.mDrawValuesReady) {
            int width = getWidth() / 2;
            int height = getHeight() / 2;
            int min = (int) (Math.min(width, height) * this.mCircleRadiusMultiplier);
            this.mAmPmCircleRadius = (int) (min * this.mAmPmCircleRadiusMultiplier);
            double d = height;
            double d2 = this.mAmPmCircleRadius;
            Double.isNaN(d2);
            Double.isNaN(d);
            this.mPaint.setTextSize((r2 * 3) / 4);
            int i4 = this.mAmPmCircleRadius;
            this.mAmPmYCenter = (((int) (d + (d2 * 0.75d))) - (i4 / 2)) + min;
            this.mAmXCenter = (width - min) + i4;
            this.mPmXCenter = (width + min) - i4;
            this.mDrawValuesReady = true;
        }
        int i5 = this.mUnselectedColor;
        int i6 = this.mAmPmTextColor;
        int i7 = this.mAmOrPm;
        int i8 = 255;
        if (i7 == 0) {
            i = this.mSelectedColor;
            i3 = this.mSelectedAlpha;
            i2 = this.mAmPmSelectedTextColor;
        } else if (i7 == 1) {
            int i9 = this.mSelectedColor;
            i8 = this.mSelectedAlpha;
            i3 = 255;
            i = i5;
            i5 = i9;
            i2 = i6;
            i6 = this.mAmPmSelectedTextColor;
        } else {
            i = i5;
            i2 = i6;
            i3 = 255;
        }
        int i10 = this.mAmOrPmPressed;
        if (i10 == 0) {
            i = this.mTouchedColor;
            i3 = this.mSelectedAlpha;
        } else if (i10 == 1) {
            i5 = this.mTouchedColor;
            i8 = this.mSelectedAlpha;
        }
        if (this.mAmDisabled) {
            i = this.mUnselectedColor;
            i2 = this.mAmPmDisabledTextColor;
        }
        if (this.mPmDisabled) {
            i5 = this.mUnselectedColor;
            i6 = this.mAmPmDisabledTextColor;
        }
        this.mPaint.setColor(i);
        this.mPaint.setAlpha(i3);
        canvas.drawCircle(this.mAmXCenter, this.mAmPmYCenter, this.mAmPmCircleRadius, this.mPaint);
        this.mPaint.setColor(i5);
        this.mPaint.setAlpha(i8);
        canvas.drawCircle(this.mPmXCenter, this.mAmPmYCenter, this.mAmPmCircleRadius, this.mPaint);
        this.mPaint.setColor(i2);
        float descent = this.mAmPmYCenter - (((int) (this.mPaint.descent() + this.mPaint.ascent())) / 2);
        canvas.drawText(this.mAmText, this.mAmXCenter, descent, this.mPaint);
        this.mPaint.setColor(i6);
        canvas.drawText(this.mPmText, this.mPmXCenter, descent, this.mPaint);
    }

    public void setAmOrPm(int i) {
        this.mAmOrPm = i;
    }

    public void setAmOrPmPressed(int i) {
        this.mAmOrPmPressed = i;
    }
}
