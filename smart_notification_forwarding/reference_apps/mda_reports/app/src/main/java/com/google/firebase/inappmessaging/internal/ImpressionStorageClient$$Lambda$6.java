package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpression;
import io.reactivex.functions.Function;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class ImpressionStorageClient$$Lambda$6 implements Function {
    private static final ImpressionStorageClient$$Lambda$6 instance = new ImpressionStorageClient$$Lambda$6();

    private ImpressionStorageClient$$Lambda$6() {
    }

    public static Function lambdaFactory$() {
        return instance;
    }

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        return ((CampaignImpression) obj).getCampaignId();
    }
}
