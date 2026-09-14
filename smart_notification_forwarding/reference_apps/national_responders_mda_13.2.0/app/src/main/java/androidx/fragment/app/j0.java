package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.b0;
import androidx.lifecycle.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j0 implements androidx.lifecycle.g, p0.e, androidx.lifecycle.f0 {

    /* renamed from: f, reason: collision with root package name */
    private final Fragment f3048f;

    /* renamed from: g, reason: collision with root package name */
    private final androidx.lifecycle.e0 f3049g;

    /* renamed from: h, reason: collision with root package name */
    private androidx.lifecycle.m f3050h = null;

    /* renamed from: i, reason: collision with root package name */
    private p0.d f3051i = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j0(Fragment fragment, androidx.lifecycle.e0 e0Var) {
        this.f3048f = fragment;
        this.f3049g = e0Var;
    }

    @Override // androidx.lifecycle.f0
    public androidx.lifecycle.e0 F() {
        c();
        return this.f3049g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h.b bVar) {
        this.f3050h.h(bVar);
    }

    @Override // androidx.lifecycle.l
    public androidx.lifecycle.h b() {
        c();
        return this.f3050h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.f3050h == null) {
            this.f3050h = new androidx.lifecycle.m(this);
            p0.d a10 = p0.d.a(this);
            this.f3051i = a10;
            a10.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f3050h != null;
    }

    @Override // p0.e
    public p0.c f() {
        c();
        return this.f3051i.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Bundle bundle) {
        this.f3051i.d(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Bundle bundle) {
        this.f3051i.e(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(h.c cVar) {
        this.f3050h.o(cVar);
    }

    @Override // androidx.lifecycle.g
    public k0.a w() {
        Application application;
        Context applicationContext = this.f3048f.C1().getApplicationContext();
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
        k0.d dVar = new k0.d();
        if (application != null) {
            dVar.b(b0.a.f3198b, application);
        }
        dVar.b(androidx.lifecycle.x.f3238a, this.f3048f);
        dVar.b(androidx.lifecycle.x.f3239b, this);
        if (this.f3048f.y() != null) {
            dVar.b(androidx.lifecycle.x.f3240c, this.f3048f.y());
        }
        return dVar;
    }
}
