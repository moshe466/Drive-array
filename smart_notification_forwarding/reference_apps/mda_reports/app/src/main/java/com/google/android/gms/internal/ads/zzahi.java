package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzahi extends zzgc implements zzahg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzahi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzahg
    public final void zzcn(int i) {
        Parcel c = c();
        c.writeInt(i);
        b(2, c);
    }

    @Override // com.google.android.gms.internal.ads.zzahg
    public final void zzrv() {
        b(1, c());
    }
}
