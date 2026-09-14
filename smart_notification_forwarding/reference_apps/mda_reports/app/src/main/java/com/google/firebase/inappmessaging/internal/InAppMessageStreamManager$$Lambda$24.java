package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class InAppMessageStreamManager$$Lambda$24 implements Consumer {
    private final AnalyticsEventsManager arg$1;

    private InAppMessageStreamManager$$Lambda$24(AnalyticsEventsManager analyticsEventsManager) {
        this.arg$1 = analyticsEventsManager;
    }

    public static Consumer lambdaFactory$(AnalyticsEventsManager analyticsEventsManager) {
        return new InAppMessageStreamManager$$Lambda$24(analyticsEventsManager);
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(Object obj) {
        this.arg$1.updateContextualTriggers((FetchEligibleCampaignsResponse) obj);
    }
}
