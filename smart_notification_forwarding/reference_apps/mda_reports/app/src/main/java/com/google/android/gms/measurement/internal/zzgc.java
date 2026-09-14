package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzgc implements Runnable {
    private final /* synthetic */ zzhc zza;
    private final /* synthetic */ zzga zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgc(zzga zzgaVar, zzhc zzhcVar) {
        this.zzb = zzgaVar;
        this.zza = zzhcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza(this.zza);
        this.zzb.a();
    }
}
