package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.app.b;
import androidx.lifecycle.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import p0.c;

/* loaded from: classes.dex */
public class j extends ComponentActivity implements b.d, b.f {

    /* renamed from: v, reason: collision with root package name */
    boolean f3044v;

    /* renamed from: w, reason: collision with root package name */
    boolean f3045w;

    /* renamed from: t, reason: collision with root package name */
    final m f3042t = m.b(new a());

    /* renamed from: u, reason: collision with root package name */
    final androidx.lifecycle.m f3043u = new androidx.lifecycle.m(this);

    /* renamed from: x, reason: collision with root package name */
    boolean f3046x = true;

    /* loaded from: classes.dex */
    class a extends o<j> implements androidx.core.content.b, androidx.core.content.c, androidx.core.app.o, androidx.core.app.p, androidx.lifecycle.f0, androidx.activity.h, androidx.activity.result.e, p0.e, a0, androidx.core.view.i {
        public a() {
            super(j.this);
        }

        @Override // androidx.activity.result.e
        public androidx.activity.result.d A() {
            return j.this.A();
        }

        @Override // androidx.core.app.o
        public void C(androidx.core.util.a<androidx.core.app.h> aVar) {
            j.this.C(aVar);
        }

        @Override // androidx.lifecycle.f0
        public androidx.lifecycle.e0 F() {
            return j.this.F();
        }

        @Override // androidx.core.app.o
        public void G(androidx.core.util.a<androidx.core.app.h> aVar) {
            j.this.G(aVar);
        }

        @Override // androidx.core.content.b
        public void K(androidx.core.util.a<Configuration> aVar) {
            j.this.K(aVar);
        }

        @Override // androidx.fragment.app.a0
        public void a(w wVar, Fragment fragment) {
            j.this.l0(fragment);
        }

        @Override // androidx.lifecycle.l
        public androidx.lifecycle.h b() {
            return j.this.f3043u;
        }

        @Override // androidx.fragment.app.o, androidx.fragment.app.l
        public View d(int i10) {
            return j.this.findViewById(i10);
        }

        @Override // androidx.activity.h
        public OnBackPressedDispatcher e() {
            return j.this.e();
        }

        @Override // p0.e
        public p0.c f() {
            return j.this.f();
        }

        @Override // androidx.fragment.app.o, androidx.fragment.app.l
        public boolean g() {
            Window window = j.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.core.view.i
        public void h(androidx.core.view.l lVar) {
            j.this.h(lVar);
        }

        @Override // androidx.fragment.app.o
        public void l(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            j.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.core.content.b
        public void m(androidx.core.util.a<Configuration> aVar) {
            j.this.m(aVar);
        }

        @Override // androidx.fragment.app.o
        public LayoutInflater o() {
            return j.this.getLayoutInflater().cloneInContext(j.this);
        }

        @Override // androidx.fragment.app.o
        public boolean p(String str) {
            return androidx.core.app.b.o(j.this, str);
        }

        @Override // androidx.core.app.p
        public void r(androidx.core.util.a<androidx.core.app.r> aVar) {
            j.this.r(aVar);
        }

        @Override // androidx.fragment.app.o
        public void s() {
            t();
        }

        public void t() {
            j.this.invalidateOptionsMenu();
        }

        @Override // androidx.core.content.c
        public void u(androidx.core.util.a<Integer> aVar) {
            j.this.u(aVar);
        }

        @Override // androidx.core.content.c
        public void v(androidx.core.util.a<Integer> aVar) {
            j.this.v(aVar);
        }

        @Override // androidx.fragment.app.o
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public j n() {
            return j.this;
        }

        @Override // androidx.core.app.p
        public void x(androidx.core.util.a<androidx.core.app.r> aVar) {
            j.this.x(aVar);
        }

        @Override // androidx.core.view.i
        public void z(androidx.core.view.l lVar) {
            j.this.z(lVar);
        }
    }

    public j() {
        e0();
    }

    private void e0() {
        f().h("android:support:lifecycle", new c.InterfaceC0267c() { // from class: androidx.fragment.app.i
            @Override // p0.c.InterfaceC0267c
            public final Bundle a() {
                Bundle f02;
                f02 = j.this.f0();
                return f02;
            }
        });
        m(new androidx.core.util.a() { // from class: androidx.fragment.app.g
            @Override // androidx.core.util.a
            public final void a(Object obj) {
                j.this.g0((Configuration) obj);
            }
        });
        R(new androidx.core.util.a() { // from class: androidx.fragment.app.f
            @Override // androidx.core.util.a
            public final void a(Object obj) {
                j.this.h0((Intent) obj);
            }
        });
        Q(new c.b() { // from class: androidx.fragment.app.h
            @Override // c.b
            public final void a(Context context) {
                j.this.i0(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle f0() {
        j0();
        this.f3043u.h(h.b.ON_STOP);
        return new Bundle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(Configuration configuration) {
        this.f3042t.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(Intent intent) {
        this.f3042t.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(Context context) {
        this.f3042t.a(null);
    }

    private static boolean k0(w wVar, h.c cVar) {
        boolean z10 = false;
        for (Fragment fragment : wVar.t0()) {
            if (fragment != null) {
                if (fragment.N() != null) {
                    z10 |= k0(fragment.z(), cVar);
                }
                j0 j0Var = fragment.X;
                if (j0Var != null && j0Var.b().b().isAtLeast(h.c.STARTED)) {
                    fragment.X.i(cVar);
                    z10 = true;
                }
                if (fragment.W.b().isAtLeast(h.c.STARTED)) {
                    fragment.W.o(cVar);
                    z10 = true;
                }
            }
        }
        return z10;
    }

    final View c0(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f3042t.n(view, str, context, attributeSet);
    }

    @Override // androidx.core.app.b.f
    @Deprecated
    public final void d(int i10) {
    }

    public w d0() {
        return this.f3042t.l();
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (L(strArr)) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            String str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f3044v);
            printWriter.print(" mResumed=");
            printWriter.print(this.f3045w);
            printWriter.print(" mStopped=");
            printWriter.print(this.f3046x);
            if (getApplication() != null) {
                androidx.loader.app.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
            }
            this.f3042t.l().X(str, fileDescriptor, printWriter, strArr);
        }
    }

    void j0() {
        do {
        } while (k0(d0(), h.c.CREATED));
    }

    @Deprecated
    public void l0(Fragment fragment) {
    }

    protected void m0() {
        this.f3043u.h(h.b.ON_RESUME);
        this.f3042t.h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        this.f3042t.m();
        super.onActivityResult(i10, i11, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.g, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3043u.h(h.b.ON_CREATE);
        this.f3042t.e();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View c02 = c0(view, str, context, attributeSet);
        return c02 == null ? super.onCreateView(view, str, context, attributeSet) : c02;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View c02 = c0(null, str, context, attributeSet);
        return c02 == null ? super.onCreateView(str, context, attributeSet) : c02;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f3042t.f();
        this.f3043u.h(h.b.ON_DESTROY);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        if (i10 == 6) {
            return this.f3042t.d(menuItem);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.f3045w = false;
        this.f3042t.g();
        this.f3043u.h(h.b.ON_PAUSE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        m0();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        this.f3042t.m();
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        this.f3042t.m();
        super.onResume();
        this.f3045w = true;
        this.f3042t.k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        this.f3042t.m();
        super.onStart();
        this.f3046x = false;
        if (!this.f3044v) {
            this.f3044v = true;
            this.f3042t.c();
        }
        this.f3042t.k();
        this.f3043u.h(h.b.ON_START);
        this.f3042t.i();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.f3042t.m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.f3046x = true;
        j0();
        this.f3042t.j();
        this.f3043u.h(h.b.ON_STOP);
    }
}
