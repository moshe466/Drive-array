package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzbvo implements zzdxg<Set<String>> {
    private final zzdxp<zzbwz> zzfeh;

    public zzbvo(zzdxp<zzbwz> zzdxpVar) {
        this.zzfeh = zzdxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (Set) zzdxm.zza(this.zzfeh.get().zzajs() != null ? Collections.singleton("banner") : Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
