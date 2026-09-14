package androidx.lifecycle;

import android.os.Bundle;
import java.util.Map;
import l0.C0514d;
import l0.InterfaceC0513c;
import s2.C0682g;

/* loaded from: classes.dex */
public final class Q implements InterfaceC0513c {

    /* renamed from: a, reason: collision with root package name */
    public final C0514d f3577a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3578b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f3579c;

    /* renamed from: d, reason: collision with root package name */
    public final C0682g f3580d;

    public Q(C0514d savedStateRegistry, a0 a0Var) {
        kotlin.jvm.internal.j.e(savedStateRegistry, "savedStateRegistry");
        this.f3577a = savedStateRegistry;
        this.f3580d = T.b.A(new R.U(a0Var, 2));
    }

    @Override // l0.InterfaceC0513c
    public final Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f3579c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : ((S) this.f3580d.a()).f3581b.entrySet()) {
            String str = (String) entry.getKey();
            Bundle a2 = ((L) entry.getValue()).f3567e.a();
            if (!kotlin.jvm.internal.j.a(a2, Bundle.EMPTY)) {
                bundle.putBundle(str, a2);
            }
        }
        this.f3578b = false;
        return bundle;
    }

    public final void b() {
        if (!this.f3578b) {
            Bundle a2 = this.f3577a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
            Bundle bundle = new Bundle();
            Bundle bundle2 = this.f3579c;
            if (bundle2 != null) {
                bundle.putAll(bundle2);
            }
            if (a2 != null) {
                bundle.putAll(a2);
            }
            this.f3579c = bundle;
            this.f3578b = true;
        }
    }
}
