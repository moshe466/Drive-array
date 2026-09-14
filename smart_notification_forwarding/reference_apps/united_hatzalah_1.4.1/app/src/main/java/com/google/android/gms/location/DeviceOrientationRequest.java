package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.location.zzer;
import org.checkerframework.dataflow.qual.Pure;

/* loaded from: classes.dex */
public final class DeviceOrientationRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DeviceOrientationRequest> CREATOR = new zzn();
    public static final long OUTPUT_PERIOD_DEFAULT = 20000;
    public static final long OUTPUT_PERIOD_FAST = 5000;
    public static final long OUTPUT_PERIOD_MEDIUM = 10000;
    private final long zza;
    private final boolean zzb;

    /* loaded from: classes.dex */
    public static final class Builder {
        private long zza;
        private final boolean zzb;

        public Builder(long j2) {
            this.zzb = false;
            setSamplingPeriodMicros(j2);
        }

        public DeviceOrientationRequest build() {
            return new DeviceOrientationRequest(this.zza, this.zzb);
        }

        public Builder setSamplingPeriodMicros(long j2) {
            boolean z3 = false;
            if (j2 >= 0 && j2 < Long.MAX_VALUE) {
                z3 = true;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(j2).length() + 102);
            sb.append("Invalid interval: ");
            sb.append(j2);
            sb.append(" should be greater than or equal to 0. Note: Long.MAX_VALUE is not a valid interval.");
            zzer.zzb(z3, sb.toString());
            this.zza = j2;
            return this;
        }

        public Builder(DeviceOrientationRequest deviceOrientationRequest) {
            this.zza = deviceOrientationRequest.zza();
            this.zzb = deviceOrientationRequest.zzb();
        }
    }

    public DeviceOrientationRequest(long j2, boolean z3) {
        this.zza = j2;
        this.zzb = z3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceOrientationRequest)) {
            return false;
        }
        DeviceOrientationRequest deviceOrientationRequest = (DeviceOrientationRequest) obj;
        if (this.zza == deviceOrientationRequest.zza && this.zzb == deviceOrientationRequest.zzb) {
            return true;
        }
        return false;
    }

    @Pure
    public long getSamplingPeriodMicros() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Boolean.valueOf(this.zzb));
    }

    public String toString() {
        String str;
        long j2 = this.zza;
        int length = String.valueOf(j2).length();
        if (true != this.zzb) {
            str = "";
        } else {
            str = ", withVelocity";
        }
        StringBuilder sb = new StringBuilder(str.length() + length + 46 + 1);
        sb.append("DeviceOrientationRequest[samplingPeriodMicros=");
        sb.append(j2);
        sb.append(str);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 2, getSamplingPeriodMicros());
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final /* synthetic */ long zza() {
        return this.zza;
    }

    public final /* synthetic */ boolean zzb() {
        return this.zzb;
    }
}
