package com.google.android.gms.internal.ads;

import android.os.Bundle;
import io.fabric.sdk.android.services.network.HttpRequest;

/* loaded from: classes.dex */
public final class zzctt implements zzcty<Bundle> {
    private final String zzbma;
    private final int zzdjf;
    private final boolean zzdkc;
    private final boolean zzdwc;
    private final boolean zzggt;
    private final int zzggu;
    private final int zzggv;

    public zzctt(boolean z, boolean z2, String str, boolean z3, int i, int i2, int i3) {
        this.zzggt = z;
        this.zzdwc = z2;
        this.zzbma = str;
        this.zzdkc = z3;
        this.zzdjf = i;
        this.zzggu = i2;
        this.zzggv = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putString("js", this.zzbma);
        bundle2.putBoolean("is_nonagon", true);
        bundle2.putString("extra_caps", (String) zzve.zzoy().zzd(zzzn.zzclv));
        bundle2.putInt("target_api", this.zzdjf);
        bundle2.putInt("dv", this.zzggu);
        bundle2.putInt("lv", this.zzggv);
        Bundle zza = zzdaa.zza(bundle2, "sdk_env");
        zza.putBoolean("mf", zzaaz.zzcti.get().booleanValue());
        zza.putBoolean("instant_app", this.zzggt);
        zza.putBoolean("lite", this.zzdwc);
        zza.putBoolean("is_privileged_process", this.zzdkc);
        bundle2.putBundle("sdk_env", zza);
        Bundle zza2 = zzdaa.zza(zza, "build_meta");
        zza2.putString("cl", "278033407");
        zza2.putString("rapid_rc", "dev");
        zza2.putString("rapid_rollup", HttpRequest.METHOD_HEAD);
        zza.putBundle("build_meta", zza2);
    }
}
