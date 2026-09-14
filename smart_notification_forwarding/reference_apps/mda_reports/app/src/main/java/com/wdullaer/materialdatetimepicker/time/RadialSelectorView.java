package com.wdullaer.materialdatetimepicker.time;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import com.google.logging.type.LogSeverity;
import com.wdullaer.materialdatetimepicker.R;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class RadialSelectorView extends View {
    private static final int FULL_ALPHA = 255;
    private static final int SELECTED_ALPHA = 255;
    private static final int SELECTED_ALPHA_THEME_DARK = 255;
    private static final String TAG = "RadialSelectorView";
    private float mAmPmCircleRadiusMultiplier;
    private float mAnimationRadiusMultiplier;
    private int mCircleRadius;
    private float mCircleRadiusMultiplier;
    private boolean mDrawValuesReady;
    private boolean mForceDrawDot;
    private boolean mHasInnerCircle;
    private float mInnerNumbersRadiusMultiplier;
    private InvalidateUpdateListener mInvalidateUpdateListener;
    private boolean mIs24HourMode;
    private boolean mIsInitialized;
    private int mLineLength;
    private float mNumbersRadiusMultiplier;
    private float mOuterNumbersRadiusMultiplier;
    private final Paint mPaint;
    private int mSelectionAlpha;
    private int mSelectionDegrees;
    private double mSelectionRadians;
    private int mSelectionRadius;
    private float mSelectionRadiusMultiplier;
    private float mTransitionEndRadiusMultiplier;
    private float mTransitionMidRadiusMultiplier;
    private int mXCenter;
    private int mYCenter;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class InvalidateUpdateListener implements ValueAnimator.AnimatorUpdateListener {
        private final WeakReference<RadialSelectorView> selectorRef;

        InvalidateUpdateListener(RadialSelectorView radialSelectorView) {
            this.selectorRef = new WeakReference<>(radialSelectorView);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RadialSelectorView radialSelectorView = this.selectorRef.get();
            if (radialSelectorView != null) {
                radialSelectorView.invalidate();
            }
        }
    }

    public RadialSelectorView(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.mIsInitialized = false;
    }

    public int getDegreesFromCoords(float f, float f2, boolean z, Boolean[] boolArr) {
        if (!this.mDrawValuesReady) {
            return -1;
        }
        int i = this.mYCenter;
        float f3 = (f2 - i) * (f2 - i);
        int i2 = this.mXCenter;
        double sqrt = Math.sqrt(f3 + ((f - i2) * (f - i2)));
        if (this.mHasInnerCircle) {
            if (z) {
                double d = (int) (this.mCircleRadius * this.mInnerNumbersRadiusMultiplier);
                Double.isNaN(d);
                int abs = (int) Math.abs(sqrt - d);
                double d2 = (int) (this.mCircleRadius * this.mOuterNumbersRadiusMultiplier);
                Double.isNaN(d2);
                boolArr[0] = Boolean.valueOf(abs <= ((int) Math.abs(sqrt - d2)));
            } else {
                int i3 = this.mCircleRadius;
                float f4 = this.mInnerNumbersRadiusMultiplier;
                int i4 = this.mSelectionRadius;
                int i5 = ((int) (i3 * f4)) - i4;
                float f5 = this.mOuterNumbersRadiusMultiplier;
                int i6 = ((int) (i3 * f5)) + i4;
                int i7 = (int) (i3 * ((f5 + f4) / 2.0f));
                if (sqrt >= i5 && sqrt <= i7) {
                    boolArr[0] = true;
                } else {
                    if (sqrt > i6 || sqrt < i7) {
                        return -1;
                    }
                    boolArr[0] = false;
                }
            }
        } else if (!z) {
            double d3 = this.mLineLength;
            Double.isNaN(d3);
            if (((int) Math.abs(sqrt - d3)) > ((int) (this.mCircleRadius * (1.0f - this.mNumbersRadiusMultiplier)))) {
                return -1;
            }
        }
        double abs2 = Math.abs(f2 - this.mYCenter);
        Double.isNaN(abs2);
        int asin = (int) ((Math.asin(abs2 / sqrt) * 180.0d) / 3.141592653589793d);
        boolean z2 = f > ((float) this.mXCenter);
        boolean z3 = f2 < ((float) this.mYCenter);
        return (z2 && z3) ? 90 - asin : (!z2 || z3) ? (z2 || z3) ? (z2 || !z3) ? asin : asin + 270 : 270 - asin : asin + 90;
    }

    public ObjectAnimator getDisappearAnimator() {
        if (!this.mIsInitialized || !this.mDrawValuesReady) {
            Log.e(TAG, "RadialSelectorView was not ready for animation.");
            return null;
        }
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofKeyframe("animationRadiusMultiplier", Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.2f, this.mTransitionMidRadiusMultiplier), Keyframe.ofFloat(1.0f, this.mTransitionEndRadiusMultiplier)), PropertyValuesHolder.ofKeyframe("alpha", Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(1.0f, 0.0f))).setDuration(LogSeverity.ERROR_VALUE);
        duration.addUpdateListener(this.mInvalidateUpdateListener);
        return duration;
    }

    public ObjectAnimator getReappearAnimator() {
        if (!this.mIsInitialized || !this.mDrawValuesReady) {
            Log.e(TAG, "RadialSelectorView was not ready for animation.");
            return null;
        }
        float f = LogSeverity.ERROR_VALUE;
        int i = (int) (1.25f * f);
        float f2 = (f * 0.25f) / i;
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofKeyframe("animationRadiusMultiplier", Keyframe.ofFloat(0.0f, this.mTransitionEndRadiusMultiplier), Keyframe.ofFloat(f2, this.mTransitionEndRadiusMultiplier), Keyframe.ofFloat(1.0f - ((1.0f - f2) * 0.2f), this.mTransitionMidRadiusMultiplier), Keyframe.ofFloat(1.0f, 1.0f)), PropertyValuesHolder.ofKeyframe("alpha", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(f2, 0.0f), Keyframe.ofFloat(1.0f, 1.0f))).setDuration(i);
        duration.addUpdateListener(this.mInvalidateUpdateListener);
        return duration;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public void initialize(Context context, TimePickerController timePickerController, boolean z, boolean z2, int i, boolean z3) {
        if (this.mIsInitialized) {
            Log.e(TAG, "This RadialSelectorView may only be initialized once.");
            return;
        }
        Resources resources = context.getResources();
        this.mPaint.setColor(timePickerController.getAccentColor());
        this.mPaint.setAntiAlias(true);
        timePickerController.isThemeDark();
        this.mSelectionAlpha = 255;
        this.mIs24HourMode = timePickerController.is24HourMode();
        if (this.mIs24HourMode || timePickerController.getVersion() != TimePickerDialog.Version.VERSION_1) {
            this.mCircleRadiusMultiplier = Float.parseFloat(resources.getString(R.string.mdtp_circle_radius_multiplier_24HourMode));
        } else {
            this.mCircleRadiusMultiplier = Float.parseFloat(resources.getString(R.string.mdtp_circle_radius_multiplier));
            this.mAmPmCircleRadiusMultiplier = Float.parseFloat(resources.getString(R.string.mdtp_ampm_circle_radius_multiplier));
        }
        this.mHasInnerCircle = z;
        if (z) {
            this.mInnerNumbersRadiusMultiplier = Float.parseFloat(resources.getString(R.string.mdtp_numbers_radius_multiplier_inner));
            this.mOuterNumbersRadiusMultiplier = Float.parseFloat(resources.getString(R.string.mdtp_numbers_radius_multiplier_outer));
        } else {
            this.mNumbersRadiusMultiplier = Float.parseFloat(resources.getString(R.string.mdtp_numbers_radius_multiplier_normal));
        }
        this.mSelectionRadiusMultiplier = Float.parseFloat(resources.getString(R.string.mdtp_selection_radius_multiplier));
        this.mAnimationRadiusMultiplier = 1.0f;
        this.mTransitionMidRadiusMultiplier = ((z2 ? -1 : 1) * 0.05f) + 1.0f;
        this.mTransitionEndRadiusMultiplier = ((z2 ? 1 : -1) * 0.3f) + 1.0f;
        this.mInvalidateUpdateListener = new InvalidateUpdateListener(this);
        setSelection(i, z3, false);
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
            this.mCircleRadius = (int) (Math.min(this.mXCenter, this.mYCenter) * this.mCircleRadiusMultiplier);
            if (!this.mIs24HourMode) {
                int i = (int) (this.mCircleRadius * this.mAmPmCircleRadiusMultiplier);
                double d = this.mYCenter;
                double d2 = i;
                Double.isNaN(d2);
                Double.isNaN(d);
                this.mYCenter = (int) (d - (d2 * 0.75d));
            }
            this.mSelectionRadius = (int) (this.mCircleRadius * this.mSelectionRadiusMultiplier);
            this.mDrawValuesReady = true;
        }
        this.mLineLength = (int) (this.mCircleRadius * this.mNumbersRadiusMultiplier * this.mAnimationRadiusMultiplier);
        int i2 = this.mXCenter;
        double d3 = this.mLineLength;
        double sin = Math.sin(this.mSelectionRadians);
        Double.isNaN(d3);
        int i3 = i2 + ((int) (d3 * sin));
        int i4 = this.mYCenter;
        double d4 = this.mLineLength;
        double cos = Math.cos(this.mSelectionRadians);
        Double.isNaN(d4);
        int i5 = i4 - ((int) (d4 * cos));
        this.mPaint.setAlpha(this.mSelectionAlpha);
        float f = i3;
        float f2 = i5;
        canvas.drawCircle(f, f2, this.mSelectionRadius, this.mPaint);
        if ((this.mSelectionDegrees % 30 != 0) || this.mForceDrawDot) {
            this.mPaint.setAlpha(255);
            canvas.drawCircle(f, f2, (this.mSelectionRadius * 2) / 7, this.mPaint);
        } else {
            int i6 = this.mLineLength - this.mSelectionRadius;
            int i7 = this.mXCenter;
            double d5 = i6;
            double sin2 = Math.sin(this.mSelectionRadians);
            Double.isNaN(d5);
            i3 = ((int) (sin2 * d5)) + i7;
            int i8 = this.mYCenter;
            double cos2 = Math.cos(this.mSelectionRadians);
            Double.isNaN(d5);
            i5 = i8 - ((int) (d5 * cos2));
        }
        this.mPaint.setAlpha(255);
        this.mPaint.setStrokeWidth(3.0f);
        canvas.drawLine(this.mXCenter, this.mYCenter, i3, i5, this.mPaint);
    }

    public void setAnimationRadiusMultiplier(float f) {
        this.mAnimationRadiusMultiplier = f;
    }

    public void setSelection(int i, boolean z, boolean z2) {
        this.mSelectionDegrees = i;
        double d = i;
        Double.isNaN(d);
        this.mSelectionRadians = (d * 3.141592653589793d) / 180.0d;
        this.mForceDrawDot = z2;
        if (this.mHasInnerCircle) {
            this.mNumbersRadiusMultiplier = z ? this.mInnerNumbersRadiusMultiplier : this.mOuterNumbersRadiusMultiplier;
        }
    }
}
