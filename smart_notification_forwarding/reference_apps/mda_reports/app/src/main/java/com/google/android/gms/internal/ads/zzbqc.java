package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzbqc implements zzdxg<zzbqa> {
    private final zzdxp<Set<zzbsu<AdMetadataListener>>> zzfeo;

    private zzbqc(zzdxp<Set<zzbsu<AdMetadataListener>>> zzdxpVar) {
        this.zzfeo = zzdxpVar;
    }

    public static zzbqc zzl(zzdxp<Set<zzbsu<AdMetadataListener>>> zzdxpVar) {
        return new zzbqc(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbqa(this.zzfeo.get());
    }
}
