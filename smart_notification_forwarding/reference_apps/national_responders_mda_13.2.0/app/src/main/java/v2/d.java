package v2;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.v;
import com.google.android.gms.internal.measurement.v0;
import com.google.android.gms.measurement.internal.ha;
import com.google.android.gms.measurement.internal.n9;
import com.google.android.gms.measurement.internal.q;
import com.google.android.gms.measurement.internal.v9;
import java.util.Collection;

/* loaded from: classes.dex */
public abstract class d extends v0 implements c {
    public d() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:1:0x0000. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.v0
    protected final boolean i(int i10, Parcel parcel, Parcel parcel2, int i11) {
        Collection s10;
        switch (i10) {
            case 1:
                V((q) v.a(parcel, q.CREATOR), (v9) v.a(parcel, v9.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                g0((n9) v.a(parcel, n9.CREATOR), (v9) v.a(parcel, v9.CREATOR));
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            default:
                return false;
            case 4:
                t((v9) v.a(parcel, v9.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                J((q) v.a(parcel, q.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                I((v9) v.a(parcel, v9.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                s10 = s((v9) v.a(parcel, v9.CREATOR), v.e(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(s10);
                return true;
            case 9:
                byte[] v10 = v((q) v.a(parcel, q.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(v10);
                return true;
            case 10:
                e0(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                String W = W((v9) v.a(parcel, v9.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(W);
                return true;
            case 12:
                l0((ha) v.a(parcel, ha.CREATOR), (v9) v.a(parcel, v9.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                r0((ha) v.a(parcel, ha.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                s10 = r(parcel.readString(), parcel.readString(), v.e(parcel), (v9) v.a(parcel, v9.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(s10);
                return true;
            case 15:
                s10 = K(parcel.readString(), parcel.readString(), parcel.readString(), v.e(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(s10);
                return true;
            case 16:
                s10 = m0(parcel.readString(), parcel.readString(), (v9) v.a(parcel, v9.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(s10);
                return true;
            case 17:
                s10 = j0(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(s10);
                return true;
            case 18:
                i0((v9) v.a(parcel, v9.CREATOR));
                parcel2.writeNoException();
                return true;
            case 19:
                Y((Bundle) v.a(parcel, Bundle.CREATOR), (v9) v.a(parcel, v9.CREATOR));
                parcel2.writeNoException();
                return true;
            case 20:
                x((v9) v.a(parcel, v9.CREATOR));
                parcel2.writeNoException();
                return true;
        }
    }
}
