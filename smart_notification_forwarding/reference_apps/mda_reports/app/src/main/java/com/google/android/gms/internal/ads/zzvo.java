package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzvo extends zzgc implements zzvm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoader");
    }

    @Override // com.google.android.gms.internal.ads.zzvm
    public final String getMediationAdapterClassName() {
        Parcel a = a(2, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzvm
    public final boolean isLoading() {
        Parcel a = a(3, c());
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzvm
    public final void zza(zzug zzugVar, int i) {
        Parcel c = c();
        zzge.zza(c, zzugVar);
        c.writeInt(i);
        b(5, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvm
    public final void zzb(zzug zzugVar) {
        Parcel c = c();
        zzge.zza(c, zzugVar);
        b(1, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvm
    public final String zzka() {
        Parcel a = a(4, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }
}
