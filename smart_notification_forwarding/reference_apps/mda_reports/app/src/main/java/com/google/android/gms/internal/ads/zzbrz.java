package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzbrz implements zzdxg<Set<zzbsu<AdMetadataListener>>> {
    private final zzbrm zzfim;

    private zzbrz(zzbrm zzbrmVar) {
        this.zzfim = zzbrmVar;
    }

    public static zzbrz zzp(zzbrm zzbrmVar) {
        return new zzbrz(zzbrmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (Set) zzdxm.zza(this.zzfim.zzahq(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
