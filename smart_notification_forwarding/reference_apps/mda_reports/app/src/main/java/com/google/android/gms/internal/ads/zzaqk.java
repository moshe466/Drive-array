package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "NonagonRequestParcelCreator")
/* loaded from: classes.dex */
public final class zzaqk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaqk> CREATOR = new zzaqn();

    @SafeParcelable.Field(id = 3)
    public final ApplicationInfo applicationInfo;

    @SafeParcelable.Field(id = 4)
    public final String packageName;

    @SafeParcelable.Field(id = 2)
    public final zzazb zzdij;

    @Nullable
    @SafeParcelable.Field(id = 6)
    public final PackageInfo zzdip;

    @SafeParcelable.Field(id = 5)
    public final List<String> zzdiz;

    @SafeParcelable.Field(id = 7)
    public final String zzdjj;

    @SafeParcelable.Field(id = 1)
    public final Bundle zzdlu;

    @SafeParcelable.Field(id = 8)
    public final boolean zzdlv;

    @SafeParcelable.Field(id = 9)
    public final String zzdlw;

    @Nullable
    @SafeParcelable.Field(id = 10)
    public zzdbe zzdlx;

    @Nullable
    @SafeParcelable.Field(id = 11)
    public String zzdly;

    @SafeParcelable.Constructor
    public zzaqk(@SafeParcelable.Param(id = 1) Bundle bundle, @SafeParcelable.Param(id = 2) zzazb zzazbVar, @SafeParcelable.Param(id = 3) ApplicationInfo applicationInfo, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) List<String> list, @Nullable @SafeParcelable.Param(id = 6) PackageInfo packageInfo, @SafeParcelable.Param(id = 7) String str2, @SafeParcelable.Param(id = 8) boolean z, @SafeParcelable.Param(id = 9) String str3, @SafeParcelable.Param(id = 10) zzdbe zzdbeVar, @SafeParcelable.Param(id = 11) String str4) {
        this.zzdlu = bundle;
        this.zzdij = zzazbVar;
        this.packageName = str;
        this.applicationInfo = applicationInfo;
        this.zzdiz = list;
        this.zzdip = packageInfo;
        this.zzdjj = str2;
        this.zzdlv = z;
        this.zzdlw = str3;
        this.zzdlx = zzdbeVar;
        this.zzdly = str4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.zzdlu, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdij, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.applicationInfo, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.packageName, false);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzdiz, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzdip, i, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzdjj, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdlv);
        SafeParcelWriter.writeString(parcel, 9, this.zzdlw, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzdlx, i, false);
        SafeParcelWriter.writeString(parcel, 11, this.zzdly, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
