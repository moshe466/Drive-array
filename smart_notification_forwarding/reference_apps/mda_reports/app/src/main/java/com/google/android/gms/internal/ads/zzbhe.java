package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
final class zzbhe implements zzblp {
    private zzdxp<Set<zzbsu<zzbph>>> zzerv;
    private zzdxp<zzbpg> zzerw;
    private zzdxp<zzczt> zzerx;
    private zzdxp<zzczl> zzery;
    private zzdxp<Set<zzbsu<zzbqb>>> zzesp;
    private zzdxp<zzbpw> zzesq;
    private zzdxp<String> zzeta;
    private zzdxp<zzbom> zzetb;
    private zzdxp<zzbmg> zzetc;
    private final zzbls zzexf;
    private zzdxp<zzaea> zzexg;
    private zzdxp<Runnable> zzexh;
    private zzdxp<zzblo> zzexi;
    private final /* synthetic */ zzbhc zzexj;

    private zzbhe(zzbhc zzbhcVar, zzbmt zzbmtVar, zzbls zzblsVar) {
        zzdxp zzdxpVar;
        this.zzexj = zzbhcVar;
        this.zzexf = zzblsVar;
        this.zzerx = zzbmy.zze(zzbmtVar);
        this.zzery = zzbmw.zzc(zzbmtVar);
        this.zzerv = zzdxl.zzar(0, 2).zzaq(zzbhc.z(this.zzexj)).zzaq(zzbhc.y(this.zzexj)).zzbdp();
        this.zzerw = zzdxd.zzan(zzbpn.zzi(this.zzerv));
        this.zzesp = zzdxl.zzar(4, 3).zzap(zzbhc.v(this.zzexj)).zzap(zzbhc.u(this.zzexj)).zzap(zzbhc.t(this.zzexj)).zzaq(zzbhc.g(this.zzexj)).zzaq(zzbhc.f(this.zzexj)).zzaq(zzbhc.e(this.zzexj)).zzap(zzbhc.q(this.zzexj)).zzbdp();
        this.zzesq = zzdxd.zzan(zzbpy.zzk(this.zzesp));
        this.zzeta = zzbmv.zza(zzbmtVar);
        this.zzetb = zzbop.zzh(this.zzery, this.zzeta);
        this.zzetc = zzbnp.zzb(this.zzerx, this.zzery, this.zzerw, this.zzesq, zzbhc.h(this.zzexj), this.zzetb);
        this.zzexg = new zzblu(zzblsVar);
        this.zzexh = new zzblr(zzblsVar);
        zzdxp<zzbmg> zzdxpVar2 = this.zzetc;
        zzdxp<zzaea> zzdxpVar3 = this.zzexg;
        zzdxp<Runnable> zzdxpVar4 = this.zzexh;
        zzdxpVar = this.zzexj.a.zzejz;
        this.zzexi = zzdxd.zzan(new zzblt(zzdxpVar2, zzdxpVar3, zzdxpVar4, zzdxpVar));
    }

    @Override // com.google.android.gms.internal.ads.zzblp
    public final zzbkk zzaef() {
        return (zzbkk) zzdxm.zza(this.zzexi.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
