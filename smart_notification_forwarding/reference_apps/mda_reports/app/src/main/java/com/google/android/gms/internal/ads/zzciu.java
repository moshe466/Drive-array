package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzciu implements zzcio<zzbke> {
    private final Executor zzfci;
    private final zzczu zzfgl;
    private final zzcbn zzfod;
    private final zzbka zzfyh;
    private final Context zzup;

    public zzciu(zzbka zzbkaVar, Context context, Executor executor, zzcbn zzcbnVar, zzczu zzczuVar) {
        this.zzup = context;
        this.zzfyh = zzbkaVar;
        this.zzfci = executor;
        this.zzfod = zzcbnVar;
        this.zzfgl = zzczuVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdhe a(zzczt zzcztVar, zzczl zzczlVar, Object obj) {
        zzuj zza = zzczy.zza(this.zzup, zzczlVar.zzglq);
        final zzbdi zzc = this.zzfod.zzc(zza);
        final zzbjt zza2 = this.zzfyh.zza(new zzbmt(zzcztVar, zzczlVar, null), new zzbjw(zzc.getView(), zzc, zzczy.zze(zza), zzczlVar.zzfdp));
        zza2.zzadx().zzb(zzc, false);
        zza2.zzadk().zza(new zzbpe(zzc) { // from class: com.google.android.gms.internal.ads.zzciw
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
        return zzdgs.zzb(zzcbp.zza(zzc, zzczpVar.zzdhr, zzczpVar.zzdht), new zzded(zza2) { // from class: com.google.android.gms.internal.ads.zzciv
            private final zzbjt zzfyi;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfyi = zza2;
            }

            @Override // com.google.android.gms.internal.ads.zzded
            public final Object apply(Object obj2) {
                return this.zzfyi.zzadw();
            }
        }, zzazd.zzdwj);
    }

    @Override // com.google.android.gms.internal.ads.zzcio
    public final boolean zza(zzczt zzcztVar, zzczl zzczlVar) {
        zzczp zzczpVar = zzczlVar.zzglo;
        return (zzczpVar == null || zzczpVar.zzdht == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcio
    public final zzdhe<zzbke> zzb(final zzczt zzcztVar, final zzczl zzczlVar) {
        return zzdgs.zzb(zzdgs.zzaj(null), new zzdgf(this, zzcztVar, zzczlVar) { // from class: com.google.android.gms.internal.ads.zzcit
            private final zzczl zzfel;
            private final zzczt zzfot;
            private final zzciu zzfyg;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfyg = this;
                this.zzfot = zzcztVar;
                this.zzfel = zzczlVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdgf
            public final zzdhe zzf(Object obj) {
                return this.zzfyg.a(this.zzfot, this.zzfel, obj);
            }
        }, this.zzfci);
    }
}
