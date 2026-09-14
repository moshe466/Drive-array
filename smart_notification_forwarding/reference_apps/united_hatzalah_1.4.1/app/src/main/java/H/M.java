package h;

import F0.C0021d0;
import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;
import k.AbstractC0458b;
import k.C0466j;
import k.InterfaceC0457a;
import m.C0548i;

/* loaded from: classes.dex */
public final class M extends AbstractC0458b implements l.k {

    /* renamed from: c, reason: collision with root package name */
    public final Context f4750c;

    /* renamed from: d, reason: collision with root package name */
    public final l.m f4751d;

    /* renamed from: e, reason: collision with root package name */
    public C0021d0 f4752e;

    /* renamed from: f, reason: collision with root package name */
    public WeakReference f4753f;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ N f4754j;

    public M(N n4, Context context, C0021d0 c0021d0) {
        this.f4754j = n4;
        this.f4750c = context;
        this.f4752e = c0021d0;
        l.m mVar = new l.m(context);
        mVar.f5410l = 1;
        this.f4751d = mVar;
        mVar.f5404e = this;
    }

    @Override // k.AbstractC0458b
    public final void a() {
        N n4 = this.f4754j;
        if (n4.i != this) {
            return;
        }
        boolean z3 = n4.p;
        boolean z4 = n4.f4771q;
        if (!z3 && !z4) {
            this.f4752e.e(this);
        } else {
            n4.f4765j = this;
            n4.f4766k = this.f4752e;
        }
        this.f4752e = null;
        n4.v(false);
        ActionBarContextView actionBarContextView = n4.f4762f;
        if (actionBarContextView.f2818n == null) {
            actionBarContextView.e();
        }
        n4.f4759c.setHideOnContentScrollEnabled(n4.f4776v);
        n4.i = null;
    }

    @Override // k.AbstractC0458b
    public final View b() {
        WeakReference weakReference = this.f4753f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // k.AbstractC0458b
    public final l.m c() {
        return this.f4751d;
    }

    @Override // k.AbstractC0458b
    public final MenuInflater d() {
        return new C0466j(this.f4750c);
    }

    @Override // k.AbstractC0458b
    public final CharSequence e() {
        return this.f4754j.f4762f.getSubtitle();
    }

    @Override // l.k
    public final void f(l.m mVar) {
        if (this.f4752e != null) {
            h();
            C0548i c0548i = this.f4754j.f4762f.f2811d;
            if (c0548i != null) {
                c0548i.l();
            }
        }
    }

    @Override // k.AbstractC0458b
    public final CharSequence g() {
        return this.f4754j.f4762f.getTitle();
    }

    @Override // k.AbstractC0458b
    public final void h() {
        if (this.f4754j.i != this) {
            return;
        }
        l.m mVar = this.f4751d;
        mVar.w();
        try {
            this.f4752e.d(this, mVar);
        } finally {
            mVar.v();
        }
    }

    @Override // l.k
    public final boolean i(l.m mVar, MenuItem menuItem) {
        C0021d0 c0021d0 = this.f4752e;
        if (c0021d0 != null) {
            return ((InterfaceC0457a) c0021d0.f479a).a(this, menuItem);
        }
        return false;
    }

    @Override // k.AbstractC0458b
    public final boolean j() {
        return this.f4754j.f4762f.f2825v;
    }

    @Override // k.AbstractC0458b
    public final void k(View view) {
        this.f4754j.f4762f.setCustomView(view);
        this.f4753f = new WeakReference(view);
    }

    @Override // k.AbstractC0458b
    public final void l(int i) {
        m(this.f4754j.f4757a.getResources().getString(i));
    }

    @Override // k.AbstractC0458b
    public final void m(CharSequence charSequence) {
        this.f4754j.f4762f.setSubtitle(charSequence);
    }

    @Override // k.AbstractC0458b
    public final void n(int i) {
        o(this.f4754j.f4757a.getResources().getString(i));
    }

    @Override // k.AbstractC0458b
    public final void o(CharSequence charSequence) {
        this.f4754j.f4762f.setTitle(charSequence);
    }

    @Override // k.AbstractC0458b
    public final void p(boolean z3) {
        this.f5101b = z3;
        this.f4754j.f4762f.setTitleOptional(z3);
    }
}
