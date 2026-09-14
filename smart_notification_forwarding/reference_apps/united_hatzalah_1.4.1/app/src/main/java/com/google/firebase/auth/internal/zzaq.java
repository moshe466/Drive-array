package com.google.firebase.auth.internal;

import F0.AbstractC0008a;
import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.util.DefaultClock;
import com.google.firebase.FirebaseApp;

/* loaded from: classes.dex */
public final class zzaq {
    private static Logger zzc = new Logger("TokenRefresher", "FirebaseAuth:");
    volatile long zza;
    volatile long zzb;
    private final FirebaseApp zzd;
    private long zze;
    private HandlerThread zzf;
    private Handler zzg;
    private Runnable zzh;

    public zzaq(FirebaseApp firebaseApp) {
        zzc.v("Initializing TokenRefresher", new Object[0]);
        FirebaseApp firebaseApp2 = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
        this.zzd = firebaseApp2;
        HandlerThread handlerThread = new HandlerThread("TokenRefresher", 10);
        this.zzf = handlerThread;
        handlerThread.start();
        this.zzg = new com.google.android.gms.internal.p002firebaseauthapi.zze(this.zzf.getLooper());
        this.zzh = new zzat(this, firebaseApp2.getName());
        this.zze = 300000L;
    }

    public final void zzb() {
        this.zzg.removeCallbacks(this.zzh);
    }

    public final void zzc() {
        zzc.v(AbstractC0008a.l("Scheduling refresh for ", this.zza - this.zze), new Object[0]);
        zzb();
        this.zzb = Math.max((this.zza - DefaultClock.getInstance().currentTimeMillis()) - this.zze, 0L) / 1000;
        this.zzg.postDelayed(this.zzh, this.zzb * 1000);
    }

    public final void zzd() {
        long j2;
        int i = (int) this.zzb;
        if (i != 30 && i != 60 && i != 120 && i != 240 && i != 480) {
            if (i != 960) {
                j2 = 30;
            } else {
                j2 = 960;
            }
        } else {
            j2 = 2 * this.zzb;
        }
        this.zzb = j2;
        this.zza = (this.zzb * 1000) + DefaultClock.getInstance().currentTimeMillis();
        zzc.v(AbstractC0008a.l("Scheduling refresh for ", this.zza), new Object[0]);
        this.zzg.postDelayed(this.zzh, this.zzb * 1000);
    }
}
