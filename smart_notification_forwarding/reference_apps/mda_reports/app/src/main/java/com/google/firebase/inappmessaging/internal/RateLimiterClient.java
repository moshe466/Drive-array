package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.RateLimitProto;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.RateLimit;
import com.google.firebase.inappmessaging.internal.time.Clock;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class RateLimiterClient {
    private static final RateLimitProto.RateLimit EMPTY_RATE_LIMITS = RateLimitProto.RateLimit.getDefaultInstance();
    private Maybe<RateLimitProto.RateLimit> cachedRateLimts = Maybe.empty();
    private final Clock clock;
    private final ProtoStorageClient storageClient;

    @Inject
    public RateLimiterClient(@RateLimit ProtoStorageClient protoStorageClient, Clock clock) {
        this.storageClient = protoStorageClient;
        this.clock = clock;
    }

    public static /* synthetic */ boolean a(RateLimiterClient rateLimiterClient, com.google.firebase.inappmessaging.model.RateLimit rateLimit, RateLimitProto.Counter counter) {
        return !rateLimiterClient.isLimitExpired(counter, rateLimit);
    }

    public static /* synthetic */ boolean b(RateLimiterClient rateLimiterClient, com.google.firebase.inappmessaging.model.RateLimit rateLimit, RateLimitProto.Counter counter) {
        return rateLimiterClient.isLimitExpired(counter, rateLimit) || counter.getValue() < rateLimit.limit();
    }

    public void clearInMemCache() {
        this.cachedRateLimts = Maybe.empty();
    }

    private Maybe<RateLimitProto.RateLimit> getRateLimits() {
        return this.cachedRateLimts.switchIfEmpty(this.storageClient.read(RateLimitProto.RateLimit.parser()).doOnSuccess(RateLimiterClient$$Lambda$4.lambdaFactory$(this))).doOnError(RateLimiterClient$$Lambda$5.lambdaFactory$(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RateLimitProto.Counter increment(RateLimitProto.Counter counter) {
        return RateLimitProto.Counter.newBuilder(counter).clearValue().setValue(counter.getValue() + 1).build();
    }

    public void initInMemCache(RateLimitProto.RateLimit rateLimit) {
        this.cachedRateLimts = Maybe.just(rateLimit);
    }

    private boolean isLimitExpired(RateLimitProto.Counter counter, com.google.firebase.inappmessaging.model.RateLimit rateLimit) {
        return this.clock.now() - counter.getStartTimeEpoch() > rateLimit.timeToLiveMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RateLimitProto.Counter newCounter() {
        return RateLimitProto.Counter.newBuilder().setValue(0L).setStartTimeEpoch(this.clock.now()).build();
    }

    public Completable increment(com.google.firebase.inappmessaging.model.RateLimit rateLimit) {
        return getRateLimits().defaultIfEmpty(EMPTY_RATE_LIMITS).flatMapCompletable(RateLimiterClient$$Lambda$1.lambdaFactory$(this, rateLimit));
    }

    public Single<Boolean> isRateLimited(com.google.firebase.inappmessaging.model.RateLimit rateLimit) {
        return getRateLimits().switchIfEmpty(Maybe.just(RateLimitProto.RateLimit.getDefaultInstance())).map(RateLimiterClient$$Lambda$2.lambdaFactory$(this, rateLimit)).filter(RateLimiterClient$$Lambda$3.lambdaFactory$(this, rateLimit)).isEmpty();
    }
}
