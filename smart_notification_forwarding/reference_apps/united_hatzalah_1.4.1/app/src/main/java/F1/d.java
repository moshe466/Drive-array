package F1;

import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public abstract class d extends Binder implements IInterface {
    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i3) {
        if (i > 16777215) {
            if (super.onTransact(i, parcel, parcel2, i3)) {
                return true;
            }
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
        }
        E1.h hVar = (E1.h) this;
        Parcelable parcelable = null;
        if (i != 2) {
            if (i != 3) {
                return false;
            }
            Parcelable.Creator creator = Bundle.CREATOR;
            int i4 = e.f736a;
            if (parcel.readInt() != 0) {
                parcelable = (Parcelable) creator.createFromParcel(parcel);
            }
            Bundle bundle = (Bundle) parcelable;
            int dataAvail = parcel.dataAvail();
            if (dataAvail <= 0) {
                hVar.g(bundle);
                return true;
            }
            throw new BadParcelableException(e0.a.c(dataAvail, "Parcel data not fully consumed, unread size: "));
        }
        Parcelable.Creator creator2 = Bundle.CREATOR;
        int i5 = e.f736a;
        if (parcel.readInt() != 0) {
            parcelable = (Parcelable) creator2.createFromParcel(parcel);
        }
        Bundle bundle2 = (Bundle) parcelable;
        int dataAvail2 = parcel.dataAvail();
        if (dataAvail2 <= 0) {
            hVar.f(bundle2);
            return true;
        }
        throw new BadParcelableException(e0.a.c(dataAvail2, "Parcel data not fully consumed, unread size: "));
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
