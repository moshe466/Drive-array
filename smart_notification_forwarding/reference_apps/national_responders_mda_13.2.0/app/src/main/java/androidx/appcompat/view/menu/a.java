package androidx.appcompat.view.menu;

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

/* loaded from: classes.dex */
public class a implements u.b {

    /* renamed from: a, reason: collision with root package name */
    private final int f847a;

    /* renamed from: b, reason: collision with root package name */
    private final int f848b;

    /* renamed from: c, reason: collision with root package name */
    private final int f849c;

    /* renamed from: d, reason: collision with root package name */
    private CharSequence f850d;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f851e;

    /* renamed from: f, reason: collision with root package name */
    private Intent f852f;

    /* renamed from: g, reason: collision with root package name */
    private char f853g;

    /* renamed from: i, reason: collision with root package name */
    private char f855i;

    /* renamed from: k, reason: collision with root package name */
    private Drawable f857k;

    /* renamed from: l, reason: collision with root package name */
    private Context f858l;

    /* renamed from: m, reason: collision with root package name */
    private CharSequence f859m;

    /* renamed from: n, reason: collision with root package name */
    private CharSequence f860n;

    /* renamed from: h, reason: collision with root package name */
    private int f854h = 4096;

    /* renamed from: j, reason: collision with root package name */
    private int f856j = 4096;

    /* renamed from: o, reason: collision with root package name */
    private ColorStateList f861o = null;

    /* renamed from: p, reason: collision with root package name */
    private PorterDuff.Mode f862p = null;

    /* renamed from: q, reason: collision with root package name */
    private boolean f863q = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f864r = false;

    /* renamed from: s, reason: collision with root package name */
    private int f865s = 16;

    public a(Context context, int i10, int i11, int i12, int i13, CharSequence charSequence) {
        this.f858l = context;
        this.f847a = i11;
        this.f848b = i10;
        this.f849c = i13;
        this.f850d = charSequence;
    }

    private void c() {
        Drawable drawable = this.f857k;
        if (drawable != null) {
            if (this.f863q || this.f864r) {
                Drawable q10 = androidx.core.graphics.drawable.a.q(drawable);
                this.f857k = q10;
                Drawable mutate = q10.mutate();
                this.f857k = mutate;
                if (this.f863q) {
                    androidx.core.graphics.drawable.a.o(mutate, this.f861o);
                }
                if (this.f864r) {
                    androidx.core.graphics.drawable.a.p(this.f857k, this.f862p);
                }
            }
        }
    }

    @Override // u.b
    public u.b a(androidx.core.view.b bVar) {
        throw new UnsupportedOperationException();
    }

    @Override // u.b
    public androidx.core.view.b b() {
        return null;
    }

    @Override // u.b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // u.b, android.view.MenuItem
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public u.b setActionView(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // u.b, android.view.MenuItem
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public u.b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // u.b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // u.b, android.view.MenuItem
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public u.b setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // u.b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // u.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f856j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f855i;
    }

    @Override // u.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f859m;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f848b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f857k;
    }

    @Override // u.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f861o;
    }

    @Override // u.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f862p;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f852f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f847a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // u.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f854h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f853g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f849c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f850d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f851e;
        return charSequence != null ? charSequence : this.f850d;
    }

    @Override // u.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f860n;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // u.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f865s & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f865s & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f865s & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f865s & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10) {
        this.f855i = Character.toLowerCase(c10);
        return this;
    }

    @Override // u.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        this.f855i = Character.toLowerCase(c10);
        this.f856j = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        this.f865s = (z10 ? 1 : 0) | (this.f865s & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        this.f865s = (z10 ? 2 : 0) | (this.f865s & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public u.b setContentDescription(CharSequence charSequence) {
        this.f859m = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        this.f865s = (z10 ? 16 : 0) | (this.f865s & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i10) {
        this.f857k = androidx.core.content.a.f(this.f858l, i10);
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f857k = drawable;
        c();
        return this;
    }

    @Override // u.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f861o = colorStateList;
        this.f863q = true;
        c();
        return this;
    }

    @Override // u.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f862p = mode;
        this.f864r = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f852f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10) {
        this.f853g = c10;
        return this;
    }

    @Override // u.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c10, int i10) {
        this.f853g = c10;
        this.f854h = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11) {
        this.f853g = c10;
        this.f855i = Character.toLowerCase(c11);
        return this;
    }

    @Override // u.b, android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f853g = c10;
        this.f854h = KeyEvent.normalizeMetaState(i10);
        this.f855i = Character.toLowerCase(c11);
        this.f856j = KeyEvent.normalizeMetaState(i11);
        return this;
    }

    @Override // u.b, android.view.MenuItem
    public void setShowAsAction(int i10) {
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i10) {
        this.f850d = this.f858l.getResources().getString(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f850d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f851e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public u.b setTooltipText(CharSequence charSequence) {
        this.f860n = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        this.f865s = (this.f865s & 8) | (z10 ? 0 : 8);
        return this;
    }
}
