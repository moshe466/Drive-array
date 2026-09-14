package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AnalyticsListener;
import dagger.Module;
import dagger.Provides;
import io.reactivex.flowables.ConnectableFlowable;
import javax.inject.Singleton;

@Module
/* loaded from: classes2.dex */
public class AnalyticsEventsModule {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public AnalyticsEventsManager a(AnalyticsConnector analyticsConnector) {
        return new AnalyticsEventsManager(analyticsConnector);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    @AnalyticsListener
    public ConnectableFlowable<String> a(AnalyticsEventsManager analyticsEventsManager) {
        return analyticsEventsManager.getAnalyticsEventsFlowable();
    }
}
