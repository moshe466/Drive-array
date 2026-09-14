package com.google.android.gms.ads.query;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes.dex */
public class QueryDataConfiguration {
    private final String zzbqz;
    private final Context zzup;

    /* JADX INFO: Access modifiers changed from: package-private */
    @KeepForSdk
    public QueryDataConfiguration(Context context, String str) {
        this.zzup = context;
        this.zzbqz = str;
    }

    @KeepForSdk
    public String getAdUnitId() {
        return this.zzbqz;
    }

    @KeepForSdk
    public Context getContext() {
        return this.zzup;
    }
}
