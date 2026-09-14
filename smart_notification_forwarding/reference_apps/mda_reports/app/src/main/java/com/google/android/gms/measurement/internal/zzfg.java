package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzfg implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzfd zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfg(zzfd zzfdVar, boolean z) {
        this.zzb = zzfdVar;
        this.zza = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzke zzkeVar;
        zzkeVar = this.zzb.zzb;
        zzkeVar.a(this.zza);
    }
}
