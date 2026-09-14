package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.l0;
import androidx.lifecycle.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d0 {

    /* renamed from: a, reason: collision with root package name */
    private final q f2960a;

    /* renamed from: b, reason: collision with root package name */
    private final e0 f2961b;

    /* renamed from: c, reason: collision with root package name */
    private final Fragment f2962c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2963d = false;

    /* renamed from: e, reason: collision with root package name */
    private int f2964e = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f2965f;

        a(d0 d0Var, View view) {
            this.f2965f = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f2965f.removeOnAttachStateChangeListener(this);
            androidx.core.view.a0.g0(this.f2965f);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2966a;

        static {
            int[] iArr = new int[h.c.values().length];
            f2966a = iArr;
            try {
                iArr[h.c.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2966a[h.c.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2966a[h.c.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2966a[h.c.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0(q qVar, e0 e0Var, Fragment fragment) {
        this.f2960a = qVar;
        this.f2961b = e0Var;
        this.f2962c = fragment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0(q qVar, e0 e0Var, Fragment fragment, c0 c0Var) {
        this.f2960a = qVar;
        this.f2961b = e0Var;
        this.f2962c = fragment;
        fragment.f2833h = null;
        fragment.f2834i = null;
        fragment.f2849x = 0;
        fragment.f2846u = false;
        fragment.f2842q = false;
        Fragment fragment2 = fragment.f2838m;
        fragment.f2839n = fragment2 != null ? fragment2.f2836k : null;
        fragment.f2838m = null;
        Bundle bundle = c0Var.f2921r;
        fragment.f2832g = bundle == null ? new Bundle() : bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0(q qVar, e0 e0Var, ClassLoader classLoader, n nVar, c0 c0Var) {
        this.f2960a = qVar;
        this.f2961b = e0Var;
        Fragment a10 = c0Var.a(nVar, classLoader);
        this.f2962c = a10;
        if (w.H0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Instantiated fragment ");
            sb2.append(a10);
        }
    }

    private boolean l(View view) {
        if (view == this.f2962c.N) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f2962c.N) {
                return true;
            }
        }
        return false;
    }

    private Bundle q() {
        Bundle bundle = new Bundle();
        this.f2962c.w1(bundle);
        this.f2960a.j(this.f2962c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f2962c.N != null) {
            s();
        }
        if (this.f2962c.f2833h != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f2962c.f2833h);
        }
        if (this.f2962c.f2834i != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.f2962c.f2834i);
        }
        if (!this.f2962c.P) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f2962c.P);
        }
        return bundle;
    }

    void a() {
        if (w.H0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto ACTIVITY_CREATED: ");
            sb2.append(this.f2962c);
        }
        Fragment fragment = this.f2962c;
        fragment.c1(fragment.f2832g);
        q qVar = this.f2960a;
        Fragment fragment2 = this.f2962c;
        qVar.a(fragment2, fragment2.f2832g, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        int j10 = this.f2961b.j(this.f2962c);
        Fragment fragment = this.f2962c;
        fragment.M.addView(fragment.N, j10);
    }

    void c() {
        if (w.H0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto ATTACHED: ");
            sb2.append(this.f2962c);
        }
        Fragment fragment = this.f2962c;
        Fragment fragment2 = fragment.f2838m;
        d0 d0Var = null;
        if (fragment2 != null) {
            d0 n10 = this.f2961b.n(fragment2.f2836k);
            if (n10 == null) {
                throw new IllegalStateException("Fragment " + this.f2962c + " declared target fragment " + this.f2962c.f2838m + " that does not belong to this FragmentManager!");
            }
            Fragment fragment3 = this.f2962c;
            fragment3.f2839n = fragment3.f2838m.f2836k;
            fragment3.f2838m = null;
            d0Var = n10;
        } else {
            String str = fragment.f2839n;
            if (str != null && (d0Var = this.f2961b.n(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f2962c + " declared target fragment " + this.f2962c.f2839n + " that does not belong to this FragmentManager!");
            }
        }
        if (d0Var != null) {
            d0Var.m();
        }
        Fragment fragment4 = this.f2962c;
        fragment4.f2851z = fragment4.f2850y.u0();
        Fragment fragment5 = this.f2962c;
        fragment5.B = fragment5.f2850y.x0();
        this.f2960a.g(this.f2962c, false);
        this.f2962c.d1();
        this.f2960a.b(this.f2962c, false);
    }

    int d() {
        Fragment fragment = this.f2962c;
        if (fragment.f2850y == null) {
            return fragment.f2831f;
        }
        int i10 = this.f2964e;
        int i11 = b.f2966a[fragment.V.ordinal()];
        if (i11 != 1) {
            i10 = i11 != 2 ? i11 != 3 ? i11 != 4 ? Math.min(i10, -1) : Math.min(i10, 0) : Math.min(i10, 1) : Math.min(i10, 5);
        }
        Fragment fragment2 = this.f2962c;
        if (fragment2.f2845t) {
            if (fragment2.f2846u) {
                i10 = Math.max(this.f2964e, 2);
                View view = this.f2962c.N;
                if (view != null && view.getParent() == null) {
                    i10 = Math.min(i10, 2);
                }
            } else {
                i10 = this.f2964e < 4 ? Math.min(i10, fragment2.f2831f) : Math.min(i10, 1);
            }
        }
        if (!this.f2962c.f2842q) {
            i10 = Math.min(i10, 1);
        }
        Fragment fragment3 = this.f2962c;
        ViewGroup viewGroup = fragment3.M;
        l0.e.b l10 = viewGroup != null ? l0.n(viewGroup, fragment3.S()).l(this) : null;
        if (l10 == l0.e.b.ADDING) {
            i10 = Math.min(i10, 6);
        } else if (l10 == l0.e.b.REMOVING) {
            i10 = Math.max(i10, 3);
        } else {
            Fragment fragment4 = this.f2962c;
            if (fragment4.f2843r) {
                i10 = fragment4.o0() ? Math.min(i10, 1) : Math.min(i10, -1);
            }
        }
        Fragment fragment5 = this.f2962c;
        if (fragment5.O && fragment5.f2831f < 5) {
            i10 = Math.min(i10, 4);
        }
        if (w.H0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("computeExpectedState() of ");
            sb2.append(i10);
            sb2.append(" for ");
            sb2.append(this.f2962c);
        }
        return i10;
    }

    void e() {
        if (w.H0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto CREATED: ");
            sb2.append(this.f2962c);
        }
        Fragment fragment = this.f2962c;
        if (fragment.T) {
            fragment.E1(fragment.f2832g);
            this.f2962c.f2831f = 1;
            return;
        }
        this.f2960a.h(fragment, fragment.f2832g, false);
        Fragment fragment2 = this.f2962c;
        fragment2.g1(fragment2.f2832g);
        q qVar = this.f2960a;
        Fragment fragment3 = this.f2962c;
        qVar.c(fragment3, fragment3.f2832g, false);
    }

    void f() {
        String str;
        if (this.f2962c.f2845t) {
            return;
        }
        if (w.H0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto CREATE_VIEW: ");
            sb2.append(this.f2962c);
        }
        Fragment fragment = this.f2962c;
        LayoutInflater m12 = fragment.m1(fragment.f2832g);
        ViewGroup viewGroup = null;
        Fragment fragment2 = this.f2962c;
        ViewGroup viewGroup2 = fragment2.M;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i10 = fragment2.D;
            if (i10 != 0) {
                if (i10 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f2962c + " for a container view with no id");
                }
                viewGroup = (ViewGroup) fragment2.f2850y.q0().d(this.f2962c.D);
                if (viewGroup == null) {
                    Fragment fragment3 = this.f2962c;
                    if (!fragment3.f2847v) {
                        try {
                            str = fragment3.Y().getResourceName(this.f2962c.D);
                        } catch (Resources.NotFoundException unused) {
                            str = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f2962c.D) + " (" + str + ") for fragment " + this.f2962c);
                    }
                } else if (!(viewGroup instanceof FragmentContainerView)) {
                    e0.d.k(this.f2962c, viewGroup);
                }
            }
        }
        Fragment fragment4 = this.f2962c;
        fragment4.M = viewGroup;
        fragment4.i1(m12, viewGroup, fragment4.f2832g);
        View view = this.f2962c.N;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            Fragment fragment5 = this.f2962c;
            fragment5.N.setTag(d0.b.f8628a, fragment5);
            if (viewGroup != null) {
                b();
            }
            Fragment fragment6 = this.f2962c;
            if (fragment6.F) {
                fragment6.N.setVisibility(8);
            }
            if (androidx.core.view.a0.R(this.f2962c.N)) {
                androidx.core.view.a0.g0(this.f2962c.N);
            } else {
                View view2 = this.f2962c.N;
                view2.addOnAttachStateChangeListener(new a(this, view2));
            }
            this.f2962c.z1();
            q qVar = this.f2960a;
            Fragment fragment7 = this.f2962c;
            qVar.m(fragment7, fragment7.N, fragment7.f2832g, false);
            int visibility = this.f2962c.N.getVisibility();
            this.f2962c.M1(this.f2962c.N.getAlpha());
            Fragment fragment8 = this.f2962c;
            if (fragment8.M != null && visibility == 0) {
                View findFocus = fragment8.N.findFocus();
                if (findFocus != null) {
                    this.f2962c.J1(findFocus);
                    if (w.H0(2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("requestFocus: Saved focused view ");
                        sb3.append(findFocus);
                        sb3.append(" for Fragment ");
                        sb3.append(this.f2962c);
                    }
                }
                this.f2962c.N.setAlpha(0.0f);
            }
        }
        this.f2962c.f2831f = 2;
    }

    void g() {
        Fragment f10;
        if (w.H0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom CREATED: ");
            sb2.append(this.f2962c);
        }
        Fragment fragment = this.f2962c;
        boolean z10 = true;
        boolean z11 = fragment.f2843r && !fragment.o0();
        if (z11) {
            Fragment fragment2 = this.f2962c;
            if (!fragment2.f2844s) {
                this.f2961b.B(fragment2.f2836k, null);
            }
        }
        if (!(z11 || this.f2961b.p().q(this.f2962c))) {
            String str = this.f2962c.f2839n;
            if (str != null && (f10 = this.f2961b.f(str)) != null && f10.H) {
                this.f2962c.f2838m = f10;
            }
            this.f2962c.f2831f = 0;
            return;
        }
        o<?> oVar = this.f2962c.f2851z;
        if (oVar instanceof androidx.lifecycle.f0) {
            z10 = this.f2961b.p().n();
        } else if (oVar.j() instanceof Activity) {
            z10 = true ^ ((Activity) oVar.j()).isChangingConfigurations();
        }
        if ((z11 && !this.f2962c.f2844s) || z10) {
            this.f2961b.p().f(this.f2962c);
        }
        this.f2962c.j1();
        this.f2960a.d(this.f2962c, false);
        for (d0 d0Var : this.f2961b.k()) {
            if (d0Var != null) {
                Fragment k10 = d0Var.k();
                if (this.f2962c.f2836k.equals(k10.f2839n)) {
                    k10.f2838m = this.f2962c;
                    k10.f2839n = null;
                }
            }
        }
        Fragment fragment3 = this.f2962c;
        String str2 = fragment3.f2839n;
        if (str2 != null) {
            fragment3.f2838m = this.f2961b.f(str2);
        }
        this.f2961b.s(this);
    }

    void h() {
        View view;
        if (w.H0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom CREATE_VIEW: ");
            sb2.append(this.f2962c);
        }
        Fragment fragment = this.f2962c;
        ViewGroup viewGroup = fragment.M;
        if (viewGroup != null && (view = fragment.N) != null) {
            viewGroup.removeView(view);
        }
        this.f2962c.k1();
        this.f2960a.n(this.f2962c, false);
        Fragment fragment2 = this.f2962c;
        fragment2.M = null;
        fragment2.N = null;
        fragment2.X = null;
        fragment2.Y.j(null);
        this.f2962c.f2846u = false;
    }

    void i() {
        if (w.H0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom ATTACHED: ");
            sb2.append(this.f2962c);
        }
        this.f2962c.l1();
        boolean z10 = false;
        this.f2960a.e(this.f2962c, false);
        Fragment fragment = this.f2962c;
        fragment.f2831f = -1;
        fragment.f2851z = null;
        fragment.B = null;
        fragment.f2850y = null;
        if (fragment.f2843r && !fragment.o0()) {
            z10 = true;
        }
        if (z10 || this.f2961b.p().q(this.f2962c)) {
            if (w.H0(3)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("initState called for fragment: ");
                sb3.append(this.f2962c);
            }
            this.f2962c.k0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        Fragment fragment = this.f2962c;
        if (fragment.f2845t && fragment.f2846u && !fragment.f2848w) {
            if (w.H0(3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("moveto CREATE_VIEW: ");
                sb2.append(this.f2962c);
            }
            Fragment fragment2 = this.f2962c;
            fragment2.i1(fragment2.m1(fragment2.f2832g), null, this.f2962c.f2832g);
            View view = this.f2962c.N;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f2962c;
                fragment3.N.setTag(d0.b.f8628a, fragment3);
                Fragment fragment4 = this.f2962c;
                if (fragment4.F) {
                    fragment4.N.setVisibility(8);
                }
                this.f2962c.z1();
                q qVar = this.f2960a;
                Fragment fragment5 = this.f2962c;
                qVar.m(fragment5, fragment5.N, fragment5.f2832g, false);
                this.f2962c.f2831f = 2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment k() {
        return this.f2962c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.f2963d) {
            if (w.H0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Ignoring re-entrant call to moveToExpectedState() for ");
                sb2.append(k());
                return;
            }
            return;
        }
        try {
            this.f2963d = true;
            boolean z10 = false;
            while (true) {
                int d10 = d();
                Fragment fragment = this.f2962c;
                int i10 = fragment.f2831f;
                if (d10 == i10) {
                    if (!z10 && i10 == -1 && fragment.f2843r && !fragment.o0() && !this.f2962c.f2844s) {
                        if (w.H0(3)) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Cleaning up state of never attached fragment: ");
                            sb3.append(this.f2962c);
                        }
                        this.f2961b.p().f(this.f2962c);
                        this.f2961b.s(this);
                        if (w.H0(3)) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("initState called for fragment: ");
                            sb4.append(this.f2962c);
                        }
                        this.f2962c.k0();
                    }
                    Fragment fragment2 = this.f2962c;
                    if (fragment2.R) {
                        if (fragment2.N != null && (viewGroup = fragment2.M) != null) {
                            l0 n10 = l0.n(viewGroup, fragment2.S());
                            if (this.f2962c.F) {
                                n10.c(this);
                            } else {
                                n10.e(this);
                            }
                        }
                        Fragment fragment3 = this.f2962c;
                        w wVar = fragment3.f2850y;
                        if (wVar != null) {
                            wVar.F0(fragment3);
                        }
                        Fragment fragment4 = this.f2962c;
                        fragment4.R = false;
                        fragment4.L0(fragment4.F);
                        this.f2962c.A.J();
                    }
                    return;
                }
                if (d10 <= i10) {
                    switch (i10 - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            if (fragment.f2844s && this.f2961b.q(fragment.f2836k) == null) {
                                r();
                            }
                            g();
                            break;
                        case 1:
                            h();
                            this.f2962c.f2831f = 1;
                            break;
                        case 2:
                            fragment.f2846u = false;
                            fragment.f2831f = 2;
                            break;
                        case 3:
                            if (w.H0(3)) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("movefrom ACTIVITY_CREATED: ");
                                sb5.append(this.f2962c);
                            }
                            Fragment fragment5 = this.f2962c;
                            if (fragment5.f2844s) {
                                r();
                            } else if (fragment5.N != null && fragment5.f2833h == null) {
                                s();
                            }
                            Fragment fragment6 = this.f2962c;
                            if (fragment6.N != null && (viewGroup2 = fragment6.M) != null) {
                                l0.n(viewGroup2, fragment6.S()).d(this);
                            }
                            this.f2962c.f2831f = 3;
                            break;
                        case 4:
                            v();
                            break;
                        case 5:
                            fragment.f2831f = 5;
                            break;
                        case 6:
                            n();
                            break;
                    }
                } else {
                    switch (i10 + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (fragment.N != null && (viewGroup3 = fragment.M) != null) {
                                l0.n(viewGroup3, fragment.S()).b(l0.e.c.from(this.f2962c.N.getVisibility()), this);
                            }
                            this.f2962c.f2831f = 4;
                            break;
                        case 5:
                            u();
                            break;
                        case 6:
                            fragment.f2831f = 6;
                            break;
                        case 7:
                            p();
                            break;
                    }
                }
                z10 = true;
            }
        } finally {
            this.f2963d = false;
        }
    }

    void n() {
        if (w.H0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom RESUMED: ");
            sb2.append(this.f2962c);
        }
        this.f2962c.r1();
        this.f2960a.f(this.f2962c, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(ClassLoader classLoader) {
        Bundle bundle = this.f2962c.f2832g;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        Fragment fragment = this.f2962c;
        fragment.f2833h = fragment.f2832g.getSparseParcelableArray("android:view_state");
        Fragment fragment2 = this.f2962c;
        fragment2.f2834i = fragment2.f2832g.getBundle("android:view_registry_state");
        Fragment fragment3 = this.f2962c;
        fragment3.f2839n = fragment3.f2832g.getString("android:target_state");
        Fragment fragment4 = this.f2962c;
        if (fragment4.f2839n != null) {
            fragment4.f2840o = fragment4.f2832g.getInt("android:target_req_state", 0);
        }
        Fragment fragment5 = this.f2962c;
        Boolean bool = fragment5.f2835j;
        if (bool != null) {
            fragment5.P = bool.booleanValue();
            this.f2962c.f2835j = null;
        } else {
            fragment5.P = fragment5.f2832g.getBoolean("android:user_visible_hint", true);
        }
        Fragment fragment6 = this.f2962c;
        if (fragment6.P) {
            return;
        }
        fragment6.O = true;
    }

    void p() {
        if (w.H0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto RESUMED: ");
            sb2.append(this.f2962c);
        }
        View L = this.f2962c.L();
        if (L != null && l(L)) {
            boolean requestFocus = L.requestFocus();
            if (w.H0(2)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("requestFocus: Restoring focused view ");
                sb3.append(L);
                sb3.append(" ");
                sb3.append(requestFocus ? "succeeded" : "failed");
                sb3.append(" on Fragment ");
                sb3.append(this.f2962c);
                sb3.append(" resulting in focused view ");
                sb3.append(this.f2962c.N.findFocus());
            }
        }
        this.f2962c.J1(null);
        this.f2962c.v1();
        this.f2960a.i(this.f2962c, false);
        Fragment fragment = this.f2962c;
        fragment.f2832g = null;
        fragment.f2833h = null;
        fragment.f2834i = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        c0 c0Var = new c0(this.f2962c);
        Fragment fragment = this.f2962c;
        if (fragment.f2831f <= -1 || c0Var.f2921r != null) {
            c0Var.f2921r = fragment.f2832g;
        } else {
            Bundle q10 = q();
            c0Var.f2921r = q10;
            if (this.f2962c.f2839n != null) {
                if (q10 == null) {
                    c0Var.f2921r = new Bundle();
                }
                c0Var.f2921r.putString("android:target_state", this.f2962c.f2839n);
                int i10 = this.f2962c.f2840o;
                if (i10 != 0) {
                    c0Var.f2921r.putInt("android:target_req_state", i10);
                }
            }
        }
        this.f2961b.B(this.f2962c.f2836k, c0Var);
    }

    void s() {
        if (this.f2962c.N == null) {
            return;
        }
        if (w.H0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Saving view state for fragment ");
            sb2.append(this.f2962c);
            sb2.append(" with view ");
            sb2.append(this.f2962c.N);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f2962c.N.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f2962c.f2833h = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f2962c.X.h(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f2962c.f2834i = bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int i10) {
        this.f2964e = i10;
    }

    void u() {
        if (w.H0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto STARTED: ");
            sb2.append(this.f2962c);
        }
        this.f2962c.x1();
        this.f2960a.k(this.f2962c, false);
    }

    void v() {
        if (w.H0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom STARTED: ");
            sb2.append(this.f2962c);
        }
        this.f2962c.y1();
        this.f2960a.l(this.f2962c, false);
    }
}
