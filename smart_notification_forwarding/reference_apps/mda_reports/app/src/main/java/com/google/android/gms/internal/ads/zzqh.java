package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: Access modifiers changed from: package-private */
@TargetApi(14)
/* loaded from: classes.dex */
public final class zzqh implements Application.ActivityLifecycleCallbacks {
    private Runnable zzbph;
    private long zzbpi;
    private Context zzup;

    @Nullable
    private Activity zzzk;
    private final Object lock = new Object();
    private boolean foreground = true;
    private boolean zzbpe = false;

    @GuardedBy("lock")
    private final List<zzqj> zzbpf = new ArrayList();

    @GuardedBy("lock")
    private final List<zzqu> zzbpg = new ArrayList();
    private boolean zzxx = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean a(zzqh zzqhVar, boolean z) {
        zzqhVar.foreground = false;
        return false;
    }

    private final void setActivity(Activity activity) {
        synchronized (this.lock) {
            if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                this.zzzk = activity;
            }
        }
    }

    @Nullable
    public final Activity getActivity() {
        return this.zzzk;
    }

    @Nullable
    public final Context getContext() {
        return this.zzup;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.lock) {
            if (this.zzzk == null) {
                return;
            }
            if (this.zzzk.equals(activity)) {
                this.zzzk = null;
            }
            Iterator<zzqu> it = this.zzbpg.iterator();
            while (it.hasNext()) {
                try {
                    if (it.next().zza(activity)) {
                        it.remove();
                    }
                } catch (Exception e) {
                    com.google.android.gms.ads.internal.zzq.zzku().zza(e, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                    zzayu.zzc("", e);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        setActivity(activity);
        synchronized (this.lock) {
            Iterator<zzqu> it = this.zzbpg.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onActivityPaused(activity);
                } catch (Exception e) {
                    com.google.android.gms.ads.internal.zzq.zzku().zza(e, "AppActivityTracker.ActivityListener.onActivityPaused");
                    zzayu.zzc("", e);
                }
            }
        }
        this.zzbpe = true;
        Runnable runnable = this.zzbph;
        if (runnable != null) {
            zzawb.zzdsr.removeCallbacks(runnable);
        }
        zzddu zzdduVar = zzawb.zzdsr;
        zzqg zzqgVar = new zzqg(this);
        this.zzbph = zzqgVar;
        zzdduVar.postDelayed(zzqgVar, this.zzbpi);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        setActivity(activity);
        this.zzbpe = false;
        boolean z = !this.foreground;
        this.foreground = true;
        Runnable runnable = this.zzbph;
        if (runnable != null) {
            zzawb.zzdsr.removeCallbacks(runnable);
        }
        synchronized (this.lock) {
            Iterator<zzqu> it = this.zzbpg.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onActivityResumed(activity);
                } catch (Exception e) {
                    com.google.android.gms.ads.internal.zzq.zzku().zza(e, "AppActivityTracker.ActivityListener.onActivityResumed");
                    zzayu.zzc("", e);
                }
            }
            if (z) {
                Iterator<zzqj> it2 = this.zzbpf.iterator();
                while (it2.hasNext()) {
                    try {
                        it2.next().zzp(true);
                    } catch (Exception e2) {
                        zzayu.zzc("", e2);
                    }
                }
            } else {
                zzayu.zzea("App is still foreground.");
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        setActivity(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    public final void zza(Application application, Context context) {
        if (this.zzxx) {
            return;
        }
        application.registerActivityLifecycleCallbacks(this);
        if (context instanceof Activity) {
            setActivity((Activity) context);
        }
        this.zzup = application;
        this.zzbpi = ((Long) zzve.zzoy().zzd(zzzn.zzcjb)).longValue();
        this.zzxx = true;
    }

    public final void zza(zzqj zzqjVar) {
        synchronized (this.lock) {
            this.zzbpf.add(zzqjVar);
        }
    }

    public final void zzb(zzqj zzqjVar) {
        synchronized (this.lock) {
            this.zzbpf.remove(zzqjVar);
        }
    }
}
