package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class zzcsc implements zzcty<Bundle> {
    private final Bundle zzdjn;

    public zzcsc(Bundle bundle) {
        this.zzdjn = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        Bundle zza = zzdaa.zza(bundle2, "device");
        zza.putBundle("android_mem_info", this.zzdjn);
        bundle2.putBundle("device", zza);
    }
}
