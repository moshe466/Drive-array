package com.samsung.sr.nmt.t2t.translator.core.dagger;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlin.coroutines.CoroutineContext;

/* loaded from: classes.dex */
public final class ComputationContextModule_ProvideComputationContextFactory implements Factory<CoroutineContext> {
    private final ComputationContextModule module;

    public ComputationContextModule_ProvideComputationContextFactory(ComputationContextModule computationContextModule) {
        this.module = computationContextModule;
    }

    @Override // javax.inject.Provider
    public CoroutineContext get() {
        return provideComputationContext(this.module);
    }

    public static ComputationContextModule_ProvideComputationContextFactory create(ComputationContextModule computationContextModule) {
        return new ComputationContextModule_ProvideComputationContextFactory(computationContextModule);
    }

    public static CoroutineContext provideComputationContext(ComputationContextModule computationContextModule) {
        return (CoroutineContext) Preconditions.checkNotNullFromProvides(computationContextModule.provideComputationContext());
    }
}
