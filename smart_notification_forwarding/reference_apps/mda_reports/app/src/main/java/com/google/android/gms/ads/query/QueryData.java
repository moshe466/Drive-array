package com.google.android.gms.ads.query;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzapj;
import com.google.android.gms.internal.ads.zzxx;

@KeepForSdk
/* loaded from: classes.dex */
public class QueryData {
    private zzxx zzgrs;

    public QueryData(zzxx zzxxVar) {
        this.zzgrs = zzxxVar;
    }

    @KeepForSdk
    public static void generate(QueryDataConfiguration queryDataConfiguration, QueryDataGenerationCallback queryDataGenerationCallback) {
        new zzapj(queryDataConfiguration).zza(queryDataGenerationCallback);
    }

    @KeepForSdk
    public String getQuery() {
        return this.zzgrs.getQuery();
    }
}
