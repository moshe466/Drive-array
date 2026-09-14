package b2;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;

/* loaded from: classes.dex */
public final class h1 implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.k(parcel, 1, gVar.f3985f);
        c2.c.k(parcel, 2, gVar.f3986g);
        c2.c.k(parcel, 3, gVar.f3987h);
        c2.c.q(parcel, 4, gVar.f3988i, false);
        c2.c.j(parcel, 5, gVar.f3989j, false);
        c2.c.s(parcel, 6, gVar.f3990k, i10, false);
        c2.c.e(parcel, 7, gVar.f3991l, false);
        c2.c.o(parcel, 8, gVar.f3992m, i10, false);
        c2.c.s(parcel, 10, gVar.f3993n, i10, false);
        c2.c.s(parcel, 11, gVar.f3994o, i10, false);
        c2.c.c(parcel, 12, gVar.f3995p);
        c2.c.k(parcel, 13, gVar.f3996q);
        c2.c.c(parcel, 14, gVar.f3997r);
        c2.c.q(parcel, 15, gVar.g(), false);
        c2.c.b(parcel, a10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        Scope[] scopeArr = g.f3983t;
        Bundle bundle = new Bundle();
        z1.c[] cVarArr = g.f3984u;
        z1.c[] cVarArr2 = cVarArr;
        String str = null;
        IBinder iBinder = null;
        Account account = null;
        String str2 = null;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        boolean z10 = false;
        int i13 = 0;
        boolean z11 = false;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            switch (c2.b.i(p10)) {
                case 1:
                    i10 = c2.b.r(parcel, p10);
                    break;
                case 2:
                    i11 = c2.b.r(parcel, p10);
                    break;
                case 3:
                    i12 = c2.b.r(parcel, p10);
                    break;
                case 4:
                    str = c2.b.d(parcel, p10);
                    break;
                case 5:
                    iBinder = c2.b.q(parcel, p10);
                    break;
                case 6:
                    scopeArr = (Scope[]) c2.b.f(parcel, p10, Scope.CREATOR);
                    break;
                case 7:
                    bundle = c2.b.a(parcel, p10);
                    break;
                case 8:
                    account = (Account) c2.b.c(parcel, p10, Account.CREATOR);
                    break;
                case 9:
                default:
                    c2.b.w(parcel, p10);
                    break;
                case 10:
                    cVarArr = (z1.c[]) c2.b.f(parcel, p10, z1.c.CREATOR);
                    break;
                case 11:
                    cVarArr2 = (z1.c[]) c2.b.f(parcel, p10, z1.c.CREATOR);
                    break;
                case 12:
                    z10 = c2.b.j(parcel, p10);
                    break;
                case 13:
                    i13 = c2.b.r(parcel, p10);
                    break;
                case 14:
                    z11 = c2.b.j(parcel, p10);
                    break;
                case 15:
                    str2 = c2.b.d(parcel, p10);
                    break;
            }
        }
        c2.b.h(parcel, x10);
        return new g(i10, i11, i12, str, iBinder, scopeArr, bundle, account, cVarArr, cVarArr2, z10, i13, z11, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new g[i10];
    }
}
