package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.auth.ActionCodeUrl;
import com.google.firebase.auth.EmailAuthCredential;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class zzagp implements zzaes {
    private static final String zza = "zzagp";
    private final String zzb;
    private final String zzc;
    private final EmailAuthCredential zzd;
    private final String zze;
    private final String zzf;

    static {
        new Logger(zza, new String[0]);
    }

    public zzagp(EmailAuthCredential emailAuthCredential, String str, String str2) {
        this.zzd = (EmailAuthCredential) Preconditions.checkNotNull(emailAuthCredential);
        this.zzb = Preconditions.checkNotEmpty(emailAuthCredential.zzc());
        this.zzc = Preconditions.checkNotEmpty(emailAuthCredential.zze());
        this.zze = str;
        this.zzf = str2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaes
    public final String zza() {
        String str;
        ActionCodeUrl parseLink = ActionCodeUrl.parseLink(this.zzc);
        String str2 = null;
        if (parseLink != null) {
            str = parseLink.getCode();
        } else {
            str = null;
        }
        if (parseLink != null) {
            str2 = parseLink.zza();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Scopes.EMAIL, this.zzb);
        if (str != null) {
            jSONObject.put("oobCode", str);
        }
        if (str2 != null) {
            jSONObject.put("tenantId", str2);
        }
        String str3 = this.zze;
        if (str3 != null) {
            jSONObject.put("idToken", str3);
        }
        String str4 = this.zzf;
        if (str4 != null) {
            zzajc.zza(jSONObject, "captchaResp", str4);
        } else {
            zzajc.zza(jSONObject);
        }
        return jSONObject.toString();
    }

    public final EmailAuthCredential zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zzf;
    }
}
