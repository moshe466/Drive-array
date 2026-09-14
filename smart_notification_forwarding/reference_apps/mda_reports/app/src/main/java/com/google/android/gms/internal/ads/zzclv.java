package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzclv implements zzcir<zzcbb, zzdac, zzcjy> {
    private final Executor zzfci;
    private final zzcbi zzgal;
    private final Context zzup;

    public zzclv(Context context, Executor executor, zzcbi zzcbiVar) {
        this.zzup = context;
        this.zzfci = executor;
        this.zzgal = zzcbiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void zza(zzczt zzcztVar, zzczl zzczlVar, zzcip<zzdac, zzcjy> zzcipVar) {
        try {
            zzcipVar.zzddn.zzb(this.zzup, zzcztVar.zzgmh.zzfgl.zzgml, zzczlVar.zzglr.toString(), zzcipVar.zzfyf);
        } catch (Exception e) {
            String valueOf = String.valueOf(zzcipVar.zzfge);
            zzayu.zzd(valueOf.length() != 0 ? "Fail to load ad from adapter ".concat(valueOf) : new String("Fail to load ad from adapter "), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final /* synthetic */ zzcbb zzb(zzczt zzcztVar, zzczl zzczlVar, final zzcip<zzdac, zzcjy> zzcipVar) {
        zzcbd zza = this.zzgal.zza(new zzbmt(zzcztVar, zzczlVar, zzcipVar.zzfge), new zzcbg(new zzbuv(zzcipVar) { // from class: com.google.android.gms.internal.ads.zzcly
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
                    ((zzdac) zzcipVar2.zzddn).zzcb(context);
                } catch (zzdab e) {
                    zzayu.zzd("Cannot show rewarded .", e);
                }
            }
        }));
        zza.zzadh().zza((zzbpg) new zzbiu(zzcipVar.zzddn), this.zzfci);
        zzcipVar.zzfyf.zza(zza.zzaew());
        return zza.zzaeu();
    }
}
