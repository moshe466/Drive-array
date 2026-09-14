package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzasp extends zzgc implements zzasm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzasp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzasm
    public final IBinder zzd(IObjectWrapper iObjectWrapper, String str, zzalc zzalcVar, int i) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        c.writeString(str);
        zzge.zza(c, zzalcVar);
        c.writeInt(i);
        Parcel a = a(1, c);
        IBinder readStrongBinder = a.readStrongBinder();
        a.recycle();
        return readStrongBinder;
    }
}
