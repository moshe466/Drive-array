package com.google.android.gms.internal.ads;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzard implements zzaqo {
    private zzaju<JSONObject, JSONObject> zzdnk;
    private zzaju<JSONObject, JSONObject> zzdnp;

    public zzard(Context context) {
        zzakc zza = com.google.android.gms.ads.internal.zzq.zzld().zza(context, zzazb.zzxm());
        zzajy<JSONObject> zzajyVar = zzajx.zzdaq;
        this.zzdnp = zza.zza("google.afma.request.getAdDictionary", zzajyVar, zzajyVar);
        zzakc zza2 = com.google.android.gms.ads.internal.zzq.zzld().zza(context, zzazb.zzxm());
        zzajy<JSONObject> zzajyVar2 = zzajx.zzdaq;
        this.zzdnk = zza2.zza("google.afma.sdkConstants.getSdkConstants", zzajyVar2, zzajyVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzaqo
    public final zzaju<JSONObject, JSONObject> zztz() {
        return this.zzdnk;
    }
}
