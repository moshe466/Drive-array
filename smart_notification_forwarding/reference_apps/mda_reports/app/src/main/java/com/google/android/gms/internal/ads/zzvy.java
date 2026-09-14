package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzvy extends zzgc implements zzvv {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManagerCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzvv
    public final IBinder zza(IObjectWrapper iObjectWrapper, zzuj zzujVar, String str, zzalc zzalcVar, int i, int i2) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, zzujVar);
        c.writeString(str);
        zzge.zza(c, zzalcVar);
        c.writeInt(i);
        c.writeInt(i2);
        Parcel a = a(2, c);
        IBinder readStrongBinder = a.readStrongBinder();
        a.recycle();
        return readStrongBinder;
    }
}
