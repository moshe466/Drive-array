package b2;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class t1 extends o2.b implements u1 {
    public t1() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static u1 n(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        return queryLocalInterface instanceof u1 ? (u1) queryLocalInterface : new s1(iBinder);
    }

    @Override // o2.b
    protected final boolean i(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 == 1) {
            j2.a c10 = c();
            parcel2.writeNoException();
            o2.c.e(parcel2, c10);
        } else {
            if (i10 != 2) {
                return false;
            }
            int b10 = b();
            parcel2.writeNoException();
            parcel2.writeInt(b10);
        }
        return true;
    }
}
