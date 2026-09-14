package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import android.util.JsonWriter;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzczp implements zzaxx {

    @Nullable
    public final String zzdhr;

    @Nullable
    public final String zzdht;
    public final JSONObject zzfka;
    private final JSONObject zzgmc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzczp(JsonReader jsonReader) {
        this.zzgmc = zzaxs.zzc(jsonReader);
        this.zzdht = this.zzgmc.optString("ad_html", null);
        this.zzdhr = this.zzgmc.optString("ad_base_url", null);
        this.zzfka = this.zzgmc.optJSONObject("ad_json");
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final void zza(JsonWriter jsonWriter) {
        zzaxs.zza(jsonWriter, this.zzgmc);
    }
}
