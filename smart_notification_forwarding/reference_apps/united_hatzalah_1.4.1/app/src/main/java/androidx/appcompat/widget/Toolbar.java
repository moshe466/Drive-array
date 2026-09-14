package androidx.appcompat.widget;

import F0.C0035g2;
import F0.C0047j2;
import F0.b3;
import J.C0127o;
import J.InterfaceC0123k;
import J.InterfaceC0128p;
import J.S;
import a.AbstractC0228a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.fragment.app.Y;
import com.uh.sf.R;
import g.AbstractC0424a;
import h.H;
import h.ViewOnClickListenerC0433c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import k.C0466j;
import l.m;
import l.o;
import m.C0537c0;
import m.C0548i;
import m.C0575w;
import m.C0577x;
import m.InterfaceC0559n0;
import m.S0;
import m.l1;
import m.m1;
import m.n1;
import m.o1;
import m.p1;
import m.q1;
import m.s1;
import m.z1;
import p3.h;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup implements InterfaceC0123k {

    /* renamed from: A, reason: collision with root package name */
    public CharSequence f2963A;

    /* renamed from: B, reason: collision with root package name */
    public CharSequence f2964B;

    /* renamed from: C, reason: collision with root package name */
    public ColorStateList f2965C;

    /* renamed from: D, reason: collision with root package name */
    public ColorStateList f2966D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f2967E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f2968F;

    /* renamed from: G, reason: collision with root package name */
    public final ArrayList f2969G;

    /* renamed from: H, reason: collision with root package name */
    public final ArrayList f2970H;

    /* renamed from: I, reason: collision with root package name */
    public final int[] f2971I;

    /* renamed from: J, reason: collision with root package name */
    public final C0127o f2972J;

    /* renamed from: K, reason: collision with root package name */
    public ArrayList f2973K;

    /* renamed from: L, reason: collision with root package name */
    public p1 f2974L;

    /* renamed from: M, reason: collision with root package name */
    public final C0035g2 f2975M;

    /* renamed from: N, reason: collision with root package name */
    public s1 f2976N;

    /* renamed from: O, reason: collision with root package name */
    public C0548i f2977O;

    /* renamed from: P, reason: collision with root package name */
    public n1 f2978P;

    /* renamed from: Q, reason: collision with root package name */
    public H f2979Q;

    /* renamed from: R, reason: collision with root package name */
    public C0035g2 f2980R;

    /* renamed from: S, reason: collision with root package name */
    public boolean f2981S;

    /* renamed from: T, reason: collision with root package name */
    public OnBackInvokedCallback f2982T;

    /* renamed from: U, reason: collision with root package name */
    public OnBackInvokedDispatcher f2983U;

    /* renamed from: V, reason: collision with root package name */
    public boolean f2984V;

    /* renamed from: W, reason: collision with root package name */
    public final G.a f2985W;

    /* renamed from: a, reason: collision with root package name */
    public ActionMenuView f2986a;

    /* renamed from: b, reason: collision with root package name */
    public C0537c0 f2987b;

    /* renamed from: c, reason: collision with root package name */
    public C0537c0 f2988c;

    /* renamed from: d, reason: collision with root package name */
    public C0575w f2989d;

    /* renamed from: e, reason: collision with root package name */
    public C0577x f2990e;

    /* renamed from: f, reason: collision with root package name */
    public final Drawable f2991f;

    /* renamed from: j, reason: collision with root package name */
    public final CharSequence f2992j;

    /* renamed from: k, reason: collision with root package name */
    public C0575w f2993k;

    /* renamed from: l, reason: collision with root package name */
    public View f2994l;

    /* renamed from: m, reason: collision with root package name */
    public Context f2995m;

    /* renamed from: n, reason: collision with root package name */
    public int f2996n;

    /* renamed from: o, reason: collision with root package name */
    public int f2997o;
    public int p;

    /* renamed from: q, reason: collision with root package name */
    public final int f2998q;

    /* renamed from: r, reason: collision with root package name */
    public final int f2999r;

    /* renamed from: s, reason: collision with root package name */
    public int f3000s;

    /* renamed from: t, reason: collision with root package name */
    public int f3001t;

    /* renamed from: u, reason: collision with root package name */
    public int f3002u;

    /* renamed from: v, reason: collision with root package name */
    public int f3003v;

    /* renamed from: w, reason: collision with root package name */
    public S0 f3004w;

    /* renamed from: x, reason: collision with root package name */
    public int f3005x;
    public int y;

    /* renamed from: z, reason: collision with root package name */
    public final int f3006z;

    public Toolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.toolbarStyle);
        this.f3006z = 8388627;
        this.f2969G = new ArrayList();
        this.f2970H = new ArrayList();
        this.f2971I = new int[2];
        this.f2972J = new C0127o(new l1(this, 1));
        this.f2973K = new ArrayList();
        this.f2975M = new C0035g2(this, 19);
        this.f2985W = new G.a(this, 8);
        Context context2 = getContext();
        int[] iArr = AbstractC0424a.y;
        b3 t3 = b3.t(context2, attributeSet, iArr, R.attr.toolbarStyle);
        S.h(this, context, iArr, attributeSet, (TypedArray) t3.f470c, R.attr.toolbarStyle);
        TypedArray typedArray = (TypedArray) t3.f470c;
        this.f2997o = typedArray.getResourceId(28, 0);
        this.p = typedArray.getResourceId(19, 0);
        this.f3006z = typedArray.getInteger(0, 8388627);
        this.f2998q = typedArray.getInteger(2, 48);
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(22, 0);
        dimensionPixelOffset = typedArray.hasValue(27) ? typedArray.getDimensionPixelOffset(27, dimensionPixelOffset) : dimensionPixelOffset;
        this.f3003v = dimensionPixelOffset;
        this.f3002u = dimensionPixelOffset;
        this.f3001t = dimensionPixelOffset;
        this.f3000s = dimensionPixelOffset;
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(25, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.f3000s = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = typedArray.getDimensionPixelOffset(24, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.f3001t = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = typedArray.getDimensionPixelOffset(26, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.f3002u = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = typedArray.getDimensionPixelOffset(23, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.f3003v = dimensionPixelOffset5;
        }
        this.f2999r = typedArray.getDimensionPixelSize(13, -1);
        int dimensionPixelOffset6 = typedArray.getDimensionPixelOffset(9, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = typedArray.getDimensionPixelOffset(5, Integer.MIN_VALUE);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(7, 0);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(8, 0);
        d();
        S0 s02 = this.f3004w;
        s02.f5600h = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            s02.f5597e = dimensionPixelSize;
            s02.f5593a = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            s02.f5598f = dimensionPixelSize2;
            s02.f5594b = dimensionPixelSize2;
        }
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            s02.a(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.f3005x = typedArray.getDimensionPixelOffset(10, Integer.MIN_VALUE);
        this.y = typedArray.getDimensionPixelOffset(6, Integer.MIN_VALUE);
        this.f2991f = t3.o(4);
        this.f2992j = typedArray.getText(3);
        CharSequence text = typedArray.getText(21);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = typedArray.getText(18);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.f2995m = getContext();
        setPopupTheme(typedArray.getResourceId(17, 0));
        Drawable o2 = t3.o(16);
        if (o2 != null) {
            setNavigationIcon(o2);
        }
        CharSequence text3 = typedArray.getText(15);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable o4 = t3.o(11);
        if (o4 != null) {
            setLogo(o4);
        }
        CharSequence text4 = typedArray.getText(12);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (typedArray.hasValue(29)) {
            setTitleTextColor(t3.n(29));
        }
        if (typedArray.hasValue(20)) {
            setSubtitleTextColor(t3.n(20));
        }
        if (typedArray.hasValue(14)) {
            getMenuInflater().inflate(typedArray.getResourceId(14, 0), getMenu());
        }
        t3.v();
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i = 0; i < menu.size(); i++) {
            arrayList.add(menu.getItem(i));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new C0466j(getContext());
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [m.o1, android.view.ViewGroup$MarginLayoutParams] */
    public static o1 h() {
        ?? marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.f5743b = 0;
        marginLayoutParams.f5742a = 8388627;
        return marginLayoutParams;
    }

    public static o1 i(ViewGroup.LayoutParams layoutParams) {
        boolean z3 = layoutParams instanceof o1;
        if (z3) {
            o1 o1Var = (o1) layoutParams;
            o1 o1Var2 = new o1(o1Var);
            o1Var2.f5743b = 0;
            o1Var2.f5743b = o1Var.f5743b;
            return o1Var2;
        }
        if (z3) {
            o1 o1Var3 = new o1((o1) layoutParams);
            o1Var3.f5743b = 0;
            return o1Var3;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            o1 o1Var4 = new o1(marginLayoutParams);
            o1Var4.f5743b = 0;
            ((ViewGroup.MarginLayoutParams) o1Var4).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) o1Var4).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) o1Var4).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) o1Var4).bottomMargin = marginLayoutParams.bottomMargin;
            return o1Var4;
        }
        o1 o1Var5 = new o1(layoutParams);
        o1Var5.f5743b = 0;
        return o1Var5;
    }

    public static int k(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart();
    }

    public static int l(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final void a(int i, ArrayList arrayList) {
        boolean z3;
        WeakHashMap weakHashMap = S.f954a;
        if (getLayoutDirection() == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i, getLayoutDirection());
        arrayList.clear();
        if (z3) {
            for (int i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                o1 o1Var = (o1) childAt.getLayoutParams();
                if (o1Var.f5743b == 0 && t(childAt)) {
                    int i4 = o1Var.f5742a;
                    WeakHashMap weakHashMap2 = S.f954a;
                    int layoutDirection = getLayoutDirection();
                    int absoluteGravity2 = Gravity.getAbsoluteGravity(i4, layoutDirection) & 7;
                    if (absoluteGravity2 != 1 && absoluteGravity2 != 3 && absoluteGravity2 != 5) {
                        absoluteGravity2 = layoutDirection == 1 ? 5 : 3;
                    }
                    if (absoluteGravity2 == absoluteGravity) {
                        arrayList.add(childAt);
                    }
                }
            }
            return;
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt2 = getChildAt(i5);
            o1 o1Var2 = (o1) childAt2.getLayoutParams();
            if (o1Var2.f5743b == 0 && t(childAt2)) {
                int i6 = o1Var2.f5742a;
                WeakHashMap weakHashMap3 = S.f954a;
                int layoutDirection2 = getLayoutDirection();
                int absoluteGravity3 = Gravity.getAbsoluteGravity(i6, layoutDirection2) & 7;
                if (absoluteGravity3 != 1 && absoluteGravity3 != 3 && absoluteGravity3 != 5) {
                    absoluteGravity3 = layoutDirection2 == 1 ? 5 : 3;
                }
                if (absoluteGravity3 == absoluteGravity) {
                    arrayList.add(childAt2);
                }
            }
        }
    }

    @Override // J.InterfaceC0123k
    public final void addMenuProvider(InterfaceC0128p interfaceC0128p) {
        C0127o c0127o = this.f2972J;
        c0127o.f1019b.add(interfaceC0128p);
        c0127o.f1018a.run();
    }

    public final void b(View view, boolean z3) {
        o1 o1Var;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            o1Var = h();
        } else if (!checkLayoutParams(layoutParams)) {
            o1Var = i(layoutParams);
        } else {
            o1Var = (o1) layoutParams;
        }
        o1Var.f5743b = 1;
        if (z3 && this.f2994l != null) {
            view.setLayoutParams(o1Var);
            this.f2970H.add(view);
        } else {
            addView(view, o1Var);
        }
    }

    public final void c() {
        if (this.f2993k == null) {
            C0575w c0575w = new C0575w(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.f2993k = c0575w;
            c0575w.setImageDrawable(this.f2991f);
            this.f2993k.setContentDescription(this.f2992j);
            o1 h2 = h();
            h2.f5742a = (this.f2998q & 112) | 8388611;
            h2.f5743b = 2;
            this.f2993k.setLayoutParams(h2);
            this.f2993k.setOnClickListener(new ViewOnClickListenerC0433c(this, 2));
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (super.checkLayoutParams(layoutParams) && (layoutParams instanceof o1)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, m.S0] */
    public final void d() {
        if (this.f3004w == null) {
            ?? obj = new Object();
            obj.f5593a = 0;
            obj.f5594b = 0;
            obj.f5595c = Integer.MIN_VALUE;
            obj.f5596d = Integer.MIN_VALUE;
            obj.f5597e = 0;
            obj.f5598f = 0;
            obj.f5599g = false;
            obj.f5600h = false;
            this.f3004w = obj;
        }
    }

    public final void e() {
        f();
        ActionMenuView actionMenuView = this.f2986a;
        if (actionMenuView.f2857s == null) {
            m mVar = (m) actionMenuView.getMenu();
            if (this.f2978P == null) {
                this.f2978P = new n1(this);
            }
            this.f2986a.setExpandedActionViewsExclusive(true);
            mVar.b(this.f2978P, this.f2995m);
            v();
        }
    }

    public final void f() {
        if (this.f2986a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.f2986a = actionMenuView;
            actionMenuView.setPopupTheme(this.f2996n);
            this.f2986a.setOnMenuItemClickListener(this.f2975M);
            ActionMenuView actionMenuView2 = this.f2986a;
            H h2 = this.f2979Q;
            C0047j2 c0047j2 = new C0047j2(this, 20);
            actionMenuView2.f2862x = h2;
            actionMenuView2.y = c0047j2;
            o1 h3 = h();
            h3.f5742a = (this.f2998q & 112) | 8388613;
            this.f2986a.setLayoutParams(h3);
            b(this.f2986a, false);
        }
    }

    public final void g() {
        if (this.f2989d == null) {
            this.f2989d = new C0575w(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            o1 h2 = h();
            h2.f5742a = (this.f2998q & 112) | 8388611;
            this.f2989d.setLayoutParams(h2);
        }
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return h();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return i(layoutParams);
    }

    public CharSequence getCollapseContentDescription() {
        C0575w c0575w = this.f2993k;
        if (c0575w != null) {
            return c0575w.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        C0575w c0575w = this.f2993k;
        if (c0575w != null) {
            return c0575w.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        S0 s02 = this.f3004w;
        if (s02 != null) {
            if (s02.f5599g) {
                return s02.f5593a;
            }
            return s02.f5594b;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i = this.y;
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        return getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        S0 s02 = this.f3004w;
        if (s02 != null) {
            return s02.f5593a;
        }
        return 0;
    }

    public int getContentInsetRight() {
        S0 s02 = this.f3004w;
        if (s02 != null) {
            return s02.f5594b;
        }
        return 0;
    }

    public int getContentInsetStart() {
        S0 s02 = this.f3004w;
        if (s02 != null) {
            if (s02.f5599g) {
                return s02.f5594b;
            }
            return s02.f5593a;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.f3005x;
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        m mVar;
        ActionMenuView actionMenuView = this.f2986a;
        if (actionMenuView != null && (mVar = actionMenuView.f2857s) != null && mVar.hasVisibleItems()) {
            return Math.max(getContentInsetEnd(), Math.max(this.y, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        WeakHashMap weakHashMap = S.f954a;
        if (getLayoutDirection() == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        WeakHashMap weakHashMap = S.f954a;
        if (getLayoutDirection() == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.f3005x, 0));
        }
        return getContentInsetStart();
    }

    public Drawable getLogo() {
        C0577x c0577x = this.f2990e;
        if (c0577x != null) {
            return c0577x.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        C0577x c0577x = this.f2990e;
        if (c0577x != null) {
            return c0577x.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        e();
        return this.f2986a.getMenu();
    }

    public View getNavButtonView() {
        return this.f2989d;
    }

    public CharSequence getNavigationContentDescription() {
        C0575w c0575w = this.f2989d;
        if (c0575w != null) {
            return c0575w.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        C0575w c0575w = this.f2989d;
        if (c0575w != null) {
            return c0575w.getDrawable();
        }
        return null;
    }

    public C0548i getOuterActionMenuPresenter() {
        return this.f2977O;
    }

    public Drawable getOverflowIcon() {
        e();
        return this.f2986a.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f2995m;
    }

    public int getPopupTheme() {
        return this.f2996n;
    }

    public CharSequence getSubtitle() {
        return this.f2964B;
    }

    public final TextView getSubtitleTextView() {
        return this.f2988c;
    }

    public CharSequence getTitle() {
        return this.f2963A;
    }

    public int getTitleMarginBottom() {
        return this.f3003v;
    }

    public int getTitleMarginEnd() {
        return this.f3001t;
    }

    public int getTitleMarginStart() {
        return this.f3000s;
    }

    public int getTitleMarginTop() {
        return this.f3002u;
    }

    public final TextView getTitleTextView() {
        return this.f2987b;
    }

    public InterfaceC0559n0 getWrapper() {
        if (this.f2976N == null) {
            this.f2976N = new s1(this, true);
        }
        return this.f2976N;
    }

    public final int j(View view, int i) {
        int i3;
        o1 o1Var = (o1) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        if (i > 0) {
            i3 = (measuredHeight - i) / 2;
        } else {
            i3 = 0;
        }
        int i4 = o1Var.f5742a & 112;
        if (i4 != 16 && i4 != 48 && i4 != 80) {
            i4 = this.f3006z & 112;
        }
        if (i4 != 48) {
            if (i4 != 80) {
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int i5 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                int i6 = ((ViewGroup.MarginLayoutParams) o1Var).topMargin;
                if (i5 < i6) {
                    i5 = i6;
                } else {
                    int i7 = (((height - paddingBottom) - measuredHeight) - i5) - paddingTop;
                    int i8 = ((ViewGroup.MarginLayoutParams) o1Var).bottomMargin;
                    if (i7 < i8) {
                        i5 = Math.max(0, i5 - (i8 - i7));
                    }
                }
                return paddingTop + i5;
            }
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) o1Var).bottomMargin) - i3;
        }
        return getPaddingTop() - i3;
    }

    public final void m() {
        ArrayList arrayList = this.f2973K;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            getMenu().removeItem(((MenuItem) obj).getItemId());
        }
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        MenuInflater menuInflater = getMenuInflater();
        Iterator it = this.f2972J.f1019b.iterator();
        while (it.hasNext()) {
            ((Y) ((InterfaceC0128p) it.next())).f3332a.k(menu, menuInflater);
        }
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.f2973K = currentMenuItems2;
    }

    public final boolean n(View view) {
        if (view.getParent() != this && !this.f2970H.contains(view)) {
            return false;
        }
        return true;
    }

    public final boolean o() {
        C0548i c0548i;
        ActionMenuView actionMenuView = this.f2986a;
        if (actionMenuView != null && (c0548i = actionMenuView.f2861w) != null && c0548i.k()) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        v();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f2985W);
        v();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f2968F = false;
        }
        if (!this.f2968F) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f2968F = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.f2968F = false;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x028f A[LOOP:0: B:39:0x028d->B:40:0x028f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x02a7 A[LOOP:1: B:43:0x02a5->B:44:0x02a7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x02c7 A[LOOP:2: B:47:0x02c5->B:48:0x02c7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x031a A[LOOP:3: B:56:0x0318->B:57:0x031a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0218  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 811
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean a2 = z1.a(this);
        int i11 = !a2 ? 1 : 0;
        int i12 = 0;
        if (t(this.f2989d)) {
            s(this.f2989d, i, 0, i3, this.f2999r);
            i4 = k(this.f2989d) + this.f2989d.getMeasuredWidth();
            i5 = Math.max(0, l(this.f2989d) + this.f2989d.getMeasuredHeight());
            i6 = View.combineMeasuredStates(0, this.f2989d.getMeasuredState());
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        if (t(this.f2993k)) {
            s(this.f2993k, i, 0, i3, this.f2999r);
            i4 = k(this.f2993k) + this.f2993k.getMeasuredWidth();
            i5 = Math.max(i5, l(this.f2993k) + this.f2993k.getMeasuredHeight());
            i6 = View.combineMeasuredStates(i6, this.f2993k.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = Math.max(currentContentInsetStart, i4);
        int max2 = Math.max(0, currentContentInsetStart - i4);
        int[] iArr = this.f2971I;
        iArr[a2 ? 1 : 0] = max2;
        if (t(this.f2986a)) {
            s(this.f2986a, i, max, i3, this.f2999r);
            i7 = k(this.f2986a) + this.f2986a.getMeasuredWidth();
            i5 = Math.max(i5, l(this.f2986a) + this.f2986a.getMeasuredHeight());
            i6 = View.combineMeasuredStates(i6, this.f2986a.getMeasuredState());
        } else {
            i7 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max3 = max + Math.max(currentContentInsetEnd, i7);
        iArr[i11] = Math.max(0, currentContentInsetEnd - i7);
        if (t(this.f2994l)) {
            max3 += r(this.f2994l, i, max3, i3, 0, iArr);
            i5 = Math.max(i5, l(this.f2994l) + this.f2994l.getMeasuredHeight());
            i6 = View.combineMeasuredStates(i6, this.f2994l.getMeasuredState());
        }
        if (t(this.f2990e)) {
            max3 += r(this.f2990e, i, max3, i3, 0, iArr);
            i5 = Math.max(i5, l(this.f2990e) + this.f2990e.getMeasuredHeight());
            i6 = View.combineMeasuredStates(i6, this.f2990e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (((o1) childAt.getLayoutParams()).f5743b == 0 && t(childAt)) {
                max3 += r(childAt, i, max3, i3, 0, iArr);
                int max4 = Math.max(i5, l(childAt) + childAt.getMeasuredHeight());
                i6 = View.combineMeasuredStates(i6, childAt.getMeasuredState());
                i5 = max4;
            } else {
                max3 = max3;
            }
        }
        int i14 = max3;
        int i15 = this.f3002u + this.f3003v;
        int i16 = this.f3000s + this.f3001t;
        if (t(this.f2987b)) {
            r(this.f2987b, i, i14 + i16, i3, i15, iArr);
            int k4 = k(this.f2987b) + this.f2987b.getMeasuredWidth();
            i8 = l(this.f2987b) + this.f2987b.getMeasuredHeight();
            i9 = View.combineMeasuredStates(i6, this.f2987b.getMeasuredState());
            i10 = k4;
        } else {
            i8 = 0;
            i9 = i6;
            i10 = 0;
        }
        if (t(this.f2988c)) {
            i10 = Math.max(i10, r(this.f2988c, i, i14 + i16, i3, i15 + i8, iArr));
            i8 += l(this.f2988c) + this.f2988c.getMeasuredHeight();
            i9 = View.combineMeasuredStates(i9, this.f2988c.getMeasuredState());
        }
        int max5 = Math.max(i5, i8);
        int paddingRight = getPaddingRight() + getPaddingLeft() + i14 + i10;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + max5;
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i, (-16777216) & i9);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i3, i9 << 16);
        if (this.f2981S) {
            int childCount2 = getChildCount();
            for (int i17 = 0; i17 < childCount2; i17++) {
                View childAt2 = getChildAt(i17);
                if (!t(childAt2) || childAt2.getMeasuredWidth() <= 0 || childAt2.getMeasuredHeight() <= 0) {
                }
            }
            setMeasuredDimension(resolveSizeAndState, i12);
        }
        i12 = resolveSizeAndState2;
        setMeasuredDimension(resolveSizeAndState, i12);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        m mVar;
        MenuItem findItem;
        if (!(parcelable instanceof q1)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        q1 q1Var = (q1) parcelable;
        super.onRestoreInstanceState(q1Var.f1721a);
        ActionMenuView actionMenuView = this.f2986a;
        if (actionMenuView != null) {
            mVar = actionMenuView.f2857s;
        } else {
            mVar = null;
        }
        int i = q1Var.f5755c;
        if (i != 0 && this.f2978P != null && mVar != null && (findItem = mVar.findItem(i)) != null) {
            findItem.expandActionView();
        }
        if (q1Var.f5756d) {
            G.a aVar = this.f2985W;
            removeCallbacks(aVar);
            post(aVar);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        d();
        S0 s02 = this.f3004w;
        boolean z3 = true;
        if (i != 1) {
            z3 = false;
        }
        if (z3 == s02.f5599g) {
            return;
        }
        s02.f5599g = z3;
        if (s02.f5600h) {
            if (z3) {
                int i3 = s02.f5596d;
                if (i3 == Integer.MIN_VALUE) {
                    i3 = s02.f5597e;
                }
                s02.f5593a = i3;
                int i4 = s02.f5595c;
                if (i4 == Integer.MIN_VALUE) {
                    i4 = s02.f5598f;
                }
                s02.f5594b = i4;
                return;
            }
            int i5 = s02.f5595c;
            if (i5 == Integer.MIN_VALUE) {
                i5 = s02.f5597e;
            }
            s02.f5593a = i5;
            int i6 = s02.f5596d;
            if (i6 == Integer.MIN_VALUE) {
                i6 = s02.f5598f;
            }
            s02.f5594b = i6;
            return;
        }
        s02.f5593a = s02.f5597e;
        s02.f5594b = s02.f5598f;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [m.q1, android.os.Parcelable, Q.c] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        o oVar;
        ?? cVar = new Q.c(super.onSaveInstanceState());
        n1 n1Var = this.f2978P;
        if (n1Var != null && (oVar = n1Var.f5731b) != null) {
            cVar.f5755c = oVar.f5428a;
        }
        cVar.f5756d = o();
        return cVar;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2967E = false;
        }
        if (!this.f2967E) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f2967E = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.f2967E = false;
        return true;
    }

    public final int p(View view, int i, int i3, int[] iArr) {
        o1 o1Var = (o1) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) o1Var).leftMargin - iArr[0];
        int max = Math.max(0, i4) + i;
        iArr[0] = Math.max(0, -i4);
        int j2 = j(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, j2, max + measuredWidth, view.getMeasuredHeight() + j2);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) o1Var).rightMargin + max;
    }

    public final int q(View view, int i, int i3, int[] iArr) {
        o1 o1Var = (o1) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) o1Var).rightMargin - iArr[1];
        int max = i - Math.max(0, i4);
        iArr[1] = Math.max(0, -i4);
        int j2 = j(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, j2, max, view.getMeasuredHeight() + j2);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) o1Var).leftMargin);
    }

    public final int r(View view, int i, int i3, int i4, int i5, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i6 = marginLayoutParams.leftMargin - iArr[0];
        int i7 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i7) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i6);
        iArr[1] = Math.max(0, -i7);
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + max + i3, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i4, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    @Override // J.InterfaceC0123k
    public final void removeMenuProvider(InterfaceC0128p interfaceC0128p) {
        this.f2972J.b(interfaceC0128p);
    }

    public final void s(View view, int i, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i4, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public void setBackInvokedCallbackEnabled(boolean z3) {
        if (this.f2984V != z3) {
            this.f2984V = z3;
            v();
        }
    }

    public void setCollapseContentDescription(int i) {
        setCollapseContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setCollapseIcon(int i) {
        setCollapseIcon(AbstractC0228a.q(getContext(), i));
    }

    public void setCollapsible(boolean z3) {
        this.f2981S = z3;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.y) {
            this.y = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f3005x) {
            this.f3005x = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i) {
        setLogo(AbstractC0228a.q(getContext(), i));
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(AbstractC0228a.q(getContext(), i));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        g();
        this.f2989d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(p1 p1Var) {
        this.f2974L = p1Var;
    }

    public void setOverflowIcon(Drawable drawable) {
        e();
        this.f2986a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.f2996n != i) {
            this.f2996n = i;
            if (i == 0) {
                this.f2995m = getContext();
            } else {
                this.f2995m = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitleTextColor(int i) {
        setSubtitleTextColor(ColorStateList.valueOf(i));
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitleMarginBottom(int i) {
        this.f3003v = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.f3001t = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.f3000s = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.f3002u = i;
        requestLayout();
    }

    public void setTitleTextColor(int i) {
        setTitleTextColor(ColorStateList.valueOf(i));
    }

    public final boolean t(View view) {
        if (view != null && view.getParent() == this && view.getVisibility() != 8) {
            return true;
        }
        return false;
    }

    public final boolean u() {
        C0548i c0548i;
        ActionMenuView actionMenuView = this.f2986a;
        if (actionMenuView != null && (c0548i = actionMenuView.f2861w) != null && c0548i.l()) {
            return true;
        }
        return false;
    }

    public final void v() {
        boolean z3;
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher a2 = m1.a(this);
            n1 n1Var = this.f2978P;
            int i = 0;
            if (n1Var != null && n1Var.f5731b != null && a2 != null) {
                WeakHashMap weakHashMap = S.f954a;
                if (isAttachedToWindow() && this.f2984V) {
                    z3 = true;
                    if (!z3 && this.f2983U == null) {
                        if (this.f2982T == null) {
                            this.f2982T = m1.b(new l1(this, i));
                        }
                        m1.c(a2, this.f2982T);
                        this.f2983U = a2;
                        return;
                    }
                    if (z3 && (onBackInvokedDispatcher = this.f2983U) != null) {
                        m1.d(onBackInvokedDispatcher, this.f2982T);
                        this.f2983U = null;
                        return;
                    }
                }
            }
            z3 = false;
            if (!z3) {
            }
            if (z3) {
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [m.o1, android.view.ViewGroup$LayoutParams, android.view.ViewGroup$MarginLayoutParams] */
    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        ?? marginLayoutParams = new ViewGroup.MarginLayoutParams(context, attributeSet);
        marginLayoutParams.f5742a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0424a.f4628b);
        marginLayoutParams.f5742a = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        marginLayoutParams.f5743b = 0;
        return marginLayoutParams;
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            c();
        }
        C0575w c0575w = this.f2993k;
        if (c0575w != null) {
            c0575w.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            c();
            this.f2993k.setImageDrawable(drawable);
        } else {
            C0575w c0575w = this.f2993k;
            if (c0575w != null) {
                c0575w.setImageDrawable(this.f2991f);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.f2990e == null) {
                this.f2990e = new C0577x(getContext(), null, 0);
            }
            if (!n(this.f2990e)) {
                b(this.f2990e, true);
            }
        } else {
            C0577x c0577x = this.f2990e;
            if (c0577x != null && n(c0577x)) {
                removeView(this.f2990e);
                this.f2970H.remove(this.f2990e);
            }
        }
        C0577x c0577x2 = this.f2990e;
        if (c0577x2 != null) {
            c0577x2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.f2990e == null) {
            this.f2990e = new C0577x(getContext(), null, 0);
        }
        C0577x c0577x = this.f2990e;
        if (c0577x != null) {
            c0577x.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        C0575w c0575w = this.f2989d;
        if (c0575w != null) {
            c0575w.setContentDescription(charSequence);
            h.D(this.f2989d, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            if (!n(this.f2989d)) {
                b(this.f2989d, true);
            }
        } else {
            C0575w c0575w = this.f2989d;
            if (c0575w != null && n(c0575w)) {
                removeView(this.f2989d);
                this.f2970H.remove(this.f2989d);
            }
        }
        C0575w c0575w2 = this.f2989d;
        if (c0575w2 != null) {
            c0575w2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f2988c == null) {
                Context context = getContext();
                C0537c0 c0537c0 = new C0537c0(context, null);
                this.f2988c = c0537c0;
                c0537c0.setSingleLine();
                this.f2988c.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.p;
                if (i != 0) {
                    this.f2988c.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.f2966D;
                if (colorStateList != null) {
                    this.f2988c.setTextColor(colorStateList);
                }
            }
            if (!n(this.f2988c)) {
                b(this.f2988c, true);
            }
        } else {
            C0537c0 c0537c02 = this.f2988c;
            if (c0537c02 != null && n(c0537c02)) {
                removeView(this.f2988c);
                this.f2970H.remove(this.f2988c);
            }
        }
        C0537c0 c0537c03 = this.f2988c;
        if (c0537c03 != null) {
            c0537c03.setText(charSequence);
        }
        this.f2964B = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.f2966D = colorStateList;
        C0537c0 c0537c0 = this.f2988c;
        if (c0537c0 != null) {
            c0537c0.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f2987b == null) {
                Context context = getContext();
                C0537c0 c0537c0 = new C0537c0(context, null);
                this.f2987b = c0537c0;
                c0537c0.setSingleLine();
                this.f2987b.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.f2997o;
                if (i != 0) {
                    this.f2987b.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.f2965C;
                if (colorStateList != null) {
                    this.f2987b.setTextColor(colorStateList);
                }
            }
            if (!n(this.f2987b)) {
                b(this.f2987b, true);
            }
        } else {
            C0537c0 c0537c02 = this.f2987b;
            if (c0537c02 != null && n(c0537c02)) {
                removeView(this.f2987b);
                this.f2970H.remove(this.f2987b);
            }
        }
        C0537c0 c0537c03 = this.f2987b;
        if (c0537c03 != null) {
            c0537c03.setText(charSequence);
        }
        this.f2963A = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.f2965C = colorStateList;
        C0537c0 c0537c0 = this.f2987b;
        if (c0537c0 != null) {
            c0537c0.setTextColor(colorStateList);
        }
    }
}
