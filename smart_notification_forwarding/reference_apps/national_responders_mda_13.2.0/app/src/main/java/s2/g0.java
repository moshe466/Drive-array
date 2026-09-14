package s2;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public abstract class g0 extends q2.i implements h0 {
    public static h0 n(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
        return queryLocalInterface instanceof h0 ? (h0) queryLocalInterface : new f0(iBinder);
    }
}
