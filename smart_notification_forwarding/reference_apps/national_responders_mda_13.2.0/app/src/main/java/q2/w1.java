package q2;

import android.location.Location;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public abstract class w1 extends i implements x1 {
    public w1() {
        super("com.google.android.gms.location.internal.ILocationStatusCallback");
    }

    @Override // q2.i
    protected final boolean i(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 != 1) {
            return false;
        }
        Status status = (Status) v.a(parcel, Status.CREATOR);
        Location location = (Location) v.a(parcel, Location.CREATOR);
        v.b(parcel);
        H(status, location);
        return true;
    }
}
