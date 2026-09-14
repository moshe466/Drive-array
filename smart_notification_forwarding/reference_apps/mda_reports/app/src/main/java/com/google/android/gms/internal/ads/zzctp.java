package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class zzctp implements zzcty<Bundle> {
    private final String zzdpg;
    private final String zzggo;
    private final String zzggp;
    private final String zzggq;
    private final Long zzggr;

    public zzctp(String str, String str2, String str3, String str4, Long l) {
        this.zzdpg = str;
        this.zzggo = str2;
        this.zzggp = str3;
        this.zzggq = str4;
        this.zzggr = l;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzdaa.zza(bundle2, "gmp_app_id", this.zzdpg);
        zzdaa.zza(bundle2, "fbs_aiid", this.zzggo);
        zzdaa.zza(bundle2, "fbs_aeid", this.zzggp);
        zzdaa.zza(bundle2, "apm_id_origin", this.zzggq);
        Long l = this.zzggr;
        if (l != null) {
            bundle2.putLong("sai_timeout", l.longValue());
        }
    }
}
