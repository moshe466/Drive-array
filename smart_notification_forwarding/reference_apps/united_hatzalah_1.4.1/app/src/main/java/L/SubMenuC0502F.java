package l;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: l.F, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class SubMenuC0502F extends m implements SubMenu {

    /* renamed from: A, reason: collision with root package name */
    public final m f5337A;

    /* renamed from: B, reason: collision with root package name */
    public final o f5338B;

    public SubMenuC0502F(Context context, m mVar, o oVar) {
        super(context);
        this.f5337A = mVar;
        this.f5338B = oVar;
    }

    @Override // l.m
    public final boolean d(o oVar) {
        return this.f5337A.d(oVar);
    }

    @Override // l.m
    public final boolean e(m mVar, MenuItem menuItem) {
        if (!super.e(mVar, menuItem) && !this.f5337A.e(mVar, menuItem)) {
            return false;
        }
        return true;
    }

    @Override // l.m
    public final boolean f(o oVar) {
        return this.f5337A.f(oVar);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.f5338B;
    }

    @Override // l.m
    public final String j() {
        int i;
        o oVar = this.f5338B;
        if (oVar != null) {
            i = oVar.f5428a;
        } else {
            i = 0;
        }
        if (i == 0) {
            return null;
        }
        return e0.a.c(i, "android:menu:actionviewstates:");
    }

    @Override // l.m
    public final m k() {
        return this.f5337A.k();
    }

    @Override // l.m
    public final boolean m() {
        return this.f5337A.m();
    }

    @Override // l.m
    public final boolean n() {
        return this.f5337A.n();
    }

    @Override // l.m
    public final boolean o() {
        return this.f5337A.o();
    }

    @Override // l.m, android.view.Menu
    public final void setGroupDividerEnabled(boolean z3) {
        this.f5337A.setGroupDividerEnabled(z3);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        u(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        u(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        u(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.f5338B.setIcon(drawable);
        return this;
    }

    @Override // l.m, android.view.Menu
    public final void setQwertyMode(boolean z3) {
        this.f5337A.setQwertyMode(z3);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i) {
        u(0, null, i, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i) {
        u(i, null, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i) {
        this.f5338B.setIcon(i);
        return this;
    }
}
