package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;

/* loaded from: classes.dex */
final class zzcki implements zzbuv {
    private final zzazb zzbli;
    private final zzczl zzfmp;
    private final zzdhe<zzbtw> zzfzp;
    private final zzbdi zzfzq;
    private final Context zzup;

    private zzcki(Context context, zzazb zzazbVar, zzdhe<zzbtw> zzdheVar, zzczl zzczlVar, zzbdi zzbdiVar) {
        this.zzup = context;
        this.zzbli = zzazbVar;
        this.zzfzp = zzdheVar;
        this.zzfmp = zzczlVar;
        this.zzfzq = zzbdiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbuv
    public final void zza(boolean z, Context context) {
        zzbtw zzbtwVar = (zzbtw) zzdgs.zzc(this.zzfzp);
        this.zzfzq.zzax(true);
        com.google.android.gms.ads.internal.zzq.zzkq();
        com.google.android.gms.ads.internal.zzg zzgVar = new com.google.android.gms.ads.internal.zzg(false, zzawb.zzbb(this.zzup), false, 0.0f, -1, z, this.zzfmp.zzglv, false);
        com.google.android.gms.ads.internal.zzq.zzkp();
        zzbun zzaeo = zzbtwVar.zzaeo();
        zzbdi zzbdiVar = this.zzfzq;
        zzczl zzczlVar = this.zzfmp;
        int i = zzczlVar.zzglw;
        zzazb zzazbVar = this.zzbli;
        String str = zzczlVar.zzdkp;
        zzczp zzczpVar = zzczlVar.zzglo;
        com.google.android.gms.ads.internal.overlay.zzn.zza(context, new AdOverlayInfoParcel((zzty) null, zzaeo, (com.google.android.gms.ads.internal.overlay.zzt) null, zzbdiVar, i, zzazbVar, str, zzgVar, zzczpVar.zzdhr, zzczpVar.zzdht), true);
    }
}
