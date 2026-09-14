package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class zzpv implements Application.ActivityLifecycleCallbacks {
    private final Application zzxa;
    private final WeakReference<Application.ActivityLifecycleCallbacks> zzxb;
    private boolean zzxc = false;

    public zzpv(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzxb = new WeakReference<>(activityLifecycleCallbacks);
        this.zzxa = application;
    }

    private final void zza(zzqd zzqdVar) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.zzxb.get();
            if (activityLifecycleCallbacks != null) {
                zzqdVar.zza(activityLifecycleCallbacks);
            } else {
                if (this.zzxc) {
                    return;
                }
                this.zzxa.unregisterActivityLifecycleCallbacks(this);
                this.zzxc = true;
            }
        } catch (Exception e) {
            zzayu.zzc("Error while dispatching lifecycle callback.", e);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzpu(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zza(new zzqa(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zza(new zzpz(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zza(new zzpw(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzqb(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zza(new zzpx(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        zza(new zzpy(this, activity));
    }
}
