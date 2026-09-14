package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.query.QueryData;
import com.google.android.gms.ads.query.QueryDataGenerationCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzapl extends zzaum {
    private final /* synthetic */ QueryDataGenerationCallback zzdid;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzapl(zzapj zzapjVar, QueryDataGenerationCallback queryDataGenerationCallback) {
        this.zzdid = queryDataGenerationCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzaun
    public final void onError(String str) {
        this.zzdid.onFailure(str);
    }

    @Override // com.google.android.gms.internal.ads.zzaun
    public final void zzk(String str, String str2) {
        QueryData queryData = new QueryData(new zzxx(str));
        zzve.zzpc().put(queryData, str2);
        this.zzdid.onSuccess(queryData);
    }
}
