package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;

/* loaded from: classes.dex */
final class zzanr implements MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> {
    private final /* synthetic */ zzali zzdeo;
    private final /* synthetic */ zzanc zzder;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzanr(zzann zzannVar, zzanc zzancVar, zzali zzaliVar) {
        this.zzder = zzancVar;
        this.zzdeo = zzaliVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final MediationNativeAdCallback onSuccess(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        if (unifiedNativeAdMapper != null) {
            try {
                this.zzder.zza(new zzamt(unifiedNativeAdMapper));
            } catch (RemoteException e) {
                zzayu.zzc("", e);
            }
            return new zzant(this.zzdeo);
        }
        zzayu.zzez("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
        try {
            this.zzder.zzdl("Adapter returned null.");
            return null;
        } catch (RemoteException e2) {
            zzayu.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        try {
            this.zzder.zzdl(str);
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
    }
}
