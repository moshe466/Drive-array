package com.wdullaer.materialdatetimepicker.time;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.google.logging.type.LogSeverity;
import com.wdullaer.materialdatetimepicker.R;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

/* loaded from: classes2.dex */
public class RadialTextsView extends View {
    private static final String TAG = "RadialTextsView";
    ObjectAnimator a;
    ObjectAnimator b;
    private float mAmPmCircleRadiusMultiplier;
    private float mAnimationRadiusMultiplier;
    private float mCircleRadius;
    private float mCircleRadiusMultiplier;
    private boolean mDrawValuesReady;
    private boolean mHasInnerCircle;
    private final Paint mInactivePaint;
    private float mInnerNumbersRadiusMultiplier;
    private float[] mInnerTextGridHeights;
    private float[] mInnerTextGridWidths;
    private float mInnerTextSize;
    private float mInnerTextSizeMultiplier;
    private String[] mInnerTexts;
    private InvalidateUpdateListener mInvalidateUpdateListener;
    private boolean mIs24HourMode;
    private boolean mIsInitialized;
    private float mNumbersRadiusMultiplier;
    private final Paint mPaint;
    private final Paint mSelectedPaint;
    private float[] mTextGridHeights;
    private boolean mTextGridValuesDirty;
    private float[] mTextGridWidths;
    private float mTextSize;
    private float mTextSizeMultiplier;
    private String[] mTexts;
    private float mTransitionEndRadiusMultiplier;
    private float mTransitionMidRadiusMultiplier;
    private Typeface mTypefaceLight;
    private Typeface mTypefaceRegular;
    private SelectionValidator mValidator;
    private int mXCenter;
    private int mYCenter;
    private int selection;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class InvalidateUpdateListener implements ValueAnimator.AnimatorUpdateListener {
        private InvalidateUpdateListener() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RadialTextsView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface SelectionValidator {
        boolean isValidSelection(int i);
    }

    public RadialTextsView(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.mSelectedPaint = new Paint();
        this.mInactivePaint = new Paint();
        this.selection = -1;
        this.mIsInitialized = false;
    }

    private Paint[] assignTextColors(String[] strArr) {
        Paint[] paintArr = new Paint[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            int parseInt = Integer.parseInt(strArr[i]);
            if (parseInt == this.selection) {
                paintArr[i] = this.mSelectedPaint;
            } else if (this.mValidator.isValidSelection(parseInt)) {
                paintArr[i] = this.mPaint;
            } else {
                paintArr[i] = this.mInactivePaint;
            }
        }
        return paintArr;
    }

    private void calculateGridSizes(float f, float f2, float f3, float f4, float[] fArr, float[] fArr2) {
        float sqrt = (((float) Math.sqrt(3.0d)) * f) / 2.0f;
        float f5 = f / 2.0f;
        this.mPaint.setTextSize(f4);
        this.mSelectedPaint.setTextSize(f4);
        this.mInactivePaint.setTextSize(f4);
        float descent = f3 - ((this.mPaint.descent() + this.mPaint.ascent()) / 2.0f);
        fArr[0] = descent - f;
        fArr2[0] = f2 - f;
        fArr[1] = descent - sqrt;
        fArr2[1] = f2 - sqrt;
        fArr[2] = descent - f5;
        fArr2[2] = f2 - f5;
        fArr[3] = descent;
        fArr2[3] = f2;
        fArr[4] = descent + f5;
        fArr2[4] = f5 + f2;
        fArr[5] = descent + sqrt;
        fArr2[5] = sqrt + f2;
        fArr[6] = descent + f;
        fArr2[6] = f2 + f;
    }

    private void drawTexts(Canvas canvas, float f, Typeface typeface, String[] strArr, float[] fArr, float[] fArr2) {
        this.mPaint.setTextSize(f);
        this.mPaint.setTypeface(typeface);
        Paint[] assignTextColors = assignTextColors(strArr);
        canvas.drawText(strArr[0], fArr[3], fArr2[0], assignTextColors[0]);
        canvas.drawText(strArr[1], fArr[4], fArr2[1], assignTextColors[1]);
        canvas.drawText(strArr[2], fArr[5], fArr2[2], assignTextColors[2]);
        canvas.drawText(strArr[3], fArr[6], fArr2[3], assignTextColors[3]);
        canvas.drawText(strArr[4], fArr[5], fArr2[4], assignTextColors[4]);
        canvas.drawText(strArr[5], fArr[4], fArr2[5], assignTextColors[5]);
        canvas.drawText(strArr[6], fArr[3], fArr2[6], assignTextColors[6]);
        canvas.drawText(strArr[7], fArr[2], fArr2[5], assignTextColors[7]);
        canvas.drawText(strArr[8], fArr[1], fArr2[4], assignTextColors[8]);
        canvas.drawText(strArr[9], fArr[0], fArr2[3], assignTextColors[9]);
        canvas.drawText(strArr[10], fArr[1], fArr2[2], assignTextColors[10]);
        canvas.drawText(strArr[11], fArr[2], fArr2[1], assignTextColors[11]);
    }

    private void renderAnimations() {
        this.a = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofKeyframe("animationRadiusMultiplier", Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.2f, this.mTransitionMidRadiusMultiplier), Keyframe.ofFloat(1.0f, this.mTransitionEndRadiusMultiplier)), PropertyValuesHolder.ofKeyframe("alpha", Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(1.0f, 0.0f))).setDuration(LogSeverity.ERROR_VALUE);
        this.a.addUpdateListener(this.mInvalidateUpdateListener);
        float f = LogSeverity.ERROR_VALUE;
        int i = (int) (1.25f * f);
        float f2 = (f * 0.25f) / i;
        this.b = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofKeyframe("animationRadiusMultiplier", Keyframe.ofFloat(0.0f, this.mTransitionEndRadiusMultiplier), Keyframe.ofFloat(f2, this.mTransitionEndRadiusMultiplier), Keyframe.ofFloat(1.0f - ((1.0f - f2) * 0.2f), this.mTransitionMidRadiusMultiplier), Keyframe.ofFloat(1.0f, 1.0f)), PropertyValuesHolder.ofKeyframe("alpha", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(f2, 0.0f), Keyframe.ofFloat(1.0f, 1.0f))).setDuration(i);
        this.b.addUpdateListener(this.mInvalidateUpdateListener);
    }

    public ObjectAnimator getDisappearAnimator() {
        ObjectAnimator objectAnimator;
        if (this.mIsInitialized && this.mDrawValuesReady && (objectAnimator = this.a) != null) {
            return objectAnimator;
        }
        Log.e(TAG, "RadialTextView was not ready for animation.");
        return null;
    }

    public ObjectAnimator getReappearAnimator() {
        ObjectAnimator objectAnimator;
        if (this.mIsInitialized && this.mDrawValuesReady && (objectAnimator = this.b) != null) {
            return objectAnimator;
        }
        Log.e(TAG, "RadialTextView was not ready for animation.");
        return null;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public void initialize(Context context, String[] strArr, String[] strArr2, TimePickerController timePickerController, SelectionValidator selectionValidator, boolean z) {
        int i;
        if (this.mIsInitialized) {
            Log.e(TAG, "This RadialTextsView may only be initialized once.");
            return;
        }
        Resources resources = context.getResources();
        this.mPaint.setColor(ContextCompat.getColor(context, timePickerController.isThemeDark() ? R.color.mdtp_white : R.color.mdtp_numbers_text_color));
        this.mTypefaceLight = Typeface.create(resources.getString(R.string.mdtp_radial_numbers_typeface), 0);
        this.mTypefaceRegular = Typeface.create(resources.getString(R.string.mdtp_sans_serif), 0);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mSelectedPaint.setColor(ContextCompat.getColor(context, R.color.mdtp_white));
        this.mSelectedPaint.setAntiAlias(true);
        this.mSelectedPaint.setTextAlign(Paint.Align.CENTER);
        this.mInactivePaint.setColor(ContextCompat.getColor(context, timePickerController.isThemeDark() ? R.color.mdtp_date_picker_text_disabled_dark_theme : R.color.mdtp_date_picker_text_disabled));
        this.mInactivePaint.setAntiAlias(true);
        this.mInactivePaint.setTextAlign(Paint.Align.CENTER);
        this.mTexts = strArr;
        this.mInnerTexts = strArr2;
        this.mIs24HourMode = timePickerController.is24HourMode();
        this.mHasInnerCircle = strArr2 != null;
        if (this.mIs24HourMode || timePickerController.getVersion() != TimePickerDialog.Version.VERSION_1) {
            this.mCircleRadiusMultiplier = Float.parseFloat(resources.getString(R.string.mdtp_circle_radius_multiplier_24HourMode));
        } else {
            this.mCircleRadiusMultiplier = Float.parseFloat(resources.getString(R.string.mdtp_circle_radius_multiplier));
            this.mAmPmCircleRadiusMultiplier = Float.parseFloat(resources.getString(R.string.mdtp_ampm_circle_radius_multiplier));
        }
        this.mTextGridHeights = new float[7];
        this.mTextGridWidths = new float[7];
        if (this.mHasInnerCircle) {
            this.mNumbersRadiusMultiplier = Float.parseFloat(resources.getString(R.string.mdtp_numbers_radius_multiplier_outer));
            this.mInnerNumbersRadiusMultiplier = Float.parseFloat(resources.getString(R.string.mdtp_numbers_radius_multiplier_inner));
            if (timePickerController.getVersion() == TimePickerDialog.Version.VERSION_1) {
                this.mTextSizeMultiplier = Float.parseFloat(resources.getString(R.string.mdtp_text_size_multiplier_outer));
                i = R.string.mdtp_text_size_multiplier_inner;
            } else {
                this.mTextSizeMultiplier = Float.parseFloat(resources.getString(R.string.mdtp_text_size_multiplier_outer_v2));
                i = R.string.mdtp_text_size_multiplier_inner_v2;
            }
            this.mInnerTextSizeMultiplier = Float.parseFloat(resources.getString(i));
            this.mInnerTextGridHeights = new float[7];
            this.mInnerTextGridWidths = new float[7];
        } else {
            this.mNumbersRadiusMultiplier = Float.parseFloat(resources.getString(R.string.mdtp_numbers_radius_multiplier_normal));
            this.mTextSizeMultiplier = Float.parseFloat(resources.getString(R.string.mdtp_text_size_multiplier_normal));
        }
        this.mAnimationRadiusMultiplier = 1.0f;
        this.mTransitionMidRadiusMultiplier = ((z ? -1 : 1) * 0.05f) + 1.0f;
        this.mTransitionEndRadiusMultiplier = ((z ? 1 : -1) * 0.3f) + 1.0f;
        this.mInvalidateUpdateListener = new InvalidateUpdateListener();
        this.mValidator = selectionValidator;
        this.mTextGridValuesDirty = true;
        this.mIsInitialized = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (getWidth() == 0 || !this.mIsInitialized) {
            return;
        }
        if (!this.mDrawValuesReady) {
            this.mXCenter = getWidth() / 2;
            this.mYCenter = getHeight() / 2;
            this.mCircleRadius = Math.min(this.mXCenter, this.mYCenter) * this.mCircleRadiusMultiplier;
            if (!this.mIs24HourMode) {
                float f = this.mCircleRadius * this.mAmPmCircleRadiusMultiplier;
                double d = this.mYCenter;
                double d2 = f;
                Double.isNaN(d2);
                Double.isNaN(d);
                this.mYCenter = (int) (d - (d2 * 0.75d));
            }
            float f2 = this.mCircleRadius;
            this.mTextSize = this.mTextSizeMultiplier * f2;
            if (this.mHasInnerCircle) {
                this.mInnerTextSize = f2 * this.mInnerTextSizeMultiplier;
            }
            renderAnimations();
            this.mTextGridValuesDirty = true;
            this.mDrawValuesReady = true;
        }
        if (this.mTextGridValuesDirty) {
            calculateGridSizes(this.mCircleRadius * this.mNumbersRadiusMultiplier * this.mAnimationRadiusMultiplier, this.mXCenter, this.mYCenter, this.mTextSize, this.mTextGridHeights, this.mTextGridWidths);
            if (this.mHasInnerCircle) {
                calculateGridSizes(this.mCircleRadius * this.mInnerNumbersRadiusMultiplier * this.mAnimationRadiusMultiplier, this.mXCenter, this.mYCenter, this.mInnerTextSize, this.mInnerTextGridHeights, this.mInnerTextGridWidths);
            }
            this.mTextGridValuesDirty = false;
        }
        drawTexts(canvas, this.mTextSize, this.mTypefaceLight, this.mTexts, this.mTextGridWidths, this.mTextGridHeights);
        if (this.mHasInnerCircle) {
            drawTexts(canvas, this.mInnerTextSize, this.mTypefaceRegular, this.mInnerTexts, this.mInnerTextGridWidths, this.mInnerTextGridHeights);
        }
    }

    public void setAnimationRadiusMultiplier(float f) {
        this.mAnimationRadiusMultiplier = f;
        this.mTextGridValuesDirty = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSelection(int i) {
        this.selection = i;
    }
}
