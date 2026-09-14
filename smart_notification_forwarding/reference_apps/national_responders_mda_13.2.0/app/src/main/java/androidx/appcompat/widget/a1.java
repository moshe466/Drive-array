package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.Toolbar;

/* loaded from: classes.dex */
public class a1 implements f0 {

    /* renamed from: a, reason: collision with root package name */
    Toolbar f1230a;

    /* renamed from: b, reason: collision with root package name */
    private int f1231b;

    /* renamed from: c, reason: collision with root package name */
    private View f1232c;

    /* renamed from: d, reason: collision with root package name */
    private View f1233d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f1234e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f1235f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f1236g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1237h;

    /* renamed from: i, reason: collision with root package name */
    CharSequence f1238i;

    /* renamed from: j, reason: collision with root package name */
    private CharSequence f1239j;

    /* renamed from: k, reason: collision with root package name */
    private CharSequence f1240k;

    /* renamed from: l, reason: collision with root package name */
    Window.Callback f1241l;

    /* renamed from: m, reason: collision with root package name */
    boolean f1242m;

    /* renamed from: n, reason: collision with root package name */
    private c f1243n;

    /* renamed from: o, reason: collision with root package name */
    private int f1244o;

    /* renamed from: p, reason: collision with root package name */
    private int f1245p;

    /* renamed from: q, reason: collision with root package name */
    private Drawable f1246q;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {

        /* renamed from: f, reason: collision with root package name */
        final androidx.appcompat.view.menu.a f1247f;

        a() {
            this.f1247f = new androidx.appcompat.view.menu.a(a1.this.f1230a.getContext(), 0, R.id.home, 0, 0, a1.this.f1238i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a1 a1Var = a1.this;
            Window.Callback callback = a1Var.f1241l;
            if (callback == null || !a1Var.f1242m) {
                return;
            }
            callback.onMenuItemSelected(0, this.f1247f);
        }
    }

    /* loaded from: classes.dex */
    class b extends androidx.core.view.i0 {

        /* renamed from: a, reason: collision with root package name */
        private boolean f1249a = false;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f1250b;

        b(int i10) {
            this.f1250b = i10;
        }

        @Override // androidx.core.view.i0, androidx.core.view.h0
        public void a(View view) {
            this.f1249a = true;
        }

        @Override // androidx.core.view.h0
        public void b(View view) {
            if (this.f1249a) {
                return;
            }
            a1.this.f1230a.setVisibility(this.f1250b);
        }

        @Override // androidx.core.view.i0, androidx.core.view.h0
        public void c(View view) {
            a1.this.f1230a.setVisibility(0);
        }
    }

    public a1(Toolbar toolbar, boolean z10) {
        this(toolbar, z10, e.h.f8976a, e.e.f8917n);
    }

    public a1(Toolbar toolbar, boolean z10, int i10, int i11) {
        Drawable drawable;
        this.f1244o = 0;
        this.f1245p = 0;
        this.f1230a = toolbar;
        this.f1238i = toolbar.getTitle();
        this.f1239j = toolbar.getSubtitle();
        this.f1237h = this.f1238i != null;
        this.f1236g = toolbar.getNavigationIcon();
        y0 v10 = y0.v(toolbar.getContext(), null, e.j.f8992a, e.a.f8856c, 0);
        this.f1246q = v10.g(e.j.f9047l);
        if (z10) {
            CharSequence p10 = v10.p(e.j.f9077r);
            if (!TextUtils.isEmpty(p10)) {
                E(p10);
            }
            CharSequence p11 = v10.p(e.j.f9067p);
            if (!TextUtils.isEmpty(p11)) {
                D(p11);
            }
            Drawable g10 = v10.g(e.j.f9057n);
            if (g10 != null) {
                z(g10);
            }
            Drawable g11 = v10.g(e.j.f9052m);
            if (g11 != null) {
                setIcon(g11);
            }
            if (this.f1236g == null && (drawable = this.f1246q) != null) {
                C(drawable);
            }
            o(v10.k(e.j.f9027h, 0));
            int n10 = v10.n(e.j.f9022g, 0);
            if (n10 != 0) {
                s(LayoutInflater.from(this.f1230a.getContext()).inflate(n10, (ViewGroup) this.f1230a, false));
                o(this.f1231b | 16);
            }
            int m10 = v10.m(e.j.f9037j, 0);
            if (m10 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1230a.getLayoutParams();
                layoutParams.height = m10;
                this.f1230a.setLayoutParams(layoutParams);
            }
            int e10 = v10.e(e.j.f9017f, -1);
            int e11 = v10.e(e.j.f9012e, -1);
            if (e10 >= 0 || e11 >= 0) {
                this.f1230a.M(Math.max(e10, 0), Math.max(e11, 0));
            }
            int n11 = v10.n(e.j.f9082s, 0);
            if (n11 != 0) {
                Toolbar toolbar2 = this.f1230a;
                toolbar2.P(toolbar2.getContext(), n11);
            }
            int n12 = v10.n(e.j.f9072q, 0);
            if (n12 != 0) {
                Toolbar toolbar3 = this.f1230a;
                toolbar3.O(toolbar3.getContext(), n12);
            }
            int n13 = v10.n(e.j.f9062o, 0);
            if (n13 != 0) {
                this.f1230a.setPopupTheme(n13);
            }
        } else {
            this.f1231b = x();
        }
        v10.w();
        y(i10);
        this.f1240k = this.f1230a.getNavigationContentDescription();
        this.f1230a.setNavigationOnClickListener(new a());
    }

    private void F(CharSequence charSequence) {
        this.f1238i = charSequence;
        if ((this.f1231b & 8) != 0) {
            this.f1230a.setTitle(charSequence);
            if (this.f1237h) {
                androidx.core.view.a0.m0(this.f1230a.getRootView(), charSequence);
            }
        }
    }

    private void G() {
        if ((this.f1231b & 4) != 0) {
            if (TextUtils.isEmpty(this.f1240k)) {
                this.f1230a.setNavigationContentDescription(this.f1245p);
            } else {
                this.f1230a.setNavigationContentDescription(this.f1240k);
            }
        }
    }

    private void H() {
        Toolbar toolbar;
        Drawable drawable;
        if ((this.f1231b & 4) != 0) {
            toolbar = this.f1230a;
            drawable = this.f1236g;
            if (drawable == null) {
                drawable = this.f1246q;
            }
        } else {
            toolbar = this.f1230a;
            drawable = null;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void I() {
        Drawable drawable;
        int i10 = this.f1231b;
        if ((i10 & 2) == 0) {
            drawable = null;
        } else if ((i10 & 1) == 0 || (drawable = this.f1235f) == null) {
            drawable = this.f1234e;
        }
        this.f1230a.setLogo(drawable);
    }

    private int x() {
        if (this.f1230a.getNavigationIcon() == null) {
            return 11;
        }
        this.f1246q = this.f1230a.getNavigationIcon();
        return 15;
    }

    public void A(int i10) {
        B(i10 == 0 ? null : c().getString(i10));
    }

    public void B(CharSequence charSequence) {
        this.f1240k = charSequence;
        G();
    }

    public void C(Drawable drawable) {
        this.f1236g = drawable;
        H();
    }

    public void D(CharSequence charSequence) {
        this.f1239j = charSequence;
        if ((this.f1231b & 8) != 0) {
            this.f1230a.setSubtitle(charSequence);
        }
    }

    public void E(CharSequence charSequence) {
        this.f1237h = true;
        F(charSequence);
    }

    @Override // androidx.appcompat.widget.f0
    public void a(Menu menu, m.a aVar) {
        if (this.f1243n == null) {
            c cVar = new c(this.f1230a.getContext());
            this.f1243n = cVar;
            cVar.p(e.f.f8936g);
        }
        this.f1243n.k(aVar);
        this.f1230a.N((androidx.appcompat.view.menu.g) menu, this.f1243n);
    }

    @Override // androidx.appcompat.widget.f0
    public boolean b() {
        return this.f1230a.D();
    }

    @Override // androidx.appcompat.widget.f0
    public Context c() {
        return this.f1230a.getContext();
    }

    @Override // androidx.appcompat.widget.f0
    public void collapseActionView() {
        this.f1230a.e();
    }

    @Override // androidx.appcompat.widget.f0
    public void d() {
        this.f1242m = true;
    }

    @Override // androidx.appcompat.widget.f0
    public boolean e() {
        return this.f1230a.C();
    }

    @Override // androidx.appcompat.widget.f0
    public boolean f() {
        return this.f1230a.x();
    }

    @Override // androidx.appcompat.widget.f0
    public boolean g() {
        return this.f1230a.S();
    }

    @Override // androidx.appcompat.widget.f0
    public CharSequence getTitle() {
        return this.f1230a.getTitle();
    }

    @Override // androidx.appcompat.widget.f0
    public boolean h() {
        return this.f1230a.d();
    }

    @Override // androidx.appcompat.widget.f0
    public void i() {
        this.f1230a.f();
    }

    @Override // androidx.appcompat.widget.f0
    public void j(int i10) {
        this.f1230a.setVisibility(i10);
    }

    @Override // androidx.appcompat.widget.f0
    public void k(r0 r0Var) {
        View view = this.f1232c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f1230a;
            if (parent == toolbar) {
                toolbar.removeView(this.f1232c);
            }
        }
        this.f1232c = r0Var;
        if (r0Var == null || this.f1244o != 2) {
            return;
        }
        this.f1230a.addView(r0Var, 0);
        Toolbar.e eVar = (Toolbar.e) this.f1232c.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) eVar).width = -2;
        ((ViewGroup.MarginLayoutParams) eVar).height = -2;
        eVar.f603a = 8388691;
        r0Var.setAllowCollapse(true);
    }

    @Override // androidx.appcompat.widget.f0
    public ViewGroup l() {
        return this.f1230a;
    }

    @Override // androidx.appcompat.widget.f0
    public void m(boolean z10) {
    }

    @Override // androidx.appcompat.widget.f0
    public boolean n() {
        return this.f1230a.w();
    }

    @Override // androidx.appcompat.widget.f0
    public void o(int i10) {
        View view;
        CharSequence charSequence;
        Toolbar toolbar;
        int i11 = this.f1231b ^ i10;
        this.f1231b = i10;
        if (i11 != 0) {
            if ((i11 & 4) != 0) {
                if ((i10 & 4) != 0) {
                    G();
                }
                H();
            }
            if ((i11 & 3) != 0) {
                I();
            }
            if ((i11 & 8) != 0) {
                if ((i10 & 8) != 0) {
                    this.f1230a.setTitle(this.f1238i);
                    toolbar = this.f1230a;
                    charSequence = this.f1239j;
                } else {
                    charSequence = null;
                    this.f1230a.setTitle((CharSequence) null);
                    toolbar = this.f1230a;
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((i11 & 16) == 0 || (view = this.f1233d) == null) {
                return;
            }
            if ((i10 & 16) != 0) {
                this.f1230a.addView(view);
            } else {
                this.f1230a.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.f0
    public int p() {
        return this.f1231b;
    }

    @Override // androidx.appcompat.widget.f0
    public void q(int i10) {
        z(i10 != 0 ? f.a.b(c(), i10) : null);
    }

    @Override // androidx.appcompat.widget.f0
    public int r() {
        return this.f1244o;
    }

    @Override // androidx.appcompat.widget.f0
    public void s(View view) {
        View view2 = this.f1233d;
        if (view2 != null && (this.f1231b & 16) != 0) {
            this.f1230a.removeView(view2);
        }
        this.f1233d = view;
        if (view == null || (this.f1231b & 16) == 0) {
            return;
        }
        this.f1230a.addView(view);
    }

    @Override // androidx.appcompat.widget.f0
    public void setIcon(int i10) {
        setIcon(i10 != 0 ? f.a.b(c(), i10) : null);
    }

    @Override // androidx.appcompat.widget.f0
    public void setIcon(Drawable drawable) {
        this.f1234e = drawable;
        I();
    }

    @Override // androidx.appcompat.widget.f0
    public void setWindowCallback(Window.Callback callback) {
        this.f1241l = callback;
    }

    @Override // androidx.appcompat.widget.f0
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f1237h) {
            return;
        }
        F(charSequence);
    }

    @Override // androidx.appcompat.widget.f0
    public androidx.core.view.g0 t(int i10, long j10) {
        return androidx.core.view.a0.c(this.f1230a).b(i10 == 0 ? 1.0f : 0.0f).f(j10).h(new b(i10));
    }

    @Override // androidx.appcompat.widget.f0
    public void u() {
    }

    @Override // androidx.appcompat.widget.f0
    public void v() {
    }

    @Override // androidx.appcompat.widget.f0
    public void w(boolean z10) {
        this.f1230a.setCollapsible(z10);
    }

    public void y(int i10) {
        if (i10 == this.f1245p) {
            return;
        }
        this.f1245p = i10;
        if (TextUtils.isEmpty(this.f1230a.getNavigationContentDescription())) {
            A(this.f1245p);
        }
    }

    public void z(Drawable drawable) {
        this.f1235f = drawable;
        I();
    }
}
