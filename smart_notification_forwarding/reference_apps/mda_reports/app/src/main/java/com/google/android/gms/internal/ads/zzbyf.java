package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbyf implements zzdxg<zzbxa> {
    private final zzdxp<zzbye> zzetg;
    private final zzbyg zzfon;

    public zzbyf(zzbyg zzbygVar, zzdxp<zzbye> zzdxpVar) {
        this.zzfon = zzbygVar;
        this.zzetg = zzdxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbxa) zzdxm.zza(this.zzetg.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
