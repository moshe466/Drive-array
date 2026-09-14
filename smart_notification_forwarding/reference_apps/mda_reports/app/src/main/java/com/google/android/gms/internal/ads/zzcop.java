package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzcop implements zzbov, zzbow, zzbpe, zzbqb, zzty {

    @GuardedBy("this")
    private zzvh zzgdc;

    @Override // com.google.android.gms.internal.ads.zzty
    public final synchronized void onAdClicked() {
        if (this.zzgdc != null) {
            try {
                this.zzgdc.onAdClicked();
            } catch (RemoteException e) {
                zzayu.zzd("Remote Exception at onAdClicked.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final synchronized void onAdClosed() {
        if (this.zzgdc != null) {
            try {
                this.zzgdc.onAdClosed();
            } catch (RemoteException e) {
                zzayu.zzd("Remote Exception at onAdClosed.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbow
    public final synchronized void onAdFailedToLoad(int i) {
        if (this.zzgdc != null) {
            try {
                this.zzgdc.onAdFailedToLoad(i);
            } catch (RemoteException e) {
                zzayu.zzd("Remote Exception at onAdFailedToLoad.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final synchronized void onAdImpression() {
        if (this.zzgdc != null) {
            try {
                this.zzgdc.onAdImpression();
            } catch (RemoteException e) {
                zzayu.zzd("Remote Exception at onAdImpression.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final synchronized void onAdLeftApplication() {
        if (this.zzgdc != null) {
            try {
                this.zzgdc.onAdLeftApplication();
            } catch (RemoteException e) {
                zzayu.zzd("Remote Exception at onAdLeftApplication.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbqb
    public final synchronized void onAdLoaded() {
        if (this.zzgdc != null) {
            try {
                this.zzgdc.onAdLoaded();
            } catch (RemoteException e) {
                zzayu.zzd("Remote Exception at onAdLoaded.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final synchronized void onAdOpened() {
        if (this.zzgdc != null) {
            try {
                this.zzgdc.onAdOpened();
            } catch (RemoteException e) {
                zzayu.zzd("Remote Exception at onAdOpened.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onRewardedVideoStarted() {
    }

    public final synchronized zzvh zzamo() {
        return this.zzgdc;
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void zzb(zzare zzareVar, String str, String str2) {
    }

    public final synchronized void zzc(zzvh zzvhVar) {
        this.zzgdc = zzvhVar;
    }
}
