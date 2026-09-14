package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionMenuView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup implements androidx.core.view.i {
    private int A;
    private int B;
    private CharSequence C;
    private CharSequence D;
    private ColorStateList E;
    private ColorStateList F;
    private boolean G;
    private boolean H;
    private final ArrayList<View> I;
    private final ArrayList<View> J;
    private final int[] K;
    final androidx.core.view.j L;
    private ArrayList<MenuItem> M;
    f N;
    private final ActionMenuView.e O;
    private a1 P;
    private androidx.appcompat.widget.c Q;
    private d R;
    private m.a S;
    private g.a T;
    private boolean U;
    private final Runnable V;

    /* renamed from: f, reason: collision with root package name */
    private ActionMenuView f1164f;

    /* renamed from: g, reason: collision with root package name */
    private TextView f1165g;

    /* renamed from: h, reason: collision with root package name */
    private TextView f1166h;

    /* renamed from: i, reason: collision with root package name */
    private ImageButton f1167i;

    /* renamed from: j, reason: collision with root package name */
    private ImageView f1168j;

    /* renamed from: k, reason: collision with root package name */
    private Drawable f1169k;

    /* renamed from: l, reason: collision with root package name */
    private CharSequence f1170l;

    /* renamed from: m, reason: collision with root package name */
    ImageButton f1171m;

    /* renamed from: n, reason: collision with root package name */
    View f1172n;

    /* renamed from: o, reason: collision with root package name */
    private Context f1173o;

    /* renamed from: p, reason: collision with root package name */
    private int f1174p;

    /* renamed from: q, reason: collision with root package name */
    private int f1175q;

    /* renamed from: r, reason: collision with root package name */
    private int f1176r;

    /* renamed from: s, reason: collision with root package name */
    int f1177s;

    /* renamed from: t, reason: collision with root package name */
    private int f1178t;

    /* renamed from: u, reason: collision with root package name */
    private int f1179u;

    /* renamed from: v, reason: collision with root package name */
    private int f1180v;

    /* renamed from: w, reason: collision with root package name */
    private int f1181w;

    /* renamed from: x, reason: collision with root package name */
    private int f1182x;

    /* renamed from: y, reason: collision with root package name */
    private q0 f1183y;

    /* renamed from: z, reason: collision with root package name */
    private int f1184z;

    /* loaded from: classes.dex */
    class a implements ActionMenuView.e {
        a() {
        }

        @Override // androidx.appcompat.widget.ActionMenuView.e
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (Toolbar.this.L.d(menuItem)) {
                return true;
            }
            f fVar = Toolbar.this.N;
            if (fVar != null) {
                return fVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.S();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements androidx.appcompat.view.menu.m {

        /* renamed from: f, reason: collision with root package name */
        androidx.appcompat.view.menu.g f1188f;

        /* renamed from: g, reason: collision with root package name */
        androidx.appcompat.view.menu.i f1189g;

        d() {
        }

        @Override // androidx.appcompat.view.menu.m
        public void b(androidx.appcompat.view.menu.g gVar, boolean z10) {
        }

        @Override // androidx.appcompat.view.menu.m
        public void d(Context context, androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.i iVar;
            androidx.appcompat.view.menu.g gVar2 = this.f1188f;
            if (gVar2 != null && (iVar = this.f1189g) != null) {
                gVar2.f(iVar);
            }
            this.f1188f = gVar;
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean e(androidx.appcompat.view.menu.r rVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.m
        public void f(boolean z10) {
            if (this.f1189g != null) {
                androidx.appcompat.view.menu.g gVar = this.f1188f;
                boolean z11 = false;
                if (gVar != null) {
                    int size = gVar.size();
                    int i10 = 0;
                    while (true) {
                        if (i10 >= size) {
                            break;
                        }
                        if (this.f1188f.getItem(i10) == this.f1189g) {
                            z11 = true;
                            break;
                        }
                        i10++;
                    }
                }
                if (z11) {
                    return;
                }
                i(this.f1188f, this.f1189g);
            }
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean g() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean i(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.i iVar) {
            KeyEvent.Callback callback = Toolbar.this.f1172n;
            if (callback instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) callback).f();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f1172n);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f1171m);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f1172n = null;
            toolbar3.a();
            this.f1189g = null;
            Toolbar.this.requestLayout();
            iVar.r(false);
            return true;
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean j(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.i iVar) {
            Toolbar.this.g();
            ViewParent parent = Toolbar.this.f1171m.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f1171m);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f1171m);
            }
            Toolbar.this.f1172n = iVar.getActionView();
            this.f1189g = iVar;
            ViewParent parent2 = Toolbar.this.f1172n.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f1172n);
                }
                e generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                generateDefaultLayoutParams.f603a = 8388611 | (toolbar4.f1177s & 112);
                generateDefaultLayoutParams.f1191b = 2;
                toolbar4.f1172n.setLayoutParams(generateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f1172n);
            }
            Toolbar.this.K();
            Toolbar.this.requestLayout();
            iVar.r(true);
            KeyEvent.Callback callback = Toolbar.this.f1172n;
            if (callback instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) callback).c();
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends a.C0018a {

        /* renamed from: b, reason: collision with root package name */
        int f1191b;

        public e(int i10, int i11) {
            super(i10, i11);
            this.f1191b = 0;
            this.f603a = 8388627;
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1191b = 0;
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1191b = 0;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1191b = 0;
            a(marginLayoutParams);
        }

        public e(a.C0018a c0018a) {
            super(c0018a);
            this.f1191b = 0;
        }

        public e(e eVar) {
            super((a.C0018a) eVar);
            this.f1191b = 0;
            this.f1191b = eVar.f1191b;
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    /* loaded from: classes.dex */
    public static class g extends y.a {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: h, reason: collision with root package name */
        int f1192h;

        /* renamed from: i, reason: collision with root package name */
        boolean f1193i;

        /* loaded from: classes.dex */
        class a implements Parcelable.ClassLoaderCreator<g> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public g[] newArray(int i10) {
                return new g[i10];
            }
        }

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1192h = parcel.readInt();
            this.f1193i = parcel.readInt() != 0;
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // y.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f1192h);
            parcel.writeInt(this.f1193i ? 1 : 0);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.a.M);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.B = 8388627;
        this.I = new ArrayList<>();
        this.J = new ArrayList<>();
        this.K = new int[2];
        this.L = new androidx.core.view.j(new Runnable() { // from class: androidx.appcompat.widget.z0
            @Override // java.lang.Runnable
            public final void run() {
                Toolbar.this.A();
            }
        });
        this.M = new ArrayList<>();
        this.O = new a();
        this.V = new b();
        Context context2 = getContext();
        int[] iArr = e.j.O2;
        y0 v10 = y0.v(context2, attributeSet, iArr, i10, 0);
        androidx.core.view.a0.h0(this, context, iArr, attributeSet, v10.r(), i10, 0);
        this.f1175q = v10.n(e.j.f9076q3, 0);
        this.f1176r = v10.n(e.j.f9031h3, 0);
        this.B = v10.l(e.j.P2, this.B);
        this.f1177s = v10.l(e.j.Q2, 48);
        int e10 = v10.e(e.j.f9046k3, 0);
        int i11 = e.j.f9071p3;
        e10 = v10.s(i11) ? v10.e(i11, e10) : e10;
        this.f1182x = e10;
        this.f1181w = e10;
        this.f1180v = e10;
        this.f1179u = e10;
        int e11 = v10.e(e.j.f9061n3, -1);
        if (e11 >= 0) {
            this.f1179u = e11;
        }
        int e12 = v10.e(e.j.f9056m3, -1);
        if (e12 >= 0) {
            this.f1180v = e12;
        }
        int e13 = v10.e(e.j.f9066o3, -1);
        if (e13 >= 0) {
            this.f1181w = e13;
        }
        int e14 = v10.e(e.j.f9051l3, -1);
        if (e14 >= 0) {
            this.f1182x = e14;
        }
        this.f1178t = v10.f(e.j.f9001b3, -1);
        int e15 = v10.e(e.j.X2, Integer.MIN_VALUE);
        int e16 = v10.e(e.j.T2, Integer.MIN_VALUE);
        int f10 = v10.f(e.j.V2, 0);
        int f11 = v10.f(e.j.W2, 0);
        i();
        this.f1183y.e(f10, f11);
        if (e15 != Integer.MIN_VALUE || e16 != Integer.MIN_VALUE) {
            this.f1183y.g(e15, e16);
        }
        this.f1184z = v10.e(e.j.Y2, Integer.MIN_VALUE);
        this.A = v10.e(e.j.U2, Integer.MIN_VALUE);
        this.f1169k = v10.g(e.j.S2);
        this.f1170l = v10.p(e.j.R2);
        CharSequence p10 = v10.p(e.j.f9041j3);
        if (!TextUtils.isEmpty(p10)) {
            setTitle(p10);
        }
        CharSequence p11 = v10.p(e.j.f9026g3);
        if (!TextUtils.isEmpty(p11)) {
            setSubtitle(p11);
        }
        this.f1173o = getContext();
        setPopupTheme(v10.n(e.j.f9021f3, 0));
        Drawable g10 = v10.g(e.j.f9016e3);
        if (g10 != null) {
            setNavigationIcon(g10);
        }
        CharSequence p12 = v10.p(e.j.f9011d3);
        if (!TextUtils.isEmpty(p12)) {
            setNavigationContentDescription(p12);
        }
        Drawable g11 = v10.g(e.j.Z2);
        if (g11 != null) {
            setLogo(g11);
        }
        CharSequence p13 = v10.p(e.j.f8996a3);
        if (!TextUtils.isEmpty(p13)) {
            setLogoDescription(p13);
        }
        int i12 = e.j.f9081r3;
        if (v10.s(i12)) {
            setTitleTextColor(v10.c(i12));
        }
        int i13 = e.j.f9036i3;
        if (v10.s(i13)) {
            setSubtitleTextColor(v10.c(i13));
        }
        int i14 = e.j.f9006c3;
        if (v10.s(i14)) {
            y(v10.n(i14, 0));
        }
        v10.w();
    }

    private boolean B(View view) {
        return view.getParent() == this || this.J.contains(view);
    }

    private int E(View view, int i10, int[] iArr, int i11) {
        e eVar = (e) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - iArr[0];
        int max = i10 + Math.max(0, i12);
        iArr[0] = Math.max(0, -i12);
        int r10 = r(view, i11);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, r10, max + measuredWidth, view.getMeasuredHeight() + r10);
        return max + measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
    }

    private int F(View view, int i10, int[] iArr, int i11) {
        e eVar = (e) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - iArr[1];
        int max = i10 - Math.max(0, i12);
        iArr[1] = Math.max(0, -i12);
        int r10 = r(view, i11);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, r10, max, view.getMeasuredHeight() + r10);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).leftMargin);
    }

    private int G(View view, int i10, int i11, int i12, int i13, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i14 = marginLayoutParams.leftMargin - iArr[0];
        int i15 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i14) + Math.max(0, i15);
        iArr[0] = Math.max(0, -i14);
        iArr[1] = Math.max(0, -i15);
        view.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + max + i11, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i12, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private void H(View view, int i10, int i11, int i12, int i13, int i14) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i12, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i14 >= 0) {
            if (mode != 0) {
                i14 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i14);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void I() {
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.L.b(menu, getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.M = currentMenuItems2;
        this.L.e(menu);
    }

    private void J() {
        removeCallbacks(this.V);
        post(this.V);
    }

    private boolean Q() {
        if (!this.U) {
            return false;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (R(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean R(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void b(List<View> list, int i10) {
        boolean z10 = androidx.core.view.a0.z(this) == 1;
        int childCount = getChildCount();
        int b10 = androidx.core.view.e.b(i10, androidx.core.view.a0.z(this));
        list.clear();
        if (!z10) {
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.f1191b == 0 && R(childAt) && q(eVar.f603a) == b10) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i12 = childCount - 1; i12 >= 0; i12--) {
            View childAt2 = getChildAt(i12);
            e eVar2 = (e) childAt2.getLayoutParams();
            if (eVar2.f1191b == 0 && R(childAt2) && q(eVar2.f603a) == b10) {
                list.add(childAt2);
            }
        }
    }

    private void c(View view, boolean z10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        e generateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (e) layoutParams;
        generateDefaultLayoutParams.f1191b = 1;
        if (!z10 || this.f1172n == null) {
            addView(view, generateDefaultLayoutParams);
        } else {
            view.setLayoutParams(generateDefaultLayoutParams);
            this.J.add(view);
        }
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i10 = 0; i10 < menu.size(); i10++) {
            arrayList.add(menu.getItem(i10));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new androidx.appcompat.view.g(getContext());
    }

    private void i() {
        if (this.f1183y == null) {
            this.f1183y = new q0();
        }
    }

    private void j() {
        if (this.f1168j == null) {
            this.f1168j = new AppCompatImageView(getContext());
        }
    }

    private void k() {
        l();
        if (this.f1164f.N() == null) {
            androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) this.f1164f.getMenu();
            if (this.R == null) {
                this.R = new d();
            }
            this.f1164f.setExpandedActionViewsExclusive(true);
            gVar.c(this.R, this.f1173o);
        }
    }

    private void l() {
        if (this.f1164f == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f1164f = actionMenuView;
            actionMenuView.setPopupTheme(this.f1174p);
            this.f1164f.setOnMenuItemClickListener(this.O);
            this.f1164f.O(this.S, this.T);
            e generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f603a = 8388613 | (this.f1177s & 112);
            this.f1164f.setLayoutParams(generateDefaultLayoutParams);
            c(this.f1164f, false);
        }
    }

    private void m() {
        if (this.f1167i == null) {
            this.f1167i = new o(getContext(), null, e.a.L);
            e generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f603a = 8388611 | (this.f1177s & 112);
            this.f1167i.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    private int q(int i10) {
        int z10 = androidx.core.view.a0.z(this);
        int b10 = androidx.core.view.e.b(i10, z10) & 7;
        return (b10 == 1 || b10 == 3 || b10 == 5) ? b10 : z10 == 1 ? 5 : 3;
    }

    private int r(View view, int i10) {
        e eVar = (e) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i11 = i10 > 0 ? (measuredHeight - i10) / 2 : 0;
        int s10 = s(eVar.f603a);
        if (s10 == 48) {
            return getPaddingTop() - i11;
        }
        if (s10 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) - i11;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i12 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i13 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
        if (i12 < i13) {
            i12 = i13;
        } else {
            int i14 = (((height - paddingBottom) - measuredHeight) - i12) - paddingTop;
            int i15 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
            if (i14 < i15) {
                i12 = Math.max(0, i12 - (i15 - i14));
            }
        }
        return paddingTop + i12;
    }

    private int s(int i10) {
        int i11 = i10 & 112;
        return (i11 == 16 || i11 == 48 || i11 == 80) ? i11 : this.B & 112;
    }

    private int t(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return androidx.core.view.h.b(marginLayoutParams) + androidx.core.view.h.a(marginLayoutParams);
    }

    private int u(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int v(List<View> list, int[] iArr) {
        int i10 = iArr[0];
        int i11 = iArr[1];
        int size = list.size();
        int i12 = 0;
        int i13 = 0;
        while (i12 < size) {
            View view = list.get(i12);
            e eVar = (e) view.getLayoutParams();
            int i14 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - i10;
            int i15 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - i11;
            int max = Math.max(0, i14);
            int max2 = Math.max(0, i15);
            int max3 = Math.max(0, -i14);
            int max4 = Math.max(0, -i15);
            i13 += max + view.getMeasuredWidth() + max2;
            i12++;
            i11 = max4;
            i10 = max3;
        }
        return i13;
    }

    public void A() {
        Iterator<MenuItem> it = this.M.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(it.next().getItemId());
        }
        I();
    }

    public boolean C() {
        ActionMenuView actionMenuView = this.f1164f;
        return actionMenuView != null && actionMenuView.I();
    }

    public boolean D() {
        ActionMenuView actionMenuView = this.f1164f;
        return actionMenuView != null && actionMenuView.J();
    }

    void K() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((e) childAt.getLayoutParams()).f1191b != 2 && childAt != this.f1164f) {
                removeViewAt(childCount);
                this.J.add(childAt);
            }
        }
    }

    public void L(int i10, int i11) {
        i();
        this.f1183y.e(i10, i11);
    }

    public void M(int i10, int i11) {
        i();
        this.f1183y.g(i10, i11);
    }

    public void N(androidx.appcompat.view.menu.g gVar, androidx.appcompat.widget.c cVar) {
        if (gVar == null && this.f1164f == null) {
            return;
        }
        l();
        androidx.appcompat.view.menu.g N = this.f1164f.N();
        if (N == gVar) {
            return;
        }
        if (N != null) {
            N.O(this.Q);
            N.O(this.R);
        }
        if (this.R == null) {
            this.R = new d();
        }
        cVar.G(true);
        if (gVar != null) {
            gVar.c(cVar, this.f1173o);
            gVar.c(this.R, this.f1173o);
        } else {
            cVar.d(this.f1173o, null);
            this.R.d(this.f1173o, null);
            cVar.f(true);
            this.R.f(true);
        }
        this.f1164f.setPopupTheme(this.f1174p);
        this.f1164f.setPresenter(cVar);
        this.Q = cVar;
    }

    public void O(Context context, int i10) {
        this.f1176r = i10;
        TextView textView = this.f1166h;
        if (textView != null) {
            textView.setTextAppearance(context, i10);
        }
    }

    public void P(Context context, int i10) {
        this.f1175q = i10;
        TextView textView = this.f1165g;
        if (textView != null) {
            textView.setTextAppearance(context, i10);
        }
    }

    public boolean S() {
        ActionMenuView actionMenuView = this.f1164f;
        return actionMenuView != null && actionMenuView.P();
    }

    void a() {
        for (int size = this.J.size() - 1; size >= 0; size--) {
            addView(this.J.get(size));
        }
        this.J.clear();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof e);
    }

    public boolean d() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f1164f) != null && actionMenuView.K();
    }

    public void e() {
        d dVar = this.R;
        androidx.appcompat.view.menu.i iVar = dVar == null ? null : dVar.f1189g;
        if (iVar != null) {
            iVar.collapseActionView();
        }
    }

    public void f() {
        ActionMenuView actionMenuView = this.f1164f;
        if (actionMenuView != null) {
            actionMenuView.B();
        }
    }

    void g() {
        if (this.f1171m == null) {
            o oVar = new o(getContext(), null, e.a.L);
            this.f1171m = oVar;
            oVar.setImageDrawable(this.f1169k);
            this.f1171m.setContentDescription(this.f1170l);
            e generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f603a = 8388611 | (this.f1177s & 112);
            generateDefaultLayoutParams.f1191b = 2;
            this.f1171m.setLayoutParams(generateDefaultLayoutParams);
            this.f1171m.setOnClickListener(new c());
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f1171m;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f1171m;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        q0 q0Var = this.f1183y;
        if (q0Var != null) {
            return q0Var.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i10 = this.A;
        return i10 != Integer.MIN_VALUE ? i10 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        q0 q0Var = this.f1183y;
        if (q0Var != null) {
            return q0Var.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        q0 q0Var = this.f1183y;
        if (q0Var != null) {
            return q0Var.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        q0 q0Var = this.f1183y;
        if (q0Var != null) {
            return q0Var.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i10 = this.f1184z;
        return i10 != Integer.MIN_VALUE ? i10 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.g N;
        ActionMenuView actionMenuView = this.f1164f;
        return actionMenuView != null && (N = actionMenuView.N()) != null && N.hasVisibleItems() ? Math.max(getContentInsetEnd(), Math.max(this.A, 0)) : getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        return androidx.core.view.a0.z(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return androidx.core.view.a0.z(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f1184z, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f1168j;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f1168j;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        k();
        return this.f1164f.getMenu();
    }

    View getNavButtonView() {
        return this.f1167i;
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f1167i;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f1167i;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    androidx.appcompat.widget.c getOuterActionMenuPresenter() {
        return this.Q;
    }

    public Drawable getOverflowIcon() {
        k();
        return this.f1164f.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.f1173o;
    }

    public int getPopupTheme() {
        return this.f1174p;
    }

    public CharSequence getSubtitle() {
        return this.D;
    }

    final TextView getSubtitleTextView() {
        return this.f1166h;
    }

    public CharSequence getTitle() {
        return this.C;
    }

    public int getTitleMarginBottom() {
        return this.f1182x;
    }

    public int getTitleMarginEnd() {
        return this.f1180v;
    }

    public int getTitleMarginStart() {
        return this.f1179u;
    }

    public int getTitleMarginTop() {
        return this.f1181w;
    }

    final TextView getTitleTextView() {
        return this.f1165g;
    }

    public f0 getWrapper() {
        if (this.P == null) {
            this.P = new a1(this, true);
        }
        return this.P;
    }

    @Override // androidx.core.view.i
    public void h(androidx.core.view.l lVar) {
        this.L.f(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.V);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.H = false;
        }
        if (!this.H) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.H = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.H = false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:112:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0295 A[LOOP:0: B:46:0x0293->B:47:0x0295, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x02b7 A[LOOP:1: B:50:0x02b5->B:51:0x02b7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02f0 A[LOOP:2: B:59:0x02ee->B:60:0x02f0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x021d  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 773
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int[] iArr = this.K;
        boolean b10 = h1.b(this);
        int i19 = !b10 ? 1 : 0;
        if (R(this.f1167i)) {
            H(this.f1167i, i10, 0, i11, 0, this.f1178t);
            i12 = this.f1167i.getMeasuredWidth() + t(this.f1167i);
            i13 = Math.max(0, this.f1167i.getMeasuredHeight() + u(this.f1167i));
            i14 = View.combineMeasuredStates(0, this.f1167i.getMeasuredState());
        } else {
            i12 = 0;
            i13 = 0;
            i14 = 0;
        }
        if (R(this.f1171m)) {
            H(this.f1171m, i10, 0, i11, 0, this.f1178t);
            i12 = this.f1171m.getMeasuredWidth() + t(this.f1171m);
            i13 = Math.max(i13, this.f1171m.getMeasuredHeight() + u(this.f1171m));
            i14 = View.combineMeasuredStates(i14, this.f1171m.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = 0 + Math.max(currentContentInsetStart, i12);
        iArr[b10 ? 1 : 0] = Math.max(0, currentContentInsetStart - i12);
        if (R(this.f1164f)) {
            H(this.f1164f, i10, max, i11, 0, this.f1178t);
            i15 = this.f1164f.getMeasuredWidth() + t(this.f1164f);
            i13 = Math.max(i13, this.f1164f.getMeasuredHeight() + u(this.f1164f));
            i14 = View.combineMeasuredStates(i14, this.f1164f.getMeasuredState());
        } else {
            i15 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i15);
        iArr[i19] = Math.max(0, currentContentInsetEnd - i15);
        if (R(this.f1172n)) {
            max2 += G(this.f1172n, i10, max2, i11, 0, iArr);
            i13 = Math.max(i13, this.f1172n.getMeasuredHeight() + u(this.f1172n));
            i14 = View.combineMeasuredStates(i14, this.f1172n.getMeasuredState());
        }
        if (R(this.f1168j)) {
            max2 += G(this.f1168j, i10, max2, i11, 0, iArr);
            i13 = Math.max(i13, this.f1168j.getMeasuredHeight() + u(this.f1168j));
            i14 = View.combineMeasuredStates(i14, this.f1168j.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt = getChildAt(i20);
            if (((e) childAt.getLayoutParams()).f1191b == 0 && R(childAt)) {
                max2 += G(childAt, i10, max2, i11, 0, iArr);
                i13 = Math.max(i13, childAt.getMeasuredHeight() + u(childAt));
                i14 = View.combineMeasuredStates(i14, childAt.getMeasuredState());
            }
        }
        int i21 = this.f1181w + this.f1182x;
        int i22 = this.f1179u + this.f1180v;
        if (R(this.f1165g)) {
            G(this.f1165g, i10, max2 + i22, i11, i21, iArr);
            int measuredWidth = this.f1165g.getMeasuredWidth() + t(this.f1165g);
            i18 = this.f1165g.getMeasuredHeight() + u(this.f1165g);
            i16 = View.combineMeasuredStates(i14, this.f1165g.getMeasuredState());
            i17 = measuredWidth;
        } else {
            i16 = i14;
            i17 = 0;
            i18 = 0;
        }
        if (R(this.f1166h)) {
            i17 = Math.max(i17, G(this.f1166h, i10, max2 + i22, i11, i18 + i21, iArr));
            i18 += this.f1166h.getMeasuredHeight() + u(this.f1166h);
            i16 = View.combineMeasuredStates(i16, this.f1166h.getMeasuredState());
        }
        int max3 = Math.max(i13, i18);
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max2 + i17 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i10, (-16777216) & i16), Q() ? 0 : View.resolveSizeAndState(Math.max(max3 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i11, i16 << 16));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.a());
        ActionMenuView actionMenuView = this.f1164f;
        androidx.appcompat.view.menu.g N = actionMenuView != null ? actionMenuView.N() : null;
        int i10 = gVar.f1192h;
        if (i10 != 0 && this.R != null && N != null && (findItem = N.findItem(i10)) != null) {
            findItem.expandActionView();
        }
        if (gVar.f1193i) {
            J();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i10);
        }
        i();
        this.f1183y.f(i10 == 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.i iVar;
        g gVar = new g(super.onSaveInstanceState());
        d dVar = this.R;
        if (dVar != null && (iVar = dVar.f1189g) != null) {
            gVar.f1192h = iVar.getItemId();
        }
        gVar.f1193i = D();
        return gVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.G = false;
        }
        if (!this.G) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.G = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.G = false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof a.C0018a ? new e((a.C0018a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    public void setCollapseContentDescription(int i10) {
        setCollapseContentDescription(i10 != 0 ? getContext().getText(i10) : null);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.f1171m;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(int i10) {
        setCollapseIcon(f.a.b(getContext(), i10));
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            this.f1171m.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.f1171m;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.f1169k);
            }
        }
    }

    public void setCollapsible(boolean z10) {
        this.U = z10;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i10) {
        if (i10 < 0) {
            i10 = Integer.MIN_VALUE;
        }
        if (i10 != this.A) {
            this.A = i10;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i10) {
        if (i10 < 0) {
            i10 = Integer.MIN_VALUE;
        }
        if (i10 != this.f1184z) {
            this.f1184z = i10;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i10) {
        setLogo(f.a.b(getContext(), i10));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            j();
            if (!B(this.f1168j)) {
                c(this.f1168j, true);
            }
        } else {
            ImageView imageView = this.f1168j;
            if (imageView != null && B(imageView)) {
                removeView(this.f1168j);
                this.J.remove(this.f1168j);
            }
        }
        ImageView imageView2 = this.f1168j;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i10) {
        setLogoDescription(getContext().getText(i10));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            j();
        }
        ImageView imageView = this.f1168j;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(int i10) {
        setNavigationContentDescription(i10 != 0 ? getContext().getText(i10) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m();
        }
        ImageButton imageButton = this.f1167i;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
            b1.a(this.f1167i, charSequence);
        }
    }

    public void setNavigationIcon(int i10) {
        setNavigationIcon(f.a.b(getContext(), i10));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            m();
            if (!B(this.f1167i)) {
                c(this.f1167i, true);
            }
        } else {
            ImageButton imageButton = this.f1167i;
            if (imageButton != null && B(imageButton)) {
                removeView(this.f1167i);
                this.J.remove(this.f1167i);
            }
        }
        ImageButton imageButton2 = this.f1167i;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        m();
        this.f1167i.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(f fVar) {
        this.N = fVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        k();
        this.f1164f.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i10) {
        if (this.f1174p != i10) {
            this.f1174p = i10;
            if (i10 == 0) {
                this.f1173o = getContext();
            } else {
                this.f1173o = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    public void setSubtitle(int i10) {
        setSubtitle(getContext().getText(i10));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f1166h;
            if (textView != null && B(textView)) {
                removeView(this.f1166h);
                this.J.remove(this.f1166h);
            }
        } else {
            if (this.f1166h == null) {
                Context context = getContext();
                b0 b0Var = new b0(context);
                this.f1166h = b0Var;
                b0Var.setSingleLine();
                this.f1166h.setEllipsize(TextUtils.TruncateAt.END);
                int i10 = this.f1176r;
                if (i10 != 0) {
                    this.f1166h.setTextAppearance(context, i10);
                }
                ColorStateList colorStateList = this.F;
                if (colorStateList != null) {
                    this.f1166h.setTextColor(colorStateList);
                }
            }
            if (!B(this.f1166h)) {
                c(this.f1166h, true);
            }
        }
        TextView textView2 = this.f1166h;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.D = charSequence;
    }

    public void setSubtitleTextColor(int i10) {
        setSubtitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.F = colorStateList;
        TextView textView = this.f1166h;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(int i10) {
        setTitle(getContext().getText(i10));
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f1165g;
            if (textView != null && B(textView)) {
                removeView(this.f1165g);
                this.J.remove(this.f1165g);
            }
        } else {
            if (this.f1165g == null) {
                Context context = getContext();
                b0 b0Var = new b0(context);
                this.f1165g = b0Var;
                b0Var.setSingleLine();
                this.f1165g.setEllipsize(TextUtils.TruncateAt.END);
                int i10 = this.f1175q;
                if (i10 != 0) {
                    this.f1165g.setTextAppearance(context, i10);
                }
                ColorStateList colorStateList = this.E;
                if (colorStateList != null) {
                    this.f1165g.setTextColor(colorStateList);
                }
            }
            if (!B(this.f1165g)) {
                c(this.f1165g, true);
            }
        }
        TextView textView2 = this.f1165g;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.C = charSequence;
    }

    public void setTitleMarginBottom(int i10) {
        this.f1182x = i10;
        requestLayout();
    }

    public void setTitleMarginEnd(int i10) {
        this.f1180v = i10;
        requestLayout();
    }

    public void setTitleMarginStart(int i10) {
        this.f1179u = i10;
        requestLayout();
    }

    public void setTitleMarginTop(int i10) {
        this.f1181w = i10;
        requestLayout();
    }

    public void setTitleTextColor(int i10) {
        setTitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.E = colorStateList;
        TextView textView = this.f1165g;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public boolean w() {
        d dVar = this.R;
        return (dVar == null || dVar.f1189g == null) ? false : true;
    }

    public boolean x() {
        ActionMenuView actionMenuView = this.f1164f;
        return actionMenuView != null && actionMenuView.H();
    }

    public void y(int i10) {
        getMenuInflater().inflate(i10, getMenu());
    }

    @Override // androidx.core.view.i
    public void z(androidx.core.view.l lVar) {
        this.L.a(lVar);
    }
}
