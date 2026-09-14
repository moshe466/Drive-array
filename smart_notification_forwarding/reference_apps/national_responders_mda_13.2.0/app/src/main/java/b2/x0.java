package b2;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class x0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        int i10 = 0;
        boolean z10 = false;
        boolean z11 = false;
        int i11 = 0;
        int i12 = 0;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            int i13 = c2.b.i(p10);
            if (i13 == 1) {
                i10 = c2.b.r(parcel, p10);
            } else if (i13 == 2) {
                z10 = c2.b.j(parcel, p10);
            } else if (i13 == 3) {
                z11 = c2.b.j(parcel, p10);
            } else if (i13 == 4) {
                i11 = c2.b.r(parcel, p10);
            } else if (i13 != 5) {
                c2.b.w(parcel, p10);
            } else {
                i12 = c2.b.r(parcel, p10);
            }
        }
        c2.b.h(parcel, x10);
        return new r(i10, z10, z11, i11, i12);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new r[i10];
    }
}
