package androidx.swiperefreshlayout.widget;

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
import android.view.animation.LinearInterpolator;
import b0.InterpolatorC0321a;

/* loaded from: classes.dex */
public final class e extends Drawable implements Animatable {

    /* renamed from: j, reason: collision with root package name */
    public static final LinearInterpolator f3765j = new LinearInterpolator();

    /* renamed from: k, reason: collision with root package name */
    public static final InterpolatorC0321a f3766k = new InterpolatorC0321a(InterpolatorC0321a.f3798c);

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f3767l = {-16777216};

    /* renamed from: a, reason: collision with root package name */
    public final d f3768a;

    /* renamed from: b, reason: collision with root package name */
    public float f3769b;

    /* renamed from: c, reason: collision with root package name */
    public final Resources f3770c;

    /* renamed from: d, reason: collision with root package name */
    public final ValueAnimator f3771d;

    /* renamed from: e, reason: collision with root package name */
    public float f3772e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3773f;

    public e(Context context) {
        context.getClass();
        this.f3770c = context.getResources();
        d dVar = new d();
        this.f3768a = dVar;
        dVar.i = f3767l;
        dVar.a(0);
        dVar.f3753h = 2.5f;
        dVar.f3747b.setStrokeWidth(2.5f);
        invalidateSelf();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new b(this, dVar));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f3765j);
        ofFloat.addListener(new c(this, dVar));
        this.f3771d = ofFloat;
    }

    public static void d(float f4, d dVar) {
        if (f4 > 0.75f) {
            float f5 = (f4 - 0.75f) / 0.25f;
            int[] iArr = dVar.i;
            int i = dVar.f3754j;
            int i3 = iArr[i];
            int i4 = iArr[(i + 1) % iArr.length];
            dVar.f3764u = ((((i3 >> 24) & 255) + ((int) ((((i4 >> 24) & 255) - r1) * f5))) << 24) | ((((i3 >> 16) & 255) + ((int) ((((i4 >> 16) & 255) - r3) * f5))) << 16) | ((((i3 >> 8) & 255) + ((int) ((((i4 >> 8) & 255) - r4) * f5))) << 8) | ((i3 & 255) + ((int) (f5 * ((i4 & 255) - r2))));
            return;
        }
        dVar.f3764u = dVar.i[dVar.f3754j];
    }

    public final void a(float f4, d dVar, boolean z3) {
        float interpolation;
        float f5;
        if (this.f3773f) {
            d(f4, dVar);
            float floor = (float) (Math.floor(dVar.f3757m / 0.8f) + 1.0d);
            float f6 = dVar.f3755k;
            float f7 = dVar.f3756l;
            dVar.f3750e = (((f7 - 0.01f) - f6) * f4) + f6;
            dVar.f3751f = f7;
            float f8 = dVar.f3757m;
            dVar.f3752g = ((floor - f8) * f4) + f8;
            return;
        }
        if (f4 == 1.0f && !z3) {
            return;
        }
        float f9 = dVar.f3757m;
        InterpolatorC0321a interpolatorC0321a = f3766k;
        if (f4 < 0.5f) {
            interpolation = dVar.f3755k;
            f5 = (interpolatorC0321a.getInterpolation(f4 / 0.5f) * 0.79f) + 0.01f + interpolation;
        } else {
            float f10 = dVar.f3755k + 0.79f;
            interpolation = f10 - (((1.0f - interpolatorC0321a.getInterpolation((f4 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
            f5 = f10;
        }
        float f11 = (0.20999998f * f4) + f9;
        float f12 = (f4 + this.f3772e) * 216.0f;
        dVar.f3750e = interpolation;
        dVar.f3751f = f5;
        dVar.f3752g = f11;
        this.f3769b = f12;
    }

    public final void b(float f4, float f5, float f6, float f7) {
        float f8 = this.f3770c.getDisplayMetrics().density;
        float f9 = f5 * f8;
        d dVar = this.f3768a;
        dVar.f3753h = f9;
        dVar.f3747b.setStrokeWidth(f9);
        dVar.f3760q = f4 * f8;
        dVar.a(0);
        dVar.f3761r = (int) (f6 * f8);
        dVar.f3762s = (int) (f7 * f8);
    }

    public final void c(int i) {
        if (i == 0) {
            b(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            b(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f3769b, bounds.exactCenterX(), bounds.exactCenterY());
        d dVar = this.f3768a;
        Paint paint = dVar.f3747b;
        RectF rectF = dVar.f3746a;
        float f4 = dVar.f3760q;
        float f5 = (dVar.f3753h / 2.0f) + f4;
        if (f4 <= 0.0f) {
            f5 = (Math.min(bounds.width(), bounds.height()) / 2.0f) - Math.max((dVar.f3761r * dVar.p) / 2.0f, dVar.f3753h / 2.0f);
        }
        rectF.set(bounds.centerX() - f5, bounds.centerY() - f5, bounds.centerX() + f5, bounds.centerY() + f5);
        float f6 = dVar.f3750e;
        float f7 = dVar.f3752g;
        float f8 = (f6 + f7) * 360.0f;
        float f9 = ((dVar.f3751f + f7) * 360.0f) - f8;
        paint.setColor(dVar.f3764u);
        paint.setAlpha(dVar.f3763t);
        float f10 = dVar.f3753h / 2.0f;
        rectF.inset(f10, f10);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, dVar.f3749d);
        float f11 = -f10;
        rectF.inset(f11, f11);
        canvas.drawArc(rectF, f8, f9, false, paint);
        Paint paint2 = dVar.f3748c;
        if (dVar.f3758n) {
            Path path = dVar.f3759o;
            if (path == null) {
                Path path2 = new Path();
                dVar.f3759o = path2;
                path2.setFillType(Path.FillType.EVEN_ODD);
            } else {
                path.reset();
            }
            float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
            float f12 = (dVar.f3761r * dVar.p) / 2.0f;
            dVar.f3759o.moveTo(0.0f, 0.0f);
            dVar.f3759o.lineTo(dVar.f3761r * dVar.p, 0.0f);
            Path path3 = dVar.f3759o;
            float f13 = dVar.f3761r;
            float f14 = dVar.p;
            path3.lineTo((f13 * f14) / 2.0f, dVar.f3762s * f14);
            dVar.f3759o.offset((rectF.centerX() + min) - f12, (dVar.f3753h / 2.0f) + rectF.centerY());
            dVar.f3759o.close();
            paint2.setColor(dVar.f3764u);
            paint2.setAlpha(dVar.f3763t);
            canvas.save();
            canvas.rotate(f8 + f9, rectF.centerX(), rectF.centerY());
            canvas.drawPath(dVar.f3759o, paint2);
            canvas.restore();
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f3768a.f3763t;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f3771d.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.f3768a.f3763t = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f3768a.f3747b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        this.f3771d.cancel();
        d dVar = this.f3768a;
        float f4 = dVar.f3750e;
        dVar.f3755k = f4;
        float f5 = dVar.f3751f;
        dVar.f3756l = f5;
        dVar.f3757m = dVar.f3752g;
        if (f5 != f4) {
            this.f3773f = true;
            this.f3771d.setDuration(666L);
            this.f3771d.start();
            return;
        }
        dVar.a(0);
        dVar.f3755k = 0.0f;
        dVar.f3756l = 0.0f;
        dVar.f3757m = 0.0f;
        dVar.f3750e = 0.0f;
        dVar.f3751f = 0.0f;
        dVar.f3752g = 0.0f;
        this.f3771d.setDuration(1332L);
        this.f3771d.start();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f3771d.cancel();
        this.f3769b = 0.0f;
        d dVar = this.f3768a;
        if (dVar.f3758n) {
            dVar.f3758n = false;
        }
        dVar.a(0);
        dVar.f3755k = 0.0f;
        dVar.f3756l = 0.0f;
        dVar.f3757m = 0.0f;
        dVar.f3750e = 0.0f;
        dVar.f3751f = 0.0f;
        dVar.f3752g = 0.0f;
        invalidateSelf();
    }
}
