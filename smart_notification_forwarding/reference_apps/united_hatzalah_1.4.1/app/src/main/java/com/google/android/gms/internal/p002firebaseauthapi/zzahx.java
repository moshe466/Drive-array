package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.util.Strings;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class zzahx implements zzaer<zzahx> {
    private static final String zza = "zzahx";
    private String zzb;
    private String zzc;
    private String zzd;
    private zzahq zze;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzahx zza(String str) {
        String str2;
        char c4;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString(Scopes.EMAIL));
            this.zzc = Strings.emptyToNull(jSONObject.optString("newEmail"));
            int optInt = jSONObject.optInt("reqType");
            if (optInt != 1) {
                switch (optInt) {
                    case 4:
                        str2 = "VERIFY_EMAIL";
                        break;
                    case 5:
                        str2 = "RECOVER_EMAIL";
                        break;
                    case 6:
                        str2 = "EMAIL_SIGNIN";
                        break;
                    case 7:
                        str2 = "VERIFY_AND_CHANGE_EMAIL";
                        break;
                    case 8:
                        str2 = "REVERT_SECOND_FACTOR_ADDITION";
                        break;
                    default:
                        str2 = null;
                        break;
                }
            } else {
                str2 = "PASSWORD_RESET";
            }
            this.zzd = str2;
            if (TextUtils.isEmpty(str2)) {
                String optString = jSONObject.optString("requestType");
                switch (optString.hashCode()) {
                    case -1874510116:
                        if (optString.equals("REVERT_SECOND_FACTOR_ADDITION")) {
                            c4 = 5;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case -1452371317:
                        if (optString.equals("PASSWORD_RESET")) {
                            c4 = 1;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case -1341836234:
                        if (optString.equals("VERIFY_EMAIL")) {
                            c4 = 0;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case -1099157829:
                        if (optString.equals("VERIFY_AND_CHANGE_EMAIL")) {
                            c4 = 3;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case 870738373:
                        if (optString.equals("EMAIL_SIGNIN")) {
                            c4 = 2;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case 970484929:
                        if (optString.equals("RECOVER_EMAIL")) {
                            c4 = 4;
                            break;
                        }
                        c4 = 65535;
                        break;
                    default:
                        c4 = 65535;
                        break;
                }
                this.zzd = (c4 == 0 || c4 == 1 || c4 == 2 || c4 == 3 || c4 == 4 || c4 == 5) ? optString : null;
            }
            if (jSONObject.has("mfaInfo")) {
                this.zze = zzahq.zza(jSONObject.optJSONObject("mfaInfo"));
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

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzd;
    }

    public final boolean zze() {
        if (this.zzb != null) {
            return true;
        }
        return false;
    }

    public final boolean zzf() {
        if (this.zze != null) {
            return true;
        }
        return false;
    }

    public final boolean zzg() {
        if (this.zzc != null) {
            return true;
        }
        return false;
    }

    public final boolean zzh() {
        if (this.zzd != null) {
            return true;
        }
        return false;
    }

    public final zzahq zza() {
        return this.zze;
    }

    public final String zzb() {
        return this.zzb;
    }
}
