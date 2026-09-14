package com.samsung.sr.nmt.t2t.translator.core.languagedetector.differentiator;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ChineseDifferentiator_Factory implements Factory<ChineseDifferentiator> {
    private final Provider<Set<String>> traditionalChineseCharactersProvider;
    private final Provider<Integer> traditionalChineseThresholdProvider;

    public ChineseDifferentiator_Factory(Provider<Set<String>> provider, Provider<Integer> provider2) {
        this.traditionalChineseCharactersProvider = provider;
        this.traditionalChineseThresholdProvider = provider2;
    }

    @Override // javax.inject.Provider
    public ChineseDifferentiator get() {
        return newInstance(this.traditionalChineseCharactersProvider.get(), this.traditionalChineseThresholdProvider.get().intValue());
    }

    public static ChineseDifferentiator_Factory create(Provider<Set<String>> provider, Provider<Integer> provider2) {
        return new ChineseDifferentiator_Factory(provider, provider2);
    }

    public static ChineseDifferentiator newInstance(Set<String> set, int i) {
        return new ChineseDifferentiator(set, i);
    }
}
