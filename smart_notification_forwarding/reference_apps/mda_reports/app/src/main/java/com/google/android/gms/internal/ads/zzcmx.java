package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcmx implements zzdxg<zzcmy> {
    private final zzdxp<zzcnz> zzgbd;

    private zzcmx(zzdxp<zzcnz> zzdxpVar) {
        this.zzgbd = zzdxpVar;
    }

    public static zzcmx zzaf(zzdxp<zzcnz> zzdxpVar) {
        return new zzcmx(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcmy(this.zzgbd.get());
    }
}
