package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzckk implements zzcir<zzbtu, zzdac, zzcjy> {
    private final zzazb zzbli;
    private final Executor zzfci;
    private final zzbup zzfyt;
    private final Context zzup;

    public zzckk(Context context, zzazb zzazbVar, zzbup zzbupVar, Executor executor) {
        this.zzup = context;
        this.zzbli = zzazbVar;
        this.zzfyt = zzbupVar;
        this.zzfci = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void zza(zzczt zzcztVar, zzczl zzczlVar, zzcip<zzdac, zzcjy> zzcipVar) {
        if (this.zzbli.zzdwa < 4100000) {
            zzcipVar.zzddn.zza(this.zzup, zzcztVar.zzgmh.zzfgl.zzgml, zzczlVar.zzglr.toString(), zzcipVar.zzfyf);
        } else {
            zzcipVar.zzddn.zza(this.zzup, zzcztVar.zzgmh.zzfgl.zzgml, zzczlVar.zzglr.toString(), zzaxs.zza(zzczlVar.zzglo), zzcipVar.zzfyf);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final /* synthetic */ zzbtu zzb(zzczt zzcztVar, zzczl zzczlVar, final zzcip<zzdac, zzcjy> zzcipVar) {
        zzbtw zza = this.zzfyt.zza(new zzbmt(zzcztVar, zzczlVar, zzcipVar.zzfge), new zzbtv(new zzbuv(zzcipVar) { // from class: com.google.android.gms.internal.ads.zzckj
            private final zzcip zzfyq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfyq = zzcipVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.internal.ads.zzbuv
            public final void zza(boolean z, Context context) {
                zzcip zzcipVar2 = this.zzfyq;
                try {
                    ((zzdac) zzcipVar2.zzddn).setImmersiveMode(z);
                    ((zzdac) zzcipVar2.zzddn).showInterstitial();
                } catch (zzdab unused) {
                    zzayu.zzey("Cannot show interstitial.");
                }
            }
        }));
        zza.zzadh().zza((zzbpg) new zzbiu(zzcipVar.zzddn), this.zzfci);
        zzcipVar.zzfyf.zza(zza.zzadm());
        return zza.zzaem();
    }
}
