package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzakx {
    public final List<zzaky> zzdbo;
    private final long zzdbp;
    private final List<String> zzdbq;
    private final List<String> zzdbr;
    private final List<String> zzdbs;
    private final List<String> zzdbt;
    private final List<String> zzdbu;
    private final boolean zzdbv;
    private final String zzdbw;
    private final long zzdbx;
    private final String zzdby;
    private final int zzdbz;
    private final int zzdca;
    private final long zzdcb;
    private final boolean zzdcc;
    private final boolean zzdcd;
    private final boolean zzdce;
    private final boolean zzdcf;
    private int zzdcg;
    private int zzdch;
    private boolean zzdci;

    public zzakx(JSONObject jSONObject) {
        if (zzayu.isLoggable(2)) {
            String valueOf = String.valueOf(jSONObject.toString(2));
            zzavs.zzed(valueOf.length() != 0 ? "Mediation Response JSON: ".concat(valueOf) : new String("Mediation Response JSON: "));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                zzaky zzakyVar = new zzaky(jSONArray.getJSONObject(i2));
                boolean z = true;
                if ("banner".equalsIgnoreCase(zzakyVar.zzdde)) {
                    this.zzdci = true;
                }
                arrayList.add(zzakyVar);
                if (i < 0) {
                    Iterator<String> it = zzakyVar.zzdcl.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        i = i2;
                    }
                }
            } catch (JSONException unused) {
            }
        }
        this.zzdcg = i;
        this.zzdch = jSONArray.length();
        this.zzdbo = Collections.unmodifiableList(arrayList);
        this.zzdbw = jSONObject.optString("qdata");
        this.zzdca = jSONObject.optInt("fs_model_type", -1);
        this.zzdcb = jSONObject.optLong("timeout_ms", -1L);
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject == null) {
            this.zzdbp = -1L;
            this.zzdbq = null;
            this.zzdbr = null;
            this.zzdbs = null;
            this.zzdbt = null;
            this.zzdbu = null;
            this.zzdbx = -1L;
            this.zzdby = null;
            this.zzdbz = 0;
            this.zzdcc = false;
            this.zzdbv = false;
            this.zzdcd = false;
            this.zzdce = false;
            this.zzdcf = false;
            return;
        }
        this.zzdbp = optJSONObject.optLong("ad_network_timeout_millis", -1L);
        com.google.android.gms.ads.internal.zzq.zzli();
        this.zzdbq = zzala.zza(optJSONObject, "click_urls");
        com.google.android.gms.ads.internal.zzq.zzli();
        this.zzdbr = zzala.zza(optJSONObject, "imp_urls");
        com.google.android.gms.ads.internal.zzq.zzli();
        this.zzdbs = zzala.zza(optJSONObject, "downloaded_imp_urls");
        com.google.android.gms.ads.internal.zzq.zzli();
        this.zzdbt = zzala.zza(optJSONObject, "nofill_urls");
        com.google.android.gms.ads.internal.zzq.zzli();
        this.zzdbu = zzala.zza(optJSONObject, "remote_ping_urls");
        this.zzdbv = optJSONObject.optBoolean("render_in_browser", false);
        long optLong = optJSONObject.optLong("refresh", -1L);
        this.zzdbx = optLong > 0 ? 1000 * optLong : -1L;
        zzasd zza = zzasd.zza(optJSONObject.optJSONArray("rewards"));
        if (zza == null) {
            this.zzdby = null;
            this.zzdbz = 0;
        } else {
            this.zzdby = zza.type;
            this.zzdbz = zza.zzdno;
        }
        this.zzdcc = optJSONObject.optBoolean("use_displayed_impression", false);
        this.zzdcd = optJSONObject.optBoolean("allow_pub_rendered_attribution", false);
        this.zzdce = optJSONObject.optBoolean("allow_pub_owned_ad_view", false);
        this.zzdcf = optJSONObject.optBoolean("allow_custom_click_gesture", false);
    }
}
