package com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter;

import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SplitterManager_Factory implements Factory<SplitterManager> {
    private final Provider<Map<Class<?>, SplitRule>> splitterRuleMapProvider;

    public SplitterManager_Factory(Provider<Map<Class<?>, SplitRule>> provider) {
        this.splitterRuleMapProvider = provider;
    }

    @Override // javax.inject.Provider
    public SplitterManager get() {
        return newInstance(this.splitterRuleMapProvider.get());
    }

    public static SplitterManager_Factory create(Provider<Map<Class<?>, SplitRule>> provider) {
        return new SplitterManager_Factory(provider);
    }

    public static SplitterManager newInstance(Map<Class<?>, SplitRule> map) {
        return new SplitterManager(map);
    }
}
