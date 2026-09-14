package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzavf {
    private String zzdjl;
    private final long zzdqp;
    private final List<String> zzdqq = new ArrayList();
    private final List<String> zzdqr = new ArrayList();
    private final Map<String, zzakx> zzdqs = new HashMap();
    private String zzdqt;
    private JSONObject zzdqu;
    private boolean zzdqv;

    public zzavf(String str, long j) {
        JSONObject optJSONObject;
        this.zzdqv = false;
        this.zzdjl = str;
        this.zzdqp = j;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.zzdqu = new JSONObject(str);
            if (this.zzdqu.optInt("status", -1) != 1) {
                this.zzdqv = false;
                zzayu.zzez("App settings could not be fetched successfully.");
                return;
            }
            this.zzdqv = true;
            this.zzdqt = this.zzdqu.optString("app_id");
            JSONArray optJSONArray = this.zzdqu.optJSONArray("ad_unit_id_settings");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i);
                    String optString = jSONObject.optString("format");
                    String optString2 = jSONObject.optString("ad_unit_id");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        if ("interstitial".equalsIgnoreCase(optString)) {
                            this.zzdqr.add(optString2);
                        } else if ("rewarded".equalsIgnoreCase(optString) && (optJSONObject = jSONObject.optJSONObject("mediation_config")) != null) {
                            this.zzdqs.put(optString2, new zzakx(optJSONObject));
                        }
                    }
                }
            }
            JSONArray optJSONArray2 = this.zzdqu.optJSONArray("persistable_banner_ad_unit_ids");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.zzdqq.add(optJSONArray2.optString(i2));
                }
            }
        } catch (JSONException e) {
            zzayu.zzd("Exception occurred while processing app setting json", e);
            com.google.android.gms.ads.internal.zzq.zzku().zza(e, "AppSettings.parseAppSettingsJson");
        }
    }

    public final long zzvj() {
        return this.zzdqp;
    }

    public final boolean zzvk() {
        return this.zzdqv;
    }

    public final String zzvl() {
        return this.zzdjl;
    }

    public final String zzvm() {
        return this.zzdqt;
    }

    public final Map<String, zzakx> zzvn() {
        return this.zzdqs;
    }

    public final JSONObject zzvo() {
        return this.zzdqu;
    }
}
