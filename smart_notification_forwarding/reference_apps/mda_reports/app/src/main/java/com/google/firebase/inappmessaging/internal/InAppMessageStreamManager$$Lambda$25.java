package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class InAppMessageStreamManager$$Lambda$25 implements Consumer {
    private final TestDeviceHelper arg$1;

    private InAppMessageStreamManager$$Lambda$25(TestDeviceHelper testDeviceHelper) {
        this.arg$1 = testDeviceHelper;
    }

    public static Consumer lambdaFactory$(TestDeviceHelper testDeviceHelper) {
        return new InAppMessageStreamManager$$Lambda$25(testDeviceHelper);
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(Object obj) {
        this.arg$1.processCampaignFetch((FetchEligibleCampaignsResponse) obj);
    }
}
