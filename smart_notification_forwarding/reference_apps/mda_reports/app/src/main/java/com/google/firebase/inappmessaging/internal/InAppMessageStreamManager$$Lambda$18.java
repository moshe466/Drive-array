package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import io.reactivex.functions.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class InAppMessageStreamManager$$Lambda$18 implements Function {
    private static final InAppMessageStreamManager$$Lambda$18 instance = new InAppMessageStreamManager$$Lambda$18();

    private InAppMessageStreamManager$$Lambda$18() {
    }

    public static Function lambdaFactory$() {
        return instance;
    }

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        return InAppMessageStreamManager.a((CampaignProto.ThickContent) obj);
    }
}
