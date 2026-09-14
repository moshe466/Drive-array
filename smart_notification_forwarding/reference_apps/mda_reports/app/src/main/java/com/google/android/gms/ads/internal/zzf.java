package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzdgf;
import com.google.android.gms.internal.ads.zzdgs;
import com.google.android.gms.internal.ads.zzdhe;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class zzf implements zzdgf {
    static final zzdgf a = new zzf();

    private zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzdgf
    public final zzdhe zzf(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optBoolean("isSuccessful", false)) {
            zzq.zzku().zzvf().zzeg(jSONObject.getString("appSettingsJson"));
        }
        return zzdgs.zzaj(null);
    }
}
