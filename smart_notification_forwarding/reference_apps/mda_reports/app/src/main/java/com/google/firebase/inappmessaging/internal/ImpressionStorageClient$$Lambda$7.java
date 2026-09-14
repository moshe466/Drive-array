package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import io.reactivex.functions.Action;

/* loaded from: classes2.dex */
public final /* synthetic */ class ImpressionStorageClient$$Lambda$7 implements Action {
    private final ImpressionStorageClient arg$1;
    private final CampaignImpressionList arg$2;

    private ImpressionStorageClient$$Lambda$7(ImpressionStorageClient impressionStorageClient, CampaignImpressionList campaignImpressionList) {
        this.arg$1 = impressionStorageClient;
        this.arg$2 = campaignImpressionList;
    }

    public static Action lambdaFactory$(ImpressionStorageClient impressionStorageClient, CampaignImpressionList campaignImpressionList) {
        return new ImpressionStorageClient$$Lambda$7(impressionStorageClient, campaignImpressionList);
    }

    @Override // io.reactivex.functions.Action
    public void run() {
        this.arg$1.initInMemCache(this.arg$2);
    }
}
