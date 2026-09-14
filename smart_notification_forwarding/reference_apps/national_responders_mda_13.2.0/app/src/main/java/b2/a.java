package b2;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import b2.j;

/* loaded from: classes.dex */
public class a extends j.a {
    public static Account p(j jVar) {
        Account account = null;
        if (jVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = jVar.a();
            } catch (RemoteException unused) {
            } catch (Throwable th) {
                Binder.restoreCallingIdentity(clearCallingIdentity);
                throw th;
            }
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
        return account;
    }
}
