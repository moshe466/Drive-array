package androidx.core.widget;

import F0.G1;
import J.C0114b;
import J.C0120h;
import J.C0129q;
import J.C0131t;
import J.C0137z;
import J.InterfaceC0130s;
import J.J;
import J.S;
import M.c;
import M.e;
import M.f;
import M.g;
import M.h;
import a.AbstractC0228a;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements InterfaceC0130s {

    /* renamed from: F, reason: collision with root package name */
    public static final float f3054F = (float) (Math.log(0.78d) / Math.log(0.9d));

    /* renamed from: G, reason: collision with root package name */
    public static final e f3055G = new C0114b();

    /* renamed from: H, reason: collision with root package name */
    public static final int[] f3056H = {R.attr.fillViewport};

    /* renamed from: A, reason: collision with root package name */
    public h f3057A;

    /* renamed from: B, reason: collision with root package name */
    public final C0131t f3058B;

    /* renamed from: C, reason: collision with root package name */
    public final C0129q f3059C;

    /* renamed from: D, reason: collision with root package name */
    public float f3060D;

    /* renamed from: E, reason: collision with root package name */
    public final C0120h f3061E;

    /* renamed from: a, reason: collision with root package name */
    public final float f3062a;

    /* renamed from: b, reason: collision with root package name */
    public long f3063b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f3064c;

    /* renamed from: d, reason: collision with root package name */
    public final OverScroller f3065d;

    /* renamed from: e, reason: collision with root package name */
    public final EdgeEffect f3066e;

    /* renamed from: f, reason: collision with root package name */
    public final EdgeEffect f3067f;

    /* renamed from: j, reason: collision with root package name */
    public C0137z f3068j;

    /* renamed from: k, reason: collision with root package name */
    public int f3069k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f3070l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3071m;

    /* renamed from: n, reason: collision with root package name */
    public View f3072n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f3073o;
    public VelocityTracker p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f3074q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f3075r;

    /* renamed from: s, reason: collision with root package name */
    public final int f3076s;

    /* renamed from: t, reason: collision with root package name */
    public final int f3077t;

    /* renamed from: u, reason: collision with root package name */
    public final int f3078u;

    /* renamed from: v, reason: collision with root package name */
    public int f3079v;

    /* renamed from: w, reason: collision with root package name */
    public final int[] f3080w;

    /* renamed from: x, reason: collision with root package name */
    public final int[] f3081x;
    public int y;

    /* renamed from: z, reason: collision with root package name */
    public int f3082z;

    /* JADX WARN: Type inference failed for: r7v2, types: [J.t, java.lang.Object] */
    public NestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.uh.sf.R.attr.nestedScrollViewStyle);
        EdgeEffect edgeEffect;
        EdgeEffect edgeEffect2;
        this.f3064c = new Rect();
        this.f3070l = true;
        this.f3071m = false;
        this.f3072n = null;
        this.f3073o = false;
        this.f3075r = true;
        this.f3079v = -1;
        this.f3080w = new int[2];
        this.f3081x = new int[2];
        this.f3061E = new C0120h(getContext(), new G1(this, 6));
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            edgeEffect = c.a(context, attributeSet);
        } else {
            edgeEffect = new EdgeEffect(context);
        }
        this.f3066e = edgeEffect;
        if (i >= 31) {
            edgeEffect2 = c.a(context, attributeSet);
        } else {
            edgeEffect2 = new EdgeEffect(context);
        }
        this.f3067f = edgeEffect2;
        this.f3062a = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        this.f3065d = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f3076s = viewConfiguration.getScaledTouchSlop();
        this.f3077t = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3078u = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3056H, com.uh.sf.R.attr.nestedScrollViewStyle, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f3058B = new Object();
        this.f3059C = new C0129q(this);
        setNestedScrollingEnabled(true);
        S.i(this, f3055G);
    }

    public static boolean g(View view, NestedScrollView nestedScrollView) {
        if (view != nestedScrollView) {
            Object parent = view.getParent();
            if ((parent instanceof ViewGroup) && g((View) parent, nestedScrollView)) {
                return true;
            }
            return false;
        }
        return true;
    }

    private C0137z getScrollFeedbackProvider() {
        if (this.f3068j == null) {
            this.f3068j = new C0137z(this);
        }
        return this.f3068j;
    }

    public final boolean a(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View view = findFocus;
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus != null && h(findNextFocus, maxScrollAmount, getHeight())) {
            Rect rect = this.f3064c;
            findNextFocus.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(findNextFocus, rect);
            n(b(rect), -1, null, 0, 1, true);
            findNextFocus.requestFocus(i);
        } else {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getHeight() + getScrollY()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            n(maxScrollAmount, -1, null, 0, 1, true);
        }
        if (view != null && view.isFocused() && !h(view, 0, getHeight())) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public final int b(Rect rect) {
        int i;
        int i3;
        int i4;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i5 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        if (rect.bottom < childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin) {
            i = i5 - verticalFadingEdgeLength;
        } else {
            i = i5;
        }
        int i6 = rect.bottom;
        if (i6 > i && rect.top > scrollY) {
            if (rect.height() > height) {
                i4 = rect.top - scrollY;
            } else {
                i4 = rect.bottom - i;
            }
            return Math.min(i4, (childAt.getBottom() + layoutParams.bottomMargin) - i5);
        }
        if (rect.top >= scrollY || i6 >= i) {
            return 0;
        }
        if (rect.height() > height) {
            i3 = 0 - (i - rect.bottom);
        } else {
            i3 = 0 - (scrollY - rect.top);
        }
        return Math.max(i3, -getScrollY());
    }

    public final boolean c(int i, int i3, int[] iArr, int[] iArr2, int i4) {
        return this.f3059C.c(i, i3, iArr, null, i4);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void computeScroll() {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.computeScroll():void");
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > max) {
            return (scrollY - max) + bottom;
        }
        return bottom;
    }

    public final boolean d(KeyEvent keyEvent) {
        this.f3064c.setEmpty();
        int i = 130;
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
                if (keyEvent.getAction() == 0) {
                    int keyCode = keyEvent.getKeyCode();
                    if (keyCode != 19) {
                        if (keyCode != 20) {
                            if (keyCode != 62) {
                                if (keyCode != 92) {
                                    if (keyCode != 93) {
                                        if (keyCode != 122) {
                                            if (keyCode == 123) {
                                                l(130);
                                                return false;
                                            }
                                        } else {
                                            l(33);
                                            return false;
                                        }
                                    } else {
                                        return f(130);
                                    }
                                } else {
                                    return f(33);
                                }
                            } else {
                                if (keyEvent.isShiftPressed()) {
                                    i = 33;
                                }
                                l(i);
                                return false;
                            }
                        } else {
                            if (keyEvent.isAltPressed()) {
                                return f(130);
                            }
                            return a(130);
                        }
                    } else {
                        if (keyEvent.isAltPressed()) {
                            return f(33);
                        }
                        return a(33);
                    }
                }
                return false;
            }
        }
        if (isFocused() && keyEvent.getKeyCode() != 4) {
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            if (findNextFocus != null && findNextFocus != this && findNextFocus.requestFocus(130)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent) && !d(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f4, float f5, boolean z3) {
        return this.f3059C.a(f4, f5, z3);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f4, float f5) {
        return this.f3059C.b(f4, f5);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i, int i3, int[] iArr, int[] iArr2) {
        return this.f3059C.c(i, i3, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i, int i3, int i4, int i5, int[] iArr) {
        return this.f3059C.d(i, i3, i4, i5, iArr, 0, null);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i;
        super.draw(canvas);
        int scrollY = getScrollY();
        EdgeEffect edgeEffect = this.f3066e;
        int i3 = 0;
        if (!edgeEffect.isFinished()) {
            int save = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int min = Math.min(0, scrollY);
            if (getClipToPadding()) {
                width -= getPaddingRight() + getPaddingLeft();
                i = getPaddingLeft();
            } else {
                i = 0;
            }
            if (getClipToPadding()) {
                height -= getPaddingBottom() + getPaddingTop();
                min += getPaddingTop();
            }
            canvas.translate(i, min);
            edgeEffect.setSize(width, height);
            if (edgeEffect.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect2 = this.f3067f;
        if (!edgeEffect2.isFinished()) {
            int save2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int max = Math.max(getScrollRange(), scrollY) + height2;
            if (getClipToPadding()) {
                width2 -= getPaddingRight() + getPaddingLeft();
                i3 = getPaddingLeft();
            }
            if (getClipToPadding()) {
                height2 -= getPaddingBottom() + getPaddingTop();
                max -= getPaddingBottom();
            }
            canvas.translate(i3 - width2, max);
            canvas.rotate(180.0f, width2, 0.0f);
            edgeEffect2.setSize(width2, height2);
            if (edgeEffect2.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(save2);
        }
    }

    public final void e(int i) {
        if (getChildCount() > 0) {
            this.f3065d.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER, 0, 0);
            q(2, 1);
            this.f3082z = getScrollY();
            postInvalidateOnAnimation();
            if (Build.VERSION.SDK_INT >= 35) {
                f.a(this, Math.abs(this.f3065d.getCurrVelocity()));
            }
        }
    }

    public final boolean f(int i) {
        boolean z3;
        int childCount;
        if (i == 130) {
            z3 = true;
        } else {
            z3 = false;
        }
        int height = getHeight();
        Rect rect = this.f3064c;
        rect.top = 0;
        rect.bottom = height;
        if (z3 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            rect.bottom = paddingBottom;
            rect.top = paddingBottom - height;
        }
        return m(i, rect.top, rect.bottom);
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
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
        C0131t c0131t = this.f3058B;
        return c0131t.f1032b | c0131t.f1031a;
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
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

    public float getVerticalScrollFactorCompat() {
        if (this.f3060D == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                this.f3060D = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.f3060D;
    }

    public final boolean h(View view, int i, int i3) {
        Rect rect = this.f3064c;
        view.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(view, rect);
        if (rect.bottom + i >= getScrollY() && rect.top - i <= getScrollY() + i3) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.f3059C.f(0);
    }

    public final void i(int i, int i3, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f3059C.d(0, scrollY2, 0, i - scrollY2, null, i3, iArr);
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.f3059C.f1026d;
    }

    public final void j(MotionEvent motionEvent) {
        int i;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f3079v) {
            if (actionIndex == 0) {
                i = 1;
            } else {
                i = 0;
            }
            this.f3069k = (int) motionEvent.getY(i);
            this.f3079v = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.p;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public final boolean k(int i, int i3, int i4, int i5) {
        int i6;
        boolean z3;
        int i7;
        boolean z4;
        getOverScrollMode();
        super.computeHorizontalScrollRange();
        super.computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        super.computeVerticalScrollExtent();
        int i8 = i4 + i;
        if (i3 > 0 || i3 < 0) {
            i6 = 0;
            z3 = true;
        } else {
            i6 = i3;
            z3 = false;
        }
        if (i8 > i5) {
            i7 = i5;
        } else if (i8 < 0) {
            i7 = 0;
        } else {
            i7 = i8;
            z4 = false;
            if (z4 && !this.f3059C.f(1)) {
                this.f3065d.springBack(i6, i7, 0, 0, 0, getScrollRange());
            }
            super.scrollTo(i6, i7);
            if (!z3 || z4) {
                return true;
            }
            return false;
        }
        z4 = true;
        if (z4) {
            this.f3065d.springBack(i6, i7, 0, 0, 0, getScrollRange());
        }
        super.scrollTo(i6, i7);
        if (!z3) {
        }
        return true;
    }

    public final void l(int i) {
        boolean z3;
        if (i == 130) {
            z3 = true;
        } else {
            z3 = false;
        }
        int height = getHeight();
        Rect rect = this.f3064c;
        if (z3) {
            rect.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                if (rect.top + height > paddingBottom) {
                    rect.top = paddingBottom - height;
                }
            }
        } else {
            int scrollY = getScrollY() - height;
            rect.top = scrollY;
            if (scrollY < 0) {
                rect.top = 0;
            }
        }
        int i3 = rect.top;
        int i4 = height + i3;
        rect.bottom = i4;
        m(i, i3, i4);
    }

    public final boolean m(int i, int i3, int i4) {
        boolean z3;
        View view;
        int i5;
        boolean z4;
        boolean z5;
        boolean z6;
        int height = getHeight();
        int scrollY = getScrollY();
        int i6 = height + scrollY;
        if (i == 33) {
            z3 = true;
        } else {
            z3 = false;
        }
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view2 = null;
        boolean z7 = false;
        for (int i7 = 0; i7 < size; i7++) {
            View view3 = focusables.get(i7);
            int top = view3.getTop();
            int bottom = view3.getBottom();
            if (i3 < bottom && top < i4) {
                if (i3 < top && bottom < i4) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (view2 == null) {
                    view2 = view3;
                    z7 = z5;
                } else {
                    if ((z3 && top < view2.getTop()) || (!z3 && bottom > view2.getBottom())) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (z7) {
                        if (z5) {
                            if (!z6) {
                            }
                            view2 = view3;
                        }
                    } else if (z5) {
                        view2 = view3;
                        z7 = true;
                    } else {
                        if (!z6) {
                        }
                        view2 = view3;
                    }
                }
            }
        }
        if (view2 == null) {
            view = this;
        } else {
            view = view2;
        }
        if (i3 >= scrollY && i4 <= i6) {
            z4 = false;
        } else {
            if (z3) {
                i5 = i3 - scrollY;
            } else {
                i5 = i4 - i6;
            }
            n(i5, -1, null, 0, 1, true);
            z4 = true;
        }
        if (view != findFocus()) {
            view.requestFocus(i);
        }
        return z4;
    }

    @Override // android.view.ViewGroup
    public final void measureChild(View view, int i, int i3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public final void measureChildWithMargins(View view, int i, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int n(int r21, int r22, android.view.MotionEvent r23, int r24, int r25, boolean r26) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.n(int, int, android.view.MotionEvent, int, int, boolean):int");
    }

    public final boolean o(EdgeEffect edgeEffect, int i) {
        if (i > 0) {
            return true;
        }
        float p = AbstractC0228a.p(edgeEffect) * getHeight();
        float abs = Math.abs(-i) * 0.35f;
        float f4 = this.f3062a * 0.015f;
        double log = Math.log(abs / f4);
        double d2 = f3054F;
        if (((float) (Math.exp((d2 / (d2 - 1.0d)) * log) * f4)) < p) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3071m = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:144:0x0122, code lost:
    
        if (r0 >= 0) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x00d7, code lost:
    
        if (r7 >= 0) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02ab  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onGenericMotionEvent(android.view.MotionEvent r32) {
        /*
            Method dump skipped, instructions count: 844
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z3 = true;
        if (action == 2 && this.f3073o) {
            return true;
        }
        int i = action & 255;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 6) {
                            j(motionEvent);
                        }
                    }
                } else {
                    int i3 = this.f3079v;
                    if (i3 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i3);
                        if (findPointerIndex == -1) {
                            Log.e("NestedScrollView", "Invalid pointerId=" + i3 + " in onInterceptTouchEvent");
                        } else {
                            int y = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y - this.f3069k) > this.f3076s && (2 & getNestedScrollAxes()) == 0) {
                                this.f3073o = true;
                                this.f3069k = y;
                                if (this.p == null) {
                                    this.p = VelocityTracker.obtain();
                                }
                                this.p.addMovement(motionEvent);
                                this.y = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                }
            }
            this.f3073o = false;
            this.f3079v = -1;
            VelocityTracker velocityTracker = this.p;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.p = null;
            }
            if (this.f3065d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
            s(0);
        } else {
            int y3 = (int) motionEvent.getY();
            int x3 = (int) motionEvent.getX();
            if (getChildCount() > 0) {
                int scrollY = getScrollY();
                View childAt = getChildAt(0);
                if (y3 >= childAt.getTop() - scrollY && y3 < childAt.getBottom() - scrollY && x3 >= childAt.getLeft() && x3 < childAt.getRight()) {
                    this.f3069k = y3;
                    this.f3079v = motionEvent.getPointerId(0);
                    VelocityTracker velocityTracker2 = this.p;
                    if (velocityTracker2 == null) {
                        this.p = VelocityTracker.obtain();
                    } else {
                        velocityTracker2.clear();
                    }
                    this.p.addMovement(motionEvent);
                    this.f3065d.computeScrollOffset();
                    if (!r(motionEvent) && this.f3065d.isFinished()) {
                        z3 = false;
                    }
                    this.f3073o = z3;
                    q(2, 0);
                }
            }
            if (!r(motionEvent) && this.f3065d.isFinished()) {
                z3 = false;
            }
            this.f3073o = z3;
            VelocityTracker velocityTracker3 = this.p;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.p = null;
            }
        }
        return this.f3073o;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z3, int i, int i3, int i4, int i5) {
        int i6;
        super.onLayout(z3, i, i3, i4, i5);
        int i7 = 0;
        this.f3070l = false;
        View view = this.f3072n;
        if (view != null && g(view, this)) {
            View view2 = this.f3072n;
            Rect rect = this.f3064c;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int b4 = b(rect);
            if (b4 != 0) {
                scrollBy(0, b4);
            }
        }
        this.f3072n = null;
        if (!this.f3071m) {
            if (this.f3057A != null) {
                scrollTo(getScrollX(), this.f3057A.f1379a);
                this.f3057A = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i6 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            } else {
                i6 = 0;
            }
            int paddingTop = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            if (paddingTop < i6 && scrollY >= 0) {
                i7 = paddingTop + scrollY > i6 ? i6 - paddingTop : scrollY;
            }
            if (i7 != scrollY) {
                scrollTo(getScrollX(), i7);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f3071m = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i3) {
        super.onMeasure(i, i3);
        if (this.f3074q && View.MeasureSpec.getMode(i3) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f4, float f5, boolean z3) {
        if (!z3) {
            dispatchNestedFling(0.0f, f5, true);
            e((int) f5);
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f4, float f5) {
        return this.f3059C.b(f4, f5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i3, int[] iArr) {
        c(i, i3, iArr, null, 0);
    }

    @Override // J.InterfaceC0130s
    public final void onNestedScroll(View view, int i, int i3, int i4, int i5, int i6, int[] iArr) {
        i(i5, i6, iArr);
    }

    @Override // J.r
    public final void onNestedScrollAccepted(View view, View view2, int i, int i3) {
        C0131t c0131t = this.f3058B;
        if (i3 == 1) {
            c0131t.f1032b = i;
        } else {
            c0131t.f1031a = i;
        }
        q(2, i3);
    }

    @Override // android.view.View
    public final void onOverScrolled(int i, int i3, boolean z3, boolean z4) {
        super.scrollTo(i, i3);
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i, Rect rect) {
        View findNextFocusFromRect;
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        if (rect == null) {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, null, i);
        } else {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        }
        if (findNextFocusFromRect == null || !h(findNextFocusFromRect, 0, getHeight())) {
            return false;
        }
        return findNextFocusFromRect.requestFocus(i, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.getSuperState());
        this.f3057A = hVar;
        requestLayout();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.View$BaseSavedState, android.os.Parcelable, M.h] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ?? baseSavedState = new View.BaseSavedState(super.onSaveInstanceState());
        baseSavedState.f1379a = getScrollY();
        return baseSavedState;
    }

    @Override // android.view.View
    public final void onScrollChanged(int i, int i3, int i4, int i5) {
        super.onScrollChanged(i, i3, i4, i5);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i3, int i4, int i5) {
        super.onSizeChanged(i, i3, i4, i5);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && h(findFocus, 0, i5)) {
            Rect rect = this.f3064c;
            findFocus.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(findFocus, rect);
            int b4 = b(rect);
            if (b4 != 0) {
                if (this.f3075r) {
                    p(0, b4, false);
                } else {
                    scrollBy(0, b4);
                }
            }
        }
    }

    @Override // J.r
    public final boolean onStartNestedScroll(View view, View view2, int i, int i3) {
        return (i & 2) != 0;
    }

    @Override // J.r
    public final void onStopNestedScroll(View view, int i) {
        C0131t c0131t = this.f3058B;
        if (i == 1) {
            c0131t.f1032b = 0;
        } else {
            c0131t.f1031a = 0;
        }
        s(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0147  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(int i, int i3, boolean z3) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f3063b > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int max = Math.max(0, Math.min(i3 + scrollY, Math.max(0, height - height2))) - scrollY;
            this.f3065d.startScroll(getScrollX(), scrollY, 0, max, 250);
            if (z3) {
                q(2, 1);
            } else {
                s(1);
            }
            this.f3082z = getScrollY();
            postInvalidateOnAnimation();
        } else {
            if (!this.f3065d.isFinished()) {
                this.f3065d.abortAnimation();
                s(1);
            }
            scrollBy(i, i3);
        }
        this.f3063b = AnimationUtils.currentAnimationTimeMillis();
    }

    public final boolean q(int i, int i3) {
        return this.f3059C.g(2, i3);
    }

    public final boolean r(MotionEvent motionEvent) {
        boolean z3;
        EdgeEffect edgeEffect = this.f3066e;
        if (AbstractC0228a.p(edgeEffect) != 0.0f) {
            AbstractC0228a.y(edgeEffect, 0.0f, motionEvent.getX() / getWidth());
            z3 = true;
        } else {
            z3 = false;
        }
        EdgeEffect edgeEffect2 = this.f3067f;
        if (AbstractC0228a.p(edgeEffect2) != 0.0f) {
            AbstractC0228a.y(edgeEffect2, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
            return true;
        }
        return z3;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        if (!this.f3070l) {
            Rect rect = this.f3064c;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int b4 = b(rect);
            if (b4 != 0) {
                scrollBy(0, b4);
            }
        } else {
            this.f3072n = view2;
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z3) {
        boolean z4;
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int b4 = b(rect);
        if (b4 != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            if (z3) {
                scrollBy(0, b4);
                return z4;
            }
            p(0, b4, false);
        }
        return z4;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z3) {
        VelocityTracker velocityTracker;
        if (z3 && (velocityTracker = this.p) != null) {
            velocityTracker.recycle();
            this.p = null;
        }
        super.requestDisallowInterceptTouchEvent(z3);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.f3070l = true;
        super.requestLayout();
    }

    public final void s(int i) {
        this.f3059C.h(i);
    }

    @Override // android.view.View
    public final void scrollTo(int i, int i3) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (width < width2 && i >= 0) {
                if (width + i > width2) {
                    i = width2 - width;
                }
            } else {
                i = 0;
            }
            if (height < height2 && i3 >= 0) {
                if (height + i3 > height2) {
                    i3 = height2 - height;
                }
            } else {
                i3 = 0;
            }
            if (i != getScrollX() || i3 != getScrollY()) {
                super.scrollTo(i, i3);
            }
        }
    }

    public void setFillViewport(boolean z3) {
        if (z3 != this.f3074q) {
            this.f3074q = z3;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z3) {
        C0129q c0129q = this.f3059C;
        if (c0129q.f1026d) {
            ViewGroup viewGroup = c0129q.f1025c;
            WeakHashMap weakHashMap = S.f954a;
            J.l(viewGroup);
        }
        c0129q.f1026d = z3;
    }

    public void setSmoothScrollingEnabled(boolean z3) {
        this.f3075r = z3;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i) {
        return this.f3059C.g(i, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        s(0);
    }

    @Override // J.r
    public final void onNestedPreScroll(View view, int i, int i3, int[] iArr, int i4) {
        c(i, i3, iArr, null, i4);
    }

    @Override // J.r
    public final void onNestedScroll(View view, int i, int i3, int i4, int i5, int i6) {
        i(i5, i6, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i3, int i4, int i5) {
        i(i5, 0, null);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i) {
        if (getChildCount() <= 0) {
            super.addView(view, i);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void setOnScrollChangeListener(g gVar) {
    }
}
