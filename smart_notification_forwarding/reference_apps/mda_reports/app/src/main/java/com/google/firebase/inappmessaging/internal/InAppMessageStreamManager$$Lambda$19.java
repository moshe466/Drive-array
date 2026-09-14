package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.Maybe;
import io.reactivex.functions.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class InAppMessageStreamManager$$Lambda$19 implements Function {
    private final InAppMessageStreamManager arg$1;
    private final String arg$2;
    private final Function arg$3;
    private final Function arg$4;
    private final Function arg$5;

    private InAppMessageStreamManager$$Lambda$19(InAppMessageStreamManager inAppMessageStreamManager, String str, Function function, Function function2, Function function3) {
        this.arg$1 = inAppMessageStreamManager;
        this.arg$2 = str;
        this.arg$3 = function;
        this.arg$4 = function2;
        this.arg$5 = function3;
    }

    public static Function lambdaFactory$(InAppMessageStreamManager inAppMessageStreamManager, String str, Function function, Function function2, Function function3) {
        return new InAppMessageStreamManager$$Lambda$19(inAppMessageStreamManager, str, function, function2, function3);
    }

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        Maybe triggeredInAppMessageMaybe;
        triggeredInAppMessageMaybe = this.arg$1.getTriggeredInAppMessageMaybe(this.arg$2, this.arg$3, this.arg$4, this.arg$5, (FetchEligibleCampaignsResponse) obj);
        return triggeredInAppMessageMaybe;
    }
}
