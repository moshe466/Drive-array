package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes.dex */
public class zzcnd extends zzalh {
    private final zzbpw zzffq;
    private final zzbpm zzfgg;
    private final zzbqj zzfjf;
    private final zzbpd zzfkd;
    private final zzboq zzfke;
    private final zzbra zzfqq;
    private final zzbtj zzgbj;

    public zzcnd(zzboq zzboqVar, zzbpd zzbpdVar, zzbpm zzbpmVar, zzbpw zzbpwVar, zzbra zzbraVar, zzbqj zzbqjVar, zzbtj zzbtjVar) {
        this.zzfke = zzboqVar;
        this.zzfkd = zzbpdVar;
        this.zzfgg = zzbpmVar;
        this.zzffq = zzbpwVar;
        this.zzfqq = zzbraVar;
        this.zzfjf = zzbqjVar;
        this.zzgbj = zzbtjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void onAdClicked() {
        this.zzfke.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void onAdClosed() {
        this.zzfjf.zzte();
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void onAdFailedToLoad(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void onAdImpression() {
        this.zzfkd.onAdImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void onAdLeftApplication() {
        this.zzfgg.onAdLeftApplication();
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void onAdLoaded() {
        this.zzffq.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void onAdOpened() {
        this.zzfjf.zztf();
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void onAppEvent(String str, String str2) {
        this.zzfqq.onAppEvent(str, str2);
    }

    public void onVideoEnd() {
        this.zzgbj.onVideoEnd();
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void onVideoPause() {
        this.zzgbj.onVideoPause();
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void onVideoPlay() {
        this.zzgbj.onVideoPlay();
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void zza(zzade zzadeVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void zza(zzalj zzaljVar) {
    }

    public void zza(zzasf zzasfVar) {
    }

    public void zzb(Bundle bundle) {
    }

    public void zzb(zzasd zzasdVar) {
    }

    public void zzco(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void zzdj(String str) {
    }

    public void zzss() {
        this.zzgbj.onVideoStart();
    }

    public void zzst() {
    }
}
