package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Bundle;

/* loaded from: classes.dex */
final class zzfs implements Runnable {
    private final /* synthetic */ zzga zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ Context zzd;
    private final /* synthetic */ zzew zze;
    private final /* synthetic */ BroadcastReceiver.PendingResult zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfs(zzfq zzfqVar, zzga zzgaVar, long j, Bundle bundle, Context context, zzew zzewVar, BroadcastReceiver.PendingResult pendingResult) {
        this.zza = zzgaVar;
        this.zzb = j;
        this.zzc = bundle;
        this.zzd = context;
        this.zze = zzewVar;
        this.zzf = pendingResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long zza = this.zza.zzc().zzh.zza();
        long j = this.zzb;
        if (zza > 0 && (j >= zza || j <= 0)) {
            j = zza - 1;
        }
        if (j > 0) {
            this.zzc.putLong("click_timestamp", j);
        }
        this.zzc.putString("_cis", "referrer broadcast");
        zzga.zza(this.zzd, null).zzh().zza("auto", "_cmp", this.zzc);
        this.zze.zzx().zza("Install campaign recorded");
        BroadcastReceiver.PendingResult pendingResult = this.zzf;
        if (pendingResult != null) {
            pendingResult.finish();
        }
    }
}
