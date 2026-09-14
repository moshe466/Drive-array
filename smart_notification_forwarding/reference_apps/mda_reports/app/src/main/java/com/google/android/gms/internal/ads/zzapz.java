package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "AutoClickProtectionConfigurationParcelCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzapz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzapz> CREATOR = new zzapy();

    @SafeParcelable.Field(id = 2)
    public final boolean zzdln;

    @Nullable
    @SafeParcelable.Field(id = 3)
    public final List<String> zzdlo;

    public zzapz() {
        this(false, Collections.emptyList());
    }

    @SafeParcelable.Constructor
    public zzapz(@SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) List<String> list) {
        this.zzdln = z;
        this.zzdlo = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzdln);
        SafeParcelWriter.writeStringList(parcel, 3, this.zzdlo, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
