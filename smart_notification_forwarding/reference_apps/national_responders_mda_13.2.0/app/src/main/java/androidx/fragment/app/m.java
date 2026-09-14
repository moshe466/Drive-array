package androidx.fragment.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private final o<?> f3081a;

    private m(o<?> oVar) {
        this.f3081a = oVar;
    }

    public static m b(o<?> oVar) {
        return new m((o) androidx.core.util.h.g(oVar, "callbacks == null"));
    }

    public void a(Fragment fragment) {
        o<?> oVar = this.f3081a;
        oVar.f3086i.m(oVar, oVar, fragment);
    }

    public void c() {
        this.f3081a.f3086i.y();
    }

    public boolean d(MenuItem menuItem) {
        return this.f3081a.f3086i.B(menuItem);
    }

    public void e() {
        this.f3081a.f3086i.C();
    }

    public void f() {
        this.f3081a.f3086i.E();
    }

    public void g() {
        this.f3081a.f3086i.N();
    }

    public void h() {
        this.f3081a.f3086i.R();
    }

    public void i() {
        this.f3081a.f3086i.S();
    }

    public void j() {
        this.f3081a.f3086i.U();
    }

    public boolean k() {
        return this.f3081a.f3086i.b0(true);
    }

    public w l() {
        return this.f3081a.f3086i;
    }

    public void m() {
        this.f3081a.f3086i.W0();
    }

    public View n(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f3081a.f3086i.v0().onCreateView(view, str, context, attributeSet);
    }
}
