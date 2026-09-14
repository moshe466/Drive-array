package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.ForegroundNotifier;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.reactivex.flowables.ConnectableFlowable;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory implements Factory<ConnectableFlowable<String>> {
    private final Provider<Application> applicationProvider;
    private final Provider<ForegroundNotifier> foregroundProvider;
    private final ForegroundFlowableModule module;

    public ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory(ForegroundFlowableModule foregroundFlowableModule, Provider<Application> provider, Provider<ForegroundNotifier> provider2) {
        this.module = foregroundFlowableModule;
        this.applicationProvider = provider;
        this.foregroundProvider = provider2;
    }

    public static ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory create(ForegroundFlowableModule foregroundFlowableModule, Provider<Application> provider, Provider<ForegroundNotifier> provider2) {
        return new ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory(foregroundFlowableModule, provider, provider2);
    }

    public static ConnectableFlowable<String> providesAppForegroundEventStream(ForegroundFlowableModule foregroundFlowableModule, Application application, ForegroundNotifier foregroundNotifier) {
        return (ConnectableFlowable) Preconditions.checkNotNull(foregroundFlowableModule.providesAppForegroundEventStream(application, foregroundNotifier), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public ConnectableFlowable<String> get() {
        return providesAppForegroundEventStream(this.module, this.applicationProvider.get(), this.foregroundProvider.get());
    }
}
