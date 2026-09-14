package y1;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class f implements Parcelable.Creator<a> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        Intent intent = null;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            if (c2.b.i(p10) != 1) {
                c2.b.w(parcel, p10);
            } else {
                intent = (Intent) c2.b.c(parcel, p10, Intent.CREATOR);
            }
        }
        c2.b.h(parcel, x10);
        return new a(intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a[] newArray(int i10) {
        return new a[i10];
    }
}
