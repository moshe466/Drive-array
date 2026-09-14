package com.google.android.gms.gass.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ProgramRequestCreator")
/* loaded from: classes.dex */
public final class zzm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzm> CREATOR = new zzl();

    @SafeParcelable.VersionField(id = 1)
    private final int versionCode;

    @SafeParcelable.Field(id = 3)
    private final String zzgsf;

    @SafeParcelable.Field(id = 4)
    private final String zzgsg;

    @SafeParcelable.Field(id = 2)
    private final int zzgsh;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzm(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2) {
        this.versionCode = i;
        this.zzgsh = i2;
        this.zzgsf = str;
        this.zzgsg = str2;
    }

    public zzm(int i, String str, String str2) {
        this(1, i, str, str2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeInt(parcel, 2, this.zzgsh);
        SafeParcelWriter.writeString(parcel, 3, this.zzgsf, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzgsg, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
