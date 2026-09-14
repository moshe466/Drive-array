package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.dataclass.TranslatorModuleBuilderParams;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class ExternalConfigurationModule_TranslatorModuleBuilderParamsFactory implements Factory<TranslatorModuleBuilderParams> {
    private final ExternalConfigurationModule module;

    public ExternalConfigurationModule_TranslatorModuleBuilderParamsFactory(ExternalConfigurationModule externalConfigurationModule) {
        this.module = externalConfigurationModule;
    }

    @Override // javax.inject.Provider
    public TranslatorModuleBuilderParams get() {
        return translatorModuleBuilderParams(this.module);
    }

    public static ExternalConfigurationModule_TranslatorModuleBuilderParamsFactory create(ExternalConfigurationModule externalConfigurationModule) {
        return new ExternalConfigurationModule_TranslatorModuleBuilderParamsFactory(externalConfigurationModule);
    }

    public static TranslatorModuleBuilderParams translatorModuleBuilderParams(ExternalConfigurationModule externalConfigurationModule) {
        return (TranslatorModuleBuilderParams) Preconditions.checkNotNullFromProvides(externalConfigurationModule.getTranslatorModuleBuilderParams());
    }
}
