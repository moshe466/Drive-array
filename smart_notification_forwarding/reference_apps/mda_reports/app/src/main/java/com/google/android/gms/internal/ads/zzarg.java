package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzarg extends zzgc implements zzare {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzarg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardItem");
    }

    @Override // com.google.android.gms.internal.ads.zzare
    public final int getAmount() {
        Parcel a = a(2, c());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.ads.zzare
    public final String getType() {
        Parcel a = a(1, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }
}
