package l0;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0305o;
import androidx.lifecycle.C0311v;
import androidx.lifecycle.EnumC0304n;
import java.util.Map;

/* renamed from: l0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0515e {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0516f f5480a;

    /* renamed from: b, reason: collision with root package name */
    public final C0514d f5481b = new C0514d();

    /* renamed from: c, reason: collision with root package name */
    public boolean f5482c;

    public C0515e(InterfaceC0516f interfaceC0516f) {
        this.f5480a = interfaceC0516f;
    }

    public final void a() {
        InterfaceC0516f interfaceC0516f = this.f5480a;
        AbstractC0305o lifecycle = interfaceC0516f.getLifecycle();
        if (((C0311v) lifecycle).f3618c == EnumC0304n.f3608b) {
            lifecycle.a(new C0511a(interfaceC0516f, 0));
            C0514d c0514d = this.f5481b;
            c0514d.getClass();
            if (!c0514d.f5475b) {
                lifecycle.a(new c.e(c0514d, 2));
                c0514d.f5475b = true;
                this.f5482c = true;
                return;
            }
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    public final void b(Bundle bundle) {
        Bundle bundle2;
        if (!this.f5482c) {
            a();
        }
        C0311v c0311v = (C0311v) this.f5480a.getLifecycle();
        if (c0311v.f3618c.compareTo(EnumC0304n.f3610d) < 0) {
            C0514d c0514d = this.f5481b;
            if (c0514d.f5475b) {
                if (!c0514d.f5477d) {
                    if (bundle != null) {
                        bundle2 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                    } else {
                        bundle2 = null;
                    }
                    c0514d.f5476c = bundle2;
                    c0514d.f5477d = true;
                    return;
                }
                throw new IllegalStateException("SavedStateRegistry was already restored.");
            }
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + c0311v.f3618c).toString());
    }

    public final void c(Bundle bundle) {
        C0514d c0514d = this.f5481b;
        c0514d.getClass();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = c0514d.f5476c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        o.f fVar = c0514d.f5474a;
        fVar.getClass();
        o.d dVar = new o.d(fVar);
        fVar.f5908c.put(dVar, Boolean.FALSE);
        while (dVar.hasNext()) {
            Map.Entry entry = (Map.Entry) dVar.next();
            bundle2.putBundle((String) entry.getKey(), ((InterfaceC0513c) entry.getValue()).a());
        }
        if (!bundle2.isEmpty()) {
            bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
        }
    }
}
