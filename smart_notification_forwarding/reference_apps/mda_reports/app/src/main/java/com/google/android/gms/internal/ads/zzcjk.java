package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes.dex */
public final class zzcjk implements zzcir<zzbkk, zzani, zzcjy> {
    private View view;
    private final zzblg zzfyj;
    private final Context zzup;

    public zzcjk(Context context, zzblg zzblgVar) {
        this.zzup = context;
        this.zzfyj = zzblgVar;
    }

    public static final /* synthetic */ zzxb a(zzcip zzcipVar) {
        try {
            return ((zzani) zzcipVar.zzddn).getVideoController();
        } catch (RemoteException e) {
            throw new zzdab(e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void zza(zzczt zzcztVar, zzczl zzczlVar, zzcip<zzani, zzcjy> zzcipVar) {
        try {
            zzcipVar.zzddn.zzdm(zzczlVar.zzdem);
            zzcipVar.zzddn.zza(zzczlVar.zzeif, zzczlVar.zzglr.toString(), zzcztVar.zzgmh.zzfgl.zzgml, ObjectWrapper.wrap(this.zzup), new zzcjl(this, zzcipVar), zzcipVar.zzfyf, zzcztVar.zzgmh.zzfgl.zzblm);
        } catch (RemoteException e) {
            throw new zzdab(e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final /* synthetic */ zzbkk zzb(zzczt zzcztVar, zzczl zzczlVar, zzcip<zzani, zzcjy> zzcipVar) {
        zzbkj zza = this.zzfyj.zza(new zzbmt(zzcztVar, zzczlVar, zzcipVar.zzfge), new zzbkn(this.view, null, new zzbme(zzcipVar) { // from class: com.google.android.gms.internal.ads.zzcjj
            private final zzcip zzfyq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfyq = zzcipVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbme
            public final zzxb getVideoController() {
                return zzcjk.a(this.zzfyq);
            }
        }, zzczlVar.zzglq.get(0)));
        zza.zzaei().zzq(this.view);
        zzcipVar.zzfyf.zza(zza.zzadm());
        return zza.zzaeh();
    }
}
