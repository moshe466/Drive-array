package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzjg implements Runnable {
    private final /* synthetic */ zzeo zza;
    private final /* synthetic */ zzjb zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjg(zzjb zzjbVar, zzeo zzeoVar) {
        this.zzb = zzjbVar;
        this.zza = zzeoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb) {
            zzjb.a(this.zzb, false);
            if (!this.zzb.a.zzab()) {
                this.zzb.a.zzr().zzw().zza("Connected to remote service");
                this.zzb.a.a(this.zza);
            }
        }
    }
}
