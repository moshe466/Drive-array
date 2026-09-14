package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.functions.Predicate;

/* loaded from: classes2.dex */
public final /* synthetic */ class CampaignCacheClient$$Lambda$4 implements Predicate {
    private final CampaignCacheClient arg$1;

    private CampaignCacheClient$$Lambda$4(CampaignCacheClient campaignCacheClient) {
        this.arg$1 = campaignCacheClient;
    }

    public static Predicate lambdaFactory$(CampaignCacheClient campaignCacheClient) {
        return new CampaignCacheClient$$Lambda$4(campaignCacheClient);
    }

    @Override // io.reactivex.functions.Predicate
    public boolean test(Object obj) {
        boolean isResponseValid;
        isResponseValid = this.arg$1.isResponseValid((FetchEligibleCampaignsResponse) obj);
        return isResponseValid;
    }
}
