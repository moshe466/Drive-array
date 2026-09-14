package androidx.drawerlayout.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.a0;
import androidx.core.view.accessibility.d;
import java.util.ArrayList;
import java.util.List;
import z.a;

/* loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {
    private static final int[] P = {R.attr.colorPrimaryDark};
    static final int[] Q = {R.attr.layout_gravity};
    static final boolean R;
    private static final boolean S;
    private float A;
    private Drawable B;
    private Drawable C;
    private Drawable D;
    private CharSequence E;
    private CharSequence F;
    private Object G;
    private boolean H;
    private Drawable I;
    private Drawable J;
    private Drawable K;
    private Drawable L;
    private final ArrayList<View> M;
    private Rect N;
    private Matrix O;

    /* renamed from: f, reason: collision with root package name */
    private final c f2699f;

    /* renamed from: g, reason: collision with root package name */
    private float f2700g;

    /* renamed from: h, reason: collision with root package name */
    private int f2701h;

    /* renamed from: i, reason: collision with root package name */
    private int f2702i;

    /* renamed from: j, reason: collision with root package name */
    private float f2703j;

    /* renamed from: k, reason: collision with root package name */
    private Paint f2704k;

    /* renamed from: l, reason: collision with root package name */
    private final z.a f2705l;

    /* renamed from: m, reason: collision with root package name */
    private final z.a f2706m;

    /* renamed from: n, reason: collision with root package name */
    private final g f2707n;

    /* renamed from: o, reason: collision with root package name */
    private final g f2708o;

    /* renamed from: p, reason: collision with root package name */
    private int f2709p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f2710q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f2711r;

    /* renamed from: s, reason: collision with root package name */
    private int f2712s;

    /* renamed from: t, reason: collision with root package name */
    private int f2713t;

    /* renamed from: u, reason: collision with root package name */
    private int f2714u;

    /* renamed from: v, reason: collision with root package name */
    private int f2715v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f2716w;

    /* renamed from: x, reason: collision with root package name */
    private d f2717x;

    /* renamed from: y, reason: collision with root package name */
    private List<d> f2718y;

    /* renamed from: z, reason: collision with root package name */
    private float f2719z;

    /* loaded from: classes.dex */
    class a implements View.OnApplyWindowInsetsListener {
        a(DrawerLayout drawerLayout) {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((DrawerLayout) view).M(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    /* loaded from: classes.dex */
    class b extends androidx.core.view.a {

        /* renamed from: d, reason: collision with root package name */
        private final Rect f2720d = new Rect();

        b() {
        }

        private void n(androidx.core.view.accessibility.d dVar, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (DrawerLayout.y(childAt)) {
                    dVar.c(childAt);
                }
            }
        }

        private void o(androidx.core.view.accessibility.d dVar, androidx.core.view.accessibility.d dVar2) {
            Rect rect = this.f2720d;
            dVar2.k(rect);
            dVar.R(rect);
            dVar2.l(rect);
            dVar.S(rect);
            dVar.s0(dVar2.J());
            dVar.i0(dVar2.r());
            dVar.V(dVar2.m());
            dVar.Z(dVar2.o());
            dVar.b0(dVar2.C());
            dVar.W(dVar2.B());
            dVar.d0(dVar2.D());
            dVar.e0(dVar2.E());
            dVar.P(dVar2.y());
            dVar.n0(dVar2.I());
            dVar.h0(dVar2.F());
            dVar.a(dVar2.j());
        }

        @Override // androidx.core.view.a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.a(view, accessibilityEvent);
            }
            List<CharSequence> text = accessibilityEvent.getText();
            View n10 = DrawerLayout.this.n();
            if (n10 == null) {
                return true;
            }
            CharSequence q10 = DrawerLayout.this.q(DrawerLayout.this.r(n10));
            if (q10 == null) {
                return true;
            }
            text.add(q10);
            return true;
        }

        @Override // androidx.core.view.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        @Override // androidx.core.view.a
        public void g(View view, androidx.core.view.accessibility.d dVar) {
            if (DrawerLayout.R) {
                super.g(view, dVar);
            } else {
                androidx.core.view.accessibility.d K = androidx.core.view.accessibility.d.K(dVar);
                super.g(view, K);
                dVar.p0(view);
                Object F = a0.F(view);
                if (F instanceof View) {
                    dVar.k0((View) F);
                }
                o(dVar, K);
                K.M();
                n(dVar, (ViewGroup) view);
            }
            dVar.V(DrawerLayout.class.getName());
            dVar.d0(false);
            dVar.e0(false);
            dVar.N(d.a.f2536d);
            dVar.N(d.a.f2537e);
        }

        @Override // androidx.core.view.a
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.R || DrawerLayout.y(view)) {
                return super.i(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    static final class c extends androidx.core.view.a {
        c() {
        }

        @Override // androidx.core.view.a
        public void g(View view, androidx.core.view.accessibility.d dVar) {
            super.g(view, dVar);
            if (DrawerLayout.y(view)) {
                return;
            }
            dVar.k0(null);
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(int i10);

        void b(View view, float f10);

        void c(View view);

        void d(View view);
    }

    /* loaded from: classes.dex */
    public static class e extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f2722a;

        /* renamed from: b, reason: collision with root package name */
        float f2723b;

        /* renamed from: c, reason: collision with root package name */
        boolean f2724c;

        /* renamed from: d, reason: collision with root package name */
        int f2725d;

        public e(int i10, int i11) {
            super(i10, i11);
            this.f2722a = 0;
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2722a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.Q);
            this.f2722a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2722a = 0;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2722a = 0;
        }

        public e(e eVar) {
            super((ViewGroup.MarginLayoutParams) eVar);
            this.f2722a = 0;
            this.f2722a = eVar.f2722a;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class f extends y.a {
        public static final Parcelable.Creator<f> CREATOR = new a();

        /* renamed from: h, reason: collision with root package name */
        int f2726h;

        /* renamed from: i, reason: collision with root package name */
        int f2727i;

        /* renamed from: j, reason: collision with root package name */
        int f2728j;

        /* renamed from: k, reason: collision with root package name */
        int f2729k;

        /* renamed from: l, reason: collision with root package name */
        int f2730l;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<f> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel) {
                return new f(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new f(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public f[] newArray(int i10) {
                return new f[i10];
            }
        }

        public f(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2726h = 0;
            this.f2726h = parcel.readInt();
            this.f2727i = parcel.readInt();
            this.f2728j = parcel.readInt();
            this.f2729k = parcel.readInt();
            this.f2730l = parcel.readInt();
        }

        public f(Parcelable parcelable) {
            super(parcelable);
            this.f2726h = 0;
        }

        @Override // y.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f2726h);
            parcel.writeInt(this.f2727i);
            parcel.writeInt(this.f2728j);
            parcel.writeInt(this.f2729k);
            parcel.writeInt(this.f2730l);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g extends a.c {

        /* renamed from: a, reason: collision with root package name */
        private final int f2731a;

        /* renamed from: b, reason: collision with root package name */
        private z.a f2732b;

        /* renamed from: c, reason: collision with root package name */
        private final Runnable f2733c = new a();

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.o();
            }
        }

        g(int i10) {
            this.f2731a = i10;
        }

        private void n() {
            View l10 = DrawerLayout.this.l(this.f2731a == 3 ? 5 : 3);
            if (l10 != null) {
                DrawerLayout.this.d(l10);
            }
        }

        @Override // z.a.c
        public int a(View view, int i10, int i11) {
            int width;
            int width2;
            if (DrawerLayout.this.c(view, 3)) {
                width2 = -view.getWidth();
                width = 0;
            } else {
                width = DrawerLayout.this.getWidth();
                width2 = width - view.getWidth();
            }
            return Math.max(width2, Math.min(i10, width));
        }

        @Override // z.a.c
        public int b(View view, int i10, int i11) {
            return view.getTop();
        }

        @Override // z.a.c
        public int d(View view) {
            if (DrawerLayout.this.B(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // z.a.c
        public void f(int i10, int i11) {
            DrawerLayout drawerLayout;
            int i12;
            if ((i10 & 1) == 1) {
                drawerLayout = DrawerLayout.this;
                i12 = 3;
            } else {
                drawerLayout = DrawerLayout.this;
                i12 = 5;
            }
            View l10 = drawerLayout.l(i12);
            if (l10 == null || DrawerLayout.this.p(l10) != 0) {
                return;
            }
            this.f2732b.b(l10, i11);
        }

        @Override // z.a.c
        public boolean g(int i10) {
            return false;
        }

        @Override // z.a.c
        public void h(int i10, int i11) {
            DrawerLayout.this.postDelayed(this.f2733c, 160L);
        }

        @Override // z.a.c
        public void i(View view, int i10) {
            ((e) view.getLayoutParams()).f2724c = false;
            n();
        }

        @Override // z.a.c
        public void j(int i10) {
            DrawerLayout.this.S(this.f2731a, i10, this.f2732b.v());
        }

        @Override // z.a.c
        public void k(View view, int i10, int i11, int i12, int i13) {
            float width = (DrawerLayout.this.c(view, 3) ? i10 + r3 : DrawerLayout.this.getWidth() - i10) / view.getWidth();
            DrawerLayout.this.Q(view, width);
            view.setVisibility(width == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        @Override // z.a.c
        public void l(View view, float f10, float f11) {
            int i10;
            float s10 = DrawerLayout.this.s(view);
            int width = view.getWidth();
            if (DrawerLayout.this.c(view, 3)) {
                i10 = (f10 > 0.0f || (f10 == 0.0f && s10 > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f10 < 0.0f || (f10 == 0.0f && s10 > 0.5f)) {
                    width2 -= width;
                }
                i10 = width2;
            }
            this.f2732b.M(i10, view.getTop());
            DrawerLayout.this.invalidate();
        }

        @Override // z.a.c
        public boolean m(View view, int i10) {
            return DrawerLayout.this.B(view) && DrawerLayout.this.c(view, this.f2731a) && DrawerLayout.this.p(view) == 0;
        }

        void o() {
            View l10;
            int width;
            int w10 = this.f2732b.w();
            boolean z10 = this.f2731a == 3;
            if (z10) {
                l10 = DrawerLayout.this.l(3);
                width = (l10 != null ? -l10.getWidth() : 0) + w10;
            } else {
                l10 = DrawerLayout.this.l(5);
                width = DrawerLayout.this.getWidth() - w10;
            }
            if (l10 != null) {
                if (((!z10 || l10.getLeft() >= width) && (z10 || l10.getLeft() <= width)) || DrawerLayout.this.p(l10) != 0) {
                    return;
                }
                e eVar = (e) l10.getLayoutParams();
                this.f2732b.O(l10, width, l10.getTop());
                eVar.f2724c = true;
                DrawerLayout.this.invalidate();
                n();
                DrawerLayout.this.b();
            }
        }

        public void p() {
            DrawerLayout.this.removeCallbacks(this.f2733c);
        }

        public void q(z.a aVar) {
            this.f2732b = aVar;
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        R = i10 >= 19;
        S = i10 >= 21;
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2699f = new c();
        this.f2702i = -1728053248;
        this.f2704k = new Paint();
        this.f2711r = true;
        this.f2712s = 3;
        this.f2713t = 3;
        this.f2714u = 3;
        this.f2715v = 3;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        setDescendantFocusability(262144);
        float f10 = getResources().getDisplayMetrics().density;
        this.f2701h = (int) ((64.0f * f10) + 0.5f);
        float f11 = 400.0f * f10;
        g gVar = new g(3);
        this.f2707n = gVar;
        g gVar2 = new g(5);
        this.f2708o = gVar2;
        z.a n10 = z.a.n(this, 1.0f, gVar);
        this.f2705l = n10;
        n10.K(1);
        n10.L(f11);
        gVar.q(n10);
        z.a n11 = z.a.n(this, 1.0f, gVar2);
        this.f2706m = n11;
        n11.K(2);
        n11.L(f11);
        gVar2.q(n11);
        setFocusableInTouchMode(true);
        a0.u0(this, 1);
        a0.j0(this, new b());
        setMotionEventSplittingEnabled(false);
        if (a0.w(this)) {
            if (Build.VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new a(this));
                setSystemUiVisibility(1280);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(P);
                try {
                    this.B = obtainStyledAttributes.getDrawable(0);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } else {
                this.B = null;
            }
        }
        this.f2700g = f10 * 10.0f;
        this.M = new ArrayList<>();
    }

    private boolean D(float f10, float f11, View view) {
        if (this.N == null) {
            this.N = new Rect();
        }
        view.getHitRect(this.N);
        return this.N.contains((int) f10, (int) f11);
    }

    private boolean E(Drawable drawable, int i10) {
        if (drawable == null || !androidx.core.graphics.drawable.a.h(drawable)) {
            return false;
        }
        androidx.core.graphics.drawable.a.m(drawable, i10);
        return true;
    }

    private Drawable J() {
        int z10 = a0.z(this);
        if (z10 == 0) {
            Drawable drawable = this.I;
            if (drawable != null) {
                E(drawable, z10);
                return this.I;
            }
        } else {
            Drawable drawable2 = this.J;
            if (drawable2 != null) {
                E(drawable2, z10);
                return this.J;
            }
        }
        return this.K;
    }

    private Drawable K() {
        int z10 = a0.z(this);
        if (z10 == 0) {
            Drawable drawable = this.J;
            if (drawable != null) {
                E(drawable, z10);
                return this.J;
            }
        } else {
            Drawable drawable2 = this.I;
            if (drawable2 != null) {
                E(drawable2, z10);
                return this.I;
            }
        }
        return this.L;
    }

    private void L() {
        if (S) {
            return;
        }
        this.C = J();
        this.D = K();
    }

    private void R(View view, boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            a0.u0(childAt, ((z10 || B(childAt)) && !(z10 && childAt == view)) ? 4 : 1);
        }
    }

    private boolean k(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent t10 = t(motionEvent, view);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(t10);
            t10.recycle();
            return dispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return dispatchGenericMotionEvent2;
    }

    private MotionEvent t(MotionEvent motionEvent, View view) {
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(scrollX, scrollY);
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.O == null) {
                this.O = new Matrix();
            }
            matrix.invert(this.O);
            obtain.transform(this.O);
        }
        return obtain;
    }

    static String u(int i10) {
        return (i10 & 3) == 3 ? "LEFT" : (i10 & 5) == 5 ? "RIGHT" : Integer.toHexString(i10);
    }

    private static boolean v(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    private boolean w() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (((e) getChildAt(i10).getLayoutParams()).f2724c) {
                return true;
            }
        }
        return false;
    }

    private boolean x() {
        return n() != null;
    }

    static boolean y(View view) {
        return (a0.x(view) == 4 || a0.x(view) == 2) ? false : true;
    }

    public boolean A(View view) {
        if (B(view)) {
            return (((e) view.getLayoutParams()).f2725d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    boolean B(View view) {
        int b10 = androidx.core.view.e.b(((e) view.getLayoutParams()).f2722a, a0.z(view));
        return ((b10 & 3) == 0 && (b10 & 5) == 0) ? false : true;
    }

    public boolean C(View view) {
        if (B(view)) {
            return ((e) view.getLayoutParams()).f2723b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    void F(View view, float f10) {
        float s10 = s(view);
        float width = view.getWidth();
        int i10 = ((int) (width * f10)) - ((int) (s10 * width));
        if (!c(view, 3)) {
            i10 = -i10;
        }
        view.offsetLeftAndRight(i10);
        Q(view, f10);
    }

    public void G(View view) {
        H(view, true);
    }

    public void H(View view, boolean z10) {
        if (!B(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        e eVar = (e) view.getLayoutParams();
        if (this.f2711r) {
            eVar.f2723b = 1.0f;
            eVar.f2725d = 1;
            R(view, true);
        } else if (z10) {
            eVar.f2725d |= 2;
            if (c(view, 3)) {
                this.f2705l.O(view, 0, view.getTop());
            } else {
                this.f2706m.O(view, getWidth() - view.getWidth(), view.getTop());
            }
        } else {
            F(view, 1.0f);
            S(eVar.f2722a, 0, view);
            view.setVisibility(0);
        }
        invalidate();
    }

    public void I(d dVar) {
        List<d> list;
        if (dVar == null || (list = this.f2718y) == null) {
            return;
        }
        list.remove(dVar);
    }

    public void M(Object obj, boolean z10) {
        this.G = obj;
        this.H = z10;
        setWillNotDraw(!z10 && getBackground() == null);
        requestLayout();
    }

    public void N(int i10, int i11) {
        View l10;
        int b10 = androidx.core.view.e.b(i11, a0.z(this));
        if (i11 == 3) {
            this.f2712s = i10;
        } else if (i11 == 5) {
            this.f2713t = i10;
        } else if (i11 == 8388611) {
            this.f2714u = i10;
        } else if (i11 == 8388613) {
            this.f2715v = i10;
        }
        if (i10 != 0) {
            (b10 == 3 ? this.f2705l : this.f2706m).a();
        }
        if (i10 != 1) {
            if (i10 == 2 && (l10 = l(b10)) != null) {
                G(l10);
                return;
            }
            return;
        }
        View l11 = l(b10);
        if (l11 != null) {
            d(l11);
        }
    }

    public void O(int i10, int i11) {
        P(androidx.core.content.a.f(getContext(), i10), i11);
    }

    public void P(Drawable drawable, int i10) {
        if (S) {
            return;
        }
        if ((i10 & 8388611) == 8388611) {
            this.I = drawable;
        } else if ((i10 & 8388613) == 8388613) {
            this.J = drawable;
        } else if ((i10 & 3) == 3) {
            this.K = drawable;
        } else if ((i10 & 5) != 5) {
            return;
        } else {
            this.L = drawable;
        }
        L();
        invalidate();
    }

    void Q(View view, float f10) {
        e eVar = (e) view.getLayoutParams();
        if (f10 == eVar.f2723b) {
            return;
        }
        eVar.f2723b = f10;
        j(view, f10);
    }

    void S(int i10, int i11, View view) {
        int z10 = this.f2705l.z();
        int z11 = this.f2706m.z();
        int i12 = 2;
        if (z10 == 1 || z11 == 1) {
            i12 = 1;
        } else if (z10 != 2 && z11 != 2) {
            i12 = 0;
        }
        if (view != null && i11 == 0) {
            float f10 = ((e) view.getLayoutParams()).f2723b;
            if (f10 == 0.0f) {
                h(view);
            } else if (f10 == 1.0f) {
                i(view);
            }
        }
        if (i12 != this.f2709p) {
            this.f2709p = i12;
            List<d> list = this.f2718y;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f2718y.get(size).a(i12);
                }
            }
        }
    }

    public void a(d dVar) {
        if (dVar == null) {
            return;
        }
        if (this.f2718y == null) {
            this.f2718y = new ArrayList();
        }
        this.f2718y.add(dVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z10 = false;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (!B(childAt)) {
                this.M.add(childAt);
            } else if (A(childAt)) {
                childAt.addFocusables(arrayList, i10, i11);
                z10 = true;
            }
        }
        if (!z10) {
            int size = this.M.size();
            for (int i13 = 0; i13 < size; i13++) {
                View view = this.M.get(i13);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i10, i11);
                }
            }
        }
        this.M.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i10, layoutParams);
        a0.u0(view, (m() != null || B(view)) ? 4 : 1);
        if (R) {
            return;
        }
        a0.j0(view, this.f2699f);
    }

    void b() {
        if (this.f2716w) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            getChildAt(i10).dispatchTouchEvent(obtain);
        }
        obtain.recycle();
        this.f2716w = true;
    }

    boolean c(View view, int i10) {
        return (r(view) & i10) == i10;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof e) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float f10 = 0.0f;
        for (int i10 = 0; i10 < childCount; i10++) {
            f10 = Math.max(f10, ((e) getChildAt(i10).getLayoutParams()).f2723b);
        }
        this.f2703j = f10;
        boolean m10 = this.f2705l.m(true);
        boolean m11 = this.f2706m.m(true);
        if (m10 || m11) {
            a0.d0(this);
        }
    }

    public void d(View view) {
        e(view, true);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f2703j <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        for (int i10 = childCount - 1; i10 >= 0; i10--) {
            View childAt = getChildAt(i10);
            if (D(x10, y10, childAt) && !z(childAt) && k(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j10) {
        Drawable drawable;
        int height = getHeight();
        boolean z10 = z(view);
        int width = getWidth();
        int save = canvas.save();
        int i10 = 0;
        if (z10) {
            int childCount = getChildCount();
            int i11 = 0;
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (childAt != view && childAt.getVisibility() == 0 && v(childAt) && B(childAt) && childAt.getHeight() >= height) {
                    if (c(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i11) {
                            i11 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i11, 0, width, getHeight());
            i10 = i11;
        }
        boolean drawChild = super.drawChild(canvas, view, j10);
        canvas.restoreToCount(save);
        float f10 = this.f2703j;
        if (f10 <= 0.0f || !z10) {
            if (this.C != null && c(view, 3)) {
                int intrinsicWidth = this.C.getIntrinsicWidth();
                int right2 = view.getRight();
                float max = Math.max(0.0f, Math.min(right2 / this.f2705l.w(), 1.0f));
                this.C.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
                this.C.setAlpha((int) (max * 255.0f));
                drawable = this.C;
            } else if (this.D != null && c(view, 5)) {
                int intrinsicWidth2 = this.D.getIntrinsicWidth();
                int left2 = view.getLeft();
                float max2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.f2706m.w(), 1.0f));
                this.D.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
                this.D.setAlpha((int) (max2 * 255.0f));
                drawable = this.D;
            }
            drawable.draw(canvas);
        } else {
            this.f2704k.setColor((this.f2702i & 16777215) | (((int) ((((-16777216) & r2) >>> 24) * f10)) << 24));
            canvas.drawRect(i10, 0.0f, width, getHeight(), this.f2704k);
        }
        return drawChild;
    }

    public void e(View view, boolean z10) {
        z.a aVar;
        int width;
        if (!B(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        e eVar = (e) view.getLayoutParams();
        if (this.f2711r) {
            eVar.f2723b = 0.0f;
            eVar.f2725d = 0;
        } else if (z10) {
            eVar.f2725d |= 4;
            if (c(view, 3)) {
                aVar = this.f2705l;
                width = -view.getWidth();
            } else {
                aVar = this.f2706m;
                width = getWidth();
            }
            aVar.O(view, width, view.getTop());
        } else {
            F(view, 0.0f);
            S(eVar.f2722a, 0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    public void f() {
        g(false);
    }

    void g(boolean z10) {
        int childCount = getChildCount();
        boolean z11 = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            e eVar = (e) childAt.getLayoutParams();
            if (B(childAt) && (!z10 || eVar.f2724c)) {
                z11 |= c(childAt, 3) ? this.f2705l.O(childAt, -childAt.getWidth(), childAt.getTop()) : this.f2706m.O(childAt, getWidth(), childAt.getTop());
                eVar.f2724c = false;
            }
        }
        this.f2707n.p();
        this.f2708o.p();
        if (z11) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    public float getDrawerElevation() {
        if (S) {
            return this.f2700g;
        }
        return 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.B;
    }

    void h(View view) {
        View rootView;
        e eVar = (e) view.getLayoutParams();
        if ((eVar.f2725d & 1) == 1) {
            eVar.f2725d = 0;
            List<d> list = this.f2718y;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f2718y.get(size).d(view);
                }
            }
            R(view, false);
            if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                return;
            }
            rootView.sendAccessibilityEvent(32);
        }
    }

    void i(View view) {
        e eVar = (e) view.getLayoutParams();
        if ((eVar.f2725d & 1) == 0) {
            eVar.f2725d = 1;
            List<d> list = this.f2718y;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f2718y.get(size).c(view);
                }
            }
            R(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    void j(View view, float f10) {
        List<d> list = this.f2718y;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f2718y.get(size).b(view, f10);
            }
        }
    }

    View l(int i10) {
        int b10 = androidx.core.view.e.b(i10, a0.z(this)) & 7;
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if ((r(childAt) & 7) == b10) {
                return childAt;
            }
        }
        return null;
    }

    View m() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if ((((e) childAt.getLayoutParams()).f2725d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    View n() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (B(childAt) && C(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public int o(int i10) {
        int z10 = a0.z(this);
        if (i10 == 3) {
            int i11 = this.f2712s;
            if (i11 != 3) {
                return i11;
            }
            int i12 = z10 == 0 ? this.f2714u : this.f2715v;
            if (i12 != 3) {
                return i12;
            }
            return 0;
        }
        if (i10 == 5) {
            int i13 = this.f2713t;
            if (i13 != 3) {
                return i13;
            }
            int i14 = z10 == 0 ? this.f2715v : this.f2714u;
            if (i14 != 3) {
                return i14;
            }
            return 0;
        }
        if (i10 == 8388611) {
            int i15 = this.f2714u;
            if (i15 != 3) {
                return i15;
            }
            int i16 = z10 == 0 ? this.f2712s : this.f2713t;
            if (i16 != 3) {
                return i16;
            }
            return 0;
        }
        if (i10 != 8388613) {
            return 0;
        }
        int i17 = this.f2715v;
        if (i17 != 3) {
            return i17;
        }
        int i18 = z10 == 0 ? this.f2713t : this.f2712s;
        if (i18 != 3) {
            return i18;
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2711r = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2711r = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Object obj;
        super.onDraw(canvas);
        if (!this.H || this.B == null) {
            return;
        }
        int systemWindowInsetTop = (Build.VERSION.SDK_INT < 21 || (obj = this.G) == null) ? 0 : ((WindowInsets) obj).getSystemWindowInsetTop();
        if (systemWindowInsetTop > 0) {
            this.B.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.B.draw(canvas);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if (r0 != 3) goto L13;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            z.a r1 = r6.f2705l
            boolean r1 = r1.N(r7)
            z.a r2 = r6.f2706m
            boolean r2 = r2.N(r7)
            r1 = r1 | r2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L38
            if (r0 == r2) goto L31
            r7 = 2
            r4 = 3
            if (r0 == r7) goto L1e
            if (r0 == r4) goto L31
            goto L36
        L1e:
            z.a r7 = r6.f2705l
            boolean r7 = r7.d(r4)
            if (r7 == 0) goto L36
            androidx.drawerlayout.widget.DrawerLayout$g r7 = r6.f2707n
            r7.p()
            androidx.drawerlayout.widget.DrawerLayout$g r7 = r6.f2708o
            r7.p()
            goto L36
        L31:
            r6.g(r2)
            r6.f2716w = r3
        L36:
            r7 = 0
            goto L60
        L38:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f2719z = r0
            r6.A = r7
            float r4 = r6.f2703j
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L5d
            z.a r4 = r6.f2705l
            int r0 = (int) r0
            int r7 = (int) r7
            android.view.View r7 = r4.t(r0, r7)
            if (r7 == 0) goto L5d
            boolean r7 = r6.z(r7)
            if (r7 == 0) goto L5d
            r7 = 1
            goto L5e
        L5d:
            r7 = 0
        L5e:
            r6.f2716w = r3
        L60:
            if (r1 != 0) goto L70
            if (r7 != 0) goto L70
            boolean r7 = r6.w()
            if (r7 != 0) goto L70
            boolean r7 = r6.f2716w
            if (r7 == 0) goto L6f
            goto L70
        L6f:
            r2 = 0
        L70:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 != 4 || !x()) {
            return super.onKeyDown(i10, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return super.onKeyUp(i10, keyEvent);
        }
        View n10 = n();
        if (n10 != null && p(n10) == 0) {
            f();
        }
        return n10 != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        float f10;
        int i14;
        int measuredHeight;
        int i15;
        int i16;
        this.f2710q = true;
        int i17 = i12 - i10;
        int childCount = getChildCount();
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (z(childAt)) {
                    int i19 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
                    childAt.layout(i19, ((ViewGroup.MarginLayoutParams) eVar).topMargin, childAt.getMeasuredWidth() + i19, ((ViewGroup.MarginLayoutParams) eVar).topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight2 = childAt.getMeasuredHeight();
                    if (c(childAt, 3)) {
                        float f11 = measuredWidth;
                        i14 = (-measuredWidth) + ((int) (eVar.f2723b * f11));
                        f10 = (measuredWidth + i14) / f11;
                    } else {
                        float f12 = measuredWidth;
                        f10 = (i17 - r11) / f12;
                        i14 = i17 - ((int) (eVar.f2723b * f12));
                    }
                    boolean z11 = f10 != eVar.f2723b;
                    int i20 = eVar.f2722a & 112;
                    if (i20 != 16) {
                        if (i20 != 80) {
                            measuredHeight = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                            i15 = measuredWidth + i14;
                            i16 = measuredHeight2 + measuredHeight;
                        } else {
                            int i21 = i13 - i11;
                            measuredHeight = (i21 - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) - childAt.getMeasuredHeight();
                            i15 = measuredWidth + i14;
                            i16 = i21 - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                        }
                        childAt.layout(i14, measuredHeight, i15, i16);
                    } else {
                        int i22 = i13 - i11;
                        int i23 = (i22 - measuredHeight2) / 2;
                        int i24 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                        if (i23 < i24) {
                            i23 = i24;
                        } else {
                            int i25 = i23 + measuredHeight2;
                            int i26 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                            if (i25 > i22 - i26) {
                                i23 = (i22 - i26) - measuredHeight2;
                            }
                        }
                        childAt.layout(i14, i23, measuredWidth + i14, measuredHeight2 + i23);
                    }
                    if (z11) {
                        Q(childAt, f10);
                    }
                    int i27 = eVar.f2723b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i27) {
                        childAt.setVisibility(i27);
                    }
                }
            }
        }
        this.f2710q = false;
        this.f2711r = false;
    }

    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    protected void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
            if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                size2 = 300;
            }
        }
        setMeasuredDimension(size, size2);
        int i12 = 0;
        boolean z10 = this.G != null && a0.w(this);
        int z11 = a0.z(this);
        int childCount = getChildCount();
        int i13 = 0;
        boolean z12 = false;
        boolean z13 = false;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (z10) {
                    int b10 = androidx.core.view.e.b(eVar.f2722a, z11);
                    boolean w10 = a0.w(childAt);
                    int i14 = Build.VERSION.SDK_INT;
                    if (w10) {
                        if (i14 >= 21) {
                            WindowInsets windowInsets = (WindowInsets) this.G;
                            if (b10 == 3) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), i12, windowInsets.getSystemWindowInsetBottom());
                            } else if (b10 == 5) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(i12, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                            }
                            childAt.dispatchApplyWindowInsets(windowInsets);
                        }
                    } else if (i14 >= 21) {
                        WindowInsets windowInsets2 = (WindowInsets) this.G;
                        if (b10 == 3) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), i12, windowInsets2.getSystemWindowInsetBottom());
                        } else if (b10 == 5) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(i12, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) eVar).leftMargin = windowInsets2.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) eVar).topMargin = windowInsets2.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) eVar).rightMargin = windowInsets2.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (z(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) eVar).leftMargin) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) eVar).topMargin) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin, 1073741824));
                } else {
                    if (!B(childAt)) {
                        throw new IllegalStateException("Child " + childAt + " at index " + i13 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                    }
                    if (S) {
                        float t10 = a0.t(childAt);
                        float f10 = this.f2700g;
                        if (t10 != f10) {
                            a0.r0(childAt, f10);
                        }
                    }
                    int r10 = r(childAt) & 7;
                    boolean z14 = r10 == 3;
                    if ((z14 && z12) || (!z14 && z13)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + u(r10) + " but this DrawerLayout already has a drawer view along that edge");
                    }
                    if (z14) {
                        z12 = true;
                    } else {
                        z13 = true;
                    }
                    childAt.measure(ViewGroup.getChildMeasureSpec(i10, this.f2701h + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin, ((ViewGroup.MarginLayoutParams) eVar).width), ViewGroup.getChildMeasureSpec(i11, ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin, ((ViewGroup.MarginLayoutParams) eVar).height));
                    i13++;
                    i12 = 0;
                }
            }
            i13++;
            i12 = 0;
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        View l10;
        if (!(parcelable instanceof f)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.a());
        int i10 = fVar.f2726h;
        if (i10 != 0 && (l10 = l(i10)) != null) {
            G(l10);
        }
        int i11 = fVar.f2727i;
        if (i11 != 3) {
            N(i11, 3);
        }
        int i12 = fVar.f2728j;
        if (i12 != 3) {
            N(i12, 5);
        }
        int i13 = fVar.f2729k;
        if (i13 != 3) {
            N(i13, 8388611);
        }
        int i14 = fVar.f2730l;
        if (i14 != 3) {
            N(i14, 8388613);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
        L();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        f fVar = new f(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            e eVar = (e) getChildAt(i10).getLayoutParams();
            int i11 = eVar.f2725d;
            boolean z10 = i11 == 1;
            boolean z11 = i11 == 2;
            if (z10 || z11) {
                fVar.f2726h = eVar.f2722a;
                break;
            }
        }
        fVar.f2727i = this.f2712s;
        fVar.f2728j = this.f2713t;
        fVar.f2729k = this.f2714u;
        fVar.f2730l = this.f2715v;
        return fVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
    
        if (p(r7) != 2) goto L20;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            z.a r0 = r6.f2705l
            r0.E(r7)
            z.a r0 = r6.f2706m
            r0.E(r7)
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L60
            if (r0 == r2) goto L1e
            r7 = 3
            if (r0 == r7) goto L1a
            goto L6e
        L1a:
            r6.g(r2)
            goto L6c
        L1e:
            float r0 = r7.getX()
            float r7 = r7.getY()
            z.a r3 = r6.f2705l
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r3 = r3.t(r4, r5)
            if (r3 == 0) goto L5b
            boolean r3 = r6.z(r3)
            if (r3 == 0) goto L5b
            float r3 = r6.f2719z
            float r0 = r0 - r3
            float r3 = r6.A
            float r7 = r7 - r3
            z.a r3 = r6.f2705l
            int r3 = r3.y()
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r0 = r0 + r7
            int r3 = r3 * r3
            float r7 = (float) r3
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L5b
            android.view.View r7 = r6.m()
            if (r7 == 0) goto L5b
            int r7 = r6.p(r7)
            r0 = 2
            if (r7 != r0) goto L5c
        L5b:
            r1 = 1
        L5c:
            r6.g(r1)
            goto L6e
        L60:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f2719z = r0
            r6.A = r7
        L6c:
            r6.f2716w = r1
        L6e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public int p(View view) {
        if (B(view)) {
            return o(((e) view.getLayoutParams()).f2722a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public CharSequence q(int i10) {
        int b10 = androidx.core.view.e.b(i10, a0.z(this));
        if (b10 == 3) {
            return this.E;
        }
        if (b10 == 5) {
            return this.F;
        }
        return null;
    }

    int r(View view) {
        return androidx.core.view.e.b(((e) view.getLayoutParams()).f2722a, a0.z(this));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        super.requestDisallowInterceptTouchEvent(z10);
        if (z10) {
            g(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f2710q) {
            return;
        }
        super.requestLayout();
    }

    float s(View view) {
        return ((e) view.getLayoutParams()).f2723b;
    }

    public void setDrawerElevation(float f10) {
        this.f2700g = f10;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (B(childAt)) {
                a0.r0(childAt, this.f2700g);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(d dVar) {
        d dVar2 = this.f2717x;
        if (dVar2 != null) {
            I(dVar2);
        }
        if (dVar != null) {
            a(dVar);
        }
        this.f2717x = dVar;
    }

    public void setDrawerLockMode(int i10) {
        N(i10, 3);
        N(i10, 5);
    }

    public void setScrimColor(int i10) {
        this.f2702i = i10;
        invalidate();
    }

    public void setStatusBarBackground(int i10) {
        this.B = i10 != 0 ? androidx.core.content.a.f(getContext(), i10) : null;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.B = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i10) {
        this.B = new ColorDrawable(i10);
        invalidate();
    }

    boolean z(View view) {
        return ((e) view.getLayoutParams()).f2722a == 0;
    }
}
