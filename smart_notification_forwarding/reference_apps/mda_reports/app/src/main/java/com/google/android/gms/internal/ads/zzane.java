package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzane extends zzgc implements zzanc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzane(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzanc
    public final void zza(zzalr zzalrVar) {
        Parcel c = c();
        zzge.zza(c, zzalrVar);
        b(1, c);
    }

    @Override // com.google.android.gms.internal.ads.zzanc
    public final void zzdl(String str) {
        Parcel c = c();
        c.writeString(str);
        b(2, c);
    }
}
