package x2;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class g extends m2.a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void x0(b2.j jVar, int i10, boolean z10) {
        Parcel i11 = i();
        m2.c.e(i11, jVar);
        i11.writeInt(i10);
        m2.c.c(i11, z10);
        n(9, i11);
    }

    public final void y0(j jVar, f fVar) {
        Parcel i10 = i();
        m2.c.d(i10, jVar);
        m2.c.e(i10, fVar);
        n(12, i10);
    }

    public final void z(int i10) {
        Parcel i11 = i();
        i11.writeInt(i10);
        n(7, i11);
    }
}
