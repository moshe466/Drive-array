package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzx;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzba extends zzx.zza {
    private final /* synthetic */ Long zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ String zze;
    private final /* synthetic */ Bundle zzf;
    private final /* synthetic */ boolean zzg;
    private final /* synthetic */ boolean zzh;
    private final /* synthetic */ zzx zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzba(zzx zzxVar, Long l, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        super(zzxVar);
        this.zzi = zzxVar;
        this.zzc = l;
        this.zzd = str;
        this.zze = str2;
        this.zzf = bundle;
        this.zzg = z;
        this.zzh = z2;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.zza
    final void zza() {
        zzm zzmVar;
        Long l = this.zzc;
        long longValue = l == null ? this.a : l.longValue();
        zzmVar = this.zzi.zzr;
        zzmVar.logEvent(this.zzd, this.zze, this.zzf, this.zzg, this.zzh, longValue);
    }
}
