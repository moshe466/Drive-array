package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzso;

/* loaded from: classes.dex */
public final class zzcdd implements zzdxg<zzcdh> {
    private static final zzcdd zzfse = new zzcdd();

    public static zzcdd zzald() {
        return zzfse;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzcdh) zzdxm.zza(new zzcdh(zzso.zza.EnumC0023zza.REQUEST_WILL_PROCESS_RESPONSE, zzso.zza.EnumC0023zza.REQUEST_DID_PROCESS_RESPONSE, zzso.zza.EnumC0023zza.REQUEST_FAILED_TO_PROCESS_RESPONSE), "Cannot return null from a non-@Nullable @Provides method");
    }
}
