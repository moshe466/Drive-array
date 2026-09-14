package androidx.core.view;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private InterfaceC0041b f2548a;

    /* loaded from: classes.dex */
    public interface a {
    }

    /* renamed from: androidx.core.view.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0041b {
        void onActionProviderVisibilityChanged(boolean z10);
    }

    public b(Context context) {
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public View d(MenuItem menuItem) {
        return c();
    }

    public boolean e() {
        return false;
    }

    public void f(SubMenu subMenu) {
    }

    public boolean g() {
        return false;
    }

    public void h() {
        this.f2548a = null;
    }

    public void i(a aVar) {
    }

    public void j(InterfaceC0041b interfaceC0041b) {
        if (this.f2548a != null && interfaceC0041b != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
            sb2.append(getClass().getSimpleName());
            sb2.append(" instance while it is still in use somewhere else?");
        }
        this.f2548a = interfaceC0041b;
    }
}
