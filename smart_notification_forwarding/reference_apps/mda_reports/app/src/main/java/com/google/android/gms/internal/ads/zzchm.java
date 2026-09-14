package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzchm implements zzdxg<zzcgw> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<Executor> zzfei;
    private final zzdxp<zzarb> zzfwo;
    private final zzdxp<zzbij> zzfwp;
    private final zzdxp<zzaqy> zzfwq;
    private final zzdxp<HashMap<String, zzchh>> zzfwr;

    private zzchm(zzdxp<Context> zzdxpVar, zzdxp<Executor> zzdxpVar2, zzdxp<zzarb> zzdxpVar3, zzdxp<zzbij> zzdxpVar4, zzdxp<zzaqy> zzdxpVar5, zzdxp<HashMap<String, zzchh>> zzdxpVar6) {
        this.zzejv = zzdxpVar;
        this.zzfei = zzdxpVar2;
        this.zzfwo = zzdxpVar3;
        this.zzfwp = zzdxpVar4;
        this.zzfwq = zzdxpVar5;
        this.zzfwr = zzdxpVar6;
    }

    public static zzchm zzc(zzdxp<Context> zzdxpVar, zzdxp<Executor> zzdxpVar2, zzdxp<zzarb> zzdxpVar3, zzdxp<zzbij> zzdxpVar4, zzdxp<zzaqy> zzdxpVar5, zzdxp<HashMap<String, zzchh>> zzdxpVar6) {
        return new zzchm(zzdxpVar, zzdxpVar2, zzdxpVar3, zzdxpVar4, zzdxpVar5, zzdxpVar6);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcgw(this.zzejv.get(), this.zzfei.get(), this.zzfwo.get(), this.zzfwp.get(), this.zzfwq.get(), this.zzfwr.get());
    }
}
