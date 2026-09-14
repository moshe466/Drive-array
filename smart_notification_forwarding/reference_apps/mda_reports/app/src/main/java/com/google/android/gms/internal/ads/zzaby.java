package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "NativeAdOptionsParcelCreator")
/* loaded from: classes.dex */
public final class zzaby extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaby> CREATOR = new zzabx();

    @SafeParcelable.Field(id = 1)
    public final int versionCode;

    @SafeParcelable.Field(id = 3)
    public final int zzbjw;

    @SafeParcelable.Field(id = 8)
    public final int zzbjx;

    @SafeParcelable.Field(id = 4)
    public final boolean zzbjy;

    @SafeParcelable.Field(id = 5)
    public final int zzbjz;

    @SafeParcelable.Field(id = 7)
    public final boolean zzbkb;

    @SafeParcelable.Field(id = 2)
    public final boolean zzcvo;

    @Nullable
    @SafeParcelable.Field(id = 6)
    public final zzyw zzcvp;

    @SafeParcelable.Constructor
    public zzaby(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) boolean z2, @SafeParcelable.Param(id = 5) int i3, @SafeParcelable.Param(id = 6) zzyw zzywVar, @SafeParcelable.Param(id = 7) boolean z3, @SafeParcelable.Param(id = 8) int i4) {
        this.versionCode = i;
        this.zzcvo = z;
        this.zzbjw = i2;
        this.zzbjy = z2;
        this.zzbjz = i3;
        this.zzcvp = zzywVar;
        this.zzbkb = z3;
        this.zzbjx = i4;
    }

    public zzaby(NativeAdOptions nativeAdOptions) {
        this(4, nativeAdOptions.shouldReturnUrlsForImageAssets(), nativeAdOptions.getImageOrientation(), nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzyw(nativeAdOptions.getVideoOptions()) : null, nativeAdOptions.zzjk(), nativeAdOptions.getMediaAspectRatio());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzcvo);
        SafeParcelWriter.writeInt(parcel, 3, this.zzbjw);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzbjy);
        SafeParcelWriter.writeInt(parcel, 5, this.zzbjz);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzcvp, i, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzbkb);
        SafeParcelWriter.writeInt(parcel, 8, this.zzbjx);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
