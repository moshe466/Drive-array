package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* loaded from: classes.dex */
final class zzagj extends zzagg {
    private final /* synthetic */ zzazl zzbrs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzagj(zzagk zzagkVar, zzazl zzazlVar) {
        this.zzbrs = zzazlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzagd
    public final void zza(ParcelFileDescriptor parcelFileDescriptor) {
        this.zzbrs.set(parcelFileDescriptor);
    }
}
