package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes.dex */
public final class zzckl implements zzcir<zzbtu, zzani, zzcjy> {
    private final zzbup zzfyt;
    private final Context zzup;

    public zzckl(Context context, zzbup zzbupVar) {
        this.zzup = context;
        this.zzfyt = zzbupVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void zza(zzczt zzcztVar, zzczl zzczlVar, zzcip<zzani, zzcjy> zzcipVar) {
        try {
            zzcipVar.zzddn.zzdm(zzczlVar.zzdem);
            zzcipVar.zzddn.zza(zzczlVar.zzeif, zzczlVar.zzglr.toString(), zzcztVar.zzgmh.zzfgl.zzgml, ObjectWrapper.wrap(this.zzup), new zzckq(this, zzcipVar), zzcipVar.zzfyf);
        } catch (RemoteException e) {
            throw new zzdab(e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final /* synthetic */ zzbtu zzb(zzczt zzcztVar, zzczl zzczlVar, final zzcip<zzani, zzcjy> zzcipVar) {
        final zzciq zzciqVar = new zzciq(zzczlVar);
        zzbtw zza = this.zzfyt.zza(new zzbmt(zzcztVar, zzczlVar, zzcipVar.zzfge), new zzbtv(new zzbuv(zzcipVar, zzciqVar) { // from class: com.google.android.gms.internal.ads.zzcko
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
                    if (((zzani) zzcipVar2.zzddn).zzz(ObjectWrapper.wrap(context))) {
                        zzciqVar2.zzamd();
                    } else {
                        zzayu.zzez("Cannot show interstitial.");
                    }
                } catch (RemoteException e) {
                    zzayu.zzd("Cannot show interstitial.", e);
                }
            }
        }));
        zzciqVar.zza(zza.zzadk());
        zzcipVar.zzfyf.zza(zza.zzadm());
        return zza.zzaem();
    }
}
