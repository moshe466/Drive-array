package androidx.appcompat.widget;

import F0.C0047j2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.lifecycle.N;
import com.google.android.gms.common.api.Api;
import h.H;
import l.InterfaceC0498B;
import l.k;
import l.l;
import l.m;
import l.o;
import l.y;
import m.A0;
import m.B0;
import m.C0540e;
import m.C0546h;
import m.C0548i;
import m.C0552k;
import m.InterfaceC0550j;
import m.InterfaceC0554l;
import m.z1;

/* loaded from: classes.dex */
public class ActionMenuView extends B0 implements l, InterfaceC0498B {

    /* renamed from: A, reason: collision with root package name */
    public int f2853A;

    /* renamed from: B, reason: collision with root package name */
    public final int f2854B;

    /* renamed from: C, reason: collision with root package name */
    public final int f2855C;

    /* renamed from: D, reason: collision with root package name */
    public InterfaceC0554l f2856D;

    /* renamed from: s, reason: collision with root package name */
    public m f2857s;

    /* renamed from: t, reason: collision with root package name */
    public Context f2858t;

    /* renamed from: u, reason: collision with root package name */
    public int f2859u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f2860v;

    /* renamed from: w, reason: collision with root package name */
    public C0548i f2861w;

    /* renamed from: x, reason: collision with root package name */
    public H f2862x;
    public k y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f2863z;

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setBaselineAligned(false);
        float f4 = context.getResources().getDisplayMetrics().density;
        this.f2854B = (int) (56.0f * f4);
        this.f2855C = (int) (f4 * 4.0f);
        this.f2858t = context;
        this.f2859u = 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.LinearLayout$LayoutParams, m.k] */
    public static C0552k i() {
        ?? layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.f5709a = false;
        ((LinearLayout.LayoutParams) layoutParams).gravity = 16;
        return layoutParams;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.widget.LinearLayout$LayoutParams, m.k] */
    public static C0552k j(ViewGroup.LayoutParams layoutParams) {
        C0552k c0552k;
        if (layoutParams != null) {
            if (layoutParams instanceof C0552k) {
                C0552k c0552k2 = (C0552k) layoutParams;
                ?? layoutParams2 = new LinearLayout.LayoutParams((ViewGroup.LayoutParams) c0552k2);
                layoutParams2.f5709a = c0552k2.f5709a;
                c0552k = layoutParams2;
            } else {
                c0552k = new LinearLayout.LayoutParams(layoutParams);
            }
            if (((LinearLayout.LayoutParams) c0552k).gravity <= 0) {
                ((LinearLayout.LayoutParams) c0552k).gravity = 16;
            }
            return c0552k;
        }
        return i();
    }

    @Override // l.l
    public final boolean a(o oVar) {
        return this.f2857s.q(oVar, null, 0);
    }

    @Override // l.InterfaceC0498B
    public final void b(m mVar) {
        this.f2857s = mVar;
    }

    @Override // m.B0, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0552k;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // m.B0
    /* renamed from: e */
    public final /* bridge */ /* synthetic */ A0 generateDefaultLayoutParams() {
        return i();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [m.A0, android.widget.LinearLayout$LayoutParams] */
    @Override // m.B0
    /* renamed from: f */
    public final A0 generateLayoutParams(AttributeSet attributeSet) {
        return new LinearLayout.LayoutParams(getContext(), attributeSet);
    }

    @Override // m.B0
    /* renamed from: g */
    public final /* bridge */ /* synthetic */ A0 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return j(layoutParams);
    }

    @Override // m.B0, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return i();
    }

    @Override // m.B0, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return j(layoutParams);
    }

    public Menu getMenu() {
        if (this.f2857s == null) {
            Context context = getContext();
            m mVar = new m(context);
            this.f2857s = mVar;
            mVar.f5404e = new C0047j2(this, 19);
            C0548i c0548i = new C0548i(context);
            this.f2861w = c0548i;
            c0548i.f5679o = true;
            c0548i.p = true;
            y yVar = this.f2862x;
            if (yVar == null) {
                yVar = new N(24);
            }
            c0548i.f5672e = yVar;
            this.f2857s.b(c0548i, this.f2858t);
            C0548i c0548i2 = this.f2861w;
            c0548i2.f5675k = this;
            this.f2857s = c0548i2.f5670c;
        }
        return this.f2857s;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        C0548i c0548i = this.f2861w;
        C0546h c0546h = c0548i.f5676l;
        if (c0546h != null) {
            return c0546h.getDrawable();
        }
        if (c0548i.f5678n) {
            return c0548i.f5677m;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.f2859u;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public final boolean k(int i) {
        boolean z3 = false;
        if (i == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i - 1);
        KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof InterfaceC0550j)) {
            z3 = ((InterfaceC0550j) childAt).a();
        }
        if (i > 0 && (childAt2 instanceof InterfaceC0550j)) {
            return ((InterfaceC0550j) childAt2).c() | z3;
        }
        return z3;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0548i c0548i = this.f2861w;
        if (c0548i != null) {
            c0548i.e();
            if (this.f2861w.k()) {
                this.f2861w.g();
                this.f2861w.l();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0548i c0548i = this.f2861w;
        if (c0548i != null) {
            c0548i.g();
            C0540e c0540e = c0548i.f5686w;
            if (c0540e != null && c0540e.b()) {
                c0540e.i.dismiss();
            }
        }
    }

    @Override // m.B0, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z3, int i, int i3, int i4, int i5) {
        int i6;
        int width;
        int i7;
        if (!this.f2863z) {
            super.onLayout(z3, i, i3, i4, i5);
            return;
        }
        int childCount = getChildCount();
        int i8 = (i5 - i3) / 2;
        int dividerWidth = getDividerWidth();
        int i9 = i4 - i;
        int paddingRight = (i9 - getPaddingRight()) - getPaddingLeft();
        boolean a2 = z1.a(this);
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                C0552k c0552k = (C0552k) childAt.getLayoutParams();
                if (c0552k.f5709a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (k(i12)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a2) {
                        i7 = getPaddingLeft() + ((LinearLayout.LayoutParams) c0552k).leftMargin;
                        width = i7 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) c0552k).rightMargin;
                        i7 = width - measuredWidth;
                    }
                    int i13 = i8 - (measuredHeight / 2);
                    childAt.layout(i7, i13, width, measuredHeight + i13);
                    paddingRight -= measuredWidth;
                    i10 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) c0552k).leftMargin) + ((LinearLayout.LayoutParams) c0552k).rightMargin;
                    k(i12);
                    i11++;
                }
            }
        }
        if (childCount == 1 && i10 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i14 = (i9 / 2) - (measuredWidth2 / 2);
            int i15 = i8 - (measuredHeight2 / 2);
            childAt2.layout(i14, i15, measuredWidth2 + i14, measuredHeight2 + i15);
            return;
        }
        int i16 = i11 - (i10 ^ 1);
        if (i16 > 0) {
            i6 = paddingRight / i16;
        } else {
            i6 = 0;
        }
        int max = Math.max(0, i6);
        if (a2) {
            int width2 = getWidth() - getPaddingRight();
            for (int i17 = 0; i17 < childCount; i17++) {
                View childAt3 = getChildAt(i17);
                C0552k c0552k2 = (C0552k) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !c0552k2.f5709a) {
                    int i18 = width2 - ((LinearLayout.LayoutParams) c0552k2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i19 = i8 - (measuredHeight3 / 2);
                    childAt3.layout(i18 - measuredWidth3, i19, i18, measuredHeight3 + i19);
                    width2 = i18 - ((measuredWidth3 + ((LinearLayout.LayoutParams) c0552k2).leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt4 = getChildAt(i20);
            C0552k c0552k3 = (C0552k) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !c0552k3.f5709a) {
                int i21 = paddingLeft + ((LinearLayout.LayoutParams) c0552k3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i22 = i8 - (measuredHeight4 / 2);
                childAt4.layout(i21, i22, i21 + measuredWidth4, measuredHeight4 + i22);
                paddingLeft = measuredWidth4 + ((LinearLayout.LayoutParams) c0552k3).rightMargin + max + i21;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v41 */
    @Override // m.B0, android.view.View
    public final void onMeasure(int i, int i3) {
        boolean z3;
        int i4;
        boolean z4;
        int i5;
        boolean z5;
        int i6;
        int i7;
        ?? r11;
        boolean z6;
        int i8;
        int i9;
        ActionMenuItemView actionMenuItemView;
        boolean z7;
        int i10;
        boolean z8;
        m mVar;
        boolean z9 = this.f2863z;
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f2863z = z3;
        if (z9 != z3) {
            this.f2853A = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.f2863z && (mVar = this.f2857s) != null && size != this.f2853A) {
            this.f2853A = size;
            mVar.p(true);
        }
        int childCount = getChildCount();
        if (this.f2863z && childCount > 0) {
            int mode = View.MeasureSpec.getMode(i3);
            int size2 = View.MeasureSpec.getSize(i);
            int size3 = View.MeasureSpec.getSize(i3);
            int paddingRight = getPaddingRight() + getPaddingLeft();
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, paddingBottom, -2);
            int i11 = size2 - paddingRight;
            int i12 = this.f2854B;
            int i13 = i11 / i12;
            int i14 = i11 % i12;
            if (i13 == 0) {
                setMeasuredDimension(i11, 0);
                return;
            }
            int i15 = (i14 / i13) + i12;
            int childCount2 = getChildCount();
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            boolean z10 = false;
            int i20 = 0;
            long j2 = 0;
            while (true) {
                i4 = this.f2855C;
                if (i19 >= childCount2) {
                    break;
                }
                View childAt = getChildAt(i19);
                int i21 = size3;
                int i22 = paddingBottom;
                if (childAt.getVisibility() == 8) {
                    i9 = i15;
                } else {
                    boolean z11 = childAt instanceof ActionMenuItemView;
                    i17++;
                    if (z11) {
                        childAt.setPadding(i4, 0, i4, 0);
                    }
                    C0552k c0552k = (C0552k) childAt.getLayoutParams();
                    c0552k.f5714f = false;
                    c0552k.f5711c = 0;
                    c0552k.f5710b = 0;
                    c0552k.f5712d = false;
                    ((LinearLayout.LayoutParams) c0552k).leftMargin = 0;
                    ((LinearLayout.LayoutParams) c0552k).rightMargin = 0;
                    if (z11 && !TextUtils.isEmpty(((ActionMenuItemView) childAt).getText())) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    c0552k.f5713e = z6;
                    if (c0552k.f5709a) {
                        i8 = 1;
                    } else {
                        i8 = i13;
                    }
                    C0552k c0552k2 = (C0552k) childAt.getLayoutParams();
                    int i23 = i13;
                    i9 = i15;
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - i22, View.MeasureSpec.getMode(childMeasureSpec));
                    if (z11) {
                        actionMenuItemView = (ActionMenuItemView) childAt;
                    } else {
                        actionMenuItemView = null;
                    }
                    if (actionMenuItemView != null && !TextUtils.isEmpty(actionMenuItemView.getText())) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    boolean z12 = z7;
                    if (i8 > 0 && (!z7 || i8 >= 2)) {
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(i9 * i8, Integer.MIN_VALUE), makeMeasureSpec);
                        int measuredWidth = childAt.getMeasuredWidth();
                        i10 = measuredWidth / i9;
                        if (measuredWidth % i9 != 0) {
                            i10++;
                        }
                        if (z12 && i10 < 2) {
                            i10 = 2;
                        }
                    } else {
                        i10 = 0;
                    }
                    if (!c0552k2.f5709a && z12) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    c0552k2.f5712d = z8;
                    c0552k2.f5710b = i10;
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i10 * i9, 1073741824), makeMeasureSpec);
                    i18 = Math.max(i18, i10);
                    if (c0552k.f5712d) {
                        i20++;
                    }
                    if (c0552k.f5709a) {
                        z10 = true;
                    }
                    i13 = i23 - i10;
                    i16 = Math.max(i16, childAt.getMeasuredHeight());
                    if (i10 == 1) {
                        j2 |= 1 << i19;
                    }
                }
                i19++;
                size3 = i21;
                paddingBottom = i22;
                i15 = i9;
            }
            int i24 = size3;
            int i25 = i13;
            int i26 = i15;
            if (z10 && i17 == 2) {
                z4 = true;
            } else {
                z4 = false;
            }
            int i27 = i25;
            boolean z13 = false;
            while (i20 > 0 && i27 > 0) {
                int i28 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                long j3 = 0;
                int i29 = 0;
                int i30 = 0;
                while (i30 < childCount2) {
                    int i31 = i16;
                    C0552k c0552k3 = (C0552k) getChildAt(i30).getLayoutParams();
                    boolean z14 = z4;
                    if (c0552k3.f5712d) {
                        int i32 = c0552k3.f5710b;
                        if (i32 < i28) {
                            j3 = 1 << i30;
                            i28 = i32;
                            i29 = 1;
                        } else if (i32 == i28) {
                            j3 |= 1 << i30;
                            i29++;
                        }
                    }
                    i30++;
                    z4 = z14;
                    i16 = i31;
                }
                i5 = i16;
                boolean z15 = z4;
                j2 |= j3;
                if (i29 > i27) {
                    break;
                }
                int i33 = i28 + 1;
                int i34 = 0;
                while (i34 < childCount2) {
                    View childAt2 = getChildAt(i34);
                    C0552k c0552k4 = (C0552k) childAt2.getLayoutParams();
                    boolean z16 = z10;
                    long j4 = 1 << i34;
                    if ((j3 & j4) == 0) {
                        if (c0552k4.f5710b == i33) {
                            j2 |= j4;
                        }
                    } else {
                        if (z15 && c0552k4.f5713e) {
                            r11 = 1;
                            r11 = 1;
                            if (i27 == 1) {
                                childAt2.setPadding(i4 + i26, 0, i4, 0);
                            }
                        } else {
                            r11 = 1;
                        }
                        c0552k4.f5710b += r11;
                        c0552k4.f5714f = r11;
                        i27--;
                    }
                    i34++;
                    z10 = z16;
                }
                z4 = z15;
                i16 = i5;
                z13 = true;
            }
            i5 = i16;
            if (!z10 && i17 == 1) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (i27 > 0 && j2 != 0 && (i27 < i17 - 1 || z5 || i18 > 1)) {
                float bitCount = Long.bitCount(j2);
                if (!z5) {
                    if ((j2 & 1) != 0 && !((C0552k) getChildAt(0).getLayoutParams()).f5713e) {
                        bitCount -= 0.5f;
                    }
                    int i35 = childCount2 - 1;
                    if ((j2 & (1 << i35)) != 0 && !((C0552k) getChildAt(i35).getLayoutParams()).f5713e) {
                        bitCount -= 0.5f;
                    }
                }
                if (bitCount > 0.0f) {
                    i7 = (int) ((i27 * i26) / bitCount);
                } else {
                    i7 = 0;
                }
                boolean z17 = z13;
                for (int i36 = 0; i36 < childCount2; i36++) {
                    if ((j2 & (1 << i36)) != 0) {
                        View childAt3 = getChildAt(i36);
                        C0552k c0552k5 = (C0552k) childAt3.getLayoutParams();
                        if (childAt3 instanceof ActionMenuItemView) {
                            c0552k5.f5711c = i7;
                            c0552k5.f5714f = true;
                            if (i36 == 0 && !c0552k5.f5713e) {
                                ((LinearLayout.LayoutParams) c0552k5).leftMargin = (-i7) / 2;
                            }
                            z17 = true;
                        } else if (c0552k5.f5709a) {
                            c0552k5.f5711c = i7;
                            c0552k5.f5714f = true;
                            ((LinearLayout.LayoutParams) c0552k5).rightMargin = (-i7) / 2;
                            z17 = true;
                        } else {
                            if (i36 != 0) {
                                ((LinearLayout.LayoutParams) c0552k5).leftMargin = i7 / 2;
                            }
                            if (i36 != childCount2 - 1) {
                                ((LinearLayout.LayoutParams) c0552k5).rightMargin = i7 / 2;
                            }
                        }
                    }
                }
                z13 = z17;
            }
            if (z13) {
                for (int i37 = 0; i37 < childCount2; i37++) {
                    View childAt4 = getChildAt(i37);
                    C0552k c0552k6 = (C0552k) childAt4.getLayoutParams();
                    if (c0552k6.f5714f) {
                        childAt4.measure(View.MeasureSpec.makeMeasureSpec((c0552k6.f5710b * i26) + c0552k6.f5711c, 1073741824), childMeasureSpec);
                    }
                }
            }
            if (mode != 1073741824) {
                i6 = i5;
            } else {
                i6 = i24;
            }
            setMeasuredDimension(i11, i6);
            return;
        }
        for (int i38 = 0; i38 < childCount; i38++) {
            C0552k c0552k7 = (C0552k) getChildAt(i38).getLayoutParams();
            ((LinearLayout.LayoutParams) c0552k7).rightMargin = 0;
            ((LinearLayout.LayoutParams) c0552k7).leftMargin = 0;
        }
        super.onMeasure(i, i3);
    }

    public void setExpandedActionViewsExclusive(boolean z3) {
        this.f2861w.f5683t = z3;
    }

    public void setOnMenuItemClickListener(InterfaceC0554l interfaceC0554l) {
        this.f2856D = interfaceC0554l;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        C0548i c0548i = this.f2861w;
        C0546h c0546h = c0548i.f5676l;
        if (c0546h != null) {
            c0546h.setImageDrawable(drawable);
        } else {
            c0548i.f5678n = true;
            c0548i.f5677m = drawable;
        }
    }

    public void setOverflowReserved(boolean z3) {
        this.f2860v = z3;
    }

    public void setPopupTheme(int i) {
        if (this.f2859u != i) {
            this.f2859u = i;
            if (i == 0) {
                this.f2858t = getContext();
            } else {
                this.f2858t = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(C0548i c0548i) {
        this.f2861w = c0548i;
        c0548i.f5675k = this;
        this.f2857s = c0548i.f5670c;
    }

    @Override // m.B0, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LinearLayout.LayoutParams(getContext(), attributeSet);
    }
}
