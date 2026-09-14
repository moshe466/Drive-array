package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;

/* loaded from: classes.dex */
final class zzanp implements MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> {
    private final /* synthetic */ zzamx zzden;
    private final /* synthetic */ zzali zzdeo;
    private final /* synthetic */ zzann zzdep;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzanp(zzann zzannVar, zzamx zzamxVar, zzali zzaliVar) {
        this.zzdep = zzannVar;
        this.zzden = zzamxVar;
        this.zzdeo = zzaliVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final MediationInterstitialAdCallback onSuccess(MediationInterstitialAd mediationInterstitialAd) {
        if (mediationInterstitialAd != null) {
            try {
                this.zzdep.zzdel = mediationInterstitialAd;
                this.zzden.zztb();
            } catch (RemoteException e) {
                zzayu.zzc("", e);
            }
            return new zzant(this.zzdeo);
        }
        zzayu.zzez("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
        try {
            this.zzden.zzdl("Adapter returned null.");
            return null;
        } catch (RemoteException e2) {
            zzayu.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        try {
            this.zzden.zzdl(str);
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
    }
}
