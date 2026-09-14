package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.app.a;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.f0;
import androidx.appcompat.widget.r0;
import androidx.core.view.a0;
import androidx.core.view.g0;
import androidx.core.view.h0;
import androidx.core.view.i0;
import androidx.core.view.j0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class n extends androidx.appcompat.app.a implements ActionBarOverlayLayout.d {
    private static final Interpolator B = new AccelerateInterpolator();
    private static final Interpolator C = new DecelerateInterpolator();
    final j0 A;

    /* renamed from: a, reason: collision with root package name */
    Context f715a;

    /* renamed from: b, reason: collision with root package name */
    private Context f716b;

    /* renamed from: c, reason: collision with root package name */
    ActionBarOverlayLayout f717c;

    /* renamed from: d, reason: collision with root package name */
    ActionBarContainer f718d;

    /* renamed from: e, reason: collision with root package name */
    f0 f719e;

    /* renamed from: f, reason: collision with root package name */
    ActionBarContextView f720f;

    /* renamed from: g, reason: collision with root package name */
    View f721g;

    /* renamed from: h, reason: collision with root package name */
    r0 f722h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f723i;

    /* renamed from: j, reason: collision with root package name */
    d f724j;

    /* renamed from: k, reason: collision with root package name */
    androidx.appcompat.view.b f725k;

    /* renamed from: l, reason: collision with root package name */
    b.a f726l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f727m;

    /* renamed from: n, reason: collision with root package name */
    private ArrayList<a.b> f728n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f729o;

    /* renamed from: p, reason: collision with root package name */
    private int f730p;

    /* renamed from: q, reason: collision with root package name */
    boolean f731q;

    /* renamed from: r, reason: collision with root package name */
    boolean f732r;

    /* renamed from: s, reason: collision with root package name */
    boolean f733s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f734t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f735u;

    /* renamed from: v, reason: collision with root package name */
    androidx.appcompat.view.h f736v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f737w;

    /* renamed from: x, reason: collision with root package name */
    boolean f738x;

    /* renamed from: y, reason: collision with root package name */
    final h0 f739y;

    /* renamed from: z, reason: collision with root package name */
    final h0 f740z;

    /* loaded from: classes.dex */
    class a extends i0 {
        a() {
        }

        @Override // androidx.core.view.h0
        public void b(View view) {
            View view2;
            n nVar = n.this;
            if (nVar.f731q && (view2 = nVar.f721g) != null) {
                view2.setTranslationY(0.0f);
                n.this.f718d.setTranslationY(0.0f);
            }
            n.this.f718d.setVisibility(8);
            n.this.f718d.setTransitioning(false);
            n nVar2 = n.this;
            nVar2.f736v = null;
            nVar2.D();
            ActionBarOverlayLayout actionBarOverlayLayout = n.this.f717c;
            if (actionBarOverlayLayout != null) {
                a0.g0(actionBarOverlayLayout);
            }
        }
    }

    /* loaded from: classes.dex */
    class b extends i0 {
        b() {
        }

        @Override // androidx.core.view.h0
        public void b(View view) {
            n nVar = n.this;
            nVar.f736v = null;
            nVar.f718d.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    class c implements j0 {
        c() {
        }

        @Override // androidx.core.view.j0
        public void a(View view) {
            ((View) n.this.f718d.getParent()).invalidate();
        }
    }

    /* loaded from: classes.dex */
    public class d extends androidx.appcompat.view.b implements g.a {

        /* renamed from: h, reason: collision with root package name */
        private final Context f744h;

        /* renamed from: i, reason: collision with root package name */
        private final androidx.appcompat.view.menu.g f745i;

        /* renamed from: j, reason: collision with root package name */
        private b.a f746j;

        /* renamed from: k, reason: collision with root package name */
        private WeakReference<View> f747k;

        public d(Context context, b.a aVar) {
            this.f744h = context;
            this.f746j = aVar;
            androidx.appcompat.view.menu.g S = new androidx.appcompat.view.menu.g(context).S(1);
            this.f745i = S;
            S.R(this);
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            b.a aVar = this.f746j;
            if (aVar != null) {
                return aVar.c(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(androidx.appcompat.view.menu.g gVar) {
            if (this.f746j == null) {
                return;
            }
            k();
            n.this.f720f.l();
        }

        @Override // androidx.appcompat.view.b
        public void c() {
            n nVar = n.this;
            if (nVar.f724j != this) {
                return;
            }
            if (n.C(nVar.f732r, nVar.f733s, false)) {
                this.f746j.b(this);
            } else {
                n nVar2 = n.this;
                nVar2.f725k = this;
                nVar2.f726l = this.f746j;
            }
            this.f746j = null;
            n.this.B(false);
            n.this.f720f.g();
            n nVar3 = n.this;
            nVar3.f717c.setHideOnContentScrollEnabled(nVar3.f738x);
            n.this.f724j = null;
        }

        @Override // androidx.appcompat.view.b
        public View d() {
            WeakReference<View> weakReference = this.f747k;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // androidx.appcompat.view.b
        public Menu e() {
            return this.f745i;
        }

        @Override // androidx.appcompat.view.b
        public MenuInflater f() {
            return new androidx.appcompat.view.g(this.f744h);
        }

        @Override // androidx.appcompat.view.b
        public CharSequence g() {
            return n.this.f720f.getSubtitle();
        }

        @Override // androidx.appcompat.view.b
        public CharSequence i() {
            return n.this.f720f.getTitle();
        }

        @Override // androidx.appcompat.view.b
        public void k() {
            if (n.this.f724j != this) {
                return;
            }
            this.f745i.d0();
            try {
                this.f746j.a(this, this.f745i);
            } finally {
                this.f745i.c0();
            }
        }

        @Override // androidx.appcompat.view.b
        public boolean l() {
            return n.this.f720f.j();
        }

        @Override // androidx.appcompat.view.b
        public void m(View view) {
            n.this.f720f.setCustomView(view);
            this.f747k = new WeakReference<>(view);
        }

        @Override // androidx.appcompat.view.b
        public void n(int i10) {
            o(n.this.f715a.getResources().getString(i10));
        }

        @Override // androidx.appcompat.view.b
        public void o(CharSequence charSequence) {
            n.this.f720f.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.view.b
        public void q(int i10) {
            r(n.this.f715a.getResources().getString(i10));
        }

        @Override // androidx.appcompat.view.b
        public void r(CharSequence charSequence) {
            n.this.f720f.setTitle(charSequence);
        }

        @Override // androidx.appcompat.view.b
        public void s(boolean z10) {
            super.s(z10);
            n.this.f720f.setTitleOptional(z10);
        }

        public boolean t() {
            this.f745i.d0();
            try {
                return this.f746j.d(this, this.f745i);
            } finally {
                this.f745i.c0();
            }
        }
    }

    public n(Activity activity, boolean z10) {
        new ArrayList();
        this.f728n = new ArrayList<>();
        this.f730p = 0;
        this.f731q = true;
        this.f735u = true;
        this.f739y = new a();
        this.f740z = new b();
        this.A = new c();
        View decorView = activity.getWindow().getDecorView();
        J(decorView);
        if (z10) {
            return;
        }
        this.f721g = decorView.findViewById(R.id.content);
    }

    public n(Dialog dialog) {
        new ArrayList();
        this.f728n = new ArrayList<>();
        this.f730p = 0;
        this.f731q = true;
        this.f735u = true;
        this.f739y = new a();
        this.f740z = new b();
        this.A = new c();
        J(dialog.getWindow().getDecorView());
    }

    static boolean C(boolean z10, boolean z11, boolean z12) {
        if (z12) {
            return true;
        }
        return (z10 || z11) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private f0 G(View view) {
        if (view instanceof f0) {
            return (f0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Can't make a decor toolbar out of ");
        sb2.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb2.toString());
    }

    private void I() {
        if (this.f734t) {
            this.f734t = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f717c;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            S(false);
        }
    }

    private void J(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(e.f.f8945p);
        this.f717c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f719e = G(view.findViewById(e.f.f8930a));
        this.f720f = (ActionBarContextView) view.findViewById(e.f.f8935f);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(e.f.f8932c);
        this.f718d = actionBarContainer;
        f0 f0Var = this.f719e;
        if (f0Var == null || this.f720f == null || actionBarContainer == null) {
            throw new IllegalStateException(n.class.getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f715a = f0Var.c();
        boolean z10 = (this.f719e.p() & 4) != 0;
        if (z10) {
            this.f723i = true;
        }
        androidx.appcompat.view.a b10 = androidx.appcompat.view.a.b(this.f715a);
        P(b10.a() || z10);
        N(b10.g());
        TypedArray obtainStyledAttributes = this.f715a.obtainStyledAttributes(null, e.j.f8992a, e.a.f8856c, 0);
        if (obtainStyledAttributes.getBoolean(e.j.f9042k, false)) {
            O(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(e.j.f9032i, 0);
        if (dimensionPixelSize != 0) {
            M(dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private void N(boolean z10) {
        this.f729o = z10;
        if (z10) {
            this.f718d.setTabContainer(null);
            this.f719e.k(this.f722h);
        } else {
            this.f719e.k(null);
            this.f718d.setTabContainer(this.f722h);
        }
        boolean z11 = H() == 2;
        r0 r0Var = this.f722h;
        if (r0Var != null) {
            if (z11) {
                r0Var.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f717c;
                if (actionBarOverlayLayout != null) {
                    a0.g0(actionBarOverlayLayout);
                }
            } else {
                r0Var.setVisibility(8);
            }
        }
        this.f719e.w(!this.f729o && z11);
        this.f717c.setHasNonEmbeddedTabs(!this.f729o && z11);
    }

    private boolean Q() {
        return a0.S(this.f718d);
    }

    private void R() {
        if (this.f734t) {
            return;
        }
        this.f734t = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f717c;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        S(false);
    }

    private void S(boolean z10) {
        if (C(this.f732r, this.f733s, this.f734t)) {
            if (this.f735u) {
                return;
            }
            this.f735u = true;
            F(z10);
            return;
        }
        if (this.f735u) {
            this.f735u = false;
            E(z10);
        }
    }

    @Override // androidx.appcompat.app.a
    public androidx.appcompat.view.b A(b.a aVar) {
        d dVar = this.f724j;
        if (dVar != null) {
            dVar.c();
        }
        this.f717c.setHideOnContentScrollEnabled(false);
        this.f720f.k();
        d dVar2 = new d(this.f720f.getContext(), aVar);
        if (!dVar2.t()) {
            return null;
        }
        this.f724j = dVar2;
        dVar2.k();
        this.f720f.h(dVar2);
        B(true);
        return dVar2;
    }

    public void B(boolean z10) {
        g0 t10;
        g0 f10;
        if (z10) {
            R();
        } else {
            I();
        }
        if (!Q()) {
            if (z10) {
                this.f719e.j(4);
                this.f720f.setVisibility(0);
                return;
            } else {
                this.f719e.j(0);
                this.f720f.setVisibility(8);
                return;
            }
        }
        if (z10) {
            f10 = this.f719e.t(4, 100L);
            t10 = this.f720f.f(0, 200L);
        } else {
            t10 = this.f719e.t(0, 200L);
            f10 = this.f720f.f(8, 100L);
        }
        androidx.appcompat.view.h hVar = new androidx.appcompat.view.h();
        hVar.d(f10, t10);
        hVar.h();
    }

    void D() {
        b.a aVar = this.f726l;
        if (aVar != null) {
            aVar.b(this.f725k);
            this.f725k = null;
            this.f726l = null;
        }
    }

    public void E(boolean z10) {
        View view;
        androidx.appcompat.view.h hVar = this.f736v;
        if (hVar != null) {
            hVar.a();
        }
        if (this.f730p != 0 || (!this.f737w && !z10)) {
            this.f739y.b(null);
            return;
        }
        this.f718d.setAlpha(1.0f);
        this.f718d.setTransitioning(true);
        androidx.appcompat.view.h hVar2 = new androidx.appcompat.view.h();
        float f10 = -this.f718d.getHeight();
        if (z10) {
            this.f718d.getLocationInWindow(new int[]{0, 0});
            f10 -= r5[1];
        }
        g0 m10 = a0.c(this.f718d).m(f10);
        m10.k(this.A);
        hVar2.c(m10);
        if (this.f731q && (view = this.f721g) != null) {
            hVar2.c(a0.c(view).m(f10));
        }
        hVar2.f(B);
        hVar2.e(250L);
        hVar2.g(this.f739y);
        this.f736v = hVar2;
        hVar2.h();
    }

    public void F(boolean z10) {
        View view;
        View view2;
        androidx.appcompat.view.h hVar = this.f736v;
        if (hVar != null) {
            hVar.a();
        }
        this.f718d.setVisibility(0);
        if (this.f730p == 0 && (this.f737w || z10)) {
            this.f718d.setTranslationY(0.0f);
            float f10 = -this.f718d.getHeight();
            if (z10) {
                this.f718d.getLocationInWindow(new int[]{0, 0});
                f10 -= r5[1];
            }
            this.f718d.setTranslationY(f10);
            androidx.appcompat.view.h hVar2 = new androidx.appcompat.view.h();
            g0 m10 = a0.c(this.f718d).m(0.0f);
            m10.k(this.A);
            hVar2.c(m10);
            if (this.f731q && (view2 = this.f721g) != null) {
                view2.setTranslationY(f10);
                hVar2.c(a0.c(this.f721g).m(0.0f));
            }
            hVar2.f(C);
            hVar2.e(250L);
            hVar2.g(this.f740z);
            this.f736v = hVar2;
            hVar2.h();
        } else {
            this.f718d.setAlpha(1.0f);
            this.f718d.setTranslationY(0.0f);
            if (this.f731q && (view = this.f721g) != null) {
                view.setTranslationY(0.0f);
            }
            this.f740z.b(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f717c;
        if (actionBarOverlayLayout != null) {
            a0.g0(actionBarOverlayLayout);
        }
    }

    public int H() {
        return this.f719e.r();
    }

    public void K(boolean z10) {
        L(z10 ? 4 : 0, 4);
    }

    public void L(int i10, int i11) {
        int p10 = this.f719e.p();
        if ((i11 & 4) != 0) {
            this.f723i = true;
        }
        this.f719e.o((i10 & i11) | ((~i11) & p10));
    }

    public void M(float f10) {
        a0.r0(this.f718d, f10);
    }

    public void O(boolean z10) {
        if (z10 && !this.f717c.w()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.f738x = z10;
        this.f717c.setHideOnContentScrollEnabled(z10);
    }

    public void P(boolean z10) {
        this.f719e.m(z10);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a() {
        if (this.f733s) {
            this.f733s = false;
            S(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b() {
        androidx.appcompat.view.h hVar = this.f736v;
        if (hVar != null) {
            hVar.a();
            this.f736v = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c(int i10) {
        this.f730p = i10;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d() {
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e(boolean z10) {
        this.f731q = z10;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void f() {
        if (this.f733s) {
            return;
        }
        this.f733s = true;
        S(true);
    }

    @Override // androidx.appcompat.app.a
    public boolean h() {
        f0 f0Var = this.f719e;
        if (f0Var == null || !f0Var.n()) {
            return false;
        }
        this.f719e.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void i(boolean z10) {
        if (z10 == this.f727m) {
            return;
        }
        this.f727m = z10;
        int size = this.f728n.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f728n.get(i10).a(z10);
        }
    }

    @Override // androidx.appcompat.app.a
    public int j() {
        return this.f719e.p();
    }

    @Override // androidx.appcompat.app.a
    public Context k() {
        if (this.f716b == null) {
            TypedValue typedValue = new TypedValue();
            this.f715a.getTheme().resolveAttribute(e.a.f8860g, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                this.f716b = new ContextThemeWrapper(this.f715a, i10);
            } else {
                this.f716b = this.f715a;
            }
        }
        return this.f716b;
    }

    @Override // androidx.appcompat.app.a
    public void m(Configuration configuration) {
        N(androidx.appcompat.view.a.b(this.f715a).g());
    }

    @Override // androidx.appcompat.app.a
    public boolean o(int i10, KeyEvent keyEvent) {
        Menu e10;
        d dVar = this.f724j;
        if (dVar == null || (e10 = dVar.e()) == null) {
            return false;
        }
        e10.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return e10.performShortcut(i10, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a
    public void r(Drawable drawable) {
        this.f718d.setPrimaryBackground(drawable);
    }

    @Override // androidx.appcompat.app.a
    public void s(int i10) {
        t(LayoutInflater.from(k()).inflate(i10, this.f719e.l(), false));
    }

    @Override // androidx.appcompat.app.a
    public void t(View view) {
        this.f719e.s(view);
    }

    @Override // androidx.appcompat.app.a
    public void u(boolean z10) {
        if (this.f723i) {
            return;
        }
        K(z10);
    }

    @Override // androidx.appcompat.app.a
    public void v(boolean z10) {
        L(z10 ? 16 : 0, 16);
    }

    @Override // androidx.appcompat.app.a
    public void w(boolean z10) {
        L(z10 ? 2 : 0, 2);
    }

    @Override // androidx.appcompat.app.a
    public void x(boolean z10) {
        L(z10 ? 8 : 0, 8);
    }

    @Override // androidx.appcompat.app.a
    public void y(boolean z10) {
        androidx.appcompat.view.h hVar;
        this.f737w = z10;
        if (z10 || (hVar = this.f736v) == null) {
            return;
        }
        hVar.a();
    }

    @Override // androidx.appcompat.app.a
    public void z(CharSequence charSequence) {
        this.f719e.setWindowTitle(charSequence);
    }
}
