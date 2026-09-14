package b2;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* loaded from: classes.dex */
public final class m0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        Account account = null;
        GoogleSignInAccount googleSignInAccount = null;
        int i10 = 0;
        int i11 = 0;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            int i12 = c2.b.i(p10);
            if (i12 == 1) {
                i10 = c2.b.r(parcel, p10);
            } else if (i12 == 2) {
                account = (Account) c2.b.c(parcel, p10, Account.CREATOR);
            } else if (i12 == 3) {
                i11 = c2.b.r(parcel, p10);
            } else if (i12 != 4) {
                c2.b.w(parcel, p10);
            } else {
                googleSignInAccount = (GoogleSignInAccount) c2.b.c(parcel, p10, GoogleSignInAccount.CREATOR);
            }
        }
        c2.b.h(parcel, x10);
        return new l0(i10, account, i11, googleSignInAccount);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new l0[i10];
    }
}
