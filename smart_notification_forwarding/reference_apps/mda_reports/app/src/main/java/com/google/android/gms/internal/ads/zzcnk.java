package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class zzcnk implements com.google.android.gms.ads.internal.zze {
    private final zzbsy zzfeb;
    private final zzbpd zzfkd;
    private final zzboq zzfke;
    private final zzbjd zzfkf;
    private final zzbst zzfkh;
    private AtomicBoolean zzgbq = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcnk(zzboq zzboqVar, zzbpd zzbpdVar, zzbsy zzbsyVar, zzbst zzbstVar, zzbjd zzbjdVar) {
        this.zzfke = zzboqVar;
        this.zzfkd = zzbpdVar;
        this.zzfeb = zzbsyVar;
        this.zzfkh = zzbstVar;
        this.zzfkf = zzbjdVar;
    }

    @Override // com.google.android.gms.ads.internal.zze
    public final synchronized void zzg(View view) {
        if (this.zzgbq.compareAndSet(false, true)) {
            this.zzfkf.onAdImpression();
            this.zzfkh.zzq(view);
        }
    }

    @Override // com.google.android.gms.ads.internal.zze
    public final void zzjr() {
        if (this.zzgbq.get()) {
            this.zzfke.onAdClicked();
        }
    }

    @Override // com.google.android.gms.ads.internal.zze
    public final void zzjs() {
        if (this.zzgbq.get()) {
            this.zzfkd.onAdImpression();
            this.zzfeb.zzaia();
        }
    }
}
