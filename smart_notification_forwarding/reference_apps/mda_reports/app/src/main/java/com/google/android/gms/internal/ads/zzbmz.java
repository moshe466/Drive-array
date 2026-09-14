package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class zzbmz<T> {
    private final zzcfx zzfgi;
    private final zzcge zzfgj;
    private final zzdxp<zzdhe<zzaqk>> zzfgk;
    private final zzczu zzfgl;
    private final zzdcr zzfgm;
    private final zzbim zzfgn;
    private final zzclu<T> zzfgo;
    private final zzbrf zzfgp;

    @Nullable
    private final zzczt zzfgq;
    private final zzcgu zzfgr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbmz(zzcfx zzcfxVar, zzcge zzcgeVar, zzdxp<zzdhe<zzaqk>> zzdxpVar, zzczu zzczuVar, zzdcr zzdcrVar, zzbim zzbimVar, zzclu<T> zzcluVar, zzbrf zzbrfVar, @Nullable zzczt zzcztVar, zzcgu zzcguVar) {
        this.zzfgi = zzcfxVar;
        this.zzfgj = zzcgeVar;
        this.zzfgk = zzdxpVar;
        this.zzfgl = zzczuVar;
        this.zzfgm = zzdcrVar;
        this.zzfgn = zzbimVar;
        this.zzfgo = zzcluVar;
        this.zzfgp = zzbrfVar;
        this.zzfgq = zzcztVar;
        this.zzfgr = zzcguVar;
    }

    public final zzdhe<T> zza(zzdhe<zzczt> zzdheVar) {
        zzdcj zza;
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcow)).booleanValue()) {
            zza = this.zzfgm.zza((zzdcr) zzdco.RENDERER, (zzdhe) zzdheVar).zza(this.zzfgn).zza(this.zzfgo);
        } else {
            zza = this.zzfgm.zza((zzdcr) zzdco.RENDERER, (zzdhe) zzdheVar).zza(this.zzfgn).zza(this.zzfgo).zza(((Integer) zzve.zzoy().zzd(zzzn.zzcox)).intValue(), TimeUnit.SECONDS);
        }
        return zza.zzaqg();
    }

    public final zzdhe<zzczt> zzagz() {
        zzdcj zza;
        zzdch zzu;
        zzdhe<zzczt> zzalt;
        zzdhe<zzaqk> zzdheVar = this.zzfgk.get();
        if (this.zzfgq != null) {
            zzu = this.zzfgm.zzu(zzdco.SERVER_TRANSACTION);
            zzalt = zzdgs.zzaj(this.zzfgq);
        } else {
            com.google.android.gms.ads.internal.zzq.zzkw().zzmo();
            if (this.zzfgl.zzgml.zzccm == null) {
                zza = this.zzfgm.zza((zzdcr) zzdco.SERVER_TRANSACTION, (zzdhe) zzdheVar).zza(this.zzfgi);
                return zza.zzaqg();
            }
            zzu = this.zzfgm.zzu(zzdco.SERVER_TRANSACTION);
            zzalt = this.zzfgj.zzalt();
        }
        zza = zzu.zzc(zzalt);
        return zza.zzaqg();
    }

    public final zzdhe<T> zzaha() {
        return zza(zzagz());
    }

    public final zzbrf zzahb() {
        return this.zzfgp;
    }
}
