package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class x implements Parcelable.Creator<w> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(w wVar, Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.e(parcel, 2, wVar.f7477f, false);
        c2.c.b(parcel, a10);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public w createFromParcel(Parcel parcel) {
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
        return new w(bundle);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public w[] newArray(int i10) {
        return new w[i10];
    }
}
