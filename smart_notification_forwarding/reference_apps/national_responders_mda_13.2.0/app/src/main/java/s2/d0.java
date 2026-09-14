package s2;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;

/* loaded from: classes.dex */
public abstract class d0 extends q2.i implements e0 {
    public d0() {
        super("com.google.android.gms.location.ILocationCallback");
    }

    public static e0 n(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return queryLocalInterface instanceof e0 ? (e0) queryLocalInterface : new c0(iBinder);
    }

    @Override // q2.i
    protected final boolean i(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 == 1) {
            LocationResult locationResult = (LocationResult) q2.v.a(parcel, LocationResult.CREATOR);
            q2.v.b(parcel);
            v0(locationResult);
        } else if (i10 == 2) {
            LocationAvailability locationAvailability = (LocationAvailability) q2.v.a(parcel, LocationAvailability.CREATOR);
            q2.v.b(parcel);
            L(locationAvailability);
        } else {
            if (i10 != 3) {
                return false;
            }
            m();
        }
        return true;
    }
}
