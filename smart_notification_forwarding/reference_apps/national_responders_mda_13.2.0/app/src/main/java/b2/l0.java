package b2;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* loaded from: classes.dex */
public final class l0 extends c2.a {
    public static final Parcelable.Creator<l0> CREATOR = new m0();

    /* renamed from: f, reason: collision with root package name */
    final int f4029f;

    /* renamed from: g, reason: collision with root package name */
    private final Account f4030g;

    /* renamed from: h, reason: collision with root package name */
    private final int f4031h;

    /* renamed from: i, reason: collision with root package name */
    private final GoogleSignInAccount f4032i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l0(int i10, Account account, int i11, GoogleSignInAccount googleSignInAccount) {
        this.f4029f = i10;
        this.f4030g = account;
        this.f4031h = i11;
        this.f4032i = googleSignInAccount;
    }

    public l0(Account account, int i10, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i10, googleSignInAccount);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.k(parcel, 1, this.f4029f);
        c2.c.o(parcel, 2, this.f4030g, i10, false);
        c2.c.k(parcel, 3, this.f4031h);
        c2.c.o(parcel, 4, this.f4032i, i10, false);
        c2.c.b(parcel, a10);
    }
}
