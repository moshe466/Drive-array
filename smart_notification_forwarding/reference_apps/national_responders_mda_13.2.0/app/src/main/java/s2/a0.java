package s2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import q2.u0;

/* loaded from: classes.dex */
public final class a0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        ArrayList arrayList = null;
        String str = "";
        int i10 = 0;
        String str2 = null;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            int i11 = c2.b.i(p10);
            if (i11 == 1) {
                arrayList = c2.b.g(parcel, p10, u0.CREATOR);
            } else if (i11 == 2) {
                i10 = c2.b.r(parcel, p10);
            } else if (i11 == 3) {
                str = c2.b.d(parcel, p10);
            } else if (i11 != 4) {
                c2.b.w(parcel, p10);
            } else {
                str2 = c2.b.d(parcel, p10);
            }
        }
        c2.b.h(parcel, x10);
        return new m(arrayList, i10, str, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new m[i10];
    }
}
