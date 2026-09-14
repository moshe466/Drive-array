package s2;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class x implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        ArrayList arrayList = null;
        Bundle bundle = null;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            int i10 = c2.b.i(p10);
            if (i10 == 1) {
                arrayList = c2.b.g(parcel, p10, d.CREATOR);
            } else if (i10 != 2) {
                c2.b.w(parcel, p10);
            } else {
                bundle = c2.b.a(parcel, p10);
            }
        }
        c2.b.h(parcel, x10);
        return new f(arrayList, bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new f[i10];
    }
}
