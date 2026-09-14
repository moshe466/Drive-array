package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* loaded from: classes.dex */
public final class zzas extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzas> CREATOR = new zzat();
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;

    public zzas(int i, int i3, int i4, int i5) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (i >= 0 && i <= 23) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "Start hour must be in range [0, 23].");
        if (i3 >= 0 && i3 <= 59) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkState(z4, "Start minute must be in range [0, 59].");
        if (i4 >= 0 && i4 <= 23) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkState(z5, "End hour must be in range [0, 23].");
        if (i5 >= 0 && i5 <= 59) {
            z6 = true;
        } else {
            z6 = false;
        }
        Preconditions.checkState(z6, "End minute must be in range [0, 59].");
        Preconditions.checkState(((i + i3) + i4) + i5 > 0, "Parameters can't be all 0.");
        this.zza = i;
        this.zzb = i3;
        this.zzc = i4;
        this.zzd = i5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzas)) {
            return false;
        }
        zzas zzasVar = (zzas) obj;
        if (this.zza == zzasVar.zza && this.zzb == zzasVar.zzb && this.zzc == zzasVar.zzc && this.zzd == zzasVar.zzd) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd));
    }

    public final String toString() {
        int i = this.zza;
        int length = String.valueOf(i).length();
        int i3 = this.zzb;
        int length2 = String.valueOf(i3).length();
        int i4 = this.zzc;
        int length3 = String.valueOf(i4).length();
        int i5 = this.zzd;
        StringBuilder sb = new StringBuilder(length + 50 + length2 + 10 + length3 + 12 + String.valueOf(i5).length() + 1);
        sb.append("UserPreferredSleepWindow [startHour=");
        sb.append(i);
        sb.append(", startMinute=");
        sb.append(i3);
        sb.append(", endHour=");
        sb.append(i4);
        sb.append(", endMinute=");
        sb.append(i5);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Preconditions.checkNotNull(parcel);
        int i3 = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i3);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
