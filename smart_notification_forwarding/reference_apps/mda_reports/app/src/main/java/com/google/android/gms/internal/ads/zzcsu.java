package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzcsu implements zzdxg<zzcss> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzdhd> zzgem;
    private final zzdxp<Set<String>> zzgew;

    private zzcsu(zzdxp<zzdhd> zzdxpVar, zzdxp<Context> zzdxpVar2, zzdxp<Set<String>> zzdxpVar3) {
        this.zzgem = zzdxpVar;
        this.zzejv = zzdxpVar2;
        this.zzgew = zzdxpVar3;
    }

    public static zzcsu zzo(zzdxp<zzdhd> zzdxpVar, zzdxp<Context> zzdxpVar2, zzdxp<Set<String>> zzdxpVar3) {
        return new zzcsu(zzdxpVar, zzdxpVar2, zzdxpVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcss(this.zzgem.get(), this.zzejv.get(), this.zzgew.get());
    }
}
