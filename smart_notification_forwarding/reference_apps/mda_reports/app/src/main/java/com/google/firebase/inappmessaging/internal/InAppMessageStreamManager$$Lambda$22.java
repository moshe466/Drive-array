package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final /* synthetic */ class InAppMessageStreamManager$$Lambda$22 implements Callable {
    private final InAppMessageStreamManager arg$1;
    private final CampaignImpressionList arg$2;

    private InAppMessageStreamManager$$Lambda$22(InAppMessageStreamManager inAppMessageStreamManager, CampaignImpressionList campaignImpressionList) {
        this.arg$1 = inAppMessageStreamManager;
        this.arg$2 = campaignImpressionList;
    }

    public static Callable lambdaFactory$(InAppMessageStreamManager inAppMessageStreamManager, CampaignImpressionList campaignImpressionList) {
        return new InAppMessageStreamManager$$Lambda$22(inAppMessageStreamManager, campaignImpressionList);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        FetchEligibleCampaignsResponse a;
        a = this.arg$1.apiClient.a(this.arg$2);
        return a;
    }
}
