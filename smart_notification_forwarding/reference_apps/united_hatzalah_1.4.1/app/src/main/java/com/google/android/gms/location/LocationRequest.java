package com.google.android.gms.location;

import F0.AbstractC0008a;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.WorkSource;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.internal.location.zzeo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.sessions.settings.RemoteSettings;
import e0.a;
import org.apache.tika.utils.StringUtils;
import org.checkerframework.dataflow.qual.Pure;

/* loaded from: classes.dex */
public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new zzaf();

    @Deprecated
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;

    @Deprecated
    public static final int PRIORITY_HIGH_ACCURACY = 100;

    @Deprecated
    public static final int PRIORITY_LOW_POWER = 104;

    @Deprecated
    public static final int PRIORITY_NO_POWER = 105;
    private int zza;
    private long zzb;
    private long zzc;
    private long zzd;
    private long zze;
    private int zzf;
    private float zzg;
    private boolean zzh;
    private long zzi;
    private final int zzj;
    private final int zzk;
    private final boolean zzl;
    private final WorkSource zzm;
    private final com.google.android.gms.internal.location.zze zzn;

    @Deprecated
    public LocationRequest() {
        this(102, 3600000L, 600000L, 0L, Long.MAX_VALUE, Long.MAX_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER, 0.0f, true, 3600000L, 0, 0, false, new WorkSource(), null);
    }

    @Deprecated
    public static LocationRequest create() {
        return new LocationRequest(102, 3600000L, 600000L, 0L, Long.MAX_VALUE, Long.MAX_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER, 0.0f, true, 3600000L, 0, 0, false, new WorkSource(), null);
    }

    private static String zze(long j2) {
        if (j2 == Long.MAX_VALUE) {
            return "∞";
        }
        return zzeo.zzb(j2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            if (this.zza == locationRequest.zza && ((isPassive() || this.zzb == locationRequest.zzb) && this.zzc == locationRequest.zzc && isBatched() == locationRequest.isBatched() && ((!isBatched() || this.zzd == locationRequest.zzd) && this.zze == locationRequest.zze && this.zzf == locationRequest.zzf && this.zzg == locationRequest.zzg && this.zzh == locationRequest.zzh && this.zzj == locationRequest.zzj && this.zzk == locationRequest.zzk && this.zzl == locationRequest.zzl && this.zzm.equals(locationRequest.zzm) && Objects.equal(this.zzn, locationRequest.zzn)))) {
                return true;
            }
        }
        return false;
    }

    @Pure
    public long getDurationMillis() {
        return this.zze;
    }

    @Deprecated
    @Pure
    public long getExpirationTime() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = this.zze;
        long j3 = elapsedRealtime + j2;
        if (((elapsedRealtime ^ j3) & (j2 ^ j3)) < 0) {
            return Long.MAX_VALUE;
        }
        return j3;
    }

    @Deprecated
    @Pure
    public long getFastestInterval() {
        return getMinUpdateIntervalMillis();
    }

    @Pure
    public int getGranularity() {
        return this.zzj;
    }

    @Deprecated
    @Pure
    public long getInterval() {
        return getIntervalMillis();
    }

    @Pure
    public long getIntervalMillis() {
        return this.zzb;
    }

    @Pure
    public long getMaxUpdateAgeMillis() {
        return this.zzi;
    }

    @Pure
    public long getMaxUpdateDelayMillis() {
        return this.zzd;
    }

    @Pure
    public int getMaxUpdates() {
        return this.zzf;
    }

    @Deprecated
    @Pure
    public long getMaxWaitTime() {
        return Math.max(this.zzd, this.zzb);
    }

    @Pure
    public float getMinUpdateDistanceMeters() {
        return this.zzg;
    }

    @Pure
    public long getMinUpdateIntervalMillis() {
        return this.zzc;
    }

    @Deprecated
    @Pure
    public int getNumUpdates() {
        return getMaxUpdates();
    }

    @Pure
    public int getPriority() {
        return this.zza;
    }

    @Deprecated
    @Pure
    public float getSmallestDisplacement() {
        return getMinUpdateDistanceMeters();
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Long.valueOf(this.zzb), Long.valueOf(this.zzc), this.zzm);
    }

    @Pure
    public boolean isBatched() {
        long j2 = this.zzd;
        return j2 > 0 && (j2 >> 1) >= this.zzb;
    }

    @Deprecated
    @Pure
    public boolean isFastestIntervalExplicitlySet() {
        return true;
    }

    @Pure
    public boolean isPassive() {
        return this.zza == 105;
    }

    public boolean isWaitForAccurateLocation() {
        return this.zzh;
    }

    @Deprecated
    public LocationRequest setExpirationDuration(long j2) {
        boolean z3;
        if (j2 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "durationMillis must be greater than 0");
        this.zze = j2;
        return this;
    }

    @Deprecated
    public LocationRequest setExpirationTime(long j2) {
        this.zze = Math.max(1L, j2 - SystemClock.elapsedRealtime());
        return this;
    }

    @Deprecated
    public LocationRequest setFastestInterval(long j2) {
        boolean z3;
        Object[] objArr = {Long.valueOf(j2)};
        if (j2 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "illegal fastest interval: %d", objArr);
        this.zzc = j2;
        return this;
    }

    @Deprecated
    public LocationRequest setInterval(long j2) {
        boolean z3;
        if (j2 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "intervalMillis must be greater than or equal to 0");
        long j3 = this.zzc;
        long j4 = this.zzb;
        if (j3 == j4 / 6) {
            this.zzc = j2 / 6;
        }
        if (this.zzi == j4) {
            this.zzi = j2;
        }
        this.zzb = j2;
        return this;
    }

    @Deprecated
    public LocationRequest setMaxWaitTime(long j2) {
        boolean z3;
        Object[] objArr = {Long.valueOf(j2)};
        if (j2 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "illegal max wait time: %d", objArr);
        this.zzd = j2;
        return this;
    }

    @Deprecated
    public LocationRequest setNumUpdates(int i) {
        if (i > 0) {
            this.zzf = i;
            return this;
        }
        throw new IllegalArgumentException(AbstractC0008a.t(new StringBuilder(String.valueOf(i).length() + 20), "invalid numUpdates: ", i));
    }

    @Deprecated
    public LocationRequest setPriority(int i) {
        zzan.zza(i);
        this.zza = i;
        return this;
    }

    @Deprecated
    public LocationRequest setSmallestDisplacement(float f4) {
        if (f4 >= 0.0f) {
            this.zzg = f4;
            return this;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(f4).length() + 22);
        sb.append("invalid displacement: ");
        sb.append(f4);
        throw new IllegalArgumentException(sb.toString());
    }

    @Deprecated
    public LocationRequest setWaitForAccurateLocation(boolean z3) {
        this.zzh = z3;
        return this;
    }

    public String toString() {
        StringBuilder h2 = a.h("Request[");
        if (isPassive()) {
            h2.append(zzan.zzb(this.zza));
            if (this.zzd > 0) {
                h2.append(RemoteSettings.FORWARD_SLASH_STRING);
                zzeo.zzc(this.zzd, h2);
            }
        } else {
            h2.append("@");
            if (isBatched()) {
                zzeo.zzc(this.zzb, h2);
                h2.append(RemoteSettings.FORWARD_SLASH_STRING);
                zzeo.zzc(this.zzd, h2);
            } else {
                zzeo.zzc(this.zzb, h2);
            }
            h2.append(StringUtils.SPACE);
            h2.append(zzan.zzb(this.zza));
        }
        if (isPassive() || this.zzc != this.zzb) {
            h2.append(", minUpdateInterval=");
            h2.append(zze(this.zzc));
        }
        if (this.zzg > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            h2.append(", minUpdateDistance=");
            h2.append(this.zzg);
        }
        if (!isPassive() ? this.zzi != this.zzb : this.zzi != Long.MAX_VALUE) {
            h2.append(", maxUpdateAge=");
            h2.append(zze(this.zzi));
        }
        if (this.zze != Long.MAX_VALUE) {
            h2.append(", duration=");
            zzeo.zzc(this.zze, h2);
        }
        if (this.zzf != Integer.MAX_VALUE) {
            h2.append(", maxUpdates=");
            h2.append(this.zzf);
        }
        if (this.zzk != 0) {
            h2.append(", ");
            h2.append(zzar.zzb(this.zzk));
        }
        if (this.zzj != 0) {
            h2.append(", ");
            h2.append(zzq.zzb(this.zzj));
        }
        if (this.zzh) {
            h2.append(", waitForAccurateLocation");
        }
        if (this.zzl) {
            h2.append(", bypass");
        }
        if (!WorkSourceUtil.isEmpty(this.zzm)) {
            h2.append(", ");
            h2.append(this.zzm);
        }
        if (this.zzn != null) {
            h2.append(", impersonation=");
            h2.append(this.zzn);
        }
        h2.append(']');
        return h2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getPriority());
        SafeParcelWriter.writeLong(parcel, 2, getIntervalMillis());
        SafeParcelWriter.writeLong(parcel, 3, getMinUpdateIntervalMillis());
        SafeParcelWriter.writeInt(parcel, 6, getMaxUpdates());
        SafeParcelWriter.writeFloat(parcel, 7, getMinUpdateDistanceMeters());
        SafeParcelWriter.writeLong(parcel, 8, getMaxUpdateDelayMillis());
        SafeParcelWriter.writeBoolean(parcel, 9, isWaitForAccurateLocation());
        SafeParcelWriter.writeLong(parcel, 10, getDurationMillis());
        SafeParcelWriter.writeLong(parcel, 11, getMaxUpdateAgeMillis());
        SafeParcelWriter.writeInt(parcel, 12, getGranularity());
        SafeParcelWriter.writeInt(parcel, 13, this.zzk);
        SafeParcelWriter.writeBoolean(parcel, 15, this.zzl);
        SafeParcelWriter.writeParcelable(parcel, 16, this.zzm, i, false);
        SafeParcelWriter.writeParcelable(parcel, 17, this.zzn, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Pure
    public final int zza() {
        return this.zzk;
    }

    @Pure
    public final boolean zzb() {
        return this.zzl;
    }

    @Pure
    public final WorkSource zzc() {
        return this.zzm;
    }

    @Pure
    public final com.google.android.gms.internal.location.zze zzd() {
        return this.zzn;
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        public static final long IMPLICIT_MAX_UPDATE_AGE = -1;
        public static final long IMPLICIT_MIN_UPDATE_INTERVAL = -1;
        private int zza;
        private long zzb;
        private long zzc;
        private long zzd;
        private long zze;
        private int zzf;
        private float zzg;
        private boolean zzh;
        private long zzi;
        private int zzj;
        private int zzk;
        private boolean zzl;
        private WorkSource zzm;
        private com.google.android.gms.internal.location.zze zzn;

        public Builder(int i, long j2) {
            this(j2);
            setPriority(i);
        }

        public LocationRequest build() {
            int i = this.zza;
            long j2 = this.zzb;
            long j3 = this.zzc;
            if (j3 == -1) {
                j3 = j2;
            } else if (i != 105) {
                j3 = Math.min(j3, j2);
            }
            long max = Math.max(this.zzd, this.zzb);
            long j4 = this.zze;
            int i3 = this.zzf;
            float f4 = this.zzg;
            boolean z3 = this.zzh;
            long j5 = this.zzi;
            if (j5 == -1) {
                j5 = this.zzb;
            }
            return new LocationRequest(i, j2, j3, max, Long.MAX_VALUE, j4, i3, f4, z3, j5, this.zzj, this.zzk, this.zzl, new WorkSource(this.zzm), this.zzn);
        }

        public Builder setDurationMillis(long j2) {
            boolean z3;
            if (j2 > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "durationMillis must be greater than 0");
            this.zze = j2;
            return this;
        }

        public Builder setGranularity(int i) {
            zzq.zza(i);
            this.zzj = i;
            return this;
        }

        public Builder setIntervalMillis(long j2) {
            boolean z3;
            if (j2 >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "intervalMillis must be greater than or equal to 0");
            this.zzb = j2;
            return this;
        }

        public Builder setMaxUpdateAgeMillis(long j2) {
            boolean z3 = true;
            if (j2 != -1 && j2 < 0) {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "maxUpdateAgeMillis must be greater than or equal to 0, or IMPLICIT_MAX_UPDATE_AGE");
            this.zzi = j2;
            return this;
        }

        public Builder setMaxUpdateDelayMillis(long j2) {
            boolean z3;
            if (j2 >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "maxUpdateDelayMillis must be greater than or equal to 0");
            this.zzd = j2;
            return this;
        }

        public Builder setMaxUpdates(int i) {
            boolean z3;
            if (i > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "maxUpdates must be greater than 0");
            this.zzf = i;
            return this;
        }

        public Builder setMinUpdateDistanceMeters(float f4) {
            boolean z3;
            if (f4 >= 0.0f) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "minUpdateDistanceMeters must be greater than or equal to 0");
            this.zzg = f4;
            return this;
        }

        public Builder setMinUpdateIntervalMillis(long j2) {
            boolean z3 = true;
            if (j2 != -1 && j2 < 0) {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "minUpdateIntervalMillis must be greater than or equal to 0, or IMPLICIT_MIN_UPDATE_INTERVAL");
            this.zzc = j2;
            return this;
        }

        public Builder setPriority(int i) {
            zzan.zza(i);
            this.zza = i;
            return this;
        }

        public Builder setWaitForAccurateLocation(boolean z3) {
            this.zzh = z3;
            return this;
        }

        public final Builder zza(int i) {
            zzar.zza(i);
            this.zzk = i;
            return this;
        }

        public final Builder zzb(boolean z3) {
            this.zzl = z3;
            return this;
        }

        public final Builder zzc(WorkSource workSource) {
            this.zzm = workSource;
            return this;
        }

        public Builder(long j2) {
            this.zza = 102;
            this.zzc = -1L;
            this.zzd = 0L;
            this.zze = Long.MAX_VALUE;
            this.zzf = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.zzg = 0.0f;
            this.zzh = true;
            this.zzi = -1L;
            this.zzj = 0;
            this.zzk = 0;
            this.zzl = false;
            this.zzm = null;
            this.zzn = null;
            setIntervalMillis(j2);
        }

        public Builder(LocationRequest locationRequest) {
            this(locationRequest.getPriority(), locationRequest.getIntervalMillis());
            setMinUpdateIntervalMillis(locationRequest.getMinUpdateIntervalMillis());
            setMaxUpdateDelayMillis(locationRequest.getMaxUpdateDelayMillis());
            setDurationMillis(locationRequest.getDurationMillis());
            setMaxUpdates(locationRequest.getMaxUpdates());
            setMinUpdateDistanceMeters(locationRequest.getMinUpdateDistanceMeters());
            setWaitForAccurateLocation(locationRequest.isWaitForAccurateLocation());
            setMaxUpdateAgeMillis(locationRequest.getMaxUpdateAgeMillis());
            setGranularity(locationRequest.getGranularity());
            int zza = locationRequest.zza();
            zzar.zza(zza);
            this.zzk = zza;
            this.zzl = locationRequest.zzb();
            this.zzm = locationRequest.zzc();
            com.google.android.gms.internal.location.zze zzd = locationRequest.zzd();
            boolean z3 = true;
            if (zzd != null && zzd.zza()) {
                z3 = false;
            }
            Preconditions.checkArgument(z3);
            this.zzn = zzd;
        }
    }

    public LocationRequest(int i, long j2, long j3, long j4, long j5, long j6, int i3, float f4, boolean z3, long j7, int i4, int i5, boolean z4, WorkSource workSource, com.google.android.gms.internal.location.zze zzeVar) {
        this.zza = i;
        if (i == 105) {
            this.zzb = Long.MAX_VALUE;
        } else {
            this.zzb = j2;
        }
        this.zzc = j3;
        this.zzd = j4;
        this.zze = j5 == Long.MAX_VALUE ? j6 : Math.min(Math.max(1L, j5 - SystemClock.elapsedRealtime()), j6);
        this.zzf = i3;
        this.zzg = f4;
        this.zzh = z3;
        this.zzi = j7 != -1 ? j7 : j2;
        this.zzj = i4;
        this.zzk = i5;
        this.zzl = z4;
        this.zzm = workSource;
        this.zzn = zzeVar;
    }
}
