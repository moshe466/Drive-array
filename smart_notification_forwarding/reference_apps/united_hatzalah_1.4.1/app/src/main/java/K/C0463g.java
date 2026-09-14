package k;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import l.MenuC0499C;

/* renamed from: k.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0463g extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    public final Context f5114a;

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC0458b f5115b;

    public C0463g(Context context, AbstractC0458b abstractC0458b) {
        this.f5114a = context;
        this.f5115b = abstractC0458b;
    }

    @Override // android.view.ActionMode
    public final void finish() {
        this.f5115b.a();
    }

    @Override // android.view.ActionMode
    public final View getCustomView() {
        return this.f5115b.b();
    }

    @Override // android.view.ActionMode
    public final Menu getMenu() {
        return new MenuC0499C(this.f5114a, this.f5115b.c());
    }

    @Override // android.view.ActionMode
    public final MenuInflater getMenuInflater() {
        return this.f5115b.d();
    }

    @Override // android.view.ActionMode
    public final CharSequence getSubtitle() {
        return this.f5115b.e();
    }

    @Override // android.view.ActionMode
    public final Object getTag() {
        return this.f5115b.f5100a;
    }

    @Override // android.view.ActionMode
    public final CharSequence getTitle() {
        return this.f5115b.g();
    }

    @Override // android.view.ActionMode
    public final boolean getTitleOptionalHint() {
        return this.f5115b.f5101b;
    }

    @Override // android.view.ActionMode
    public final void invalidate() {
        this.f5115b.h();
    }

    @Override // android.view.ActionMode
    public final boolean isTitleOptional() {
        return this.f5115b.j();
    }

    @Override // android.view.ActionMode
    public final void setCustomView(View view) {
        this.f5115b.k(view);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(CharSequence charSequence) {
        this.f5115b.m(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTag(Object obj) {
        this.f5115b.f5100a = obj;
    }

    @Override // android.view.ActionMode
    public final void setTitle(CharSequence charSequence) {
        this.f5115b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTitleOptionalHint(boolean z3) {
        this.f5115b.p(z3);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(int i) {
        this.f5115b.l(i);
    }

    @Override // android.view.ActionMode
    public final void setTitle(int i) {
        this.f5115b.n(i);
    }
}
