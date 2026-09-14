package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final /* synthetic */ class zzahz {
    public static void zza(zzaia zzaiaVar, String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("(");
        sb.append(str2);
        sb.append(");");
        zzaiaVar.zzcy(sb.toString());
    }

    public static void zza(zzaia zzaiaVar, String str, Map map) {
        try {
            zzaiaVar.zzb(str, com.google.android.gms.ads.internal.zzq.zzkq().zzi((Map<String, ?>) map));
        } catch (JSONException unused) {
            zzayu.zzez("Could not convert parameters to JSON.");
        }
    }

    public static void zza(zzaia zzaiaVar, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        zzaiaVar.zzj(str, jSONObject.toString());
    }

    public static void zzb(zzaia zzaiaVar, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        String valueOf = String.valueOf(sb.toString());
        zzayu.zzea(valueOf.length() != 0 ? "Dispatching AFMA event: ".concat(valueOf) : new String("Dispatching AFMA event: "));
        zzaiaVar.zzcy(sb.toString());
    }
}
