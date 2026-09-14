package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class x9 implements Parcelable.Creator<v9> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ v9 createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        long j10 = 0;
        long j11 = 0;
        long j12 = 0;
        long j13 = 0;
        long j14 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        Boolean bool = null;
        ArrayList<String> arrayList = null;
        String str8 = null;
        long j15 = -2147483648L;
        String str9 = "";
        boolean z10 = true;
        boolean z11 = false;
        int i10 = 0;
        boolean z12 = true;
        boolean z13 = true;
        boolean z14 = false;
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
                    str3 = c2.b.d(parcel, p10);
                    break;
                case 5:
                    str4 = c2.b.d(parcel, p10);
                    break;
                case 6:
                    j10 = c2.b.s(parcel, p10);
                    break;
                case 7:
                    j11 = c2.b.s(parcel, p10);
                    break;
                case 8:
                    str5 = c2.b.d(parcel, p10);
                    break;
                case 9:
                    z10 = c2.b.j(parcel, p10);
                    break;
                case 10:
                    z11 = c2.b.j(parcel, p10);
                    break;
                case 11:
                    j15 = c2.b.s(parcel, p10);
                    break;
                case 12:
                    str6 = c2.b.d(parcel, p10);
                    break;
                case 13:
                    j12 = c2.b.s(parcel, p10);
                    break;
                case 14:
                    j13 = c2.b.s(parcel, p10);
                    break;
                case 15:
                    i10 = c2.b.r(parcel, p10);
                    break;
                case 16:
                    z12 = c2.b.j(parcel, p10);
                    break;
                case 17:
                    z13 = c2.b.j(parcel, p10);
                    break;
                case 18:
                    z14 = c2.b.j(parcel, p10);
                    break;
                case 19:
                    str7 = c2.b.d(parcel, p10);
                    break;
                case 20:
                default:
                    c2.b.w(parcel, p10);
                    break;
                case 21:
                    bool = c2.b.k(parcel, p10);
                    break;
                case 22:
                    j14 = c2.b.s(parcel, p10);
                    break;
                case 23:
                    arrayList = c2.b.e(parcel, p10);
                    break;
                case 24:
                    str8 = c2.b.d(parcel, p10);
                    break;
                case 25:
                    str9 = c2.b.d(parcel, p10);
                    break;
            }
        }
        c2.b.h(parcel, x10);
        return new v9(str, str2, str3, str4, j10, j11, str5, z10, z11, j15, str6, j12, j13, i10, z12, z13, z14, str7, bool, j14, arrayList, str8, str9);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ v9[] newArray(int i10) {
        return new v9[i10];
    }
}
