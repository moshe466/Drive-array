package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p002firebaseauthapi.zzaag;
import com.google.android.gms.internal.p002firebaseauthapi.zzahc;
import com.google.android.gms.internal.p002firebaseauthapi.zzaht;
import com.google.firebase.auth.UserInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzab extends AbstractSafeParcelable implements UserInfo {
    public static final Parcelable.Creator<zzab> CREATOR = new zzaa();
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private Uri zze;
    private String zzf;
    private String zzg;
    private boolean zzh;
    private String zzi;

    public zzab(zzaht zzahtVar) {
        Preconditions.checkNotNull(zzahtVar);
        this.zza = zzahtVar.zzd();
        this.zzb = Preconditions.checkNotEmpty(zzahtVar.zzf());
        this.zzc = zzahtVar.zzb();
        Uri zza = zzahtVar.zza();
        if (zza != null) {
            this.zzd = zza.toString();
            this.zze = zza;
        }
        this.zzf = zzahtVar.zzc();
        this.zzg = zzahtVar.zze();
        this.zzh = false;
        this.zzi = zzahtVar.zzg();
    }

    public static zzab zza(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new zzab(jSONObject.optString("userId"), jSONObject.optString("providerId"), jSONObject.optString(Scopes.EMAIL), jSONObject.optString("phoneNumber"), jSONObject.optString("displayName"), jSONObject.optString("photoUrl"), jSONObject.optBoolean("isEmailVerified"), jSONObject.optString("rawUserInfo"));
        } catch (JSONException e4) {
            throw new zzaag(e4);
        }
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getDisplayName() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getEmail() {
        return this.zzf;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getPhoneNumber() {
        return this.zzg;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final Uri getPhotoUrl() {
        if (!TextUtils.isEmpty(this.zzd) && this.zze == null) {
            this.zze = Uri.parse(this.zzd);
        }
        return this.zze;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getProviderId() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getUid() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final boolean isEmailVerified() {
        return this.zzh;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getUid(), false);
        SafeParcelWriter.writeString(parcel, 2, getProviderId(), false);
        SafeParcelWriter.writeString(parcel, 3, getDisplayName(), false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 5, getEmail(), false);
        SafeParcelWriter.writeString(parcel, 6, getPhoneNumber(), false);
        SafeParcelWriter.writeBoolean(parcel, 7, isEmailVerified());
        SafeParcelWriter.writeString(parcel, 8, this.zzi, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zzb() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("userId", this.zza);
            jSONObject.putOpt("providerId", this.zzb);
            jSONObject.putOpt("displayName", this.zzc);
            jSONObject.putOpt("photoUrl", this.zzd);
            jSONObject.putOpt(Scopes.EMAIL, this.zzf);
            jSONObject.putOpt("phoneNumber", this.zzg);
            jSONObject.putOpt("isEmailVerified", Boolean.valueOf(this.zzh));
            jSONObject.putOpt("rawUserInfo", this.zzi);
            return jSONObject.toString();
        } catch (JSONException e4) {
            throw new zzaag(e4);
        }
    }

    public final String zza() {
        return this.zzi;
    }

    public zzab(zzahc zzahcVar, String str) {
        Preconditions.checkNotNull(zzahcVar);
        Preconditions.checkNotEmpty(str);
        this.zza = Preconditions.checkNotEmpty(zzahcVar.zzi());
        this.zzb = str;
        this.zzf = zzahcVar.zzh();
        this.zzc = zzahcVar.zzg();
        Uri zzc = zzahcVar.zzc();
        if (zzc != null) {
            this.zzd = zzc.toString();
            this.zze = zzc;
        }
        this.zzh = zzahcVar.zzm();
        this.zzi = null;
        this.zzg = zzahcVar.zzj();
    }

    public zzab(String str, String str2, String str3, String str4, String str5, String str6, boolean z3, String str7) {
        this.zza = str;
        this.zzb = str2;
        this.zzf = str3;
        this.zzg = str4;
        this.zzc = str5;
        this.zzd = str6;
        if (!TextUtils.isEmpty(str6)) {
            this.zze = Uri.parse(this.zzd);
        }
        this.zzh = z3;
        this.zzi = str7;
    }
}
