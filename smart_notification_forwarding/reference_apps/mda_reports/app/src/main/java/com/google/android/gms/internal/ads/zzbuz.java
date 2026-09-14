package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbuz implements zzdxg<zzbva> {
    private final zzdxp<zzbpd> zzfjk;
    private final zzdxp<zzczl> zzfjl;

    private zzbuz(zzdxp<zzbpd> zzdxpVar, zzdxp<zzczl> zzdxpVar2) {
        this.zzfjk = zzdxpVar;
        this.zzfjl = zzdxpVar2;
    }

    public static zzbuz zzk(zzdxp<zzbpd> zzdxpVar, zzdxp<zzczl> zzdxpVar2) {
        return new zzbuz(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbva(this.zzfjk.get(), this.zzfjl.get());
    }
}
