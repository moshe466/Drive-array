package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzju implements Runnable {
    long a;
    final /* synthetic */ zzjp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzju(zzjp zzjpVar, long j) {
        this.b = zzjpVar;
        this.a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a.zzq().zza(new Runnable(this) { // from class: com.google.android.gms.measurement.internal.zzjt
            private final zzju zza;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzju zzjuVar = this.zza;
                zzjp zzjpVar = zzjuVar.b;
                long j = zzjuVar.a;
                zzjpVar.a.zzd();
                zzjpVar.a.zzr().zzw().zza("Application going to the background");
                zzjpVar.a.zzf().a("auto", "_ab", j, new Bundle());
            }
        });
    }
}
