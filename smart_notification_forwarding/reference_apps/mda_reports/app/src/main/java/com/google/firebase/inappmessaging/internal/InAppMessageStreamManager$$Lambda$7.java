package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import io.reactivex.functions.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class InAppMessageStreamManager$$Lambda$7 implements Function {
    private final CampaignProto.ThickContent arg$1;

    private InAppMessageStreamManager$$Lambda$7(CampaignProto.ThickContent thickContent) {
        this.arg$1 = thickContent;
    }

    public static Function lambdaFactory$(CampaignProto.ThickContent thickContent) {
        return new InAppMessageStreamManager$$Lambda$7(thickContent);
    }

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        CampaignProto.ThickContent thickContent = this.arg$1;
        InAppMessageStreamManager.c(thickContent, (Boolean) obj);
        return thickContent;
    }
}
