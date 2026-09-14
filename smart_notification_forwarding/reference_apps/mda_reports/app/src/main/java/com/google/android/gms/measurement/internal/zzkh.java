package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzkh implements Callable<String> {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzke zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkh(zzke zzkeVar, zzm zzmVar) {
        this.zzb = zzkeVar;
        this.zza = zzmVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() {
        zzg c = this.zzb.c(this.zza);
        if (c != null) {
            return c.zzd();
        }
        this.zzb.zzr().zzi().zza("App info was null when attempting to get app instance id");
        return null;
    }
}
