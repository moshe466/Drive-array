package c;

import F0.Q2;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.AbstractC0305o;
import androidx.lifecycle.C0311v;
import androidx.lifecycle.EnumC0303m;
import androidx.lifecycle.InterfaceC0309t;
import androidx.lifecycle.P;
import com.uh.sf.R;
import l0.C0514d;
import l0.C0515e;
import l0.InterfaceC0516f;

/* loaded from: classes.dex */
public class n extends Dialog implements InterfaceC0309t, y, InterfaceC0516f {

    /* renamed from: a, reason: collision with root package name */
    public C0311v f3832a;

    /* renamed from: b, reason: collision with root package name */
    public final C0515e f3833b;

    /* renamed from: c, reason: collision with root package name */
    public final x f3834c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(Context context, int i) {
        super(context, i);
        kotlin.jvm.internal.j.e(context, "context");
        this.f3833b = new C0515e(this);
        this.f3834c = new x(new Q2(this, 4));
    }

    public static void a(n nVar) {
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        kotlin.jvm.internal.j.e(view, "view");
        b();
        super.addContentView(view, layoutParams);
    }

    public final void b() {
        Window window = getWindow();
        kotlin.jvm.internal.j.b(window);
        View decorView = window.getDecorView();
        kotlin.jvm.internal.j.d(decorView, "getDecorView(...)");
        P.f(decorView, this);
        Window window2 = getWindow();
        kotlin.jvm.internal.j.b(window2);
        View decorView2 = window2.getDecorView();
        kotlin.jvm.internal.j.d(decorView2, "getDecorView(...)");
        decorView2.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        Window window3 = getWindow();
        kotlin.jvm.internal.j.b(window3);
        View decorView3 = window3.getDecorView();
        kotlin.jvm.internal.j.d(decorView3, "getDecorView(...)");
        T.b.H(decorView3, this);
    }

    @Override // androidx.lifecycle.InterfaceC0309t
    public final AbstractC0305o getLifecycle() {
        C0311v c0311v = this.f3832a;
        if (c0311v == null) {
            C0311v c0311v2 = new C0311v(this);
            this.f3832a = c0311v2;
            return c0311v2;
        }
        return c0311v;
    }

    @Override // c.y
    public final x getOnBackPressedDispatcher() {
        return this.f3834c;
    }

    @Override // l0.InterfaceC0516f
    public final C0514d getSavedStateRegistry() {
        return this.f3833b.f5481b;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        this.f3834c.c();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            kotlin.jvm.internal.j.d(onBackInvokedDispatcher, "getOnBackInvokedDispatcher(...)");
            x xVar = this.f3834c;
            xVar.f3860e = onBackInvokedDispatcher;
            xVar.d(xVar.f3862g);
        }
        this.f3833b.b(bundle);
        C0311v c0311v = this.f3832a;
        if (c0311v == null) {
            c0311v = new C0311v(this);
            this.f3832a = c0311v;
        }
        c0311v.e(EnumC0303m.ON_CREATE);
    }

    @Override // android.app.Dialog
    public final Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        kotlin.jvm.internal.j.d(onSaveInstanceState, "onSaveInstanceState(...)");
        this.f3833b.c(onSaveInstanceState);
        return onSaveInstanceState;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        C0311v c0311v = this.f3832a;
        if (c0311v == null) {
            c0311v = new C0311v(this);
            this.f3832a = c0311v;
        }
        c0311v.e(EnumC0303m.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        C0311v c0311v = this.f3832a;
        if (c0311v == null) {
            c0311v = new C0311v(this);
            this.f3832a = c0311v;
        }
        c0311v.e(EnumC0303m.ON_DESTROY);
        this.f3832a = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        b();
        super.setContentView(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        kotlin.jvm.internal.j.e(view, "view");
        b();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        kotlin.jvm.internal.j.e(view, "view");
        b();
        super.setContentView(view, layoutParams);
    }
}
