package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class v implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        boolean z10 = false;
        String str = null;
        IBinder iBinder = null;
        boolean z11 = false;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            int i10 = c2.b.i(p10);
            if (i10 == 1) {
                str = c2.b.d(parcel, p10);
            } else if (i10 == 2) {
                iBinder = c2.b.q(parcel, p10);
            } else if (i10 == 3) {
                z10 = c2.b.j(parcel, p10);
            } else if (i10 != 4) {
                c2.b.w(parcel, p10);
            } else {
                z11 = c2.b.j(parcel, p10);
            }
        }
        c2.b.h(parcel, x10);
        return new u(str, iBinder, z10, z11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new u[i10];
    }
}
