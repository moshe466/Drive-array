package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzx;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaj extends zzx.zza {
    private final /* synthetic */ com.google.android.gms.measurement.internal.zzha zzc;
    private final /* synthetic */ zzx zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaj(zzx zzxVar, com.google.android.gms.measurement.internal.zzha zzhaVar) {
        super(zzxVar);
        this.zzd = zzxVar;
        this.zzc = zzhaVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.zza
    final void zza() {
        zzm zzmVar;
        zzmVar = this.zzd.zzr;
        zzmVar.setEventInterceptor(new zzx.zzc(this.zzc));
    }
}
