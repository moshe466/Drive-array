package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzir implements Runnable {
    private final /* synthetic */ zzif zza;
    private final /* synthetic */ zzij zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzir(zzij zzijVar, zzif zzifVar) {
        this.zzb = zzijVar;
        this.zza = zzifVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzeo zzeoVar;
        long j;
        String str;
        String str2;
        String packageName;
        zzeoVar = this.zzb.zzb;
        if (zzeoVar == null) {
            this.zzb.zzr().zzf().zza("Failed to send current screen to service");
            return;
        }
        try {
            if (this.zza == null) {
                j = 0;
                str = null;
                str2 = null;
                packageName = this.zzb.zzn().getPackageName();
            } else {
                j = this.zza.zzc;
                str = this.zza.zza;
                str2 = this.zza.zzb;
                packageName = this.zzb.zzn().getPackageName();
            }
            zzeoVar.zza(j, str, str2, packageName);
            this.zzb.zzaj();
        } catch (RemoteException e) {
            this.zzb.zzr().zzf().zza("Failed to send current screen to the service", e);
        }
    }
}
