package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcib implements zzdcx {
    private final zzchz zzfxk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcib(zzchz zzchzVar) {
        this.zzfxk = zzchzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdcx
    public final void zza(zzdco zzdcoVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdcx
    public final void zza(zzdco zzdcoVar, String str, Throwable th) {
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcqf)).booleanValue() && zzdco.RENDERER == zzdcoVar && this.zzfxk.zzalz() != 0) {
            this.zzfxk.zzer(com.google.android.gms.ads.internal.zzq.zzkx().elapsedRealtime() - this.zzfxk.zzalz());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcx
    public final void zzb(zzdco zzdcoVar, String str) {
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcqf)).booleanValue() && zzdco.RENDERER == zzdcoVar) {
            this.zzfxk.zzfe(com.google.android.gms.ads.internal.zzq.zzkx().elapsedRealtime());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcx
    public final void zzc(zzdco zzdcoVar, String str) {
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcqf)).booleanValue() && zzdco.RENDERER == zzdcoVar && this.zzfxk.zzalz() != 0) {
            this.zzfxk.zzer(com.google.android.gms.ads.internal.zzq.zzkx().elapsedRealtime() - this.zzfxk.zzalz());
        }
    }
}
