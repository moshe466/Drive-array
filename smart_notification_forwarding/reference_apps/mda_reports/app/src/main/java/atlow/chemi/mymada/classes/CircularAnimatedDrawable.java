package atlow.chemi.mymada.classes;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class CircularAnimatedDrawable extends Drawable implements Animatable {
    private static final int ANGLE_ANIMATOR_DURATION = 2000;
    private static final int PROGRESS_ANIMATOR_DURATION = 200;
    private static final int SWEEP_ANIMATOR_DURATION = 700;
    private View mAnimatedView;
    private AnimatorSet mAnimatorSet;
    private float mBorderWidth;
    private float mCurrentGlobalAngle;
    private float mCurrentGlobalAngleOffset;
    private float mCurrentSweepAngle;
    private boolean mModeAppearing;
    private boolean mRunning;
    private ValueAnimator mValueAnimatorAngle;
    private ValueAnimator mValueAnimatorProgress;
    private ValueAnimator mValueAnimatorSweep;
    private int progress;
    private boolean shouldDraw;
    private float shownProgress;
    private static final Interpolator ANGLE_INTERPOLATOR = new LinearInterpolator();
    private static final Interpolator SWEEP_INTERPOLATOR = new AccelerateDecelerateInterpolator();
    private static final Float MIN_SWEEP_ANGLE = Float.valueOf(50.0f);
    private final RectF fBounds = new RectF();
    private Paint mPaint = new Paint();

    /* JADX INFO: Access modifiers changed from: package-private */
    public CircularAnimatedDrawable(View view, float f, int i) {
        this.mAnimatedView = view;
        this.mBorderWidth = f;
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(f);
        this.mPaint.setColor(i);
        setupAnimations();
        this.shouldDraw = true;
        this.mAnimatorSet = new AnimatorSet();
    }

    private void setupAnimations() {
        this.mValueAnimatorAngle = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.mValueAnimatorAngle.setInterpolator(ANGLE_INTERPOLATOR);
        this.mValueAnimatorAngle.setDuration(2000L);
        this.mValueAnimatorAngle.setRepeatCount(-1);
        this.mValueAnimatorAngle.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: atlow.chemi.mymada.classes.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CircularAnimatedDrawable.this.b(valueAnimator);
            }
        });
        this.mValueAnimatorSweep = ValueAnimator.ofFloat(0.0f, 360.0f - (MIN_SWEEP_ANGLE.floatValue() * 2.0f));
        this.mValueAnimatorSweep.setInterpolator(SWEEP_INTERPOLATOR);
        this.mValueAnimatorSweep.setDuration(700L);
        this.mValueAnimatorSweep.setRepeatCount(-1);
        this.mValueAnimatorSweep.addListener(new AnimatorListenerAdapter() { // from class: atlow.chemi.mymada.classes.CircularAnimatedDrawable.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                CircularAnimatedDrawable.this.toggleAppearingMode();
                CircularAnimatedDrawable.this.shouldDraw = false;
            }
        });
        this.mValueAnimatorSweep.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: atlow.chemi.mymada.classes.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CircularAnimatedDrawable.this.c(valueAnimator);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleAppearingMode() {
        this.mModeAppearing = !this.mModeAppearing;
        if (this.mModeAppearing) {
            this.mCurrentGlobalAngleOffset = (this.mCurrentGlobalAngleOffset + (MIN_SWEEP_ANGLE.floatValue() * 2.0f)) % 360.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        ValueAnimator valueAnimator = this.mValueAnimatorAngle;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.mValueAnimatorAngle.removeAllUpdateListeners();
            this.mValueAnimatorAngle.cancel();
        }
        this.mValueAnimatorAngle = null;
        ValueAnimator valueAnimator2 = this.mValueAnimatorSweep;
        if (valueAnimator2 != null) {
            valueAnimator2.end();
            this.mValueAnimatorSweep.removeAllUpdateListeners();
            this.mValueAnimatorSweep.cancel();
        }
        this.mValueAnimatorSweep = null;
        ValueAnimator valueAnimator3 = this.mValueAnimatorProgress;
        if (valueAnimator3 != null) {
            if (valueAnimator3.isRunning()) {
                this.mValueAnimatorProgress.end();
            }
            this.mValueAnimatorProgress.removeAllUpdateListeners();
            this.mValueAnimatorProgress.cancel();
        }
        AnimatorSet animatorSet = this.mAnimatorSet;
        if (animatorSet != null) {
            animatorSet.end();
            this.mAnimatorSet.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.mPaint.setColor(i);
    }

    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        this.shownProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.mAnimatedView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        if (this.progress == i) {
            return;
        }
        this.progress = i;
        if (i < 0) {
            this.shownProgress = 0.0f;
        }
        ValueAnimator valueAnimator = this.mValueAnimatorProgress;
        if (valueAnimator == null) {
            this.mValueAnimatorProgress = ValueAnimator.ofFloat(this.shownProgress, i * 3.6f);
            this.mValueAnimatorProgress.setInterpolator(SWEEP_INTERPOLATOR);
            this.mValueAnimatorProgress.setDuration(200L);
            this.mValueAnimatorProgress.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: atlow.chemi.mymada.classes.b
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    CircularAnimatedDrawable.this.a(valueAnimator2);
                }
            });
        } else {
            if (valueAnimator.isRunning()) {
                this.mValueAnimatorProgress.cancel();
            }
            this.mValueAnimatorProgress.setFloatValues(this.shownProgress, i * 3.6f);
        }
        if (!isRunning() || i < 0) {
            return;
        }
        this.mValueAnimatorProgress.start();
    }

    public /* synthetic */ void b(ValueAnimator valueAnimator) {
        this.mCurrentGlobalAngle = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    public /* synthetic */ void c(ValueAnimator valueAnimator) {
        this.mCurrentSweepAngle = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (this.mCurrentSweepAngle < 5.0f) {
            this.shouldDraw = true;
        }
        if (this.shouldDraw) {
            this.mAnimatedView.invalidate();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        float floatValue;
        float f;
        float f2;
        float f3 = this.mCurrentGlobalAngle - this.mCurrentGlobalAngleOffset;
        float f4 = this.mCurrentSweepAngle;
        int i = this.progress;
        if (i < 0 || i > 100) {
            if (this.mModeAppearing) {
                floatValue = f4 + MIN_SWEEP_ANGLE.floatValue();
            } else {
                f3 += f4;
                floatValue = (360.0f - f4) - MIN_SWEEP_ANGLE.floatValue();
            }
            f = f3;
            f2 = floatValue;
        } else {
            f2 = this.shownProgress;
            f = -90.0f;
        }
        canvas.drawArc(this.fBounds, f, f2, false, this.mPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        RectF rectF = this.fBounds;
        float f = rect.left;
        float f2 = this.mBorderWidth;
        rectF.left = f + (f2 / 2.0f) + 0.5f;
        rectF.right = (rect.right - (f2 / 2.0f)) - 0.5f;
        rectF.top = rect.top + (f2 / 2.0f) + 0.5f;
        rectF.bottom = (rect.bottom - (f2 / 2.0f)) - 0.5f;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (isRunning()) {
            return;
        }
        this.mRunning = true;
        this.mAnimatorSet.playTogether(this.mValueAnimatorAngle, this.mValueAnimatorSweep);
        this.mAnimatorSet.start();
        ValueAnimator valueAnimator = this.mValueAnimatorProgress;
        if (valueAnimator == null || valueAnimator.isRunning()) {
            return;
        }
        this.mValueAnimatorProgress.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (isRunning()) {
            this.mRunning = false;
            this.mAnimatorSet.cancel();
        }
    }
}
