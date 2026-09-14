package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzcob {
    private final Executor executor;
    private final Map<String, zzcoi> zzgcf = new ConcurrentHashMap();
    private final Map<String, Map<String, List<zzcoi>>> zzgcg = new ConcurrentHashMap();
    private JSONObject zzgch;

    public zzcob(Executor executor) {
        this.executor = executor;
    }

    private static boolean zza(JSONArray jSONArray, String str) {
        if (jSONArray != null && str != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                } catch (PatternSyntaxException e) {
                    com.google.android.gms.ads.internal.zzq.zzku().zza(e, "RtbAdapterMap.hasAtleastOneRegexMatch");
                }
                if (Pattern.compile(jSONArray.optString(i)).matcher(str).lookingAt()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzamk, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final synchronized void c() {
        JSONArray optJSONArray;
        JSONObject zzvo = com.google.android.gms.ads.internal.zzq.zzku().zzvf().zzwa().zzvo();
        if (zzvo != null) {
            try {
                JSONArray optJSONArray2 = zzvo.optJSONArray("ad_unit_id_settings");
                this.zzgch = zzvo.optJSONObject("ad_unit_patterns");
                if (optJSONArray2 != null) {
                    for (int i = 0; i < optJSONArray2.length(); i++) {
                        JSONObject jSONObject = optJSONArray2.getJSONObject(i);
                        String optString = jSONObject.optString("ad_unit_id", "");
                        String optString2 = jSONObject.optString("format", "");
                        ArrayList arrayList = new ArrayList();
                        JSONObject optJSONObject = jSONObject.optJSONObject("mediation_config");
                        if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("ad_networks")) != null) {
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                                ArrayList arrayList2 = new ArrayList();
                                if (jSONObject2 != null) {
                                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                                    Bundle bundle = new Bundle();
                                    if (optJSONObject2 != null) {
                                        Iterator<String> keys = optJSONObject2.keys();
                                        while (keys.hasNext()) {
                                            String next = keys.next();
                                            bundle.putString(next, optJSONObject2.optString(next, ""));
                                        }
                                    }
                                    JSONArray optJSONArray3 = jSONObject2.optJSONArray("rtb_adapters");
                                    if (optJSONArray3 != null) {
                                        ArrayList arrayList3 = new ArrayList();
                                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                                            String optString3 = optJSONArray3.optString(i3, "");
                                            if (!TextUtils.isEmpty(optString3)) {
                                                arrayList3.add(optString3);
                                            }
                                        }
                                        int size = arrayList3.size();
                                        int i4 = 0;
                                        while (i4 < size) {
                                            Object obj = arrayList3.get(i4);
                                            i4++;
                                            String str = (String) obj;
                                            zzgi(str);
                                            if (this.zzgcf.get(str) != null) {
                                                arrayList2.add(new zzcoi(str, optString2, bundle));
                                            }
                                        }
                                    }
                                }
                                arrayList.addAll(arrayList2);
                            }
                        }
                        if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString)) {
                            Map<String, List<zzcoi>> map = this.zzgcg.get(optString2);
                            if (map == null) {
                                map = new ConcurrentHashMap<>();
                            }
                            this.zzgcg.put(optString2, map);
                            List<zzcoi> list = map.get(optString);
                            if (list == null) {
                                list = new ArrayList<>();
                            }
                            list.addAll(arrayList);
                            map.put(optString, list);
                        }
                    }
                }
            } catch (JSONException e) {
                zzavs.zza("Malformed config loading JSON.", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b() {
        this.executor.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcog
            private final zzcob zzgci;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgci = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgci.c();
            }
        });
    }

    public final void zzamj() {
        com.google.android.gms.ads.internal.zzq.zzku().zzvf().zzb(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcoe
            private final zzcob zzgci;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgci = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgci.b();
            }
        });
        this.executor.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcod
            private final zzcob zzgci;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgci = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgci.a();
            }
        });
    }

    public final void zzgi(String str) {
        if (TextUtils.isEmpty(str) || this.zzgcf.containsKey(str)) {
            return;
        }
        this.zzgcf.put(str, new zzcoi(str, "", new Bundle()));
    }

    public final Map<String, List<Bundle>> zzr(String str, String str2) {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return Collections.emptyMap();
        }
        Map<String, List<zzcoi>> map = this.zzgcg.get(str);
        if (map == null) {
            return Collections.emptyMap();
        }
        List<zzcoi> list = map.get(str2);
        if (list == null) {
            String str3 = "";
            if (((Boolean) zzve.zzoy().zzd(zzzn.zzckp)).booleanValue() && (jSONObject = this.zzgch) != null && (optJSONArray = jSONObject.optJSONArray(str)) != null) {
                int i = 0;
                while (true) {
                    if (i >= optJSONArray.length()) {
                        break;
                    }
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("including");
                        JSONArray optJSONArray3 = optJSONObject.optJSONArray("excluding");
                        if (zza(optJSONArray2, str2) && !zza(optJSONArray3, str2)) {
                            str3 = optJSONObject.optString("effective_ad_unit_id", "");
                            break;
                        }
                    }
                    i++;
                }
            }
            list = map.get(str3);
        }
        if (list == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        for (zzcoi zzcoiVar : list) {
            String str4 = zzcoiVar.zzfge;
            if (!hashMap.containsKey(str4)) {
                hashMap.put(str4, new ArrayList());
            }
            ((List) hashMap.get(str4)).add(zzcoiVar.zzeig);
        }
        return hashMap;
    }
}
