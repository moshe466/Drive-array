package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzbrc implements zzdxg<zzbra> {
    private final zzdxp<Set<zzbsu<AppEventListener>>> zzfeo;

    private zzbrc(zzdxp<Set<zzbsu<AppEventListener>>> zzdxpVar) {
        this.zzfeo = zzdxpVar;
    }

    public static zzbrc zzp(zzdxp<Set<zzbsu<AppEventListener>>> zzdxpVar) {
        return new zzbrc(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbra(this.zzfeo.get());
    }
}
