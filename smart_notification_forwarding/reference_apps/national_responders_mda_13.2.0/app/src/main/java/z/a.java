package z;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.a0;
import java.util.Arrays;

/* loaded from: classes.dex */
public class a {

    /* renamed from: w, reason: collision with root package name */
    private static final Interpolator f16033w = new InterpolatorC0340a();

    /* renamed from: a, reason: collision with root package name */
    private int f16034a;

    /* renamed from: b, reason: collision with root package name */
    private int f16035b;

    /* renamed from: d, reason: collision with root package name */
    private float[] f16037d;

    /* renamed from: e, reason: collision with root package name */
    private float[] f16038e;

    /* renamed from: f, reason: collision with root package name */
    private float[] f16039f;

    /* renamed from: g, reason: collision with root package name */
    private float[] f16040g;

    /* renamed from: h, reason: collision with root package name */
    private int[] f16041h;

    /* renamed from: i, reason: collision with root package name */
    private int[] f16042i;

    /* renamed from: j, reason: collision with root package name */
    private int[] f16043j;

    /* renamed from: k, reason: collision with root package name */
    private int f16044k;

    /* renamed from: l, reason: collision with root package name */
    private VelocityTracker f16045l;

    /* renamed from: m, reason: collision with root package name */
    private float f16046m;

    /* renamed from: n, reason: collision with root package name */
    private float f16047n;

    /* renamed from: o, reason: collision with root package name */
    private int f16048o;

    /* renamed from: p, reason: collision with root package name */
    private int f16049p;

    /* renamed from: q, reason: collision with root package name */
    private OverScroller f16050q;

    /* renamed from: r, reason: collision with root package name */
    private final c f16051r;

    /* renamed from: s, reason: collision with root package name */
    private View f16052s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f16053t;

    /* renamed from: u, reason: collision with root package name */
    private final ViewGroup f16054u;

    /* renamed from: c, reason: collision with root package name */
    private int f16036c = -1;

    /* renamed from: v, reason: collision with root package name */
    private final Runnable f16055v = new b();

    /* renamed from: z.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class InterpolatorC0340a implements Interpolator {
        InterpolatorC0340a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.J(0);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {
        public abstract int a(View view, int i10, int i11);

        public abstract int b(View view, int i10, int i11);

        public int c(int i10) {
            return i10;
        }

        public int d(View view) {
            return 0;
        }

        public int e(View view) {
            return 0;
        }

        public void f(int i10, int i11) {
        }

        public boolean g(int i10) {
            return false;
        }

        public void h(int i10, int i11) {
        }

        public void i(View view, int i10) {
        }

        public abstract void j(int i10);

        public abstract void k(View view, int i10, int i11, int i12, int i13);

        public abstract void l(View view, float f10, float f11);

        public abstract boolean m(View view, int i10);
    }

    private a(Context context, ViewGroup viewGroup, c cVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (cVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f16054u = viewGroup;
        this.f16051r = cVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f16048o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f16035b = viewConfiguration.getScaledTouchSlop();
        this.f16046m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f16047n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f16050q = new OverScroller(context, f16033w);
    }

    private boolean C(int i10) {
        if (B(i10)) {
            return true;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Ignoring pointerId=");
        sb2.append(i10);
        sb2.append(" because ACTION_DOWN was not received ");
        sb2.append("for this pointer before ACTION_MOVE. It likely happened because ");
        sb2.append(" ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void F() {
        this.f16045l.computeCurrentVelocity(1000, this.f16046m);
        p(g(this.f16045l.getXVelocity(this.f16036c), this.f16047n, this.f16046m), g(this.f16045l.getYVelocity(this.f16036c), this.f16047n, this.f16046m));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r3v3, types: [z.a$c] */
    private void G(float f10, float f11, int i10) {
        boolean c10 = c(f10, f11, i10, 1);
        boolean z10 = c10;
        if (c(f11, f10, i10, 4)) {
            z10 = (c10 ? 1 : 0) | 4;
        }
        boolean z11 = z10;
        if (c(f10, f11, i10, 2)) {
            z11 = (z10 ? 1 : 0) | 2;
        }
        ?? r02 = z11;
        if (c(f11, f10, i10, 8)) {
            r02 = (z11 ? 1 : 0) | 8;
        }
        if (r02 != 0) {
            int[] iArr = this.f16042i;
            iArr[i10] = iArr[i10] | r02;
            this.f16051r.f(r02, i10);
        }
    }

    private void H(float f10, float f11, int i10) {
        s(i10);
        float[] fArr = this.f16037d;
        this.f16039f[i10] = f10;
        fArr[i10] = f10;
        float[] fArr2 = this.f16038e;
        this.f16040g[i10] = f11;
        fArr2[i10] = f11;
        this.f16041h[i10] = x((int) f10, (int) f11);
        this.f16044k |= 1 << i10;
    }

    private void I(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i10 = 0; i10 < pointerCount; i10++) {
            int pointerId = motionEvent.getPointerId(i10);
            if (C(pointerId)) {
                float x10 = motionEvent.getX(i10);
                float y10 = motionEvent.getY(i10);
                this.f16039f[pointerId] = x10;
                this.f16040g[pointerId] = y10;
            }
        }
    }

    private boolean c(float f10, float f11, int i10, int i11) {
        float abs = Math.abs(f10);
        float abs2 = Math.abs(f11);
        if ((this.f16041h[i10] & i11) != i11 || (this.f16049p & i11) == 0 || (this.f16043j[i10] & i11) == i11 || (this.f16042i[i10] & i11) == i11) {
            return false;
        }
        int i12 = this.f16035b;
        if (abs <= i12 && abs2 <= i12) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.f16051r.g(i11)) {
            return (this.f16042i[i10] & i11) == 0 && abs > ((float) this.f16035b);
        }
        int[] iArr = this.f16043j;
        iArr[i10] = iArr[i10] | i11;
        return false;
    }

    private boolean f(View view, float f10, float f11) {
        if (view == null) {
            return false;
        }
        boolean z10 = this.f16051r.d(view) > 0;
        boolean z11 = this.f16051r.e(view) > 0;
        if (!z10 || !z11) {
            return z10 ? Math.abs(f10) > ((float) this.f16035b) : z11 && Math.abs(f11) > ((float) this.f16035b);
        }
        float f12 = (f10 * f10) + (f11 * f11);
        int i10 = this.f16035b;
        return f12 > ((float) (i10 * i10));
    }

    private float g(float f10, float f11, float f12) {
        float abs = Math.abs(f10);
        if (abs < f11) {
            return 0.0f;
        }
        return abs > f12 ? f10 > 0.0f ? f12 : -f12 : f10;
    }

    private int h(int i10, int i11, int i12) {
        int abs = Math.abs(i10);
        if (abs < i11) {
            return 0;
        }
        return abs > i12 ? i10 > 0 ? i12 : -i12 : i10;
    }

    private void i() {
        float[] fArr = this.f16037d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f16038e, 0.0f);
        Arrays.fill(this.f16039f, 0.0f);
        Arrays.fill(this.f16040g, 0.0f);
        Arrays.fill(this.f16041h, 0);
        Arrays.fill(this.f16042i, 0);
        Arrays.fill(this.f16043j, 0);
        this.f16044k = 0;
    }

    private void j(int i10) {
        if (this.f16037d == null || !B(i10)) {
            return;
        }
        this.f16037d[i10] = 0.0f;
        this.f16038e[i10] = 0.0f;
        this.f16039f[i10] = 0.0f;
        this.f16040g[i10] = 0.0f;
        this.f16041h[i10] = 0;
        this.f16042i[i10] = 0;
        this.f16043j[i10] = 0;
        this.f16044k = (~(1 << i10)) & this.f16044k;
    }

    private int k(int i10, int i11, int i12) {
        if (i10 == 0) {
            return 0;
        }
        int width = this.f16054u.getWidth();
        float f10 = width / 2;
        float q10 = f10 + (q(Math.min(1.0f, Math.abs(i10) / width)) * f10);
        int abs = Math.abs(i11);
        return Math.min(abs > 0 ? Math.round(Math.abs(q10 / abs) * 1000.0f) * 4 : (int) (((Math.abs(i10) / i12) + 1.0f) * 256.0f), 600);
    }

    private int l(View view, int i10, int i11, int i12, int i13) {
        float f10;
        float f11;
        float f12;
        float f13;
        int h10 = h(i12, (int) this.f16047n, (int) this.f16046m);
        int h11 = h(i13, (int) this.f16047n, (int) this.f16046m);
        int abs = Math.abs(i10);
        int abs2 = Math.abs(i11);
        int abs3 = Math.abs(h10);
        int abs4 = Math.abs(h11);
        int i14 = abs3 + abs4;
        int i15 = abs + abs2;
        if (h10 != 0) {
            f10 = abs3;
            f11 = i14;
        } else {
            f10 = abs;
            f11 = i15;
        }
        float f14 = f10 / f11;
        if (h11 != 0) {
            f12 = abs4;
            f13 = i14;
        } else {
            f12 = abs2;
            f13 = i15;
        }
        return (int) ((k(i10, h10, this.f16051r.d(view)) * f14) + (k(i11, h11, this.f16051r.e(view)) * (f12 / f13)));
    }

    public static a n(ViewGroup viewGroup, float f10, c cVar) {
        a o10 = o(viewGroup, cVar);
        o10.f16035b = (int) (o10.f16035b * (1.0f / f10));
        return o10;
    }

    public static a o(ViewGroup viewGroup, c cVar) {
        return new a(viewGroup.getContext(), viewGroup, cVar);
    }

    private void p(float f10, float f11) {
        this.f16053t = true;
        this.f16051r.l(this.f16052s, f10, f11);
        this.f16053t = false;
        if (this.f16034a == 1) {
            J(0);
        }
    }

    private float q(float f10) {
        return (float) Math.sin((f10 - 0.5f) * 0.47123894f);
    }

    private void r(int i10, int i11, int i12, int i13) {
        int left = this.f16052s.getLeft();
        int top = this.f16052s.getTop();
        if (i12 != 0) {
            i10 = this.f16051r.a(this.f16052s, i10, i12);
            a0.Y(this.f16052s, i10 - left);
        }
        int i14 = i10;
        if (i13 != 0) {
            i11 = this.f16051r.b(this.f16052s, i11, i13);
            a0.Z(this.f16052s, i11 - top);
        }
        int i15 = i11;
        if (i12 == 0 && i13 == 0) {
            return;
        }
        this.f16051r.k(this.f16052s, i14, i15, i14 - left, i15 - top);
    }

    private void s(int i10) {
        float[] fArr = this.f16037d;
        if (fArr == null || fArr.length <= i10) {
            int i11 = i10 + 1;
            float[] fArr2 = new float[i11];
            float[] fArr3 = new float[i11];
            float[] fArr4 = new float[i11];
            float[] fArr5 = new float[i11];
            int[] iArr = new int[i11];
            int[] iArr2 = new int[i11];
            int[] iArr3 = new int[i11];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f16038e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f16039f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f16040g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f16041h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f16042i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f16043j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f16037d = fArr2;
            this.f16038e = fArr3;
            this.f16039f = fArr4;
            this.f16040g = fArr5;
            this.f16041h = iArr;
            this.f16042i = iArr2;
            this.f16043j = iArr3;
        }
    }

    private boolean u(int i10, int i11, int i12, int i13) {
        int left = this.f16052s.getLeft();
        int top = this.f16052s.getTop();
        int i14 = i10 - left;
        int i15 = i11 - top;
        if (i14 == 0 && i15 == 0) {
            this.f16050q.abortAnimation();
            J(0);
            return false;
        }
        this.f16050q.startScroll(left, top, i14, i15, l(this.f16052s, i14, i15, i12, i13));
        J(2);
        return true;
    }

    private int x(int i10, int i11) {
        int i12 = i10 < this.f16054u.getLeft() + this.f16048o ? 1 : 0;
        if (i11 < this.f16054u.getTop() + this.f16048o) {
            i12 |= 4;
        }
        if (i10 > this.f16054u.getRight() - this.f16048o) {
            i12 |= 2;
        }
        return i11 > this.f16054u.getBottom() - this.f16048o ? i12 | 8 : i12;
    }

    public boolean A(int i10, int i11) {
        return D(this.f16052s, i10, i11);
    }

    public boolean B(int i10) {
        return ((1 << i10) & this.f16044k) != 0;
    }

    public boolean D(View view, int i10, int i11) {
        return view != null && i10 >= view.getLeft() && i10 < view.getRight() && i11 >= view.getTop() && i11 < view.getBottom();
    }

    public void E(MotionEvent motionEvent) {
        int i10;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f16045l == null) {
            this.f16045l = VelocityTracker.obtain();
        }
        this.f16045l.addMovement(motionEvent);
        int i11 = 0;
        if (actionMasked == 0) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View t10 = t((int) x10, (int) y10);
            H(x10, y10, pointerId);
            P(t10, pointerId);
            int i12 = this.f16041h[pointerId];
            int i13 = this.f16049p;
            if ((i12 & i13) != 0) {
                this.f16051r.h(i12 & i13, pointerId);
                return;
            }
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (this.f16034a != 1) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (i11 < pointerCount) {
                        int pointerId2 = motionEvent.getPointerId(i11);
                        if (C(pointerId2)) {
                            float x11 = motionEvent.getX(i11);
                            float y11 = motionEvent.getY(i11);
                            float f10 = x11 - this.f16037d[pointerId2];
                            float f11 = y11 - this.f16038e[pointerId2];
                            G(f10, f11, pointerId2);
                            if (this.f16034a != 1) {
                                View t11 = t((int) x11, (int) y11);
                                if (f(t11, f10, f11) && P(t11, pointerId2)) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        i11++;
                    }
                } else {
                    if (!C(this.f16036c)) {
                        return;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(this.f16036c);
                    float x12 = motionEvent.getX(findPointerIndex);
                    float y12 = motionEvent.getY(findPointerIndex);
                    float[] fArr = this.f16039f;
                    int i14 = this.f16036c;
                    int i15 = (int) (x12 - fArr[i14]);
                    int i16 = (int) (y12 - this.f16040g[i14]);
                    r(this.f16052s.getLeft() + i15, this.f16052s.getTop() + i16, i15, i16);
                }
                I(motionEvent);
                return;
            }
            if (actionMasked != 3) {
                if (actionMasked == 5) {
                    int pointerId3 = motionEvent.getPointerId(actionIndex);
                    float x13 = motionEvent.getX(actionIndex);
                    float y13 = motionEvent.getY(actionIndex);
                    H(x13, y13, pointerId3);
                    if (this.f16034a != 0) {
                        if (A((int) x13, (int) y13)) {
                            P(this.f16052s, pointerId3);
                            return;
                        }
                        return;
                    } else {
                        P(t((int) x13, (int) y13), pointerId3);
                        int i17 = this.f16041h[pointerId3];
                        int i18 = this.f16049p;
                        if ((i17 & i18) != 0) {
                            this.f16051r.h(i17 & i18, pointerId3);
                            return;
                        }
                        return;
                    }
                }
                if (actionMasked != 6) {
                    return;
                }
                int pointerId4 = motionEvent.getPointerId(actionIndex);
                if (this.f16034a == 1 && pointerId4 == this.f16036c) {
                    int pointerCount2 = motionEvent.getPointerCount();
                    while (true) {
                        if (i11 >= pointerCount2) {
                            i10 = -1;
                            break;
                        }
                        int pointerId5 = motionEvent.getPointerId(i11);
                        if (pointerId5 != this.f16036c) {
                            View t12 = t((int) motionEvent.getX(i11), (int) motionEvent.getY(i11));
                            View view = this.f16052s;
                            if (t12 == view && P(view, pointerId5)) {
                                i10 = this.f16036c;
                                break;
                            }
                        }
                        i11++;
                    }
                    if (i10 == -1) {
                        F();
                    }
                }
                j(pointerId4);
                return;
            }
            if (this.f16034a == 1) {
                p(0.0f, 0.0f);
            }
        } else if (this.f16034a == 1) {
            F();
        }
        a();
    }

    void J(int i10) {
        this.f16054u.removeCallbacks(this.f16055v);
        if (this.f16034a != i10) {
            this.f16034a = i10;
            this.f16051r.j(i10);
            if (this.f16034a == 0) {
                this.f16052s = null;
            }
        }
    }

    public void K(int i10) {
        this.f16049p = i10;
    }

    public void L(float f10) {
        this.f16047n = f10;
    }

    public boolean M(int i10, int i11) {
        if (this.f16053t) {
            return u(i10, i11, (int) this.f16045l.getXVelocity(this.f16036c), (int) this.f16045l.getYVelocity(this.f16036c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00dd, code lost:
    
        if (r12 != r11) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean N(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z.a.N(android.view.MotionEvent):boolean");
    }

    public boolean O(View view, int i10, int i11) {
        this.f16052s = view;
        this.f16036c = -1;
        boolean u10 = u(i10, i11, 0, 0);
        if (!u10 && this.f16034a == 0 && this.f16052s != null) {
            this.f16052s = null;
        }
        return u10;
    }

    boolean P(View view, int i10) {
        if (view == this.f16052s && this.f16036c == i10) {
            return true;
        }
        if (view == null || !this.f16051r.m(view, i10)) {
            return false;
        }
        this.f16036c = i10;
        b(view, i10);
        return true;
    }

    public void a() {
        this.f16036c = -1;
        i();
        VelocityTracker velocityTracker = this.f16045l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f16045l = null;
        }
    }

    public void b(View view, int i10) {
        if (view.getParent() == this.f16054u) {
            this.f16052s = view;
            this.f16036c = i10;
            this.f16051r.i(view, i10);
            J(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f16054u + ")");
    }

    public boolean d(int i10) {
        int length = this.f16037d.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (e(i10, i11)) {
                return true;
            }
        }
        return false;
    }

    public boolean e(int i10, int i11) {
        if (!B(i11)) {
            return false;
        }
        boolean z10 = (i10 & 1) == 1;
        boolean z11 = (i10 & 2) == 2;
        float f10 = this.f16039f[i11] - this.f16037d[i11];
        float f11 = this.f16040g[i11] - this.f16038e[i11];
        if (!z10 || !z11) {
            return z10 ? Math.abs(f10) > ((float) this.f16035b) : z11 && Math.abs(f11) > ((float) this.f16035b);
        }
        float f12 = (f10 * f10) + (f11 * f11);
        int i12 = this.f16035b;
        return f12 > ((float) (i12 * i12));
    }

    public boolean m(boolean z10) {
        if (this.f16034a == 2) {
            boolean computeScrollOffset = this.f16050q.computeScrollOffset();
            int currX = this.f16050q.getCurrX();
            int currY = this.f16050q.getCurrY();
            int left = currX - this.f16052s.getLeft();
            int top = currY - this.f16052s.getTop();
            if (left != 0) {
                a0.Y(this.f16052s, left);
            }
            if (top != 0) {
                a0.Z(this.f16052s, top);
            }
            if (left != 0 || top != 0) {
                this.f16051r.k(this.f16052s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f16050q.getFinalX() && currY == this.f16050q.getFinalY()) {
                this.f16050q.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z10) {
                    this.f16054u.post(this.f16055v);
                } else {
                    J(0);
                }
            }
        }
        return this.f16034a == 2;
    }

    public View t(int i10, int i11) {
        for (int childCount = this.f16054u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f16054u.getChildAt(this.f16051r.c(childCount));
            if (i10 >= childAt.getLeft() && i10 < childAt.getRight() && i11 >= childAt.getTop() && i11 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public View v() {
        return this.f16052s;
    }

    public int w() {
        return this.f16048o;
    }

    public int y() {
        return this.f16035b;
    }

    public int z() {
        return this.f16034a;
    }
}
