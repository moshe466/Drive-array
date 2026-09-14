package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Consumer;

/* loaded from: classes2.dex */
final /* synthetic */ class RateLimiterClient$$Lambda$5 implements Consumer {
    private final RateLimiterClient arg$1;

    private RateLimiterClient$$Lambda$5(RateLimiterClient rateLimiterClient) {
        this.arg$1 = rateLimiterClient;
    }

    public static Consumer lambdaFactory$(RateLimiterClient rateLimiterClient) {
        return new RateLimiterClient$$Lambda$5(rateLimiterClient);
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(Object obj) {
        RateLimiterClient.a(this.arg$1, (Throwable) obj);
    }
}
