package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzagi extends zzgc implements zzagf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzagi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    @Override // com.google.android.gms.internal.ads.zzagf
    public final void zza(zzafz zzafzVar, zzagd zzagdVar) {
        Parcel c = c();
        zzge.zza(c, zzafzVar);
        zzge.zza(c, zzagdVar);
        c(2, c);
    }
}
