package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class zzahk implements zzaer<zzahk> {
    private static final String zza = "zzahk";
    private String zzb;
    private zzaj<zzahv> zzc;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzahk zza(String str) {
        zzaj<zzahv> zza2;
        zzahv zza3;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString("recaptchaKey"));
            if (jSONObject.has("recaptchaEnforcementState")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("recaptchaEnforcementState");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    zzam zzg = zzaj.zzg();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 == null) {
                            zza3 = zzahv.zza(null, null);
                        } else {
                            zza3 = zzahv.zza(Strings.emptyToNull(jSONObject2.optString("provider")), Strings.emptyToNull(jSONObject2.optString("enforcementState")));
                        }
                        zzg.zza(zza3);
                    }
                    zza2 = zzg.zza();
                    this.zzc = zza2;
                }
                zza2 = zzaj.zza(new ArrayList());
                this.zzc = zza2;
            }
            return this;
        } catch (NullPointerException e4) {
            e = e4;
            throw zzajc.zza(e, zza, str);
        } catch (JSONException e5) {
            e = e5;
            throw zzajc.zza(e, zza, str);
        }
    }

    public final String zzb(String str) {
        Preconditions.checkNotEmpty(str);
        zzaj<zzahv> zzajVar = this.zzc;
        if (zzajVar != null && !zzajVar.isEmpty()) {
            zzaj<zzahv> zzajVar2 = this.zzc;
            int size = zzajVar2.size();
            int i = 0;
            while (i < size) {
                zzahv zzahvVar = zzajVar2.get(i);
                i++;
                zzahv zzahvVar2 = zzahvVar;
                String zza2 = zzahvVar2.zza();
                String zzb = zzahvVar2.zzb();
                if (zza2 != null && zzb != null && zzb.equals(str)) {
                    return zzahvVar2.zza();
                }
            }
        }
        return null;
    }

    public final boolean zzc(String str) {
        String zzb = zzb(str);
        if (zzb == null) {
            return false;
        }
        if (!zzb.equals("ENFORCE") && !zzb.equals("AUDIT")) {
            return false;
        }
        return true;
    }

    public final String zza() {
        return this.zzb;
    }
}
