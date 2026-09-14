package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import io.reactivex.functions.Function;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class ImpressionStorageClient$$Lambda$4 implements Function {
    private static final ImpressionStorageClient$$Lambda$4 instance = new ImpressionStorageClient$$Lambda$4();

    private ImpressionStorageClient$$Lambda$4() {
    }

    public static Function lambdaFactory$() {
        return instance;
    }

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        return ((CampaignImpressionList) obj).getAlreadySeenCampaignsList();
    }
}
