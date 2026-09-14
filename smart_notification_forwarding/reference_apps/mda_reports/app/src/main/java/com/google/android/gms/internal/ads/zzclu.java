package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class zzclu<AdT> implements zzdgf<zzczt, AdT> {
    private final Executor executor;
    private final zzdda zzfbm;
    private final ScheduledExecutorService zzfdi;
    private final zzdcr zzfgm;
    private final zzbou zzfik;
    private final zzbmi<AdT> zzgaj;
    private final zzclp zzgak;

    public zzclu(zzdcr zzdcrVar, zzclp zzclpVar, zzbou zzbouVar, zzdda zzddaVar, zzbmi<AdT> zzbmiVar, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.zzfgm = zzdcrVar;
        this.zzgak = zzclpVar;
        this.zzfik = zzbouVar;
        this.zzfbm = zzddaVar;
        this.zzgaj = zzbmiVar;
        this.executor = executor;
        this.zzfdi = scheduledExecutorService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdhe a(zzczl zzczlVar, zzcio zzcioVar, zzczt zzcztVar, Throwable th) {
        return this.zzgak.zza(zzczlVar, zzdgs.zza(zzcioVar.zzb(zzcztVar, zzczlVar), zzczlVar.zzglx, TimeUnit.MILLISECONDS, this.zzfdi));
    }

    @Override // com.google.android.gms.internal.ads.zzdgf
    public final /* synthetic */ zzdhe zzf(zzczt zzcztVar) {
        final zzczt zzcztVar2 = zzcztVar;
        zzdca zzaqg = this.zzfgm.zzu(zzdco.RENDER_CONFIG_INIT).zzc(zzdgs.zzk(new zzclr("No ad configs", 3))).zzaqg();
        this.zzfik.zza(new zzbit(zzcztVar2, this.zzfbm), this.executor);
        int i = 0;
        for (final zzczl zzczlVar : zzcztVar2.zzgmi.zzgme) {
            Iterator<String> it = zzczlVar.zzgli.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                final zzcio<AdT> zzd = this.zzgaj.zzd(zzczlVar.zzfjj, next);
                if (zzd != null && zzd.zza(zzcztVar2, zzczlVar)) {
                    zzdcj<I> zza = this.zzfgm.zza((zzdcr) zzdco.RENDER_CONFIG_WATERFALL, (zzdhe) zzaqg);
                    StringBuilder sb = new StringBuilder(String.valueOf(next).length() + 26);
                    sb.append("render-config-");
                    sb.append(i);
                    sb.append("-");
                    sb.append(next);
                    zzaqg = zza.zzgn(sb.toString()).zza(Throwable.class, new zzdgf(this, zzczlVar, zzd, zzcztVar2) { // from class: com.google.android.gms.internal.ads.zzclt
                        private final zzczl zzfzk;
                        private final zzczt zzfzm;
                        private final zzclu zzgah;
                        private final zzcio zzgai;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzgah = this;
                            this.zzfzk = zzczlVar;
                            this.zzgai = zzd;
                            this.zzfzm = zzcztVar2;
                        }

                        @Override // com.google.android.gms.internal.ads.zzdgf
                        public final zzdhe zzf(Object obj) {
                            return this.zzgah.a(this.zzfzk, this.zzgai, this.zzfzm, (Throwable) obj);
                        }
                    }).zzaqg();
                    break;
                }
            }
            i++;
        }
        return zzaqg;
    }
}
