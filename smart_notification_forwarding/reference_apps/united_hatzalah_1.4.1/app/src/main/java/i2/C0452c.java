package i2;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.InterfaceC0309t;
import kotlin.jvm.internal.j;

/* renamed from: i2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0452c implements Application.ActivityLifecycleCallbacks, DefaultLifecycleObserver {

    /* renamed from: a, reason: collision with root package name */
    public final Activity f4988a;

    public C0452c(Activity activity) {
        this.f4988a = activity;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        j.e(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        j.e(activity, "activity");
        if (this.f4988a == activity && activity.getApplicationContext() != null) {
            Context applicationContext = activity.getApplicationContext();
            j.c(applicationContext, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext).unregisterActivityLifecycleCallbacks(this);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        j.e(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        j.e(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        j.e(activity, "activity");
        j.e(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        j.e(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        j.e(activity, "activity");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onDestroy(InterfaceC0309t interfaceC0309t) {
        onActivityDestroyed(this.f4988a);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onCreate(InterfaceC0309t interfaceC0309t) {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onPause(InterfaceC0309t interfaceC0309t) {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onResume(InterfaceC0309t interfaceC0309t) {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStart(InterfaceC0309t interfaceC0309t) {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStop(InterfaceC0309t interfaceC0309t) {
    }
}
