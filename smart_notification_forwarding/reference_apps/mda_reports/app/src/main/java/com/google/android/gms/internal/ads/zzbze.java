package com.google.android.gms.internal.ads;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzbze {
    private final Executor executor;
    private final zzbyu zzfow;

    public zzbze(Executor executor, zzbyu zzbyuVar) {
        this.executor = executor;
        this.zzfow = zzbyuVar;
    }

    public final zzdhe<List<zzbzf>> zzg(JSONObject jSONObject, String str) {
        zzdhe zzaj;
        final String optString;
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return zzdgs.zzaj(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null && (optString = optJSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.NAME)) != null) {
                String optString2 = optJSONObject.optString("type");
                char c = "string".equals(optString2) ? (char) 1 : "image".equals(optString2) ? (char) 2 : (char) 0;
                if (c == 1) {
                    zzaj = zzdgs.zzaj(new zzbzf(optString, optJSONObject.optString("string_value")));
                } else if (c == 2) {
                    zzaj = zzdgs.zzb(this.zzfow.zzc(optJSONObject, "image_value"), new zzded(optString) { // from class: com.google.android.gms.internal.ads.zzbzg
                        private final String zzcyz;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzcyz = optString;
                        }

                        @Override // com.google.android.gms.internal.ads.zzded
                        public final Object apply(Object obj) {
                            return new zzbzf(this.zzcyz, (zzabu) obj);
                        }
                    }, this.executor);
                }
                arrayList.add(zzaj);
            }
            zzaj = zzdgs.zzaj(null);
            arrayList.add(zzaj);
        }
        return zzdgs.zzb(zzdgs.zzg(arrayList), zzbzd.a, this.executor);
    }
}
