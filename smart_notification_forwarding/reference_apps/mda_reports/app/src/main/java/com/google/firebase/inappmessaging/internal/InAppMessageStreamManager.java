package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.CommonTypesProto;
import com.google.firebase.inappmessaging.MessagesProto;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AppForeground;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.ProgrammaticTrigger;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.ProtoMarshallerClient;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.firebase.inappmessaging.model.TriggeredInAppMessage;
import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.Comparator;
import javax.inject.Inject;
import org.reactivestreams.Publisher;

@FirebaseAppScope
/* loaded from: classes2.dex */
public class InAppMessageStreamManager {
    public static final String ON_FOREGROUND = "ON_FOREGROUND";
    private final AnalyticsEventsManager analyticsEventsManager;
    private final ApiClient apiClient;
    private final ConnectableFlowable<String> appForegroundEventFlowable;
    private final RateLimit appForegroundRateLimit;
    private final CampaignCacheClient campaignCacheClient;
    private final Clock clock;
    private final ImpressionStorageClient impressionStorageClient;
    private final ConnectableFlowable<String> programmaticTriggerEventFlowable;
    private final RateLimiterClient rateLimiterClient;
    private final Schedulers schedulers;
    private final TestDeviceHelper testDeviceHelper;

    /* renamed from: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$1 */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[MessagesProto.Content.MessageDetailsCase.values().length];

        static {
            try {
                a[MessagesProto.Content.MessageDetailsCase.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[MessagesProto.Content.MessageDetailsCase.IMAGE_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[MessagesProto.Content.MessageDetailsCase.MODAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[MessagesProto.Content.MessageDetailsCase.CARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Inject
    public InAppMessageStreamManager(@AppForeground ConnectableFlowable<String> connectableFlowable, @ProgrammaticTrigger ConnectableFlowable<String> connectableFlowable2, CampaignCacheClient campaignCacheClient, Clock clock, ApiClient apiClient, AnalyticsEventsManager analyticsEventsManager, Schedulers schedulers, ImpressionStorageClient impressionStorageClient, RateLimiterClient rateLimiterClient, @AppForeground RateLimit rateLimit, TestDeviceHelper testDeviceHelper) {
        this.appForegroundEventFlowable = connectableFlowable;
        this.programmaticTriggerEventFlowable = connectableFlowable2;
        this.campaignCacheClient = campaignCacheClient;
        this.clock = clock;
        this.apiClient = apiClient;
        this.analyticsEventsManager = analyticsEventsManager;
        this.schedulers = schedulers;
        this.impressionStorageClient = impressionStorageClient;
        this.rateLimiterClient = rateLimiterClient;
        this.appForegroundRateLimit = rateLimit;
        this.testDeviceHelper = testDeviceHelper;
    }

    public static /* synthetic */ CampaignProto.ThickContent a(CampaignProto.ThickContent thickContent, Boolean bool) {
        return thickContent;
    }

    public static /* synthetic */ Maybe a(InAppMessageStreamManager inAppMessageStreamManager, CampaignProto.ThickContent thickContent) {
        Consumer<? super Throwable> consumer;
        Predicate<? super Boolean> predicate;
        if (thickContent.getIsTestCampaign()) {
            return Maybe.just(thickContent);
        }
        Single<Boolean> isImpressed = inAppMessageStreamManager.impressionStorageClient.isImpressed(thickContent.getVanillaPayload().getCampaignId());
        consumer = InAppMessageStreamManager$$Lambda$27.instance;
        Single<Boolean> doOnSuccess = isImpressed.doOnError(consumer).onErrorResumeNext(Single.just(false)).doOnSuccess(InAppMessageStreamManager$$Lambda$28.lambdaFactory$(thickContent));
        predicate = InAppMessageStreamManager$$Lambda$29.instance;
        return doOnSuccess.filter(predicate).map(InAppMessageStreamManager$$Lambda$30.lambdaFactory$(thickContent));
    }

    public static /* synthetic */ Maybe a(CampaignProto.ThickContent thickContent) {
        int i = AnonymousClass1.a[thickContent.getContent().getMessageDetailsCase().ordinal()];
        if (i != 1 && i != 2 && i != 3 && i != 4) {
            return Maybe.empty();
        }
        return Maybe.just(thickContent);
    }

    public static /* synthetic */ Publisher a(InAppMessageStreamManager inAppMessageStreamManager, String str) {
        Consumer<? super FetchEligibleCampaignsResponse> consumer;
        Consumer<? super Throwable> consumer2;
        Function function;
        Consumer<? super Throwable> consumer3;
        Maybe<FetchEligibleCampaignsResponse> switchIfEmpty;
        Maybe<FetchEligibleCampaignsResponse> maybe = inAppMessageStreamManager.campaignCacheClient.get();
        consumer = InAppMessageStreamManager$$Lambda$13.instance;
        Maybe<FetchEligibleCampaignsResponse> doOnSuccess = maybe.doOnSuccess(consumer);
        consumer2 = InAppMessageStreamManager$$Lambda$14.instance;
        Maybe<FetchEligibleCampaignsResponse> onErrorResumeNext = doOnSuccess.doOnError(consumer2).onErrorResumeNext(Maybe.empty());
        Consumer lambdaFactory$ = InAppMessageStreamManager$$Lambda$15.lambdaFactory$(inAppMessageStreamManager);
        Function lambdaFactory$2 = InAppMessageStreamManager$$Lambda$16.lambdaFactory$(inAppMessageStreamManager);
        Function lambdaFactory$3 = InAppMessageStreamManager$$Lambda$17.lambdaFactory$(inAppMessageStreamManager, str);
        function = InAppMessageStreamManager$$Lambda$18.instance;
        Function<? super FetchEligibleCampaignsResponse, ? extends MaybeSource<? extends R>> lambdaFactory$4 = InAppMessageStreamManager$$Lambda$19.lambdaFactory$(inAppMessageStreamManager, str, lambdaFactory$2, lambdaFactory$3, function);
        Maybe<CampaignImpressionList> allImpressions = inAppMessageStreamManager.impressionStorageClient.getAllImpressions();
        consumer3 = InAppMessageStreamManager$$Lambda$20.instance;
        Maybe<CampaignImpressionList> onErrorResumeNext2 = allImpressions.doOnError(consumer3).defaultIfEmpty(CampaignImpressionList.getDefaultInstance()).onErrorResumeNext(Maybe.just(CampaignImpressionList.getDefaultInstance()));
        Function<? super CampaignImpressionList, ? extends MaybeSource<? extends R>> lambdaFactory$5 = InAppMessageStreamManager$$Lambda$21.lambdaFactory$(inAppMessageStreamManager);
        if (inAppMessageStreamManager.shouldIgnoreCache(str)) {
            Logging.logi(String.format("Forcing fetch from service rather than cache. Test Device: %s | App Fresh Install: %s", Boolean.valueOf(inAppMessageStreamManager.testDeviceHelper.isDeviceInTestMode()), Boolean.valueOf(inAppMessageStreamManager.testDeviceHelper.isAppInstallFresh())));
            switchIfEmpty = onErrorResumeNext2.flatMap(lambdaFactory$5);
        } else {
            Logging.logd("Attempting to fetch campaigns using cache");
            switchIfEmpty = onErrorResumeNext.switchIfEmpty(onErrorResumeNext2.flatMap(lambdaFactory$5).doOnSuccess(lambdaFactory$));
        }
        return switchIfEmpty.flatMap(lambdaFactory$4).toFlowable();
    }

    public static /* synthetic */ boolean a(Boolean bool) {
        return !bool.booleanValue();
    }

    public static /* synthetic */ Maybe b(InAppMessageStreamManager inAppMessageStreamManager, CampaignImpressionList campaignImpressionList) {
        Consumer consumer;
        Consumer<? super Throwable> consumer2;
        Maybe fromCallable = Maybe.fromCallable(InAppMessageStreamManager$$Lambda$22.lambdaFactory$(inAppMessageStreamManager, campaignImpressionList));
        consumer = InAppMessageStreamManager$$Lambda$23.instance;
        Maybe doOnSuccess = fromCallable.doOnSuccess(consumer);
        AnalyticsEventsManager analyticsEventsManager = inAppMessageStreamManager.analyticsEventsManager;
        analyticsEventsManager.getClass();
        Maybe doOnSuccess2 = doOnSuccess.doOnSuccess(InAppMessageStreamManager$$Lambda$24.lambdaFactory$(analyticsEventsManager));
        TestDeviceHelper testDeviceHelper = inAppMessageStreamManager.testDeviceHelper;
        testDeviceHelper.getClass();
        Maybe doOnSuccess3 = doOnSuccess2.doOnSuccess(InAppMessageStreamManager$$Lambda$25.lambdaFactory$(testDeviceHelper));
        consumer2 = InAppMessageStreamManager$$Lambda$26.instance;
        return doOnSuccess3.doOnError(consumer2).onErrorResumeNext(Maybe.empty());
    }

    public static /* synthetic */ boolean b(InAppMessageStreamManager inAppMessageStreamManager, CampaignProto.ThickContent thickContent) {
        return inAppMessageStreamManager.testDeviceHelper.isDeviceInTestMode() || isActive(inAppMessageStreamManager.clock, thickContent.getVanillaPayload());
    }

    public static /* synthetic */ CampaignProto.ThickContent c(CampaignProto.ThickContent thickContent, Boolean bool) {
        return thickContent;
    }

    public static /* synthetic */ boolean c(Boolean bool) {
        return !bool.booleanValue();
    }

    public static int compareByPriority(CampaignProto.ThickContent thickContent, CampaignProto.ThickContent thickContent2) {
        if (thickContent.getIsTestCampaign() && !thickContent2.getIsTestCampaign()) {
            return -1;
        }
        if (!thickContent2.getIsTestCampaign() || thickContent.getIsTestCampaign()) {
            return Integer.compare(thickContent.getPriority().getValue(), thickContent2.getPriority().getValue());
        }
        return 1;
    }

    public static boolean containsTriggeringCondition(String str, CampaignProto.ThickContent thickContent) {
        if (isAppForegroundEvent(str) && thickContent.getIsTestCampaign()) {
            return true;
        }
        for (CommonTypesProto.TriggeringCondition triggeringCondition : thickContent.getTriggeringConditionsList()) {
            if (hasFiamTrigger(triggeringCondition, str) || hasAnalyticsTrigger(triggeringCondition, str)) {
                Logging.logd(String.format("The event %s is contained in the list of triggers", str));
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ void f(Throwable th) {
        Logging.logw("Impression store read fail: " + th.getMessage());
    }

    public Maybe<CampaignProto.ThickContent> getContentIfNotRateLimited(String str, CampaignProto.ThickContent thickContent) {
        Consumer<? super Boolean> consumer;
        Predicate<? super Boolean> predicate;
        if (thickContent.getIsTestCampaign() || !isAppForegroundEvent(str)) {
            return Maybe.just(thickContent);
        }
        Single<Boolean> isRateLimited = this.rateLimiterClient.isRateLimited(this.appForegroundRateLimit);
        consumer = InAppMessageStreamManager$$Lambda$5.instance;
        Single<Boolean> onErrorResumeNext = isRateLimited.doOnSuccess(consumer).onErrorResumeNext(Single.just(false));
        predicate = InAppMessageStreamManager$$Lambda$6.instance;
        return onErrorResumeNext.filter(predicate).map(InAppMessageStreamManager$$Lambda$7.lambdaFactory$(thickContent));
    }

    public Maybe<TriggeredInAppMessage> getTriggeredInAppMessageMaybe(String str, Function<CampaignProto.ThickContent, Maybe<CampaignProto.ThickContent>> function, Function<CampaignProto.ThickContent, Maybe<CampaignProto.ThickContent>> function2, Function<CampaignProto.ThickContent, Maybe<CampaignProto.ThickContent>> function3, FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        Predicate predicate;
        Comparator comparator;
        Flowable fromIterable = Flowable.fromIterable(fetchEligibleCampaignsResponse.getMessagesList());
        predicate = InAppMessageStreamManager$$Lambda$8.instance;
        Flowable flatMapMaybe = fromIterable.filter(predicate).filter(InAppMessageStreamManager$$Lambda$9.lambdaFactory$(this)).filter(InAppMessageStreamManager$$Lambda$10.lambdaFactory$(str)).flatMapMaybe(function).flatMapMaybe(function2).flatMapMaybe(function3);
        comparator = InAppMessageStreamManager$$Lambda$11.instance;
        return flatMapMaybe.sorted(comparator).firstElement().flatMap(InAppMessageStreamManager$$Lambda$12.lambdaFactory$(this, str));
    }

    private static boolean hasAnalyticsTrigger(CommonTypesProto.TriggeringCondition triggeringCondition, String str) {
        return triggeringCondition.getEvent().getName().equals(str);
    }

    private static boolean hasFiamTrigger(CommonTypesProto.TriggeringCondition triggeringCondition, String str) {
        return triggeringCondition.getFiamTrigger().toString().equals(str);
    }

    private static boolean isActive(Clock clock, CampaignProto.VanillaCampaignPayload vanillaCampaignPayload) {
        long campaignStartTimeMillis = vanillaCampaignPayload.getCampaignStartTimeMillis();
        long campaignEndTimeMillis = vanillaCampaignPayload.getCampaignEndTimeMillis();
        long now = clock.now();
        return now > campaignStartTimeMillis && now < campaignEndTimeMillis;
    }

    public static boolean isAppForegroundEvent(CommonTypesProto.TriggeringCondition triggeringCondition) {
        return triggeringCondition.getFiamTrigger().toString().equals(ON_FOREGROUND);
    }

    public static boolean isAppForegroundEvent(String str) {
        return str.equals(ON_FOREGROUND);
    }

    private boolean shouldIgnoreCache(String str) {
        return this.testDeviceHelper.isAppInstallFresh() ? isAppForegroundEvent(str) : this.testDeviceHelper.isDeviceInTestMode();
    }

    public Maybe<TriggeredInAppMessage> triggeredInAppMessage(CampaignProto.ThickContent thickContent, String str) {
        InAppMessage decode = ProtoMarshallerClient.decode(thickContent.getContent(), thickContent.getVanillaPayload().getCampaignId(), thickContent.getVanillaPayload().getCampaignName(), thickContent.getIsTestCampaign());
        return decode.getMessageType().equals(MessageType.UNSUPPORTED) ? Maybe.empty() : Maybe.just(new TriggeredInAppMessage(decode, str));
    }

    public Flowable<TriggeredInAppMessage> createFirebaseInAppMessageStream() {
        Consumer consumer;
        Flowable merge = Flowable.merge(this.appForegroundEventFlowable, this.analyticsEventsManager.getAnalyticsEventsFlowable(), this.programmaticTriggerEventFlowable);
        consumer = InAppMessageStreamManager$$Lambda$1.instance;
        return merge.doOnNext(consumer).observeOn(this.schedulers.io()).concatMap(InAppMessageStreamManager$$Lambda$4.lambdaFactory$(this)).observeOn(this.schedulers.mainThread());
    }
}
