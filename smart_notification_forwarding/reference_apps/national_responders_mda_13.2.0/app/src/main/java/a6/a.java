package a6;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.f0;

/* loaded from: classes.dex */
public abstract class a extends androidx.fragment.app.e implements b {

    /* renamed from: u0, reason: collision with root package name */
    protected LayoutInflater f304u0;

    /* renamed from: v0, reason: collision with root package name */
    protected ViewGroup f305v0;

    /* renamed from: w0, reason: collision with root package name */
    protected View f306w0;

    /* renamed from: x0, reason: collision with root package name */
    protected Bundle f307x0;

    /* renamed from: y0, reason: collision with root package name */
    private b f308y0;

    /* renamed from: z0, reason: collision with root package name */
    protected boolean f309z0;

    @Override // a6.b
    public void E() {
        this.f308y0.E();
    }

    @Override // androidx.fragment.app.Fragment
    public View F0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f304u0 = layoutInflater;
        this.f305v0 = viewGroup;
        this.f307x0 = bundle;
        n2();
        CookieSyncManager.createInstance(t());
        CookieManager.getInstance().setAcceptCookie(true);
        View view = this.f306w0;
        return view == null ? super.F0(layoutInflater, viewGroup, bundle) : view;
    }

    @Override // a6.b
    public void I(boolean z10) {
        this.f308y0.I(z10);
    }

    @Override // a6.b
    public void J(boolean z10) {
        this.f308y0.J(z10);
    }

    @Override // androidx.fragment.app.Fragment
    public void R0() {
        this.f309z0 = false;
        super.R0();
        o2();
        if (Build.VERSION.SDK_INT < 25) {
            CookieSyncManager.getInstance().sync();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void W0() {
        super.W0();
        this.f309z0 = true;
        if (Build.VERSION.SDK_INT < 25) {
            CookieSyncManager.getInstance().stopSync();
        }
    }

    @Override // a6.b
    public void a(String str) {
        this.f308y0.a(str);
    }

    @Override // a6.b
    public void g(boolean z10) {
        this.f308y0.g(z10);
    }

    public void j2(Fragment fragment, int i10) {
        f0 o10 = M().o();
        o10.b(i10, fragment);
        o10.h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View k2(int i10) {
        return this.f306w0.findViewById(i10);
    }

    @Override // a6.b
    public void l(boolean z10) {
        this.f308y0.l(z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l2(int i10) {
        this.f306w0 = this.f304u0.inflate(i10, this.f305v0, false);
    }

    public boolean m2() {
        return t0() && m0() && t() != null && !t().isFinishing();
    }

    protected abstract void n2();

    @Override // a6.b
    public void o(Fragment fragment, boolean z10) {
        this.f308y0.o(fragment, z10);
    }

    public abstract void o2();

    @Override // a6.b
    public void q(boolean z10) {
        this.f308y0.q(z10);
    }

    @Override // a6.b
    public void setTitle(int i10) {
        this.f308y0.setTitle(i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void x0(Activity activity) {
        super.x0(activity);
        try {
            this.f308y0 = (b) activity;
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString() + " must implement LisInterface");
        }
    }
}
