package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.util.VisibleForTesting;

/* loaded from: classes.dex */
public final class zzxn {
    private final zzuh zzaba;
    private AppEventListener zzbkj;
    private boolean zzbld;
    private zzvu zzbqy;
    private String zzbqz;
    private final zzakz zzbrb;
    private zzty zzcbt;
    private AdListener zzcbw;
    private AdMetadataListener zzcbx;
    private OnCustomRenderedAdLoadedListener zzcen;
    private RewardedVideoAdListener zzceu;
    private boolean zzcev;
    private final Context zzup;

    public zzxn(Context context) {
        this(context, zzuh.zzccn, null);
    }

    public zzxn(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, zzuh.zzccn, publisherInterstitialAd);
    }

    @VisibleForTesting
    private zzxn(Context context, zzuh zzuhVar, PublisherInterstitialAd publisherInterstitialAd) {
        this.zzbrb = new zzakz();
        this.zzup = context;
        this.zzaba = zzuhVar;
    }

    private final void zzcn(String str) {
        if (this.zzbqy != null) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63);
        sb.append("The ad unit ID must be set on InterstitialAd before ");
        sb.append(str);
        sb.append(" is called.");
        throw new IllegalStateException(sb.toString());
    }

    public final AdListener getAdListener() {
        return this.zzcbw;
    }

    public final Bundle getAdMetadata() {
        try {
            if (this.zzbqy != null) {
                return this.zzbqy.getAdMetadata();
            }
        } catch (RemoteException e) {
            zzayu.zze("#008 Must be called on the main UI thread.", e);
        }
        return new Bundle();
    }

    public final String getAdUnitId() {
        return this.zzbqz;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzbkj;
    }

    public final String getMediationAdapterClassName() {
        try {
            if (this.zzbqy != null) {
                return this.zzbqy.zzka();
            }
            return null;
        } catch (RemoteException e) {
            zzayu.zze("#008 Must be called on the main UI thread.", e);
            return null;
        }
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzcen;
    }

    public final boolean isLoaded() {
        try {
            if (this.zzbqy == null) {
                return false;
            }
            return this.zzbqy.isReady();
        } catch (RemoteException e) {
            zzayu.zze("#008 Must be called on the main UI thread.", e);
            return false;
        }
    }

    public final boolean isLoading() {
        try {
            if (this.zzbqy == null) {
                return false;
            }
            return this.zzbqy.isLoading();
        } catch (RemoteException e) {
            zzayu.zze("#008 Must be called on the main UI thread.", e);
            return false;
        }
    }

    public final void setAdListener(AdListener adListener) {
        try {
            this.zzcbw = adListener;
            if (this.zzbqy != null) {
                this.zzbqy.zza(adListener != null ? new zzuc(adListener) : null);
            }
        } catch (RemoteException e) {
            zzayu.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        try {
            this.zzcbx = adMetadataListener;
            if (this.zzbqy != null) {
                this.zzbqy.zza(adMetadataListener != null ? new zzud(adMetadataListener) : null);
            }
        } catch (RemoteException e) {
            zzayu.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void setAdUnitId(String str) {
        if (this.zzbqz != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.zzbqz = str;
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzbkj = appEventListener;
            if (this.zzbqy != null) {
                this.zzbqy.zza(appEventListener != null ? new zzul(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzayu.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void setImmersiveMode(boolean z) {
        try {
            this.zzbld = z;
            if (this.zzbqy != null) {
                this.zzbqy.setImmersiveMode(z);
            }
        } catch (RemoteException e) {
            zzayu.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        try {
            this.zzcen = onCustomRenderedAdLoadedListener;
            if (this.zzbqy != null) {
                this.zzbqy.zza(onCustomRenderedAdLoadedListener != null ? new zzaal(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            zzayu.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        try {
            this.zzceu = rewardedVideoAdListener;
            if (this.zzbqy != null) {
                this.zzbqy.zza(rewardedVideoAdListener != null ? new zzarv(rewardedVideoAdListener) : null);
            }
        } catch (RemoteException e) {
            zzayu.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void show() {
        try {
            zzcn("show");
            this.zzbqy.showInterstitial();
        } catch (RemoteException e) {
            zzayu.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void zza(zzty zztyVar) {
        try {
            this.zzcbt = zztyVar;
            if (this.zzbqy != null) {
                this.zzbqy.zza(zztyVar != null ? new zztx(zztyVar) : null);
            }
        } catch (RemoteException e) {
            zzayu.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void zza(zzxj zzxjVar) {
        try {
            if (this.zzbqy == null) {
                if (this.zzbqz == null) {
                    zzcn("loadAd");
                }
                zzuj zzol = this.zzcev ? zzuj.zzol() : new zzuj();
                zzup zzov = zzve.zzov();
                Context context = this.zzup;
                this.zzbqy = new zzuv(zzov, context, zzol, this.zzbqz, this.zzbrb).zzd(context, false);
                if (this.zzcbw != null) {
                    this.zzbqy.zza(new zzuc(this.zzcbw));
                }
                if (this.zzcbt != null) {
                    this.zzbqy.zza(new zztx(this.zzcbt));
                }
                if (this.zzcbx != null) {
                    this.zzbqy.zza(new zzud(this.zzcbx));
                }
                if (this.zzbkj != null) {
                    this.zzbqy.zza(new zzul(this.zzbkj));
                }
                if (this.zzcen != null) {
                    this.zzbqy.zza(new zzaal(this.zzcen));
                }
                if (this.zzceu != null) {
                    this.zzbqy.zza(new zzarv(this.zzceu));
                }
                this.zzbqy.setImmersiveMode(this.zzbld);
            }
            if (this.zzbqy.zza(zzuh.zza(this.zzup, zzxjVar))) {
                this.zzbrb.zzf(zzxjVar.zzpq());
            }
        } catch (RemoteException e) {
            zzayu.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void zzd(boolean z) {
        this.zzcev = true;
    }
}
