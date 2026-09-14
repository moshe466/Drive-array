package androidx.lifecycle;

import android.os.Bundle;
import java.util.Map;
import p0.c;

/* loaded from: classes.dex */
public final class y implements c.InterfaceC0267c {

    /* renamed from: a, reason: collision with root package name */
    private final p0.c f3242a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f3243b;

    /* renamed from: c, reason: collision with root package name */
    private Bundle f3244c;

    /* renamed from: d, reason: collision with root package name */
    private final l8.h f3245d;

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.a<z> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ f0 f3246f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(f0 f0Var) {
            super(0);
            this.f3246f = f0Var;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final z b() {
            return x.b(this.f3246f);
        }
    }

    public y(p0.c cVar, f0 f0Var) {
        l8.h b10;
        y8.k.e(cVar, "savedStateRegistry");
        y8.k.e(f0Var, "viewModelStoreOwner");
        this.f3242a = cVar;
        b10 = l8.j.b(new a(f0Var));
        this.f3245d = b10;
    }

    private final z b() {
        return (z) this.f3245d.getValue();
    }

    @Override // p0.c.InterfaceC0267c
    public Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f3244c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry<String, w> entry : b().e().entrySet()) {
            String key = entry.getKey();
            Bundle a10 = entry.getValue().c().a();
            if (!y8.k.a(a10, Bundle.EMPTY)) {
                bundle.putBundle(key, a10);
            }
        }
        this.f3243b = false;
        return bundle;
    }

    public final void c() {
        if (this.f3243b) {
            return;
        }
        this.f3244c = this.f3242a.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
        this.f3243b = true;
        b();
    }
}
