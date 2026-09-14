package androidx.fragment.app;

import android.view.View;
import androidx.lifecycle.EnumC0303m;
import androidx.lifecycle.InterfaceC0309t;

/* loaded from: classes.dex */
public final class A implements androidx.lifecycle.r {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ G f3252a;

    public A(G g3) {
        this.f3252a = g3;
    }

    @Override // androidx.lifecycle.r
    public final void a(InterfaceC0309t interfaceC0309t, EnumC0303m enumC0303m) {
        View view;
        if (enumC0303m == EnumC0303m.ON_STOP && (view = this.f3252a.mView) != null) {
            view.cancelPendingInputEvents();
        }
    }
}
