package com.google.android.gms.ads.query;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes.dex */
public class AdData {
    private final QueryData zzgrq;
    private final String zzgrr;

    @KeepForSdk
    public AdData(QueryData queryData, String str) {
        this.zzgrq = queryData;
        this.zzgrr = str;
    }

    @KeepForSdk
    public static String getRequestId(String str) {
        return "";
    }

    @KeepForSdk
    public String getAdString() {
        return this.zzgrr;
    }

    @KeepForSdk
    public QueryData getQueryData() {
        return this.zzgrq;
    }
}
