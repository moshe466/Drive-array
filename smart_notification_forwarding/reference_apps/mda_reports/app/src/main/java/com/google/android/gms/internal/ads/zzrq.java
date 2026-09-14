package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzrq {

    @Nullable
    @GuardedBy("lock")
    private zzrz zzbrd;

    @Nullable
    @GuardedBy("lock")
    private zzsd zzbre;

    @Nullable
    @GuardedBy("lock")
    private Context zzup;
    private final Runnable zzbrc = new zzrt(this);
    private final Object lock = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzrz a(zzrq zzrqVar, zzrz zzrzVar) {
        zzrqVar.zzbrd = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void connect() {
        synchronized (this.lock) {
            if (this.zzup != null && this.zzbrd == null) {
                this.zzbrd = zza(new zzrv(this), new zzru(this));
                this.zzbrd.checkAvailabilityAndConnect();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disconnect() {
        synchronized (this.lock) {
            if (this.zzbrd == null) {
                return;
            }
            if (this.zzbrd.isConnected() || this.zzbrd.isConnecting()) {
                this.zzbrd.disconnect();
            }
            this.zzbrd = null;
            this.zzbre = null;
            Binder.flushPendingCommands();
        }
    }

    @VisibleForTesting
    private final synchronized zzrz zza(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zzrz(this.zzup, com.google.android.gms.ads.internal.zzq.zzle().zzxb(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }

    public final void initialize(Context context) {
        if (context == null) {
            return;
        }
        synchronized (this.lock) {
            if (this.zzup != null) {
                return;
            }
            this.zzup = context.getApplicationContext();
            if (((Boolean) zzve.zzoy().zzd(zzzn.zzcmz)).booleanValue()) {
                connect();
            } else {
                if (((Boolean) zzve.zzoy().zzd(zzzn.zzcmy)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzq.zzkt().zza(new zzrs(this));
                }
            }
        }
    }

    public final zzrx zza(zzry zzryVar) {
        synchronized (this.lock) {
            if (this.zzbre == null) {
                return new zzrx();
            }
            try {
                return this.zzbre.zza(zzryVar);
            } catch (RemoteException e) {
                zzayu.zzc("Unable to call into cache service.", e);
                return new zzrx();
            }
        }
    }

    public final void zzmo() {
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcna)).booleanValue()) {
            synchronized (this.lock) {
                connect();
                com.google.android.gms.ads.internal.zzq.zzkq();
                zzawb.zzdsr.removeCallbacks(this.zzbrc);
                com.google.android.gms.ads.internal.zzq.zzkq();
                zzawb.zzdsr.postDelayed(this.zzbrc, ((Long) zzve.zzoy().zzd(zzzn.zzcnb)).longValue());
            }
        }
    }
}
