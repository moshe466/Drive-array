package k;

import F0.C0021d0;
import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;
import m.C0548i;

/* renamed from: k.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0462f extends AbstractC0458b implements l.k {

    /* renamed from: c, reason: collision with root package name */
    public Context f5108c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContextView f5109d;

    /* renamed from: e, reason: collision with root package name */
    public C0021d0 f5110e;

    /* renamed from: f, reason: collision with root package name */
    public WeakReference f5111f;

    /* renamed from: j, reason: collision with root package name */
    public boolean f5112j;

    /* renamed from: k, reason: collision with root package name */
    public l.m f5113k;

    @Override // k.AbstractC0458b
    public final void a() {
        if (this.f5112j) {
            return;
        }
        this.f5112j = true;
        this.f5110e.e(this);
    }

    @Override // k.AbstractC0458b
    public final View b() {
        WeakReference weakReference = this.f5111f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // k.AbstractC0458b
    public final l.m c() {
        return this.f5113k;
    }

    @Override // k.AbstractC0458b
    public final MenuInflater d() {
        return new C0466j(this.f5109d.getContext());
    }

    @Override // k.AbstractC0458b
    public final CharSequence e() {
        return this.f5109d.getSubtitle();
    }

    @Override // l.k
    public final void f(l.m mVar) {
        h();
        C0548i c0548i = this.f5109d.f2811d;
        if (c0548i != null) {
            c0548i.l();
        }
    }

    @Override // k.AbstractC0458b
    public final CharSequence g() {
        return this.f5109d.getTitle();
    }

    @Override // k.AbstractC0458b
    public final void h() {
        this.f5110e.d(this, this.f5113k);
    }

    @Override // l.k
    public final boolean i(l.m mVar, MenuItem menuItem) {
        return ((InterfaceC0457a) this.f5110e.f479a).a(this, menuItem);
    }

    @Override // k.AbstractC0458b
    public final boolean j() {
        return this.f5109d.f2825v;
    }

    @Override // k.AbstractC0458b
    public final void k(View view) {
        WeakReference weakReference;
        this.f5109d.setCustomView(view);
        if (view != null) {
            weakReference = new WeakReference(view);
        } else {
            weakReference = null;
        }
        this.f5111f = weakReference;
    }

    @Override // k.AbstractC0458b
    public final void l(int i) {
        m(this.f5108c.getString(i));
    }

    @Override // k.AbstractC0458b
    public final void m(CharSequence charSequence) {
        this.f5109d.setSubtitle(charSequence);
    }

    @Override // k.AbstractC0458b
    public final void n(int i) {
        o(this.f5108c.getString(i));
    }

    @Override // k.AbstractC0458b
    public final void o(CharSequence charSequence) {
        this.f5109d.setTitle(charSequence);
    }

    @Override // k.AbstractC0458b
    public final void p(boolean z3) {
        this.f5101b = z3;
        this.f5109d.setTitleOptional(z3);
    }
}
