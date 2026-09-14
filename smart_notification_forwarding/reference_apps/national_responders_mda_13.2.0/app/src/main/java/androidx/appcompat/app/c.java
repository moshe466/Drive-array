package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.b;
import androidx.appcompat.widget.g1;
import androidx.core.app.u;
import androidx.lifecycle.g0;
import androidx.lifecycle.h0;
import p0.c;

/* loaded from: classes.dex */
public class c extends androidx.fragment.app.j implements d, u.a {

    /* renamed from: y, reason: collision with root package name */
    private e f607y;

    /* renamed from: z, reason: collision with root package name */
    private Resources f608z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements c.InterfaceC0267c {
        a() {
        }

        @Override // p0.c.InterfaceC0267c
        public Bundle a() {
            Bundle bundle = new Bundle();
            c.this.n0().u(bundle);
            return bundle;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements c.b {
        b() {
        }

        @Override // c.b
        public void a(Context context) {
            e n02 = c.this.n0();
            n02.n();
            n02.q(c.this.f().b("androidx:appcompat"));
        }
    }

    public c() {
        p0();
    }

    private void T() {
        g0.a(getWindow().getDecorView(), this);
        h0.a(getWindow().getDecorView(), this);
        p0.f.a(getWindow().getDecorView(), this);
    }

    private void p0() {
        f().h("androidx:appcompat", new a());
        Q(new b());
    }

    private boolean v0(KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    @Override // androidx.core.app.u.a
    public Intent D() {
        return androidx.core.app.i.a(this);
    }

    @Override // androidx.appcompat.app.d
    public androidx.appcompat.view.b H(b.a aVar) {
        return null;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        T();
        n0().d(view, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(n0().f(context));
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        androidx.appcompat.app.a o02 = o0();
        if (getWindow().hasFeature(0)) {
            if (o02 == null || !o02.g()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // androidx.core.app.g, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        androidx.appcompat.app.a o02 = o0();
        if (keyCode == 82 && o02 != null && o02.p(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i10) {
        return (T) n0().i(i10);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return n0().l();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f608z == null && g1.c()) {
            this.f608z = new g1(this, super.getResources());
        }
        Resources resources = this.f608z;
        return resources == null ? super.getResources() : resources;
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        n0().o();
    }

    @Override // androidx.appcompat.app.d
    public void n(androidx.appcompat.view.b bVar) {
    }

    public e n0() {
        if (this.f607y == null) {
            this.f607y = e.g(this, this);
        }
        return this.f607y;
    }

    public androidx.appcompat.app.a o0() {
        return n0().m();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        n0().p(configuration);
        if (this.f608z != null) {
            this.f608z.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        t0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        n0().r();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (v0(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // androidx.fragment.app.j, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        androidx.appcompat.app.a o02 = o0();
        if (menuItem.getItemId() != 16908332 || o02 == null || (o02.j() & 4) == 0) {
            return false;
        }
        return u0();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i10, Menu menu) {
        return super.onMenuOpened(i10, menu);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i10, Menu menu) {
        super.onPanelClosed(i10, menu);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        n0().s(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.j, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        n0().t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.j, android.app.Activity
    public void onStart() {
        super.onStart();
        n0().v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.j, android.app.Activity
    public void onStop() {
        super.onStop();
        n0().w();
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i10) {
        super.onTitleChanged(charSequence, i10);
        n0().E(charSequence);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        androidx.appcompat.app.a o02 = o0();
        if (getWindow().hasFeature(0)) {
            if (o02 == null || !o02.q()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // androidx.appcompat.app.d
    public void p(androidx.appcompat.view.b bVar) {
    }

    public void q0(u uVar) {
        uVar.f(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r0(int i10) {
    }

    public void s0(u uVar) {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        T();
        n0().A(i10);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        T();
        n0().B(view);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        T();
        n0().C(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i10) {
        super.setTheme(i10);
        n0().D(i10);
    }

    @Deprecated
    public void t0() {
    }

    public boolean u0() {
        Intent D = D();
        if (D == null) {
            return false;
        }
        if (!x0(D)) {
            w0(D);
            return true;
        }
        u j10 = u.j(this);
        q0(j10);
        s0(j10);
        j10.l();
        try {
            androidx.core.app.b.k(this);
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    public void w0(Intent intent) {
        androidx.core.app.i.e(this, intent);
    }

    public boolean x0(Intent intent) {
        return androidx.core.app.i.f(this, intent);
    }
}
