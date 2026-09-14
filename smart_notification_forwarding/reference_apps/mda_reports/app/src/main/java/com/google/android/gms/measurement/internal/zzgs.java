package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzgs implements Runnable {
    private final /* synthetic */ zzv zza;
    private final /* synthetic */ zzm zzb;
    private final /* synthetic */ zzgb zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgs(zzgb zzgbVar, zzv zzvVar, zzm zzmVar) {
        this.zzc = zzgbVar;
        this.zza = zzvVar;
        this.zzb = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzke zzkeVar;
        zzke zzkeVar2;
        zzke zzkeVar3;
        zzkeVar = this.zzc.zza;
        zzkeVar.d();
        if (this.zza.zzc.zza() == null) {
            zzkeVar3 = this.zzc.zza;
            zzkeVar3.b(this.zza, this.zzb);
        } else {
            zzkeVar2 = this.zzc.zza;
            zzkeVar2.a(this.zza, this.zzb);
        }
    }
}
