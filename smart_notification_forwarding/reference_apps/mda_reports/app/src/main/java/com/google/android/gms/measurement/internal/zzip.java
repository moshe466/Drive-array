package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzip implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzn zzb;
    private final /* synthetic */ zzij zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzip(zzij zzijVar, zzm zzmVar, com.google.android.gms.internal.measurement.zzn zznVar) {
        this.zzc = zzijVar;
        this.zza = zzmVar;
        this.zzb = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzeo zzeoVar;
        String str = null;
        try {
            try {
                zzeoVar = this.zzc.zzb;
                if (zzeoVar == null) {
                    this.zzc.zzr().zzf().zza("Failed to get app instance id");
                } else {
                    str = zzeoVar.zzc(this.zza);
                    if (str != null) {
                        this.zzc.zzf().zza(str);
                        this.zzc.zzs().zzj.zza(str);
                    }
                    this.zzc.zzaj();
                }
            } catch (RemoteException e) {
                this.zzc.zzr().zzf().zza("Failed to get app instance id", e);
            }
        } finally {
            this.zzc.zzp().zza(this.zzb, (String) null);
        }
    }
}
