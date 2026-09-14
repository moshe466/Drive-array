package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzaqq {
    private final int errorCode;
    private final String type;
    private String url;
    private final String zzdiy;
    private final String zzdlk;
    private final boolean zzdll;
    private final String zzdly;
    private final List<String> zzdma;
    private final String zzdmb;
    private final String zzdmc;
    private final boolean zzdmd;
    private final String zzdme;
    private final boolean zzdmf;
    private final JSONObject zzdmg;

    public zzaqq(JSONObject jSONObject) {
        this.url = jSONObject.optString("url");
        this.zzdmb = jSONObject.optString("base_uri");
        this.zzdmc = jSONObject.optString("post_parameters");
        String optString = jSONObject.optString("drt_include");
        this.zzdmd = optString != null && (optString.equals("1") || optString.equals("true"));
        this.zzdiy = jSONObject.optString("request_id");
        this.type = jSONObject.optString("type");
        String optString2 = jSONObject.optString("errors");
        this.zzdma = optString2 == null ? null : Arrays.asList(optString2.split(","));
        this.errorCode = jSONObject.optInt("valid", 0) == 1 ? -2 : 1;
        this.zzdme = jSONObject.optString("fetched_ad");
        this.zzdmf = jSONObject.optBoolean("render_test_ad_label");
        JSONObject optJSONObject = jSONObject.optJSONObject("preprocessor_flags");
        this.zzdmg = optJSONObject == null ? new JSONObject() : optJSONObject;
        this.zzdlk = jSONObject.optString("analytics_query_ad_event_id");
        this.zzdll = jSONObject.optBoolean("is_analytics_logging_enabled");
        this.zzdly = jSONObject.optString("pool_key");
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getUrl() {
        return this.url;
    }

    public final List<String> zzua() {
        return this.zzdma;
    }

    public final String zzub() {
        return this.zzdmb;
    }

    public final String zzuc() {
        return this.zzdmc;
    }

    public final boolean zzud() {
        return this.zzdmd;
    }

    public final JSONObject zzue() {
        return this.zzdmg;
    }

    public final String zzuf() {
        return this.zzdly;
    }
}
