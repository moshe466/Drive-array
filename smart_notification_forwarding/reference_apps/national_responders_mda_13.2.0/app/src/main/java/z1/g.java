package z1;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class g implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        String str = null;
        int i10 = 0;
        long j10 = -1;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            int i11 = c2.b.i(p10);
            if (i11 == 1) {
                str = c2.b.d(parcel, p10);
            } else if (i11 == 2) {
                i10 = c2.b.r(parcel, p10);
            } else if (i11 != 3) {
                c2.b.w(parcel, p10);
            } else {
                j10 = c2.b.s(parcel, p10);
            }
        }
        c2.b.h(parcel, x10);
        return new c(str, i10, j10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new c[i10];
    }
}
