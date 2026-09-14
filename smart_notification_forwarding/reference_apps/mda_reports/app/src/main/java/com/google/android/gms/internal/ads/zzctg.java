package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class zzctg implements zzcty<Bundle> {
    private final String zzggi;

    public zzctg(String str) {
        this.zzggi = str;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final /* synthetic */ void zzr(Bundle bundle) {
        bundle.putString("rtb", this.zzggi);
    }
}
