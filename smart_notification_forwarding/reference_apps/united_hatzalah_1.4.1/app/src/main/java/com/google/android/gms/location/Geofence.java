package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.location.zzek;

/* loaded from: classes.dex */
public interface Geofence {
    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1;

    /* loaded from: classes.dex */
    public static final class Builder {
        private double zze;
        private double zzf;
        private float zzg;
        private String zza = null;
        private int zzb = 3;
        private long zzc = -1;
        private short zzd = -1;
        private int zzh = 0;
        private int zzi = -1;

        public Geofence build() {
            if (this.zza != null) {
                int i = this.zzb;
                if (i != 0) {
                    if ((i & 4) != 0 && this.zzi < 0) {
                        throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELL.");
                    }
                    if (this.zzc != Long.MIN_VALUE) {
                        if (this.zzd != -1) {
                            if (this.zzh >= 0) {
                                return new zzek(this.zza, this.zzb, (short) 1, this.zze, this.zzf, this.zzg, this.zzc, this.zzh, this.zzi);
                            }
                            throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
                        }
                        throw new IllegalArgumentException("Geofence region not set.");
                    }
                    throw new IllegalArgumentException("Expiration not set.");
                }
                throw new IllegalArgumentException("Transitions types not set.");
            }
            throw new IllegalArgumentException("Request ID not set.");
        }

        public Builder setCircularRegion(double d2, double d4, float f4) {
            boolean z3;
            boolean z4;
            boolean z5 = false;
            if (d2 >= -90.0d && d2 <= 90.0d) {
                z3 = true;
            } else {
                z3 = false;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(d2).length() + 18);
            sb.append("Invalid latitude: ");
            sb.append(d2);
            Preconditions.checkArgument(z3, sb.toString());
            if (d4 >= -180.0d && d4 <= 180.0d) {
                z4 = true;
            } else {
                z4 = false;
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(d4).length() + 19);
            sb2.append("Invalid longitude: ");
            sb2.append(d4);
            Preconditions.checkArgument(z4, sb2.toString());
            if (f4 > 0.0f) {
                z5 = true;
            }
            StringBuilder sb3 = new StringBuilder(String.valueOf(f4).length() + 16);
            sb3.append("Invalid radius: ");
            sb3.append(f4);
            Preconditions.checkArgument(z5, sb3.toString());
            this.zzd = (short) 1;
            this.zze = d2;
            this.zzf = d4;
            this.zzg = f4;
            return this;
        }

        public Builder setExpirationDuration(long j2) {
            if (j2 < 0) {
                this.zzc = -1L;
                return this;
            }
            this.zzc = DefaultClock.getInstance().elapsedRealtime() + j2;
            return this;
        }

        public Builder setLoiteringDelay(int i) {
            this.zzi = i;
            return this;
        }

        public Builder setNotificationResponsiveness(int i) {
            this.zzh = i;
            return this;
        }

        public Builder setRequestId(String str) {
            this.zza = (String) Preconditions.checkNotNull(str, "Request ID can't be set to null");
            return this;
        }

        public Builder setTransitionTypes(int i) {
            this.zzb = i;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public @interface GeofenceTransition {
    }

    /* loaded from: classes.dex */
    public @interface TransitionTypes {
    }

    long getExpirationTime();

    double getLatitude();

    int getLoiteringDelay();

    double getLongitude();

    int getNotificationResponsiveness();

    float getRadius();

    String getRequestId();

    int getTransitionTypes();
}
