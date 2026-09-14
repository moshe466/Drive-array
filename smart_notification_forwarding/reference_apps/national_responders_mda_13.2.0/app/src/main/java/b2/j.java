package b2;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public interface j extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class a extends o2.b implements j {
        public static j n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return queryLocalInterface instanceof j ? (j) queryLocalInterface : new q1(iBinder);
        }
    }

    Account a();
}
