package b2;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b2.j;
import com.google.android.gms.common.api.Scope;

/* loaded from: classes.dex */
public class g extends c2.a {
    public static final Parcelable.Creator<g> CREATOR = new h1();

    /* renamed from: t, reason: collision with root package name */
    static final Scope[] f3983t = new Scope[0];

    /* renamed from: u, reason: collision with root package name */
    static final z1.c[] f3984u = new z1.c[0];

    /* renamed from: f, reason: collision with root package name */
    final int f3985f;

    /* renamed from: g, reason: collision with root package name */
    final int f3986g;

    /* renamed from: h, reason: collision with root package name */
    int f3987h;

    /* renamed from: i, reason: collision with root package name */
    String f3988i;

    /* renamed from: j, reason: collision with root package name */
    IBinder f3989j;

    /* renamed from: k, reason: collision with root package name */
    Scope[] f3990k;

    /* renamed from: l, reason: collision with root package name */
    Bundle f3991l;

    /* renamed from: m, reason: collision with root package name */
    Account f3992m;

    /* renamed from: n, reason: collision with root package name */
    z1.c[] f3993n;

    /* renamed from: o, reason: collision with root package name */
    z1.c[] f3994o;

    /* renamed from: p, reason: collision with root package name */
    boolean f3995p;

    /* renamed from: q, reason: collision with root package name */
    int f3996q;

    /* renamed from: r, reason: collision with root package name */
    boolean f3997r;

    /* renamed from: s, reason: collision with root package name */
    private String f3998s;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(int i10, int i11, int i12, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, z1.c[] cVarArr, z1.c[] cVarArr2, boolean z10, int i13, boolean z11, String str2) {
        scopeArr = scopeArr == null ? f3983t : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        cVarArr = cVarArr == null ? f3984u : cVarArr;
        cVarArr2 = cVarArr2 == null ? f3984u : cVarArr2;
        this.f3985f = i10;
        this.f3986g = i11;
        this.f3987h = i12;
        if ("com.google.android.gms".equals(str)) {
            this.f3988i = "com.google.android.gms";
        } else {
            this.f3988i = str;
        }
        if (i10 < 2) {
            this.f3992m = iBinder != null ? a.p(j.a.n(iBinder)) : null;
        } else {
            this.f3989j = iBinder;
            this.f3992m = account;
        }
        this.f3990k = scopeArr;
        this.f3991l = bundle;
        this.f3993n = cVarArr;
        this.f3994o = cVarArr2;
        this.f3995p = z10;
        this.f3996q = i13;
        this.f3997r = z11;
        this.f3998s = str2;
    }

    public final String g() {
        return this.f3998s;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        h1.a(this, parcel, i10);
    }
}
