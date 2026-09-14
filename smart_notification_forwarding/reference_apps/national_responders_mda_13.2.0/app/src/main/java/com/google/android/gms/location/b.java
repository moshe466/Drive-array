package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import q2.m0;

/* loaded from: classes.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        WorkSource workSource = new WorkSource();
        String str = null;
        m0 m0Var = null;
        long j10 = Long.MAX_VALUE;
        long j11 = Long.MAX_VALUE;
        long j12 = 3600000;
        long j13 = 600000;
        long j14 = 0;
        long j15 = -1;
        int i10 = 102;
        int i11 = Integer.MAX_VALUE;
        float f10 = 0.0f;
        boolean z10 = false;
        int i12 = 0;
        int i13 = 0;
        boolean z11 = false;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            switch (c2.b.i(p10)) {
                case 1:
                    i10 = c2.b.r(parcel, p10);
                    break;
                case 2:
                    j12 = c2.b.s(parcel, p10);
                    break;
                case 3:
                    j13 = c2.b.s(parcel, p10);
                    break;
                case 4:
                default:
                    c2.b.w(parcel, p10);
                    break;
                case 5:
                    j10 = c2.b.s(parcel, p10);
                    break;
                case 6:
                    i11 = c2.b.r(parcel, p10);
                    break;
                case 7:
                    f10 = c2.b.n(parcel, p10);
                    break;
                case 8:
                    j14 = c2.b.s(parcel, p10);
                    break;
                case 9:
                    z10 = c2.b.j(parcel, p10);
                    break;
                case 10:
                    j11 = c2.b.s(parcel, p10);
                    break;
                case 11:
                    j15 = c2.b.s(parcel, p10);
                    break;
                case 12:
                    i12 = c2.b.r(parcel, p10);
                    break;
                case 13:
                    i13 = c2.b.r(parcel, p10);
                    break;
                case 14:
                    str = c2.b.d(parcel, p10);
                    break;
                case 15:
                    z11 = c2.b.j(parcel, p10);
                    break;
                case 16:
                    workSource = (WorkSource) c2.b.c(parcel, p10, WorkSource.CREATOR);
                    break;
                case 17:
                    m0Var = (m0) c2.b.c(parcel, p10, m0.CREATOR);
                    break;
            }
        }
        c2.b.h(parcel, x10);
        return new LocationRequest(i10, j12, j13, j14, j10, j11, i11, f10, z10, j15, i12, i13, str, z11, workSource, m0Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new LocationRequest[i10];
    }
}
