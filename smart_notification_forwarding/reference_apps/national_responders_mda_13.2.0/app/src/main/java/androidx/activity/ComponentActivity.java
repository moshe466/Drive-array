package androidx.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.app.o;
import androidx.core.app.p;
import androidx.core.app.r;
import androidx.lifecycle.b0;
import androidx.lifecycle.e0;
import androidx.lifecycle.f0;
import androidx.lifecycle.g0;
import androidx.lifecycle.h;
import androidx.lifecycle.h0;
import androidx.lifecycle.l;
import androidx.lifecycle.m;
import androidx.lifecycle.u;
import androidx.lifecycle.x;
import d.a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import p0.c;

/* loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.g implements f0, androidx.lifecycle.g, p0.e, h, androidx.activity.result.e, androidx.core.content.b, androidx.core.content.c, o, p, androidx.core.view.i {

    /* renamed from: g, reason: collision with root package name */
    final c.a f448g = new c.a();

    /* renamed from: h, reason: collision with root package name */
    private final androidx.core.view.j f449h = new androidx.core.view.j(new Runnable() { // from class: androidx.activity.c
        @Override // java.lang.Runnable
        public final void run() {
            ComponentActivity.this.U();
        }
    });

    /* renamed from: i, reason: collision with root package name */
    private final m f450i = new m(this);

    /* renamed from: j, reason: collision with root package name */
    final p0.d f451j;

    /* renamed from: k, reason: collision with root package name */
    private e0 f452k;

    /* renamed from: l, reason: collision with root package name */
    private final OnBackPressedDispatcher f453l;

    /* renamed from: m, reason: collision with root package name */
    private int f454m;

    /* renamed from: n, reason: collision with root package name */
    private final androidx.activity.result.d f455n;

    /* renamed from: o, reason: collision with root package name */
    private final CopyOnWriteArrayList<androidx.core.util.a<Configuration>> f456o;

    /* renamed from: p, reason: collision with root package name */
    private final CopyOnWriteArrayList<androidx.core.util.a<Integer>> f457p;

    /* renamed from: q, reason: collision with root package name */
    private final CopyOnWriteArrayList<androidx.core.util.a<Intent>> f458q;

    /* renamed from: r, reason: collision with root package name */
    private final CopyOnWriteArrayList<androidx.core.util.a<androidx.core.app.h>> f459r;

    /* renamed from: s, reason: collision with root package name */
    private final CopyOnWriteArrayList<androidx.core.util.a<r>> f460s;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e10) {
                if (!TextUtils.equals(e10.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e10;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    class b extends androidx.activity.result.d {

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f466f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ a.C0139a f467g;

            a(int i10, a.C0139a c0139a) {
                this.f466f = i10;
                this.f467g = c0139a;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.c(this.f466f, this.f467g.a());
            }
        }

        /* renamed from: androidx.activity.ComponentActivity$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0016b implements Runnable {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f469f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ IntentSender.SendIntentException f470g;

            RunnableC0016b(int i10, IntentSender.SendIntentException sendIntentException) {
                this.f469f = i10;
                this.f470g = sendIntentException;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.b(this.f469f, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.f470g));
            }
        }

        b() {
        }

        @Override // androidx.activity.result.d
        public <I, O> void f(int i10, d.a<I, O> aVar, I i11, androidx.core.app.c cVar) {
            ComponentActivity componentActivity = ComponentActivity.this;
            a.C0139a<O> b10 = aVar.b(componentActivity, i11);
            if (b10 != null) {
                new Handler(Looper.getMainLooper()).post(new a(i10, b10));
                return;
            }
            Intent a10 = aVar.a(componentActivity, i11);
            Bundle bundle = null;
            if (a10.getExtras() != null && a10.getExtras().getClassLoader() == null) {
                a10.setExtrasClassLoader(componentActivity.getClassLoader());
            }
            if (a10.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                bundle = a10.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                a10.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            }
            Bundle bundle2 = bundle;
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(a10.getAction())) {
                String[] stringArrayExtra = a10.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                androidx.core.app.b.n(componentActivity, stringArrayExtra, i10);
                return;
            }
            if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(a10.getAction())) {
                androidx.core.app.b.p(componentActivity, a10, i10, bundle2);
                return;
            }
            androidx.activity.result.f fVar = (androidx.activity.result.f) a10.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                androidx.core.app.b.q(componentActivity, fVar.d(), i10, fVar.a(), fVar.b(), fVar.c(), 0, bundle2);
            } catch (IntentSender.SendIntentException e10) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0016b(i10, e10));
            }
        }
    }

    /* loaded from: classes.dex */
    static class c {
        static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        Object f472a;

        /* renamed from: b, reason: collision with root package name */
        e0 f473b;

        d() {
        }
    }

    public ComponentActivity() {
        p0.d a10 = p0.d.a(this);
        this.f451j = a10;
        this.f453l = new OnBackPressedDispatcher(new a());
        new AtomicInteger();
        this.f455n = new b();
        this.f456o = new CopyOnWriteArrayList<>();
        this.f457p = new CopyOnWriteArrayList<>();
        this.f458q = new CopyOnWriteArrayList<>();
        this.f459r = new CopyOnWriteArrayList<>();
        this.f460s = new CopyOnWriteArrayList<>();
        if (b() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 19) {
            b().a(new androidx.lifecycle.j() { // from class: androidx.activity.ComponentActivity.3
                @Override // androidx.lifecycle.j
                public void d(l lVar, h.b bVar) {
                    if (bVar == h.b.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        View peekDecorView = window != null ? window.peekDecorView() : null;
                        if (peekDecorView != null) {
                            c.a(peekDecorView);
                        }
                    }
                }
            });
        }
        b().a(new androidx.lifecycle.j() { // from class: androidx.activity.ComponentActivity.4
            @Override // androidx.lifecycle.j
            public void d(l lVar, h.b bVar) {
                if (bVar == h.b.ON_DESTROY) {
                    ComponentActivity.this.f448g.b();
                    if (ComponentActivity.this.isChangingConfigurations()) {
                        return;
                    }
                    ComponentActivity.this.F().a();
                }
            }
        });
        b().a(new androidx.lifecycle.j() { // from class: androidx.activity.ComponentActivity.5
            @Override // androidx.lifecycle.j
            public void d(l lVar, h.b bVar) {
                ComponentActivity.this.S();
                ComponentActivity.this.b().c(this);
            }
        });
        a10.c();
        x.a(this);
        if (19 <= i10 && i10 <= 23) {
            b().a(new ImmLeaksCleaner(this));
        }
        f().h("android:support:activity-result", new c.InterfaceC0267c() { // from class: androidx.activity.d
            @Override // p0.c.InterfaceC0267c
            public final Bundle a() {
                Bundle V;
                V = ComponentActivity.this.V();
                return V;
            }
        });
        Q(new c.b() { // from class: androidx.activity.b
            @Override // c.b
            public final void a(Context context) {
                ComponentActivity.this.W(context);
            }
        });
    }

    private void T() {
        g0.a(getWindow().getDecorView(), this);
        h0.a(getWindow().getDecorView(), this);
        p0.f.a(getWindow().getDecorView(), this);
        j.a(getWindow().getDecorView(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle V() {
        Bundle bundle = new Bundle();
        this.f455n.h(bundle);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(Context context) {
        Bundle b10 = f().b("android:support:activity-result");
        if (b10 != null) {
            this.f455n.g(b10);
        }
    }

    @Override // androidx.activity.result.e
    public final androidx.activity.result.d A() {
        return this.f455n;
    }

    @Override // androidx.core.app.o
    public final void C(androidx.core.util.a<androidx.core.app.h> aVar) {
        this.f459r.add(aVar);
    }

    @Override // androidx.lifecycle.f0
    public e0 F() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        S();
        return this.f452k;
    }

    @Override // androidx.core.app.o
    public final void G(androidx.core.util.a<androidx.core.app.h> aVar) {
        this.f459r.remove(aVar);
    }

    @Override // androidx.core.content.b
    public final void K(androidx.core.util.a<Configuration> aVar) {
        this.f456o.remove(aVar);
    }

    public final void Q(c.b bVar) {
        this.f448g.a(bVar);
    }

    public final void R(androidx.core.util.a<Intent> aVar) {
        this.f458q.add(aVar);
    }

    void S() {
        if (this.f452k == null) {
            d dVar = (d) getLastNonConfigurationInstance();
            if (dVar != null) {
                this.f452k = dVar.f473b;
            }
            if (this.f452k == null) {
                this.f452k = new e0();
            }
        }
    }

    public void U() {
        invalidateOptionsMenu();
    }

    @Deprecated
    public Object X() {
        return null;
    }

    @Override // android.app.Activity
    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        T();
        super.addContentView(view, layoutParams);
    }

    @Override // androidx.lifecycle.l
    public androidx.lifecycle.h b() {
        return this.f450i;
    }

    @Override // androidx.activity.h
    public final OnBackPressedDispatcher e() {
        return this.f453l;
    }

    @Override // p0.e
    public final p0.c f() {
        return this.f451j.b();
    }

    @Override // androidx.core.view.i
    public void h(androidx.core.view.l lVar) {
        this.f449h.f(lVar);
    }

    @Override // androidx.core.content.b
    public final void m(androidx.core.util.a<Configuration> aVar) {
        this.f456o.add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    @Deprecated
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (this.f455n.b(i10, i11, intent)) {
            return;
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.f453l.c();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<androidx.core.util.a<Configuration>> it = this.f456o.iterator();
        while (it.hasNext()) {
            it.next().a(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.app.g, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.f451j.d(bundle);
        this.f448g.c(this);
        super.onCreate(bundle);
        u.g(this);
        int i10 = this.f454m;
        if (i10 != 0) {
            setContentView(i10);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i10, Menu menu) {
        if (i10 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i10, menu);
        this.f449h.b(menu, getMenuInflater());
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        if (i10 == 0) {
            return this.f449h.d(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z10) {
        Iterator<androidx.core.util.a<androidx.core.app.h>> it = this.f459r.iterator();
        while (it.hasNext()) {
            it.next().a(new androidx.core.app.h(z10));
        }
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z10, Configuration configuration) {
        Iterator<androidx.core.util.a<androidx.core.app.h>> it = this.f459r.iterator();
        while (it.hasNext()) {
            it.next().a(new androidx.core.app.h(z10, configuration));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(@SuppressLint({"UnknownNullness", "MissingNullability"}) Intent intent) {
        super.onNewIntent(intent);
        Iterator<androidx.core.util.a<Intent>> it = this.f458q.iterator();
        while (it.hasNext()) {
            it.next().a(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i10, Menu menu) {
        this.f449h.c(menu);
        super.onPanelClosed(i10, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z10) {
        Iterator<androidx.core.util.a<r>> it = this.f460s.iterator();
        while (it.hasNext()) {
            it.next().a(new r(z10));
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z10, Configuration configuration) {
        Iterator<androidx.core.util.a<r>> it = this.f460s.iterator();
        while (it.hasNext()) {
            it.next().a(new r(z10, configuration));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i10, View view, Menu menu) {
        if (i10 != 0) {
            return true;
        }
        super.onPreparePanel(i10, view, menu);
        this.f449h.e(menu);
        return true;
    }

    @Override // android.app.Activity
    @Deprecated
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        if (this.f455n.b(i10, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        d dVar;
        Object X = X();
        e0 e0Var = this.f452k;
        if (e0Var == null && (dVar = (d) getLastNonConfigurationInstance()) != null) {
            e0Var = dVar.f473b;
        }
        if (e0Var == null && X == null) {
            return null;
        }
        d dVar2 = new d();
        dVar2.f472a = X;
        dVar2.f473b = e0Var;
        return dVar2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.app.g, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        androidx.lifecycle.h b10 = b();
        if (b10 instanceof m) {
            ((m) b10).o(h.c.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.f451j.e(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        super.onTrimMemory(i10);
        Iterator<androidx.core.util.a<Integer>> it = this.f457p.iterator();
        while (it.hasNext()) {
            it.next().a(Integer.valueOf(i10));
        }
    }

    @Override // androidx.core.app.p
    public final void r(androidx.core.util.a<r> aVar) {
        this.f460s.remove(aVar);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (r0.a.d()) {
                r0.a.a("reportFullyDrawn() for ComponentActivity");
            }
            int i10 = Build.VERSION.SDK_INT;
            if (i10 > 19 || (i10 == 19 && androidx.core.content.a.a(this, "android.permission.UPDATE_DEVICE_STATS") == 0)) {
                super.reportFullyDrawn();
            }
        } finally {
            r0.a.b();
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i10) {
        T();
        super.setContentView(i10);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        T();
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        T();
        super.setContentView(view, layoutParams);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i10) {
        super.startActivityForResult(intent, i10);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i10, Bundle bundle) {
        super.startActivityForResult(intent, i10, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13) {
        super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
    }

    @Override // androidx.core.content.c
    public final void u(androidx.core.util.a<Integer> aVar) {
        this.f457p.remove(aVar);
    }

    @Override // androidx.core.content.c
    public final void v(androidx.core.util.a<Integer> aVar) {
        this.f457p.add(aVar);
    }

    @Override // androidx.lifecycle.g
    public k0.a w() {
        k0.d dVar = new k0.d();
        if (getApplication() != null) {
            dVar.b(b0.a.f3198b, getApplication());
        }
        dVar.b(x.f3238a, this);
        dVar.b(x.f3239b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            dVar.b(x.f3240c, getIntent().getExtras());
        }
        return dVar;
    }

    @Override // androidx.core.app.p
    public final void x(androidx.core.util.a<r> aVar) {
        this.f460s.add(aVar);
    }

    @Override // androidx.core.view.i
    public void z(androidx.core.view.l lVar) {
        this.f449h.a(lVar);
    }
}
