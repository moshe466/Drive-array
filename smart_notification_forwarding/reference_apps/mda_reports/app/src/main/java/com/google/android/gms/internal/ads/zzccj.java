package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzccj implements zzdxg<zzsm> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<Integer> zzfdc;
    private final zzdxp<zzazb> zzfhn;
    private final zzdxp<String> zzfrr;
    private final zzdxp<String> zzfrs;

    private zzccj(zzdxp<Context> zzdxpVar, zzdxp<String> zzdxpVar2, zzdxp<zzazb> zzdxpVar3, zzdxp<Integer> zzdxpVar4, zzdxp<String> zzdxpVar5) {
        this.zzejv = zzdxpVar;
        this.zzfrr = zzdxpVar2;
        this.zzfhn = zzdxpVar3;
        this.zzfdc = zzdxpVar4;
        this.zzfrs = zzdxpVar5;
    }

    public static zzccj zze(zzdxp<Context> zzdxpVar, zzdxp<String> zzdxpVar2, zzdxp<zzazb> zzdxpVar3, zzdxp<Integer> zzdxpVar4, zzdxp<String> zzdxpVar5) {
        return new zzccj(zzdxpVar, zzdxpVar2, zzdxpVar3, zzdxpVar4, zzdxpVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        Context context = this.zzejv.get();
        final String str = this.zzfrr.get();
        zzazb zzazbVar = this.zzfhn.get();
        final int intValue = this.zzfdc.get().intValue();
        final String str2 = this.zzfrs.get();
        zzsm zzsmVar = new zzsm(new zzsr(context));
        final zztt zzttVar = new zztt();
        zzttVar.zzcam = Integer.valueOf(zzazbVar.zzdvz);
        zzttVar.zzcan = Integer.valueOf(zzazbVar.zzdwa);
        zzttVar.zzcao = Integer.valueOf(zzazbVar.zzdwb ? 0 : 2);
        zzsmVar.zza(new zzsp(intValue, str, zzttVar, str2) { // from class: com.google.android.gms.internal.ads.zzcck
            private final String zzcyr;
            private final int zzdvv;
            private final zztt zzfrt;
            private final String zzfru;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdvv = intValue;
                this.zzcyr = str;
                this.zzfrt = zzttVar;
                this.zzfru = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzsp
            public final void zza(zztu zztuVar) {
                int i = this.zzdvv;
                String str3 = this.zzcyr;
                zztt zzttVar2 = this.zzfrt;
                String str4 = this.zzfru;
                zztuVar.zzcay.zzbzt = Integer.valueOf(i);
                zzts zztsVar = zztuVar.zzcav;
                zztsVar.zzcae = str3;
                zztsVar.zzcah = zzttVar2;
                zztuVar.zzcaq = str4;
            }
        });
        return (zzsm) zzdxm.zza(zzsmVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
