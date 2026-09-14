package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzbwd implements zzdxg<zzpn> {
    private final zzdxp<zzazb> zzfdb;
    private final zzdxp<String> zzfdc;

    public zzbwd(zzdxp<zzazb> zzdxpVar, zzdxp<String> zzdxpVar2) {
        this.zzfdb = zzdxpVar;
        this.zzfdc = zzdxpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        zzazb zzazbVar = this.zzfdb.get();
        String str = this.zzfdc.get();
        com.google.android.gms.ads.internal.zzq.zzkq();
        return (zzpn) zzdxm.zza(new zzpn(zzawb.zzwk(), zzazbVar, str, new JSONObject(), false, true), "Cannot return null from a non-@Nullable @Provides method");
    }
}
