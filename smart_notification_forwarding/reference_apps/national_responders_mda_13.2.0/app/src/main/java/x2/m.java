package x2;

import android.os.Parcel;
import android.os.Parcelable;
import b2.n0;

/* loaded from: classes.dex */
public final class m implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        com.google.android.gms.common.a aVar = null;
        n0 n0Var = null;
        int i10 = 0;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            int i11 = c2.b.i(p10);
            if (i11 == 1) {
                i10 = c2.b.r(parcel, p10);
            } else if (i11 == 2) {
                aVar = (com.google.android.gms.common.a) c2.b.c(parcel, p10, com.google.android.gms.common.a.CREATOR);
            } else if (i11 != 3) {
                c2.b.w(parcel, p10);
            } else {
                n0Var = (n0) c2.b.c(parcel, p10, n0.CREATOR);
            }
        }
        c2.b.h(parcel, x10);
        return new l(i10, aVar, n0Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new l[i10];
    }
}
