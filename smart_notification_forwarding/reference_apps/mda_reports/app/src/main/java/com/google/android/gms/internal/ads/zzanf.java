package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzanf extends zzgc implements zzand {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzanf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void zzdl(String str) {
        Parcel c = c();
        c.writeString(str);
        b(3, c);
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void zztb() {
        b(2, c());
    }
}
