package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.functions.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class CampaignCacheClient$$Lambda$3 implements Consumer {
    private final CampaignCacheClient arg$1;

    private CampaignCacheClient$$Lambda$3(CampaignCacheClient campaignCacheClient) {
        this.arg$1 = campaignCacheClient;
    }

    public static Consumer lambdaFactory$(CampaignCacheClient campaignCacheClient) {
        return new CampaignCacheClient$$Lambda$3(campaignCacheClient);
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(Object obj) {
        this.arg$1.cachedResponse = (FetchEligibleCampaignsResponse) obj;
    }
}
