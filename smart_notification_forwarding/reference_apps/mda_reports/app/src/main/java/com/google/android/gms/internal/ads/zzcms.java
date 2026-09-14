package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcms implements zzcir<zzcbb, zzdac, zzcjx> {
    private final Executor zzfci;
    private final zzcbi zzgal;
    private final Context zzup;

    public zzcms(Context context, Executor executor, zzcbi zzcbiVar) {
        this.zzup = context;
        this.zzfci = executor;
        this.zzgal = zzcbiVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzc(zzczt zzcztVar, zzczl zzczlVar, zzcip<zzdac, zzcjx> zzcipVar) {
        try {
            zzcipVar.zzddn.zza(zzcztVar.zzgmh.zzfgl.zzgml, zzczlVar.zzglr.toString());
        } catch (Exception e) {
            String valueOf = String.valueOf(zzcipVar.zzfge);
            zzayu.zzd(valueOf.length() != 0 ? "Fail to load ad from adapter ".concat(valueOf) : new String("Fail to load ad from adapter "), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void zza(zzczt zzcztVar, zzczl zzczlVar, zzcip<zzdac, zzcjx> zzcipVar) {
        if (zzcipVar.zzddn.isInitialized()) {
            zzc(zzcztVar, zzczlVar, zzcipVar);
            return;
        }
        zzcipVar.zzfyf.zza(new zzcmu(this, zzcztVar, zzczlVar, zzcipVar));
        zzcipVar.zzddn.zza(this.zzup, zzcztVar.zzgmh.zzfgl.zzgml, (String) null, zzcipVar.zzfyf, zzczlVar.zzglr.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final /* synthetic */ zzcbb zzb(zzczt zzcztVar, zzczl zzczlVar, final zzcip<zzdac, zzcjx> zzcipVar) {
        zzcbd zza = this.zzgal.zza(new zzbmt(zzcztVar, zzczlVar, zzcipVar.zzfge), new zzcbg(new zzbuv(zzcipVar) { // from class: com.google.android.gms.internal.ads.zzcmr
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
                    ((zzdac) zzcipVar2.zzddn).showVideo();
                } catch (zzdab e) {
                    zzayu.zzd("Cannot show rewarded video.", e);
                }
            }
        }));
        zza.zzadh().zza((zzbpg) new zzbiu(zzcipVar.zzddn), this.zzfci);
        zzbpm zzadi = zza.zzadi();
        zzboq zzadj = zza.zzadj();
        zzcipVar.zzfyf.zza(new zzcmw(this, zza.zzaen(), zzadj, zzadi, zza.zzaev()));
        return zza.zzaeu();
    }
}
