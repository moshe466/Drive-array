package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzash extends zzgc implements zzasf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzash(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
    }

    @Override // com.google.android.gms.internal.ads.zzasf
    public final int getAmount() {
        Parcel a = a(2, c());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.ads.zzasf
    public final String getType() {
        Parcel a = a(1, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }
}
