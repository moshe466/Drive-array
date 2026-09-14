package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

/* loaded from: classes.dex */
final class zzans implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {
    private final /* synthetic */ zzali zzdeo;
    private final /* synthetic */ zzann zzdep;
    private final /* synthetic */ zzand zzdes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzans(zzann zzannVar, zzand zzandVar, zzali zzaliVar) {
        this.zzdep = zzannVar;
        this.zzdes = zzandVar;
        this.zzdeo = zzaliVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final MediationRewardedAdCallback onSuccess(MediationRewardedAd mediationRewardedAd) {
        if (mediationRewardedAd != null) {
            try {
                this.zzdep.zzddr = mediationRewardedAd;
                this.zzdes.zztb();
            } catch (RemoteException e) {
                zzayu.zzc("", e);
            }
            return new zzant(this.zzdeo);
        }
        zzayu.zzez("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
        try {
            this.zzdes.zzdl("Adapter returned null.");
            return null;
        } catch (RemoteException e2) {
            zzayu.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        try {
            this.zzdes.zzdl(str);
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
    }
}
