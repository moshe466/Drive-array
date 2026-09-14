package q2;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
/* loaded from: classes.dex */
public final class s0 extends c2.a {
    public static final Parcelable.Creator<s0> CREATOR = new t0();

    /* renamed from: f, reason: collision with root package name */
    private final int f13532f;

    /* renamed from: g, reason: collision with root package name */
    private final q0 f13533g;

    /* renamed from: h, reason: collision with root package name */
    private final s2.h0 f13534h;

    /* renamed from: i, reason: collision with root package name */
    private final s2.e0 f13535i;

    /* renamed from: j, reason: collision with root package name */
    private final PendingIntent f13536j;

    /* renamed from: k, reason: collision with root package name */
    private final r1 f13537k;

    /* renamed from: l, reason: collision with root package name */
    private final String f13538l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s0(int i10, q0 q0Var, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, IBinder iBinder3, String str) {
        this.f13532f = i10;
        this.f13533g = q0Var;
        r1 r1Var = null;
        this.f13534h = iBinder != null ? s2.g0.n(iBinder) : null;
        this.f13536j = pendingIntent;
        this.f13535i = iBinder2 != null ? s2.d0.n(iBinder2) : null;
        if (iBinder3 != null) {
            IInterface queryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            r1Var = queryLocalInterface instanceof r1 ? (r1) queryLocalInterface : new p1(iBinder3);
        }
        this.f13537k = r1Var;
        this.f13538l = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.k(parcel, 1, this.f13532f);
        c2.c.o(parcel, 2, this.f13533g, i10, false);
        s2.h0 h0Var = this.f13534h;
        c2.c.j(parcel, 3, h0Var == null ? null : h0Var.asBinder(), false);
        c2.c.o(parcel, 4, this.f13536j, i10, false);
        s2.e0 e0Var = this.f13535i;
        c2.c.j(parcel, 5, e0Var == null ? null : e0Var.asBinder(), false);
        r1 r1Var = this.f13537k;
        c2.c.j(parcel, 6, r1Var != null ? r1Var.asBinder() : null, false);
        c2.c.q(parcel, 8, this.f13538l, false);
        c2.c.b(parcel, a10);
    }
}
