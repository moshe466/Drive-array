package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzgd implements Runnable {
    private final /* synthetic */ zzv zza;
    private final /* synthetic */ zzgb zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgd(zzgb zzgbVar, zzv zzvVar) {
        this.zzb = zzgbVar;
        this.zza = zzvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzke zzkeVar;
        zzke zzkeVar2;
        zzke zzkeVar3;
        zzkeVar = this.zzb.zza;
        zzkeVar.d();
        if (this.zza.zzc.zza() == null) {
            zzkeVar3 = this.zzb.zza;
            zzkeVar3.b(this.zza);
        } else {
            zzkeVar2 = this.zzb.zza;
            zzkeVar2.a(this.zza);
        }
    }
}
