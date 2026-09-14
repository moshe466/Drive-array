package com.samsung.sr.nmt.t2t.translator.core.languagedetector.differentiator;

import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DifferentiationManager_Factory implements Factory<DifferentiationManager> {
    private final Provider<Map<String, LanguageDifferentiator>> differentiatorMapProvider;

    public DifferentiationManager_Factory(Provider<Map<String, LanguageDifferentiator>> provider) {
        this.differentiatorMapProvider = provider;
    }

    @Override // javax.inject.Provider
    public DifferentiationManager get() {
        return newInstance(this.differentiatorMapProvider.get());
    }

    public static DifferentiationManager_Factory create(Provider<Map<String, LanguageDifferentiator>> provider) {
        return new DifferentiationManager_Factory(provider);
    }

    public static DifferentiationManager newInstance(Map<String, LanguageDifferentiator> map) {
        return new DifferentiationManager(map);
    }
}
