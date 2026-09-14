package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzbkv implements zzdxg<zzbsu<zzbqb>> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzazb> zzfav;
    private final zzdxp<zzczl> zzfda;
    private final zzbkn zzfen;
    private final zzdxp<zzczu> zzfep;

    public zzbkv(zzbkn zzbknVar, zzdxp<Context> zzdxpVar, zzdxp<zzazb> zzdxpVar2, zzdxp<zzczl> zzdxpVar3, zzdxp<zzczu> zzdxpVar4) {
        this.zzfen = zzbknVar;
        this.zzejv = zzdxpVar;
        this.zzfav = zzdxpVar2;
        this.zzfda = zzdxpVar3;
        this.zzfep = zzdxpVar4;
    }

    public static zzbsu<zzbqb> zza(zzbkn zzbknVar, final Context context, final zzazb zzazbVar, final zzczl zzczlVar, final zzczu zzczuVar) {
        return (zzbsu) zzdxm.zza(new zzbsu(new zzbqb(context, zzazbVar, zzczlVar, zzczuVar) { // from class: com.google.android.gms.internal.ads.zzbkq
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

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zza(this.zzfen, this.zzejv.get(), this.zzfav.get(), this.zzfda.get(), this.zzfep.get());
    }
}
