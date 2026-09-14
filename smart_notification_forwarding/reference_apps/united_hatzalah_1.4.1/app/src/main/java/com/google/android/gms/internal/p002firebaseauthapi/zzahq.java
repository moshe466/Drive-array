package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Strings;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzahq {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final long zzd;
    private final zzair zze;

    private zzahq(String str, String str2, String str3, long j2, zzair zzairVar) {
        if (!TextUtils.isEmpty(str) && zzairVar != null) {
            Log.e("MfaInfo", "Cannot have both MFA phone_info and totp_info");
            throw new IllegalArgumentException("Cannot have both MFA phone_info and totp_info");
        }
        this.zza = str;
        this.zzb = Preconditions.checkNotEmpty(str2);
        this.zzc = str3;
        this.zzd = j2;
        this.zze = zzairVar;
    }

    private static long zza(String str) {
        try {
            return zzaoe.zza(zzaoe.zza(str));
        } catch (ParseException unused) {
            return 0L;
        }
    }

    public final zzair zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final String zze() {
        return this.zza;
    }

    public final long zza() {
        return this.zzd;
    }

    public static zzahq zza(JSONObject jSONObject) {
        zzahq zzahqVar = new zzahq(Strings.emptyToNull(jSONObject.optString("phoneInfo")), Strings.emptyToNull(jSONObject.optString("mfaEnrollmentId")), Strings.emptyToNull(jSONObject.optString("displayName")), zza(jSONObject.optString("enrolledAt", "")), jSONObject.opt("totpInfo") != null ? new zzair() : null);
        jSONObject.optString("unobfuscatedPhoneInfo");
        return zzahqVar;
    }

    public static List<zzahq> zza(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(zza(jSONArray.getJSONObject(i)));
            }
            return arrayList;
        }
        return new ArrayList();
    }
}
