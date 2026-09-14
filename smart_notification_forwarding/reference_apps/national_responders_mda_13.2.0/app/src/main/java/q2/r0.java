package q2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class r0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        LocationRequest locationRequest = null;
        ArrayList arrayList = null;
        String str = null;
        String str2 = null;
        long j10 = Long.MAX_VALUE;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            int i10 = c2.b.i(p10);
            if (i10 == 1) {
                locationRequest = (LocationRequest) c2.b.c(parcel, p10, LocationRequest.CREATOR);
            } else if (i10 != 5) {
                switch (i10) {
                    case 8:
                        z10 = c2.b.j(parcel, p10);
                        break;
                    case 9:
                        z11 = c2.b.j(parcel, p10);
                        break;
                    case 10:
                        str = c2.b.d(parcel, p10);
                        break;
                    case 11:
                        z12 = c2.b.j(parcel, p10);
                        break;
                    case 12:
                        z13 = c2.b.j(parcel, p10);
                        break;
                    case 13:
                        str2 = c2.b.d(parcel, p10);
                        break;
                    case 14:
                        j10 = c2.b.s(parcel, p10);
                        break;
                    default:
                        c2.b.w(parcel, p10);
                        break;
                }
            } else {
                arrayList = c2.b.g(parcel, p10, b2.d.CREATOR);
            }
        }
        c2.b.h(parcel, x10);
        return new q0(locationRequest, arrayList, z10, z11, str, z12, z13, str2, j10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new q0[i10];
    }
}
