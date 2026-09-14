package com.google.android.gms.internal.ads;

import android.view.ViewGroup;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzcon implements zzdgt<zzbkk> {
    private final /* synthetic */ zzblg zzgcu;
    private final /* synthetic */ zzcoo zzgcv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcon(zzcoo zzcooVar, zzblg zzblgVar) {
        this.zzgcv = zzcooVar;
        this.zzgcu = zzblgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final /* synthetic */ void onSuccess(zzbkk zzbkkVar) {
        zzbkk zzbkkVar2;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        zzbqp zzbqpVar;
        zzbkk zzbkkVar3;
        zzbkk zzbkkVar4 = zzbkkVar;
        synchronized (this.zzgcv) {
            zzcoo.a(this.zzgcv, (zzdhe) null);
            zzbkkVar2 = this.zzgcv.zzgcp;
            if (zzbkkVar2 != null) {
                zzbkkVar3 = this.zzgcv.zzgcp;
                zzbkkVar3.destroy();
            }
            this.zzgcv.zzgcp = zzbkkVar4;
            viewGroup = this.zzgcv.zzfdu;
            viewGroup.removeAllViews();
            viewGroup2 = this.zzgcv.zzfdu;
            viewGroup2.addView(zzbkkVar4.zzaga());
            zzbkkVar4.zzagf();
            zzbqpVar = this.zzgcv.zzgcz;
            zzbqpVar.zzdg(zzbkkVar4.zzage());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void zzb(Throwable th) {
        zzbqp zzbqpVar;
        synchronized (this.zzgcv) {
            zzcoo.a(this.zzgcv, (zzdhe) null);
            this.zzgcu.zzadd().onAdFailedToLoad(zzcfb.zzd(th));
            zzbqpVar = this.zzgcv.zzgcz;
            zzbqpVar.zzdg(60);
            zzdad.zzc(th, "BannerAdManagerShim.onFailure");
        }
    }
}
