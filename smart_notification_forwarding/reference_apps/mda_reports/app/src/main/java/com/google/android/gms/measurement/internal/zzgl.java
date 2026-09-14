package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class zzgl implements Callable<byte[]> {
    private final /* synthetic */ zzan zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzgb zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgl(zzgb zzgbVar, zzan zzanVar, String str) {
        this.zzc = zzgbVar;
        this.zza = zzanVar;
        this.zzb = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ byte[] call() {
        zzke zzkeVar;
        zzke zzkeVar2;
        zzkeVar = this.zzc.zza;
        zzkeVar.d();
        zzkeVar2 = this.zzc.zza;
        return zzkeVar2.zzg().zza(this.zza, this.zzb);
    }
}
