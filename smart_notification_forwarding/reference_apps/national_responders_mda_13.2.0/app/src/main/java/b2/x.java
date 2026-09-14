package b2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class x implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        int i10 = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            int i11 = c2.b.i(p10);
            if (i11 == 1) {
                i10 = c2.b.r(parcel, p10);
            } else if (i11 != 2) {
                c2.b.w(parcel, p10);
            } else {
                arrayList = c2.b.g(parcel, p10, n.CREATOR);
            }
        }
        c2.b.h(parcel, x10);
        return new t(i10, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new t[i10];
    }
}
