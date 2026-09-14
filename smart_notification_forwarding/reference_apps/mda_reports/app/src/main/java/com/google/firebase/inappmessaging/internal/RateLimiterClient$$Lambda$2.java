package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.RateLimitProto;
import com.google.firebase.inappmessaging.model.RateLimit;
import io.reactivex.functions.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class RateLimiterClient$$Lambda$2 implements Function {
    private final RateLimiterClient arg$1;
    private final RateLimit arg$2;

    private RateLimiterClient$$Lambda$2(RateLimiterClient rateLimiterClient, RateLimit rateLimit) {
        this.arg$1 = rateLimiterClient;
        this.arg$2 = rateLimit;
    }

    public static Function lambdaFactory$(RateLimiterClient rateLimiterClient, RateLimit rateLimit) {
        return new RateLimiterClient$$Lambda$2(rateLimiterClient, rateLimit);
    }

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        RateLimitProto.Counter limitsOrDefault;
        RateLimitProto.RateLimit rateLimit = (RateLimitProto.RateLimit) obj;
        limitsOrDefault = rateLimit.getLimitsOrDefault(this.arg$2.limiterKey(), this.arg$1.newCounter());
        return limitsOrDefault;
    }
}
