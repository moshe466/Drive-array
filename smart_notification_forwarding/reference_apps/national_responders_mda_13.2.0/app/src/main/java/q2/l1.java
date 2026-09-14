package q2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes.dex */
public final class l1 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        List x11 = f1.x();
        String str = null;
        String str2 = null;
        String str3 = null;
        m0 m0Var = null;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            switch (c2.b.i(p10)) {
                case 1:
                    i10 = c2.b.r(parcel, p10);
                    break;
                case 2:
                    i11 = c2.b.r(parcel, p10);
                    break;
                case 3:
                    str = c2.b.d(parcel, p10);
                    break;
                case 4:
                    str2 = c2.b.d(parcel, p10);
                    break;
                case 5:
                    i12 = c2.b.r(parcel, p10);
                    break;
                case 6:
                    str3 = c2.b.d(parcel, p10);
                    break;
                case 7:
                    m0Var = (m0) c2.b.c(parcel, p10, m0.CREATOR);
                    break;
                case 8:
                    x11 = c2.b.g(parcel, p10, z1.c.CREATOR);
                    break;
                default:
                    c2.b.w(parcel, p10);
                    break;
            }
        }
        c2.b.h(parcel, x10);
        return new m0(i10, i11, str, str2, str3, i12, x11, m0Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new m0[i10];
    }
}
