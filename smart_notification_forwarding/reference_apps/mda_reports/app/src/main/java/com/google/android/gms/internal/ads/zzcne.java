package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpu;

/* loaded from: classes.dex */
public final class zzcne<AdT, AdapterT, ListenerT extends zzbpu> implements zzdxg<zzcna<AdT, AdapterT, ListenerT>> {
    private final zzdxp<zzcis<AdapterT, ListenerT>> zzfaw;
    private final zzdxp<zzdhd> zzfei;
    private final zzdxp<zzdcr> zzfet;
    private final zzdxp<zzcir<AdT, AdapterT, ListenerT>> zzgbk;

    private zzcne(zzdxp<zzdcr> zzdxpVar, zzdxp<zzdhd> zzdxpVar2, zzdxp<zzcis<AdapterT, ListenerT>> zzdxpVar3, zzdxp<zzcir<AdT, AdapterT, ListenerT>> zzdxpVar4) {
        this.zzfet = zzdxpVar;
        this.zzfei = zzdxpVar2;
        this.zzfaw = zzdxpVar3;
        this.zzgbk = zzdxpVar4;
    }

    public static <AdT, AdapterT, ListenerT extends zzbpu> zzcne<AdT, AdapterT, ListenerT> zzd(zzdxp<zzdcr> zzdxpVar, zzdxp<zzdhd> zzdxpVar2, zzdxp<zzcis<AdapterT, ListenerT>> zzdxpVar3, zzdxp<zzcir<AdT, AdapterT, ListenerT>> zzdxpVar4) {
        return new zzcne<>(zzdxpVar, zzdxpVar2, zzdxpVar3, zzdxpVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcna(this.zzfet.get(), this.zzfei.get(), this.zzfaw.get(), this.zzgbk.get());
    }
}
