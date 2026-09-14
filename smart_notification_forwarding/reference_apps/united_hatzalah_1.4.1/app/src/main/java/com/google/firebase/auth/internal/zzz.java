package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.auth.AdditionalUserInfo;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import java.util.List;

/* loaded from: classes.dex */
public final class zzz implements AuthResult {
    public static final Parcelable.Creator<zzz> CREATOR = new zzy();
    private zzaf zza;
    private zzx zzb;
    private com.google.firebase.auth.zzc zzc;

    public zzz(zzaf zzafVar) {
        zzaf zzafVar2 = (zzaf) Preconditions.checkNotNull(zzafVar);
        this.zza = zzafVar2;
        List<zzab> zzj = zzafVar2.zzj();
        this.zzb = null;
        for (int i = 0; i < zzj.size(); i++) {
            if (!TextUtils.isEmpty(zzj.get(i).zza())) {
                this.zzb = new zzx(zzj.get(i).getProviderId(), zzj.get(i).zza(), zzafVar.zzk());
            }
        }
        if (this.zzb == null) {
            this.zzb = new zzx(zzafVar.zzk());
        }
        this.zzc = zzafVar.zzh();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.firebase.auth.AuthResult
    public final AdditionalUserInfo getAdditionalUserInfo() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.AuthResult
    public final AuthCredential getCredential() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.AuthResult
    public final FirebaseUser getUser() {
        return this.zza;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getUser(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getAdditionalUserInfo(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzz(zzaf zzafVar, zzx zzxVar, com.google.firebase.auth.zzc zzcVar) {
        this.zza = zzafVar;
        this.zzb = zzxVar;
        this.zzc = zzcVar;
    }
}
