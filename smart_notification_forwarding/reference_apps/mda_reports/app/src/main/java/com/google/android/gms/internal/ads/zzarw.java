package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes.dex */
public final class zzarw implements RewardedVideoAd {

    @NonNull
    private final zzarl zzdnt;
    private String zzdnv;
    private String zzdnw;
    private final Context zzup;
    private final Object lock = new Object();
    private final zzarv zzdnu = new zzarv(null);

    public zzarw(Context context, @Nullable zzarl zzarlVar) {
        this.zzdnt = zzarlVar == null ? new zzyl() : zzarlVar;
        this.zzup = context.getApplicationContext();
    }

    private final void zza(String str, zzxj zzxjVar) {
        synchronized (this.lock) {
            if (this.zzdnt == null) {
                return;
            }
            try {
                this.zzdnt.zza(zzuh.zza(this.zzup, zzxjVar, str));
            } catch (RemoteException e) {
                zzayu.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void destroy() {
        destroy(null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void destroy(Context context) {
        synchronized (this.lock) {
            this.zzdnu.setRewardedVideoAdListener(null);
            if (this.zzdnt == null) {
                return;
            }
            try {
                this.zzdnt.zzl(ObjectWrapper.wrap(context));
            } catch (RemoteException e) {
                zzayu.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final Bundle getAdMetadata() {
        synchronized (this.lock) {
            if (this.zzdnt != null) {
                try {
                    return this.zzdnt.getAdMetadata();
                } catch (RemoteException e) {
                    zzayu.zze("#007 Could not call remote method.", e);
                }
            }
            return new Bundle();
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final String getCustomData() {
        String str;
        synchronized (this.lock) {
            str = this.zzdnw;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final String getMediationAdapterClassName() {
        try {
            if (this.zzdnt != null) {
                return this.zzdnt.getMediationAdapterClassName();
            }
            return null;
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListener;
        synchronized (this.lock) {
            rewardedVideoAdListener = this.zzdnu.getRewardedVideoAdListener();
        }
        return rewardedVideoAdListener;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final String getUserId() {
        String str;
        synchronized (this.lock) {
            str = this.zzdnv;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final boolean isLoaded() {
        synchronized (this.lock) {
            if (this.zzdnt == null) {
                return false;
            }
            try {
                return this.zzdnt.isLoaded();
            } catch (RemoteException e) {
                zzayu.zze("#007 Could not call remote method.", e);
                return false;
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void loadAd(String str, AdRequest adRequest) {
        zza(str, adRequest.zzdg());
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void loadAd(String str, PublisherAdRequest publisherAdRequest) {
        zza(str, publisherAdRequest.zzdg());
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void pause() {
        pause(null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void pause(Context context) {
        synchronized (this.lock) {
            if (this.zzdnt == null) {
                return;
            }
            try {
                this.zzdnt.zzj(ObjectWrapper.wrap(context));
            } catch (RemoteException e) {
                zzayu.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void resume() {
        resume(null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void resume(Context context) {
        synchronized (this.lock) {
            if (this.zzdnt == null) {
                return;
            }
            try {
                this.zzdnt.zzk(ObjectWrapper.wrap(context));
            } catch (RemoteException e) {
                zzayu.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        synchronized (this.lock) {
            if (this.zzdnt != null) {
                try {
                    this.zzdnt.zza(new zzud(adMetadataListener));
                } catch (RemoteException e) {
                    zzayu.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setCustomData(String str) {
        synchronized (this.lock) {
            if (this.zzdnt != null) {
                try {
                    this.zzdnt.setCustomData(str);
                    this.zzdnw = str;
                } catch (RemoteException e) {
                    zzayu.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setImmersiveMode(boolean z) {
        synchronized (this.lock) {
            if (this.zzdnt != null) {
                try {
                    this.zzdnt.setImmersiveMode(z);
                } catch (RemoteException e) {
                    zzayu.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        synchronized (this.lock) {
            this.zzdnu.setRewardedVideoAdListener(rewardedVideoAdListener);
            if (this.zzdnt != null) {
                try {
                    this.zzdnt.zza(this.zzdnu);
                } catch (RemoteException e) {
                    zzayu.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setUserId(String str) {
        synchronized (this.lock) {
            this.zzdnv = str;
            if (this.zzdnt != null) {
                try {
                    this.zzdnt.setUserId(str);
                } catch (RemoteException e) {
                    zzayu.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void show() {
        synchronized (this.lock) {
            if (this.zzdnt == null) {
                return;
            }
            try {
                this.zzdnt.show();
            } catch (RemoteException e) {
                zzayu.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
