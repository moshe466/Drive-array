package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbic implements zzdxg<zzayy> {
    private final zzdxp<String> zzfba;

    public zzbic(zzdxp<String> zzdxpVar) {
        this.zzfba = zzdxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzayy) zzdxm.zza(new zzayy(this.zzfba.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
