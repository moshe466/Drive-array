package com.google.android.gms.internal.location;

import F0.AbstractC0008a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.location.DeviceOrientationRequest;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class zzh extends AbstractSafeParcelable {
    final DeviceOrientationRequest zzc;
    final List zzd;
    final String zze;
    static final List zza = Collections.EMPTY_LIST;
    static final DeviceOrientationRequest zzb = new DeviceOrientationRequest.Builder(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT).build();
    public static final Parcelable.Creator<zzh> CREATOR = new zzi();

    public zzh(DeviceOrientationRequest deviceOrientationRequest, List list, String str) {
        this.zzc = deviceOrientationRequest;
        this.zzd = list;
        this.zze = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzh)) {
            return false;
        }
        zzh zzhVar = (zzh) obj;
        if (!Objects.equal(this.zzc, zzhVar.zzc) || !Objects.equal(this.zzd, zzhVar.zzd) || !Objects.equal(this.zze, zzhVar.zze)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.zzc.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzc);
        String valueOf2 = String.valueOf(this.zzd);
        int length = valueOf.length();
        int length2 = valueOf2.length();
        String str = this.zze;
        StringBuilder sb = new StringBuilder(length + 68 + length2 + 7 + String.valueOf(str).length() + 2);
        sb.append("DeviceOrientationRequestInternal[deviceOrientationRequest=");
        sb.append(valueOf);
        sb.append(", clients=");
        sb.append(valueOf2);
        return AbstractC0008a.v(sb, ", tag='", str, "']");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzc, i, false);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 3, this.zze, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
