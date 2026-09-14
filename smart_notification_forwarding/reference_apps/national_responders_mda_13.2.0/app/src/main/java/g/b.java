package g;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Drawable implements Drawable.Callback {

    /* renamed from: f, reason: collision with root package name */
    private d f9704f;

    /* renamed from: g, reason: collision with root package name */
    private Rect f9705g;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f9706h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f9707i;

    /* renamed from: k, reason: collision with root package name */
    private boolean f9709k;

    /* renamed from: m, reason: collision with root package name */
    private boolean f9711m;

    /* renamed from: n, reason: collision with root package name */
    private Runnable f9712n;

    /* renamed from: o, reason: collision with root package name */
    private long f9713o;

    /* renamed from: p, reason: collision with root package name */
    private long f9714p;

    /* renamed from: q, reason: collision with root package name */
    private c f9715q;

    /* renamed from: j, reason: collision with root package name */
    private int f9708j = 255;

    /* renamed from: l, reason: collision with root package name */
    private int f9710l = -1;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(true);
            b.this.invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0173b {
        public static boolean a(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static void b(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }

        public static Resources c(Resources.Theme theme) {
            return theme.getResources();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c implements Drawable.Callback {

        /* renamed from: f, reason: collision with root package name */
        private Drawable.Callback f9717f;

        c() {
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f9717f;
            this.f9717f = null;
            return callback;
        }

        public c b(Drawable.Callback callback) {
            this.f9717f = callback;
            return this;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
            Drawable.Callback callback = this.f9717f;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j10);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f9717f;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class d extends Drawable.ConstantState {
        int A;
        int B;
        boolean C;
        ColorFilter D;
        boolean E;
        ColorStateList F;
        PorterDuff.Mode G;
        boolean H;
        boolean I;

        /* renamed from: a, reason: collision with root package name */
        final b f9718a;

        /* renamed from: b, reason: collision with root package name */
        Resources f9719b;

        /* renamed from: c, reason: collision with root package name */
        int f9720c;

        /* renamed from: d, reason: collision with root package name */
        int f9721d;

        /* renamed from: e, reason: collision with root package name */
        int f9722e;

        /* renamed from: f, reason: collision with root package name */
        SparseArray<Drawable.ConstantState> f9723f;

        /* renamed from: g, reason: collision with root package name */
        Drawable[] f9724g;

        /* renamed from: h, reason: collision with root package name */
        int f9725h;

        /* renamed from: i, reason: collision with root package name */
        boolean f9726i;

        /* renamed from: j, reason: collision with root package name */
        boolean f9727j;

        /* renamed from: k, reason: collision with root package name */
        Rect f9728k;

        /* renamed from: l, reason: collision with root package name */
        boolean f9729l;

        /* renamed from: m, reason: collision with root package name */
        boolean f9730m;

        /* renamed from: n, reason: collision with root package name */
        int f9731n;

        /* renamed from: o, reason: collision with root package name */
        int f9732o;

        /* renamed from: p, reason: collision with root package name */
        int f9733p;

        /* renamed from: q, reason: collision with root package name */
        int f9734q;

        /* renamed from: r, reason: collision with root package name */
        boolean f9735r;

        /* renamed from: s, reason: collision with root package name */
        int f9736s;

        /* renamed from: t, reason: collision with root package name */
        boolean f9737t;

        /* renamed from: u, reason: collision with root package name */
        boolean f9738u;

        /* renamed from: v, reason: collision with root package name */
        boolean f9739v;

        /* renamed from: w, reason: collision with root package name */
        boolean f9740w;

        /* renamed from: x, reason: collision with root package name */
        boolean f9741x;

        /* renamed from: y, reason: collision with root package name */
        boolean f9742y;

        /* renamed from: z, reason: collision with root package name */
        int f9743z;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(d dVar, b bVar, Resources resources) {
            this.f9726i = false;
            this.f9729l = false;
            this.f9741x = true;
            this.A = 0;
            this.B = 0;
            this.f9718a = bVar;
            this.f9719b = resources != null ? resources : dVar != null ? dVar.f9719b : null;
            int f10 = b.f(resources, dVar != null ? dVar.f9720c : 0);
            this.f9720c = f10;
            if (dVar == null) {
                this.f9724g = new Drawable[10];
                this.f9725h = 0;
                return;
            }
            this.f9721d = dVar.f9721d;
            this.f9722e = dVar.f9722e;
            this.f9739v = true;
            this.f9740w = true;
            this.f9726i = dVar.f9726i;
            this.f9729l = dVar.f9729l;
            this.f9741x = dVar.f9741x;
            this.f9742y = dVar.f9742y;
            this.f9743z = dVar.f9743z;
            this.A = dVar.A;
            this.B = dVar.B;
            this.C = dVar.C;
            this.D = dVar.D;
            this.E = dVar.E;
            this.F = dVar.F;
            this.G = dVar.G;
            this.H = dVar.H;
            this.I = dVar.I;
            if (dVar.f9720c == f10) {
                if (dVar.f9727j) {
                    this.f9728k = dVar.f9728k != null ? new Rect(dVar.f9728k) : null;
                    this.f9727j = true;
                }
                if (dVar.f9730m) {
                    this.f9731n = dVar.f9731n;
                    this.f9732o = dVar.f9732o;
                    this.f9733p = dVar.f9733p;
                    this.f9734q = dVar.f9734q;
                    this.f9730m = true;
                }
            }
            if (dVar.f9735r) {
                this.f9736s = dVar.f9736s;
                this.f9735r = true;
            }
            if (dVar.f9737t) {
                this.f9738u = dVar.f9738u;
                this.f9737t = true;
            }
            Drawable[] drawableArr = dVar.f9724g;
            this.f9724g = new Drawable[drawableArr.length];
            this.f9725h = dVar.f9725h;
            SparseArray<Drawable.ConstantState> sparseArray = dVar.f9723f;
            this.f9723f = sparseArray != null ? sparseArray.clone() : new SparseArray<>(this.f9725h);
            int i10 = this.f9725h;
            for (int i11 = 0; i11 < i10; i11++) {
                if (drawableArr[i11] != null) {
                    Drawable.ConstantState constantState = drawableArr[i11].getConstantState();
                    if (constantState != null) {
                        this.f9723f.put(i11, constantState);
                    } else {
                        this.f9724g[i11] = drawableArr[i11];
                    }
                }
            }
        }

        private void e() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f9723f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i10 = 0; i10 < size; i10++) {
                    this.f9724g[this.f9723f.keyAt(i10)] = s(this.f9723f.valueAt(i10).newDrawable(this.f9719b));
                }
                this.f9723f = null;
            }
        }

        private Drawable s(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                androidx.core.graphics.drawable.a.m(drawable, this.f9743z);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f9718a);
            return mutate;
        }

        public final int a(Drawable drawable) {
            int i10 = this.f9725h;
            if (i10 >= this.f9724g.length) {
                o(i10, i10 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f9718a);
            this.f9724g[i10] = drawable;
            this.f9725h++;
            this.f9722e = drawable.getChangingConfigurations() | this.f9722e;
            p();
            this.f9728k = null;
            this.f9727j = false;
            this.f9730m = false;
            this.f9739v = false;
            return i10;
        }

        final void b(Resources.Theme theme) {
            if (theme != null) {
                e();
                int i10 = this.f9725h;
                Drawable[] drawableArr = this.f9724g;
                for (int i11 = 0; i11 < i10; i11++) {
                    if (drawableArr[i11] != null && androidx.core.graphics.drawable.a.b(drawableArr[i11])) {
                        androidx.core.graphics.drawable.a.a(drawableArr[i11], theme);
                        this.f9722e |= drawableArr[i11].getChangingConfigurations();
                    }
                }
                y(C0173b.c(theme));
            }
        }

        public boolean c() {
            if (this.f9739v) {
                return this.f9740w;
            }
            e();
            this.f9739v = true;
            int i10 = this.f9725h;
            Drawable[] drawableArr = this.f9724g;
            for (int i11 = 0; i11 < i10; i11++) {
                if (drawableArr[i11].getConstantState() == null) {
                    this.f9740w = false;
                    return false;
                }
            }
            this.f9740w = true;
            return true;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i10 = this.f9725h;
            Drawable[] drawableArr = this.f9724g;
            for (int i11 = 0; i11 < i10; i11++) {
                Drawable drawable = drawableArr[i11];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.f9723f.get(i11);
                    if (constantState != null && C0173b.a(constantState)) {
                        return true;
                    }
                } else if (androidx.core.graphics.drawable.a.b(drawable)) {
                    return true;
                }
            }
            return false;
        }

        protected void d() {
            this.f9730m = true;
            e();
            int i10 = this.f9725h;
            Drawable[] drawableArr = this.f9724g;
            this.f9732o = -1;
            this.f9731n = -1;
            this.f9734q = 0;
            this.f9733p = 0;
            for (int i11 = 0; i11 < i10; i11++) {
                Drawable drawable = drawableArr[i11];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f9731n) {
                    this.f9731n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f9732o) {
                    this.f9732o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f9733p) {
                    this.f9733p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f9734q) {
                    this.f9734q = minimumHeight;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final int f() {
            return this.f9724g.length;
        }

        public final Drawable g(int i10) {
            int indexOfKey;
            Drawable drawable = this.f9724g[i10];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f9723f;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i10)) < 0) {
                return null;
            }
            Drawable s10 = s(this.f9723f.valueAt(indexOfKey).newDrawable(this.f9719b));
            this.f9724g[i10] = s10;
            this.f9723f.removeAt(indexOfKey);
            if (this.f9723f.size() == 0) {
                this.f9723f = null;
            }
            return s10;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f9721d | this.f9722e;
        }

        public final int h() {
            return this.f9725h;
        }

        public final int i() {
            if (!this.f9730m) {
                d();
            }
            return this.f9732o;
        }

        public final int j() {
            if (!this.f9730m) {
                d();
            }
            return this.f9734q;
        }

        public final int k() {
            if (!this.f9730m) {
                d();
            }
            return this.f9733p;
        }

        public final Rect l() {
            Rect rect = null;
            if (this.f9726i) {
                return null;
            }
            Rect rect2 = this.f9728k;
            if (rect2 != null || this.f9727j) {
                return rect2;
            }
            e();
            Rect rect3 = new Rect();
            int i10 = this.f9725h;
            Drawable[] drawableArr = this.f9724g;
            for (int i11 = 0; i11 < i10; i11++) {
                if (drawableArr[i11].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i12 = rect3.left;
                    if (i12 > rect.left) {
                        rect.left = i12;
                    }
                    int i13 = rect3.top;
                    if (i13 > rect.top) {
                        rect.top = i13;
                    }
                    int i14 = rect3.right;
                    if (i14 > rect.right) {
                        rect.right = i14;
                    }
                    int i15 = rect3.bottom;
                    if (i15 > rect.bottom) {
                        rect.bottom = i15;
                    }
                }
            }
            this.f9727j = true;
            this.f9728k = rect;
            return rect;
        }

        public final int m() {
            if (!this.f9730m) {
                d();
            }
            return this.f9731n;
        }

        public final int n() {
            if (this.f9735r) {
                return this.f9736s;
            }
            e();
            int i10 = this.f9725h;
            Drawable[] drawableArr = this.f9724g;
            int opacity = i10 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i11 = 1; i11 < i10; i11++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i11].getOpacity());
            }
            this.f9736s = opacity;
            this.f9735r = true;
            return opacity;
        }

        public void o(int i10, int i11) {
            Drawable[] drawableArr = new Drawable[i11];
            Drawable[] drawableArr2 = this.f9724g;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i10);
            }
            this.f9724g = drawableArr;
        }

        void p() {
            this.f9735r = false;
            this.f9737t = false;
        }

        public final boolean q() {
            return this.f9729l;
        }

        abstract void r();

        public final void t(boolean z10) {
            this.f9729l = z10;
        }

        public final void u(int i10) {
            this.A = i10;
        }

        public final void v(int i10) {
            this.B = i10;
        }

        final boolean w(int i10, int i11) {
            int i12 = this.f9725h;
            Drawable[] drawableArr = this.f9724g;
            boolean z10 = false;
            for (int i13 = 0; i13 < i12; i13++) {
                if (drawableArr[i13] != null) {
                    boolean m10 = Build.VERSION.SDK_INT >= 23 ? androidx.core.graphics.drawable.a.m(drawableArr[i13], i10) : false;
                    if (i13 == i11) {
                        z10 = m10;
                    }
                }
            }
            this.f9743z = i10;
            return z10;
        }

        public final void x(boolean z10) {
            this.f9726i = z10;
        }

        final void y(Resources resources) {
            if (resources != null) {
                this.f9719b = resources;
                int f10 = b.f(resources, this.f9720c);
                int i10 = this.f9720c;
                this.f9720c = f10;
                if (i10 != f10) {
                    this.f9730m = false;
                    this.f9727j = false;
                }
            }
        }
    }

    private void d(Drawable drawable) {
        if (this.f9715q == null) {
            this.f9715q = new c();
        }
        drawable.setCallback(this.f9715q.b(drawable.getCallback()));
        try {
            if (this.f9704f.A <= 0 && this.f9709k) {
                drawable.setAlpha(this.f9708j);
            }
            d dVar = this.f9704f;
            if (dVar.E) {
                drawable.setColorFilter(dVar.D);
            } else {
                if (dVar.H) {
                    androidx.core.graphics.drawable.a.o(drawable, dVar.F);
                }
                d dVar2 = this.f9704f;
                if (dVar2.I) {
                    androidx.core.graphics.drawable.a.p(drawable, dVar2.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f9704f.f9741x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 23) {
                androidx.core.graphics.drawable.a.m(drawable, androidx.core.graphics.drawable.a.f(this));
            }
            if (i10 >= 19) {
                androidx.core.graphics.drawable.a.j(drawable, this.f9704f.C);
            }
            Rect rect = this.f9705g;
            if (i10 >= 21 && rect != null) {
                androidx.core.graphics.drawable.a.l(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.f9715q.a());
        }
    }

    private boolean e() {
        return isAutoMirrored() && androidx.core.graphics.drawable.a.f(this) == 1;
    }

    static int f(Resources resources, int i10) {
        if (resources != null) {
            i10 = resources.getDisplayMetrics().densityDpi;
        }
        if (i10 == 0) {
            return 160;
        }
        return i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f9709k = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f9706h
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L36
            long r9 = r13.f9713o
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L38
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L20
            int r9 = r13.f9708j
            r3.setAlpha(r9)
            goto L36
        L20:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r10 = (int) r9
            g.b$d r9 = r13.f9704f
            int r9 = r9.A
            int r10 = r10 / r9
            int r9 = 255 - r10
            int r10 = r13.f9708j
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = 1
            goto L39
        L36:
            r13.f9713o = r7
        L38:
            r3 = 0
        L39:
            android.graphics.drawable.Drawable r9 = r13.f9707i
            if (r9 == 0) goto L61
            long r10 = r13.f9714p
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 == 0) goto L63
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L4e
            r9.setVisible(r6, r6)
            r0 = 0
            r13.f9707i = r0
            goto L61
        L4e:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            g.b$d r4 = r13.f9704f
            int r4 = r4.B
            int r3 = r3 / r4
            int r4 = r13.f9708j
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L64
        L61:
            r13.f9714p = r7
        L63:
            r0 = r3
        L64:
            if (r14 == 0) goto L70
            if (r0 == 0) goto L70
            java.lang.Runnable r14 = r13.f9712n
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g.b.a(boolean):void");
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.f9704f.b(theme);
    }

    d b() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f9710l;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f9704f.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f9706h;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f9707i;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean g(int r10) {
        /*
            r9 = this;
            int r0 = r9.f9710l
            r1 = 0
            if (r10 != r0) goto L6
            return r1
        L6:
            long r2 = android.os.SystemClock.uptimeMillis()
            g.b$d r0 = r9.f9704f
            int r0 = r0.B
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L2e
            android.graphics.drawable.Drawable r0 = r9.f9707i
            if (r0 == 0) goto L1a
            r0.setVisible(r1, r1)
        L1a:
            android.graphics.drawable.Drawable r0 = r9.f9706h
            if (r0 == 0) goto L29
            r9.f9707i = r0
            g.b$d r0 = r9.f9704f
            int r0 = r0.B
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.f9714p = r0
            goto L35
        L29:
            r9.f9707i = r4
            r9.f9714p = r5
            goto L35
        L2e:
            android.graphics.drawable.Drawable r0 = r9.f9706h
            if (r0 == 0) goto L35
            r0.setVisible(r1, r1)
        L35:
            if (r10 < 0) goto L55
            g.b$d r0 = r9.f9704f
            int r1 = r0.f9725h
            if (r10 >= r1) goto L55
            android.graphics.drawable.Drawable r0 = r0.g(r10)
            r9.f9706h = r0
            r9.f9710l = r10
            if (r0 == 0) goto L5a
            g.b$d r10 = r9.f9704f
            int r10 = r10.A
            if (r10 <= 0) goto L51
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.f9713o = r2
        L51:
            r9.d(r0)
            goto L5a
        L55:
            r9.f9706h = r4
            r10 = -1
            r9.f9710l = r10
        L5a:
            long r0 = r9.f9713o
            r10 = 1
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 != 0) goto L67
            long r0 = r9.f9714p
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 == 0) goto L79
        L67:
            java.lang.Runnable r0 = r9.f9712n
            if (r0 != 0) goto L73
            g.b$a r0 = new g.b$a
            r0.<init>()
            r9.f9712n = r0
            goto L76
        L73:
            r9.unscheduleSelf(r0)
        L76:
            r9.a(r10)
        L79:
            r9.invalidateSelf()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: g.b.g(int):boolean");
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f9708j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f9704f.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!this.f9704f.c()) {
            return null;
        }
        this.f9704f.f9721d = getChangingConfigurations();
        return this.f9704f;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f9706h;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f9705g;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f9704f.q()) {
            return this.f9704f.i();
        }
        Drawable drawable = this.f9706h;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f9704f.q()) {
            return this.f9704f.m();
        }
        Drawable drawable = this.f9706h;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f9704f.q()) {
            return this.f9704f.j();
        }
        Drawable drawable = this.f9706h;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f9704f.q()) {
            return this.f9704f.k();
        }
        Drawable drawable = this.f9706h;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f9706h;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f9704f.n();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.f9706h;
        if (drawable != null) {
            C0173b.b(drawable, outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect l10 = this.f9704f.l();
        if (l10 != null) {
            rect.set(l10);
            padding = (l10.right | ((l10.left | l10.top) | l10.bottom)) != 0;
        } else {
            Drawable drawable = this.f9706h;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (e()) {
            int i10 = rect.left;
            rect.left = rect.right;
            rect.right = i10;
        }
        return padding;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(d dVar) {
        this.f9704f = dVar;
        int i10 = this.f9710l;
        if (i10 >= 0) {
            Drawable g10 = dVar.g(i10);
            this.f9706h = g10;
            if (g10 != null) {
                d(g10);
            }
        }
        this.f9707i = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i(Resources resources) {
        this.f9704f.y(resources);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        d dVar = this.f9704f;
        if (dVar != null) {
            dVar.p();
        }
        if (drawable != this.f9706h || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f9704f.C;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z10;
        Drawable drawable = this.f9707i;
        boolean z11 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f9707i = null;
            z10 = true;
        } else {
            z10 = false;
        }
        Drawable drawable2 = this.f9706h;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f9709k) {
                this.f9706h.setAlpha(this.f9708j);
            }
        }
        if (this.f9714p != 0) {
            this.f9714p = 0L;
            z10 = true;
        }
        if (this.f9713o != 0) {
            this.f9713o = 0L;
        } else {
            z11 = z10;
        }
        if (z11) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f9711m && super.mutate() == this) {
            d b10 = b();
            b10.r();
            h(b10);
            this.f9711m = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f9707i;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f9706h;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i10) {
        return this.f9704f.w(i10, c());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i10) {
        Drawable drawable = this.f9707i;
        if (drawable != null) {
            return drawable.setLevel(i10);
        }
        Drawable drawable2 = this.f9706h;
        if (drawable2 != null) {
            return drawable2.setLevel(i10);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f9707i;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f9706h;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        if (drawable != this.f9706h || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (this.f9709k && this.f9708j == i10) {
            return;
        }
        this.f9709k = true;
        this.f9708j = i10;
        Drawable drawable = this.f9706h;
        if (drawable != null) {
            if (this.f9713o == 0) {
                drawable.setAlpha(i10);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        d dVar = this.f9704f;
        if (dVar.C != z10) {
            dVar.C = z10;
            Drawable drawable = this.f9706h;
            if (drawable != null) {
                androidx.core.graphics.drawable.a.j(drawable, z10);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        d dVar = this.f9704f;
        dVar.E = true;
        if (dVar.D != colorFilter) {
            dVar.D = colorFilter;
            Drawable drawable = this.f9706h;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z10) {
        d dVar = this.f9704f;
        if (dVar.f9741x != z10) {
            dVar.f9741x = z10;
            Drawable drawable = this.f9706h;
            if (drawable != null) {
                drawable.setDither(z10);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f10, float f11) {
        Drawable drawable = this.f9706h;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.k(drawable, f10, f11);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i10, int i11, int i12, int i13) {
        Rect rect = this.f9705g;
        if (rect == null) {
            this.f9705g = new Rect(i10, i11, i12, i13);
        } else {
            rect.set(i10, i11, i12, i13);
        }
        Drawable drawable = this.f9706h;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.l(drawable, i10, i11, i12, i13);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        d dVar = this.f9704f;
        dVar.H = true;
        if (dVar.F != colorStateList) {
            dVar.F = colorStateList;
            androidx.core.graphics.drawable.a.o(this.f9706h, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        d dVar = this.f9704f;
        dVar.I = true;
        if (dVar.G != mode) {
            dVar.G = mode;
            androidx.core.graphics.drawable.a.p(this.f9706h, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        Drawable drawable = this.f9707i;
        if (drawable != null) {
            drawable.setVisible(z10, z11);
        }
        Drawable drawable2 = this.f9706h;
        if (drawable2 != null) {
            drawable2.setVisible(z10, z11);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f9706h || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }
}
