package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class zzcry implements zzcty<Bundle> {
    private final String zzdjo;
    private final boolean zzdjq;

    public zzcry(String str, boolean z) {
        this.zzdjo = str;
        this.zzdjq = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putString("gct", this.zzdjo);
        if (this.zzdjq) {
            bundle2.putString("de", "1");
        }
    }
}
