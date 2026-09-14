package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes.dex */
public final class c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        List list = LocationResult.f5779g;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            if (c2.b.i(p10) != 1) {
                c2.b.w(parcel, p10);
            } else {
                list = c2.b.g(parcel, p10, Location.CREATOR);
            }
        }
        c2.b.h(parcel, x10);
        return new LocationResult(list);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new LocationResult[i10];
    }
}
