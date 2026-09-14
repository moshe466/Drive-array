package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class CircularProgressDrawable extends Drawable implements Animatable {
    private static final int ANIMATION_DURATION = 1332;
    private static final int ARROW_HEIGHT = 5;
    private static final int ARROW_HEIGHT_LARGE = 6;
    private static final int ARROW_WIDTH = 10;
    private static final int ARROW_WIDTH_LARGE = 12;
    private static final float CENTER_RADIUS = 7.5f;
    private static final float CENTER_RADIUS_LARGE = 11.0f;
    private static final float COLOR_CHANGE_OFFSET = 0.75f;
    public static final int DEFAULT = 1;
    private static final float GROUP_FULL_ROTATION = 216.0f;
    public static final int LARGE = 0;
    private static final float MAX_PROGRESS_ARC = 0.8f;
    private static final float MIN_PROGRESS_ARC = 0.01f;
    private static final float RING_ROTATION = 0.20999998f;
    private static final float SHRINK_OFFSET = 0.5f;
    private static final float STROKE_WIDTH = 2.5f;
    private static final float STROKE_WIDTH_LARGE = 3.0f;
    float a;
    boolean b;
    private Animator mAnimator;
    private Resources mResources;
    private final Ring mRing = new Ring();
    private float mRotation;
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static final Interpolator MATERIAL_INTERPOLATOR = new FastOutSlowInInterpolator();
    private static final int[] COLORS = {ViewCompat.MEASURED_STATE_MASK};

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public @interface ProgressDrawableSize {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Ring {
        int[] i;
        int j;
        float k;
        float l;
        float m;
        boolean n;
        Path o;
        float q;
        int r;
        int s;
        int u;
        final RectF a = new RectF();
        final Paint b = new Paint();
        final Paint c = new Paint();
        final Paint d = new Paint();
        float e = 0.0f;
        float f = 0.0f;
        float g = 0.0f;
        float h = 5.0f;
        float p = 1.0f;
        int t = 255;

        Ring() {
            this.b.setStrokeCap(Paint.Cap.SQUARE);
            this.b.setAntiAlias(true);
            this.b.setStyle(Paint.Style.STROKE);
            this.c.setStyle(Paint.Style.FILL);
            this.c.setAntiAlias(true);
            this.d.setColor(0);
        }

        int a() {
            return this.t;
        }

        void a(float f) {
            if (f != this.p) {
                this.p = f;
            }
        }

        void a(float f, float f2) {
            this.r = (int) f;
            this.s = (int) f2;
        }

        void a(int i) {
            this.t = i;
        }

        void a(Canvas canvas, float f, float f2, RectF rectF) {
            if (this.n) {
                Path path = this.o;
                if (path == null) {
                    this.o = new Path();
                    this.o.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
                float f3 = (this.r * this.p) / 2.0f;
                this.o.moveTo(0.0f, 0.0f);
                this.o.lineTo(this.r * this.p, 0.0f);
                Path path2 = this.o;
                float f4 = this.r;
                float f5 = this.p;
                path2.lineTo((f4 * f5) / 2.0f, this.s * f5);
                this.o.offset((min + rectF.centerX()) - f3, rectF.centerY() + (this.h / 2.0f));
                this.o.close();
                this.c.setColor(this.u);
                this.c.setAlpha(this.t);
                canvas.save();
                canvas.rotate(f + f2, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.o, this.c);
                canvas.restore();
            }
        }

        void a(Canvas canvas, Rect rect) {
            RectF rectF = this.a;
            float f = this.q;
            float f2 = (this.h / 2.0f) + f;
            if (f <= 0.0f) {
                f2 = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.r * this.p) / 2.0f, this.h / 2.0f);
            }
            rectF.set(rect.centerX() - f2, rect.centerY() - f2, rect.centerX() + f2, rect.centerY() + f2);
            float f3 = this.e;
            float f4 = this.g;
            float f5 = (f3 + f4) * 360.0f;
            float f6 = ((this.f + f4) * 360.0f) - f5;
            this.b.setColor(this.u);
            this.b.setAlpha(this.t);
            float f7 = this.h / 2.0f;
            rectF.inset(f7, f7);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.d);
            float f8 = -f7;
            rectF.inset(f8, f8);
            canvas.drawArc(rectF, f5, f6, false, this.b);
            a(canvas, f5, f6, rectF);
        }

        void a(ColorFilter colorFilter) {
            this.b.setColorFilter(colorFilter);
        }

        void a(Paint.Cap cap) {
            this.b.setStrokeCap(cap);
        }

        void a(boolean z) {
            if (this.n != z) {
                this.n = z;
            }
        }

        void a(@NonNull int[] iArr) {
            this.i = iArr;
            d(0);
        }

        float b() {
            return this.s;
        }

        void b(float f) {
            this.q = f;
        }

        void b(int i) {
            this.d.setColor(i);
        }

        float c() {
            return this.p;
        }

        void c(float f) {
            this.f = f;
        }

        void c(int i) {
            this.u = i;
        }

        float d() {
            return this.r;
        }

        void d(float f) {
            this.g = f;
        }

        void d(int i) {
            this.j = i;
            this.u = this.i[this.j];
        }

        int e() {
            return this.d.getColor();
        }

        void e(float f) {
            this.e = f;
        }

        float f() {
            return this.q;
        }

        void f(float f) {
            this.h = f;
            this.b.setStrokeWidth(f);
        }

        int[] g() {
            return this.i;
        }

        float h() {
            return this.f;
        }

        int i() {
            return this.i[j()];
        }

        int j() {
            return (this.j + 1) % this.i.length;
        }

        float k() {
            return this.g;
        }

        boolean l() {
            return this.n;
        }

        float m() {
            return this.e;
        }

        int n() {
            return this.i[this.j];
        }

        float o() {
            return this.l;
        }

        float p() {
            return this.m;
        }

        float q() {
            return this.k;
        }

        Paint.Cap r() {
            return this.b.getStrokeCap();
        }

        float s() {
            return this.h;
        }

        void t() {
            d(j());
        }

        void u() {
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            e(0.0f);
            c(0.0f);
            d(0.0f);
        }

        void v() {
            this.k = this.e;
            this.l = this.f;
            this.m = this.g;
        }
    }

    public CircularProgressDrawable(@NonNull Context context) {
        this.mResources = ((Context) Preconditions.checkNotNull(context)).getResources();
        this.mRing.a(COLORS);
        setStrokeWidth(STROKE_WIDTH);
        setupAnimators();
    }

    private void applyFinishTranslation(float f, Ring ring) {
        a(f, ring);
        float floor = (float) (Math.floor(ring.p() / MAX_PROGRESS_ARC) + 1.0d);
        ring.e(ring.q() + (((ring.o() - MIN_PROGRESS_ARC) - ring.q()) * f));
        ring.c(ring.o());
        ring.d(ring.p() + ((floor - ring.p()) * f));
    }

    private int evaluateColorChange(float f, int i, int i2) {
        return ((((i >> 24) & 255) + ((int) ((((i2 >> 24) & 255) - r0) * f))) << 24) | ((((i >> 16) & 255) + ((int) ((((i2 >> 16) & 255) - r1) * f))) << 16) | ((((i >> 8) & 255) + ((int) ((((i2 >> 8) & 255) - r2) * f))) << 8) | ((i & 255) + ((int) (f * ((i2 & 255) - r8))));
    }

    private float getRotation() {
        return this.mRotation;
    }

    private void setRotation(float f) {
        this.mRotation = f;
    }

    private void setSizeParameters(float f, float f2, float f3, float f4) {
        Ring ring = this.mRing;
        float f5 = this.mResources.getDisplayMetrics().density;
        ring.f(f2 * f5);
        ring.b(f * f5);
        ring.d(0);
        ring.a(f3 * f5, f4 * f5);
    }

    private void setupAnimators() {
        final Ring ring = this.mRing;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.swiperefreshlayout.widget.CircularProgressDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircularProgressDrawable.this.a(floatValue, ring);
                CircularProgressDrawable.this.a(floatValue, ring, false);
                CircularProgressDrawable.this.invalidateSelf();
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(LINEAR_INTERPOLATOR);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: androidx.swiperefreshlayout.widget.CircularProgressDrawable.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                CircularProgressDrawable.this.a(1.0f, ring, true);
                ring.v();
                ring.t();
                CircularProgressDrawable circularProgressDrawable = CircularProgressDrawable.this;
                if (!circularProgressDrawable.b) {
                    circularProgressDrawable.a += 1.0f;
                    return;
                }
                circularProgressDrawable.b = false;
                animator.cancel();
                animator.setDuration(1332L);
                animator.start();
                ring.a(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                CircularProgressDrawable.this.a = 0.0f;
            }
        });
        this.mAnimator = ofFloat;
    }

    void a(float f, Ring ring) {
        ring.c(f > COLOR_CHANGE_OFFSET ? evaluateColorChange((f - COLOR_CHANGE_OFFSET) / 0.25f, ring.n(), ring.i()) : ring.n());
    }

    void a(float f, Ring ring, boolean z) {
        float q;
        float interpolation;
        if (this.b) {
            applyFinishTranslation(f, ring);
            return;
        }
        if (f != 1.0f || z) {
            float p = ring.p();
            if (f < SHRINK_OFFSET) {
                float f2 = f / SHRINK_OFFSET;
                float q2 = ring.q();
                q = (MATERIAL_INTERPOLATOR.getInterpolation(f2) * 0.79f) + MIN_PROGRESS_ARC + q2;
                interpolation = q2;
            } else {
                float f3 = (f - SHRINK_OFFSET) / SHRINK_OFFSET;
                q = ring.q() + 0.79f;
                interpolation = q - (((1.0f - MATERIAL_INTERPOLATOR.getInterpolation(f3)) * 0.79f) + MIN_PROGRESS_ARC);
            }
            float f4 = p + (RING_ROTATION * f);
            float f5 = (f + this.a) * GROUP_FULL_ROTATION;
            ring.e(interpolation);
            ring.c(q);
            ring.d(f4);
            setRotation(f5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.mRotation, bounds.exactCenterX(), bounds.exactCenterY());
        this.mRing.a(canvas, bounds);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mRing.a();
    }

    public boolean getArrowEnabled() {
        return this.mRing.l();
    }

    public float getArrowHeight() {
        return this.mRing.b();
    }

    public float getArrowScale() {
        return this.mRing.c();
    }

    public float getArrowWidth() {
        return this.mRing.d();
    }

    public int getBackgroundColor() {
        return this.mRing.e();
    }

    public float getCenterRadius() {
        return this.mRing.f();
    }

    @NonNull
    public int[] getColorSchemeColors() {
        return this.mRing.g();
    }

    public float getEndTrim() {
        return this.mRing.h();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float getProgressRotation() {
        return this.mRing.k();
    }

    public float getStartTrim() {
        return this.mRing.m();
    }

    @NonNull
    public Paint.Cap getStrokeCap() {
        return this.mRing.r();
    }

    public float getStrokeWidth() {
        return this.mRing.s();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mAnimator.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mRing.a(i);
        invalidateSelf();
    }

    public void setArrowDimensions(float f, float f2) {
        this.mRing.a(f, f2);
        invalidateSelf();
    }

    public void setArrowEnabled(boolean z) {
        this.mRing.a(z);
        invalidateSelf();
    }

    public void setArrowScale(float f) {
        this.mRing.a(f);
        invalidateSelf();
    }

    public void setBackgroundColor(int i) {
        this.mRing.b(i);
        invalidateSelf();
    }

    public void setCenterRadius(float f) {
        this.mRing.b(f);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mRing.a(colorFilter);
        invalidateSelf();
    }

    public void setColorSchemeColors(@NonNull int... iArr) {
        this.mRing.a(iArr);
        this.mRing.d(0);
        invalidateSelf();
    }

    public void setProgressRotation(float f) {
        this.mRing.d(f);
        invalidateSelf();
    }

    public void setStartEndTrim(float f, float f2) {
        this.mRing.e(f);
        this.mRing.c(f2);
        invalidateSelf();
    }

    public void setStrokeCap(@NonNull Paint.Cap cap) {
        this.mRing.a(cap);
        invalidateSelf();
    }

    public void setStrokeWidth(float f) {
        this.mRing.f(f);
        invalidateSelf();
    }

    public void setStyle(int i) {
        float f;
        float f2;
        float f3;
        float f4;
        if (i == 0) {
            f = CENTER_RADIUS_LARGE;
            f2 = STROKE_WIDTH_LARGE;
            f3 = 12.0f;
            f4 = 6.0f;
        } else {
            f = CENTER_RADIUS;
            f2 = STROKE_WIDTH;
            f3 = 10.0f;
            f4 = 5.0f;
        }
        setSizeParameters(f, f2, f3, f4);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Animator animator;
        long j;
        this.mAnimator.cancel();
        this.mRing.v();
        if (this.mRing.h() != this.mRing.m()) {
            this.b = true;
            animator = this.mAnimator;
            j = 666;
        } else {
            this.mRing.d(0);
            this.mRing.u();
            animator = this.mAnimator;
            j = 1332;
        }
        animator.setDuration(j);
        this.mAnimator.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.mAnimator.cancel();
        setRotation(0.0f);
        this.mRing.a(false);
        this.mRing.d(0);
        this.mRing.u();
        invalidateSelf();
    }
}
