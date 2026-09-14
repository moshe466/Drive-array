package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzso;

/* loaded from: classes.dex */
public final class zzcdc implements zzdxg<zzcdh> {
    private static final zzcdc zzfsd = new zzcdc();

    public static zzcdc zzalc() {
        return zzfsd;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzcdh) zzdxm.zza(new zzcdh(zzso.zza.EnumC0023zza.REQUEST_WILL_BUILD_URL, zzso.zza.EnumC0023zza.REQUEST_DID_BUILD_URL, zzso.zza.EnumC0023zza.REQUEST_FAILED_TO_BUILD_URL), "Cannot return null from a non-@Nullable @Provides method");
    }
}
