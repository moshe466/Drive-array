package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzwo extends zzgc implements zzwl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzwl
    public final IBinder zzb(IObjectWrapper iObjectWrapper, int i) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        c.writeInt(i);
        Parcel a = a(1, c);
        IBinder readStrongBinder = a.readStrongBinder();
        a.recycle();
        return readStrongBinder;
    }
}
