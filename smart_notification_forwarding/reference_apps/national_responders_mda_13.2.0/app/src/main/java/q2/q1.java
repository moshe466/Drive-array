package q2;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class q1 extends i implements r1 {
    public q1() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    @Override // q2.i
    protected final boolean i(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 == 1) {
            n1 n1Var = (n1) v.a(parcel, n1.CREATOR);
            v.b(parcel);
            p0(n1Var);
        } else {
            if (i10 != 2) {
                return false;
            }
            d();
        }
        return true;
    }
}
