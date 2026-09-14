package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzahj extends zzgc implements zzahh {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzahj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzahh
    public final void onInstreamAdFailedToLoad(int i) {
        Parcel c = c();
        c.writeInt(i);
        b(2, c);
    }

    @Override // com.google.android.gms.internal.ads.zzahh
    public final void zza(zzahb zzahbVar) {
        Parcel c = c();
        zzge.zza(c, zzahbVar);
        b(1, c);
    }
}
