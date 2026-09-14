package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzgq implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzgb zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgq(zzgb zzgbVar, zzm zzmVar) {
        this.zzb = zzgbVar;
        this.zza = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzke zzkeVar;
        zzke zzkeVar2;
        zzkeVar = this.zzb.zza;
        zzkeVar.d();
        zzkeVar2 = this.zzb.zza;
        zzkeVar2.b(this.zza);
    }
}
