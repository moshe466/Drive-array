package androidx.appcompat.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.view.menu.m;
import androidx.core.view.k0;

@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements e0, androidx.core.view.s, androidx.core.view.q, androidx.core.view.r {
    static final int[] K = {e.a.f8855b, R.attr.windowContentOverlay};
    private androidx.core.view.k0 A;
    private androidx.core.view.k0 B;
    private androidx.core.view.k0 C;
    private d D;
    private OverScroller E;
    ViewPropertyAnimator F;
    final AnimatorListenerAdapter G;
    private final Runnable H;
    private final Runnable I;
    private final androidx.core.view.t J;

    /* renamed from: f, reason: collision with root package name */
    private int f1052f;

    /* renamed from: g, reason: collision with root package name */
    private int f1053g;

    /* renamed from: h, reason: collision with root package name */
    private ContentFrameLayout f1054h;

    /* renamed from: i, reason: collision with root package name */
    ActionBarContainer f1055i;

    /* renamed from: j, reason: collision with root package name */
    private f0 f1056j;

    /* renamed from: k, reason: collision with root package name */
    private Drawable f1057k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f1058l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f1059m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f1060n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f1061o;

    /* renamed from: p, reason: collision with root package name */
    boolean f1062p;

    /* renamed from: q, reason: collision with root package name */
    private int f1063q;

    /* renamed from: r, reason: collision with root package name */
    private int f1064r;

    /* renamed from: s, reason: collision with root package name */
    private final Rect f1065s;

    /* renamed from: t, reason: collision with root package name */
    private final Rect f1066t;

    /* renamed from: u, reason: collision with root package name */
    private final Rect f1067u;

    /* renamed from: v, reason: collision with root package name */
    private final Rect f1068v;

    /* renamed from: w, reason: collision with root package name */
    private final Rect f1069w;

    /* renamed from: x, reason: collision with root package name */
    private final Rect f1070x;

    /* renamed from: y, reason: collision with root package name */
    private final Rect f1071y;

    /* renamed from: z, reason: collision with root package name */
    private androidx.core.view.k0 f1072z;

    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.F = null;
            actionBarOverlayLayout.f1062p = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.F = null;
            actionBarOverlayLayout.f1062p = false;
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.F = actionBarOverlayLayout.f1055i.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.G);
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.F = actionBarOverlayLayout.f1055i.animate().translationY(-ActionBarOverlayLayout.this.f1055i.getHeight()).setListener(ActionBarOverlayLayout.this.G);
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a();

        void b();

        void c(int i10);

        void d();

        void e(boolean z10);

        void f();
    }

    /* loaded from: classes.dex */
    public static class e extends ViewGroup.MarginLayoutParams {
        public e(int i10, int i11) {
            super(i10, i11);
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1053g = 0;
        this.f1065s = new Rect();
        this.f1066t = new Rect();
        this.f1067u = new Rect();
        this.f1068v = new Rect();
        this.f1069w = new Rect();
        this.f1070x = new Rect();
        this.f1071y = new Rect();
        androidx.core.view.k0 k0Var = androidx.core.view.k0.f2587b;
        this.f1072z = k0Var;
        this.A = k0Var;
        this.B = k0Var;
        this.C = k0Var;
        this.G = new a();
        this.H = new b();
        this.I = new c();
        v(context);
        this.J = new androidx.core.view.t(this);
    }

    private void A() {
        u();
        this.H.run();
    }

    private boolean B(float f10) {
        this.E.fling(0, 0, 0, (int) f10, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.E.getFinalY() > this.f1055i.getHeight();
    }

    private void p() {
        u();
        this.I.run();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean q(android.view.View r3, android.graphics.Rect r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        /*
            r2 = this;
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.ActionBarOverlayLayout$e r3 = (androidx.appcompat.widget.ActionBarOverlayLayout.e) r3
            r0 = 1
            if (r5 == 0) goto L13
            int r5 = r3.leftMargin
            int r1 = r4.left
            if (r5 == r1) goto L13
            r3.leftMargin = r1
            r5 = 1
            goto L14
        L13:
            r5 = 0
        L14:
            if (r6 == 0) goto L1f
            int r6 = r3.topMargin
            int r1 = r4.top
            if (r6 == r1) goto L1f
            r3.topMargin = r1
            r5 = 1
        L1f:
            if (r8 == 0) goto L2a
            int r6 = r3.rightMargin
            int r8 = r4.right
            if (r6 == r8) goto L2a
            r3.rightMargin = r8
            r5 = 1
        L2a:
            if (r7 == 0) goto L35
            int r6 = r3.bottomMargin
            int r4 = r4.bottom
            if (r6 == r4) goto L35
            r3.bottomMargin = r4
            goto L36
        L35:
            r0 = r5
        L36:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.q(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private f0 t(View view) {
        if (view instanceof f0) {
            return (f0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void v(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(K);
        this.f1052f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f1057k = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        this.f1058l = context.getApplicationInfo().targetSdkVersion < 19;
        this.E = new OverScroller(context);
    }

    private void x() {
        u();
        postDelayed(this.I, 600L);
    }

    private void y() {
        u();
        postDelayed(this.H, 600L);
    }

    @Override // androidx.appcompat.widget.e0
    public void a(Menu menu, m.a aVar) {
        z();
        this.f1056j.a(menu, aVar);
    }

    @Override // androidx.appcompat.widget.e0
    public boolean b() {
        z();
        return this.f1056j.b();
    }

    @Override // androidx.core.view.q
    public void c(View view, View view2, int i10, int i11) {
        if (i11 == 0) {
            onNestedScrollAccepted(view, view2, i10);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // androidx.appcompat.widget.e0
    public void d() {
        z();
        this.f1056j.d();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1057k == null || this.f1058l) {
            return;
        }
        int bottom = this.f1055i.getVisibility() == 0 ? (int) (this.f1055i.getBottom() + this.f1055i.getTranslationY() + 0.5f) : 0;
        this.f1057k.setBounds(0, bottom, getWidth(), this.f1057k.getIntrinsicHeight() + bottom);
        this.f1057k.draw(canvas);
    }

    @Override // androidx.appcompat.widget.e0
    public boolean e() {
        z();
        return this.f1056j.e();
    }

    @Override // androidx.appcompat.widget.e0
    public boolean f() {
        z();
        return this.f1056j.f();
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT >= 21) {
            return super.fitSystemWindows(rect);
        }
        z();
        boolean q10 = q(this.f1055i, rect, true, true, false, true);
        this.f1068v.set(rect);
        h1.a(this, this.f1068v, this.f1065s);
        if (!this.f1069w.equals(this.f1068v)) {
            this.f1069w.set(this.f1068v);
            q10 = true;
        }
        if (!this.f1066t.equals(this.f1065s)) {
            this.f1066t.set(this.f1065s);
            q10 = true;
        }
        if (q10) {
            requestLayout();
        }
        return true;
    }

    @Override // androidx.appcompat.widget.e0
    public boolean g() {
        z();
        return this.f1056j.g();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f1055i;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.J.a();
    }

    public CharSequence getTitle() {
        z();
        return this.f1056j.getTitle();
    }

    @Override // androidx.appcompat.widget.e0
    public boolean h() {
        z();
        return this.f1056j.h();
    }

    @Override // androidx.core.view.q
    public void i(View view, int i10) {
        if (i10 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // androidx.core.view.q
    public void j(View view, int i10, int i11, int[] iArr, int i12) {
        if (i12 == 0) {
            onNestedPreScroll(view, i10, i11, iArr);
        }
    }

    @Override // androidx.appcompat.widget.e0
    public void k(int i10) {
        z();
        if (i10 == 2) {
            this.f1056j.u();
        } else if (i10 == 5) {
            this.f1056j.v();
        } else {
            if (i10 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // androidx.appcompat.widget.e0
    public void l() {
        z();
        this.f1056j.i();
    }

    @Override // androidx.core.view.r
    public void m(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        n(view, i10, i11, i12, i13, i14);
    }

    @Override // androidx.core.view.q
    public void n(View view, int i10, int i11, int i12, int i13, int i14) {
        if (i14 == 0) {
            onNestedScroll(view, i10, i11, i12, i13);
        }
    }

    @Override // androidx.core.view.q
    public boolean o(View view, View view2, int i10, int i11) {
        return i11 == 0 && onStartNestedScroll(view, view2, i10);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        z();
        androidx.core.view.k0 v10 = androidx.core.view.k0.v(windowInsets, this);
        boolean q10 = q(this.f1055i, new Rect(v10.i(), v10.k(), v10.j(), v10.h()), true, true, false, true);
        androidx.core.view.a0.f(this, v10, this.f1065s);
        Rect rect = this.f1065s;
        androidx.core.view.k0 l10 = v10.l(rect.left, rect.top, rect.right, rect.bottom);
        this.f1072z = l10;
        boolean z10 = true;
        if (!this.A.equals(l10)) {
            this.A = this.f1072z;
            q10 = true;
        }
        if (this.f1066t.equals(this.f1065s)) {
            z10 = q10;
        } else {
            this.f1066t.set(this.f1065s);
        }
        if (z10) {
            requestLayout();
        }
        return v10.a().c().b().t();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        v(getContext());
        androidx.core.view.a0.g0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i15 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i16 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i15, i16, measuredWidth + i15, measuredHeight + i16);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int measuredHeight;
        androidx.core.view.k0 a10;
        z();
        measureChildWithMargins(this.f1055i, i10, 0, i11, 0);
        e eVar = (e) this.f1055i.getLayoutParams();
        int max = Math.max(0, this.f1055i.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int max2 = Math.max(0, this.f1055i.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f1055i.getMeasuredState());
        boolean z10 = (androidx.core.view.a0.K(this) & 256) != 0;
        if (z10) {
            measuredHeight = this.f1052f;
            if (this.f1060n && this.f1055i.getTabContainer() != null) {
                measuredHeight += this.f1052f;
            }
        } else {
            measuredHeight = this.f1055i.getVisibility() != 8 ? this.f1055i.getMeasuredHeight() : 0;
        }
        this.f1067u.set(this.f1065s);
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 21) {
            this.B = this.f1072z;
        } else {
            this.f1070x.set(this.f1068v);
        }
        if (!this.f1059m && !z10) {
            Rect rect = this.f1067u;
            rect.top += measuredHeight;
            rect.bottom += 0;
            if (i12 >= 21) {
                a10 = this.B.l(0, measuredHeight, 0, 0);
                this.B = a10;
            }
        } else if (i12 >= 21) {
            a10 = new k0.b(this.B).c(androidx.core.graphics.b.b(this.B.i(), this.B.k() + measuredHeight, this.B.j(), this.B.h() + 0)).a();
            this.B = a10;
        } else {
            Rect rect2 = this.f1070x;
            rect2.top += measuredHeight;
            rect2.bottom += 0;
        }
        q(this.f1054h, this.f1067u, true, true, true, true);
        if (i12 >= 21 && !this.C.equals(this.B)) {
            androidx.core.view.k0 k0Var = this.B;
            this.C = k0Var;
            androidx.core.view.a0.g(this.f1054h, k0Var);
        } else if (i12 < 21 && !this.f1071y.equals(this.f1070x)) {
            this.f1071y.set(this.f1070x);
            this.f1054h.a(this.f1070x);
        }
        measureChildWithMargins(this.f1054h, i10, 0, i11, 0);
        e eVar2 = (e) this.f1054h.getLayoutParams();
        int max3 = Math.max(max, this.f1054h.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int max4 = Math.max(max2, this.f1054h.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f1054h.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i10, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i11, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.s
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        if (!this.f1061o || !z10) {
            return false;
        }
        if (B(f11)) {
            p();
        } else {
            A();
        }
        this.f1062p = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.s
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.s
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.s
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        int i14 = this.f1063q + i11;
        this.f1063q = i14;
        setActionBarHideOffset(i14);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.s
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        this.J.b(view, view2, i10);
        this.f1063q = getActionBarHideOffset();
        u();
        d dVar = this.D;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.s
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        if ((i10 & 2) == 0 || this.f1055i.getVisibility() != 0) {
            return false;
        }
        return this.f1061o;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.s
    public void onStopNestedScroll(View view) {
        if (this.f1061o && !this.f1062p) {
            if (this.f1063q <= this.f1055i.getHeight()) {
                y();
            } else {
                x();
            }
        }
        d dVar = this.D;
        if (dVar != null) {
            dVar.d();
        }
    }

    @Override // android.view.View
    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i10) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i10);
        }
        z();
        int i11 = this.f1064r ^ i10;
        this.f1064r = i10;
        boolean z10 = (i10 & 4) == 0;
        boolean z11 = (i10 & 256) != 0;
        d dVar = this.D;
        if (dVar != null) {
            dVar.e(!z11);
            if (z10 || !z11) {
                this.D.a();
            } else {
                this.D.f();
            }
        }
        if ((i11 & 256) == 0 || this.D == null) {
            return;
        }
        androidx.core.view.a0.g0(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.f1053g = i10;
        d dVar = this.D;
        if (dVar != null) {
            dVar.c(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public void setActionBarHideOffset(int i10) {
        u();
        this.f1055i.setTranslationY(-Math.max(0, Math.min(i10, this.f1055i.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.D = dVar;
        if (getWindowToken() != null) {
            this.D.c(this.f1053g);
            int i10 = this.f1064r;
            if (i10 != 0) {
                onWindowSystemUiVisibilityChanged(i10);
                androidx.core.view.a0.g0(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z10) {
        this.f1060n = z10;
    }

    public void setHideOnContentScrollEnabled(boolean z10) {
        if (z10 != this.f1061o) {
            this.f1061o = z10;
            if (z10) {
                return;
            }
            u();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i10) {
        z();
        this.f1056j.setIcon(i10);
    }

    public void setIcon(Drawable drawable) {
        z();
        this.f1056j.setIcon(drawable);
    }

    public void setLogo(int i10) {
        z();
        this.f1056j.q(i10);
    }

    public void setOverlayMode(boolean z10) {
        this.f1059m = z10;
        this.f1058l = z10 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z10) {
    }

    public void setUiOptions(int i10) {
    }

    @Override // androidx.appcompat.widget.e0
    public void setWindowCallback(Window.Callback callback) {
        z();
        this.f1056j.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.e0
    public void setWindowTitle(CharSequence charSequence) {
        z();
        this.f1056j.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    void u() {
        removeCallbacks(this.H);
        removeCallbacks(this.I);
        ViewPropertyAnimator viewPropertyAnimator = this.F;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public boolean w() {
        return this.f1059m;
    }

    void z() {
        if (this.f1054h == null) {
            this.f1054h = (ContentFrameLayout) findViewById(e.f.f8931b);
            this.f1055i = (ActionBarContainer) findViewById(e.f.f8932c);
            this.f1056j = t(findViewById(e.f.f8930a));
        }
    }
}
