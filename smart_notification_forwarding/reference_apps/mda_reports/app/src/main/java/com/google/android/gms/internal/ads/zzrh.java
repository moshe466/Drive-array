package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzrh extends zzgc implements zzrf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    @Override // com.google.android.gms.internal.ads.zzrf
    public final void zza(zzrl zzrlVar) {
        Parcel c = c();
        zzge.zza(c, zzrlVar);
        b(3, c);
    }

    @Override // com.google.android.gms.internal.ads.zzrf
    public final zzvu zzdm() {
        Parcel a = a(2, c());
        zzvu zzc = zzvt.zzc(a.readStrongBinder());
        a.recycle();
        return zzc;
    }
}
