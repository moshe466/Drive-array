package androidx.recyclerview.widget;

import F.h;
import F0.C0092v0;
import F0.C0110z2;
import F0.G1;
import F0.b3;
import G.a;
import J.C0129q;
import J.J;
import J.L;
import J.S;
import J.T;
import M0.d;
import Q.c;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.lifecycle.N;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import j0.AbstractC0456a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.WeakHashMap;
import k0.AbstractC0473D;
import k0.C0471B;
import k0.C0472C;
import k0.C0476G;
import k0.C0482f;
import k0.C0483g;
import k0.InterfaceC0470A;
import k0.RunnableC0474E;
import k0.RunnableC0485i;
import k0.o;
import k0.p;
import k0.q;
import k0.r;
import k0.s;
import k0.t;
import k0.u;
import k0.v;
import k0.w;
import k0.x;
import k0.y;
import k0.z;
import kotlin.jvm.internal.j;
import org.apache.tika.utils.StringUtils;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup {

    /* renamed from: k0, reason: collision with root package name */
    public static final int[] f3671k0 = {R.attr.nestedScrollingEnabled};

    /* renamed from: l0, reason: collision with root package name */
    public static final int[] f3672l0 = {R.attr.clipToPadding};

    /* renamed from: m0, reason: collision with root package name */
    public static final Class[] f3673m0;

    /* renamed from: n0, reason: collision with root package name */
    public static final o f3674n0;

    /* renamed from: A, reason: collision with root package name */
    public final int f3675A;

    /* renamed from: B, reason: collision with root package name */
    public r f3676B;

    /* renamed from: C, reason: collision with root package name */
    public EdgeEffect f3677C;

    /* renamed from: D, reason: collision with root package name */
    public EdgeEffect f3678D;

    /* renamed from: E, reason: collision with root package name */
    public EdgeEffect f3679E;

    /* renamed from: F, reason: collision with root package name */
    public EdgeEffect f3680F;

    /* renamed from: G, reason: collision with root package name */
    public s f3681G;

    /* renamed from: H, reason: collision with root package name */
    public int f3682H;

    /* renamed from: I, reason: collision with root package name */
    public int f3683I;

    /* renamed from: J, reason: collision with root package name */
    public VelocityTracker f3684J;

    /* renamed from: K, reason: collision with root package name */
    public int f3685K;

    /* renamed from: L, reason: collision with root package name */
    public int f3686L;

    /* renamed from: M, reason: collision with root package name */
    public int f3687M;

    /* renamed from: N, reason: collision with root package name */
    public int f3688N;

    /* renamed from: O, reason: collision with root package name */
    public int f3689O;

    /* renamed from: P, reason: collision with root package name */
    public final int f3690P;

    /* renamed from: Q, reason: collision with root package name */
    public final int f3691Q;

    /* renamed from: R, reason: collision with root package name */
    public final float f3692R;

    /* renamed from: S, reason: collision with root package name */
    public final float f3693S;

    /* renamed from: T, reason: collision with root package name */
    public boolean f3694T;

    /* renamed from: U, reason: collision with root package name */
    public final RunnableC0474E f3695U;

    /* renamed from: V, reason: collision with root package name */
    public RunnableC0485i f3696V;

    /* renamed from: W, reason: collision with root package name */
    public final C0483g f3697W;

    /* renamed from: a, reason: collision with root package name */
    public final z f3698a;

    /* renamed from: a0, reason: collision with root package name */
    public final C0472C f3699a0;

    /* renamed from: b, reason: collision with root package name */
    public C0471B f3700b;

    /* renamed from: b0, reason: collision with root package name */
    public ArrayList f3701b0;

    /* renamed from: c, reason: collision with root package name */
    public final C0110z2 f3702c;

    /* renamed from: c0, reason: collision with root package name */
    public final N f3703c0;

    /* renamed from: d, reason: collision with root package name */
    public final b3 f3704d;

    /* renamed from: d0, reason: collision with root package name */
    public C0476G f3705d0;

    /* renamed from: e, reason: collision with root package name */
    public final N f3706e;

    /* renamed from: e0, reason: collision with root package name */
    public C0129q f3707e0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3708f;

    /* renamed from: f0, reason: collision with root package name */
    public final int[] f3709f0;

    /* renamed from: g0, reason: collision with root package name */
    public final int[] f3710g0;

    /* renamed from: h0, reason: collision with root package name */
    public final int[] f3711h0;

    /* renamed from: i0, reason: collision with root package name */
    public final ArrayList f3712i0;

    /* renamed from: j, reason: collision with root package name */
    public final Rect f3713j;

    /* renamed from: j0, reason: collision with root package name */
    public final a f3714j0;

    /* renamed from: k, reason: collision with root package name */
    public final Rect f3715k;

    /* renamed from: l, reason: collision with root package name */
    public t f3716l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f3717m;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList f3718n;

    /* renamed from: o, reason: collision with root package name */
    public C0482f f3719o;
    public boolean p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f3720q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f3721r;

    /* renamed from: s, reason: collision with root package name */
    public int f3722s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f3723t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f3724u;

    /* renamed from: v, reason: collision with root package name */
    public int f3725v;

    /* renamed from: w, reason: collision with root package name */
    public final AccessibilityManager f3726w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f3727x;
    public boolean y;

    /* renamed from: z, reason: collision with root package name */
    public int f3728z;

    /* JADX WARN: Type inference failed for: r0v6, types: [k0.o, java.lang.Object] */
    static {
        Class cls = Integer.TYPE;
        f3673m0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        f3674n0 = new Object();
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [k0.r, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v8, types: [k0.b, java.lang.Object, k0.s] */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.Object, k0.g] */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.lang.Object, k0.C] */
    public RecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        float a2;
        float a4;
        boolean z3;
        int i;
        ClassLoader classLoader;
        Constructor constructor;
        this.f3698a = new z(this);
        this.f3706e = new N();
        this.f3713j = new Rect();
        this.f3715k = new Rect();
        new RectF();
        this.f3717m = new ArrayList();
        this.f3718n = new ArrayList();
        this.f3722s = 0;
        this.f3727x = false;
        this.y = false;
        this.f3728z = 0;
        this.f3675A = 0;
        this.f3676B = new Object();
        ?? obj = new Object();
        Object[] objArr = null;
        obj.f5264a = null;
        obj.f5265b = new ArrayList();
        obj.f5266c = 250L;
        obj.f5267d = 250L;
        obj.f5203e = new ArrayList();
        obj.f5204f = new ArrayList();
        obj.f5205g = new ArrayList();
        obj.f5206h = new ArrayList();
        obj.i = new ArrayList();
        obj.f5207j = new ArrayList();
        obj.f5208k = new ArrayList();
        obj.f5209l = new ArrayList();
        obj.f5210m = new ArrayList();
        obj.f5211n = new ArrayList();
        obj.f5212o = new ArrayList();
        this.f3681G = obj;
        this.f3682H = 0;
        this.f3683I = -1;
        this.f3692R = Float.MIN_VALUE;
        this.f3693S = Float.MIN_VALUE;
        boolean z4 = true;
        this.f3694T = true;
        this.f3695U = new RunnableC0474E(this);
        this.f3697W = new Object();
        ?? obj2 = new Object();
        obj2.f5164a = 0;
        obj2.f5165b = false;
        obj2.f5166c = false;
        obj2.f5167d = false;
        obj2.f5168e = false;
        this.f3699a0 = obj2;
        N n4 = new N(21);
        this.f3703c0 = n4;
        this.f3709f0 = new int[2];
        this.f3710g0 = new int[2];
        this.f3711h0 = new int[2];
        this.f3712i0 = new ArrayList();
        this.f3714j0 = new a(this, 5);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3672l0, 0, 0);
            this.f3708f = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.f3708f = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f3689O = viewConfiguration.getScaledTouchSlop();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            Method method = T.f959a;
            a2 = B.a.d(viewConfiguration);
        } else {
            a2 = T.a(viewConfiguration, context);
        }
        this.f3692R = a2;
        if (i3 >= 26) {
            a4 = B.a.e(viewConfiguration);
        } else {
            a4 = T.a(viewConfiguration, context);
        }
        this.f3693S = a4;
        this.f3690P = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3691Q = viewConfiguration.getScaledMaximumFlingVelocity();
        if (getOverScrollMode() == 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        setWillNotDraw(z3);
        this.f3681G.f5264a = n4;
        this.f3702c = new C0110z2(new N(this, 20));
        this.f3704d = new b3(new G1(this, 19));
        WeakHashMap weakHashMap = S.f954a;
        if (i3 >= 26) {
            i = L.a(this);
        } else {
            i = 0;
        }
        if (i == 0 && i3 >= 26) {
            L.b(this, 8);
        }
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.f3726w = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new C0476G(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, AbstractC0456a.f5099a, 0, 0);
            String string = obtainStyledAttributes2.getString(7);
            if (obtainStyledAttributes2.getInt(1, -1) == -1) {
                setDescendantFocusability(262144);
            }
            if (obtainStyledAttributes2.getBoolean(2, false)) {
                StateListDrawable stateListDrawable = (StateListDrawable) obtainStyledAttributes2.getDrawable(5);
                Drawable drawable = obtainStyledAttributes2.getDrawable(6);
                StateListDrawable stateListDrawable2 = (StateListDrawable) obtainStyledAttributes2.getDrawable(3);
                Drawable drawable2 = obtainStyledAttributes2.getDrawable(4);
                if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
                    Resources resources = getContext().getResources();
                    new C0482f(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(com.uh.sf.R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(com.uh.sf.R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(com.uh.sf.R.dimen.fastscroll_margin));
                } else {
                    throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + h());
                }
            }
            obtainStyledAttributes2.recycle();
            if (string != null) {
                String trim = string.trim();
                if (!trim.isEmpty()) {
                    if (trim.charAt(0) == '.') {
                        trim = context.getPackageName() + trim;
                    } else if (!trim.contains(".")) {
                        trim = RecyclerView.class.getPackage().getName() + '.' + trim;
                    }
                    String str = trim;
                    try {
                        if (isInEditMode()) {
                            classLoader = getClass().getClassLoader();
                        } else {
                            classLoader = context.getClassLoader();
                        }
                        Class<? extends U> asSubclass = classLoader.loadClass(str).asSubclass(t.class);
                        try {
                            constructor = asSubclass.getConstructor(f3673m0);
                            objArr = new Object[]{context, attributeSet, 0, 0};
                        } catch (NoSuchMethodException e4) {
                            try {
                                constructor = asSubclass.getConstructor(null);
                            } catch (NoSuchMethodException e5) {
                                e5.initCause(e4);
                                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + str, e5);
                            }
                        }
                        constructor.setAccessible(true);
                        setLayoutManager((t) constructor.newInstance(objArr));
                    } catch (ClassCastException e6) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + str, e6);
                    } catch (ClassNotFoundException e7) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + str, e7);
                    } catch (IllegalAccessException e8) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + str, e8);
                    } catch (InstantiationException e9) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e9);
                    } catch (InvocationTargetException e10) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e10);
                    }
                }
            }
            TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f3671k0, 0, 0);
            z4 = obtainStyledAttributes3.getBoolean(0, true);
            obtainStyledAttributes3.recycle();
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z4);
    }

    private C0129q getScrollingChildHelper() {
        if (this.f3707e0 == null) {
            this.f3707e0 = new C0129q(this);
        }
        return this.f3707e0;
    }

    public static void j(View view) {
        if (view == null) {
            return;
        }
        ((u) view.getLayoutParams()).getClass();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i, int i3) {
        t tVar = this.f3716l;
        if (tVar != null) {
            tVar.getClass();
        }
        super.addFocusables(arrayList, i, i3);
    }

    public final void b(String str) {
        if (this.f3728z > 0) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + h());
            }
            throw new IllegalStateException(str);
        }
        if (this.f3675A > 0) {
            new IllegalStateException("" + h());
        }
    }

    public final void c(int i, int i3) {
        boolean z3;
        EdgeEffect edgeEffect = this.f3677C;
        if (edgeEffect != null && !edgeEffect.isFinished() && i > 0) {
            this.f3677C.onRelease();
            z3 = this.f3677C.isFinished();
        } else {
            z3 = false;
        }
        EdgeEffect edgeEffect2 = this.f3679E;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.f3679E.onRelease();
            z3 |= this.f3679E.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f3678D;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.f3678D.onRelease();
            z3 |= this.f3678D.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f3680F;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.f3680F.onRelease();
            z3 |= this.f3680F.isFinished();
        }
        if (z3) {
            WeakHashMap weakHashMap = S.f954a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof u) && this.f3716l.d((u) layoutParams)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        t tVar = this.f3716l;
        if (tVar != null && tVar.b()) {
            return this.f3716l.f(this.f3699a0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        t tVar = this.f3716l;
        if (tVar != null && tVar.b()) {
            this.f3716l.g(this.f3699a0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        t tVar = this.f3716l;
        if (tVar != null && tVar.b()) {
            return this.f3716l.h(this.f3699a0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        t tVar = this.f3716l;
        if (tVar != null && tVar.c()) {
            return this.f3716l.i(this.f3699a0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        t tVar = this.f3716l;
        if (tVar != null && tVar.c()) {
            this.f3716l.j(this.f3699a0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        t tVar = this.f3716l;
        if (tVar != null && tVar.c()) {
            return this.f3716l.k(this.f3699a0);
        }
        return 0;
    }

    public final void d() {
        if (this.f3721r && !this.f3727x) {
            C0110z2 c0110z2 = this.f3702c;
            if (((ArrayList) c0110z2.f730c).size() > 0) {
                c0110z2.getClass();
                if (((ArrayList) c0110z2.f730c).size() > 0) {
                    int i = h.f164a;
                    Trace.beginSection("RV FullInvalidate");
                    Log.e("RecyclerView", "No adapter attached; skipping layout");
                    Trace.endSection();
                    return;
                }
                return;
            }
            return;
        }
        int i3 = h.f164a;
        Trace.beginSection("RV FullInvalidate");
        Log.e("RecyclerView", "No adapter attached; skipping layout");
        Trace.endSection();
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f4, float f5, boolean z3) {
        return getScrollingChildHelper().a(f4, f5, z3);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f4, float f5) {
        return getScrollingChildHelper().b(f4, f5);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i, i3, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().d(i, i3, i4, i5, iArr, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        boolean z3;
        boolean z4;
        int i;
        boolean z5;
        boolean z6;
        int i3;
        super.draw(canvas);
        ArrayList arrayList = this.f3717m;
        int size = arrayList.size();
        boolean z7 = false;
        int i4 = 0;
        while (true) {
            z3 = true;
            if (i4 >= size) {
                break;
            }
            C0482f c0482f = (C0482f) arrayList.get(i4);
            if (c0482f.f5228l == c0482f.f5230n.getWidth() && c0482f.f5229m == c0482f.f5230n.getHeight()) {
                if (c0482f.f5237v != 0) {
                    if (c0482f.f5231o) {
                        int i5 = c0482f.f5228l;
                        int i6 = c0482f.f5221d;
                        int i7 = i5 - i6;
                        int i8 = 0 - (0 / 2);
                        StateListDrawable stateListDrawable = c0482f.f5219b;
                        stateListDrawable.setBounds(0, 0, i6, 0);
                        Drawable drawable = c0482f.f5220c;
                        drawable.setBounds(0, 0, c0482f.f5222e, c0482f.f5229m);
                        RecyclerView recyclerView = c0482f.f5230n;
                        WeakHashMap weakHashMap = S.f954a;
                        if (recyclerView.getLayoutDirection() == 1) {
                            drawable.draw(canvas);
                            canvas.translate(i6, i8);
                            canvas.scale(-1.0f, 1.0f);
                            stateListDrawable.draw(canvas);
                            canvas.scale(1.0f, 1.0f);
                            canvas.translate(-i6, -i8);
                        } else {
                            canvas.translate(i7, 0.0f);
                            drawable.draw(canvas);
                            canvas.translate(0.0f, i8);
                            stateListDrawable.draw(canvas);
                            canvas.translate(-i7, -i8);
                        }
                    }
                    if (c0482f.p) {
                        int i9 = c0482f.f5229m;
                        int i10 = c0482f.f5225h;
                        int i11 = i9 - i10;
                        StateListDrawable stateListDrawable2 = c0482f.f5223f;
                        stateListDrawable2.setBounds(0, 0, 0, i10);
                        Drawable drawable2 = c0482f.f5224g;
                        drawable2.setBounds(0, 0, c0482f.f5228l, c0482f.i);
                        canvas.translate(0.0f, i11);
                        drawable2.draw(canvas);
                        canvas.translate(0 - (0 / 2), 0.0f);
                        stateListDrawable2.draw(canvas);
                        canvas.translate(-r8, -i11);
                    }
                }
            } else {
                c0482f.f5228l = c0482f.f5230n.getWidth();
                c0482f.f5229m = c0482f.f5230n.getHeight();
                c0482f.e(0);
            }
            i4++;
        }
        EdgeEffect edgeEffect = this.f3677C;
        if (edgeEffect != null && !edgeEffect.isFinished()) {
            int save = canvas.save();
            if (this.f3708f) {
                i3 = getPaddingBottom();
            } else {
                i3 = 0;
            }
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + i3, 0.0f);
            EdgeEffect edgeEffect2 = this.f3677C;
            if (edgeEffect2 != null && edgeEffect2.draw(canvas)) {
                z4 = true;
            } else {
                z4 = false;
            }
            canvas.restoreToCount(save);
        } else {
            z4 = false;
        }
        EdgeEffect edgeEffect3 = this.f3678D;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.f3708f) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.f3678D;
            if (edgeEffect4 != null && edgeEffect4.draw(canvas)) {
                z6 = true;
            } else {
                z6 = false;
            }
            z4 |= z6;
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.f3679E;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            if (this.f3708f) {
                i = getPaddingTop();
            } else {
                i = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate(-i, -width);
            EdgeEffect edgeEffect6 = this.f3679E;
            if (edgeEffect6 != null && edgeEffect6.draw(canvas)) {
                z5 = true;
            } else {
                z5 = false;
            }
            z4 |= z5;
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.f3680F;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f3708f) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.f3680F;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z7 = true;
            }
            z4 |= z7;
            canvas.restoreToCount(save4);
        }
        if (z4 || this.f3681G == null || arrayList.size() <= 0 || !this.f3681G.b()) {
            z3 = z4;
        }
        if (z3) {
            WeakHashMap weakHashMap2 = S.f954a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public final void e(int i, int i3) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        WeakHashMap weakHashMap = S.f954a;
        setMeasuredDimension(t.e(i, paddingRight, getMinimumWidth()), t.e(i3, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    public final boolean f(int i, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().c(i, i3, iArr, iArr2, i4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c2, code lost:
    
        if (r4 > 0) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e0, code lost:
    
        if (r7 > 0) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e3, code lost:
    
        if (r4 < 0) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00e6, code lost:
    
        if (r7 < 0) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ee, code lost:
    
        if ((r7 * r1) < 0) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00f6, code lost:
    
        if ((r7 * r1) > 0) goto L83;
     */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View focusSearch(android.view.View r13, int r14) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.focusSearch(android.view.View, int):android.view.View");
    }

    public final boolean g(int i, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().d(0, 0, 0, 0, iArr, i6, null);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        t tVar = this.f3716l;
        if (tVar != null) {
            return tVar.l();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + h());
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        t tVar = this.f3716l;
        if (tVar != null) {
            return tVar.m(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + h());
    }

    public p getAdapter() {
        return null;
    }

    @Override // android.view.View
    public int getBaseline() {
        t tVar = this.f3716l;
        if (tVar != null) {
            tVar.getClass();
            return -1;
        }
        return super.getBaseline();
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i, int i3) {
        return super.getChildDrawingOrder(i, i3);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f3708f;
    }

    public C0476G getCompatAccessibilityDelegate() {
        return this.f3705d0;
    }

    public r getEdgeEffectFactory() {
        return this.f3676B;
    }

    public s getItemAnimator() {
        return this.f3681G;
    }

    public int getItemDecorationCount() {
        return this.f3717m.size();
    }

    public t getLayoutManager() {
        return this.f3716l;
    }

    public int getMaxFlingVelocity() {
        return this.f3691Q;
    }

    public int getMinFlingVelocity() {
        return this.f3690P;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public v getOnFlingListener() {
        return null;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f3694T;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [k0.y, java.lang.Object] */
    public y getRecycledViewPool() {
        z zVar = this.f3698a;
        if (zVar.f5284f == null) {
            ?? obj = new Object();
            obj.f5277a = new SparseArray();
            obj.f5278b = 0;
            zVar.f5284f = obj;
        }
        return zVar.f5284f;
    }

    public int getScrollState() {
        return this.f3682H;
    }

    public final String h() {
        return StringUtils.SPACE + super.toString() + ", adapter:null, layout:" + this.f3716l + ", context:" + getContext();
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().f(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View i(android.view.View r3) {
        /*
            r2 = this;
            android.view.ViewParent r0 = r3.getParent()
        L4:
            if (r0 == 0) goto L14
            if (r0 == r2) goto L14
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L14
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            android.view.ViewParent r0 = r3.getParent()
            goto L4
        L14:
            if (r0 != r2) goto L17
            return r3
        L17:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.i(android.view.View):android.view.View");
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return this.p;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().f1026d;
    }

    public final boolean k(int i) {
        return getScrollingChildHelper().f(1);
    }

    public final boolean l() {
        if (this.f3721r && !this.f3727x && ((ArrayList) this.f3702c.f730c).size() <= 0) {
            return false;
        }
        return true;
    }

    public final void m() {
        int s3 = this.f3704d.s();
        for (int i = 0; i < s3; i++) {
            ((u) this.f3704d.r(i).getLayoutParams()).f5276b = true;
        }
        ArrayList arrayList = this.f3698a.f5280b;
        if (arrayList.size() > 0) {
            throw e0.a.b(0, arrayList);
        }
    }

    public final void n(MotionEvent motionEvent) {
        int i;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f3683I) {
            if (actionIndex == 0) {
                i = 1;
            } else {
                i = 0;
            }
            this.f3683I = motionEvent.getPointerId(i);
            int x3 = (int) (motionEvent.getX(i) + 0.5f);
            this.f3687M = x3;
            this.f3685K = x3;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.f3688N = y;
            this.f3686L = y;
        }
    }

    public final void o(View view, View view2) {
        View view3;
        boolean z3;
        if (view2 != null) {
            view3 = view2;
        } else {
            view3 = view;
        }
        int width = view3.getWidth();
        int height = view3.getHeight();
        Rect rect = this.f3713j;
        rect.set(0, 0, width, height);
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof u) {
            u uVar = (u) layoutParams;
            if (!uVar.f5276b) {
                Rect rect2 = uVar.f5275a;
                rect.left -= rect2.left;
                rect.right += rect2.right;
                rect.top -= rect2.top;
                rect.bottom += rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, rect);
            offsetRectIntoDescendantCoords(view, rect);
        }
        t tVar = this.f3716l;
        boolean z4 = !this.f3721r;
        if (view2 == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        tVar.G(this, view, this.f3713j, z4, z3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
    
        if (r1 >= 30.0f) goto L19;
     */
    /* JADX WARN: Type inference failed for: r1v3, types: [k0.i, java.lang.Object] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.f3728z = r0
            r1 = 1
            r5.p = r1
            boolean r2 = r5.f3721r
            if (r2 == 0) goto L14
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L14
            r0 = r1
        L14:
            r5.f3721r = r0
            k0.t r0 = r5.f3716l
            if (r0 == 0) goto L1c
            r0.f5272e = r1
        L1c:
            java.lang.ThreadLocal r0 = k0.RunnableC0485i.f5247e
            java.lang.Object r1 = r0.get()
            k0.i r1 = (k0.RunnableC0485i) r1
            r5.f3696V = r1
            if (r1 != 0) goto L64
            k0.i r1 = new k0.i
            r1.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f5249a = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f5252d = r2
            r5.f3696V = r1
            java.util.WeakHashMap r1 = J.S.f954a
            android.view.Display r1 = r5.getDisplay()
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L56
            if (r1 == 0) goto L56
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L56
            goto L58
        L56:
            r1 = 1114636288(0x42700000, float:60.0)
        L58:
            k0.i r2 = r5.f3696V
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f5251c = r3
            r0.set(r2)
        L64:
            k0.i r0 = r5.f3696V
            java.util.ArrayList r0 = r0.f5249a
            r0.add(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Object obj;
        super.onDetachedFromWindow();
        s sVar = this.f3681G;
        if (sVar != null) {
            sVar.a();
        }
        setScrollState(0);
        RunnableC0474E runnableC0474E = this.f3695U;
        runnableC0474E.f5175j.removeCallbacks(runnableC0474E);
        runnableC0474E.f5171c.abortAnimation();
        this.p = false;
        t tVar = this.f3716l;
        if (tVar != null) {
            tVar.f5272e = false;
            tVar.z(this);
        }
        this.f3712i0.clear();
        removeCallbacks(this.f3714j0);
        this.f3706e.getClass();
        do {
            C0092v0 c0092v0 = k0.N.f5202a;
            Object[] objArr = (Object[]) c0092v0.f693b;
            int i = c0092v0.f692a;
            obj = null;
            if (i > 0) {
                int i3 = i - 1;
                Object obj2 = objArr[i3];
                j.c(obj2, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
                objArr[i3] = null;
                c0092v0.f692a--;
                obj = obj2;
            }
        } while (obj != null);
        RunnableC0485i runnableC0485i = this.f3696V;
        if (runnableC0485i != null) {
            runnableC0485i.f5249a.remove(this);
            this.f3696V = null;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList arrayList = this.f3717m;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((C0482f) arrayList.get(i)).getClass();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            k0.t r0 = r5.f3716l
            r1 = 0
            if (r0 != 0) goto L7
            goto L79
        L7:
            boolean r0 = r5.f3723t
            if (r0 == 0) goto Ld
            goto L79
        Ld:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L79
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L40
            k0.t r0 = r5.f3716l
            boolean r0 = r0.c()
            if (r0 == 0) goto L2e
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2f
        L2e:
            r0 = r2
        L2f:
            k0.t r3 = r5.f3716l
            boolean r3 = r3.b()
            if (r3 == 0) goto L3e
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L66
        L3e:
            r3 = r2
            goto L66
        L40:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L64
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            k0.t r3 = r5.f3716l
            boolean r3 = r3.c()
            if (r3 == 0) goto L59
            float r0 = -r0
            goto L3e
        L59:
            k0.t r3 = r5.f3716l
            boolean r3 = r3.b()
            if (r3 == 0) goto L64
            r3 = r0
            r0 = r2
            goto L66
        L64:
            r0 = r2
            r3 = r0
        L66:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6e
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L79
        L6e:
            float r2 = r5.f3692R
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.f3693S
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.q(r2, r0, r6)
        L79:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z3;
        if (!this.f3723t) {
            int action = motionEvent.getAction();
            if (action == 3 || action == 0) {
                this.f3719o = null;
            }
            ArrayList arrayList = this.f3718n;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                C0482f c0482f = (C0482f) arrayList.get(i);
                if (c0482f.c(motionEvent) && action != 3) {
                    this.f3719o = c0482f;
                    p();
                    setScrollState(0);
                    return true;
                }
            }
            t tVar = this.f3716l;
            if (tVar != null) {
                boolean b4 = tVar.b();
                boolean c4 = this.f3716l.c();
                if (this.f3684J == null) {
                    this.f3684J = VelocityTracker.obtain();
                }
                this.f3684J.addMovement(motionEvent);
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                if (actionMasked != 0) {
                    if (actionMasked != 1) {
                        if (actionMasked != 2) {
                            if (actionMasked != 3) {
                                if (actionMasked != 5) {
                                    if (actionMasked == 6) {
                                        n(motionEvent);
                                    }
                                } else {
                                    this.f3683I = motionEvent.getPointerId(actionIndex);
                                    int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                                    this.f3687M = x3;
                                    this.f3685K = x3;
                                    int y = (int) (motionEvent.getY(actionIndex) + 0.5f);
                                    this.f3688N = y;
                                    this.f3686L = y;
                                }
                            } else {
                                p();
                                setScrollState(0);
                            }
                        } else {
                            int findPointerIndex = motionEvent.findPointerIndex(this.f3683I);
                            if (findPointerIndex < 0) {
                                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f3683I + " not found. Did any MotionEvents get skipped?");
                                return false;
                            }
                            int x4 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                            int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                            if (this.f3682H != 1) {
                                int i3 = x4 - this.f3685K;
                                int i4 = y3 - this.f3686L;
                                if (b4 != 0 && Math.abs(i3) > this.f3689O) {
                                    this.f3687M = x4;
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (c4 && Math.abs(i4) > this.f3689O) {
                                    this.f3688N = y3;
                                    z3 = true;
                                }
                                if (z3) {
                                    setScrollState(1);
                                }
                            }
                        }
                    } else {
                        this.f3684J.clear();
                        s(0);
                    }
                } else {
                    if (this.f3724u) {
                        this.f3724u = false;
                    }
                    this.f3683I = motionEvent.getPointerId(0);
                    int x5 = (int) (motionEvent.getX() + 0.5f);
                    this.f3687M = x5;
                    this.f3685K = x5;
                    int y4 = (int) (motionEvent.getY() + 0.5f);
                    this.f3688N = y4;
                    this.f3686L = y4;
                    if (this.f3682H == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                    int[] iArr = this.f3711h0;
                    iArr[1] = 0;
                    iArr[0] = 0;
                    int i5 = b4;
                    if (c4) {
                        i5 = (b4 ? 1 : 0) | 2;
                    }
                    getScrollingChildHelper().g(i5, 0);
                }
                if (this.f3682H == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z3, int i, int i3, int i4, int i5) {
        int i6 = h.f164a;
        Trace.beginSection("RV OnLayout");
        Log.e("RecyclerView", "No adapter attached; skipping layout");
        Trace.endSection();
        this.f3721r = true;
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i3) {
        t tVar = this.f3716l;
        if (tVar == null) {
            e(i, i3);
            return;
        }
        if (tVar.y()) {
            View.MeasureSpec.getMode(i);
            View.MeasureSpec.getMode(i3);
            this.f3716l.f5269b.e(i, i3);
        } else {
            if (this.f3720q) {
                this.f3716l.f5269b.e(i, i3);
                return;
            }
            C0472C c0472c = this.f3699a0;
            if (c0472c.f5168e) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            c0472c.getClass();
            this.f3722s++;
            this.f3716l.f5269b.e(i, i3);
            if (this.f3722s < 1) {
                this.f3722s = 1;
            }
            this.f3722s--;
            c0472c.f5166c = false;
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (this.f3728z > 0) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof C0471B)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0471B c0471b = (C0471B) parcelable;
        this.f3700b = c0471b;
        super.onRestoreInstanceState(c0471b.f1721a);
        t tVar = this.f3716l;
        if (tVar != null && (parcelable2 = this.f3700b.f5163c) != null) {
            tVar.B(parcelable2);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, Q.c, k0.B] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ?? cVar = new c(super.onSaveInstanceState());
        C0471B c0471b = this.f3700b;
        if (c0471b != null) {
            cVar.f5163c = c0471b.f5163c;
            return cVar;
        }
        t tVar = this.f3716l;
        if (tVar != null) {
            cVar.f5163c = tVar.C();
            return cVar;
        }
        cVar.f5163c = null;
        return cVar;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i3, int i4, int i5) {
        super.onSizeChanged(i, i3, i4, i5);
        if (i == i4 && i3 == i5) {
            return;
        }
        this.f3680F = null;
        this.f3678D = null;
        this.f3679E = null;
        this.f3677C = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0241  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r22) {
        /*
            Method dump skipped, instructions count: 856
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p() {
        VelocityTracker velocityTracker = this.f3684J;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean z3 = false;
        s(0);
        EdgeEffect edgeEffect = this.f3677C;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z3 = this.f3677C.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f3678D;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z3 |= this.f3678D.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f3679E;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z3 |= this.f3679E.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f3680F;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z3 |= this.f3680F.isFinished();
        }
        if (z3) {
            WeakHashMap weakHashMap = S.f954a;
            postInvalidateOnAnimation();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0178  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(int r12, int r13, android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 495
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.q(int, int, android.view.MotionEvent):void");
    }

    public final void r(int i, int i3) {
        int i4;
        int i5;
        boolean z3;
        int height;
        int i6;
        t tVar = this.f3716l;
        if (tVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (!this.f3723t) {
            if (!tVar.b()) {
                i4 = 0;
            } else {
                i4 = i;
            }
            if (!this.f3716l.c()) {
                i5 = 0;
            } else {
                i5 = i3;
            }
            if (i4 == 0 && i5 == 0) {
                return;
            }
            RunnableC0474E runnableC0474E = this.f3695U;
            RecyclerView recyclerView = runnableC0474E.f5175j;
            int abs = Math.abs(i4);
            int abs2 = Math.abs(i5);
            if (abs > abs2) {
                z3 = true;
            } else {
                z3 = false;
            }
            int sqrt = (int) Math.sqrt(0);
            int sqrt2 = (int) Math.sqrt((i5 * i5) + (i4 * i4));
            if (z3) {
                height = recyclerView.getWidth();
            } else {
                height = recyclerView.getHeight();
            }
            int i7 = height / 2;
            float f4 = height;
            float f5 = i7;
            float sin = (((float) Math.sin((Math.min(1.0f, (sqrt2 * 1.0f) / f4) - 0.5f) * 0.47123894f)) * f5) + f5;
            if (sqrt > 0) {
                i6 = Math.round(Math.abs(sin / sqrt) * 1000.0f) * 4;
            } else {
                if (!z3) {
                    abs = abs2;
                }
                i6 = (int) (((abs / f4) + 1.0f) * 300.0f);
            }
            int min = Math.min(i6, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE);
            Interpolator interpolator = runnableC0474E.f5172d;
            o oVar = f3674n0;
            if (interpolator != oVar) {
                runnableC0474E.f5172d = oVar;
                runnableC0474E.f5171c = new OverScroller(recyclerView.getContext(), oVar);
            }
            recyclerView.setScrollState(2);
            runnableC0474E.f5170b = 0;
            runnableC0474E.f5169a = 0;
            runnableC0474E.f5171c.startScroll(0, 0, i4, i5, min);
            runnableC0474E.a();
        }
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z3) {
        j(view);
        view.clearAnimation();
        j(view);
        super.removeDetachedView(view, z3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        this.f3716l.getClass();
        if (this.f3728z <= 0 && view2 != null) {
            o(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z3) {
        return this.f3716l.G(this, view, rect, z3, false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z3) {
        ArrayList arrayList = this.f3718n;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((C0482f) arrayList.get(i)).getClass();
        }
        super.requestDisallowInterceptTouchEvent(z3);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.f3722s == 0 && !this.f3723t) {
            super.requestLayout();
        }
    }

    public final void s(int i) {
        getScrollingChildHelper().h(i);
    }

    @Override // android.view.View
    public final void scrollBy(int i, int i3) {
        t tVar = this.f3716l;
        if (tVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (!this.f3723t) {
            boolean b4 = tVar.b();
            boolean c4 = this.f3716l.c();
            if (!b4 && !c4) {
                return;
            }
            if (!b4) {
                i = 0;
            }
            if (!c4) {
                i3 = 0;
            }
            q(i, i3, null);
        }
    }

    @Override // android.view.View
    public final void scrollTo(int i, int i3) {
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        int i;
        if (this.f3728z > 0) {
            int i3 = 0;
            if (accessibilityEvent != null) {
                i = accessibilityEvent.getContentChangeTypes();
            } else {
                i = 0;
            }
            if (i != 0) {
                i3 = i;
            }
            this.f3725v |= i3;
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(C0476G c0476g) {
        this.f3705d0 = c0476g;
        S.i(this, c0476g);
    }

    /* JADX WARN: Type inference failed for: r0v22, types: [k0.y, java.lang.Object] */
    public void setAdapter(p pVar) {
        setLayoutFrozen(false);
        s sVar = this.f3681G;
        if (sVar != null) {
            sVar.a();
        }
        t tVar = this.f3716l;
        z zVar = this.f3698a;
        if (tVar != null) {
            tVar.E();
            this.f3716l.F(zVar);
        }
        zVar.f5279a.clear();
        ArrayList arrayList = zVar.f5280b;
        int size = arrayList.size() - 1;
        if (size < 0) {
            arrayList.clear();
            C0483g c0483g = zVar.f5285g.f3697W;
            c0483g.getClass();
            c0483g.f5241c = 0;
            C0110z2 c0110z2 = this.f3702c;
            c0110z2.u((ArrayList) c0110z2.f730c);
            c0110z2.u((ArrayList) c0110z2.f731d);
            ArrayList arrayList2 = zVar.f5279a;
            RecyclerView recyclerView = zVar.f5285g;
            ArrayList arrayList3 = zVar.f5280b;
            arrayList2.clear();
            int size2 = arrayList3.size() - 1;
            if (size2 < 0) {
                arrayList3.clear();
                C0483g c0483g2 = recyclerView.f3697W;
                c0483g2.getClass();
                c0483g2.f5241c = 0;
                if (zVar.f5284f == null) {
                    ?? obj = new Object();
                    obj.f5277a = new SparseArray();
                    obj.f5278b = 0;
                    zVar.f5284f = obj;
                }
                y yVar = zVar.f5284f;
                if (yVar.f5278b == 0) {
                    SparseArray sparseArray = yVar.f5277a;
                    if (sparseArray.size() > 0) {
                        ((x) sparseArray.valueAt(0)).getClass();
                        throw null;
                    }
                }
                this.f3699a0.f5165b = true;
                this.y = this.y;
                this.f3727x = true;
                int s3 = this.f3704d.s();
                for (int i = 0; i < s3; i++) {
                    j(this.f3704d.r(i));
                }
                m();
                int size3 = arrayList3.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    if (arrayList3.get(i3) != null) {
                        throw new ClassCastException();
                    }
                }
                int size4 = arrayList3.size() - 1;
                if (size4 < 0) {
                    arrayList3.clear();
                    C0483g c0483g3 = recyclerView.f3697W;
                    c0483g3.getClass();
                    c0483g3.f5241c = 0;
                    requestLayout();
                    return;
                }
                throw e0.a.b(size4, arrayList3);
            }
            throw e0.a.b(size2, arrayList3);
        }
        throw e0.a.b(size, arrayList);
    }

    public void setChildDrawingOrderCallback(q qVar) {
        if (qVar == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z3) {
        if (z3 != this.f3708f) {
            this.f3680F = null;
            this.f3678D = null;
            this.f3679E = null;
            this.f3677C = null;
        }
        this.f3708f = z3;
        super.setClipToPadding(z3);
        if (this.f3721r) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(r rVar) {
        rVar.getClass();
        this.f3676B = rVar;
        this.f3680F = null;
        this.f3678D = null;
        this.f3679E = null;
        this.f3677C = null;
    }

    public void setHasFixedSize(boolean z3) {
        this.f3720q = z3;
    }

    public void setItemAnimator(s sVar) {
        s sVar2 = this.f3681G;
        if (sVar2 != null) {
            sVar2.a();
            this.f3681G.f5264a = null;
        }
        this.f3681G = sVar;
        if (sVar != null) {
            sVar.f5264a = this.f3703c0;
        }
    }

    public void setItemViewCacheSize(int i) {
        z zVar = this.f3698a;
        zVar.f5282d = i;
        zVar.b();
    }

    public void setLayoutFrozen(boolean z3) {
        if (z3 != this.f3723t) {
            b("Do not setLayoutFrozen in layout or scroll");
            if (!z3) {
                this.f3723t = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.f3723t = true;
            this.f3724u = true;
            setScrollState(0);
            RunnableC0474E runnableC0474E = this.f3695U;
            runnableC0474E.f5175j.removeCallbacks(runnableC0474E);
            runnableC0474E.f5171c.abortAnimation();
        }
    }

    public void setLayoutManager(t tVar) {
        if (tVar == this.f3716l) {
            return;
        }
        setScrollState(0);
        RunnableC0474E runnableC0474E = this.f3695U;
        runnableC0474E.f5175j.removeCallbacks(runnableC0474E);
        runnableC0474E.f5171c.abortAnimation();
        t tVar2 = this.f3716l;
        z zVar = this.f3698a;
        if (tVar2 != null) {
            s sVar = this.f3681G;
            if (sVar != null) {
                sVar.a();
            }
            this.f3716l.E();
            this.f3716l.F(zVar);
            zVar.f5279a.clear();
            ArrayList arrayList = zVar.f5280b;
            int size = arrayList.size() - 1;
            if (size < 0) {
                arrayList.clear();
                C0483g c0483g = zVar.f5285g.f3697W;
                c0483g.getClass();
                c0483g.f5241c = 0;
                if (this.p) {
                    t tVar3 = this.f3716l;
                    tVar3.f5272e = false;
                    tVar3.z(this);
                }
                this.f3716l.I(null);
                this.f3716l = null;
            } else {
                throw e0.a.b(size, arrayList);
            }
        } else {
            zVar.f5279a.clear();
            ArrayList arrayList2 = zVar.f5280b;
            int size2 = arrayList2.size() - 1;
            if (size2 < 0) {
                arrayList2.clear();
                C0483g c0483g2 = zVar.f5285g.f3697W;
                c0483g2.getClass();
                c0483g2.f5241c = 0;
            } else {
                throw e0.a.b(size2, arrayList2);
            }
        }
        b3 b3Var = this.f3704d;
        G1 g12 = (G1) b3Var.f469b;
        ((d) b3Var.f470c).c();
        ArrayList arrayList3 = (ArrayList) b3Var.f471d;
        for (int size3 = arrayList3.size() - 1; size3 >= 0; size3--) {
            j((View) arrayList3.get(size3));
            arrayList3.remove(size3);
        }
        RecyclerView recyclerView = (RecyclerView) g12.f218b;
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            j(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeAllViews();
        this.f3716l = tVar;
        if (tVar != null) {
            if (tVar.f5269b == null) {
                tVar.I(this);
                if (this.p) {
                    this.f3716l.f5272e = true;
                }
            } else {
                throw new IllegalArgumentException("LayoutManager " + tVar + " is already attached to a RecyclerView:" + tVar.f5269b.h());
            }
        }
        zVar.b();
        requestLayout();
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z3) {
        C0129q scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.f1026d) {
            ViewGroup viewGroup = scrollingChildHelper.f1025c;
            WeakHashMap weakHashMap = S.f954a;
            J.l(viewGroup);
        }
        scrollingChildHelper.f1026d = z3;
    }

    public void setPreserveFocusAfterLayout(boolean z3) {
        this.f3694T = z3;
    }

    public void setRecycledViewPool(y yVar) {
        z zVar = this.f3698a;
        if (zVar.f5284f != null) {
            r1.f5278b--;
        }
        zVar.f5284f = yVar;
        if (yVar != null) {
            zVar.f5285g.getAdapter();
        }
    }

    public void setScrollState(int i) {
        if (i != this.f3682H) {
            this.f3682H = i;
            if (i != 2) {
                RunnableC0474E runnableC0474E = this.f3695U;
                runnableC0474E.f5175j.removeCallbacks(runnableC0474E);
                runnableC0474E.f5171c.abortAnimation();
            }
            t tVar = this.f3716l;
            if (tVar != null) {
                tVar.D(i);
            }
            ArrayList arrayList = this.f3701b0;
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((w) this.f3701b0.get(size)).getClass();
                }
            }
        }
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i != 1) {
            this.f3689O = viewConfiguration.getScaledTouchSlop();
        } else {
            this.f3689O = viewConfiguration.getScaledPagingTouchSlop();
        }
    }

    public void setViewCacheExtension(AbstractC0473D abstractC0473D) {
        this.f3698a.getClass();
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i) {
        return getScrollingChildHelper().g(i, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        getScrollingChildHelper().h(0);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        t tVar = this.f3716l;
        if (tVar != null) {
            return tVar.n(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + h());
    }

    public void setOnFlingListener(v vVar) {
    }

    @Deprecated
    public void setOnScrollListener(w wVar) {
    }

    public void setRecyclerListener(InterfaceC0470A interfaceC0470A) {
    }
}
