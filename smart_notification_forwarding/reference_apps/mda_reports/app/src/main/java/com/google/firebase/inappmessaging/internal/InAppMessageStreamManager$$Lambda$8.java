package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import io.reactivex.functions.Predicate;

/* loaded from: classes2.dex */
public final /* synthetic */ class InAppMessageStreamManager$$Lambda$8 implements Predicate {
    private static final InAppMessageStreamManager$$Lambda$8 instance = new InAppMessageStreamManager$$Lambda$8();

    private InAppMessageStreamManager$$Lambda$8() {
    }

    public static Predicate lambdaFactory$() {
        return instance;
    }

    @Override // io.reactivex.functions.Predicate
    public boolean test(Object obj) {
        boolean equals;
        equals = ((CampaignProto.ThickContent) obj).getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.VANILLA_PAYLOAD);
        return equals;
    }
}
