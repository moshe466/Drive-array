package atlow.chemi.mymada.classes;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import atlow.chemi.mymada.classes.CircularProgressButton;
import atlow.chemi.mymada.helpers.UtilsJava;

/* loaded from: classes.dex */
public class CircularProgressButton extends AppCompatButton implements AnimatedButton, CustomizableByCode {
    private boolean doneWhileMorphing;
    private boolean layoutDone;
    private CircularAnimatedDrawable mAnimatedDrawable;
    private AnimatorSet mAnimatorSet;
    private Bitmap mBitmapDone;
    private int mFillColorDone;
    private GradientDrawable mGradientDrawable;
    private boolean mIsMorphingInProgress;
    private Params mParams;
    private CircularRevealAnimatedDrawable mRevealDrawable;
    private State mState;
    private int progress;
    private boolean shouldStartAnimation;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: atlow.chemi.mymada.classes.CircularProgressButton$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass2 extends AnimatorListenerAdapter {
        AnonymousClass2() {
        }

        public /* synthetic */ void a() {
            CircularProgressButton circularProgressButton = CircularProgressButton.this;
            circularProgressButton.doneLoadingAnimation(circularProgressButton.mFillColorDone, CircularProgressButton.this.mBitmapDone);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            CircularProgressButton.this.mIsMorphingInProgress = false;
            if (CircularProgressButton.this.doneWhileMorphing) {
                CircularProgressButton.this.doneWhileMorphing = false;
                new Handler().postDelayed(new Runnable() { // from class: atlow.chemi.mymada.classes.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        CircularProgressButton.AnonymousClass2.this.a();
                    }
                }, 50L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class BackgroundAndMorphingDrawables {
        Drawable a;
        GradientDrawable b;

        BackgroundAndMorphingDrawables() {
        }

        void a(GradientDrawable gradientDrawable) {
            this.a = gradientDrawable;
            this.b = gradientDrawable;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class Params {
        private int mDoneColor;
        private Drawable[] mDrawables;
        private float mFinalCornerRadius;
        private float mInitialCornerRadius;
        private Integer mInitialHeight;
        private int mInitialWidth;
        private Float mPaddingProgress;
        private int mSpinningBarColor;
        private float mSpinningBarWidth;
        private String mText;

        private Params(CircularProgressButton circularProgressButton) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum State {
        PROGRESS,
        IDLE,
        DONE,
        STOPPED
    }

    public CircularProgressButton(Context context) {
        super(context);
        init(context, null, 0, 0);
    }

    public CircularProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet, 0, 0);
    }

    public CircularProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i, 0);
    }

    @TargetApi(23)
    public CircularProgressButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        init(context, attributeSet, i, i2);
    }

    @Nullable
    static BackgroundAndMorphingDrawables a(Drawable drawable) {
        BackgroundAndMorphingDrawables backgroundAndMorphingDrawables = new BackgroundAndMorphingDrawables();
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof GradientDrawable) {
            backgroundAndMorphingDrawables.a((GradientDrawable) drawable);
        } else if (drawable instanceof ColorDrawable) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(((ColorDrawable) drawable).getColor());
            backgroundAndMorphingDrawables.a(gradientDrawable);
        } else if ((drawable instanceof InsetDrawable) && Build.VERSION.SDK_INT >= 19) {
            InsetDrawable insetDrawable = (InsetDrawable) drawable;
            backgroundAndMorphingDrawables = a(insetDrawable.getDrawable());
            if (backgroundAndMorphingDrawables != null) {
                backgroundAndMorphingDrawables.a = insetDrawable;
            }
        } else if (drawable instanceof StateListDrawable) {
            StateListDrawable stateListDrawable = (StateListDrawable) drawable;
            stateListDrawable.setState(new int[]{R.attr.state_enabled, R.attr.state_active, -16842919});
            backgroundAndMorphingDrawables = a(stateListDrawable.getCurrent());
        }
        if (backgroundAndMorphingDrawables == null || backgroundAndMorphingDrawables.b == null) {
            throw new RuntimeException("Error reading background... Use a shape or a color in xml!");
        }
        return backgroundAndMorphingDrawables;
    }

    private void drawDoneAnimation(Canvas canvas) {
        this.mRevealDrawable.draw(canvas);
    }

    private void drawProgress(Canvas canvas) {
        CircularAnimatedDrawable circularAnimatedDrawable = this.mAnimatedDrawable;
        if (circularAnimatedDrawable != null && circularAnimatedDrawable.isRunning()) {
            this.mAnimatedDrawable.b(this.progress);
            this.mAnimatedDrawable.draw(canvas);
            return;
        }
        this.mAnimatedDrawable = new CircularAnimatedDrawable(this, this.mParams.mSpinningBarWidth, this.mParams.mSpinningBarColor);
        int width = (getWidth() - getHeight()) / 2;
        int intValue = this.mParams.mPaddingProgress.intValue() + width;
        int width2 = (getWidth() - width) - this.mParams.mPaddingProgress.intValue();
        int height = getHeight() - this.mParams.mPaddingProgress.intValue();
        this.mAnimatedDrawable.setBounds(intValue, this.mParams.mPaddingProgress.intValue(), width2, height);
        this.mAnimatedDrawable.setCallback(this);
        this.mAnimatedDrawable.start();
    }

    private void init(Context context, AttributeSet attributeSet, int i, int i2) {
        BackgroundAndMorphingDrawables backgroundAndMorphingDrawables;
        this.mParams = new Params();
        this.mParams.mPaddingProgress = Float.valueOf(0.0f);
        if (attributeSet == null) {
            backgroundAndMorphingDrawables = a(UtilsJava.getDrawable(getContext(), atlow.chemi.mymada.R.drawable.round_button));
        } else {
            int[] iArr = {R.attr.background};
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, atlow.chemi.mymada.R.styleable.CircularProgressButton, i, i2);
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
            BackgroundAndMorphingDrawables a = a(obtainStyledAttributes2.getDrawable(0));
            this.mParams.mInitialCornerRadius = obtainStyledAttributes.getDimension(1, 100.0f);
            this.mParams.mFinalCornerRadius = obtainStyledAttributes.getDimension(0, 100.0f);
            this.mParams.mSpinningBarWidth = obtainStyledAttributes.getDimension(4, 10.0f);
            this.mParams.mSpinningBarColor = obtainStyledAttributes.getColor(2, UtilsJava.getColorWrapper(context, R.color.black));
            this.mParams.mPaddingProgress = Float.valueOf(obtainStyledAttributes.getDimension(3, 0.0f));
            obtainStyledAttributes.recycle();
            obtainStyledAttributes2.recycle();
            backgroundAndMorphingDrawables = a;
        }
        this.mState = State.IDLE;
        this.mParams.mText = getText().toString();
        this.mParams.mDrawables = getCompoundDrawablesRelative();
        if (backgroundAndMorphingDrawables != null) {
            this.mGradientDrawable = backgroundAndMorphingDrawables.b;
            Drawable drawable = backgroundAndMorphingDrawables.a;
            if (drawable != null) {
                setBackground(drawable);
            }
        }
        resetProgress();
    }

    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = intValue;
        setLayoutParams(layoutParams);
    }

    public /* synthetic */ void b(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = intValue;
        setLayoutParams(layoutParams);
    }

    public /* synthetic */ void c(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = intValue;
        setLayoutParams(layoutParams);
    }

    public /* synthetic */ void d(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = intValue;
        setLayoutParams(layoutParams);
    }

    @Override // atlow.chemi.mymada.classes.AnimatedButton
    public void dispose() {
        CircularAnimatedDrawable circularAnimatedDrawable = this.mAnimatedDrawable;
        if (circularAnimatedDrawable != null) {
            circularAnimatedDrawable.a();
        }
        CircularRevealAnimatedDrawable circularRevealAnimatedDrawable = this.mRevealDrawable;
        if (circularRevealAnimatedDrawable != null) {
            circularRevealAnimatedDrawable.a();
        }
    }

    public void doneLoadingAnimation(int i, Bitmap bitmap) {
        if (this.mState != State.PROGRESS) {
            return;
        }
        if (this.mIsMorphingInProgress) {
            this.doneWhileMorphing = true;
            this.mFillColorDone = i;
            this.mBitmapDone = bitmap;
            return;
        }
        this.mState = State.DONE;
        this.mAnimatedDrawable.stop();
        this.mRevealDrawable = new CircularRevealAnimatedDrawable(this, i, bitmap);
        this.mRevealDrawable.setBounds(0, 0, getWidth(), getHeight());
        this.mRevealDrawable.setCallback(this);
        this.mRevealDrawable.start();
    }

    public Boolean isAnimating() {
        return Boolean.valueOf(this.mState == State.PROGRESS);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.layoutDone = true;
        if (this.shouldStartAnimation) {
            startAnimation();
        }
        if (this.mState == State.PROGRESS && !this.mIsMorphingInProgress) {
            drawProgress(canvas);
        } else if (this.mState == State.DONE) {
            drawDoneAnimation(canvas);
        }
    }

    @Override // atlow.chemi.mymada.classes.AnimatedButton
    public void resetProgress() {
        this.progress = -1;
    }

    @Override // atlow.chemi.mymada.classes.AnimatedButton
    public void revertAnimation() {
        revertAnimation(null);
    }

    @Override // atlow.chemi.mymada.classes.AnimatedButton
    public void revertAnimation(final OnAnimationEndListener onAnimationEndListener) {
        State state = this.mState;
        State state2 = State.IDLE;
        if (state == state2) {
            return;
        }
        this.mState = state2;
        resetProgress();
        CircularAnimatedDrawable circularAnimatedDrawable = this.mAnimatedDrawable;
        if (circularAnimatedDrawable != null && circularAnimatedDrawable.isRunning()) {
            stopAnimation();
        }
        if (this.mIsMorphingInProgress) {
            this.mAnimatorSet.cancel();
        }
        setClickable(true);
        int width = getWidth();
        int height = getHeight();
        int intValue = this.mParams.mInitialHeight.intValue();
        int i = this.mParams.mInitialWidth;
        GradientDrawable gradientDrawable = this.mGradientDrawable;
        ObjectAnimator ofFloat = gradientDrawable != null ? ObjectAnimator.ofFloat(gradientDrawable, "cornerRadius", this.mParams.mFinalCornerRadius, this.mParams.mInitialCornerRadius) : null;
        ValueAnimator ofInt = ValueAnimator.ofInt(width, i);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: atlow.chemi.mymada.classes.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CircularProgressButton.this.a(valueAnimator);
            }
        });
        ValueAnimator ofInt2 = ValueAnimator.ofInt(height, intValue);
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: atlow.chemi.mymada.classes.h
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CircularProgressButton.this.b(valueAnimator);
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.setDuration(300L);
        if (this.mGradientDrawable != null) {
            this.mAnimatorSet.playTogether(ofFloat, ofInt, ofInt2);
        } else {
            this.mAnimatorSet.playTogether(ofInt, ofInt2);
        }
        this.mAnimatorSet.addListener(new AnimatorListenerAdapter() { // from class: atlow.chemi.mymada.classes.CircularProgressButton.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                CircularProgressButton.this.setClickable(true);
                CircularProgressButton.this.mIsMorphingInProgress = false;
                CircularProgressButton circularProgressButton = CircularProgressButton.this;
                circularProgressButton.setCompoundDrawablesRelative(circularProgressButton.mParams.mDrawables[0], CircularProgressButton.this.mParams.mDrawables[1], CircularProgressButton.this.mParams.mDrawables[2], CircularProgressButton.this.mParams.mDrawables[3]);
                OnAnimationEndListener onAnimationEndListener2 = onAnimationEndListener;
                if (onAnimationEndListener2 != null) {
                    onAnimationEndListener2.onAnimationEnd();
                }
            }
        });
        this.mIsMorphingInProgress = true;
        this.mAnimatorSet.start();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.mGradientDrawable.setColor(i);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(@ColorRes int i) {
        this.mGradientDrawable.setColor(ContextCompat.getColor(getContext(), i));
    }

    @Override // atlow.chemi.mymada.classes.CustomizableByCode
    public void setDoneColor(int i) {
        this.mParams.mDoneColor = i;
    }

    @Override // atlow.chemi.mymada.classes.CustomizableByCode
    public void setFinalCornerRadius(float f) {
        this.mParams.mFinalCornerRadius = f;
    }

    @Override // atlow.chemi.mymada.classes.CustomizableByCode
    public void setInitialCornerRadius(float f) {
        this.mParams.mInitialCornerRadius = f;
    }

    @Override // atlow.chemi.mymada.classes.CustomizableByCode
    public void setInitialHeight(int i) {
        this.mParams.mInitialHeight = Integer.valueOf(i);
    }

    @Override // atlow.chemi.mymada.classes.CustomizableByCode
    public void setPaddingProgress(float f) {
        this.mParams.mPaddingProgress = Float.valueOf(f);
    }

    @Override // atlow.chemi.mymada.classes.AnimatedButton
    public void setProgress(int i) {
        this.progress = Math.max(0, Math.min(100, i));
    }

    @Override // atlow.chemi.mymada.classes.CustomizableByCode
    public void setSpinningBarColor(int i) {
        this.mParams.mSpinningBarColor = i;
        CircularAnimatedDrawable circularAnimatedDrawable = this.mAnimatedDrawable;
        if (circularAnimatedDrawable != null) {
            circularAnimatedDrawable.a(i);
        }
    }

    @Override // atlow.chemi.mymada.classes.CustomizableByCode
    public void setSpinningBarWidth(float f) {
        this.mParams.mSpinningBarWidth = f;
    }

    @Override // atlow.chemi.mymada.classes.AnimatedButton
    public void startAnimation() {
        if (this.mState != State.IDLE) {
            return;
        }
        if (!this.layoutDone) {
            this.shouldStartAnimation = true;
            return;
        }
        this.shouldStartAnimation = false;
        if (this.mIsMorphingInProgress) {
            this.mAnimatorSet.cancel();
        } else {
            this.mParams.mInitialWidth = getWidth();
            this.mParams.mInitialHeight = Integer.valueOf(getHeight());
        }
        this.mState = State.PROGRESS;
        this.mParams.mText = getText().toString();
        setCompoundDrawables(null, null, null, null);
        setClickable(true);
        int intValue = this.mParams.mInitialHeight.intValue();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mGradientDrawable, "cornerRadius", this.mParams.mInitialCornerRadius, this.mParams.mFinalCornerRadius);
        ValueAnimator ofInt = ValueAnimator.ofInt(this.mParams.mInitialWidth, intValue);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: atlow.chemi.mymada.classes.g
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CircularProgressButton.this.c(valueAnimator);
            }
        });
        ValueAnimator ofInt2 = ValueAnimator.ofInt(this.mParams.mInitialHeight.intValue(), intValue);
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: atlow.chemi.mymada.classes.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CircularProgressButton.this.d(valueAnimator);
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.setDuration(300L);
        this.mAnimatorSet.playTogether(ofFloat, ofInt, ofInt2);
        this.mAnimatorSet.addListener(new AnonymousClass2());
        this.mIsMorphingInProgress = true;
        this.mAnimatorSet.start();
    }

    public void stopAnimation() {
        if (this.mState != State.PROGRESS || this.mIsMorphingInProgress) {
            return;
        }
        this.mState = State.STOPPED;
        this.mAnimatedDrawable.stop();
    }
}
