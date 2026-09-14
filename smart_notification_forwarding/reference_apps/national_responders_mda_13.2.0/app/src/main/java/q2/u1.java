package q2;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import b2.k;
import com.google.android.gms.location.LocationRequest;

/* loaded from: classes.dex */
public final class u1 extends a implements v1 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public u1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    @Override // q2.v1
    public final b2.k F(s2.g gVar, x1 x1Var) {
        Parcel i10 = i();
        v.c(i10, gVar);
        v.d(i10, x1Var);
        Parcel n10 = n(87, i10);
        b2.k n11 = k.a.n(n10.readStrongBinder());
        n10.recycle();
        return n11;
    }

    @Override // q2.v1
    public final void S(s0 s0Var) {
        Parcel i10 = i();
        v.c(i10, s0Var);
        p(59, i10);
    }

    @Override // q2.v1
    public final void T(s2.e eVar, PendingIntent pendingIntent, com.google.android.gms.common.api.internal.i iVar) {
        Parcel i10 = i();
        v.c(i10, eVar);
        v.c(i10, pendingIntent);
        v.d(i10, iVar);
        p(72, i10);
    }

    @Override // q2.v1
    public final void a0(o0 o0Var, com.google.android.gms.common.api.internal.i iVar) {
        Parcel i10 = i();
        v.c(i10, o0Var);
        v.d(i10, iVar);
        p(89, i10);
    }

    @Override // q2.v1
    public final void b0(PendingIntent pendingIntent, com.google.android.gms.common.api.internal.i iVar) {
        Parcel i10 = i();
        v.c(i10, pendingIntent);
        v.d(i10, iVar);
        p(73, i10);
    }

    @Override // q2.v1
    public final void c0(PendingIntent pendingIntent, t1 t1Var, String str) {
        Parcel i10 = i();
        v.c(i10, pendingIntent);
        v.d(i10, t1Var);
        i10.writeString(str);
        p(2, i10);
    }

    @Override // q2.v1
    public final void d0(o0 o0Var, LocationRequest locationRequest, com.google.android.gms.common.api.internal.i iVar) {
        Parcel i10 = i();
        v.c(i10, o0Var);
        v.c(i10, locationRequest);
        v.d(i10, iVar);
        p(88, i10);
    }

    @Override // q2.v1
    public final void n0(s2.m mVar, PendingIntent pendingIntent, t1 t1Var) {
        Parcel i10 = i();
        v.c(i10, mVar);
        v.c(i10, pendingIntent);
        v.d(i10, t1Var);
        p(57, i10);
    }
}
