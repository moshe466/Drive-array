package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRule;
import dagger.internal.Factory;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class RecaserProcessor_Factory implements Factory<RecaserProcessor> {
    private final Provider<Set<String>> noCaseDistinctLanguagesProvider;
    private final Provider<Map<Class<?>, RecaseRule>> recaseRuleMapProvider;

    public RecaserProcessor_Factory(Provider<Map<Class<?>, RecaseRule>> provider, Provider<Set<String>> provider2) {
        this.recaseRuleMapProvider = provider;
        this.noCaseDistinctLanguagesProvider = provider2;
    }

    @Override // javax.inject.Provider
    public RecaserProcessor get() {
        return newInstance(this.recaseRuleMapProvider.get(), this.noCaseDistinctLanguagesProvider.get());
    }

    public static RecaserProcessor_Factory create(Provider<Map<Class<?>, RecaseRule>> provider, Provider<Set<String>> provider2) {
        return new RecaserProcessor_Factory(provider, provider2);
    }

    public static RecaserProcessor newInstance(Map<Class<?>, RecaseRule> map, Set<String> set) {
        return new RecaserProcessor(map, set);
    }
}
