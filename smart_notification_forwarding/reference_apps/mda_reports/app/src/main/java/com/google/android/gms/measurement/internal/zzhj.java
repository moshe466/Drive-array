package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzhj implements Runnable {
    private final /* synthetic */ zzha zza;
    private final /* synthetic */ zzhb zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhj(zzhb zzhbVar, zzha zzhaVar) {
        this.zzb = zzhbVar;
        this.zza = zzhaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza(this.zza);
    }
}
