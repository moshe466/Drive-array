package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzafa {
    public static final zzafn<zzbdi> zzcwu = zzaez.a;
    public static final zzafn<zzbdi> zzcwv = zzafc.a;
    public static final zzafn<zzbdi> zzcww = zzafb.a;
    public static final zzafn<zzbdi> zzcwx = new zzafg();
    public static final zzafn<zzbdi> zzcwy = new zzaff();
    public static final zzafn<zzbdi> zzcwz = zzafe.a;
    public static final zzafn<Object> zzcxa = new zzafi();
    public static final zzafn<zzbdi> zzcxb = new zzafh();
    public static final zzafn<zzbdi> zzcxc = zzafd.a;
    public static final zzafn<zzbdi> zzcxd = new zzafk();
    public static final zzafn<zzbdi> zzcxe = new zzafj();
    public static final zzafn<zzbaz> zzcxf = new zzbcg();
    public static final zzafn<zzbaz> zzcxg = new zzbcj();
    public static final zzafn<zzbdi> zzcxh = new zzaex();
    public static final zzaft zzcxi = new zzaft();
    public static final zzafn<zzbdi> zzcxj = new zzafm();
    public static final zzafn<zzbdi> zzcxk = new zzafl();
    public static final zzafn<zzbdi> zzcxl = new zzafo();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(zzahs zzahsVar, Map map) {
        String str = (String) map.get("u");
        if (str == null) {
            zzayu.zzez("URL missing from click GMSG.");
            return;
        }
        Uri parse = Uri.parse(str);
        try {
            zzdq zzaad = ((zzbeq) zzahsVar).zzaad();
            if (zzaad != null && zzaad.zzb(parse)) {
                parse = zzaad.zza(parse, ((zzbei) zzahsVar).getContext(), ((zzbes) zzahsVar).getView(), ((zzbei) zzahsVar).zzyn());
            }
        } catch (zzdt unused) {
            String valueOf = String.valueOf(str);
            zzayu.zzez(valueOf.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf) : new String("Unable to append parameter to URL: "));
        }
        zzbei zzbeiVar = (zzbei) zzahsVar;
        new zzayb(zzbeiVar.getContext(), ((zzbet) zzahsVar).zzyr().zzbma, zzauk.zzb(parse, zzbeiVar.getContext())).zzvr();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(zzbei zzbeiVar, Map map) {
        String str = (String) map.get("u");
        if (str == null) {
            zzayu.zzez("URL missing from httpTrack GMSG.");
        } else {
            new zzayb(zzbeiVar.getContext(), ((zzbet) zzbeiVar).zzyr().zzbma, str).zzvr();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(zzbeq zzbeqVar, Map map) {
        String str = (String) map.get("tx");
        String str2 = (String) map.get("ty");
        String str3 = (String) map.get("td");
        try {
            int parseInt = Integer.parseInt(str);
            int parseInt2 = Integer.parseInt(str2);
            int parseInt3 = Integer.parseInt(str3);
            zzdq zzaad = zzbeqVar.zzaad();
            if (zzaad != null) {
                zzaad.zzbw().zza(parseInt, parseInt2, parseInt3);
            }
        } catch (NumberFormatException unused) {
            zzayu.zzez("Could not parse touch parameters from gmsg.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void b(zzbei zzbeiVar, Map map) {
        JSONException jSONException;
        String str;
        PackageManager packageManager = zzbeiVar.getContext().getPackageManager();
        try {
            try {
                JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String optString = jSONObject2.optString("id");
                        String optString2 = jSONObject2.optString("u");
                        String optString3 = jSONObject2.optString("i");
                        String optString4 = jSONObject2.optString("m");
                        String optString5 = jSONObject2.optString("p");
                        String optString6 = jSONObject2.optString("c");
                        jSONObject2.optString("f");
                        jSONObject2.optString("e");
                        String optString7 = jSONObject2.optString("intent_url");
                        Intent intent = null;
                        if (!TextUtils.isEmpty(optString7)) {
                            try {
                                intent = Intent.parseUri(optString7, 0);
                            } catch (URISyntaxException e) {
                                String valueOf = String.valueOf(optString7);
                                zzayu.zzc(valueOf.length() != 0 ? "Error parsing the url: ".concat(valueOf) : new String("Error parsing the url: "), e);
                            }
                        }
                        if (intent == null) {
                            intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split("/", 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                        }
                        try {
                            jSONObject.put(optString, packageManager.resolveActivity(intent, 65536) != null);
                        } catch (JSONException e2) {
                            jSONException = e2;
                            str = "Error constructing openable urls response.";
                            zzayu.zzc(str, jSONException);
                        }
                    } catch (JSONException e3) {
                        jSONException = e3;
                        str = "Error parsing the intent data.";
                    }
                }
                ((zzahs) zzbeiVar).zzb("openableIntents", jSONObject);
            } catch (JSONException unused) {
                ((zzahs) zzbeiVar).zzb("openableIntents", new JSONObject());
            }
        } catch (JSONException unused2) {
            ((zzahs) zzbeiVar).zzb("openableIntents", new JSONObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void c(zzbei zzbeiVar, Map map) {
        String str = (String) map.get("urls");
        if (TextUtils.isEmpty(str)) {
            zzayu.zzez("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] split = str.split(",");
        HashMap hashMap = new HashMap();
        PackageManager packageManager = zzbeiVar.getContext().getPackageManager();
        for (String str2 : split) {
            String[] split2 = str2.split(";", 2);
            boolean z = true;
            if (packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) == null) {
                z = false;
            }
            hashMap.put(str2, Boolean.valueOf(z));
        }
        ((zzahs) zzbeiVar).zza("openableURLs", hashMap);
    }
}
