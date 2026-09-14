package b2;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class q1 extends o2.a implements j {
    /* JADX INFO: Access modifiers changed from: package-private */
    public q1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    @Override // b2.j
    public final Account a() {
        Parcel i10 = i(2, p());
        Account account = (Account) o2.c.a(i10, Account.CREATOR);
        i10.recycle();
        return account;
    }
}
