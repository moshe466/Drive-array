package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzgm implements Runnable {
    private final /* synthetic */ zzan zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzgb zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgm(zzgb zzgbVar, zzan zzanVar, String str) {
        this.zzc = zzgbVar;
        this.zza = zzanVar;
        this.zzb = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzke zzkeVar;
        zzke zzkeVar2;
        zzkeVar = this.zzc.zza;
        zzkeVar.d();
        zzkeVar2 = this.zzc.zza;
        zzkeVar2.a(this.zza, this.zzb);
    }
}
