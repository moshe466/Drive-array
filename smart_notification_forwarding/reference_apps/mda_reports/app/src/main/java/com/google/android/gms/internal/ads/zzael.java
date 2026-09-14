package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAppInstallAd;

/* loaded from: classes.dex */
public final class zzael extends zzadh {
    private final NativeAppInstallAd.OnAppInstallAdLoadedListener zzcwh;

    public zzael(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.zzcwh = onAppInstallAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final void zza(zzacw zzacwVar) {
        this.zzcwh.onAppInstallAdLoaded(new zzacx(zzacwVar));
    }
}
