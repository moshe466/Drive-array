package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzwt extends zzgc implements zzwr {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMuteThisAdReason");
    }

    @Override // com.google.android.gms.internal.ads.zzwr
    public final String getDescription() {
        Parcel a = a(1, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzwr
    public final String zzph() {
        Parcel a = a(2, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }
}
