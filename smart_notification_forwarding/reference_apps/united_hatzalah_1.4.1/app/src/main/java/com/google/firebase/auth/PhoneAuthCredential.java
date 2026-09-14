package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* loaded from: classes.dex */
public class PhoneAuthCredential extends AuthCredential implements Cloneable {
    public static final Parcelable.Creator<PhoneAuthCredential> CREATOR = new zzao();
    private String zza;
    private String zzb;
    private String zzc;
    private boolean zzd;
    private String zze;

    public PhoneAuthCredential(String str, String str2, String str3, boolean z3, String str4) {
        boolean z4;
        if ((!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4))) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkArgument(z4, "Cannot create PhoneAuthCredential without either sessionInfo + smsCode or temporary proof + phoneNumber.");
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = z3;
        this.zze = str4;
    }

    public static PhoneAuthCredential zzb(String str, String str2) {
        return new PhoneAuthCredential(null, null, str, true, str2);
    }

    public /* synthetic */ Object clone() {
        return new PhoneAuthCredential(this.zza, getSmsCode(), this.zzc, this.zzd, this.zze);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return "phone";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getSignInMethod() {
        return "phone";
    }

    public String getSmsCode() {
        return this.zzb;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, getSmsCode(), false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzd);
        SafeParcelWriter.writeString(parcel, 6, this.zze, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential zza() {
        return (PhoneAuthCredential) clone();
    }

    public final String zzc() {
        return this.zza;
    }

    public final String zzd() {
        return this.zze;
    }

    public final boolean zze() {
        return this.zzd;
    }

    public static PhoneAuthCredential zza(String str, String str2) {
        return new PhoneAuthCredential(str, str2, null, true, null);
    }

    public final String zzb() {
        return this.zzc;
    }

    public final PhoneAuthCredential zza(boolean z3) {
        this.zzd = false;
        return this;
    }
}
