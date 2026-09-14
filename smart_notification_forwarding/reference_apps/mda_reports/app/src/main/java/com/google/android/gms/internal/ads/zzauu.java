package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "SignalConfigurationParcelCreator")
/* loaded from: classes.dex */
public final class zzauu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzauu> CREATOR = new zzaux();

    @SafeParcelable.Field(id = 2)
    public final String zzblx;

    @SafeParcelable.Field(id = 1)
    public final String zzbqz;

    @SafeParcelable.Field(id = 3)
    public final zzuj zzdpu;

    @SafeParcelable.Constructor
    public zzauu(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) zzuj zzujVar) {
        this.zzbqz = str;
        this.zzblx = str2;
        this.zzdpu = zzujVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzbqz, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzblx, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdpu, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
