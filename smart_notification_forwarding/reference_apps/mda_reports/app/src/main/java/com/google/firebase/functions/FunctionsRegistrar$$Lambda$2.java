package com.google.firebase.functions;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* loaded from: classes2.dex */
final /* synthetic */ class FunctionsRegistrar$$Lambda$2 implements ComponentFactory {
    private static final FunctionsRegistrar$$Lambda$2 instance = new FunctionsRegistrar$$Lambda$2();

    private FunctionsRegistrar$$Lambda$2() {
    }

    public static ComponentFactory lambdaFactory$() {
        return instance;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object create(ComponentContainer componentContainer) {
        return FunctionsRegistrar.lambda$getComponents$1(componentContainer);
    }
}
