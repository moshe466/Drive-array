package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "RequestConfigurationParcelCreator")
/* loaded from: classes.dex */
public final class zzyq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzyq> CREATOR = new zzyp();

    @SafeParcelable.Field(id = 1)
    private final int zzabo;

    @SafeParcelable.Field(id = 2)
    private final int zzabp;

    @SafeParcelable.Constructor
    public zzyq(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2) {
        this.zzabo = i;
        this.zzabp = i2;
    }

    public zzyq(RequestConfiguration requestConfiguration) {
        this.zzabo = requestConfiguration.getTagForChildDirectedTreatment();
        this.zzabp = requestConfiguration.getTagForUnderAgeOfConsent();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzabo);
        SafeParcelWriter.writeInt(parcel, 2, this.zzabp);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
