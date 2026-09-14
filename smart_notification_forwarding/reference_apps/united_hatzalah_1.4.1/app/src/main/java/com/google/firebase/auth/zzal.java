package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzal> CREATOR = new zzan();
    private final String zza;
    private final String zzb;
    private final String zzc;

    public zzal(String str, String str2, String str3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    public static com.google.android.gms.internal.p002firebaseauthapi.zzaj<zzal> zza(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            com.google.android.gms.internal.p002firebaseauthapi.zzam zzg = com.google.android.gms.internal.p002firebaseauthapi.zzaj.zzg();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                zzg.zza(new zzal(jSONObject.getString("credentialId"), jSONObject.getString("name"), jSONObject.getString("displayName")));
            }
            return zzg.zza();
        }
        return com.google.android.gms.internal.p002firebaseauthapi.zzaj.zza(new ArrayList());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public static final zzal zza(JSONObject jSONObject) {
        return new zzal(jSONObject.getString("credentialId"), jSONObject.getString("name"), jSONObject.getString("displayName"));
    }

    public static final JSONObject zza(zzal zzalVar) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("credentialId", zzalVar.zza);
        jSONObject.put("name", zzalVar.zzb);
        jSONObject.put("displayName", zzalVar.zzc);
        return jSONObject;
    }
}
