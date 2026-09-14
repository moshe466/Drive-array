package com.google.firebase.analytics;

import com.google.android.gms.internal.measurement.zzx;
import com.google.android.gms.measurement.internal.zzga;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
final class zzb implements Callable<String> {
    private final /* synthetic */ FirebaseAnalytics zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(FirebaseAnalytics firebaseAnalytics) {
        this.zza = firebaseAnalytics;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() {
        String zzb;
        boolean z;
        zzga zzgaVar;
        String zzc;
        zzx zzxVar;
        zzb = this.zza.zzb();
        if (zzb != null) {
            return zzb;
        }
        z = this.zza.zzd;
        if (z) {
            zzxVar = this.zza.zzc;
            zzc = zzxVar.zzh();
        } else {
            zzgaVar = this.zza.zzb;
            zzc = zzgaVar.zzh().zzc(120000L);
        }
        if (zzc == null) {
            throw new TimeoutException();
        }
        this.zza.zza(zzc);
        return zzc;
    }
}
