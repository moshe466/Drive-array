package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzcwu implements zzdxg<zzcwr> {
    private final zzdxp<zzbfx> zzejt;
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzazb> zzfdb;
    private final zzdxp<String> zzgja;
    private final zzdxp<zzcwl> zzgjb;
    private final zzdxp<zzcwz> zzgjc;

    public zzcwu(zzdxp<zzbfx> zzdxpVar, zzdxp<Context> zzdxpVar2, zzdxp<String> zzdxpVar3, zzdxp<zzcwl> zzdxpVar4, zzdxp<zzcwz> zzdxpVar5, zzdxp<zzazb> zzdxpVar6) {
        this.zzejt = zzdxpVar;
        this.zzejv = zzdxpVar2;
        this.zzgja = zzdxpVar3;
        this.zzgjb = zzdxpVar4;
        this.zzgjc = zzdxpVar5;
        this.zzfdb = zzdxpVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcwr(this.zzejt.get(), this.zzejv.get(), this.zzgja.get(), this.zzgjb.get(), this.zzgjc.get(), this.zzfdb.get());
    }
}
