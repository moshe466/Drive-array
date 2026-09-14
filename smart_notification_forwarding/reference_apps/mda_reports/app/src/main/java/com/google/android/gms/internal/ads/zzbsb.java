package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzbsb implements zzdxg<Set<zzbsu<AppEventListener>>> {
    private final zzbrm zzfim;

    private zzbsb(zzbrm zzbrmVar) {
        this.zzfim = zzbrmVar;
    }

    public static zzbsb zzs(zzbrm zzbrmVar) {
        return new zzbsb(zzbrmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (Set) zzdxm.zza(this.zzfim.zzahr(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
