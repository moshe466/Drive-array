package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.CampaignCache;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* loaded from: classes2.dex */
public class CampaignCacheClient {
    private final Application application;

    @Nullable
    private FetchEligibleCampaignsResponse cachedResponse;
    private final Clock clock;
    private final ProtoStorageClient storageClient;

    @Inject
    public CampaignCacheClient(@CampaignCache ProtoStorageClient protoStorageClient, Application application, Clock clock) {
        this.storageClient = protoStorageClient;
        this.application = application;
        this.clock = clock;
    }

    public boolean isResponseValid(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        long expirationEpochTimestampMillis = fetchEligibleCampaignsResponse.getExpirationEpochTimestampMillis();
        long now = this.clock.now();
        File file = new File(this.application.getApplicationContext().getFilesDir(), ProtoStorageClientModule.CAMPAIGN_CACHE_FILE);
        return expirationEpochTimestampMillis != 0 ? now < expirationEpochTimestampMillis : !file.exists() || now < file.lastModified() + TimeUnit.DAYS.toMillis(1L);
    }

    public Maybe<FetchEligibleCampaignsResponse> get() {
        return Maybe.fromCallable(CampaignCacheClient$$Lambda$2.lambdaFactory$(this)).switchIfEmpty(this.storageClient.read(FetchEligibleCampaignsResponse.parser()).doOnSuccess(CampaignCacheClient$$Lambda$3.lambdaFactory$(this))).filter(CampaignCacheClient$$Lambda$4.lambdaFactory$(this)).doOnError(CampaignCacheClient$$Lambda$5.lambdaFactory$(this));
    }

    public Completable put(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        return this.storageClient.write(fetchEligibleCampaignsResponse).doOnComplete(CampaignCacheClient$$Lambda$1.lambdaFactory$(this, fetchEligibleCampaignsResponse));
    }
}
