package l;

import android.view.MenuItem;

/* loaded from: classes.dex */
public final class r implements MenuItem.OnActionExpandListener {

    /* renamed from: a, reason: collision with root package name */
    public final MenuItem.OnActionExpandListener f5454a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f5455b;

    public r(t tVar, MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f5455b = tVar;
        this.f5454a = onActionExpandListener;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return this.f5454a.onMenuItemActionCollapse(this.f5455b.h(menuItem));
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionExpand(MenuItem menuItem) {
        return this.f5454a.onMenuItemActionExpand(this.f5455b.h(menuItem));
    }
}
