package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class zzago implements zzaer<zzago> {
    private static final String zza = "zzago";
    private String zzb;
    private String zzc;
    private boolean zzd;
    private long zze;
    private List<zzahq> zzf;
    private String zzg;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzago zza(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.optString("localId", null);
            jSONObject.optString(Scopes.EMAIL, null);
            this.zzb = jSONObject.optString("idToken", null);
            this.zzc = jSONObject.optString("refreshToken", null);
            this.zzd = jSONObject.optBoolean("isNewUser", false);
            this.zze = jSONObject.optLong("expiresIn", 0L);
            this.zzf = zzahq.zza(jSONObject.optJSONArray("mfaInfo"));
            this.zzg = jSONObject.optString("mfaPendingCredential", null);
            return this;
        } catch (NullPointerException | JSONException e4) {
            throw zzajc.zza(e4, zza, str);
        }
    }

    public final long zza() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzg;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final List<zzahq> zze() {
        return this.zzf;
    }

    public final boolean zzf() {
        if (!TextUtils.isEmpty(this.zzg)) {
            return true;
        }
        return false;
    }

    public final boolean zzg() {
        return this.zzd;
    }

    public final String zzb() {
        return this.zzb;
    }
}
