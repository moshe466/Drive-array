package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes.dex */
final class zzanq implements MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> {
    private final /* synthetic */ zzali zzdeo;
    private final /* synthetic */ zzamw zzdeq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzanq(zzann zzannVar, zzamw zzamwVar, zzali zzaliVar) {
        this.zzdeq = zzamwVar;
        this.zzdeo = zzaliVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final MediationBannerAdCallback onSuccess(MediationBannerAd mediationBannerAd) {
        if (mediationBannerAd != null) {
            try {
                this.zzdeq.zzx(ObjectWrapper.wrap(mediationBannerAd.getView()));
            } catch (RemoteException e) {
                zzayu.zzc("", e);
            }
            return new zzant(this.zzdeo);
        }
        zzayu.zzez("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
        try {
            this.zzdeq.zzdl("Adapter returned null.");
            return null;
        } catch (RemoteException e2) {
            zzayu.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        try {
            this.zzdeq.zzdl(str);
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
    }
}
