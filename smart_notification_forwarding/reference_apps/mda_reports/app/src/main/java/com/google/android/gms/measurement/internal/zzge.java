package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
final class zzge implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzgb zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzge(zzgb zzgbVar, zzm zzmVar) {
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
        zzm zzmVar = this.zza;
        zzkeVar2.zzq().zzd();
        zzkeVar2.b();
        Preconditions.checkNotEmpty(zzmVar.zza);
        zzkeVar2.c(zzmVar);
    }
}
