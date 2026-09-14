package s2;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class t implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        int i10 = 0;
        int i11 = 0;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            int i12 = c2.b.i(p10);
            if (i12 == 1) {
                i10 = c2.b.r(parcel, p10);
            } else if (i12 != 2) {
                c2.b.w(parcel, p10);
            } else {
                i11 = c2.b.r(parcel, p10);
            }
        }
        c2.b.h(parcel, x10);
        return new c(i10, i11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new c[i10];
    }
}
