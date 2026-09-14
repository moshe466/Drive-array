package h;

import F0.C0035g2;
import F0.C0047j2;
import F0.G1;
import J.S;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.Window;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.WeakHashMap;
import m.C0548i;
import m.n1;
import m.s1;

/* loaded from: classes.dex */
public final class I extends AbstractC0431a {

    /* renamed from: a, reason: collision with root package name */
    public final s1 f4734a;

    /* renamed from: b, reason: collision with root package name */
    public final Window.Callback f4735b;

    /* renamed from: c, reason: collision with root package name */
    public final C0047j2 f4736c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4737d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4738e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4739f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f4740g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final G.a f4741h = new G.a(this, 3);

    public I(Toolbar toolbar, CharSequence charSequence, u uVar) {
        G1 g12 = new G1(this, 17);
        s1 s1Var = new s1(toolbar, false);
        this.f4734a = s1Var;
        uVar.getClass();
        this.f4735b = uVar;
        s1Var.f5781k = uVar;
        toolbar.setOnMenuItemClickListener(g12);
        if (!s1Var.f5778g) {
            s1Var.f5779h = charSequence;
            if ((s1Var.f5773b & 8) != 0) {
                Toolbar toolbar2 = s1Var.f5772a;
                toolbar2.setTitle(charSequence);
                if (s1Var.f5778g) {
                    S.j(toolbar2.getRootView(), charSequence);
                }
            }
        }
        this.f4736c = new C0047j2(this, 15);
    }

    @Override // h.AbstractC0431a
    public final boolean a() {
        C0548i c0548i;
        ActionMenuView actionMenuView = this.f4734a.f5772a.f2986a;
        if (actionMenuView != null && (c0548i = actionMenuView.f2861w) != null && c0548i.g()) {
            return true;
        }
        return false;
    }

    @Override // h.AbstractC0431a
    public final boolean b() {
        l.o oVar;
        n1 n1Var = this.f4734a.f5772a.f2978P;
        if (n1Var != null && (oVar = n1Var.f5731b) != null) {
            if (n1Var == null) {
                oVar = null;
            }
            if (oVar != null) {
                oVar.collapseActionView();
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // h.AbstractC0431a
    public final void c(boolean z3) {
        if (z3 != this.f4739f) {
            this.f4739f = z3;
            ArrayList arrayList = this.f4740g;
            if (arrayList.size() <= 0) {
            } else {
                throw e0.a.b(0, arrayList);
            }
        }
    }

    @Override // h.AbstractC0431a
    public final int d() {
        return this.f4734a.f5773b;
    }

    @Override // h.AbstractC0431a
    public final Context e() {
        return this.f4734a.f5772a.getContext();
    }

    @Override // h.AbstractC0431a
    public final void f() {
        this.f4734a.f5772a.setVisibility(8);
    }

    @Override // h.AbstractC0431a
    public final boolean g() {
        s1 s1Var = this.f4734a;
        Toolbar toolbar = s1Var.f5772a;
        G.a aVar = this.f4741h;
        toolbar.removeCallbacks(aVar);
        Toolbar toolbar2 = s1Var.f5772a;
        WeakHashMap weakHashMap = S.f954a;
        toolbar2.postOnAnimation(aVar);
        return true;
    }

    @Override // h.AbstractC0431a
    public final boolean h() {
        if (this.f4734a.f5772a.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // h.AbstractC0431a
    public final void j() {
        this.f4734a.f5772a.removeCallbacks(this.f4741h);
    }

    @Override // h.AbstractC0431a
    public final boolean k(int i, KeyEvent keyEvent) {
        Menu v2 = v();
        if (v2 == null) {
            return false;
        }
        boolean z3 = true;
        if (KeyCharacterMap.load(keyEvent.getDeviceId()).getKeyboardType() == 1) {
            z3 = false;
        }
        v2.setQwertyMode(z3);
        return v2.performShortcut(i, keyEvent, 0);
    }

    @Override // h.AbstractC0431a
    public final boolean l(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            m();
        }
        return true;
    }

    @Override // h.AbstractC0431a
    public final boolean m() {
        return this.f4734a.f5772a.u();
    }

    @Override // h.AbstractC0431a
    public final void n(ColorDrawable colorDrawable) {
        Toolbar toolbar = this.f4734a.f5772a;
        WeakHashMap weakHashMap = S.f954a;
        toolbar.setBackground(colorDrawable);
    }

    @Override // h.AbstractC0431a
    public final void p(boolean z3) {
        int i;
        if (z3) {
            i = 8;
        } else {
            i = 0;
        }
        s1 s1Var = this.f4734a;
        s1Var.a((i & 8) | (s1Var.f5773b & (-9)));
    }

    @Override // h.AbstractC0431a
    public final void r(CharSequence charSequence) {
        s1 s1Var = this.f4734a;
        s1Var.f5778g = true;
        Toolbar toolbar = s1Var.f5772a;
        s1Var.f5779h = charSequence;
        if ((s1Var.f5773b & 8) != 0) {
            toolbar.setTitle(charSequence);
            if (s1Var.f5778g) {
                S.j(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // h.AbstractC0431a
    public final void s(CharSequence charSequence) {
        s1 s1Var = this.f4734a;
        if (!s1Var.f5778g) {
            Toolbar toolbar = s1Var.f5772a;
            s1Var.f5779h = charSequence;
            if ((s1Var.f5773b & 8) != 0) {
                toolbar.setTitle(charSequence);
                if (s1Var.f5778g) {
                    S.j(toolbar.getRootView(), charSequence);
                }
            }
        }
    }

    @Override // h.AbstractC0431a
    public final void t() {
        this.f4734a.f5772a.setVisibility(0);
    }

    public final Menu v() {
        boolean z3 = this.f4738e;
        s1 s1Var = this.f4734a;
        if (!z3) {
            H h2 = new H(this);
            C0035g2 c0035g2 = new C0035g2(this, 14);
            Toolbar toolbar = s1Var.f5772a;
            toolbar.f2979Q = h2;
            toolbar.f2980R = c0035g2;
            ActionMenuView actionMenuView = toolbar.f2986a;
            if (actionMenuView != null) {
                actionMenuView.f2862x = h2;
                actionMenuView.y = c0035g2;
            }
            this.f4738e = true;
        }
        return s1Var.f5772a.getMenu();
    }

    @Override // h.AbstractC0431a
    public final void i() {
    }

    @Override // h.AbstractC0431a
    public final void o(boolean z3) {
    }

    @Override // h.AbstractC0431a
    public final void q(boolean z3) {
    }
}
