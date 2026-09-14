package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* loaded from: classes.dex */
public final class zzcgj extends zzaqh {
    private final /* synthetic */ zzcgk zzfvp;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzcgj(zzcgk zzcgkVar) {
        this.zzfvp = zzcgkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaqe
    public final void zza(zzaxc zzaxcVar) {
        this.zzfvp.a.setException(new zzaxf(zzaxcVar.zzdtr, zzaxcVar.errorCode));
    }

    @Override // com.google.android.gms.internal.ads.zzaqe
    public final void zzb(ParcelFileDescriptor parcelFileDescriptor) {
        this.zzfvp.a.set(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
    }
}
