package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.b0;
import androidx.lifecycle.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.l, androidx.lifecycle.f0, androidx.lifecycle.g, p0.e {

    /* renamed from: d0, reason: collision with root package name */
    static final Object f2827d0 = new Object();
    Fragment B;
    int C;
    int D;
    String E;
    boolean F;
    boolean G;
    boolean H;
    boolean I;
    boolean J;
    private boolean L;
    ViewGroup M;
    View N;
    boolean O;
    f Q;
    boolean R;
    LayoutInflater S;
    boolean T;
    public String U;
    h.c V;
    androidx.lifecycle.m W;
    j0 X;
    androidx.lifecycle.q<androidx.lifecycle.l> Y;
    p0.d Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f2828a0;

    /* renamed from: b0, reason: collision with root package name */
    private final ArrayList<i> f2829b0;

    /* renamed from: c0, reason: collision with root package name */
    private final i f2830c0;

    /* renamed from: g, reason: collision with root package name */
    Bundle f2832g;

    /* renamed from: h, reason: collision with root package name */
    SparseArray<Parcelable> f2833h;

    /* renamed from: i, reason: collision with root package name */
    Bundle f2834i;

    /* renamed from: j, reason: collision with root package name */
    Boolean f2835j;

    /* renamed from: l, reason: collision with root package name */
    Bundle f2837l;

    /* renamed from: m, reason: collision with root package name */
    Fragment f2838m;

    /* renamed from: o, reason: collision with root package name */
    int f2840o;

    /* renamed from: q, reason: collision with root package name */
    boolean f2842q;

    /* renamed from: r, reason: collision with root package name */
    boolean f2843r;

    /* renamed from: s, reason: collision with root package name */
    boolean f2844s;

    /* renamed from: t, reason: collision with root package name */
    boolean f2845t;

    /* renamed from: u, reason: collision with root package name */
    boolean f2846u;

    /* renamed from: v, reason: collision with root package name */
    boolean f2847v;

    /* renamed from: w, reason: collision with root package name */
    boolean f2848w;

    /* renamed from: x, reason: collision with root package name */
    int f2849x;

    /* renamed from: y, reason: collision with root package name */
    w f2850y;

    /* renamed from: z, reason: collision with root package name */
    o<?> f2851z;

    /* renamed from: f, reason: collision with root package name */
    int f2831f = -1;

    /* renamed from: k, reason: collision with root package name */
    String f2836k = UUID.randomUUID().toString();

    /* renamed from: n, reason: collision with root package name */
    String f2839n = null;

    /* renamed from: p, reason: collision with root package name */
    private Boolean f2841p = null;
    w A = new x();
    boolean K = true;
    boolean P = true;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.S1();
        }
    }

    /* loaded from: classes.dex */
    class b extends i {
        b() {
            super(null);
        }

        @Override // androidx.fragment.app.Fragment.i
        void a() {
            Fragment.this.Z.c();
            androidx.lifecycle.x.a(Fragment.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.m(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ l0 f2856f;

        d(Fragment fragment, l0 l0Var) {
            this.f2856f = l0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2856f.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends l {
        e() {
        }

        @Override // androidx.fragment.app.l
        public View d(int i10) {
            View view = Fragment.this.N;
            if (view != null) {
                return view.findViewById(i10);
            }
            throw new IllegalStateException("Fragment " + Fragment.this + " does not have a view");
        }

        @Override // androidx.fragment.app.l
        public boolean g() {
            return Fragment.this.N != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        View f2858a;

        /* renamed from: b, reason: collision with root package name */
        boolean f2859b;

        /* renamed from: c, reason: collision with root package name */
        int f2860c;

        /* renamed from: d, reason: collision with root package name */
        int f2861d;

        /* renamed from: e, reason: collision with root package name */
        int f2862e;

        /* renamed from: f, reason: collision with root package name */
        int f2863f;

        /* renamed from: g, reason: collision with root package name */
        int f2864g;

        /* renamed from: h, reason: collision with root package name */
        ArrayList<String> f2865h;

        /* renamed from: i, reason: collision with root package name */
        ArrayList<String> f2866i;

        /* renamed from: j, reason: collision with root package name */
        Object f2867j = null;

        /* renamed from: k, reason: collision with root package name */
        Object f2868k;

        /* renamed from: l, reason: collision with root package name */
        Object f2869l;

        /* renamed from: m, reason: collision with root package name */
        Object f2870m;

        /* renamed from: n, reason: collision with root package name */
        Object f2871n;

        /* renamed from: o, reason: collision with root package name */
        Object f2872o;

        /* renamed from: p, reason: collision with root package name */
        Boolean f2873p;

        /* renamed from: q, reason: collision with root package name */
        Boolean f2874q;

        /* renamed from: r, reason: collision with root package name */
        androidx.core.app.t f2875r;

        /* renamed from: s, reason: collision with root package name */
        androidx.core.app.t f2876s;

        /* renamed from: t, reason: collision with root package name */
        float f2877t;

        /* renamed from: u, reason: collision with root package name */
        View f2878u;

        /* renamed from: v, reason: collision with root package name */
        boolean f2879v;

        f() {
            Object obj = Fragment.f2827d0;
            this.f2868k = obj;
            this.f2869l = null;
            this.f2870m = obj;
            this.f2871n = null;
            this.f2872o = obj;
            this.f2877t = 1.0f;
            this.f2878u = null;
        }
    }

    /* loaded from: classes.dex */
    static class g {
        static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    /* loaded from: classes.dex */
    public static class h extends RuntimeException {
        public h(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class i {
        private i() {
        }

        /* synthetic */ i(a aVar) {
            this();
        }

        abstract void a();
    }

    public Fragment() {
        new a();
        this.V = h.c.RESUMED;
        this.Y = new androidx.lifecycle.q<>();
        new AtomicInteger();
        this.f2829b0 = new ArrayList<>();
        this.f2830c0 = new b();
        j0();
    }

    private void A1(i iVar) {
        if (this.f2831f >= 0) {
            iVar.a();
        } else {
            this.f2829b0.add(iVar);
        }
    }

    private void F1() {
        if (w.H0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto RESTORE_VIEW_STATE: ");
            sb2.append(this);
        }
        if (this.N != null) {
            G1(this.f2832g);
        }
        this.f2832g = null;
    }

    private int P() {
        h.c cVar = this.V;
        return (cVar == h.c.INITIALIZED || this.B == null) ? cVar.ordinal() : Math.min(cVar.ordinal(), this.B.P());
    }

    private Fragment f0(boolean z10) {
        String str;
        if (z10) {
            e0.d.j(this);
        }
        Fragment fragment = this.f2838m;
        if (fragment != null) {
            return fragment;
        }
        w wVar = this.f2850y;
        if (wVar == null || (str = this.f2839n) == null) {
            return null;
        }
        return wVar.f0(str);
    }

    private void j0() {
        this.W = new androidx.lifecycle.m(this);
        this.Z = p0.d.a(this);
        if (this.f2829b0.contains(this.f2830c0)) {
            return;
        }
        A1(this.f2830c0);
    }

    @Deprecated
    public static Fragment l0(Context context, String str, Bundle bundle) {
        try {
            Fragment newInstance = n.d(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(newInstance.getClass().getClassLoader());
                newInstance.I1(bundle);
            }
            return newInstance;
        } catch (IllegalAccessException e10) {
            throw new h("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e10);
        } catch (InstantiationException e11) {
            throw new h("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e11);
        } catch (NoSuchMethodException e12) {
            throw new h("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e12);
        } catch (InvocationTargetException e13) {
            throw new h("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e13);
        }
    }

    private f r() {
        if (this.Q == null) {
            this.Q = new f();
        }
        return this.Q;
    }

    public Context A() {
        o<?> oVar = this.f2851z;
        if (oVar == null) {
            return null;
        }
        return oVar.j();
    }

    public boolean A0(MenuItem menuItem) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int B() {
        f fVar = this.Q;
        if (fVar == null) {
            return 0;
        }
        return fVar.f2860c;
    }

    public void B0(Bundle bundle) {
        this.L = true;
        E1(bundle);
        if (this.A.N0(1)) {
            return;
        }
        this.A.C();
    }

    public final j B1() {
        j t10 = t();
        if (t10 != null) {
            return t10;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public Object C() {
        f fVar = this.Q;
        if (fVar == null) {
            return null;
        }
        return fVar.f2867j;
    }

    public Animation C0(int i10, boolean z10, int i11) {
        return null;
    }

    public final Context C1() {
        Context A = A();
        if (A != null) {
            return A;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.core.app.t D() {
        f fVar = this.Q;
        if (fVar == null) {
            return null;
        }
        return fVar.f2875r;
    }

    public Animator D0(int i10, boolean z10, int i11) {
        return null;
    }

    public final View D1() {
        View h02 = h0();
        if (h02 != null) {
            return h02;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    @Deprecated
    public void E0(Menu menu, MenuInflater menuInflater) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E1(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.A.i1(parcelable);
        this.A.C();
    }

    @Override // androidx.lifecycle.f0
    public androidx.lifecycle.e0 F() {
        if (this.f2850y == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (P() != h.c.INITIALIZED.ordinal()) {
            return this.f2850y.C0(this);
        }
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    }

    public View F0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i10 = this.f2828a0;
        if (i10 != 0) {
            return layoutInflater.inflate(i10, viewGroup, false);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int G() {
        f fVar = this.Q;
        if (fVar == null) {
            return 0;
        }
        return fVar.f2861d;
    }

    public void G0() {
        this.L = true;
    }

    final void G1(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.f2833h;
        if (sparseArray != null) {
            this.N.restoreHierarchyState(sparseArray);
            this.f2833h = null;
        }
        if (this.N != null) {
            this.X.g(this.f2834i);
            this.f2834i = null;
        }
        this.L = false;
        b1(bundle);
        if (this.L) {
            if (this.N != null) {
                this.X.a(h.b.ON_CREATE);
            }
        } else {
            throw new n0("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public Object H() {
        f fVar = this.Q;
        if (fVar == null) {
            return null;
        }
        return fVar.f2869l;
    }

    @Deprecated
    public void H0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H1(int i10, int i11, int i12, int i13) {
        if (this.Q == null && i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) {
            return;
        }
        r().f2860c = i10;
        r().f2861d = i11;
        r().f2862e = i12;
        r().f2863f = i13;
    }

    public void I0() {
        this.L = true;
    }

    public void I1(Bundle bundle) {
        if (this.f2850y != null && s0()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.f2837l = bundle;
    }

    public void J0() {
        this.L = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J1(View view) {
        r().f2878u = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.core.app.t K() {
        f fVar = this.Q;
        if (fVar == null) {
            return null;
        }
        return fVar.f2876s;
    }

    public LayoutInflater K0(Bundle bundle) {
        return O(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K1(int i10) {
        if (this.Q == null && i10 == 0) {
            return;
        }
        r();
        this.Q.f2864g = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View L() {
        f fVar = this.Q;
        if (fVar == null) {
            return null;
        }
        return fVar.f2878u;
    }

    public void L0(boolean z10) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L1(boolean z10) {
        if (this.Q == null) {
            return;
        }
        r().f2859b = z10;
    }

    @Deprecated
    public final w M() {
        return this.f2850y;
    }

    @Deprecated
    public void M0(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.L = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M1(float f10) {
        r().f2877t = f10;
    }

    public final Object N() {
        o<?> oVar = this.f2851z;
        if (oVar == null) {
            return null;
        }
        return oVar.n();
    }

    public void N0(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.L = true;
        o<?> oVar = this.f2851z;
        Activity i10 = oVar == null ? null : oVar.i();
        if (i10 != null) {
            this.L = false;
            M0(i10, attributeSet, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N1(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        r();
        f fVar = this.Q;
        fVar.f2865h = arrayList;
        fVar.f2866i = arrayList2;
    }

    @Deprecated
    public LayoutInflater O(Bundle bundle) {
        o<?> oVar = this.f2851z;
        if (oVar == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater o10 = oVar.o();
        androidx.core.view.g.b(o10, this.A.v0());
        return o10;
    }

    public void O0(boolean z10) {
    }

    public boolean O1(String str) {
        o<?> oVar = this.f2851z;
        if (oVar != null) {
            return oVar.p(str);
        }
        return false;
    }

    @Deprecated
    public boolean P0(MenuItem menuItem) {
        return false;
    }

    public void P1(@SuppressLint({"UnknownNullness"}) Intent intent) {
        Q1(intent, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int Q() {
        f fVar = this.Q;
        if (fVar == null) {
            return 0;
        }
        return fVar.f2864g;
    }

    @Deprecated
    public void Q0(Menu menu) {
    }

    public void Q1(@SuppressLint({"UnknownNullness"}) Intent intent, Bundle bundle) {
        o<?> oVar = this.f2851z;
        if (oVar != null) {
            oVar.q(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final Fragment R() {
        return this.B;
    }

    public void R0() {
        this.L = true;
    }

    @Deprecated
    public void R1(@SuppressLint({"UnknownNullness"}) Intent intent, int i10, Bundle bundle) {
        if (this.f2851z != null) {
            S().U0(this, intent, i10, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final w S() {
        w wVar = this.f2850y;
        if (wVar != null) {
            return wVar;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public void S0(boolean z10) {
    }

    public void S1() {
        if (this.Q == null || !r().f2879v) {
            return;
        }
        if (this.f2851z == null) {
            r().f2879v = false;
        } else if (Looper.myLooper() != this.f2851z.k().getLooper()) {
            this.f2851z.k().postAtFrontOfQueue(new c());
        } else {
            m(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean T() {
        f fVar = this.Q;
        if (fVar == null) {
            return false;
        }
        return fVar.f2859b;
    }

    @Deprecated
    public void T0(Menu menu) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int U() {
        f fVar = this.Q;
        if (fVar == null) {
            return 0;
        }
        return fVar.f2862e;
    }

    public void U0(boolean z10) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int V() {
        f fVar = this.Q;
        if (fVar == null) {
            return 0;
        }
        return fVar.f2863f;
    }

    @Deprecated
    public void V0(int i10, String[] strArr, int[] iArr) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float W() {
        f fVar = this.Q;
        if (fVar == null) {
            return 1.0f;
        }
        return fVar.f2877t;
    }

    public void W0() {
        this.L = true;
    }

    public Object X() {
        f fVar = this.Q;
        if (fVar == null) {
            return null;
        }
        Object obj = fVar.f2870m;
        return obj == f2827d0 ? H() : obj;
    }

    public void X0(Bundle bundle) {
    }

    public final Resources Y() {
        return C1().getResources();
    }

    public void Y0() {
        this.L = true;
    }

    public Object Z() {
        f fVar = this.Q;
        if (fVar == null) {
            return null;
        }
        Object obj = fVar.f2868k;
        return obj == f2827d0 ? C() : obj;
    }

    public void Z0() {
        this.L = true;
    }

    public Object a0() {
        f fVar = this.Q;
        if (fVar == null) {
            return null;
        }
        return fVar.f2871n;
    }

    public void a1(View view, Bundle bundle) {
    }

    @Override // androidx.lifecycle.l
    public androidx.lifecycle.h b() {
        return this.W;
    }

    public Object b0() {
        f fVar = this.Q;
        if (fVar == null) {
            return null;
        }
        Object obj = fVar.f2872o;
        return obj == f2827d0 ? a0() : obj;
    }

    public void b1(Bundle bundle) {
        this.L = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> c0() {
        ArrayList<String> arrayList;
        f fVar = this.Q;
        return (fVar == null || (arrayList = fVar.f2865h) == null) ? new ArrayList<>() : arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c1(Bundle bundle) {
        this.A.W0();
        this.f2831f = 3;
        this.L = false;
        v0(bundle);
        if (this.L) {
            F1();
            this.A.y();
        } else {
            throw new n0("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> d0() {
        ArrayList<String> arrayList;
        f fVar = this.Q;
        return (fVar == null || (arrayList = fVar.f2866i) == null) ? new ArrayList<>() : arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d1() {
        Iterator<i> it = this.f2829b0.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f2829b0.clear();
        this.A.m(this.f2851z, n(), this);
        this.f2831f = 0;
        this.L = false;
        y0(this.f2851z.j());
        if (this.L) {
            this.f2850y.I(this);
            this.A.z();
        } else {
            throw new n0("Fragment " + this + " did not call through to super.onAttach()");
        }
    }

    public final String e0(int i10) {
        return Y().getString(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e1(Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // p0.e
    public final p0.c f() {
        return this.Z.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f1(MenuItem menuItem) {
        if (this.F) {
            return false;
        }
        if (A0(menuItem)) {
            return true;
        }
        return this.A.B(menuItem);
    }

    public final CharSequence g0(int i10) {
        return Y().getText(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g1(Bundle bundle) {
        this.A.W0();
        this.f2831f = 1;
        this.L = false;
        if (Build.VERSION.SDK_INT >= 19) {
            this.W.a(new androidx.lifecycle.j() { // from class: androidx.fragment.app.Fragment.6
                @Override // androidx.lifecycle.j
                public void d(androidx.lifecycle.l lVar, h.b bVar) {
                    View view;
                    if (bVar != h.b.ON_STOP || (view = Fragment.this.N) == null) {
                        return;
                    }
                    g.a(view);
                }
            });
        }
        this.Z.d(bundle);
        B0(bundle);
        this.T = true;
        if (this.L) {
            this.W.h(h.b.ON_CREATE);
            return;
        }
        throw new n0("Fragment " + this + " did not call through to super.onCreate()");
    }

    public View h0() {
        return this.N;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h1(Menu menu, MenuInflater menuInflater) {
        boolean z10 = false;
        if (this.F) {
            return false;
        }
        if (this.J && this.K) {
            z10 = true;
            E0(menu, menuInflater);
        }
        return z10 | this.A.D(menu, menuInflater);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public LiveData<androidx.lifecycle.l> i0() {
        return this.Y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.A.W0();
        this.f2848w = true;
        this.X = new j0(this, F());
        View F0 = F0(layoutInflater, viewGroup, bundle);
        this.N = F0;
        if (F0 == null) {
            if (this.X.d()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.X = null;
        } else {
            this.X.c();
            androidx.lifecycle.g0.a(this.N, this.X);
            androidx.lifecycle.h0.a(this.N, this.X);
            p0.f.a(this.N, this.X);
            this.Y.j(this.X);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j1() {
        this.A.E();
        this.W.h(h.b.ON_DESTROY);
        this.f2831f = 0;
        this.L = false;
        this.T = false;
        G0();
        if (this.L) {
            return;
        }
        throw new n0("Fragment " + this + " did not call through to super.onDestroy()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k0() {
        j0();
        this.U = this.f2836k;
        this.f2836k = UUID.randomUUID().toString();
        this.f2842q = false;
        this.f2843r = false;
        this.f2845t = false;
        this.f2846u = false;
        this.f2847v = false;
        this.f2849x = 0;
        this.f2850y = null;
        this.A = new x();
        this.f2851z = null;
        this.C = 0;
        this.D = 0;
        this.E = null;
        this.F = false;
        this.G = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k1() {
        this.A.F();
        if (this.N != null && this.X.b().b().isAtLeast(h.c.CREATED)) {
            this.X.a(h.b.ON_DESTROY);
        }
        this.f2831f = 1;
        this.L = false;
        I0();
        if (this.L) {
            androidx.loader.app.a.b(this).c();
            this.f2848w = false;
        } else {
            throw new n0("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l1() {
        this.f2831f = -1;
        this.L = false;
        J0();
        this.S = null;
        if (this.L) {
            if (this.A.G0()) {
                return;
            }
            this.A.E();
            this.A = new x();
            return;
        }
        throw new n0("Fragment " + this + " did not call through to super.onDetach()");
    }

    void m(boolean z10) {
        ViewGroup viewGroup;
        w wVar;
        f fVar = this.Q;
        if (fVar != null) {
            fVar.f2879v = false;
        }
        if (this.N == null || (viewGroup = this.M) == null || (wVar = this.f2850y) == null) {
            return;
        }
        l0 n10 = l0.n(viewGroup, wVar);
        n10.p();
        if (z10) {
            this.f2851z.k().post(new d(this, n10));
        } else {
            n10.g();
        }
    }

    public final boolean m0() {
        return this.f2851z != null && this.f2842q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater m1(Bundle bundle) {
        LayoutInflater K0 = K0(bundle);
        this.S = K0;
        return K0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l n() {
        return new e();
    }

    public final boolean n0() {
        w wVar;
        return this.F || ((wVar = this.f2850y) != null && wVar.K0(this.B));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n1() {
        onLowMemory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean o0() {
        return this.f2849x > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o1(boolean z10) {
        O0(z10);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.L = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        B1().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.L = true;
    }

    public void p(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.C));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.D));
        printWriter.print(" mTag=");
        printWriter.println(this.E);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f2831f);
        printWriter.print(" mWho=");
        printWriter.print(this.f2836k);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f2849x);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f2842q);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f2843r);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f2845t);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f2846u);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.F);
        printWriter.print(" mDetached=");
        printWriter.print(this.G);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.K);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.J);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.H);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.P);
        if (this.f2850y != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f2850y);
        }
        if (this.f2851z != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f2851z);
        }
        if (this.B != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.B);
        }
        if (this.f2837l != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f2837l);
        }
        if (this.f2832g != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f2832g);
        }
        if (this.f2833h != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f2833h);
        }
        if (this.f2834i != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.f2834i);
        }
        Fragment f02 = f0(false);
        if (f02 != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(f02);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f2840o);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(T());
        if (B() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(B());
        }
        if (G() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(G());
        }
        if (U() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(U());
        }
        if (V() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(V());
        }
        if (this.M != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.M);
        }
        if (this.N != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.N);
        }
        if (x() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(x());
        }
        if (A() != null) {
            androidx.loader.app.a.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.A + ":");
        this.A.X(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public final boolean p0() {
        w wVar;
        return this.K && ((wVar = this.f2850y) == null || wVar.L0(this.B));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p1(MenuItem menuItem) {
        if (this.F) {
            return false;
        }
        if (this.J && this.K && P0(menuItem)) {
            return true;
        }
        return this.A.K(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q0() {
        f fVar = this.Q;
        if (fVar == null) {
            return false;
        }
        return fVar.f2879v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q1(Menu menu) {
        if (this.F) {
            return;
        }
        if (this.J && this.K) {
            Q0(menu);
        }
        this.A.L(menu);
    }

    public final boolean r0() {
        return this.f2843r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r1() {
        this.A.N();
        if (this.N != null) {
            this.X.a(h.b.ON_PAUSE);
        }
        this.W.h(h.b.ON_PAUSE);
        this.f2831f = 6;
        this.L = false;
        R0();
        if (this.L) {
            return;
        }
        throw new n0("Fragment " + this + " did not call through to super.onPause()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment s(String str) {
        return str.equals(this.f2836k) ? this : this.A.j0(str);
    }

    public final boolean s0() {
        w wVar = this.f2850y;
        if (wVar == null) {
            return false;
        }
        return wVar.O0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s1(boolean z10) {
        S0(z10);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i10) {
        R1(intent, i10, null);
    }

    public final j t() {
        o<?> oVar = this.f2851z;
        if (oVar == null) {
            return null;
        }
        return (j) oVar.i();
    }

    public final boolean t0() {
        View view;
        return (!m0() || n0() || (view = this.N) == null || view.getWindowToken() == null || this.N.getVisibility() != 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t1(Menu menu) {
        boolean z10 = false;
        if (this.F) {
            return false;
        }
        if (this.J && this.K) {
            z10 = true;
            T0(menu);
        }
        return z10 | this.A.P(menu);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append(getClass().getSimpleName());
        sb2.append("{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("}");
        sb2.append(" (");
        sb2.append(this.f2836k);
        if (this.C != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(this.C));
        }
        if (this.E != null) {
            sb2.append(" tag=");
            sb2.append(this.E);
        }
        sb2.append(")");
        return sb2.toString();
    }

    public boolean u() {
        Boolean bool;
        f fVar = this.Q;
        if (fVar == null || (bool = fVar.f2874q) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u0() {
        this.A.W0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u1() {
        boolean M0 = this.f2850y.M0(this);
        Boolean bool = this.f2841p;
        if (bool == null || bool.booleanValue() != M0) {
            this.f2841p = Boolean.valueOf(M0);
            U0(M0);
            this.A.Q();
        }
    }

    public boolean v() {
        Boolean bool;
        f fVar = this.Q;
        if (fVar == null || (bool = fVar.f2873p) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    @Deprecated
    public void v0(Bundle bundle) {
        this.L = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v1() {
        this.A.W0();
        this.A.b0(true);
        this.f2831f = 7;
        this.L = false;
        W0();
        if (!this.L) {
            throw new n0("Fragment " + this + " did not call through to super.onResume()");
        }
        androidx.lifecycle.m mVar = this.W;
        h.b bVar = h.b.ON_RESUME;
        mVar.h(bVar);
        if (this.N != null) {
            this.X.a(bVar);
        }
        this.A.R();
    }

    @Override // androidx.lifecycle.g
    public k0.a w() {
        Application application;
        Context applicationContext = C1().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        if (application == null && w.H0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Could not find Application instance from Context ");
            sb2.append(C1().getApplicationContext());
            sb2.append(", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        k0.d dVar = new k0.d();
        if (application != null) {
            dVar.b(b0.a.f3198b, application);
        }
        dVar.b(androidx.lifecycle.x.f3238a, this);
        dVar.b(androidx.lifecycle.x.f3239b, this);
        if (y() != null) {
            dVar.b(androidx.lifecycle.x.f3240c, y());
        }
        return dVar;
    }

    @Deprecated
    public void w0(int i10, int i11, Intent intent) {
        if (w.H0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Fragment ");
            sb2.append(this);
            sb2.append(" received the following in onActivityResult(): requestCode: ");
            sb2.append(i10);
            sb2.append(" resultCode: ");
            sb2.append(i11);
            sb2.append(" data: ");
            sb2.append(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w1(Bundle bundle) {
        X0(bundle);
        this.Z.e(bundle);
        Bundle P0 = this.A.P0();
        if (P0 != null) {
            bundle.putParcelable("android:support:fragments", P0);
        }
    }

    View x() {
        f fVar = this.Q;
        if (fVar == null) {
            return null;
        }
        return fVar.f2858a;
    }

    @Deprecated
    public void x0(Activity activity) {
        this.L = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x1() {
        this.A.W0();
        this.A.b0(true);
        this.f2831f = 5;
        this.L = false;
        Y0();
        if (!this.L) {
            throw new n0("Fragment " + this + " did not call through to super.onStart()");
        }
        androidx.lifecycle.m mVar = this.W;
        h.b bVar = h.b.ON_START;
        mVar.h(bVar);
        if (this.N != null) {
            this.X.a(bVar);
        }
        this.A.S();
    }

    public final Bundle y() {
        return this.f2837l;
    }

    public void y0(Context context) {
        this.L = true;
        o<?> oVar = this.f2851z;
        Activity i10 = oVar == null ? null : oVar.i();
        if (i10 != null) {
            this.L = false;
            x0(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y1() {
        this.A.U();
        if (this.N != null) {
            this.X.a(h.b.ON_STOP);
        }
        this.W.h(h.b.ON_STOP);
        this.f2831f = 4;
        this.L = false;
        Z0();
        if (this.L) {
            return;
        }
        throw new n0("Fragment " + this + " did not call through to super.onStop()");
    }

    public final w z() {
        if (this.f2851z != null) {
            return this.A;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    @Deprecated
    public void z0(Fragment fragment) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z1() {
        a1(this.N, this.f2832g);
        this.A.V();
    }
}
