package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "InstreamAdConfigurationParcelCreator")
/* loaded from: classes.dex */
public final class zzagz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzagz> CREATOR = new zzahc();

    @SafeParcelable.VersionField(id = 1000)
    public final int versionCode;

    @SafeParcelable.Field(id = 3)
    public final int zzbjx;

    @SafeParcelable.Field(id = 1)
    public final int zzcyi;

    @SafeParcelable.Field(id = 2)
    public final String zzcyj;

    @SafeParcelable.Constructor
    public zzagz(@SafeParcelable.Param(id = 1000) int i, @SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i3) {
        this.versionCode = i;
        this.zzcyi = i2;
        this.zzcyj = str;
        this.zzbjx = i3;
    }

    public zzagz(zzahl zzahlVar) {
        this(2, 1, zzahlVar.zzrw(), zzahlVar.getMediaAspectRatio());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzcyi);
        SafeParcelWriter.writeString(parcel, 2, this.zzcyj, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzbjx);
        SafeParcelWriter.writeInt(parcel, 1000, this.versionCode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
