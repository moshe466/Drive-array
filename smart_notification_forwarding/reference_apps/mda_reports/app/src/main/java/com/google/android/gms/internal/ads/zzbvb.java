package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbvb implements zzdxg<zzbvc> {
    private final zzdxp<zzbpg> zzfjk;

    private zzbvb(zzdxp<zzbpg> zzdxpVar) {
        this.zzfjk = zzdxpVar;
    }

    public static zzbvb zzv(zzdxp<zzbpg> zzdxpVar) {
        return new zzbvb(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbvc(this.zzfjk.get());
    }
}
