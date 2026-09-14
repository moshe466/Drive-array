package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzdcz implements zzdxg<zzdcq> {
    private final zzdxp<Set<zzbsu<zzdcx>>> zzfeo;

    private zzdcz(zzdxp<Set<zzbsu<zzdcx>>> zzdxpVar) {
        this.zzfeo = zzdxpVar;
    }

    public static zzdcz zzam(zzdxp<Set<zzbsu<zzdcx>>> zzdxpVar) {
        return new zzdcz(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzdcq(this.zzfeo.get());
    }
}
