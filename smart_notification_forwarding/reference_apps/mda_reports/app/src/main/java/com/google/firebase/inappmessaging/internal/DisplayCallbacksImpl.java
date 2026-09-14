package com.google.firebase.inappmessaging.internal;

import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpression;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;

/* loaded from: classes2.dex */
public class DisplayCallbacksImpl implements FirebaseInAppMessagingDisplayCallbacks {
    private static final String MESSAGE_CLICK = "message click to metrics logger";
    private static boolean wasImpressed;
    private final RateLimit appForegroundRateLimit;
    private final CampaignCacheClient campaignCacheClient;
    private final Clock clock;
    private final DataCollectionHelper dataCollectionHelper;
    private final ImpressionStorageClient impressionStorageClient;
    private final InAppMessage inAppMessage;
    private final MetricsLoggerClient metricsLoggerClient;
    private final RateLimiterClient rateLimiterClient;
    private final Schedulers schedulers;
    private final String triggeringEvent;

    @VisibleForTesting
    public DisplayCallbacksImpl(ImpressionStorageClient impressionStorageClient, Clock clock, Schedulers schedulers, RateLimiterClient rateLimiterClient, CampaignCacheClient campaignCacheClient, RateLimit rateLimit, MetricsLoggerClient metricsLoggerClient, DataCollectionHelper dataCollectionHelper, InAppMessage inAppMessage, String str) {
        this.impressionStorageClient = impressionStorageClient;
        this.clock = clock;
        this.schedulers = schedulers;
        this.rateLimiterClient = rateLimiterClient;
        this.campaignCacheClient = campaignCacheClient;
        this.appForegroundRateLimit = rateLimit;
        this.metricsLoggerClient = metricsLoggerClient;
        this.dataCollectionHelper = dataCollectionHelper;
        this.inAppMessage = inAppMessage;
        this.triggeringEvent = str;
        wasImpressed = false;
    }

    public static /* synthetic */ MaybeSource a(TaskCompletionSource taskCompletionSource, Throwable th) {
        if (th instanceof Exception) {
            taskCompletionSource.setException((Exception) th);
        } else {
            taskCompletionSource.setException(new RuntimeException(th));
        }
        return Maybe.empty();
    }

    public static /* synthetic */ Object a(TaskCompletionSource taskCompletionSource) {
        taskCompletionSource.setResult(null);
        return null;
    }

    public static /* synthetic */ void a() {
        Logging.logd("Impression store write success");
    }

    private boolean actionMatches(Action action, Action action2) {
        return action == null ? action2 == null || TextUtils.isEmpty(action2.getActionUrl()) : action.getActionUrl().equals(action2.getActionUrl());
    }

    private void logActionNotTaken(String str) {
        logActionNotTaken(str, null);
    }

    private void logActionNotTaken(String str, Maybe<String> maybe) {
        Logging.logd(maybe != null ? String.format("Not recording: %s. Reason: %s", str, maybe) : this.inAppMessage.getIsTestMessage().booleanValue() ? String.format("Not recording: %s. Reason: Message is test message", str) : !this.dataCollectionHelper.isAutomaticDataCollectionEnabled() ? String.format("Not recording: %s. Reason: Data collection is disabled", str) : String.format("Not recording: %s", str));
    }

    private Task<Void> logImpressionIfNeeded(Completable completable) {
        if (!wasImpressed) {
            impressionDetected();
        }
        return maybeToTask(completable.toMaybe(), this.schedulers.io());
    }

    private Task<Void> logMessageClick(Action action) {
        Logging.logd("Attempting to record: message click to metrics logger");
        return logImpressionIfNeeded(Completable.fromAction(DisplayCallbacksImpl$$Lambda$4.lambdaFactory$(this, action)));
    }

    private Completable logToImpressionStore() {
        Consumer<? super Throwable> consumer;
        io.reactivex.functions.Action action;
        Consumer<? super Throwable> consumer2;
        io.reactivex.functions.Action action2;
        Logging.logd("Attempting to record: message impression in impression store");
        Completable storeImpression = this.impressionStorageClient.storeImpression(CampaignImpression.newBuilder().setImpressionTimestampMillis(this.clock.now()).setCampaignId(this.inAppMessage.getCampaignId()).build());
        consumer = DisplayCallbacksImpl$$Lambda$6.instance;
        Completable doOnError = storeImpression.doOnError(consumer);
        action = DisplayCallbacksImpl$$Lambda$7.instance;
        Completable doOnComplete = doOnError.doOnComplete(action);
        if (!InAppMessageStreamManager.isAppForegroundEvent(this.triggeringEvent)) {
            return doOnComplete;
        }
        Completable increment = this.rateLimiterClient.increment(this.appForegroundRateLimit);
        consumer2 = DisplayCallbacksImpl$$Lambda$8.instance;
        Completable doOnError2 = increment.doOnError(consumer2);
        action2 = DisplayCallbacksImpl$$Lambda$9.instance;
        return doOnError2.doOnComplete(action2).onErrorComplete().andThen(doOnComplete);
    }

    private static <T> Task<T> maybeToTask(Maybe<T> maybe, Scheduler scheduler) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        maybe.doOnSuccess(DisplayCallbacksImpl$$Lambda$10.lambdaFactory$(taskCompletionSource)).switchIfEmpty(Maybe.fromCallable(DisplayCallbacksImpl$$Lambda$11.lambdaFactory$(taskCompletionSource))).onErrorResumeNext(DisplayCallbacksImpl$$Lambda$12.lambdaFactory$(taskCompletionSource)).subscribeOn(scheduler).subscribe();
        return taskCompletionSource.getTask();
    }

    private boolean shouldLog() {
        return this.dataCollectionHelper.isAutomaticDataCollectionEnabled();
    }

    private Completable updateWasImpressed() {
        io.reactivex.functions.Action action;
        action = DisplayCallbacksImpl$$Lambda$2.instance;
        return Completable.fromAction(action);
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks
    public Task<Void> displayErrorEncountered(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason) {
        if (!shouldLog()) {
            logActionNotTaken("render error to metrics logger");
            return new TaskCompletionSource().getTask();
        }
        Logging.logd("Attempting to record: render error to metrics logger");
        return maybeToTask(logToImpressionStore().andThen(Completable.fromAction(DisplayCallbacksImpl$$Lambda$5.lambdaFactory$(this, inAppMessagingErrorReason))).andThen(updateWasImpressed()).toMaybe(), this.schedulers.io());
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks
    public Task<Void> impressionDetected() {
        if (!shouldLog() || wasImpressed) {
            logActionNotTaken("message impression to metrics logger");
            return new TaskCompletionSource().getTask();
        }
        Logging.logd("Attempting to record: message impression to metrics logger");
        return maybeToTask(logToImpressionStore().andThen(Completable.fromAction(DisplayCallbacksImpl$$Lambda$1.lambdaFactory$(this))).andThen(updateWasImpressed()).toMaybe(), this.schedulers.io());
    }

    @Deprecated
    public Task<Void> messageClicked() {
        return messageClicked(this.inAppMessage.getAction());
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks
    public Task<Void> messageClicked(Action action) {
        if (shouldLog()) {
            return action.getActionUrl() == null ? messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.CLICK) : logMessageClick(action);
        }
        logActionNotTaken(MESSAGE_CLICK);
        return new TaskCompletionSource().getTask();
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks
    public Task<Void> messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType inAppMessagingDismissType) {
        if (!shouldLog()) {
            logActionNotTaken("message dismissal to metrics logger");
            return new TaskCompletionSource().getTask();
        }
        Logging.logd("Attempting to record: message dismissal to metrics logger");
        return logImpressionIfNeeded(Completable.fromAction(DisplayCallbacksImpl$$Lambda$3.lambdaFactory$(this, inAppMessagingDismissType)));
    }
}
