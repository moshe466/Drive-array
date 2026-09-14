package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes.dex */
public final class zzbtc implements zzbsz {
    private final List<String> zzdkm;
    private final zzdda zzfbm;
    private boolean zzfit;

    public zzbtc(zzczl zzczlVar, zzdda zzddaVar) {
        this.zzdkm = zzczlVar.zzdkm;
        this.zzfbm = zzddaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final void zzaia() {
        if (this.zzfit) {
            return;
        }
        this.zzfbm.zzg(this.zzdkm);
        this.zzfit = true;
    }
}
