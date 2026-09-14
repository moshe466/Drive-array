package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzgk implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzgb zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgk(zzgb zzgbVar, zzm zzmVar) {
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
        zzkeVar2.a(this.zza);
    }
}
