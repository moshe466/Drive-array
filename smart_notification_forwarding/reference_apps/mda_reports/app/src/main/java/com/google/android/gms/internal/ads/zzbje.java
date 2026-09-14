package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzbje implements zzdxg<zzbjb> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzpn> zzfcn;

    private zzbje(zzdxp<Context> zzdxpVar, zzdxp<zzpn> zzdxpVar2) {
        this.zzejv = zzdxpVar;
        this.zzfcn = zzdxpVar2;
    }

    public static zzbje zza(zzdxp<Context> zzdxpVar, zzdxp<zzpn> zzdxpVar2) {
        return new zzbje(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbjb(this.zzejv.get(), this.zzfcn.get());
    }
}
