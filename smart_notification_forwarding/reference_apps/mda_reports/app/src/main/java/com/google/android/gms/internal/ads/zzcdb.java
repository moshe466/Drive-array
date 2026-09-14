package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzso;

/* loaded from: classes.dex */
public final class zzcdb implements zzdxg<zzcdh> {
    private static final zzcdb zzfsc = new zzcdb();

    public static zzcdb zzalb() {
        return zzfsc;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzcdh) zzdxm.zza(new zzcdh(zzso.zza.EnumC0023zza.REQUEST_WILL_UPDATE_GMS_SIGNALS, zzso.zza.EnumC0023zza.REQUEST_DID_UPDATE_GMS_SIGNALS, zzso.zza.EnumC0023zza.REQUEST_FAILED_TO_UPDATE_GMS_SIGNALS), "Cannot return null from a non-@Nullable @Provides method");
    }
}
