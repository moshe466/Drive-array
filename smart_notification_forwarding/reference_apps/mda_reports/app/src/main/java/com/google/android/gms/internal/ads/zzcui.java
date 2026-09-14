package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class zzcui implements zzcty<Bundle> {
    private final String zzdmn;
    private final int zzdmo;
    private final int zzdmp;
    private final int zzdmq;
    private final boolean zzdmr;
    private final int zzdms;

    public zzcui(String str, int i, int i2, int i3, boolean z, int i4) {
        this.zzdmn = str;
        this.zzdmo = i;
        this.zzdmp = i2;
        this.zzdmq = i3;
        this.zzdmr = z;
        this.zzdms = i4;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzdaa.zza(bundle2, "carrier", this.zzdmn, !TextUtils.isEmpty(r0));
        zzdaa.zza(bundle2, "cnt", Integer.valueOf(this.zzdmo), this.zzdmo != -2);
        bundle2.putInt("gnt", this.zzdmp);
        bundle2.putInt("pt", this.zzdmq);
        Bundle zza = zzdaa.zza(bundle2, "device");
        bundle2.putBundle("device", zza);
        Bundle zza2 = zzdaa.zza(zza, "network");
        zza.putBundle("network", zza2);
        zza2.putInt("active_network_state", this.zzdms);
        zza2.putBoolean("active_network_metered", this.zzdmr);
    }
}
