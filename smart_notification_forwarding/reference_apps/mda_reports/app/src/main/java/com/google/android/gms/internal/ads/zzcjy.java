package com.google.android.gms.internal.ads;

import android.os.Bundle;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzcjy extends zzalh implements zzbpu {

    @GuardedBy("this")
    private zzali zzdet;

    @GuardedBy("this")
    private zzbpx zzfzf;

    @Override // com.google.android.gms.internal.ads.zzali
    public final synchronized void onAdClicked() {
        if (this.zzdet != null) {
            this.zzdet.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final synchronized void onAdClosed() {
        if (this.zzdet != null) {
            this.zzdet.onAdClosed();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final synchronized void onAdFailedToLoad(int i) {
        if (this.zzdet != null) {
            this.zzdet.onAdFailedToLoad(i);
        }
        if (this.zzfzf != null) {
            this.zzfzf.onAdFailedToLoad(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final synchronized void onAdImpression() {
        if (this.zzdet != null) {
            this.zzdet.onAdImpression();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final synchronized void onAdLeftApplication() {
        if (this.zzdet != null) {
            this.zzdet.onAdLeftApplication();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final synchronized void onAdLoaded() {
        if (this.zzdet != null) {
            this.zzdet.onAdLoaded();
        }
        if (this.zzfzf != null) {
            this.zzfzf.onAdLoaded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final synchronized void onAdOpened() {
        if (this.zzdet != null) {
            this.zzdet.onAdOpened();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final synchronized void onAppEvent(String str, String str2) {
        if (this.zzdet != null) {
            this.zzdet.onAppEvent(str, str2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final synchronized void onVideoEnd() {
        if (this.zzdet != null) {
            this.zzdet.onVideoEnd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final synchronized void onVideoPause() {
        if (this.zzdet != null) {
            this.zzdet.onVideoPause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final synchronized void onVideoPlay() {
        if (this.zzdet != null) {
            this.zzdet.onVideoPlay();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final synchronized void zza(zzade zzadeVar, String str) {
        if (this.zzdet != null) {
            this.zzdet.zza(zzadeVar, str);
        }
    }

    public final synchronized void zza(zzali zzaliVar) {
        this.zzdet = zzaliVar;
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final synchronized void zza(zzalj zzaljVar) {
        if (this.zzdet != null) {
            this.zzdet.zza(zzaljVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final synchronized void zza(zzasf zzasfVar) {
        if (this.zzdet != null) {
            this.zzdet.zza(zzasfVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpu
    public final synchronized void zza(zzbpx zzbpxVar) {
        this.zzfzf = zzbpxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final synchronized void zzb(Bundle bundle) {
        if (this.zzdet != null) {
            this.zzdet.zzb(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final synchronized void zzb(zzasd zzasdVar) {
        if (this.zzdet != null) {
            this.zzdet.zzb(zzasdVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final synchronized void zzco(int i) {
        if (this.zzdet != null) {
            this.zzdet.zzco(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final synchronized void zzdj(String str) {
        if (this.zzdet != null) {
            this.zzdet.zzdj(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final synchronized void zzss() {
        if (this.zzdet != null) {
            this.zzdet.zzss();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final synchronized void zzst() {
        if (this.zzdet != null) {
            this.zzdet.zzst();
        }
    }
}
