package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import e0.a;

/* loaded from: classes.dex */
public final class zzad extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzad> CREATOR = new zzae();
    private final boolean zza;
    private final com.google.android.gms.internal.location.zze zzb;

    public zzad(boolean z3, com.google.android.gms.internal.location.zze zzeVar) {
        this.zza = z3;
        this.zzb = zzeVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzad)) {
            return false;
        }
        zzad zzadVar = (zzad) obj;
        if (this.zza != zzadVar.zza || !Objects.equal(this.zzb, zzadVar.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.zza));
    }

    public final String toString() {
        StringBuilder h2 = a.h("LocationAvailabilityRequest[");
        if (this.zza) {
            h2.append("bypass, ");
        }
        if (this.zzb != null) {
            h2.append("impersonation=");
            h2.append(this.zzb);
            h2.append(", ");
        }
        h2.setLength(h2.length() - 2);
        h2.append(']');
        return h2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        boolean z3 = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, z3);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
