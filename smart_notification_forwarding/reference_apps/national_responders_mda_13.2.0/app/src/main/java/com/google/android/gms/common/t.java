package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class t implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        String str = null;
        IBinder iBinder = null;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            int i10 = c2.b.i(p10);
            if (i10 == 1) {
                str = c2.b.d(parcel, p10);
            } else if (i10 == 2) {
                z10 = c2.b.j(parcel, p10);
            } else if (i10 == 3) {
                z11 = c2.b.j(parcel, p10);
            } else if (i10 == 4) {
                iBinder = c2.b.q(parcel, p10);
            } else if (i10 != 5) {
                c2.b.w(parcel, p10);
            } else {
                z12 = c2.b.j(parcel, p10);
            }
        }
        c2.b.h(parcel, x10);
        return new s(str, z10, z11, iBinder, z12);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new s[i10];
    }
}
