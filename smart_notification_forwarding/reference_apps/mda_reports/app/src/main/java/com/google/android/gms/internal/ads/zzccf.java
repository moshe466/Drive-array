package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzccf implements zzdxg<zzccg> {
    private final zzdxp<zzbdi> zzfef;

    private zzccf(zzdxp<zzbdi> zzdxpVar) {
        this.zzfef = zzdxpVar;
    }

    public static zzccf zzy(zzdxp<zzbdi> zzdxpVar) {
        return new zzccf(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzccg(this.zzfef.get());
    }
}
