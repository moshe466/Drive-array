package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.google.common.annotations.VisibleForTesting;
import com.google.developers.mobile.targeting.proto.ClientSignalsProto;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfo;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequest;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import dagger.Lazy;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@FirebaseAppScope
/* loaded from: classes2.dex */
public class ApiClient {
    private static final String DATA_COLLECTION_DISABLED_ERROR = "Automatic data collection is disabled, not attempting campaign fetch from service.";
    private static final String FETCHING_CAMPAIGN_MESSAGE = "Fetching campaigns from service.";
    private static final String IID_NOT_INITIALIZED_ERROR = "FirebaseInstanceId not yet initialized, not attempting campaign fetch from service.";
    private final Application application;
    private final Clock clock;
    private final DataCollectionHelper dataCollectionHelper;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstanceId firebaseInstanceId;
    private final Lazy<GrpcClient> grpcClient;
    private final ProviderInstaller providerInstaller;

    public ApiClient(Lazy<GrpcClient> lazy, FirebaseApp firebaseApp, Application application, FirebaseInstanceId firebaseInstanceId, DataCollectionHelper dataCollectionHelper, Clock clock, ProviderInstaller providerInstaller) {
        this.grpcClient = lazy;
        this.firebaseApp = firebaseApp;
        this.application = application;
        this.firebaseInstanceId = firebaseInstanceId;
        this.dataCollectionHelper = dataCollectionHelper;
        this.clock = clock;
        this.providerInstaller = providerInstaller;
    }

    @VisibleForTesting
    static FetchEligibleCampaignsResponse a() {
        return FetchEligibleCampaignsResponse.newBuilder().setExpirationEpochTimestampMillis(1L).build();
    }

    private ClientAppInfo getClientAppInfo() {
        ClientAppInfo.Builder gmpAppId = ClientAppInfo.newBuilder().setGmpAppId(this.firebaseApp.getOptions().getApplicationId());
        String id = this.firebaseInstanceId.getId();
        if (!TextUtils.isEmpty(id)) {
            gmpAppId.setAppInstanceId(id);
        }
        String token = this.firebaseInstanceId.getToken();
        if (!TextUtils.isEmpty(token)) {
            gmpAppId.setAppInstanceIdToken(token);
        }
        return gmpAppId.build();
    }

    private ClientSignalsProto.ClientSignals getClientSignals() {
        ClientSignalsProto.ClientSignals.Builder timeZone = ClientSignalsProto.ClientSignals.newBuilder().setPlatformVersion(String.valueOf(Build.VERSION.SDK_INT)).setLanguageCode(Locale.getDefault().toString()).setTimeZone(TimeZone.getDefault().getID());
        String versionName = getVersionName();
        if (!TextUtils.isEmpty(versionName)) {
            timeZone.setAppVersion(versionName);
        }
        return timeZone.build();
    }

    @Nullable
    private String getVersionName() {
        try {
            return this.application.getPackageManager().getPackageInfo(this.application.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Logging.loge("Error finding versionName : " + e.getMessage());
            return null;
        }
    }

    private boolean isFirebaseTokenInitialized() {
        return (TextUtils.isEmpty(this.firebaseInstanceId.getToken()) || TextUtils.isEmpty(this.firebaseInstanceId.getId())) ? false : true;
    }

    private FetchEligibleCampaignsResponse withCacheExpirationSafeguards(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        return (fetchEligibleCampaignsResponse.getExpirationEpochTimestampMillis() < this.clock.now() + TimeUnit.MINUTES.toMillis(1L) || fetchEligibleCampaignsResponse.getExpirationEpochTimestampMillis() > this.clock.now() + TimeUnit.DAYS.toMillis(3L)) ? fetchEligibleCampaignsResponse.toBuilder().setExpirationEpochTimestampMillis(this.clock.now() + TimeUnit.DAYS.toMillis(1L)).build() : fetchEligibleCampaignsResponse;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FetchEligibleCampaignsResponse a(CampaignImpressionList campaignImpressionList) {
        if (!this.dataCollectionHelper.isAutomaticDataCollectionEnabled()) {
            Logging.logi(DATA_COLLECTION_DISABLED_ERROR);
            return a();
        }
        if (!isFirebaseTokenInitialized()) {
            Logging.logi(IID_NOT_INITIALIZED_ERROR);
            return a();
        }
        Logging.logi(FETCHING_CAMPAIGN_MESSAGE);
        this.providerInstaller.install();
        return withCacheExpirationSafeguards(this.grpcClient.get().fetchEligibleCampaigns(FetchEligibleCampaignsRequest.newBuilder().setProjectNumber(this.firebaseApp.getOptions().getGcmSenderId()).addAllAlreadySeenCampaigns(campaignImpressionList.getAlreadySeenCampaignsList()).setClientSignals(getClientSignals()).setRequestingClientApp(getClientAppInfo()).build()));
    }
}
