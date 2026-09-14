package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class ga implements Parcelable.Creator<ha> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ha createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        long j10 = 0;
        long j11 = 0;
        long j12 = 0;
        String str = null;
        String str2 = null;
        n9 n9Var = null;
        String str3 = null;
        q qVar = null;
        q qVar2 = null;
        q qVar3 = null;
        boolean z10 = false;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            switch (c2.b.i(p10)) {
                case 2:
                    str = c2.b.d(parcel, p10);
                    break;
                case 3:
                    str2 = c2.b.d(parcel, p10);
                    break;
                case 4:
                    n9Var = (n9) c2.b.c(parcel, p10, n9.CREATOR);
                    break;
                case 5:
                    j10 = c2.b.s(parcel, p10);
                    break;
                case 6:
                    z10 = c2.b.j(parcel, p10);
                    break;
                case 7:
                    str3 = c2.b.d(parcel, p10);
                    break;
                case 8:
                    qVar = (q) c2.b.c(parcel, p10, q.CREATOR);
                    break;
                case 9:
                    j11 = c2.b.s(parcel, p10);
                    break;
                case 10:
                    qVar2 = (q) c2.b.c(parcel, p10, q.CREATOR);
                    break;
                case 11:
                    j12 = c2.b.s(parcel, p10);
                    break;
                case 12:
                    qVar3 = (q) c2.b.c(parcel, p10, q.CREATOR);
                    break;
                default:
                    c2.b.w(parcel, p10);
                    break;
            }
        }
        c2.b.h(parcel, x10);
        return new ha(str, str2, n9Var, j10, z10, str3, qVar, j11, qVar2, j12, qVar3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ha[] newArray(int i10) {
        return new ha[i10];
    }
}
