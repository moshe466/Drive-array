package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzbtz implements zzdxg<zzbsu<zzbqb>> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzazb> zzfav;
    private final zzdxp<zzczl> zzfda;
    private final zzdxp<zzczu> zzfep;
    private final zzbtv zzfje;

    private zzbtz(zzbtv zzbtvVar, zzdxp<Context> zzdxpVar, zzdxp<zzazb> zzdxpVar2, zzdxp<zzczl> zzdxpVar3, zzdxp<zzczu> zzdxpVar4) {
        this.zzfje = zzbtvVar;
        this.zzejv = zzdxpVar;
        this.zzfav = zzdxpVar2;
        this.zzfda = zzdxpVar3;
        this.zzfep = zzdxpVar4;
    }

    public static zzbtz zza(zzbtv zzbtvVar, zzdxp<Context> zzdxpVar, zzdxp<zzazb> zzdxpVar2, zzdxp<zzczl> zzdxpVar3, zzdxp<zzczu> zzdxpVar4) {
        return new zzbtz(zzbtvVar, zzdxpVar, zzdxpVar2, zzdxpVar3, zzdxpVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        final Context context = this.zzejv.get();
        final zzazb zzazbVar = this.zzfav.get();
        final zzczl zzczlVar = this.zzfda.get();
        final zzczu zzczuVar = this.zzfep.get();
        return (zzbsu) zzdxm.zza(new zzbsu(new zzbqb(context, zzazbVar, zzczlVar, zzczuVar) { // from class: com.google.android.gms.internal.ads.zzbty
            private final Context zzcri;
            private final zzazb zzfek;
            private final zzczl zzfel;
            private final zzczu zzfem;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcri = context;
                this.zzfek = zzazbVar;
                this.zzfel = zzczlVar;
                this.zzfem = zzczuVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbqb
            public final void onAdLoaded() {
                com.google.android.gms.ads.internal.zzq.zzla().zzb(this.zzcri, this.zzfek.zzbma, this.zzfel.zzglt.toString(), this.zzfem.zzgmm);
            }
        }, zzazd.zzdwj), "Cannot return null from a non-@Nullable @Provides method");
    }
}
