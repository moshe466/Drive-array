package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.RateLimitProto;
import com.google.firebase.inappmessaging.model.RateLimit;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class RateLimiterClient$$Lambda$1 implements Function {
    private final RateLimiterClient arg$1;
    private final RateLimit arg$2;

    private RateLimiterClient$$Lambda$1(RateLimiterClient rateLimiterClient, RateLimit rateLimit) {
        this.arg$1 = rateLimiterClient;
        this.arg$2 = rateLimit;
    }

    public static Function lambdaFactory$(RateLimiterClient rateLimiterClient, RateLimit rateLimit) {
        return new RateLimiterClient$$Lambda$1(rateLimiterClient, rateLimit);
    }

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        CompletableSource flatMapCompletable;
        flatMapCompletable = Observable.just(r3.getLimitsOrDefault(r1.limiterKey(), r0.newCounter())).filter(RateLimiterClient$$Lambda$6.lambdaFactory$(r0, r1)).switchIfEmpty(Observable.just(r0.newCounter())).map(RateLimiterClient$$Lambda$7.lambdaFactory$((RateLimitProto.RateLimit) obj, this.arg$2)).flatMapCompletable(RateLimiterClient$$Lambda$8.lambdaFactory$(this.arg$1));
        return flatMapCompletable;
    }
}
