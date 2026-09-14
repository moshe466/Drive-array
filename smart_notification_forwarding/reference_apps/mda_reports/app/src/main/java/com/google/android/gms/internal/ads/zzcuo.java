package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* loaded from: classes.dex */
final /* synthetic */ class zzcuo implements zzded {
    static final zzded a = new zzcuo();

    private zzcuo() {
    }

    @Override // com.google.android.gms.internal.ads.zzded
    public final Object apply(Object obj) {
        AdvertisingIdClient.Info info = (AdvertisingIdClient.Info) obj;
        info.getClass();
        return new zzcum(info, null);
    }
}
