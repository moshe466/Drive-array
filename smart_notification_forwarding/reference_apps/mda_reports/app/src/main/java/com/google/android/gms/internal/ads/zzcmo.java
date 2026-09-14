package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;

/* loaded from: classes.dex */
final class zzcmo implements zzbuv {
    private final zzazb zzbli;
    private final zzczl zzffc;
    private final zzczu zzfgl;
    private final zzcbn zzfod;
    private final zzdhe<zzcbd> zzfzp;
    private final zzbdi zzgas;
    private final Context zzup;

    private zzcmo(Context context, zzcbn zzcbnVar, zzczu zzczuVar, zzazb zzazbVar, zzczl zzczlVar, zzdhe<zzcbd> zzdheVar, zzbdi zzbdiVar) {
        this.zzup = context;
        this.zzfod = zzcbnVar;
        this.zzfgl = zzczuVar;
        this.zzbli = zzazbVar;
        this.zzffc = zzczlVar;
        this.zzfzp = zzdheVar;
        this.zzgas = zzbdiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbuv
    public final void zza(boolean z, Context context) {
        zzbdi zzbdiVar;
        zzcbd zzcbdVar = (zzcbd) zzdgs.zzc(this.zzfzp);
        try {
            zzczl zzczlVar = this.zzffc;
            if (this.zzgas.zzaap()) {
                if (((Boolean) zzve.zzoy().zzd(zzzn.zzciu)).booleanValue()) {
                    final zzbdi zzc = this.zzfod.zzc(this.zzfgl.zzblm);
                    zzafy.zza(zzc, zzcbdVar.zzaev());
                    final zzccd zzccdVar = new zzccd();
                    zzccdVar.zza(this.zzup, zzc.getView());
                    zzcbdVar.zzadx().zzb(zzc, true);
                    zzc.zzaaa().zza(new zzbeu(zzccdVar, zzc) { // from class: com.google.android.gms.internal.ads.zzcmn
                        private final zzbdi zzfpv;
                        private final zzccd zzfzn;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzfzn = zzccdVar;
                            this.zzfpv = zzc;
                        }

                        @Override // com.google.android.gms.internal.ads.zzbeu
                        public final void zzak(boolean z2) {
                            zzccd zzccdVar2 = this.zzfzn;
                            zzbdi zzbdiVar2 = this.zzfpv;
                            zzccdVar2.zzakx();
                            zzbdiVar2.zzzu();
                            zzbdiVar2.zzaaa().zzaaz();
                        }
                    });
                    zzbev zzaaa = zzc.zzaaa();
                    zzc.getClass();
                    zzaaa.zza(zzcmq.a(zzc));
                    zzc.zzb(zzczlVar.zzglo.zzdhr, zzczlVar.zzglo.zzdht, null);
                    zzbdiVar = zzc;
                    zzbdiVar.zzax(true);
                    com.google.android.gms.ads.internal.zzq.zzkq();
                    boolean zzbb = zzawb.zzbb(this.zzup);
                    zzczl zzczlVar2 = this.zzffc;
                    com.google.android.gms.ads.internal.zzg zzgVar = new com.google.android.gms.ads.internal.zzg(false, zzbb, false, 0.0f, -1, z, zzczlVar2.zzglv, zzczlVar2.zzblf);
                    com.google.android.gms.ads.internal.zzq.zzkp();
                    zzbun zzaeo = zzcbdVar.zzaeo();
                    zzczl zzczlVar3 = this.zzffc;
                    int i = zzczlVar3.zzglw;
                    zzazb zzazbVar = this.zzbli;
                    String str = zzczlVar3.zzdkp;
                    zzczp zzczpVar = zzczlVar3.zzglo;
                    com.google.android.gms.ads.internal.overlay.zzn.zza(context, new AdOverlayInfoParcel((zzty) null, zzaeo, (com.google.android.gms.ads.internal.overlay.zzt) null, zzbdiVar, i, zzazbVar, str, zzgVar, zzczpVar.zzdhr, zzczpVar.zzdht), true);
                }
            }
            zzbdiVar = this.zzgas;
            zzbdiVar.zzax(true);
            com.google.android.gms.ads.internal.zzq.zzkq();
            boolean zzbb2 = zzawb.zzbb(this.zzup);
            zzczl zzczlVar22 = this.zzffc;
            com.google.android.gms.ads.internal.zzg zzgVar2 = new com.google.android.gms.ads.internal.zzg(false, zzbb2, false, 0.0f, -1, z, zzczlVar22.zzglv, zzczlVar22.zzblf);
            com.google.android.gms.ads.internal.zzq.zzkp();
            zzbun zzaeo2 = zzcbdVar.zzaeo();
            zzczl zzczlVar32 = this.zzffc;
            int i2 = zzczlVar32.zzglw;
            zzazb zzazbVar2 = this.zzbli;
            String str2 = zzczlVar32.zzdkp;
            zzczp zzczpVar2 = zzczlVar32.zzglo;
            com.google.android.gms.ads.internal.overlay.zzn.zza(context, new AdOverlayInfoParcel((zzty) null, zzaeo2, (com.google.android.gms.ads.internal.overlay.zzt) null, zzbdiVar, i2, zzazbVar2, str2, zzgVar2, zzczpVar2.zzdhr, zzczpVar2.zzdht), true);
        } catch (zzbdv e) {
            zzayu.zzc("", e);
        }
    }
}
