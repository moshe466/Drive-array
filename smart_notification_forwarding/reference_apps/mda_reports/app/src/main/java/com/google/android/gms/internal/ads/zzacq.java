package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzacq extends zzgc implements zzacn {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzacq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzacn
    public final IBinder zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, int i) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, iObjectWrapper2);
        zzge.zza(c, iObjectWrapper3);
        c.writeInt(i);
        Parcel a = a(1, c);
        IBinder readStrongBinder = a.readStrongBinder();
        a.recycle();
        return readStrongBinder;
    }
}
