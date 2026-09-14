package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;

/* loaded from: classes.dex */
public final class zzasu implements RewardItem {
    private final zzasf zzdny;

    public zzasu(zzasf zzasfVar) {
        this.zzdny = zzasfVar;
    }

    @Override // com.google.android.gms.ads.rewarded.RewardItem
    public final int getAmount() {
        zzasf zzasfVar = this.zzdny;
        if (zzasfVar == null) {
            return 0;
        }
        try {
            return zzasfVar.getAmount();
        } catch (RemoteException e) {
            zzayu.zzd("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }

    @Override // com.google.android.gms.ads.rewarded.RewardItem
    public final String getType() {
        zzasf zzasfVar = this.zzdny;
        if (zzasfVar == null) {
            return null;
        }
        try {
            return zzasfVar.getType();
        } catch (RemoteException e) {
            zzayu.zzd("Could not forward getType to RewardItem", e);
            return null;
        }
    }
}
