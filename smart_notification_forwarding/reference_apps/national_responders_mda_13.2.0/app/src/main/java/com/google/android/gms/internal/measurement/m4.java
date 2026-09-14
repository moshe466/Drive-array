package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class m4 extends a implements l2 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public m4(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    @Override // com.google.android.gms.internal.measurement.l2
    public final Bundle f(Bundle bundle) {
        Parcel i10 = i();
        v.c(i10, bundle);
        Parcel n10 = n(1, i10);
        Bundle bundle2 = (Bundle) v.a(n10, Bundle.CREATOR);
        n10.recycle();
        return bundle2;
    }
}
