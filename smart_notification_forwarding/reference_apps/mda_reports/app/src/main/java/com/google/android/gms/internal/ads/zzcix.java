package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcix implements zzcio<zzbkk> {
    private final Executor zzfci;
    private final zzczu zzfgl;
    private final zzcbn zzfod;
    private final zzblg zzfyj;
    private final zzded<zzczl, zzawt> zzfyk;
    private final Context zzup;

    public zzcix(zzblg zzblgVar, Context context, Executor executor, zzcbn zzcbnVar, zzczu zzczuVar, zzded<zzczl, zzawt> zzdedVar) {
        this.zzup = context;
        this.zzfyj = zzblgVar;
        this.zzfci = executor;
        this.zzfod = zzcbnVar;
        this.zzfgl = zzczuVar;
        this.zzfyk = zzdedVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdhe a(zzczt zzcztVar, zzczl zzczlVar, Object obj) {
        zzuj zza = zzczy.zza(this.zzup, zzczlVar.zzglq);
        final zzbdi zzc = this.zzfod.zzc(zza);
        zzc.zzba(zzczlVar.zzdll);
        zzblg zzblgVar = this.zzfyj;
        zzbmt zzbmtVar = new zzbmt(zzcztVar, zzczlVar, null);
        zzcce zzcceVar = new zzcce(this.zzup, zzc.getView(), this.zzfyk.apply(zzczlVar));
        zzc.getClass();
        final zzbkj zza2 = zzblgVar.zza(zzbmtVar, new zzbkn(zzcceVar, zzc, zzciz.a(zzc), zzczy.zze(zza)));
        zza2.zzadx().zzb(zzc, false);
        zza2.zzadk().zza(new zzbpe(zzc) { // from class: com.google.android.gms.internal.ads.zzcjc
            private final zzbdi zzehp;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzehp = zzc;
            }

            @Override // com.google.android.gms.internal.ads.zzbpe
            public final void onAdImpression() {
                zzbdi zzbdiVar = this.zzehp;
                if (zzbdiVar.zzaaa() != null) {
                    zzbdiVar.zzaaa().zzaaz();
                }
            }
        }, zzazd.zzdwj);
        zza2.zzadx();
        zzczp zzczpVar = zzczlVar.zzglo;
        zzdhe<?> zza3 = zzcbp.zza(zzc, zzczpVar.zzdhr, zzczpVar.zzdht);
        if (zzczlVar.zzdmf) {
            zzc.getClass();
            zza3.addListener(zzcjb.a(zzc), this.zzfci);
        }
        zza3.addListener(new Runnable(this, zzc) { // from class: com.google.android.gms.internal.ads.zzcje
            private final zzbdi zzfpv;
            private final zzcix zzfym;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfym = this;
                this.zzfpv = zzc;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzfym.a(this.zzfpv);
            }
        }, this.zzfci);
        return zzdgs.zzb(zza3, new zzded(zza2) { // from class: com.google.android.gms.internal.ads.zzcjd
            private final zzbkj zzfyn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfyn = zza2;
            }

            @Override // com.google.android.gms.internal.ads.zzded
            public final Object apply(Object obj2) {
                return this.zzfyn.zzaeh();
            }
        }, zzazd.zzdwj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzbdi zzbdiVar) {
        zzbdiVar.zzzu();
        zzbed zzyl = zzbdiVar.zzyl();
        zzyw zzywVar = this.zzfgl.zzgmk;
        if (zzywVar == null || zzyl == null) {
            return;
        }
        zzyl.zzb(zzywVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcio
    public final boolean zza(zzczt zzcztVar, zzczl zzczlVar) {
        zzczp zzczpVar = zzczlVar.zzglo;
        return (zzczpVar == null || zzczpVar.zzdht == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcio
    public final zzdhe<zzbkk> zzb(final zzczt zzcztVar, final zzczl zzczlVar) {
        return zzdgs.zzb(zzdgs.zzaj(null), new zzdgf(this, zzcztVar, zzczlVar) { // from class: com.google.android.gms.internal.ads.zzcja
            private final zzczl zzfel;
            private final zzczt zzfot;
            private final zzcix zzfym;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfym = this;
                this.zzfot = zzcztVar;
                this.zzfel = zzczlVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdgf
            public final zzdhe zzf(Object obj) {
                return this.zzfym.a(this.zzfot, this.zzfel, obj);
            }
        }, this.zzfci);
    }
}
