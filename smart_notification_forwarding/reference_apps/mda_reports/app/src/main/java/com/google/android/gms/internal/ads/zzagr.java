package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzagr extends zzgc implements zzagp {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzagr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzagp
    public final void onInitializationFailed(String str) {
        Parcel c = c();
        c.writeString(str);
        b(3, c);
    }

    @Override // com.google.android.gms.internal.ads.zzagp
    public final void onInitializationSucceeded() {
        b(2, c());
    }
}
