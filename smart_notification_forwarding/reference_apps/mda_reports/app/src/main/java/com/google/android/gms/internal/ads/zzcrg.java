package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class zzcrg implements zzcty<Bundle> {
    private final double zzdmt;
    private final boolean zzdmu;

    public zzcrg(double d, boolean z) {
        this.zzdmt = d;
        this.zzdmu = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        Bundle zza = zzdaa.zza(bundle2, "device");
        bundle2.putBundle("device", zza);
        Bundle zza2 = zzdaa.zza(zza, "battery");
        zza.putBundle("battery", zza2);
        zza2.putBoolean("is_charging", this.zzdmu);
        zza2.putDouble("battery_level", this.zzdmt);
    }
}
