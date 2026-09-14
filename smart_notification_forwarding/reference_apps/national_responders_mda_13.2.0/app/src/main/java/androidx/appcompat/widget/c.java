package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.b;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends androidx.appcompat.view.menu.b implements b.a {
    private final SparseBooleanArray A;
    e B;
    a C;
    RunnableC0022c D;
    private b E;
    final f F;
    int G;

    /* renamed from: n, reason: collision with root package name */
    d f1259n;

    /* renamed from: o, reason: collision with root package name */
    private Drawable f1260o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f1261p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f1262q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f1263r;

    /* renamed from: s, reason: collision with root package name */
    private int f1264s;

    /* renamed from: t, reason: collision with root package name */
    private int f1265t;

    /* renamed from: u, reason: collision with root package name */
    private int f1266u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f1267v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f1268w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f1269x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f1270y;

    /* renamed from: z, reason: collision with root package name */
    private int f1271z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends androidx.appcompat.view.menu.l {
        public a(Context context, androidx.appcompat.view.menu.r rVar, View view) {
            super(context, rVar, view, false, e.a.f8865l);
            if (!((androidx.appcompat.view.menu.i) rVar.getItem()).l()) {
                View view2 = c.this.f1259n;
                f(view2 == null ? (View) ((androidx.appcompat.view.menu.b) c.this).f873m : view2);
            }
            j(c.this.F);
        }

        @Override // androidx.appcompat.view.menu.l
        protected void e() {
            c cVar = c.this;
            cVar.C = null;
            cVar.G = 0;
            super.e();
        }
    }

    /* loaded from: classes.dex */
    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public androidx.appcompat.view.menu.p a() {
            a aVar = c.this.C;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.appcompat.widget.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0022c implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        private e f1274f;

        public RunnableC0022c(e eVar) {
            this.f1274f = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((androidx.appcompat.view.menu.b) c.this).f868h != null) {
                ((androidx.appcompat.view.menu.b) c.this).f868h.d();
            }
            View view = (View) ((androidx.appcompat.view.menu.b) c.this).f873m;
            if (view != null && view.getWindowToken() != null && this.f1274f.m()) {
                c.this.B = this.f1274f;
            }
            c.this.D = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends AppCompatImageView implements ActionMenuView.a {

        /* loaded from: classes.dex */
        class a extends j0 {
            a(View view, c cVar) {
                super(view);
            }

            @Override // androidx.appcompat.widget.j0
            public androidx.appcompat.view.menu.p b() {
                e eVar = c.this.B;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            @Override // androidx.appcompat.widget.j0
            public boolean c() {
                c.this.K();
                return true;
            }

            @Override // androidx.appcompat.widget.j0
            public boolean d() {
                c cVar = c.this;
                if (cVar.D != null) {
                    return false;
                }
                cVar.B();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, e.a.f8864k);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            b1.a(this, getContentDescription());
            setOnTouchListener(new a(this, c.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            c.this.K();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i10, int i11, int i12, int i13) {
            boolean frame = super.setFrame(i10, i11, i12, i13);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.l(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends androidx.appcompat.view.menu.l {
        public e(Context context, androidx.appcompat.view.menu.g gVar, View view, boolean z10) {
            super(context, gVar, view, z10, e.a.f8865l);
            h(8388613);
            j(c.this.F);
        }

        @Override // androidx.appcompat.view.menu.l
        protected void e() {
            if (((androidx.appcompat.view.menu.b) c.this).f868h != null) {
                ((androidx.appcompat.view.menu.b) c.this).f868h.close();
            }
            c.this.B = null;
            super.e();
        }
    }

    /* loaded from: classes.dex */
    private class f implements m.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void b(androidx.appcompat.view.menu.g gVar, boolean z10) {
            if (gVar instanceof androidx.appcompat.view.menu.r) {
                gVar.D().e(false);
            }
            m.a m10 = c.this.m();
            if (m10 != null) {
                m10.b(gVar, z10);
            }
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean c(androidx.appcompat.view.menu.g gVar) {
            if (gVar == ((androidx.appcompat.view.menu.b) c.this).f868h) {
                return false;
            }
            c.this.G = ((androidx.appcompat.view.menu.r) gVar).getItem().getItemId();
            m.a m10 = c.this.m();
            if (m10 != null) {
                return m10.c(gVar);
            }
            return false;
        }
    }

    public c(Context context) {
        super(context, e.g.f8958c, e.g.f8957b);
        this.A = new SparseBooleanArray();
        this.F = new f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View z(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f873m;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if ((childAt instanceof n.a) && ((n.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public Drawable A() {
        d dVar = this.f1259n;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.f1261p) {
            return this.f1260o;
        }
        return null;
    }

    public boolean B() {
        Object obj;
        RunnableC0022c runnableC0022c = this.D;
        if (runnableC0022c != null && (obj = this.f873m) != null) {
            ((View) obj).removeCallbacks(runnableC0022c);
            this.D = null;
            return true;
        }
        e eVar = this.B;
        if (eVar == null) {
            return false;
        }
        eVar.b();
        return true;
    }

    public boolean C() {
        a aVar = this.C;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    public boolean D() {
        return this.D != null || E();
    }

    public boolean E() {
        e eVar = this.B;
        return eVar != null && eVar.d();
    }

    public void F(Configuration configuration) {
        if (!this.f1267v) {
            this.f1266u = androidx.appcompat.view.a.b(this.f867g).d();
        }
        androidx.appcompat.view.menu.g gVar = this.f868h;
        if (gVar != null) {
            gVar.K(true);
        }
    }

    public void G(boolean z10) {
        this.f1270y = z10;
    }

    public void H(ActionMenuView actionMenuView) {
        this.f873m = actionMenuView;
        actionMenuView.b(this.f868h);
    }

    public void I(Drawable drawable) {
        d dVar = this.f1259n;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.f1261p = true;
            this.f1260o = drawable;
        }
    }

    public void J(boolean z10) {
        this.f1262q = z10;
        this.f1263r = true;
    }

    public boolean K() {
        androidx.appcompat.view.menu.g gVar;
        if (!this.f1262q || E() || (gVar = this.f868h) == null || this.f873m == null || this.D != null || gVar.z().isEmpty()) {
            return false;
        }
        RunnableC0022c runnableC0022c = new RunnableC0022c(new e(this.f867g, this.f868h, this.f1259n, true));
        this.D = runnableC0022c;
        ((View) this.f873m).post(runnableC0022c);
        return true;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void b(androidx.appcompat.view.menu.g gVar, boolean z10) {
        y();
        super.b(gVar, z10);
    }

    @Override // androidx.appcompat.view.menu.b
    public void c(androidx.appcompat.view.menu.i iVar, n.a aVar) {
        aVar.e(iVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f873m);
        if (this.E == null) {
            this.E = new b();
        }
        actionMenuItemView.setPopupCallback(this.E);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void d(Context context, androidx.appcompat.view.menu.g gVar) {
        super.d(context, gVar);
        Resources resources = context.getResources();
        androidx.appcompat.view.a b10 = androidx.appcompat.view.a.b(context);
        if (!this.f1263r) {
            this.f1262q = b10.h();
        }
        if (!this.f1269x) {
            this.f1264s = b10.c();
        }
        if (!this.f1267v) {
            this.f1266u = b10.d();
        }
        int i10 = this.f1264s;
        if (this.f1262q) {
            if (this.f1259n == null) {
                d dVar = new d(this.f866f);
                this.f1259n = dVar;
                if (this.f1261p) {
                    dVar.setImageDrawable(this.f1260o);
                    this.f1260o = null;
                    this.f1261p = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f1259n.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i10 -= this.f1259n.getMeasuredWidth();
        } else {
            this.f1259n = null;
        }
        this.f1265t = i10;
        this.f1271z = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public boolean e(androidx.appcompat.view.menu.r rVar) {
        boolean z10 = false;
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.r rVar2 = rVar;
        while (rVar2.e0() != this.f868h) {
            rVar2 = (androidx.appcompat.view.menu.r) rVar2.e0();
        }
        View z11 = z(rVar2.getItem());
        if (z11 == null) {
            return false;
        }
        rVar.getItem().getItemId();
        int size = rVar.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                break;
            }
            MenuItem item = rVar.getItem(i10);
            if (item.isVisible() && item.getIcon() != null) {
                z10 = true;
                break;
            }
            i10++;
        }
        a aVar = new a(this.f867g, rVar, z11);
        this.C = aVar;
        aVar.g(z10);
        this.C.k();
        super.e(rVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void f(boolean z10) {
        super.f(z10);
        ((View) this.f873m).requestLayout();
        androidx.appcompat.view.menu.g gVar = this.f868h;
        boolean z11 = false;
        if (gVar != null) {
            ArrayList<androidx.appcompat.view.menu.i> s10 = gVar.s();
            int size = s10.size();
            for (int i10 = 0; i10 < size; i10++) {
                androidx.core.view.b b10 = s10.get(i10).b();
                if (b10 != null) {
                    b10.i(this);
                }
            }
        }
        androidx.appcompat.view.menu.g gVar2 = this.f868h;
        ArrayList<androidx.appcompat.view.menu.i> z12 = gVar2 != null ? gVar2.z() : null;
        if (this.f1262q && z12 != null) {
            int size2 = z12.size();
            if (size2 == 1) {
                z11 = !z12.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z11 = true;
            }
        }
        d dVar = this.f1259n;
        if (z11) {
            if (dVar == null) {
                this.f1259n = new d(this.f866f);
            }
            ViewGroup viewGroup = (ViewGroup) this.f1259n.getParent();
            if (viewGroup != this.f873m) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f1259n);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f873m;
                actionMenuView.addView(this.f1259n, actionMenuView.F());
            }
        } else if (dVar != null) {
            Object parent = dVar.getParent();
            Object obj = this.f873m;
            if (parent == obj) {
                ((ViewGroup) obj).removeView(this.f1259n);
            }
        }
        ((ActionMenuView) this.f873m).setOverflowReserved(this.f1262q);
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean g() {
        ArrayList<androidx.appcompat.view.menu.i> arrayList;
        int i10;
        int i11;
        int i12;
        int i13;
        c cVar = this;
        androidx.appcompat.view.menu.g gVar = cVar.f868h;
        View view = null;
        int i14 = 0;
        if (gVar != null) {
            arrayList = gVar.E();
            i10 = arrayList.size();
        } else {
            arrayList = null;
            i10 = 0;
        }
        int i15 = cVar.f1266u;
        int i16 = cVar.f1265t;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) cVar.f873m;
        boolean z10 = false;
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < i10; i19++) {
            androidx.appcompat.view.menu.i iVar = arrayList.get(i19);
            if (iVar.o()) {
                i17++;
            } else if (iVar.n()) {
                i18++;
            } else {
                z10 = true;
            }
            if (cVar.f1270y && iVar.isActionViewExpanded()) {
                i15 = 0;
            }
        }
        if (cVar.f1262q && (z10 || i18 + i17 > i15)) {
            i15--;
        }
        int i20 = i15 - i17;
        SparseBooleanArray sparseBooleanArray = cVar.A;
        sparseBooleanArray.clear();
        if (cVar.f1268w) {
            int i21 = cVar.f1271z;
            i12 = i16 / i21;
            i11 = i21 + ((i16 % i21) / i12);
        } else {
            i11 = 0;
            i12 = 0;
        }
        int i22 = 0;
        int i23 = 0;
        while (i22 < i10) {
            androidx.appcompat.view.menu.i iVar2 = arrayList.get(i22);
            if (iVar2.o()) {
                View n10 = cVar.n(iVar2, view, viewGroup);
                if (cVar.f1268w) {
                    i12 -= ActionMenuView.L(n10, i11, i12, makeMeasureSpec, i14);
                } else {
                    n10.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = n10.getMeasuredWidth();
                i16 -= measuredWidth;
                if (i23 == 0) {
                    i23 = measuredWidth;
                }
                int groupId = iVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                iVar2.u(true);
                i13 = i10;
            } else if (iVar2.n()) {
                int groupId2 = iVar2.getGroupId();
                boolean z11 = sparseBooleanArray.get(groupId2);
                boolean z12 = (i20 > 0 || z11) && i16 > 0 && (!cVar.f1268w || i12 > 0);
                boolean z13 = z12;
                i13 = i10;
                if (z12) {
                    View n11 = cVar.n(iVar2, null, viewGroup);
                    if (cVar.f1268w) {
                        int L = ActionMenuView.L(n11, i11, i12, makeMeasureSpec, 0);
                        i12 -= L;
                        if (L == 0) {
                            z13 = false;
                        }
                    } else {
                        n11.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z14 = z13;
                    int measuredWidth2 = n11.getMeasuredWidth();
                    i16 -= measuredWidth2;
                    if (i23 == 0) {
                        i23 = measuredWidth2;
                    }
                    z12 = z14 & (!cVar.f1268w ? i16 + i23 <= 0 : i16 < 0);
                }
                if (z12 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z11) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i24 = 0; i24 < i22; i24++) {
                        androidx.appcompat.view.menu.i iVar3 = arrayList.get(i24);
                        if (iVar3.getGroupId() == groupId2) {
                            if (iVar3.l()) {
                                i20++;
                            }
                            iVar3.u(false);
                        }
                    }
                }
                if (z12) {
                    i20--;
                }
                iVar2.u(z12);
            } else {
                i13 = i10;
                iVar2.u(false);
                i22++;
                view = null;
                cVar = this;
                i10 = i13;
                i14 = 0;
            }
            i22++;
            view = null;
            cVar = this;
            i10 = i13;
            i14 = 0;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean l(ViewGroup viewGroup, int i10) {
        if (viewGroup.getChildAt(i10) == this.f1259n) {
            return false;
        }
        return super.l(viewGroup, i10);
    }

    @Override // androidx.appcompat.view.menu.b
    public View n(androidx.appcompat.view.menu.i iVar, View view, ViewGroup viewGroup) {
        View actionView = iVar.getActionView();
        if (actionView == null || iVar.j()) {
            actionView = super.n(iVar, view, viewGroup);
        }
        actionView.setVisibility(iVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.b
    public androidx.appcompat.view.menu.n o(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.n nVar = this.f873m;
        androidx.appcompat.view.menu.n o10 = super.o(viewGroup);
        if (nVar != o10) {
            ((ActionMenuView) o10).setPresenter(this);
        }
        return o10;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean q(int i10, androidx.appcompat.view.menu.i iVar) {
        return iVar.l();
    }

    public boolean y() {
        return B() | C();
    }
}
