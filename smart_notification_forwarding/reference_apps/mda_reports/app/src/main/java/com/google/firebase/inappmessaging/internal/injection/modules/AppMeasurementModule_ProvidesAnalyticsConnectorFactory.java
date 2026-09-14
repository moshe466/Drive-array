package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.analytics.connector.AnalyticsConnector;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes2.dex */
public final class AppMeasurementModule_ProvidesAnalyticsConnectorFactory implements Factory<AnalyticsConnector> {
    private final AppMeasurementModule module;

    public AppMeasurementModule_ProvidesAnalyticsConnectorFactory(AppMeasurementModule appMeasurementModule) {
        this.module = appMeasurementModule;
    }

    public static AppMeasurementModule_ProvidesAnalyticsConnectorFactory create(AppMeasurementModule appMeasurementModule) {
        return new AppMeasurementModule_ProvidesAnalyticsConnectorFactory(appMeasurementModule);
    }

    public static AnalyticsConnector providesAnalyticsConnector(AppMeasurementModule appMeasurementModule) {
        return (AnalyticsConnector) Preconditions.checkNotNull(appMeasurementModule.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public AnalyticsConnector get() {
        return providesAnalyticsConnector(this.module);
    }
}
