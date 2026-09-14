package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    final Context f874a;

    /* renamed from: b, reason: collision with root package name */
    private l.g<u.b, MenuItem> f875b;

    /* renamed from: c, reason: collision with root package name */
    private l.g<u.c, SubMenu> f876c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.f874a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof u.b)) {
            return menuItem;
        }
        u.b bVar = (u.b) menuItem;
        if (this.f875b == null) {
            this.f875b = new l.g<>();
        }
        MenuItem menuItem2 = this.f875b.get(bVar);
        if (menuItem2 != null) {
            return menuItem2;
        }
        j jVar = new j(this.f874a, bVar);
        this.f875b.put(bVar, jVar);
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof u.c)) {
            return subMenu;
        }
        u.c cVar = (u.c) subMenu;
        if (this.f876c == null) {
            this.f876c = new l.g<>();
        }
        SubMenu subMenu2 = this.f876c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        s sVar = new s(this.f874a, cVar);
        this.f876c.put(cVar, sVar);
        return sVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        l.g<u.b, MenuItem> gVar = this.f875b;
        if (gVar != null) {
            gVar.clear();
        }
        l.g<u.c, SubMenu> gVar2 = this.f876c;
        if (gVar2 != null) {
            gVar2.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(int i10) {
        if (this.f875b == null) {
            return;
        }
        int i11 = 0;
        while (i11 < this.f875b.size()) {
            if (this.f875b.i(i11).getGroupId() == i10) {
                this.f875b.k(i11);
                i11--;
            }
            i11++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g(int i10) {
        if (this.f875b == null) {
            return;
        }
        for (int i11 = 0; i11 < this.f875b.size(); i11++) {
            if (this.f875b.i(i11).getItemId() == i10) {
                this.f875b.k(i11);
                return;
            }
        }
    }
}
