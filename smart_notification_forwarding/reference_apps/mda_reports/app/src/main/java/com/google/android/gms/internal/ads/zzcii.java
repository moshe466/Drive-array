package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* loaded from: classes.dex */
public final class zzcii implements zzdxg<zzcid> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzchz> zzems;
    private final zzdxp<zzcht> zzepb;
    private final zzdxp<zzdhe<Bundle>> zzfxy;

    private zzcii(zzdxp<Context> zzdxpVar, zzdxp<zzdhe<Bundle>> zzdxpVar2, zzdxp<zzchz> zzdxpVar3, zzdxp<zzcht> zzdxpVar4) {
        this.zzejv = zzdxpVar;
        this.zzfxy = zzdxpVar2;
        this.zzems = zzdxpVar3;
        this.zzepb = zzdxpVar4;
    }

    public static zzcii zzc(zzdxp<Context> zzdxpVar, zzdxp<zzdhe<Bundle>> zzdxpVar2, zzdxp<zzchz> zzdxpVar3, zzdxp<zzcht> zzdxpVar4) {
        return new zzcii(zzdxpVar, zzdxpVar2, zzdxpVar3, zzdxpVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcid(this.zzejv.get(), this.zzfxy.get(), this.zzems.get(), this.zzepb.get());
    }
}
