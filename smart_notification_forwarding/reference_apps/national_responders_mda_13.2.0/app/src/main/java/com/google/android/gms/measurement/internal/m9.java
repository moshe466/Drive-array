package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class m9 implements Parcelable.Creator<n9> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ n9 createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        String str = null;
        Long l10 = null;
        Float f10 = null;
        String str2 = null;
        String str3 = null;
        Double d10 = null;
        long j10 = 0;
        int i10 = 0;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            switch (c2.b.i(p10)) {
                case 1:
                    i10 = c2.b.r(parcel, p10);
                    break;
                case 2:
                    str = c2.b.d(parcel, p10);
                    break;
                case 3:
                    j10 = c2.b.s(parcel, p10);
                    break;
                case 4:
                    l10 = c2.b.t(parcel, p10);
                    break;
                case 5:
                    f10 = c2.b.o(parcel, p10);
                    break;
                case 6:
                    str2 = c2.b.d(parcel, p10);
                    break;
                case 7:
                    str3 = c2.b.d(parcel, p10);
                    break;
                case 8:
                    d10 = c2.b.m(parcel, p10);
                    break;
                default:
                    c2.b.w(parcel, p10);
                    break;
            }
        }
        c2.b.h(parcel, x10);
        return new n9(i10, str, j10, l10, f10, str2, str3, d10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ n9[] newArray(int i10) {
        return new n9[i10];
    }
}
