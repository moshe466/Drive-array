package I1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public abstract class p extends j implements q {
    @Override // I1.j
    public final boolean a(int i, Parcel parcel, Parcel parcel2, int i3) {
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    if (i != 5) {
                        return false;
                    }
                    Parcelable.Creator creator = Bundle.CREATOR;
                    Bundle bundle = (Bundle) k.a(parcel);
                    k.b(parcel);
                    b(bundle);
                    return true;
                }
                Parcelable.Creator creator2 = Bundle.CREATOR;
                Bundle bundle2 = (Bundle) k.a(parcel);
                k.b(parcel);
                d(bundle2);
                return true;
            }
            Parcelable.Creator creator3 = Bundle.CREATOR;
            Bundle bundle3 = (Bundle) k.a(parcel);
            k.b(parcel);
            c(bundle3);
            return true;
        }
        Parcelable.Creator creator4 = Bundle.CREATOR;
        Bundle bundle4 = (Bundle) k.a(parcel);
        k.b(parcel);
        e(bundle4);
        return true;
    }
}
