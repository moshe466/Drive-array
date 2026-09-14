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
import androidx.core.util.h;

/* loaded from: classes.dex */
public class b extends Drawable implements Animatable {

    /* renamed from: l, reason: collision with root package name */
    private static final Interpolator f3705l = new LinearInterpolator();

    /* renamed from: m, reason: collision with root package name */
    private static final Interpolator f3706m = new f0.b();

    /* renamed from: n, reason: collision with root package name */
    private static final int[] f3707n = {-16777216};

    /* renamed from: f, reason: collision with root package name */
    private final c f3708f;

    /* renamed from: g, reason: collision with root package name */
    private float f3709g;

    /* renamed from: h, reason: collision with root package name */
    private Resources f3710h;

    /* renamed from: i, reason: collision with root package name */
    private Animator f3711i;

    /* renamed from: j, reason: collision with root package name */
    float f3712j;

    /* renamed from: k, reason: collision with root package name */
    boolean f3713k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f3714a;

        a(c cVar) {
            this.f3714a = cVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            b.this.n(floatValue, this.f3714a);
            b.this.b(floatValue, this.f3714a, false);
            b.this.invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.swiperefreshlayout.widget.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0061b implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f3716a;

        C0061b(c cVar) {
            this.f3716a = cVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            b.this.b(1.0f, this.f3716a, true);
            this.f3716a.A();
            this.f3716a.l();
            b bVar = b.this;
            if (!bVar.f3713k) {
                bVar.f3712j += 1.0f;
                return;
            }
            bVar.f3713k = false;
            animator.cancel();
            animator.setDuration(1332L);
            animator.start();
            this.f3716a.x(false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.f3712j = 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        final RectF f3718a = new RectF();

        /* renamed from: b, reason: collision with root package name */
        final Paint f3719b;

        /* renamed from: c, reason: collision with root package name */
        final Paint f3720c;

        /* renamed from: d, reason: collision with root package name */
        final Paint f3721d;

        /* renamed from: e, reason: collision with root package name */
        float f3722e;

        /* renamed from: f, reason: collision with root package name */
        float f3723f;

        /* renamed from: g, reason: collision with root package name */
        float f3724g;

        /* renamed from: h, reason: collision with root package name */
        float f3725h;

        /* renamed from: i, reason: collision with root package name */
        int[] f3726i;

        /* renamed from: j, reason: collision with root package name */
        int f3727j;

        /* renamed from: k, reason: collision with root package name */
        float f3728k;

        /* renamed from: l, reason: collision with root package name */
        float f3729l;

        /* renamed from: m, reason: collision with root package name */
        float f3730m;

        /* renamed from: n, reason: collision with root package name */
        boolean f3731n;

        /* renamed from: o, reason: collision with root package name */
        Path f3732o;

        /* renamed from: p, reason: collision with root package name */
        float f3733p;

        /* renamed from: q, reason: collision with root package name */
        float f3734q;

        /* renamed from: r, reason: collision with root package name */
        int f3735r;

        /* renamed from: s, reason: collision with root package name */
        int f3736s;

        /* renamed from: t, reason: collision with root package name */
        int f3737t;

        /* renamed from: u, reason: collision with root package name */
        int f3738u;

        c() {
            Paint paint = new Paint();
            this.f3719b = paint;
            Paint paint2 = new Paint();
            this.f3720c = paint2;
            Paint paint3 = new Paint();
            this.f3721d = paint3;
            this.f3722e = 0.0f;
            this.f3723f = 0.0f;
            this.f3724g = 0.0f;
            this.f3725h = 5.0f;
            this.f3733p = 1.0f;
            this.f3737t = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        void A() {
            this.f3728k = this.f3722e;
            this.f3729l = this.f3723f;
            this.f3730m = this.f3724g;
        }

        void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f3718a;
            float f10 = this.f3734q;
            float f11 = (this.f3725h / 2.0f) + f10;
            if (f10 <= 0.0f) {
                f11 = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.f3735r * this.f3733p) / 2.0f, this.f3725h / 2.0f);
            }
            rectF.set(rect.centerX() - f11, rect.centerY() - f11, rect.centerX() + f11, rect.centerY() + f11);
            float f12 = this.f3722e;
            float f13 = this.f3724g;
            float f14 = (f12 + f13) * 360.0f;
            float f15 = ((this.f3723f + f13) * 360.0f) - f14;
            this.f3719b.setColor(this.f3738u);
            this.f3719b.setAlpha(this.f3737t);
            float f16 = this.f3725h / 2.0f;
            rectF.inset(f16, f16);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f3721d);
            float f17 = -f16;
            rectF.inset(f17, f17);
            canvas.drawArc(rectF, f14, f15, false, this.f3719b);
            b(canvas, f14, f15, rectF);
        }

        void b(Canvas canvas, float f10, float f11, RectF rectF) {
            if (this.f3731n) {
                Path path = this.f3732o;
                if (path == null) {
                    Path path2 = new Path();
                    this.f3732o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
                float f12 = (this.f3735r * this.f3733p) / 2.0f;
                this.f3732o.moveTo(0.0f, 0.0f);
                this.f3732o.lineTo(this.f3735r * this.f3733p, 0.0f);
                Path path3 = this.f3732o;
                float f13 = this.f3735r;
                float f14 = this.f3733p;
                path3.lineTo((f13 * f14) / 2.0f, this.f3736s * f14);
                this.f3732o.offset((min + rectF.centerX()) - f12, rectF.centerY() + (this.f3725h / 2.0f));
                this.f3732o.close();
                this.f3720c.setColor(this.f3738u);
                this.f3720c.setAlpha(this.f3737t);
                canvas.save();
                canvas.rotate(f10 + f11, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.f3732o, this.f3720c);
                canvas.restore();
            }
        }

        int c() {
            return this.f3737t;
        }

        float d() {
            return this.f3723f;
        }

        int e() {
            return this.f3726i[f()];
        }

        int f() {
            return (this.f3727j + 1) % this.f3726i.length;
        }

        float g() {
            return this.f3722e;
        }

        int h() {
            return this.f3726i[this.f3727j];
        }

        float i() {
            return this.f3729l;
        }

        float j() {
            return this.f3730m;
        }

        float k() {
            return this.f3728k;
        }

        void l() {
            t(f());
        }

        void m() {
            this.f3728k = 0.0f;
            this.f3729l = 0.0f;
            this.f3730m = 0.0f;
            y(0.0f);
            v(0.0f);
            w(0.0f);
        }

        void n(int i10) {
            this.f3737t = i10;
        }

        void o(float f10, float f11) {
            this.f3735r = (int) f10;
            this.f3736s = (int) f11;
        }

        void p(float f10) {
            if (f10 != this.f3733p) {
                this.f3733p = f10;
            }
        }

        void q(float f10) {
            this.f3734q = f10;
        }

        void r(int i10) {
            this.f3738u = i10;
        }

        void s(ColorFilter colorFilter) {
            this.f3719b.setColorFilter(colorFilter);
        }

        void t(int i10) {
            this.f3727j = i10;
            this.f3738u = this.f3726i[i10];
        }

        void u(int[] iArr) {
            this.f3726i = iArr;
            t(0);
        }

        void v(float f10) {
            this.f3723f = f10;
        }

        void w(float f10) {
            this.f3724g = f10;
        }

        void x(boolean z10) {
            if (this.f3731n != z10) {
                this.f3731n = z10;
            }
        }

        void y(float f10) {
            this.f3722e = f10;
        }

        void z(float f10) {
            this.f3725h = f10;
            this.f3719b.setStrokeWidth(f10);
        }
    }

    public b(Context context) {
        this.f3710h = ((Context) h.f(context)).getResources();
        c cVar = new c();
        this.f3708f = cVar;
        cVar.u(f3707n);
        k(2.5f);
        m();
    }

    private void a(float f10, c cVar) {
        n(f10, cVar);
        float floor = (float) (Math.floor(cVar.j() / 0.8f) + 1.0d);
        cVar.y(cVar.k() + (((cVar.i() - 0.01f) - cVar.k()) * f10));
        cVar.v(cVar.i());
        cVar.w(cVar.j() + ((floor - cVar.j()) * f10));
    }

    private int c(float f10, int i10, int i11) {
        return ((((i10 >> 24) & 255) + ((int) ((((i11 >> 24) & 255) - r0) * f10))) << 24) | ((((i10 >> 16) & 255) + ((int) ((((i11 >> 16) & 255) - r1) * f10))) << 16) | ((((i10 >> 8) & 255) + ((int) ((((i11 >> 8) & 255) - r2) * f10))) << 8) | ((i10 & 255) + ((int) (f10 * ((i11 & 255) - r8))));
    }

    private void h(float f10) {
        this.f3709g = f10;
    }

    private void i(float f10, float f11, float f12, float f13) {
        c cVar = this.f3708f;
        float f14 = this.f3710h.getDisplayMetrics().density;
        cVar.z(f11 * f14);
        cVar.q(f10 * f14);
        cVar.t(0);
        cVar.o(f12 * f14, f13 * f14);
    }

    private void m() {
        c cVar = this.f3708f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new a(cVar));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f3705l);
        ofFloat.addListener(new C0061b(cVar));
        this.f3711i = ofFloat;
    }

    void b(float f10, c cVar, boolean z10) {
        float interpolation;
        float f11;
        if (this.f3713k) {
            a(f10, cVar);
            return;
        }
        if (f10 != 1.0f || z10) {
            float j10 = cVar.j();
            if (f10 < 0.5f) {
                interpolation = cVar.k();
                f11 = (f3706m.getInterpolation(f10 / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                float k10 = cVar.k() + 0.79f;
                interpolation = k10 - (((1.0f - f3706m.getInterpolation((f10 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f11 = k10;
            }
            float f12 = j10 + (0.20999998f * f10);
            float f13 = (f10 + this.f3712j) * 216.0f;
            cVar.y(interpolation);
            cVar.v(f11);
            cVar.w(f12);
            h(f13);
        }
    }

    public void d(boolean z10) {
        this.f3708f.x(z10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f3709g, bounds.exactCenterX(), bounds.exactCenterY());
        this.f3708f.a(canvas, bounds);
        canvas.restore();
    }

    public void e(float f10) {
        this.f3708f.p(f10);
        invalidateSelf();
    }

    public void f(int... iArr) {
        this.f3708f.u(iArr);
        this.f3708f.t(0);
        invalidateSelf();
    }

    public void g(float f10) {
        this.f3708f.w(f10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f3708f.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f3711i.isRunning();
    }

    public void j(float f10, float f11) {
        this.f3708f.y(f10);
        this.f3708f.v(f11);
        invalidateSelf();
    }

    public void k(float f10) {
        this.f3708f.z(f10);
        invalidateSelf();
    }

    public void l(int i10) {
        float f10;
        float f11;
        float f12;
        float f13;
        if (i10 == 0) {
            f10 = 11.0f;
            f11 = 3.0f;
            f12 = 12.0f;
            f13 = 6.0f;
        } else {
            f10 = 7.5f;
            f11 = 2.5f;
            f12 = 10.0f;
            f13 = 5.0f;
        }
        i(f10, f11, f12, f13);
        invalidateSelf();
    }

    void n(float f10, c cVar) {
        cVar.r(f10 > 0.75f ? c((f10 - 0.75f) / 0.25f, cVar.h(), cVar.e()) : cVar.h());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f3708f.n(i10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f3708f.s(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Animator animator;
        long j10;
        this.f3711i.cancel();
        this.f3708f.A();
        if (this.f3708f.d() != this.f3708f.g()) {
            this.f3713k = true;
            animator = this.f3711i;
            j10 = 666;
        } else {
            this.f3708f.t(0);
            this.f3708f.m();
            animator = this.f3711i;
            j10 = 1332;
        }
        animator.setDuration(j10);
        this.f3711i.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f3711i.cancel();
        h(0.0f);
        this.f3708f.x(false);
        this.f3708f.t(0);
        this.f3708f.m();
        invalidateSelf();
    }
}
