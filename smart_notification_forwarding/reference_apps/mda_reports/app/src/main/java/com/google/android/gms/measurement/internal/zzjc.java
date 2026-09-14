package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzjc implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzm zzd;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzn zze;
    private final /* synthetic */ zzij zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjc(zzij zzijVar, String str, String str2, boolean z, zzm zzmVar, com.google.android.gms.internal.measurement.zzn zznVar) {
        this.zzf = zzijVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = zzmVar;
        this.zze = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzeo zzeoVar;
        Bundle bundle = new Bundle();
        try {
            try {
                zzeoVar = this.zzf.zzb;
                if (zzeoVar == null) {
                    this.zzf.zzr().zzf().zza("Failed to get user properties", this.zza, this.zzb);
                } else {
                    bundle = zzkm.zza(zzeoVar.zza(this.zza, this.zzb, this.zzc, this.zzd));
                    this.zzf.zzaj();
                }
            } catch (RemoteException e) {
                this.zzf.zzr().zzf().zza("Failed to get user properties", this.zza, e);
            }
        } finally {
            this.zzf.zzp().zza(this.zze, bundle);
        }
    }
}
