package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzbjj implements zzdxg<zzpn> {
    private final zzdxp<JSONObject> zzeua;
    private final zzdxp<zzczl> zzfda;
    private final zzdxp<zzazb> zzfdb;
    private final zzdxp<String> zzfdc;

    private zzbjj(zzdxp<zzczl> zzdxpVar, zzdxp<zzazb> zzdxpVar2, zzdxp<JSONObject> zzdxpVar3, zzdxp<String> zzdxpVar4) {
        this.zzfda = zzdxpVar;
        this.zzfdb = zzdxpVar2;
        this.zzeua = zzdxpVar3;
        this.zzfdc = zzdxpVar4;
    }

    public static zzbjj zza(zzdxp<zzczl> zzdxpVar, zzdxp<zzazb> zzdxpVar2, zzdxp<JSONObject> zzdxpVar3, zzdxp<String> zzdxpVar4) {
        return new zzbjj(zzdxpVar, zzdxpVar2, zzdxpVar3, zzdxpVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        this.zzfda.get();
        zzazb zzazbVar = this.zzfdb.get();
        JSONObject jSONObject = this.zzeua.get();
        String str = this.zzfdc.get();
        boolean equals = "native".equals(str);
        com.google.android.gms.ads.internal.zzq.zzkq();
        return (zzpn) zzdxm.zza(new zzpn(zzawb.zzwk(), zzazbVar, str, jSONObject, false, equals), "Cannot return null from a non-@Nullable @Provides method");
    }
}
