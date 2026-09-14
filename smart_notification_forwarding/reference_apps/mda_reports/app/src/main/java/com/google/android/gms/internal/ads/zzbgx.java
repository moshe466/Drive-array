package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class zzbgx extends zzcut {
    private zzdxp<String> zzemd;
    private zzdxp<zzcdh> zzemt;
    private zzdxp<Map<zzdco, zzcdh>> zzemv;
    private zzdxp<Set<zzbsu<zzdcx>>> zzemx;
    private zzdxp<Set<zzbsu<zzdcx>>> zzene;
    private zzdxp zzenf;
    private zzdxp<zzdcr> zzeng;
    private zzdxp<ApplicationInfo> zzenh;
    private final /* synthetic */ zzbgr zzerr;
    private final zzcvw zzeuu;
    private zzdxp<zzcup> zzeuv;
    private zzdxp<String> zzeuw;
    private zzdxp<zzcuz> zzeux;
    private zzdxp<zzcvd> zzeuy;
    private zzdxp<zzcvi> zzeuz;
    private zzdxp<Boolean> zzeva;
    private zzdxp<zzcvr> zzevb;
    private zzdxp<zzcvv> zzevc;
    private zzdxp<zzcwg> zzevd;
    private zzdxp<zzcdh> zzeve;
    private zzdxp<zzcdh> zzevf;
    private zzdxp<zzcdh> zzevg;

    private zzbgx(zzbgr zzbgrVar, zzcvw zzcvwVar) {
        zzdxp zzdxpVar;
        zzdxp zzdxpVar2;
        zzdxp zzdxpVar3;
        zzdxp zzdxpVar4;
        zzdxp zzdxpVar5;
        zzdxp zzdxpVar6;
        zzdxp zzdxpVar7;
        zzdxp zzdxpVar8;
        zzdxp zzdxpVar9;
        this.zzerr = zzbgrVar;
        this.zzeuu = zzcvwVar;
        zzbih zzafi = zzbih.zzafi();
        zzdxpVar = this.zzerr.zzekf;
        zzdxpVar2 = this.zzerr.zzekb;
        this.zzeuv = new zzcuq(zzafi, zzdxpVar, zzdxpVar2, zzdbv.zzapz());
        this.zzeuw = new zzcvz(zzcvwVar);
        zzbgk zzacu = zzbgk.zzacu();
        zzdxpVar3 = this.zzerr.zzekf;
        this.zzeux = new zzcvb(zzacu, zzdxpVar3, this.zzeuw, zzdbv.zzapz());
        zzbid zzafb = zzbid.zzafb();
        zzdbv zzapz = zzdbv.zzapz();
        zzdxpVar4 = this.zzerr.zzekf;
        this.zzeuy = new zzcvf(zzafb, zzapz, zzdxpVar4);
        this.zzeuz = new zzcvk(zzbig.zzafg(), zzdbv.zzapz(), this.zzeuw);
        this.zzeva = new zzcwb(zzcvwVar);
        this.zzenh = new zzcvy(zzcvwVar);
        zzbif zzafe = zzbif.zzafe();
        zzdxpVar5 = this.zzerr.zzekb;
        this.zzevb = new zzcvt(zzafe, zzdxpVar5, this.zzeva, this.zzenh);
        zzbii zzafk = zzbii.zzafk();
        zzdxpVar6 = this.zzerr.zzekb;
        zzdxpVar7 = this.zzerr.zzekf;
        this.zzevc = new zzcvx(zzafk, zzdxpVar6, zzdxpVar7);
        this.zzevd = new zzcwi(zzdbv.zzapz());
        this.zzemd = new zzcwa(zzcvwVar);
        this.zzemt = zzdxd.zzan(zzcdb.zzalb());
        this.zzeve = zzdxd.zzan(zzcdc.zzalc());
        this.zzevf = zzdxd.zzan(zzcde.zzale());
        this.zzevg = zzdxd.zzan(zzcdd.zzald());
        this.zzemv = ((zzdxk) ((zzdxk) ((zzdxk) ((zzdxk) zzdxi.zzhl(4).zza(zzdco.GMS_SIGNALS, this.zzemt)).zza(zzdco.BUILD_URL, this.zzeve)).zza(zzdco.HTTP, this.zzevf)).zza(zzdco.PRE_PROCESS, this.zzevg)).zzbdo();
        zzdxp<String> zzdxpVar10 = this.zzemd;
        zzdxpVar8 = this.zzerr.zzekf;
        this.zzemx = zzdxd.zzan(new zzcdg(zzdxpVar10, zzdxpVar8, zzdbv.zzapz(), this.zzemv));
        this.zzene = zzdxl.zzar(0, 1).zzaq(this.zzemx).zzbdp();
        this.zzenf = zzdcz.zzam(this.zzene);
        zzdbv zzapz2 = zzdbv.zzapz();
        zzdxpVar9 = this.zzerr.zzekb;
        this.zzeng = zzdxd.zzan(zzdcw.zzr(zzapz2, zzdxpVar9, this.zzenf));
    }

    private final zzcvm zzadr() {
        return new zzcvm(zzbie.zzafd(), zzdbv.zzaqa(), (List) zzdxm.zza(this.zzeuu.zzanx(), "Cannot return null from a non-@Nullable @Provides method"));
    }

    private final zzcuv zzads() {
        return new zzcuv(zzbih.zzafj(), zzdbv.zzaqa(), (String) zzdxm.zza(this.zzeuu.zzanu(), "Cannot return null from a non-@Nullable @Provides method"), this.zzeuu.zzanv());
    }

    @Override // com.google.android.gms.internal.ads.zzcut
    public final zzcua<JSONObject> zzadt() {
        zzdxp zzdxpVar;
        zzdxp zzdxpVar2;
        zzdxp zzdxpVar3;
        zzdxp zzdxpVar4;
        zzbga zzbgaVar;
        zzdxp zzdxpVar5;
        zzbga zzbgaVar2;
        zzdxp zzdxpVar6;
        zzdxp zzdxpVar7;
        zzdxp zzdxpVar8;
        zzbga zzbgaVar3;
        zzbga zzbgaVar4;
        zzdxp zzdxpVar9;
        zzdhd zzaqa = zzdbv.zzaqa();
        zzcvi zzcviVar = new zzcvi(zzbig.zzafh(), zzdbv.zzaqa(), zzcvz.zzc(this.zzeuu));
        zzdxpVar = this.zzerr.zzekb;
        zzcub zzcubVar = (zzcub) zzdxm.zza(new zzcsx(zzcviVar, 0L, (ScheduledExecutorService) zzdxpVar.get()), "Cannot return null from a non-@Nullable @Provides method");
        zzaks zzaff = zzbif.zzaff();
        zzdxpVar2 = this.zzerr.zzekb;
        zzcvr zzcvrVar = new zzcvr(zzaff, (ScheduledExecutorService) zzdxpVar2.get(), this.zzeuu.zzanw(), zzcvy.zzb(this.zzeuu));
        zzdxpVar3 = this.zzerr.zzekb;
        zzcub zzcubVar2 = (zzcub) zzdxm.zza(new zzcsx(zzcvrVar, ((Long) zzve.zzoy().zzd(zzzn.zzcmn)).longValue(), (ScheduledExecutorService) zzdxpVar3.get()), "Cannot return null from a non-@Nullable @Provides method");
        zzaow zzafl = zzbii.zzafl();
        zzdxpVar4 = this.zzerr.zzekb;
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) zzdxpVar4.get();
        zzbgaVar = this.zzerr.zzejy;
        zzcvv zzcvvVar = new zzcvv(zzafl, scheduledExecutorService, zzbgd.zza(zzbgaVar));
        zzdxpVar5 = this.zzerr.zzekb;
        zzcub zzcubVar3 = (zzcub) zzdxm.zza(new zzcsx(zzcvvVar, ((Long) zzve.zzoy().zzd(zzzn.zzcmu)).longValue(), (ScheduledExecutorService) zzdxpVar5.get()), "Cannot return null from a non-@Nullable @Provides method");
        zzava zzafj = zzbih.zzafj();
        zzbgaVar2 = this.zzerr.zzejy;
        Context zza = zzbgd.zza(zzbgaVar2);
        zzdxpVar6 = this.zzerr.zzekb;
        zzcup zzcupVar = new zzcup(zzafj, zza, (ScheduledExecutorService) zzdxpVar6.get(), zzdbv.zzaqa());
        zzdxpVar7 = this.zzerr.zzekb;
        zzcub zzcubVar4 = (zzcub) zzdxm.zza(new zzcsx(zzcupVar, 0L, (ScheduledExecutorService) zzdxpVar7.get()), "Cannot return null from a non-@Nullable @Provides method");
        zzcwg zzcwgVar = new zzcwg(zzdbv.zzaqa());
        zzdxpVar8 = this.zzerr.zzekb;
        zzcub zzcubVar5 = (zzcub) zzdxm.zza(new zzcsx(zzcwgVar, 0L, (ScheduledExecutorService) zzdxpVar8.get()), "Cannot return null from a non-@Nullable @Provides method");
        zzcub<? extends zzcty<JSONObject>> zzaoa = zzcwf.zzaoa();
        zzbgaVar3 = this.zzerr.zzejy;
        zzsf zzafc = zzbid.zzafc();
        zzdhd zzaqa2 = zzdbv.zzaqa();
        zzbgaVar4 = this.zzerr.zzejy;
        zzdxpVar9 = this.zzerr.zzekt;
        return new zzcua<>(zzaqa, zzdfb.zza(zzcubVar, zzcubVar2, zzcubVar3, zzcubVar4, zzcubVar5, zzaoa, new zzcuz(null, zzbgd.zza(zzbgaVar3), zzcvz.zzc(this.zzeuu), zzdbv.zzaqa()), new zzcvd(zzafc, zzaqa2, zzbgd.zza(zzbgaVar4)), zzadr(), zzads(), (zzcub) zzdxpVar9.get()));
    }

    @Override // com.google.android.gms.internal.ads.zzcut
    public final zzcua<JSONObject> zzadu() {
        zzdxp zzdxpVar;
        zzdxpVar = this.zzerr.zzekt;
        return zzcwe.zza(zzdxpVar.get(), zzads(), zzadr(), zzdxd.zzao(this.zzeuv), zzdxd.zzao(this.zzeux), zzdxd.zzao(this.zzeuy), zzdxd.zzao(this.zzeuz), zzdxd.zzao(this.zzevb), zzdxd.zzao(this.zzevc), zzdxd.zzao(this.zzevd), zzdbv.zzaqa());
    }

    @Override // com.google.android.gms.internal.ads.zzcut
    public final zzdcr zzadv() {
        return this.zzeng.get();
    }
}
