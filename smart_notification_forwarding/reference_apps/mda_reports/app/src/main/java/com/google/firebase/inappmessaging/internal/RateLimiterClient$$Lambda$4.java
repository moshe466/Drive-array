package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.RateLimitProto;
import io.reactivex.functions.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class RateLimiterClient$$Lambda$4 implements Consumer {
    private final RateLimiterClient arg$1;

    private RateLimiterClient$$Lambda$4(RateLimiterClient rateLimiterClient) {
        this.arg$1 = rateLimiterClient;
    }

    public static Consumer lambdaFactory$(RateLimiterClient rateLimiterClient) {
        return new RateLimiterClient$$Lambda$4(rateLimiterClient);
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(Object obj) {
        this.arg$1.initInMemCache((RateLimitProto.RateLimit) obj);
    }
}
