package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzis implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zzij zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzis(zzij zzijVar, zzm zzmVar, boolean z) {
        this.zzc = zzijVar;
        this.zza = zzmVar;
        this.zzb = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzeo zzeoVar;
        zzeoVar = this.zzc.zzb;
        if (zzeoVar == null) {
            this.zzc.zzr().zzf().zza("Discarding data. Failed to send app launch");
            return;
        }
        try {
            zzeoVar.zza(this.zza);
            if (this.zzb) {
                this.zzc.zzj().zzad();
            }
            this.zzc.a(zzeoVar, (AbstractSafeParcelable) null, this.zza);
            this.zzc.zzaj();
        } catch (RemoteException e) {
            this.zzc.zzr().zzf().zza("Failed to send app launch to the service", e);
        }
    }
}
