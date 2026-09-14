package atlow.chemi.mymada.classes;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

/* loaded from: classes.dex */
public class CircularRevealAnimatedDrawable extends Drawable implements Animatable {
    private float bitMapXOffset;
    private float bitMapYOffset;
    private View mAnimatedView;
    private float mCenterHeight;
    private float mCenterWidth;
    private float mFinalRadius;
    private int mImageReadyAlpha;
    private boolean mIsFilled;
    private Paint mPaintImageReady;
    private float mRadius;
    private Bitmap mReadyImage;
    private ValueAnimator mRevealInAnimation;
    private boolean isRunning = false;
    private Paint mPaint = new Paint();

    /* JADX INFO: Access modifiers changed from: package-private */
    public CircularRevealAnimatedDrawable(View view, int i, Bitmap bitmap) {
        this.mAnimatedView = view;
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(i);
        this.mPaintImageReady = new Paint();
        this.mPaintImageReady.setAntiAlias(true);
        this.mPaintImageReady.setStyle(Paint.Style.FILL);
        this.mPaintImageReady.setColor(0);
        this.mReadyImage = bitmap;
        this.mImageReadyAlpha = 0;
        this.mRadius = 0.0f;
    }

    private void setupAnimations() {
        final ValueAnimator ofInt = ValueAnimator.ofInt(0, 255);
        ofInt.setDuration(80L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: atlow.chemi.mymada.classes.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CircularRevealAnimatedDrawable.this.a(valueAnimator);
            }
        });
        this.mRevealInAnimation = ValueAnimator.ofFloat(0.0f, this.mFinalRadius);
        this.mRevealInAnimation.setInterpolator(new DecelerateInterpolator());
        this.mRevealInAnimation.setDuration(120L);
        this.mRevealInAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: atlow.chemi.mymada.classes.i
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CircularRevealAnimatedDrawable.this.b(valueAnimator);
            }
        });
        this.mRevealInAnimation.addListener(new AnimatorListenerAdapter() { // from class: atlow.chemi.mymada.classes.CircularRevealAnimatedDrawable.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                CircularRevealAnimatedDrawable.this.mIsFilled = true;
                ofInt.start();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        ValueAnimator valueAnimator = this.mRevealInAnimation;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.mRevealInAnimation.removeAllUpdateListeners();
            this.mRevealInAnimation.cancel();
        }
        this.mRevealInAnimation = null;
    }

    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        this.mImageReadyAlpha = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        invalidateSelf();
        this.mAnimatedView.invalidate();
    }

    public /* synthetic */ void b(ValueAnimator valueAnimator) {
        this.mRadius = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidateSelf();
        this.mAnimatedView.invalidate();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawCircle(this.mCenterWidth, this.mCenterHeight, this.mRadius, this.mPaint);
        if (this.mIsFilled) {
            this.mPaintImageReady.setAlpha(this.mImageReadyAlpha);
            canvas.drawBitmap(this.mReadyImage, this.bitMapXOffset, this.bitMapYOffset, this.mPaintImageReady);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    public boolean isFilled() {
        return this.mIsFilled;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        double d = rect.right - rect.left;
        Double.isNaN(d);
        double d2 = rect.bottom - rect.top;
        Double.isNaN(d2);
        this.bitMapXOffset = ((r0 - r1) - r2) / 2;
        this.bitMapYOffset = ((r3 - r6) - r4) / 2;
        this.mReadyImage = Bitmap.createScaledBitmap(this.mReadyImage, (int) (d * 0.6d), (int) (d2 * 0.6d), false);
        int i = rect.right;
        int i2 = rect.left;
        this.mFinalRadius = (i - i2) / 2;
        this.mCenterWidth = (i + i2) / 2;
        this.mCenterHeight = (rect.bottom + rect.top) / 2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (isRunning()) {
            return;
        }
        setupAnimations();
        this.isRunning = true;
        this.mRevealInAnimation.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (isRunning()) {
            this.isRunning = false;
            this.mRevealInAnimation.cancel();
        }
    }
}
