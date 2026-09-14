package com.google.firebase.functions;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* loaded from: classes2.dex */
final /* synthetic */ class FunctionsRegistrar$$Lambda$1 implements ComponentFactory {
    private static final FunctionsRegistrar$$Lambda$1 instance = new FunctionsRegistrar$$Lambda$1();

    private FunctionsRegistrar$$Lambda$1() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object create(ComponentContainer componentContainer) {
        return FunctionsRegistrar.lambda$getComponents$0(componentContainer);
    }
}
