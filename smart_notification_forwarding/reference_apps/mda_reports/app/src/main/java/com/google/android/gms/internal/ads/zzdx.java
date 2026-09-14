package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class zzdx implements Application.ActivityLifecycleCallbacks {
    private final Application zzxa;
    private final WeakReference<Application.ActivityLifecycleCallbacks> zzxb;
    private boolean zzxc = false;

    public zzdx(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzxb = new WeakReference<>(activityLifecycleCallbacks);
        this.zzxa = application;
    }

    private final void zza(zzef zzefVar) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.zzxb.get();
            if (activityLifecycleCallbacks != null) {
                zzefVar.zza(activityLifecycleCallbacks);
            } else {
                if (this.zzxc) {
                    return;
                }
                this.zzxa.unregisterActivityLifecycleCallbacks(this);
                this.zzxc = true;
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzdw(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zza(new zzec(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zza(new zzeb(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zza(new zzdy(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzed(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zza(new zzdz(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        zza(new zzea(this, activity));
    }
}
