package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzacr extends zzgc implements zzacp {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzacr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
    }

    @Override // com.google.android.gms.internal.ads.zzacp
    public final void unregisterNativeAd() {
        b(2, c());
    }

    @Override // com.google.android.gms.internal.ads.zzacp
    public final void zza(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(1, c);
    }

    @Override // com.google.android.gms.internal.ads.zzacp
    public final void zze(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(3, c);
    }
}
