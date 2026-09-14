package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class zzgf implements Callable<List<zzkn>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzgb zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgf(zzgb zzgbVar, String str, String str2, String str3) {
        this.zzd = zzgbVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzkn> call() {
        zzke zzkeVar;
        zzke zzkeVar2;
        zzkeVar = this.zzd.zza;
        zzkeVar.d();
        zzkeVar2 = this.zzd.zza;
        return zzkeVar2.zze().zza(this.zza, this.zzb, this.zzc);
    }
}
