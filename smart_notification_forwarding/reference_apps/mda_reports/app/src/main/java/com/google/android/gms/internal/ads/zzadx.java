package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzadx extends zzgc implements zzadv {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzadx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zza(zzaeg zzaegVar) {
        Parcel c = c();
        zzge.zza(c, zzaegVar);
        b(1, c);
    }
}
