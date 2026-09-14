package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzaky {
    private final long zzdbp;
    private final String zzdcj;
    private final String zzdck;
    public final List<String> zzdcl;
    private final String zzdcm;
    private final String zzdcn;
    private final List<String> zzdco;
    private final List<String> zzdcp;
    private final List<String> zzdcq;
    private final List<String> zzdcr;
    private final List<String> zzdcs;
    public final String zzdct;
    private final List<String> zzdcu;
    private final List<String> zzdcv;
    private final List<String> zzdcw;
    private final String zzdcx;
    private final String zzdcy;

    @Nullable
    private final String zzdcz;

    @Nullable
    private final String zzdda;
    private final String zzddb;

    @Nullable
    private final List<String> zzddc;
    private final String zzddd;

    @Nullable
    public final String zzdde;

    public zzaky(JSONObject jSONObject) {
        List<String> list;
        this.zzdck = jSONObject.optString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.zzdcl = Collections.unmodifiableList(arrayList);
        this.zzdcm = jSONObject.optString("allocation_id", null);
        com.google.android.gms.ads.internal.zzq.zzli();
        this.zzdco = zzala.zza(jSONObject, "clickurl");
        com.google.android.gms.ads.internal.zzq.zzli();
        this.zzdcp = zzala.zza(jSONObject, "imp_urls");
        com.google.android.gms.ads.internal.zzq.zzli();
        this.zzdcq = zzala.zza(jSONObject, "downloaded_imp_urls");
        com.google.android.gms.ads.internal.zzq.zzli();
        this.zzdcs = zzala.zza(jSONObject, "fill_urls");
        com.google.android.gms.ads.internal.zzq.zzli();
        this.zzdcu = zzala.zza(jSONObject, "video_start_urls");
        com.google.android.gms.ads.internal.zzq.zzli();
        this.zzdcw = zzala.zza(jSONObject, "video_complete_urls");
        com.google.android.gms.ads.internal.zzq.zzli();
        this.zzdcv = zzala.zza(jSONObject, "video_reward_urls");
        this.zzdcx = jSONObject.optString(FirebaseAnalytics.Param.TRANSACTION_ID);
        this.zzdcy = jSONObject.optString("valid_from_timestamp");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        if (optJSONObject != null) {
            com.google.android.gms.ads.internal.zzq.zzli();
            list = zzala.zza(optJSONObject, "manual_impression_urls");
        } else {
            list = null;
        }
        this.zzdcr = list;
        this.zzdcj = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        this.zzdct = optJSONObject2 != null ? optJSONObject2.toString() : null;
        this.zzdcn = optJSONObject2 != null ? optJSONObject2.optString("class_name") : null;
        this.zzdcz = jSONObject.optString("html_template", null);
        this.zzdda = jSONObject.optString("ad_base_url", null);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("assets");
        this.zzddb = optJSONObject3 != null ? optJSONObject3.toString() : null;
        com.google.android.gms.ads.internal.zzq.zzli();
        this.zzddc = zzala.zza(jSONObject, "template_ids");
        JSONObject optJSONObject4 = jSONObject.optJSONObject("ad_loader_options");
        this.zzddd = optJSONObject4 != null ? optJSONObject4.toString() : null;
        this.zzdde = jSONObject.optString("response_type", null);
        this.zzdbp = jSONObject.optLong("ad_network_timeout_millis", -1L);
    }
}
