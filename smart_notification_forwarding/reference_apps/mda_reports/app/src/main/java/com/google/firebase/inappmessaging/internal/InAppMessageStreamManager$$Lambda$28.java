package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import io.reactivex.functions.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class InAppMessageStreamManager$$Lambda$28 implements Consumer {
    private final CampaignProto.ThickContent arg$1;

    private InAppMessageStreamManager$$Lambda$28(CampaignProto.ThickContent thickContent) {
        this.arg$1 = thickContent;
    }

    public static Consumer lambdaFactory$(CampaignProto.ThickContent thickContent) {
        return new InAppMessageStreamManager$$Lambda$28(thickContent);
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(Object obj) {
        Logging.logi(String.format("Already impressed %s ? : %s", this.arg$1.getVanillaPayload().getCampaignName(), (Boolean) obj));
    }
}
