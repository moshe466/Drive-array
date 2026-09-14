package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzale extends zzgc implements zzalc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzale(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzalc
    public final zzald zzde(String str) {
        zzald zzalfVar;
        Parcel c = c();
        c.writeString(str);
        Parcel a = a(1, c);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzalfVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            zzalfVar = queryLocalInterface instanceof zzald ? (zzald) queryLocalInterface : new zzalf(readStrongBinder);
        }
        a.recycle();
        return zzalfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzalc
    public final boolean zzdf(String str) {
        Parcel c = c();
        c.writeString(str);
        Parcel a = a(2, c);
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzalc
    public final zzani zzdi(String str) {
        Parcel c = c();
        c.writeString(str);
        Parcel a = a(3, c);
        zzani zzad = zzanh.zzad(a.readStrongBinder());
        a.recycle();
        return zzad;
    }
}
