package q2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public final class o1 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        Status status = null;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            if (c2.b.i(p10) != 1) {
                c2.b.w(parcel, p10);
            } else {
                status = (Status) c2.b.c(parcel, p10, Status.CREATOR);
            }
        }
        c2.b.h(parcel, x10);
        return new n1(status);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new n1[i10];
    }
}
