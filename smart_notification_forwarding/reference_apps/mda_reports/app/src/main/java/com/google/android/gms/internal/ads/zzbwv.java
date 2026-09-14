package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzbwv extends zzbww {
    private final boolean zzdcd;
    private final boolean zzdce;
    private final boolean zzdli;
    private final JSONObject zzfmn;
    private final boolean zzfmo;

    public zzbwv(zzczl zzczlVar, JSONObject jSONObject) {
        super(zzczlVar);
        boolean z = false;
        this.zzfmn = zzaxs.zza(jSONObject, "tracking_urls_and_actions", "active_view");
        this.zzdce = zzaxs.zza(false, jSONObject, "allow_pub_owned_ad_view");
        this.zzdcd = zzaxs.zza(false, jSONObject, "attribution", "allow_pub_rendering");
        this.zzdli = zzaxs.zza(false, jSONObject, "enable_omid");
        if (jSONObject != null && jSONObject.optJSONObject("overlay") != null) {
            z = true;
        }
        this.zzfmo = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbww
    public final boolean zzaiw() {
        return this.zzdli;
    }

    @Override // com.google.android.gms.internal.ads.zzbww
    public final JSONObject zzajl() {
        JSONObject jSONObject = this.zzfmn;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            return new JSONObject(this.a.zzdks);
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbww
    public final boolean zzajm() {
        return this.zzfmo;
    }

    @Override // com.google.android.gms.internal.ads.zzbww
    public final boolean zzajn() {
        return this.zzdce;
    }

    @Override // com.google.android.gms.internal.ads.zzbww
    public final boolean zzajo() {
        return this.zzdcd;
    }
}
