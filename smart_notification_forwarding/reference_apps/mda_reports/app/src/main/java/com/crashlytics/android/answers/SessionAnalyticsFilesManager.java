package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import io.fabric.sdk.android.services.events.EventsStorage;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.util.UUID;

/* loaded from: classes.dex */
class SessionAnalyticsFilesManager extends EventsFilesManager<SessionEvent> {
    private static final String SESSION_ANALYTICS_TO_SEND_FILE_EXTENSION = ".tap";
    private static final String SESSION_ANALYTICS_TO_SEND_FILE_PREFIX = "sa";
    private AnalyticsSettingsData analyticsSettingsData;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionAnalyticsFilesManager(Context context, SessionEventTransform sessionEventTransform, CurrentTimeProvider currentTimeProvider, EventsStorage eventsStorage) {
        super(context, sessionEventTransform, currentTimeProvider, eventsStorage, 100);
    }

    @Override // io.fabric.sdk.android.services.events.EventsFilesManager
    protected String a() {
        return SESSION_ANALYTICS_TO_SEND_FILE_PREFIX + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + UUID.randomUUID().toString() + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + this.c.getCurrentTimeMillis() + SESSION_ANALYTICS_TO_SEND_FILE_EXTENSION;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AnalyticsSettingsData analyticsSettingsData) {
        this.analyticsSettingsData = analyticsSettingsData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.fabric.sdk.android.services.events.EventsFilesManager
    public int b() {
        AnalyticsSettingsData analyticsSettingsData = this.analyticsSettingsData;
        return analyticsSettingsData == null ? super.b() : analyticsSettingsData.maxByteSizePerFile;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.fabric.sdk.android.services.events.EventsFilesManager
    public int c() {
        AnalyticsSettingsData analyticsSettingsData = this.analyticsSettingsData;
        return analyticsSettingsData == null ? super.c() : analyticsSettingsData.maxPendingSendFileCount;
    }
}
