package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.rewarded.RewardItem;

/* loaded from: classes.dex */
public final class zzatc extends zzase {
    private final String type;
    private final int zzdno;

    public zzatc(@Nullable RewardItem rewardItem) {
        this(rewardItem != null ? rewardItem.getType() : "", rewardItem != null ? rewardItem.getAmount() : 1);
    }

    public zzatc(@Nullable zzasd zzasdVar) {
        this(zzasdVar != null ? zzasdVar.type : "", zzasdVar != null ? zzasdVar.zzdno : 1);
    }

    public zzatc(String str, int i) {
        this.type = str;
        this.zzdno = i;
    }

    @Override // com.google.android.gms.internal.ads.zzasf
    public final int getAmount() {
        return this.zzdno;
    }

    @Override // com.google.android.gms.internal.ads.zzasf
    public final String getType() {
        return this.type;
    }
}
