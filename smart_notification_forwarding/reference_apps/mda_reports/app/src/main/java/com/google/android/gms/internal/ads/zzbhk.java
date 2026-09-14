package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
final class zzbhk implements zzczd {
    private final /* synthetic */ zzbgr zzerr;
    private zzdxp<Context> zzewd;
    private zzdxp<String> zzewe;
    private zzdxp<zzcxt<zzcbi, zzcbb>> zzezh;
    private zzdxp<zzcxz> zzezi;
    private zzdxp<zzczs> zzezj;
    private zzdxp<zzcyt> zzezk;
    private zzdxp<zzczf> zzezl;
    private zzdxp<zzcyz> zzezm;

    private zzbhk(zzbgr zzbgrVar, Context context, String str) {
        zzdxp zzdxpVar;
        zzdxp zzdxpVar2;
        zzdxp zzdxpVar3;
        zzdxp zzdxpVar4;
        zzdxp zzdxpVar5;
        this.zzerr = zzbgrVar;
        this.zzewd = zzdxf.zzbe(context);
        zzdxp<Context> zzdxpVar6 = this.zzewd;
        zzdxpVar = this.zzerr.zzelm;
        zzdxpVar2 = this.zzerr.zzeln;
        this.zzezh = new zzcxx(zzdxpVar6, zzdxpVar, zzdxpVar2);
        zzdxpVar3 = this.zzerr.zzelm;
        this.zzezi = zzdxd.zzan(new zzcyr(zzdxpVar3));
        this.zzezj = zzdxd.zzan(zzczv.zzaop());
        zzdxp<Context> zzdxpVar7 = this.zzewd;
        zzdxpVar4 = this.zzerr.zzejz;
        zzdxpVar5 = this.zzerr.zzejt;
        this.zzezk = zzdxd.zzan(new zzcyw(zzdxpVar7, zzdxpVar4, zzdxpVar5, this.zzezh, this.zzezi, zzczz.zzaot(), this.zzezj));
        this.zzezl = zzdxd.zzan(new zzczg(this.zzezk, this.zzezi, this.zzezj));
        this.zzewe = zzdxf.zzbf(str);
        this.zzezm = zzdxd.zzan(new zzcza(this.zzewe, this.zzezk, this.zzezi, this.zzezj));
    }

    @Override // com.google.android.gms.internal.ads.zzczd
    public final zzczf zzaep() {
        return this.zzezl.get();
    }

    @Override // com.google.android.gms.internal.ads.zzczd
    public final zzcyz zzaeq() {
        return this.zzezm.get();
    }
}
