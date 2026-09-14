package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcmi implements zzcio<zzcbb> {
    private final zzazb zzbli;
    private final Executor zzfci;
    private final zzczu zzfgl;
    private final zzcbn zzfod;
    private final zzcbi zzgal;
    private final Context zzup;

    public zzcmi(Context context, zzazb zzazbVar, zzczu zzczuVar, Executor executor, zzcbi zzcbiVar, zzcbn zzcbnVar) {
        this.zzup = context;
        this.zzfgl = zzczuVar;
        this.zzgal = zzcbiVar;
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
        final zzcbd zza3 = this.zzgal.zza(new zzbmt(zzcztVar, zzczlVar, null), new zzcbg(new zzcmo(this.zzup, this.zzfod, this.zzfgl, this.zzbli, zzczlVar, zzazlVar, zza2), zza2));
        zzazlVar.set(zza3);
        zzafy.zza(zza2, zza3.zzaev());
        zza3.zzadk().zza(new zzbpe(zza2) { // from class: com.google.android.gms.internal.ads.zzcmj
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
        return zzdgs.zzb(zza, new zzded(this, zza2, zzczlVar, zza3) { // from class: com.google.android.gms.internal.ads.zzcmm
            private final zzczl zzfel;
            private final zzbdi zzfpv;
            private final zzcmi zzgaq;
            private final zzcbd zzgar;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgaq = this;
                this.zzfpv = zza2;
                this.zzfel = zzczlVar;
                this.zzgar = zza3;
            }

            @Override // com.google.android.gms.internal.ads.zzded
            public final Object apply(Object obj2) {
                zzbdi zzbdiVar = this.zzfpv;
                zzczl zzczlVar2 = this.zzfel;
                zzcbd zzcbdVar = this.zzgar;
                if (zzczlVar2.zzdmf) {
                    zzbdiVar.zzaan();
                }
                zzbdiVar.zzzu();
                if (((Boolean) zzve.zzoy().zzd(zzzn.zzciq)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzq.zzks();
                    zzawh.zza(zzbdiVar);
                }
                return zzcbdVar.zzaeu();
            }
        }, this.zzfci);
    }

    @Override // com.google.android.gms.internal.ads.zzcio
    public final boolean zza(zzczt zzcztVar, zzczl zzczlVar) {
        zzczp zzczpVar = zzczlVar.zzglo;
        return (zzczpVar == null || zzczpVar.zzdht == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcio
    public final zzdhe<zzcbb> zzb(final zzczt zzcztVar, final zzczl zzczlVar) {
        final zzccd zzccdVar = new zzccd();
        zzdhe<zzcbb> zzb = zzdgs.zzb(zzdgs.zzaj(null), new zzdgf(this, zzczlVar, zzccdVar, zzcztVar) { // from class: com.google.android.gms.internal.ads.zzcmh
            private final zzczl zzfzk;
            private final zzccd zzfzl;
            private final zzczt zzfzm;
            private final zzcmi zzgaq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgaq = this;
                this.zzfzk = zzczlVar;
                this.zzfzl = zzccdVar;
                this.zzfzm = zzcztVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdgf
            public final zzdhe zzf(Object obj) {
                return this.zzgaq.a(this.zzfzk, this.zzfzl, this.zzfzm, obj);
            }
        }, this.zzfci);
        zzb.addListener(zzcmk.a(zzccdVar), this.zzfci);
        return zzb;
    }
}
