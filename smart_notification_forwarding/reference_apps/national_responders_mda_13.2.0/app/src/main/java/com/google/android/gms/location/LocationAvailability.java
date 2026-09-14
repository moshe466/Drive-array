package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import b2.o;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Arrays;
import s2.p;

/* loaded from: classes.dex */
public final class LocationAvailability extends c2.a implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationAvailability> CREATOR;

    /* renamed from: f, reason: collision with root package name */
    private final int f5744f;

    /* renamed from: g, reason: collision with root package name */
    private final int f5745g;

    /* renamed from: h, reason: collision with root package name */
    private final long f5746h;

    /* renamed from: i, reason: collision with root package name */
    int f5747i;

    /* renamed from: j, reason: collision with root package name */
    private final p[] f5748j;

    static {
        new LocationAvailability(0, 1, 1, 0L, null, true);
        new LocationAvailability(1000, 1, 1, 0L, null, false);
        CREATOR = new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationAvailability(int i10, int i11, int i12, long j10, p[] pVarArr, boolean z10) {
        this.f5747i = i10 < 1000 ? 0 : 1000;
        this.f5744f = i11;
        this.f5745g = i12;
        this.f5746h = j10;
        this.f5748j = pVarArr;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocationAvailability) {
            LocationAvailability locationAvailability = (LocationAvailability) obj;
            if (this.f5744f == locationAvailability.f5744f && this.f5745g == locationAvailability.f5745g && this.f5746h == locationAvailability.f5746h && this.f5747i == locationAvailability.f5747i && Arrays.equals(this.f5748j, locationAvailability.f5748j)) {
                return true;
            }
        }
        return false;
    }

    public boolean g() {
        return this.f5747i < 1000;
    }

    public int hashCode() {
        return o.b(Integer.valueOf(this.f5747i));
    }

    public String toString() {
        return "LocationAvailability[" + g() + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.k(parcel, 1, this.f5744f);
        c2.c.k(parcel, 2, this.f5745g);
        c2.c.m(parcel, 3, this.f5746h);
        c2.c.k(parcel, 4, this.f5747i);
        c2.c.s(parcel, 5, this.f5748j, i10, false);
        c2.c.c(parcel, 6, g());
        c2.c.b(parcel, a10);
    }
}
