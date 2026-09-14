package androidx.fragment.app;

import J.InterfaceC0123k;
import J.InterfaceC0128p;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.AbstractC0305o;
import l0.C0514d;
import l0.InterfaceC0516f;
import x.InterfaceC0776g;
import x.InterfaceC0777h;

/* loaded from: classes.dex */
public final class K extends S implements InterfaceC0776g, InterfaceC0777h, w.q, w.r, androidx.lifecycle.a0, c.y, e.i, InterfaceC0516f, l0, InterfaceC0123k {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ L f3307e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(L l3) {
        super(l3);
        this.f3307e = l3;
    }

    @Override // androidx.fragment.app.l0
    public final void a(G g3) {
        this.f3307e.onAttachFragment(g3);
    }

    @Override // J.InterfaceC0123k
    public final void addMenuProvider(InterfaceC0128p interfaceC0128p) {
        this.f3307e.addMenuProvider(interfaceC0128p);
    }

    @Override // x.InterfaceC0776g
    public final void addOnConfigurationChangedListener(I.a aVar) {
        this.f3307e.addOnConfigurationChangedListener(aVar);
    }

    @Override // w.q
    public final void addOnMultiWindowModeChangedListener(I.a aVar) {
        this.f3307e.addOnMultiWindowModeChangedListener(aVar);
    }

    @Override // w.r
    public final void addOnPictureInPictureModeChangedListener(I.a aVar) {
        this.f3307e.addOnPictureInPictureModeChangedListener(aVar);
    }

    @Override // x.InterfaceC0777h
    public final void addOnTrimMemoryListener(I.a aVar) {
        this.f3307e.addOnTrimMemoryListener(aVar);
    }

    @Override // androidx.fragment.app.O
    public final View b(int i) {
        return this.f3307e.findViewById(i);
    }

    @Override // androidx.fragment.app.O
    public final boolean c() {
        Window window = this.f3307e.getWindow();
        if (window != null && window.peekDecorView() != null) {
            return true;
        }
        return false;
    }

    @Override // e.i
    public final e.h getActivityResultRegistry() {
        return this.f3307e.getActivityResultRegistry();
    }

    @Override // androidx.lifecycle.InterfaceC0309t
    public final AbstractC0305o getLifecycle() {
        return this.f3307e.mFragmentLifecycleRegistry;
    }

    @Override // c.y
    public final c.x getOnBackPressedDispatcher() {
        return this.f3307e.getOnBackPressedDispatcher();
    }

    @Override // l0.InterfaceC0516f
    public final C0514d getSavedStateRegistry() {
        return this.f3307e.getSavedStateRegistry();
    }

    @Override // androidx.lifecycle.a0
    public final androidx.lifecycle.Z getViewModelStore() {
        return this.f3307e.getViewModelStore();
    }

    @Override // J.InterfaceC0123k
    public final void removeMenuProvider(InterfaceC0128p interfaceC0128p) {
        this.f3307e.removeMenuProvider(interfaceC0128p);
    }

    @Override // x.InterfaceC0776g
    public final void removeOnConfigurationChangedListener(I.a aVar) {
        this.f3307e.removeOnConfigurationChangedListener(aVar);
    }

    @Override // w.q
    public final void removeOnMultiWindowModeChangedListener(I.a aVar) {
        this.f3307e.removeOnMultiWindowModeChangedListener(aVar);
    }

    @Override // w.r
    public final void removeOnPictureInPictureModeChangedListener(I.a aVar) {
        this.f3307e.removeOnPictureInPictureModeChangedListener(aVar);
    }

    @Override // x.InterfaceC0777h
    public final void removeOnTrimMemoryListener(I.a aVar) {
        this.f3307e.removeOnTrimMemoryListener(aVar);
    }
}
