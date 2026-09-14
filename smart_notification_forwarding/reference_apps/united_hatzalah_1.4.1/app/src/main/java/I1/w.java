package I1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public abstract class w extends j implements x {
    @Override // I1.j
    public final boolean a(int i, Parcel parcel, Parcel parcel2, int i3) {
        if (i == 2) {
            Parcelable.Creator creator = Bundle.CREATOR;
            Bundle bundle = (Bundle) k.a(parcel);
            k.b(parcel);
            b(bundle);
            return true;
        }
        return false;
    }
}
