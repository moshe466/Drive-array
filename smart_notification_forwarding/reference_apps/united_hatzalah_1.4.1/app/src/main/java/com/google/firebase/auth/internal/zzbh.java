package com.google.firebase.auth.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.internal.p002firebaseauthapi.zzaag;
import e0.a;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import t.C0694j;

/* loaded from: classes.dex */
final class zzbh {
    private static final Logger zza = new Logger("JSONParser", new String[0]);

    private static List<Object> zza(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                obj = zza((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = zza((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    public static Map<String, Object> zzb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject == JSONObject.NULL) {
                return null;
            }
            return zza(jSONObject);
        } catch (Exception e4) {
            throw new zzaag(e4);
        }
    }

    public static Map<String, Object> zza(String str) {
        Preconditions.checkNotEmpty(str);
        List<String> zza2 = com.google.android.gms.internal.p002firebaseauthapi.zzv.zza('.').zza((CharSequence) str);
        if (zza2.size() < 2) {
            zza.e(a.d("Invalid idToken ", str), new Object[0]);
            return new HashMap();
        }
        try {
            Map<String, Object> zzb = zzb(new String(Base64Utils.decodeUrlSafeNoPadding(zza2.get(1)), "UTF-8"));
            return zzb == null ? new HashMap() : zzb;
        } catch (UnsupportedEncodingException e4) {
            zza.e("Unable to decode token", e4, new Object[0]);
            return new HashMap();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [t.j, java.util.Map<java.lang.String, java.lang.Object>] */
    private static Map<String, Object> zza(JSONObject jSONObject) {
        ?? c0694j = new C0694j(0);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONArray) {
                obj = zza((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = zza((JSONObject) obj);
            }
            c0694j.put(next, obj);
        }
        return c0694j;
    }
}
