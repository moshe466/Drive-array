package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.view.a0;
import androidx.core.view.accessibility.d;
import androidx.core.view.p;
import androidx.core.view.r;
import androidx.core.view.t;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements r, androidx.core.view.n {
    private static final float G = (float) (Math.log(0.78d) / Math.log(0.9d));
    private static final a H = new a();
    private static final int[] I = {R.attr.fillViewport};
    private int A;
    private d B;
    private final t C;
    private final p D;
    private float E;
    private c F;

    /* renamed from: f, reason: collision with root package name */
    private final float f2631f;

    /* renamed from: g, reason: collision with root package name */
    private long f2632g;

    /* renamed from: h, reason: collision with root package name */
    private final Rect f2633h;

    /* renamed from: i, reason: collision with root package name */
    private OverScroller f2634i;

    /* renamed from: j, reason: collision with root package name */
    public EdgeEffect f2635j;

    /* renamed from: k, reason: collision with root package name */
    public EdgeEffect f2636k;

    /* renamed from: l, reason: collision with root package name */
    private int f2637l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f2638m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f2639n;

    /* renamed from: o, reason: collision with root package name */
    private View f2640o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f2641p;

    /* renamed from: q, reason: collision with root package name */
    private VelocityTracker f2642q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f2643r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f2644s;

    /* renamed from: t, reason: collision with root package name */
    private int f2645t;

    /* renamed from: u, reason: collision with root package name */
    private int f2646u;

    /* renamed from: v, reason: collision with root package name */
    private int f2647v;

    /* renamed from: w, reason: collision with root package name */
    private int f2648w;

    /* renamed from: x, reason: collision with root package name */
    private final int[] f2649x;

    /* renamed from: y, reason: collision with root package name */
    private final int[] f2650y;

    /* renamed from: z, reason: collision with root package name */
    private int f2651z;

    /* loaded from: classes.dex */
    static class a extends androidx.core.view.a {
        a() {
        }

        @Override // androidx.core.view.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            androidx.core.view.accessibility.f.a(accessibilityEvent, nestedScrollView.getScrollX());
            androidx.core.view.accessibility.f.b(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // androidx.core.view.a
        public void g(View view, androidx.core.view.accessibility.d dVar) {
            int scrollRange;
            super.g(view, dVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            dVar.V(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            dVar.m0(true);
            if (nestedScrollView.getScrollY() > 0) {
                dVar.b(d.a.f2539g);
                dVar.b(d.a.f2540h);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                dVar.b(d.a.f2538f);
                dVar.b(d.a.f2541i);
            }
        }

        @Override // androidx.core.view.a
        public boolean j(View view, int i10, Bundle bundle) {
            if (super.j(view, i10, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (i10 != 4096) {
                if (i10 == 8192 || i10 == 16908344) {
                    int max = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.U(0, max, true);
                    return true;
                }
                if (i10 != 16908346) {
                    return false;
                }
            }
            int min = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (min == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.U(0, min, true);
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class b {
        static boolean a(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d extends View.BaseSavedState {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: f, reason: collision with root package name */
        public int f2652f;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<d> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i10) {
                return new d[i10];
            }
        }

        d(Parcel parcel) {
            super(parcel);
            this.f2652f = parcel.readInt();
        }

        d(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f2652f + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f2652f);
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, t.a.f14217c);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2633h = new Rect();
        this.f2638m = true;
        this.f2639n = false;
        this.f2640o = null;
        this.f2641p = false;
        this.f2644s = true;
        this.f2648w = -1;
        this.f2649x = new int[2];
        this.f2650y = new int[2];
        this.f2635j = e.a(context, attributeSet);
        this.f2636k = e.a(context, attributeSet);
        this.f2631f = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        B();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, I, i10, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.C = new t(this);
        this.D = new p(this);
        setNestedScrollingEnabled(true);
        a0.j0(this, H);
    }

    private void A() {
        VelocityTracker velocityTracker = this.f2642q;
        if (velocityTracker == null) {
            this.f2642q = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void B() {
        this.f2634i = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f2645t = viewConfiguration.getScaledTouchSlop();
        this.f2646u = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f2647v = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void C() {
        if (this.f2642q == null) {
            this.f2642q = VelocityTracker.obtain();
        }
    }

    private boolean D(View view) {
        return !F(view, 0, getHeight());
    }

    private static boolean E(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && E((View) parent, view2);
    }

    private boolean F(View view, int i10, int i11) {
        view.getDrawingRect(this.f2633h);
        offsetDescendantRectToMyCoords(view, this.f2633h);
        return this.f2633h.bottom + i10 >= getScrollY() && this.f2633h.top - i10 <= getScrollY() + i11;
    }

    private void G(int i10, int i11, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i10);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.D.e(0, scrollY2, 0, i10 - scrollY2, null, i11, iArr);
    }

    private void H(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f2648w) {
            int i10 = actionIndex == 0 ? 1 : 0;
            this.f2637l = (int) motionEvent.getY(i10);
            this.f2648w = motionEvent.getPointerId(i10);
            VelocityTracker velocityTracker = this.f2642q;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void K() {
        VelocityTracker velocityTracker = this.f2642q;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f2642q = null;
        }
    }

    private int L(int i10, float f10) {
        float d10;
        EdgeEffect edgeEffect;
        float width = f10 / getWidth();
        float height = i10 / getHeight();
        float f11 = 0.0f;
        if (e.b(this.f2635j) != 0.0f) {
            d10 = -e.d(this.f2635j, -height, width);
            if (e.b(this.f2635j) == 0.0f) {
                edgeEffect = this.f2635j;
                edgeEffect.onRelease();
            }
            f11 = d10;
        } else if (e.b(this.f2636k) != 0.0f) {
            d10 = e.d(this.f2636k, height, 1.0f - width);
            if (e.b(this.f2636k) == 0.0f) {
                edgeEffect = this.f2636k;
                edgeEffect.onRelease();
            }
            f11 = d10;
        }
        int round = Math.round(f11 * getHeight());
        if (round != 0) {
            invalidate();
        }
        return round;
    }

    private void M(boolean z10) {
        if (z10) {
            V(2, 1);
        } else {
            a(1);
        }
        this.A = getScrollY();
        a0.d0(this);
    }

    private boolean N(int i10, int i11, int i12) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i13 = height + scrollY;
        boolean z10 = false;
        boolean z11 = i10 == 33;
        View u10 = u(z11, i11, i12);
        if (u10 == null) {
            u10 = this;
        }
        if (i11 < scrollY || i12 > i13) {
            q(z11 ? i11 - scrollY : i12 - i13);
            z10 = true;
        }
        if (u10 != findFocus()) {
            u10.requestFocus(i10);
        }
        return z10;
    }

    private void O(View view) {
        view.getDrawingRect(this.f2633h);
        offsetDescendantRectToMyCoords(view, this.f2633h);
        int h10 = h(this.f2633h);
        if (h10 != 0) {
            scrollBy(0, h10);
        }
    }

    private boolean P(Rect rect, boolean z10) {
        int h10 = h(rect);
        boolean z11 = h10 != 0;
        if (z11) {
            if (z10) {
                scrollBy(0, h10);
            } else {
                R(0, h10);
            }
        }
        return z11;
    }

    private boolean Q(EdgeEffect edgeEffect, int i10) {
        if (i10 > 0) {
            return true;
        }
        return x(-i10) < e.b(edgeEffect) * ((float) getHeight());
    }

    private void S(int i10, int i11, int i12, boolean z10) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f2632g > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f2634i.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i11 + scrollY, Math.max(0, height - height2))) - scrollY, i12);
            M(z10);
        } else {
            if (!this.f2634i.isFinished()) {
                b();
            }
            scrollBy(i10, i11);
        }
        this.f2632g = AnimationUtils.currentAnimationTimeMillis();
    }

    private boolean W(MotionEvent motionEvent) {
        boolean z10;
        if (e.b(this.f2635j) != 0.0f) {
            e.d(this.f2635j, 0.0f, motionEvent.getX() / getWidth());
            z10 = true;
        } else {
            z10 = false;
        }
        if (e.b(this.f2636k) == 0.0f) {
            return z10;
        }
        e.d(this.f2636k, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    private void b() {
        this.f2634i.abortAnimation();
        a(1);
    }

    private boolean e() {
        int overScrollMode = getOverScrollMode();
        if (overScrollMode != 0) {
            return overScrollMode == 1 && getScrollRange() > 0;
        }
        return true;
    }

    private boolean f() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private static int g(int i10, int i11, int i12) {
        if (i11 >= i12 || i10 < 0) {
            return 0;
        }
        return i11 + i10 > i12 ? i12 - i11 : i10;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.E == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.E = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.E;
    }

    private void q(int i10) {
        if (i10 != 0) {
            if (this.f2644s) {
                R(0, i10);
            } else {
                scrollBy(0, i10);
            }
        }
    }

    private boolean r(int i10) {
        EdgeEffect edgeEffect;
        if (e.b(this.f2635j) != 0.0f) {
            if (Q(this.f2635j, i10)) {
                edgeEffect = this.f2635j;
                edgeEffect.onAbsorb(i10);
            } else {
                i10 = -i10;
                v(i10);
            }
        } else {
            if (e.b(this.f2636k) == 0.0f) {
                return false;
            }
            i10 = -i10;
            if (Q(this.f2636k, i10)) {
                edgeEffect = this.f2636k;
                edgeEffect.onAbsorb(i10);
            }
            v(i10);
        }
        return true;
    }

    private void s() {
        this.f2641p = false;
        K();
        a(0);
        this.f2635j.onRelease();
        this.f2636k.onRelease();
    }

    private View u(boolean z10, int i10, int i11) {
        ArrayList focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z11 = false;
        for (int i12 = 0; i12 < size; i12++) {
            View view2 = (View) focusables.get(i12);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i10 < bottom && top < i11) {
                boolean z12 = i10 < top && bottom < i11;
                if (view == null) {
                    view = view2;
                    z11 = z12;
                } else {
                    boolean z13 = (z10 && top < view.getTop()) || (!z10 && bottom > view.getBottom());
                    if (z11) {
                        if (z12) {
                            if (!z13) {
                            }
                            view = view2;
                        }
                    } else if (z12) {
                        view = view2;
                        z11 = true;
                    } else {
                        if (!z13) {
                        }
                        view = view2;
                    }
                }
            }
        }
        return view;
    }

    private float x(int i10) {
        double log = Math.log((Math.abs(i10) * 0.35f) / (this.f2631f * 0.015f));
        float f10 = G;
        return (float) (this.f2631f * 0.015f * Math.exp((f10 / (f10 - 1.0d)) * log));
    }

    private boolean z(int i10, int i11) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i11 >= childAt.getTop() - scrollY && i11 < childAt.getBottom() - scrollY && i10 >= childAt.getLeft() && i10 < childAt.getRight();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0083 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    boolean I(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21) {
        /*
            r12 = this;
            r0 = r12
            int r1 = r12.getOverScrollMode()
            int r2 = r12.computeHorizontalScrollRange()
            int r3 = r12.computeHorizontalScrollExtent()
            r4 = 0
            r5 = 1
            if (r2 <= r3) goto L13
            r2 = 1
            goto L14
        L13:
            r2 = 0
        L14:
            int r3 = r12.computeVerticalScrollRange()
            int r6 = r12.computeVerticalScrollExtent()
            if (r3 <= r6) goto L20
            r3 = 1
            goto L21
        L20:
            r3 = 0
        L21:
            if (r1 == 0) goto L2a
            if (r1 != r5) goto L28
            if (r2 == 0) goto L28
            goto L2a
        L28:
            r2 = 0
            goto L2b
        L2a:
            r2 = 1
        L2b:
            if (r1 == 0) goto L34
            if (r1 != r5) goto L32
            if (r3 == 0) goto L32
            goto L34
        L32:
            r1 = 0
            goto L35
        L34:
            r1 = 1
        L35:
            int r3 = r15 + r13
            if (r2 != 0) goto L3b
            r2 = 0
            goto L3d
        L3b:
            r2 = r19
        L3d:
            int r6 = r16 + r14
            if (r1 != 0) goto L43
            r1 = 0
            goto L45
        L43:
            r1 = r20
        L45:
            int r7 = -r2
            int r2 = r2 + r17
            int r8 = -r1
            int r1 = r1 + r18
            if (r3 <= r2) goto L50
            r3 = r2
        L4e:
            r2 = 1
            goto L55
        L50:
            if (r3 >= r7) goto L54
            r3 = r7
            goto L4e
        L54:
            r2 = 0
        L55:
            if (r6 <= r1) goto L5a
            r6 = r1
        L58:
            r1 = 1
            goto L5f
        L5a:
            if (r6 >= r8) goto L5e
            r6 = r8
            goto L58
        L5e:
            r1 = 0
        L5f:
            if (r1 == 0) goto L7e
            boolean r7 = r12.y(r5)
            if (r7 != 0) goto L7e
            android.widget.OverScroller r7 = r0.f2634i
            r8 = 0
            r9 = 0
            r10 = 0
            int r11 = r12.getScrollRange()
            r13 = r7
            r14 = r3
            r15 = r6
            r16 = r8
            r17 = r9
            r18 = r10
            r19 = r11
            r13.springBack(r14, r15, r16, r17, r18, r19)
        L7e:
            r12.onOverScrolled(r3, r6, r2, r1)
            if (r2 != 0) goto L85
            if (r1 == 0) goto L86
        L85:
            r4 = 1
        L86:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.I(int, int, int, int, int, int, int, int, boolean):boolean");
    }

    public boolean J(int i10) {
        boolean z10 = i10 == 130;
        int height = getHeight();
        if (z10) {
            this.f2633h.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f2633h;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f2633h.top = getScrollY() - height;
            Rect rect2 = this.f2633h;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f2633h;
        int i11 = rect3.top;
        int i12 = height + i11;
        rect3.bottom = i12;
        return N(i10, i11, i12);
    }

    public final void R(int i10, int i11) {
        S(i10, i11, 250, false);
    }

    void T(int i10, int i11, int i12, boolean z10) {
        S(i10 - getScrollX(), i11 - getScrollY(), i12, z10);
    }

    void U(int i10, int i11, boolean z10) {
        T(i10, i11, 250, z10);
    }

    public boolean V(int i10, int i11) {
        return this.D.q(i10, i11);
    }

    @Override // androidx.core.view.n
    public void a(int i10) {
        this.D.s(i10);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i10);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i10, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    @Override // androidx.core.view.q
    public void c(View view, View view2, int i10, int i11) {
        this.C.c(view, view2, i10, i11);
        V(2, i11);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        EdgeEffect edgeEffect;
        if (this.f2634i.isFinished()) {
            return;
        }
        this.f2634i.computeScrollOffset();
        int currY = this.f2634i.getCurrY();
        int k10 = k(currY - this.A);
        this.A = currY;
        int[] iArr = this.f2650y;
        boolean z10 = false;
        iArr[1] = 0;
        l(0, k10, iArr, null, 1);
        int i10 = k10 - this.f2650y[1];
        int scrollRange = getScrollRange();
        if (i10 != 0) {
            int scrollY = getScrollY();
            I(0, i10, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            int i11 = i10 - scrollY2;
            int[] iArr2 = this.f2650y;
            iArr2[1] = 0;
            p(0, scrollY2, 0, i11, this.f2649x, 1, iArr2);
            i10 = i11 - this.f2650y[1];
        }
        if (i10 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                z10 = true;
            }
            if (z10) {
                if (i10 < 0) {
                    if (this.f2635j.isFinished()) {
                        edgeEffect = this.f2635j;
                        edgeEffect.onAbsorb((int) this.f2634i.getCurrVelocity());
                    }
                } else if (this.f2636k.isFinished()) {
                    edgeEffect = this.f2636k;
                    edgeEffect.onAbsorb((int) this.f2634i.getCurrVelocity());
                }
            }
            b();
        }
        if (this.f2634i.isFinished()) {
            a(1);
        } else {
            a0.d0(this);
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    public boolean d(int i10) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i10);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !F(findNextFocus, maxScrollAmount, getHeight())) {
            if (i10 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i10 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i10 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            q(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f2633h);
            offsetDescendantRectToMyCoords(findNextFocus, this.f2633h);
            q(h(this.f2633h));
            findNextFocus.requestFocus(i10);
        }
        if (findFocus == null || !findFocus.isFocused() || !D(findFocus)) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || t(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return this.D.a(f10, f11, z10);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f10, float f11) {
        return this.D.b(f10, f11);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return l(i10, i11, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return this.D.f(i10, i11, i12, i13, iArr);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        int scrollY = getScrollY();
        int i10 = 0;
        if (!this.f2635j.isFinished()) {
            int save = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int min = Math.min(0, scrollY);
            int i11 = Build.VERSION.SDK_INT;
            if (i11 < 21 || b.a(this)) {
                width -= getPaddingLeft() + getPaddingRight();
                paddingLeft = getPaddingLeft() + 0;
            } else {
                paddingLeft = 0;
            }
            if (i11 >= 21 && b.a(this)) {
                height -= getPaddingTop() + getPaddingBottom();
                min += getPaddingTop();
            }
            canvas.translate(paddingLeft, min);
            this.f2635j.setSize(width, height);
            if (this.f2635j.draw(canvas)) {
                a0.d0(this);
            }
            canvas.restoreToCount(save);
        }
        if (this.f2636k.isFinished()) {
            return;
        }
        int save2 = canvas.save();
        int width2 = getWidth();
        int height2 = getHeight();
        int max = Math.max(getScrollRange(), scrollY) + height2;
        int i12 = Build.VERSION.SDK_INT;
        if (i12 < 21 || b.a(this)) {
            width2 -= getPaddingLeft() + getPaddingRight();
            i10 = 0 + getPaddingLeft();
        }
        if (i12 >= 21 && b.a(this)) {
            height2 -= getPaddingTop() + getPaddingBottom();
            max -= getPaddingBottom();
        }
        canvas.translate(i10 - width2, max);
        canvas.rotate(180.0f, width2, 0.0f);
        this.f2636k.setSize(width2, height2);
        if (this.f2636k.draw(canvas)) {
            a0.d0(this);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.C.a();
    }

    int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    protected int h(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i10 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i11 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i10 - verticalFadingEdgeLength : i10;
        int i12 = rect.bottom;
        if (i12 > i11 && rect.top > scrollY) {
            return Math.min((rect.height() > height ? rect.top - scrollY : rect.bottom - i11) + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i10);
        }
        if (rect.top >= scrollY || i12 >= i11) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i11 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return y(0);
    }

    @Override // androidx.core.view.q
    public void i(View view, int i10) {
        this.C.e(view, i10);
        a(i10);
    }

    @Override // android.view.View, androidx.core.view.o
    public boolean isNestedScrollingEnabled() {
        return this.D.m();
    }

    @Override // androidx.core.view.q
    public void j(View view, int i10, int i11, int[] iArr, int i12) {
        l(i10, i11, iArr, null, i12);
    }

    int k(int i10) {
        int height = getHeight();
        if (i10 > 0 && e.b(this.f2635j) != 0.0f) {
            int round = Math.round(((-height) / 4.0f) * e.d(this.f2635j, ((-i10) * 4.0f) / height, 0.5f));
            if (round != i10) {
                this.f2635j.finish();
            }
            return i10 - round;
        }
        if (i10 >= 0 || e.b(this.f2636k) == 0.0f) {
            return i10;
        }
        float f10 = height;
        int round2 = Math.round((f10 / 4.0f) * e.d(this.f2636k, (i10 * 4.0f) / f10, 0.5f));
        if (round2 != i10) {
            this.f2636k.finish();
        }
        return i10 - round2;
    }

    public boolean l(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        return this.D.d(i10, i11, iArr, iArr2, i12);
    }

    @Override // androidx.core.view.r
    public void m(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        G(i13, i14, iArr);
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int i10, int i11) {
        view.measure(FrameLayout.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(FrameLayout.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // androidx.core.view.q
    public void n(View view, int i10, int i11, int i12, int i13, int i14) {
        G(i13, i14, null);
    }

    @Override // androidx.core.view.q
    public boolean o(View view, View view2, int i10, int i11) {
        return (i10 & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2639n = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            int r0 = r9.getAction()
            r1 = 0
            r2 = 8
            if (r0 != r2) goto La5
            boolean r0 = r8.f2641p
            if (r0 != 0) goto La5
            r0 = 2
            boolean r0 = androidx.core.view.m.a(r9, r0)
            r2 = 0
            if (r0 == 0) goto L1c
            r0 = 9
        L17:
            float r0 = r9.getAxisValue(r0)
            goto L28
        L1c:
            r0 = 4194304(0x400000, float:5.877472E-39)
            boolean r0 = androidx.core.view.m.a(r9, r0)
            if (r0 == 0) goto L27
            r0 = 26
            goto L17
        L27:
            r0 = 0
        L28:
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto La5
            float r2 = r8.getVerticalScrollFactorCompat()
            float r0 = r0 * r2
            int r0 = (int) r0
            int r2 = r8.getScrollRange()
            int r3 = r8.getScrollY()
            int r0 = r3 - r0
            r4 = 1056964608(0x3f000000, float:0.5)
            r5 = 8194(0x2002, float:1.1482E-41)
            r6 = 1
            if (r0 >= 0) goto L6c
            boolean r2 = r8.e()
            if (r2 == 0) goto L52
            boolean r9 = androidx.core.view.m.a(r9, r5)
            if (r9 != 0) goto L52
            r9 = 1
            goto L53
        L52:
            r9 = 0
        L53:
            if (r9 == 0) goto L99
            android.widget.EdgeEffect r9 = r8.f2635j
            float r0 = (float) r0
            float r0 = -r0
            int r2 = r8.getHeight()
            float r2 = (float) r2
            float r0 = r0 / r2
            androidx.core.widget.e.d(r9, r0, r4)
            android.widget.EdgeEffect r9 = r8.f2635j
            r9.onRelease()
            r8.invalidate()
            r9 = 1
            goto L9a
        L6c:
            if (r0 <= r2) goto L98
            boolean r7 = r8.e()
            if (r7 == 0) goto L7c
            boolean r9 = androidx.core.view.m.a(r9, r5)
            if (r9 != 0) goto L7c
            r9 = 1
            goto L7d
        L7c:
            r9 = 0
        L7d:
            if (r9 == 0) goto L95
            android.widget.EdgeEffect r9 = r8.f2636k
            int r0 = r0 - r2
            float r0 = (float) r0
            int r1 = r8.getHeight()
            float r1 = (float) r1
            float r0 = r0 / r1
            androidx.core.widget.e.d(r9, r0, r4)
            android.widget.EdgeEffect r9 = r8.f2636k
            r9.onRelease()
            r8.invalidate()
            r1 = 1
        L95:
            r9 = r1
            r1 = r2
            goto L9a
        L98:
            r1 = r0
        L99:
            r9 = 0
        L9a:
            if (r1 == r3) goto La4
            int r9 = r8.getScrollX()
            super.scrollTo(r9, r1)
            return r6
        La4:
            return r9
        La5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z10 = true;
        if (action == 2 && this.f2641p) {
            return true;
        }
        int i10 = action & 255;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    int i11 = this.f2648w;
                    if (i11 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i11);
                        if (findPointerIndex == -1) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Invalid pointerId=");
                            sb2.append(i11);
                            sb2.append(" in onInterceptTouchEvent");
                        } else {
                            int y10 = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y10 - this.f2637l) > this.f2645t && (2 & getNestedScrollAxes()) == 0) {
                                this.f2641p = true;
                                this.f2637l = y10;
                                C();
                                this.f2642q.addMovement(motionEvent);
                                this.f2651z = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i10 != 3) {
                    if (i10 == 6) {
                        H(motionEvent);
                    }
                }
            }
            this.f2641p = false;
            this.f2648w = -1;
            K();
            if (this.f2634i.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                a0.d0(this);
            }
            a(0);
        } else {
            int y11 = (int) motionEvent.getY();
            if (z((int) motionEvent.getX(), y11)) {
                this.f2637l = y11;
                this.f2648w = motionEvent.getPointerId(0);
                A();
                this.f2642q.addMovement(motionEvent);
                this.f2634i.computeScrollOffset();
                if (!W(motionEvent) && this.f2634i.isFinished()) {
                    z10 = false;
                }
                this.f2641p = z10;
                V(2, 0);
            } else {
                if (!W(motionEvent) && this.f2634i.isFinished()) {
                    z10 = false;
                }
                this.f2641p = z10;
                K();
            }
        }
        return this.f2641p;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        int i14 = 0;
        this.f2638m = false;
        View view = this.f2640o;
        if (view != null && E(view, this)) {
            O(this.f2640o);
        }
        this.f2640o = null;
        if (!this.f2639n) {
            if (this.B != null) {
                scrollTo(getScrollX(), this.B.f2652f);
                this.B = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i14 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i13 - i11) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int g10 = g(scrollY, paddingTop, i14);
            if (g10 != scrollY) {
                scrollTo(getScrollX(), g10);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f2639n = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f2643r && View.MeasureSpec.getMode(i11) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(FrameLayout.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.s
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        if (z10) {
            return false;
        }
        dispatchNestedFling(0.0f, f11, true);
        v((int) f11);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.s
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return dispatchNestedPreFling(f10, f11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.s
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        j(view, i10, i11, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.s
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        G(i13, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.s
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        c(view, view2, i10, 0);
    }

    @Override // android.view.View
    protected void onOverScrolled(int i10, int i11, boolean z10, boolean z11) {
        super.scrollTo(i10, i11);
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i10, Rect rect) {
        if (i10 == 2) {
            i10 = 130;
        } else if (i10 == 1) {
            i10 = 33;
        }
        FocusFinder focusFinder = FocusFinder.getInstance();
        View findNextFocus = rect == null ? focusFinder.findNextFocus(this, null, i10) : focusFinder.findNextFocusFromRect(this, rect, i10);
        if (findNextFocus == null || D(findNextFocus)) {
            return false;
        }
        return findNextFocus.requestFocus(i10, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        this.B = dVar;
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.f2652f = getScrollY();
        return dVar;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        c cVar = this.F;
        if (cVar != null) {
            cVar.a(this, i10, i11, i12, i13);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        View findFocus = findFocus();
        if (findFocus == null || this == findFocus || !F(findFocus, 0, i13)) {
            return;
        }
        findFocus.getDrawingRect(this.f2633h);
        offsetDescendantRectToMyCoords(findFocus, this.f2633h);
        q(h(this.f2633h));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.s
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        return o(view, view2, i10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.s
    public void onStopNestedScroll(View view) {
        i(view, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0076, code lost:
    
        if (r23.f2634i.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0078, code lost:
    
        androidx.core.view.a0.d0(r23);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0219, code lost:
    
        if (r23.f2634i.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) != false) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01cb  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r24) {
        /*
            Method dump skipped, instructions count: 599
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void p(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        this.D.e(i10, i11, i12, i13, iArr, i14, iArr2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.f2638m) {
            this.f2640o = view2;
        } else {
            O(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return P(rect, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        if (z10) {
            K();
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f2638m = true;
        super.requestLayout();
    }

    @Override // android.view.View
    public void scrollTo(int i10, int i11) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int g10 = g(i10, width, width2);
            int g11 = g(i11, height, height2);
            if (g10 == getScrollX() && g11 == getScrollY()) {
                return;
            }
            super.scrollTo(g10, g11);
        }
    }

    public void setFillViewport(boolean z10) {
        if (z10 != this.f2643r) {
            this.f2643r = z10;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z10) {
        this.D.n(z10);
    }

    public void setOnScrollChangeListener(c cVar) {
        this.F = cVar;
    }

    public void setSmoothScrollingEnabled(boolean z10) {
        this.f2644s = z10;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i10) {
        return V(i10, 0);
    }

    @Override // android.view.View, androidx.core.view.o
    public void stopNestedScroll() {
        a(0);
    }

    public boolean t(KeyEvent keyEvent) {
        this.f2633h.setEmpty();
        if (!f()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            return (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) ? false : true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19) {
            return !keyEvent.isAltPressed() ? d(33) : w(33);
        }
        if (keyCode == 20) {
            return !keyEvent.isAltPressed() ? d(130) : w(130);
        }
        if (keyCode != 62) {
            return false;
        }
        J(keyEvent.isShiftPressed() ? 33 : 130);
        return false;
    }

    public void v(int i10) {
        if (getChildCount() > 0) {
            this.f2634i.fling(getScrollX(), getScrollY(), 0, i10, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            M(true);
        }
    }

    public boolean w(int i10) {
        int childCount;
        boolean z10 = i10 == 130;
        int height = getHeight();
        Rect rect = this.f2633h;
        rect.top = 0;
        rect.bottom = height;
        if (z10 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f2633h.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f2633h;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f2633h;
        return N(i10, rect3.top, rect3.bottom);
    }

    public boolean y(int i10) {
        return this.D.l(i10);
    }
}
