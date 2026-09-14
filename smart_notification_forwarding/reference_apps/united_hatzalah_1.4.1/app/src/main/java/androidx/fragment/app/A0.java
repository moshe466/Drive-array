package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.lifecycle.AbstractC0305o;
import androidx.lifecycle.C0311v;
import androidx.lifecycle.EnumC0303m;
import androidx.lifecycle.InterfaceC0299i;
import d0.AbstractC0356b;
import d0.C0357c;
import java.util.LinkedHashMap;
import l0.C0514d;
import l0.C0515e;
import l0.InterfaceC0516f;

/* loaded from: classes.dex */
public final class A0 implements InterfaceC0299i, InterfaceC0516f, androidx.lifecycle.a0 {

    /* renamed from: a, reason: collision with root package name */
    public final G f3253a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.lifecycle.Z f3254b;

    /* renamed from: c, reason: collision with root package name */
    public final RunnableC0286v f3255c;

    /* renamed from: d, reason: collision with root package name */
    public androidx.lifecycle.X f3256d;

    /* renamed from: e, reason: collision with root package name */
    public C0311v f3257e = null;

    /* renamed from: f, reason: collision with root package name */
    public C0515e f3258f = null;

    public A0(G g3, androidx.lifecycle.Z z3, RunnableC0286v runnableC0286v) {
        this.f3253a = g3;
        this.f3254b = z3;
        this.f3255c = runnableC0286v;
    }

    public final void a(EnumC0303m enumC0303m) {
        this.f3257e.e(enumC0303m);
    }

    public final void b() {
        if (this.f3257e == null) {
            this.f3257e = new C0311v(this);
            C0515e c0515e = new C0515e(this);
            this.f3258f = c0515e;
            c0515e.a();
            this.f3255c.run();
        }
    }

    @Override // androidx.lifecycle.InterfaceC0299i
    public final AbstractC0356b getDefaultViewModelCreationExtras() {
        Application application;
        G g3 = this.f3253a;
        Context applicationContext = g3.requireContext().getApplicationContext();
        while (true) {
            if (applicationContext instanceof ContextWrapper) {
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            } else {
                application = null;
                break;
            }
        }
        C0357c c0357c = new C0357c(0);
        LinkedHashMap linkedHashMap = c0357c.f4412a;
        if (application != null) {
            linkedHashMap.put(androidx.lifecycle.W.f3591d, application);
        }
        linkedHashMap.put(androidx.lifecycle.P.f3574a, g3);
        linkedHashMap.put(androidx.lifecycle.P.f3575b, this);
        if (g3.getArguments() != null) {
            linkedHashMap.put(androidx.lifecycle.P.f3576c, g3.getArguments());
        }
        return c0357c;
    }

    @Override // androidx.lifecycle.InterfaceC0299i
    public final androidx.lifecycle.X getDefaultViewModelProviderFactory() {
        Application application;
        G g3 = this.f3253a;
        androidx.lifecycle.X defaultViewModelProviderFactory = g3.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(g3.mDefaultFactory)) {
            this.f3256d = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.f3256d == null) {
            Context applicationContext = g3.requireContext().getApplicationContext();
            while (true) {
                if (applicationContext instanceof ContextWrapper) {
                    if (applicationContext instanceof Application) {
                        application = (Application) applicationContext;
                        break;
                    }
                    applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
                } else {
                    application = null;
                    break;
                }
            }
            this.f3256d = new androidx.lifecycle.T(application, g3, g3.getArguments());
        }
        return this.f3256d;
    }

    @Override // androidx.lifecycle.InterfaceC0309t
    public final AbstractC0305o getLifecycle() {
        b();
        return this.f3257e;
    }

    @Override // l0.InterfaceC0516f
    public final C0514d getSavedStateRegistry() {
        b();
        return this.f3258f.f5481b;
    }

    @Override // androidx.lifecycle.a0
    public final androidx.lifecycle.Z getViewModelStore() {
        b();
        return this.f3254b;
    }
}
