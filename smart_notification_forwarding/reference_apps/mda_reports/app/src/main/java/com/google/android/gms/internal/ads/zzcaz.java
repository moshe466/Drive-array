package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/* loaded from: classes.dex */
public final class zzcaz implements zzafx {
    private final zzbpm zzfgg;

    @Nullable
    private final zzasd zzfqx;
    private final String zzfqy;
    private final String zzfqz;

    public zzcaz(zzbpm zzbpmVar, zzczl zzczlVar) {
        this.zzfgg = zzbpmVar;
        this.zzfqx = zzczlVar.zzdky;
        this.zzfqy = zzczlVar.zzdcx;
        this.zzfqz = zzczlVar.zzdcy;
    }

    @Override // com.google.android.gms.internal.ads.zzafx
    @ParametersAreNonnullByDefault
    public final void zza(zzasd zzasdVar) {
        String str;
        int i;
        zzasd zzasdVar2 = this.zzfqx;
        if (zzasdVar2 != null) {
            zzasdVar = zzasdVar2;
        }
        if (zzasdVar != null) {
            str = zzasdVar.type;
            i = zzasdVar.zzdno;
        } else {
            str = "";
            i = 1;
        }
        this.zzfgg.zzb(new zzarc(str, i), this.zzfqy, this.zzfqz);
    }

    @Override // com.google.android.gms.internal.ads.zzafx
    public final void zzrs() {
        this.zzfgg.onRewardedVideoStarted();
    }

    @Override // com.google.android.gms.internal.ads.zzafx
    public final void zzrt() {
        this.zzfgg.onRewardedVideoCompleted();
    }
}
