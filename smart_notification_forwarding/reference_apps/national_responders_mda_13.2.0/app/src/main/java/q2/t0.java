package q2;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class t0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int x10 = c2.b.x(parcel);
        q0 q0Var = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        PendingIntent pendingIntent = null;
        IBinder iBinder3 = null;
        String str = null;
        int i10 = 1;
        while (parcel.dataPosition() < x10) {
            int p10 = c2.b.p(parcel);
            switch (c2.b.i(p10)) {
                case 1:
                    i10 = c2.b.r(parcel, p10);
                    break;
                case 2:
                    q0Var = (q0) c2.b.c(parcel, p10, q0.CREATOR);
                    break;
                case 3:
                    iBinder = c2.b.q(parcel, p10);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) c2.b.c(parcel, p10, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinder2 = c2.b.q(parcel, p10);
                    break;
                case 6:
                    iBinder3 = c2.b.q(parcel, p10);
                    break;
                case 7:
                default:
                    c2.b.w(parcel, p10);
                    break;
                case 8:
                    str = c2.b.d(parcel, p10);
                    break;
            }
        }
        c2.b.h(parcel, x10);
        return new s0(i10, q0Var, iBinder, iBinder2, pendingIntent, iBinder3, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new s0[i10];
    }
}
