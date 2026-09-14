package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzso;

/* loaded from: classes.dex */
public final class zzccr implements zzdxg<zzcdh> {
    private static final zzccr zzfrv = new zzccr();

    public static zzccr zzaky() {
        return zzfrv;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzcdh) zzdxm.zza(new zzcdh(zzso.zza.EnumC0023zza.REQUEST_WILL_RENDER, zzso.zza.EnumC0023zza.REQUEST_DID_RENDER, zzso.zza.EnumC0023zza.REQUEST_FAILED_TO_RENDER), "Cannot return null from a non-@Nullable @Provides method");
    }
}
