package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcjf implements zzcir<zzbkk, zzdac, zzcjy> {
    private final zzazb zzbli;
    private final Executor zzfci;
    private final zzblg zzfyj;
    private final Context zzup;

    public zzcjf(Context context, zzazb zzazbVar, zzblg zzblgVar, Executor executor) {
        this.zzup = context;
        this.zzbli = zzazbVar;
        this.zzfyj = zzblgVar;
        this.zzfci = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void zza(zzczt zzcztVar, zzczl zzczlVar, zzcip<zzdac, zzcjy> zzcipVar) {
        zzuj zzujVar = zzcztVar.zzgmh.zzfgl.zzblm;
        zzuj zzujVar2 = zzujVar.zzccv ? new zzuj(this.zzup, com.google.android.gms.ads.zzb.zza(zzujVar.width, zzujVar.height)) : zzczy.zza(this.zzup, zzczlVar.zzglq);
        if (this.zzbli.zzdwa < 4100000) {
            zzcipVar.zzddn.zza(this.zzup, zzujVar2, zzcztVar.zzgmh.zzfgl.zzgml, zzczlVar.zzglr.toString(), zzcipVar.zzfyf);
        } else {
            zzcipVar.zzddn.zza(this.zzup, zzujVar2, zzcztVar.zzgmh.zzfgl.zzgml, zzczlVar.zzglr.toString(), zzaxs.zza(zzczlVar.zzglo), zzcipVar.zzfyf);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final /* synthetic */ zzbkk zzb(zzczt zzcztVar, zzczl zzczlVar, zzcip<zzdac, zzcjy> zzcipVar) {
        zzblg zzblgVar = this.zzfyj;
        zzbmt zzbmtVar = new zzbmt(zzcztVar, zzczlVar, zzcipVar.zzfge);
        View view = zzcipVar.zzddn.getView();
        zzdac zzdacVar = zzcipVar.zzddn;
        zzdacVar.getClass();
        zzbkj zza = zzblgVar.zza(zzbmtVar, new zzbkn(view, null, zzcji.a(zzdacVar), zzczlVar.zzglq.get(0)));
        zza.zzaei().zzq(zzcipVar.zzddn.getView());
        zza.zzadh().zza((zzbpg) new zzbiu(zzcipVar.zzddn), this.zzfci);
        zzcipVar.zzfyf.zza(zza.zzadm());
        return zza.zzaeh();
    }
}
