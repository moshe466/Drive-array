package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class zzcrc implements zzcty<Bundle> {
    private final float zzdje;
    private final int zzdmh;
    private final boolean zzdmi;
    private final boolean zzdmj;
    private final int zzdmk;
    private final int zzdml;
    private final int zzdmm;
    private final boolean zzgfj;

    public zzcrc(int i, boolean z, boolean z2, int i2, int i3, int i4, float f, boolean z3) {
        this.zzdmh = i;
        this.zzdmi = z;
        this.zzdmj = z2;
        this.zzdmk = i2;
        this.zzdml = i3;
        this.zzdmm = i4;
        this.zzdje = f;
        this.zzgfj = z3;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putInt("am", this.zzdmh);
        bundle2.putBoolean("ma", this.zzdmi);
        bundle2.putBoolean("sp", this.zzdmj);
        bundle2.putInt("muv", this.zzdmk);
        bundle2.putInt("rm", this.zzdml);
        bundle2.putInt("riv", this.zzdmm);
        bundle2.putFloat("android_app_volume", this.zzdje);
        bundle2.putBoolean("android_app_muted", this.zzgfj);
    }
}
