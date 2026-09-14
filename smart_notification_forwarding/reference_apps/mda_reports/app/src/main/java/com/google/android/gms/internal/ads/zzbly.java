package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class zzbly implements zzbqb, zzps {
    private final zzczl zzfbs;
    private final zzbpd zzffh;
    private final zzbqf zzffi;
    private final AtomicBoolean zzffj = new AtomicBoolean();
    private final AtomicBoolean zzffk = new AtomicBoolean();

    public zzbly(zzczl zzczlVar, zzbpd zzbpdVar, zzbqf zzbqfVar) {
        this.zzfbs = zzczlVar;
        this.zzffh = zzbpdVar;
        this.zzffi = zzbqfVar;
    }

    private final void zzagp() {
        if (this.zzffj.compareAndSet(false, true)) {
            this.zzffh.onAdImpression();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbqb
    public final synchronized void onAdLoaded() {
        if (this.zzfbs.zzglj != 1) {
            zzagp();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzps
    public final void zza(zzpt zzptVar) {
        if (this.zzfbs.zzglj == 1 && zzptVar.zzbnq) {
            zzagp();
        }
        if (zzptVar.zzbnq && this.zzffk.compareAndSet(false, true)) {
            this.zzffi.zzahi();
        }
    }
}
