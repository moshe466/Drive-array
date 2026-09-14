package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.util.Strings;
import com.google.firebase.auth.zzc;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class zzaiv implements zzaer<zzaiv> {
    private static final String zza = "zzaiv";
    private boolean zzb;
    private String zzc;
    private String zzd;
    private long zze;
    private String zzf;
    private String zzg;
    private String zzh;
    private boolean zzi;
    private String zzj;
    private String zzk;
    private String zzl;
    private String zzm;
    private String zzn;
    private String zzo;
    private List<zzahq> zzp;
    private String zzq;

    public final long zza() {
        return this.zze;
    }

    public final zzc zzb() {
        if (TextUtils.isEmpty(this.zzj) && TextUtils.isEmpty(this.zzk)) {
            return null;
        }
        return zzc.zza(this.zzg, this.zzk, this.zzj, this.zzn, this.zzl);
    }

    public final String zzc() {
        return this.zzf;
    }

    public final String zzd() {
        return this.zzm;
    }

    public final String zze() {
        return this.zzc;
    }

    public final String zzf() {
        return this.zzq;
    }

    public final String zzg() {
        return this.zzg;
    }

    public final String zzh() {
        return this.zzh;
    }

    public final String zzi() {
        return this.zzd;
    }

    public final String zzj() {
        return this.zzo;
    }

    public final List<zzahq> zzk() {
        return this.zzp;
    }

    public final boolean zzl() {
        if (!TextUtils.isEmpty(this.zzq)) {
            return true;
        }
        return false;
    }

    public final boolean zzm() {
        return this.zzb;
    }

    public final boolean zzn() {
        return this.zzi;
    }

    public final boolean zzo() {
        if (!this.zzb && TextUtils.isEmpty(this.zzm)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzaiv zza(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = jSONObject.optBoolean("needConfirmation", false);
            jSONObject.optBoolean("needEmail", false);
            this.zzc = Strings.emptyToNull(jSONObject.optString("idToken", null));
            this.zzd = Strings.emptyToNull(jSONObject.optString("refreshToken", null));
            this.zze = jSONObject.optLong("expiresIn", 0L);
            Strings.emptyToNull(jSONObject.optString("localId", null));
            this.zzf = Strings.emptyToNull(jSONObject.optString(Scopes.EMAIL, null));
            Strings.emptyToNull(jSONObject.optString("displayName", null));
            Strings.emptyToNull(jSONObject.optString("photoUrl", null));
            this.zzg = Strings.emptyToNull(jSONObject.optString("providerId", null));
            this.zzh = Strings.emptyToNull(jSONObject.optString("rawUserInfo", null));
            this.zzi = jSONObject.optBoolean("isNewUser", false);
            this.zzj = jSONObject.optString("oauthAccessToken", null);
            this.zzk = jSONObject.optString("oauthIdToken", null);
            this.zzm = Strings.emptyToNull(jSONObject.optString("errorMessage", null));
            this.zzn = Strings.emptyToNull(jSONObject.optString("pendingToken", null));
            this.zzo = Strings.emptyToNull(jSONObject.optString("tenantId", null));
            this.zzp = zzahq.zza(jSONObject.optJSONArray("mfaInfo"));
            this.zzq = Strings.emptyToNull(jSONObject.optString("mfaPendingCredential", null));
            this.zzl = Strings.emptyToNull(jSONObject.optString("oauthTokenSecret", null));
            return this;
        } catch (NullPointerException | JSONException e4) {
            throw zzajc.zza(e4, zza, str);
        }
    }
}
