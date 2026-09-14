package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzvr extends zzgc implements zzvs {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzvs
    public final IBinder zzc(IObjectWrapper iObjectWrapper, String str, zzalc zzalcVar, int i) {
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
