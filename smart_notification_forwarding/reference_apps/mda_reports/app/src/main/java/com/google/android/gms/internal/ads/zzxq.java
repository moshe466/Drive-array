package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzxq {
    private static final Object lock = new Object();

    @GuardedBy("lock")
    private static zzxq zzcez;
    private zzwk zzcfa;
    private RewardedVideoAd zzcfb;

    @NonNull
    private RequestConfiguration zzcfc = new RequestConfiguration.Builder().build();
    private InitializationStatus zzcfd;

    private zzxq() {
    }

    private final void zza(@NonNull RequestConfiguration requestConfiguration) {
        try {
            this.zzcfa.zza(new zzyq(requestConfiguration));
        } catch (RemoteException e) {
            zzayu.zzc("Unable to set request configuration parcel.", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InitializationStatus zzb(List<zzagn> list) {
        HashMap hashMap = new HashMap();
        for (zzagn zzagnVar : list) {
            hashMap.put(zzagnVar.zzcyc, new zzagv(zzagnVar.zzcyd ? AdapterStatus.State.READY : AdapterStatus.State.NOT_READY, zzagnVar.description, zzagnVar.zzcye));
        }
        return new zzagy(hashMap);
    }

    public static zzxq zzpw() {
        zzxq zzxqVar;
        synchronized (lock) {
            if (zzcez == null) {
                zzcez = new zzxq();
            }
            zzxqVar = zzcez;
        }
        return zzxqVar;
    }

    private final boolean zzpx() {
        try {
            return this.zzcfa.getVersionString().endsWith("0");
        } catch (RemoteException unused) {
            zzayu.zzex("Unable to get version string.");
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(OnInitializationCompleteListener onInitializationCompleteListener) {
        onInitializationCompleteListener.onInitializationComplete(this.zzcfd);
    }

    public final InitializationStatus getInitializationStatus() {
        Preconditions.checkState(this.zzcfa != null, "MobileAds.initialize() must be called prior to getting initialization status.");
        try {
            return this.zzcfd != null ? this.zzcfd : zzb(this.zzcfa.zzpg());
        } catch (RemoteException unused) {
            zzayu.zzex("Unable to get Initialization status.");
            return null;
        }
    }

    @NonNull
    public final RequestConfiguration getRequestConfiguration() {
        return this.zzcfc;
    }

    public final RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        synchronized (lock) {
            if (this.zzcfb != null) {
                return this.zzcfb;
            }
            this.zzcfb = new zzarw(context, new zzvc(zzve.zzov(), context, new zzakz()).zzd(context, false));
            return this.zzcfb;
        }
    }

    public final String getVersionString() {
        Preconditions.checkState(this.zzcfa != null, "MobileAds.initialize() must be called prior to getting version string.");
        try {
            return this.zzcfa.getVersionString();
        } catch (RemoteException e) {
            zzayu.zzc("Unable to get version string.", e);
            return "";
        }
    }

    public final void openDebugMenu(Context context, String str) {
        Preconditions.checkState(this.zzcfa != null, "MobileAds.initialize() must be called prior to opening debug menu.");
        try {
            this.zzcfa.zzb(ObjectWrapper.wrap(context), str);
        } catch (RemoteException e) {
            zzayu.zzc("Unable to open debug menu.", e);
        }
    }

    public final void registerRtbAdapter(Class<? extends RtbAdapter> cls) {
        try {
            this.zzcfa.zzce(cls.getCanonicalName());
        } catch (RemoteException e) {
            zzayu.zzc("Unable to register RtbAdapter", e);
        }
    }

    public final void setAppMuted(boolean z) {
        Preconditions.checkState(this.zzcfa != null, "MobileAds.initialize() must be called prior to setting app muted state.");
        try {
            this.zzcfa.setAppMuted(z);
        } catch (RemoteException e) {
            zzayu.zzc("Unable to set app mute state.", e);
        }
    }

    public final void setAppVolume(float f) {
        Preconditions.checkArgument(0.0f <= f && f <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        Preconditions.checkState(this.zzcfa != null, "MobileAds.initialize() must be called prior to setting the app volume.");
        try {
            this.zzcfa.setAppVolume(f);
        } catch (RemoteException e) {
            zzayu.zzc("Unable to set app volume.", e);
        }
    }

    public final void setRequestConfiguration(@NonNull RequestConfiguration requestConfiguration) {
        Preconditions.checkArgument(requestConfiguration != null, "Null passed to setRequestConfiguration.");
        RequestConfiguration requestConfiguration2 = this.zzcfc;
        this.zzcfc = requestConfiguration;
        if (this.zzcfa == null) {
            return;
        }
        if (requestConfiguration2.getTagForChildDirectedTreatment() == requestConfiguration.getTagForChildDirectedTreatment() && requestConfiguration2.getTagForUnderAgeOfConsent() == requestConfiguration.getTagForUnderAgeOfConsent()) {
            return;
        }
        zza(requestConfiguration);
    }

    public final void zza(final Context context, String str, zzxv zzxvVar, final OnInitializationCompleteListener onInitializationCompleteListener) {
        synchronized (lock) {
            if (this.zzcfa != null) {
                return;
            }
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null.");
            }
            try {
                zzaku.zzsj().zzc(context, str);
                this.zzcfa = new zzux(zzve.zzov(), context).zzd(context, false);
                if (onInitializationCompleteListener != null) {
                    this.zzcfa.zza(new zzxt(this, onInitializationCompleteListener, null));
                }
                this.zzcfa.zza(new zzakz());
                this.zzcfa.initialize();
                this.zzcfa.zza(str, ObjectWrapper.wrap(new Runnable(this, context) { // from class: com.google.android.gms.internal.ads.zzxp
                    private final zzxq zzcex;
                    private final Context zzcey;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzcex = this;
                        this.zzcey = context;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzcex.getRewardedVideoAdInstance(this.zzcey);
                    }
                }));
                if (this.zzcfc.getTagForChildDirectedTreatment() != -1 || this.zzcfc.getTagForUnderAgeOfConsent() != -1) {
                    zza(this.zzcfc);
                }
                zzzn.initialize(context);
                if (!((Boolean) zzve.zzoy().zzd(zzzn.zzcom)).booleanValue() && !zzpx()) {
                    zzayu.zzex("Google Mobile Ads SDK initialization functionality unavailable for this session. Ad requests can be made at any time.");
                    this.zzcfd = new InitializationStatus(this) { // from class: com.google.android.gms.internal.ads.zzxr
                        private final zzxq zzcex;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzcex = this;
                        }

                        @Override // com.google.android.gms.ads.initialization.InitializationStatus
                        public final Map getAdapterStatusMap() {
                            zzxq zzxqVar = this.zzcex;
                            HashMap hashMap = new HashMap();
                            hashMap.put("com.google.android.gms.ads.MobileAds", new zzxu(zzxqVar));
                            return hashMap;
                        }
                    };
                    if (onInitializationCompleteListener != null) {
                        zzayk.zzyu.post(new Runnable(this, onInitializationCompleteListener) { // from class: com.google.android.gms.internal.ads.zzxs
                            private final zzxq zzcex;
                            private final OnInitializationCompleteListener zzcfe;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.zzcex = this;
                                this.zzcfe = onInitializationCompleteListener;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zzcex.a(this.zzcfe);
                            }
                        });
                    }
                }
            } catch (RemoteException e) {
                zzayu.zzd("MobileAdsSettingManager initialization failed", e);
            }
        }
    }

    public final float zzpe() {
        zzwk zzwkVar = this.zzcfa;
        if (zzwkVar == null) {
            return 1.0f;
        }
        try {
            return zzwkVar.zzpe();
        } catch (RemoteException e) {
            zzayu.zzc("Unable to get app volume.", e);
            return 1.0f;
        }
    }

    public final boolean zzpf() {
        zzwk zzwkVar = this.zzcfa;
        if (zzwkVar == null) {
            return false;
        }
        try {
            return zzwkVar.zzpf();
        } catch (RemoteException e) {
            zzayu.zzc("Unable to get app mute state.", e);
            return false;
        }
    }
}
