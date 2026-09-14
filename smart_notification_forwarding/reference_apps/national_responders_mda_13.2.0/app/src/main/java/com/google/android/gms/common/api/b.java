package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        String str = null;
        PendingIntent pendingIntent = null;
        com.google.android.gms.common.a aVar = null;
        int i10 = 0;
        int i11 = 0;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            int i12 = c2.b.i(p10);
            if (i12 == 1) {
                i11 = c2.b.r(parcel, p10);
            } else if (i12 == 2) {
                str = c2.b.d(parcel, p10);
            } else if (i12 == 3) {
                pendingIntent = (PendingIntent) c2.b.c(parcel, p10, PendingIntent.CREATOR);
            } else if (i12 == 4) {
                aVar = (com.google.android.gms.common.a) c2.b.c(parcel, p10, com.google.android.gms.common.a.CREATOR);
            } else if (i12 != 1000) {
                c2.b.w(parcel, p10);
            } else {
                i10 = c2.b.r(parcel, p10);
            }
        }
        c2.b.h(parcel, x10);
        return new Status(i10, i11, str, pendingIntent, aVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new Status[i10];
    }
}
