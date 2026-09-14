package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class zzbwe implements zzdxg<zzbst> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzczl> zzffb;

    public zzbwe(zzdxp<Context> zzdxpVar, zzdxp<zzczl> zzdxpVar2) {
        this.zzejv = zzdxpVar;
        this.zzffb = zzdxpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbst) zzdxm.zza(new zzbst(this.zzejv.get(), new HashSet(), this.zzffb.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
