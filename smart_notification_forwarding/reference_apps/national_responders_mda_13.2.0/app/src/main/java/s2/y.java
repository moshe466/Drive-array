package s2;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import q2.m0;

/* loaded from: classes.dex */
public final class y implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        WorkSource workSource = new WorkSource();
        String str = null;
        m0 m0Var = null;
        long j10 = Long.MAX_VALUE;
        long j11 = Long.MAX_VALUE;
        int i10 = 0;
        int i11 = 102;
        boolean z10 = false;
        int i12 = 0;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            switch (c2.b.i(p10)) {
                case 1:
                    j10 = c2.b.s(parcel, p10);
                    break;
                case 2:
                    i10 = c2.b.r(parcel, p10);
                    break;
                case 3:
                    i11 = c2.b.r(parcel, p10);
                    break;
                case 4:
                    j11 = c2.b.s(parcel, p10);
                    break;
                case 5:
                    z10 = c2.b.j(parcel, p10);
                    break;
                case 6:
                    workSource = (WorkSource) c2.b.c(parcel, p10, WorkSource.CREATOR);
                    break;
                case 7:
                    i12 = c2.b.r(parcel, p10);
                    break;
                case 8:
                    str = c2.b.d(parcel, p10);
                    break;
                case 9:
                    m0Var = (m0) c2.b.c(parcel, p10, m0.CREATOR);
                    break;
                default:
                    c2.b.w(parcel, p10);
                    break;
            }
        }
        c2.b.h(parcel, x10);
        return new g(j10, i10, i11, j11, z10, i12, str, workSource, m0Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new g[i10];
    }
}
