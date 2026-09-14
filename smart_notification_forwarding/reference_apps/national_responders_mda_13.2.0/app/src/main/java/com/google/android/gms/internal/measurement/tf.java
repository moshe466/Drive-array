package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class tf extends a implements rf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public tf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // com.google.android.gms.internal.measurement.rf
    public final void f(Bundle bundle) {
        Parcel i10 = i();
        v.c(i10, bundle);
        p(1, i10);
    }
}
