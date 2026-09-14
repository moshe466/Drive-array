package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class r implements Parcelable.Creator<p> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ p createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            if (c2.b.i(p10) != 2) {
                c2.b.w(parcel, p10);
            } else {
                bundle = c2.b.a(parcel, p10);
            }
        }
        c2.b.h(parcel, x10);
        return new p(bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ p[] newArray(int i10) {
        return new p[i10];
    }
}
