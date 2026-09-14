package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import io.reactivex.functions.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class InAppMessageStreamManager$$Lambda$16 implements Function {
    private final InAppMessageStreamManager arg$1;

    private InAppMessageStreamManager$$Lambda$16(InAppMessageStreamManager inAppMessageStreamManager) {
        this.arg$1 = inAppMessageStreamManager;
    }

    public static Function lambdaFactory$(InAppMessageStreamManager inAppMessageStreamManager) {
        return new InAppMessageStreamManager$$Lambda$16(inAppMessageStreamManager);
    }

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        return InAppMessageStreamManager.a(this.arg$1, (CampaignProto.ThickContent) obj);
    }
}
