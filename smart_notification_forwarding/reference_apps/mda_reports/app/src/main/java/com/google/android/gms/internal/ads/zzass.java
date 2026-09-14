package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzass extends zzgc implements zzast {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzass(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
    }

    @Override // com.google.android.gms.internal.ads.zzast
    public final void zza(zzasf zzasfVar, String str, String str2) {
        Parcel c = c();
        zzge.zza(c, zzasfVar);
        c.writeString(str);
        c.writeString(str2);
        b(2, c);
    }
}
