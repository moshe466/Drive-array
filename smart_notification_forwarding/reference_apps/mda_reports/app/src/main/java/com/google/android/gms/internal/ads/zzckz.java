package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzckz implements zzcir<zzbwk, zzdac, zzcjy> {
    private final Executor zzfci;
    private final zzbvm zzfzt;
    private final Context zzup;

    public zzckz(Context context, zzbvm zzbvmVar, Executor executor) {
        this.zzup = context;
        this.zzfzt = zzbvmVar;
        this.zzfci = executor;
    }

    private static boolean zza(zzczt zzcztVar, int i) {
        return zzcztVar.zzgmh.zzfgl.zzgmn.contains(Integer.toString(i));
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void zza(zzczt zzcztVar, zzczl zzczlVar, zzcip<zzdac, zzcjy> zzcipVar) {
        zzdac zzdacVar = zzcipVar.zzddn;
        Context context = this.zzup;
        zzug zzugVar = zzcztVar.zzgmh.zzfgl.zzgml;
        String jSONObject = zzczlVar.zzglr.toString();
        String zza = zzaxs.zza(zzczlVar.zzglo);
        zzcjy zzcjyVar = zzcipVar.zzfyf;
        zzczu zzczuVar = zzcztVar.zzgmh.zzfgl;
        zzdacVar.zza(context, zzugVar, jSONObject, zza, zzcjyVar, zzczuVar.zzddz, zzczuVar.zzgmn);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final /* synthetic */ zzbwk zzb(zzczt zzcztVar, zzczl zzczlVar, zzcip<zzdac, zzcjy> zzcipVar) {
        zzbws zza;
        zzall zzsl = zzcipVar.zzddn.zzsl();
        zzalq zzsm = zzcipVar.zzddn.zzsm();
        zzalr zzsr = zzcipVar.zzddn.zzsr();
        if (zzsr != null && zza(zzcztVar, 6)) {
            zza = zzbws.zzb(zzsr);
        } else if (zzsl != null && zza(zzcztVar, 6)) {
            zza = zzbws.zzb(zzsl);
        } else if (zzsl != null && zza(zzcztVar, 2)) {
            zza = zzbws.zza(zzsl);
        } else if (zzsm != null && zza(zzcztVar, 6)) {
            zza = zzbws.zzb(zzsm);
        } else {
            if (zzsm == null || !zza(zzcztVar, 1)) {
                throw new zzclr("No native ad mappers", 0);
            }
            zza = zzbws.zza(zzsm);
        }
        if (!zzcztVar.zzgmh.zzfgl.zzgmn.contains(Integer.toString(zza.zzaja()))) {
            throw new zzclr("No corresponding native ad listener", 0);
        }
        zzbwt zza2 = this.zzfzt.zza(new zzbmt(zzcztVar, zzczlVar, zzcipVar.zzfge), new zzbxe(zza), new zzbyg(zzsm, zzsl, zzsr));
        zzcipVar.zzfyf.zza(zza2.zzadm());
        zza2.zzadh().zza((zzbpg) new zzbiu(zzcipVar.zzddn), this.zzfci);
        return zza2.zzadn();
    }
}
