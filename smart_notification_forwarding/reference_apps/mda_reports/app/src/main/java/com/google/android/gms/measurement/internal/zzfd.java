package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class zzfd extends BroadcastReceiver {

    @VisibleForTesting
    private static final String zza = zzfd.class.getName();
    private final zzke zzb;
    private boolean zzc;
    private boolean zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfd(zzke zzkeVar) {
        Preconditions.checkNotNull(zzkeVar);
        this.zzb = zzkeVar;
    }

    @Override // android.content.BroadcastReceiver
    @MainThread
    public void onReceive(Context context, Intent intent) {
        this.zzb.b();
        String action = intent.getAction();
        this.zzb.zzr().zzx().zza("NetworkBroadcastReceiver received action", action);
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            this.zzb.zzr().zzi().zza("NetworkBroadcastReceiver received unknown action", action);
            return;
        }
        boolean zzf = this.zzb.zzd().zzf();
        if (this.zzd != zzf) {
            this.zzd = zzf;
            this.zzb.zzq().zza(new zzfg(this, zzf));
        }
    }

    @WorkerThread
    public final void zza() {
        this.zzb.b();
        this.zzb.zzq().zzd();
        if (this.zzc) {
            return;
        }
        this.zzb.zzn().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.zzd = this.zzb.zzd().zzf();
        this.zzb.zzr().zzx().zza("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzd));
        this.zzc = true;
    }

    @WorkerThread
    public final void zzb() {
        this.zzb.b();
        this.zzb.zzq().zzd();
        this.zzb.zzq().zzd();
        if (this.zzc) {
            this.zzb.zzr().zzx().zza("Unregistering connectivity change receiver");
            this.zzc = false;
            this.zzd = false;
            try {
                this.zzb.zzn().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.zzb.zzr().zzf().zza("Failed to unregister the network broadcast receiver", e);
            }
        }
    }
}
