package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class InAppMessageStreamManager$$Lambda$12 implements Function {
    private final InAppMessageStreamManager arg$1;
    private final String arg$2;

    private InAppMessageStreamManager$$Lambda$12(InAppMessageStreamManager inAppMessageStreamManager, String str) {
        this.arg$1 = inAppMessageStreamManager;
        this.arg$2 = str;
    }

    public static Function lambdaFactory$(InAppMessageStreamManager inAppMessageStreamManager, String str) {
        return new InAppMessageStreamManager$$Lambda$12(inAppMessageStreamManager, str);
    }

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        MaybeSource triggeredInAppMessage;
        triggeredInAppMessage = this.arg$1.triggeredInAppMessage((CampaignProto.ThickContent) obj, this.arg$2);
        return triggeredInAppMessage;
    }
}
