package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzgo implements Runnable {
    private final /* synthetic */ zzkl zza;
    private final /* synthetic */ zzm zzb;
    private final /* synthetic */ zzgb zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgo(zzgb zzgbVar, zzkl zzklVar, zzm zzmVar) {
        this.zzc = zzgbVar;
        this.zza = zzklVar;
        this.zzb = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzke zzkeVar;
        zzke zzkeVar2;
        zzke zzkeVar3;
        zzkeVar = this.zzc.zza;
        zzkeVar.d();
        if (this.zza.zza() == null) {
            zzkeVar3 = this.zzc.zza;
            zzkeVar3.b(this.zza, this.zzb);
        } else {
            zzkeVar2 = this.zzc.zza;
            zzkeVar2.a(this.zza, this.zzb);
        }
    }
}
