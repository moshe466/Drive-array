package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcqb implements zzdxg<zzcpy> {
    private final zzdxp<zzczu> zzfep;

    private zzcqb(zzdxp<zzczu> zzdxpVar) {
        this.zzfep = zzdxpVar;
    }

    public static zzcqb zzah(zzdxp<zzczu> zzdxpVar) {
        return new zzcqb(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcpy(this.zzfep.get());
    }
}
