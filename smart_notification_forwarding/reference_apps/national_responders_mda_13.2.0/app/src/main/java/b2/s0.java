package b2;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class s0 extends o2.a implements u0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public s0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // b2.u0
    public final boolean B(com.google.android.gms.common.u uVar, j2.a aVar) {
        Parcel p10 = p();
        o2.c.d(p10, uVar);
        o2.c.e(p10, aVar);
        Parcel i10 = i(5, p10);
        boolean f10 = o2.c.f(i10);
        i10.recycle();
        return f10;
    }

    @Override // b2.u0
    public final z1.i h0(com.google.android.gms.common.s sVar) {
        Parcel p10 = p();
        o2.c.d(p10, sVar);
        Parcel i10 = i(6, p10);
        z1.i iVar = (z1.i) o2.c.a(i10, z1.i.CREATOR);
        i10.recycle();
        return iVar;
    }

    @Override // b2.u0
    public final boolean k() {
        Parcel i10 = i(7, p());
        boolean f10 = o2.c.f(i10);
        i10.recycle();
        return f10;
    }

    @Override // b2.u0
    public final z1.i u(com.google.android.gms.common.s sVar) {
        Parcel p10 = p();
        o2.c.d(p10, sVar);
        Parcel i10 = i(8, p10);
        z1.i iVar = (z1.i) o2.c.a(i10, z1.i.CREATOR);
        i10.recycle();
        return iVar;
    }
}
