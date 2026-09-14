package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.location.zzeo;
import e0.a;
import org.checkerframework.dataflow.qual.Pure;

/* loaded from: classes.dex */
public final class LastLocationRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LastLocationRequest> CREATOR = new zzaa();
    private final long zza;
    private final int zzb;
    private final boolean zzc;
    private final com.google.android.gms.internal.location.zze zzd;

    /* loaded from: classes.dex */
    public static final class Builder {
        private long zza;
        private int zzb;
        private final boolean zzc;
        private final com.google.android.gms.internal.location.zze zzd;

        public Builder() {
            this.zza = Long.MAX_VALUE;
            this.zzb = 0;
            this.zzc = false;
            this.zzd = null;
        }

        public LastLocationRequest build() {
            return new LastLocationRequest(this.zza, this.zzb, this.zzc, this.zzd);
        }

        public Builder setGranularity(int i) {
            zzq.zza(i);
            this.zzb = i;
            return this;
        }

        public Builder setMaxUpdateAgeMillis(long j2) {
            boolean z3;
            if (j2 > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "maxUpdateAgeMillis must be greater than 0");
            this.zza = j2;
            return this;
        }

        public Builder(LastLocationRequest lastLocationRequest) {
            this.zza = lastLocationRequest.getMaxUpdateAgeMillis();
            this.zzb = lastLocationRequest.getGranularity();
            this.zzc = lastLocationRequest.zza();
            this.zzd = lastLocationRequest.zzb();
        }
    }

    public LastLocationRequest(long j2, int i, boolean z3, com.google.android.gms.internal.location.zze zzeVar) {
        this.zza = j2;
        this.zzb = i;
        this.zzc = z3;
        this.zzd = zzeVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LastLocationRequest)) {
            return false;
        }
        LastLocationRequest lastLocationRequest = (LastLocationRequest) obj;
        if (this.zza != lastLocationRequest.zza || this.zzb != lastLocationRequest.zzb || this.zzc != lastLocationRequest.zzc || !Objects.equal(this.zzd, lastLocationRequest.zzd)) {
            return false;
        }
        return true;
    }

    @Pure
    public int getGranularity() {
        return this.zzb;
    }

    @Pure
    public long getMaxUpdateAgeMillis() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Integer.valueOf(this.zzb), Boolean.valueOf(this.zzc));
    }

    public String toString() {
        StringBuilder h2 = a.h("LastLocationRequest[");
        if (this.zza != Long.MAX_VALUE) {
            h2.append("maxAge=");
            zzeo.zzc(this.zza, h2);
        }
        if (this.zzb != 0) {
            h2.append(", ");
            h2.append(zzq.zzb(this.zzb));
        }
        if (this.zzc) {
            h2.append(", bypass");
        }
        if (this.zzd != null) {
            h2.append(", impersonation=");
            h2.append(this.zzd);
        }
        h2.append(']');
        return h2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getMaxUpdateAgeMillis());
        SafeParcelWriter.writeInt(parcel, 2, getGranularity());
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzd, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Pure
    public final boolean zza() {
        return this.zzc;
    }

    @Pure
    public final com.google.android.gms.internal.location.zze zzb() {
        return this.zzd;
    }
}
