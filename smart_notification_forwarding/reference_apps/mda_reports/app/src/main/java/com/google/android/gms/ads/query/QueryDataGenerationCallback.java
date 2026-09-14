package com.google.android.gms.ads.query;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes.dex */
public interface QueryDataGenerationCallback {
    @KeepForSdk
    void onFailure(String str);

    @KeepForSdk
    void onSuccess(QueryData queryData);
}
