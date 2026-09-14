package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class e extends b implements g.a {

    /* renamed from: h, reason: collision with root package name */
    private Context f758h;

    /* renamed from: i, reason: collision with root package name */
    private ActionBarContextView f759i;

    /* renamed from: j, reason: collision with root package name */
    private b.a f760j;

    /* renamed from: k, reason: collision with root package name */
    private WeakReference<View> f761k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f762l;

    /* renamed from: m, reason: collision with root package name */
    private androidx.appcompat.view.menu.g f763m;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z10) {
        this.f758h = context;
        this.f759i = actionBarContextView;
        this.f760j = aVar;
        androidx.appcompat.view.menu.g S = new androidx.appcompat.view.menu.g(actionBarContextView.getContext()).S(1);
        this.f763m = S;
        S.R(this);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        return this.f760j.c(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public void b(androidx.appcompat.view.menu.g gVar) {
        k();
        this.f759i.l();
    }

    @Override // androidx.appcompat.view.b
    public void c() {
        if (this.f762l) {
            return;
        }
        this.f762l = true;
        this.f760j.b(this);
    }

    @Override // androidx.appcompat.view.b
    public View d() {
        WeakReference<View> weakReference = this.f761k;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // androidx.appcompat.view.b
    public Menu e() {
        return this.f763m;
    }

    @Override // androidx.appcompat.view.b
    public MenuInflater f() {
        return new g(this.f759i.getContext());
    }

    @Override // androidx.appcompat.view.b
    public CharSequence g() {
        return this.f759i.getSubtitle();
    }

    @Override // androidx.appcompat.view.b
    public CharSequence i() {
        return this.f759i.getTitle();
    }

    @Override // androidx.appcompat.view.b
    public void k() {
        this.f760j.a(this, this.f763m);
    }

    @Override // androidx.appcompat.view.b
    public boolean l() {
        return this.f759i.j();
    }

    @Override // androidx.appcompat.view.b
    public void m(View view) {
        this.f759i.setCustomView(view);
        this.f761k = view != null ? new WeakReference<>(view) : null;
    }

    @Override // androidx.appcompat.view.b
    public void n(int i10) {
        o(this.f758h.getString(i10));
    }

    @Override // androidx.appcompat.view.b
    public void o(CharSequence charSequence) {
        this.f759i.setSubtitle(charSequence);
    }

    @Override // androidx.appcompat.view.b
    public void q(int i10) {
        r(this.f758h.getString(i10));
    }

    @Override // androidx.appcompat.view.b
    public void r(CharSequence charSequence) {
        this.f759i.setTitle(charSequence);
    }

    @Override // androidx.appcompat.view.b
    public void s(boolean z10) {
        super.s(z10);
        this.f759i.setTitleOptional(z10);
    }
}
