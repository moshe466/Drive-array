package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzqe {
    private final Object zzboy = new Object();

    @GuardedBy("activityTrackerLock")
    private zzqh zzboz = null;

    @GuardedBy("activityTrackerLock")
    private boolean zzbpa = false;

    @Nullable
    public final Activity getActivity() {
        synchronized (this.zzboy) {
            if (this.zzboz == null) {
                return null;
            }
            return this.zzboz.getActivity();
        }
    }

    @Nullable
    public final Context getContext() {
        synchronized (this.zzboy) {
            if (this.zzboz == null) {
                return null;
            }
            return this.zzboz.getContext();
        }
    }

    public final void initialize(Context context) {
        synchronized (this.zzboy) {
            if (!this.zzbpa) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                if (application == null) {
                    zzayu.zzez("Can not cast Context to Application");
                    return;
                }
                if (this.zzboz == null) {
                    this.zzboz = new zzqh();
                }
                this.zzboz.zza(application, context);
                this.zzbpa = true;
            }
        }
    }

    public final void zza(zzqj zzqjVar) {
        synchronized (this.zzboy) {
            if (this.zzboz == null) {
                this.zzboz = new zzqh();
            }
            this.zzboz.zza(zzqjVar);
        }
    }

    public final void zzb(zzqj zzqjVar) {
        synchronized (this.zzboy) {
            if (this.zzboz == null) {
                return;
            }
            this.zzboz.zzb(zzqjVar);
        }
    }
}
