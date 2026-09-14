package androidx.fragment.app;

import android.view.View;

/* renamed from: androidx.fragment.app.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0284t extends O {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ O f3515a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DialogInterfaceOnCancelListenerC0285u f3516b;

    public C0284t(DialogInterfaceOnCancelListenerC0285u dialogInterfaceOnCancelListenerC0285u, O o2) {
        this.f3516b = dialogInterfaceOnCancelListenerC0285u;
        this.f3515a = o2;
    }

    @Override // androidx.fragment.app.O
    public final View b(int i) {
        O o2 = this.f3515a;
        if (o2.c()) {
            return o2.b(i);
        }
        return this.f3516b.onFindViewById(i);
    }

    @Override // androidx.fragment.app.O
    public final boolean c() {
        if (!this.f3515a.c() && !this.f3516b.onHasView()) {
            return false;
        }
        return true;
    }
}
