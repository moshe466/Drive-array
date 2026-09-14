package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "VideoOptionsParcelCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzyw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzyw> CREATOR = new zzyv();

    @SafeParcelable.Field(id = 2)
    public final boolean zzabv;

    @SafeParcelable.Field(id = 3)
    public final boolean zzabw;

    @SafeParcelable.Field(id = 4)
    public final boolean zzabx;

    public zzyw(VideoOptions videoOptions) {
        this(videoOptions.getStartMuted(), videoOptions.getCustomControlsRequested(), videoOptions.getClickToExpandRequested());
    }

    @SafeParcelable.Constructor
    public zzyw(@SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 4) boolean z3) {
        this.zzabv = z;
        this.zzabw = z2;
        this.zzabx = z3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzabv);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzabw);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzabx);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
