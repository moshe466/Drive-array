package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class zzcru implements zzcty<Bundle> {
    private final Bundle zzgfv;

    public zzcru(Bundle bundle) {
        this.zzgfv = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final /* synthetic */ void zzr(Bundle bundle) {
        bundle.putBundle("content_info", this.zzgfv);
    }
}
