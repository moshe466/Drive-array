package com.google.android.gms.gass;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.gass.internal.zzm;
import com.google.android.gms.gass.internal.zzo;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: classes.dex */
public final class zzg implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private final long startTime;

    @VisibleForTesting
    private com.google.android.gms.gass.internal.zzd zzgsb;
    private final LinkedBlockingQueue<zzo> zzgsd;
    private final String zzgsf;
    private final String zzgsg;
    private final AdShield2Logger zzus;
    private final int zzgsh = 1;
    private final HandlerThread zzdup = new HandlerThread("GassDGClient");

    public zzg(Context context, int i, String str, String str2, String str3, AdShield2Logger adShield2Logger) {
        this.zzgsf = str;
        this.zzgsg = str2;
        this.zzus = adShield2Logger;
        this.zzdup.start();
        this.startTime = System.currentTimeMillis();
        this.zzgsb = new com.google.android.gms.gass.internal.zzd(context, this.zzdup.getLooper(), this, this);
        this.zzgsd = new LinkedBlockingQueue<>();
        this.zzgsb.checkAvailabilityAndConnect();
    }

    private final void zza(int i, long j, Exception exc) {
        AdShield2Logger adShield2Logger = this.zzus;
        if (adShield2Logger != null) {
            adShield2Logger.logException(i, System.currentTimeMillis() - j, exc);
        }
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
    private static zzo zzaqj() {
        return new zzo(null);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        com.google.android.gms.gass.internal.zzg zzaqh = zzaqh();
        if (zzaqh != null) {
            try {
                this.zzgsd.put(zzaqh.zza(new zzm(this.zzgsh, this.zzgsf, this.zzgsg)));
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.zzgsd.put(zzaqj());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        try {
            this.zzgsd.put(zzaqj());
        } catch (InterruptedException unused) {
        }
    }

    public final zzo zzdo(int i) {
        zzo zzoVar;
        try {
            zzoVar = this.zzgsd.poll(50000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            zza(AdShield2Logger.EVENTID_GASSDGCLIENT_EXCEPTION, this.startTime, e);
            zzoVar = null;
        }
        zza(AdShield2Logger.EVENTID_LATENCY_GASSDGCLIENT_GET_PROGRAM, this.startTime, null);
        return zzoVar == null ? zzaqj() : zzoVar;
    }
}
