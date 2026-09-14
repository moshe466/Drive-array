package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* loaded from: classes.dex */
public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new zzb();
    private final String zza;

    @Deprecated
    private final int zzb;
    private final long zzc;
    private final boolean zzd;

    public Feature(String str, int i, long j2, boolean z3) {
        this.zza = str;
        this.zzb = i;
        this.zzc = j2;
        this.zzd = z3;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            if (matches(feature) && getIsFullyRolledOut() == feature.getIsFullyRolledOut()) {
                return true;
            }
        }
        return false;
    }

    public boolean getIsFullyRolledOut() {
        return this.zzd;
    }

    public String getName() {
        return this.zza;
    }

    public long getVersion() {
        long j2 = this.zzc;
        return j2 == -1 ? this.zzb : j2;
    }

    public final int hashCode() {
        return Objects.hashCode(getName(), Long.valueOf(getVersion()), Boolean.valueOf(getIsFullyRolledOut()));
    }

    public boolean matches(Feature feature) {
        if (feature != null && Objects.equal(getName(), feature.getName()) && getVersion() == feature.getVersion()) {
            return true;
        }
        return false;
    }

    public final String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
        stringHelper.add("name", getName());
        stringHelper.add("version", Long.valueOf(getVersion()));
        stringHelper.add("is_fully_rolled_out", Boolean.valueOf(getIsFullyRolledOut()));
        return stringHelper.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getName(), false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeLong(parcel, 3, getVersion());
        SafeParcelWriter.writeBoolean(parcel, 4, getIsFullyRolledOut());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public Feature(String str, int i, long j2) {
        this(str, i, j2, false);
    }

    public Feature(String str, long j2) {
        this(str, -1, j2, false);
    }

    public Feature(String str, long j2, boolean z3) {
        this(str, -1, j2, z3);
    }
}
