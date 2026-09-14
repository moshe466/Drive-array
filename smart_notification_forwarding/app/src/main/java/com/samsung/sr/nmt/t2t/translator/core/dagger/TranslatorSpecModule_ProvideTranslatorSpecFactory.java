package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.dataclass.TranslatorSpec;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class TranslatorSpecModule_ProvideTranslatorSpecFactory implements Factory<TranslatorSpec> {
    private final TranslatorSpecModule module;
    private final Provider<TranslatorSpecFactory> translatorSpecFactoryProvider;

    public TranslatorSpecModule_ProvideTranslatorSpecFactory(TranslatorSpecModule translatorSpecModule, Provider<TranslatorSpecFactory> provider) {
        this.module = translatorSpecModule;
        this.translatorSpecFactoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public TranslatorSpec get() {
        return provideTranslatorSpec(this.module, this.translatorSpecFactoryProvider.get());
    }

    public static TranslatorSpecModule_ProvideTranslatorSpecFactory create(TranslatorSpecModule translatorSpecModule, Provider<TranslatorSpecFactory> provider) {
        return new TranslatorSpecModule_ProvideTranslatorSpecFactory(translatorSpecModule, provider);
    }

    public static TranslatorSpec provideTranslatorSpec(TranslatorSpecModule translatorSpecModule, TranslatorSpecFactory translatorSpecFactory) {
        return (TranslatorSpec) Preconditions.checkNotNullFromProvides(translatorSpecModule.provideTranslatorSpec(translatorSpecFactory));
    }
}
