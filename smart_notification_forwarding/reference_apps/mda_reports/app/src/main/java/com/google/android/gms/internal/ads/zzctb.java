package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class zzctb implements zzcty<Bundle> {
    private final Bundle zzfhf;

    public zzctb(Bundle bundle) {
        this.zzfhf = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        Bundle bundle3 = this.zzfhf;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
    }
}
