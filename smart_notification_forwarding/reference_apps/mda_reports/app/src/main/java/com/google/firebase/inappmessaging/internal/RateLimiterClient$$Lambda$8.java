package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.RateLimitProto;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class RateLimiterClient$$Lambda$8 implements Function {
    private final RateLimiterClient arg$1;

    private RateLimiterClient$$Lambda$8(RateLimiterClient rateLimiterClient) {
        this.arg$1 = rateLimiterClient;
    }

    public static Function lambdaFactory$(RateLimiterClient rateLimiterClient) {
        return new RateLimiterClient$$Lambda$8(rateLimiterClient);
    }

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        CompletableSource doOnComplete;
        doOnComplete = r0.storageClient.write(r2).doOnComplete(RateLimiterClient$$Lambda$9.lambdaFactory$(this.arg$1, (RateLimitProto.RateLimit) obj));
        return doOnComplete;
    }
}
