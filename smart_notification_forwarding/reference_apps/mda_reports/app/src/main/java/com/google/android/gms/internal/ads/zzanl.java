package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzanl extends zzgc implements zzanj {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzanl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void onFailure(String str) {
        Parcel c = c();
        c.writeString(str);
        b(2, c);
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zzdn(String str) {
        Parcel c = c();
        c.writeString(str);
        b(1, c);
    }
}
