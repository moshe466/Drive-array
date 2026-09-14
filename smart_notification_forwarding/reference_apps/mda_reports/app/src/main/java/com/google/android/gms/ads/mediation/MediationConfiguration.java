package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import com.google.android.gms.ads.AdFormat;

/* loaded from: classes.dex */
public class MediationConfiguration {
    private final Bundle zzeig;
    private final AdFormat zzeik;

    public MediationConfiguration(AdFormat adFormat, Bundle bundle) {
        this.zzeik = adFormat;
        this.zzeig = bundle;
    }

    public AdFormat getFormat() {
        return this.zzeik;
    }

    public Bundle getServerParameters() {
        return this.zzeig;
    }
}
