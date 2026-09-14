package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzaly extends zzalg {
    private final Object zzddn;
    private zzalz zzddo;
    private zzarz zzddp;
    private IObjectWrapper zzddq;
    private MediationRewardedAd zzddr;

    public zzaly(@NonNull Adapter adapter) {
        this.zzddn = adapter;
    }

    public zzaly(@NonNull MediationAdapter mediationAdapter) {
        this.zzddn = mediationAdapter;
    }

    private final Bundle zza(String str, zzug zzugVar, String str2) {
        Bundle bundle;
        String valueOf = String.valueOf(str);
        zzayu.zzea(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
        try {
            Bundle bundle2 = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                bundle = new Bundle();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bundle.putString(next, jSONObject.getString(next));
                }
            } else {
                bundle = bundle2;
            }
            if (this.zzddn instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (zzugVar != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zzugVar.zzabo);
                }
            }
            bundle.remove("max_ad_content_rating");
            return bundle;
        } catch (Throwable th) {
            zzayu.zzc("", th);
            throw new RemoteException();
        }
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

    @Override // com.google.android.gms.internal.ads.zzald
    public final void destroy() {
        Object obj = this.zzddn;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onDestroy();
            } catch (Throwable th) {
                zzayu.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final Bundle getInterstitialAdapterInfo() {
        Object obj = this.zzddn;
        if (obj instanceof zzbfy) {
            return ((zzbfy) obj).getInterstitialAdapterInfo();
        }
        String canonicalName = zzbfy.class.getCanonicalName();
        String canonicalName2 = this.zzddn.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzayu.zzez(sb.toString());
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final zzxb getVideoController() {
        Object obj = this.zzddn;
        if (!(obj instanceof com.google.android.gms.ads.mediation.zza)) {
            return null;
        }
        try {
            return ((com.google.android.gms.ads.mediation.zza) obj).getVideoController();
        } catch (Throwable th) {
            zzayu.zzc("", th);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final boolean isInitialized() {
        Object obj = this.zzddn;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzayu.zzea("Check if adapter is initialized.");
            try {
                return ((MediationRewardedVideoAdAdapter) this.zzddn).isInitialized();
            } catch (Throwable th) {
                zzayu.zzc("", th);
                throw new RemoteException();
            }
        }
        if (obj instanceof Adapter) {
            return this.zzddp != null;
        }
        String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
        String canonicalName2 = Adapter.class.getCanonicalName();
        String canonicalName3 = this.zzddn.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
        sb.append(canonicalName);
        sb.append(" or ");
        sb.append(canonicalName2);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName3);
        zzayu.zzez(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void pause() {
        Object obj = this.zzddn;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onPause();
            } catch (Throwable th) {
                zzayu.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void resume() {
        Object obj = this.zzddn;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onResume();
            } catch (Throwable th) {
                zzayu.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void setImmersiveMode(boolean z) {
        Object obj = this.zzddn;
        if (obj instanceof OnImmersiveModeUpdatedListener) {
            try {
                ((OnImmersiveModeUpdatedListener) obj).onImmersiveModeUpdated(z);
                return;
            } catch (Throwable th) {
                zzayu.zzc("", th);
                return;
            }
        }
        String canonicalName = OnImmersiveModeUpdatedListener.class.getCanonicalName();
        String canonicalName2 = this.zzddn.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzayu.zzez(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void showInterstitial() {
        if (this.zzddn instanceof MediationInterstitialAdapter) {
            zzayu.zzea("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.zzddn).showInterstitial();
                return;
            } catch (Throwable th) {
                zzayu.zzc("", th);
                throw new RemoteException();
            }
        }
        String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
        String canonicalName2 = this.zzddn.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzayu.zzez(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void showVideo() {
        Object obj = this.zzddn;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzayu.zzea("Show rewarded video ad from adapter.");
            try {
                ((MediationRewardedVideoAdAdapter) this.zzddn).showVideo();
                return;
            } catch (Throwable th) {
                zzayu.zzc("", th);
                throw new RemoteException();
            }
        }
        if (obj instanceof Adapter) {
            MediationRewardedAd mediationRewardedAd = this.zzddr;
            if (mediationRewardedAd != null) {
                mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(this.zzddq));
                return;
            } else {
                zzayu.zzex("Can not show null mediated rewarded ad.");
                throw new RemoteException();
            }
        }
        String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
        String canonicalName2 = Adapter.class.getCanonicalName();
        String canonicalName3 = this.zzddn.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
        sb.append(canonicalName);
        sb.append(" or ");
        sb.append(canonicalName2);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName3);
        zzayu.zzez(sb.toString());
        throw new RemoteException();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006e  */
    @Override // com.google.android.gms.internal.ads.zzald
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(com.google.android.gms.dynamic.IObjectWrapper r10, com.google.android.gms.internal.ads.zzagp r11, java.util.List<com.google.android.gms.internal.ads.zzagx> r12) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.zzddn
            boolean r0 = r0 instanceof com.google.android.gms.ads.mediation.Adapter
            if (r0 == 0) goto L87
            com.google.android.gms.internal.ads.zzama r0 = new com.google.android.gms.internal.ads.zzama
            r0.<init>(r9, r11)
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.Iterator r12 = r12.iterator()
        L14:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L79
            java.lang.Object r1 = r12.next()
            com.google.android.gms.internal.ads.zzagx r1 = (com.google.android.gms.internal.ads.zzagx) r1
            com.google.android.gms.ads.mediation.MediationConfiguration r2 = new com.google.android.gms.ads.mediation.MediationConfiguration
            java.lang.String r3 = r1.zzcyg
            r4 = -1
            int r5 = r3.hashCode()
            r6 = 3
            r7 = 2
            r8 = 1
            switch(r5) {
                case -1396342996: goto L4e;
                case -1052618729: goto L44;
                case -239580146: goto L3a;
                case 604727084: goto L30;
                default: goto L2f;
            }
        L2f:
            goto L57
        L30:
            java.lang.String r5 = "interstitial"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L57
            r4 = 1
            goto L57
        L3a:
            java.lang.String r5 = "rewarded"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L57
            r4 = 2
            goto L57
        L44:
            java.lang.String r5 = "native"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L57
            r4 = 3
            goto L57
        L4e:
            java.lang.String r5 = "banner"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L57
            r4 = 0
        L57:
            if (r4 == 0) goto L6e
            if (r4 == r8) goto L6b
            if (r4 == r7) goto L68
            if (r4 != r6) goto L62
            com.google.android.gms.ads.AdFormat r3 = com.google.android.gms.ads.AdFormat.NATIVE
            goto L70
        L62:
            android.os.RemoteException r10 = new android.os.RemoteException
            r10.<init>()
            throw r10
        L68:
            com.google.android.gms.ads.AdFormat r3 = com.google.android.gms.ads.AdFormat.REWARDED
            goto L70
        L6b:
            com.google.android.gms.ads.AdFormat r3 = com.google.android.gms.ads.AdFormat.INTERSTITIAL
            goto L70
        L6e:
            com.google.android.gms.ads.AdFormat r3 = com.google.android.gms.ads.AdFormat.BANNER
        L70:
            android.os.Bundle r1 = r1.extras
            r2.<init>(r3, r1)
            r11.add(r2)
            goto L14
        L79:
            java.lang.Object r12 = r9.zzddn
            com.google.android.gms.ads.mediation.Adapter r12 = (com.google.android.gms.ads.mediation.Adapter) r12
            java.lang.Object r10 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r10)
            android.content.Context r10 = (android.content.Context) r10
            r12.initialize(r10, r0, r11)
            return
        L87:
            android.os.RemoteException r10 = new android.os.RemoteException
            r10.<init>()
            goto L8e
        L8d:
            throw r10
        L8e:
            goto L8d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaly.zza(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.internal.ads.zzagp, java.util.List):void");
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void zza(IObjectWrapper iObjectWrapper, zzarz zzarzVar, List<String> list) {
        if (!(this.zzddn instanceof InitializableMediationRewardedVideoAdAdapter)) {
            String canonicalName = InitializableMediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzddn.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzayu.zzez(sb.toString());
            throw new RemoteException();
        }
        zzayu.zzea("Initialize rewarded video adapter.");
        try {
            InitializableMediationRewardedVideoAdAdapter initializableMediationRewardedVideoAdAdapter = (InitializableMediationRewardedVideoAdAdapter) this.zzddn;
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(zza(it.next(), (zzug) null, (String) null));
            }
            initializableMediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzasa(zzarzVar), arrayList);
        } catch (Throwable th) {
            zzayu.zzd("Could not initialize rewarded video adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void zza(IObjectWrapper iObjectWrapper, zzug zzugVar, String str, zzali zzaliVar) {
        zza(iObjectWrapper, zzugVar, str, (String) null, zzaliVar);
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void zza(IObjectWrapper iObjectWrapper, zzug zzugVar, String str, zzarz zzarzVar, String str2) {
        zzalv zzalvVar;
        Bundle bundle;
        Object obj = this.zzddn;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzayu.zzea("Initialize rewarded video adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzddn;
                Bundle zza = zza(str2, zzugVar, (String) null);
                if (zzugVar != null) {
                    zzalv zzalvVar2 = new zzalv(zzugVar.zzcby == -1 ? null : new Date(zzugVar.zzcby), zzugVar.zzcbz, zzugVar.zzcca != null ? new HashSet(zzugVar.zzcca) : null, zzugVar.zzmi, zzc(zzugVar), zzugVar.zzabo, zzugVar.zzcck, zzugVar.zzabp, zza(str2, zzugVar));
                    bundle = zzugVar.zzccf != null ? zzugVar.zzccf.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null;
                    zzalvVar = zzalvVar2;
                } else {
                    zzalvVar = null;
                    bundle = null;
                }
                mediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), zzalvVar, str, new zzasa(zzarzVar), zza, bundle);
                return;
            } catch (Throwable th) {
                zzayu.zzc("", th);
                throw new RemoteException();
            }
        }
        if (obj instanceof Adapter) {
            this.zzddq = iObjectWrapper;
            this.zzddp = zzarzVar;
            zzarzVar.zzaf(ObjectWrapper.wrap(obj));
            return;
        }
        String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
        String canonicalName2 = Adapter.class.getCanonicalName();
        String canonicalName3 = this.zzddn.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
        sb.append(canonicalName);
        sb.append(" or ");
        sb.append(canonicalName2);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName3);
        zzayu.zzez(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void zza(IObjectWrapper iObjectWrapper, zzug zzugVar, String str, String str2, zzali zzaliVar) {
        if (!(this.zzddn instanceof MediationInterstitialAdapter)) {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzddn.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzayu.zzez(sb.toString());
            throw new RemoteException();
        }
        zzayu.zzea("Requesting interstitial ad from adapter.");
        try {
            MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.zzddn;
            mediationInterstitialAdapter.requestInterstitialAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzalz(zzaliVar), zza(str, zzugVar, str2), new zzalv(zzugVar.zzcby == -1 ? null : new Date(zzugVar.zzcby), zzugVar.zzcbz, zzugVar.zzcca != null ? new HashSet(zzugVar.zzcca) : null, zzugVar.zzmi, zzc(zzugVar), zzugVar.zzabo, zzugVar.zzcck, zzugVar.zzabp, zza(str, zzugVar)), zzugVar.zzccf != null ? zzugVar.zzccf.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzayu.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void zza(IObjectWrapper iObjectWrapper, zzug zzugVar, String str, String str2, zzali zzaliVar, zzaby zzabyVar, List<String> list) {
        Object obj = this.zzddn;
        if (!(obj instanceof MediationNativeAdapter)) {
            String canonicalName = MediationNativeAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzddn.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzayu.zzez(sb.toString());
            throw new RemoteException();
        }
        try {
            MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) obj;
            zzamd zzamdVar = new zzamd(zzugVar.zzcby == -1 ? null : new Date(zzugVar.zzcby), zzugVar.zzcbz, zzugVar.zzcca != null ? new HashSet(zzugVar.zzcca) : null, zzugVar.zzmi, zzc(zzugVar), zzugVar.zzabo, zzabyVar, list, zzugVar.zzcck, zzugVar.zzabp, zza(str, zzugVar));
            Bundle bundle = zzugVar.zzccf != null ? zzugVar.zzccf.getBundle(mediationNativeAdapter.getClass().getName()) : null;
            this.zzddo = new zzalz(zzaliVar);
            mediationNativeAdapter.requestNativeAd((Context) ObjectWrapper.unwrap(iObjectWrapper), this.zzddo, zza(str, zzugVar, str2), zzamdVar, bundle);
        } catch (Throwable th) {
            zzayu.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void zza(IObjectWrapper iObjectWrapper, zzuj zzujVar, zzug zzugVar, String str, zzali zzaliVar) {
        zza(iObjectWrapper, zzujVar, zzugVar, str, null, zzaliVar);
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void zza(IObjectWrapper iObjectWrapper, zzuj zzujVar, zzug zzugVar, String str, String str2, zzali zzaliVar) {
        if (!(this.zzddn instanceof MediationBannerAdapter)) {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzddn.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzayu.zzez(sb.toString());
            throw new RemoteException();
        }
        zzayu.zzea("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzddn;
            mediationBannerAdapter.requestBannerAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzalz(zzaliVar), zza(str, zzugVar, str2), zzujVar.zzccv ? com.google.android.gms.ads.zzb.zza(zzujVar.width, zzujVar.height) : com.google.android.gms.ads.zzb.zza(zzujVar.width, zzujVar.height, zzujVar.zzabg), new zzalv(zzugVar.zzcby == -1 ? null : new Date(zzugVar.zzcby), zzugVar.zzcbz, zzugVar.zzcca != null ? new HashSet(zzugVar.zzcca) : null, zzugVar.zzmi, zzc(zzugVar), zzugVar.zzabo, zzugVar.zzcck, zzugVar.zzabp, zza(str, zzugVar)), zzugVar.zzccf != null ? zzugVar.zzccf.getBundle(mediationBannerAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzayu.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void zza(zzug zzugVar, String str) {
        zza(zzugVar, str, (String) null);
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void zza(zzug zzugVar, String str, String str2) {
        Object obj = this.zzddn;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzayu.zzea("Requesting rewarded video ad from adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzddn;
                mediationRewardedVideoAdAdapter.loadAd(new zzalv(zzugVar.zzcby == -1 ? null : new Date(zzugVar.zzcby), zzugVar.zzcbz, zzugVar.zzcca != null ? new HashSet(zzugVar.zzcca) : null, zzugVar.zzmi, zzc(zzugVar), zzugVar.zzabo, zzugVar.zzcck, zzugVar.zzabp, zza(str, zzugVar)), zza(str, zzugVar, str2), zzugVar.zzccf != null ? zzugVar.zzccf.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
                return;
            } catch (Throwable th) {
                zzayu.zzc("", th);
                throw new RemoteException();
            }
        }
        if (obj instanceof Adapter) {
            zzb(this.zzddq, zzugVar, str, new zzamc((Adapter) obj, this.zzddp));
            return;
        }
        String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
        String canonicalName2 = Adapter.class.getCanonicalName();
        String canonicalName3 = this.zzddn.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
        sb.append(canonicalName);
        sb.append(" or ");
        sb.append(canonicalName2);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName3);
        zzayu.zzez(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void zzb(IObjectWrapper iObjectWrapper, zzug zzugVar, String str, zzali zzaliVar) {
        Bundle bundle;
        if (!(this.zzddn instanceof Adapter)) {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zzddn.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzayu.zzez(sb.toString());
            throw new RemoteException();
        }
        zzayu.zzea("Requesting rewarded ad from adapter.");
        try {
            Adapter adapter = (Adapter) this.zzddn;
            zzalx zzalxVar = new zzalx(this, zzaliVar, adapter);
            Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            Bundle zza = zza(str, zzugVar, (String) null);
            if (zzugVar.zzccf == null || (bundle = zzugVar.zzccf.getBundle(this.zzddn.getClass().getName())) == null) {
                bundle = new Bundle();
            }
            adapter.loadRewardedAd(new MediationRewardedAdConfiguration(context, "", zza, bundle, zzc(zzugVar), zzugVar.zzmi, zzugVar.zzabo, zzugVar.zzabp, zza(str, zzugVar), ""), zzalxVar);
        } catch (Exception e) {
            zzayu.zzc("", e);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void zzs(IObjectWrapper iObjectWrapper) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        Object obj = this.zzddn;
        if (obj instanceof OnContextChangedListener) {
            ((OnContextChangedListener) obj).onContextChanged(context);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final IObjectWrapper zzsk() {
        Object obj = this.zzddn;
        if (obj instanceof MediationBannerAdapter) {
            try {
                return ObjectWrapper.wrap(((MediationBannerAdapter) obj).getBannerView());
            } catch (Throwable th) {
                zzayu.zzc("", th);
                throw new RemoteException();
            }
        }
        String canonicalName = MediationBannerAdapter.class.getCanonicalName();
        String canonicalName2 = this.zzddn.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzayu.zzez(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final zzall zzsl() {
        NativeAdMapper zzsw = this.zzddo.zzsw();
        if (zzsw instanceof NativeAppInstallAdMapper) {
            return new zzamb((NativeAppInstallAdMapper) zzsw);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final zzalq zzsm() {
        NativeAdMapper zzsw = this.zzddo.zzsw();
        if (zzsw instanceof NativeContentAdMapper) {
            return new zzame((NativeContentAdMapper) zzsw);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final Bundle zzsn() {
        Object obj = this.zzddn;
        if (obj instanceof zzbfw) {
            return ((zzbfw) obj).zzsn();
        }
        String canonicalName = zzbfw.class.getCanonicalName();
        String canonicalName2 = this.zzddn.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzayu.zzez(sb.toString());
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final Bundle zzso() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final boolean zzsp() {
        return this.zzddn instanceof InitializableMediationRewardedVideoAdAdapter;
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final zzade zzsq() {
        NativeCustomTemplateAd zzsy = this.zzddo.zzsy();
        if (zzsy instanceof zzadf) {
            return ((zzadf) zzsy).zzro();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final zzalr zzsr() {
        UnifiedNativeAdMapper zzsx = this.zzddo.zzsx();
        if (zzsx != null) {
            return new zzamt(zzsx);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void zzt(IObjectWrapper iObjectWrapper) {
        if (this.zzddn instanceof Adapter) {
            zzayu.zzea("Show rewarded ad from adapter.");
            MediationRewardedAd mediationRewardedAd = this.zzddr;
            if (mediationRewardedAd != null) {
                mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
                return;
            } else {
                zzayu.zzex("Can not show null mediation rewarded ad.");
                throw new RemoteException();
            }
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = this.zzddn.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzayu.zzez(sb.toString());
        throw new RemoteException();
    }
}
