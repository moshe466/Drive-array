package com.google.android.gms.ads.query;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes.dex */
public class BannerQueryDataConfiguration extends QueryDataConfiguration {
    private final AdSize zzdi;

    @KeepForSdk
    public BannerQueryDataConfiguration(Context context, String str, AdSize adSize) {
        super(context, str);
        this.zzdi = adSize;
    }

    @KeepForSdk
    public AdSize getAdSize() {
        return this.zzdi;
    }
}
