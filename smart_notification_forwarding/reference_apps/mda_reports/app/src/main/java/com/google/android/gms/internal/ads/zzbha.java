package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
final class zzbha implements zzcwx {
    private final /* synthetic */ zzbgr zzerr;
    private zzdxp<Context> zzewd;
    private zzdxp<String> zzewe;
    private zzdxp<zzcxt<zzbka, zzbke>> zzewf;
    private zzdxp<zzcwz> zzewg;
    private zzdxp<zzcwl> zzewh;
    private zzdxp<zzcwr> zzewi;

    private zzbha(zzbgr zzbgrVar, Context context, String str) {
        zzdxp zzdxpVar;
        zzdxp zzdxpVar2;
        zzdxp zzdxpVar3;
        zzdxp zzdxpVar4;
        zzdxp zzdxpVar5;
        zzdxp zzdxpVar6;
        zzdxp zzdxpVar7;
        this.zzerr = zzbgrVar;
        this.zzewd = zzdxf.zzbe(context);
        this.zzewe = zzdxf.zzbe(str);
        zzdxp<Context> zzdxpVar8 = this.zzewd;
        zzdxpVar = this.zzerr.zzelm;
        zzdxpVar2 = this.zzerr.zzeln;
        this.zzewf = new zzcxu(zzdxpVar8, zzdxpVar, zzdxpVar2);
        zzdxpVar3 = this.zzerr.zzelm;
        this.zzewg = zzdxd.zzan(new zzcxc(zzdxpVar3));
        zzdxp<Context> zzdxpVar9 = this.zzewd;
        zzdxpVar4 = this.zzerr.zzejz;
        zzdxpVar5 = this.zzerr.zzejt;
        this.zzewh = zzdxd.zzan(new zzcwo(zzdxpVar9, zzdxpVar4, zzdxpVar5, this.zzewf, this.zzewg, zzczz.zzaot()));
        zzdxpVar6 = this.zzerr.zzejt;
        zzdxp<Context> zzdxpVar10 = this.zzewd;
        zzdxp<String> zzdxpVar11 = this.zzewe;
        zzdxp<zzcwl> zzdxpVar12 = this.zzewh;
        zzdxp<zzcwz> zzdxpVar13 = this.zzewg;
        zzdxpVar7 = this.zzerr.zzekg;
        this.zzewi = zzdxd.zzan(new zzcwu(zzdxpVar6, zzdxpVar10, zzdxpVar11, zzdxpVar12, zzdxpVar13, zzdxpVar7));
    }

    @Override // com.google.android.gms.internal.ads.zzcwx
    public final zzcwr zzaea() {
        return this.zzewi.get();
    }
}
