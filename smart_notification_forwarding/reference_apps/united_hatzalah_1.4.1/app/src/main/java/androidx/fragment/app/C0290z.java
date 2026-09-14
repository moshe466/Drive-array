package androidx.fragment.app;

import android.view.View;

/* renamed from: androidx.fragment.app.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0290z extends O {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ G f3538a;

    public C0290z(G g3) {
        this.f3538a = g3;
    }

    @Override // androidx.fragment.app.O
    public final View b(int i) {
        G g3 = this.f3538a;
        View view = g3.mView;
        if (view != null) {
            return view.findViewById(i);
        }
        throw new IllegalStateException("Fragment " + g3 + " does not have a view");
    }

    @Override // androidx.fragment.app.O
    public final boolean c() {
        if (this.f3538a.mView != null) {
            return true;
        }
        return false;
    }
}
