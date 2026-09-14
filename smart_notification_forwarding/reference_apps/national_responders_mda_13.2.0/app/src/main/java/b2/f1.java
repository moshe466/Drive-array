package b2;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class f1 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        Bundle bundle = null;
        z1.c[] cVarArr = null;
        f fVar = null;
        int i10 = 0;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            int i11 = c2.b.i(p10);
            if (i11 == 1) {
                bundle = c2.b.a(parcel, p10);
            } else if (i11 == 2) {
                cVarArr = (z1.c[]) c2.b.f(parcel, p10, z1.c.CREATOR);
            } else if (i11 == 3) {
                i10 = c2.b.r(parcel, p10);
            } else if (i11 != 4) {
                c2.b.w(parcel, p10);
            } else {
                fVar = (f) c2.b.c(parcel, p10, f.CREATOR);
            }
        }
        c2.b.h(parcel, x10);
        return new e1(bundle, cVarArr, i10, fVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new e1[i10];
    }
}
