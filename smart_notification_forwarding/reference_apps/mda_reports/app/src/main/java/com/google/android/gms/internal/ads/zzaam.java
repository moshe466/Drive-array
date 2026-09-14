package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzaam extends zzgc implements zzaak {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaam(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzaak
    public final void zza(zzaaf zzaafVar) {
        Parcel c = c();
        zzge.zza(c, zzaafVar);
        b(1, c);
    }
}
