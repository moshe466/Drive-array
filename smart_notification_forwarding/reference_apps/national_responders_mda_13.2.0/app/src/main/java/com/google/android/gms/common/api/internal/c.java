package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class c implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: j, reason: collision with root package name */
    private static final c f4792j = new c();

    /* renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f4793f = new AtomicBoolean();

    /* renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f4794g = new AtomicBoolean();

    /* renamed from: h, reason: collision with root package name */
    private final ArrayList f4795h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private boolean f4796i = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z10);
    }

    private c() {
    }

    public static c b() {
        return f4792j;
    }

    public static void c(Application application) {
        c cVar = f4792j;
        synchronized (cVar) {
            if (!cVar.f4796i) {
                application.registerActivityLifecycleCallbacks(cVar);
                application.registerComponentCallbacks(cVar);
                cVar.f4796i = true;
            }
        }
    }

    private final void f(boolean z10) {
        synchronized (f4792j) {
            Iterator it = this.f4795h.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(z10);
            }
        }
    }

    public void a(a aVar) {
        synchronized (f4792j) {
            this.f4795h.add(aVar);
        }
    }

    public boolean d() {
        return this.f4793f.get();
    }

    @TargetApi(16)
    public boolean e(boolean z10) {
        if (!this.f4794g.get()) {
            if (!g2.l.b()) {
                return z10;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f4794g.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f4793f.set(true);
            }
        }
        return d();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.f4793f.compareAndSet(true, false);
        this.f4794g.set(true);
        if (compareAndSet) {
            f(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.f4793f.compareAndSet(true, false);
        this.f4794g.set(true);
        if (compareAndSet) {
            f(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i10) {
        if (i10 == 20 && this.f4793f.compareAndSet(false, true)) {
            this.f4794g.set(true);
            f(true);
        }
    }
}
