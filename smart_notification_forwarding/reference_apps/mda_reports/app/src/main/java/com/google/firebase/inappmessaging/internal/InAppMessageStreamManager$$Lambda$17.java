package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import io.reactivex.Maybe;
import io.reactivex.functions.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class InAppMessageStreamManager$$Lambda$17 implements Function {
    private final InAppMessageStreamManager arg$1;
    private final String arg$2;

    private InAppMessageStreamManager$$Lambda$17(InAppMessageStreamManager inAppMessageStreamManager, String str) {
        this.arg$1 = inAppMessageStreamManager;
        this.arg$2 = str;
    }

    public static Function lambdaFactory$(InAppMessageStreamManager inAppMessageStreamManager, String str) {
        return new InAppMessageStreamManager$$Lambda$17(inAppMessageStreamManager, str);
    }

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        Maybe contentIfNotRateLimited;
        contentIfNotRateLimited = this.arg$1.getContentIfNotRateLimited(this.arg$2, (CampaignProto.ThickContent) obj);
        return contentIfNotRateLimited;
    }
}
