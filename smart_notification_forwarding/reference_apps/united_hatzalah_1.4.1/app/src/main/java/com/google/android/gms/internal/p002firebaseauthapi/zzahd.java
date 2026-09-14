package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.util.Strings;
import com.google.firebase.auth.zzal;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class zzahd implements zzaer<zzahd> {
    private static final String zza = "zzahd";
    private zzahf zzb;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzahd zza(String str) {
        zzahf zzahfVar;
        int i;
        zzahc zzahcVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("users")) {
                zzahfVar = new zzahf();
            } else {
                JSONArray optJSONArray = jSONObject.optJSONArray("users");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    ArrayList arrayList = new ArrayList(optJSONArray.length());
                    boolean z3 = false;
                    int i3 = 0;
                    while (i3 < optJSONArray.length()) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                        if (jSONObject2 == null) {
                            zzahcVar = new zzahc();
                            i = i3;
                        } else {
                            i = i3;
                            zzahcVar = new zzahc(Strings.emptyToNull(jSONObject2.optString("localId", null)), Strings.emptyToNull(jSONObject2.optString(Scopes.EMAIL, null)), jSONObject2.optBoolean("emailVerified", z3), Strings.emptyToNull(jSONObject2.optString("displayName", null)), Strings.emptyToNull(jSONObject2.optString("photoUrl", null)), zzahs.zza(jSONObject2.optJSONArray("providerUserInfo")), Strings.emptyToNull(jSONObject2.optString("rawPassword", null)), Strings.emptyToNull(jSONObject2.optString("phoneNumber", null)), jSONObject2.optLong("createdAt", 0L), jSONObject2.optLong("lastLoginAt", 0L), false, null, zzahq.zza(jSONObject2.optJSONArray("mfaInfo")), zzal.zza(jSONObject2.optJSONArray("passkeyInfo")));
                        }
                        arrayList.add(zzahcVar);
                        i3 = i + 1;
                        z3 = false;
                    }
                    zzahfVar = new zzahf(arrayList);
                }
                zzahfVar = new zzahf(new ArrayList());
            }
            this.zzb = zzahfVar;
            return this;
        } catch (NullPointerException e4) {
            e = e4;
            throw zzajc.zza(e, zza, str);
        } catch (JSONException e5) {
            e = e5;
            throw zzajc.zza(e, zza, str);
        }
    }

    public final List<zzahc> zza() {
        return this.zzb.zza();
    }
}
