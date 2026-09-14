package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes.dex */
public final class zzclb implements zzcir<zzbwk, zzani, zzcjy> {
    private final zzbvm zzfzt;
    private zzalr zzfzx;
    private final Context zzup;

    public zzclb(Context context, zzbvm zzbvmVar) {
        this.zzup = context;
        this.zzfzt = zzbvmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void zza(zzczt zzcztVar, zzczl zzczlVar, zzcip<zzani, zzcjy> zzcipVar) {
        try {
            zzcipVar.zzddn.zzdm(zzczlVar.zzdem);
            zzcipVar.zzddn.zza(zzczlVar.zzeif, zzczlVar.zzglr.toString(), zzcztVar.zzgmh.zzfgl.zzgml, ObjectWrapper.wrap(this.zzup), new zzcld(this, zzcipVar), zzcipVar.zzfyf);
        } catch (RemoteException e) {
            throw new zzdab(e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final /* synthetic */ zzbwk zzb(zzczt zzcztVar, zzczl zzczlVar, zzcip<zzani, zzcjy> zzcipVar) {
        if (!zzcztVar.zzgmh.zzfgl.zzgmn.contains(Integer.toString(6))) {
            throw new zzclr("Unified must be used for RTB.", 1);
        }
        zzbws zzb = zzbws.zzb(this.zzfzx);
        if (!zzcztVar.zzgmh.zzfgl.zzgmn.contains(Integer.toString(zzb.zzaja()))) {
            throw new zzclr("No corresponding native ad listener", 0);
        }
        zzbwt zza = this.zzfzt.zza(new zzbmt(zzcztVar, zzczlVar, zzcipVar.zzfge), new zzbxe(zzb), new zzbyg(null, null, this.zzfzx));
        zzcipVar.zzfyf.zza(zza.zzadm());
        return zza.zzadn();
    }
}
