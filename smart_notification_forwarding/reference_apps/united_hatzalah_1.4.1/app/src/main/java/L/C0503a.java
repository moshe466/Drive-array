package l;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: l.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0503a implements D.a {

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f5339a;

    /* renamed from: b, reason: collision with root package name */
    public CharSequence f5340b;

    /* renamed from: c, reason: collision with root package name */
    public Intent f5341c;

    /* renamed from: d, reason: collision with root package name */
    public char f5342d;

    /* renamed from: e, reason: collision with root package name */
    public int f5343e;

    /* renamed from: f, reason: collision with root package name */
    public char f5344f;

    /* renamed from: g, reason: collision with root package name */
    public int f5345g;

    /* renamed from: h, reason: collision with root package name */
    public Drawable f5346h;
    public Context i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f5347j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f5348k;

    /* renamed from: l, reason: collision with root package name */
    public ColorStateList f5349l;

    /* renamed from: m, reason: collision with root package name */
    public PorterDuff.Mode f5350m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f5351n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f5352o;
    public int p;

    @Override // D.a
    public final D.a a(p pVar) {
        throw new UnsupportedOperationException();
    }

    @Override // D.a
    public final p b() {
        return null;
    }

    public final void c() {
        Drawable drawable = this.f5346h;
        if (drawable != null) {
            if (this.f5351n || this.f5352o) {
                this.f5346h = drawable;
                Drawable mutate = drawable.mutate();
                this.f5346h = mutate;
                if (this.f5351n) {
                    mutate.setTintList(this.f5349l);
                }
                if (this.f5352o) {
                    this.f5346h.setTintMode(this.f5350m);
                }
            }
        }
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        return null;
    }

    @Override // D.a, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f5345g;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f5344f;
    }

    @Override // D.a, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f5347j;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return this.f5346h;
    }

    @Override // D.a, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f5349l;
    }

    @Override // D.a, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f5350m;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f5341c;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return R.id.home;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // D.a, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f5343e;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f5342d;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f5339a;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f5340b;
        if (charSequence != null) {
            return charSequence;
        }
        return this.f5339a;
    }

    @Override // D.a, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f5348k;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        if ((this.p & 1) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        if ((this.p & 2) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        if ((this.p & 16) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        if ((this.p & 8) == 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c4) {
        this.f5344f = Character.toLowerCase(c4);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z3) {
        this.p = (z3 ? 1 : 0) | (this.p & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z3) {
        int i;
        int i3 = this.p & (-3);
        if (z3) {
            i = 2;
        } else {
            i = 0;
        }
        this.p = i | i3;
        return this;
    }

    @Override // D.a, android.view.MenuItem
    public final D.a setContentDescription(CharSequence charSequence) {
        this.f5347j = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z3) {
        int i;
        int i3 = this.p & (-17);
        if (z3) {
            i = 16;
        } else {
            i = 0;
        }
        this.p = i | i3;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f5346h = drawable;
        c();
        return this;
    }

    @Override // D.a, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f5349l = colorStateList;
        this.f5351n = true;
        c();
        return this;
    }

    @Override // D.a, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f5350m = mode;
        this.f5352o = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f5341c = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c4) {
        this.f5342d = c4;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c4, char c5) {
        this.f5342d = c4;
        this.f5344f = Character.toLowerCase(c5);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f5339a = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f5340b = charSequence;
        return this;
    }

    @Override // D.a, android.view.MenuItem
    public final D.a setTooltipText(CharSequence charSequence) {
        this.f5348k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z3) {
        int i = 8;
        int i3 = this.p & 8;
        if (z3) {
            i = 0;
        }
        this.p = i3 | i;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // D.a, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c4, int i) {
        this.f5344f = Character.toLowerCase(c4);
        this.f5345g = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f5347j = charSequence;
        return this;
    }

    @Override // D.a, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c4, int i) {
        this.f5342d = c4;
        this.f5343e = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i) {
        this.f5339a = this.i.getResources().getString(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.f5348k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i) {
        this.f5346h = this.i.getDrawable(i);
        c();
        return this;
    }

    @Override // D.a, android.view.MenuItem
    public final MenuItem setShortcut(char c4, char c5, int i, int i3) {
        this.f5342d = c4;
        this.f5343e = KeyEvent.normalizeMetaState(i);
        this.f5344f = Character.toLowerCase(c5);
        this.f5345g = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i) {
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i) {
        return this;
    }
}
