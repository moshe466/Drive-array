package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaby;
import com.google.android.gms.internal.ads.zzael;
import com.google.android.gms.internal.ads.zzaen;
import com.google.android.gms.internal.ads.zzaeo;
import com.google.android.gms.internal.ads.zzaep;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzaer;
import com.google.android.gms.internal.ads.zzakz;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzuc;
import com.google.android.gms.internal.ads.zzuh;
import com.google.android.gms.internal.ads.zzuj;
import com.google.android.gms.internal.ads.zzve;
import com.google.android.gms.internal.ads.zzvm;
import com.google.android.gms.internal.ads.zzvn;
import com.google.android.gms.internal.ads.zzxj;

/* loaded from: classes.dex */
public class AdLoader {
    private final zzuh zzaba;
    private final zzvm zzabb;
    private final Context zzup;

    /* loaded from: classes.dex */
    public static class Builder {
        private final zzvn zzabd;
        private final Context zzup;

        private Builder(Context context, zzvn zzvnVar) {
            this.zzup = context;
            this.zzabd = zzvnVar;
        }

        public Builder(Context context, String str) {
            this((Context) Preconditions.checkNotNull(context, "context cannot be null"), zzve.zzov().zzb(context, str, new zzakz()));
        }

        public AdLoader build() {
            try {
                return new AdLoader(this.zzup, this.zzabd.zzpd());
            } catch (RemoteException e) {
                zzayu.zzc("Failed to build AdLoader.", e);
                return null;
            }
        }

        @Deprecated
        public Builder forAppInstallAd(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
            try {
                this.zzabd.zza(new zzael(onAppInstallAdLoadedListener));
            } catch (RemoteException e) {
                zzayu.zzd("Failed to add app install ad listener", e);
            }
            return this;
        }

        @Deprecated
        public Builder forContentAd(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
            try {
                this.zzabd.zza(new zzaeo(onContentAdLoadedListener));
            } catch (RemoteException e) {
                zzayu.zzd("Failed to add content ad listener", e);
            }
            return this;
        }

        public Builder forCustomTemplateAd(String str, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
            try {
                this.zzabd.zza(str, new zzaeq(onCustomTemplateAdLoadedListener), onCustomClickListener == null ? null : new zzaen(onCustomClickListener));
            } catch (RemoteException e) {
                zzayu.zzd("Failed to add custom template ad listener", e);
            }
            return this;
        }

        public Builder forPublisherAdView(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener, AdSize... adSizeArr) {
            if (adSizeArr == null || adSizeArr.length <= 0) {
                throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
            }
            try {
                this.zzabd.zza(new zzaep(onPublisherAdViewLoadedListener), new zzuj(this.zzup, adSizeArr));
            } catch (RemoteException e) {
                zzayu.zzd("Failed to add publisher banner ad listener", e);
            }
            return this;
        }

        public Builder forUnifiedNativeAd(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
            try {
                this.zzabd.zza(new zzaer(onUnifiedNativeAdLoadedListener));
            } catch (RemoteException e) {
                zzayu.zzd("Failed to add google native ad listener", e);
            }
            return this;
        }

        public Builder withAdListener(AdListener adListener) {
            try {
                this.zzabd.zzb(new zzuc(adListener));
            } catch (RemoteException e) {
                zzayu.zzd("Failed to set AdListener.", e);
            }
            return this;
        }

        @KeepForSdk
        @Deprecated
        public Builder withCorrelator(@NonNull Correlator correlator) {
            return this;
        }

        public Builder withNativeAdOptions(NativeAdOptions nativeAdOptions) {
            try {
                this.zzabd.zza(new zzaby(nativeAdOptions));
            } catch (RemoteException e) {
                zzayu.zzd("Failed to specify native ad options", e);
            }
            return this;
        }

        public Builder withPublisherAdViewOptions(PublisherAdViewOptions publisherAdViewOptions) {
            try {
                this.zzabd.zza(publisherAdViewOptions);
            } catch (RemoteException e) {
                zzayu.zzd("Failed to specify DFP banner ad options", e);
            }
            return this;
        }
    }

    AdLoader(Context context, zzvm zzvmVar) {
        this(context, zzvmVar, zzuh.zzccn);
    }

    private AdLoader(Context context, zzvm zzvmVar, zzuh zzuhVar) {
        this.zzup = context;
        this.zzabb = zzvmVar;
        this.zzaba = zzuhVar;
    }

    private final void zza(zzxj zzxjVar) {
        try {
            this.zzabb.zzb(zzuh.zza(this.zzup, zzxjVar));
        } catch (RemoteException e) {
            zzayu.zzc("Failed to load ad.", e);
        }
    }

    @Deprecated
    public String getMediationAdapterClassName() {
        try {
            return this.zzabb.zzka();
        } catch (RemoteException e) {
            zzayu.zzd("Failed to get the mediation adapter class name.", e);
            return null;
        }
    }

    public boolean isLoading() {
        try {
            return this.zzabb.isLoading();
        } catch (RemoteException e) {
            zzayu.zzd("Failed to check if ad is loading.", e);
            return false;
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(AdRequest adRequest) {
        zza(adRequest.zzdg());
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzdg());
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAds(AdRequest adRequest, int i) {
        try {
            this.zzabb.zza(zzuh.zza(this.zzup, adRequest.zzdg()), i);
        } catch (RemoteException e) {
            zzayu.zzc("Failed to load ads.", e);
        }
    }
}
