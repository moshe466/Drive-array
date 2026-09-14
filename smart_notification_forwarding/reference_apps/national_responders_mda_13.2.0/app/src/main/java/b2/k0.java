package b2;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class k0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        String str = null;
        String str2 = null;
        long j10 = 0;
        long j11 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = -1;
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
                    i12 = c2.b.r(parcel, p10);
                    break;
                case 4:
                    j10 = c2.b.s(parcel, p10);
                    break;
                case 5:
                    j11 = c2.b.s(parcel, p10);
                    break;
                case 6:
                    str = c2.b.d(parcel, p10);
                    break;
                case 7:
                    str2 = c2.b.d(parcel, p10);
                    break;
                case 8:
                    i13 = c2.b.r(parcel, p10);
                    break;
                case 9:
                    i14 = c2.b.r(parcel, p10);
                    break;
                default:
                    c2.b.w(parcel, p10);
                    break;
            }
        }
        c2.b.h(parcel, x10);
        return new n(i10, i11, i12, j10, j11, str, str2, i13, i14);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new n[i10];
    }
}
