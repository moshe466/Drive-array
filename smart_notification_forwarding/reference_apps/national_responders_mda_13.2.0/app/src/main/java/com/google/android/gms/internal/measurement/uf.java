package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class uf extends v0 implements rf {
    public uf() {
        super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // com.google.android.gms.internal.measurement.v0
    protected final boolean i(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 != 1) {
            return false;
        }
        f((Bundle) v.a(parcel, Bundle.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
