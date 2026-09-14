package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzbnz implements zzdxg<zzded<zzczl, zzawt>> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzazb> zzfav;
    private final zzdxp<zzczu> zzfep;

    public zzbnz(zzdxp<Context> zzdxpVar, zzdxp<zzazb> zzdxpVar2, zzdxp<zzczu> zzdxpVar3) {
        this.zzejv = zzdxpVar;
        this.zzfav = zzdxpVar2;
        this.zzfep = zzdxpVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        final Context context = this.zzejv.get();
        final zzazb zzazbVar = this.zzfav.get();
        final zzczu zzczuVar = this.zzfep.get();
        return (zzded) zzdxm.zza(new zzded(context, zzazbVar, zzczuVar) { // from class: com.google.android.gms.internal.ads.zzboa
            private final Context zzcri;
            private final zzazb zzfek;
            private final zzczu zzfhd;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcri = context;
                this.zzfek = zzazbVar;
                this.zzfhd = zzczuVar;
            }

            @Override // com.google.android.gms.internal.ads.zzded
            public final Object apply(Object obj) {
                Context context2 = this.zzcri;
                zzazb zzazbVar2 = this.zzfek;
                zzczu zzczuVar2 = this.zzfhd;
                zzczl zzczlVar = (zzczl) obj;
                zzawt zzawtVar = new zzawt(context2);
                zzawtVar.zzeo(zzczlVar.zzdkp);
                zzawtVar.zzep(zzczlVar.zzglt.toString());
                zzawtVar.zzx(zzazbVar2.zzbma);
                zzawtVar.setAdUnitId(zzczuVar2.zzgmm);
                return zzawtVar;
            }
        }, "Cannot return null from a non-@Nullable @Provides method");
    }
}
