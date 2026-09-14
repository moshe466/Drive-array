package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import io.reactivex.functions.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class InAppMessageStreamManager$$Lambda$21 implements Function {
    private final InAppMessageStreamManager arg$1;

    private InAppMessageStreamManager$$Lambda$21(InAppMessageStreamManager inAppMessageStreamManager) {
        this.arg$1 = inAppMessageStreamManager;
    }

    public static Function lambdaFactory$(InAppMessageStreamManager inAppMessageStreamManager) {
        return new InAppMessageStreamManager$$Lambda$21(inAppMessageStreamManager);
    }

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        return InAppMessageStreamManager.b(this.arg$1, (CampaignImpressionList) obj);
    }
}
