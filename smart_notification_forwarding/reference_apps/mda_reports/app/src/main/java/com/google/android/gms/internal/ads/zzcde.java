package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzso;

/* loaded from: classes.dex */
public final class zzcde implements zzdxg<zzcdh> {
    private static final zzcde zzfsf = new zzcde();

    public static zzcde zzale() {
        return zzfsf;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzcdh) zzdxm.zza(new zzcdh(zzso.zza.EnumC0023zza.REQUEST_WILL_MAKE_NETWORK_REQUEST, zzso.zza.EnumC0023zza.REQUEST_DID_RECEIVE_NETWORK_RESPONSE, zzso.zza.EnumC0023zza.REQUEST_FAILED_TO_MAKE_NETWORK_REQUEST), "Cannot return null from a non-@Nullable @Provides method");
    }
}
