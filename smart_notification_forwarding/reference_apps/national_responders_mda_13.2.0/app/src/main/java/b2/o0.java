package b2;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class o0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        IBinder iBinder = null;
        com.google.android.gms.common.a aVar = null;
        int i10 = 0;
        boolean z10 = false;
        boolean z11 = false;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            int i11 = c2.b.i(p10);
            if (i11 == 1) {
                i10 = c2.b.r(parcel, p10);
            } else if (i11 == 2) {
                iBinder = c2.b.q(parcel, p10);
            } else if (i11 == 3) {
                aVar = (com.google.android.gms.common.a) c2.b.c(parcel, p10, com.google.android.gms.common.a.CREATOR);
            } else if (i11 == 4) {
                z10 = c2.b.j(parcel, p10);
            } else if (i11 != 5) {
                c2.b.w(parcel, p10);
            } else {
                z11 = c2.b.j(parcel, p10);
            }
        }
        c2.b.h(parcel, x10);
        return new n0(i10, iBinder, aVar, z10, z11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new n0[i10];
    }
}
