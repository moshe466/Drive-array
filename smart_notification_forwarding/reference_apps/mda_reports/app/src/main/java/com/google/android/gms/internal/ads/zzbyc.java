package com.google.android.gms.internal.ads;

import androidx.collection.ArrayMap;

/* loaded from: classes.dex */
public final class zzbyc implements zzbpe {
    private final zzbws zzfkc;
    private final zzbww zzfli;

    public zzbyc(zzbws zzbwsVar, zzbww zzbwwVar) {
        this.zzfkc = zzbwsVar;
        this.zzfli = zzbwwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final void onAdImpression() {
        if (this.zzfkc.zzajh() == null) {
            return;
        }
        zzbdi zzajg = this.zzfkc.zzajg();
        zzbdi zzajf = this.zzfkc.zzajf();
        if (zzajg == null) {
            zzajg = zzajf != null ? zzajf : null;
        }
        if (!this.zzfli.zzaiw() || zzajg == null) {
            return;
        }
        zzajg.zza("onSdkImpression", new ArrayMap());
    }
}
