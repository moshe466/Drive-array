package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.view.a0;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends RecyclerView.n implements RecyclerView.s {
    private static final int[] D = {R.attr.state_pressed};
    private static final int[] E = new int[0];
    int A;
    private final Runnable B;
    private final RecyclerView.t C;

    /* renamed from: a, reason: collision with root package name */
    private final int f3573a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3574b;

    /* renamed from: c, reason: collision with root package name */
    final StateListDrawable f3575c;

    /* renamed from: d, reason: collision with root package name */
    final Drawable f3576d;

    /* renamed from: e, reason: collision with root package name */
    private final int f3577e;

    /* renamed from: f, reason: collision with root package name */
    private final int f3578f;

    /* renamed from: g, reason: collision with root package name */
    private final StateListDrawable f3579g;

    /* renamed from: h, reason: collision with root package name */
    private final Drawable f3580h;

    /* renamed from: i, reason: collision with root package name */
    private final int f3581i;

    /* renamed from: j, reason: collision with root package name */
    private final int f3582j;

    /* renamed from: k, reason: collision with root package name */
    int f3583k;

    /* renamed from: l, reason: collision with root package name */
    int f3584l;

    /* renamed from: m, reason: collision with root package name */
    float f3585m;

    /* renamed from: n, reason: collision with root package name */
    int f3586n;

    /* renamed from: o, reason: collision with root package name */
    int f3587o;

    /* renamed from: p, reason: collision with root package name */
    float f3588p;

    /* renamed from: s, reason: collision with root package name */
    private RecyclerView f3591s;

    /* renamed from: z, reason: collision with root package name */
    final ValueAnimator f3598z;

    /* renamed from: q, reason: collision with root package name */
    private int f3589q = 0;

    /* renamed from: r, reason: collision with root package name */
    private int f3590r = 0;

    /* renamed from: t, reason: collision with root package name */
    private boolean f3592t = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f3593u = false;

    /* renamed from: v, reason: collision with root package name */
    private int f3594v = 0;

    /* renamed from: w, reason: collision with root package name */
    private int f3595w = 0;

    /* renamed from: x, reason: collision with root package name */
    private final int[] f3596x = new int[2];

    /* renamed from: y, reason: collision with root package name */
    private final int[] f3597y = new int[2];

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.q(500);
        }
    }

    /* loaded from: classes.dex */
    class b extends RecyclerView.t {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i10, int i11) {
            d.this.B(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    /* loaded from: classes.dex */
    private class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private boolean f3601a = false;

        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3601a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f3601a) {
                this.f3601a = false;
                return;
            }
            if (((Float) d.this.f3598z.getAnimatedValue()).floatValue() == 0.0f) {
                d dVar = d.this;
                dVar.A = 0;
                dVar.y(0);
            } else {
                d dVar2 = d.this;
                dVar2.A = 2;
                dVar2.v();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0059d implements ValueAnimator.AnimatorUpdateListener {
        C0059d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            d.this.f3575c.setAlpha(floatValue);
            d.this.f3576d.setAlpha(floatValue);
            d.this.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i10, int i11, int i12) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f3598z = ofFloat;
        this.A = 0;
        this.B = new a();
        this.C = new b();
        this.f3575c = stateListDrawable;
        this.f3576d = drawable;
        this.f3579g = stateListDrawable2;
        this.f3580h = drawable2;
        this.f3577e = Math.max(i10, stateListDrawable.getIntrinsicWidth());
        this.f3578f = Math.max(i10, drawable.getIntrinsicWidth());
        this.f3581i = Math.max(i10, stateListDrawable2.getIntrinsicWidth());
        this.f3582j = Math.max(i10, drawable2.getIntrinsicWidth());
        this.f3573a = i11;
        this.f3574b = i12;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new c());
        ofFloat.addUpdateListener(new C0059d());
        j(recyclerView);
    }

    private void C(float f10) {
        int[] p10 = p();
        float max = Math.max(p10[0], Math.min(p10[1], f10));
        if (Math.abs(this.f3584l - max) < 2.0f) {
            return;
        }
        int x10 = x(this.f3585m, max, p10, this.f3591s.computeVerticalScrollRange(), this.f3591s.computeVerticalScrollOffset(), this.f3590r);
        if (x10 != 0) {
            this.f3591s.scrollBy(0, x10);
        }
        this.f3585m = max;
    }

    private void k() {
        this.f3591s.removeCallbacks(this.B);
    }

    private void l() {
        this.f3591s.Y0(this);
        this.f3591s.Z0(this);
        this.f3591s.a1(this.C);
        k();
    }

    private void m(Canvas canvas) {
        int i10 = this.f3590r;
        int i11 = this.f3581i;
        int i12 = this.f3587o;
        int i13 = this.f3586n;
        this.f3579g.setBounds(0, 0, i13, i11);
        this.f3580h.setBounds(0, 0, this.f3589q, this.f3582j);
        canvas.translate(0.0f, i10 - i11);
        this.f3580h.draw(canvas);
        canvas.translate(i12 - (i13 / 2), 0.0f);
        this.f3579g.draw(canvas);
        canvas.translate(-r2, -r0);
    }

    private void n(Canvas canvas) {
        int i10 = this.f3589q;
        int i11 = this.f3577e;
        int i12 = i10 - i11;
        int i13 = this.f3584l;
        int i14 = this.f3583k;
        int i15 = i13 - (i14 / 2);
        this.f3575c.setBounds(0, 0, i11, i14);
        this.f3576d.setBounds(0, 0, this.f3578f, this.f3590r);
        if (s()) {
            this.f3576d.draw(canvas);
            canvas.translate(this.f3577e, i15);
            canvas.scale(-1.0f, 1.0f);
            this.f3575c.draw(canvas);
            canvas.scale(1.0f, 1.0f);
            i12 = this.f3577e;
        } else {
            canvas.translate(i12, 0.0f);
            this.f3576d.draw(canvas);
            canvas.translate(0.0f, i15);
            this.f3575c.draw(canvas);
        }
        canvas.translate(-i12, -i15);
    }

    private int[] o() {
        int[] iArr = this.f3597y;
        int i10 = this.f3574b;
        iArr[0] = i10;
        iArr[1] = this.f3589q - i10;
        return iArr;
    }

    private int[] p() {
        int[] iArr = this.f3596x;
        int i10 = this.f3574b;
        iArr[0] = i10;
        iArr[1] = this.f3590r - i10;
        return iArr;
    }

    private void r(float f10) {
        int[] o10 = o();
        float max = Math.max(o10[0], Math.min(o10[1], f10));
        if (Math.abs(this.f3587o - max) < 2.0f) {
            return;
        }
        int x10 = x(this.f3588p, max, o10, this.f3591s.computeHorizontalScrollRange(), this.f3591s.computeHorizontalScrollOffset(), this.f3589q);
        if (x10 != 0) {
            this.f3591s.scrollBy(x10, 0);
        }
        this.f3588p = max;
    }

    private boolean s() {
        return a0.z(this.f3591s) == 1;
    }

    private void w(int i10) {
        k();
        this.f3591s.postDelayed(this.B, i10);
    }

    private int x(float f10, float f11, int[] iArr, int i10, int i11, int i12) {
        int i13 = iArr[1] - iArr[0];
        if (i13 == 0) {
            return 0;
        }
        int i14 = i10 - i12;
        int i15 = (int) (((f11 - f10) / i13) * i14);
        int i16 = i11 + i15;
        if (i16 >= i14 || i16 < 0) {
            return 0;
        }
        return i15;
    }

    private void z() {
        this.f3591s.i(this);
        this.f3591s.k(this);
        this.f3591s.l(this.C);
    }

    public void A() {
        int i10 = this.A;
        if (i10 != 0) {
            if (i10 != 3) {
                return;
            } else {
                this.f3598z.cancel();
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.f3598z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f3598z.setDuration(500L);
        this.f3598z.setStartDelay(0L);
        this.f3598z.start();
    }

    void B(int i10, int i11) {
        int computeVerticalScrollRange = this.f3591s.computeVerticalScrollRange();
        int i12 = this.f3590r;
        this.f3592t = computeVerticalScrollRange - i12 > 0 && i12 >= this.f3573a;
        int computeHorizontalScrollRange = this.f3591s.computeHorizontalScrollRange();
        int i13 = this.f3589q;
        boolean z10 = computeHorizontalScrollRange - i13 > 0 && i13 >= this.f3573a;
        this.f3593u = z10;
        boolean z11 = this.f3592t;
        if (!z11 && !z10) {
            if (this.f3594v != 0) {
                y(0);
                return;
            }
            return;
        }
        if (z11) {
            float f10 = i12;
            this.f3584l = (int) ((f10 * (i11 + (f10 / 2.0f))) / computeVerticalScrollRange);
            this.f3583k = Math.min(i12, (i12 * i12) / computeVerticalScrollRange);
        }
        if (this.f3593u) {
            float f11 = i13;
            this.f3587o = (int) ((f11 * (i10 + (f11 / 2.0f))) / computeHorizontalScrollRange);
            this.f3586n = Math.min(i13, (i13 * i13) / computeHorizontalScrollRange);
        }
        int i14 = this.f3594v;
        if (i14 == 0 || i14 == 1) {
            y(1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i10 = this.f3594v;
        if (i10 == 1) {
            boolean u10 = u(motionEvent.getX(), motionEvent.getY());
            boolean t10 = t(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!u10 && !t10) {
                return false;
            }
            if (t10) {
                this.f3595w = 1;
                this.f3588p = (int) motionEvent.getX();
            } else if (u10) {
                this.f3595w = 2;
                this.f3585m = (int) motionEvent.getY();
            }
            y(2);
        } else if (i10 != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void b(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f3594v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean u10 = u(motionEvent.getX(), motionEvent.getY());
            boolean t10 = t(motionEvent.getX(), motionEvent.getY());
            if (u10 || t10) {
                if (t10) {
                    this.f3595w = 1;
                    this.f3588p = (int) motionEvent.getX();
                } else if (u10) {
                    this.f3595w = 2;
                    this.f3585m = (int) motionEvent.getY();
                }
                y(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.f3594v == 2) {
            this.f3585m = 0.0f;
            this.f3588p = 0.0f;
            y(1);
            this.f3595w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.f3594v == 2) {
            A();
            if (this.f3595w == 1) {
                r(motionEvent.getX());
            }
            if (this.f3595w == 2) {
                C(motionEvent.getY());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void c(boolean z10) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        if (this.f3589q != this.f3591s.getWidth() || this.f3590r != this.f3591s.getHeight()) {
            this.f3589q = this.f3591s.getWidth();
            this.f3590r = this.f3591s.getHeight();
            y(0);
        } else if (this.A != 0) {
            if (this.f3592t) {
                n(canvas);
            }
            if (this.f3593u) {
                m(canvas);
            }
        }
    }

    public void j(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f3591s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            l();
        }
        this.f3591s = recyclerView;
        if (recyclerView != null) {
            z();
        }
    }

    void q(int i10) {
        int i11 = this.A;
        if (i11 == 1) {
            this.f3598z.cancel();
        } else if (i11 != 2) {
            return;
        }
        this.A = 3;
        ValueAnimator valueAnimator = this.f3598z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f3598z.setDuration(i10);
        this.f3598z.start();
    }

    boolean t(float f10, float f11) {
        if (f11 >= this.f3590r - this.f3581i) {
            int i10 = this.f3587o;
            int i11 = this.f3586n;
            if (f10 >= i10 - (i11 / 2) && f10 <= i10 + (i11 / 2)) {
                return true;
            }
        }
        return false;
    }

    boolean u(float f10, float f11) {
        if (!s() ? f10 >= this.f3589q - this.f3577e : f10 <= this.f3577e / 2) {
            int i10 = this.f3584l;
            int i11 = this.f3583k;
            if (f11 >= i10 - (i11 / 2) && f11 <= i10 + (i11 / 2)) {
                return true;
            }
        }
        return false;
    }

    void v() {
        this.f3591s.invalidate();
    }

    void y(int i10) {
        int i11;
        if (i10 == 2 && this.f3594v != 2) {
            this.f3575c.setState(D);
            k();
        }
        if (i10 == 0) {
            v();
        } else {
            A();
        }
        if (this.f3594v != 2 || i10 == 2) {
            i11 = i10 == 1 ? 1500 : 1200;
            this.f3594v = i10;
        }
        this.f3575c.setState(E);
        w(i11);
        this.f3594v = i10;
    }
}
