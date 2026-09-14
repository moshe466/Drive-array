package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* loaded from: classes.dex */
class b implements e {
    private f o(d dVar) {
        return (f) dVar.g();
    }

    @Override // androidx.cardview.widget.e
    public float a(d dVar) {
        return o(dVar).c();
    }

    @Override // androidx.cardview.widget.e
    public ColorStateList b(d dVar) {
        return o(dVar).b();
    }

    @Override // androidx.cardview.widget.e
    public void c(d dVar, Context context, ColorStateList colorStateList, float f10, float f11, float f12) {
        dVar.d(new f(colorStateList, f10));
        View b10 = dVar.b();
        b10.setClipToOutline(true);
        b10.setElevation(f11);
        n(dVar, f12);
    }

    @Override // androidx.cardview.widget.e
    public void d(d dVar, float f10) {
        o(dVar).h(f10);
    }

    @Override // androidx.cardview.widget.e
    public float e(d dVar) {
        return dVar.b().getElevation();
    }

    @Override // androidx.cardview.widget.e
    public void f() {
    }

    @Override // androidx.cardview.widget.e
    public float g(d dVar) {
        return o(dVar).d();
    }

    @Override // androidx.cardview.widget.e
    public float h(d dVar) {
        return g(dVar) * 2.0f;
    }

    @Override // androidx.cardview.widget.e
    public float i(d dVar) {
        return g(dVar) * 2.0f;
    }

    @Override // androidx.cardview.widget.e
    public void j(d dVar) {
        n(dVar, a(dVar));
    }

    @Override // androidx.cardview.widget.e
    public void k(d dVar, float f10) {
        dVar.b().setElevation(f10);
    }

    @Override // androidx.cardview.widget.e
    public void l(d dVar) {
        n(dVar, a(dVar));
    }

    @Override // androidx.cardview.widget.e
    public void m(d dVar, ColorStateList colorStateList) {
        o(dVar).f(colorStateList);
    }

    @Override // androidx.cardview.widget.e
    public void n(d dVar, float f10) {
        o(dVar).g(f10, dVar.f(), dVar.e());
        p(dVar);
    }

    public void p(d dVar) {
        if (!dVar.f()) {
            dVar.a(0, 0, 0, 0);
            return;
        }
        float a10 = a(dVar);
        float g10 = g(dVar);
        int ceil = (int) Math.ceil(g.c(a10, g10, dVar.e()));
        int ceil2 = (int) Math.ceil(g.d(a10, g10, dVar.e()));
        dVar.a(ceil, ceil2, ceil, ceil2);
    }
}
