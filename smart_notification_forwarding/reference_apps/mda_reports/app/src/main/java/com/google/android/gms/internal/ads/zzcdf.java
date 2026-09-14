package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes.dex */
public final class zzcdf implements zzdcx {
    private zzsm zzfry;
    private Map<zzdco, zzcdh> zzfsg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcdf(zzsm zzsmVar, Map<zzdco, zzcdh> map) {
        this.zzfsg = map;
        this.zzfry = zzsmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdcx
    public final void zza(zzdco zzdcoVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdcx
    public final void zza(zzdco zzdcoVar, String str, Throwable th) {
        if (this.zzfsg.containsKey(zzdcoVar)) {
            this.zzfry.zza(this.zzfsg.get(zzdcoVar).zzfsl);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcx
    public final void zzb(zzdco zzdcoVar, String str) {
        if (this.zzfsg.containsKey(zzdcoVar)) {
            this.zzfry.zza(this.zzfsg.get(zzdcoVar).zzfsj);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcx
    public final void zzc(zzdco zzdcoVar, String str) {
        if (this.zzfsg.containsKey(zzdcoVar)) {
            this.zzfry.zza(this.zzfsg.get(zzdcoVar).zzfsk);
        }
    }
}
