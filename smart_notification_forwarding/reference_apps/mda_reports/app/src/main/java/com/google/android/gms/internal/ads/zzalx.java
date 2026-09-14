package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzalx implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {
    private final /* synthetic */ zzali zzddk;
    private final /* synthetic */ Adapter zzddl;
    private final /* synthetic */ zzaly zzddm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzalx(zzaly zzalyVar, zzali zzaliVar, Adapter adapter) {
        this.zzddm = zzalyVar;
        this.zzddk = zzaliVar;
        this.zzddl = adapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final MediationRewardedAdCallback onSuccess(MediationRewardedAd mediationRewardedAd) {
        try {
            this.zzddm.zzddr = mediationRewardedAd;
            this.zzddk.onAdLoaded();
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
        return new zzatd(this.zzddk);
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        try {
            String canonicalName = this.zzddl.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 30 + String.valueOf(str).length());
            sb.append(canonicalName);
            sb.append("failed to loaded medation ad: ");
            sb.append(str);
            zzayu.zzea(sb.toString());
            this.zzddk.onAdFailedToLoad(0);
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
    }
}
