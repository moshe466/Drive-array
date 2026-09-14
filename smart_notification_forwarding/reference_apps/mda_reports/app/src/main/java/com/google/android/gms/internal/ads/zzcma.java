package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes.dex */
public final class zzcma implements zzcir<zzcbb, zzani, zzcjy> {
    private final zzcbi zzgal;
    private final Context zzup;

    public zzcma(Context context, zzcbi zzcbiVar) {
        this.zzup = context;
        this.zzgal = zzcbiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void zza(zzczt zzcztVar, zzczl zzczlVar, zzcip<zzani, zzcjy> zzcipVar) {
        try {
            zzcipVar.zzddn.zzdm(zzczlVar.zzdem);
            zzcipVar.zzddn.zza(zzczlVar.zzeif, zzczlVar.zzglr.toString(), zzcztVar.zzgmh.zzfgl.zzgml, ObjectWrapper.wrap(this.zzup), new zzcmb(this, zzcipVar), zzcipVar.zzfyf);
        } catch (RemoteException e) {
            zzdpt.zzl(e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final /* synthetic */ zzcbb zzb(zzczt zzcztVar, zzczl zzczlVar, final zzcip<zzani, zzcjy> zzcipVar) {
        final zzciq zzciqVar = new zzciq(zzczlVar);
        zzcbd zza = this.zzgal.zza(new zzbmt(zzcztVar, zzczlVar, zzcipVar.zzfge), new zzcbg(new zzbuv(zzcipVar, zzciqVar) { // from class: com.google.android.gms.internal.ads.zzclz
            private final zzcip zzfyq;
            private final zzciq zzfzr;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfyq = zzcipVar;
                this.zzfzr = zzciqVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbuv
            public final void zza(boolean z, Context context) {
                zzcip zzcipVar2 = this.zzfyq;
                zzciq zzciqVar2 = this.zzfzr;
                try {
                    if (((zzani) zzcipVar2.zzddn).zzaa(ObjectWrapper.wrap(context))) {
                        zzciqVar2.zzamd();
                    } else {
                        zzayu.zzez("Can't show rewarded video.");
                    }
                } catch (RemoteException e) {
                    zzayu.zzd("Can't show rewarded video.", e);
                }
            }
        }));
        zzciqVar.zza(zza.zzadk());
        zzcipVar.zzfyf.zza(zza.zzaew());
        return zza.zzaeu();
    }
}
