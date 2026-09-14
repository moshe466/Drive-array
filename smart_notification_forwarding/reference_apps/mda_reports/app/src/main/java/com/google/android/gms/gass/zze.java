package com.google.android.gms.gass;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbs;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: classes.dex */
public final class zze implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private final String packageName;
    private final HandlerThread zzdup = new HandlerThread("GassClient");

    @VisibleForTesting
    private com.google.android.gms.gass.internal.zzd zzgsb;
    private final String zzgsc;
    private final LinkedBlockingQueue<zzbs.zza> zzgsd;

    public zze(Context context, String str, String str2) {
        this.packageName = str;
        this.zzgsc = str2;
        this.zzdup.start();
        this.zzgsb = new com.google.android.gms.gass.internal.zzd(context, this.zzdup.getLooper(), this, this);
        this.zzgsd = new LinkedBlockingQueue<>();
        this.zzgsb.checkAvailabilityAndConnect();
    }

    private final void zzalu() {
        com.google.android.gms.gass.internal.zzd zzdVar = this.zzgsb;
        if (zzdVar != null) {
            if (zzdVar.isConnected() || this.zzgsb.isConnecting()) {
                this.zzgsb.disconnect();
            }
        }
    }

    private final com.google.android.gms.gass.internal.zzg zzaqh() {
        try {
            return this.zzgsb.zzaqp();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }

    @VisibleForTesting
    private static zzbs.zza zzaqi() {
        return (zzbs.zza) zzbs.zza.zzan().zzau(PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID).zzbaf();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        com.google.android.gms.gass.internal.zzg zzaqh = zzaqh();
        if (zzaqh != null) {
            try {
                try {
                    this.zzgsd.put(zzaqh.zza(new com.google.android.gms.gass.internal.zzc(this.packageName, this.zzgsc)).zzaqq());
                } catch (Throwable unused) {
                    this.zzgsd.put(zzaqi());
                }
            } catch (InterruptedException unused2) {
            } catch (Throwable th) {
                zzalu();
                this.zzdup.quit();
                throw th;
            }
            zzalu();
            this.zzdup.quit();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.zzgsd.put(zzaqi());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        try {
            this.zzgsd.put(zzaqi());
        } catch (InterruptedException unused) {
        }
    }

    public final zzbs.zza zzdn(int i) {
        zzbs.zza zzaVar;
        try {
            zzaVar = this.zzgsd.poll(5000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            zzaVar = null;
        }
        return zzaVar == null ? zzaqi() : zzaVar;
    }
}
