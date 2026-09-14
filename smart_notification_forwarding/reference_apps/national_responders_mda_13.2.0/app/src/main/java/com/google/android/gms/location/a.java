package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import s2.p;

/* loaded from: classes.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        long j10 = 0;
        p[] pVarArr = null;
        int i10 = 1000;
        int i11 = 1;
        int i12 = 1;
        boolean z10 = false;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            switch (c2.b.i(p10)) {
                case 1:
                    i11 = c2.b.r(parcel, p10);
                    break;
                case 2:
                    i12 = c2.b.r(parcel, p10);
                    break;
                case 3:
                    j10 = c2.b.s(parcel, p10);
                    break;
                case 4:
                    i10 = c2.b.r(parcel, p10);
                    break;
                case 5:
                    pVarArr = (p[]) c2.b.f(parcel, p10, p.CREATOR);
                    break;
                case 6:
                    z10 = c2.b.j(parcel, p10);
                    break;
                default:
                    c2.b.w(parcel, p10);
                    break;
            }
        }
        c2.b.h(parcel, x10);
        return new LocationAvailability(i10, i11, i12, j10, pVarArr, z10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new LocationAvailability[i10];
    }
}
