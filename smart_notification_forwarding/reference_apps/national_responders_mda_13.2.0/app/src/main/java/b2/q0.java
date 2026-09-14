package b2;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class q0 extends o2.b implements l {
    public q0() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // o2.b
    protected final boolean i(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 == 1) {
            int readInt = parcel.readInt();
            IBinder readStrongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) o2.c.a(parcel, Bundle.CREATOR);
            o2.c.b(parcel);
            u0(readInt, readStrongBinder, bundle);
        } else if (i10 == 2) {
            int readInt2 = parcel.readInt();
            Bundle bundle2 = (Bundle) o2.c.a(parcel, Bundle.CREATOR);
            o2.c.b(parcel);
            X(readInt2, bundle2);
        } else {
            if (i10 != 3) {
                return false;
            }
            int readInt3 = parcel.readInt();
            IBinder readStrongBinder2 = parcel.readStrongBinder();
            e1 e1Var = (e1) o2.c.a(parcel, e1.CREATOR);
            o2.c.b(parcel);
            P(readInt3, readStrongBinder2, e1Var);
        }
        parcel2.writeNoException();
        return true;
    }
}
