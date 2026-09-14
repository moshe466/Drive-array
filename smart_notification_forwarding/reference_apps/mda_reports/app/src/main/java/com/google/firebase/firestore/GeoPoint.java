package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.firestore.util.Util;

/* loaded from: classes2.dex */
public class GeoPoint implements Comparable<GeoPoint> {
    private final double latitude;
    private final double longitude;

    public GeoPoint(double d, double d2) {
        if (Double.isNaN(d) || d < -90.0d || d > 90.0d) {
            throw new IllegalArgumentException("Latitude must be in the range of [-90, 90]");
        }
        if (Double.isNaN(d2) || d2 < -180.0d || d2 > 180.0d) {
            throw new IllegalArgumentException("Longitude must be in the range of [-180, 180]");
        }
        this.latitude = d;
        this.longitude = d2;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull GeoPoint geoPoint) {
        int compareDoubles = Util.compareDoubles(this.latitude, geoPoint.latitude);
        return compareDoubles == 0 ? Util.compareDoubles(this.longitude, geoPoint.longitude) : compareDoubles;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof GeoPoint)) {
            return false;
        }
        GeoPoint geoPoint = (GeoPoint) obj;
        return this.latitude == geoPoint.latitude && this.longitude == geoPoint.longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.latitude);
        int i = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        long doubleToLongBits2 = Double.doubleToLongBits(this.longitude);
        return (i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    @NonNull
    public String toString() {
        return "GeoPoint { latitude=" + this.latitude + ", longitude=" + this.longitude + " }";
    }
}
