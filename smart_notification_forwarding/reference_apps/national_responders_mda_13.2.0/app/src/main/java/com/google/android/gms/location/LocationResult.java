package com.google.android.gms.location;

import android.location.Location;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import b2.o;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class LocationResult extends c2.a implements ReflectedParcelable {

    /* renamed from: f, reason: collision with root package name */
    private final List f5780f;

    /* renamed from: g, reason: collision with root package name */
    static final List f5779g = Collections.emptyList();
    public static final Parcelable.Creator<LocationResult> CREATOR = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationResult(List list) {
        this.f5780f = list;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        if (Build.VERSION.SDK_INT >= 31) {
            return this.f5780f.equals(locationResult.f5780f);
        }
        if (this.f5780f.size() != locationResult.f5780f.size()) {
            return false;
        }
        Iterator it = locationResult.f5780f.iterator();
        for (Location location : this.f5780f) {
            Location location2 = (Location) it.next();
            if (Double.compare(location.getLatitude(), location2.getLatitude()) != 0 || Double.compare(location.getLongitude(), location2.getLongitude()) != 0 || location.getTime() != location2.getTime() || location.getElapsedRealtimeNanos() != location2.getElapsedRealtimeNanos() || !o.a(location.getProvider(), location2.getProvider())) {
                return false;
            }
        }
        return true;
    }

    public Location g() {
        int size = this.f5780f.size();
        if (size == 0) {
            return null;
        }
        return (Location) this.f5780f.get(size - 1);
    }

    public int hashCode() {
        return o.b(this.f5780f);
    }

    public List<Location> j() {
        return this.f5780f;
    }

    public String toString() {
        return "LocationResult".concat(String.valueOf(this.f5780f));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.t(parcel, 1, j(), false);
        c2.c.b(parcel, a10);
    }
}
