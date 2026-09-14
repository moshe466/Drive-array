package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzkd implements Runnable {
    private final /* synthetic */ zzkj zza;
    private final /* synthetic */ zzke zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkd(zzke zzkeVar, zzkj zzkjVar) {
        this.zzb = zzkeVar;
        this.zza = zzkjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza(this.zza);
        this.zzb.a();
    }
}
