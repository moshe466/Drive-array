package q2;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class v0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        double d10 = 0.0d;
        double d11 = 0.0d;
        String str = null;
        long j10 = 0;
        int i10 = 0;
        short s10 = 0;
        float f10 = 0.0f;
        int i11 = 0;
        int i12 = -1;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            switch (c2.b.i(p10)) {
                case 1:
                    str = c2.b.d(parcel, p10);
                    break;
                case 2:
                    j10 = c2.b.s(parcel, p10);
                    break;
                case 3:
                    s10 = c2.b.u(parcel, p10);
                    break;
                case 4:
                    d10 = c2.b.l(parcel, p10);
                    break;
                case 5:
                    d11 = c2.b.l(parcel, p10);
                    break;
                case 6:
                    f10 = c2.b.n(parcel, p10);
                    break;
                case 7:
                    i10 = c2.b.r(parcel, p10);
                    break;
                case 8:
                    i11 = c2.b.r(parcel, p10);
                    break;
                case 9:
                    i12 = c2.b.r(parcel, p10);
                    break;
                default:
                    c2.b.w(parcel, p10);
                    break;
            }
        }
        c2.b.h(parcel, x10);
        return new u0(str, i10, s10, d10, d11, f10, j10, i11, i12);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new u0[i10];
    }
}
