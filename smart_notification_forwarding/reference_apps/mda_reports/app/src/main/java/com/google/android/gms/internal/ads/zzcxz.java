package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class zzcxz extends AdMetadataListener implements zzbov, zzbow, zzbpa, zzbqb, zzcxq {
    private final zzdax zzgjf;
    private final AtomicReference<AdMetadataListener> zzgkj = new AtomicReference<>();
    private final AtomicReference<zzaso> zzgkk = new AtomicReference<>();
    private final AtomicReference<zzasl> zzgkl = new AtomicReference<>();
    private final AtomicReference<zzaro> zzgkm = new AtomicReference<>();
    private final AtomicReference<zzast> zzgkn = new AtomicReference<>();
    private final AtomicReference<zzarj> zzgko = new AtomicReference<>();
    private zzcxz zzgkp = null;

    public zzcxz(zzdax zzdaxVar) {
        this.zzgjf = zzdaxVar;
    }

    public static zzcxz zza(zzcxz zzcxzVar) {
        zzcxz zzcxzVar2 = new zzcxz(zzcxzVar.zzgjf);
        zzcxzVar2.zzb(zzcxzVar);
        return zzcxzVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onAdClosed() {
        zzcxz zzcxzVar = this;
        while (true) {
            zzcxz zzcxzVar2 = zzcxzVar.zzgkp;
            if (zzcxzVar2 == null) {
                zzcxzVar.zzgjf.onAdClosed();
                zzcxp.zza(zzcxzVar.zzgkl, zzcyn.a);
                zzcxp.zza(zzcxzVar.zzgkm, zzcym.a);
                return;
            }
            zzcxzVar = zzcxzVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbow
    public final void onAdFailedToLoad(final int i) {
        zzcxz zzcxzVar = this;
        while (true) {
            zzcxz zzcxzVar2 = zzcxzVar.zzgkp;
            if (zzcxzVar2 == null) {
                zzcxp.zza(zzcxzVar.zzgkk, new zzcxo(i) { // from class: com.google.android.gms.internal.ads.zzcyj
                    private final int zzdvv;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzdvv = i;
                    }

                    @Override // com.google.android.gms.internal.ads.zzcxo
                    public final void zzt(Object obj) {
                        ((zzaso) obj).onRewardedAdFailedToLoad(this.zzdvv);
                    }
                });
                zzcxp.zza(zzcxzVar.zzgkm, new zzcxo(i) { // from class: com.google.android.gms.internal.ads.zzcyi
                    private final int zzdvv;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzdvv = i;
                    }

                    @Override // com.google.android.gms.internal.ads.zzcxo
                    public final void zzt(Object obj) {
                        ((zzaro) obj).onRewardedVideoAdFailedToLoad(this.zzdvv);
                    }
                });
                return;
            }
            zzcxzVar = zzcxzVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onAdLeftApplication() {
        zzcxz zzcxzVar = this;
        while (true) {
            zzcxz zzcxzVar2 = zzcxzVar.zzgkp;
            if (zzcxzVar2 == null) {
                zzcxp.zza(zzcxzVar.zzgkm, zzcyp.a);
                return;
            }
            zzcxzVar = zzcxzVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbqb
    public final void onAdLoaded() {
        zzcxz zzcxzVar = this;
        while (true) {
            zzcxz zzcxzVar2 = zzcxzVar.zzgkp;
            if (zzcxzVar2 == null) {
                zzcxp.zza(zzcxzVar.zzgkk, zzcxy.a);
                zzcxp.zza(zzcxzVar.zzgkm, zzcyb.a);
                return;
            }
            zzcxzVar = zzcxzVar2;
        }
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        zzcxz zzcxzVar = this.zzgkp;
        if (zzcxzVar != null) {
            zzcxzVar.onAdMetadataChanged();
        } else {
            zzcxp.zza(this.zzgkj, zzcyg.a);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onAdOpened() {
        zzcxz zzcxzVar = this;
        while (true) {
            zzcxz zzcxzVar2 = zzcxzVar.zzgkp;
            if (zzcxzVar2 == null) {
                zzcxp.zza(zzcxzVar.zzgkl, zzcyl.a);
                zzcxp.zza(zzcxzVar.zzgkm, zzcyk.a);
                return;
            }
            zzcxzVar = zzcxzVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onRewardedVideoCompleted() {
        zzcxz zzcxzVar = this;
        while (true) {
            zzcxz zzcxzVar2 = zzcxzVar.zzgkp;
            if (zzcxzVar2 == null) {
                zzcxp.zza(zzcxzVar.zzgkm, zzcye.a);
                return;
            }
            zzcxzVar = zzcxzVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onRewardedVideoStarted() {
        zzcxz zzcxzVar = this;
        while (true) {
            zzcxz zzcxzVar2 = zzcxzVar.zzgkp;
            if (zzcxzVar2 == null) {
                zzcxp.zza(zzcxzVar.zzgkm, zzcyo.a);
                return;
            }
            zzcxzVar = zzcxzVar2;
        }
    }

    public final void zza(AdMetadataListener adMetadataListener) {
        this.zzgkj.set(adMetadataListener);
    }

    public final void zza(zzaso zzasoVar) {
        this.zzgkk.set(zzasoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void zzb(final zzare zzareVar, final String str, final String str2) {
        zzcxz zzcxzVar = this;
        while (true) {
            zzcxz zzcxzVar2 = zzcxzVar.zzgkp;
            if (zzcxzVar2 == null) {
                zzcxp.zza(zzcxzVar.zzgkl, new zzcxo(zzareVar) { // from class: com.google.android.gms.internal.ads.zzcya
                    private final zzare zzfhs;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzfhs = zzareVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzcxo
                    public final void zzt(Object obj) {
                        zzare zzareVar2 = this.zzfhs;
                        ((zzasl) obj).zza(new zzatc(zzareVar2.getType(), zzareVar2.getAmount()));
                    }
                });
                zzcxp.zza(zzcxzVar.zzgkn, new zzcxo(zzareVar, str, str2) { // from class: com.google.android.gms.internal.ads.zzcyd
                    private final String zzcyr;
                    private final String zzdbl;
                    private final zzare zzfhs;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzfhs = zzareVar;
                        this.zzcyr = str;
                        this.zzdbl = str2;
                    }

                    @Override // com.google.android.gms.internal.ads.zzcxo
                    public final void zzt(Object obj) {
                        zzare zzareVar2 = this.zzfhs;
                        ((zzast) obj).zza(new zzatc(zzareVar2.getType(), zzareVar2.getAmount()), this.zzcyr, this.zzdbl);
                    }
                });
                zzcxp.zza(zzcxzVar.zzgkm, new zzcxo(zzareVar) { // from class: com.google.android.gms.internal.ads.zzcyc
                    private final zzare zzfhs;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzfhs = zzareVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzcxo
                    public final void zzt(Object obj) {
                        ((zzaro) obj).zza(this.zzfhs);
                    }
                });
                zzcxp.zza(zzcxzVar.zzgko, new zzcxo(zzareVar, str, str2) { // from class: com.google.android.gms.internal.ads.zzcyf
                    private final String zzcyr;
                    private final String zzdbl;
                    private final zzare zzfhs;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzfhs = zzareVar;
                        this.zzcyr = str;
                        this.zzdbl = str2;
                    }

                    @Override // com.google.android.gms.internal.ads.zzcxo
                    public final void zzt(Object obj) {
                        ((zzarj) obj).zza(this.zzfhs, this.zzcyr, this.zzdbl);
                    }
                });
                return;
            }
            zzcxzVar = zzcxzVar2;
        }
    }

    @Deprecated
    public final void zzb(zzarj zzarjVar) {
        this.zzgko.set(zzarjVar);
    }

    @Deprecated
    public final void zzb(zzaro zzaroVar) {
        this.zzgkm.set(zzaroVar);
    }

    public final void zzb(zzasl zzaslVar) {
        this.zzgkl.set(zzaslVar);
    }

    public final void zzb(zzast zzastVar) {
        this.zzgkn.set(zzastVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcxq
    public final void zzb(zzcxq zzcxqVar) {
        this.zzgkp = (zzcxz) zzcxqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final void zzco(final int i) {
        zzcxz zzcxzVar = this;
        while (true) {
            zzcxz zzcxzVar2 = zzcxzVar.zzgkp;
            if (zzcxzVar2 == null) {
                zzcxp.zza(zzcxzVar.zzgkl, new zzcxo(i) { // from class: com.google.android.gms.internal.ads.zzcyh
                    private final int zzdvv;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzdvv = i;
                    }

                    @Override // com.google.android.gms.internal.ads.zzcxo
                    public final void zzt(Object obj) {
                        ((zzasl) obj).onRewardedAdFailedToShow(this.zzdvv);
                    }
                });
                return;
            }
            zzcxzVar = zzcxzVar2;
        }
    }
}
