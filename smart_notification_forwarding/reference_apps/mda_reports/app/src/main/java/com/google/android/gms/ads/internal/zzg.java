package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "InterstitialAdParameterParcelCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzg> CREATOR = new zzj();

    @SafeParcelable.Field(id = 2)
    public final boolean zzbkx;

    @SafeParcelable.Field(id = 3)
    public final boolean zzbky;

    @SafeParcelable.Field(id = 4)
    private final String zzbkz;

    @SafeParcelable.Field(id = 5)
    public final boolean zzbla;

    @SafeParcelable.Field(id = 6)
    public final float zzblb;

    @SafeParcelable.Field(id = 7)
    public final int zzblc;

    @SafeParcelable.Field(id = 8)
    public final boolean zzbld;

    @SafeParcelable.Field(id = 9)
    public final boolean zzble;

    @SafeParcelable.Field(id = 10)
    public final boolean zzblf;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzg(@SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) boolean z3, @SafeParcelable.Param(id = 6) float f, @SafeParcelable.Param(id = 7) int i, @SafeParcelable.Param(id = 8) boolean z4, @SafeParcelable.Param(id = 9) boolean z5, @SafeParcelable.Param(id = 10) boolean z6) {
        this.zzbkx = z;
        this.zzbky = z2;
        this.zzbkz = str;
        this.zzbla = z3;
        this.zzblb = f;
        this.zzblc = i;
        this.zzbld = z4;
        this.zzble = z5;
        this.zzblf = z6;
    }

    public zzg(boolean z, boolean z2, boolean z3, float f, int i, boolean z4, boolean z5, boolean z6) {
        this(false, z2, null, false, 0.0f, -1, z4, z5, z6);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzbkx);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzbky);
        SafeParcelWriter.writeString(parcel, 4, this.zzbkz, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzbla);
        SafeParcelWriter.writeFloat(parcel, 6, this.zzblb);
        SafeParcelWriter.writeInt(parcel, 7, this.zzblc);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbld);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzble);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzblf);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
