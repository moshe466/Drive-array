package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.internal.location.zzeo;
import e0.a;
import org.checkerframework.dataflow.qual.Pure;

/* loaded from: classes.dex */
public final class CurrentLocationRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CurrentLocationRequest> CREATOR = new zzj();
    private final long zza;
    private final int zzb;
    private final int zzc;
    private final long zzd;
    private final boolean zze;
    private final int zzf;
    private final WorkSource zzg;
    private final com.google.android.gms.internal.location.zze zzh;

    /* loaded from: classes.dex */
    public static final class Builder {
        private long zza;
        private int zzb;
        private int zzc;
        private long zzd;
        private final boolean zze;
        private final int zzf;
        private final WorkSource zzg;
        private final com.google.android.gms.internal.location.zze zzh;

        public Builder() {
            this.zza = 10000L;
            this.zzb = 0;
            this.zzc = 102;
            this.zzd = Long.MAX_VALUE;
            this.zze = false;
            this.zzf = 0;
            this.zzg = null;
            this.zzh = null;
        }

        public CurrentLocationRequest build() {
            return new CurrentLocationRequest(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, new WorkSource(this.zzg), this.zzh);
        }

        public Builder setDurationMillis(long j2) {
            boolean z3;
            if (j2 > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "durationMillis must be greater than 0");
            this.zzd = j2;
            return this;
        }

        public Builder setGranularity(int i) {
            zzq.zza(i);
            this.zzb = i;
            return this;
        }

        public Builder setMaxUpdateAgeMillis(long j2) {
            boolean z3;
            if (j2 >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "maxUpdateAgeMillis must be greater than or equal to 0");
            this.zza = j2;
            return this;
        }

        public Builder setPriority(int i) {
            zzan.zza(i);
            this.zzc = i;
            return this;
        }

        public Builder(CurrentLocationRequest currentLocationRequest) {
            this.zza = currentLocationRequest.getMaxUpdateAgeMillis();
            this.zzb = currentLocationRequest.getGranularity();
            this.zzc = currentLocationRequest.getPriority();
            this.zzd = currentLocationRequest.getDurationMillis();
            this.zze = currentLocationRequest.zza();
            this.zzf = currentLocationRequest.zzb();
            this.zzg = new WorkSource(currentLocationRequest.zzc());
            this.zzh = currentLocationRequest.zzd();
        }
    }

    public CurrentLocationRequest(long j2, int i, int i3, long j3, boolean z3, int i4, WorkSource workSource, com.google.android.gms.internal.location.zze zzeVar) {
        this.zza = j2;
        this.zzb = i;
        this.zzc = i3;
        this.zzd = j3;
        this.zze = z3;
        this.zzf = i4;
        this.zzg = workSource;
        this.zzh = zzeVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CurrentLocationRequest)) {
            return false;
        }
        CurrentLocationRequest currentLocationRequest = (CurrentLocationRequest) obj;
        if (this.zza != currentLocationRequest.zza || this.zzb != currentLocationRequest.zzb || this.zzc != currentLocationRequest.zzc || this.zzd != currentLocationRequest.zzd || this.zze != currentLocationRequest.zze || this.zzf != currentLocationRequest.zzf || !Objects.equal(this.zzg, currentLocationRequest.zzg) || !Objects.equal(this.zzh, currentLocationRequest.zzh)) {
            return false;
        }
        return true;
    }

    @Pure
    public long getDurationMillis() {
        return this.zzd;
    }

    @Pure
    public int getGranularity() {
        return this.zzb;
    }

    @Pure
    public long getMaxUpdateAgeMillis() {
        return this.zza;
    }

    @Pure
    public int getPriority() {
        return this.zzc;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Long.valueOf(this.zzd));
    }

    public String toString() {
        StringBuilder h2 = a.h("CurrentLocationRequest[");
        h2.append(zzan.zzb(this.zzc));
        if (this.zza != Long.MAX_VALUE) {
            h2.append(", maxAge=");
            zzeo.zzc(this.zza, h2);
        }
        if (this.zzd != Long.MAX_VALUE) {
            h2.append(", duration=");
            h2.append(this.zzd);
            h2.append("ms");
        }
        if (this.zzb != 0) {
            h2.append(", ");
            h2.append(zzq.zzb(this.zzb));
        }
        if (this.zze) {
            h2.append(", bypass");
        }
        if (this.zzf != 0) {
            h2.append(", ");
            h2.append(zzar.zzb(this.zzf));
        }
        if (!WorkSourceUtil.isEmpty(this.zzg)) {
            h2.append(", workSource=");
            h2.append(this.zzg);
        }
        if (this.zzh != null) {
            h2.append(", impersonation=");
            h2.append(this.zzh);
        }
        h2.append(']');
        return h2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getMaxUpdateAgeMillis());
        SafeParcelWriter.writeInt(parcel, 2, getGranularity());
        SafeParcelWriter.writeInt(parcel, 3, getPriority());
        SafeParcelWriter.writeLong(parcel, 4, getDurationMillis());
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzg, i, false);
        SafeParcelWriter.writeInt(parcel, 7, this.zzf);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzh, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Pure
    public final boolean zza() {
        return this.zze;
    }

    @Pure
    public final int zzb() {
        return this.zzf;
    }

    @Pure
    public final WorkSource zzc() {
        return this.zzg;
    }

    @Pure
    public final com.google.android.gms.internal.location.zze zzd() {
        return this.zzh;
    }
}
