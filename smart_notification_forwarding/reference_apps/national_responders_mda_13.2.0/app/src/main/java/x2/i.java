package x2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class i implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        ArrayList<String> arrayList = null;
        String str = null;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            int i10 = c2.b.i(p10);
            if (i10 == 1) {
                arrayList = c2.b.e(parcel, p10);
            } else if (i10 != 2) {
                c2.b.w(parcel, p10);
            } else {
                str = c2.b.d(parcel, p10);
            }
        }
        c2.b.h(parcel, x10);
        return new h(arrayList, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new h[i10];
    }
}
