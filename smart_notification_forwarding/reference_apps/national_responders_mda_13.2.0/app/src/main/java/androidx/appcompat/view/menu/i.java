package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.n;
import androidx.core.view.b;

/* loaded from: classes.dex */
public final class i implements u.b {
    private View A;
    private androidx.core.view.b B;
    private MenuItem.OnActionExpandListener C;
    private ContextMenu.ContextMenuInfo E;

    /* renamed from: a, reason: collision with root package name */
    private final int f954a;

    /* renamed from: b, reason: collision with root package name */
    private final int f955b;

    /* renamed from: c, reason: collision with root package name */
    private final int f956c;

    /* renamed from: d, reason: collision with root package name */
    private final int f957d;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f958e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f959f;

    /* renamed from: g, reason: collision with root package name */
    private Intent f960g;

    /* renamed from: h, reason: collision with root package name */
    private char f961h;

    /* renamed from: j, reason: collision with root package name */
    private char f963j;

    /* renamed from: l, reason: collision with root package name */
    private Drawable f965l;

    /* renamed from: n, reason: collision with root package name */
    g f967n;

    /* renamed from: o, reason: collision with root package name */
    private r f968o;

    /* renamed from: p, reason: collision with root package name */
    private Runnable f969p;

    /* renamed from: q, reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f970q;

    /* renamed from: r, reason: collision with root package name */
    private CharSequence f971r;

    /* renamed from: s, reason: collision with root package name */
    private CharSequence f972s;

    /* renamed from: z, reason: collision with root package name */
    private int f979z;

    /* renamed from: i, reason: collision with root package name */
    private int f962i = 4096;

    /* renamed from: k, reason: collision with root package name */
    private int f964k = 4096;

    /* renamed from: m, reason: collision with root package name */
    private int f966m = 0;

    /* renamed from: t, reason: collision with root package name */
    private ColorStateList f973t = null;

    /* renamed from: u, reason: collision with root package name */
    private PorterDuff.Mode f974u = null;

    /* renamed from: v, reason: collision with root package name */
    private boolean f975v = false;

    /* renamed from: w, reason: collision with root package name */
    private boolean f976w = false;

    /* renamed from: x, reason: collision with root package name */
    private boolean f977x = false;

    /* renamed from: y, reason: collision with root package name */
    private int f978y = 16;
    private boolean D = false;

    /* loaded from: classes.dex */
    class a implements b.InterfaceC0041b {
        a() {
        }

        @Override // androidx.core.view.b.InterfaceC0041b
        public void onActionProviderVisibilityChanged(boolean z10) {
            i iVar = i.this;
            iVar.f967n.J(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, int i10, int i11, int i12, int i13, CharSequence charSequence, int i14) {
        this.f979z = 0;
        this.f967n = gVar;
        this.f954a = i11;
        this.f955b = i10;
        this.f956c = i12;
        this.f957d = i13;
        this.f958e = charSequence;
        this.f979z = i14;
    }

    private static void d(StringBuilder sb2, int i10, int i11, String str) {
        if ((i10 & i11) == i11) {
            sb2.append(str);
        }
    }

    private Drawable e(Drawable drawable) {
        if (drawable != null && this.f977x && (this.f975v || this.f976w)) {
            drawable = androidx.core.graphics.drawable.a.q(drawable).mutate();
            if (this.f975v) {
                androidx.core.graphics.drawable.a.o(drawable, this.f973t);
            }
            if (this.f976w) {
                androidx.core.graphics.drawable.a.p(drawable, this.f974u);
            }
            this.f977x = false;
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean A() {
        return this.f967n.H() && g() != 0;
    }

    public boolean B() {
        return (this.f979z & 4) == 4;
    }

    @Override // u.b
    public u.b a(androidx.core.view.b bVar) {
        androidx.core.view.b bVar2 = this.B;
        if (bVar2 != null) {
            bVar2.h();
        }
        this.A = null;
        this.B = bVar;
        this.f967n.K(true);
        androidx.core.view.b bVar3 = this.B;
        if (bVar3 != null) {
            bVar3.j(new a());
        }
        return this;
    }

    @Override // u.b
    public androidx.core.view.b b() {
        return this.B;
    }

    public void c() {
        this.f967n.I(this);
    }

    @Override // u.b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f979z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f967n.f(this);
        }
        return false;
    }

    @Override // u.b, android.view.MenuItem
    public boolean expandActionView() {
        if (!j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f967n.k(this);
        }
        return false;
    }

    public int f() {
        return this.f957d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char g() {
        return this.f967n.G() ? this.f963j : this.f961h;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // u.b, android.view.MenuItem
    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        androidx.core.view.b bVar = this.B;
        if (bVar == null) {
            return null;
        }
        View d10 = bVar.d(this);
        this.A = d10;
        return d10;
    }

    @Override // u.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f964k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f963j;
    }

    @Override // u.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f971r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f955b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f965l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.f966m == 0) {
            return null;
        }
        Drawable b10 = f.a.b(this.f967n.u(), this.f966m);
        this.f966m = 0;
        this.f965l = b10;
        return e(b10);
    }

    @Override // u.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f973t;
    }

    @Override // u.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f974u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f960g;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f954a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    @Override // u.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f962i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f961h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f956c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f968o;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f958e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f959f;
        if (charSequence == null) {
            charSequence = this.f958e;
        }
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    @Override // u.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f972s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h() {
        int i10;
        char g10 = g();
        if (g10 == 0) {
            return "";
        }
        Resources resources = this.f967n.u().getResources();
        StringBuilder sb2 = new StringBuilder();
        if (ViewConfiguration.get(this.f967n.u()).hasPermanentMenuKey()) {
            sb2.append(resources.getString(e.h.f8986k));
        }
        int i11 = this.f967n.G() ? this.f964k : this.f962i;
        d(sb2, i11, 65536, resources.getString(e.h.f8982g));
        d(sb2, i11, 4096, resources.getString(e.h.f8978c));
        d(sb2, i11, 2, resources.getString(e.h.f8977b));
        d(sb2, i11, 1, resources.getString(e.h.f8983h));
        d(sb2, i11, 4, resources.getString(e.h.f8985j));
        d(sb2, i11, 8, resources.getString(e.h.f8981f));
        if (g10 == '\b') {
            i10 = e.h.f8979d;
        } else if (g10 == '\n') {
            i10 = e.h.f8980e;
        } else {
            if (g10 != ' ') {
                sb2.append(g10);
                return sb2.toString();
            }
            i10 = e.h.f8984i;
        }
        sb2.append(resources.getString(i10));
        return sb2.toString();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f968o != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence i(n.a aVar) {
        return (aVar == null || !aVar.d()) ? getTitle() : getTitleCondensed();
    }

    @Override // u.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f978y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f978y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f978y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        androidx.core.view.b bVar = this.B;
        return (bVar == null || !bVar.g()) ? (this.f978y & 8) == 0 : (this.f978y & 8) == 0 && this.B.b();
    }

    public boolean j() {
        androidx.core.view.b bVar;
        if ((this.f979z & 8) == 0) {
            return false;
        }
        if (this.A == null && (bVar = this.B) != null) {
            this.A = bVar.d(this);
        }
        return this.A != null;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f970q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        g gVar = this.f967n;
        if (gVar.h(gVar, this)) {
            return true;
        }
        Runnable runnable = this.f969p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f960g != null) {
            try {
                this.f967n.u().startActivity(this.f960g);
                return true;
            } catch (ActivityNotFoundException unused) {
            }
        }
        androidx.core.view.b bVar = this.B;
        return bVar != null && bVar.e();
    }

    public boolean l() {
        return (this.f978y & 32) == 32;
    }

    public boolean m() {
        return (this.f978y & 4) != 0;
    }

    public boolean n() {
        return (this.f979z & 1) == 1;
    }

    public boolean o() {
        return (this.f979z & 2) == 2;
    }

    @Override // u.b, android.view.MenuItem
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public u.b setActionView(int i10) {
        Context u10 = this.f967n.u();
        setActionView(LayoutInflater.from(u10).inflate(i10, (ViewGroup) new LinearLayout(u10), false));
        return this;
    }

    @Override // u.b, android.view.MenuItem
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public u.b setActionView(View view) {
        int i10;
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && (i10 = this.f954a) > 0) {
            view.setId(i10);
        }
        this.f967n.I(this);
        return this;
    }

    public void r(boolean z10) {
        this.D = z10;
        this.f967n.K(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(boolean z10) {
        int i10 = this.f978y;
        int i11 = (z10 ? 2 : 0) | (i10 & (-3));
        this.f978y = i11;
        if (i10 != i11) {
            this.f967n.K(false);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10) {
        if (this.f963j == c10) {
            return this;
        }
        this.f963j = Character.toLowerCase(c10);
        this.f967n.K(false);
        return this;
    }

    @Override // u.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        if (this.f963j == c10 && this.f964k == i10) {
            return this;
        }
        this.f963j = Character.toLowerCase(c10);
        this.f964k = KeyEvent.normalizeMetaState(i10);
        this.f967n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        int i10 = this.f978y;
        int i11 = (z10 ? 1 : 0) | (i10 & (-2));
        this.f978y = i11;
        if (i10 != i11) {
            this.f967n.K(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        if ((this.f978y & 4) != 0) {
            this.f967n.T(this);
        } else {
            s(z10);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public u.b setContentDescription(CharSequence charSequence) {
        this.f971r = charSequence;
        this.f967n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        this.f978y = z10 ? this.f978y | 16 : this.f978y & (-17);
        this.f967n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i10) {
        this.f965l = null;
        this.f966m = i10;
        this.f977x = true;
        this.f967n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f966m = 0;
        this.f965l = drawable;
        this.f977x = true;
        this.f967n.K(false);
        return this;
    }

    @Override // u.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f973t = colorStateList;
        this.f975v = true;
        this.f977x = true;
        this.f967n.K(false);
        return this;
    }

    @Override // u.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f974u = mode;
        this.f976w = true;
        this.f977x = true;
        this.f967n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f960g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10) {
        if (this.f961h == c10) {
            return this;
        }
        this.f961h = c10;
        this.f967n.K(false);
        return this;
    }

    @Override // u.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c10, int i10) {
        if (this.f961h == c10 && this.f962i == i10) {
            return this;
        }
        this.f961h = c10;
        this.f962i = KeyEvent.normalizeMetaState(i10);
        this.f967n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f970q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11) {
        this.f961h = c10;
        this.f963j = Character.toLowerCase(c11);
        this.f967n.K(false);
        return this;
    }

    @Override // u.b, android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f961h = c10;
        this.f962i = KeyEvent.normalizeMetaState(i10);
        this.f963j = Character.toLowerCase(c11);
        this.f964k = KeyEvent.normalizeMetaState(i11);
        this.f967n.K(false);
        return this;
    }

    @Override // u.b, android.view.MenuItem
    public void setShowAsAction(int i10) {
        int i11 = i10 & 3;
        if (i11 != 0 && i11 != 1 && i11 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f979z = i10;
        this.f967n.I(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i10) {
        return setTitle(this.f967n.u().getString(i10));
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f958e = charSequence;
        this.f967n.K(false);
        r rVar = this.f968o;
        if (rVar != null) {
            rVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f959f = charSequence;
        this.f967n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public u.b setTooltipText(CharSequence charSequence) {
        this.f972s = charSequence;
        this.f967n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        if (y(z10)) {
            this.f967n.J(this);
        }
        return this;
    }

    public void t(boolean z10) {
        this.f978y = (z10 ? 4 : 0) | (this.f978y & (-5));
    }

    public String toString() {
        CharSequence charSequence = this.f958e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(boolean z10) {
        this.f978y = z10 ? this.f978y | 32 : this.f978y & (-33);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    @Override // u.b, android.view.MenuItem
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public u.b setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    public void x(r rVar) {
        this.f968o = rVar;
        rVar.setHeaderTitle(getTitle());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean y(boolean z10) {
        int i10 = this.f978y;
        int i11 = (z10 ? 0 : 8) | (i10 & (-9));
        this.f978y = i11;
        return i10 != i11;
    }

    public boolean z() {
        return this.f967n.A();
    }
}
