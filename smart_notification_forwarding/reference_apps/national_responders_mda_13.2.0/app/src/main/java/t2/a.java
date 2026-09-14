package t2;

import android.os.Parcel;
import android.os.Parcelable;
import c2.b;
import com.google.android.gms.maps.model.LatLng;

/* loaded from: classes.dex */
public final class a implements Parcelable.Creator<LatLng> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ LatLng createFromParcel(Parcel parcel) {
        int x10 = b.x(parcel);
        double d10 = 0.0d;
        double d11 = 0.0d;
        while (parcel.dataPosition() < x10) {
            int p10 = b.p(parcel);
            int i10 = b.i(p10);
            if (i10 == 2) {
                d10 = b.l(parcel, p10);
            } else if (i10 != 3) {
                b.w(parcel, p10);
            } else {
                d11 = b.l(parcel, p10);
            }
        }
        b.h(parcel, x10);
        return new LatLng(d10, d11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LatLng[] newArray(int i10) {
        return new LatLng[i10];
    }
}
