package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.utils.EnvironmentHelper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class ExternalConfigurationModule_EnvironmentHelperFactory implements Factory<EnvironmentHelper> {
    private final ExternalConfigurationModule module;

    public ExternalConfigurationModule_EnvironmentHelperFactory(ExternalConfigurationModule externalConfigurationModule) {
        this.module = externalConfigurationModule;
    }

    @Override // javax.inject.Provider
    public EnvironmentHelper get() {
        return environmentHelper(this.module);
    }

    public static ExternalConfigurationModule_EnvironmentHelperFactory create(ExternalConfigurationModule externalConfigurationModule) {
        return new ExternalConfigurationModule_EnvironmentHelperFactory(externalConfigurationModule);
    }

    public static EnvironmentHelper environmentHelper(ExternalConfigurationModule externalConfigurationModule) {
        return (EnvironmentHelper) Preconditions.checkNotNullFromProvides(externalConfigurationModule.environmentHelper());
    }
}
