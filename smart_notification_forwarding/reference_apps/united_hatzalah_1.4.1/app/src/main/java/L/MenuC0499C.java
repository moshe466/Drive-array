package l;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import t.C0694j;

/* renamed from: l.C, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class MenuC0499C extends M1.f implements Menu {

    /* renamed from: c, reason: collision with root package name */
    public final m f5318c;

    public MenuC0499C(Context context, m mVar) {
        super(context);
        if (mVar != null) {
            this.f5318c = mVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return h(this.f5318c.a(0, 0, 0, charSequence));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2;
        if (menuItemArr != null) {
            menuItemArr2 = new MenuItem[menuItemArr.length];
        } else {
            menuItemArr2 = null;
        }
        MenuItem[] menuItemArr3 = menuItemArr2;
        int addIntentOptions = this.f5318c.addIntentOptions(i, i3, i4, componentName, intentArr, intent, i5, menuItemArr3);
        if (menuItemArr3 != null) {
            int length = menuItemArr3.length;
            for (int i6 = 0; i6 < length; i6++) {
                menuItemArr[i6] = h(menuItemArr3[i6]);
            }
        }
        return addIntentOptions;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return this.f5318c.addSubMenu(charSequence);
    }

    @Override // android.view.Menu
    public final void clear() {
        C0694j c0694j = (C0694j) this.f1406b;
        if (c0694j != null) {
            c0694j.clear();
        }
        this.f5318c.clear();
    }

    @Override // android.view.Menu
    public final void close() {
        this.f5318c.close();
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i) {
        return h(this.f5318c.findItem(i));
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i) {
        return h(this.f5318c.getItem(i));
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        return this.f5318c.hasVisibleItems();
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return this.f5318c.isShortcutKey(i, keyEvent);
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i, int i3) {
        return this.f5318c.performIdentifierAction(i, i3);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i, KeyEvent keyEvent, int i3) {
        return this.f5318c.performShortcut(i, keyEvent, i3);
    }

    @Override // android.view.Menu
    public final void removeGroup(int i) {
        if (((C0694j) this.f1406b) != null) {
            int i3 = 0;
            while (true) {
                C0694j c0694j = (C0694j) this.f1406b;
                if (i3 >= c0694j.f6366c) {
                    break;
                }
                if (((D.a) c0694j.f(i3)).getGroupId() == i) {
                    ((C0694j) this.f1406b).g(i3);
                    i3--;
                }
                i3++;
            }
        }
        this.f5318c.removeGroup(i);
    }

    @Override // android.view.Menu
    public final void removeItem(int i) {
        if (((C0694j) this.f1406b) != null) {
            int i3 = 0;
            while (true) {
                C0694j c0694j = (C0694j) this.f1406b;
                if (i3 >= c0694j.f6366c) {
                    break;
                }
                if (((D.a) c0694j.f(i3)).getItemId() == i) {
                    ((C0694j) this.f1406b).g(i3);
                    break;
                }
                i3++;
            }
        }
        this.f5318c.removeItem(i);
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i, boolean z3, boolean z4) {
        this.f5318c.setGroupCheckable(i, z3, z4);
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i, boolean z3) {
        this.f5318c.setGroupEnabled(i, z3);
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i, boolean z3) {
        this.f5318c.setGroupVisible(i, z3);
    }

    @Override // android.view.Menu
    public final void setQwertyMode(boolean z3) {
        this.f5318c.setQwertyMode(z3);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f5318c.size();
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i) {
        return this.f5318c.addSubMenu(i);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i3, int i4, CharSequence charSequence) {
        return this.f5318c.addSubMenu(i, i3, i4, charSequence);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i) {
        return h(this.f5318c.add(i));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i3, int i4, int i5) {
        return this.f5318c.addSubMenu(i, i3, i4, i5);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i3, int i4, CharSequence charSequence) {
        return h(this.f5318c.a(i, i3, i4, charSequence));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i3, int i4, int i5) {
        return h(this.f5318c.add(i, i3, i4, i5));
    }
}
