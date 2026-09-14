package b2;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public interface k extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class a extends o2.b implements k {
        public static k n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICancelToken");
            return queryLocalInterface instanceof k ? (k) queryLocalInterface : new r1(iBinder);
        }
    }

    void cancel();
}
