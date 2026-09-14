package androidx.recyclerview.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.view.accessibility.d;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.b;
import androidx.recyclerview.widget.e;
import androidx.recyclerview.widget.o;
import androidx.recyclerview.widget.p;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements androidx.core.view.n {
    private static final int[] D0 = {R.attr.nestedScrollingEnabled};
    private static final int[] E0 = {R.attr.clipToPadding};
    static final boolean F0;
    static final boolean G0;
    static final boolean H0;
    private static final boolean I0;
    private static final boolean J0;
    private static final Class<?>[] K0;
    static final Interpolator L0;
    boolean A;
    final List<d0> A0;
    boolean B;
    private Runnable B0;
    private boolean C;
    private final p.b C0;
    private int D;
    boolean E;
    private final AccessibilityManager F;
    private List<q> G;
    boolean H;
    boolean I;
    private int J;
    private int K;
    private k L;
    private EdgeEffect M;
    private EdgeEffect N;
    private EdgeEffect O;
    private EdgeEffect P;
    l Q;
    private int R;
    private int S;
    private VelocityTracker T;
    private int U;
    private int V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private int f3301a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f3302b0;

    /* renamed from: c0, reason: collision with root package name */
    private r f3303c0;

    /* renamed from: d0, reason: collision with root package name */
    private final int f3304d0;

    /* renamed from: e0, reason: collision with root package name */
    private final int f3305e0;

    /* renamed from: f, reason: collision with root package name */
    private final x f3306f;

    /* renamed from: f0, reason: collision with root package name */
    private float f3307f0;

    /* renamed from: g, reason: collision with root package name */
    final v f3308g;

    /* renamed from: g0, reason: collision with root package name */
    private float f3309g0;

    /* renamed from: h, reason: collision with root package name */
    private y f3310h;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f3311h0;

    /* renamed from: i, reason: collision with root package name */
    androidx.recyclerview.widget.a f3312i;

    /* renamed from: i0, reason: collision with root package name */
    final c0 f3313i0;

    /* renamed from: j, reason: collision with root package name */
    androidx.recyclerview.widget.b f3314j;

    /* renamed from: j0, reason: collision with root package name */
    androidx.recyclerview.widget.e f3315j0;

    /* renamed from: k, reason: collision with root package name */
    final androidx.recyclerview.widget.p f3316k;

    /* renamed from: k0, reason: collision with root package name */
    e.b f3317k0;

    /* renamed from: l, reason: collision with root package name */
    boolean f3318l;

    /* renamed from: l0, reason: collision with root package name */
    final a0 f3319l0;

    /* renamed from: m, reason: collision with root package name */
    final Rect f3320m;

    /* renamed from: m0, reason: collision with root package name */
    private t f3321m0;

    /* renamed from: n, reason: collision with root package name */
    private final Rect f3322n;

    /* renamed from: n0, reason: collision with root package name */
    private List<t> f3323n0;

    /* renamed from: o, reason: collision with root package name */
    final RectF f3324o;

    /* renamed from: o0, reason: collision with root package name */
    boolean f3325o0;

    /* renamed from: p, reason: collision with root package name */
    g f3326p;

    /* renamed from: p0, reason: collision with root package name */
    boolean f3327p0;

    /* renamed from: q, reason: collision with root package name */
    o f3328q;

    /* renamed from: q0, reason: collision with root package name */
    private l.b f3329q0;

    /* renamed from: r, reason: collision with root package name */
    w f3330r;

    /* renamed from: r0, reason: collision with root package name */
    boolean f3331r0;

    /* renamed from: s, reason: collision with root package name */
    final ArrayList<n> f3332s;

    /* renamed from: s0, reason: collision with root package name */
    androidx.recyclerview.widget.k f3333s0;

    /* renamed from: t, reason: collision with root package name */
    private final ArrayList<s> f3334t;

    /* renamed from: t0, reason: collision with root package name */
    private j f3335t0;

    /* renamed from: u, reason: collision with root package name */
    private s f3336u;

    /* renamed from: u0, reason: collision with root package name */
    private final int[] f3337u0;

    /* renamed from: v, reason: collision with root package name */
    boolean f3338v;

    /* renamed from: v0, reason: collision with root package name */
    private androidx.core.view.p f3339v0;

    /* renamed from: w, reason: collision with root package name */
    boolean f3340w;

    /* renamed from: w0, reason: collision with root package name */
    private final int[] f3341w0;

    /* renamed from: x, reason: collision with root package name */
    boolean f3342x;

    /* renamed from: x0, reason: collision with root package name */
    final int[] f3343x0;

    /* renamed from: y, reason: collision with root package name */
    boolean f3344y;

    /* renamed from: y0, reason: collision with root package name */
    private final int[] f3345y0;

    /* renamed from: z, reason: collision with root package name */
    private int f3346z;

    /* renamed from: z0, reason: collision with root package name */
    final int[] f3347z0;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.f3344y || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.f3338v) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.B) {
                recyclerView2.A = true;
            } else {
                recyclerView2.v();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a0 {

        /* renamed from: b, reason: collision with root package name */
        private SparseArray<Object> f3350b;

        /* renamed from: m, reason: collision with root package name */
        int f3361m;

        /* renamed from: n, reason: collision with root package name */
        long f3362n;

        /* renamed from: o, reason: collision with root package name */
        int f3363o;

        /* renamed from: p, reason: collision with root package name */
        int f3364p;

        /* renamed from: a, reason: collision with root package name */
        int f3349a = -1;

        /* renamed from: c, reason: collision with root package name */
        int f3351c = 0;

        /* renamed from: d, reason: collision with root package name */
        int f3352d = 0;

        /* renamed from: e, reason: collision with root package name */
        int f3353e = 1;

        /* renamed from: f, reason: collision with root package name */
        int f3354f = 0;

        /* renamed from: g, reason: collision with root package name */
        boolean f3355g = false;

        /* renamed from: h, reason: collision with root package name */
        boolean f3356h = false;

        /* renamed from: i, reason: collision with root package name */
        boolean f3357i = false;

        /* renamed from: j, reason: collision with root package name */
        boolean f3358j = false;

        /* renamed from: k, reason: collision with root package name */
        boolean f3359k = false;

        /* renamed from: l, reason: collision with root package name */
        boolean f3360l = false;

        void a(int i10) {
            if ((this.f3353e & i10) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i10) + " but it is " + Integer.toBinaryString(this.f3353e));
        }

        public int b() {
            return this.f3356h ? this.f3351c - this.f3352d : this.f3354f;
        }

        public int c() {
            return this.f3349a;
        }

        public boolean d() {
            return this.f3349a != -1;
        }

        public boolean e() {
            return this.f3356h;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void f(g gVar) {
            this.f3353e = 1;
            this.f3354f = gVar.c();
            this.f3356h = false;
            this.f3357i = false;
            this.f3358j = false;
        }

        public boolean g() {
            return this.f3360l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f3349a + ", mData=" + this.f3350b + ", mItemCount=" + this.f3354f + ", mIsMeasuring=" + this.f3358j + ", mPreviousLayoutItemCount=" + this.f3351c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f3352d + ", mStructureChanged=" + this.f3355g + ", mInPreLayout=" + this.f3356h + ", mRunSimpleAnimations=" + this.f3359k + ", mRunPredictiveAnimations=" + this.f3360l + '}';
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = RecyclerView.this.Q;
            if (lVar != null) {
                lVar.u();
            }
            RecyclerView.this.f3331r0 = false;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b0 {
    }

    /* loaded from: classes.dex */
    static class c implements Interpolator {
        c() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c0 implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        private int f3366f;

        /* renamed from: g, reason: collision with root package name */
        private int f3367g;

        /* renamed from: h, reason: collision with root package name */
        OverScroller f3368h;

        /* renamed from: i, reason: collision with root package name */
        Interpolator f3369i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f3370j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f3371k;

        c0() {
            Interpolator interpolator = RecyclerView.L0;
            this.f3369i = interpolator;
            this.f3370j = false;
            this.f3371k = false;
            this.f3368h = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private int a(int i10, int i11, int i12, int i13) {
            int i14;
            int abs = Math.abs(i10);
            int abs2 = Math.abs(i11);
            boolean z10 = abs > abs2;
            int sqrt = (int) Math.sqrt((i12 * i12) + (i13 * i13));
            int sqrt2 = (int) Math.sqrt((i10 * i10) + (i11 * i11));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z10 ? recyclerView.getWidth() : recyclerView.getHeight();
            int i15 = width / 2;
            float f10 = width;
            float f11 = i15;
            float c10 = f11 + (c(Math.min(1.0f, (sqrt2 * 1.0f) / f10)) * f11);
            if (sqrt > 0) {
                i14 = Math.round(Math.abs(c10 / sqrt) * 1000.0f) * 4;
            } else {
                if (!z10) {
                    abs = abs2;
                }
                i14 = (int) (((abs / f10) + 1.0f) * 300.0f);
            }
            return Math.min(i14, 2000);
        }

        private void b() {
            this.f3371k = false;
            this.f3370j = true;
        }

        private float c(float f10) {
            return (float) Math.sin((f10 - 0.5f) * 0.47123894f);
        }

        private void d() {
            this.f3370j = false;
            if (this.f3371k) {
                f();
            }
        }

        public void e(int i10, int i11) {
            RecyclerView.this.setScrollState(2);
            this.f3367g = 0;
            this.f3366f = 0;
            this.f3368h.fling(0, 0, i10, i11, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            f();
        }

        void f() {
            if (this.f3370j) {
                this.f3371k = true;
            } else {
                RecyclerView.this.removeCallbacks(this);
                androidx.core.view.a0.e0(RecyclerView.this, this);
            }
        }

        public void g(int i10, int i11) {
            i(i10, i11, 0, 0);
        }

        public void h(int i10, int i11, int i12) {
            j(i10, i11, i12, RecyclerView.L0);
        }

        public void i(int i10, int i11, int i12, int i13) {
            h(i10, i11, a(i10, i11, i12, i13));
        }

        public void j(int i10, int i11, int i12, Interpolator interpolator) {
            if (this.f3369i != interpolator) {
                this.f3369i = interpolator;
                this.f3368h = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.f3367g = 0;
            this.f3366f = 0;
            this.f3368h.startScroll(0, 0, i10, i11, i12);
            if (Build.VERSION.SDK_INT < 23) {
                this.f3368h.computeScrollOffset();
            }
            f();
        }

        public void k(int i10, int i11, Interpolator interpolator) {
            int a10 = a(i10, i11, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.L0;
            }
            j(i10, i11, a10, interpolator);
        }

        public void l() {
            RecyclerView.this.removeCallbacks(this);
            this.f3368h.abortAnimation();
        }

        /* JADX WARN: Code restructure failed: missing block: B:55:0x00e3, code lost:
        
            if (r8 > 0) goto L50;
         */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00df  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00ef  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00f6 A[ADDED_TO_REGION] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 410
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.c0.run():void");
        }
    }

    /* loaded from: classes.dex */
    class d implements p.b {
        d() {
        }

        @Override // androidx.recyclerview.widget.p.b
        public void a(d0 d0Var) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f3328q.m1(d0Var.f3375a, recyclerView.f3308g);
        }

        @Override // androidx.recyclerview.widget.p.b
        public void b(d0 d0Var, l.c cVar, l.c cVar2) {
            RecyclerView.this.m(d0Var, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.p.b
        public void c(d0 d0Var, l.c cVar, l.c cVar2) {
            RecyclerView.this.f3308g.J(d0Var);
            RecyclerView.this.o(d0Var, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.p.b
        public void d(d0 d0Var, l.c cVar, l.c cVar2) {
            d0Var.F(false);
            RecyclerView recyclerView = RecyclerView.this;
            boolean z10 = recyclerView.H;
            l lVar = recyclerView.Q;
            if (z10) {
                if (!lVar.b(d0Var, d0Var, cVar, cVar2)) {
                    return;
                }
            } else if (!lVar.d(d0Var, cVar, cVar2)) {
                return;
            }
            RecyclerView.this.O0();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class d0 {

        /* renamed from: s, reason: collision with root package name */
        private static final List<Object> f3374s = Collections.emptyList();

        /* renamed from: a, reason: collision with root package name */
        public final View f3375a;

        /* renamed from: b, reason: collision with root package name */
        WeakReference<RecyclerView> f3376b;

        /* renamed from: j, reason: collision with root package name */
        int f3384j;

        /* renamed from: r, reason: collision with root package name */
        RecyclerView f3392r;

        /* renamed from: c, reason: collision with root package name */
        int f3377c = -1;

        /* renamed from: d, reason: collision with root package name */
        int f3378d = -1;

        /* renamed from: e, reason: collision with root package name */
        long f3379e = -1;

        /* renamed from: f, reason: collision with root package name */
        int f3380f = -1;

        /* renamed from: g, reason: collision with root package name */
        int f3381g = -1;

        /* renamed from: h, reason: collision with root package name */
        d0 f3382h = null;

        /* renamed from: i, reason: collision with root package name */
        d0 f3383i = null;

        /* renamed from: k, reason: collision with root package name */
        List<Object> f3385k = null;

        /* renamed from: l, reason: collision with root package name */
        List<Object> f3386l = null;

        /* renamed from: m, reason: collision with root package name */
        private int f3387m = 0;

        /* renamed from: n, reason: collision with root package name */
        v f3388n = null;

        /* renamed from: o, reason: collision with root package name */
        boolean f3389o = false;

        /* renamed from: p, reason: collision with root package name */
        private int f3390p = 0;

        /* renamed from: q, reason: collision with root package name */
        int f3391q = -1;

        public d0(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.f3375a = view;
        }

        private void g() {
            if (this.f3385k == null) {
                ArrayList arrayList = new ArrayList();
                this.f3385k = arrayList;
                this.f3386l = Collections.unmodifiableList(arrayList);
            }
        }

        void A(RecyclerView recyclerView) {
            int i10 = this.f3391q;
            if (i10 == -1) {
                i10 = androidx.core.view.a0.x(this.f3375a);
            }
            this.f3390p = i10;
            recyclerView.k1(this, 4);
        }

        void B(RecyclerView recyclerView) {
            recyclerView.k1(this, this.f3390p);
            this.f3390p = 0;
        }

        void C() {
            this.f3384j = 0;
            this.f3377c = -1;
            this.f3378d = -1;
            this.f3379e = -1L;
            this.f3381g = -1;
            this.f3387m = 0;
            this.f3382h = null;
            this.f3383i = null;
            d();
            this.f3390p = 0;
            this.f3391q = -1;
            RecyclerView.s(this);
        }

        void D() {
            if (this.f3378d == -1) {
                this.f3378d = this.f3377c;
            }
        }

        void E(int i10, int i11) {
            this.f3384j = (i10 & i11) | (this.f3384j & (~i11));
        }

        public final void F(boolean z10) {
            int i10;
            int i11 = this.f3387m;
            int i12 = z10 ? i11 - 1 : i11 + 1;
            this.f3387m = i12;
            if (i12 < 0) {
                this.f3387m = 0;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ");
                sb2.append(this);
                return;
            }
            if (!z10 && i12 == 1) {
                i10 = this.f3384j | 16;
            } else if (!z10 || i12 != 0) {
                return;
            } else {
                i10 = this.f3384j & (-17);
            }
            this.f3384j = i10;
        }

        void G(v vVar, boolean z10) {
            this.f3388n = vVar;
            this.f3389o = z10;
        }

        boolean H() {
            return (this.f3384j & 16) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean I() {
            return (this.f3384j & 128) != 0;
        }

        void J() {
            this.f3388n.J(this);
        }

        boolean K() {
            return (this.f3384j & 32) != 0;
        }

        void a(Object obj) {
            if (obj == null) {
                b(1024);
            } else if ((1024 & this.f3384j) == 0) {
                g();
                this.f3385k.add(obj);
            }
        }

        void b(int i10) {
            this.f3384j = i10 | this.f3384j;
        }

        void c() {
            this.f3378d = -1;
            this.f3381g = -1;
        }

        void d() {
            List<Object> list = this.f3385k;
            if (list != null) {
                list.clear();
            }
            this.f3384j &= -1025;
        }

        void e() {
            this.f3384j &= -33;
        }

        void f() {
            this.f3384j &= -257;
        }

        boolean h() {
            return (this.f3384j & 16) == 0 && androidx.core.view.a0.P(this.f3375a);
        }

        void i(int i10, int i11, boolean z10) {
            b(8);
            z(i11, z10);
            this.f3377c = i10;
        }

        public final int j() {
            RecyclerView recyclerView = this.f3392r;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.c0(this);
        }

        public final long k() {
            return this.f3379e;
        }

        public final int l() {
            return this.f3380f;
        }

        public final int m() {
            int i10 = this.f3381g;
            return i10 == -1 ? this.f3377c : i10;
        }

        public final int n() {
            return this.f3378d;
        }

        List<Object> o() {
            if ((this.f3384j & 1024) != 0) {
                return f3374s;
            }
            List<Object> list = this.f3385k;
            return (list == null || list.size() == 0) ? f3374s : this.f3386l;
        }

        boolean p(int i10) {
            return (i10 & this.f3384j) != 0;
        }

        boolean q() {
            return (this.f3384j & 512) != 0 || s();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean r() {
            return (this.f3384j & 1) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean s() {
            return (this.f3384j & 4) != 0;
        }

        public final boolean t() {
            return (this.f3384j & 16) == 0 && !androidx.core.view.a0.P(this.f3375a);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.f3377c + " id=" + this.f3379e + ", oldPos=" + this.f3378d + ", pLpos:" + this.f3381g);
            if (v()) {
                sb2.append(" scrap ");
                sb2.append(this.f3389o ? "[changeScrap]" : "[attachedScrap]");
            }
            if (s()) {
                sb2.append(" invalid");
            }
            if (!r()) {
                sb2.append(" unbound");
            }
            if (y()) {
                sb2.append(" update");
            }
            if (u()) {
                sb2.append(" removed");
            }
            if (I()) {
                sb2.append(" ignored");
            }
            if (w()) {
                sb2.append(" tmpDetached");
            }
            if (!t()) {
                sb2.append(" not recyclable(" + this.f3387m + ")");
            }
            if (q()) {
                sb2.append(" undefined adapter position");
            }
            if (this.f3375a.getParent() == null) {
                sb2.append(" no parent");
            }
            sb2.append("}");
            return sb2.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean u() {
            return (this.f3384j & 8) != 0;
        }

        boolean v() {
            return this.f3388n != null;
        }

        boolean w() {
            return (this.f3384j & 256) != 0;
        }

        boolean x() {
            return (this.f3384j & 2) != 0;
        }

        boolean y() {
            return (this.f3384j & 2) != 0;
        }

        void z(int i10, boolean z10) {
            if (this.f3378d == -1) {
                this.f3378d = this.f3377c;
            }
            if (this.f3381g == -1) {
                this.f3381g = this.f3377c;
            }
            if (z10) {
                this.f3381g += i10;
            }
            this.f3377c += i10;
            if (this.f3375a.getLayoutParams() != null) {
                ((p) this.f3375a.getLayoutParams()).f3432c = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements b.InterfaceC0057b {
        e() {
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0057b
        public View a(int i10) {
            return RecyclerView.this.getChildAt(i10);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0057b
        public void b(View view) {
            d0 g02 = RecyclerView.g0(view);
            if (g02 != null) {
                g02.A(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0057b
        public d0 c(View view) {
            return RecyclerView.g0(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0057b
        public void d(int i10) {
            d0 g02;
            View a10 = a(i10);
            if (a10 != null && (g02 = RecyclerView.g0(a10)) != null) {
                if (g02.w() && !g02.I()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + g02 + RecyclerView.this.R());
                }
                g02.b(256);
            }
            RecyclerView.this.detachViewFromParent(i10);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0057b
        public void e(View view) {
            d0 g02 = RecyclerView.g0(view);
            if (g02 != null) {
                g02.B(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0057b
        public void f(View view, int i10) {
            RecyclerView.this.addView(view, i10);
            RecyclerView.this.z(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0057b
        public int g() {
            return RecyclerView.this.getChildCount();
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0057b
        public void h(int i10) {
            View childAt = RecyclerView.this.getChildAt(i10);
            if (childAt != null) {
                RecyclerView.this.A(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i10);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0057b
        public void i() {
            int g10 = g();
            for (int i10 = 0; i10 < g10; i10++) {
                View a10 = a(i10);
                RecyclerView.this.A(a10);
                a10.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0057b
        public void j(View view, int i10, ViewGroup.LayoutParams layoutParams) {
            d0 g02 = RecyclerView.g0(view);
            if (g02 != null) {
                if (!g02.w() && !g02.I()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + g02 + RecyclerView.this.R());
                }
                g02.f();
            }
            RecyclerView.this.attachViewToParent(view, i10, layoutParams);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0057b
        public int k(View view) {
            return RecyclerView.this.indexOfChild(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements a.InterfaceC0056a {
        f() {
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0056a
        public void a(int i10, int i11) {
            RecyclerView.this.E0(i10, i11);
            RecyclerView.this.f3325o0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0056a
        public void b(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0056a
        public d0 c(int i10) {
            d0 a02 = RecyclerView.this.a0(i10, true);
            if (a02 == null || RecyclerView.this.f3314j.n(a02.f3375a)) {
                return null;
            }
            return a02;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0056a
        public void d(int i10, int i11) {
            RecyclerView.this.F0(i10, i11, false);
            RecyclerView.this.f3325o0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0056a
        public void e(int i10, int i11) {
            RecyclerView.this.D0(i10, i11);
            RecyclerView.this.f3325o0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0056a
        public void f(int i10, int i11) {
            RecyclerView.this.F0(i10, i11, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f3325o0 = true;
            recyclerView.f3319l0.f3352d += i11;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0056a
        public void g(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0056a
        public void h(int i10, int i11, Object obj) {
            RecyclerView.this.u1(i10, i11, obj);
            RecyclerView.this.f3327p0 = true;
        }

        void i(a.b bVar) {
            int i10 = bVar.f3513a;
            if (i10 == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f3328q.R0(recyclerView, bVar.f3514b, bVar.f3516d);
                return;
            }
            if (i10 == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.f3328q.U0(recyclerView2, bVar.f3514b, bVar.f3516d);
            } else if (i10 == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.f3328q.W0(recyclerView3, bVar.f3514b, bVar.f3516d, bVar.f3515c);
            } else {
                if (i10 != 8) {
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.f3328q.T0(recyclerView4, bVar.f3514b, bVar.f3516d, 1);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class g<VH extends d0> {

        /* renamed from: a, reason: collision with root package name */
        private final h f3395a = new h();

        /* renamed from: b, reason: collision with root package name */
        private boolean f3396b = false;

        public final void a(VH vh, int i10) {
            vh.f3377c = i10;
            if (f()) {
                vh.f3379e = d(i10);
            }
            vh.E(1, 519);
            androidx.core.os.k.a("RV OnBindView");
            j(vh, i10, vh.o());
            vh.d();
            ViewGroup.LayoutParams layoutParams = vh.f3375a.getLayoutParams();
            if (layoutParams instanceof p) {
                ((p) layoutParams).f3432c = true;
            }
            androidx.core.os.k.b();
        }

        public final VH b(ViewGroup viewGroup, int i10) {
            try {
                androidx.core.os.k.a("RV CreateView");
                VH k10 = k(viewGroup, i10);
                if (k10.f3375a.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                k10.f3380f = i10;
                return k10;
            } finally {
                androidx.core.os.k.b();
            }
        }

        public abstract int c();

        public long d(int i10) {
            return -1L;
        }

        public int e(int i10) {
            return 0;
        }

        public final boolean f() {
            return this.f3396b;
        }

        public final void g() {
            this.f3395a.a();
        }

        public void h(RecyclerView recyclerView) {
        }

        public abstract void i(VH vh, int i10);

        public void j(VH vh, int i10, List<Object> list) {
            i(vh, i10);
        }

        public abstract VH k(ViewGroup viewGroup, int i10);

        public void l(RecyclerView recyclerView) {
        }

        public boolean m(VH vh) {
            return false;
        }

        public void n(VH vh) {
        }

        public void o(VH vh) {
        }

        public void p(VH vh) {
        }

        public void q(i iVar) {
            this.f3395a.registerObserver(iVar);
        }

        public void r(i iVar) {
            this.f3395a.unregisterObserver(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class h extends Observable<i> {
        h() {
        }

        public void a() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).a();
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class i {
        public void a() {
        }
    }

    /* loaded from: classes.dex */
    public interface j {
        int a(int i10, int i11);
    }

    /* loaded from: classes.dex */
    public static class k {
        protected EdgeEffect a(RecyclerView recyclerView, int i10) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* loaded from: classes.dex */
    public static abstract class l {

        /* renamed from: a, reason: collision with root package name */
        private b f3397a = null;

        /* renamed from: b, reason: collision with root package name */
        private ArrayList<a> f3398b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        private long f3399c = 120;

        /* renamed from: d, reason: collision with root package name */
        private long f3400d = 120;

        /* renamed from: e, reason: collision with root package name */
        private long f3401e = 250;

        /* renamed from: f, reason: collision with root package name */
        private long f3402f = 250;

        /* loaded from: classes.dex */
        public interface a {
            void a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public interface b {
            void a(d0 d0Var);
        }

        /* loaded from: classes.dex */
        public static class c {

            /* renamed from: a, reason: collision with root package name */
            public int f3403a;

            /* renamed from: b, reason: collision with root package name */
            public int f3404b;

            public c a(d0 d0Var) {
                return b(d0Var, 0);
            }

            public c b(d0 d0Var, int i10) {
                View view = d0Var.f3375a;
                this.f3403a = view.getLeft();
                this.f3404b = view.getTop();
                view.getRight();
                view.getBottom();
                return this;
            }
        }

        static int e(d0 d0Var) {
            int i10 = d0Var.f3384j & 14;
            if (d0Var.s()) {
                return 4;
            }
            if ((i10 & 4) != 0) {
                return i10;
            }
            int n10 = d0Var.n();
            int j10 = d0Var.j();
            return (n10 == -1 || j10 == -1 || n10 == j10) ? i10 : i10 | 2048;
        }

        public abstract boolean a(d0 d0Var, c cVar, c cVar2);

        public abstract boolean b(d0 d0Var, d0 d0Var2, c cVar, c cVar2);

        public abstract boolean c(d0 d0Var, c cVar, c cVar2);

        public abstract boolean d(d0 d0Var, c cVar, c cVar2);

        public abstract boolean f(d0 d0Var);

        public boolean g(d0 d0Var, List<Object> list) {
            return f(d0Var);
        }

        public final void h(d0 d0Var) {
            r(d0Var);
            b bVar = this.f3397a;
            if (bVar != null) {
                bVar.a(d0Var);
            }
        }

        public final void i() {
            int size = this.f3398b.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f3398b.get(i10).a();
            }
            this.f3398b.clear();
        }

        public abstract void j(d0 d0Var);

        public abstract void k();

        public long l() {
            return this.f3399c;
        }

        public long m() {
            return this.f3402f;
        }

        public long n() {
            return this.f3401e;
        }

        public long o() {
            return this.f3400d;
        }

        public abstract boolean p();

        public c q() {
            return new c();
        }

        public void r(d0 d0Var) {
        }

        public c s(a0 a0Var, d0 d0Var) {
            return q().a(d0Var);
        }

        public c t(a0 a0Var, d0 d0Var, int i10, List<Object> list) {
            return q().a(d0Var);
        }

        public abstract void u();

        void v(b bVar) {
            this.f3397a = bVar;
        }
    }

    /* loaded from: classes.dex */
    private class m implements l.b {
        m() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l.b
        public void a(d0 d0Var) {
            d0Var.F(true);
            if (d0Var.f3382h != null && d0Var.f3383i == null) {
                d0Var.f3382h = null;
            }
            d0Var.f3383i = null;
            if (d0Var.H() || RecyclerView.this.X0(d0Var.f3375a) || !d0Var.w()) {
                return;
            }
            RecyclerView.this.removeDetachedView(d0Var.f3375a, false);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class n {
        @Deprecated
        public void d(Rect rect, int i10, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void e(Rect rect, View view, RecyclerView recyclerView, a0 a0Var) {
            d(rect, ((p) view.getLayoutParams()).a(), recyclerView);
        }

        @Deprecated
        public void f(Canvas canvas, RecyclerView recyclerView) {
        }

        public void g(Canvas canvas, RecyclerView recyclerView, a0 a0Var) {
            f(canvas, recyclerView);
        }

        @Deprecated
        public void h(Canvas canvas, RecyclerView recyclerView) {
        }

        public void i(Canvas canvas, RecyclerView recyclerView, a0 a0Var) {
            h(canvas, recyclerView);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class o {

        /* renamed from: a, reason: collision with root package name */
        androidx.recyclerview.widget.b f3406a;

        /* renamed from: b, reason: collision with root package name */
        RecyclerView f3407b;

        /* renamed from: c, reason: collision with root package name */
        private final o.b f3408c;

        /* renamed from: d, reason: collision with root package name */
        private final o.b f3409d;

        /* renamed from: e, reason: collision with root package name */
        androidx.recyclerview.widget.o f3410e;

        /* renamed from: f, reason: collision with root package name */
        androidx.recyclerview.widget.o f3411f;

        /* renamed from: g, reason: collision with root package name */
        z f3412g;

        /* renamed from: h, reason: collision with root package name */
        boolean f3413h;

        /* renamed from: i, reason: collision with root package name */
        boolean f3414i;

        /* renamed from: j, reason: collision with root package name */
        boolean f3415j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f3416k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f3417l;

        /* renamed from: m, reason: collision with root package name */
        int f3418m;

        /* renamed from: n, reason: collision with root package name */
        boolean f3419n;

        /* renamed from: o, reason: collision with root package name */
        private int f3420o;

        /* renamed from: p, reason: collision with root package name */
        private int f3421p;

        /* renamed from: q, reason: collision with root package name */
        private int f3422q;

        /* renamed from: r, reason: collision with root package name */
        private int f3423r;

        /* loaded from: classes.dex */
        class a implements o.b {
            a() {
            }

            @Override // androidx.recyclerview.widget.o.b
            public View a(int i10) {
                return o.this.I(i10);
            }

            @Override // androidx.recyclerview.widget.o.b
            public int b() {
                return o.this.o0() - o.this.f0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int c(View view) {
                return o.this.Q(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).leftMargin;
            }

            @Override // androidx.recyclerview.widget.o.b
            public int d() {
                return o.this.e0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int e(View view) {
                return o.this.T(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).rightMargin;
            }
        }

        /* loaded from: classes.dex */
        class b implements o.b {
            b() {
            }

            @Override // androidx.recyclerview.widget.o.b
            public View a(int i10) {
                return o.this.I(i10);
            }

            @Override // androidx.recyclerview.widget.o.b
            public int b() {
                return o.this.W() - o.this.d0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int c(View view) {
                return o.this.U(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).topMargin;
            }

            @Override // androidx.recyclerview.widget.o.b
            public int d() {
                return o.this.g0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int e(View view) {
                return o.this.O(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).bottomMargin;
            }
        }

        /* loaded from: classes.dex */
        public interface c {
            void a(int i10, int i11);
        }

        /* loaded from: classes.dex */
        public static class d {

            /* renamed from: a, reason: collision with root package name */
            public int f3426a;

            /* renamed from: b, reason: collision with root package name */
            public int f3427b;

            /* renamed from: c, reason: collision with root package name */
            public boolean f3428c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f3429d;
        }

        public o() {
            a aVar = new a();
            this.f3408c = aVar;
            b bVar = new b();
            this.f3409d = bVar;
            this.f3410e = new androidx.recyclerview.widget.o(aVar);
            this.f3411f = new androidx.recyclerview.widget.o(bVar);
            this.f3413h = false;
            this.f3414i = false;
            this.f3415j = false;
            this.f3416k = true;
            this.f3417l = true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        
            if (r5 == 1073741824) goto L14;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int K(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L1a
                if (r7 < 0) goto L11
                goto L1c
            L11:
                if (r7 != r1) goto L2f
                if (r5 == r2) goto L21
                if (r5 == 0) goto L2f
                if (r5 == r3) goto L21
                goto L2f
            L1a:
                if (r7 < 0) goto L1f
            L1c:
                r5 = 1073741824(0x40000000, float:2.0)
                goto L31
            L1f:
                if (r7 != r1) goto L23
            L21:
                r7 = r4
                goto L31
            L23:
                if (r7 != r0) goto L2f
                if (r5 == r2) goto L2c
                if (r5 != r3) goto L2a
                goto L2c
            L2a:
                r5 = 0
                goto L21
            L2c:
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L21
            L2f:
                r5 = 0
                r7 = 0
            L31:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.o.K(int, int, int, int, boolean):int");
        }

        private int[] L(RecyclerView recyclerView, View view, Rect rect, boolean z10) {
            int[] iArr = new int[2];
            int e02 = e0();
            int g02 = g0();
            int o02 = o0() - f0();
            int W = W() - d0();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i10 = left - e02;
            int min = Math.min(0, i10);
            int i11 = top - g02;
            int min2 = Math.min(0, i11);
            int i12 = width - o02;
            int max = Math.max(0, i12);
            int max2 = Math.max(0, height - W);
            if (Z() != 1) {
                if (min == 0) {
                    min = Math.min(i10, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i12);
            }
            if (min2 == 0) {
                min2 = Math.min(i11, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        private void f(View view, int i10, boolean z10) {
            d0 g02 = RecyclerView.g0(view);
            if (z10 || g02.u()) {
                this.f3407b.f3316k.b(g02);
            } else {
                this.f3407b.f3316k.p(g02);
            }
            p pVar = (p) view.getLayoutParams();
            if (g02.K() || g02.v()) {
                if (g02.v()) {
                    g02.J();
                } else {
                    g02.e();
                }
                this.f3406a.c(view, i10, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f3407b) {
                int m10 = this.f3406a.m(view);
                if (i10 == -1) {
                    i10 = this.f3406a.g();
                }
                if (m10 == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f3407b.indexOfChild(view) + this.f3407b.R());
                }
                if (m10 != i10) {
                    this.f3407b.f3328q.B0(m10, i10);
                }
            } else {
                this.f3406a.a(view, i10, false);
                pVar.f3432c = true;
                z zVar = this.f3412g;
                if (zVar != null && zVar.h()) {
                    this.f3412g.k(view);
                }
            }
            if (pVar.f3433d) {
                g02.f3375a.invalidate();
                pVar.f3433d = false;
            }
        }

        public static d i0(Context context, AttributeSet attributeSet, int i10, int i11) {
            d dVar = new d();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o0.b.f12449a, i10, i11);
            dVar.f3426a = obtainStyledAttributes.getInt(o0.b.f12450b, 1);
            dVar.f3427b = obtainStyledAttributes.getInt(o0.b.f12459k, 1);
            dVar.f3428c = obtainStyledAttributes.getBoolean(o0.b.f12458j, false);
            dVar.f3429d = obtainStyledAttributes.getBoolean(o0.b.f12460l, false);
            obtainStyledAttributes.recycle();
            return dVar;
        }

        public static int n(int i10, int i11, int i12) {
            int mode = View.MeasureSpec.getMode(i10);
            int size = View.MeasureSpec.getSize(i10);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i11, i12) : size : Math.min(size, Math.max(i11, i12));
        }

        private boolean t0(RecyclerView recyclerView, int i10, int i11) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int e02 = e0();
            int g02 = g0();
            int o02 = o0() - f0();
            int W = W() - d0();
            Rect rect = this.f3407b.f3320m;
            P(focusedChild, rect);
            return rect.left - i10 < o02 && rect.right - i10 > e02 && rect.top - i11 < W && rect.bottom - i11 > g02;
        }

        private void v1(v vVar, int i10, View view) {
            d0 g02 = RecyclerView.g0(view);
            if (g02.I()) {
                return;
            }
            if (g02.s() && !g02.u() && !this.f3407b.f3326p.f()) {
                q1(i10);
                vVar.C(g02);
            } else {
                x(i10);
                vVar.D(view);
                this.f3407b.f3316k.k(g02);
            }
        }

        private static boolean w0(int i10, int i11, int i12) {
            int mode = View.MeasureSpec.getMode(i11);
            int size = View.MeasureSpec.getSize(i11);
            if (i12 > 0 && i10 != i12) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i10;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i10;
            }
            return true;
        }

        private void y(int i10, View view) {
            this.f3406a.d(i10);
        }

        void A(RecyclerView recyclerView, v vVar) {
            this.f3414i = false;
            I0(recyclerView, vVar);
        }

        public void A0(View view, int i10, int i11) {
            p pVar = (p) view.getLayoutParams();
            Rect k02 = this.f3407b.k0(view);
            int i12 = i10 + k02.left + k02.right;
            int i13 = i11 + k02.top + k02.bottom;
            int K = K(o0(), p0(), e0() + f0() + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin + i12, ((ViewGroup.MarginLayoutParams) pVar).width, k());
            int K2 = K(W(), X(), g0() + d0() + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin + i13, ((ViewGroup.MarginLayoutParams) pVar).height, l());
            if (F1(view, K, K2, pVar)) {
                view.measure(K, K2);
            }
        }

        void A1(int i10, int i11) {
            this.f3422q = View.MeasureSpec.getSize(i10);
            int mode = View.MeasureSpec.getMode(i10);
            this.f3420o = mode;
            if (mode == 0 && !RecyclerView.G0) {
                this.f3422q = 0;
            }
            this.f3423r = View.MeasureSpec.getSize(i11);
            int mode2 = View.MeasureSpec.getMode(i11);
            this.f3421p = mode2;
            if (mode2 != 0 || RecyclerView.G0) {
                return;
            }
            this.f3423r = 0;
        }

        public View B(View view) {
            View T;
            RecyclerView recyclerView = this.f3407b;
            if (recyclerView == null || (T = recyclerView.T(view)) == null || this.f3406a.n(T)) {
                return null;
            }
            return T;
        }

        public void B0(int i10, int i11) {
            View I = I(i10);
            if (I != null) {
                x(i10);
                h(I, i11);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i10 + this.f3407b.toString());
            }
        }

        public void B1(int i10, int i11) {
            this.f3407b.setMeasuredDimension(i10, i11);
        }

        public View C(int i10) {
            int J = J();
            for (int i11 = 0; i11 < J; i11++) {
                View I = I(i11);
                d0 g02 = RecyclerView.g0(I);
                if (g02 != null && g02.m() == i10 && !g02.I() && (this.f3407b.f3319l0.e() || !g02.u())) {
                    return I;
                }
            }
            return null;
        }

        public void C0(int i10) {
            RecyclerView recyclerView = this.f3407b;
            if (recyclerView != null) {
                recyclerView.B0(i10);
            }
        }

        public void C1(Rect rect, int i10, int i11) {
            B1(n(i10, rect.width() + e0() + f0(), c0()), n(i11, rect.height() + g0() + d0(), b0()));
        }

        public abstract p D();

        public void D0(int i10) {
            RecyclerView recyclerView = this.f3407b;
            if (recyclerView != null) {
                recyclerView.C0(i10);
            }
        }

        void D1(int i10, int i11) {
            int J = J();
            if (J == 0) {
                this.f3407b.x(i10, i11);
                return;
            }
            int i12 = Integer.MIN_VALUE;
            int i13 = Integer.MIN_VALUE;
            int i14 = Integer.MAX_VALUE;
            int i15 = Integer.MAX_VALUE;
            for (int i16 = 0; i16 < J; i16++) {
                View I = I(i16);
                Rect rect = this.f3407b.f3320m;
                P(I, rect);
                int i17 = rect.left;
                if (i17 < i14) {
                    i14 = i17;
                }
                int i18 = rect.right;
                if (i18 > i12) {
                    i12 = i18;
                }
                int i19 = rect.top;
                if (i19 < i15) {
                    i15 = i19;
                }
                int i20 = rect.bottom;
                if (i20 > i13) {
                    i13 = i20;
                }
            }
            this.f3407b.f3320m.set(i14, i15, i12, i13);
            C1(this.f3407b.f3320m, i10, i11);
        }

        public p E(Context context, AttributeSet attributeSet) {
            return new p(context, attributeSet);
        }

        public void E0(g gVar, g gVar2) {
        }

        void E1(RecyclerView recyclerView) {
            int height;
            if (recyclerView == null) {
                this.f3407b = null;
                this.f3406a = null;
                height = 0;
                this.f3422q = 0;
            } else {
                this.f3407b = recyclerView;
                this.f3406a = recyclerView.f3314j;
                this.f3422q = recyclerView.getWidth();
                height = recyclerView.getHeight();
            }
            this.f3423r = height;
            this.f3420o = 1073741824;
            this.f3421p = 1073741824;
        }

        public p F(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof p ? new p((p) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new p((ViewGroup.MarginLayoutParams) layoutParams) : new p(layoutParams);
        }

        public boolean F0(RecyclerView recyclerView, ArrayList<View> arrayList, int i10, int i11) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean F1(View view, int i10, int i11, p pVar) {
            return (!view.isLayoutRequested() && this.f3416k && w0(view.getWidth(), i10, ((ViewGroup.MarginLayoutParams) pVar).width) && w0(view.getHeight(), i11, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public int G() {
            return -1;
        }

        public void G0(RecyclerView recyclerView) {
        }

        boolean G1() {
            return false;
        }

        public int H(View view) {
            return ((p) view.getLayoutParams()).f3431b.bottom;
        }

        @Deprecated
        public void H0(RecyclerView recyclerView) {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean H1(View view, int i10, int i11, p pVar) {
            return (this.f3416k && w0(view.getMeasuredWidth(), i10, ((ViewGroup.MarginLayoutParams) pVar).width) && w0(view.getMeasuredHeight(), i11, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public View I(int i10) {
            androidx.recyclerview.widget.b bVar = this.f3406a;
            if (bVar != null) {
                return bVar.f(i10);
            }
            return null;
        }

        public void I0(RecyclerView recyclerView, v vVar) {
            H0(recyclerView);
        }

        public void I1(z zVar) {
            z zVar2 = this.f3412g;
            if (zVar2 != null && zVar != zVar2 && zVar2.h()) {
                this.f3412g.r();
            }
            this.f3412g = zVar;
            zVar.q(this.f3407b, this);
        }

        public int J() {
            androidx.recyclerview.widget.b bVar = this.f3406a;
            if (bVar != null) {
                return bVar.g();
            }
            return 0;
        }

        public View J0(View view, int i10, v vVar, a0 a0Var) {
            return null;
        }

        void J1() {
            z zVar = this.f3412g;
            if (zVar != null) {
                zVar.r();
            }
        }

        public void K0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f3407b;
            L0(recyclerView.f3308g, recyclerView.f3319l0, accessibilityEvent);
        }

        public boolean K1() {
            return false;
        }

        public void L0(v vVar, a0 a0Var, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f3407b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z10 = true;
            if (!recyclerView.canScrollVertically(1) && !this.f3407b.canScrollVertically(-1) && !this.f3407b.canScrollHorizontally(-1) && !this.f3407b.canScrollHorizontally(1)) {
                z10 = false;
            }
            accessibilityEvent.setScrollable(z10);
            g gVar = this.f3407b.f3326p;
            if (gVar != null) {
                accessibilityEvent.setItemCount(gVar.c());
            }
        }

        public boolean M() {
            RecyclerView recyclerView = this.f3407b;
            return recyclerView != null && recyclerView.f3318l;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void M0(androidx.core.view.accessibility.d dVar) {
            RecyclerView recyclerView = this.f3407b;
            N0(recyclerView.f3308g, recyclerView.f3319l0, dVar);
        }

        public int N(v vVar, a0 a0Var) {
            RecyclerView recyclerView = this.f3407b;
            if (recyclerView == null || recyclerView.f3326p == null || !k()) {
                return 1;
            }
            return this.f3407b.f3326p.c();
        }

        public void N0(v vVar, a0 a0Var, androidx.core.view.accessibility.d dVar) {
            if (this.f3407b.canScrollVertically(-1) || this.f3407b.canScrollHorizontally(-1)) {
                dVar.a(8192);
                dVar.m0(true);
            }
            if (this.f3407b.canScrollVertically(1) || this.f3407b.canScrollHorizontally(1)) {
                dVar.a(4096);
                dVar.m0(true);
            }
            dVar.X(d.b.a(k0(vVar, a0Var), N(vVar, a0Var), v0(vVar, a0Var), l0(vVar, a0Var)));
        }

        public int O(View view) {
            return view.getBottom() + H(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void O0(View view, androidx.core.view.accessibility.d dVar) {
            d0 g02 = RecyclerView.g0(view);
            if (g02 == null || g02.u() || this.f3406a.n(g02.f3375a)) {
                return;
            }
            RecyclerView recyclerView = this.f3407b;
            P0(recyclerView.f3308g, recyclerView.f3319l0, view, dVar);
        }

        public void P(View view, Rect rect) {
            RecyclerView.h0(view, rect);
        }

        public void P0(v vVar, a0 a0Var, View view, androidx.core.view.accessibility.d dVar) {
            dVar.Y(d.c.a(l() ? h0(view) : 0, 1, k() ? h0(view) : 0, 1, false, false));
        }

        public int Q(View view) {
            return view.getLeft() - a0(view);
        }

        public View Q0(View view, int i10) {
            return null;
        }

        public int R(View view) {
            Rect rect = ((p) view.getLayoutParams()).f3431b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void R0(RecyclerView recyclerView, int i10, int i11) {
        }

        public int S(View view) {
            Rect rect = ((p) view.getLayoutParams()).f3431b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void S0(RecyclerView recyclerView) {
        }

        public int T(View view) {
            return view.getRight() + j0(view);
        }

        public void T0(RecyclerView recyclerView, int i10, int i11, int i12) {
        }

        public int U(View view) {
            return view.getTop() - m0(view);
        }

        public void U0(RecyclerView recyclerView, int i10, int i11) {
        }

        public View V() {
            View focusedChild;
            RecyclerView recyclerView = this.f3407b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f3406a.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void V0(RecyclerView recyclerView, int i10, int i11) {
        }

        public int W() {
            return this.f3423r;
        }

        public void W0(RecyclerView recyclerView, int i10, int i11, Object obj) {
            V0(recyclerView, i10, i11);
        }

        public int X() {
            return this.f3421p;
        }

        public void X0(v vVar, a0 a0Var) {
        }

        public int Y() {
            RecyclerView recyclerView = this.f3407b;
            g adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.c();
            }
            return 0;
        }

        public void Y0(a0 a0Var) {
        }

        public int Z() {
            return androidx.core.view.a0.z(this.f3407b);
        }

        public void Z0(v vVar, a0 a0Var, int i10, int i11) {
            this.f3407b.x(i10, i11);
        }

        public int a0(View view) {
            return ((p) view.getLayoutParams()).f3431b.left;
        }

        @Deprecated
        public boolean a1(RecyclerView recyclerView, View view, View view2) {
            return x0() || recyclerView.w0();
        }

        public void b(View view) {
            c(view, -1);
        }

        public int b0() {
            return androidx.core.view.a0.A(this.f3407b);
        }

        public boolean b1(RecyclerView recyclerView, a0 a0Var, View view, View view2) {
            return a1(recyclerView, view, view2);
        }

        public void c(View view, int i10) {
            f(view, i10, true);
        }

        public int c0() {
            return androidx.core.view.a0.B(this.f3407b);
        }

        public void c1(Parcelable parcelable) {
        }

        public void d(View view) {
            e(view, -1);
        }

        public int d0() {
            RecyclerView recyclerView = this.f3407b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public Parcelable d1() {
            return null;
        }

        public void e(View view, int i10) {
            f(view, i10, false);
        }

        public int e0() {
            RecyclerView recyclerView = this.f3407b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public void e1(int i10) {
        }

        public int f0() {
            RecyclerView recyclerView = this.f3407b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        void f1(z zVar) {
            if (this.f3412g == zVar) {
                this.f3412g = null;
            }
        }

        public void g(String str) {
            RecyclerView recyclerView = this.f3407b;
            if (recyclerView != null) {
                recyclerView.p(str);
            }
        }

        public int g0() {
            RecyclerView recyclerView = this.f3407b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean g1(int i10, Bundle bundle) {
            RecyclerView recyclerView = this.f3407b;
            return h1(recyclerView.f3308g, recyclerView.f3319l0, i10, bundle);
        }

        public void h(View view, int i10) {
            i(view, i10, (p) view.getLayoutParams());
        }

        public int h0(View view) {
            return ((p) view.getLayoutParams()).a();
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0070 A[ADDED_TO_REGION] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean h1(androidx.recyclerview.widget.RecyclerView.v r2, androidx.recyclerview.widget.RecyclerView.a0 r3, int r4, android.os.Bundle r5) {
            /*
                r1 = this;
                androidx.recyclerview.widget.RecyclerView r2 = r1.f3407b
                r3 = 0
                if (r2 != 0) goto L6
                return r3
            L6:
                r5 = 4096(0x1000, float:5.74E-42)
                r0 = 1
                if (r4 == r5) goto L42
                r5 = 8192(0x2000, float:1.14794E-41)
                if (r4 == r5) goto L12
                r2 = 0
            L10:
                r4 = 0
                goto L6e
            L12:
                r4 = -1
                boolean r2 = r2.canScrollVertically(r4)
                if (r2 == 0) goto L29
                int r2 = r1.W()
                int r5 = r1.g0()
                int r2 = r2 - r5
                int r5 = r1.d0()
                int r2 = r2 - r5
                int r2 = -r2
                goto L2a
            L29:
                r2 = 0
            L2a:
                androidx.recyclerview.widget.RecyclerView r5 = r1.f3407b
                boolean r4 = r5.canScrollHorizontally(r4)
                if (r4 == 0) goto L10
                int r4 = r1.o0()
                int r5 = r1.e0()
                int r4 = r4 - r5
                int r5 = r1.f0()
                int r4 = r4 - r5
                int r4 = -r4
                goto L6e
            L42:
                boolean r2 = r2.canScrollVertically(r0)
                if (r2 == 0) goto L57
                int r2 = r1.W()
                int r4 = r1.g0()
                int r2 = r2 - r4
                int r4 = r1.d0()
                int r2 = r2 - r4
                goto L58
            L57:
                r2 = 0
            L58:
                androidx.recyclerview.widget.RecyclerView r4 = r1.f3407b
                boolean r4 = r4.canScrollHorizontally(r0)
                if (r4 == 0) goto L10
                int r4 = r1.o0()
                int r5 = r1.e0()
                int r4 = r4 - r5
                int r5 = r1.f0()
                int r4 = r4 - r5
            L6e:
                if (r2 != 0) goto L73
                if (r4 != 0) goto L73
                return r3
            L73:
                androidx.recyclerview.widget.RecyclerView r3 = r1.f3407b
                r3.m1(r4, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.o.h1(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0, int, android.os.Bundle):boolean");
        }

        public void i(View view, int i10, p pVar) {
            d0 g02 = RecyclerView.g0(view);
            if (g02.u()) {
                this.f3407b.f3316k.b(g02);
            } else {
                this.f3407b.f3316k.p(g02);
            }
            this.f3406a.c(view, i10, pVar, g02.u());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean i1(View view, int i10, Bundle bundle) {
            RecyclerView recyclerView = this.f3407b;
            return j1(recyclerView.f3308g, recyclerView.f3319l0, view, i10, bundle);
        }

        public void j(View view, Rect rect) {
            RecyclerView recyclerView = this.f3407b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.k0(view));
            }
        }

        public int j0(View view) {
            return ((p) view.getLayoutParams()).f3431b.right;
        }

        public boolean j1(v vVar, a0 a0Var, View view, int i10, Bundle bundle) {
            return false;
        }

        public boolean k() {
            return false;
        }

        public int k0(v vVar, a0 a0Var) {
            RecyclerView recyclerView = this.f3407b;
            if (recyclerView == null || recyclerView.f3326p == null || !l()) {
                return 1;
            }
            return this.f3407b.f3326p.c();
        }

        public void k1(v vVar) {
            for (int J = J() - 1; J >= 0; J--) {
                if (!RecyclerView.g0(I(J)).I()) {
                    n1(J, vVar);
                }
            }
        }

        public boolean l() {
            return false;
        }

        public int l0(v vVar, a0 a0Var) {
            return 0;
        }

        void l1(v vVar) {
            int j10 = vVar.j();
            for (int i10 = j10 - 1; i10 >= 0; i10--) {
                View n10 = vVar.n(i10);
                d0 g02 = RecyclerView.g0(n10);
                if (!g02.I()) {
                    g02.F(false);
                    if (g02.w()) {
                        this.f3407b.removeDetachedView(n10, false);
                    }
                    l lVar = this.f3407b.Q;
                    if (lVar != null) {
                        lVar.j(g02);
                    }
                    g02.F(true);
                    vVar.y(n10);
                }
            }
            vVar.e();
            if (j10 > 0) {
                this.f3407b.invalidate();
            }
        }

        public boolean m(p pVar) {
            return pVar != null;
        }

        public int m0(View view) {
            return ((p) view.getLayoutParams()).f3431b.top;
        }

        public void m1(View view, v vVar) {
            p1(view);
            vVar.B(view);
        }

        public void n0(View view, boolean z10, Rect rect) {
            Matrix matrix;
            if (z10) {
                Rect rect2 = ((p) view.getLayoutParams()).f3431b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f3407b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f3407b.f3324o;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void n1(int i10, v vVar) {
            View I = I(i10);
            q1(i10);
            vVar.B(I);
        }

        public void o(int i10, int i11, a0 a0Var, c cVar) {
        }

        public int o0() {
            return this.f3422q;
        }

        public boolean o1(Runnable runnable) {
            RecyclerView recyclerView = this.f3407b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void p(int i10, c cVar) {
        }

        public int p0() {
            return this.f3420o;
        }

        public void p1(View view) {
            this.f3406a.p(view);
        }

        public int q(a0 a0Var) {
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean q0() {
            int J = J();
            for (int i10 = 0; i10 < J; i10++) {
                ViewGroup.LayoutParams layoutParams = I(i10).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public void q1(int i10) {
            if (I(i10) != null) {
                this.f3406a.q(i10);
            }
        }

        public int r(a0 a0Var) {
            return 0;
        }

        public boolean r0() {
            return this.f3414i;
        }

        public boolean r1(RecyclerView recyclerView, View view, Rect rect, boolean z10) {
            return s1(recyclerView, view, rect, z10, false);
        }

        public int s(a0 a0Var) {
            return 0;
        }

        public boolean s0() {
            return this.f3415j;
        }

        public boolean s1(RecyclerView recyclerView, View view, Rect rect, boolean z10, boolean z11) {
            int[] L = L(recyclerView, view, rect, z10);
            int i10 = L[0];
            int i11 = L[1];
            if ((z11 && !t0(recyclerView, i10, i11)) || (i10 == 0 && i11 == 0)) {
                return false;
            }
            if (z10) {
                recyclerView.scrollBy(i10, i11);
            } else {
                recyclerView.m1(i10, i11);
            }
            return true;
        }

        public int t(a0 a0Var) {
            return 0;
        }

        public void t1() {
            RecyclerView recyclerView = this.f3407b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int u(a0 a0Var) {
            return 0;
        }

        public final boolean u0() {
            return this.f3417l;
        }

        public void u1() {
            this.f3413h = true;
        }

        public int v(a0 a0Var) {
            return 0;
        }

        public boolean v0(v vVar, a0 a0Var) {
            return false;
        }

        public void w(v vVar) {
            for (int J = J() - 1; J >= 0; J--) {
                v1(vVar, J, I(J));
            }
        }

        public int w1(int i10, v vVar, a0 a0Var) {
            return 0;
        }

        public void x(int i10) {
            y(i10, I(i10));
        }

        public boolean x0() {
            z zVar = this.f3412g;
            return zVar != null && zVar.h();
        }

        public void x1(int i10) {
        }

        public boolean y0(View view, boolean z10, boolean z11) {
            boolean z12 = this.f3410e.b(view, 24579) && this.f3411f.b(view, 24579);
            return z10 ? z12 : !z12;
        }

        public int y1(int i10, v vVar, a0 a0Var) {
            return 0;
        }

        void z(RecyclerView recyclerView) {
            this.f3414i = true;
            G0(recyclerView);
        }

        public void z0(View view, int i10, int i11, int i12, int i13) {
            p pVar = (p) view.getLayoutParams();
            Rect rect = pVar.f3431b;
            view.layout(i10 + rect.left + ((ViewGroup.MarginLayoutParams) pVar).leftMargin, i11 + rect.top + ((ViewGroup.MarginLayoutParams) pVar).topMargin, (i12 - rect.right) - ((ViewGroup.MarginLayoutParams) pVar).rightMargin, (i13 - rect.bottom) - ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
        }

        void z1(RecyclerView recyclerView) {
            A1(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }
    }

    /* loaded from: classes.dex */
    public static class p extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        d0 f3430a;

        /* renamed from: b, reason: collision with root package name */
        final Rect f3431b;

        /* renamed from: c, reason: collision with root package name */
        boolean f3432c;

        /* renamed from: d, reason: collision with root package name */
        boolean f3433d;

        public p(int i10, int i11) {
            super(i10, i11);
            this.f3431b = new Rect();
            this.f3432c = true;
            this.f3433d = false;
        }

        public p(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3431b = new Rect();
            this.f3432c = true;
            this.f3433d = false;
        }

        public p(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3431b = new Rect();
            this.f3432c = true;
            this.f3433d = false;
        }

        public p(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f3431b = new Rect();
            this.f3432c = true;
            this.f3433d = false;
        }

        public p(p pVar) {
            super((ViewGroup.LayoutParams) pVar);
            this.f3431b = new Rect();
            this.f3432c = true;
            this.f3433d = false;
        }

        public int a() {
            return this.f3430a.m();
        }

        public boolean b() {
            return this.f3430a.x();
        }

        public boolean c() {
            return this.f3430a.u();
        }

        public boolean d() {
            return this.f3430a.s();
        }
    }

    /* loaded from: classes.dex */
    public interface q {
        void a(View view);

        void b(View view);
    }

    /* loaded from: classes.dex */
    public static abstract class r {
        public abstract boolean a(int i10, int i11);
    }

    /* loaded from: classes.dex */
    public interface s {
        boolean a(RecyclerView recyclerView, MotionEvent motionEvent);

        void b(RecyclerView recyclerView, MotionEvent motionEvent);

        void c(boolean z10);
    }

    /* loaded from: classes.dex */
    public static abstract class t {
        public void a(RecyclerView recyclerView, int i10) {
        }

        public void b(RecyclerView recyclerView, int i10, int i11) {
        }
    }

    /* loaded from: classes.dex */
    public static class u {

        /* renamed from: a, reason: collision with root package name */
        SparseArray<a> f3434a = new SparseArray<>();

        /* renamed from: b, reason: collision with root package name */
        private int f3435b = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            final ArrayList<d0> f3436a = new ArrayList<>();

            /* renamed from: b, reason: collision with root package name */
            int f3437b = 5;

            /* renamed from: c, reason: collision with root package name */
            long f3438c = 0;

            /* renamed from: d, reason: collision with root package name */
            long f3439d = 0;

            a() {
            }
        }

        private a g(int i10) {
            a aVar = this.f3434a.get(i10);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f3434a.put(i10, aVar2);
            return aVar2;
        }

        void a() {
            this.f3435b++;
        }

        public void b() {
            for (int i10 = 0; i10 < this.f3434a.size(); i10++) {
                this.f3434a.valueAt(i10).f3436a.clear();
            }
        }

        void c() {
            this.f3435b--;
        }

        void d(int i10, long j10) {
            a g10 = g(i10);
            g10.f3439d = j(g10.f3439d, j10);
        }

        void e(int i10, long j10) {
            a g10 = g(i10);
            g10.f3438c = j(g10.f3438c, j10);
        }

        public d0 f(int i10) {
            a aVar = this.f3434a.get(i10);
            if (aVar == null || aVar.f3436a.isEmpty()) {
                return null;
            }
            return aVar.f3436a.remove(r2.size() - 1);
        }

        void h(g gVar, g gVar2, boolean z10) {
            if (gVar != null) {
                c();
            }
            if (!z10 && this.f3435b == 0) {
                b();
            }
            if (gVar2 != null) {
                a();
            }
        }

        public void i(d0 d0Var) {
            int l10 = d0Var.l();
            ArrayList<d0> arrayList = g(l10).f3436a;
            if (this.f3434a.get(l10).f3437b <= arrayList.size()) {
                return;
            }
            d0Var.C();
            arrayList.add(d0Var);
        }

        long j(long j10, long j11) {
            return j10 == 0 ? j11 : ((j10 / 4) * 3) + (j11 / 4);
        }

        boolean k(int i10, long j10, long j11) {
            long j12 = g(i10).f3439d;
            return j12 == 0 || j10 + j12 < j11;
        }

        boolean l(int i10, long j10, long j11) {
            long j12 = g(i10).f3438c;
            return j12 == 0 || j10 + j12 < j11;
        }
    }

    /* loaded from: classes.dex */
    public final class v {

        /* renamed from: a, reason: collision with root package name */
        final ArrayList<d0> f3440a;

        /* renamed from: b, reason: collision with root package name */
        ArrayList<d0> f3441b;

        /* renamed from: c, reason: collision with root package name */
        final ArrayList<d0> f3442c;

        /* renamed from: d, reason: collision with root package name */
        private final List<d0> f3443d;

        /* renamed from: e, reason: collision with root package name */
        private int f3444e;

        /* renamed from: f, reason: collision with root package name */
        int f3445f;

        /* renamed from: g, reason: collision with root package name */
        u f3446g;

        public v() {
            ArrayList<d0> arrayList = new ArrayList<>();
            this.f3440a = arrayList;
            this.f3441b = null;
            this.f3442c = new ArrayList<>();
            this.f3443d = Collections.unmodifiableList(arrayList);
            this.f3444e = 2;
            this.f3445f = 2;
        }

        private boolean H(d0 d0Var, int i10, int i11, long j10) {
            d0Var.f3392r = RecyclerView.this;
            int l10 = d0Var.l();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j10 != Long.MAX_VALUE && !this.f3446g.k(l10, nanoTime, j10)) {
                return false;
            }
            RecyclerView.this.f3326p.a(d0Var, i10);
            this.f3446g.d(d0Var.l(), RecyclerView.this.getNanoTime() - nanoTime);
            b(d0Var);
            if (!RecyclerView.this.f3319l0.e()) {
                return true;
            }
            d0Var.f3381g = i11;
            return true;
        }

        private void b(d0 d0Var) {
            if (RecyclerView.this.v0()) {
                View view = d0Var.f3375a;
                if (androidx.core.view.a0.x(view) == 0) {
                    androidx.core.view.a0.u0(view, 1);
                }
                if (androidx.core.view.a0.M(view)) {
                    return;
                }
                d0Var.b(16384);
                androidx.core.view.a0.j0(view, RecyclerView.this.f3333s0.n());
            }
        }

        private void q(ViewGroup viewGroup, boolean z10) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    q((ViewGroup) childAt, true);
                }
            }
            if (z10) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        private void r(d0 d0Var) {
            View view = d0Var.f3375a;
            if (view instanceof ViewGroup) {
                q((ViewGroup) view, false);
            }
        }

        void A(int i10) {
            a(this.f3442c.get(i10), true);
            this.f3442c.remove(i10);
        }

        public void B(View view) {
            d0 g02 = RecyclerView.g0(view);
            if (g02.w()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (g02.v()) {
                g02.J();
            } else if (g02.K()) {
                g02.e();
            }
            C(g02);
        }

        void C(d0 d0Var) {
            boolean z10;
            boolean z11 = true;
            if (d0Var.v() || d0Var.f3375a.getParent() != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Scrapped or attached views may not be recycled. isScrap:");
                sb2.append(d0Var.v());
                sb2.append(" isAttached:");
                sb2.append(d0Var.f3375a.getParent() != null);
                sb2.append(RecyclerView.this.R());
                throw new IllegalArgumentException(sb2.toString());
            }
            if (d0Var.w()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + d0Var + RecyclerView.this.R());
            }
            if (d0Var.I()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.R());
            }
            boolean h10 = d0Var.h();
            g gVar = RecyclerView.this.f3326p;
            if ((gVar != null && h10 && gVar.m(d0Var)) || d0Var.t()) {
                if (this.f3445f <= 0 || d0Var.p(526)) {
                    z10 = false;
                } else {
                    int size = this.f3442c.size();
                    if (size >= this.f3445f && size > 0) {
                        A(0);
                        size--;
                    }
                    if (RecyclerView.H0 && size > 0 && !RecyclerView.this.f3317k0.d(d0Var.f3377c)) {
                        int i10 = size - 1;
                        while (i10 >= 0) {
                            if (!RecyclerView.this.f3317k0.d(this.f3442c.get(i10).f3377c)) {
                                break;
                            } else {
                                i10--;
                            }
                        }
                        size = i10 + 1;
                    }
                    this.f3442c.add(size, d0Var);
                    z10 = true;
                }
                if (!z10) {
                    a(d0Var, true);
                    r1 = z10;
                    RecyclerView.this.f3316k.q(d0Var);
                    if (r1 && !z11 && h10) {
                        d0Var.f3392r = null;
                        return;
                    }
                    return;
                }
                r1 = z10;
            }
            z11 = false;
            RecyclerView.this.f3316k.q(d0Var);
            if (r1) {
            }
        }

        void D(View view) {
            ArrayList<d0> arrayList;
            d0 g02 = RecyclerView.g0(view);
            if (!g02.p(12) && g02.x() && !RecyclerView.this.q(g02)) {
                if (this.f3441b == null) {
                    this.f3441b = new ArrayList<>();
                }
                g02.G(this, true);
                arrayList = this.f3441b;
            } else {
                if (g02.s() && !g02.u() && !RecyclerView.this.f3326p.f()) {
                    throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.R());
                }
                g02.G(this, false);
                arrayList = this.f3440a;
            }
            arrayList.add(g02);
        }

        void E(u uVar) {
            u uVar2 = this.f3446g;
            if (uVar2 != null) {
                uVar2.c();
            }
            this.f3446g = uVar;
            if (uVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.f3446g.a();
        }

        void F(b0 b0Var) {
        }

        public void G(int i10) {
            this.f3444e = i10;
            K();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0135  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0152  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0175  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x01ae  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x01d1 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:80:0x01bc  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x0184  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public androidx.recyclerview.widget.RecyclerView.d0 I(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 528
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.v.I(int, boolean, long):androidx.recyclerview.widget.RecyclerView$d0");
        }

        void J(d0 d0Var) {
            (d0Var.f3389o ? this.f3441b : this.f3440a).remove(d0Var);
            d0Var.f3388n = null;
            d0Var.f3389o = false;
            d0Var.e();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void K() {
            o oVar = RecyclerView.this.f3328q;
            this.f3445f = this.f3444e + (oVar != null ? oVar.f3418m : 0);
            for (int size = this.f3442c.size() - 1; size >= 0 && this.f3442c.size() > this.f3445f; size--) {
                A(size);
            }
        }

        boolean L(d0 d0Var) {
            if (d0Var.u()) {
                return RecyclerView.this.f3319l0.e();
            }
            int i10 = d0Var.f3377c;
            if (i10 >= 0 && i10 < RecyclerView.this.f3326p.c()) {
                if (RecyclerView.this.f3319l0.e() || RecyclerView.this.f3326p.e(d0Var.f3377c) == d0Var.l()) {
                    return !RecyclerView.this.f3326p.f() || d0Var.k() == RecyclerView.this.f3326p.d(d0Var.f3377c);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + d0Var + RecyclerView.this.R());
        }

        void M(int i10, int i11) {
            int i12;
            int i13 = i11 + i10;
            for (int size = this.f3442c.size() - 1; size >= 0; size--) {
                d0 d0Var = this.f3442c.get(size);
                if (d0Var != null && (i12 = d0Var.f3377c) >= i10 && i12 < i13) {
                    d0Var.b(2);
                    A(size);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(d0 d0Var, boolean z10) {
            RecyclerView.s(d0Var);
            if (d0Var.p(16384)) {
                d0Var.E(0, 16384);
                androidx.core.view.a0.j0(d0Var.f3375a, null);
            }
            if (z10) {
                g(d0Var);
            }
            d0Var.f3392r = null;
            i().i(d0Var);
        }

        public void c() {
            this.f3440a.clear();
            z();
        }

        void d() {
            int size = this.f3442c.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f3442c.get(i10).c();
            }
            int size2 = this.f3440a.size();
            for (int i11 = 0; i11 < size2; i11++) {
                this.f3440a.get(i11).c();
            }
            ArrayList<d0> arrayList = this.f3441b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i12 = 0; i12 < size3; i12++) {
                    this.f3441b.get(i12).c();
                }
            }
        }

        void e() {
            this.f3440a.clear();
            ArrayList<d0> arrayList = this.f3441b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int f(int i10) {
            if (i10 >= 0 && i10 < RecyclerView.this.f3319l0.b()) {
                return !RecyclerView.this.f3319l0.e() ? i10 : RecyclerView.this.f3312i.m(i10);
            }
            throw new IndexOutOfBoundsException("invalid position " + i10 + ". State item count is " + RecyclerView.this.f3319l0.b() + RecyclerView.this.R());
        }

        void g(d0 d0Var) {
            w wVar = RecyclerView.this.f3330r;
            if (wVar != null) {
                wVar.a(d0Var);
            }
            g gVar = RecyclerView.this.f3326p;
            if (gVar != null) {
                gVar.p(d0Var);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f3319l0 != null) {
                recyclerView.f3316k.q(d0Var);
            }
        }

        d0 h(int i10) {
            int size;
            int m10;
            ArrayList<d0> arrayList = this.f3441b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i11 = 0; i11 < size; i11++) {
                    d0 d0Var = this.f3441b.get(i11);
                    if (!d0Var.K() && d0Var.m() == i10) {
                        d0Var.b(32);
                        return d0Var;
                    }
                }
                if (RecyclerView.this.f3326p.f() && (m10 = RecyclerView.this.f3312i.m(i10)) > 0 && m10 < RecyclerView.this.f3326p.c()) {
                    long d10 = RecyclerView.this.f3326p.d(m10);
                    for (int i12 = 0; i12 < size; i12++) {
                        d0 d0Var2 = this.f3441b.get(i12);
                        if (!d0Var2.K() && d0Var2.k() == d10) {
                            d0Var2.b(32);
                            return d0Var2;
                        }
                    }
                }
            }
            return null;
        }

        u i() {
            if (this.f3446g == null) {
                this.f3446g = new u();
            }
            return this.f3446g;
        }

        int j() {
            return this.f3440a.size();
        }

        public List<d0> k() {
            return this.f3443d;
        }

        d0 l(long j10, int i10, boolean z10) {
            for (int size = this.f3440a.size() - 1; size >= 0; size--) {
                d0 d0Var = this.f3440a.get(size);
                if (d0Var.k() == j10 && !d0Var.K()) {
                    if (i10 == d0Var.l()) {
                        d0Var.b(32);
                        if (d0Var.u() && !RecyclerView.this.f3319l0.e()) {
                            d0Var.E(2, 14);
                        }
                        return d0Var;
                    }
                    if (!z10) {
                        this.f3440a.remove(size);
                        RecyclerView.this.removeDetachedView(d0Var.f3375a, false);
                        y(d0Var.f3375a);
                    }
                }
            }
            int size2 = this.f3442c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                d0 d0Var2 = this.f3442c.get(size2);
                if (d0Var2.k() == j10) {
                    if (i10 == d0Var2.l()) {
                        if (!z10) {
                            this.f3442c.remove(size2);
                        }
                        return d0Var2;
                    }
                    if (!z10) {
                        A(size2);
                        return null;
                    }
                }
            }
        }

        d0 m(int i10, boolean z10) {
            View e10;
            int size = this.f3440a.size();
            for (int i11 = 0; i11 < size; i11++) {
                d0 d0Var = this.f3440a.get(i11);
                if (!d0Var.K() && d0Var.m() == i10 && !d0Var.s() && (RecyclerView.this.f3319l0.f3356h || !d0Var.u())) {
                    d0Var.b(32);
                    return d0Var;
                }
            }
            if (z10 || (e10 = RecyclerView.this.f3314j.e(i10)) == null) {
                int size2 = this.f3442c.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    d0 d0Var2 = this.f3442c.get(i12);
                    if (!d0Var2.s() && d0Var2.m() == i10) {
                        if (!z10) {
                            this.f3442c.remove(i12);
                        }
                        return d0Var2;
                    }
                }
                return null;
            }
            d0 g02 = RecyclerView.g0(e10);
            RecyclerView.this.f3314j.s(e10);
            int m10 = RecyclerView.this.f3314j.m(e10);
            if (m10 != -1) {
                RecyclerView.this.f3314j.d(m10);
                D(e10);
                g02.b(8224);
                return g02;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + g02 + RecyclerView.this.R());
        }

        View n(int i10) {
            return this.f3440a.get(i10).f3375a;
        }

        public View o(int i10) {
            return p(i10, false);
        }

        View p(int i10, boolean z10) {
            return I(i10, z10, Long.MAX_VALUE).f3375a;
        }

        void s() {
            int size = this.f3442c.size();
            for (int i10 = 0; i10 < size; i10++) {
                p pVar = (p) this.f3442c.get(i10).f3375a.getLayoutParams();
                if (pVar != null) {
                    pVar.f3432c = true;
                }
            }
        }

        void t() {
            int size = this.f3442c.size();
            for (int i10 = 0; i10 < size; i10++) {
                d0 d0Var = this.f3442c.get(i10);
                if (d0Var != null) {
                    d0Var.b(6);
                    d0Var.a(null);
                }
            }
            g gVar = RecyclerView.this.f3326p;
            if (gVar == null || !gVar.f()) {
                z();
            }
        }

        void u(int i10, int i11) {
            int size = this.f3442c.size();
            for (int i12 = 0; i12 < size; i12++) {
                d0 d0Var = this.f3442c.get(i12);
                if (d0Var != null && d0Var.f3377c >= i10) {
                    d0Var.z(i11, true);
                }
            }
        }

        void v(int i10, int i11) {
            int i12;
            int i13;
            int i14;
            int i15;
            if (i10 < i11) {
                i12 = -1;
                i14 = i10;
                i13 = i11;
            } else {
                i12 = 1;
                i13 = i10;
                i14 = i11;
            }
            int size = this.f3442c.size();
            for (int i16 = 0; i16 < size; i16++) {
                d0 d0Var = this.f3442c.get(i16);
                if (d0Var != null && (i15 = d0Var.f3377c) >= i14 && i15 <= i13) {
                    if (i15 == i10) {
                        d0Var.z(i11 - i10, false);
                    } else {
                        d0Var.z(i12, false);
                    }
                }
            }
        }

        void w(int i10, int i11, boolean z10) {
            int i12 = i10 + i11;
            for (int size = this.f3442c.size() - 1; size >= 0; size--) {
                d0 d0Var = this.f3442c.get(size);
                if (d0Var != null) {
                    int i13 = d0Var.f3377c;
                    if (i13 >= i12) {
                        d0Var.z(-i11, z10);
                    } else if (i13 >= i10) {
                        d0Var.b(8);
                        A(size);
                    }
                }
            }
        }

        void x(g gVar, g gVar2, boolean z10) {
            c();
            i().h(gVar, gVar2, z10);
        }

        void y(View view) {
            d0 g02 = RecyclerView.g0(view);
            g02.f3388n = null;
            g02.f3389o = false;
            g02.e();
            C(g02);
        }

        void z() {
            for (int size = this.f3442c.size() - 1; size >= 0; size--) {
                A(size);
            }
            this.f3442c.clear();
            if (RecyclerView.H0) {
                RecyclerView.this.f3317k0.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface w {
        void a(d0 d0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class x extends i {
        x() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            RecyclerView.this.p(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f3319l0.f3355g = true;
            recyclerView.R0(true);
            if (RecyclerView.this.f3312i.p()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    public static class y extends y.a {
        public static final Parcelable.Creator<y> CREATOR = new a();

        /* renamed from: h, reason: collision with root package name */
        Parcelable f3449h;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<y> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public y createFromParcel(Parcel parcel) {
                return new y(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public y createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new y(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public y[] newArray(int i10) {
                return new y[i10];
            }
        }

        y(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3449h = parcel.readParcelable(classLoader == null ? o.class.getClassLoader() : classLoader);
        }

        y(Parcelable parcelable) {
            super(parcelable);
        }

        void b(y yVar) {
            this.f3449h = yVar.f3449h;
        }

        @Override // y.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeParcelable(this.f3449h, 0);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class z {

        /* renamed from: b, reason: collision with root package name */
        private RecyclerView f3451b;

        /* renamed from: c, reason: collision with root package name */
        private o f3452c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f3453d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f3454e;

        /* renamed from: f, reason: collision with root package name */
        private View f3455f;

        /* renamed from: h, reason: collision with root package name */
        private boolean f3457h;

        /* renamed from: a, reason: collision with root package name */
        private int f3450a = -1;

        /* renamed from: g, reason: collision with root package name */
        private final a f3456g = new a(0, 0);

        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            private int f3458a;

            /* renamed from: b, reason: collision with root package name */
            private int f3459b;

            /* renamed from: c, reason: collision with root package name */
            private int f3460c;

            /* renamed from: d, reason: collision with root package name */
            private int f3461d;

            /* renamed from: e, reason: collision with root package name */
            private Interpolator f3462e;

            /* renamed from: f, reason: collision with root package name */
            private boolean f3463f;

            /* renamed from: g, reason: collision with root package name */
            private int f3464g;

            public a(int i10, int i11) {
                this(i10, i11, Integer.MIN_VALUE, null);
            }

            public a(int i10, int i11, int i12, Interpolator interpolator) {
                this.f3461d = -1;
                this.f3463f = false;
                this.f3464g = 0;
                this.f3458a = i10;
                this.f3459b = i11;
                this.f3460c = i12;
                this.f3462e = interpolator;
            }

            private void e() {
                if (this.f3462e != null && this.f3460c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.f3460c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            boolean a() {
                return this.f3461d >= 0;
            }

            public void b(int i10) {
                this.f3461d = i10;
            }

            void c(RecyclerView recyclerView) {
                int i10 = this.f3461d;
                if (i10 >= 0) {
                    this.f3461d = -1;
                    recyclerView.y0(i10);
                    this.f3463f = false;
                } else {
                    if (!this.f3463f) {
                        this.f3464g = 0;
                        return;
                    }
                    e();
                    Interpolator interpolator = this.f3462e;
                    if (interpolator == null) {
                        int i11 = this.f3460c;
                        c0 c0Var = recyclerView.f3313i0;
                        if (i11 == Integer.MIN_VALUE) {
                            c0Var.g(this.f3458a, this.f3459b);
                        } else {
                            c0Var.h(this.f3458a, this.f3459b, i11);
                        }
                    } else {
                        recyclerView.f3313i0.j(this.f3458a, this.f3459b, this.f3460c, interpolator);
                    }
                    this.f3464g++;
                    this.f3463f = false;
                }
            }

            public void d(int i10, int i11, int i12, Interpolator interpolator) {
                this.f3458a = i10;
                this.f3459b = i11;
                this.f3460c = i12;
                this.f3462e = interpolator;
                this.f3463f = true;
            }
        }

        /* loaded from: classes.dex */
        public interface b {
            PointF a(int i10);
        }

        public PointF a(int i10) {
            Object e10 = e();
            if (e10 instanceof b) {
                return ((b) e10).a(i10);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
            sb2.append(b.class.getCanonicalName());
            return null;
        }

        public View b(int i10) {
            return this.f3451b.f3328q.C(i10);
        }

        public int c() {
            return this.f3451b.f3328q.J();
        }

        public int d(View view) {
            return this.f3451b.e0(view);
        }

        public o e() {
            return this.f3452c;
        }

        public int f() {
            return this.f3450a;
        }

        public boolean g() {
            return this.f3453d;
        }

        public boolean h() {
            return this.f3454e;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void i(PointF pointF) {
            float f10 = pointF.x;
            float f11 = pointF.y;
            float sqrt = (float) Math.sqrt((f10 * f10) + (f11 * f11));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        void j(int i10, int i11) {
            PointF a10;
            RecyclerView recyclerView = this.f3451b;
            if (!this.f3454e || this.f3450a == -1 || recyclerView == null) {
                r();
            }
            if (this.f3453d && this.f3455f == null && this.f3452c != null && (a10 = a(this.f3450a)) != null) {
                float f10 = a10.x;
                if (f10 != 0.0f || a10.y != 0.0f) {
                    recyclerView.i1((int) Math.signum(f10), (int) Math.signum(a10.y), null);
                }
            }
            this.f3453d = false;
            View view = this.f3455f;
            if (view != null) {
                if (d(view) == this.f3450a) {
                    o(this.f3455f, recyclerView.f3319l0, this.f3456g);
                    this.f3456g.c(recyclerView);
                    r();
                } else {
                    this.f3455f = null;
                }
            }
            if (this.f3454e) {
                l(i10, i11, recyclerView.f3319l0, this.f3456g);
                boolean a11 = this.f3456g.a();
                this.f3456g.c(recyclerView);
                if (a11) {
                    if (!this.f3454e) {
                        r();
                    } else {
                        this.f3453d = true;
                        recyclerView.f3313i0.f();
                    }
                }
            }
        }

        protected void k(View view) {
            if (d(view) == f()) {
                this.f3455f = view;
            }
        }

        protected abstract void l(int i10, int i11, a0 a0Var, a aVar);

        protected abstract void m();

        protected abstract void n();

        protected abstract void o(View view, a0 a0Var, a aVar);

        public void p(int i10) {
            this.f3450a = i10;
        }

        void q(RecyclerView recyclerView, o oVar) {
            if (this.f3457h) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("An instance of ");
                sb2.append(getClass().getSimpleName());
                sb2.append(" was started ");
                sb2.append("more than once. Each instance of");
                sb2.append(getClass().getSimpleName());
                sb2.append(" ");
                sb2.append("is intended to only be used once. You should create a new instance for ");
                sb2.append("each use.");
            }
            this.f3451b = recyclerView;
            this.f3452c = oVar;
            int i10 = this.f3450a;
            if (i10 == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.f3319l0.f3349a = i10;
            this.f3454e = true;
            this.f3453d = true;
            this.f3455f = b(f());
            m();
            this.f3451b.f3313i0.f();
            this.f3457h = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void r() {
            if (this.f3454e) {
                this.f3454e = false;
                n();
                this.f3451b.f3319l0.f3349a = -1;
                this.f3455f = null;
                this.f3450a = -1;
                this.f3453d = false;
                this.f3452c.f1(this);
                this.f3452c = null;
                this.f3451b = null;
            }
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        F0 = i10 == 18 || i10 == 19 || i10 == 20;
        G0 = i10 >= 23;
        H0 = i10 >= 21;
        I0 = i10 <= 15;
        J0 = i10 <= 15;
        Class<?> cls = Integer.TYPE;
        K0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        L0 = new c();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3306f = new x();
        this.f3308g = new v();
        this.f3316k = new androidx.recyclerview.widget.p();
        new a();
        this.f3320m = new Rect();
        this.f3322n = new Rect();
        this.f3324o = new RectF();
        this.f3332s = new ArrayList<>();
        this.f3334t = new ArrayList<>();
        this.f3346z = 0;
        this.H = false;
        this.I = false;
        this.J = 0;
        this.K = 0;
        this.L = new k();
        this.Q = new androidx.recyclerview.widget.c();
        this.R = 0;
        this.S = -1;
        this.f3307f0 = Float.MIN_VALUE;
        this.f3309g0 = Float.MIN_VALUE;
        boolean z10 = true;
        this.f3311h0 = true;
        this.f3313i0 = new c0();
        this.f3317k0 = H0 ? new e.b() : null;
        this.f3319l0 = new a0();
        this.f3325o0 = false;
        this.f3327p0 = false;
        this.f3329q0 = new m();
        this.f3331r0 = false;
        this.f3337u0 = new int[2];
        this.f3341w0 = new int[2];
        this.f3343x0 = new int[2];
        this.f3345y0 = new int[2];
        this.f3347z0 = new int[2];
        this.A0 = new ArrayList();
        this.B0 = new b();
        this.C0 = new d();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, E0, i10, 0);
            this.f3318l = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.f3318l = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f3302b0 = viewConfiguration.getScaledTouchSlop();
        this.f3307f0 = androidx.core.view.c0.b(viewConfiguration, context);
        this.f3309g0 = androidx.core.view.c0.d(viewConfiguration, context);
        this.f3304d0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3305e0 = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.Q.v(this.f3329q0);
        q0();
        s0();
        r0();
        if (androidx.core.view.a0.x(this) == 0) {
            androidx.core.view.a0.u0(this, 1);
        }
        this.F = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.k(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, o0.b.f12449a, i10, 0);
            String string = obtainStyledAttributes2.getString(o0.b.f12457i);
            if (obtainStyledAttributes2.getInt(o0.b.f12451c, -1) == -1) {
                setDescendantFocusability(262144);
            }
            boolean z11 = obtainStyledAttributes2.getBoolean(o0.b.f12452d, false);
            this.f3342x = z11;
            if (z11) {
                t0((StateListDrawable) obtainStyledAttributes2.getDrawable(o0.b.f12455g), obtainStyledAttributes2.getDrawable(o0.b.f12456h), (StateListDrawable) obtainStyledAttributes2.getDrawable(o0.b.f12453e), obtainStyledAttributes2.getDrawable(o0.b.f12454f));
            }
            obtainStyledAttributes2.recycle();
            w(context, string, attributeSet, i10, 0);
            if (Build.VERSION.SDK_INT >= 21) {
                TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, D0, i10, 0);
                boolean z12 = obtainStyledAttributes3.getBoolean(0, true);
                obtainStyledAttributes3.recycle();
                z10 = z12;
            }
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z10);
    }

    private void B() {
        int i10 = this.D;
        this.D = 0;
        if (i10 == 0 || !v0()) {
            return;
        }
        AccessibilityEvent obtain = AccessibilityEvent.obtain();
        obtain.setEventType(2048);
        androidx.core.view.accessibility.b.b(obtain, i10);
        sendAccessibilityEventUnchecked(obtain);
    }

    private void D() {
        this.f3319l0.a(1);
        S(this.f3319l0);
        this.f3319l0.f3358j = false;
        o1();
        this.f3316k.f();
        I0();
        Q0();
        f1();
        a0 a0Var = this.f3319l0;
        a0Var.f3357i = a0Var.f3359k && this.f3327p0;
        this.f3327p0 = false;
        this.f3325o0 = false;
        a0Var.f3356h = a0Var.f3360l;
        a0Var.f3354f = this.f3326p.c();
        V(this.f3337u0);
        if (this.f3319l0.f3359k) {
            int g10 = this.f3314j.g();
            for (int i10 = 0; i10 < g10; i10++) {
                d0 g02 = g0(this.f3314j.f(i10));
                if (!g02.I() && (!g02.s() || this.f3326p.f())) {
                    this.f3316k.e(g02, this.Q.t(this.f3319l0, g02, l.e(g02), g02.o()));
                    if (this.f3319l0.f3357i && g02.x() && !g02.u() && !g02.I() && !g02.s()) {
                        this.f3316k.c(d0(g02), g02);
                    }
                }
            }
        }
        if (this.f3319l0.f3360l) {
            g1();
            a0 a0Var2 = this.f3319l0;
            boolean z10 = a0Var2.f3355g;
            a0Var2.f3355g = false;
            this.f3328q.X0(this.f3308g, a0Var2);
            this.f3319l0.f3355g = z10;
            for (int i11 = 0; i11 < this.f3314j.g(); i11++) {
                d0 g03 = g0(this.f3314j.f(i11));
                if (!g03.I() && !this.f3316k.i(g03)) {
                    int e10 = l.e(g03);
                    boolean p10 = g03.p(8192);
                    if (!p10) {
                        e10 |= 4096;
                    }
                    l.c t10 = this.Q.t(this.f3319l0, g03, e10, g03.o());
                    if (p10) {
                        T0(g03, t10);
                    } else {
                        this.f3316k.a(g03, t10);
                    }
                }
            }
        }
        t();
        J0();
        q1(false);
        this.f3319l0.f3353e = 2;
    }

    private void E() {
        o1();
        I0();
        this.f3319l0.a(6);
        this.f3312i.j();
        this.f3319l0.f3354f = this.f3326p.c();
        a0 a0Var = this.f3319l0;
        a0Var.f3352d = 0;
        a0Var.f3356h = false;
        this.f3328q.X0(this.f3308g, a0Var);
        a0 a0Var2 = this.f3319l0;
        a0Var2.f3355g = false;
        this.f3310h = null;
        a0Var2.f3359k = a0Var2.f3359k && this.Q != null;
        a0Var2.f3353e = 4;
        J0();
        q1(false);
    }

    private void F() {
        this.f3319l0.a(4);
        o1();
        I0();
        a0 a0Var = this.f3319l0;
        a0Var.f3353e = 1;
        if (a0Var.f3359k) {
            for (int g10 = this.f3314j.g() - 1; g10 >= 0; g10--) {
                d0 g02 = g0(this.f3314j.f(g10));
                if (!g02.I()) {
                    long d02 = d0(g02);
                    l.c s10 = this.Q.s(this.f3319l0, g02);
                    d0 g11 = this.f3316k.g(d02);
                    if (g11 != null && !g11.I()) {
                        boolean h10 = this.f3316k.h(g11);
                        boolean h11 = this.f3316k.h(g02);
                        if (!h10 || g11 != g02) {
                            l.c n10 = this.f3316k.n(g11);
                            this.f3316k.d(g02, s10);
                            l.c m10 = this.f3316k.m(g02);
                            if (n10 == null) {
                                l0(d02, g02, g11);
                            } else {
                                n(g11, g02, n10, m10, h10, h11);
                            }
                        }
                    }
                    this.f3316k.d(g02, s10);
                }
            }
            this.f3316k.o(this.C0);
        }
        this.f3328q.l1(this.f3308g);
        a0 a0Var2 = this.f3319l0;
        a0Var2.f3351c = a0Var2.f3354f;
        this.H = false;
        this.I = false;
        a0Var2.f3359k = false;
        a0Var2.f3360l = false;
        this.f3328q.f3413h = false;
        ArrayList<d0> arrayList = this.f3308g.f3441b;
        if (arrayList != null) {
            arrayList.clear();
        }
        o oVar = this.f3328q;
        if (oVar.f3419n) {
            oVar.f3418m = 0;
            oVar.f3419n = false;
            this.f3308g.K();
        }
        this.f3328q.Y0(this.f3319l0);
        J0();
        q1(false);
        this.f3316k.f();
        int[] iArr = this.f3337u0;
        if (y(iArr[0], iArr[1])) {
            L(0, 0);
        }
        U0();
        d1();
    }

    private boolean I(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        s sVar = this.f3336u;
        if (sVar != null) {
            if (action != 0) {
                sVar.b(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.f3336u = null;
                }
                return true;
            }
            this.f3336u = null;
        }
        if (action != 0) {
            int size = this.f3334t.size();
            for (int i10 = 0; i10 < size; i10++) {
                s sVar2 = this.f3334t.get(i10);
                if (sVar2.a(this, motionEvent)) {
                    this.f3336u = sVar2;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean J(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.f3336u = null;
        }
        int size = this.f3334t.size();
        for (int i10 = 0; i10 < size; i10++) {
            s sVar = this.f3334t.get(i10);
            if (sVar.a(this, motionEvent) && action != 3) {
                this.f3336u = sVar;
                return true;
            }
        }
        return false;
    }

    private void L0(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.S) {
            int i10 = actionIndex == 0 ? 1 : 0;
            this.S = motionEvent.getPointerId(i10);
            int x10 = (int) (motionEvent.getX(i10) + 0.5f);
            this.W = x10;
            this.U = x10;
            int y10 = (int) (motionEvent.getY(i10) + 0.5f);
            this.f3301a0 = y10;
            this.V = y10;
        }
    }

    private boolean P0() {
        return this.Q != null && this.f3328q.K1();
    }

    private void Q0() {
        boolean z10;
        if (this.H) {
            this.f3312i.u();
            if (this.I) {
                this.f3328q.S0(this);
            }
        }
        if (P0()) {
            this.f3312i.s();
        } else {
            this.f3312i.j();
        }
        boolean z11 = false;
        boolean z12 = this.f3325o0 || this.f3327p0;
        this.f3319l0.f3359k = this.f3344y && this.Q != null && ((z10 = this.H) || z12 || this.f3328q.f3413h) && (!z10 || this.f3326p.f());
        a0 a0Var = this.f3319l0;
        if (a0Var.f3359k && z12 && !this.H && P0()) {
            z11 = true;
        }
        a0Var.f3360l = z11;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void S0(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L21
            r6.O()
            android.widget.EdgeEffect r3 = r6.M
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
        L1c:
            androidx.core.widget.e.c(r3, r4, r9)
            r9 = 1
            goto L39
        L21:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L38
            r6.P()
            android.widget.EdgeEffect r3 = r6.O
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            goto L1c
        L38:
            r9 = 0
        L39:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L53
            r6.Q()
            android.widget.EdgeEffect r9 = r6.N
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            androidx.core.widget.e.c(r9, r0, r7)
            goto L6f
        L53:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L6e
            r6.N()
            android.widget.EdgeEffect r9 = r6.P
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            androidx.core.widget.e.c(r9, r3, r0)
            goto L6f
        L6e:
            r1 = r9
        L6f:
            if (r1 != 0) goto L79
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L79
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L7c
        L79:
            androidx.core.view.a0.d0(r6)
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.S0(float, float, float, float):void");
    }

    private void U0() {
        View findViewById;
        if (!this.f3311h0 || this.f3326p == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!J0 || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.f3314j.n(focusedChild)) {
                    return;
                }
            } else if (this.f3314j.g() == 0) {
                requestFocus();
                return;
            }
        }
        View view = null;
        d0 Z = (this.f3319l0.f3362n == -1 || !this.f3326p.f()) ? null : Z(this.f3319l0.f3362n);
        if (Z != null && !this.f3314j.n(Z.f3375a) && Z.f3375a.hasFocusable()) {
            view = Z.f3375a;
        } else if (this.f3314j.g() > 0) {
            view = X();
        }
        if (view != null) {
            int i10 = this.f3319l0.f3363o;
            if (i10 != -1 && (findViewById = view.findViewById(i10)) != null && findViewById.isFocusable()) {
                view = findViewById;
            }
            view.requestFocus();
        }
    }

    private void V(int[] iArr) {
        int g10 = this.f3314j.g();
        if (g10 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i10 = Integer.MAX_VALUE;
        int i11 = Integer.MIN_VALUE;
        for (int i12 = 0; i12 < g10; i12++) {
            d0 g02 = g0(this.f3314j.f(i12));
            if (!g02.I()) {
                int m10 = g02.m();
                if (m10 < i10) {
                    i10 = m10;
                }
                if (m10 > i11) {
                    i11 = m10;
                }
            }
        }
        iArr[0] = i10;
        iArr[1] = i11;
    }

    private void V0() {
        boolean z10;
        EdgeEffect edgeEffect = this.M;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z10 = this.M.isFinished();
        } else {
            z10 = false;
        }
        EdgeEffect edgeEffect2 = this.N;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z10 |= this.N.isFinished();
        }
        EdgeEffect edgeEffect3 = this.O;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z10 |= this.O.isFinished();
        }
        EdgeEffect edgeEffect4 = this.P;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z10 |= this.P.isFinished();
        }
        if (z10) {
            androidx.core.view.a0.d0(this);
        }
    }

    static RecyclerView W(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            RecyclerView W = W(viewGroup.getChildAt(i10));
            if (W != null) {
                return W;
            }
        }
        return null;
    }

    private View X() {
        d0 Y;
        a0 a0Var = this.f3319l0;
        int i10 = a0Var.f3361m;
        if (i10 == -1) {
            i10 = 0;
        }
        int b10 = a0Var.b();
        for (int i11 = i10; i11 < b10; i11++) {
            d0 Y2 = Y(i11);
            if (Y2 == null) {
                break;
            }
            if (Y2.f3375a.hasFocusable()) {
                return Y2.f3375a;
            }
        }
        int min = Math.min(b10, i10);
        do {
            min--;
            if (min < 0 || (Y = Y(min)) == null) {
                return null;
            }
        } while (!Y.f3375a.hasFocusable());
        return Y.f3375a;
    }

    private void c1(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f3320m.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof p) {
            p pVar = (p) layoutParams;
            if (!pVar.f3432c) {
                Rect rect = pVar.f3431b;
                Rect rect2 = this.f3320m;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f3320m);
            offsetRectIntoDescendantCoords(view, this.f3320m);
        }
        this.f3328q.s1(this, view, this.f3320m, !this.f3344y, view2 == null);
    }

    private void d1() {
        a0 a0Var = this.f3319l0;
        a0Var.f3362n = -1L;
        a0Var.f3361m = -1;
        a0Var.f3363o = -1;
    }

    private void e1() {
        VelocityTracker velocityTracker = this.T;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        a(0);
        V0();
    }

    private void f1() {
        View focusedChild = (this.f3311h0 && hasFocus() && this.f3326p != null) ? getFocusedChild() : null;
        d0 U = focusedChild != null ? U(focusedChild) : null;
        if (U == null) {
            d1();
            return;
        }
        this.f3319l0.f3362n = this.f3326p.f() ? U.k() : -1L;
        this.f3319l0.f3361m = this.H ? -1 : U.u() ? U.f3378d : U.j();
        this.f3319l0.f3363o = i0(U.f3375a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d0 g0(View view) {
        if (view == null) {
            return null;
        }
        return ((p) view.getLayoutParams()).f3430a;
    }

    private androidx.core.view.p getScrollingChildHelper() {
        if (this.f3339v0 == null) {
            this.f3339v0 = new androidx.core.view.p(this);
        }
        return this.f3339v0;
    }

    private void h(d0 d0Var) {
        View view = d0Var.f3375a;
        boolean z10 = view.getParent() == this;
        this.f3308g.J(f0(view));
        if (d0Var.w()) {
            this.f3314j.c(view, -1, view.getLayoutParams(), true);
            return;
        }
        androidx.recyclerview.widget.b bVar = this.f3314j;
        if (z10) {
            bVar.k(view);
        } else {
            bVar.b(view, true);
        }
    }

    static void h0(View view, Rect rect) {
        p pVar = (p) view.getLayoutParams();
        Rect rect2 = pVar.f3431b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
    }

    private int i0(View view) {
        int id;
        loop0: while (true) {
            id = view.getId();
            while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
                view = ((ViewGroup) view).getFocusedChild();
                if (view.getId() != -1) {
                    break;
                }
            }
        }
        return id;
    }

    private String j0(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    private void j1(g gVar, boolean z10, boolean z11) {
        g gVar2 = this.f3326p;
        if (gVar2 != null) {
            gVar2.r(this.f3306f);
            this.f3326p.l(this);
        }
        if (!z10 || z11) {
            W0();
        }
        this.f3312i.u();
        g gVar3 = this.f3326p;
        this.f3326p = gVar;
        if (gVar != null) {
            gVar.q(this.f3306f);
            gVar.h(this);
        }
        o oVar = this.f3328q;
        if (oVar != null) {
            oVar.E0(gVar3, this.f3326p);
        }
        this.f3308g.x(gVar3, this.f3326p, z10);
        this.f3319l0.f3355g = true;
    }

    private void l0(long j10, d0 d0Var, d0 d0Var2) {
        int g10 = this.f3314j.g();
        for (int i10 = 0; i10 < g10; i10++) {
            d0 g02 = g0(this.f3314j.f(i10));
            if (g02 != d0Var && d0(g02) == j10) {
                g gVar = this.f3326p;
                if (gVar == null || !gVar.f()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + g02 + " \n View Holder 2:" + d0Var + R());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + g02 + " \n View Holder 2:" + d0Var + R());
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ");
        sb2.append(d0Var2);
        sb2.append(" cannot be found but it is necessary for ");
        sb2.append(d0Var);
        sb2.append(R());
    }

    private void n(d0 d0Var, d0 d0Var2, l.c cVar, l.c cVar2, boolean z10, boolean z11) {
        d0Var.F(false);
        if (z10) {
            h(d0Var);
        }
        if (d0Var != d0Var2) {
            if (z11) {
                h(d0Var2);
            }
            d0Var.f3382h = d0Var2;
            h(d0Var);
            this.f3308g.J(d0Var);
            d0Var2.F(false);
            d0Var2.f3383i = d0Var;
        }
        if (this.Q.b(d0Var, d0Var2, cVar, cVar2)) {
            O0();
        }
    }

    private boolean p0() {
        int g10 = this.f3314j.g();
        for (int i10 = 0; i10 < g10; i10++) {
            d0 g02 = g0(this.f3314j.f(i10));
            if (g02 != null && !g02.I() && g02.x()) {
                return true;
            }
        }
        return false;
    }

    private void r() {
        e1();
        setScrollState(0);
    }

    @SuppressLint({"InlinedApi"})
    private void r0() {
        if (androidx.core.view.a0.y(this) == 0) {
            androidx.core.view.a0.v0(this, 8);
        }
    }

    static void s(d0 d0Var) {
        WeakReference<RecyclerView> weakReference = d0Var.f3376b;
        if (weakReference != null) {
            Object obj = weakReference.get();
            while (true) {
                for (View view = (View) obj; view != null; view = null) {
                    if (view == d0Var.f3375a) {
                        return;
                    }
                    obj = view.getParent();
                    if (obj instanceof View) {
                        break;
                    }
                }
                d0Var.f3376b = null;
                return;
            }
        }
    }

    private void s0() {
        this.f3314j = new androidx.recyclerview.widget.b(new e());
    }

    private void s1() {
        this.f3313i0.l();
        o oVar = this.f3328q;
        if (oVar != null) {
            oVar.J1();
        }
    }

    private void w(Context context, String str, AttributeSet attributeSet, int i10, int i11) {
        Constructor constructor;
        if (str != null) {
            String trim = str.trim();
            if (trim.isEmpty()) {
                return;
            }
            String j02 = j0(context, trim);
            try {
                Class<? extends U> asSubclass = (isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).loadClass(j02).asSubclass(o.class);
                Object[] objArr = null;
                try {
                    constructor = asSubclass.getConstructor(K0);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i10), Integer.valueOf(i11)};
                } catch (NoSuchMethodException e10) {
                    try {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    } catch (NoSuchMethodException e11) {
                        e11.initCause(e10);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + j02, e11);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((o) constructor.newInstance(objArr));
            } catch (ClassCastException e12) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + j02, e12);
            } catch (ClassNotFoundException e13) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + j02, e13);
            } catch (IllegalAccessException e14) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + j02, e14);
            } catch (InstantiationException e15) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + j02, e15);
            } catch (InvocationTargetException e16) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + j02, e16);
            }
        }
    }

    private boolean x0(View view, View view2, int i10) {
        int i11;
        if (view2 == null || view2 == this || T(view2) == null) {
            return false;
        }
        if (view == null || T(view) == null) {
            return true;
        }
        this.f3320m.set(0, 0, view.getWidth(), view.getHeight());
        this.f3322n.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f3320m);
        offsetDescendantRectToMyCoords(view2, this.f3322n);
        char c10 = 65535;
        int i12 = this.f3328q.Z() == 1 ? -1 : 1;
        Rect rect = this.f3320m;
        int i13 = rect.left;
        Rect rect2 = this.f3322n;
        int i14 = rect2.left;
        if ((i13 < i14 || rect.right <= i14) && rect.right < rect2.right) {
            i11 = 1;
        } else {
            int i15 = rect.right;
            int i16 = rect2.right;
            i11 = ((i15 > i16 || i13 >= i16) && i13 > i14) ? -1 : 0;
        }
        int i17 = rect.top;
        int i18 = rect2.top;
        if ((i17 < i18 || rect.bottom <= i18) && rect.bottom < rect2.bottom) {
            c10 = 1;
        } else {
            int i19 = rect.bottom;
            int i20 = rect2.bottom;
            if ((i19 <= i20 && i17 < i20) || i17 <= i18) {
                c10 = 0;
            }
        }
        if (i10 == 1) {
            return c10 < 0 || (c10 == 0 && i11 * i12 <= 0);
        }
        if (i10 == 2) {
            return c10 > 0 || (c10 == 0 && i11 * i12 >= 0);
        }
        if (i10 == 17) {
            return i11 < 0;
        }
        if (i10 == 33) {
            return c10 < 0;
        }
        if (i10 == 66) {
            return i11 > 0;
        }
        if (i10 == 130) {
            return c10 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i10 + R());
    }

    private boolean y(int i10, int i11) {
        V(this.f3337u0);
        int[] iArr = this.f3337u0;
        return (iArr[0] == i10 && iArr[1] == i11) ? false : true;
    }

    void A(View view) {
        d0 g02 = g0(view);
        H0(view);
        g gVar = this.f3326p;
        if (gVar != null && g02 != null) {
            gVar.o(g02);
        }
        List<q> list = this.G;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.G.get(size).b(view);
            }
        }
    }

    void A0() {
        int j10 = this.f3314j.j();
        for (int i10 = 0; i10 < j10; i10++) {
            d0 g02 = g0(this.f3314j.i(i10));
            if (g02 != null && !g02.I()) {
                g02.b(6);
            }
        }
        z0();
        this.f3308g.t();
    }

    public void B0(int i10) {
        int g10 = this.f3314j.g();
        for (int i11 = 0; i11 < g10; i11++) {
            this.f3314j.f(i11).offsetLeftAndRight(i10);
        }
    }

    void C() {
        if (this.f3326p == null || this.f3328q == null) {
            return;
        }
        a0 a0Var = this.f3319l0;
        a0Var.f3358j = false;
        if (a0Var.f3353e == 1) {
            D();
        } else if (!this.f3312i.q() && this.f3328q.o0() == getWidth() && this.f3328q.W() == getHeight()) {
            this.f3328q.z1(this);
            F();
        }
        this.f3328q.z1(this);
        E();
        F();
    }

    public void C0(int i10) {
        int g10 = this.f3314j.g();
        for (int i11 = 0; i11 < g10; i11++) {
            this.f3314j.f(i11).offsetTopAndBottom(i10);
        }
    }

    void D0(int i10, int i11) {
        int j10 = this.f3314j.j();
        for (int i12 = 0; i12 < j10; i12++) {
            d0 g02 = g0(this.f3314j.i(i12));
            if (g02 != null && !g02.I() && g02.f3377c >= i10) {
                g02.z(i11, false);
                this.f3319l0.f3355g = true;
            }
        }
        this.f3308g.u(i10, i11);
        requestLayout();
    }

    void E0(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int j10 = this.f3314j.j();
        if (i10 < i11) {
            i14 = -1;
            i13 = i10;
            i12 = i11;
        } else {
            i12 = i10;
            i13 = i11;
            i14 = 1;
        }
        for (int i16 = 0; i16 < j10; i16++) {
            d0 g02 = g0(this.f3314j.i(i16));
            if (g02 != null && (i15 = g02.f3377c) >= i13 && i15 <= i12) {
                if (i15 == i10) {
                    g02.z(i11 - i10, false);
                } else {
                    g02.z(i14, false);
                }
                this.f3319l0.f3355g = true;
            }
        }
        this.f3308g.v(i10, i11);
        requestLayout();
    }

    void F0(int i10, int i11, boolean z10) {
        int i12 = i10 + i11;
        int j10 = this.f3314j.j();
        for (int i13 = 0; i13 < j10; i13++) {
            d0 g02 = g0(this.f3314j.i(i13));
            if (g02 != null && !g02.I()) {
                int i14 = g02.f3377c;
                if (i14 >= i12) {
                    g02.z(-i11, z10);
                } else if (i14 >= i10) {
                    g02.i(i10 - 1, -i11, z10);
                }
                this.f3319l0.f3355g = true;
            }
        }
        this.f3308g.w(i10, i11, z10);
        requestLayout();
    }

    public boolean G(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        return getScrollingChildHelper().d(i10, i11, iArr, iArr2, i12);
    }

    public void G0(View view) {
    }

    public boolean H(int i10, int i11, int i12, int i13, int[] iArr, int i14) {
        return getScrollingChildHelper().g(i10, i11, i12, i13, iArr, i14);
    }

    public void H0(View view) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I0() {
        this.J++;
    }

    void J0() {
        K0(true);
    }

    void K(int i10) {
        o oVar = this.f3328q;
        if (oVar != null) {
            oVar.e1(i10);
        }
        M0(i10);
        t tVar = this.f3321m0;
        if (tVar != null) {
            tVar.a(this, i10);
        }
        List<t> list = this.f3323n0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f3323n0.get(size).a(this, i10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K0(boolean z10) {
        int i10 = this.J - 1;
        this.J = i10;
        if (i10 < 1) {
            this.J = 0;
            if (z10) {
                B();
                M();
            }
        }
    }

    void L(int i10, int i11) {
        this.K++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        N0(i10, i11);
        t tVar = this.f3321m0;
        if (tVar != null) {
            tVar.b(this, i10, i11);
        }
        List<t> list = this.f3323n0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f3323n0.get(size).b(this, i10, i11);
            }
        }
        this.K--;
    }

    void M() {
        int i10;
        for (int size = this.A0.size() - 1; size >= 0; size--) {
            d0 d0Var = this.A0.get(size);
            if (d0Var.f3375a.getParent() == this && !d0Var.I() && (i10 = d0Var.f3391q) != -1) {
                androidx.core.view.a0.u0(d0Var.f3375a, i10);
                d0Var.f3391q = -1;
            }
        }
        this.A0.clear();
    }

    public void M0(int i10) {
    }

    void N() {
        int measuredWidth;
        int measuredHeight;
        if (this.P != null) {
            return;
        }
        EdgeEffect a10 = this.L.a(this, 3);
        this.P = a10;
        if (this.f3318l) {
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        } else {
            measuredWidth = getMeasuredWidth();
            measuredHeight = getMeasuredHeight();
        }
        a10.setSize(measuredWidth, measuredHeight);
    }

    public void N0(int i10, int i11) {
    }

    void O() {
        int measuredHeight;
        int measuredWidth;
        if (this.M != null) {
            return;
        }
        EdgeEffect a10 = this.L.a(this, 0);
        this.M = a10;
        if (this.f3318l) {
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        } else {
            measuredHeight = getMeasuredHeight();
            measuredWidth = getMeasuredWidth();
        }
        a10.setSize(measuredHeight, measuredWidth);
    }

    void O0() {
        if (this.f3331r0 || !this.f3338v) {
            return;
        }
        androidx.core.view.a0.e0(this, this.B0);
        this.f3331r0 = true;
    }

    void P() {
        int measuredHeight;
        int measuredWidth;
        if (this.O != null) {
            return;
        }
        EdgeEffect a10 = this.L.a(this, 2);
        this.O = a10;
        if (this.f3318l) {
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        } else {
            measuredHeight = getMeasuredHeight();
            measuredWidth = getMeasuredWidth();
        }
        a10.setSize(measuredHeight, measuredWidth);
    }

    void Q() {
        int measuredWidth;
        int measuredHeight;
        if (this.N != null) {
            return;
        }
        EdgeEffect a10 = this.L.a(this, 1);
        this.N = a10;
        if (this.f3318l) {
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        } else {
            measuredWidth = getMeasuredWidth();
            measuredHeight = getMeasuredHeight();
        }
        a10.setSize(measuredWidth, measuredHeight);
    }

    String R() {
        return " " + super.toString() + ", adapter:" + this.f3326p + ", layout:" + this.f3328q + ", context:" + getContext();
    }

    void R0(boolean z10) {
        this.I = z10 | this.I;
        this.H = true;
        A0();
    }

    final void S(a0 a0Var) {
        if (getScrollState() != 2) {
            a0Var.f3364p = 0;
            return;
        }
        OverScroller overScroller = this.f3313i0.f3368h;
        a0Var.f3364p = overScroller.getFinalX() - overScroller.getCurrX();
        overScroller.getFinalY();
        overScroller.getCurrY();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View T(android.view.View r3) {
        /*
            r2 = this;
        L0:
            android.view.ViewParent r0 = r3.getParent()
            if (r0 == 0) goto L10
            if (r0 == r2) goto L10
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L10
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            goto L0
        L10:
            if (r0 != r2) goto L13
            goto L14
        L13:
            r3 = 0
        L14:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.T(android.view.View):android.view.View");
    }

    void T0(d0 d0Var, l.c cVar) {
        d0Var.E(0, 8192);
        if (this.f3319l0.f3357i && d0Var.x() && !d0Var.u() && !d0Var.I()) {
            this.f3316k.c(d0(d0Var), d0Var);
        }
        this.f3316k.e(d0Var, cVar);
    }

    public d0 U(View view) {
        View T = T(view);
        if (T == null) {
            return null;
        }
        return f0(T);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W0() {
        l lVar = this.Q;
        if (lVar != null) {
            lVar.k();
        }
        o oVar = this.f3328q;
        if (oVar != null) {
            oVar.k1(this.f3308g);
            this.f3328q.l1(this.f3308g);
        }
        this.f3308g.c();
    }

    boolean X0(View view) {
        o1();
        boolean r10 = this.f3314j.r(view);
        if (r10) {
            d0 g02 = g0(view);
            this.f3308g.J(g02);
            this.f3308g.C(g02);
        }
        q1(!r10);
        return r10;
    }

    public d0 Y(int i10) {
        d0 d0Var = null;
        if (this.H) {
            return null;
        }
        int j10 = this.f3314j.j();
        for (int i11 = 0; i11 < j10; i11++) {
            d0 g02 = g0(this.f3314j.i(i11));
            if (g02 != null && !g02.u() && c0(g02) == i10) {
                if (!this.f3314j.n(g02.f3375a)) {
                    return g02;
                }
                d0Var = g02;
            }
        }
        return d0Var;
    }

    public void Y0(n nVar) {
        o oVar = this.f3328q;
        if (oVar != null) {
            oVar.g("Cannot remove item decoration during a scroll  or layout");
        }
        this.f3332s.remove(nVar);
        if (this.f3332s.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        z0();
        requestLayout();
    }

    public d0 Z(long j10) {
        g gVar = this.f3326p;
        d0 d0Var = null;
        if (gVar != null && gVar.f()) {
            int j11 = this.f3314j.j();
            for (int i10 = 0; i10 < j11; i10++) {
                d0 g02 = g0(this.f3314j.i(i10));
                if (g02 != null && !g02.u() && g02.k() == j10) {
                    if (!this.f3314j.n(g02.f3375a)) {
                        return g02;
                    }
                    d0Var = g02;
                }
            }
        }
        return d0Var;
    }

    public void Z0(s sVar) {
        this.f3334t.remove(sVar);
        if (this.f3336u == sVar) {
            this.f3336u = null;
        }
    }

    @Override // androidx.core.view.n
    public void a(int i10) {
        getScrollingChildHelper().s(i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.recyclerview.widget.RecyclerView.d0 a0(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.b r0 = r5.f3314j
            int r0 = r0.j()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            androidx.recyclerview.widget.b r3 = r5.f3314j
            android.view.View r3 = r3.i(r2)
            androidx.recyclerview.widget.RecyclerView$d0 r3 = g0(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.u()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.f3377c
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.m()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            androidx.recyclerview.widget.b r1 = r5.f3314j
            android.view.View r4 = r3.f3375a
            boolean r1 = r1.n(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.a0(int, boolean):androidx.recyclerview.widget.RecyclerView$d0");
    }

    public void a1(t tVar) {
        List<t> list = this.f3323n0;
        if (list != null) {
            list.remove(tVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        o oVar = this.f3328q;
        if (oVar == null || !oVar.F0(this, arrayList, i10, i11)) {
            super.addFocusables(arrayList, i10, i11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean b0(int i10, int i11) {
        o oVar = this.f3328q;
        if (oVar == null || this.B) {
            return false;
        }
        int k10 = oVar.k();
        boolean l10 = this.f3328q.l();
        if (k10 == 0 || Math.abs(i10) < this.f3304d0) {
            i10 = 0;
        }
        if (!l10 || Math.abs(i11) < this.f3304d0) {
            i11 = 0;
        }
        if (i10 == 0 && i11 == 0) {
            return false;
        }
        float f10 = i10;
        float f11 = i11;
        if (!dispatchNestedPreFling(f10, f11)) {
            boolean z10 = k10 != 0 || l10;
            dispatchNestedFling(f10, f11, z10);
            r rVar = this.f3303c0;
            if (rVar != null && rVar.a(i10, i11)) {
                return true;
            }
            if (z10) {
                if (l10) {
                    k10 = (k10 == true ? 1 : 0) | 2;
                }
                p1(k10, 1);
                int i12 = this.f3305e0;
                int max = Math.max(-i12, Math.min(i10, i12));
                int i13 = this.f3305e0;
                this.f3313i0.e(max, Math.max(-i13, Math.min(i11, i13)));
                return true;
            }
        }
        return false;
    }

    void b1() {
        d0 d0Var;
        int g10 = this.f3314j.g();
        for (int i10 = 0; i10 < g10; i10++) {
            View f10 = this.f3314j.f(i10);
            d0 f02 = f0(f10);
            if (f02 != null && (d0Var = f02.f3383i) != null) {
                View view = d0Var.f3375a;
                int left = f10.getLeft();
                int top = f10.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    void c(int i10, int i11) {
        if (i10 < 0) {
            O();
            this.M.onAbsorb(-i10);
        } else if (i10 > 0) {
            P();
            this.O.onAbsorb(i10);
        }
        if (i11 < 0) {
            Q();
            this.N.onAbsorb(-i11);
        } else if (i11 > 0) {
            N();
            this.P.onAbsorb(i11);
        }
        if (i10 == 0 && i11 == 0) {
            return;
        }
        androidx.core.view.a0.d0(this);
    }

    int c0(d0 d0Var) {
        if (d0Var.p(524) || !d0Var.r()) {
            return -1;
        }
        return this.f3312i.e(d0Var.f3377c);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof p) && this.f3328q.m((p) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        o oVar = this.f3328q;
        if (oVar != null && oVar.k()) {
            return this.f3328q.q(this.f3319l0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        o oVar = this.f3328q;
        if (oVar != null && oVar.k()) {
            return this.f3328q.r(this.f3319l0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        o oVar = this.f3328q;
        if (oVar != null && oVar.k()) {
            return this.f3328q.s(this.f3319l0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        o oVar = this.f3328q;
        if (oVar != null && oVar.l()) {
            return this.f3328q.t(this.f3319l0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        o oVar = this.f3328q;
        if (oVar != null && oVar.l()) {
            return this.f3328q.u(this.f3319l0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        o oVar = this.f3328q;
        if (oVar != null && oVar.l()) {
            return this.f3328q.v(this.f3319l0);
        }
        return 0;
    }

    long d0(d0 d0Var) {
        return this.f3326p.f() ? d0Var.k() : d0Var.f3377c;
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return getScrollingChildHelper().a(f10, f11, z10);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f10, float f11) {
        return getScrollingChildHelper().b(f10, f11);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i10, i11, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return getScrollingChildHelper().f(i10, i11, i12, i13, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z10;
        float f10;
        int i10;
        super.draw(canvas);
        int size = this.f3332s.size();
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            this.f3332s.get(i11).i(canvas, this, this.f3319l0);
        }
        EdgeEffect edgeEffect = this.M;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z10 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.f3318l ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.M;
            z10 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.N;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.f3318l) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.N;
            z10 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.O;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f3318l ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.O;
            z10 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.P;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f3318l) {
                f10 = (-getWidth()) + getPaddingRight();
                i10 = (-getHeight()) + getPaddingBottom();
            } else {
                f10 = -getWidth();
                i10 = -getHeight();
            }
            canvas.translate(f10, i10);
            EdgeEffect edgeEffect8 = this.P;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z11 = true;
            }
            z10 |= z11;
            canvas.restoreToCount(save4);
        }
        if ((z10 || this.Q == null || this.f3332s.size() <= 0 || !this.Q.p()) ? z10 : true) {
            androidx.core.view.a0.d0(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        return super.drawChild(canvas, view, j10);
    }

    public int e0(View view) {
        d0 g02 = g0(view);
        if (g02 != null) {
            return g02.m();
        }
        return -1;
    }

    public d0 f0(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return g0(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i10) {
        View view2;
        boolean z10;
        View Q0 = this.f3328q.Q0(view, i10);
        if (Q0 != null) {
            return Q0;
        }
        boolean z11 = (this.f3326p == null || this.f3328q == null || w0() || this.B) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z11 && (i10 == 2 || i10 == 1)) {
            if (this.f3328q.l()) {
                int i11 = i10 == 2 ? 130 : 33;
                z10 = focusFinder.findNextFocus(this, view, i11) == null;
                if (I0) {
                    i10 = i11;
                }
            } else {
                z10 = false;
            }
            if (!z10 && this.f3328q.k()) {
                int i12 = (this.f3328q.Z() == 1) ^ (i10 == 2) ? 66 : 17;
                boolean z12 = focusFinder.findNextFocus(this, view, i12) == null;
                if (I0) {
                    i10 = i12;
                }
                z10 = z12;
            }
            if (z10) {
                v();
                if (T(view) == null) {
                    return null;
                }
                o1();
                this.f3328q.J0(view, i10, this.f3308g, this.f3319l0);
                q1(false);
            }
            view2 = focusFinder.findNextFocus(this, view, i10);
        } else {
            View findNextFocus = focusFinder.findNextFocus(this, view, i10);
            if (findNextFocus == null && z11) {
                v();
                if (T(view) == null) {
                    return null;
                }
                o1();
                view2 = this.f3328q.J0(view, i10, this.f3308g, this.f3319l0);
                q1(false);
            } else {
                view2 = findNextFocus;
            }
        }
        if (view2 == null || view2.hasFocusable()) {
            return x0(view, view2, i10) ? view2 : super.focusSearch(view, i10);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i10);
        }
        c1(view2, null);
        return view;
    }

    void g1() {
        int j10 = this.f3314j.j();
        for (int i10 = 0; i10 < j10; i10++) {
            d0 g02 = g0(this.f3314j.i(i10));
            if (!g02.I()) {
                g02.D();
            }
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        o oVar = this.f3328q;
        if (oVar != null) {
            return oVar.D();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + R());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        o oVar = this.f3328q;
        if (oVar != null) {
            return oVar.E(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + R());
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        o oVar = this.f3328q;
        if (oVar != null) {
            return oVar.F(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + R());
    }

    public g getAdapter() {
        return this.f3326p;
    }

    @Override // android.view.View
    public int getBaseline() {
        o oVar = this.f3328q;
        return oVar != null ? oVar.G() : super.getBaseline();
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i10, int i11) {
        j jVar = this.f3335t0;
        return jVar == null ? super.getChildDrawingOrder(i10, i11) : jVar.a(i10, i11);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f3318l;
    }

    public androidx.recyclerview.widget.k getCompatAccessibilityDelegate() {
        return this.f3333s0;
    }

    public k getEdgeEffectFactory() {
        return this.L;
    }

    public l getItemAnimator() {
        return this.Q;
    }

    public int getItemDecorationCount() {
        return this.f3332s.size();
    }

    public o getLayoutManager() {
        return this.f3328q;
    }

    public int getMaxFlingVelocity() {
        return this.f3305e0;
    }

    public int getMinFlingVelocity() {
        return this.f3304d0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNanoTime() {
        if (H0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public r getOnFlingListener() {
        return this.f3303c0;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f3311h0;
    }

    public u getRecycledViewPool() {
        return this.f3308g.i();
    }

    public int getScrollState() {
        return this.R;
    }

    boolean h1(int i10, int i11, MotionEvent motionEvent) {
        int i12;
        int i13;
        int i14;
        int i15;
        v();
        if (this.f3326p != null) {
            i1(i10, i11, this.f3347z0);
            int[] iArr = this.f3347z0;
            int i16 = iArr[0];
            int i17 = iArr[1];
            i13 = i17;
            i14 = i16;
            i15 = i10 - i16;
            i12 = i11 - i17;
        } else {
            i12 = 0;
            i13 = 0;
            i14 = 0;
            i15 = 0;
        }
        if (!this.f3332s.isEmpty()) {
            invalidate();
        }
        int i18 = i12;
        if (H(i14, i13, i15, i12, this.f3341w0, 0)) {
            int i19 = this.W;
            int[] iArr2 = this.f3341w0;
            this.W = i19 - iArr2[0];
            this.f3301a0 -= iArr2[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation(iArr2[0], iArr2[1]);
            }
            int[] iArr3 = this.f3345y0;
            int i20 = iArr3[0];
            int[] iArr4 = this.f3341w0;
            iArr3[0] = i20 + iArr4[0];
            iArr3[1] = iArr3[1] + iArr4[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null && !androidx.core.view.m.a(motionEvent, 8194)) {
                S0(motionEvent.getX(), i15, motionEvent.getY(), i18);
            }
            u(i10, i11);
        }
        if (i14 != 0 || i13 != 0) {
            L(i14, i13);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i14 == 0 && i13 == 0) ? false : true;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().k();
    }

    public void i(n nVar) {
        j(nVar, -1);
    }

    void i1(int i10, int i11, int[] iArr) {
        o1();
        I0();
        androidx.core.os.k.a("RV Scroll");
        S(this.f3319l0);
        int w12 = i10 != 0 ? this.f3328q.w1(i10, this.f3308g, this.f3319l0) : 0;
        int y12 = i11 != 0 ? this.f3328q.y1(i11, this.f3308g, this.f3319l0) : 0;
        androidx.core.os.k.b();
        b1();
        J0();
        q1(false);
        if (iArr != null) {
            iArr[0] = w12;
            iArr[1] = y12;
        }
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.f3338v;
    }

    @Override // android.view.View, androidx.core.view.o
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().m();
    }

    public void j(n nVar, int i10) {
        o oVar = this.f3328q;
        if (oVar != null) {
            oVar.g("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f3332s.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i10 < 0) {
            this.f3332s.add(nVar);
        } else {
            this.f3332s.add(i10, nVar);
        }
        z0();
        requestLayout();
    }

    public void k(s sVar) {
        this.f3334t.add(sVar);
    }

    Rect k0(View view) {
        p pVar = (p) view.getLayoutParams();
        if (!pVar.f3432c) {
            return pVar.f3431b;
        }
        if (this.f3319l0.e() && (pVar.b() || pVar.d())) {
            return pVar.f3431b;
        }
        Rect rect = pVar.f3431b;
        rect.set(0, 0, 0, 0);
        int size = this.f3332s.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f3320m.set(0, 0, 0, 0);
            this.f3332s.get(i10).e(this.f3320m, view, this, this.f3319l0);
            int i11 = rect.left;
            Rect rect2 = this.f3320m;
            rect.left = i11 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        pVar.f3432c = false;
        return rect;
    }

    boolean k1(d0 d0Var, int i10) {
        if (!w0()) {
            androidx.core.view.a0.u0(d0Var.f3375a, i10);
            return true;
        }
        d0Var.f3391q = i10;
        this.A0.add(d0Var);
        return false;
    }

    public void l(t tVar) {
        if (this.f3323n0 == null) {
            this.f3323n0 = new ArrayList();
        }
        this.f3323n0.add(tVar);
    }

    boolean l1(AccessibilityEvent accessibilityEvent) {
        if (!w0()) {
            return false;
        }
        int a10 = accessibilityEvent != null ? androidx.core.view.accessibility.b.a(accessibilityEvent) : 0;
        this.D |= a10 != 0 ? a10 : 0;
        return true;
    }

    void m(d0 d0Var, l.c cVar, l.c cVar2) {
        d0Var.F(false);
        if (this.Q.a(d0Var, cVar, cVar2)) {
            O0();
        }
    }

    public boolean m0() {
        return this.f3340w;
    }

    public void m1(int i10, int i11) {
        n1(i10, i11, null);
    }

    public boolean n0(int i10) {
        return getScrollingChildHelper().l(i10);
    }

    public void n1(int i10, int i11, Interpolator interpolator) {
        o oVar = this.f3328q;
        if (oVar == null || this.B) {
            return;
        }
        if (!oVar.k()) {
            i10 = 0;
        }
        if (!this.f3328q.l()) {
            i11 = 0;
        }
        if (i10 == 0 && i11 == 0) {
            return;
        }
        this.f3313i0.k(i10, i11, interpolator);
    }

    void o(d0 d0Var, l.c cVar, l.c cVar2) {
        h(d0Var);
        d0Var.F(false);
        if (this.Q.c(d0Var, cVar, cVar2)) {
            O0();
        }
    }

    public boolean o0() {
        return !this.f3344y || this.H || this.f3312i.p();
    }

    void o1() {
        int i10 = this.f3346z + 1;
        this.f3346z = i10;
        if (i10 != 1 || this.B) {
            return;
        }
        this.A = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.J = 0;
        this.f3338v = true;
        this.f3344y = this.f3344y && !isLayoutRequested();
        o oVar = this.f3328q;
        if (oVar != null) {
            oVar.z(this);
        }
        this.f3331r0 = false;
        if (H0) {
            ThreadLocal<androidx.recyclerview.widget.e> threadLocal = androidx.recyclerview.widget.e.f3604j;
            androidx.recyclerview.widget.e eVar = threadLocal.get();
            this.f3315j0 = eVar;
            if (eVar == null) {
                this.f3315j0 = new androidx.recyclerview.widget.e();
                Display s10 = androidx.core.view.a0.s(this);
                float f10 = 60.0f;
                if (!isInEditMode() && s10 != null) {
                    float refreshRate = s10.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f10 = refreshRate;
                    }
                }
                androidx.recyclerview.widget.e eVar2 = this.f3315j0;
                eVar2.f3608h = 1.0E9f / f10;
                threadLocal.set(eVar2);
            }
            this.f3315j0.a(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        androidx.recyclerview.widget.e eVar;
        super.onDetachedFromWindow();
        l lVar = this.Q;
        if (lVar != null) {
            lVar.k();
        }
        r1();
        this.f3338v = false;
        o oVar = this.f3328q;
        if (oVar != null) {
            oVar.A(this, this.f3308g);
        }
        this.A0.clear();
        removeCallbacks(this.B0);
        this.f3316k.j();
        if (!H0 || (eVar = this.f3315j0) == null) {
            return;
        }
        eVar.j(this);
        this.f3315j0 = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f3332s.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f3332s.get(i10).g(canvas, this, this.f3319l0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0066  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$o r0 = r5.f3328q
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.B
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L77
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3c
            androidx.recyclerview.widget.RecyclerView$o r0 = r5.f3328q
            boolean r0 = r0.l()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = 0
        L2d:
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.f3328q
            boolean r3 = r3.k()
            if (r3 == 0) goto L61
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L62
        L3c:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L60
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.f3328q
            boolean r3 = r3.l()
            if (r3 == 0) goto L55
            float r0 = -r0
            goto L61
        L55:
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.f3328q
            boolean r3 = r3.k()
            if (r3 == 0) goto L60
            r3 = r0
            r0 = 0
            goto L62
        L60:
            r0 = 0
        L61:
            r3 = 0
        L62:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6a
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L77
        L6a:
            float r2 = r5.f3307f0
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.f3309g0
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.h1(r2, r0, r6)
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        if (this.B) {
            return false;
        }
        if (J(motionEvent)) {
            r();
            return true;
        }
        o oVar = this.f3328q;
        if (oVar == null) {
            return false;
        }
        boolean k10 = oVar.k();
        boolean l10 = this.f3328q.l();
        if (this.T == null) {
            this.T = VelocityTracker.obtain();
        }
        this.T.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.C) {
                this.C = false;
            }
            this.S = motionEvent.getPointerId(0);
            int x10 = (int) (motionEvent.getX() + 0.5f);
            this.W = x10;
            this.U = x10;
            int y10 = (int) (motionEvent.getY() + 0.5f);
            this.f3301a0 = y10;
            this.V = y10;
            if (this.R == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
            int[] iArr = this.f3345y0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i10 = k10;
            if (l10) {
                i10 = (k10 ? 1 : 0) | 2;
            }
            p1(i10, 0);
        } else if (actionMasked == 1) {
            this.T.clear();
            a(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.S);
            if (findPointerIndex < 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error processing scroll; pointer index for id ");
                sb2.append(this.S);
                sb2.append(" not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x11 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y11 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.R != 1) {
                int i11 = x11 - this.U;
                int i12 = y11 - this.V;
                if (k10 == 0 || Math.abs(i11) <= this.f3302b0) {
                    z10 = false;
                } else {
                    this.W = x11;
                    z10 = true;
                }
                if (l10 && Math.abs(i12) > this.f3302b0) {
                    this.f3301a0 = y11;
                    z10 = true;
                }
                if (z10) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            r();
        } else if (actionMasked == 5) {
            this.S = motionEvent.getPointerId(actionIndex);
            int x12 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.W = x12;
            this.U = x12;
            int y12 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.f3301a0 = y12;
            this.V = y12;
        } else if (actionMasked == 6) {
            L0(motionEvent);
        }
        return this.R == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        androidx.core.os.k.a("RV OnLayout");
        C();
        androidx.core.os.k.b();
        this.f3344y = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        o oVar = this.f3328q;
        if (oVar == null) {
            x(i10, i11);
            return;
        }
        boolean z10 = false;
        if (oVar.s0()) {
            int mode = View.MeasureSpec.getMode(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            this.f3328q.Z0(this.f3308g, this.f3319l0, i10, i11);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z10 = true;
            }
            if (z10 || this.f3326p == null) {
                return;
            }
            if (this.f3319l0.f3353e == 1) {
                D();
            }
            this.f3328q.A1(i10, i11);
            this.f3319l0.f3358j = true;
            E();
            this.f3328q.D1(i10, i11);
            if (this.f3328q.G1()) {
                this.f3328q.A1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.f3319l0.f3358j = true;
                E();
                this.f3328q.D1(i10, i11);
                return;
            }
            return;
        }
        if (this.f3340w) {
            this.f3328q.Z0(this.f3308g, this.f3319l0, i10, i11);
            return;
        }
        if (this.E) {
            o1();
            I0();
            Q0();
            J0();
            a0 a0Var = this.f3319l0;
            if (a0Var.f3360l) {
                a0Var.f3356h = true;
            } else {
                this.f3312i.j();
                this.f3319l0.f3356h = false;
            }
            this.E = false;
            q1(false);
        } else if (this.f3319l0.f3360l) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        g gVar = this.f3326p;
        if (gVar != null) {
            this.f3319l0.f3354f = gVar.c();
        } else {
            this.f3319l0.f3354f = 0;
        }
        o1();
        this.f3328q.Z0(this.f3308g, this.f3319l0, i10, i11);
        q1(false);
        this.f3319l0.f3356h = false;
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i10, Rect rect) {
        if (w0()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i10, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof y)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        y yVar = (y) parcelable;
        this.f3310h = yVar;
        super.onRestoreInstanceState(yVar.a());
        o oVar = this.f3328q;
        if (oVar == null || (parcelable2 = this.f3310h.f3449h) == null) {
            return;
        }
        oVar.c1(parcelable2);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        y yVar = new y(super.onSaveInstanceState());
        y yVar2 = this.f3310h;
        if (yVar2 != null) {
            yVar.b(yVar2);
        } else {
            o oVar = this.f3328q;
            yVar.f3449h = oVar != null ? oVar.d1() : null;
        }
        return yVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 == i12 && i11 == i13) {
            return;
        }
        u0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0113  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    void p(String str) {
        if (w0()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + R());
        }
        if (this.K > 0) {
            new IllegalStateException("" + R());
        }
    }

    public boolean p1(int i10, int i11) {
        return getScrollingChildHelper().q(i10, i11);
    }

    boolean q(d0 d0Var) {
        l lVar = this.Q;
        return lVar == null || lVar.g(d0Var, d0Var.o());
    }

    void q0() {
        this.f3312i = new androidx.recyclerview.widget.a(new f());
    }

    void q1(boolean z10) {
        if (this.f3346z < 1) {
            this.f3346z = 1;
        }
        if (!z10 && !this.B) {
            this.A = false;
        }
        if (this.f3346z == 1) {
            if (z10 && this.A && !this.B && this.f3328q != null && this.f3326p != null) {
                C();
            }
            if (!this.B) {
                this.A = false;
            }
        }
        this.f3346z--;
    }

    public void r1() {
        setScrollState(0);
        s1();
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z10) {
        d0 g02 = g0(view);
        if (g02 != null) {
            if (g02.w()) {
                g02.f();
            } else if (!g02.I()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + g02 + R());
            }
        }
        view.clearAnimation();
        A(view);
        super.removeDetachedView(view, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f3328q.b1(this, this.f3319l0, view, view2) && view2 != null) {
            c1(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        return this.f3328q.r1(this, view, rect, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        int size = this.f3334t.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f3334t.get(i10).c(z10);
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f3346z != 0 || this.B) {
            this.A = true;
        } else {
            super.requestLayout();
        }
    }

    @Override // android.view.View
    public void scrollBy(int i10, int i11) {
        o oVar = this.f3328q;
        if (oVar == null || this.B) {
            return;
        }
        boolean k10 = oVar.k();
        boolean l10 = this.f3328q.l();
        if (k10 || l10) {
            if (!k10) {
                i10 = 0;
            }
            if (!l10) {
                i11 = 0;
            }
            h1(i10, i11, null);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i10, int i11) {
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (l1(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(androidx.recyclerview.widget.k kVar) {
        this.f3333s0 = kVar;
        androidx.core.view.a0.j0(this, kVar);
    }

    public void setAdapter(g gVar) {
        setLayoutFrozen(false);
        j1(gVar, false, true);
        R0(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(j jVar) {
        if (jVar == this.f3335t0) {
            return;
        }
        this.f3335t0 = jVar;
        setChildrenDrawingOrderEnabled(jVar != null);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z10) {
        if (z10 != this.f3318l) {
            u0();
        }
        this.f3318l = z10;
        super.setClipToPadding(z10);
        if (this.f3344y) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(k kVar) {
        androidx.core.util.h.f(kVar);
        this.L = kVar;
        u0();
    }

    public void setHasFixedSize(boolean z10) {
        this.f3340w = z10;
    }

    public void setItemAnimator(l lVar) {
        l lVar2 = this.Q;
        if (lVar2 != null) {
            lVar2.k();
            this.Q.v(null);
        }
        this.Q = lVar;
        if (lVar != null) {
            lVar.v(this.f3329q0);
        }
    }

    public void setItemViewCacheSize(int i10) {
        this.f3308g.G(i10);
    }

    public void setLayoutFrozen(boolean z10) {
        if (z10 != this.B) {
            p("Do not setLayoutFrozen in layout or scroll");
            if (z10) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.B = true;
                this.C = true;
                r1();
                return;
            }
            this.B = false;
            if (this.A && this.f3328q != null && this.f3326p != null) {
                requestLayout();
            }
            this.A = false;
        }
    }

    public void setLayoutManager(o oVar) {
        if (oVar == this.f3328q) {
            return;
        }
        r1();
        if (this.f3328q != null) {
            l lVar = this.Q;
            if (lVar != null) {
                lVar.k();
            }
            this.f3328q.k1(this.f3308g);
            this.f3328q.l1(this.f3308g);
            this.f3308g.c();
            if (this.f3338v) {
                this.f3328q.A(this, this.f3308g);
            }
            this.f3328q.E1(null);
            this.f3328q = null;
        } else {
            this.f3308g.c();
        }
        this.f3314j.o();
        this.f3328q = oVar;
        if (oVar != null) {
            if (oVar.f3407b != null) {
                throw new IllegalArgumentException("LayoutManager " + oVar + " is already attached to a RecyclerView:" + oVar.f3407b.R());
            }
            oVar.E1(this);
            if (this.f3338v) {
                this.f3328q.z(this);
            }
        }
        this.f3308g.K();
        requestLayout();
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z10) {
        getScrollingChildHelper().n(z10);
    }

    public void setOnFlingListener(r rVar) {
        this.f3303c0 = rVar;
    }

    @Deprecated
    public void setOnScrollListener(t tVar) {
        this.f3321m0 = tVar;
    }

    public void setPreserveFocusAfterLayout(boolean z10) {
        this.f3311h0 = z10;
    }

    public void setRecycledViewPool(u uVar) {
        this.f3308g.E(uVar);
    }

    public void setRecyclerListener(w wVar) {
        this.f3330r = wVar;
    }

    void setScrollState(int i10) {
        if (i10 == this.R) {
            return;
        }
        this.R = i10;
        if (i10 != 2) {
            s1();
        }
        K(i10);
    }

    public void setScrollingTouchSlop(int i10) {
        int scaledTouchSlop;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i10 != 0) {
            if (i10 == 1) {
                scaledTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                this.f3302b0 = scaledTouchSlop;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("setScrollingTouchSlop(): bad argument constant ");
                sb2.append(i10);
                sb2.append("; using default value");
            }
        }
        scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.f3302b0 = scaledTouchSlop;
    }

    public void setViewCacheExtension(b0 b0Var) {
        this.f3308g.F(b0Var);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i10) {
        return getScrollingChildHelper().p(i10);
    }

    @Override // android.view.View, androidx.core.view.o
    public void stopNestedScroll() {
        getScrollingChildHelper().r();
    }

    void t() {
        int j10 = this.f3314j.j();
        for (int i10 = 0; i10 < j10; i10++) {
            d0 g02 = g0(this.f3314j.i(i10));
            if (!g02.I()) {
                g02.c();
            }
        }
        this.f3308g.d();
    }

    void t0(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new androidx.recyclerview.widget.d(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(o0.a.f12446a), resources.getDimensionPixelSize(o0.a.f12448c), resources.getDimensionPixelOffset(o0.a.f12447b));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + R());
        }
    }

    public void t1(g gVar, boolean z10) {
        setLayoutFrozen(false);
        j1(gVar, true, z10);
        R0(true);
        requestLayout();
    }

    void u(int i10, int i11) {
        boolean z10;
        EdgeEffect edgeEffect = this.M;
        if (edgeEffect == null || edgeEffect.isFinished() || i10 <= 0) {
            z10 = false;
        } else {
            this.M.onRelease();
            z10 = this.M.isFinished();
        }
        EdgeEffect edgeEffect2 = this.O;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i10 < 0) {
            this.O.onRelease();
            z10 |= this.O.isFinished();
        }
        EdgeEffect edgeEffect3 = this.N;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i11 > 0) {
            this.N.onRelease();
            z10 |= this.N.isFinished();
        }
        EdgeEffect edgeEffect4 = this.P;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i11 < 0) {
            this.P.onRelease();
            z10 |= this.P.isFinished();
        }
        if (z10) {
            androidx.core.view.a0.d0(this);
        }
    }

    void u0() {
        this.P = null;
        this.N = null;
        this.O = null;
        this.M = null;
    }

    void u1(int i10, int i11, Object obj) {
        int i12;
        int j10 = this.f3314j.j();
        int i13 = i10 + i11;
        for (int i14 = 0; i14 < j10; i14++) {
            View i15 = this.f3314j.i(i14);
            d0 g02 = g0(i15);
            if (g02 != null && !g02.I() && (i12 = g02.f3377c) >= i10 && i12 < i13) {
                g02.b(2);
                g02.a(obj);
                ((p) i15.getLayoutParams()).f3432c = true;
            }
        }
        this.f3308g.M(i10, i11);
    }

    void v() {
        if (!this.f3344y || this.H) {
            androidx.core.os.k.a("RV FullInvalidate");
            C();
            androidx.core.os.k.b();
            return;
        }
        if (this.f3312i.p()) {
            if (this.f3312i.o(4) && !this.f3312i.o(11)) {
                androidx.core.os.k.a("RV PartialInvalidate");
                o1();
                I0();
                this.f3312i.s();
                if (!this.A) {
                    if (p0()) {
                        C();
                    } else {
                        this.f3312i.i();
                    }
                }
                q1(true);
                J0();
            } else {
                if (!this.f3312i.p()) {
                    return;
                }
                androidx.core.os.k.a("RV FullInvalidate");
                C();
            }
            androidx.core.os.k.b();
        }
    }

    boolean v0() {
        AccessibilityManager accessibilityManager = this.F;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean w0() {
        return this.J > 0;
    }

    void x(int i10, int i11) {
        setMeasuredDimension(o.n(i10, getPaddingLeft() + getPaddingRight(), androidx.core.view.a0.B(this)), o.n(i11, getPaddingTop() + getPaddingBottom(), androidx.core.view.a0.A(this)));
    }

    void y0(int i10) {
        o oVar = this.f3328q;
        if (oVar == null) {
            return;
        }
        oVar.x1(i10);
        awakenScrollBars();
    }

    void z(View view) {
        d0 g02 = g0(view);
        G0(view);
        g gVar = this.f3326p;
        if (gVar != null && g02 != null) {
            gVar.n(g02);
        }
        List<q> list = this.G;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.G.get(size).a(view);
            }
        }
    }

    void z0() {
        int j10 = this.f3314j.j();
        for (int i10 = 0; i10 < j10; i10++) {
            ((p) this.f3314j.i(i10).getLayoutParams()).f3432c = true;
        }
        this.f3308g.s();
    }
}
