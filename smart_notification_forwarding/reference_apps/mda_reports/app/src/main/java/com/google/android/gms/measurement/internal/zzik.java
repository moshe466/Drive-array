package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzik implements Runnable {
    private final /* synthetic */ zzif zza;
    private final /* synthetic */ zzii zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzik(zzii zziiVar, zzif zzifVar) {
        this.zzb = zziiVar;
        this.zza = zzifVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza(this.zza, false);
        zzii zziiVar = this.zzb;
        zziiVar.b = null;
        zziiVar.zzh().a((zzif) null);
    }
}
