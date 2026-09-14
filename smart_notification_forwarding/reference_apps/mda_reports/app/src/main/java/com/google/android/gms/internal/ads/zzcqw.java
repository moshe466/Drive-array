package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class zzcqw implements zzcty<Bundle> {
    private final boolean zzgfd = false;
    private final boolean zzgfe = false;
    private final boolean zzgff;

    public zzcqw(boolean z, boolean z2, boolean z3) {
        this.zzgff = z3;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putBoolean("c_pcbg", this.zzgfd);
        bundle2.putBoolean("c_phbg", this.zzgfe);
        bundle2.putBoolean("ar_lr", this.zzgff);
    }
}
