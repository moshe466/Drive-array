package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.internal.StubAnalyticsConnector;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
/* loaded from: classes2.dex */
public class AppMeasurementModule {
    private AnalyticsConnector analyticsConnector;
    private Subscriber firebaseEventsSubscriber;

    public AppMeasurementModule(AnalyticsConnector analyticsConnector, Subscriber subscriber) {
        this.analyticsConnector = analyticsConnector == null ? StubAnalyticsConnector.instance : analyticsConnector;
        this.firebaseEventsSubscriber = subscriber;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public AnalyticsConnector a() {
        return this.analyticsConnector;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public Subscriber b() {
        return this.firebaseEventsSubscriber;
    }
}
