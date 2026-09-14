package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.a0;

/* loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {

    /* renamed from: w, reason: collision with root package name */
    private static final int f2653w = ViewConfiguration.getTapTimeout();

    /* renamed from: h, reason: collision with root package name */
    final View f2656h;

    /* renamed from: i, reason: collision with root package name */
    private Runnable f2657i;

    /* renamed from: l, reason: collision with root package name */
    private int f2660l;

    /* renamed from: m, reason: collision with root package name */
    private int f2661m;

    /* renamed from: q, reason: collision with root package name */
    private boolean f2665q;

    /* renamed from: r, reason: collision with root package name */
    boolean f2666r;

    /* renamed from: s, reason: collision with root package name */
    boolean f2667s;

    /* renamed from: t, reason: collision with root package name */
    boolean f2668t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f2669u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f2670v;

    /* renamed from: f, reason: collision with root package name */
    final C0043a f2654f = new C0043a();

    /* renamed from: g, reason: collision with root package name */
    private final Interpolator f2655g = new AccelerateInterpolator();

    /* renamed from: j, reason: collision with root package name */
    private float[] f2658j = {0.0f, 0.0f};

    /* renamed from: k, reason: collision with root package name */
    private float[] f2659k = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: n, reason: collision with root package name */
    private float[] f2662n = {0.0f, 0.0f};

    /* renamed from: o, reason: collision with root package name */
    private float[] f2663o = {0.0f, 0.0f};

    /* renamed from: p, reason: collision with root package name */
    private float[] f2664p = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.core.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0043a {

        /* renamed from: a, reason: collision with root package name */
        private int f2671a;

        /* renamed from: b, reason: collision with root package name */
        private int f2672b;

        /* renamed from: c, reason: collision with root package name */
        private float f2673c;

        /* renamed from: d, reason: collision with root package name */
        private float f2674d;

        /* renamed from: j, reason: collision with root package name */
        private float f2680j;

        /* renamed from: k, reason: collision with root package name */
        private int f2681k;

        /* renamed from: e, reason: collision with root package name */
        private long f2675e = Long.MIN_VALUE;

        /* renamed from: i, reason: collision with root package name */
        private long f2679i = -1;

        /* renamed from: f, reason: collision with root package name */
        private long f2676f = 0;

        /* renamed from: g, reason: collision with root package name */
        private int f2677g = 0;

        /* renamed from: h, reason: collision with root package name */
        private int f2678h = 0;

        C0043a() {
        }

        private float e(long j10) {
            long j11 = this.f2675e;
            if (j10 < j11) {
                return 0.0f;
            }
            long j12 = this.f2679i;
            if (j12 < 0 || j10 < j12) {
                return a.e(((float) (j10 - j11)) / this.f2671a, 0.0f, 1.0f) * 0.5f;
            }
            float f10 = this.f2680j;
            return (1.0f - f10) + (f10 * a.e(((float) (j10 - j12)) / this.f2681k, 0.0f, 1.0f));
        }

        private float g(float f10) {
            return ((-4.0f) * f10 * f10) + (f10 * 4.0f);
        }

        public void a() {
            if (this.f2676f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float g10 = g(e(currentAnimationTimeMillis));
            long j10 = currentAnimationTimeMillis - this.f2676f;
            this.f2676f = currentAnimationTimeMillis;
            float f10 = ((float) j10) * g10;
            this.f2677g = (int) (this.f2673c * f10);
            this.f2678h = (int) (f10 * this.f2674d);
        }

        public int b() {
            return this.f2677g;
        }

        public int c() {
            return this.f2678h;
        }

        public int d() {
            float f10 = this.f2673c;
            return (int) (f10 / Math.abs(f10));
        }

        public int f() {
            float f10 = this.f2674d;
            return (int) (f10 / Math.abs(f10));
        }

        public boolean h() {
            return this.f2679i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f2679i + ((long) this.f2681k);
        }

        public void i() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f2681k = a.f((int) (currentAnimationTimeMillis - this.f2675e), 0, this.f2672b);
            this.f2680j = e(currentAnimationTimeMillis);
            this.f2679i = currentAnimationTimeMillis;
        }

        public void j(int i10) {
            this.f2672b = i10;
        }

        public void k(int i10) {
            this.f2671a = i10;
        }

        public void l(float f10, float f11) {
            this.f2673c = f10;
            this.f2674d = f11;
        }

        public void m() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f2675e = currentAnimationTimeMillis;
            this.f2679i = -1L;
            this.f2676f = currentAnimationTimeMillis;
            this.f2680j = 0.5f;
            this.f2677g = 0;
            this.f2678h = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.f2668t) {
                if (aVar.f2666r) {
                    aVar.f2666r = false;
                    aVar.f2654f.m();
                }
                C0043a c0043a = a.this.f2654f;
                if (c0043a.h() || !a.this.u()) {
                    a.this.f2668t = false;
                    return;
                }
                a aVar2 = a.this;
                if (aVar2.f2667s) {
                    aVar2.f2667s = false;
                    aVar2.c();
                }
                c0043a.a();
                a.this.j(c0043a.b(), c0043a.c());
                a0.e0(a.this.f2656h, this);
            }
        }
    }

    public a(View view) {
        this.f2656h = view;
        float f10 = Resources.getSystem().getDisplayMetrics().density;
        float f11 = (int) ((1575.0f * f10) + 0.5f);
        o(f11, f11);
        float f12 = (int) ((f10 * 315.0f) + 0.5f);
        p(f12, f12);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f2653w);
        r(500);
        q(500);
    }

    private float d(int i10, float f10, float f11, float f12) {
        float h10 = h(this.f2658j[i10], f11, this.f2659k[i10], f10);
        if (h10 == 0.0f) {
            return 0.0f;
        }
        float f13 = this.f2662n[i10];
        float f14 = this.f2663o[i10];
        float f15 = this.f2664p[i10];
        float f16 = f13 * f12;
        return h10 > 0.0f ? e(h10 * f16, f14, f15) : -e((-h10) * f16, f14, f15);
    }

    static float e(float f10, float f11, float f12) {
        return f10 > f12 ? f12 : f10 < f11 ? f11 : f10;
    }

    static int f(int i10, int i11, int i12) {
        return i10 > i12 ? i12 : i10 < i11 ? i11 : i10;
    }

    private float g(float f10, float f11) {
        if (f11 == 0.0f) {
            return 0.0f;
        }
        int i10 = this.f2660l;
        if (i10 == 0 || i10 == 1) {
            if (f10 < f11) {
                if (f10 >= 0.0f) {
                    return 1.0f - (f10 / f11);
                }
                if (this.f2668t && i10 == 1) {
                    return 1.0f;
                }
            }
        } else if (i10 == 2 && f10 < 0.0f) {
            return f10 / (-f11);
        }
        return 0.0f;
    }

    private float h(float f10, float f11, float f12, float f13) {
        float interpolation;
        float e10 = e(f10 * f11, 0.0f, f12);
        float g10 = g(f11 - f13, e10) - g(f13, e10);
        if (g10 < 0.0f) {
            interpolation = -this.f2655g.getInterpolation(-g10);
        } else {
            if (g10 <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f2655g.getInterpolation(g10);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    private void i() {
        if (this.f2666r) {
            this.f2668t = false;
        } else {
            this.f2654f.i();
        }
    }

    private void v() {
        int i10;
        if (this.f2657i == null) {
            this.f2657i = new b();
        }
        this.f2668t = true;
        this.f2666r = true;
        if (this.f2665q || (i10 = this.f2661m) <= 0) {
            this.f2657i.run();
        } else {
            a0.f0(this.f2656h, this.f2657i, i10);
        }
        this.f2665q = true;
    }

    public abstract boolean a(int i10);

    public abstract boolean b(int i10);

    void c() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f2656h.onTouchEvent(obtain);
        obtain.recycle();
    }

    public abstract void j(int i10, int i11);

    public a k(int i10) {
        this.f2661m = i10;
        return this;
    }

    public a l(int i10) {
        this.f2660l = i10;
        return this;
    }

    public a m(boolean z10) {
        if (this.f2669u && !z10) {
            i();
        }
        this.f2669u = z10;
        return this;
    }

    public a n(float f10, float f11) {
        float[] fArr = this.f2659k;
        fArr[0] = f10;
        fArr[1] = f11;
        return this;
    }

    public a o(float f10, float f11) {
        float[] fArr = this.f2664p;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
    
        if (r0 != 3) goto L20;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f2669u
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.i()
            goto L58
        L1a:
            r5.f2667s = r2
            r5.f2665q = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f2656h
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.d(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f2656h
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.d(r2, r7, r6, r3)
            androidx.core.widget.a$a r7 = r5.f2654f
            r7.l(r0, r6)
            boolean r6 = r5.f2668t
            if (r6 != 0) goto L58
            boolean r6 = r5.u()
            if (r6 == 0) goto L58
            r5.v()
        L58:
            boolean r6 = r5.f2670v
            if (r6 == 0) goto L61
            boolean r6 = r5.f2668t
            if (r6 == 0) goto L61
            r1 = 1
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public a p(float f10, float f11) {
        float[] fArr = this.f2663o;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    public a q(int i10) {
        this.f2654f.j(i10);
        return this;
    }

    public a r(int i10) {
        this.f2654f.k(i10);
        return this;
    }

    public a s(float f10, float f11) {
        float[] fArr = this.f2658j;
        fArr[0] = f10;
        fArr[1] = f11;
        return this;
    }

    public a t(float f10, float f11) {
        float[] fArr = this.f2662n;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    boolean u() {
        C0043a c0043a = this.f2654f;
        int f10 = c0043a.f();
        int d10 = c0043a.d();
        return (f10 != 0 && b(f10)) || (d10 != 0 && a(d10));
    }
}
