package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "RewardedVideoAdRequestParcelCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzaru extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaru> CREATOR = new zzarx();

    @SafeParcelable.Field(id = 3)
    public final String zzbqz;

    @SafeParcelable.Field(id = 2)
    public final zzug zzdio;

    @SafeParcelable.Constructor
    public zzaru(@SafeParcelable.Param(id = 2) zzug zzugVar, @SafeParcelable.Param(id = 3) String str) {
        this.zzdio = zzugVar;
        this.zzbqz = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdio, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzbqz, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
