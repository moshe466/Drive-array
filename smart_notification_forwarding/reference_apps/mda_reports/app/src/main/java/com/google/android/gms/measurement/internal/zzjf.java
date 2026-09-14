package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* loaded from: classes.dex */
final class zzjf implements Runnable {
    private final /* synthetic */ zzjb zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjf(zzjb zzjbVar) {
        this.zza = zzjbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzij zzijVar = this.zza.a;
        Context zzn = zzijVar.zzn();
        this.zza.a.zzu();
        zzijVar.zza(new ComponentName(zzn, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
