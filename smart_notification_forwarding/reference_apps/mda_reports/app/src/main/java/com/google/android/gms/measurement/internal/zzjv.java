package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzjv extends zzaf {
    private final /* synthetic */ zzjw zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzjv(zzjw zzjwVar, zzgt zzgtVar) {
        super(zzgtVar);
        this.zza = zzjwVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzaf
    @WorkerThread
    public final void zza() {
        this.zza.zzc();
    }
}
