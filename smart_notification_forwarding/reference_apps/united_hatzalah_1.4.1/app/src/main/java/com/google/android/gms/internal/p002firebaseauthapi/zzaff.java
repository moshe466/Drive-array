package com.google.android.gms.internal.p002firebaseauthapi;

/* loaded from: classes.dex */
final class zzaff implements Runnable {
    private final /* synthetic */ zzafe zza;
    private final /* synthetic */ zzaez zzb;

    public zzaff(zzaez zzaezVar, zzafe zzafeVar) {
        this.zza = zzafeVar;
        this.zzb = zzaezVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb.zza.zzh) {
            try {
                if (!this.zzb.zza.zzh.isEmpty()) {
                    this.zza.zza(this.zzb.zza.zzh.get(0), new Object[0]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
