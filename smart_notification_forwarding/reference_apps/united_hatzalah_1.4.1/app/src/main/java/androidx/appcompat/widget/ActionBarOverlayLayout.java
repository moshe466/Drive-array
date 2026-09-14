package androidx.appcompat.widget;

import J.C0131t;
import J.H;
import J.InterfaceC0130s;
import J.J;
import J.S;
import J.W;
import J.Z;
import J.a0;
import J.b0;
import J.c0;
import J.d0;
import J.e0;
import J.m0;
import J.p0;
import J.r;
import a.AbstractC0228a;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.uh.sf.R;
import h.N;
import java.util.WeakHashMap;
import k.C0468l;
import l.m;
import l.y;
import m.C0538d;
import m.C0548i;
import m.InterfaceC0536c;
import m.InterfaceC0557m0;
import m.InterfaceC0559n0;
import m.RunnableC0534b;
import m.n1;
import m.s1;

/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements InterfaceC0557m0, r, InterfaceC0130s {

    /* renamed from: E, reason: collision with root package name */
    public static final int[] f2827E = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};

    /* renamed from: A, reason: collision with root package name */
    public final W f2828A;

    /* renamed from: B, reason: collision with root package name */
    public final RunnableC0534b f2829B;

    /* renamed from: C, reason: collision with root package name */
    public final RunnableC0534b f2830C;

    /* renamed from: D, reason: collision with root package name */
    public final C0131t f2831D;

    /* renamed from: a, reason: collision with root package name */
    public int f2832a;

    /* renamed from: b, reason: collision with root package name */
    public int f2833b;

    /* renamed from: c, reason: collision with root package name */
    public ContentFrameLayout f2834c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContainer f2835d;

    /* renamed from: e, reason: collision with root package name */
    public InterfaceC0559n0 f2836e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f2837f;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2838j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f2839k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f2840l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2841m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f2842n;

    /* renamed from: o, reason: collision with root package name */
    public int f2843o;
    public int p;

    /* renamed from: q, reason: collision with root package name */
    public final Rect f2844q;

    /* renamed from: r, reason: collision with root package name */
    public final Rect f2845r;

    /* renamed from: s, reason: collision with root package name */
    public final Rect f2846s;

    /* renamed from: t, reason: collision with root package name */
    public p0 f2847t;

    /* renamed from: u, reason: collision with root package name */
    public p0 f2848u;

    /* renamed from: v, reason: collision with root package name */
    public p0 f2849v;

    /* renamed from: w, reason: collision with root package name */
    public p0 f2850w;

    /* renamed from: x, reason: collision with root package name */
    public InterfaceC0536c f2851x;
    public OverScroller y;

    /* renamed from: z, reason: collision with root package name */
    public ViewPropertyAnimator f2852z;

    /* JADX WARN: Type inference failed for: r2v1, types: [J.t, java.lang.Object] */
    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2833b = 0;
        this.f2844q = new Rect();
        this.f2845r = new Rect();
        this.f2846s = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        p0 p0Var = p0.f1021b;
        this.f2847t = p0Var;
        this.f2848u = p0Var;
        this.f2849v = p0Var;
        this.f2850w = p0Var;
        this.f2828A = new W(this, 1);
        this.f2829B = new RunnableC0534b(this, 0);
        this.f2830C = new RunnableC0534b(this, 1);
        c(context);
        this.f2831D = new Object();
    }

    public static boolean a(View view, Rect rect, boolean z3) {
        boolean z4;
        C0538d c0538d = (C0538d) view.getLayoutParams();
        int i = ((ViewGroup.MarginLayoutParams) c0538d).leftMargin;
        int i3 = rect.left;
        if (i != i3) {
            ((ViewGroup.MarginLayoutParams) c0538d).leftMargin = i3;
            z4 = true;
        } else {
            z4 = false;
        }
        int i4 = ((ViewGroup.MarginLayoutParams) c0538d).topMargin;
        int i5 = rect.top;
        if (i4 != i5) {
            ((ViewGroup.MarginLayoutParams) c0538d).topMargin = i5;
            z4 = true;
        }
        int i6 = ((ViewGroup.MarginLayoutParams) c0538d).rightMargin;
        int i7 = rect.right;
        if (i6 != i7) {
            ((ViewGroup.MarginLayoutParams) c0538d).rightMargin = i7;
            z4 = true;
        }
        if (z3) {
            int i8 = ((ViewGroup.MarginLayoutParams) c0538d).bottomMargin;
            int i9 = rect.bottom;
            if (i8 != i9) {
                ((ViewGroup.MarginLayoutParams) c0538d).bottomMargin = i9;
                return true;
            }
        }
        return z4;
    }

    public final void b() {
        removeCallbacks(this.f2829B);
        removeCallbacks(this.f2830C);
        ViewPropertyAnimator viewPropertyAnimator = this.f2852z;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void c(Context context) {
        boolean z3;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f2827E);
        boolean z4 = false;
        this.f2832a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f2837f = drawable;
        if (drawable == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        setWillNotDraw(z3);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z4 = true;
        }
        this.f2838j = z4;
        this.y = new OverScroller(context);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0538d;
    }

    public final void d(int i) {
        e();
        if (i != 2) {
            if (i != 5) {
                if (i != 109) {
                    return;
                }
                setOverlayMode(true);
                return;
            }
            this.f2836e.getClass();
            return;
        }
        this.f2836e.getClass();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i;
        super.draw(canvas);
        if (this.f2837f != null && !this.f2838j) {
            if (this.f2835d.getVisibility() == 0) {
                i = (int) (this.f2835d.getTranslationY() + this.f2835d.getBottom() + 0.5f);
            } else {
                i = 0;
            }
            this.f2837f.setBounds(0, i, getWidth(), this.f2837f.getIntrinsicHeight() + i);
            this.f2837f.draw(canvas);
        }
    }

    public final void e() {
        InterfaceC0559n0 wrapper;
        if (this.f2834c == null) {
            this.f2834c = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f2835d = (ActionBarContainer) findViewById(R.id.action_bar_container);
            KeyEvent.Callback findViewById = findViewById(R.id.action_bar);
            if (findViewById instanceof InterfaceC0559n0) {
                wrapper = (InterfaceC0559n0) findViewById;
            } else if (findViewById instanceof Toolbar) {
                wrapper = ((Toolbar) findViewById).getWrapper();
            } else {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(findViewById.getClass().getSimpleName()));
            }
            this.f2836e = wrapper;
        }
    }

    public final void f(Menu menu, y yVar) {
        e();
        s1 s1Var = (s1) this.f2836e;
        Toolbar toolbar = s1Var.f5772a;
        if (s1Var.f5783m == null) {
            s1Var.f5783m = new C0548i(toolbar.getContext());
        }
        C0548i c0548i = s1Var.f5783m;
        c0548i.f5672e = yVar;
        m mVar = (m) menu;
        if (mVar != null || toolbar.f2986a != null) {
            toolbar.f();
            m mVar2 = toolbar.f2986a.f2857s;
            if (mVar2 == mVar) {
                return;
            }
            if (mVar2 != null) {
                mVar2.r(toolbar.f2977O);
                mVar2.r(toolbar.f2978P);
            }
            if (toolbar.f2978P == null) {
                toolbar.f2978P = new n1(toolbar);
            }
            c0548i.f5683t = true;
            if (mVar != null) {
                mVar.b(c0548i, toolbar.f2995m);
                mVar.b(toolbar.f2978P, toolbar.f2995m);
            } else {
                c0548i.h(toolbar.f2995m, null);
                toolbar.f2978P.h(toolbar.f2995m, null);
                c0548i.e();
                toolbar.f2978P.e();
            }
            toolbar.f2986a.setPopupTheme(toolbar.f2996n);
            toolbar.f2986a.setPresenter(c0548i);
            toolbar.f2977O = c0548i;
            toolbar.v();
        }
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f2835d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        C0131t c0131t = this.f2831D;
        return c0131t.f1032b | c0131t.f1031a;
    }

    public CharSequence getTitle() {
        e();
        return ((s1) this.f2836e).f5772a.getTitle();
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        e();
        p0 c4 = p0.c(windowInsets, this);
        m0 m0Var = c4.f1022a;
        boolean a2 = a(this.f2835d, new Rect(m0Var.i().f2a, m0Var.i().f3b, m0Var.i().f4c, m0Var.i().f5d), false);
        WeakHashMap weakHashMap = S.f954a;
        Rect rect = this.f2844q;
        J.b(this, c4, rect);
        p0 k4 = m0Var.k(rect.left, rect.top, rect.right, rect.bottom);
        this.f2847t = k4;
        boolean z3 = true;
        if (!this.f2848u.equals(k4)) {
            this.f2848u = this.f2847t;
            a2 = true;
        }
        Rect rect2 = this.f2845r;
        if (!rect2.equals(rect)) {
            rect2.set(rect);
        } else {
            z3 = a2;
        }
        if (z3) {
            requestLayout();
        }
        return m0Var.a().f1022a.c().f1022a.b().b();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c(getContext());
        WeakHashMap weakHashMap = S.f954a;
        H.c(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z3, int i, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                C0538d c0538d = (C0538d) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = ((ViewGroup.MarginLayoutParams) c0538d).leftMargin + paddingLeft;
                int i8 = ((ViewGroup.MarginLayoutParams) c0538d).topMargin + paddingTop;
                childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i3) {
        boolean z3;
        int measuredHeight;
        e0 z4;
        e();
        measureChildWithMargins(this.f2835d, i, 0, i3, 0);
        C0538d c0538d = (C0538d) this.f2835d.getLayoutParams();
        int max = Math.max(0, this.f2835d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c0538d).leftMargin + ((ViewGroup.MarginLayoutParams) c0538d).rightMargin);
        int max2 = Math.max(0, this.f2835d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c0538d).topMargin + ((ViewGroup.MarginLayoutParams) c0538d).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f2835d.getMeasuredState());
        WeakHashMap weakHashMap = S.f954a;
        if ((getWindowSystemUiVisibility() & UserVerificationMethods.USER_VERIFY_HANDPRINT) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            measuredHeight = this.f2832a;
            if (this.f2840l && this.f2835d.getTabContainer() != null) {
                measuredHeight += this.f2832a;
            }
        } else {
            measuredHeight = this.f2835d.getVisibility() != 8 ? this.f2835d.getMeasuredHeight() : 0;
        }
        Rect rect = this.f2844q;
        Rect rect2 = this.f2846s;
        rect2.set(rect);
        p0 p0Var = this.f2847t;
        this.f2849v = p0Var;
        if (!this.f2839k && !z3) {
            rect2.top += measuredHeight;
            rect2.bottom = rect2.bottom;
            this.f2849v = p0Var.f1022a.k(0, measuredHeight, 0, 0);
        } else {
            A.c a2 = A.c.a(p0Var.f1022a.i().f2a, this.f2849v.f1022a.i().f3b + measuredHeight, this.f2849v.f1022a.i().f4c, this.f2849v.f1022a.i().f5d);
            p0 p0Var2 = this.f2849v;
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 34) {
                z4 = new d0(p0Var2);
            } else if (i4 >= 31) {
                z4 = new c0(p0Var2);
            } else if (i4 >= 30) {
                z4 = new b0(p0Var2);
            } else if (i4 >= 29) {
                z4 = new a0(p0Var2);
            } else {
                z4 = new Z(p0Var2);
            }
            z4.d(a2);
            this.f2849v = z4.b();
        }
        a(this.f2834c, rect2, true);
        if (!this.f2850w.equals(this.f2849v)) {
            p0 p0Var3 = this.f2849v;
            this.f2850w = p0Var3;
            S.b(this.f2834c, p0Var3);
        }
        measureChildWithMargins(this.f2834c, i, 0, i3, 0);
        C0538d c0538d2 = (C0538d) this.f2834c.getLayoutParams();
        int max3 = Math.max(max, this.f2834c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c0538d2).leftMargin + ((ViewGroup.MarginLayoutParams) c0538d2).rightMargin);
        int max4 = Math.max(max2, this.f2834c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c0538d2).topMargin + ((ViewGroup.MarginLayoutParams) c0538d2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f2834c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + max3, getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + max4, getSuggestedMinimumHeight()), i3, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f4, float f5, boolean z3) {
        if (this.f2841m && z3) {
            this.y.fling(0, 0, 0, (int) f5, 0, 0, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER);
            if (this.y.getFinalY() > this.f2835d.getHeight()) {
                b();
                this.f2830C.run();
            } else {
                b();
                this.f2829B.run();
            }
            this.f2842n = true;
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f4, float f5) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i3, int[] iArr) {
    }

    @Override // J.InterfaceC0130s
    public final void onNestedScroll(View view, int i, int i3, int i4, int i5, int i6, int[] iArr) {
        onNestedScroll(view, i, i3, i4, i5, i6);
    }

    @Override // J.r
    public final void onNestedScrollAccepted(View view, View view2, int i, int i3) {
        if (i3 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // J.r
    public final boolean onStartNestedScroll(View view, View view2, int i, int i3) {
        return i3 == 0 && onStartNestedScroll(view, view2, i);
    }

    @Override // J.r
    public final void onStopNestedScroll(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int i) {
        boolean z3;
        boolean z4;
        super.onWindowSystemUiVisibilityChanged(i);
        e();
        int i3 = this.p ^ i;
        this.p = i;
        if ((i & 4) == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if ((i & UserVerificationMethods.USER_VERIFY_HANDPRINT) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        InterfaceC0536c interfaceC0536c = this.f2851x;
        if (interfaceC0536c != null) {
            N n4 = (N) interfaceC0536c;
            n4.f4770o = !z4;
            if (!z3 && z4) {
                if (!n4.f4771q) {
                    n4.f4771q = true;
                    n4.y(true);
                }
            } else if (n4.f4771q) {
                n4.f4771q = false;
                n4.y(true);
            }
        }
        if ((i3 & UserVerificationMethods.USER_VERIFY_HANDPRINT) != 0 && this.f2851x != null) {
            WeakHashMap weakHashMap = S.f954a;
            H.c(this);
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f2833b = i;
        InterfaceC0536c interfaceC0536c = this.f2851x;
        if (interfaceC0536c != null) {
            ((N) interfaceC0536c).f4769n = i;
        }
    }

    public void setActionBarHideOffset(int i) {
        b();
        this.f2835d.setTranslationY(-Math.max(0, Math.min(i, this.f2835d.getHeight())));
    }

    public void setActionBarVisibilityCallback(InterfaceC0536c interfaceC0536c) {
        this.f2851x = interfaceC0536c;
        if (getWindowToken() != null) {
            ((N) this.f2851x).f4769n = this.f2833b;
            int i = this.p;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                WeakHashMap weakHashMap = S.f954a;
                H.c(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z3) {
        this.f2840l = z3;
    }

    public void setHideOnContentScrollEnabled(boolean z3) {
        if (z3 != this.f2841m) {
            this.f2841m = z3;
            if (!z3) {
                b();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i) {
        e();
        s1 s1Var = (s1) this.f2836e;
        s1Var.f5775d = i != 0 ? AbstractC0228a.q(s1Var.f5772a.getContext(), i) : null;
        s1Var.c();
    }

    public void setLogo(int i) {
        Drawable drawable;
        e();
        s1 s1Var = (s1) this.f2836e;
        if (i != 0) {
            drawable = AbstractC0228a.q(s1Var.f5772a.getContext(), i);
        } else {
            drawable = null;
        }
        s1Var.f5776e = drawable;
        s1Var.c();
    }

    public void setOverlayMode(boolean z3) {
        boolean z4;
        this.f2839k = z3;
        if (z3 && getContext().getApplicationInfo().targetSdkVersion < 19) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2838j = z4;
    }

    public void setShowingForActionMode(boolean z3) {
    }

    public void setUiOptions(int i) {
    }

    @Override // m.InterfaceC0557m0
    public void setWindowCallback(Window.Callback callback) {
        e();
        ((s1) this.f2836e).f5781k = callback;
    }

    @Override // m.InterfaceC0557m0
    public void setWindowTitle(CharSequence charSequence) {
        e();
        s1 s1Var = (s1) this.f2836e;
        if (!s1Var.f5778g) {
            Toolbar toolbar = s1Var.f5772a;
            s1Var.f5779h = charSequence;
            if ((s1Var.f5773b & 8) != 0) {
                toolbar.setTitle(charSequence);
                if (s1Var.f5778g) {
                    S.j(toolbar.getRootView(), charSequence);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // J.r
    public final void onNestedPreScroll(View view, int i, int i3, int[] iArr, int i4) {
    }

    @Override // J.r
    public final void onNestedScroll(View view, int i, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            onNestedScroll(view, i, i3, i4, i5);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        N n4;
        C0468l c0468l;
        this.f2831D.f1031a = i;
        this.f2843o = getActionBarHideOffset();
        b();
        InterfaceC0536c interfaceC0536c = this.f2851x;
        if (interfaceC0536c == null || (c0468l = (n4 = (N) interfaceC0536c).f4774t) == null) {
            return;
        }
        c0468l.a();
        n4.f4774t = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f2835d.getVisibility() != 0) {
            return false;
        }
        return this.f2841m;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (!this.f2841m || this.f2842n) {
            return;
        }
        if (this.f2843o <= this.f2835d.getHeight()) {
            b();
            postDelayed(this.f2829B, 600L);
        } else {
            b();
            postDelayed(this.f2830C, 600L);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i3, int i4, int i5) {
        int i6 = this.f2843o + i3;
        this.f2843o = i6;
        setActionBarHideOffset(i6);
    }

    public void setIcon(Drawable drawable) {
        e();
        s1 s1Var = (s1) this.f2836e;
        s1Var.f5775d = drawable;
        s1Var.c();
    }
}
