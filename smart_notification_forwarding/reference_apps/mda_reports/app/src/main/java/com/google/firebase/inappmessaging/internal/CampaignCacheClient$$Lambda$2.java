package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final /* synthetic */ class CampaignCacheClient$$Lambda$2 implements Callable {
    private final CampaignCacheClient arg$1;

    private CampaignCacheClient$$Lambda$2(CampaignCacheClient campaignCacheClient) {
        this.arg$1 = campaignCacheClient;
    }

    public static Callable lambdaFactory$(CampaignCacheClient campaignCacheClient) {
        return new CampaignCacheClient$$Lambda$2(campaignCacheClient);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse;
        fetchEligibleCampaignsResponse = this.arg$1.cachedResponse;
        return fetchEligibleCampaignsResponse;
    }
}
