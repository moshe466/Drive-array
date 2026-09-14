package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzxc extends zzgc implements zzxa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IResponseInfo");
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final String getMediationAdapterClassName() {
        Parcel a = a(1, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final String zzpj() {
        Parcel a = a(2, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }
}
