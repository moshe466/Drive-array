package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.k0;

/* loaded from: classes.dex */
public class ActionMenuView extends k0 implements g.b, androidx.appcompat.view.menu.n {
    g.a A;
    private boolean B;
    private int C;
    private int D;
    private int E;
    e F;

    /* renamed from: u, reason: collision with root package name */
    private androidx.appcompat.view.menu.g f1076u;

    /* renamed from: v, reason: collision with root package name */
    private Context f1077v;

    /* renamed from: w, reason: collision with root package name */
    private int f1078w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f1079x;

    /* renamed from: y, reason: collision with root package name */
    private androidx.appcompat.widget.c f1080y;

    /* renamed from: z, reason: collision with root package name */
    private m.a f1081z;

    /* loaded from: classes.dex */
    public interface a {
        boolean a();

        boolean b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements m.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void b(androidx.appcompat.view.menu.g gVar, boolean z10) {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean c(androidx.appcompat.view.menu.g gVar) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends k0.a {

        /* renamed from: a, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f1082a;

        /* renamed from: b, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f1083b;

        /* renamed from: c, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f1084c;

        /* renamed from: d, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f1085d;

        /* renamed from: e, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f1086e;

        /* renamed from: f, reason: collision with root package name */
        boolean f1087f;

        public c(int i10, int i11) {
            super(i10, i11);
            this.f1082a = false;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.f1082a = cVar.f1082a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements g.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            e eVar = ActionMenuView.this.F;
            return eVar != null && eVar.onMenuItemClick(menuItem);
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(androidx.appcompat.view.menu.g gVar) {
            g.a aVar = ActionMenuView.this.A;
            if (aVar != null) {
                aVar.b(gVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.D = (int) (56.0f * f10);
        this.E = (int) (f10 * 4.0f);
        this.f1077v = context;
        this.f1078w = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int L(View view, int i10, int i11, int i12, int i13) {
        c cVar = (c) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i12) - i13, View.MeasureSpec.getMode(i12));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z10 = actionMenuItemView != null && actionMenuItemView.f();
        int i14 = 2;
        if (i11 <= 0 || (z10 && i11 < 2)) {
            i14 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i11 * i10, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i15 = measuredWidth / i10;
            if (measuredWidth % i10 != 0) {
                i15++;
            }
            if (!z10 || i15 >= 2) {
                i14 = i15;
            }
        }
        cVar.f1085d = !cVar.f1082a && z10;
        cVar.f1083b = i14;
        view.measure(View.MeasureSpec.makeMeasureSpec(i10 * i14, 1073741824), makeMeasureSpec);
        return i14;
    }

    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9, types: [boolean, int] */
    private void M(int i10, int i11) {
        int i12;
        int i13;
        boolean z10;
        int i14;
        boolean z11;
        boolean z12;
        int i15;
        ?? r14;
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, paddingTop, -2);
        int i16 = size - paddingLeft;
        int i17 = this.D;
        int i18 = i16 / i17;
        int i19 = i16 % i17;
        if (i18 == 0) {
            setMeasuredDimension(i16, 0);
            return;
        }
        int i20 = i17 + (i19 / i18);
        int childCount = getChildCount();
        int i21 = 0;
        int i22 = 0;
        boolean z13 = false;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        long j10 = 0;
        while (i22 < childCount) {
            View childAt = getChildAt(i22);
            int i26 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z14 = childAt instanceof ActionMenuItemView;
                int i27 = i23 + 1;
                if (z14) {
                    int i28 = this.E;
                    i15 = i27;
                    r14 = 0;
                    childAt.setPadding(i28, 0, i28, 0);
                } else {
                    i15 = i27;
                    r14 = 0;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.f1087f = r14;
                cVar.f1084c = r14;
                cVar.f1083b = r14;
                cVar.f1085d = r14;
                ((LinearLayout.LayoutParams) cVar).leftMargin = r14;
                ((LinearLayout.LayoutParams) cVar).rightMargin = r14;
                cVar.f1086e = z14 && ((ActionMenuItemView) childAt).f();
                int L = L(childAt, i20, cVar.f1082a ? 1 : i18, childMeasureSpec, paddingTop);
                i24 = Math.max(i24, L);
                if (cVar.f1085d) {
                    i25++;
                }
                if (cVar.f1082a) {
                    z13 = true;
                }
                i18 -= L;
                i21 = Math.max(i21, childAt.getMeasuredHeight());
                if (L == 1) {
                    j10 |= 1 << i22;
                    i21 = i21;
                }
                i23 = i15;
            }
            i22++;
            size2 = i26;
        }
        int i29 = size2;
        boolean z15 = z13 && i23 == 2;
        boolean z16 = false;
        while (i25 > 0 && i18 > 0) {
            int i30 = 0;
            int i31 = 0;
            int i32 = Integer.MAX_VALUE;
            long j11 = 0;
            while (i31 < childCount) {
                boolean z17 = z16;
                c cVar2 = (c) getChildAt(i31).getLayoutParams();
                int i33 = i21;
                if (cVar2.f1085d) {
                    int i34 = cVar2.f1083b;
                    if (i34 < i32) {
                        j11 = 1 << i31;
                        i32 = i34;
                        i30 = 1;
                    } else if (i34 == i32) {
                        i30++;
                        j11 |= 1 << i31;
                    }
                }
                i31++;
                i21 = i33;
                z16 = z17;
            }
            z10 = z16;
            i14 = i21;
            j10 |= j11;
            if (i30 > i18) {
                i12 = mode;
                i13 = i16;
                break;
            }
            int i35 = i32 + 1;
            int i36 = 0;
            while (i36 < childCount) {
                View childAt2 = getChildAt(i36);
                c cVar3 = (c) childAt2.getLayoutParams();
                int i37 = i16;
                int i38 = mode;
                long j12 = 1 << i36;
                if ((j11 & j12) == 0) {
                    if (cVar3.f1083b == i35) {
                        j10 |= j12;
                    }
                    z12 = z15;
                } else {
                    if (z15 && cVar3.f1086e && i18 == 1) {
                        int i39 = this.E;
                        z12 = z15;
                        childAt2.setPadding(i39 + i20, 0, i39, 0);
                    } else {
                        z12 = z15;
                    }
                    cVar3.f1083b++;
                    cVar3.f1087f = true;
                    i18--;
                }
                i36++;
                mode = i38;
                i16 = i37;
                z15 = z12;
            }
            i21 = i14;
            z16 = true;
        }
        i12 = mode;
        i13 = i16;
        z10 = z16;
        i14 = i21;
        boolean z18 = !z13 && i23 == 1;
        if (i18 <= 0 || j10 == 0 || (i18 >= i23 - 1 && !z18 && i24 <= 1)) {
            z11 = z10;
        } else {
            float bitCount = Long.bitCount(j10);
            if (!z18) {
                if ((j10 & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).f1086e) {
                    bitCount -= 0.5f;
                }
                int i40 = childCount - 1;
                if ((j10 & (1 << i40)) != 0 && !((c) getChildAt(i40).getLayoutParams()).f1086e) {
                    bitCount -= 0.5f;
                }
            }
            int i41 = bitCount > 0.0f ? (int) ((i18 * i20) / bitCount) : 0;
            z11 = z10;
            for (int i42 = 0; i42 < childCount; i42++) {
                if ((j10 & (1 << i42)) != 0) {
                    View childAt3 = getChildAt(i42);
                    c cVar4 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.f1084c = i41;
                        cVar4.f1087f = true;
                        if (i42 == 0 && !cVar4.f1086e) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = (-i41) / 2;
                        }
                    } else if (cVar4.f1082a) {
                        cVar4.f1084c = i41;
                        cVar4.f1087f = true;
                        ((LinearLayout.LayoutParams) cVar4).rightMargin = (-i41) / 2;
                    } else {
                        if (i42 != 0) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = i41 / 2;
                        }
                        if (i42 != childCount - 1) {
                            ((LinearLayout.LayoutParams) cVar4).rightMargin = i41 / 2;
                        }
                    }
                    z11 = true;
                }
            }
        }
        if (z11) {
            for (int i43 = 0; i43 < childCount; i43++) {
                View childAt4 = getChildAt(i43);
                c cVar5 = (c) childAt4.getLayoutParams();
                if (cVar5.f1087f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.f1083b * i20) + cVar5.f1084c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i13, i12 != 1073741824 ? i14 : i29);
    }

    public void B() {
        androidx.appcompat.widget.c cVar = this.f1080y;
        if (cVar != null) {
            cVar.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.k0
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        ((LinearLayout.LayoutParams) cVar).gravity = 16;
        return cVar;
    }

    @Override // androidx.appcompat.widget.k0
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.k0
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (((LinearLayout.LayoutParams) cVar).gravity <= 0) {
            ((LinearLayout.LayoutParams) cVar).gravity = 16;
        }
        return cVar;
    }

    public c F() {
        c generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.f1082a = true;
        return generateDefaultLayoutParams;
    }

    protected boolean G(int i10) {
        boolean z10 = false;
        if (i10 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i10 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i10);
        if (i10 < getChildCount() && (childAt instanceof a)) {
            z10 = false | ((a) childAt).a();
        }
        return (i10 <= 0 || !(childAt2 instanceof a)) ? z10 : z10 | ((a) childAt2).b();
    }

    public boolean H() {
        androidx.appcompat.widget.c cVar = this.f1080y;
        return cVar != null && cVar.B();
    }

    public boolean I() {
        androidx.appcompat.widget.c cVar = this.f1080y;
        return cVar != null && cVar.D();
    }

    public boolean J() {
        androidx.appcompat.widget.c cVar = this.f1080y;
        return cVar != null && cVar.E();
    }

    public boolean K() {
        return this.f1079x;
    }

    public androidx.appcompat.view.menu.g N() {
        return this.f1076u;
    }

    public void O(m.a aVar, g.a aVar2) {
        this.f1081z = aVar;
        this.A = aVar2;
    }

    public boolean P() {
        androidx.appcompat.widget.c cVar = this.f1080y;
        return cVar != null && cVar.K();
    }

    @Override // androidx.appcompat.view.menu.g.b
    public boolean a(androidx.appcompat.view.menu.i iVar) {
        return this.f1076u.L(iVar, 0);
    }

    @Override // androidx.appcompat.view.menu.n
    public void b(androidx.appcompat.view.menu.g gVar) {
        this.f1076u = gVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.k0, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public Menu getMenu() {
        if (this.f1076u == null) {
            Context context = getContext();
            androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
            this.f1076u = gVar;
            gVar.R(new d());
            androidx.appcompat.widget.c cVar = new androidx.appcompat.widget.c(context);
            this.f1080y = cVar;
            cVar.J(true);
            androidx.appcompat.widget.c cVar2 = this.f1080y;
            m.a aVar = this.f1081z;
            if (aVar == null) {
                aVar = new b();
            }
            cVar2.k(aVar);
            this.f1076u.c(this.f1080y, this.f1077v);
            this.f1080y.H(this);
        }
        return this.f1076u;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f1080y.A();
    }

    public int getPopupTheme() {
        return this.f1078w;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.widget.c cVar = this.f1080y;
        if (cVar != null) {
            cVar.f(false);
            if (this.f1080y.E()) {
                this.f1080y.B();
                this.f1080y.K();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        B();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.k0, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int width;
        int i14;
        if (!this.B) {
            super.onLayout(z10, i10, i11, i12, i13);
            return;
        }
        int childCount = getChildCount();
        int i15 = (i13 - i11) / 2;
        int dividerWidth = getDividerWidth();
        int i16 = i12 - i10;
        int paddingRight = (i16 - getPaddingRight()) - getPaddingLeft();
        boolean b10 = h1.b(this);
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt = getChildAt(i19);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f1082a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (G(i19)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (b10) {
                        i14 = getPaddingLeft() + ((LinearLayout.LayoutParams) cVar).leftMargin;
                        width = i14 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) cVar).rightMargin;
                        i14 = width - measuredWidth;
                    }
                    int i20 = i15 - (measuredHeight / 2);
                    childAt.layout(i14, i20, width, measuredHeight + i20);
                    paddingRight -= measuredWidth;
                    i17 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) cVar).leftMargin) + ((LinearLayout.LayoutParams) cVar).rightMargin;
                    G(i19);
                    i18++;
                }
            }
        }
        if (childCount == 1 && i17 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i21 = (i16 / 2) - (measuredWidth2 / 2);
            int i22 = i15 - (measuredHeight2 / 2);
            childAt2.layout(i21, i22, measuredWidth2 + i21, measuredHeight2 + i22);
            return;
        }
        int i23 = i18 - (i17 ^ 1);
        int max = Math.max(0, i23 > 0 ? paddingRight / i23 : 0);
        if (b10) {
            int width2 = getWidth() - getPaddingRight();
            for (int i24 = 0; i24 < childCount; i24++) {
                View childAt3 = getChildAt(i24);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f1082a) {
                    int i25 = width2 - ((LinearLayout.LayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i26 = i15 - (measuredHeight3 / 2);
                    childAt3.layout(i25 - measuredWidth3, i26, i25, measuredHeight3 + i26);
                    width2 = i25 - ((measuredWidth3 + ((LinearLayout.LayoutParams) cVar2).leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i27 = 0; i27 < childCount; i27++) {
            View childAt4 = getChildAt(i27);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f1082a) {
                int i28 = paddingLeft + ((LinearLayout.LayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i29 = i15 - (measuredHeight4 / 2);
                childAt4.layout(i28, i29, i28 + measuredWidth4, measuredHeight4 + i29);
                paddingLeft = i28 + measuredWidth4 + ((LinearLayout.LayoutParams) cVar3).rightMargin + max;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.k0, android.view.View
    public void onMeasure(int i10, int i11) {
        androidx.appcompat.view.menu.g gVar;
        boolean z10 = this.B;
        boolean z11 = View.MeasureSpec.getMode(i10) == 1073741824;
        this.B = z11;
        if (z10 != z11) {
            this.C = 0;
        }
        int size = View.MeasureSpec.getSize(i10);
        if (this.B && (gVar = this.f1076u) != null && size != this.C) {
            this.C = size;
            gVar.K(true);
        }
        int childCount = getChildCount();
        if (this.B && childCount > 0) {
            M(i10, i11);
            return;
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            c cVar = (c) getChildAt(i12).getLayoutParams();
            ((LinearLayout.LayoutParams) cVar).rightMargin = 0;
            ((LinearLayout.LayoutParams) cVar).leftMargin = 0;
        }
        super.onMeasure(i10, i11);
    }

    public void setExpandedActionViewsExclusive(boolean z10) {
        this.f1080y.G(z10);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.F = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f1080y.I(drawable);
    }

    public void setOverflowReserved(boolean z10) {
        this.f1079x = z10;
    }

    public void setPopupTheme(int i10) {
        if (this.f1078w != i10) {
            this.f1078w = i10;
            if (i10 == 0) {
                this.f1077v = getContext();
            } else {
                this.f1077v = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    public void setPresenter(androidx.appcompat.widget.c cVar) {
        this.f1080y = cVar;
        cVar.H(this);
    }
}
