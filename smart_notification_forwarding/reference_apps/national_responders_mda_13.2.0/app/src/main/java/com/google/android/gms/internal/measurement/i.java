package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class i implements Parcelable.Creator<f> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        long j10 = 0;
        long j11 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        boolean z10 = false;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            switch (c2.b.i(p10)) {
                case 1:
                    j10 = c2.b.s(parcel, p10);
                    break;
                case 2:
                    j11 = c2.b.s(parcel, p10);
                    break;
                case 3:
                    z10 = c2.b.j(parcel, p10);
                    break;
                case 4:
                    str = c2.b.d(parcel, p10);
                    break;
                case 5:
                    str2 = c2.b.d(parcel, p10);
                    break;
                case 6:
                    str3 = c2.b.d(parcel, p10);
                    break;
                case 7:
                    bundle = c2.b.a(parcel, p10);
                    break;
                default:
                    c2.b.w(parcel, p10);
                    break;
            }
        }
        c2.b.h(parcel, x10);
        return new f(j10, j11, z10, str, str2, str3, bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f[] newArray(int i10) {
        return new f[i10];
    }
}
