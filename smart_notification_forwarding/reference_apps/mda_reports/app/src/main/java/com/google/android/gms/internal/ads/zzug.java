package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

@SafeParcelable.Class(creator = "AdRequestParcelCreator")
/* loaded from: classes.dex */
public final class zzug extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzug> CREATOR = new zzui();

    @SafeParcelable.Field(id = 3)
    public final Bundle extras;

    @SafeParcelable.Field(id = 1)
    public final int versionCode;

    @SafeParcelable.Field(id = 7)
    public final int zzabo;

    @SafeParcelable.Field(id = 20)
    public final int zzabp;

    @Nullable
    @SafeParcelable.Field(id = 21)
    public final String zzabq;

    @SafeParcelable.Field(id = 8)
    public final boolean zzbkh;

    @SafeParcelable.Field(id = 2)
    @Deprecated
    public final long zzcby;

    @SafeParcelable.Field(id = 4)
    @Deprecated
    public final int zzcbz;

    @SafeParcelable.Field(id = 5)
    public final List<String> zzcca;

    @SafeParcelable.Field(id = 6)
    public final boolean zzccb;

    @SafeParcelable.Field(id = 9)
    public final String zzccc;

    @SafeParcelable.Field(id = 10)
    public final zzys zzccd;

    @SafeParcelable.Field(id = 12)
    public final String zzcce;

    @SafeParcelable.Field(id = 13)
    public final Bundle zzccf;

    @SafeParcelable.Field(id = 14)
    public final Bundle zzccg;

    @SafeParcelable.Field(id = 15)
    public final List<String> zzcch;

    @SafeParcelable.Field(id = 16)
    public final String zzcci;

    @SafeParcelable.Field(id = 17)
    public final String zzccj;

    @SafeParcelable.Field(id = 18)
    @Deprecated
    public final boolean zzcck;

    @SafeParcelable.Field(id = 22)
    public final List<String> zzccl;

    @Nullable
    @SafeParcelable.Field(id = 19)
    public final zzua zzccm;

    @SafeParcelable.Field(id = 11)
    public final Location zzmi;

    @SafeParcelable.Constructor
    public zzug(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) long j, @SafeParcelable.Param(id = 3) Bundle bundle, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) List<String> list, @SafeParcelable.Param(id = 6) boolean z, @SafeParcelable.Param(id = 7) int i3, @SafeParcelable.Param(id = 8) boolean z2, @SafeParcelable.Param(id = 9) String str, @SafeParcelable.Param(id = 10) zzys zzysVar, @SafeParcelable.Param(id = 11) Location location, @SafeParcelable.Param(id = 12) String str2, @SafeParcelable.Param(id = 13) Bundle bundle2, @SafeParcelable.Param(id = 14) Bundle bundle3, @SafeParcelable.Param(id = 15) List<String> list2, @SafeParcelable.Param(id = 16) String str3, @SafeParcelable.Param(id = 17) String str4, @SafeParcelable.Param(id = 18) boolean z3, @SafeParcelable.Param(id = 19) zzua zzuaVar, @SafeParcelable.Param(id = 20) int i4, @Nullable @SafeParcelable.Param(id = 21) String str5, @SafeParcelable.Param(id = 22) List<String> list3) {
        this.versionCode = i;
        this.zzcby = j;
        this.extras = bundle == null ? new Bundle() : bundle;
        this.zzcbz = i2;
        this.zzcca = list;
        this.zzccb = z;
        this.zzabo = i3;
        this.zzbkh = z2;
        this.zzccc = str;
        this.zzccd = zzysVar;
        this.zzmi = location;
        this.zzcce = str2;
        this.zzccf = bundle2 == null ? new Bundle() : bundle2;
        this.zzccg = bundle3;
        this.zzcch = list2;
        this.zzcci = str3;
        this.zzccj = str4;
        this.zzcck = z3;
        this.zzccm = zzuaVar;
        this.zzabp = i4;
        this.zzabq = str5;
        this.zzccl = list3 == null ? new ArrayList<>() : list3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzug)) {
            return false;
        }
        zzug zzugVar = (zzug) obj;
        return this.versionCode == zzugVar.versionCode && this.zzcby == zzugVar.zzcby && Objects.equal(this.extras, zzugVar.extras) && this.zzcbz == zzugVar.zzcbz && Objects.equal(this.zzcca, zzugVar.zzcca) && this.zzccb == zzugVar.zzccb && this.zzabo == zzugVar.zzabo && this.zzbkh == zzugVar.zzbkh && Objects.equal(this.zzccc, zzugVar.zzccc) && Objects.equal(this.zzccd, zzugVar.zzccd) && Objects.equal(this.zzmi, zzugVar.zzmi) && Objects.equal(this.zzcce, zzugVar.zzcce) && Objects.equal(this.zzccf, zzugVar.zzccf) && Objects.equal(this.zzccg, zzugVar.zzccg) && Objects.equal(this.zzcch, zzugVar.zzcch) && Objects.equal(this.zzcci, zzugVar.zzcci) && Objects.equal(this.zzccj, zzugVar.zzccj) && this.zzcck == zzugVar.zzcck && this.zzabp == zzugVar.zzabp && Objects.equal(this.zzabq, zzugVar.zzabq) && Objects.equal(this.zzccl, zzugVar.zzccl);
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.versionCode), Long.valueOf(this.zzcby), this.extras, Integer.valueOf(this.zzcbz), this.zzcca, Boolean.valueOf(this.zzccb), Integer.valueOf(this.zzabo), Boolean.valueOf(this.zzbkh), this.zzccc, this.zzccd, this.zzmi, this.zzcce, this.zzccf, this.zzccg, this.zzcch, this.zzcci, this.zzccj, Boolean.valueOf(this.zzcck), Integer.valueOf(this.zzabp), this.zzabq, this.zzccl);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeLong(parcel, 2, this.zzcby);
        SafeParcelWriter.writeBundle(parcel, 3, this.extras, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzcbz);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzcca, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzccb);
        SafeParcelWriter.writeInt(parcel, 7, this.zzabo);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbkh);
        SafeParcelWriter.writeString(parcel, 9, this.zzccc, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzccd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzmi, i, false);
        SafeParcelWriter.writeString(parcel, 12, this.zzcce, false);
        SafeParcelWriter.writeBundle(parcel, 13, this.zzccf, false);
        SafeParcelWriter.writeBundle(parcel, 14, this.zzccg, false);
        SafeParcelWriter.writeStringList(parcel, 15, this.zzcch, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzcci, false);
        SafeParcelWriter.writeString(parcel, 17, this.zzccj, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzcck);
        SafeParcelWriter.writeParcelable(parcel, 19, this.zzccm, i, false);
        SafeParcelWriter.writeInt(parcel, 20, this.zzabp);
        SafeParcelWriter.writeString(parcel, 21, this.zzabq, false);
        SafeParcelWriter.writeStringList(parcel, 22, this.zzccl, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
