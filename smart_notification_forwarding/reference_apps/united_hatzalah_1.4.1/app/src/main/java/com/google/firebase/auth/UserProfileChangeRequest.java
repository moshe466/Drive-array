package com.google.firebase.auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* loaded from: classes.dex */
public class UserProfileChangeRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<UserProfileChangeRequest> CREATOR = new zzau();
    private String zza;
    private String zzb;
    private boolean zzc;
    private boolean zzd;
    private Uri zze;

    /* loaded from: classes.dex */
    public static class Builder {
        private String zza;
        private Uri zzb;
        private boolean zzc;
        private boolean zzd;

        public UserProfileChangeRequest build() {
            String uri;
            String str = this.zza;
            Uri uri2 = this.zzb;
            if (uri2 == null) {
                uri = null;
            } else {
                uri = uri2.toString();
            }
            return new UserProfileChangeRequest(str, uri, this.zzc, this.zzd);
        }

        public String getDisplayName() {
            return this.zza;
        }

        public Uri getPhotoUri() {
            return this.zzb;
        }

        public Builder setDisplayName(String str) {
            if (str == null) {
                this.zzc = true;
                return this;
            }
            this.zza = str;
            return this;
        }

        public Builder setPhotoUri(Uri uri) {
            if (uri == null) {
                this.zzd = true;
                return this;
            }
            this.zzb = uri;
            return this;
        }
    }

    public UserProfileChangeRequest(String str, String str2, boolean z3, boolean z4) {
        Uri parse;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z3;
        this.zzd = z4;
        if (TextUtils.isEmpty(str2)) {
            parse = null;
        } else {
            parse = Uri.parse(str2);
        }
        this.zze = parse;
    }

    public String getDisplayName() {
        return this.zza;
    }

    public Uri getPhotoUri() {
        return this.zze;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zza() {
        return this.zzb;
    }

    public final boolean zzb() {
        return this.zzc;
    }

    public final boolean zzc() {
        return this.zzd;
    }
}
