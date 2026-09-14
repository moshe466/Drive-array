package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.ForegroundNotifier;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes2.dex */
public final class ForegroundNotifierModule_ProvidesForegroundFactory implements Factory<ForegroundNotifier> {
    private final ForegroundNotifierModule module;

    public ForegroundNotifierModule_ProvidesForegroundFactory(ForegroundNotifierModule foregroundNotifierModule) {
        this.module = foregroundNotifierModule;
    }

    public static ForegroundNotifierModule_ProvidesForegroundFactory create(ForegroundNotifierModule foregroundNotifierModule) {
        return new ForegroundNotifierModule_ProvidesForegroundFactory(foregroundNotifierModule);
    }

    public static ForegroundNotifier providesForeground(ForegroundNotifierModule foregroundNotifierModule) {
        return (ForegroundNotifier) Preconditions.checkNotNull(foregroundNotifierModule.providesForeground(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public ForegroundNotifier get() {
        return providesForeground(this.module);
    }
}
