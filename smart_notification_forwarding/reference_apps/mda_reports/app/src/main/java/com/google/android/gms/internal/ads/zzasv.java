package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzasv {
    private final zzasg zzdnz;
    private final Context zzyv;

    public zzasv(Context context, String str) {
        this.zzyv = context.getApplicationContext();
        this.zzdnz = zzve.zzov().zzc(context, str, new zzakz());
    }

    public final Bundle getAdMetadata() {
        try {
            return this.zzdnz.getAdMetadata();
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
            return new Bundle();
        }
    }

    public final String getMediationAdapterClassName() {
        try {
            return this.zzdnz.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
            return "";
        }
    }

    @Nullable
    public final RewardItem getRewardItem() {
        try {
            zzasf zzpz = this.zzdnz.zzpz();
            if (zzpz == null) {
                return null;
            }
            return new zzasu(zzpz);
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final boolean isLoaded() {
        try {
            return this.zzdnz.isLoaded();
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        try {
            this.zzdnz.zza(new zzyn(onAdMetadataChangedListener));
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        try {
            this.zzdnz.zza(new zzatb(serverSideVerificationOptions));
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback) {
        try {
            this.zzdnz.zza(new zzasx(rewardedAdCallback));
            this.zzdnz.zzh(ObjectWrapper.wrap(activity));
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback, boolean z) {
        try {
            this.zzdnz.zza(new zzasx(rewardedAdCallback));
            this.zzdnz.zza(ObjectWrapper.wrap(activity), z);
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzxj zzxjVar, RewardedAdLoadCallback rewardedAdLoadCallback) {
        try {
            this.zzdnz.zza(zzuh.zza(this.zzyv, zzxjVar), new zzasy(rewardedAdLoadCallback));
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
    }
}
