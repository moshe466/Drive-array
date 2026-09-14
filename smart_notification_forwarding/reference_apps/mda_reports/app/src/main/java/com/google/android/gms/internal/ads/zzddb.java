package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzddb implements zzdxg<zzakc> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzazb> zzfhn;
    private final zzdcy zzgrn;

    public zzddb(zzdcy zzdcyVar, zzdxp<Context> zzdxpVar, zzdxp<zzazb> zzdxpVar2) {
        this.zzgrn = zzdcyVar;
        this.zzejv = zzdxpVar;
        this.zzfhn = zzdxpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzakc) zzdxm.zza(new zzajt().zzb(this.zzejv.get(), this.zzfhn.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
