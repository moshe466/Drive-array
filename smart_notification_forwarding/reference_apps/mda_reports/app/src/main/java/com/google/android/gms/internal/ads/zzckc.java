package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzckc implements zzcio<zzbtu> {
    private final zzazb zzbli;
    private final Executor zzfci;
    private final zzczu zzfgl;
    private final zzcbn zzfod;
    private final zzbup zzfyt;
    private final Context zzup;

    public zzckc(Context context, zzazb zzazbVar, zzczu zzczuVar, Executor executor, zzbup zzbupVar, zzcbn zzcbnVar) {
        this.zzup = context;
        this.zzfgl = zzczuVar;
        this.zzfyt = zzbupVar;
        this.zzfci = executor;
        this.zzbli = zzazbVar;
        this.zzfod = zzcbnVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdhe a(final zzczl zzczlVar, zzccd zzccdVar, zzczt zzcztVar, Object obj) {
        zzdhe<?> zza;
        final zzbdi zza2 = this.zzfod.zza(this.zzfgl.zzblm, zzczlVar.zzega);
        zza2.zzba(zzczlVar.zzdll);
        zzccdVar.zza(this.zzup, zza2.getView());
        zzazl zzazlVar = new zzazl();
        final zzbtw zza3 = this.zzfyt.zza(new zzbmt(zzcztVar, zzczlVar, null), new zzbtv(new zzcki(this.zzup, this.zzbli, zzazlVar, zzczlVar, zza2), zza2));
        zzazlVar.set(zza3);
        zza3.zzadk().zza(new zzbpe(zza2) { // from class: com.google.android.gms.internal.ads.zzckd
            private final zzbdi zzehp;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzehp = zza2;
            }

            @Override // com.google.android.gms.internal.ads.zzbpe
            public final void onAdImpression() {
                zzbdi zzbdiVar = this.zzehp;
                if (zzbdiVar.zzaaa() != null) {
                    zzbdiVar.zzaaa().zzaaz();
                }
            }
        }, zzazd.zzdwj);
        zza3.zzadx().zzb(zza2, true);
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcqj)).booleanValue() && zzczlVar.zzega) {
            zza = zzdgs.zzaj(null);
        } else {
            zza3.zzadx();
            zzczp zzczpVar = zzczlVar.zzglo;
            zza = zzcbp.zza(zza2, zzczpVar.zzdhr, zzczpVar.zzdht);
        }
        return zzdgs.zzb(zza, new zzded(this, zza2, zzczlVar, zza3) { // from class: com.google.android.gms.internal.ads.zzckg
            private final zzczl zzfel;
            private final zzbdi zzfpv;
            private final zzckc zzfzj;
            private final zzbtw zzfzo;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfzj = this;
                this.zzfpv = zza2;
                this.zzfel = zzczlVar;
                this.zzfzo = zza3;
            }

            @Override // com.google.android.gms.internal.ads.zzded
            public final Object apply(Object obj2) {
                zzbdi zzbdiVar = this.zzfpv;
                zzczl zzczlVar2 = this.zzfel;
                zzbtw zzbtwVar = this.zzfzo;
                if (zzczlVar2.zzdmf) {
                    zzbdiVar.zzaan();
                }
                zzbdiVar.zzzu();
                if (((Boolean) zzve.zzoy().zzd(zzzn.zzciq)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzq.zzks();
                    zzawh.zza(zzbdiVar);
                }
                return zzbtwVar.zzaem();
            }
        }, this.zzfci);
    }

    @Override // com.google.android.gms.internal.ads.zzcio
    public final boolean zza(zzczt zzcztVar, zzczl zzczlVar) {
        zzczp zzczpVar = zzczlVar.zzglo;
        return (zzczpVar == null || zzczpVar.zzdht == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcio
    public final zzdhe<zzbtu> zzb(final zzczt zzcztVar, final zzczl zzczlVar) {
        final zzccd zzccdVar = new zzccd();
        zzdhe<zzbtu> zzb = zzdgs.zzb(zzdgs.zzaj(null), new zzdgf(this, zzczlVar, zzccdVar, zzcztVar) { // from class: com.google.android.gms.internal.ads.zzckb
            private final zzckc zzfzj;
            private final zzczl zzfzk;
            private final zzccd zzfzl;
            private final zzczt zzfzm;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfzj = this;
                this.zzfzk = zzczlVar;
                this.zzfzl = zzccdVar;
                this.zzfzm = zzcztVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdgf
            public final zzdhe zzf(Object obj) {
                return this.zzfzj.a(this.zzfzk, this.zzfzl, this.zzfzm, obj);
            }
        }, this.zzfci);
        zzb.addListener(zzcke.a(zzccdVar), this.zzfci);
        return zzb;
    }
}
