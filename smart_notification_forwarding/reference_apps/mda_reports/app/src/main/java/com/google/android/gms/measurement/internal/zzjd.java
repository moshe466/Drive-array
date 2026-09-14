package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* loaded from: classes.dex */
final class zzjd implements Runnable {
    private final /* synthetic */ ComponentName zza;
    private final /* synthetic */ zzjb zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjd(zzjb zzjbVar, ComponentName componentName) {
        this.zzb = zzjbVar;
        this.zza = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.a.zza(this.zza);
    }
}
