package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.m;

/* loaded from: classes.dex */
public interface f0 {
    void a(Menu menu, m.a aVar);

    boolean b();

    Context c();

    void collapseActionView();

    void d();

    boolean e();

    boolean f();

    boolean g();

    CharSequence getTitle();

    boolean h();

    void i();

    void j(int i10);

    void k(r0 r0Var);

    ViewGroup l();

    void m(boolean z10);

    boolean n();

    void o(int i10);

    int p();

    void q(int i10);

    int r();

    void s(View view);

    void setIcon(int i10);

    void setIcon(Drawable drawable);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    androidx.core.view.g0 t(int i10, long j10);

    void u();

    void v();

    void w(boolean z10);
}
