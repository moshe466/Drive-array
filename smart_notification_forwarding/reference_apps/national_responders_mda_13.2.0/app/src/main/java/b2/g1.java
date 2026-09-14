package b2;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class g1 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        r rVar = null;
        int[] iArr = null;
        int[] iArr2 = null;
        boolean z10 = false;
        boolean z11 = false;
        int i10 = 0;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            switch (c2.b.i(p10)) {
                case 1:
                    rVar = (r) c2.b.c(parcel, p10, r.CREATOR);
                    break;
                case 2:
                    z10 = c2.b.j(parcel, p10);
                    break;
                case 3:
                    z11 = c2.b.j(parcel, p10);
                    break;
                case 4:
                    iArr = c2.b.b(parcel, p10);
                    break;
                case 5:
                    i10 = c2.b.r(parcel, p10);
                    break;
                case 6:
                    iArr2 = c2.b.b(parcel, p10);
                    break;
                default:
                    c2.b.w(parcel, p10);
                    break;
            }
        }
        c2.b.h(parcel, x10);
        return new f(rVar, z10, z11, iArr, i10, iArr2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new f[i10];
    }
}
