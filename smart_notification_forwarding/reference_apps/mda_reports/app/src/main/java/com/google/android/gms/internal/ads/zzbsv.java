package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzbsv implements zzdxg<zzbst> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<Set<zzbsu<zzps>>> zzfeo;
    private final zzdxp<zzczl> zzffb;

    private zzbsv(zzdxp<Context> zzdxpVar, zzdxp<Set<zzbsu<zzps>>> zzdxpVar2, zzdxp<zzczl> zzdxpVar3) {
        this.zzejv = zzdxpVar;
        this.zzfeo = zzdxpVar2;
        this.zzffb = zzdxpVar3;
    }

    public static zzbsv zzh(zzdxp<Context> zzdxpVar, zzdxp<Set<zzbsu<zzps>>> zzdxpVar2, zzdxp<zzczl> zzdxpVar3) {
        return new zzbsv(zzdxpVar, zzdxpVar2, zzdxpVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbst(this.zzejv.get(), this.zzfeo.get(), this.zzffb.get());
    }
}
