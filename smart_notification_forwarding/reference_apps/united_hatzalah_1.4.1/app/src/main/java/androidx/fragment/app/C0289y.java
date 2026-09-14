package androidx.fragment.app;

import android.os.Bundle;

/* renamed from: androidx.fragment.app.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0289y extends E {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ G f3532a;

    public C0289y(G g3) {
        this.f3532a = g3;
    }

    @Override // androidx.fragment.app.E
    public final void a() {
        Bundle bundle;
        G g3 = this.f3532a;
        g3.mSavedStateRegistryController.a();
        androidx.lifecycle.P.d(g3);
        Bundle bundle2 = g3.mSavedFragmentState;
        if (bundle2 != null) {
            bundle = bundle2.getBundle("registryState");
        } else {
            bundle = null;
        }
        g3.mSavedStateRegistryController.b(bundle);
    }
}
