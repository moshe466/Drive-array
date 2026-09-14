package com.crashlytics.android.answers;

import android.content.Context;
import com.crashlytics.android.answers.SessionEvent;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.events.FilesSender;
import io.fabric.sdk.android.services.events.TimeBasedFileRollOverRunnable;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
class EnabledSessionAnalyticsManagerStrategy implements SessionAnalyticsManagerStrategy {
    final SessionEventMetadata a;
    FilesSender b;
    private final Context context;
    private final ScheduledExecutorService executorService;
    private final SessionAnalyticsFilesManager filesManager;
    private final FirebaseAnalyticsApiAdapter firebaseAnalyticsApiAdapter;
    private final HttpRequestFactory httpRequestFactory;
    private final Kit kit;
    private final AtomicReference<ScheduledFuture<?>> rolloverFutureRef = new AtomicReference<>();
    ApiKey c = new ApiKey();
    EventFilter d = new KeepAllEventFilter();
    boolean e = true;
    boolean f = true;
    volatile int g = -1;
    boolean h = false;
    boolean i = false;

    public EnabledSessionAnalyticsManagerStrategy(Kit kit, Context context, ScheduledExecutorService scheduledExecutorService, SessionAnalyticsFilesManager sessionAnalyticsFilesManager, HttpRequestFactory httpRequestFactory, SessionEventMetadata sessionEventMetadata, FirebaseAnalyticsApiAdapter firebaseAnalyticsApiAdapter) {
        this.kit = kit;
        this.context = context;
        this.executorService = scheduledExecutorService;
        this.filesManager = sessionAnalyticsFilesManager;
        this.httpRequestFactory = httpRequestFactory;
        this.a = sessionEventMetadata;
        this.firebaseAnalyticsApiAdapter = firebaseAnalyticsApiAdapter;
    }

    void a(long j, long j2) {
        if (this.rolloverFutureRef.get() == null) {
            TimeBasedFileRollOverRunnable timeBasedFileRollOverRunnable = new TimeBasedFileRollOverRunnable(this.context, this);
            CommonUtils.logControlled(this.context, "Scheduling time based file roll over every " + j2 + " seconds");
            try {
                this.rolloverFutureRef.set(this.executorService.scheduleAtFixedRate(timeBasedFileRollOverRunnable, j, j2, TimeUnit.SECONDS));
            } catch (RejectedExecutionException e) {
                CommonUtils.logControlledError(this.context, "Failed to schedule time based file roll over", e);
            }
        }
    }

    @Override // io.fabric.sdk.android.services.events.FileRollOverManager
    public void cancelTimeBasedFileRollOver() {
        if (this.rolloverFutureRef.get() != null) {
            CommonUtils.logControlled(this.context, "Cancelling time-based rollover because no events are currently being generated.");
            this.rolloverFutureRef.get().cancel(false);
            this.rolloverFutureRef.set(null);
        }
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    public void deleteAllEvents() {
        this.filesManager.deleteAllEventsFiles();
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    public void processEvent(SessionEvent.Builder builder) {
        Logger logger;
        StringBuilder sb;
        String str;
        SessionEvent build = builder.build(this.a);
        if (!this.e && SessionEvent.Type.CUSTOM.equals(build.type)) {
            logger = Fabric.getLogger();
            sb = new StringBuilder();
            str = "Custom events tracking disabled - skipping event: ";
        } else if (!this.f && SessionEvent.Type.PREDEFINED.equals(build.type)) {
            logger = Fabric.getLogger();
            sb = new StringBuilder();
            str = "Predefined events tracking disabled - skipping event: ";
        } else {
            if (!this.d.skipEvent(build)) {
                try {
                    this.filesManager.writeEvent(build);
                } catch (IOException e) {
                    Fabric.getLogger().e(Answers.TAG, "Failed to write event: " + build, e);
                }
                scheduleTimeBasedRollOverIfNeeded();
                boolean z = SessionEvent.Type.CUSTOM.equals(build.type) || SessionEvent.Type.PREDEFINED.equals(build.type);
                boolean equals = "purchase".equals(build.predefinedType);
                if (this.h && z) {
                    if (!equals || this.i) {
                        try {
                            this.firebaseAnalyticsApiAdapter.processEvent(build);
                            return;
                        } catch (Exception e2) {
                            Fabric.getLogger().e(Answers.TAG, "Failed to map event to Firebase: " + build, e2);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            logger = Fabric.getLogger();
            sb = new StringBuilder();
            str = "Skipping filtered event: ";
        }
        sb.append(str);
        sb.append(build);
        logger.d(Answers.TAG, sb.toString());
    }

    @Override // io.fabric.sdk.android.services.events.FileRollOverManager
    public boolean rollFileOver() {
        try {
            return this.filesManager.rollFileOver();
        } catch (IOException e) {
            CommonUtils.logControlledError(this.context, "Failed to roll file over.", e);
            return false;
        }
    }

    @Override // io.fabric.sdk.android.services.events.FileRollOverManager
    public void scheduleTimeBasedRollOverIfNeeded() {
        if (this.g != -1) {
            a(this.g, this.g);
        }
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    public void sendEvents() {
        if (this.b == null) {
            CommonUtils.logControlled(this.context, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        CommonUtils.logControlled(this.context, "Sending all files");
        List<File> batchOfFilesToSend = this.filesManager.getBatchOfFilesToSend();
        int i = 0;
        while (batchOfFilesToSend.size() > 0) {
            try {
                CommonUtils.logControlled(this.context, String.format(Locale.US, "attempt to send batch of %d files", Integer.valueOf(batchOfFilesToSend.size())));
                boolean send = this.b.send(batchOfFilesToSend);
                if (send) {
                    i += batchOfFilesToSend.size();
                    this.filesManager.deleteSentFiles(batchOfFilesToSend);
                }
                if (!send) {
                    break;
                } else {
                    batchOfFilesToSend = this.filesManager.getBatchOfFilesToSend();
                }
            } catch (Exception e) {
                CommonUtils.logControlledError(this.context, "Failed to send batch of analytics files to server: " + e.getMessage(), e);
            }
        }
        if (i == 0) {
            this.filesManager.deleteOldestInRollOverIfOverMax();
        }
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    public void setAnalyticsSettingsData(AnalyticsSettingsData analyticsSettingsData, String str) {
        this.b = AnswersRetryFilesSender.build(new SessionAnalyticsFilesSender(this.kit, str, analyticsSettingsData.analyticsURL, this.httpRequestFactory, this.c.getValue(this.context)));
        this.filesManager.a(analyticsSettingsData);
        this.h = analyticsSettingsData.forwardToFirebaseAnalytics;
        this.i = analyticsSettingsData.includePurchaseEventsInForwardedEvents;
        Logger logger = Fabric.getLogger();
        StringBuilder sb = new StringBuilder();
        sb.append("Firebase analytics forwarding ");
        sb.append(this.h ? "enabled" : "disabled");
        logger.d(Answers.TAG, sb.toString());
        Logger logger2 = Fabric.getLogger();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Firebase analytics including purchase events ");
        sb2.append(this.i ? "enabled" : "disabled");
        logger2.d(Answers.TAG, sb2.toString());
        this.e = analyticsSettingsData.trackCustomEvents;
        Logger logger3 = Fabric.getLogger();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Custom event tracking ");
        sb3.append(this.e ? "enabled" : "disabled");
        logger3.d(Answers.TAG, sb3.toString());
        this.f = analyticsSettingsData.trackPredefinedEvents;
        Logger logger4 = Fabric.getLogger();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Predefined event tracking ");
        sb4.append(this.f ? "enabled" : "disabled");
        logger4.d(Answers.TAG, sb4.toString());
        if (analyticsSettingsData.samplingRate > 1) {
            Fabric.getLogger().d(Answers.TAG, "Event sampling enabled");
            this.d = new SamplingEventFilter(analyticsSettingsData.samplingRate);
        }
        this.g = analyticsSettingsData.flushIntervalSeconds;
        a(0L, this.g);
    }
}
