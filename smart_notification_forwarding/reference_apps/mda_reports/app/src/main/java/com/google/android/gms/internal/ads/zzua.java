package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdDataParcelCreator")
/* loaded from: classes.dex */
public final class zzua extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzua> CREATOR = new zztz();

    @SafeParcelable.Field(id = 1)
    public final String zzcbu;

    @SafeParcelable.Field(id = 2)
    public final String zzcbv;

    @SafeParcelable.Constructor
    public zzua(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2) {
        this.zzcbu = str;
        this.zzcbv = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzcbu, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzcbv, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
