package c;

import J.C0125m;
import J.C0126n;
import J.C0127o;
import J.InterfaceC0123k;
import J.InterfaceC0128p;
import a.AbstractC0228a;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Trace;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.L;
import androidx.fragment.app.Y;
import androidx.lifecycle.AbstractC0305o;
import androidx.lifecycle.C0311v;
import androidx.lifecycle.EnumC0303m;
import androidx.lifecycle.EnumC0304n;
import androidx.lifecycle.H;
import androidx.lifecycle.InterfaceC0299i;
import androidx.lifecycle.InterfaceC0309t;
import androidx.lifecycle.J;
import androidx.lifecycle.K;
import androidx.lifecycle.P;
import androidx.lifecycle.W;
import androidx.lifecycle.X;
import androidx.lifecycle.Z;
import androidx.lifecycle.a0;
import com.uh.sf.R;
import d.C0354a;
import d0.AbstractC0356b;
import d0.C0357c;
import f.AbstractC0365a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import l0.C0511a;
import l0.C0514d;
import l0.C0515e;
import l0.InterfaceC0516f;
import s2.C0682g;
import s2.InterfaceC0678c;
import x.InterfaceC0776g;
import x.InterfaceC0777h;

/* loaded from: classes.dex */
public abstract class m extends w.f implements a0, InterfaceC0299i, InterfaceC0516f, y, e.i, InterfaceC0776g, InterfaceC0777h, w.q, w.r, InterfaceC0123k {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private static final g Companion = new Object();
    private Z _viewModelStore;
    private final e.h activityResultRegistry;
    private int contentLayoutId;
    private final C0354a contextAwareHelper = new C0354a();
    private final InterfaceC0678c defaultViewModelProviderFactory$delegate;
    private boolean dispatchingOnMultiWindowModeChanged;
    private boolean dispatchingOnPictureInPictureModeChanged;
    private final InterfaceC0678c fullyDrawnReporter$delegate;
    private final C0127o menuHostHelper;
    private final AtomicInteger nextLocalRequestCode;
    private final InterfaceC0678c onBackPressedDispatcher$delegate;
    private final CopyOnWriteArrayList<I.a> onConfigurationChangedListeners;
    private final CopyOnWriteArrayList<I.a> onMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<I.a> onNewIntentListeners;
    private final CopyOnWriteArrayList<I.a> onPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<I.a> onTrimMemoryListeners;
    private final CopyOnWriteArrayList<Runnable> onUserLeaveHintListeners;
    private final i reportFullyDrawnExecutor;
    private final C0515e savedStateRegistryController;

    public m() {
        final L l3 = (L) this;
        this.menuHostHelper = new C0127o(new c(l3, 0));
        C0515e c0515e = new C0515e(this);
        this.savedStateRegistryController = c0515e;
        this.reportFullyDrawnExecutor = new j(l3);
        this.fullyDrawnReporter$delegate = T.b.A(new d(l3, 1));
        this.nextLocalRequestCode = new AtomicInteger();
        this.activityResultRegistry = new l(l3);
        this.onConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.onTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.onNewIntentListeners = new CopyOnWriteArrayList<>();
        this.onMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.onPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.onUserLeaveHintListeners = new CopyOnWriteArrayList<>();
        if (getLifecycle() != null) {
            getLifecycle().a(new e(l3, 0));
            getLifecycle().a(new e(l3, 1));
            getLifecycle().a(new C0511a(l3, 3));
            c0515e.a();
            P.d(this);
            getSavedStateRegistry().c(ACTIVITY_RESULT_TAG, new K(l3, 1));
            addOnContextAvailableListener(new d.b() { // from class: c.f
                @Override // d.b
                public final void a(m mVar) {
                    m.e(L.this, mVar);
                }
            });
            this.defaultViewModelProviderFactory$delegate = T.b.A(new d(l3, 2));
            this.onBackPressedDispatcher$delegate = T.b.A(new d(l3, 3));
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    public static Bundle a(L l3) {
        Bundle bundle = new Bundle();
        e.h hVar = ((m) l3).activityResultRegistry;
        hVar.getClass();
        LinkedHashMap linkedHashMap = hVar.f4430b;
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(linkedHashMap.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(linkedHashMap.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(hVar.f4432d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", new Bundle(hVar.f4435g));
        return bundle;
    }

    public static final void access$ensureViewModelStore(m mVar) {
        if (mVar._viewModelStore == null) {
            h hVar = (h) mVar.getLastNonConfigurationInstance();
            if (hVar != null) {
                mVar._viewModelStore = hVar.f3822b;
            }
            if (mVar._viewModelStore == null) {
                mVar._viewModelStore = new Z();
            }
        }
    }

    public static void b(L l3) {
        try {
            super.onBackPressed();
        } catch (IllegalStateException e4) {
            if (kotlin.jvm.internal.j.a(e4.getMessage(), "Can not perform this action after onSaveInstanceState")) {
            } else {
                throw e4;
            }
        } catch (NullPointerException e5) {
            if (!kotlin.jvm.internal.j.a(e5.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                throw e5;
            }
        }
    }

    public static void c(L l3, InterfaceC0309t interfaceC0309t, EnumC0303m enumC0303m) {
        if (enumC0303m == EnumC0303m.ON_DESTROY) {
            ((m) l3).contextAwareHelper.f4410b = null;
            if (!l3.isChangingConfigurations()) {
                l3.getViewModelStore().a();
            }
            j jVar = (j) ((m) l3).reportFullyDrawnExecutor;
            L l4 = jVar.f3826d;
            l4.getWindow().getDecorView().removeCallbacks(jVar);
            l4.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(jVar);
        }
    }

    public static o d(L l3) {
        return new o(((m) l3).reportFullyDrawnExecutor, new d(l3, 0));
    }

    public static void e(L l3, Context it) {
        kotlin.jvm.internal.j.e(it, "it");
        Bundle a2 = l3.getSavedStateRegistry().a(ACTIVITY_RESULT_TAG);
        if (a2 != null) {
            e.h hVar = ((m) l3).activityResultRegistry;
            LinkedHashMap linkedHashMap = hVar.f4430b;
            LinkedHashMap linkedHashMap2 = hVar.f4429a;
            Bundle bundle = hVar.f4435g;
            ArrayList<Integer> integerArrayList = a2.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = a2.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (stringArrayList != null && integerArrayList != null) {
                ArrayList<String> stringArrayList2 = a2.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                if (stringArrayList2 != null) {
                    hVar.f4432d.addAll(stringArrayList2);
                }
                Bundle bundle2 = a2.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
                if (bundle2 != null) {
                    bundle.putAll(bundle2);
                }
                int size = stringArrayList.size();
                for (int i = 0; i < size; i++) {
                    String str = stringArrayList.get(i);
                    if (linkedHashMap.containsKey(str)) {
                        Integer num = (Integer) linkedHashMap.remove(str);
                        if (bundle.containsKey(str)) {
                            continue;
                        } else if (!(linkedHashMap2 instanceof G2.a)) {
                            linkedHashMap2.remove(num);
                        } else {
                            kotlin.jvm.internal.u.e(linkedHashMap2, "kotlin.collections.MutableMap");
                            throw null;
                        }
                    }
                    Integer num2 = integerArrayList.get(i);
                    kotlin.jvm.internal.j.d(num2, "get(...)");
                    int intValue = num2.intValue();
                    String str2 = stringArrayList.get(i);
                    kotlin.jvm.internal.j.d(str2, "get(...)");
                    String str3 = str2;
                    linkedHashMap2.put(Integer.valueOf(intValue), str3);
                    hVar.f4430b.put(str3, Integer.valueOf(intValue));
                }
            }
        }
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        i iVar = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.j.d(decorView, "getDecorView(...)");
        ((j) iVar).a(decorView);
        super.addContentView(view, layoutParams);
    }

    @Override // J.InterfaceC0123k
    public void addMenuProvider(InterfaceC0128p provider) {
        kotlin.jvm.internal.j.e(provider, "provider");
        C0127o c0127o = this.menuHostHelper;
        c0127o.f1019b.add(provider);
        c0127o.f1018a.run();
    }

    @Override // x.InterfaceC0776g
    public final void addOnConfigurationChangedListener(I.a listener) {
        kotlin.jvm.internal.j.e(listener, "listener");
        this.onConfigurationChangedListeners.add(listener);
    }

    public final void addOnContextAvailableListener(d.b listener) {
        kotlin.jvm.internal.j.e(listener, "listener");
        C0354a c0354a = this.contextAwareHelper;
        c0354a.getClass();
        m mVar = c0354a.f4410b;
        if (mVar != null) {
            listener.a(mVar);
        }
        c0354a.f4409a.add(listener);
    }

    @Override // w.q
    public final void addOnMultiWindowModeChangedListener(I.a listener) {
        kotlin.jvm.internal.j.e(listener, "listener");
        this.onMultiWindowModeChangedListeners.add(listener);
    }

    public final void addOnNewIntentListener(I.a listener) {
        kotlin.jvm.internal.j.e(listener, "listener");
        this.onNewIntentListeners.add(listener);
    }

    @Override // w.r
    public final void addOnPictureInPictureModeChangedListener(I.a listener) {
        kotlin.jvm.internal.j.e(listener, "listener");
        this.onPictureInPictureModeChangedListeners.add(listener);
    }

    @Override // x.InterfaceC0777h
    public final void addOnTrimMemoryListener(I.a listener) {
        kotlin.jvm.internal.j.e(listener, "listener");
        this.onTrimMemoryListeners.add(listener);
    }

    public final void addOnUserLeaveHintListener(Runnable listener) {
        kotlin.jvm.internal.j.e(listener, "listener");
        this.onUserLeaveHintListeners.add(listener);
    }

    @Override // e.i
    public final e.h getActivityResultRegistry() {
        return this.activityResultRegistry;
    }

    @Override // androidx.lifecycle.InterfaceC0299i
    public AbstractC0356b getDefaultViewModelCreationExtras() {
        Bundle bundle;
        C0357c c0357c = new C0357c(0);
        Application application = getApplication();
        LinkedHashMap linkedHashMap = c0357c.f4412a;
        if (application != null) {
            linkedHashMap.put(W.f3591d, getApplication());
        }
        linkedHashMap.put(P.f3574a, this);
        linkedHashMap.put(P.f3575b, this);
        Intent intent = getIntent();
        if (intent != null) {
            bundle = intent.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            linkedHashMap.put(P.f3576c, bundle);
        }
        return c0357c;
    }

    @Override // androidx.lifecycle.InterfaceC0299i
    public X getDefaultViewModelProviderFactory() {
        return (X) ((C0682g) this.defaultViewModelProviderFactory$delegate).a();
    }

    public o getFullyDrawnReporter() {
        return (o) ((C0682g) this.fullyDrawnReporter$delegate).a();
    }

    public Object getLastCustomNonConfigurationInstance() {
        h hVar = (h) getLastNonConfigurationInstance();
        if (hVar != null) {
            return hVar.f3821a;
        }
        return null;
    }

    @Override // w.f, androidx.lifecycle.InterfaceC0309t
    public AbstractC0305o getLifecycle() {
        return super.getLifecycle();
    }

    @Override // c.y
    public final x getOnBackPressedDispatcher() {
        return (x) ((C0682g) this.onBackPressedDispatcher$delegate).a();
    }

    @Override // l0.InterfaceC0516f
    public final C0514d getSavedStateRegistry() {
        return this.savedStateRegistryController.f5481b;
    }

    @Override // androidx.lifecycle.a0
    public Z getViewModelStore() {
        if (getApplication() != null) {
            if (this._viewModelStore == null) {
                h hVar = (h) getLastNonConfigurationInstance();
                if (hVar != null) {
                    this._viewModelStore = hVar.f3822b;
                }
                if (this._viewModelStore == null) {
                    this._viewModelStore = new Z();
                }
            }
            Z z3 = this._viewModelStore;
            kotlin.jvm.internal.j.b(z3);
            return z3;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public void initializeViewTreeOwners() {
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.j.d(decorView, "getDecorView(...)");
        P.f(decorView, this);
        View decorView2 = getWindow().getDecorView();
        kotlin.jvm.internal.j.d(decorView2, "getDecorView(...)");
        decorView2.setTag(R.id.view_tree_view_model_store_owner, this);
        View decorView3 = getWindow().getDecorView();
        kotlin.jvm.internal.j.d(decorView3, "getDecorView(...)");
        T.b.H(decorView3, this);
        View decorView4 = getWindow().getDecorView();
        kotlin.jvm.internal.j.d(decorView4, "getDecorView(...)");
        decorView4.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        View decorView5 = getWindow().getDecorView();
        kotlin.jvm.internal.j.d(decorView5, "getDecorView(...)");
        decorView5.setTag(R.id.report_drawn, this);
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i3, Intent intent) {
        if (!this.activityResultRegistry.a(i, i3, intent)) {
            super.onActivityResult(i, i3, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        getOnBackPressedDispatcher().c();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.j.e(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Iterator<I.a> it = this.onConfigurationChangedListeners.iterator();
        kotlin.jvm.internal.j.d(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(newConfig);
        }
    }

    @Override // w.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.savedStateRegistryController.b(bundle);
        C0354a c0354a = this.contextAwareHelper;
        c0354a.getClass();
        c0354a.f4410b = this;
        Iterator it = c0354a.f4409a.iterator();
        while (it.hasNext()) {
            ((d.b) it.next()).a(this);
        }
        super.onCreate(bundle);
        int i = J.f3558b;
        H.b(this);
        int i3 = this.contentLayoutId;
        if (i3 != 0) {
            setContentView(i3);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        kotlin.jvm.internal.j.e(menu, "menu");
        if (i == 0) {
            super.onCreatePanelMenu(i, menu);
            C0127o c0127o = this.menuHostHelper;
            MenuInflater menuInflater = getMenuInflater();
            Iterator it = c0127o.f1019b.iterator();
            while (it.hasNext()) {
                ((Y) ((InterfaceC0128p) it.next())).f3332a.k(menu, menuInflater);
            }
            return true;
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem item) {
        kotlin.jvm.internal.j.e(item, "item");
        if (super.onMenuItemSelected(i, item)) {
            return true;
        }
        if (i == 0) {
            return this.menuHostHelper.a(item);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z3) {
        if (this.dispatchingOnMultiWindowModeChanged) {
            return;
        }
        Iterator<I.a> it = this.onMultiWindowModeChangedListeners.iterator();
        kotlin.jvm.internal.j.d(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(new w.g(z3));
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        kotlin.jvm.internal.j.e(intent, "intent");
        super.onNewIntent(intent);
        Iterator<I.a> it = this.onNewIntentListeners.iterator();
        kotlin.jvm.internal.j.d(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        kotlin.jvm.internal.j.e(menu, "menu");
        Iterator it = this.menuHostHelper.f1019b.iterator();
        while (it.hasNext()) {
            ((Y) ((InterfaceC0128p) it.next())).f3332a.q(menu);
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z3) {
        if (this.dispatchingOnPictureInPictureModeChanged) {
            return;
        }
        Iterator<I.a> it = this.onPictureInPictureModeChangedListeners.iterator();
        kotlin.jvm.internal.j.d(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(new w.s(z3));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        kotlin.jvm.internal.j.e(menu, "menu");
        if (i == 0) {
            super.onPreparePanel(i, view, menu);
            Iterator it = this.menuHostHelper.f1019b.iterator();
            while (it.hasNext()) {
                ((Y) ((InterfaceC0128p) it.next())).f3332a.t(menu);
            }
            return true;
        }
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] permissions, int[] grantResults) {
        kotlin.jvm.internal.j.e(permissions, "permissions");
        kotlin.jvm.internal.j.e(grantResults, "grantResults");
        if (!this.activityResultRegistry.a(i, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", permissions).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", grantResults))) {
            super.onRequestPermissionsResult(i, permissions, grantResults);
        }
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, c.h] */
    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        h hVar;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        Z z3 = this._viewModelStore;
        if (z3 == null && (hVar = (h) getLastNonConfigurationInstance()) != null) {
            z3 = hVar.f3822b;
        }
        if (z3 == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        ?? obj = new Object();
        obj.f3821a = onRetainCustomNonConfigurationInstance;
        obj.f3822b = z3;
        return obj;
    }

    @Override // w.f, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.j.e(outState, "outState");
        if (getLifecycle() instanceof C0311v) {
            AbstractC0305o lifecycle = getLifecycle();
            kotlin.jvm.internal.j.c(lifecycle, "null cannot be cast to non-null type androidx.lifecycle.LifecycleRegistry");
            ((C0311v) lifecycle).g();
        }
        super.onSaveInstanceState(outState);
        this.savedStateRegistryController.c(outState);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        Iterator<I.a> it = this.onTrimMemoryListeners.iterator();
        kotlin.jvm.internal.j.d(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i));
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        Iterator<Runnable> it = this.onUserLeaveHintListeners.iterator();
        kotlin.jvm.internal.j.d(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().run();
        }
    }

    public Context peekAvailableContext() {
        return this.contextAwareHelper.f4410b;
    }

    public final <I, O> e.c registerForActivityResult(AbstractC0365a contract, e.h registry, e.b callback) {
        kotlin.jvm.internal.j.e(contract, "contract");
        kotlin.jvm.internal.j.e(registry, "registry");
        kotlin.jvm.internal.j.e(callback, "callback");
        return registry.c("activity_rq#" + this.nextLocalRequestCode.getAndIncrement(), this, contract, callback);
    }

    @Override // J.InterfaceC0123k
    public void removeMenuProvider(InterfaceC0128p provider) {
        kotlin.jvm.internal.j.e(provider, "provider");
        this.menuHostHelper.b(provider);
    }

    @Override // x.InterfaceC0776g
    public final void removeOnConfigurationChangedListener(I.a listener) {
        kotlin.jvm.internal.j.e(listener, "listener");
        this.onConfigurationChangedListeners.remove(listener);
    }

    public final void removeOnContextAvailableListener(d.b listener) {
        kotlin.jvm.internal.j.e(listener, "listener");
        C0354a c0354a = this.contextAwareHelper;
        c0354a.getClass();
        c0354a.f4409a.remove(listener);
    }

    @Override // w.q
    public final void removeOnMultiWindowModeChangedListener(I.a listener) {
        kotlin.jvm.internal.j.e(listener, "listener");
        this.onMultiWindowModeChangedListeners.remove(listener);
    }

    public final void removeOnNewIntentListener(I.a listener) {
        kotlin.jvm.internal.j.e(listener, "listener");
        this.onNewIntentListeners.remove(listener);
    }

    @Override // w.r
    public final void removeOnPictureInPictureModeChangedListener(I.a listener) {
        kotlin.jvm.internal.j.e(listener, "listener");
        this.onPictureInPictureModeChangedListeners.remove(listener);
    }

    @Override // x.InterfaceC0777h
    public final void removeOnTrimMemoryListener(I.a listener) {
        kotlin.jvm.internal.j.e(listener, "listener");
        this.onTrimMemoryListeners.remove(listener);
    }

    public final void removeOnUserLeaveHintListener(Runnable listener) {
        kotlin.jvm.internal.j.e(listener, "listener");
        this.onUserLeaveHintListeners.remove(listener);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (AbstractC0228a.x()) {
                Trace.beginSection(AbstractC0228a.D("reportFullyDrawn() for ComponentActivity"));
            }
            super.reportFullyDrawn();
            o fullyDrawnReporter = getFullyDrawnReporter();
            synchronized (fullyDrawnReporter.f3836b) {
                try {
                    fullyDrawnReporter.f3837c = true;
                    ArrayList arrayList = fullyDrawnReporter.f3838d;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((F2.a) obj).invoke();
                    }
                    fullyDrawnReporter.f3838d.clear();
                } finally {
                }
            }
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        initializeViewTreeOwners();
        i iVar = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.j.d(decorView, "getDecorView(...)");
        ((j) iVar).a(decorView);
        super.setContentView(i);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        kotlin.jvm.internal.j.e(intent, "intent");
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intent, int i, Intent intent2, int i3, int i4, int i5) {
        kotlin.jvm.internal.j.e(intent, "intent");
        super.startIntentSenderForResult(intent, i, intent2, i3, i4, i5);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        kotlin.jvm.internal.j.e(intent, "intent");
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intent, int i, Intent intent2, int i3, int i4, int i5, Bundle bundle) {
        kotlin.jvm.internal.j.e(intent, "intent");
        super.startIntentSenderForResult(intent, i, intent2, i3, i4, i5, bundle);
    }

    public final <I, O> e.c registerForActivityResult(AbstractC0365a contract, e.b callback) {
        kotlin.jvm.internal.j.e(contract, "contract");
        kotlin.jvm.internal.j.e(callback, "callback");
        return registerForActivityResult(contract, this.activityResultRegistry, callback);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z3, Configuration newConfig) {
        kotlin.jvm.internal.j.e(newConfig, "newConfig");
        this.dispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z3, newConfig);
            this.dispatchingOnMultiWindowModeChanged = false;
            Iterator<I.a> it = this.onMultiWindowModeChangedListeners.iterator();
            kotlin.jvm.internal.j.d(it, "iterator(...)");
            while (it.hasNext()) {
                it.next().accept(new w.g(z3));
            }
        } catch (Throwable th) {
            this.dispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z3, Configuration newConfig) {
        kotlin.jvm.internal.j.e(newConfig, "newConfig");
        this.dispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z3, newConfig);
            this.dispatchingOnPictureInPictureModeChanged = false;
            Iterator<I.a> it = this.onPictureInPictureModeChangedListeners.iterator();
            kotlin.jvm.internal.j.d(it, "iterator(...)");
            while (it.hasNext()) {
                it.next().accept(new w.s(z3));
            }
        } catch (Throwable th) {
            this.dispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        initializeViewTreeOwners();
        i iVar = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.j.d(decorView, "getDecorView(...)");
        ((j) iVar).a(decorView);
        super.setContentView(view);
    }

    public void addMenuProvider(InterfaceC0128p provider, InterfaceC0309t owner) {
        kotlin.jvm.internal.j.e(provider, "provider");
        kotlin.jvm.internal.j.e(owner, "owner");
        C0127o c0127o = this.menuHostHelper;
        c0127o.f1019b.add(provider);
        c0127o.f1018a.run();
        AbstractC0305o lifecycle = owner.getLifecycle();
        HashMap hashMap = c0127o.f1020c;
        C0126n c0126n = (C0126n) hashMap.remove(provider);
        if (c0126n != null) {
            c0126n.f1016a.b(c0126n.f1017b);
            c0126n.f1017b = null;
        }
        hashMap.put(provider, new C0126n(lifecycle, new C0125m(0, c0127o, provider)));
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        i iVar = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.j.d(decorView, "getDecorView(...)");
        ((j) iVar).a(decorView);
        super.setContentView(view, layoutParams);
    }

    public void addMenuProvider(final InterfaceC0128p provider, InterfaceC0309t owner, final EnumC0304n state) {
        kotlin.jvm.internal.j.e(provider, "provider");
        kotlin.jvm.internal.j.e(owner, "owner");
        kotlin.jvm.internal.j.e(state, "state");
        final C0127o c0127o = this.menuHostHelper;
        c0127o.getClass();
        AbstractC0305o lifecycle = owner.getLifecycle();
        HashMap hashMap = c0127o.f1020c;
        C0126n c0126n = (C0126n) hashMap.remove(provider);
        if (c0126n != null) {
            c0126n.f1016a.b(c0126n.f1017b);
            c0126n.f1017b = null;
        }
        hashMap.put(provider, new C0126n(lifecycle, new androidx.lifecycle.r() { // from class: J.l
            @Override // androidx.lifecycle.r
            public final void a(InterfaceC0309t interfaceC0309t, EnumC0303m enumC0303m) {
                EnumC0303m enumC0303m2;
                C0127o c0127o2 = C0127o.this;
                c0127o2.getClass();
                Runnable runnable = c0127o2.f1018a;
                CopyOnWriteArrayList copyOnWriteArrayList = c0127o2.f1019b;
                EnumC0303m.Companion.getClass();
                EnumC0304n enumC0304n = state;
                int ordinal = enumC0304n.ordinal();
                EnumC0303m enumC0303m3 = null;
                if (ordinal != 2) {
                    if (ordinal != 3) {
                        if (ordinal != 4) {
                            enumC0303m2 = null;
                        } else {
                            enumC0303m2 = EnumC0303m.ON_RESUME;
                        }
                    } else {
                        enumC0303m2 = EnumC0303m.ON_START;
                    }
                } else {
                    enumC0303m2 = EnumC0303m.ON_CREATE;
                }
                InterfaceC0128p interfaceC0128p = provider;
                if (enumC0303m == enumC0303m2) {
                    copyOnWriteArrayList.add(interfaceC0128p);
                    runnable.run();
                    return;
                }
                EnumC0303m enumC0303m4 = EnumC0303m.ON_DESTROY;
                if (enumC0303m == enumC0303m4) {
                    c0127o2.b(interfaceC0128p);
                    return;
                }
                int ordinal2 = enumC0304n.ordinal();
                if (ordinal2 != 2) {
                    if (ordinal2 != 3) {
                        if (ordinal2 == 4) {
                            enumC0303m3 = EnumC0303m.ON_PAUSE;
                        }
                    } else {
                        enumC0303m3 = EnumC0303m.ON_STOP;
                    }
                } else {
                    enumC0303m3 = enumC0303m4;
                }
                if (enumC0303m == enumC0303m3) {
                    copyOnWriteArrayList.remove(interfaceC0128p);
                    runnable.run();
                }
            }
        }));
    }

    public static /* synthetic */ void getOnBackPressedDispatcher$annotations() {
    }
}
