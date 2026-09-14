package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* loaded from: classes.dex */
public class e extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: e0, reason: collision with root package name */
    private Handler f2967e0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f2976n0;

    /* renamed from: p0, reason: collision with root package name */
    private Dialog f2978p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f2979q0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f2980r0;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f2981s0;

    /* renamed from: f0, reason: collision with root package name */
    private Runnable f2968f0 = new a();

    /* renamed from: g0, reason: collision with root package name */
    private DialogInterface.OnCancelListener f2969g0 = new b();

    /* renamed from: h0, reason: collision with root package name */
    private DialogInterface.OnDismissListener f2970h0 = new c();

    /* renamed from: i0, reason: collision with root package name */
    private int f2971i0 = 0;

    /* renamed from: j0, reason: collision with root package name */
    private int f2972j0 = 0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f2973k0 = true;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f2974l0 = true;

    /* renamed from: m0, reason: collision with root package name */
    private int f2975m0 = -1;

    /* renamed from: o0, reason: collision with root package name */
    private androidx.lifecycle.r<androidx.lifecycle.l> f2977o0 = new d();

    /* renamed from: t0, reason: collision with root package name */
    private boolean f2982t0 = false;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        @SuppressLint({"SyntheticAccessor"})
        public void run() {
            e.this.f2970h0.onDismiss(e.this.f2978p0);
        }
    }

    /* loaded from: classes.dex */
    class b implements DialogInterface.OnCancelListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        @SuppressLint({"SyntheticAccessor"})
        public void onCancel(DialogInterface dialogInterface) {
            if (e.this.f2978p0 != null) {
                e eVar = e.this;
                eVar.onCancel(eVar.f2978p0);
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements DialogInterface.OnDismissListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        @SuppressLint({"SyntheticAccessor"})
        public void onDismiss(DialogInterface dialogInterface) {
            if (e.this.f2978p0 != null) {
                e eVar = e.this;
                eVar.onDismiss(eVar.f2978p0);
            }
        }
    }

    /* loaded from: classes.dex */
    class d implements androidx.lifecycle.r<androidx.lifecycle.l> {
        d() {
        }

        @Override // androidx.lifecycle.r
        @SuppressLint({"SyntheticAccessor"})
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(androidx.lifecycle.l lVar) {
            if (lVar == null || !e.this.f2974l0) {
                return;
            }
            View D1 = e.this.D1();
            if (D1.getParent() != null) {
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
            if (e.this.f2978p0 != null) {
                if (w.H0(3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("DialogFragment ");
                    sb2.append(this);
                    sb2.append(" setting the content view on ");
                    sb2.append(e.this.f2978p0);
                }
                e.this.f2978p0.setContentView(D1);
            }
        }
    }

    /* renamed from: androidx.fragment.app.e$e, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0049e extends l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f2987a;

        C0049e(l lVar) {
            this.f2987a = lVar;
        }

        @Override // androidx.fragment.app.l
        public View d(int i10) {
            return this.f2987a.g() ? this.f2987a.d(i10) : e.this.c2(i10);
        }

        @Override // androidx.fragment.app.l
        public boolean g() {
            return this.f2987a.g() || e.this.d2();
        }
    }

    private void Y1(boolean z10, boolean z11, boolean z12) {
        if (this.f2980r0) {
            return;
        }
        this.f2980r0 = true;
        this.f2981s0 = false;
        Dialog dialog = this.f2978p0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f2978p0.dismiss();
            if (!z11) {
                if (Looper.myLooper() == this.f2967e0.getLooper()) {
                    onDismiss(this.f2978p0);
                } else {
                    this.f2967e0.post(this.f2968f0);
                }
            }
        }
        this.f2979q0 = true;
        if (this.f2975m0 >= 0) {
            if (z12) {
                S().c1(this.f2975m0, 1);
            } else {
                S().a1(this.f2975m0, 1, z10);
            }
            this.f2975m0 = -1;
            return;
        }
        f0 o10 = S().o();
        o10.s(true);
        o10.n(this);
        if (z12) {
            o10.j();
        } else if (z10) {
            o10.i();
        } else {
            o10.h();
        }
    }

    private void e2(Bundle bundle) {
        if (this.f2974l0 && !this.f2982t0) {
            try {
                this.f2976n0 = true;
                Dialog b22 = b2(bundle);
                this.f2978p0 = b22;
                if (this.f2974l0) {
                    h2(b22, this.f2971i0);
                    Context A = A();
                    if (A instanceof Activity) {
                        this.f2978p0.setOwnerActivity((Activity) A);
                    }
                    this.f2978p0.setCancelable(this.f2973k0);
                    this.f2978p0.setOnCancelListener(this.f2969g0);
                    this.f2978p0.setOnDismissListener(this.f2970h0);
                    this.f2982t0 = true;
                } else {
                    this.f2978p0 = null;
                }
            } finally {
                this.f2976n0 = false;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void B0(Bundle bundle) {
        super.B0(bundle);
        this.f2967e0 = new Handler();
        this.f2974l0 = this.D == 0;
        if (bundle != null) {
            this.f2971i0 = bundle.getInt("android:style", 0);
            this.f2972j0 = bundle.getInt("android:theme", 0);
            this.f2973k0 = bundle.getBoolean("android:cancelable", true);
            this.f2974l0 = bundle.getBoolean("android:showsDialog", this.f2974l0);
            this.f2975m0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void I0() {
        super.I0();
        Dialog dialog = this.f2978p0;
        if (dialog != null) {
            this.f2979q0 = true;
            dialog.setOnDismissListener(null);
            this.f2978p0.dismiss();
            if (!this.f2980r0) {
                onDismiss(this.f2978p0);
            }
            this.f2978p0 = null;
            this.f2982t0 = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void J0() {
        super.J0();
        if (!this.f2981s0 && !this.f2980r0) {
            this.f2980r0 = true;
        }
        i0().i(this.f2977o0);
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater K0(Bundle bundle) {
        StringBuilder sb2;
        String str;
        LayoutInflater K0 = super.K0(bundle);
        if (this.f2974l0 && !this.f2976n0) {
            e2(bundle);
            if (w.H0(2)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("get layout inflater for DialogFragment ");
                sb3.append(this);
                sb3.append(" from dialog context");
            }
            Dialog dialog = this.f2978p0;
            return dialog != null ? K0.cloneInContext(dialog.getContext()) : K0;
        }
        if (w.H0(2)) {
            String str2 = "getting layout inflater for DialogFragment " + this;
            if (this.f2974l0) {
                sb2 = new StringBuilder();
                str = "mCreatingDialog = true: ";
            } else {
                sb2 = new StringBuilder();
                str = "mShowsDialog = false: ";
            }
            sb2.append(str);
            sb2.append(str2);
        }
        return K0;
    }

    public void W1() {
        Y1(false, false, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void X0(Bundle bundle) {
        super.X0(bundle);
        Dialog dialog = this.f2978p0;
        if (dialog != null) {
            Bundle onSaveInstanceState = dialog.onSaveInstanceState();
            onSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i10 = this.f2971i0;
        if (i10 != 0) {
            bundle.putInt("android:style", i10);
        }
        int i11 = this.f2972j0;
        if (i11 != 0) {
            bundle.putInt("android:theme", i11);
        }
        boolean z10 = this.f2973k0;
        if (!z10) {
            bundle.putBoolean("android:cancelable", z10);
        }
        boolean z11 = this.f2974l0;
        if (!z11) {
            bundle.putBoolean("android:showsDialog", z11);
        }
        int i12 = this.f2975m0;
        if (i12 != -1) {
            bundle.putInt("android:backStackId", i12);
        }
    }

    public void X1() {
        Y1(true, false, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void Y0() {
        super.Y0();
        Dialog dialog = this.f2978p0;
        if (dialog != null) {
            this.f2979q0 = false;
            dialog.show();
            View decorView = this.f2978p0.getWindow().getDecorView();
            androidx.lifecycle.g0.a(decorView, this);
            androidx.lifecycle.h0.a(decorView, this);
            p0.f.a(decorView, this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void Z0() {
        super.Z0();
        Dialog dialog = this.f2978p0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    public Dialog Z1() {
        return this.f2978p0;
    }

    public int a2() {
        return this.f2972j0;
    }

    @Override // androidx.fragment.app.Fragment
    public void b1(Bundle bundle) {
        Bundle bundle2;
        super.b1(bundle);
        if (this.f2978p0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f2978p0.onRestoreInstanceState(bundle2);
    }

    public Dialog b2(Bundle bundle) {
        if (w.H0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onCreateDialog called for DialogFragment ");
            sb2.append(this);
        }
        return new androidx.activity.f(C1(), a2());
    }

    View c2(int i10) {
        Dialog dialog = this.f2978p0;
        if (dialog != null) {
            return dialog.findViewById(i10);
        }
        return null;
    }

    boolean d2() {
        return this.f2982t0;
    }

    public void f2(boolean z10) {
        this.f2973k0 = z10;
        Dialog dialog = this.f2978p0;
        if (dialog != null) {
            dialog.setCancelable(z10);
        }
    }

    public void g2(boolean z10) {
        this.f2974l0 = z10;
    }

    public void h2(Dialog dialog, int i10) {
        if (i10 != 1 && i10 != 2) {
            if (i10 != 3) {
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.fragment.app.Fragment
    public void i1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.i1(layoutInflater, viewGroup, bundle);
        if (this.N != null || this.f2978p0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f2978p0.onRestoreInstanceState(bundle2);
    }

    public void i2(w wVar, String str) {
        this.f2980r0 = false;
        this.f2981s0 = true;
        f0 o10 = wVar.o();
        o10.s(true);
        o10.e(this, str);
        o10.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.fragment.app.Fragment
    public l n() {
        return new C0049e(super.n());
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f2979q0) {
            return;
        }
        if (w.H0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onDismiss called for DialogFragment ");
            sb2.append(this);
        }
        Y1(true, true, false);
    }

    @Override // androidx.fragment.app.Fragment
    @Deprecated
    public void v0(Bundle bundle) {
        super.v0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void y0(Context context) {
        super.y0(context);
        i0().f(this.f2977o0);
        if (this.f2981s0) {
            return;
        }
        this.f2980r0 = false;
    }
}
