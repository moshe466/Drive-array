package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.functions.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class InAppMessageStreamManager$$Lambda$15 implements Consumer {
    private final InAppMessageStreamManager arg$1;

    private InAppMessageStreamManager$$Lambda$15(InAppMessageStreamManager inAppMessageStreamManager) {
        this.arg$1 = inAppMessageStreamManager;
    }

    public static Consumer lambdaFactory$(InAppMessageStreamManager inAppMessageStreamManager) {
        return new InAppMessageStreamManager$$Lambda$15(inAppMessageStreamManager);
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(Object obj) {
        this.arg$1.campaignCacheClient.put((FetchEligibleCampaignsResponse) obj).doOnComplete(InAppMessageStreamManager$$Lambda$31.lambdaFactory$()).doOnError(InAppMessageStreamManager$$Lambda$32.lambdaFactory$()).onErrorResumeNext(InAppMessageStreamManager$$Lambda$33.lambdaFactory$()).subscribe();
    }
}
