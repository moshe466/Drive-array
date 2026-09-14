package v2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.internal.p;
import com.google.android.gms.measurement.internal.q;

/* loaded from: classes.dex */
public final class b implements Parcelable.Creator<q> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ q createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        String str = null;
        p pVar = null;
        String str2 = null;
        long j10 = 0;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            int i10 = c2.b.i(p10);
            if (i10 == 2) {
                str = c2.b.d(parcel, p10);
            } else if (i10 == 3) {
                pVar = (p) c2.b.c(parcel, p10, p.CREATOR);
            } else if (i10 == 4) {
                str2 = c2.b.d(parcel, p10);
            } else if (i10 != 5) {
                c2.b.w(parcel, p10);
            } else {
                j10 = c2.b.s(parcel, p10);
            }
        }
        c2.b.h(parcel, x10);
        return new q(str, pVar, str2, j10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ q[] newArray(int i10) {
        return new q[i10];
    }
}
