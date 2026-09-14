package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import c2.a;
import c2.c;
import com.google.android.gms.common.internal.ReflectedParcelable;

/* loaded from: classes.dex */
public final class LatLng extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<LatLng> CREATOR = new t2.a();

    /* renamed from: f, reason: collision with root package name */
    public final double f5781f;

    /* renamed from: g, reason: collision with root package name */
    public final double f5782g;

    public LatLng(double d10, double d11) {
        this.f5782g = (d11 < -180.0d || d11 >= 180.0d) ? ((((d11 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d : d11;
        this.f5781f = Math.max(-90.0d, Math.min(90.0d, d10));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLng)) {
            return false;
        }
        LatLng latLng = (LatLng) obj;
        return Double.doubleToLongBits(this.f5781f) == Double.doubleToLongBits(latLng.f5781f) && Double.doubleToLongBits(this.f5782g) == Double.doubleToLongBits(latLng.f5782g);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f5781f);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f5782g);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public String toString() {
        double d10 = this.f5781f;
        double d11 = this.f5782g;
        StringBuilder sb2 = new StringBuilder(60);
        sb2.append("lat/lng: (");
        sb2.append(d10);
        sb2.append(",");
        sb2.append(d11);
        sb2.append(")");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = c.a(parcel);
        c.f(parcel, 2, this.f5781f);
        c.f(parcel, 3, this.f5782g);
        c.b(parcel, a10);
    }
}
