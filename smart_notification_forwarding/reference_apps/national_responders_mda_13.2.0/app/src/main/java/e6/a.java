package e6;

import a0.b;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.KeyCharacterMap;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import androidx.core.view.a0;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class a extends FrameLayout implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: g0, reason: collision with root package name */
    private static final int f9151g0 = (int) (ViewConfiguration.getLongPressTimeout() * 1.5f);

    /* renamed from: h0, reason: collision with root package name */
    private static final int f9152h0;
    private int A;
    private int B;
    private boolean C;
    private boolean D;
    private final int E;
    private final int F;
    private int G;
    private final int H;
    private final int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private ValueAnimator N;
    private final TimeInterpolator O;
    private final Rect P;
    private final Rect Q;
    private boolean R;
    private float S;
    private final g T;
    private final h U;
    private int V;
    private View.OnTouchListener W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f9153a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f9154b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f9155c0;

    /* renamed from: d0, reason: collision with root package name */
    private final boolean f9156d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f9157e0;

    /* renamed from: f, reason: collision with root package name */
    boolean f9158f;

    /* renamed from: f0, reason: collision with root package name */
    private final Rect f9159f0;

    /* renamed from: g, reason: collision with root package name */
    private Rect f9160g;

    /* renamed from: h, reason: collision with root package name */
    boolean f9161h;

    /* renamed from: i, reason: collision with root package name */
    private final WindowManager f9162i;

    /* renamed from: j, reason: collision with root package name */
    private final WindowManager.LayoutParams f9163j;

    /* renamed from: k, reason: collision with root package name */
    private VelocityTracker f9164k;

    /* renamed from: l, reason: collision with root package name */
    private ViewConfiguration f9165l;

    /* renamed from: m, reason: collision with root package name */
    private float f9166m;

    /* renamed from: n, reason: collision with root package name */
    private float f9167n;

    /* renamed from: o, reason: collision with root package name */
    private float f9168o;

    /* renamed from: p, reason: collision with root package name */
    private float f9169p;

    /* renamed from: q, reason: collision with root package name */
    private float f9170q;

    /* renamed from: r, reason: collision with root package name */
    private final DisplayMetrics f9171r;

    /* renamed from: s, reason: collision with root package name */
    private long f9172s;

    /* renamed from: t, reason: collision with root package name */
    private float f9173t;

    /* renamed from: u, reason: collision with root package name */
    private float f9174u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f9175v;

    /* renamed from: w, reason: collision with root package name */
    private float f9176w;

    /* renamed from: x, reason: collision with root package name */
    private float f9177x;

    /* renamed from: y, reason: collision with root package name */
    private float f9178y;

    /* renamed from: z, reason: collision with root package name */
    private float f9179z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e6.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0150a implements ValueAnimator.AnimatorUpdateListener {
        C0150a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.f9163j.y = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            a.this.X();
            a.this.S(valueAnimator);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.f9163j.x = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            a.this.X();
            a.this.S(valueAnimator);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements b.r {
        c() {
        }

        @Override // a0.b.r
        public void a(a0.b bVar, float f10, float f11) {
            int round = Math.round(f10);
            if (a.this.f9163j.x == round || a.this.f9164k != null) {
                return;
            }
            a.this.f9163j.x = round;
            a.this.X();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements b.r {
        d() {
        }

        @Override // a0.b.r
        public void a(a0.b bVar, float f10, float f11) {
            int round = Math.round(f10);
            if (a.this.f9163j.y == round || a.this.f9164k != null) {
                return;
            }
            a.this.f9163j.y = round;
            a.this.X();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements b.r {
        e() {
        }

        @Override // a0.b.r
        public void a(a0.b bVar, float f10, float f11) {
            int round = Math.round(f10);
            if (a.this.f9163j.x == round || a.this.f9164k != null) {
                return;
            }
            a.this.f9163j.x = round;
            a.this.X();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements b.r {
        f() {
        }

        @Override // a0.b.r
        public void a(a0.b bVar, float f10, float f11) {
            int round = Math.round(f10);
            if (a.this.f9163j.y == round || a.this.f9164k != null) {
                return;
            }
            a.this.f9163j.y = round;
            a.this.X();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class g extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private long f9186a;

        /* renamed from: b, reason: collision with root package name */
        private float f9187b;

        /* renamed from: c, reason: collision with root package name */
        private float f9188c;

        /* renamed from: d, reason: collision with root package name */
        private int f9189d = 0;

        /* renamed from: e, reason: collision with root package name */
        private boolean f9190e;

        /* renamed from: f, reason: collision with root package name */
        private float f9191f;

        /* renamed from: g, reason: collision with root package name */
        private float f9192g;

        /* renamed from: h, reason: collision with root package name */
        private float f9193h;

        /* renamed from: i, reason: collision with root package name */
        private float f9194i;

        /* renamed from: j, reason: collision with root package name */
        private final WeakReference<a> f9195j;

        g(a aVar) {
            this.f9195j = new WeakReference<>(aVar);
        }

        private static float a(float f10) {
            double pow;
            double d10;
            double d11 = f10;
            if (d11 <= 0.4d) {
                d10 = 0.55d;
                pow = Math.sin((d11 * 8.0564d) - 1.5707963267948966d) * 0.55d;
            } else {
                pow = (Math.pow((d11 * 0.417d) - 0.341d, 2.0d) * 4.0d) - (Math.pow(0.07599999999999996d, 2.0d) * 4.0d);
                d10 = 1.0d;
            }
            return (float) (pow + d10);
        }

        private static Message c(int i10, int i11) {
            Message obtain = Message.obtain();
            obtain.what = i10;
            obtain.arg1 = i11;
            return obtain;
        }

        int b() {
            return this.f9189d;
        }

        void d(int i10) {
            sendMessage(c(i10, 1));
        }

        void e(int i10) {
            if (this.f9189d != i10) {
                this.f9190e = true;
            }
            this.f9189d = i10;
        }

        void f(float f10, float f11) {
            this.f9193h = f10;
            this.f9194i = f11;
        }

        void g(float f10, float f11) {
            this.f9191f = f10;
            this.f9192g = f11;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10;
            a aVar = this.f9195j.get();
            if (aVar == null) {
                removeMessages(1);
                return;
            }
            int i11 = message.what;
            int i12 = message.arg1;
            WindowManager.LayoutParams layoutParams = aVar.f9163j;
            boolean z10 = this.f9190e;
            if (z10 || i12 == 1) {
                this.f9186a = z10 ? SystemClock.uptimeMillis() : 0L;
                this.f9187b = layoutParams.x;
                this.f9188c = layoutParams.y;
                this.f9190e = false;
            }
            float min = Math.min(((float) (SystemClock.uptimeMillis() - this.f9186a)) / 300.0f, 1.0f);
            int i13 = this.f9189d;
            if (i13 == 0) {
                float a10 = a(min);
                Rect rect = aVar.P;
                float min2 = Math.min(Math.max(rect.left, (int) this.f9191f), rect.right);
                float min3 = Math.min(Math.max(rect.top, (int) this.f9192g), rect.bottom);
                float f10 = this.f9187b;
                layoutParams.x = (int) (f10 + ((min2 - f10) * a10));
                float f11 = this.f9188c;
                i10 = (int) (f11 + ((min3 - f11) * a10));
            } else {
                if (i13 != 1) {
                    return;
                }
                float a11 = a(min);
                float width = this.f9193h - (aVar.getWidth() / 2);
                float height = this.f9194i - (aVar.getHeight() / 2);
                float f12 = this.f9187b;
                layoutParams.x = (int) (f12 + ((width - f12) * a11));
                float f13 = this.f9188c;
                i10 = (int) (f13 + ((height - f13) * a11));
            }
            layoutParams.y = i10;
            aVar.X();
            sendMessageAtTime(c(i11, 2), SystemClock.uptimeMillis() + 10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class h extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<a> f9196a;

        h(a aVar) {
            this.f9196a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = this.f9196a.get();
            if (aVar == null) {
                removeMessages(0);
            } else {
                aVar.v();
            }
        }
    }

    static {
        f9152h0 = Build.VERSION.SDK_INT <= 25 ? 2007 : 2038;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        super(context);
        this.f9158f = false;
        this.f9161h = true;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this.f9162i = windowManager;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f9163j = layoutParams;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f9171r = displayMetrics;
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.type = f9152h0;
        layoutParams.flags = 40;
        layoutParams.format = -3;
        layoutParams.gravity = 83;
        this.T = new g(this);
        this.U = new h(this);
        this.O = new OvershootInterpolator(1.25f);
        this.f9154b0 = 0;
        this.f9155c0 = false;
        Resources resources = context.getResources();
        boolean z10 = (resources.getConfiguration().screenLayout & 15) >= 3;
        this.f9156d0 = z10;
        this.f9157e0 = windowManager.getDefaultDisplay().getRotation();
        this.P = new Rect();
        this.Q = new Rect();
        this.f9159f0 = new Rect();
        int m10 = m(resources, "status_bar_height");
        this.E = m10;
        this.F = resources.getIdentifier("status_bar_height_landscape", "dimen", "android") > 0 ? m(resources, "status_bar_height_landscape") : m10;
        W();
        if (r()) {
            this.H = m(resources, "navigation_bar_height");
            this.I = m(resources, z10 ? "navigation_bar_height_landscape" : "navigation_bar_width");
        } else {
            this.H = 0;
            this.I = 0;
        }
        getViewTreeObserver().addOnPreDrawListener(this);
    }

    private void K(float f10) {
        if (Build.VERSION.SDK_INT > 19) {
            setScaleX(f10);
            setScaleY(f10);
            return;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            childAt.setScaleX(f10);
            childAt.setScaleY(f10);
        }
    }

    private void M(float f10) {
        a0.c cVar = new a0.c(new a0.e());
        cVar.v(f10);
        cVar.t(this.Q.right);
        cVar.u(this.Q.left);
        cVar.l(this.f9163j.x);
        cVar.s(1.7f);
        cVar.j(1.0f);
        cVar.b(new e());
        cVar.o();
    }

    private void N(float f10) {
        a0.c cVar = new a0.c(new a0.e());
        cVar.v(f10);
        cVar.t(this.Q.bottom);
        cVar.u(this.Q.top);
        cVar.l(this.f9163j.y);
        cVar.s(1.7f);
        cVar.j(1.0f);
        cVar.b(new f());
        cVar.o();
    }

    private void O(int i10, int i11, int i12, int i13) {
        ValueAnimator ofInt;
        ValueAnimator.AnimatorUpdateListener bVar;
        if (i12 == i10) {
            ofInt = ValueAnimator.ofInt(i11, i13);
            this.N = ofInt;
            bVar = new C0150a();
        } else {
            this.f9163j.y = i13;
            ofInt = ValueAnimator.ofInt(i10, i12);
            this.N = ofInt;
            bVar = new b();
        }
        ofInt.addUpdateListener(bVar);
        this.N.setDuration(450L);
        this.N.setInterpolator(this.O);
        this.N.start();
    }

    private void P(int i10, int i11) {
        int i12 = this.f9163j.x;
        Rect rect = this.Q;
        boolean z10 = i12 < rect.right && i12 > rect.left;
        if (this.f9154b0 == 3 && z10) {
            M(Math.min(Math.max(this.f9164k.getXVelocity(), -this.f9168o), this.f9168o));
        } else {
            Q(i10);
        }
        int i13 = this.f9163j.y;
        Rect rect2 = this.Q;
        boolean z11 = i13 < rect2.bottom && i13 > rect2.top;
        float f10 = -Math.min(Math.max(this.f9164k.getYVelocity(), -this.f9169p), this.f9169p);
        if (z11) {
            N(f10);
        } else {
            R(i11, f10);
        }
    }

    private void Q(int i10) {
        a0.g gVar = new a0.g(i10);
        gVar.d(0.7f);
        gVar.f(350.0f);
        a0.f fVar = new a0.f(new a0.e());
        fVar.m(this.f9164k.getXVelocity());
        fVar.l(this.f9163j.x);
        fVar.t(gVar);
        fVar.j(1.0f);
        fVar.b(new c());
        fVar.o();
    }

    private void R(int i10, float f10) {
        a0.g gVar = new a0.g(i10 < this.f9171r.heightPixels / 2 ? this.Q.top : this.Q.bottom);
        gVar.d(0.75f);
        gVar.f(200.0f);
        a0.f fVar = new a0.f(new a0.e());
        fVar.m(f10);
        fVar.l(this.f9163j.y);
        fVar.t(gVar);
        fVar.j(1.0f);
        fVar.b(new d());
        fVar.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(ValueAnimator valueAnimator) {
        if (!this.D || valueAnimator.getDuration() > valueAnimator.getCurrentPlayTime()) {
            return;
        }
        this.C = false;
    }

    private void T(boolean z10, boolean z11, Rect rect) {
        int i10;
        int i11;
        int i12;
        boolean r10 = r();
        if (Build.VERSION.SDK_INT >= 17) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.f9162i.getDefaultDisplay().getRealMetrics(displayMetrics);
            i12 = displayMetrics.heightPixels - rect.bottom;
            i10 = displayMetrics.widthPixels - this.f9171r.widthPixels;
            i11 = this.H - i12;
        } else {
            i10 = 0;
            i11 = 0;
            i12 = 0;
        }
        if (!z10) {
            if (((i11 == 0 || this.H != 0) && (r10 || this.H == 0)) || r10) {
                this.J = 0;
            } else {
                this.J = -i12;
            }
            this.K = 0;
            return;
        }
        if (z11) {
            if (r10 || this.H == 0) {
                this.J = this.H;
            } else {
                this.J = 0;
            }
            this.K = 0;
            return;
        }
        if (this.f9156d0) {
            this.J = this.I;
        } else {
            this.J = 0;
            if (r10 || this.I == 0) {
                if (r10 && this.I == 0) {
                    this.K = i10;
                    return;
                } else {
                    this.K = this.I;
                    return;
                }
            }
        }
        this.K = 0;
    }

    private void U(boolean z10, boolean z11) {
        if (z10) {
            this.G = 0;
            return;
        }
        if (!(this.f9159f0.top != 0)) {
            this.G = z11 ? this.E : this.F;
        } else if (z11) {
            this.G = 0;
        } else {
            this.G = this.F;
        }
    }

    private void V(boolean z10, int i10) {
        int i11 = 0;
        if (this.f9159f0.bottom != 0) {
            this.L = i10;
            return;
        }
        if (!z10 && i10 > 0) {
            i11 = this.I;
        }
        this.L = i11;
    }

    private void W() {
        this.f9165l = ViewConfiguration.get(getContext());
        this.f9166m = r0.getScaledTouchSlop();
        float scaledMaximumFlingVelocity = this.f9165l.getScaledMaximumFlingVelocity();
        this.f9167n = scaledMaximumFlingVelocity;
        this.f9168o = scaledMaximumFlingVelocity / 9.0f;
        this.f9169p = scaledMaximumFlingVelocity / 8.0f;
        this.f9170q = scaledMaximumFlingVelocity / 9.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        if (a0.R(this)) {
            this.f9162i.updateViewLayout(this, this.f9163j);
        }
    }

    private void g(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX() - motionEvent.getX();
        float rawY = motionEvent.getRawY() - motionEvent.getY();
        motionEvent.offsetLocation(rawX, rawY);
        this.f9164k.addMovement(motionEvent);
        motionEvent.offsetLocation(-rawX, -rawY);
    }

    private void h() {
        ValueAnimator valueAnimator = this.N;
        if (valueAnimator == null || !valueAnimator.isStarted()) {
            return;
        }
        this.N.cancel();
        this.N = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004d, code lost:
    
        if ((r6 > (r5.f9171r.widthPixels - getWidth()) / 2) != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007f, code lost:
    
        if ((r6 > (r5.f9171r.widthPixels - getWidth()) / 2) != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0014, code lost:
    
        if ((r6 > (r5.f9171r.widthPixels - getWidth()) / 2) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int i(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.f9154b0
            r1 = 0
            r2 = 2
            r3 = 1
            if (r0 != 0) goto L17
            android.util.DisplayMetrics r7 = r5.f9171r
            int r7 = r7.widthPixels
            int r0 = r5.getWidth()
            int r7 = r7 - r0
            int r7 = r7 / r2
            if (r6 <= r7) goto L14
            r1 = 1
        L14:
            if (r1 == 0) goto L19
            goto L20
        L17:
            if (r0 != r3) goto L1e
        L19:
            android.graphics.Rect r6 = r5.Q
            int r6 = r6.left
            goto L82
        L1e:
            if (r0 != r2) goto L25
        L20:
            android.graphics.Rect r6 = r5.Q
            int r6 = r6.right
            goto L82
        L25:
            r4 = 4
            if (r0 != r4) goto L50
            android.graphics.Rect r0 = r5.Q
            int r0 = r0.width()
            int r0 = r0 - r6
            int r0 = java.lang.Math.min(r6, r0)
            android.graphics.Rect r4 = r5.Q
            int r4 = r4.height()
            int r4 = r4 - r7
            int r7 = java.lang.Math.min(r7, r4)
            if (r0 >= r7) goto L82
            android.util.DisplayMetrics r7 = r5.f9171r
            int r7 = r7.widthPixels
            int r0 = r5.getWidth()
            int r7 = r7 - r0
            int r7 = r7 / r2
            if (r6 <= r7) goto L4d
            r1 = 1
        L4d:
            if (r1 == 0) goto L19
            goto L20
        L50:
            r7 = 5
            if (r0 != r7) goto L82
            android.view.VelocityTracker r7 = r5.f9164k
            if (r7 == 0) goto L62
            float r7 = r7.getXVelocity()
            float r0 = r5.f9170q
            int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r7 <= 0) goto L62
            goto L20
        L62:
            android.view.VelocityTracker r7 = r5.f9164k
            if (r7 == 0) goto L72
            float r7 = r7.getXVelocity()
            float r0 = r5.f9170q
            float r0 = -r0
            int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r7 >= 0) goto L72
            goto L19
        L72:
            android.util.DisplayMetrics r7 = r5.f9171r
            int r7 = r7.widthPixels
            int r0 = r5.getWidth()
            int r7 = r7 - r0
            int r7 = r7 / r2
            if (r6 <= r7) goto L7f
            r1 = 1
        L7f:
            if (r1 == 0) goto L19
            goto L20
        L82:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.a.i(int, int):int");
    }

    private int j(int i10, int i11) {
        if (this.f9154b0 != 4 || Math.min(i10, this.Q.width() - i10) < Math.min(i11, this.Q.height() - i11)) {
            return i11;
        }
        return i11 < (this.f9171r.heightPixels - getHeight()) / 2 ? this.Q.top : this.Q.bottom;
    }

    private static int m(Resources resources, String str) {
        int identifier = resources.getIdentifier(str, "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private int p() {
        return (int) ((this.f9176w - this.f9178y) - this.L);
    }

    private int q() {
        return (int) ((this.f9171r.heightPixels + this.J) - (((this.f9177x - this.f9179z) + getHeight()) - this.M));
    }

    private boolean r() {
        if (Build.VERSION.SDK_INT >= 17) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.f9162i.getDefaultDisplay().getRealMetrics(displayMetrics);
            int i10 = displayMetrics.heightPixels;
            DisplayMetrics displayMetrics2 = this.f9171r;
            return i10 > displayMetrics2.heightPixels || displayMetrics.widthPixels > displayMetrics2.widthPixels;
        }
        Context context = getContext();
        Resources resources = context.getResources();
        boolean hasPermanentMenuKey = ViewConfiguration.get(context).hasPermanentMenuKey();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier != 0 && resources.getBoolean(identifier)) {
            return true;
        }
        return (hasPermanentMenuKey || deviceHasKey) ? false : true;
    }

    private void s(int i10, int i11, int i12, int i13, boolean z10) {
        int min = Math.min(Math.max(this.Q.left, i12), this.Q.right);
        int min2 = Math.min(Math.max(this.Q.top, i13), this.Q.bottom);
        if (z10) {
            if ((!this.f9155c0 || this.f9164k == null || this.f9154b0 == 4) ? false : true) {
                P(min, i11);
            } else {
                O(i10, i11, min, min2);
            }
        } else {
            WindowManager.LayoutParams layoutParams = this.f9163j;
            if (layoutParams.x != min || layoutParams.y != min2) {
                layoutParams.x = min;
                layoutParams.y = min2;
                X();
            }
        }
        this.f9178y = 0.0f;
        this.f9179z = 0.0f;
        this.f9173t = 0.0f;
        this.f9174u = 0.0f;
        this.f9175v = false;
    }

    private void t(int i10, int i11, boolean z10) {
        s(i10, i11, i(i10, i11), j(i10, i11), z10);
    }

    private void u(boolean z10) {
        t(p(), q(), z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        this.f9153a0 = true;
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            getChildAt(i10).performLongClick();
        }
    }

    private void x() {
        int i10;
        int i11;
        h();
        int width = this.Q.width();
        int height = this.Q.height();
        this.f9162i.getDefaultDisplay().getMetrics(this.f9171r);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        DisplayMetrics displayMetrics = this.f9171r;
        int i12 = displayMetrics.widthPixels;
        int i13 = displayMetrics.heightPixels;
        this.P.set(-measuredWidth, (-measuredHeight) * 2, i12 + measuredWidth + this.K, i13 + measuredHeight + this.J);
        Rect rect = this.Q;
        int i14 = this.V;
        boolean z10 = false;
        rect.set(-i14, 0, (i12 - measuredWidth) + i14 + this.K, ((i13 - this.G) - measuredHeight) + this.J);
        int rotation = this.f9162i.getDefaultDisplay().getRotation();
        if (this.D && this.f9157e0 != rotation) {
            this.C = false;
        }
        if (this.C && this.f9157e0 == rotation) {
            WindowManager.LayoutParams layoutParams = this.f9163j;
            i10 = layoutParams.x;
            i11 = layoutParams.y;
            z10 = true;
        } else {
            if (!this.f9175v) {
                int min = Math.min(Math.max(this.Q.left, (int) (((this.f9163j.x * this.Q.width()) / width) + 0.5f)), this.Q.right);
                int min2 = Math.min(Math.max(this.Q.top, (int) (((this.f9163j.y * this.Q.height()) / height) + 0.5f)), this.Q.bottom);
                WindowManager.LayoutParams layoutParams2 = this.f9163j;
                s(layoutParams2.x, layoutParams2.y, min, min2, false);
                this.f9157e0 = rotation;
            }
            WindowManager.LayoutParams layoutParams3 = this.f9163j;
            i10 = layoutParams3.x;
            i11 = layoutParams3.y;
        }
        t(i10, i11, z10);
        this.f9157e0 = rotation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A() {
        this.T.e(2);
        this.f9175v = false;
        setVisibility(8);
    }

    public void B(int i10) {
        this.f9163j.gravity = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(int i10, int i11) {
        this.A = i10;
        this.B = i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(int i10, int i11) {
        this.T.e(1);
        this.T.f(i10, i11);
    }

    public void E(boolean z10) {
        this.f9161h = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(int i10) {
        this.f9154b0 = i10;
    }

    public void G(Rect rect) {
        this.f9160g = rect;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H() {
        this.T.e(0);
        this.T.g(p(), q());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(int i10) {
        this.V = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(Rect rect) {
        this.f9159f0.set(rect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(float f10) {
        this.S = f10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(boolean z10) {
        this.f9155c0 = z10 && Build.VERSION.SDK_INT >= 16;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() != 0) {
            return true;
        }
        if (!this.f9161h) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.f9160g != null) {
            if (!this.f9158f && (motionEvent.getY() > this.f9160g.bottom || motionEvent.getX() > this.f9160g.right)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (motionEvent.getY() <= this.f9160g.bottom && motionEvent.getX() <= this.f9160g.right) {
                this.f9158f = true;
            }
        }
        if (!this.R || this.C) {
            return true;
        }
        this.f9176w = motionEvent.getRawX();
        this.f9177x = motionEvent.getRawY();
        int action = motionEvent.getAction();
        boolean z10 = false;
        if (action == 0) {
            if (this.f9160g != null && !this.f9158f && (motionEvent.getY() > this.f9160g.bottom || motionEvent.getX() > this.f9160g.right)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            h();
            this.f9173t = this.f9176w;
            this.f9174u = this.f9177x;
            this.f9178y = motionEvent.getX();
            this.f9179z = motionEvent.getY();
            this.f9175v = false;
            K(0.9f);
            VelocityTracker velocityTracker = this.f9164k;
            if (velocityTracker == null) {
                this.f9164k = VelocityTracker.obtain();
            } else {
                velocityTracker.clear();
            }
            this.T.g(p(), q());
            this.T.removeMessages(1);
            this.T.d(1);
            this.U.removeMessages(0);
            this.U.sendEmptyMessageDelayed(0, f9151g0);
            this.f9172s = motionEvent.getDownTime();
            g(motionEvent);
            this.C = false;
        } else if (action == 2) {
            if (this.f9175v) {
                this.f9153a0 = false;
                this.U.removeMessages(0);
            }
            if (this.f9175v) {
                this.f9153a0 = false;
                this.U.removeMessages(0);
            }
            if (this.f9172s != motionEvent.getDownTime()) {
                return true;
            }
            if (!this.f9175v && Math.abs(this.f9176w - this.f9173t) < this.f9166m && Math.abs(this.f9177x - this.f9174u) < this.f9166m) {
                return true;
            }
            this.f9175v = true;
            this.T.g(p(), q());
            g(motionEvent);
        } else if (action == 1 || action == 3) {
            VelocityTracker velocityTracker2 = this.f9164k;
            if (velocityTracker2 != null) {
                velocityTracker2.computeCurrentVelocity(1000);
            }
            boolean z11 = this.f9153a0;
            this.f9158f = false;
            this.f9153a0 = false;
            this.U.removeMessages(0);
            if (this.f9172s != motionEvent.getDownTime()) {
                return true;
            }
            this.T.removeMessages(1);
            K(1.0f);
            if (!this.f9175v) {
                this.f9164k.recycle();
                this.f9164k = null;
            }
            if (action != 1 || z11 || this.f9175v) {
                z10 = true;
            } else {
                int childCount = getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    getChildAt(i10).performClick();
                }
            }
        }
        View.OnTouchListener onTouchListener = this.W;
        if (onTouchListener != null) {
            onTouchListener.onTouch(this, motionEvent);
        }
        if (z10 && this.T.b() != 2) {
            u(true);
            VelocityTracker velocityTracker3 = this.f9164k;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f9164k = null;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float k() {
        return this.S;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l() {
        return this.T.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(Rect rect) {
        int p10 = p();
        int q10 = q();
        rect.set(p10, q10, getWidth() + p10, getHeight() + q10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WindowManager.LayoutParams o() {
        return this.f9163j;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        W();
        x();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ValueAnimator valueAnimator = this.N;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.A == Integer.MIN_VALUE) {
            this.A = 0;
        }
        if (this.B == Integer.MIN_VALUE) {
            this.B = (this.f9171r.heightPixels - this.G) - getMeasuredHeight();
        }
        WindowManager.LayoutParams layoutParams = this.f9163j;
        int i10 = this.A;
        layoutParams.x = i10;
        int i11 = this.B;
        layoutParams.y = i11;
        if (this.f9154b0 == 3) {
            s(i10, i11, i10, i11, false);
        } else {
            this.C = true;
            t(i10, i11, this.D);
        }
        this.R = true;
        X();
        return true;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        x();
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.W = onTouchListener;
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        if (i10 != 0) {
            cancelLongPress();
            K(1.0f);
            if (this.f9175v) {
                u(false);
            }
            this.T.removeMessages(1);
            this.U.removeMessages(0);
        }
        super.setVisibility(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(boolean z10, boolean z11, boolean z12, Rect rect) {
        U(z10, z12);
        V(z11, rect.left);
        this.M = z12 ? this.f9159f0.top : 0;
        T(z11, z12, rect);
        x();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(boolean z10) {
        this.D = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(boolean z10) {
        this.R = z10;
    }
}
