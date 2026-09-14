package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzarp extends zzgc implements zzarm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzarp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzarm
    public final IBinder zzb(IObjectWrapper iObjectWrapper, zzalc zzalcVar, int i) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, zzalcVar);
        c.writeInt(i);
        Parcel a = a(1, c);
        IBinder readStrongBinder = a.readStrongBinder();
        a.recycle();
        return readStrongBinder;
    }
}
