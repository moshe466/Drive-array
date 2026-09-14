package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzann extends zzanh {
    private MediationRewardedAd zzddr;
    private final RtbAdapter zzdek;
    private MediationInterstitialAd zzdel;
    private String zzdem = "";

    public zzann(RtbAdapter rtbAdapter) {
        this.zzdek = rtbAdapter;
    }

    @Nullable
    private static String zza(String str, zzug zzugVar) {
        String str2 = zzugVar.zzabq;
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return str2;
        }
    }

    private static boolean zzc(zzug zzugVar) {
        if (zzugVar.zzccb) {
            return true;
        }
        zzve.zzou();
        return zzayk.zzxd();
    }

    private final Bundle zzd(zzug zzugVar) {
        Bundle bundle;
        Bundle bundle2 = zzugVar.zzccf;
        return (bundle2 == null || (bundle = bundle2.getBundle(this.zzdek.getClass().getName())) == null) ? new Bundle() : bundle;
    }

    private static Bundle zzdo(String str) {
        String valueOf = String.valueOf(str);
        zzayu.zzez(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
        try {
            Bundle bundle = new Bundle();
            if (str == null) {
                return bundle;
            }
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle2.putString(next, jSONObject.getString(next));
            }
            return bundle2;
        } catch (JSONException e) {
            zzayu.zzc("", e);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final zzxb getVideoController() {
        MediationExtrasReceiver mediationExtrasReceiver = this.zzdek;
        if (!(mediationExtrasReceiver instanceof com.google.android.gms.ads.mediation.zza)) {
            return null;
        }
        try {
            return ((com.google.android.gms.ads.mediation.zza) mediationExtrasReceiver).getVideoController();
        } catch (Throwable th) {
            zzayu.zzc("", th);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzuj zzujVar, zzanj zzanjVar) {
        AdFormat adFormat;
        try {
            zzanu zzanuVar = new zzanu(this, zzanjVar);
            RtbAdapter rtbAdapter = this.zzdek;
            char c = 65535;
            switch (str.hashCode()) {
                case -1396342996:
                    if (str.equals("banner")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1052618729:
                    if (str.equals("native")) {
                        c = 3;
                        break;
                    }
                    break;
                case -239580146:
                    if (str.equals("rewarded")) {
                        c = 2;
                        break;
                    }
                    break;
                case 604727084:
                    if (str.equals("interstitial")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                adFormat = AdFormat.BANNER;
            } else if (c == 1) {
                adFormat = AdFormat.INTERSTITIAL;
            } else if (c == 2) {
                adFormat = AdFormat.REWARDED;
            } else {
                if (c != 3) {
                    throw new IllegalArgumentException("Internal Error");
                }
                adFormat = AdFormat.NATIVE;
            }
            MediationConfiguration mediationConfiguration = new MediationConfiguration(adFormat, bundle2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(mediationConfiguration);
            rtbAdapter.collectSignals(new RtbSignalData((Context) ObjectWrapper.unwrap(iObjectWrapper), arrayList, bundle, com.google.android.gms.ads.zzb.zza(zzujVar.width, zzujVar.height, zzujVar.zzabg)), zzanuVar);
        } catch (Throwable th) {
            zzayu.zzc("Error generating signals for RTB", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final void zza(String str, String str2, zzug zzugVar, IObjectWrapper iObjectWrapper, zzamw zzamwVar, zzali zzaliVar, zzuj zzujVar) {
        try {
            this.zzdek.loadBannerAd(new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdo(str2), zzd(zzugVar), zzc(zzugVar), zzugVar.zzmi, zzugVar.zzabo, zzugVar.zzabp, zza(str2, zzugVar), com.google.android.gms.ads.zzb.zza(zzujVar.width, zzujVar.height, zzujVar.zzabg), this.zzdem), new zzanq(this, zzamwVar, zzaliVar));
        } catch (Throwable th) {
            zzayu.zzc("Adapter failed to render banner ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final void zza(String str, String str2, zzug zzugVar, IObjectWrapper iObjectWrapper, zzamx zzamxVar, zzali zzaliVar) {
        try {
            this.zzdek.loadInterstitialAd(new MediationInterstitialAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdo(str2), zzd(zzugVar), zzc(zzugVar), zzugVar.zzmi, zzugVar.zzabo, zzugVar.zzabp, zza(str2, zzugVar), this.zzdem), new zzanp(this, zzamxVar, zzaliVar));
        } catch (Throwable th) {
            zzayu.zzc("Adapter failed to render interstitial ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final void zza(String str, String str2, zzug zzugVar, IObjectWrapper iObjectWrapper, zzanc zzancVar, zzali zzaliVar) {
        try {
            this.zzdek.loadNativeAd(new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdo(str2), zzd(zzugVar), zzc(zzugVar), zzugVar.zzmi, zzugVar.zzabo, zzugVar.zzabp, zza(str2, zzugVar), this.zzdem), new zzanr(this, zzancVar, zzaliVar));
        } catch (Throwable th) {
            zzayu.zzc("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final void zza(String str, String str2, zzug zzugVar, IObjectWrapper iObjectWrapper, zzand zzandVar, zzali zzaliVar) {
        try {
            this.zzdek.loadRewardedAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdo(str2), zzd(zzugVar), zzc(zzugVar), zzugVar.zzmi, zzugVar.zzabo, zzugVar.zzabp, zza(str2, zzugVar), this.zzdem), new zzans(this, zzandVar, zzaliVar));
        } catch (Throwable th) {
            zzayu.zzc("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final void zza(String[] strArr, Bundle[] bundleArr) {
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final boolean zzaa(IObjectWrapper iObjectWrapper) {
        MediationRewardedAd mediationRewardedAd = this.zzddr;
        if (mediationRewardedAd == null) {
            return false;
        }
        try {
            mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzayu.zzc("", th);
            return true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final void zzdm(String str) {
        this.zzdem = str;
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final zzanw zztc() {
        return zzanw.zza(this.zzdek.getVersionInfo());
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final zzanw zztd() {
        return zzanw.zza(this.zzdek.getSDKVersionInfo());
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final void zzy(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final boolean zzz(IObjectWrapper iObjectWrapper) {
        MediationInterstitialAd mediationInterstitialAd = this.zzdel;
        if (mediationInterstitialAd == null) {
            return false;
        }
        try {
            mediationInterstitialAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzayu.zzc("", th);
            return true;
        }
    }
}
