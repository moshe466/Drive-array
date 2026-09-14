package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzwe extends zzgc implements zzwc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAppEventListener");
    }

    @Override // com.google.android.gms.internal.ads.zzwc
    public final void onAppEvent(String str, String str2) {
        Parcel c = c();
        c.writeString(str);
        c.writeString(str2);
        b(1, c);
    }
}
