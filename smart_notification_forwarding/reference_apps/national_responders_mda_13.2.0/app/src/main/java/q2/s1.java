package q2;

import android.app.PendingIntent;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class s1 extends i implements t1 {
    public s1() {
        super("com.google.android.gms.location.internal.IGeofencerCallbacks");
    }

    @Override // q2.i
    protected final boolean i(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 == 1) {
            int readInt = parcel.readInt();
            String[] createStringArray = parcel.createStringArray();
            v.b(parcel);
            t0(readInt, createStringArray);
        } else if (i10 == 2) {
            int readInt2 = parcel.readInt();
            String[] createStringArray2 = parcel.createStringArray();
            v.b(parcel);
            Q(readInt2, createStringArray2);
        } else {
            if (i10 != 3) {
                return false;
            }
            int readInt3 = parcel.readInt();
            PendingIntent pendingIntent = (PendingIntent) v.a(parcel, PendingIntent.CREATOR);
            v.b(parcel);
            M(readInt3, pendingIntent);
        }
        return true;
    }
}
