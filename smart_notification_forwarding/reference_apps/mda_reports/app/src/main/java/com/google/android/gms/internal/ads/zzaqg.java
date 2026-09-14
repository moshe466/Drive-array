package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;

/* loaded from: classes.dex */
public final class zzaqg extends zzgc implements zzaqe {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaqg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzaqe
    public final void zza(zzaxc zzaxcVar) {
        Parcel c = c();
        zzge.zza(c, zzaxcVar);
        b(2, c);
    }

    @Override // com.google.android.gms.internal.ads.zzaqe
    public final void zzb(ParcelFileDescriptor parcelFileDescriptor) {
        Parcel c = c();
        zzge.zza(c, parcelFileDescriptor);
        b(1, c);
    }
}
