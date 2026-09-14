package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "IconAdOptionsParcelCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzxh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzxh> CREATOR = new zzxk();

    @SafeParcelable.Field(id = 2)
    private final int zzced;

    @SafeParcelable.Constructor
    public zzxh(@SafeParcelable.Param(id = 2) int i) {
        this.zzced = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzced);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
