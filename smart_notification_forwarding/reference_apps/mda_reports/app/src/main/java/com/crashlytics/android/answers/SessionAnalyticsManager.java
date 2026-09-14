package com.crashlytics.android.answers;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.crashlytics.android.answers.BackgroundManager;
import com.crashlytics.android.answers.SessionEvent;
import io.fabric.sdk.android.ActivityLifecycleManager;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.ExecutorUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.network.DefaultHttpRequestFactory;
import io.fabric.sdk.android.services.persistence.FileStoreImpl;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SessionAnalyticsManager implements BackgroundManager.Listener {
    final AnswersEventsHandler a;
    final ActivityLifecycleManager b;
    final BackgroundManager c;
    final AnswersPreferenceManager d;
    private final long installedAt;

    SessionAnalyticsManager(AnswersEventsHandler answersEventsHandler, ActivityLifecycleManager activityLifecycleManager, BackgroundManager backgroundManager, AnswersPreferenceManager answersPreferenceManager, long j) {
        this.a = answersEventsHandler;
        this.b = activityLifecycleManager;
        this.c = backgroundManager;
        this.d = answersPreferenceManager;
        this.installedAt = j;
    }

    public static SessionAnalyticsManager build(Kit kit, Context context, IdManager idManager, String str, String str2, long j) {
        SessionMetadataCollector sessionMetadataCollector = new SessionMetadataCollector(context, idManager, str, str2);
        AnswersFilesManagerProvider answersFilesManagerProvider = new AnswersFilesManagerProvider(context, new FileStoreImpl(kit));
        DefaultHttpRequestFactory defaultHttpRequestFactory = new DefaultHttpRequestFactory(Fabric.getLogger());
        ActivityLifecycleManager activityLifecycleManager = new ActivityLifecycleManager(context);
        ScheduledExecutorService buildSingleThreadScheduledExecutorService = ExecutorUtils.buildSingleThreadScheduledExecutorService("Answers Events Handler");
        return new SessionAnalyticsManager(new AnswersEventsHandler(kit, context, answersFilesManagerProvider, sessionMetadataCollector, defaultHttpRequestFactory, buildSingleThreadScheduledExecutorService, new FirebaseAnalyticsApiAdapter(context)), activityLifecycleManager, new BackgroundManager(buildSingleThreadScheduledExecutorService), AnswersPreferenceManager.build(context), j);
    }

    boolean a() {
        return !this.d.hasAnalyticsLaunched();
    }

    public void disable() {
        this.b.resetCallbacks();
        this.a.disable();
    }

    public void enable() {
        this.a.enable();
        this.b.registerCallbacks(new AnswersLifecycleCallbacks(this, this.c));
        this.c.registerListener(this);
        if (a()) {
            onInstall(this.installedAt);
            this.d.setAnalyticsLaunched();
        }
    }

    @Override // com.crashlytics.android.answers.BackgroundManager.Listener
    public void onBackground() {
        Fabric.getLogger().d(Answers.TAG, "Flush events when app is backgrounded");
        this.a.flushEvents();
    }

    public void onCrash(String str, String str2) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("onCrash called from main thread!!!");
        }
        Fabric.getLogger().d(Answers.TAG, "Logged crash");
        this.a.processEventSync(SessionEvent.crashEventBuilder(str, str2));
    }

    public void onCustom(CustomEvent customEvent) {
        Fabric.getLogger().d(Answers.TAG, "Logged custom event: " + customEvent);
        this.a.processEventAsync(SessionEvent.customEventBuilder(customEvent));
    }

    public void onError(String str) {
    }

    public void onInstall(long j) {
        Fabric.getLogger().d(Answers.TAG, "Logged install");
        this.a.processEventAsyncAndFlush(SessionEvent.installEventBuilder(j));
    }

    public void onLifecycle(Activity activity, SessionEvent.Type type) {
        Fabric.getLogger().d(Answers.TAG, "Logged lifecycle event: " + type.name());
        this.a.processEventAsync(SessionEvent.lifecycleEventBuilder(type, activity));
    }

    public void onPredefined(PredefinedEvent predefinedEvent) {
        Fabric.getLogger().d(Answers.TAG, "Logged predefined event: " + predefinedEvent);
        this.a.processEventAsync(SessionEvent.predefinedEventBuilder(predefinedEvent));
    }

    public void setAnalyticsSettingsData(AnalyticsSettingsData analyticsSettingsData, String str) {
        this.c.setFlushOnBackground(analyticsSettingsData.flushOnBackground);
        this.a.setAnalyticsSettingsData(analyticsSettingsData, str);
    }
}
