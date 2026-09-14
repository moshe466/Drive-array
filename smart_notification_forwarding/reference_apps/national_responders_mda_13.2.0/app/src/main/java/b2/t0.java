package b2;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public abstract class t0 extends o2.b implements u0 {
    public static u0 n(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        return queryLocalInterface instanceof u0 ? (u0) queryLocalInterface : new s0(iBinder);
    }
}
