package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzbjs {
    @Nullable
    public static JSONObject zza(zzczl zzczlVar) {
        try {
            return new JSONObject(zzczlVar.zzdks);
        } catch (JSONException unused) {
            return null;
        }
    }
}
