package h;

import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.P;
import com.google.firebase.database.core.ValidationPath;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import k.AbstractC0458b;
import k.C0461e;
import k.C0466j;
import k.InterfaceC0457a;
import m.C0567s;
import m.Q0;
import m.x1;
import t.C0691g;

/* renamed from: h.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractActivityC0441k extends androidx.fragment.app.L implements InterfaceC0442l, w.u {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private o mDelegate;
    private Resources mResources;

    @Override // c.m, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        g();
        y yVar = (y) getDelegate();
        yVar.w();
        ((ViewGroup) yVar.f4878D.findViewById(R.id.content)).addView(view, layoutParams);
        yVar.p.a(yVar.f4913o.getCallback());
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Configuration configuration;
        int i;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        y yVar = (y) getDelegate();
        int i10 = 1;
        yVar.f4892R = true;
        int i11 = yVar.f4896V;
        if (i11 == -100) {
            i11 = o.f4834b;
        }
        int C3 = yVar.C(context, i11);
        if (o.b(context) && o.b(context)) {
            if (F.a.b()) {
                if (!o.f4838f) {
                    o.f4833a.execute(new com.lt.plugin.lt_plugin.services.c(context, i10));
                }
            } else {
                synchronized (o.f4841l) {
                    try {
                        F.f fVar = o.f4835c;
                        if (fVar == null) {
                            if (o.f4836d == null) {
                                o.f4836d = F.f.a(E1.b.x(context));
                            }
                            if (!o.f4836d.f162a.f163a.isEmpty()) {
                                o.f4835c = o.f4836d;
                            }
                        } else if (!fVar.equals(o.f4836d)) {
                            F.f fVar2 = o.f4835c;
                            o.f4836d = fVar2;
                            E1.b.v(context, fVar2.f162a.f163a.toLanguageTags());
                        }
                    } finally {
                    }
                }
            }
        }
        F.f p = y.p(context);
        if (y.f4874n0 && (context instanceof ContextThemeWrapper)) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(y.t(context, C3, p, null, false));
            } catch (IllegalStateException unused) {
            }
            super.attachBaseContext(context);
        }
        if (context instanceof C0461e) {
            try {
                ((C0461e) context).a(y.t(context, C3, p, null, false));
            } catch (IllegalStateException unused2) {
            }
            super.attachBaseContext(context);
        }
        if (y.f4873m0) {
            int i12 = Build.VERSION.SDK_INT;
            Configuration configuration2 = new Configuration();
            configuration2.uiMode = -1;
            configuration2.fontScale = 0.0f;
            Configuration configuration3 = context.createConfigurationContext(configuration2).getResources().getConfiguration();
            Configuration configuration4 = context.getResources().getConfiguration();
            configuration3.uiMode = configuration4.uiMode;
            if (!configuration3.equals(configuration4)) {
                configuration = new Configuration();
                configuration.fontScale = 0.0f;
                if (configuration3.diff(configuration4) != 0) {
                    float f4 = configuration3.fontScale;
                    float f5 = configuration4.fontScale;
                    if (f4 != f5) {
                        configuration.fontScale = f5;
                    }
                    int i13 = configuration3.mcc;
                    int i14 = configuration4.mcc;
                    if (i13 != i14) {
                        configuration.mcc = i14;
                    }
                    int i15 = configuration3.mnc;
                    int i16 = configuration4.mnc;
                    if (i15 != i16) {
                        configuration.mnc = i16;
                    }
                    s.a(configuration3, configuration4, configuration);
                    int i17 = configuration3.touchscreen;
                    int i18 = configuration4.touchscreen;
                    if (i17 != i18) {
                        configuration.touchscreen = i18;
                    }
                    int i19 = configuration3.keyboard;
                    int i20 = configuration4.keyboard;
                    if (i19 != i20) {
                        configuration.keyboard = i20;
                    }
                    int i21 = configuration3.keyboardHidden;
                    int i22 = configuration4.keyboardHidden;
                    if (i21 != i22) {
                        configuration.keyboardHidden = i22;
                    }
                    int i23 = configuration3.navigation;
                    int i24 = configuration4.navigation;
                    if (i23 != i24) {
                        configuration.navigation = i24;
                    }
                    int i25 = configuration3.navigationHidden;
                    int i26 = configuration4.navigationHidden;
                    if (i25 != i26) {
                        configuration.navigationHidden = i26;
                    }
                    int i27 = configuration3.orientation;
                    int i28 = configuration4.orientation;
                    if (i27 != i28) {
                        configuration.orientation = i28;
                    }
                    int i29 = configuration3.screenLayout & 15;
                    int i30 = configuration4.screenLayout & 15;
                    if (i29 != i30) {
                        configuration.screenLayout |= i30;
                    }
                    int i31 = configuration3.screenLayout & 192;
                    int i32 = configuration4.screenLayout & 192;
                    if (i31 != i32) {
                        configuration.screenLayout |= i32;
                    }
                    int i33 = configuration3.screenLayout & 48;
                    int i34 = configuration4.screenLayout & 48;
                    if (i33 != i34) {
                        configuration.screenLayout |= i34;
                    }
                    int i35 = configuration3.screenLayout & ValidationPath.MAX_PATH_LENGTH_BYTES;
                    int i36 = configuration4.screenLayout & ValidationPath.MAX_PATH_LENGTH_BYTES;
                    if (i35 != i36) {
                        configuration.screenLayout |= i36;
                    }
                    if (i12 >= 26) {
                        i = configuration3.colorMode;
                        int i37 = i & 3;
                        i3 = configuration4.colorMode;
                        if (i37 != (i3 & 3)) {
                            i8 = configuration.colorMode;
                            i9 = configuration4.colorMode;
                            configuration.colorMode = i8 | (i9 & 3);
                        }
                        i4 = configuration3.colorMode;
                        int i38 = i4 & 12;
                        i5 = configuration4.colorMode;
                        if (i38 != (i5 & 12)) {
                            i6 = configuration.colorMode;
                            i7 = configuration4.colorMode;
                            configuration.colorMode = i6 | (i7 & 12);
                        }
                    }
                    int i39 = configuration3.uiMode & 15;
                    int i40 = configuration4.uiMode & 15;
                    if (i39 != i40) {
                        configuration.uiMode |= i40;
                    }
                    int i41 = configuration3.uiMode & 48;
                    int i42 = configuration4.uiMode & 48;
                    if (i41 != i42) {
                        configuration.uiMode |= i42;
                    }
                    int i43 = configuration3.screenWidthDp;
                    int i44 = configuration4.screenWidthDp;
                    if (i43 != i44) {
                        configuration.screenWidthDp = i44;
                    }
                    int i45 = configuration3.screenHeightDp;
                    int i46 = configuration4.screenHeightDp;
                    if (i45 != i46) {
                        configuration.screenHeightDp = i46;
                    }
                    int i47 = configuration3.smallestScreenWidthDp;
                    int i48 = configuration4.smallestScreenWidthDp;
                    if (i47 != i48) {
                        configuration.smallestScreenWidthDp = i48;
                    }
                    int i49 = configuration3.densityDpi;
                    int i50 = configuration4.densityDpi;
                    if (i49 != i50) {
                        configuration.densityDpi = i50;
                    }
                }
            } else {
                configuration = null;
            }
            Configuration t3 = y.t(context, C3, p, configuration, true);
            C0461e c0461e = new C0461e(context, com.uh.sf.R.style.Theme_AppCompat_Empty);
            c0461e.a(t3);
            try {
                if (context.getTheme() != null) {
                    Resources.Theme theme = c0461e.getTheme();
                    if (i12 >= 29) {
                        z.j.a(theme);
                    } else {
                        synchronized (z.b.f6775e) {
                            if (!z.b.f6777g) {
                                try {
                                    Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", null);
                                    z.b.f6776f = declaredMethod;
                                    declaredMethod.setAccessible(true);
                                } catch (NoSuchMethodException unused3) {
                                }
                                z.b.f6777g = true;
                            }
                            Method method = z.b.f6776f;
                            if (method != null) {
                                try {
                                    method.invoke(theme, null);
                                } catch (IllegalAccessException | InvocationTargetException unused4) {
                                    z.b.f6776f = null;
                                }
                            }
                        }
                    }
                }
            } catch (NullPointerException unused5) {
            }
            context = c0461e;
        }
        super.attachBaseContext(context);
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        AbstractC0431a supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.a()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // w.f, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        AbstractC0431a supportActionBar = getSupportActionBar();
        if (keyCode == 82 && supportActionBar != null && supportActionBar.l(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        y yVar = (y) getDelegate();
        yVar.w();
        return (T) yVar.f4913o.findViewById(i);
    }

    public final void g() {
        P.f(getWindow().getDecorView(), this);
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.j.e(decorView, "<this>");
        decorView.setTag(com.uh.sf.R.id.view_tree_view_model_store_owner, this);
        T.b.H(getWindow().getDecorView(), this);
        View decorView2 = getWindow().getDecorView();
        kotlin.jvm.internal.j.e(decorView2, "<this>");
        decorView2.setTag(com.uh.sf.R.id.view_tree_on_back_pressed_dispatcher_owner, this);
    }

    public o getDelegate() {
        if (this.mDelegate == null) {
            E e4 = o.f4833a;
            this.mDelegate = new y(this, null, this, this);
        }
        return this.mDelegate;
    }

    public InterfaceC0432b getDrawerToggleDelegate() {
        ((y) getDelegate()).getClass();
        return new androidx.lifecycle.N(9);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        Context context;
        y yVar = (y) getDelegate();
        if (yVar.f4916s == null) {
            yVar.A();
            AbstractC0431a abstractC0431a = yVar.f4915r;
            if (abstractC0431a != null) {
                context = abstractC0431a.e();
            } else {
                context = yVar.f4912n;
            }
            yVar.f4916s = new C0466j(context);
        }
        return yVar.f4916s;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = this.mResources;
        if (resources == null) {
            int i = x1.f5837a;
        }
        if (resources == null) {
            return super.getResources();
        }
        return resources;
    }

    public AbstractC0431a getSupportActionBar() {
        y yVar = (y) getDelegate();
        yVar.A();
        return yVar.f4915r;
    }

    @Override // w.u
    public Intent getSupportParentActivityIntent() {
        return m3.b.r(this);
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        getDelegate().a();
    }

    @Override // c.m, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        y yVar = (y) getDelegate();
        if (yVar.f4883I && yVar.f4877C) {
            yVar.A();
            AbstractC0431a abstractC0431a = yVar.f4915r;
            if (abstractC0431a != null) {
                abstractC0431a.i();
            }
        }
        C0567s a2 = C0567s.a();
        Context context = yVar.f4912n;
        synchronized (a2) {
            Q0 q02 = a2.f5767a;
            synchronized (q02) {
                C0691g c0691g = (C0691g) q02.f5580b.get(context);
                if (c0691g != null) {
                    c0691g.a();
                }
            }
        }
        yVar.f4895U = new Configuration(yVar.f4912n.getResources().getConfiguration());
        yVar.n(false, false);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(w.v vVar) {
        ArrayList arrayList = vVar.f6679a;
        AbstractActivityC0441k abstractActivityC0441k = vVar.f6680b;
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = m3.b.r(this);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(abstractActivityC0441k.getPackageManager());
            }
            int size = arrayList.size();
            try {
                for (Intent s3 = m3.b.s(abstractActivityC0441k, component); s3 != null; s3 = m3.b.s(abstractActivityC0441k, s3.getComponent())) {
                    arrayList.add(size, s3);
                }
                arrayList.add(supportParentActivityIntent);
            } catch (PackageManager.NameNotFoundException e4) {
                Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                throw new IllegalArgumentException(e4);
            }
        }
    }

    @Override // androidx.fragment.app.L, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getDelegate().d();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Window window;
        if (Build.VERSION.SDK_INT < 26 && !keyEvent.isCtrlPressed() && !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) && keyEvent.getRepeatCount() == 0 && !KeyEvent.isModifierKey(keyEvent.getKeyCode()) && (window = getWindow()) != null && window.getDecorView() != null && window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // androidx.fragment.app.L, c.m, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        AbstractC0431a supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() == 16908332 && supportActionBar != null && (supportActionBar.d() & 4) != 0) {
            return onSupportNavigateUp();
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    @Override // c.m, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((y) getDelegate()).w();
    }

    @Override // androidx.fragment.app.L, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        y yVar = (y) getDelegate();
        yVar.A();
        AbstractC0431a abstractC0431a = yVar.f4915r;
        if (abstractC0431a != null) {
            abstractC0431a.q(true);
        }
    }

    @Override // androidx.fragment.app.L, android.app.Activity
    public void onStart() {
        super.onStart();
        ((y) getDelegate()).n(true, false);
    }

    @Override // androidx.fragment.app.L, android.app.Activity
    public void onStop() {
        super.onStop();
        y yVar = (y) getDelegate();
        yVar.A();
        AbstractC0431a abstractC0431a = yVar.f4915r;
        if (abstractC0431a != null) {
            abstractC0431a.q(false);
        }
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (supportShouldUpRecreateTask(supportParentActivityIntent)) {
            w.v vVar = new w.v(this);
            onCreateSupportNavigateUpTaskStack(vVar);
            onPrepareSupportNavigateUpTaskStack(vVar);
            ArrayList arrayList = vVar.f6679a;
            if (!arrayList.isEmpty()) {
                Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
                intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
                vVar.f6680b.startActivities(intentArr, null);
                try {
                    finishAffinity();
                    return true;
                } catch (IllegalStateException unused) {
                    finish();
                    return true;
                }
            }
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        supportNavigateUpTo(supportParentActivityIntent);
        return true;
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        getDelegate().l(charSequence);
    }

    @Override // h.InterfaceC0442l
    public AbstractC0458b onWindowStartingSupportActionMode(InterfaceC0457a interfaceC0457a) {
        return null;
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        AbstractC0431a supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.m()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // c.m, android.app.Activity
    public void setContentView(int i) {
        g();
        getDelegate().h(i);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        CharSequence charSequence;
        y yVar = (y) getDelegate();
        if (!(yVar.f4911m instanceof Activity)) {
            return;
        }
        yVar.A();
        AbstractC0431a abstractC0431a = yVar.f4915r;
        if (!(abstractC0431a instanceof N)) {
            yVar.f4916s = null;
            if (abstractC0431a != null) {
                abstractC0431a.j();
            }
            yVar.f4915r = null;
            if (toolbar != null) {
                Object obj = yVar.f4911m;
                if (obj instanceof Activity) {
                    charSequence = ((Activity) obj).getTitle();
                } else {
                    charSequence = yVar.f4917t;
                }
                I i = new I(toolbar, charSequence, yVar.p);
                yVar.f4915r = i;
                yVar.p.f4848b = i.f4736c;
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                yVar.p.f4848b = null;
            }
            yVar.a();
            return;
        }
        throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        ((y) getDelegate()).f4897W = i;
    }

    public AbstractC0458b startSupportActionMode(InterfaceC0457a interfaceC0457a) {
        return getDelegate().m(interfaceC0457a);
    }

    @Override // androidx.fragment.app.L
    public void supportInvalidateOptionsMenu() {
        getDelegate().a();
    }

    public void supportNavigateUpTo(Intent intent) {
        navigateUpTo(intent);
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().g(i);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return shouldUpRecreateTask(intent);
    }

    @Override // c.m, android.app.Activity
    public void setContentView(View view) {
        g();
        getDelegate().j(view);
    }

    @Override // c.m, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        g();
        getDelegate().k(view, layoutParams);
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public void onLocalesChanged(F.f fVar) {
    }

    public void onNightModeChanged(int i) {
    }

    public void onPrepareSupportNavigateUpTaskStack(w.v vVar) {
    }

    @Override // h.InterfaceC0442l
    public void onSupportActionModeFinished(AbstractC0458b abstractC0458b) {
    }

    @Override // h.InterfaceC0442l
    public void onSupportActionModeStarted(AbstractC0458b abstractC0458b) {
    }

    @Deprecated
    public void setSupportProgress(int i) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z3) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z3) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z3) {
    }
}
