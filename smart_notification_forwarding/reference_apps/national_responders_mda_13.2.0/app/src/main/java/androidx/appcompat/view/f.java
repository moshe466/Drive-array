package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class f extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    final Context f764a;

    /* renamed from: b, reason: collision with root package name */
    final b f765b;

    /* loaded from: classes.dex */
    public static class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final ActionMode.Callback f766a;

        /* renamed from: b, reason: collision with root package name */
        final Context f767b;

        /* renamed from: c, reason: collision with root package name */
        final ArrayList<f> f768c = new ArrayList<>();

        /* renamed from: d, reason: collision with root package name */
        final l.g<Menu, Menu> f769d = new l.g<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f767b = context;
            this.f766a = callback;
        }

        private Menu f(Menu menu) {
            Menu menu2 = this.f769d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            o oVar = new o(this.f767b, (u.a) menu);
            this.f769d.put(menu, oVar);
            return oVar;
        }

        @Override // androidx.appcompat.view.b.a
        public boolean a(b bVar, Menu menu) {
            return this.f766a.onPrepareActionMode(e(bVar), f(menu));
        }

        @Override // androidx.appcompat.view.b.a
        public void b(b bVar) {
            this.f766a.onDestroyActionMode(e(bVar));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean c(b bVar, MenuItem menuItem) {
            return this.f766a.onActionItemClicked(e(bVar), new j(this.f767b, (u.b) menuItem));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean d(b bVar, Menu menu) {
            return this.f766a.onCreateActionMode(e(bVar), f(menu));
        }

        public ActionMode e(b bVar) {
            int size = this.f768c.size();
            for (int i10 = 0; i10 < size; i10++) {
                f fVar = this.f768c.get(i10);
                if (fVar != null && fVar.f765b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f767b, bVar);
            this.f768c.add(fVar2);
            return fVar2;
        }
    }

    public f(Context context, b bVar) {
        this.f764a = context;
        this.f765b = bVar;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f765b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f765b.d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new o(this.f764a, (u.a) this.f765b.e());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f765b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f765b.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f765b.h();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f765b.i();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f765b.j();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f765b.k();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f765b.l();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f765b.m(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i10) {
        this.f765b.n(i10);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f765b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f765b.p(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i10) {
        this.f765b.q(i10);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f765b.r(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z10) {
        this.f765b.s(z10);
    }
}
