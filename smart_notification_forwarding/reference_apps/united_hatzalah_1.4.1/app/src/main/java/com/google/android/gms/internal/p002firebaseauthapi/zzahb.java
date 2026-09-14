package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzahb implements zzaes {
    private String zza = zzagz.REFRESH_TOKEN.toString();
    private String zzb;

    public zzahb(String str) {
        this.zzb = Preconditions.checkNotEmpty(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaes
    public final String zza() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("grantType", this.zza);
        jSONObject.put("refreshToken", this.zzb);
        return jSONObject.toString();
    }
}
