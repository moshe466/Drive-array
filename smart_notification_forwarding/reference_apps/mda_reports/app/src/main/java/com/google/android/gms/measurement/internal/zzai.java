package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzai implements Runnable {
    private final /* synthetic */ zzgt zza;
    private final /* synthetic */ zzaf zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzai(zzaf zzafVar, zzgt zzgtVar) {
        this.zzb = zzafVar;
        this.zza = zzgtVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzu();
        if (zzw.zza()) {
            this.zza.zzq().zza(this);
            return;
        }
        boolean zzb = this.zzb.zzb();
        zzaf.a(this.zzb, 0L);
        if (zzb) {
            this.zzb.zza();
        }
    }
}
