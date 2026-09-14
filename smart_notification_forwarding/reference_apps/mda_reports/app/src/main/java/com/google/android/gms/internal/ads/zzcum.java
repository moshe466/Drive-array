package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzcum implements zzcty<JSONObject> {
    private final AdvertisingIdClient.Info zzghj;
    private final String zzghk;

    public zzcum(AdvertisingIdClient.Info info, String str) {
        this.zzghj = info;
        this.zzghk = str;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final /* synthetic */ void zzr(JSONObject jSONObject) {
        try {
            JSONObject zzb = zzaxs.zzb(jSONObject, "pii");
            if (this.zzghj == null || TextUtils.isEmpty(this.zzghj.getId())) {
                zzb.put("pdid", this.zzghk);
                zzb.put("pdidtype", "ssaid");
            } else {
                zzb.put("rdid", this.zzghj.getId());
                zzb.put("is_lat", this.zzghj.isLimitAdTrackingEnabled());
                zzb.put("idtype", "adid");
            }
        } catch (JSONException e) {
            zzavs.zza("Failed putting Ad ID.", e);
        }
    }
}
