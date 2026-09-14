package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzadk extends zzgc implements zzadi {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzadk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final void zza(zzacw zzacwVar) {
        Parcel c = c();
        zzge.zza(c, zzacwVar);
        b(1, c);
    }
}
