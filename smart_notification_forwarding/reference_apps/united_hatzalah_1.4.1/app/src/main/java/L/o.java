package l;

import F0.C0047j2;
import a.AbstractC0228a;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class o implements D.a {

    /* renamed from: A, reason: collision with root package name */
    public p f5425A;

    /* renamed from: B, reason: collision with root package name */
    public MenuItem.OnActionExpandListener f5426B;

    /* renamed from: a, reason: collision with root package name */
    public final int f5428a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5429b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5430c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5431d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f5432e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f5433f;

    /* renamed from: g, reason: collision with root package name */
    public Intent f5434g;

    /* renamed from: h, reason: collision with root package name */
    public char f5435h;

    /* renamed from: j, reason: collision with root package name */
    public char f5436j;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f5438l;

    /* renamed from: n, reason: collision with root package name */
    public final m f5440n;

    /* renamed from: o, reason: collision with root package name */
    public SubMenuC0502F f5441o;
    public MenuItem.OnMenuItemClickListener p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f5442q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f5443r;
    public int y;

    /* renamed from: z, reason: collision with root package name */
    public View f5450z;
    public int i = 4096;

    /* renamed from: k, reason: collision with root package name */
    public int f5437k = 4096;

    /* renamed from: m, reason: collision with root package name */
    public int f5439m = 0;

    /* renamed from: s, reason: collision with root package name */
    public ColorStateList f5444s = null;

    /* renamed from: t, reason: collision with root package name */
    public PorterDuff.Mode f5445t = null;

    /* renamed from: u, reason: collision with root package name */
    public boolean f5446u = false;

    /* renamed from: v, reason: collision with root package name */
    public boolean f5447v = false;

    /* renamed from: w, reason: collision with root package name */
    public boolean f5448w = false;

    /* renamed from: x, reason: collision with root package name */
    public int f5449x = 16;

    /* renamed from: C, reason: collision with root package name */
    public boolean f5427C = false;

    public o(m mVar, int i, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        this.f5440n = mVar;
        this.f5428a = i3;
        this.f5429b = i;
        this.f5430c = i4;
        this.f5431d = i5;
        this.f5432e = charSequence;
        this.y = i6;
    }

    public static void c(StringBuilder sb, int i, int i3, String str) {
        if ((i & i3) == i3) {
            sb.append(str);
        }
    }

    @Override // D.a
    public final D.a a(p pVar) {
        this.f5450z = null;
        this.f5425A = pVar;
        this.f5440n.p(true);
        p pVar2 = this.f5425A;
        if (pVar2 != null) {
            pVar2.f5452b = new C0047j2(this, 18);
            pVar2.f5451a.setVisibilityListener(pVar2);
        }
        return this;
    }

    @Override // D.a
    public final p b() {
        return this.f5425A;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.y & 8) == 0) {
            return false;
        }
        if (this.f5450z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f5426B;
        if (onActionExpandListener != null && !onActionExpandListener.onMenuItemActionCollapse(this)) {
            return false;
        }
        return this.f5440n.d(this);
    }

    public final Drawable d(Drawable drawable) {
        if (drawable != null && this.f5448w && (this.f5446u || this.f5447v)) {
            drawable = drawable.mutate();
            if (this.f5446u) {
                drawable.setTintList(this.f5444s);
            }
            if (this.f5447v) {
                drawable.setTintMode(this.f5445t);
            }
            this.f5448w = false;
        }
        return drawable;
    }

    public final boolean e() {
        p pVar;
        if ((this.y & 8) != 0) {
            if (this.f5450z == null && (pVar = this.f5425A) != null) {
                this.f5450z = pVar.a(this);
            }
            if (this.f5450z != null) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        if (e()) {
            MenuItem.OnActionExpandListener onActionExpandListener = this.f5426B;
            if (onActionExpandListener != null && !onActionExpandListener.onMenuItemActionExpand(this)) {
                return false;
            }
            return this.f5440n.f(this);
        }
        return false;
    }

    public final void f(boolean z3) {
        if (z3) {
            this.f5449x |= 32;
        } else {
            this.f5449x &= -33;
        }
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View view = this.f5450z;
        if (view != null) {
            return view;
        }
        p pVar = this.f5425A;
        if (pVar != null) {
            View a2 = pVar.a(this);
            this.f5450z = a2;
            return a2;
        }
        return null;
    }

    @Override // D.a, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f5437k;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f5436j;
    }

    @Override // D.a, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f5442q;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f5429b;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.f5438l;
        if (drawable != null) {
            return d(drawable);
        }
        int i = this.f5439m;
        if (i != 0) {
            Drawable q3 = AbstractC0228a.q(this.f5440n.f5400a, i);
            this.f5439m = 0;
            this.f5438l = q3;
            return d(q3);
        }
        return null;
    }

    @Override // D.a, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f5444s;
    }

    @Override // D.a, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f5445t;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f5434g;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.f5428a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // D.a, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.i;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f5435h;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f5430c;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.f5441o;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f5432e;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f5433f;
        if (charSequence == null) {
            return this.f5432e;
        }
        return charSequence;
    }

    @Override // D.a, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f5443r;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        if (this.f5441o != null) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.f5427C;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        if ((this.f5449x & 1) == 1) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        if ((this.f5449x & 2) == 2) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        if ((this.f5449x & 16) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        p pVar = this.f5425A;
        if (pVar != null && pVar.f5451a.overridesItemVisibility()) {
            if ((this.f5449x & 8) == 0 && this.f5425A.f5451a.isVisible()) {
                return true;
            }
            return false;
        }
        if ((this.f5449x & 8) == 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        int i;
        this.f5450z = view;
        this.f5425A = null;
        if (view != null && view.getId() == -1 && (i = this.f5428a) > 0) {
            view.setId(i);
        }
        m mVar = this.f5440n;
        mVar.f5409k = true;
        mVar.p(true);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c4) {
        if (this.f5436j == c4) {
            return this;
        }
        this.f5436j = Character.toLowerCase(c4);
        this.f5440n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z3) {
        int i = this.f5449x;
        int i3 = (z3 ? 1 : 0) | (i & (-2));
        this.f5449x = i3;
        if (i != i3) {
            this.f5440n.p(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z3) {
        boolean z4;
        int i;
        int i3 = this.f5449x;
        int i4 = 2;
        if ((i3 & 4) != 0) {
            m mVar = this.f5440n;
            ArrayList arrayList = mVar.f5405f;
            int size = arrayList.size();
            mVar.w();
            for (int i5 = 0; i5 < size; i5++) {
                o oVar = (o) arrayList.get(i5);
                if (oVar.f5429b == this.f5429b && (oVar.f5449x & 4) != 0 && oVar.isCheckable()) {
                    if (oVar == this) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    int i6 = oVar.f5449x;
                    int i7 = i6 & (-3);
                    if (z4) {
                        i = 2;
                    } else {
                        i = 0;
                    }
                    int i8 = i | i7;
                    oVar.f5449x = i8;
                    if (i6 != i8) {
                        oVar.f5440n.p(false);
                    }
                }
            }
            mVar.v();
            return this;
        }
        int i9 = i3 & (-3);
        if (!z3) {
            i4 = 0;
        }
        int i10 = i9 | i4;
        this.f5449x = i10;
        if (i3 != i10) {
            this.f5440n.p(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z3) {
        if (z3) {
            this.f5449x |= 16;
        } else {
            this.f5449x &= -17;
        }
        this.f5440n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f5439m = 0;
        this.f5438l = drawable;
        this.f5448w = true;
        this.f5440n.p(false);
        return this;
    }

    @Override // D.a, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f5444s = colorStateList;
        this.f5446u = true;
        this.f5448w = true;
        this.f5440n.p(false);
        return this;
    }

    @Override // D.a, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f5445t = mode;
        this.f5447v = true;
        this.f5448w = true;
        this.f5440n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f5434g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c4) {
        if (this.f5435h == c4) {
            return this;
        }
        this.f5435h = c4;
        this.f5440n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f5426B = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.p = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c4, char c5) {
        this.f5435h = c4;
        this.f5436j = Character.toLowerCase(c5);
        this.f5440n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i) {
        int i3 = i & 3;
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.y = i;
        m mVar = this.f5440n;
        mVar.f5409k = true;
        mVar.p(true);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f5432e = charSequence;
        this.f5440n.p(false);
        SubMenuC0502F subMenuC0502F = this.f5441o;
        if (subMenuC0502F != null) {
            subMenuC0502F.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f5433f = charSequence;
        this.f5440n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z3) {
        int i;
        int i3 = this.f5449x;
        int i4 = i3 & (-9);
        if (z3) {
            i = 0;
        } else {
            i = 8;
        }
        int i5 = i | i4;
        this.f5449x = i5;
        if (i3 != i5) {
            m mVar = this.f5440n;
            mVar.f5407h = true;
            mVar.p(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.f5432e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // D.a, android.view.MenuItem
    public final D.a setContentDescription(CharSequence charSequence) {
        this.f5442q = charSequence;
        this.f5440n.p(false);
        return this;
    }

    @Override // D.a, android.view.MenuItem
    public final D.a setTooltipText(CharSequence charSequence) {
        this.f5443r = charSequence;
        this.f5440n.p(false);
        return this;
    }

    @Override // D.a, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c4, int i) {
        if (this.f5436j == c4 && this.f5437k == i) {
            return this;
        }
        this.f5436j = Character.toLowerCase(c4);
        this.f5437k = KeyEvent.normalizeMetaState(i);
        this.f5440n.p(false);
        return this;
    }

    @Override // D.a, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c4, int i) {
        if (this.f5435h == c4 && this.i == i) {
            return this;
        }
        this.f5435h = c4;
        this.i = KeyEvent.normalizeMetaState(i);
        this.f5440n.p(false);
        return this;
    }

    @Override // D.a, android.view.MenuItem
    public final MenuItem setShortcut(char c4, char c5, int i, int i3) {
        this.f5435h = c4;
        this.i = KeyEvent.normalizeMetaState(i);
        this.f5436j = Character.toLowerCase(c5);
        this.f5437k = KeyEvent.normalizeMetaState(i3);
        this.f5440n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i) {
        this.f5438l = null;
        this.f5439m = i;
        this.f5448w = true;
        this.f5440n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i) {
        setTitle(this.f5440n.f5400a.getString(i));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i) {
        int i3;
        Context context = this.f5440n.f5400a;
        View inflate = LayoutInflater.from(context).inflate(i, (ViewGroup) new LinearLayout(context), false);
        this.f5450z = inflate;
        this.f5425A = null;
        if (inflate != null && inflate.getId() == -1 && (i3 = this.f5428a) > 0) {
            inflate.setId(i3);
        }
        m mVar = this.f5440n;
        mVar.f5409k = true;
        mVar.p(true);
        return this;
    }
}
