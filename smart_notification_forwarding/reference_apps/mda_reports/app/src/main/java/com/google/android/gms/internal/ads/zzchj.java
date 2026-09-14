package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* loaded from: classes.dex */
final class zzchj implements zzajv<zzchk> {
    @Override // com.google.android.gms.internal.ads.zzajv
    public final /* synthetic */ JSONObject zzj(zzchk zzchkVar) {
        zzchk zzchkVar2 = zzchkVar;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject2.put("base_url", zzchkVar2.zzfwi.zzub());
        jSONObject2.put("signals", zzchkVar2.zzfwj);
        jSONObject3.put("body", zzchkVar2.zzfwl.c);
        jSONObject3.put("headers", com.google.android.gms.ads.internal.zzq.zzkq().zzi(zzchkVar2.zzfwl.b));
        jSONObject3.put("response_code", zzchkVar2.zzfwl.a);
        jSONObject3.put("latency", zzchkVar2.zzfwl.d);
        jSONObject.put("request", jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", zzchkVar2.zzfwi.zzue());
        return jSONObject;
    }
}
