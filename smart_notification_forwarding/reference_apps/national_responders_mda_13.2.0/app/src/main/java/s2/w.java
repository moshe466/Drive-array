package s2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class w implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        ArrayList arrayList = null;
        String str = null;
        ArrayList arrayList2 = null;
        String str2 = null;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            int i10 = c2.b.i(p10);
            if (i10 == 1) {
                arrayList = c2.b.g(parcel, p10, c.CREATOR);
            } else if (i10 == 2) {
                str = c2.b.d(parcel, p10);
            } else if (i10 == 3) {
                arrayList2 = c2.b.g(parcel, p10, b2.d.CREATOR);
            } else if (i10 != 4) {
                c2.b.w(parcel, p10);
            } else {
                str2 = c2.b.d(parcel, p10);
            }
        }
        c2.b.h(parcel, x10);
        return new e(arrayList, str, arrayList2, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new e[i10];
    }
}
