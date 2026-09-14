package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdapterStatusParcelCreator")
/* loaded from: classes.dex */
public final class zzagn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzagn> CREATOR = new zzagq();

    @SafeParcelable.Field(id = 4)
    public final String description;

    @SafeParcelable.Field(id = 1)
    public final String zzcyc;

    @SafeParcelable.Field(id = 2)
    public final boolean zzcyd;

    @SafeParcelable.Field(id = 3)
    public final int zzcye;

    @SafeParcelable.Constructor
    public zzagn(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) int i, @SafeParcelable.Param(id = 4) String str2) {
        this.zzcyc = str;
        this.zzcyd = z;
        this.zzcye = i;
        this.description = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzcyc, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzcyd);
        SafeParcelWriter.writeInt(parcel, 3, this.zzcye);
        SafeParcelWriter.writeString(parcel, 4, this.description, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
