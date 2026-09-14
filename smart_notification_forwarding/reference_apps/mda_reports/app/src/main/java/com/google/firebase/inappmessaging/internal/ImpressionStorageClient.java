package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.injection.qualifiers.ImpressionStore;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpression;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class ImpressionStorageClient {
    private static final CampaignImpressionList EMPTY_IMPRESSIONS = CampaignImpressionList.getDefaultInstance();
    private Maybe<CampaignImpressionList> cachedImpressionsMaybe = Maybe.empty();
    private final ProtoStorageClient storageClient;

    @Inject
    public ImpressionStorageClient(@ImpressionStore ProtoStorageClient protoStorageClient) {
        this.storageClient = protoStorageClient;
    }

    public static /* synthetic */ CompletableSource a(ImpressionStorageClient impressionStorageClient, CampaignImpression campaignImpression, CampaignImpressionList campaignImpressionList) {
        CampaignImpressionList appendImpression = appendImpression(campaignImpressionList, campaignImpression);
        return impressionStorageClient.storageClient.write(appendImpression).doOnComplete(ImpressionStorageClient$$Lambda$7.lambdaFactory$(impressionStorageClient, appendImpression));
    }

    private static CampaignImpressionList appendImpression(CampaignImpressionList campaignImpressionList, CampaignImpression campaignImpression) {
        return CampaignImpressionList.newBuilder(campaignImpressionList).addAlreadySeenCampaigns(campaignImpression).build();
    }

    public void clearInMemCache() {
        this.cachedImpressionsMaybe = Maybe.empty();
    }

    public void initInMemCache(CampaignImpressionList campaignImpressionList) {
        this.cachedImpressionsMaybe = Maybe.just(campaignImpressionList);
    }

    public Maybe<CampaignImpressionList> getAllImpressions() {
        return this.cachedImpressionsMaybe.switchIfEmpty(this.storageClient.read(CampaignImpressionList.parser()).doOnSuccess(ImpressionStorageClient$$Lambda$2.lambdaFactory$(this))).doOnError(ImpressionStorageClient$$Lambda$3.lambdaFactory$(this));
    }

    public Single<Boolean> isImpressed(String str) {
        Function<? super CampaignImpressionList, ? extends R> function;
        Function function2;
        Function function3;
        Maybe<CampaignImpressionList> allImpressions = getAllImpressions();
        function = ImpressionStorageClient$$Lambda$4.instance;
        Maybe<R> map = allImpressions.map(function);
        function2 = ImpressionStorageClient$$Lambda$5.instance;
        Observable flatMapObservable = map.flatMapObservable(function2);
        function3 = ImpressionStorageClient$$Lambda$6.instance;
        return flatMapObservable.map(function3).contains(str);
    }

    public Completable storeImpression(CampaignImpression campaignImpression) {
        return getAllImpressions().defaultIfEmpty(EMPTY_IMPRESSIONS).flatMapCompletable(ImpressionStorageClient$$Lambda$1.lambdaFactory$(this, campaignImpression));
    }
}
