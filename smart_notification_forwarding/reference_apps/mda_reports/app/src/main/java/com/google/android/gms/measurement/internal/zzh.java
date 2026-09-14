package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzh implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzn zza;
    private final /* synthetic */ zzan zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ AppMeasurementDynamiteService zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzh(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzn zznVar, zzan zzanVar, String str) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zznVar;
        this.zzb = zzanVar;
        this.zzc = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzd.a.zzw().zza(this.zza, this.zzb, this.zzc);
    }
}
