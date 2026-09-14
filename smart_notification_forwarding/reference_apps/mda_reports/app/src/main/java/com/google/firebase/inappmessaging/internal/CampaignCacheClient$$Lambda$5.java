package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Consumer;

/* loaded from: classes2.dex */
final /* synthetic */ class CampaignCacheClient$$Lambda$5 implements Consumer {
    private final CampaignCacheClient arg$1;

    private CampaignCacheClient$$Lambda$5(CampaignCacheClient campaignCacheClient) {
        this.arg$1 = campaignCacheClient;
    }

    public static Consumer lambdaFactory$(CampaignCacheClient campaignCacheClient) {
        return new CampaignCacheClient$$Lambda$5(campaignCacheClient);
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(Object obj) {
        CampaignCacheClient.a(this.arg$1, (Throwable) obj);
    }
}
