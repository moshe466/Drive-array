package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

/* loaded from: classes.dex */
public final class zzamf<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final zzali zzdds;

    public zzamf(zzali zzaliVar) {
        this.zzdds = zzaliVar;
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzayu.zzea("Adapter called onClick.");
        zzve.zzou();
        if (!zzayk.zzxe()) {
            zzayu.zze("#008 Must be called on the main UI thread.", null);
            zzayk.zzyu.post(new zzami(this));
        } else {
            try {
                this.zzdds.onAdClicked();
            } catch (RemoteException e) {
                zzayu.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzayu.zzea("Adapter called onDismissScreen.");
        zzve.zzou();
        if (!zzayk.zzxe()) {
            zzayu.zzez("#008 Must be called on the main UI thread.");
            zzayk.zzyu.post(new zzamj(this));
        } else {
            try {
                this.zzdds.onAdClosed();
            } catch (RemoteException e) {
                zzayu.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzayu.zzea("Adapter called onDismissScreen.");
        zzve.zzou();
        if (!zzayk.zzxe()) {
            zzayu.zze("#008 Must be called on the main UI thread.", null);
            zzayk.zzyu.post(new zzamq(this));
        } else {
            try {
                this.zzdds.onAdClosed();
            } catch (RemoteException e) {
                zzayu.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, AdRequest.ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error. ");
        sb.append(valueOf);
        zzayu.zzea(sb.toString());
        zzve.zzou();
        if (!zzayk.zzxe()) {
            zzayu.zze("#008 Must be called on the main UI thread.", null);
            zzayk.zzyu.post(new zzamm(this, errorCode));
        } else {
            try {
                this.zzdds.onAdFailedToLoad(zzamr.zza(errorCode));
            } catch (RemoteException e) {
                zzayu.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, AdRequest.ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error ");
        sb.append(valueOf);
        sb.append(".");
        zzayu.zzea(sb.toString());
        zzve.zzou();
        if (!zzayk.zzxe()) {
            zzayu.zze("#008 Must be called on the main UI thread.", null);
            zzayk.zzyu.post(new zzamp(this, errorCode));
        } else {
            try {
                this.zzdds.onAdFailedToLoad(zzamr.zza(errorCode));
            } catch (RemoteException e) {
                zzayu.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzayu.zzea("Adapter called onLeaveApplication.");
        zzve.zzou();
        if (!zzayk.zzxe()) {
            zzayu.zze("#008 Must be called on the main UI thread.", null);
            zzayk.zzyu.post(new zzaml(this));
        } else {
            try {
                this.zzdds.onAdLeftApplication();
            } catch (RemoteException e) {
                zzayu.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzayu.zzea("Adapter called onLeaveApplication.");
        zzve.zzou();
        if (!zzayk.zzxe()) {
            zzayu.zze("#008 Must be called on the main UI thread.", null);
            zzayk.zzyu.post(new zzams(this));
        } else {
            try {
                this.zzdds.onAdLeftApplication();
            } catch (RemoteException e) {
                zzayu.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzayu.zzea("Adapter called onPresentScreen.");
        zzve.zzou();
        if (!zzayk.zzxe()) {
            zzayu.zze("#008 Must be called on the main UI thread.", null);
            zzayk.zzyu.post(new zzamo(this));
        } else {
            try {
                this.zzdds.onAdOpened();
            } catch (RemoteException e) {
                zzayu.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzayu.zzea("Adapter called onPresentScreen.");
        zzve.zzou();
        if (!zzayk.zzxe()) {
            zzayu.zze("#008 Must be called on the main UI thread.", null);
            zzayk.zzyu.post(new zzamh(this));
        } else {
            try {
                this.zzdds.onAdOpened();
            } catch (RemoteException e) {
                zzayu.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzayu.zzea("Adapter called onReceivedAd.");
        zzve.zzou();
        if (!zzayk.zzxe()) {
            zzayu.zze("#008 Must be called on the main UI thread.", null);
            zzayk.zzyu.post(new zzamn(this));
        } else {
            try {
                this.zzdds.onAdLoaded();
            } catch (RemoteException e) {
                zzayu.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzayu.zzea("Adapter called onReceivedAd.");
        zzve.zzou();
        if (!zzayk.zzxe()) {
            zzayu.zze("#008 Must be called on the main UI thread.", null);
            zzayk.zzyu.post(new zzamk(this));
        } else {
            try {
                this.zzdds.onAdLoaded();
            } catch (RemoteException e) {
                zzayu.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
